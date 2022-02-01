package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.protobuf.cld;
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
  private b.a EOf;
  private String[] EOl;
  private a EOm;
  private boolean EOn;
  private ap EOo;
  private b.a EOp;
  private int fLq;
  private boolean hls;
  private String patchMd5;
  private String syK;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    AppMethodBeat.i(32686);
    this.EOm = null;
    this.fLq = 0;
    this.EOn = false;
    this.hls = false;
    this.EOo = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aDl()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).c(200, 0, (cld)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).c(3, -1, (cld)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).c(4, -1, (cld)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.EOp = new b.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, cld paramAnonymouscld)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aDl()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aEL(c.this.aDl()) < c.f(c.this))
          {
            ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aEN(c.this.aDl())))
            {
              ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aDl()).delete();
              c.b(c.this).c(2, -1, paramAnonymouscld);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscld);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aEN(c.this.aDl())))
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aDl()).delete();
            c.b(c.this).c(-1, -1, paramAnonymouscld);
            AppMethodBeat.o(32673);
            return;
          }
          d.aQ(com.tencent.mm.sandbox.monitor.c.ENJ, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).c(200, 0, paramAnonymouscld);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).c(-1, -1, paramAnonymouscld);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void eS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).eS(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
      
      public final void vw(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).vw(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void vx(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).vx(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
    };
    this.EOl = new String[] { paramString2 };
    this.EOn = true;
    this.patchMd5 = paramString3;
    this.syK = paramString4;
    AppMethodBeat.o(32686);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(32685);
    this.EOm = null;
    this.fLq = 0;
    this.EOn = false;
    this.hls = false;
    this.EOo = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aDl()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).c(200, 0, (cld)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).c(3, -1, (cld)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).c(4, -1, (cld)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.EOp = new b.a()
    {
      public final void c(int paramAnonymousInt1, int paramAnonymousInt2, cld paramAnonymouscld)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aDl()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aEL(c.this.aDl()) < c.f(c.this))
          {
            ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aEN(c.this.aDl())))
            {
              ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aDl()).delete();
              c.b(c.this).c(2, -1, paramAnonymouscld);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscld);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aEN(c.this.aDl())))
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aDl()).delete();
            c.b(c.this).c(-1, -1, paramAnonymouscld);
            AppMethodBeat.o(32673);
            return;
          }
          d.aQ(com.tencent.mm.sandbox.monitor.c.ENJ, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).c(200, 0, paramAnonymouscld);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ad.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).c(-1, -1, paramAnonymouscld);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void eS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).eS(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
      
      public final void vw(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).vw(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void vx(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).vx(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
    };
    this.EOl = paramArrayOfString;
    AppMethodBeat.o(32685);
  }
  
  private int eDF()
  {
    AppMethodBeat.i(32691);
    ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.fLq + ", curLinkIdx = " + this.fLq / 5);
    int i = this.fLq / 5;
    AppMethodBeat.o(32691);
    return i;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(32687);
    this.EOf = parama;
    if (!g.getExternalStorageState().equals("mounted"))
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.c(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (this.hls)
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.c(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if ((eDy()) || (eDF() >= this.EOl.length))
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.EOl.length);
      if (this.EOn)
      {
        parama.c(1, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.c(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (!e.lo(this.ENL))
    {
      ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.EOn)
      {
        parama.c(13, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.c(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    this.EOm = new a(this.ENL, d.aEL(aDl()), this.EOp);
    this.EOm.execute(new String[] { this.EOl[eDF()] });
    AppMethodBeat.o(32687);
  }
  
  public final String aDl()
  {
    AppMethodBeat.i(32688);
    if (this.EOn)
    {
      str = ENJ + this.patchMd5 + ".temp";
      AppMethodBeat.o(32688);
      return str;
    }
    String str = super.aDl();
    AppMethodBeat.o(32688);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32690);
    ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.hls = true;
    if ((this.EOm != null) && (!this.EOm.isCancelled())) {
      this.EOm.cancel(true);
    }
    AppMethodBeat.o(32690);
  }
  
  public final String eDx()
  {
    AppMethodBeat.i(32689);
    if (this.EOn)
    {
      str = ENJ + this.syK + ".apk";
      AppMethodBeat.o(32689);
      return str;
    }
    String str = ENJ + this.ENN + ".apk";
    AppMethodBeat.o(32689);
    return str;
  }
  
  final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private b.a EOf;
    private HttpGet EOs;
    private HttpResponse EOt;
    private HttpEntity EOu;
    private int bUF;
    private int size;
    private HttpClient uLp;
    private OutputStream zir;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      AppMethodBeat.i(32680);
      this.uLp = null;
      this.EOs = null;
      this.EOt = null;
      this.EOu = null;
      this.zir = new OutputStream()
      {
        private ByteArrayOutputStream EOv;
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
          this.EOv.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          if ((this.EOv.size() < 131072) && (c.a.a(c.a.this) + this.EOv.size() < c.a.b(c.a.this)))
          {
            AppMethodBeat.o(32678);
            return;
          }
          paramAnonymousInt1 = this.EOv.size();
          paramAnonymousInt2 = d.e(c.this.aDl(), this.EOv.toByteArray(), paramAnonymousInt1);
          this.EOv.reset();
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
                c.a.c(c.a.this).eS(c.a.b(c.a.this), c.a.a(c.a.this));
              }
              c.a.c(c.a.this).vx(paramAnonymousInt1);
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
      this.bUF = paramInt2;
      this.EOf = parama;
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
      ad.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.bUF);
      this.uLp = new DefaultHttpClient();
      this.uLp.getParams().setIntParameter("http.connection.timeout", 15000);
      this.EOs = new HttpGet(paramVarArgs);
      HttpGet localHttpGet = this.EOs;
      StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.bUF).append("-");
      if (this.size - this.bUF > 1048576) {
        paramVarArgs = Integer.valueOf(this.bUF + 1048576 - 1);
      }
      for (;;)
      {
        localHttpGet.addHeader("RANGE", paramVarArgs);
        try
        {
          this.EOf.vw(50L);
          this.EOt = this.uLp.execute(this.EOs);
          int i = this.EOt.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(i)));
            if (i == 416)
            {
              if (this.EOs != null) {
                this.EOs.abort();
              }
              if (this.EOu != null) {}
              try
              {
                this.EOu.consumeContent();
                if (this.uLp != null) {
                  this.uLp.getConnectionManager().shutdown();
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
            if (this.EOs != null) {
              this.EOs.abort();
            }
            if (this.EOu != null) {}
            try
            {
              this.EOu.consumeContent();
              if (this.uLp != null) {
                this.uLp.getConnectionManager().shutdown();
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
          if ((c.g(c.this)) && (ab.hVr) && (Math.random() > 0.2D))
          {
            ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            if (this.EOs != null) {
              this.EOs.abort();
            }
            if (this.EOu != null) {}
            try
            {
              this.EOu.consumeContent();
              if (this.uLp != null) {
                this.uLp.getConnectionManager().shutdown();
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
          this.EOt.getHeaders("Content-Length");
          if (this.bUF > this.size)
          {
            ad.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            if (this.EOs != null) {
              this.EOs.abort();
            }
            if (this.EOu != null) {}
            try
            {
              this.EOu.consumeContent();
              if (this.uLp != null) {
                this.uLp.getConnectionManager().shutdown();
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
          this.EOu = this.EOt.getEntity();
          this.EOu.writeTo(this.zir);
          this.EOu.consumeContent();
          if (this.EOs != null) {
            this.EOs.abort();
          }
          if (this.EOu != null) {}
          try
          {
            this.EOu.consumeContent();
            if (this.uLp != null) {
              this.uLp.getConnectionManager().shutdown();
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
            this.EOu.consumeContent();
            if (this.uLp != null) {
              this.uLp.getConnectionManager().shutdown();
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
          if (this.EOs != null) {
            this.EOs.abort();
          }
          if (this.EOu != null) {}
          try
          {
            this.EOu.consumeContent();
            if (this.uLp != null) {
              this.uLp.getConnectionManager().shutdown();
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
          if (this.EOs != null) {
            this.EOs.abort();
          }
          if (this.EOu == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(32682);
      ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.EOs != null) {
        this.EOs.abort();
      }
      if (this.EOu != null) {}
      try
      {
        this.EOu.consumeContent();
        if (this.uLp != null)
        {
          ad.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.uLp.getConnectionManager().shutdown();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c
 * JD-Core Version:    0.7.0.1
 */