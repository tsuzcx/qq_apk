package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
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
  private String bWN;
  private int evn;
  private boolean fIp;
  private String nKS;
  private b.a ykB;
  private String[] ykH;
  private a ykI;
  private boolean ykJ;
  private ak ykK;
  private b.a ykL;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    AppMethodBeat.i(28872);
    this.ykI = null;
    this.evn = 0;
    this.ykJ = false;
    this.fIp = false;
    this.ykK = new c.1(this);
    this.ykL = new c.3(this);
    this.ykH = new String[] { paramString2 };
    this.ykJ = true;
    this.bWN = paramString3;
    this.nKS = paramString4;
    AppMethodBeat.o(28872);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(28871);
    this.ykI = null;
    this.evn = 0;
    this.ykJ = false;
    this.fIp = false;
    this.ykK = new c.1(this);
    this.ykL = new c.3(this);
    this.ykH = paramArrayOfString;
    AppMethodBeat.o(28871);
  }
  
  private int drC()
  {
    AppMethodBeat.i(28877);
    ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.evn + ", curLinkIdx = " + this.evn / 5);
    int i = this.evn / 5;
    AppMethodBeat.o(28877);
    return i;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(28873);
    this.ykB = parama;
    if (!h.getExternalStorageState().equals("mounted"))
    {
      ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(28873);
      return;
    }
    if (this.fIp)
    {
      ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(28873);
      return;
    }
    if ((drv()) || (drC() >= this.ykH.length))
    {
      ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.ykH.length);
      if (this.ykJ)
      {
        parama.b(1, -1, null);
        AppMethodBeat.o(28873);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(28873);
      return;
    }
    if (!f.gc(this.ykh))
    {
      ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.ykJ)
      {
        parama.b(13, -1, null);
        AppMethodBeat.o(28873);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(28873);
      return;
    }
    this.ykI = new a(this.ykh, e.cM(amg()), this.ykL);
    this.ykI.execute(new String[] { this.ykH[drC()] });
    AppMethodBeat.o(28873);
  }
  
  public final String amg()
  {
    AppMethodBeat.i(28874);
    if (this.ykJ)
    {
      str = ykf + this.bWN + ".temp";
      AppMethodBeat.o(28874);
      return str;
    }
    String str = super.amg();
    AppMethodBeat.o(28874);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(28876);
    ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.fIp = true;
    if ((this.ykI != null) && (!this.ykI.isCancelled())) {
      this.ykI.cancel(true);
    }
    AppMethodBeat.o(28876);
  }
  
  public final String dru()
  {
    AppMethodBeat.i(28875);
    if (this.ykJ)
    {
      str = ykf + this.nKS + ".apk";
      AppMethodBeat.o(28875);
      return str;
    }
    String str = ykf + this.ykj + ".apk";
    AppMethodBeat.o(28875);
    return str;
  }
  
  final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private int bsk;
    private HttpClient pIW;
    private int size;
    private OutputStream tuC;
    private b.a ykB;
    private HttpGet ykO;
    private HttpResponse ykP;
    private HttpEntity ykQ;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      AppMethodBeat.i(28866);
      this.pIW = null;
      this.ykO = null;
      this.ykP = null;
      this.ykQ = null;
      this.tuC = new c.a.1(this);
      this.size = paramInt1;
      this.bsk = paramInt2;
      this.ykB = parama;
      AppMethodBeat.o(28866);
    }
    
    private Integer O(String... paramVarArgs)
    {
      AppMethodBeat.i(28867);
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0))
      {
        AppMethodBeat.o(28867);
        return Integer.valueOf(-1);
      }
      ab.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.bsk);
      this.pIW = new DefaultHttpClient();
      this.pIW.getParams().setIntParameter("http.connection.timeout", 15000);
      this.ykO = new HttpGet(paramVarArgs);
      HttpGet localHttpGet = this.ykO;
      StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.bsk).append("-");
      if (this.size - this.bsk > 1048576) {
        paramVarArgs = Integer.valueOf(this.bsk + 1048576 - 1);
      }
      for (;;)
      {
        localHttpGet.addHeader("RANGE", paramVarArgs);
        try
        {
          this.ykB.nJ(50L);
          this.ykP = this.pIW.execute(this.ykO);
          int i = this.ykP.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(i)));
            if (i == 416)
            {
              if (this.ykO != null) {
                this.ykO.abort();
              }
              if (this.ykQ != null) {}
              try
              {
                this.ykQ.consumeContent();
                if (this.pIW != null) {
                  this.pIW.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(28867);
                return Integer.valueOf(-2);
                paramVarArgs = "";
              }
              catch (IOException paramVarArgs)
              {
                for (;;)
                {
                  ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
                }
              }
            }
            if (this.ykO != null) {
              this.ykO.abort();
            }
            if (this.ykQ != null) {}
            try
            {
              this.ykQ.consumeContent();
              if (this.pIW != null) {
                this.pIW.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(28867);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          if ((c.g(c.this)) && (ae.gkz) && (Math.random() > 0.2D))
          {
            ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            if (this.ykO != null) {
              this.ykO.abort();
            }
            if (this.ykQ != null) {}
            try
            {
              this.ykQ.consumeContent();
              if (this.pIW != null) {
                this.pIW.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(28867);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.ykP.getHeaders("Content-Length");
          if (this.bsk > this.size)
          {
            ab.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            if (this.ykO != null) {
              this.ykO.abort();
            }
            if (this.ykQ != null) {}
            try
            {
              this.ykQ.consumeContent();
              if (this.pIW != null) {
                this.pIW.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(28867);
              return Integer.valueOf(-2);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.ykQ = this.ykP.getEntity();
          this.ykQ.writeTo(this.tuC);
          this.ykQ.consumeContent();
          if (this.ykO != null) {
            this.ykO.abort();
          }
          if (this.ykQ != null) {}
          try
          {
            this.ykQ.consumeContent();
            if (this.pIW != null) {
              this.pIW.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(28867);
            return Integer.valueOf(0);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
          try
          {
            this.ykQ.consumeContent();
            if (this.pIW != null) {
              this.pIW.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(28867);
            throw paramVarArgs;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
          ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "exception current in download pack", new Object[0]);
          if (this.ykO != null) {
            this.ykO.abort();
          }
          if (this.ykQ != null) {}
          try
          {
            this.ykQ.consumeContent();
            if (this.pIW != null) {
              this.pIW.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(28867);
            return Integer.valueOf(-1);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
        }
        finally
        {
          if (this.ykO != null) {
            this.ykO.abort();
          }
          if (this.ykQ == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(28868);
      ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.ykO != null) {
        this.ykO.abort();
      }
      if (this.ykQ != null) {}
      try
      {
        this.ykQ.consumeContent();
        if (this.pIW != null)
        {
          ab.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.pIW.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(28868);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c
 * JD-Core Version:    0.7.0.1
 */