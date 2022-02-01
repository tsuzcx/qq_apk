package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
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
  private b.a HXe;
  private String[] HXl;
  private a HXm;
  private boolean HXn;
  private ap HXo;
  private b.a HXp;
  private int giC;
  private boolean ieP;
  private String patchMd5;
  private String uJh;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    AppMethodBeat.i(32686);
    this.HXm = null;
    this.giC = 0;
    this.HXn = false;
    this.ieP = false;
    this.HXo = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aNl()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).b(200, 0, (cvp)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).b(3, -1, (cvp)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).b(4, -1, (cvp)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.HXp = new b.a()
    {
      public final void CO(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).CO(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void CP(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).CP(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, cvp paramAnonymouscvp)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aNl()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aPI(c.this.aNl()) < c.f(c.this))
          {
            ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aPK(c.this.aNl())))
            {
              ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aNl()).delete();
              c.b(c.this).b(2, -1, paramAnonymouscvp);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscvp);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aPK(c.this.aNl())))
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aNl()).delete();
            c.b(c.this).b(-1, -1, paramAnonymouscvp);
            AppMethodBeat.o(32673);
            return;
          }
          d.bb(com.tencent.mm.sandbox.monitor.c.HWI, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).b(200, 0, paramAnonymouscvp);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).b(-1, -1, paramAnonymouscvp);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void eZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).eZ(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
    };
    this.HXl = new String[] { paramString2 };
    this.HXn = true;
    this.patchMd5 = paramString3;
    this.uJh = paramString4;
    AppMethodBeat.o(32686);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(32685);
    this.HXm = null;
    this.giC = 0;
    this.HXn = false;
    this.ieP = false;
    this.HXo = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aNl()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).b(200, 0, (cvp)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).b(3, -1, (cvp)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).b(4, -1, (cvp)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.HXp = new b.a()
    {
      public final void CO(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).CO(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void CP(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).CP(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, cvp paramAnonymouscvp)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aNl()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aPI(c.this.aNl()) < c.f(c.this))
          {
            ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aPK(c.this.aNl())))
            {
              ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aNl()).delete();
              c.b(c.this).b(2, -1, paramAnonymouscvp);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscvp);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aPK(c.this.aNl())))
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aNl()).delete();
            c.b(c.this).b(-1, -1, paramAnonymouscvp);
            AppMethodBeat.o(32673);
            return;
          }
          d.bb(com.tencent.mm.sandbox.monitor.c.HWI, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).b(200, 0, paramAnonymouscvp);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).b(-1, -1, paramAnonymouscvp);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void eZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).eZ(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
    };
    this.HXl = paramArrayOfString;
    AppMethodBeat.o(32685);
  }
  
  private int fiB()
  {
    AppMethodBeat.i(32691);
    ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.giC + ", curLinkIdx = " + this.giC / 5);
    int i = this.giC / 5;
    AppMethodBeat.o(32691);
    return i;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(32687);
    this.HXe = parama;
    if (!g.getExternalStorageState().equals("mounted"))
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (this.ieP)
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if ((fiu()) || (fiB() >= this.HXl.length))
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.HXl.length);
      if (this.HXn)
      {
        parama.b(1, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (!e.qR(this.HWK))
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.HXn)
      {
        parama.b(13, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    this.HXm = new a(this.HWK, d.aPI(aNl()), this.HXp);
    this.HXm.execute(new String[] { this.HXl[fiB()] });
    AppMethodBeat.o(32687);
  }
  
  public final String aNl()
  {
    AppMethodBeat.i(32688);
    if (this.HXn)
    {
      str = HWI + this.patchMd5 + ".temp";
      AppMethodBeat.o(32688);
      return str;
    }
    String str = super.aNl();
    AppMethodBeat.o(32688);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32690);
    ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.ieP = true;
    if ((this.HXm != null) && (!this.HXm.isCancelled())) {
      this.HXm.cancel(true);
    }
    AppMethodBeat.o(32690);
  }
  
  public final String fit()
  {
    AppMethodBeat.i(32689);
    if (this.HXn)
    {
      str = HWI + this.uJh + ".apk";
      AppMethodBeat.o(32689);
      return str;
    }
    String str = HWI + this.HWM + ".apk";
    AppMethodBeat.o(32689);
    return str;
  }
  
  final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private OutputStream Caa;
    private b.a HXe;
    private HttpGet HXs;
    private HttpResponse HXt;
    private HttpEntity HXu;
    private int ccA;
    private int size;
    private HttpClient xaJ;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      AppMethodBeat.i(32680);
      this.xaJ = null;
      this.HXs = null;
      this.HXt = null;
      this.HXu = null;
      this.Caa = new OutputStream()
      {
        private ByteArrayOutputStream HXv;
        private ap handler;
        
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
          this.HXv.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          if ((this.HXv.size() < 131072) && (c.a.a(c.a.this) + this.HXv.size() < c.a.b(c.a.this)))
          {
            AppMethodBeat.o(32678);
            return;
          }
          paramAnonymousInt1 = this.HXv.size();
          paramAnonymousInt2 = d.e(c.this.aNl(), this.HXv.toByteArray(), paramAnonymousInt1);
          this.HXv.reset();
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
                c.a.c(c.a.this).eZ(c.a.b(c.a.this), c.a.a(c.a.this));
              }
              c.a.c(c.a.this).CP(paramAnonymousInt1);
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
      this.ccA = paramInt2;
      this.HXe = parama;
      AppMethodBeat.o(32680);
    }
    
    private Integer T(String... paramVarArgs)
    {
      AppMethodBeat.i(32681);
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0))
      {
        AppMethodBeat.o(32681);
        return Integer.valueOf(-1);
      }
      ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.ccA);
      this.xaJ = new DefaultHttpClient();
      this.xaJ.getParams().setIntParameter("http.connection.timeout", 15000);
      this.HXs = new HttpGet(paramVarArgs);
      HttpGet localHttpGet = this.HXs;
      StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.ccA).append("-");
      if (this.size - this.ccA > 1048576) {
        paramVarArgs = Integer.valueOf(this.ccA + 1048576 - 1);
      }
      for (;;)
      {
        localHttpGet.addHeader("RANGE", paramVarArgs);
        try
        {
          this.HXe.CO(50L);
          this.HXt = this.xaJ.execute(this.HXs);
          int i = this.HXt.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(i)));
            if (i == 416)
            {
              if (this.HXs != null) {
                this.HXs.abort();
              }
              if (this.HXu != null) {}
              try
              {
                this.HXu.consumeContent();
                if (this.xaJ != null) {
                  this.xaJ.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(32681);
                return Integer.valueOf(-2);
                paramVarArgs = "";
              }
              catch (IOException paramVarArgs)
              {
                for (;;)
                {
                  ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
                }
              }
            }
            if (this.HXs != null) {
              this.HXs.abort();
            }
            if (this.HXu != null) {}
            try
            {
              this.HXu.consumeContent();
              if (this.xaJ != null) {
                this.xaJ.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          if ((c.g(c.this)) && (ac.iOC) && (Math.random() > 0.2D))
          {
            ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            if (this.HXs != null) {
              this.HXs.abort();
            }
            if (this.HXu != null) {}
            try
            {
              this.HXu.consumeContent();
              if (this.xaJ != null) {
                this.xaJ.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.HXt.getHeaders("Content-Length");
          if (this.ccA > this.size)
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            if (this.HXs != null) {
              this.HXs.abort();
            }
            if (this.HXu != null) {}
            try
            {
              this.HXu.consumeContent();
              if (this.xaJ != null) {
                this.xaJ.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-2);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.HXu = this.HXt.getEntity();
          this.HXu.writeTo(this.Caa);
          this.HXu.consumeContent();
          if (this.HXs != null) {
            this.HXs.abort();
          }
          if (this.HXu != null) {}
          try
          {
            this.HXu.consumeContent();
            if (this.xaJ != null) {
              this.xaJ.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(0);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
          try
          {
            this.HXu.consumeContent();
            if (this.xaJ != null) {
              this.xaJ.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            throw paramVarArgs;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
          ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "exception current in download pack", new Object[0]);
          if (this.HXs != null) {
            this.HXs.abort();
          }
          if (this.HXu != null) {}
          try
          {
            this.HXu.consumeContent();
            if (this.xaJ != null) {
              this.xaJ.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(-1);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
        }
        finally
        {
          if (this.HXs != null) {
            this.HXs.abort();
          }
          if (this.HXu == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(32682);
      ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.HXs != null) {
        this.HXs.abort();
      }
      if (this.HXu != null) {}
      try
      {
        this.HXu.consumeContent();
        if (this.xaJ != null)
        {
          ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.xaJ.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(32682);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c
 * JD-Core Version:    0.7.0.1
 */