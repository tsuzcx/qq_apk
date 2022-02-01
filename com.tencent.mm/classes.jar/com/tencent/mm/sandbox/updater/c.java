package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
  private boolean GlA;
  private ao GlB;
  private b.a GlC;
  private b.a Gls;
  private String[] Gly;
  private a Glz;
  private int fPc;
  private boolean hLV;
  private String patchMd5;
  private String tGu;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    AppMethodBeat.i(32686);
    this.Glz = null;
    this.fPc = 0;
    this.GlA = false;
    this.hLV = false;
    this.GlB = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aKc()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).d(200, 0, (cqk)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).d(3, -1, (cqk)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).d(4, -1, (cqk)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.GlC = new b.a()
    {
      public final void Aa(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).Aa(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, cqk paramAnonymouscqk)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aKc()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ac.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aKc(c.this.aKc()) < c.f(c.this))
          {
            ac.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aKe(c.this.aKc())))
            {
              ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aKc()).delete();
              c.b(c.this).d(2, -1, paramAnonymouscqk);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscqk);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aKe(c.this.aKc())))
          {
            ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aKc()).delete();
            c.b(c.this).d(-1, -1, paramAnonymouscqk);
            AppMethodBeat.o(32673);
            return;
          }
          d.aT(com.tencent.mm.sandbox.monitor.c.GkW, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).d(200, 0, paramAnonymouscqk);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).d(-1, -1, paramAnonymouscqk);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).eV(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
      
      public final void zZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).zZ(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
    };
    this.Gly = new String[] { paramString2 };
    this.GlA = true;
    this.patchMd5 = paramString3;
    this.tGu = paramString4;
    AppMethodBeat.o(32686);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(32685);
    this.Glz = null;
    this.fPc = 0;
    this.GlA = false;
    this.hLV = false;
    this.GlB = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aKc()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).d(200, 0, (cqk)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).d(3, -1, (cqk)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).d(4, -1, (cqk)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.GlC = new b.a()
    {
      public final void Aa(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).Aa(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void d(int paramAnonymousInt1, int paramAnonymousInt2, cqk paramAnonymouscqk)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aKc()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ac.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aKc(c.this.aKc()) < c.f(c.this))
          {
            ac.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aKe(c.this.aKc())))
            {
              ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aKc()).delete();
              c.b(c.this).d(2, -1, paramAnonymouscqk);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscqk);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aKe(c.this.aKc())))
          {
            ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aKc()).delete();
            c.b(c.this).d(-1, -1, paramAnonymouscqk);
            AppMethodBeat.o(32673);
            return;
          }
          d.aT(com.tencent.mm.sandbox.monitor.c.GkW, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).d(200, 0, paramAnonymouscqk);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).d(-1, -1, paramAnonymouscqk);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).eV(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
      
      public final void zZ(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).zZ(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
    };
    this.Gly = paramArrayOfString;
    AppMethodBeat.o(32685);
  }
  
  private int eSZ()
  {
    AppMethodBeat.i(32691);
    ac.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.fPc + ", curLinkIdx = " + this.fPc / 5);
    int i = this.fPc / 5;
    AppMethodBeat.o(32691);
    return i;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(32687);
    this.Gls = parama;
    if (!g.getExternalStorageState().equals("mounted"))
    {
      ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.d(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (this.hLV)
    {
      ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.d(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if ((eSS()) || (eSZ() >= this.Gly.length))
    {
      ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.Gly.length);
      if (this.GlA)
      {
        parama.d(1, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.d(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (!e.oR(this.GkY))
    {
      ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.GlA)
      {
        parama.d(13, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.d(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    this.Glz = new a(this.GkY, d.aKc(aKc()), this.GlC);
    this.Glz.execute(new String[] { this.Gly[eSZ()] });
    AppMethodBeat.o(32687);
  }
  
  public final String aKc()
  {
    AppMethodBeat.i(32688);
    if (this.GlA)
    {
      str = GkW + this.patchMd5 + ".temp";
      AppMethodBeat.o(32688);
      return str;
    }
    String str = super.aKc();
    AppMethodBeat.o(32688);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32690);
    ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.hLV = true;
    if ((this.Glz != null) && (!this.Glz.isCancelled())) {
      this.Glz.cancel(true);
    }
    AppMethodBeat.o(32690);
  }
  
  public final String eSR()
  {
    AppMethodBeat.i(32689);
    if (this.GlA)
    {
      str = GkW + this.tGu + ".apk";
      AppMethodBeat.o(32689);
      return str;
    }
    String str = GkW + this.Gla + ".apk";
    AppMethodBeat.o(32689);
    return str;
  }
  
  final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private OutputStream ABb;
    private HttpGet GlF;
    private HttpResponse GlG;
    private HttpEntity GlH;
    private b.a Gls;
    private int bSn;
    private int size;
    private HttpClient vUg;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      AppMethodBeat.i(32680);
      this.vUg = null;
      this.GlF = null;
      this.GlG = null;
      this.GlH = null;
      this.ABb = new OutputStream()
      {
        private ByteArrayOutputStream GlI;
        private ao handler;
        
        public final void write(int paramAnonymousInt)
        {
          AppMethodBeat.i(32679);
          IOException localIOException = new IOException("unexpected operation");
          AppMethodBeat.o(32679);
          throw localIOException;
        }
        
        public final void write(byte[] paramAnonymousArrayOfByte, final int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(32678);
          this.GlI.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          if ((this.GlI.size() < 131072) && (c.a.a(c.a.this) + this.GlI.size() < c.a.b(c.a.this)))
          {
            AppMethodBeat.o(32678);
            return;
          }
          paramAnonymousInt1 = this.GlI.size();
          paramAnonymousInt2 = d.e(c.this.aKc(), this.GlI.toByteArray(), paramAnonymousInt1);
          this.GlI.reset();
          if (paramAnonymousInt2 != 0)
          {
            paramAnonymousArrayOfByte = new IOException("appendToFile failed :".concat(String.valueOf(paramAnonymousInt2)));
            AppMethodBeat.o(32678);
            throw paramAnonymousArrayOfByte;
          }
          c.a.a(c.a.this, c.a.a(c.a.this) + paramAnonymousInt1);
          this.handler.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(32676);
              if (c.a.a(c.a.this) <= c.a.b(c.a.this)) {
                c.a.c(c.a.this).eV(c.a.b(c.a.this), c.a.a(c.a.this));
              }
              c.a.c(c.a.this).Aa(paramAnonymousInt1);
              AppMethodBeat.o(32676);
            }
          });
          if (c.a(c.this))
          {
            paramAnonymousArrayOfByte = new IOException("manual force cancel!");
            AppMethodBeat.o(32678);
            throw paramAnonymousArrayOfByte;
          }
          AppMethodBeat.o(32678);
        }
      };
      this.size = paramInt1;
      this.bSn = paramInt2;
      this.Gls = parama;
      AppMethodBeat.o(32680);
    }
    
    private Integer R(String... paramVarArgs)
    {
      AppMethodBeat.i(32681);
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0))
      {
        AppMethodBeat.o(32681);
        return Integer.valueOf(-1);
      }
      ac.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.bSn);
      this.vUg = new DefaultHttpClient();
      this.vUg.getParams().setIntParameter("http.connection.timeout", 15000);
      this.GlF = new HttpGet(paramVarArgs);
      HttpGet localHttpGet = this.GlF;
      StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.bSn).append("-");
      if (this.size - this.bSn > 1048576) {
        paramVarArgs = Integer.valueOf(this.bSn + 1048576 - 1);
      }
      for (;;)
      {
        localHttpGet.addHeader("RANGE", paramVarArgs);
        try
        {
          this.Gls.zZ(50L);
          this.GlG = this.vUg.execute(this.GlF);
          int i = this.GlG.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(i)));
            if (i == 416)
            {
              if (this.GlF != null) {
                this.GlF.abort();
              }
              if (this.GlH != null) {}
              try
              {
                this.GlH.consumeContent();
                if (this.vUg != null) {
                  this.vUg.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(32681);
                return Integer.valueOf(-2);
                paramVarArgs = "";
              }
              catch (IOException paramVarArgs)
              {
                for (;;)
                {
                  ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
                }
              }
            }
            if (this.GlF != null) {
              this.GlF.abort();
            }
            if (this.GlH != null) {}
            try
            {
              this.GlH.consumeContent();
              if (this.vUg != null) {
                this.vUg.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          if ((c.g(c.this)) && (ab.ivv) && (Math.random() > 0.2D))
          {
            ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            if (this.GlF != null) {
              this.GlF.abort();
            }
            if (this.GlH != null) {}
            try
            {
              this.GlH.consumeContent();
              if (this.vUg != null) {
                this.vUg.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.GlG.getHeaders("Content-Length");
          if (this.bSn > this.size)
          {
            ac.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            if (this.GlF != null) {
              this.GlF.abort();
            }
            if (this.GlH != null) {}
            try
            {
              this.GlH.consumeContent();
              if (this.vUg != null) {
                this.vUg.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-2);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.GlH = this.GlG.getEntity();
          this.GlH.writeTo(this.ABb);
          this.GlH.consumeContent();
          if (this.GlF != null) {
            this.GlF.abort();
          }
          if (this.GlH != null) {}
          try
          {
            this.GlH.consumeContent();
            if (this.vUg != null) {
              this.vUg.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(0);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
          try
          {
            this.GlH.consumeContent();
            if (this.vUg != null) {
              this.vUg.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            throw paramVarArgs;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
          ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "exception current in download pack", new Object[0]);
          if (this.GlF != null) {
            this.GlF.abort();
          }
          if (this.GlH != null) {}
          try
          {
            this.GlH.consumeContent();
            if (this.vUg != null) {
              this.vUg.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(-1);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
        }
        finally
        {
          if (this.GlF != null) {
            this.GlF.abort();
          }
          if (this.GlH == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(32682);
      ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.GlF != null) {
        this.GlF.abort();
      }
      if (this.GlH != null) {}
      try
      {
        this.GlH.consumeContent();
        if (this.vUg != null)
        {
          ac.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.vUg.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(32682);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c
 * JD-Core Version:    0.7.0.1
 */