package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
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
  private String DNx;
  private b.a USi;
  private String[] USp;
  private a USq;
  private boolean USr;
  private MMHandler USs;
  private b.a USt;
  private int jGL;
  private boolean lTb;
  private String patchMd5;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    AppMethodBeat.i(32686);
    this.USq = null;
    this.jGL = 0;
    this.USr = false;
    this.lTb = false;
    this.USs = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.brm()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).b(200, 0, (dyy)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).b(3, -1, (dyy)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).b(4, -1, (dyy)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.USt = new b.a()
    {
      public final void Uk(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).Uk(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void Ul(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).Ul(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, dyy paramAnonymousdyy)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.brm()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.bua(c.this.brm()) < c.f(c.this))
          {
            Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.buc(c.this.brm())))
            {
              Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.brm()).delete();
              c.b(c.this).b(2, -1, paramAnonymousdyy);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymousdyy);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.buc(c.this.brm())))
          {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.brm()).delete();
            c.b(c.this).b(-1, -1, paramAnonymousdyy);
            AppMethodBeat.o(32673);
            return;
          }
          d.bj(com.tencent.mm.sandbox.monitor.c.URM, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).b(200, 0, paramAnonymousdyy);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).b(-1, -1, paramAnonymousdyy);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void fK(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).fK(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
    };
    this.USp = new String[] { paramString2 };
    this.USr = true;
    this.patchMd5 = paramString3;
    this.DNx = paramString4;
    AppMethodBeat.o(32686);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(32685);
    this.USq = null;
    this.jGL = 0;
    this.USr = false;
    this.lTb = false;
    this.USs = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.brm()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).b(200, 0, (dyy)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).b(3, -1, (dyy)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).b(4, -1, (dyy)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.USt = new b.a()
    {
      public final void Uk(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).Uk(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void Ul(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).Ul(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, dyy paramAnonymousdyy)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.brm()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.bua(c.this.brm()) < c.f(c.this))
          {
            Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.buc(c.this.brm())))
            {
              Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.brm()).delete();
              c.b(c.this).b(2, -1, paramAnonymousdyy);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymousdyy);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.buc(c.this.brm())))
          {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.brm()).delete();
            c.b(c.this).b(-1, -1, paramAnonymousdyy);
            AppMethodBeat.o(32673);
            return;
          }
          d.bj(com.tencent.mm.sandbox.monitor.c.URM, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).b(200, 0, paramAnonymousdyy);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).b(-1, -1, paramAnonymousdyy);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void fK(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).fK(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
    };
    this.USp = paramArrayOfString;
    AppMethodBeat.o(32685);
  }
  
  private int hsf()
  {
    AppMethodBeat.i(32691);
    Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.jGL + ", curLinkIdx = " + this.jGL / 5);
    int i = this.jGL / 5;
    AppMethodBeat.o(32691);
    return i;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(32687);
    this.USi = parama;
    if (!g.avJ().equals("mounted"))
    {
      Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (this.lTb)
    {
      Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if ((hrY()) || (hsf() >= this.USp.length))
    {
      Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.USp.length);
      if (this.USr)
      {
        parama.b(1, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (!e.EY(this.URO))
    {
      Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.USr)
      {
        parama.b(13, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    this.USq = new a(this.URO, d.bua(brm()), this.USt);
    this.USq.execute(new String[] { this.USp[hsf()] });
    AppMethodBeat.o(32687);
  }
  
  public final String brm()
  {
    AppMethodBeat.i(32688);
    if (this.USr)
    {
      str = URM + this.patchMd5 + ".temp";
      AppMethodBeat.o(32688);
      return str;
    }
    String str = super.brm();
    AppMethodBeat.o(32688);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32690);
    Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.lTb = true;
    if ((this.USq != null) && (!this.USq.isCancelled())) {
      this.USq.cancel(true);
    }
    AppMethodBeat.o(32690);
  }
  
  public final String hrX()
  {
    AppMethodBeat.i(32689);
    if (this.USr)
    {
      str = URM + this.DNx + ".apk";
      AppMethodBeat.o(32689);
      return str;
    }
    String str = URM + this.URQ + ".apk";
    AppMethodBeat.o(32689);
    return str;
  }
  
  final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private OutputStream NLA;
    private b.a USi;
    private int USw;
    private HttpGet USx;
    private HttpResponse USy;
    private HttpEntity USz;
    private HttpClient client;
    private int size;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      AppMethodBeat.i(32680);
      this.client = null;
      this.USx = null;
      this.USy = null;
      this.USz = null;
      this.NLA = new OutputStream()
      {
        private ByteArrayOutputStream USA;
        private MMHandler handler;
        
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
          this.USA.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          if ((this.USA.size() < 131072) && (c.a.a(c.a.this) + this.USA.size() < c.a.b(c.a.this)))
          {
            AppMethodBeat.o(32678);
            return;
          }
          paramAnonymousInt1 = this.USA.size();
          paramAnonymousInt2 = d.e(c.this.brm(), this.USA.toByteArray(), paramAnonymousInt1);
          this.USA.reset();
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
                c.a.c(c.a.this).fK(c.a.b(c.a.this), c.a.a(c.a.this));
              }
              c.a.c(c.a.this).Ul(paramAnonymousInt1);
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
      this.USw = paramInt2;
      this.USi = parama;
      AppMethodBeat.o(32680);
    }
    
    private Integer X(String... paramVarArgs)
    {
      AppMethodBeat.i(32681);
      paramVarArgs = paramVarArgs[0];
      if ((paramVarArgs == null) || (paramVarArgs.length() == 0))
      {
        AppMethodBeat.o(32681);
        return Integer.valueOf(-1);
      }
      Log.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.USw);
      this.client = new DefaultHttpClient();
      this.client.getParams().setIntParameter("http.connection.timeout", 15000);
      this.USx = new HttpGet(paramVarArgs);
      HttpGet localHttpGet = this.USx;
      StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.USw).append("-");
      if (this.size - this.USw > 1048576) {
        paramVarArgs = Integer.valueOf(this.USw + 1048576 - 1);
      }
      for (;;)
      {
        localHttpGet.addHeader("RANGE", paramVarArgs);
        try
        {
          this.USi.Uk(50L);
          this.USy = this.client.execute(this.USx);
          int i = this.USy.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(i)));
            if (i == 416)
            {
              if (this.USx != null) {
                this.USx.abort();
              }
              if (this.USz != null) {}
              try
              {
                this.USz.consumeContent();
                if (this.client != null) {
                  this.client.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(32681);
                return Integer.valueOf(-2);
                paramVarArgs = "";
              }
              catch (IOException paramVarArgs)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
                }
              }
            }
            if (this.USx != null) {
              this.USx.abort();
            }
            if (this.USz != null) {}
            try
            {
              this.USz.consumeContent();
              if (this.client != null) {
                this.client.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          if ((c.g(c.this)) && (ac.mFA) && (Math.random() > 0.2D))
          {
            Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            if (this.USx != null) {
              this.USx.abort();
            }
            if (this.USz != null) {}
            try
            {
              this.USz.consumeContent();
              if (this.client != null) {
                this.client.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.USy.getHeaders("Content-Length");
          if (this.USw > this.size)
          {
            Log.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            if (this.USx != null) {
              this.USx.abort();
            }
            if (this.USz != null) {}
            try
            {
              this.USz.consumeContent();
              if (this.client != null) {
                this.client.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-2);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.USz = this.USy.getEntity();
          this.USz.writeTo(this.NLA);
          this.USz.consumeContent();
          if (this.USx != null) {
            this.USx.abort();
          }
          if (this.USz != null) {}
          try
          {
            this.USz.consumeContent();
            if (this.client != null) {
              this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(0);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
          try
          {
            this.USz.consumeContent();
            if (this.client != null) {
              this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            throw paramVarArgs;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
          Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "exception current in download pack", new Object[0]);
          if (this.USx != null) {
            this.USx.abort();
          }
          if (this.USz != null) {}
          try
          {
            this.USz.consumeContent();
            if (this.client != null) {
              this.client.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(-1);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
        }
        finally
        {
          if (this.USx != null) {
            this.USx.abort();
          }
          if (this.USz == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(32682);
      Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.USx != null) {
        this.USx.abort();
      }
      if (this.USz != null) {}
      try
      {
        this.USz.consumeContent();
        if (this.client != null)
        {
          Log.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.client.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(32682);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c
 * JD-Core Version:    0.7.0.1
 */