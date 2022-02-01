package com.tencent.mm.plugin.voip.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.a.b;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.plugin.voip.video.b.c;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.b.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender
  implements GLTextureView.m
{
  public static int FLAG_Angle270;
  public static int FLAG_Angle90;
  public static int FLAG_Mirror;
  public static int FLAG_NV12;
  public static int FLAG_NV21;
  public static int FLAG_RGBA;
  public static int FLAG_RGBAClip;
  public static int FLAG_YV12;
  public static int FLAG_YV12Edge;
  public static int MSG_FLUSH;
  public static int MSG_RENDER;
  public static int MSG_RESET;
  public static int RenderLocal;
  public static int RenderRemote;
  static String TAG;
  private static final Object zvG;
  private static final Object zvH;
  private static final Object zvI;
  private static final Object zvJ;
  static boolean zvP;
  public static int zvx;
  public float mBrightness;
  public float mContrast;
  int mRenderMode;
  public float mSaturation;
  public int zhL;
  public int zhM;
  private boolean zvA;
  private int zvB;
  private int zvC;
  private volatile boolean zvD;
  private volatile boolean zvE;
  public int zvF;
  public int zvK;
  public boolean zvL;
  long zvM;
  public b zvN;
  WeakReference<Object> zvO;
  private boolean zvQ;
  boolean zvR;
  boolean zva;
  int zvb;
  long zvc;
  long zvd;
  int zve;
  a zvf;
  boolean zvg;
  boolean zvh;
  boolean zvi;
  boolean zvj;
  boolean zvk;
  int zvl;
  int zvm;
  WeakReference<OpenGlView> zvn;
  public boolean zvo;
  public Bitmap zvp;
  private int zvq;
  private int zvr;
  private byte[] zvs;
  private int[] zvt;
  private int zvu;
  private int zvv;
  private int zvw;
  private b zvy;
  g zvz;
  
  static
  {
    AppMethodBeat.i(115668);
    TAG = "OpenGlRender";
    MSG_RENDER = 0;
    MSG_FLUSH = 1;
    MSG_RESET = 2;
    FLAG_RGBA = 0;
    FLAG_RGBAClip = 1;
    FLAG_YV12 = 0;
    FLAG_YV12Edge = 1;
    FLAG_NV12 = 2;
    FLAG_NV21 = 3;
    FLAG_Angle90 = 4;
    FLAG_Angle270 = 12;
    FLAG_Mirror = 16;
    RenderLocal = 0;
    RenderRemote = 1;
    zvx = 0;
    zvG = new Object();
    zvH = new Object();
    zvI = new Object();
    zvJ = new Object();
    zvP = false;
    AppMethodBeat.o(115668);
  }
  
  public OpenGlRender(OpenGlView paramOpenGlView, int paramInt)
  {
    AppMethodBeat.i(115648);
    this.zva = false;
    this.zvb = 0;
    this.zvc = 0L;
    this.zvd = 0L;
    this.zve = 0;
    this.mBrightness = 1.2F;
    this.mContrast = 1.93F;
    this.mSaturation = 1.05F;
    this.zvg = false;
    this.zvh = false;
    this.zvi = false;
    this.zvj = false;
    this.zvk = false;
    this.zvl = 0;
    this.zvm = 0;
    this.mRenderMode = RenderLocal;
    this.zvo = false;
    this.zvp = null;
    this.zvq = 0;
    this.zvr = 0;
    this.zvs = null;
    this.zvt = null;
    this.zvy = null;
    this.zvD = false;
    this.zvE = false;
    this.zvF = 0;
    this.zvK = 0;
    this.zhL = 0;
    this.zhM = 0;
    this.zvL = false;
    this.zvM = -1L;
    this.zvQ = false;
    this.zvR = false;
    if (!zvP)
    {
      OpenGlRender.class.getClassLoader();
      j.pq("mm_gl_disp");
      zvP = true;
    }
    this.mRenderMode = paramInt;
    this.zvn = new WeakReference(paramOpenGlView);
    paramOpenGlView = Looper.myLooper();
    if (paramOpenGlView != null) {
      this.zvf = new a(paramOpenGlView);
    }
    for (;;)
    {
      this.zvO = null;
      if (getGLVersion() == 2) {
        this.zvy = new b();
      }
      this.zvB = 0;
      this.zvz = new g();
      AppMethodBeat.o(115648);
      return;
      paramOpenGlView = Looper.getMainLooper();
      if (paramOpenGlView != null) {
        this.zvf = new a(paramOpenGlView);
      } else {
        this.zvf = null;
      }
    }
  }
  
  private native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  private native void Uninit(int paramInt);
  
  private void dXi()
  {
    AppMethodBeat.i(115662);
    if (this.zvy != null)
    {
      if (this.zvn != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)this.zvn.get();
        if (localOpenGlView != null)
        {
          localOpenGlView.queueEvent(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115643);
              if (OpenGlRender.a(OpenGlRender.this) != null) {
                OpenGlRender.a(OpenGlRender.this).destroy();
              }
              AppMethodBeat.o(115643);
            }
          });
          AppMethodBeat.o(115662);
          return;
        }
      }
      if (this.zvy != null) {
        this.zvy.destroy();
      }
    }
    AppMethodBeat.o(115662);
  }
  
  public static int getGLVersion()
  {
    AppMethodBeat.i(115647);
    if (zvx == 0)
    {
      zvx = 2;
      ad.i(TAG, "init gl version: %s", new Object[] { Integer.valueOf(zvx) });
    }
    int i = zvx;
    AppMethodBeat.o(115647);
    return i;
  }
  
  private void rU(boolean paramBoolean)
  {
    AppMethodBeat.i(115664);
    if ((this.zvn != null) && (this.zvn.get() != null))
    {
      if (!paramBoolean)
      {
        ??? = (OpenGlView)this.zvn.get();
        ad.i(TAG, "attachGLContext:%s", new Object[] { ??? });
        ((OpenGlView)???).queueEvent(new Runnable()
        {
          public final void run()
          {
            boolean bool = false;
            AppMethodBeat.i(161661);
            if (OpenGlRender.g(OpenGlRender.this))
            {
              ad.i(OpenGlRender.TAG, "attachGLContext");
              ??? = OpenGlRender.this;
              if (!OpenGlRender.b(OpenGlRender.this).dXE()) {
                bool = true;
              }
              OpenGlRender.a((OpenGlRender)???, bool);
              OpenGlRender.e(OpenGlRender.this);
              OpenGlRender.f(OpenGlRender.this);
              ad.i(OpenGlRender.TAG, "attach finish");
            }
            synchronized (OpenGlRender.Ij())
            {
              try
              {
                OpenGlRender.Ij().notifyAll();
                AppMethodBeat.o(161661);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ad.printErrStackTrace(OpenGlRender.TAG, localException, "", new Object[0]);
                }
              }
            }
          }
        });
        synchronized (zvH)
        {
          try
          {
            zvH.wait(100L);
            ad.i(TAG, "attachGLContext wait finish, bNeedAttach:%s", new Object[] { Boolean.valueOf(this.zvQ) });
            AppMethodBeat.o(115664);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ad.printErrStackTrace(TAG, localException, "", new Object[0]);
            }
          }
        }
      }
      if (this.zvQ)
      {
        ad.i(TAG, "attachGLContext");
        if (this.zvz.dXE()) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.zvQ = paramBoolean;
      this.zvs = null;
      this.zvt = null;
      ad.i(TAG, "attach finish");
      AppMethodBeat.o(115664);
      return;
    }
  }
  
  private native void render32(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void render8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setParam(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  public final void QR(int paramInt)
  {
    AppMethodBeat.i(115650);
    this.zvF = paramInt;
    if (this.zvz != null)
    {
      ad.m(TAG, "setShowMode, mode:%d, uiWidth: %s, uiHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zvl), Integer.valueOf(this.zvm) });
      if (paramInt == 1) {
        break label90;
      }
      this.zvR = true;
      dXj();
    }
    for (;;)
    {
      this.zvz.QT(this.zvF);
      AppMethodBeat.o(115650);
      return;
      label90:
      if (this.zvR)
      {
        ad.i(TAG, "is need to detach");
        dXj();
      }
      this.zvQ = true;
      rU(false);
    }
  }
  
  public final void a(int paramInt, a.b paramb)
  {
    AppMethodBeat.i(115667);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115667);
      return;
      if ((this.zvz != null) && (this.zvz.dXB() != null))
      {
        paramb.a(this.zvz.dXB());
        AppMethodBeat.o(115667);
        return;
        if ((this.zvy != null) && (this.zvy.dXv() != null)) {
          paramb.a(this.zvy.dXv());
        }
      }
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115651);
    if (this.zvz != null) {
      this.zvz.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115651);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(115653);
    if ((this.zvg) && (this.zvs == null))
    {
      this.zvu = paramInt1;
      this.zvv = paramInt2;
      this.zvw = paramInt3;
      this.zvs = paramArrayOfByte;
      this.zvA = paramBoolean;
      this.zvC = paramInt4;
      requestRender();
    }
    AppMethodBeat.o(115653);
  }
  
  public final void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(115655);
    if ((this.zvg) && (this.zvt == null))
    {
      this.zvu = paramInt1;
      this.zvv = paramInt2;
      this.zvw = paramInt3;
      this.zvt = paramArrayOfInt;
      this.zvA = paramBoolean;
      requestRender();
    }
    AppMethodBeat.o(115655);
  }
  
  public final void dXg()
  {
    AppMethodBeat.i(115660);
    ad.i(TAG, "%s onStop, renderMode: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
    this.zvh = false;
    this.zvk = false;
    AppMethodBeat.o(115660);
  }
  
  public final void dXh()
  {
    AppMethodBeat.i(115661);
    ad.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.zvg), Boolean.valueOf(this.zvh) });
    if ((this.zvg) && (this.zvh))
    {
      ad.i(TAG, "%s steve: Reset GLRender first! mode=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
      if (this.zvz != null)
      {
        ad.i(TAG, "onResetRender need detach");
        this.zvR = true;
        dXj();
      }
      this.zvg = false;
      this.zvh = false;
      dXi();
    }
    AppMethodBeat.o(115661);
  }
  
  final void dXj()
  {
    AppMethodBeat.i(115663);
    if ((this.zvn != null) && (this.zvn.get() != null))
    {
      ??? = (OpenGlView)this.zvn.get();
      ad.i(TAG, "detachGLContext:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115644);
          if (OpenGlRender.c(OpenGlRender.this))
          {
            OpenGlRender.b(OpenGlRender.this).dXF();
            OpenGlRender.d(OpenGlRender.this);
            OpenGlRender.e(OpenGlRender.this);
            OpenGlRender.f(OpenGlRender.this);
            ad.i(OpenGlRender.TAG, "detach finish");
          }
          synchronized (OpenGlRender.zvG)
          {
            try
            {
              OpenGlRender.zvG.notifyAll();
              AppMethodBeat.o(115644);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace(OpenGlRender.TAG, localException, "", new Object[0]);
              }
            }
          }
        }
      });
      synchronized (zvG)
      {
        try
        {
          zvG.wait(100L);
          ad.i(TAG, "detachGLContext wait finish, bNeedDetach:%s", new Object[] { Boolean.valueOf(this.zvR) });
          AppMethodBeat.o(115663);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace(TAG, localException, "", new Object[0]);
          }
        }
      }
    }
    if (this.zvR) {
      ((OpenGlView)this.zvn.get()).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115645);
          OpenGlRender.b(OpenGlRender.this).dXF();
          OpenGlRender.d(OpenGlRender.this);
          OpenGlRender.e(OpenGlRender.this);
          OpenGlRender.f(OpenGlRender.this);
          ad.i(OpenGlRender.TAG, "detach finish");
          AppMethodBeat.o(115645);
        }
      });
    }
    AppMethodBeat.o(115663);
  }
  
  public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115654);
    if ((this.zvg) && (this.zvs == null))
    {
      this.zvu = paramInt1;
      this.zvv = paramInt2;
      this.zvw = paramInt3;
      this.zvs = paramArrayOfByte;
      this.zvA = false;
      requestRender();
    }
    AppMethodBeat.o(115654);
  }
  
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115656);
    ad.i(TAG, "video=" + paramInt1 + "x" + paramInt2);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.zhL = paramInt1;
      this.zhM = paramInt2;
      if (this.zvz != null) {
        this.zvz.ia(paramInt1, paramInt2);
      }
      AppMethodBeat.o(115656);
      return;
    }
    ad.e(TAG, "ERROR video size:%dx%d, lastviddeosize:%dx%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.zhL), Integer.valueOf(this.zhM) });
    AppMethodBeat.o(115656);
  }
  
  /* Error */
  public final void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: ldc_w 495
    //   3: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 222	com/tencent/mm/plugin/voip/video/OpenGlRender:zvF	I
    //   10: ifne +2197 -> 2207
    //   13: aload_0
    //   14: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:zvh	Z
    //   17: ifeq +20 -> 37
    //   20: aload_0
    //   21: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:zvg	Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 259	com/tencent/mm/plugin/voip/video/OpenGlRender:zvn	Ljava/lang/ref/WeakReference;
    //   31: invokevirtual 308	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   34: ifnonnull +63 -> 97
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:zvt	[I
    //   47: getstatic 118	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   50: ldc_w 497
    //   53: iconst_3
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:zvh	Z
    //   63: invokestatic 361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_0
    //   70: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:zvg	Z
    //   73: invokestatic 361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: aload_0
    //   80: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:zvA	Z
    //   83: invokestatic 361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: invokestatic 499	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 495
    //   93: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: aload_0
    //   98: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   101: ifnull +662 -> 763
    //   104: aload_0
    //   105: invokestatic 505	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   108: putfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:zvM	J
    //   111: aload_0
    //   112: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:zvw	I
    //   115: getstatic 142	com/tencent/mm/plugin/voip/video/OpenGlRender:FLAG_Mirror	I
    //   118: iand
    //   119: ifeq +679 -> 798
    //   122: iconst_1
    //   123: istore_2
    //   124: aload_0
    //   125: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:zvB	I
    //   128: bipush 8
    //   130: iand
    //   131: ifeq +672 -> 803
    //   134: iconst_1
    //   135: istore_3
    //   136: aload_0
    //   137: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:zvy	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   140: ifnull +698 -> 838
    //   143: aload_0
    //   144: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:zvA	Z
    //   147: ifeq +691 -> 838
    //   150: aload_0
    //   151: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:zvB	I
    //   154: ifeq +684 -> 838
    //   157: iload_3
    //   158: ifne +680 -> 838
    //   161: aload_0
    //   162: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:zvy	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:zvB	I
    //   170: istore_3
    //   171: aload_1
    //   172: getfield 508	com/tencent/mm/plugin/voip/video/a/b:ggj	Z
    //   175: ifne +509 -> 684
    //   178: aload_1
    //   179: ldc_w 510
    //   182: ldc_w 512
    //   185: invokestatic 516	com/tencent/mm/plugin/voip/video/a/b:ap	(Ljava/lang/String;Ljava/lang/String;)I
    //   188: putfield 519	com/tencent/mm/plugin/voip/video/a/b:gvT	I
    //   191: aload_1
    //   192: getfield 519	com/tencent/mm/plugin/voip/video/a/b:gvT	I
    //   195: ifne +12 -> 207
    //   198: ldc_w 521
    //   201: ldc_w 523
    //   204: invokestatic 525	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_1
    //   208: aload_1
    //   209: getfield 519	com/tencent/mm/plugin/voip/video/a/b:gvT	I
    //   212: ldc_w 527
    //   215: invokestatic 533	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   218: putfield 536	com/tencent/mm/plugin/voip/video/a/b:gvV	I
    //   221: aload_1
    //   222: aload_1
    //   223: getfield 519	com/tencent/mm/plugin/voip/video/a/b:gvT	I
    //   226: ldc_w 538
    //   229: invokestatic 533	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   232: putfield 541	com/tencent/mm/plugin/voip/video/a/b:gvU	I
    //   235: aload_1
    //   236: aload_1
    //   237: getfield 519	com/tencent/mm/plugin/voip/video/a/b:gvT	I
    //   240: ldc_w 543
    //   243: invokestatic 546	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   246: putfield 549	com/tencent/mm/plugin/voip/video/a/b:gvW	I
    //   249: aload_1
    //   250: aload_1
    //   251: getfield 519	com/tencent/mm/plugin/voip/video/a/b:gvT	I
    //   254: ldc_w 551
    //   257: invokestatic 546	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   260: putfield 554	com/tencent/mm/plugin/voip/video/a/b:gvX	I
    //   263: aload_1
    //   264: aload_1
    //   265: getfield 519	com/tencent/mm/plugin/voip/video/a/b:gvT	I
    //   268: ldc_w 556
    //   271: invokestatic 546	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   274: putfield 559	com/tencent/mm/plugin/voip/video/a/b:gvY	I
    //   277: aload_1
    //   278: invokestatic 563	com/tencent/mm/plugin/voip/video/a/b:dXt	()Lcom/tencent/mm/media/f/d;
    //   281: putfield 567	com/tencent/mm/plugin/voip/video/a/b:zwK	Lcom/tencent/mm/media/f/d;
    //   284: aload_1
    //   285: invokestatic 563	com/tencent/mm/plugin/voip/video/a/b:dXt	()Lcom/tencent/mm/media/f/d;
    //   288: putfield 570	com/tencent/mm/plugin/voip/video/a/b:zwL	Lcom/tencent/mm/media/f/d;
    //   291: aload_1
    //   292: ldc_w 510
    //   295: ldc_w 572
    //   298: invokestatic 516	com/tencent/mm/plugin/voip/video/a/b:ap	(Ljava/lang/String;Ljava/lang/String;)I
    //   301: putfield 575	com/tencent/mm/plugin/voip/video/a/b:zwM	I
    //   304: aload_1
    //   305: aload_1
    //   306: getfield 575	com/tencent/mm/plugin/voip/video/a/b:zwM	I
    //   309: ldc_w 527
    //   312: invokestatic 533	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   315: putfield 578	com/tencent/mm/plugin/voip/video/a/b:zwP	I
    //   318: aload_1
    //   319: aload_1
    //   320: getfield 575	com/tencent/mm/plugin/voip/video/a/b:zwM	I
    //   323: ldc_w 538
    //   326: invokestatic 533	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   329: putfield 581	com/tencent/mm/plugin/voip/video/a/b:zwO	I
    //   332: aload_1
    //   333: aload_1
    //   334: getfield 575	com/tencent/mm/plugin/voip/video/a/b:zwM	I
    //   337: ldc_w 583
    //   340: invokestatic 546	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   343: putfield 586	com/tencent/mm/plugin/voip/video/a/b:zwQ	I
    //   346: aload_1
    //   347: aload_1
    //   348: getfield 575	com/tencent/mm/plugin/voip/video/a/b:zwM	I
    //   351: ldc_w 556
    //   354: invokestatic 546	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   357: putfield 589	com/tencent/mm/plugin/voip/video/a/b:zwR	I
    //   360: aload_1
    //   361: invokestatic 563	com/tencent/mm/plugin/voip/video/a/b:dXt	()Lcom/tencent/mm/media/f/d;
    //   364: putfield 592	com/tencent/mm/plugin/voip/video/a/b:zwN	Lcom/tencent/mm/media/f/d;
    //   367: aload_1
    //   368: invokestatic 563	com/tencent/mm/plugin/voip/video/a/b:dXt	()Lcom/tencent/mm/media/f/d;
    //   371: putfield 595	com/tencent/mm/plugin/voip/video/a/b:zwZ	Lcom/tencent/mm/media/f/d;
    //   374: getstatic 599	com/tencent/mm/plugin/voip/video/a/b:gwe	[F
    //   377: astore 11
    //   379: aload_1
    //   380: aload 11
    //   382: aload 11
    //   384: arraylength
    //   385: invokestatic 605	java/util/Arrays:copyOf	([FI)[F
    //   388: putfield 608	com/tencent/mm/plugin/voip/video/a/b:iBp	[F
    //   391: aload_1
    //   392: aload_1
    //   393: getfield 608	com/tencent/mm/plugin/voip/video/a/b:iBp	[F
    //   396: arraylength
    //   397: iconst_4
    //   398: imul
    //   399: invokestatic 614	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   402: invokestatic 620	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   405: invokevirtual 624	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   408: invokevirtual 628	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   411: putfield 632	com/tencent/mm/plugin/voip/video/a/b:guT	Ljava/nio/FloatBuffer;
    //   414: aload_1
    //   415: getfield 632	com/tencent/mm/plugin/voip/video/a/b:guT	Ljava/nio/FloatBuffer;
    //   418: aload_1
    //   419: getfield 608	com/tencent/mm/plugin/voip/video/a/b:iBp	[F
    //   422: invokevirtual 638	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   425: pop
    //   426: aload_1
    //   427: getfield 632	com/tencent/mm/plugin/voip/video/a/b:guT	Ljava/nio/FloatBuffer;
    //   430: iconst_0
    //   431: invokevirtual 642	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   434: pop
    //   435: aload_1
    //   436: getstatic 645	com/tencent/mm/plugin/voip/video/a/b:gwf	[F
    //   439: arraylength
    //   440: iconst_4
    //   441: imul
    //   442: invokestatic 614	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   445: invokestatic 620	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   448: invokevirtual 624	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   451: invokevirtual 628	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   454: putfield 648	com/tencent/mm/plugin/voip/video/a/b:guS	Ljava/nio/FloatBuffer;
    //   457: aload_1
    //   458: getfield 648	com/tencent/mm/plugin/voip/video/a/b:guS	Ljava/nio/FloatBuffer;
    //   461: getstatic 645	com/tencent/mm/plugin/voip/video/a/b:gwf	[F
    //   464: invokevirtual 638	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   467: pop
    //   468: aload_1
    //   469: getfield 648	com/tencent/mm/plugin/voip/video/a/b:guS	Ljava/nio/FloatBuffer;
    //   472: iconst_0
    //   473: invokevirtual 642	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   476: pop
    //   477: getstatic 651	com/tencent/mm/plugin/voip/video/a/b:zwJ	[F
    //   480: astore 11
    //   482: aload_1
    //   483: aload 11
    //   485: aload 11
    //   487: arraylength
    //   488: invokestatic 605	java/util/Arrays:copyOf	([FI)[F
    //   491: putfield 654	com/tencent/mm/plugin/voip/video/a/b:zwW	[F
    //   494: aload_1
    //   495: aload_1
    //   496: getfield 654	com/tencent/mm/plugin/voip/video/a/b:zwW	[F
    //   499: arraylength
    //   500: iconst_4
    //   501: imul
    //   502: invokestatic 614	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   505: invokestatic 620	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   508: invokevirtual 624	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   511: invokevirtual 628	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   514: putfield 657	com/tencent/mm/plugin/voip/video/a/b:zwS	Ljava/nio/FloatBuffer;
    //   517: aload_1
    //   518: getfield 657	com/tencent/mm/plugin/voip/video/a/b:zwS	Ljava/nio/FloatBuffer;
    //   521: aload_1
    //   522: getfield 654	com/tencent/mm/plugin/voip/video/a/b:zwW	[F
    //   525: invokevirtual 638	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   528: pop
    //   529: aload_1
    //   530: getfield 657	com/tencent/mm/plugin/voip/video/a/b:zwS	Ljava/nio/FloatBuffer;
    //   533: iconst_0
    //   534: invokevirtual 642	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   537: pop
    //   538: getstatic 599	com/tencent/mm/plugin/voip/video/a/b:gwe	[F
    //   541: astore 11
    //   543: aload_1
    //   544: aload 11
    //   546: aload 11
    //   548: arraylength
    //   549: invokestatic 605	java/util/Arrays:copyOf	([FI)[F
    //   552: putfield 660	com/tencent/mm/plugin/voip/video/a/b:zwV	[F
    //   555: aload_1
    //   556: aload_1
    //   557: getfield 660	com/tencent/mm/plugin/voip/video/a/b:zwV	[F
    //   560: arraylength
    //   561: iconst_4
    //   562: imul
    //   563: invokestatic 614	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   566: invokestatic 620	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   569: invokevirtual 624	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   572: invokevirtual 628	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   575: putfield 663	com/tencent/mm/plugin/voip/video/a/b:zwT	Ljava/nio/FloatBuffer;
    //   578: aload_1
    //   579: getfield 663	com/tencent/mm/plugin/voip/video/a/b:zwT	Ljava/nio/FloatBuffer;
    //   582: aload_1
    //   583: getfield 660	com/tencent/mm/plugin/voip/video/a/b:zwV	[F
    //   586: invokevirtual 638	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   589: pop
    //   590: aload_1
    //   591: getfield 663	com/tencent/mm/plugin/voip/video/a/b:zwT	Ljava/nio/FloatBuffer;
    //   594: iconst_0
    //   595: invokevirtual 642	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   598: pop
    //   599: aload_1
    //   600: invokestatic 667	com/tencent/mm/plugin/voip/video/a/b:dXu	()Lcom/tencent/mm/media/f/a;
    //   603: putfield 671	com/tencent/mm/plugin/voip/video/a/b:zwX	Lcom/tencent/mm/media/f/a;
    //   606: aload_1
    //   607: aconst_null
    //   608: putfield 674	com/tencent/mm/plugin/voip/video/a/b:zxf	[B
    //   611: aload_1
    //   612: invokestatic 667	com/tencent/mm/plugin/voip/video/a/b:dXu	()Lcom/tencent/mm/media/f/a;
    //   615: putfield 677	com/tencent/mm/plugin/voip/video/a/b:zwY	Lcom/tencent/mm/media/f/a;
    //   618: aload_1
    //   619: invokestatic 563	com/tencent/mm/plugin/voip/video/a/b:dXt	()Lcom/tencent/mm/media/f/d;
    //   622: putfield 680	com/tencent/mm/plugin/voip/video/a/b:oSo	Lcom/tencent/mm/media/f/d;
    //   625: iload_3
    //   626: ifeq +30 -> 656
    //   629: aload_1
    //   630: new 682	com/tencent/mm/plugin/voip/video/a/a
    //   633: dup
    //   634: invokespecial 683	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   637: putfield 687	com/tencent/mm/plugin/voip/video/a/b:zxc	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   640: aload_1
    //   641: getfield 687	com/tencent/mm/plugin/voip/video/a/b:zxc	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   644: aload_1
    //   645: getfield 595	com/tencent/mm/plugin/voip/video/a/b:zwZ	Lcom/tencent/mm/media/f/d;
    //   648: aload_1
    //   649: getfield 680	com/tencent/mm/plugin/voip/video/a/b:oSo	Lcom/tencent/mm/media/f/d;
    //   652: iload_3
    //   653: invokevirtual 690	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/f/d;Lcom/tencent/mm/media/f/d;I)V
    //   656: ldc_w 521
    //   659: ldc_w 692
    //   662: iconst_1
    //   663: anewarray 4	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: aload_1
    //   669: invokevirtual 445	java/lang/Object:hashCode	()I
    //   672: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   675: aastore
    //   676: invokestatic 340	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: aload_1
    //   680: iconst_1
    //   681: putfield 508	com/tencent/mm/plugin/voip/video/a/b:ggj	Z
    //   684: aload_0
    //   685: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:zvy	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   688: aload_0
    //   689: getfield 198	com/tencent/mm/plugin/voip/video/OpenGlRender:zvl	I
    //   692: aload_0
    //   693: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:zvm	I
    //   696: invokevirtual 695	com/tencent/mm/plugin/voip/video/a/b:hY	(II)V
    //   699: iload_2
    //   700: ifne +108 -> 808
    //   703: aload_0
    //   704: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:zvy	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   707: aload_0
    //   708: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   711: aload_0
    //   712: getfield 425	com/tencent/mm/plugin/voip/video/OpenGlRender:zvu	I
    //   715: aload_0
    //   716: getfield 427	com/tencent/mm/plugin/voip/video/OpenGlRender:zvv	I
    //   719: aload_0
    //   720: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:zvw	I
    //   723: iconst_0
    //   724: invokevirtual 697	com/tencent/mm/plugin/voip/video/a/b:d	([BIIII)V
    //   727: aload_0
    //   728: aconst_null
    //   729: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   732: aload_0
    //   733: getfield 699	com/tencent/mm/plugin/voip/video/OpenGlRender:zvN	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   736: ifnull +27 -> 763
    //   739: aload_0
    //   740: getfield 433	com/tencent/mm/plugin/voip/video/OpenGlRender:zvC	I
    //   743: iconst_3
    //   744: if_icmpne +1444 -> 2188
    //   747: aload_0
    //   748: getfield 699	com/tencent/mm/plugin/voip/video/OpenGlRender:zvN	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   751: aload_0
    //   752: getfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:zvM	J
    //   755: invokestatic 703	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   758: invokeinterface 706 3 0
    //   763: aload_0
    //   764: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:zvL	Z
    //   767: ifeq +24 -> 791
    //   770: aload_0
    //   771: getfield 699	com/tencent/mm/plugin/voip/video/OpenGlRender:zvN	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   774: ifnull +17 -> 791
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:zvL	Z
    //   782: aload_0
    //   783: getfield 699	com/tencent/mm/plugin/voip/video/OpenGlRender:zvN	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   786: invokeinterface 709 1 0
    //   791: ldc_w 495
    //   794: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   797: return
    //   798: iconst_0
    //   799: istore_2
    //   800: goto -676 -> 124
    //   803: iconst_0
    //   804: istore_3
    //   805: goto -669 -> 136
    //   808: aload_0
    //   809: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:zvy	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   812: aload_0
    //   813: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   816: aload_0
    //   817: getfield 425	com/tencent/mm/plugin/voip/video/OpenGlRender:zvu	I
    //   820: aload_0
    //   821: getfield 427	com/tencent/mm/plugin/voip/video/OpenGlRender:zvv	I
    //   824: aload_0
    //   825: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:zvw	I
    //   828: aload_0
    //   829: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:zvB	I
    //   832: invokevirtual 697	com/tencent/mm/plugin/voip/video/a/b:d	([BIIII)V
    //   835: goto -108 -> 727
    //   838: aload_0
    //   839: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:zvz	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   842: ifnull -115 -> 727
    //   845: iconst_0
    //   846: istore 4
    //   848: iload 4
    //   850: istore_2
    //   851: aload_0
    //   852: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:zvA	Z
    //   855: ifeq +15 -> 870
    //   858: iload 4
    //   860: istore_2
    //   861: iload_3
    //   862: ifeq +8 -> 870
    //   865: aload_0
    //   866: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:zvB	I
    //   869: istore_2
    //   870: aload_0
    //   871: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:zvz	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   874: iconst_0
    //   875: invokevirtual 399	com/tencent/mm/plugin/voip/video/b/g:QT	(I)V
    //   878: aload_0
    //   879: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:zvz	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   882: astore 11
    //   884: aload_0
    //   885: getfield 425	com/tencent/mm/plugin/voip/video/OpenGlRender:zvu	I
    //   888: istore_3
    //   889: aload_0
    //   890: getfield 427	com/tencent/mm/plugin/voip/video/OpenGlRender:zvv	I
    //   893: istore 4
    //   895: aload_0
    //   896: getfield 198	com/tencent/mm/plugin/voip/video/OpenGlRender:zvl	I
    //   899: istore 6
    //   901: aload_0
    //   902: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:zvm	I
    //   905: istore 7
    //   907: aload_0
    //   908: getfield 433	com/tencent/mm/plugin/voip/video/OpenGlRender:zvC	I
    //   911: istore 5
    //   913: aload_0
    //   914: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:zvw	I
    //   917: istore 8
    //   919: iload_3
    //   920: ifle +531 -> 1451
    //   923: iload 4
    //   925: ifle +526 -> 1451
    //   928: iload 8
    //   930: iconst_2
    //   931: ishr
    //   932: iconst_3
    //   933: iand
    //   934: istore 9
    //   936: iload 8
    //   938: iconst_4
    //   939: ishr
    //   940: iconst_1
    //   941: iand
    //   942: iconst_1
    //   943: if_icmpne +715 -> 1658
    //   946: iconst_1
    //   947: istore 10
    //   949: aload 11
    //   951: iload_2
    //   952: putfield 712	com/tencent/mm/plugin/voip/video/b/g:zyo	I
    //   955: iload_3
    //   956: aload 11
    //   958: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   961: if_icmpne +63 -> 1024
    //   964: iload 4
    //   966: aload 11
    //   968: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   971: if_icmpne +53 -> 1024
    //   974: iload 6
    //   976: aload 11
    //   978: getfield 721	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   981: if_icmpne +43 -> 1024
    //   984: iload 7
    //   986: aload 11
    //   988: getfield 724	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   991: if_icmpne +33 -> 1024
    //   994: aload 11
    //   996: getfield 727	com/tencent/mm/plugin/voip/video/b/g:xYz	I
    //   999: iload 9
    //   1001: if_icmpne +23 -> 1024
    //   1004: aload 11
    //   1006: getfield 730	com/tencent/mm/plugin/voip/video/b/g:zyn	Z
    //   1009: iload 10
    //   1011: if_icmpne +13 -> 1024
    //   1014: aload 11
    //   1016: getfield 733	com/tencent/mm/plugin/voip/video/b/g:zyi	I
    //   1019: iload 5
    //   1021: if_icmpeq +430 -> 1451
    //   1024: aload 11
    //   1026: iload 9
    //   1028: putfield 727	com/tencent/mm/plugin/voip/video/b/g:xYz	I
    //   1031: aload 11
    //   1033: iload 10
    //   1035: putfield 730	com/tencent/mm/plugin/voip/video/b/g:zyn	Z
    //   1038: aload 11
    //   1040: iload 5
    //   1042: putfield 733	com/tencent/mm/plugin/voip/video/b/g:zyi	I
    //   1045: ldc_w 735
    //   1048: ldc_w 737
    //   1051: bipush 11
    //   1053: anewarray 4	java/lang/Object
    //   1056: dup
    //   1057: iconst_0
    //   1058: iload 5
    //   1060: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1063: aastore
    //   1064: dup
    //   1065: iconst_1
    //   1066: aload 11
    //   1068: getfield 727	com/tencent/mm/plugin/voip/video/b/g:xYz	I
    //   1071: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1074: aastore
    //   1075: dup
    //   1076: iconst_2
    //   1077: aload 11
    //   1079: getfield 730	com/tencent/mm/plugin/voip/video/b/g:zyn	Z
    //   1082: invokestatic 361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1085: aastore
    //   1086: dup
    //   1087: iconst_3
    //   1088: iload_3
    //   1089: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1092: aastore
    //   1093: dup
    //   1094: iconst_4
    //   1095: iload 4
    //   1097: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1100: aastore
    //   1101: dup
    //   1102: iconst_5
    //   1103: iload 6
    //   1105: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1108: aastore
    //   1109: dup
    //   1110: bipush 6
    //   1112: iload 7
    //   1114: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1117: aastore
    //   1118: dup
    //   1119: bipush 7
    //   1121: aload 11
    //   1123: getfield 740	com/tencent/mm/plugin/voip/video/b/g:zyg	I
    //   1126: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1129: aastore
    //   1130: dup
    //   1131: bipush 8
    //   1133: aload 11
    //   1135: getfield 743	com/tencent/mm/plugin/voip/video/b/g:zyr	I
    //   1138: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1141: aastore
    //   1142: dup
    //   1143: bipush 9
    //   1145: aload 11
    //   1147: getfield 746	com/tencent/mm/plugin/voip/video/b/g:zys	I
    //   1150: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1153: aastore
    //   1154: dup
    //   1155: bipush 10
    //   1157: aload 11
    //   1159: getfield 712	com/tencent/mm/plugin/voip/video/b/g:zyo	I
    //   1162: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1165: aastore
    //   1166: invokestatic 340	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1169: aload 11
    //   1171: iload_3
    //   1172: putfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1175: aload 11
    //   1177: iload 4
    //   1179: putfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1182: aload 11
    //   1184: iload 6
    //   1186: putfield 721	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   1189: aload 11
    //   1191: iload 7
    //   1193: putfield 724	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   1196: aload 11
    //   1198: aload 11
    //   1200: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1203: aload 11
    //   1205: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1208: invokevirtual 749	com/tencent/mm/plugin/voip/video/b/g:ib	(II)V
    //   1211: iload_3
    //   1212: iload 4
    //   1214: imul
    //   1215: istore_2
    //   1216: iload_2
    //   1217: iconst_4
    //   1218: idiv
    //   1219: istore 6
    //   1221: aload 11
    //   1223: monitorenter
    //   1224: aload 11
    //   1226: iload 6
    //   1228: iconst_2
    //   1229: imul
    //   1230: iload_2
    //   1231: iadd
    //   1232: invokestatic 752	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1235: putfield 756	com/tencent/mm/plugin/voip/video/b/g:zyj	Ljava/nio/ByteBuffer;
    //   1238: aload 11
    //   1240: iload_2
    //   1241: invokestatic 752	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1244: putfield 759	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1247: aload 11
    //   1249: iload 6
    //   1251: invokestatic 752	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1254: putfield 762	com/tencent/mm/plugin/voip/video/b/g:zyk	Ljava/nio/ByteBuffer;
    //   1257: aload 11
    //   1259: iload 6
    //   1261: invokestatic 752	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1264: putfield 765	com/tencent/mm/plugin/voip/video/b/g:zyl	Ljava/nio/ByteBuffer;
    //   1267: aload 11
    //   1269: iload 6
    //   1271: iconst_2
    //   1272: imul
    //   1273: invokestatic 752	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1276: putfield 768	com/tencent/mm/plugin/voip/video/b/g:zym	Ljava/nio/ByteBuffer;
    //   1279: aload 11
    //   1281: monitorexit
    //   1282: aload 11
    //   1284: getfield 772	com/tencent/mm/plugin/voip/video/b/g:zyc	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1287: ifnull +164 -> 1451
    //   1290: iload 5
    //   1292: iconst_3
    //   1293: if_icmpne +158 -> 1451
    //   1296: aload 11
    //   1298: getfield 772	com/tencent/mm/plugin/voip/video/b/g:zyc	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1301: astore 11
    //   1303: ldc_w 774
    //   1306: ldc_w 776
    //   1309: iconst_4
    //   1310: anewarray 4	java/lang/Object
    //   1313: dup
    //   1314: iconst_0
    //   1315: iload_3
    //   1316: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1319: aastore
    //   1320: dup
    //   1321: iconst_1
    //   1322: iload 4
    //   1324: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1327: aastore
    //   1328: dup
    //   1329: iconst_2
    //   1330: aload 11
    //   1332: getfield 781	com/tencent/mm/plugin/voip/video/b/d:gtF	I
    //   1335: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1338: aastore
    //   1339: dup
    //   1340: iconst_3
    //   1341: aload 11
    //   1343: getfield 784	com/tencent/mm/plugin/voip/video/b/d:gtG	I
    //   1346: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1349: aastore
    //   1350: invokestatic 340	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1353: iload_3
    //   1354: aload 11
    //   1356: getfield 781	com/tencent/mm/plugin/voip/video/b/d:gtF	I
    //   1359: if_icmpne +13 -> 1372
    //   1362: aload 11
    //   1364: getfield 784	com/tencent/mm/plugin/voip/video/b/d:gtG	I
    //   1367: iload 4
    //   1369: if_icmpeq +82 -> 1451
    //   1372: aload 11
    //   1374: iload_3
    //   1375: putfield 781	com/tencent/mm/plugin/voip/video/b/d:gtF	I
    //   1378: aload 11
    //   1380: iload 4
    //   1382: putfield 784	com/tencent/mm/plugin/voip/video/b/d:gtG	I
    //   1385: aload 11
    //   1387: getfield 788	com/tencent/mm/plugin/voip/video/b/d:zxP	Lcom/tencent/mm/plugin/voip/video/b/b;
    //   1390: astore 11
    //   1392: ldc_w 774
    //   1395: ldc_w 790
    //   1398: iconst_4
    //   1399: anewarray 4	java/lang/Object
    //   1402: dup
    //   1403: iconst_0
    //   1404: iload_3
    //   1405: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1408: aastore
    //   1409: dup
    //   1410: iconst_1
    //   1411: iload 4
    //   1413: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1416: aastore
    //   1417: dup
    //   1418: iconst_2
    //   1419: aload 11
    //   1421: getfield 795	com/tencent/mm/plugin/voip/video/b/b:surfaceWidth	I
    //   1424: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1427: aastore
    //   1428: dup
    //   1429: iconst_3
    //   1430: aload 11
    //   1432: getfield 798	com/tencent/mm/plugin/voip/video/b/b:surfaceHeight	I
    //   1435: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1438: aastore
    //   1439: invokestatic 340	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1442: iload_3
    //   1443: ifle +8 -> 1451
    //   1446: iload 4
    //   1448: ifgt +228 -> 1676
    //   1451: aload_0
    //   1452: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:zvz	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1455: astore 11
    //   1457: aload_0
    //   1458: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   1461: astore 12
    //   1463: aload_0
    //   1464: getfield 433	com/tencent/mm/plugin/voip/video/OpenGlRender:zvC	I
    //   1467: istore_2
    //   1468: aload 11
    //   1470: monitorenter
    //   1471: aload 11
    //   1473: iconst_0
    //   1474: putfield 801	com/tencent/mm/plugin/voip/video/b/g:zyq	Z
    //   1477: aload 11
    //   1479: getfield 804	com/tencent/mm/plugin/voip/video/b/g:zyp	Z
    //   1482: ifeq +162 -> 1644
    //   1485: aload 12
    //   1487: ifnull +157 -> 1644
    //   1490: aload 11
    //   1492: iload_2
    //   1493: putfield 733	com/tencent/mm/plugin/voip/video/b/g:zyi	I
    //   1496: aload 11
    //   1498: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1501: aload 11
    //   1503: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1506: imul
    //   1507: iconst_3
    //   1508: imul
    //   1509: iconst_2
    //   1510: idiv
    //   1511: istore 5
    //   1513: iload_2
    //   1514: iconst_3
    //   1515: if_icmpne +327 -> 1842
    //   1518: aload 12
    //   1520: arraylength
    //   1521: iload 5
    //   1523: if_icmpne +238 -> 1761
    //   1526: aload 11
    //   1528: getfield 756	com/tencent/mm/plugin/voip/video/b/g:zyj	Ljava/nio/ByteBuffer;
    //   1531: invokevirtual 808	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1534: pop
    //   1535: aload 11
    //   1537: getfield 759	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1540: invokevirtual 808	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1543: pop
    //   1544: aload 11
    //   1546: getfield 768	com/tencent/mm/plugin/voip/video/b/g:zym	Ljava/nio/ByteBuffer;
    //   1549: invokevirtual 808	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1552: pop
    //   1553: aload 11
    //   1555: getfield 756	com/tencent/mm/plugin/voip/video/b/g:zyj	Ljava/nio/ByteBuffer;
    //   1558: aload 12
    //   1560: iconst_0
    //   1561: aload 11
    //   1563: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1566: aload 11
    //   1568: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1571: imul
    //   1572: iconst_3
    //   1573: imul
    //   1574: iconst_2
    //   1575: idiv
    //   1576: invokevirtual 811	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1579: pop
    //   1580: aload 11
    //   1582: getfield 759	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1585: aload 12
    //   1587: iconst_0
    //   1588: aload 11
    //   1590: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1593: aload 11
    //   1595: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1598: imul
    //   1599: invokevirtual 811	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1602: pop
    //   1603: aload 11
    //   1605: getfield 768	com/tencent/mm/plugin/voip/video/b/g:zym	Ljava/nio/ByteBuffer;
    //   1608: aload 12
    //   1610: aload 11
    //   1612: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1615: aload 11
    //   1617: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1620: imul
    //   1621: aload 11
    //   1623: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1626: aload 11
    //   1628: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1631: imul
    //   1632: iconst_2
    //   1633: idiv
    //   1634: invokevirtual 811	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1637: pop
    //   1638: aload 11
    //   1640: iconst_1
    //   1641: putfield 801	com/tencent/mm/plugin/voip/video/b/g:zyq	Z
    //   1644: aload 11
    //   1646: monitorexit
    //   1647: aload_0
    //   1648: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:zvz	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1651: aload_1
    //   1652: invokevirtual 813	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1655: goto -928 -> 727
    //   1658: iconst_0
    //   1659: istore 10
    //   1661: goto -712 -> 949
    //   1664: astore_1
    //   1665: aload 11
    //   1667: monitorexit
    //   1668: ldc_w 495
    //   1671: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1674: aload_1
    //   1675: athrow
    //   1676: aload 11
    //   1678: getfield 814	com/tencent/mm/plugin/voip/video/b/b:gtF	I
    //   1681: iload_3
    //   1682: if_icmpne +13 -> 1695
    //   1685: aload 11
    //   1687: getfield 815	com/tencent/mm/plugin/voip/video/b/b:gtG	I
    //   1690: iload 4
    //   1692: if_icmpeq -241 -> 1451
    //   1695: aload 11
    //   1697: iload_3
    //   1698: putfield 814	com/tencent/mm/plugin/voip/video/b/b:gtF	I
    //   1701: aload 11
    //   1703: iload 4
    //   1705: putfield 815	com/tencent/mm/plugin/voip/video/b/b:gtG	I
    //   1708: ldc_w 774
    //   1711: ldc_w 817
    //   1714: iconst_2
    //   1715: anewarray 4	java/lang/Object
    //   1718: dup
    //   1719: iconst_0
    //   1720: aload 11
    //   1722: getfield 814	com/tencent/mm/plugin/voip/video/b/b:gtF	I
    //   1725: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1728: aastore
    //   1729: dup
    //   1730: iconst_1
    //   1731: aload 11
    //   1733: getfield 815	com/tencent/mm/plugin/voip/video/b/b:gtG	I
    //   1736: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1739: aastore
    //   1740: invokestatic 340	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1743: aload 11
    //   1745: aload 11
    //   1747: getfield 814	com/tencent/mm/plugin/voip/video/b/b:gtF	I
    //   1750: aload 11
    //   1752: getfield 815	com/tencent/mm/plugin/voip/video/b/b:gtG	I
    //   1755: invokevirtual 820	com/tencent/mm/plugin/voip/video/b/b:hZ	(II)V
    //   1758: goto -307 -> 1451
    //   1761: ldc_w 735
    //   1764: ldc_w 822
    //   1767: iconst_4
    //   1768: anewarray 4	java/lang/Object
    //   1771: dup
    //   1772: iconst_0
    //   1773: aload 12
    //   1775: arraylength
    //   1776: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1779: aastore
    //   1780: dup
    //   1781: iconst_1
    //   1782: iload 5
    //   1784: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1787: aastore
    //   1788: dup
    //   1789: iconst_2
    //   1790: aload 11
    //   1792: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1795: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1798: aastore
    //   1799: dup
    //   1800: iconst_3
    //   1801: aload 11
    //   1803: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1806: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1809: aastore
    //   1810: invokestatic 492	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1813: aload 11
    //   1815: iconst_0
    //   1816: putfield 801	com/tencent/mm/plugin/voip/video/b/g:zyq	Z
    //   1819: getstatic 828	com/tencent/mm/plugin/voip/model/t:zlN	Lcom/tencent/mm/plugin/voip/model/t;
    //   1822: astore 12
    //   1824: invokestatic 831	com/tencent/mm/plugin/voip/model/t:dUq	()V
    //   1827: goto -183 -> 1644
    //   1830: astore_1
    //   1831: aload 11
    //   1833: monitorexit
    //   1834: ldc_w 495
    //   1837: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1840: aload_1
    //   1841: athrow
    //   1842: aload 11
    //   1844: aload 11
    //   1846: getfield 743	com/tencent/mm/plugin/voip/video/b/g:zyr	I
    //   1849: iconst_1
    //   1850: iadd
    //   1851: putfield 743	com/tencent/mm/plugin/voip/video/b/g:zyr	I
    //   1854: aload 11
    //   1856: getfield 743	com/tencent/mm/plugin/voip/video/b/g:zyr	I
    //   1859: bipush 100
    //   1861: irem
    //   1862: ifne +60 -> 1922
    //   1865: ldc_w 735
    //   1868: ldc_w 833
    //   1871: iconst_4
    //   1872: anewarray 4	java/lang/Object
    //   1875: dup
    //   1876: iconst_0
    //   1877: aload 11
    //   1879: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1882: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1885: aastore
    //   1886: dup
    //   1887: iconst_1
    //   1888: aload 11
    //   1890: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1893: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1896: aastore
    //   1897: dup
    //   1898: iconst_2
    //   1899: aload 11
    //   1901: getfield 743	com/tencent/mm/plugin/voip/video/b/g:zyr	I
    //   1904: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1907: aastore
    //   1908: dup
    //   1909: iconst_3
    //   1910: aload 11
    //   1912: getfield 712	com/tencent/mm/plugin/voip/video/b/g:zyo	I
    //   1915: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1918: aastore
    //   1919: invokestatic 340	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1922: aload 12
    //   1924: arraylength
    //   1925: iload 5
    //   1927: if_icmplt +192 -> 2119
    //   1930: aload 11
    //   1932: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1935: istore 6
    //   1937: aload 11
    //   1939: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1942: istore 7
    //   1944: aload 11
    //   1946: getfield 743	com/tencent/mm/plugin/voip/video/b/g:zyr	I
    //   1949: bipush 100
    //   1951: irem
    //   1952: ifne +462 -> 2414
    //   1955: aload 12
    //   1957: ifnull +452 -> 2409
    //   1960: aload 12
    //   1962: arraylength
    //   1963: iload 6
    //   1965: iload 7
    //   1967: imul
    //   1968: iconst_3
    //   1969: imul
    //   1970: iconst_2
    //   1971: idiv
    //   1972: if_icmple +437 -> 2409
    //   1975: iconst_0
    //   1976: istore_2
    //   1977: iconst_0
    //   1978: istore_3
    //   1979: goto +382 -> 2361
    //   1982: iload_2
    //   1983: ifeq +136 -> 2119
    //   1986: aload 11
    //   1988: getfield 759	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1991: invokevirtual 808	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1994: pop
    //   1995: aload 11
    //   1997: getfield 762	com/tencent/mm/plugin/voip/video/b/g:zyk	Ljava/nio/ByteBuffer;
    //   2000: invokevirtual 808	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2003: pop
    //   2004: aload 11
    //   2006: getfield 765	com/tencent/mm/plugin/voip/video/b/g:zyl	Ljava/nio/ByteBuffer;
    //   2009: invokevirtual 808	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2012: pop
    //   2013: aload 11
    //   2015: getfield 759	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   2018: aload 12
    //   2020: iconst_0
    //   2021: aload 11
    //   2023: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2026: aload 11
    //   2028: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2031: imul
    //   2032: invokevirtual 811	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2035: pop
    //   2036: aload 11
    //   2038: getfield 762	com/tencent/mm/plugin/voip/video/b/g:zyk	Ljava/nio/ByteBuffer;
    //   2041: aload 12
    //   2043: aload 11
    //   2045: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2048: aload 11
    //   2050: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2053: imul
    //   2054: aload 11
    //   2056: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2059: aload 11
    //   2061: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2064: imul
    //   2065: iconst_4
    //   2066: idiv
    //   2067: invokevirtual 811	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2070: pop
    //   2071: aload 11
    //   2073: getfield 765	com/tencent/mm/plugin/voip/video/b/g:zyl	Ljava/nio/ByteBuffer;
    //   2076: aload 12
    //   2078: aload 11
    //   2080: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2083: aload 11
    //   2085: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2088: imul
    //   2089: iconst_5
    //   2090: imul
    //   2091: iconst_4
    //   2092: idiv
    //   2093: aload 11
    //   2095: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2098: aload 11
    //   2100: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2103: imul
    //   2104: iconst_4
    //   2105: idiv
    //   2106: invokevirtual 811	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2109: pop
    //   2110: aload 11
    //   2112: iconst_1
    //   2113: putfield 801	com/tencent/mm/plugin/voip/video/b/g:zyq	Z
    //   2116: goto -472 -> 1644
    //   2119: ldc_w 735
    //   2122: ldc_w 835
    //   2125: iconst_4
    //   2126: anewarray 4	java/lang/Object
    //   2129: dup
    //   2130: iconst_0
    //   2131: aload 12
    //   2133: arraylength
    //   2134: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2137: aastore
    //   2138: dup
    //   2139: iconst_1
    //   2140: iload 5
    //   2142: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2145: aastore
    //   2146: dup
    //   2147: iconst_2
    //   2148: aload 11
    //   2150: getfield 715	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2153: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2156: aastore
    //   2157: dup
    //   2158: iconst_3
    //   2159: aload 11
    //   2161: getfield 718	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2164: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2167: aastore
    //   2168: invokestatic 492	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2171: aload 11
    //   2173: iconst_0
    //   2174: putfield 801	com/tencent/mm/plugin/voip/video/b/g:zyq	Z
    //   2177: getstatic 828	com/tencent/mm/plugin/voip/model/t:zlN	Lcom/tencent/mm/plugin/voip/model/t;
    //   2180: astore 12
    //   2182: invokestatic 838	com/tencent/mm/plugin/voip/model/t:dUr	()V
    //   2185: goto -541 -> 1644
    //   2188: aload_0
    //   2189: getfield 699	com/tencent/mm/plugin/voip/video/OpenGlRender:zvN	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2192: aload_0
    //   2193: getfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:zvM	J
    //   2196: invokestatic 703	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   2199: invokeinterface 841 3 0
    //   2204: goto -1441 -> 763
    //   2207: aload_0
    //   2208: invokestatic 505	com/tencent/mm/sdk/platformtools/bt:GC	()J
    //   2211: putfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:zvM	J
    //   2214: aload_0
    //   2215: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:zvh	Z
    //   2218: ifeq +20 -> 2238
    //   2221: aload_0
    //   2222: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:zvg	Z
    //   2225: ifeq +13 -> 2238
    //   2228: aload_0
    //   2229: getfield 259	com/tencent/mm/plugin/voip/video/OpenGlRender:zvn	Ljava/lang/ref/WeakReference;
    //   2232: invokevirtual 308	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2235: ifnonnull +63 -> 2298
    //   2238: aload_0
    //   2239: aconst_null
    //   2240: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   2243: aload_0
    //   2244: aconst_null
    //   2245: putfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:zvt	[I
    //   2248: getstatic 118	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   2251: ldc_w 843
    //   2254: iconst_3
    //   2255: anewarray 4	java/lang/Object
    //   2258: dup
    //   2259: iconst_0
    //   2260: aload_0
    //   2261: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:zvh	Z
    //   2264: invokestatic 361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2267: aastore
    //   2268: dup
    //   2269: iconst_1
    //   2270: aload_0
    //   2271: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:zvg	Z
    //   2274: invokestatic 361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2277: aastore
    //   2278: dup
    //   2279: iconst_2
    //   2280: aload_0
    //   2281: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:zvA	Z
    //   2284: invokestatic 361	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2287: aastore
    //   2288: invokestatic 499	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2291: ldc_w 495
    //   2294: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2297: return
    //   2298: aload_0
    //   2299: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:zvz	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2302: ifnull +33 -> 2335
    //   2305: aload_0
    //   2306: getfield 236	com/tencent/mm/plugin/voip/video/OpenGlRender:zvQ	Z
    //   2309: ifeq +8 -> 2317
    //   2312: aload_0
    //   2313: iconst_1
    //   2314: invokespecial 403	com/tencent/mm/plugin/voip/video/OpenGlRender:rU	(Z)V
    //   2317: aload_0
    //   2318: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:zvz	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2321: aload_1
    //   2322: invokevirtual 813	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   2325: aload_0
    //   2326: aconst_null
    //   2327: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:zvs	[B
    //   2330: aload_0
    //   2331: aconst_null
    //   2332: putfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:zvt	[I
    //   2335: aload_0
    //   2336: getfield 699	com/tencent/mm/plugin/voip/video/OpenGlRender:zvN	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2339: ifnull -1576 -> 763
    //   2342: aload_0
    //   2343: getfield 699	com/tencent/mm/plugin/voip/video/OpenGlRender:zvN	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2346: aload_0
    //   2347: getfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:zvM	J
    //   2350: invokestatic 703	com/tencent/mm/sdk/platformtools/bt:aS	(J)J
    //   2353: invokeinterface 846 3 0
    //   2358: goto -1595 -> 763
    //   2361: iload_3
    //   2362: iload 6
    //   2364: iload 7
    //   2366: imul
    //   2367: if_icmpge +28 -> 2395
    //   2370: iload_2
    //   2371: istore 4
    //   2373: aload 12
    //   2375: iload_3
    //   2376: baload
    //   2377: ifne +8 -> 2385
    //   2380: iload_2
    //   2381: iconst_1
    //   2382: iadd
    //   2383: istore 4
    //   2385: iload_3
    //   2386: iconst_1
    //   2387: iadd
    //   2388: istore_3
    //   2389: iload 4
    //   2391: istore_2
    //   2392: goto -31 -> 2361
    //   2395: iload_2
    //   2396: iload 6
    //   2398: iload 7
    //   2400: imul
    //   2401: if_icmplt +13 -> 2414
    //   2404: iconst_0
    //   2405: istore_2
    //   2406: goto -424 -> 1982
    //   2409: iconst_0
    //   2410: istore_2
    //   2411: goto -429 -> 1982
    //   2414: iconst_1
    //   2415: istore_2
    //   2416: goto -434 -> 1982
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2419	0	this	OpenGlRender
    //   0	2419	1	paramGL10	GL10
    //   123	2293	2	i	int
    //   135	2254	3	j	int
    //   846	1544	4	k	int
    //   911	1230	5	m	int
    //   899	1502	6	n	int
    //   905	1496	7	i1	int
    //   917	23	8	i2	int
    //   934	93	9	i3	int
    //   947	713	10	bool	boolean
    //   377	1795	11	localObject1	Object
    //   1461	913	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1224	1282	1664	finally
    //   1665	1668	1664	finally
    //   1471	1485	1830	finally
    //   1490	1513	1830	finally
    //   1518	1644	1830	finally
    //   1644	1647	1830	finally
    //   1761	1827	1830	finally
    //   1831	1834	1830	finally
    //   1842	1922	1830	finally
    //   1922	1955	1830	finally
    //   1960	1975	1830	finally
    //   1986	2116	1830	finally
    //   2119	2185	1830	finally
  }
  
  public final void onStarted()
  {
    AppMethodBeat.i(115659);
    this.zvh = true;
    requestRender();
    AppMethodBeat.o(115659);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115657);
    ad.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d, lastHWDecSize:%dx%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.zvA), Integer.valueOf(this.zvl), Integer.valueOf(this.zvm), Integer.valueOf(this.mRenderMode), Integer.valueOf(this.zhL), Integer.valueOf(this.zhM) });
    if ((this.zvl != paramInt1) || (this.zvm != paramInt2))
    {
      paramGL10.glViewport(0, 0, paramInt1, paramInt2);
      this.zvl = paramInt1;
      this.zvm = paramInt2;
    }
    if (this.zvy != null) {
      this.zvy.hY(paramInt1, paramInt2);
    }
    if (this.zvz != null) {
      this.zvz.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
    QR(this.zvF);
    hP(this.zhL, this.zhM);
    AppMethodBeat.o(115657);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115658);
    ad.i(TAG, "onSurfaceCreated...");
    if (getGLVersion() == 2)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glDisable(2929);
    }
    if (this.zvz != null) {
      this.zvz.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    if (v2protocal.zpw == null)
    {
      paramGL10 = e.dXC();
      try
      {
        paramGL10.zxZ = paramGL10.dXD();
        paramGL10.zxY.set(false);
        paramEGLConfig = new Surface(paramGL10.zxZ);
        v2protocal.mSurfaceTexture = paramGL10.zxZ;
        v2protocal.zpx = null;
        v2protocal.zpw = paramEGLConfig;
        paramGL10.zya.Ca();
        AppMethodBeat.o(115658);
        return;
      }
      catch (Exception paramGL10)
      {
        ad.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", paramGL10, "initSurfaceTexutre error", new Object[0]);
        paramGL10 = t.zlN;
        t.dUd();
      }
    }
    AppMethodBeat.o(115658);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115652);
    if ((this.zvn != null) && (this.zvn.get() != null))
    {
      ??? = (OpenGlView)this.zvn.get();
      ad.m(TAG, "releaseSurfaceTexture:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115641);
          ??? = e.dXC();
          try
          {
            if (((e)???).zxZ != null)
            {
              t localt2 = t.zlN;
              t.dUe();
              if (((e)???).zpx != null) {
                ((e)???).zpx.close();
              }
              ((e)???).zxZ.release();
              ((e)???).zxZ = null;
              ad.i("MicroMsg.VoipHardDecodeUtil", "uninit surface texture");
            }
          }
          catch (Exception localException1)
          {
            t localt1;
            synchronized (OpenGlRender.dXk())
            {
              try
              {
                OpenGlRender.dXk().notifyAll();
                AppMethodBeat.o(115641);
                return;
                localException1 = localException1;
                ad.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", localException1, "uninitSurfaceTexture error", new Object[0]);
                localt1 = t.zlN;
                t.dUf();
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ad.printErrStackTrace(OpenGlRender.TAG, localException2, "", new Object[0]);
                }
              }
            }
          }
          ad.i(OpenGlRender.TAG, "releaseSurfaceTexture call finish");
        }
      });
      synchronized (zvI)
      {
        try
        {
          zvI.wait(100L);
          ad.i(TAG, "releaseSurfaceTexture wait finish");
          AppMethodBeat.o(115652);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ad.printErrStackTrace(TAG, localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(115652);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115666);
    if (this.zvn.get() != null) {
      ((OpenGlView)this.zvn.get()).dXl();
    }
    AppMethodBeat.o(115666);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115665);
    ad.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.zvA), Integer.valueOf(paramInt), Integer.valueOf(this.zvB) });
    this.zvB = paramInt;
    AppMethodBeat.o(115665);
  }
  
  final class a
    extends ap
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(115646);
      OpenGlRender.this.requestRender();
      AppMethodBeat.o(115646);
    }
  }
  
  public static abstract interface b
  {
    public abstract void dWf();
    
    public abstract void uo(long paramLong);
    
    public abstract void up(long paramLong);
    
    public abstract void uq(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender
 * JD-Core Version:    0.7.0.1
 */