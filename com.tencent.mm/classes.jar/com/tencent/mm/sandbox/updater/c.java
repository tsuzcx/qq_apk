package com.tencent.mm.sandbox.updater;

import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
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
  private b.a Irl;
  private String[] Irs;
  private a Irt;
  private boolean Iru;
  private aq Irv;
  private b.a Irw;
  private int gkU;
  private boolean ihH;
  private String patchMd5;
  private String uUU;
  
  public c(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    super(paramInt1, paramString1, paramInt2, paramBoolean);
    AppMethodBeat.i(32686);
    this.Irt = null;
    this.gkU = 0;
    this.Iru = false;
    this.ihH = false;
    this.Irv = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aNJ()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).b(200, 0, (cwj)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).b(3, -1, (cwj)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).b(4, -1, (cwj)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.Irw = new b.a()
    {
      public final void Dm(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).Dm(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void Dn(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).Dn(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, cwj paramAnonymouscwj)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aNJ()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ae.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aRf(c.this.aNJ()) < c.f(c.this))
          {
            ae.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aRh(c.this.aNJ())))
            {
              ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aNJ()).delete();
              c.b(c.this).b(2, -1, paramAnonymouscwj);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscwj);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aRh(c.this.aNJ())))
          {
            ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aNJ()).delete();
            c.b(c.this).b(-1, -1, paramAnonymouscwj);
            AppMethodBeat.o(32673);
            return;
          }
          d.bc(com.tencent.mm.sandbox.monitor.c.IqQ, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).b(200, 0, paramAnonymouscwj);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).b(-1, -1, paramAnonymouscwj);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).fa(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
    };
    this.Irs = new String[] { paramString2 };
    this.Iru = true;
    this.patchMd5 = paramString3;
    this.uUU = paramString4;
    AppMethodBeat.o(32686);
  }
  
  public c(int paramInt1, String paramString, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.i(32685);
    this.Irt = null;
    this.gkU = 0;
    this.Iru = false;
    this.ihH = false;
    this.Irv = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(32670);
        if ((1 == paramAnonymousMessage.what) && (!c.a(c.this)))
        {
          new File(c.this.aNJ()).delete();
          if (paramAnonymousMessage.arg1 != 0) {
            break label91;
          }
          ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "patch ok");
          c.b(c.this).b(200, 0, (cwj)paramAnonymousMessage.obj);
        }
        for (;;)
        {
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(32670);
          return;
          label91:
          if (paramAnonymousMessage.arg1 == 3) {
            c.b(c.this).b(3, -1, (cwj)paramAnonymousMessage.obj);
          } else if (paramAnonymousMessage.arg1 == 4) {
            c.b(c.this).b(4, -1, (cwj)paramAnonymousMessage.obj);
          }
        }
      }
    };
    this.Irw = new b.a()
    {
      public final void Dm(long paramAnonymousLong)
      {
        AppMethodBeat.i(32674);
        c.b(c.this).Dm(paramAnonymousLong);
        AppMethodBeat.o(32674);
      }
      
      public final void Dn(long paramAnonymousLong)
      {
        AppMethodBeat.i(32675);
        c.b(c.this).Dn(paramAnonymousLong);
        AppMethodBeat.o(32675);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, cwj paramAnonymouscwj)
      {
        AppMethodBeat.i(32673);
        if (paramAnonymousInt1 != 0)
        {
          ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=".concat(String.valueOf(paramAnonymousInt1)));
          if (paramAnonymousInt1 == -2) {
            new File(c.this.aNJ()).delete();
          }
          c.e(c.this);
          c.this.a(c.b(c.this));
          AppMethodBeat.o(32673);
          return;
        }
        ae.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try
        {
          if (d.aRf(c.this.aNJ()) < c.f(c.this))
          {
            ae.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
            c.this.a(c.b(c.this));
            AppMethodBeat.o(32673);
            return;
          }
          if (c.g(c.this))
          {
            if (!c.h(c.this).equalsIgnoreCase(d.aRh(c.this.aNJ())))
            {
              ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
              new File(c.this.aNJ()).delete();
              c.b(c.this).b(2, -1, paramAnonymouscwj);
              AppMethodBeat.o(32673);
              return;
            }
            c.a(c.this, paramAnonymouscwj);
            AppMethodBeat.o(32673);
            return;
          }
          if (!c.i(c.this).equalsIgnoreCase(d.aRh(c.this.aNJ())))
          {
            ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
            new File(c.this.aNJ()).delete();
            c.b(c.this).b(-1, -1, paramAnonymouscwj);
            AppMethodBeat.o(32673);
            return;
          }
          d.bc(com.tencent.mm.sandbox.monitor.c.IqQ, c.j(c.this) + ".temp", c.k(c.this) + ".apk");
          c.b(c.this).b(200, 0, paramAnonymouscwj);
          AppMethodBeat.o(32673);
          return;
        }
        catch (Exception localException)
        {
          ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
          ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localException, "", new Object[0]);
          c.b(c.this).b(-1, -1, paramAnonymouscwj);
          AppMethodBeat.o(32673);
        }
      }
      
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(32672);
        ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + paramAnonymousInt1 + ", offset=" + paramAnonymousInt2);
        c.b(c.this).fa(paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(32672);
      }
    };
    this.Irs = paramArrayOfString;
    AppMethodBeat.o(32685);
  }
  
  private int fmt()
  {
    AppMethodBeat.i(32691);
    ae.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "requestCount=" + this.gkU + ", curLinkIdx = " + this.gkU / 5);
    int i = this.gkU / 5;
    AppMethodBeat.o(32691);
    return i;
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(32687);
    this.Irl = parama;
    if (!g.getExternalStorageState().equals("mounted"))
    {
      ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard not available.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (this.ihH)
    {
      ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "netscene had been canceled.");
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if ((fmm()) || (fmt() >= this.Irs.length))
    {
      ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "exceed max download url. url count = " + this.Irs.length);
      if (this.Iru)
      {
        parama.b(1, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    if (!e.re(this.IqS))
    {
      ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "SDCard full");
      if (this.Iru)
      {
        parama.b(13, -1, null);
        AppMethodBeat.o(32687);
        return;
      }
      parama.b(-1, -1, null);
      AppMethodBeat.o(32687);
      return;
    }
    this.Irt = new a(this.IqS, d.aRf(aNJ()), this.Irw);
    this.Irt.execute(new String[] { this.Irs[fmt()] });
    AppMethodBeat.o(32687);
  }
  
  public final String aNJ()
  {
    AppMethodBeat.i(32688);
    if (this.Iru)
    {
      str = IqQ + this.patchMd5 + ".temp";
      AppMethodBeat.o(32688);
      return str;
    }
    String str = super.aNJ();
    AppMethodBeat.o(32688);
    return str;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(32690);
    ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "cancel netscene");
    this.ihH = true;
    if ((this.Irt != null) && (!this.Irt.isCancelled())) {
      this.Irt.cancel(true);
    }
    AppMethodBeat.o(32690);
  }
  
  public final String fml()
  {
    AppMethodBeat.i(32689);
    if (this.Iru)
    {
      str = IqQ + this.uUU + ".apk";
      AppMethodBeat.o(32689);
      return str;
    }
    String str = IqQ + this.IqU + ".apk";
    AppMethodBeat.o(32689);
    return str;
  }
  
  final class a
    extends AsyncTask<String, Integer, Integer>
  {
    private OutputStream CrB;
    private HttpResponse IrA;
    private HttpEntity IrB;
    private b.a Irl;
    private HttpGet Irz;
    private int ccA;
    private int size;
    private HttpClient xqA;
    
    public a(int paramInt1, int paramInt2, b.a parama)
    {
      AppMethodBeat.i(32680);
      this.xqA = null;
      this.Irz = null;
      this.IrA = null;
      this.IrB = null;
      this.CrB = new OutputStream()
      {
        private ByteArrayOutputStream IrC;
        private aq handler;
        
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
          this.IrC.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
          if ((this.IrC.size() < 131072) && (c.a.a(c.a.this) + this.IrC.size() < c.a.b(c.a.this)))
          {
            AppMethodBeat.o(32678);
            return;
          }
          paramAnonymousInt1 = this.IrC.size();
          paramAnonymousInt2 = d.e(c.this.aNJ(), this.IrC.toByteArray(), paramAnonymousInt1);
          this.IrC.reset();
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
                c.a.c(c.a.this).fa(c.a.b(c.a.this), c.a.a(c.a.this));
              }
              c.a.c(c.a.this).Dn(paramAnonymousInt1);
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
      this.Irl = parama;
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
      ae.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "current download url=" + paramVarArgs + ", range=" + this.ccA);
      this.xqA = new DefaultHttpClient();
      this.xqA.getParams().setIntParameter("http.connection.timeout", 15000);
      this.Irz = new HttpGet(paramVarArgs);
      HttpGet localHttpGet = this.Irz;
      StringBuilder localStringBuilder = new StringBuilder("bytes=").append(this.ccA).append("-");
      if (this.size - this.ccA > 1048576) {
        paramVarArgs = Integer.valueOf(this.ccA + 1048576 - 1);
      }
      for (;;)
      {
        localHttpGet.addHeader("RANGE", paramVarArgs);
        try
        {
          this.Irl.Dm(50L);
          this.IrA = this.xqA.execute(this.Irz);
          int i = this.IrA.getStatusLine().getStatusCode();
          if ((i != 200) && (i != 206))
          {
            ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "HttpClient return code:".concat(String.valueOf(i)));
            if (i == 416)
            {
              if (this.Irz != null) {
                this.Irz.abort();
              }
              if (this.IrB != null) {}
              try
              {
                this.IrB.consumeContent();
                if (this.xqA != null) {
                  this.xqA.getConnectionManager().shutdown();
                }
                AppMethodBeat.o(32681);
                return Integer.valueOf(-2);
                paramVarArgs = "";
              }
              catch (IOException paramVarArgs)
              {
                for (;;)
                {
                  ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
                }
              }
            }
            if (this.Irz != null) {
              this.Irz.abort();
            }
            if (this.IrB != null) {}
            try
            {
              this.IrB.consumeContent();
              if (this.xqA != null) {
                this.xqA.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          if ((c.g(c.this)) && (ac.iRw) && (Math.random() > 0.2D))
          {
            ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "simulateNetworkFault");
            if (this.Irz != null) {
              this.Irz.abort();
            }
            if (this.IrB != null) {}
            try
            {
              this.IrB.consumeContent();
              if (this.xqA != null) {
                this.xqA.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-1);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.IrA.getHeaders("Content-Length");
          if (this.ccA > this.size)
          {
            ae.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "range out of size");
            if (this.Irz != null) {
              this.Irz.abort();
            }
            if (this.IrB != null) {}
            try
            {
              this.IrB.consumeContent();
              if (this.xqA != null) {
                this.xqA.getConnectionManager().shutdown();
              }
              AppMethodBeat.o(32681);
              return Integer.valueOf(-2);
            }
            catch (IOException paramVarArgs)
            {
              for (;;)
              {
                ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
              }
            }
          }
          this.IrB = this.IrA.getEntity();
          this.IrB.writeTo(this.CrB);
          this.IrB.consumeContent();
          if (this.Irz != null) {
            this.Irz.abort();
          }
          if (this.IrB != null) {}
          try
          {
            this.IrB.consumeContent();
            if (this.xqA != null) {
              this.xqA.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(0);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
          try
          {
            this.IrB.consumeContent();
            if (this.xqA != null) {
              this.xqA.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            throw paramVarArgs;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
          ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "exception current in download pack", new Object[0]);
          if (this.Irz != null) {
            this.Irz.abort();
          }
          if (this.IrB != null) {}
          try
          {
            this.IrB.consumeContent();
            if (this.xqA != null) {
              this.xqA.getConnectionManager().shutdown();
            }
            AppMethodBeat.o(32681);
            return Integer.valueOf(-1);
          }
          catch (IOException paramVarArgs)
          {
            for (;;)
            {
              ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", paramVarArgs, "", new Object[0]);
            }
          }
        }
        finally
        {
          if (this.Irz != null) {
            this.Irz.abort();
          }
          if (this.IrB == null) {}
        }
      }
    }
    
    protected final void onCancelled()
    {
      AppMethodBeat.i(32682);
      ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "AsyncTask had been canceled.");
      if (this.Irz != null) {
        this.Irz.abort();
      }
      if (this.IrB != null) {}
      try
      {
        this.IrB.consumeContent();
        if (this.xqA != null)
        {
          ae.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "connection shutdown.");
          this.xqA.getConnectionManager().shutdown();
        }
        AppMethodBeat.o(32682);
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", localIOException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sandbox.updater.c
 * JD-Core Version:    0.7.0.1
 */