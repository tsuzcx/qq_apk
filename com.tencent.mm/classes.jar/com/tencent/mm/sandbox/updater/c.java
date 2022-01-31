package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public final class c
  extends com.tencent.mm.sandbox.monitor.c
{
  private String bvC;
  private boolean esC = false;
  private int iks = 0;
  private String lnz;
  private b.a ucm;
  private String[] ucs;
  private a uct = null;
  private boolean ucu = false;
  private ah ucv = new c.1(this);
  private b.a ucw = new c.3(this);
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    this.ucs = new String[] { paramString2 };
    this.ucu = true;
    this.bvC = paramString3;
    this.lnz = paramString4;
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    this.ucs = paramArrayOfString;
  }
  
  private int cpN()
  {
    y.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.iks + ", curLinkIdx = " + this.iks / 5);
    return this.iks / 5;
  }
  
  protected final String SV()
  {
    if (this.ucu) {
      return ubQ + this.bvC + ".temp";
    }
    return super.SV();
  }
  
  public final void a(b.a parama)
  {
    this.ucm = parama;
    if (!h.getExternalStorageState().equals("mounted"))
    {
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.b(-1, -1, null);
      return;
    }
    if (this.esC)
    {
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.b(-1, -1, null);
      return;
    }
    if ((cpG()) || (cpN() >= this.ucs.length))
    {
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.ucs.length);
      if (this.ucu)
      {
        parama.b(1, -1, null);
        return;
      }
      parama.b(-1, -1, null);
      return;
    }
    if (!f.bs(this.ubS))
    {
      y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.ucu)
      {
        parama.b(13, -1, null);
        return;
      }
      parama.b(-1, -1, null);
      return;
    }
    this.uct = new a(this.ubS, e.bJ(SV()), this.ucw);
    this.uct.execute(new String[] { this.ucs[cpN()] });
  }
  
  public final void cancel()
  {
    y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.esC = true;
    if ((this.uct != null) && (!this.uct.isCancelled())) {
      this.uct.cancel(true);
    }
  }
  
  public final String cpF()
  {
    if (this.ucu) {
      return ubQ + this.lnz + ".apk";
    }
    return ubQ + this.ubU + ".apk";
  }
  
  private final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private int bbE;
    private HttpClient ndF = null;
    private OutputStream pPx = new c.a.1(this);
    private int size;
    private HttpResponse ucA = null;
    private HttpEntity ucB = null;
    private b.a ucm;
    private HttpGet ucz = null;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      this.size = paramInt1;
      this.bbE = paramInt2;
      this.ucm = parama;
    }
    
    private Integer F(String... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0)) {
        paramVarArgs = Integer.valueOf(-1);
      }
      for (;;)
      {
        return paramVarArgs;
        y.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.bbE);
        this.ndF = new DefaultHttpClient();
        this.ndF.getParams().setIntParameter("http.connection.timeout", 15000);
        this.ucz = new HttpGet(paramVarArgs);
        Object localObject = this.ucz;
        StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.bbE).append("-");
        if (this.size - this.bbE > 1048576)
        {
          paramVarArgs = Integer.valueOf(this.bbE + 1048576 - 1);
          ((HttpGet)localObject).addHeader("RANGE", paramVarArgs);
        }
        try
        {
          this.ucm.hm(50L);
          this.ucA = this.ndF.execute(this.ucz);
          int i = this.ucA.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:" + i);
            if (i == 416)
            {
              localObject = Integer.valueOf(-2);
              if (this.ucz != null) {
                this.ucz.abort();
              }
              if (this.ucB != null) {}
              try
              {
                this.ucB.consumeContent();
                paramVarArgs = (String[])localObject;
                if (this.ndF == null) {
                  continue;
                }
                this.ndF.getConnectionManager().shutdown();
                return localObject;
                paramVarArgs = "";
              }
              catch (IOException paramVarArgs)
              {
                for (;;)
                {
                  y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
                }
              }
            }
            localObject = Integer.valueOf(-1);
            if (this.ucz != null) {
              this.ucz.abort();
            }
            if (this.ucB != null) {}
            try
            {
              this.ucB.consumeContent();
              paramVarArgs = (String[])localObject;
              if (this.ndF == null) {
                continue;
              }
              this.ndF.getConnectionManager().shutdown();
              return localObject;
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          if ((c.g(c.this)) && (ae.eSE) && (Math.random() > 0.2D))
          {
            y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            localObject = Integer.valueOf(-1);
            if (this.ucz != null) {
              this.ucz.abort();
            }
            if (this.ucB != null) {}
            try
            {
              this.ucB.consumeContent();
              paramVarArgs = (String[])localObject;
              if (this.ndF == null) {
                continue;
              }
              this.ndF.getConnectionManager().shutdown();
              return localObject;
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.ucA.getHeaders("Content-Length");
          if (this.bbE > this.size)
          {
            y.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            localObject = Integer.valueOf(-2);
            if (this.ucz != null) {
              this.ucz.abort();
            }
            if (this.ucB != null) {}
            try
            {
              this.ucB.consumeContent();
              paramVarArgs = (String[])localObject;
              if (this.ndF == null) {
                continue;
              }
              this.ndF.getConnectionManager().shutdown();
              return localObject;
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.ucB = this.ucA.getEntity();
          this.ucB.writeTo(this.pPx);
          this.ucB.consumeContent();
          localObject = Integer.valueOf(0);
          if (this.ucz != null) {
            this.ucz.abort();
          }
          if (this.ucB != null) {}
          try
          {
            this.ucB.consumeContent();
            paramVarArgs = (String[])localObject;
            if (this.ndF == null) {
              continue;
            }
            this.ndF.getConnectionManager().shutdown();
            return localObject;
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
          try
          {
            this.ucB.consumeContent();
            if (this.ndF != null) {
              this.ndF.getConnectionManager().shutdown();
            }
            throw paramVarArgs;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
          y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "exception current in download pack", new Object[0]);
          if (this.ucz != null) {
            this.ucz.abort();
          }
          if (this.ucB != null) {}
          try
          {
            this.ucB.consumeContent();
            if (this.ndF != null) {
              this.ndF.getConnectionManager().shutdown();
            }
            return Integer.valueOf(-1);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
        }
        finally
        {
          if (this.ucz != null) {
            this.ucz.abort();
          }
          if (this.ucB == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.ucz != null) {
        this.ucz.abort();
      }
      if (this.ucB != null) {}
      try
      {
        this.ucB.consumeContent();
        if (this.ndF != null)
        {
          y.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.ndF.getConnectionManager().shutdown();
        }
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c
 * JD-Core Version:    0.7.0.1
 */