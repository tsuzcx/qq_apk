package com.tencent.mm.plugin.voip.video;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.a.b;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.b.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
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
  public static String TAG;
  static boolean UND;
  public static int UNe;
  private static final Object UNu;
  private static final Object UNv;
  public static final Object UNw;
  private static final Object UNx;
  public int Erd;
  boolean UMG;
  int UMH;
  long UMI;
  long UMJ;
  int UMK;
  a UML;
  boolean UMM;
  boolean UMN;
  boolean UMO;
  boolean UMP;
  boolean UMQ;
  int UMR;
  int UMS;
  public WeakReference<OpenGlView> UMT;
  public boolean UMU;
  public Bitmap UMV;
  private int UMW;
  private int UMX;
  private byte[] UMY;
  private int[] UMZ;
  long UNA;
  public b UNB;
  WeakReference<Object> UNC;
  private boolean UNE;
  boolean UNF;
  private int UNa;
  private int UNb;
  private int UNc;
  public int UNd;
  private b UNf;
  public g UNg;
  public com.tencent.mm.plugin.xlabeffect.k UNh;
  public byte[] UNi;
  public int UNj;
  public int UNk;
  public boolean UNl;
  private int UNm;
  private int UNn;
  private boolean UNo;
  private int UNp;
  private int UNq;
  private int UNr;
  private volatile boolean UNs;
  private volatile boolean UNt;
  public int UNy;
  public boolean UNz;
  public int UxE;
  public int UxF;
  public float mBrightness;
  public float mContrast;
  int mRenderMode;
  public float mSaturation;
  
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
    UNe = 0;
    UNu = new Object();
    UNv = new Object();
    UNw = new Object();
    UNx = new Object();
    UND = false;
    AppMethodBeat.o(115668);
  }
  
  public OpenGlRender(OpenGlView paramOpenGlView, int paramInt)
  {
    AppMethodBeat.i(115648);
    this.UMG = false;
    this.UMH = 0;
    this.UMI = 0L;
    this.UMJ = 0L;
    this.UMK = 0;
    this.mBrightness = 1.2F;
    this.mContrast = 1.93F;
    this.mSaturation = 1.05F;
    this.UMM = false;
    this.UMN = false;
    this.UMO = false;
    this.UMP = false;
    this.UMQ = false;
    this.UMR = 0;
    this.UMS = 0;
    this.mRenderMode = RenderLocal;
    this.UMU = false;
    this.UMV = null;
    this.UMW = 0;
    this.UMX = 0;
    this.UMY = null;
    this.UMZ = null;
    this.UNd = 0;
    this.UNf = null;
    this.UNh = null;
    this.UNl = false;
    this.UNs = false;
    this.UNt = false;
    this.Erd = 0;
    this.UNy = 0;
    this.UxE = 0;
    this.UxF = 0;
    this.UNz = false;
    this.UNA = -1L;
    this.UNE = false;
    this.UNF = false;
    if (!UND)
    {
      OpenGlRender.class.getClassLoader();
      com.tencent.mm.compatible.util.k.DA("mm_gl_disp");
      UND = true;
    }
    this.mRenderMode = paramInt;
    this.UMT = new WeakReference(paramOpenGlView);
    paramOpenGlView = Looper.myLooper();
    if (paramOpenGlView != null) {
      this.UML = new a(paramOpenGlView);
    }
    for (;;)
    {
      this.UNC = null;
      if (getGLVersion() == 2) {
        this.UNf = new b();
      }
      this.UNp = 0;
      this.UNq = 0;
      this.UNg = new g();
      this.UNm = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTd, 0);
      this.UNn = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTe, 0);
      Log.d(TAG, "WeEffect face beauty skin smooth param %d", new Object[] { Integer.valueOf(this.UNm) });
      Log.d(TAG, "WeEffect face beauty skin bright param %d", new Object[] { Integer.valueOf(this.UNn) });
      if (this.UNm < 0) {
        this.UNm = 0;
      }
      if (this.UNm >= 100) {
        this.UNm = 100;
      }
      if (this.UNn < 0) {
        this.UNn = 0;
      }
      if (this.UNn >= 100) {
        this.UNn = 100;
      }
      if ((this.UNm != 0) && (this.UNn != 0)) {
        this.UNl = true;
      }
      this.UMY = null;
      AppMethodBeat.o(115648);
      return;
      paramOpenGlView = Looper.getMainLooper();
      if (paramOpenGlView != null) {
        this.UML = new a(paramOpenGlView);
      } else {
        this.UML = null;
      }
    }
  }
  
  private void GQ(boolean paramBoolean)
  {
    AppMethodBeat.i(115664);
    if ((this.UMT != null) && (this.UMT.get() != null))
    {
      if (!paramBoolean)
      {
        ??? = (OpenGlView)this.UMT.get();
        Log.i(TAG, "attachGLContext:%s", new Object[] { ??? });
        ((OpenGlView)???).ag(new Runnable()
        {
          public final void run()
          {
            boolean bool = false;
            AppMethodBeat.i(292958);
            if (OpenGlRender.l(OpenGlRender.this))
            {
              Log.i(OpenGlRender.TAG, "attachGLContext");
              ??? = OpenGlRender.this;
              if (!OpenGlRender.f(OpenGlRender.this).idd()) {
                bool = true;
              }
              OpenGlRender.a((OpenGlRender)???, bool);
              OpenGlRender.j(OpenGlRender.this);
              OpenGlRender.k(OpenGlRender.this);
              Log.i(OpenGlRender.TAG, "attach finish");
            }
            synchronized (OpenGlRender.ico())
            {
              try
              {
                OpenGlRender.ico().notifyAll();
                AppMethodBeat.o(292958);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  Log.printErrStackTrace(OpenGlRender.TAG, localException, "", new Object[0]);
                }
              }
            }
          }
        });
        synchronized (UNv)
        {
          try
          {
            UNv.wait(100L);
            Log.i(TAG, "attachGLContext wait finish, bNeedAttach:%s", new Object[] { Boolean.valueOf(this.UNE) });
            AppMethodBeat.o(115664);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace(TAG, localException, "", new Object[0]);
            }
          }
        }
      }
      if (this.UNE)
      {
        Log.i(TAG, "attachGLContext");
        if (this.UNg.idd()) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.UNE = paramBoolean;
      this.UMY = null;
      this.UMZ = null;
      Log.i(TAG, "attach finish");
      AppMethodBeat.o(115664);
      return;
    }
  }
  
  private native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  private native void Uninit(int paramInt);
  
  public static int getGLVersion()
  {
    AppMethodBeat.i(115647);
    if (UNe == 0)
    {
      UNe = 2;
      Log.i(TAG, "init gl version: %s", new Object[] { Integer.valueOf(UNe) });
    }
    int i = UNe;
    AppMethodBeat.o(115647);
    return i;
  }
  
  private void ick()
  {
    AppMethodBeat.i(115662);
    if (this.UNf != null)
    {
      if (this.UMT != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)this.UMT.get();
        if (localOpenGlView != null)
        {
          localOpenGlView.ag(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(115645);
              if (OpenGlRender.e(OpenGlRender.this) != null) {
                OpenGlRender.e(OpenGlRender.this).destroy();
              }
              AppMethodBeat.o(115645);
            }
          });
          AppMethodBeat.o(115662);
          return;
        }
      }
      if (this.UNf != null) {
        this.UNf.destroy();
      }
    }
    AppMethodBeat.o(115662);
  }
  
  private native void render32(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void render8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setParam(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  public final void Qu()
  {
    AppMethodBeat.i(115659);
    this.UMN = true;
    requestRender();
    AppMethodBeat.o(115659);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(115653);
    if ((this.UMM) && (this.UMY == null))
    {
      this.UNa = paramInt1;
      this.UNb = paramInt2;
      this.UNc = paramInt3;
      this.UMY = paramArrayOfByte;
      this.UNo = paramBoolean;
      this.UNr = paramInt4;
      requestRender();
    }
    AppMethodBeat.o(115653);
  }
  
  public final void b(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(292927);
    if ((this.UMM) && (this.UMZ == null))
    {
      this.UNa = paramInt1;
      this.UNb = paramInt2;
      this.UNc = paramInt3;
      this.UMZ = paramArrayOfInt;
      this.UNo = false;
      requestRender();
    }
    AppMethodBeat.o(292927);
  }
  
  public final void iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115656);
    Log.i(TAG, "video=" + paramInt1 + "x" + paramInt2);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.UxE = paramInt1;
      this.UxF = paramInt2;
      if (this.UNg != null) {
        this.UNg.mM(paramInt1, paramInt2);
      }
      AppMethodBeat.o(115656);
      return;
    }
    Log.e(TAG, "ERROR video size:%dx%d, lastviddeosize:%dx%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.UxE), Integer.valueOf(this.UxF) });
    AppMethodBeat.o(115656);
  }
  
  public final void ici()
  {
    AppMethodBeat.i(115660);
    Log.i(TAG, "%s onStop, renderMode: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
    this.UMN = false;
    this.UMQ = false;
    AppMethodBeat.o(115660);
  }
  
  public final void icj()
  {
    AppMethodBeat.i(115661);
    Log.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.UMM), Boolean.valueOf(this.UMN) });
    if ((this.UMM) && (this.UMN))
    {
      Log.i(TAG, "%s steve: Reset GLRender first! mode=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
      if (this.UNg != null)
      {
        Log.i(TAG, "onResetRender need detach");
        this.UNF = true;
        icl();
      }
      this.UMM = false;
      this.UMN = false;
      ick();
    }
    AppMethodBeat.o(115661);
  }
  
  final void icl()
  {
    AppMethodBeat.i(115663);
    if ((this.UMT != null) && (this.UMT.get() != null))
    {
      ??? = (OpenGlView)this.UMT.get();
      Log.i(TAG, "detachGLContext:%s", new Object[] { ??? });
      ((OpenGlView)???).ag(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(161661);
          if (OpenGlRender.h(OpenGlRender.this))
          {
            OpenGlRender.f(OpenGlRender.this).ide();
            OpenGlRender.i(OpenGlRender.this);
            OpenGlRender.j(OpenGlRender.this);
            OpenGlRender.k(OpenGlRender.this);
            Log.i(OpenGlRender.TAG, "detach finish");
          }
          synchronized (OpenGlRender.icn())
          {
            try
            {
              OpenGlRender.icn().notifyAll();
              AppMethodBeat.o(161661);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                Log.printErrStackTrace(OpenGlRender.TAG, localException, "", new Object[0]);
              }
            }
          }
        }
      });
      synchronized (UNu)
      {
        try
        {
          UNu.wait(100L);
          Log.i(TAG, "detachGLContext wait finish, bNeedDetach:%s", new Object[] { Boolean.valueOf(this.UNF) });
          AppMethodBeat.o(115663);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.printErrStackTrace(TAG, localException, "", new Object[0]);
          }
        }
      }
    }
    if (this.UNF) {
      ((OpenGlView)this.UMT.get()).ag(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292952);
          OpenGlRender.f(OpenGlRender.this).ide();
          OpenGlRender.i(OpenGlRender.this);
          OpenGlRender.j(OpenGlRender.this);
          OpenGlRender.k(OpenGlRender.this);
          Log.i(OpenGlRender.TAG, "detach finish");
          AppMethodBeat.o(292952);
        }
      });
    }
    AppMethodBeat.o(115663);
  }
  
  /* Error */
  public final void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: ldc_w 527
    //   3: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 240	com/tencent/mm/plugin/voip/video/OpenGlRender:Erd	I
    //   10: ifne +2478 -> 2488
    //   13: aload_0
    //   14: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:UMN	Z
    //   17: ifeq +20 -> 37
    //   20: aload_0
    //   21: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:UMM	Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 277	com/tencent/mm/plugin/voip/video/OpenGlRender:UMT	Ljava/lang/ref/WeakReference;
    //   31: invokevirtual 358	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   34: ifnonnull +63 -> 97
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:UMZ	[I
    //   47: getstatic 130	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   50: ldc_w 529
    //   53: iconst_3
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:UMN	Z
    //   63: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_0
    //   70: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:UMM	Z
    //   73: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: aload_0
    //   80: getfield 465	com/tencent/mm/plugin/voip/video/OpenGlRender:UNo	Z
    //   83: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 527
    //   93: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: aload_0
    //   98: getfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   101: ifnull +770 -> 871
    //   104: aload_0
    //   105: invokestatic 535	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   108: putfield 252	com/tencent/mm/plugin/voip/video/OpenGlRender:UNA	J
    //   111: aload_0
    //   112: getfield 463	com/tencent/mm/plugin/voip/video/OpenGlRender:UNc	I
    //   115: getstatic 154	com/tencent/mm/plugin/voip/video/OpenGlRender:FLAG_Mirror	I
    //   118: iand
    //   119: ifeq +787 -> 906
    //   122: iconst_1
    //   123: istore_2
    //   124: aload_0
    //   125: getfield 299	com/tencent/mm/plugin/voip/video/OpenGlRender:UNp	I
    //   128: bipush 8
    //   130: iand
    //   131: ifeq +780 -> 911
    //   134: iconst_1
    //   135: istore_3
    //   136: aload_0
    //   137: getfield 299	com/tencent/mm/plugin/voip/video/OpenGlRender:UNp	I
    //   140: ifne +776 -> 916
    //   143: iconst_0
    //   144: istore 4
    //   146: aload_0
    //   147: iload 4
    //   149: putfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:UNq	I
    //   152: aload_0
    //   153: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:UNq	I
    //   156: iconst_1
    //   157: iand
    //   158: ifeq +767 -> 925
    //   161: iconst_1
    //   162: istore 4
    //   164: aload_0
    //   165: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:UNf	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   168: ifnull +827 -> 995
    //   171: aload_0
    //   172: getfield 465	com/tencent/mm/plugin/voip/video/OpenGlRender:UNo	Z
    //   175: ifeq +820 -> 995
    //   178: aload_0
    //   179: getfield 299	com/tencent/mm/plugin/voip/video/OpenGlRender:UNp	I
    //   182: ifeq +813 -> 995
    //   185: iload_3
    //   186: ifne +809 -> 995
    //   189: aload_0
    //   190: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:UNf	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   193: astore_1
    //   194: aload_0
    //   195: getfield 299	com/tencent/mm/plugin/voip/video/OpenGlRender:UNp	I
    //   198: istore_3
    //   199: aload_0
    //   200: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:UNq	I
    //   203: istore 4
    //   205: aload_1
    //   206: getfield 538	com/tencent/mm/plugin/voip/video/a/b:mGp	Z
    //   209: ifne +579 -> 788
    //   212: aload_1
    //   213: ldc_w 540
    //   216: ldc_w 542
    //   219: invokestatic 546	com/tencent/mm/plugin/voip/video/a/b:aN	(Ljava/lang/String;Ljava/lang/String;)I
    //   222: putfield 549	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   225: aload_1
    //   226: getfield 549	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   229: ifne +12 -> 241
    //   232: ldc_w 551
    //   235: ldc_w 553
    //   238: invokestatic 555	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_1
    //   242: aload_1
    //   243: getfield 549	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   246: ldc_w 557
    //   249: invokestatic 563	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   252: putfield 566	com/tencent/mm/plugin/voip/video/a/b:nEE	I
    //   255: aload_1
    //   256: aload_1
    //   257: getfield 549	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   260: ldc_w 568
    //   263: invokestatic 563	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   266: putfield 571	com/tencent/mm/plugin/voip/video/a/b:nED	I
    //   269: aload_1
    //   270: aload_1
    //   271: getfield 549	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   274: ldc_w 573
    //   277: invokestatic 576	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   280: putfield 579	com/tencent/mm/plugin/voip/video/a/b:nEF	I
    //   283: aload_1
    //   284: aload_1
    //   285: getfield 549	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   288: ldc_w 581
    //   291: invokestatic 576	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   294: putfield 584	com/tencent/mm/plugin/voip/video/a/b:nEP	I
    //   297: aload_1
    //   298: aload_1
    //   299: getfield 549	com/tencent/mm/plugin/voip/video/a/b:nEC	I
    //   302: ldc_w 586
    //   305: invokestatic 576	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   308: putfield 589	com/tencent/mm/plugin/voip/video/a/b:nEI	I
    //   311: aload_1
    //   312: invokestatic 593	com/tencent/mm/plugin/voip/video/a/b:icO	()Lcom/tencent/mm/media/g/d;
    //   315: putfield 597	com/tencent/mm/plugin/voip/video/a/b:UPf	Lcom/tencent/mm/media/g/d;
    //   318: aload_1
    //   319: invokestatic 593	com/tencent/mm/plugin/voip/video/a/b:icO	()Lcom/tencent/mm/media/g/d;
    //   322: putfield 600	com/tencent/mm/plugin/voip/video/a/b:UPg	Lcom/tencent/mm/media/g/d;
    //   325: aload_1
    //   326: ldc_w 540
    //   329: ldc_w 602
    //   332: invokestatic 546	com/tencent/mm/plugin/voip/video/a/b:aN	(Ljava/lang/String;Ljava/lang/String;)I
    //   335: putfield 605	com/tencent/mm/plugin/voip/video/a/b:UPh	I
    //   338: aload_1
    //   339: aload_1
    //   340: getfield 605	com/tencent/mm/plugin/voip/video/a/b:UPh	I
    //   343: ldc_w 557
    //   346: invokestatic 563	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   349: putfield 608	com/tencent/mm/plugin/voip/video/a/b:UPk	I
    //   352: aload_1
    //   353: aload_1
    //   354: getfield 605	com/tencent/mm/plugin/voip/video/a/b:UPh	I
    //   357: ldc_w 568
    //   360: invokestatic 563	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   363: putfield 611	com/tencent/mm/plugin/voip/video/a/b:UPj	I
    //   366: aload_1
    //   367: aload_1
    //   368: getfield 605	com/tencent/mm/plugin/voip/video/a/b:UPh	I
    //   371: ldc_w 613
    //   374: invokestatic 576	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   377: putfield 616	com/tencent/mm/plugin/voip/video/a/b:UPl	I
    //   380: aload_1
    //   381: new 618	com/tencent/mm/plugin/voip/video/render/k
    //   384: dup
    //   385: iconst_0
    //   386: iconst_0
    //   387: iconst_0
    //   388: iconst_0
    //   389: iconst_0
    //   390: iconst_0
    //   391: iconst_2
    //   392: invokespecial 621	com/tencent/mm/plugin/voip/video/render/k:<init>	(IIIIIII)V
    //   395: putfield 625	com/tencent/mm/plugin/voip/video/a/b:UPD	Lcom/tencent/mm/plugin/voip/video/render/n;
    //   398: aload_1
    //   399: aload_1
    //   400: getfield 605	com/tencent/mm/plugin/voip/video/a/b:UPh	I
    //   403: ldc_w 586
    //   406: invokestatic 576	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   409: putfield 628	com/tencent/mm/plugin/voip/video/a/b:UPm	I
    //   412: aload_1
    //   413: invokestatic 593	com/tencent/mm/plugin/voip/video/a/b:icO	()Lcom/tencent/mm/media/g/d;
    //   416: putfield 631	com/tencent/mm/plugin/voip/video/a/b:UPi	Lcom/tencent/mm/media/g/d;
    //   419: aload_1
    //   420: invokestatic 593	com/tencent/mm/plugin/voip/video/a/b:icO	()Lcom/tencent/mm/media/g/d;
    //   423: putfield 634	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   426: getstatic 638	com/tencent/mm/plugin/voip/video/a/b:nFt	[F
    //   429: astore 12
    //   431: aload_1
    //   432: aload 12
    //   434: aload 12
    //   436: arraylength
    //   437: invokestatic 644	java/util/Arrays:copyOf	([FI)[F
    //   440: putfield 647	com/tencent/mm/plugin/voip/video/a/b:qpK	[F
    //   443: aload_1
    //   444: aload_1
    //   445: getfield 647	com/tencent/mm/plugin/voip/video/a/b:qpK	[F
    //   448: arraylength
    //   449: iconst_4
    //   450: imul
    //   451: invokestatic 653	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   454: invokestatic 659	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   457: invokevirtual 663	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   460: invokevirtual 667	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   463: putfield 671	com/tencent/mm/plugin/voip/video/a/b:mVV	Ljava/nio/FloatBuffer;
    //   466: aload_1
    //   467: getfield 671	com/tencent/mm/plugin/voip/video/a/b:mVV	Ljava/nio/FloatBuffer;
    //   470: aload_1
    //   471: getfield 647	com/tencent/mm/plugin/voip/video/a/b:qpK	[F
    //   474: invokevirtual 677	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   477: pop
    //   478: aload_1
    //   479: getfield 671	com/tencent/mm/plugin/voip/video/a/b:mVV	Ljava/nio/FloatBuffer;
    //   482: iconst_0
    //   483: invokevirtual 681	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   486: pop
    //   487: aload_1
    //   488: getstatic 684	com/tencent/mm/plugin/voip/video/a/b:nFu	[F
    //   491: arraylength
    //   492: iconst_4
    //   493: imul
    //   494: invokestatic 653	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   497: invokestatic 659	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   500: invokevirtual 663	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   503: invokevirtual 667	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   506: putfield 687	com/tencent/mm/plugin/voip/video/a/b:mVU	Ljava/nio/FloatBuffer;
    //   509: aload_1
    //   510: getfield 687	com/tencent/mm/plugin/voip/video/a/b:mVU	Ljava/nio/FloatBuffer;
    //   513: getstatic 684	com/tencent/mm/plugin/voip/video/a/b:nFu	[F
    //   516: invokevirtual 677	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   519: pop
    //   520: aload_1
    //   521: getfield 687	com/tencent/mm/plugin/voip/video/a/b:mVU	Ljava/nio/FloatBuffer;
    //   524: iconst_0
    //   525: invokevirtual 681	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   528: pop
    //   529: getstatic 690	com/tencent/mm/plugin/voip/video/a/b:UPe	[F
    //   532: astore 12
    //   534: aload_1
    //   535: aload 12
    //   537: aload 12
    //   539: arraylength
    //   540: invokestatic 644	java/util/Arrays:copyOf	([FI)[F
    //   543: putfield 693	com/tencent/mm/plugin/voip/video/a/b:UPr	[F
    //   546: aload_1
    //   547: aload_1
    //   548: getfield 693	com/tencent/mm/plugin/voip/video/a/b:UPr	[F
    //   551: arraylength
    //   552: iconst_4
    //   553: imul
    //   554: invokestatic 653	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   557: invokestatic 659	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   560: invokevirtual 663	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   563: invokevirtual 667	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   566: putfield 696	com/tencent/mm/plugin/voip/video/a/b:UPn	Ljava/nio/FloatBuffer;
    //   569: aload_1
    //   570: getfield 696	com/tencent/mm/plugin/voip/video/a/b:UPn	Ljava/nio/FloatBuffer;
    //   573: aload_1
    //   574: getfield 693	com/tencent/mm/plugin/voip/video/a/b:UPr	[F
    //   577: invokevirtual 677	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   580: pop
    //   581: aload_1
    //   582: getfield 696	com/tencent/mm/plugin/voip/video/a/b:UPn	Ljava/nio/FloatBuffer;
    //   585: iconst_0
    //   586: invokevirtual 681	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   589: pop
    //   590: getstatic 638	com/tencent/mm/plugin/voip/video/a/b:nFt	[F
    //   593: astore 12
    //   595: aload_1
    //   596: aload 12
    //   598: aload 12
    //   600: arraylength
    //   601: invokestatic 644	java/util/Arrays:copyOf	([FI)[F
    //   604: putfield 699	com/tencent/mm/plugin/voip/video/a/b:UPq	[F
    //   607: aload_1
    //   608: aload_1
    //   609: getfield 699	com/tencent/mm/plugin/voip/video/a/b:UPq	[F
    //   612: arraylength
    //   613: iconst_4
    //   614: imul
    //   615: invokestatic 653	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   618: invokestatic 659	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   621: invokevirtual 663	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   624: invokevirtual 667	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   627: putfield 702	com/tencent/mm/plugin/voip/video/a/b:UPo	Ljava/nio/FloatBuffer;
    //   630: aload_1
    //   631: getfield 702	com/tencent/mm/plugin/voip/video/a/b:UPo	Ljava/nio/FloatBuffer;
    //   634: aload_1
    //   635: getfield 699	com/tencent/mm/plugin/voip/video/a/b:UPq	[F
    //   638: invokevirtual 677	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   641: pop
    //   642: aload_1
    //   643: getfield 702	com/tencent/mm/plugin/voip/video/a/b:UPo	Ljava/nio/FloatBuffer;
    //   646: iconst_0
    //   647: invokevirtual 681	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   650: pop
    //   651: aload_1
    //   652: invokestatic 706	com/tencent/mm/plugin/voip/video/a/b:icP	()Lcom/tencent/mm/media/g/a;
    //   655: putfield 710	com/tencent/mm/plugin/voip/video/a/b:UPs	Lcom/tencent/mm/media/g/a;
    //   658: aload_1
    //   659: aconst_null
    //   660: putfield 713	com/tencent/mm/plugin/voip/video/a/b:UPB	[B
    //   663: aload_1
    //   664: invokestatic 706	com/tencent/mm/plugin/voip/video/a/b:icP	()Lcom/tencent/mm/media/g/a;
    //   667: putfield 716	com/tencent/mm/plugin/voip/video/a/b:UPt	Lcom/tencent/mm/media/g/a;
    //   670: aload_1
    //   671: invokestatic 593	com/tencent/mm/plugin/voip/video/a/b:icO	()Lcom/tencent/mm/media/g/d;
    //   674: putfield 719	com/tencent/mm/plugin/voip/video/a/b:mWs	Lcom/tencent/mm/media/g/d;
    //   677: iload 4
    //   679: ifeq +45 -> 724
    //   682: aload_1
    //   683: iload 4
    //   685: putfield 722	com/tencent/mm/plugin/voip/video/a/b:UPE	I
    //   688: aload_1
    //   689: new 724	com/tencent/mm/cm/a/j
    //   692: dup
    //   693: invokespecial 725	com/tencent/mm/cm/a/j:<init>	()V
    //   696: putfield 729	com/tencent/mm/plugin/voip/video/a/b:UPF	Lcom/tencent/mm/cm/a/j;
    //   699: aload_1
    //   700: invokestatic 593	com/tencent/mm/plugin/voip/video/a/b:icO	()Lcom/tencent/mm/media/g/d;
    //   703: putfield 732	com/tencent/mm/plugin/voip/video/a/b:UPv	Lcom/tencent/mm/media/g/d;
    //   706: aload_1
    //   707: new 734	com/tencent/mm/cm/a/e
    //   710: dup
    //   711: invokespecial 735	com/tencent/mm/cm/a/e:<init>	()V
    //   714: putfield 739	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   717: aload_1
    //   718: getfield 739	com/tencent/mm/plugin/voip/video/a/b:UPK	Lcom/tencent/mm/cm/a/e;
    //   721: invokevirtual 742	com/tencent/mm/cm/a/e:apC	()V
    //   724: iload_3
    //   725: ifeq +35 -> 760
    //   728: iload 4
    //   730: ifeq +201 -> 931
    //   733: aload_1
    //   734: new 744	com/tencent/mm/plugin/voip/video/a/a
    //   737: dup
    //   738: invokespecial 745	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   741: putfield 749	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   744: aload_1
    //   745: getfield 749	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   748: aload_1
    //   749: getfield 732	com/tencent/mm/plugin/voip/video/a/b:UPv	Lcom/tencent/mm/media/g/d;
    //   752: aload_1
    //   753: getfield 719	com/tencent/mm/plugin/voip/video/a/b:mWs	Lcom/tencent/mm/media/g/d;
    //   756: iload_3
    //   757: invokevirtual 752	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/g/d;Lcom/tencent/mm/media/g/d;I)V
    //   760: ldc_w 551
    //   763: ldc_w 754
    //   766: iconst_1
    //   767: anewarray 4	java/lang/Object
    //   770: dup
    //   771: iconst_0
    //   772: aload_1
    //   773: invokevirtual 504	java/lang/Object:hashCode	()I
    //   776: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   779: aastore
    //   780: invokestatic 364	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   783: aload_1
    //   784: iconst_1
    //   785: putfield 538	com/tencent/mm/plugin/voip/video/a/b:mGp	Z
    //   788: aload_0
    //   789: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:UNf	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   792: aload_0
    //   793: getfield 210	com/tencent/mm/plugin/voip/video/OpenGlRender:UMR	I
    //   796: aload_0
    //   797: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:UMS	I
    //   800: invokevirtual 757	com/tencent/mm/plugin/voip/video/a/b:mh	(II)V
    //   803: iload_2
    //   804: ifne +157 -> 961
    //   807: aload_0
    //   808: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:UNf	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   811: aload_0
    //   812: getfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   815: aload_0
    //   816: getfield 459	com/tencent/mm/plugin/voip/video/OpenGlRender:UNa	I
    //   819: aload_0
    //   820: getfield 461	com/tencent/mm/plugin/voip/video/OpenGlRender:UNb	I
    //   823: aload_0
    //   824: getfield 463	com/tencent/mm/plugin/voip/video/OpenGlRender:UNc	I
    //   827: iconst_0
    //   828: aload_0
    //   829: getfield 228	com/tencent/mm/plugin/voip/video/OpenGlRender:UNd	I
    //   832: invokevirtual 760	com/tencent/mm/plugin/voip/video/a/b:b	([BIIIII)V
    //   835: aload_0
    //   836: aconst_null
    //   837: putfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   840: aload_0
    //   841: getfield 762	com/tencent/mm/plugin/voip/video/OpenGlRender:UNB	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   844: ifnull +27 -> 871
    //   847: aload_0
    //   848: getfield 467	com/tencent/mm/plugin/voip/video/OpenGlRender:UNr	I
    //   851: iconst_3
    //   852: if_icmpne +1617 -> 2469
    //   855: aload_0
    //   856: getfield 762	com/tencent/mm/plugin/voip/video/OpenGlRender:UNB	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   859: aload_0
    //   860: getfield 252	com/tencent/mm/plugin/voip/video/OpenGlRender:UNA	J
    //   863: invokestatic 766	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   866: invokeinterface 769 3 0
    //   871: aload_0
    //   872: getfield 248	com/tencent/mm/plugin/voip/video/OpenGlRender:UNz	Z
    //   875: ifeq +24 -> 899
    //   878: aload_0
    //   879: getfield 762	com/tencent/mm/plugin/voip/video/OpenGlRender:UNB	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   882: ifnull +17 -> 899
    //   885: aload_0
    //   886: iconst_0
    //   887: putfield 248	com/tencent/mm/plugin/voip/video/OpenGlRender:UNz	Z
    //   890: aload_0
    //   891: getfield 762	com/tencent/mm/plugin/voip/video/OpenGlRender:UNB	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   894: invokeinterface 772 1 0
    //   899: ldc_w 527
    //   902: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   905: return
    //   906: iconst_0
    //   907: istore_2
    //   908: goto -784 -> 124
    //   911: iconst_0
    //   912: istore_3
    //   913: goto -777 -> 136
    //   916: aload_0
    //   917: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:UNq	I
    //   920: istore 4
    //   922: goto -776 -> 146
    //   925: iconst_0
    //   926: istore 4
    //   928: goto -764 -> 164
    //   931: aload_1
    //   932: new 744	com/tencent/mm/plugin/voip/video/a/a
    //   935: dup
    //   936: invokespecial 745	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   939: putfield 749	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   942: aload_1
    //   943: getfield 749	com/tencent/mm/plugin/voip/video/a/b:UPy	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   946: aload_1
    //   947: getfield 634	com/tencent/mm/plugin/voip/video/a/b:UPu	Lcom/tencent/mm/media/g/d;
    //   950: aload_1
    //   951: getfield 719	com/tencent/mm/plugin/voip/video/a/b:mWs	Lcom/tencent/mm/media/g/d;
    //   954: iload_3
    //   955: invokevirtual 752	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/g/d;Lcom/tencent/mm/media/g/d;I)V
    //   958: goto -198 -> 760
    //   961: aload_0
    //   962: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:UNf	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   965: aload_0
    //   966: getfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   969: aload_0
    //   970: getfield 459	com/tencent/mm/plugin/voip/video/OpenGlRender:UNa	I
    //   973: aload_0
    //   974: getfield 461	com/tencent/mm/plugin/voip/video/OpenGlRender:UNb	I
    //   977: aload_0
    //   978: getfield 463	com/tencent/mm/plugin/voip/video/OpenGlRender:UNc	I
    //   981: aload_0
    //   982: getfield 299	com/tencent/mm/plugin/voip/video/OpenGlRender:UNp	I
    //   985: aload_0
    //   986: getfield 228	com/tencent/mm/plugin/voip/video/OpenGlRender:UNd	I
    //   989: invokevirtual 760	com/tencent/mm/plugin/voip/video/a/b:b	([BIIIII)V
    //   992: goto -157 -> 835
    //   995: aload_0
    //   996: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   999: ifnull -164 -> 835
    //   1002: aload_0
    //   1003: getfield 465	com/tencent/mm/plugin/voip/video/OpenGlRender:UNo	Z
    //   1006: ifeq +1636 -> 2642
    //   1009: iload_3
    //   1010: ifne +8 -> 1018
    //   1013: iload 4
    //   1015: ifeq +1627 -> 2642
    //   1018: aload_0
    //   1019: getfield 299	com/tencent/mm/plugin/voip/video/OpenGlRender:UNp	I
    //   1022: aload_0
    //   1023: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:UNq	I
    //   1026: iconst_5
    //   1027: ishl
    //   1028: iadd
    //   1029: istore_2
    //   1030: aload_0
    //   1031: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1034: iconst_0
    //   1035: invokevirtual 775	com/tencent/mm/plugin/voip/video/b/g:art	(I)V
    //   1038: aload_0
    //   1039: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1042: astore 12
    //   1044: aload_0
    //   1045: getfield 459	com/tencent/mm/plugin/voip/video/OpenGlRender:UNa	I
    //   1048: istore_3
    //   1049: aload_0
    //   1050: getfield 461	com/tencent/mm/plugin/voip/video/OpenGlRender:UNb	I
    //   1053: istore 4
    //   1055: aload_0
    //   1056: getfield 210	com/tencent/mm/plugin/voip/video/OpenGlRender:UMR	I
    //   1059: istore 6
    //   1061: aload_0
    //   1062: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:UMS	I
    //   1065: istore 7
    //   1067: aload_0
    //   1068: getfield 467	com/tencent/mm/plugin/voip/video/OpenGlRender:UNr	I
    //   1071: istore 5
    //   1073: aload_0
    //   1074: getfield 463	com/tencent/mm/plugin/voip/video/OpenGlRender:UNc	I
    //   1077: istore 8
    //   1079: aload_0
    //   1080: getfield 228	com/tencent/mm/plugin/voip/video/OpenGlRender:UNd	I
    //   1083: istore 9
    //   1085: iload_3
    //   1086: ifle +580 -> 1666
    //   1089: iload 4
    //   1091: ifle +575 -> 1666
    //   1094: iload 8
    //   1096: iconst_2
    //   1097: ishr
    //   1098: iconst_3
    //   1099: iand
    //   1100: istore 10
    //   1102: iload 8
    //   1104: iconst_4
    //   1105: ishr
    //   1106: iconst_1
    //   1107: iand
    //   1108: iconst_1
    //   1109: if_icmpne +830 -> 1939
    //   1112: iconst_1
    //   1113: istore 11
    //   1115: aload 12
    //   1117: iload_2
    //   1118: putfield 778	com/tencent/mm/plugin/voip/video/b/g:URa	I
    //   1121: aload 12
    //   1123: iload_2
    //   1124: iconst_5
    //   1125: ishr
    //   1126: putfield 781	com/tencent/mm/plugin/voip/video/b/g:URb	I
    //   1129: iload_3
    //   1130: aload 12
    //   1132: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1135: if_icmpne +73 -> 1208
    //   1138: iload 4
    //   1140: aload 12
    //   1142: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1145: if_icmpne +63 -> 1208
    //   1148: iload 6
    //   1150: aload 12
    //   1152: getfield 790	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   1155: if_icmpne +53 -> 1208
    //   1158: iload 7
    //   1160: aload 12
    //   1162: getfield 793	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   1165: if_icmpne +43 -> 1208
    //   1168: aload 12
    //   1170: getfield 796	com/tencent/mm/plugin/voip/video/b/g:RXR	I
    //   1173: iload 10
    //   1175: if_icmpne +33 -> 1208
    //   1178: aload 12
    //   1180: getfield 799	com/tencent/mm/plugin/voip/video/b/g:UQZ	Z
    //   1183: iload 11
    //   1185: if_icmpne +23 -> 1208
    //   1188: aload 12
    //   1190: getfield 802	com/tencent/mm/plugin/voip/video/b/g:UQU	I
    //   1193: iload 5
    //   1195: if_icmpne +13 -> 1208
    //   1198: aload 12
    //   1200: getfield 805	com/tencent/mm/plugin/voip/video/b/g:URg	I
    //   1203: iload 9
    //   1205: if_icmpeq +461 -> 1666
    //   1208: aload 12
    //   1210: iload 10
    //   1212: putfield 796	com/tencent/mm/plugin/voip/video/b/g:RXR	I
    //   1215: aload 12
    //   1217: iload 11
    //   1219: putfield 799	com/tencent/mm/plugin/voip/video/b/g:UQZ	Z
    //   1222: aload 12
    //   1224: iload 5
    //   1226: putfield 802	com/tencent/mm/plugin/voip/video/b/g:UQU	I
    //   1229: aload 12
    //   1231: iload 9
    //   1233: putfield 805	com/tencent/mm/plugin/voip/video/b/g:URg	I
    //   1236: ldc_w 807
    //   1239: ldc_w 809
    //   1242: bipush 12
    //   1244: anewarray 4	java/lang/Object
    //   1247: dup
    //   1248: iconst_0
    //   1249: iload 5
    //   1251: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1254: aastore
    //   1255: dup
    //   1256: iconst_1
    //   1257: aload 12
    //   1259: getfield 796	com/tencent/mm/plugin/voip/video/b/g:RXR	I
    //   1262: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1265: aastore
    //   1266: dup
    //   1267: iconst_2
    //   1268: aload 12
    //   1270: getfield 799	com/tencent/mm/plugin/voip/video/b/g:UQZ	Z
    //   1273: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1276: aastore
    //   1277: dup
    //   1278: iconst_3
    //   1279: iload_3
    //   1280: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1283: aastore
    //   1284: dup
    //   1285: iconst_4
    //   1286: iload 4
    //   1288: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1291: aastore
    //   1292: dup
    //   1293: iconst_5
    //   1294: iload 6
    //   1296: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1299: aastore
    //   1300: dup
    //   1301: bipush 6
    //   1303: iload 7
    //   1305: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1308: aastore
    //   1309: dup
    //   1310: bipush 7
    //   1312: aload 12
    //   1314: getfield 812	com/tencent/mm/plugin/voip/video/b/g:mWk	I
    //   1317: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1320: aastore
    //   1321: dup
    //   1322: bipush 8
    //   1324: aload 12
    //   1326: getfield 815	com/tencent/mm/plugin/voip/video/b/g:URe	I
    //   1329: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1332: aastore
    //   1333: dup
    //   1334: bipush 9
    //   1336: aload 12
    //   1338: getfield 818	com/tencent/mm/plugin/voip/video/b/g:URf	I
    //   1341: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1344: aastore
    //   1345: dup
    //   1346: bipush 10
    //   1348: iload_2
    //   1349: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1352: aastore
    //   1353: dup
    //   1354: bipush 11
    //   1356: aload 12
    //   1358: getfield 805	com/tencent/mm/plugin/voip/video/b/g:URg	I
    //   1361: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1364: aastore
    //   1365: invokestatic 364	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1368: aload 12
    //   1370: iload_3
    //   1371: putfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1374: aload 12
    //   1376: iload 4
    //   1378: putfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1381: aload 12
    //   1383: iload 6
    //   1385: putfield 790	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   1388: aload 12
    //   1390: iload 7
    //   1392: putfield 793	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   1395: aload 12
    //   1397: aload 12
    //   1399: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1402: aload 12
    //   1404: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1407: aload 12
    //   1409: getfield 805	com/tencent/mm/plugin/voip/video/b/g:URg	I
    //   1412: invokevirtual 822	com/tencent/mm/plugin/voip/video/b/g:bk	(III)V
    //   1415: iload_3
    //   1416: iload 4
    //   1418: imul
    //   1419: istore_2
    //   1420: iload_2
    //   1421: iconst_4
    //   1422: idiv
    //   1423: istore 6
    //   1425: aload 12
    //   1427: monitorenter
    //   1428: aload 12
    //   1430: iload 6
    //   1432: iconst_2
    //   1433: imul
    //   1434: iload_2
    //   1435: iadd
    //   1436: invokestatic 825	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1439: putfield 829	com/tencent/mm/plugin/voip/video/b/g:UQV	Ljava/nio/ByteBuffer;
    //   1442: aload 12
    //   1444: iload_2
    //   1445: invokestatic 825	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1448: putfield 832	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1451: aload 12
    //   1453: iload 6
    //   1455: invokestatic 825	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1458: putfield 835	com/tencent/mm/plugin/voip/video/b/g:UQW	Ljava/nio/ByteBuffer;
    //   1461: aload 12
    //   1463: iload 6
    //   1465: invokestatic 825	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1468: putfield 838	com/tencent/mm/plugin/voip/video/b/g:UQX	Ljava/nio/ByteBuffer;
    //   1471: aload 12
    //   1473: iload 6
    //   1475: iconst_2
    //   1476: imul
    //   1477: invokestatic 825	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1480: putfield 841	com/tencent/mm/plugin/voip/video/b/g:UQY	Ljava/nio/ByteBuffer;
    //   1483: aload 12
    //   1485: monitorexit
    //   1486: aload 12
    //   1488: getfield 845	com/tencent/mm/plugin/voip/video/b/g:UQP	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1491: ifnull +175 -> 1666
    //   1494: iload 5
    //   1496: iconst_3
    //   1497: if_icmpne +169 -> 1666
    //   1500: aload 12
    //   1502: getfield 845	com/tencent/mm/plugin/voip/video/b/g:UQP	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1505: astore 12
    //   1507: ldc_w 847
    //   1510: ldc_w 849
    //   1513: iconst_4
    //   1514: anewarray 4	java/lang/Object
    //   1517: dup
    //   1518: iconst_0
    //   1519: iload_3
    //   1520: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1523: aastore
    //   1524: dup
    //   1525: iconst_1
    //   1526: iload 4
    //   1528: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1531: aastore
    //   1532: dup
    //   1533: iconst_2
    //   1534: aload 12
    //   1536: getfield 854	com/tencent/mm/plugin/voip/video/b/d:outputWidth	I
    //   1539: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1542: aastore
    //   1543: dup
    //   1544: iconst_3
    //   1545: aload 12
    //   1547: getfield 857	com/tencent/mm/plugin/voip/video/b/d:outputHeight	I
    //   1550: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1553: aastore
    //   1554: invokestatic 364	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1557: iload_3
    //   1558: aload 12
    //   1560: getfield 854	com/tencent/mm/plugin/voip/video/b/d:outputWidth	I
    //   1563: if_icmpne +13 -> 1576
    //   1566: aload 12
    //   1568: getfield 857	com/tencent/mm/plugin/voip/video/b/d:outputHeight	I
    //   1571: iload 4
    //   1573: if_icmpeq +93 -> 1666
    //   1576: aload 12
    //   1578: iload_3
    //   1579: putfield 854	com/tencent/mm/plugin/voip/video/b/d:outputWidth	I
    //   1582: aload 12
    //   1584: iload 4
    //   1586: putfield 857	com/tencent/mm/plugin/voip/video/b/d:outputHeight	I
    //   1589: aload 12
    //   1591: getfield 861	com/tencent/mm/plugin/voip/video/b/d:UQx	Lcom/tencent/mm/plugin/voip/video/b/b;
    //   1594: astore 13
    //   1596: ldc_w 847
    //   1599: ldc_w 863
    //   1602: iconst_4
    //   1603: anewarray 4	java/lang/Object
    //   1606: dup
    //   1607: iconst_0
    //   1608: iload_3
    //   1609: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1612: aastore
    //   1613: dup
    //   1614: iconst_1
    //   1615: iload 4
    //   1617: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1620: aastore
    //   1621: dup
    //   1622: iconst_2
    //   1623: aload 13
    //   1625: getfield 868	com/tencent/mm/plugin/voip/video/b/b:surfaceWidth	I
    //   1628: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1631: aastore
    //   1632: dup
    //   1633: iconst_3
    //   1634: aload 13
    //   1636: getfield 871	com/tencent/mm/plugin/voip/video/b/b:surfaceHeight	I
    //   1639: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1642: aastore
    //   1643: invokestatic 364	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1646: iload_3
    //   1647: ifle +8 -> 1655
    //   1650: iload 4
    //   1652: ifgt +305 -> 1957
    //   1655: aload 12
    //   1657: getfield 872	com/tencent/mm/plugin/voip/video/b/d:UPK	Lcom/tencent/mm/cm/a/e;
    //   1660: iload_3
    //   1661: iload 4
    //   1663: invokevirtual 875	com/tencent/mm/cm/a/e:pg	(II)V
    //   1666: aload_0
    //   1667: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1670: aload_0
    //   1671: getfield 465	com/tencent/mm/plugin/voip/video/OpenGlRender:UNo	Z
    //   1674: putfield 876	com/tencent/mm/plugin/voip/video/b/g:UNo	Z
    //   1677: aload_0
    //   1678: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1681: astore 12
    //   1683: aload_0
    //   1684: getfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   1687: astore 13
    //   1689: aload_0
    //   1690: getfield 467	com/tencent/mm/plugin/voip/video/OpenGlRender:UNr	I
    //   1693: istore_2
    //   1694: aload 12
    //   1696: monitorenter
    //   1697: aload 12
    //   1699: iconst_0
    //   1700: putfield 879	com/tencent/mm/plugin/voip/video/b/g:URd	Z
    //   1703: aload 12
    //   1705: getfield 882	com/tencent/mm/plugin/voip/video/b/g:URc	Z
    //   1708: ifeq +217 -> 1925
    //   1711: aload 13
    //   1713: ifnull +212 -> 1925
    //   1716: aload 12
    //   1718: iload_2
    //   1719: putfield 802	com/tencent/mm/plugin/voip/video/b/g:UQU	I
    //   1722: aload 12
    //   1724: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1727: aload 12
    //   1729: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1732: imul
    //   1733: iconst_3
    //   1734: imul
    //   1735: iconst_2
    //   1736: idiv
    //   1737: istore 5
    //   1739: iload_2
    //   1740: iconst_3
    //   1741: if_icmpne +382 -> 2123
    //   1744: aload 13
    //   1746: arraylength
    //   1747: iload 5
    //   1749: if_icmpne +293 -> 2042
    //   1752: aload 12
    //   1754: getfield 781	com/tencent/mm/plugin/voip/video/b/g:URb	I
    //   1757: iconst_1
    //   1758: if_icmpne +49 -> 1807
    //   1761: aload 12
    //   1763: getfield 883	com/tencent/mm/plugin/voip/video/b/g:UPF	Lcom/tencent/mm/cm/a/j;
    //   1766: ifnull +41 -> 1807
    //   1769: aload 12
    //   1771: aload 12
    //   1773: getfield 883	com/tencent/mm/plugin/voip/video/b/g:UPF	Lcom/tencent/mm/cm/a/j;
    //   1776: aload 13
    //   1778: aload 12
    //   1780: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1783: aload 12
    //   1785: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1788: invokevirtual 887	com/tencent/mm/cm/a/j:Q	([BII)I
    //   1791: putfield 890	com/tencent/mm/plugin/voip/video/b/g:UPG	I
    //   1794: aload 12
    //   1796: aload 12
    //   1798: getfield 883	com/tencent/mm/plugin/voip/video/b/g:UPF	Lcom/tencent/mm/cm/a/j;
    //   1801: invokevirtual 894	com/tencent/mm/cm/a/j:jLL	()F
    //   1804: putfield 897	com/tencent/mm/plugin/voip/video/b/g:UPH	F
    //   1807: aload 12
    //   1809: getfield 829	com/tencent/mm/plugin/voip/video/b/g:UQV	Ljava/nio/ByteBuffer;
    //   1812: invokevirtual 901	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1815: pop
    //   1816: aload 12
    //   1818: getfield 832	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1821: invokevirtual 901	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1824: pop
    //   1825: aload 12
    //   1827: getfield 841	com/tencent/mm/plugin/voip/video/b/g:UQY	Ljava/nio/ByteBuffer;
    //   1830: invokevirtual 901	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1833: pop
    //   1834: aload 12
    //   1836: getfield 829	com/tencent/mm/plugin/voip/video/b/g:UQV	Ljava/nio/ByteBuffer;
    //   1839: aload 13
    //   1841: iconst_0
    //   1842: aload 12
    //   1844: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1847: aload 12
    //   1849: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1852: imul
    //   1853: iconst_3
    //   1854: imul
    //   1855: iconst_2
    //   1856: idiv
    //   1857: invokevirtual 904	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1860: pop
    //   1861: aload 12
    //   1863: getfield 832	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1866: aload 13
    //   1868: iconst_0
    //   1869: aload 12
    //   1871: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1874: aload 12
    //   1876: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1879: imul
    //   1880: invokevirtual 904	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1883: pop
    //   1884: aload 12
    //   1886: getfield 841	com/tencent/mm/plugin/voip/video/b/g:UQY	Ljava/nio/ByteBuffer;
    //   1889: aload 13
    //   1891: aload 12
    //   1893: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1896: aload 12
    //   1898: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1901: imul
    //   1902: aload 12
    //   1904: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1907: aload 12
    //   1909: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1912: imul
    //   1913: iconst_2
    //   1914: idiv
    //   1915: invokevirtual 904	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1918: pop
    //   1919: aload 12
    //   1921: iconst_1
    //   1922: putfield 879	com/tencent/mm/plugin/voip/video/b/g:URd	Z
    //   1925: aload 12
    //   1927: monitorexit
    //   1928: aload_0
    //   1929: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1932: aload_1
    //   1933: invokevirtual 906	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1936: goto -1101 -> 835
    //   1939: iconst_0
    //   1940: istore 11
    //   1942: goto -827 -> 1115
    //   1945: astore_1
    //   1946: aload 12
    //   1948: monitorexit
    //   1949: ldc_w 527
    //   1952: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1955: aload_1
    //   1956: athrow
    //   1957: aload 13
    //   1959: getfield 907	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   1962: iload_3
    //   1963: if_icmpne +13 -> 1976
    //   1966: aload 13
    //   1968: getfield 908	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   1971: iload 4
    //   1973: if_icmpeq -318 -> 1655
    //   1976: aload 13
    //   1978: iload_3
    //   1979: putfield 907	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   1982: aload 13
    //   1984: iload 4
    //   1986: putfield 908	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   1989: ldc_w 847
    //   1992: ldc_w 910
    //   1995: iconst_2
    //   1996: anewarray 4	java/lang/Object
    //   1999: dup
    //   2000: iconst_0
    //   2001: aload 13
    //   2003: getfield 907	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   2006: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2009: aastore
    //   2010: dup
    //   2011: iconst_1
    //   2012: aload 13
    //   2014: getfield 908	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   2017: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2020: aastore
    //   2021: invokestatic 364	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2024: aload 13
    //   2026: aload 13
    //   2028: getfield 907	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   2031: aload 13
    //   2033: getfield 908	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   2036: invokevirtual 913	com/tencent/mm/plugin/voip/video/b/b:mL	(II)V
    //   2039: goto -384 -> 1655
    //   2042: ldc_w 807
    //   2045: ldc_w 915
    //   2048: iconst_4
    //   2049: anewarray 4	java/lang/Object
    //   2052: dup
    //   2053: iconst_0
    //   2054: aload 13
    //   2056: arraylength
    //   2057: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2060: aastore
    //   2061: dup
    //   2062: iconst_1
    //   2063: iload 5
    //   2065: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2068: aastore
    //   2069: dup
    //   2070: iconst_2
    //   2071: aload 12
    //   2073: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2076: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2079: aastore
    //   2080: dup
    //   2081: iconst_3
    //   2082: aload 12
    //   2084: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2087: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2090: aastore
    //   2091: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2094: aload 12
    //   2096: iconst_0
    //   2097: putfield 879	com/tencent/mm/plugin/voip/video/b/g:URd	Z
    //   2100: getstatic 921	com/tencent/mm/plugin/voip/model/t:UBA	Lcom/tencent/mm/plugin/voip/model/t;
    //   2103: astore 13
    //   2105: invokestatic 924	com/tencent/mm/plugin/voip/model/t:hYg	()V
    //   2108: goto -183 -> 1925
    //   2111: astore_1
    //   2112: aload 12
    //   2114: monitorexit
    //   2115: ldc_w 527
    //   2118: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2121: aload_1
    //   2122: athrow
    //   2123: aload 12
    //   2125: aload 12
    //   2127: getfield 815	com/tencent/mm/plugin/voip/video/b/g:URe	I
    //   2130: iconst_1
    //   2131: iadd
    //   2132: putfield 815	com/tencent/mm/plugin/voip/video/b/g:URe	I
    //   2135: aload 12
    //   2137: getfield 815	com/tencent/mm/plugin/voip/video/b/g:URe	I
    //   2140: bipush 100
    //   2142: irem
    //   2143: ifne +60 -> 2203
    //   2146: ldc_w 807
    //   2149: ldc_w 926
    //   2152: iconst_4
    //   2153: anewarray 4	java/lang/Object
    //   2156: dup
    //   2157: iconst_0
    //   2158: aload 12
    //   2160: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2163: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2166: aastore
    //   2167: dup
    //   2168: iconst_1
    //   2169: aload 12
    //   2171: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2174: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2177: aastore
    //   2178: dup
    //   2179: iconst_2
    //   2180: aload 12
    //   2182: getfield 815	com/tencent/mm/plugin/voip/video/b/g:URe	I
    //   2185: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2188: aastore
    //   2189: dup
    //   2190: iconst_3
    //   2191: aload 12
    //   2193: getfield 778	com/tencent/mm/plugin/voip/video/b/g:URa	I
    //   2196: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2199: aastore
    //   2200: invokestatic 364	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2203: aload 13
    //   2205: arraylength
    //   2206: iload 5
    //   2208: if_icmplt +192 -> 2400
    //   2211: aload 12
    //   2213: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2216: istore 6
    //   2218: aload 12
    //   2220: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2223: istore 7
    //   2225: aload 12
    //   2227: getfield 815	com/tencent/mm/plugin/voip/video/b/g:URe	I
    //   2230: bipush 100
    //   2232: irem
    //   2233: ifne +467 -> 2700
    //   2236: aload 13
    //   2238: ifnull +457 -> 2695
    //   2241: aload 13
    //   2243: arraylength
    //   2244: iload 6
    //   2246: iload 7
    //   2248: imul
    //   2249: iconst_3
    //   2250: imul
    //   2251: iconst_2
    //   2252: idiv
    //   2253: if_icmple +442 -> 2695
    //   2256: iconst_0
    //   2257: istore_2
    //   2258: iconst_0
    //   2259: istore_3
    //   2260: goto +387 -> 2647
    //   2263: iload_2
    //   2264: ifeq +136 -> 2400
    //   2267: aload 12
    //   2269: getfield 832	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   2272: invokevirtual 901	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2275: pop
    //   2276: aload 12
    //   2278: getfield 835	com/tencent/mm/plugin/voip/video/b/g:UQW	Ljava/nio/ByteBuffer;
    //   2281: invokevirtual 901	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2284: pop
    //   2285: aload 12
    //   2287: getfield 838	com/tencent/mm/plugin/voip/video/b/g:UQX	Ljava/nio/ByteBuffer;
    //   2290: invokevirtual 901	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2293: pop
    //   2294: aload 12
    //   2296: getfield 832	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   2299: aload 13
    //   2301: iconst_0
    //   2302: aload 12
    //   2304: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2307: aload 12
    //   2309: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2312: imul
    //   2313: invokevirtual 904	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2316: pop
    //   2317: aload 12
    //   2319: getfield 835	com/tencent/mm/plugin/voip/video/b/g:UQW	Ljava/nio/ByteBuffer;
    //   2322: aload 13
    //   2324: aload 12
    //   2326: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2329: aload 12
    //   2331: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2334: imul
    //   2335: aload 12
    //   2337: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2340: aload 12
    //   2342: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2345: imul
    //   2346: iconst_4
    //   2347: idiv
    //   2348: invokevirtual 904	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2351: pop
    //   2352: aload 12
    //   2354: getfield 838	com/tencent/mm/plugin/voip/video/b/g:UQX	Ljava/nio/ByteBuffer;
    //   2357: aload 13
    //   2359: aload 12
    //   2361: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2364: aload 12
    //   2366: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2369: imul
    //   2370: iconst_5
    //   2371: imul
    //   2372: iconst_4
    //   2373: idiv
    //   2374: aload 12
    //   2376: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2379: aload 12
    //   2381: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2384: imul
    //   2385: iconst_4
    //   2386: idiv
    //   2387: invokevirtual 904	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2390: pop
    //   2391: aload 12
    //   2393: iconst_1
    //   2394: putfield 879	com/tencent/mm/plugin/voip/video/b/g:URd	Z
    //   2397: goto -472 -> 1925
    //   2400: ldc_w 807
    //   2403: ldc_w 928
    //   2406: iconst_4
    //   2407: anewarray 4	java/lang/Object
    //   2410: dup
    //   2411: iconst_0
    //   2412: aload 13
    //   2414: arraylength
    //   2415: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2418: aastore
    //   2419: dup
    //   2420: iconst_1
    //   2421: iload 5
    //   2423: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2426: aastore
    //   2427: dup
    //   2428: iconst_2
    //   2429: aload 12
    //   2431: getfield 784	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2434: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2437: aastore
    //   2438: dup
    //   2439: iconst_3
    //   2440: aload 12
    //   2442: getfield 787	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2445: invokestatic 338	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2448: aastore
    //   2449: invokestatic 497	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2452: aload 12
    //   2454: iconst_0
    //   2455: putfield 879	com/tencent/mm/plugin/voip/video/b/g:URd	Z
    //   2458: getstatic 921	com/tencent/mm/plugin/voip/model/t:UBA	Lcom/tencent/mm/plugin/voip/model/t;
    //   2461: astore 13
    //   2463: invokestatic 931	com/tencent/mm/plugin/voip/model/t:hYh	()V
    //   2466: goto -541 -> 1925
    //   2469: aload_0
    //   2470: getfield 762	com/tencent/mm/plugin/voip/video/OpenGlRender:UNB	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2473: aload_0
    //   2474: getfield 252	com/tencent/mm/plugin/voip/video/OpenGlRender:UNA	J
    //   2477: invokestatic 766	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   2480: invokeinterface 934 3 0
    //   2485: goto -1614 -> 871
    //   2488: aload_0
    //   2489: invokestatic 535	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   2492: putfield 252	com/tencent/mm/plugin/voip/video/OpenGlRender:UNA	J
    //   2495: aload_0
    //   2496: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:UMN	Z
    //   2499: ifeq +20 -> 2519
    //   2502: aload_0
    //   2503: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:UMM	Z
    //   2506: ifeq +13 -> 2519
    //   2509: aload_0
    //   2510: getfield 277	com/tencent/mm/plugin/voip/video/OpenGlRender:UMT	Ljava/lang/ref/WeakReference;
    //   2513: invokevirtual 358	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2516: ifnonnull +63 -> 2579
    //   2519: aload_0
    //   2520: aconst_null
    //   2521: putfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   2524: aload_0
    //   2525: aconst_null
    //   2526: putfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:UMZ	[I
    //   2529: getstatic 130	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   2532: ldc_w 936
    //   2535: iconst_3
    //   2536: anewarray 4	java/lang/Object
    //   2539: dup
    //   2540: iconst_0
    //   2541: aload_0
    //   2542: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:UMN	Z
    //   2545: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2548: aastore
    //   2549: dup
    //   2550: iconst_1
    //   2551: aload_0
    //   2552: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:UMM	Z
    //   2555: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2558: aastore
    //   2559: dup
    //   2560: iconst_2
    //   2561: aload_0
    //   2562: getfield 465	com/tencent/mm/plugin/voip/video/OpenGlRender:UNo	Z
    //   2565: invokestatic 384	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2568: aastore
    //   2569: invokestatic 344	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2572: ldc_w 527
    //   2575: invokestatic 176	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2578: return
    //   2579: aload_0
    //   2580: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2583: ifnull +33 -> 2616
    //   2586: aload_0
    //   2587: getfield 254	com/tencent/mm/plugin/voip/video/OpenGlRender:UNE	Z
    //   2590: ifeq +8 -> 2598
    //   2593: aload_0
    //   2594: iconst_1
    //   2595: invokespecial 938	com/tencent/mm/plugin/voip/video/OpenGlRender:GQ	(Z)V
    //   2598: aload_0
    //   2599: getfield 306	com/tencent/mm/plugin/voip/video/OpenGlRender:UNg	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2602: aload_1
    //   2603: invokevirtual 906	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   2606: aload_0
    //   2607: aconst_null
    //   2608: putfield 224	com/tencent/mm/plugin/voip/video/OpenGlRender:UMY	[B
    //   2611: aload_0
    //   2612: aconst_null
    //   2613: putfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:UMZ	[I
    //   2616: aload_0
    //   2617: getfield 762	com/tencent/mm/plugin/voip/video/OpenGlRender:UNB	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2620: ifnull -1749 -> 871
    //   2623: aload_0
    //   2624: getfield 762	com/tencent/mm/plugin/voip/video/OpenGlRender:UNB	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2627: aload_0
    //   2628: getfield 252	com/tencent/mm/plugin/voip/video/OpenGlRender:UNA	J
    //   2631: invokestatic 766	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   2634: invokeinterface 941 3 0
    //   2639: goto -1768 -> 871
    //   2642: iconst_0
    //   2643: istore_2
    //   2644: goto -1614 -> 1030
    //   2647: iload_3
    //   2648: iload 6
    //   2650: iload 7
    //   2652: imul
    //   2653: if_icmpge +28 -> 2681
    //   2656: iload_2
    //   2657: istore 4
    //   2659: aload 13
    //   2661: iload_3
    //   2662: baload
    //   2663: ifne +8 -> 2671
    //   2666: iload_2
    //   2667: iconst_1
    //   2668: iadd
    //   2669: istore 4
    //   2671: iload_3
    //   2672: iconst_1
    //   2673: iadd
    //   2674: istore_3
    //   2675: iload 4
    //   2677: istore_2
    //   2678: goto -31 -> 2647
    //   2681: iload_2
    //   2682: iload 6
    //   2684: iload 7
    //   2686: imul
    //   2687: if_icmplt +13 -> 2700
    //   2690: iconst_0
    //   2691: istore_2
    //   2692: goto -429 -> 2263
    //   2695: iconst_0
    //   2696: istore_2
    //   2697: goto -434 -> 2263
    //   2700: iconst_1
    //   2701: istore_2
    //   2702: goto -439 -> 2263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2705	0	this	OpenGlRender
    //   0	2705	1	paramGL10	GL10
    //   123	2579	2	i	int
    //   135	2540	3	j	int
    //   144	2532	4	k	int
    //   1071	1351	5	m	int
    //   1059	1628	6	n	int
    //   1065	1622	7	i1	int
    //   1077	29	8	i2	int
    //   1083	149	9	i3	int
    //   1100	111	10	i4	int
    //   1113	828	11	bool	boolean
    //   429	2024	12	localObject1	Object
    //   1594	1066	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1428	1486	1945	finally
    //   1697	1711	2111	finally
    //   1716	1739	2111	finally
    //   1744	1807	2111	finally
    //   1807	1925	2111	finally
    //   1925	1928	2111	finally
    //   2042	2108	2111	finally
    //   2123	2203	2111	finally
    //   2203	2236	2111	finally
    //   2241	2256	2111	finally
    //   2267	2397	2111	finally
    //   2400	2466	2111	finally
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115657);
    Log.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d, lastHWDecSize:%dx%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.UNo), Integer.valueOf(this.UMR), Integer.valueOf(this.UMS), Integer.valueOf(this.mRenderMode), Integer.valueOf(this.UxE), Integer.valueOf(this.UxF) });
    if ((this.UMR != paramInt1) || (this.UMS != paramInt2))
    {
      paramGL10.glViewport(0, 0, paramInt1, paramInt2);
      this.UMR = paramInt1;
      this.UMS = paramInt2;
    }
    if (this.UNf != null) {
      this.UNf.mh(paramInt1, paramInt2);
    }
    if (this.UNg != null) {
      this.UNg.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
    if (this.UNh == null)
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySx, false);
      int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ySv, 50);
      if ((bool) && (com.tencent.mm.media.util.d.bqo() < i)) {
        this.UNl = false;
      }
    }
    if (this.UNl)
    {
      if (this.UNh == null)
      {
        this.UNh = new com.tencent.mm.plugin.xlabeffect.k(0, 0, 1);
        this.UNh.q(this.UNm, -1, -1, this.UNn, -1);
        this.UNh.Jo(false);
        this.UNh.iGb();
      }
      if (this.UNh != null)
      {
        this.UNh.setSize(paramInt1, paramInt2);
        this.UNj = paramInt1;
        this.UNk = paramInt2;
      }
    }
    setShowMode(this.Erd);
    iS(this.UxE, this.UxF);
    AppMethodBeat.o(115657);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115658);
    Log.i(TAG, "onSurfaceCreated...");
    if (getGLVersion() == 2)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glDisable(2929);
    }
    if (this.UNg != null) {
      this.UNg.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    if (v2protocal.UFU == null)
    {
      paramGL10 = e.idb();
      try
      {
        paramGL10.UQM = paramGL10.idc();
        paramGL10.UQL.set(false);
        paramEGLConfig = new Surface(paramGL10.UQM);
        v2protocal.mSurfaceTexture = paramGL10.UQM;
        v2protocal.UFV = null;
        v2protocal.UFU = paramEGLConfig;
        paramGL10.UQN.apC();
        AppMethodBeat.o(115658);
        return;
      }
      catch (Exception paramGL10)
      {
        Log.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", paramGL10, "initSurfaceTexutre error", new Object[0]);
        paramGL10 = t.UBA;
        t.hXT();
      }
    }
    AppMethodBeat.o(115658);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115666);
    if (this.UMT.get() != null) {
      ((OpenGlView)this.UMT.get()).icp();
    }
    AppMethodBeat.o(115666);
  }
  
  public final void setShowMode(int paramInt)
  {
    AppMethodBeat.i(115650);
    this.Erd = paramInt;
    if (this.UNg != null)
    {
      Log.printInfoStack(TAG, "setShowMode, mode:%d, uiWidth: %s, uiHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.UMR), Integer.valueOf(this.UMS) });
      if (paramInt == 1) {
        break label90;
      }
      this.UNF = true;
      icl();
    }
    for (;;)
    {
      this.UNg.art(this.Erd);
      AppMethodBeat.o(115650);
      return;
      label90:
      if (this.UNF)
      {
        Log.i(TAG, "is need to detach");
        icl();
      }
      this.UNE = true;
      GQ(false);
    }
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(292971);
    Log.i(TAG, "hseasun: isDrawingSelf:%b, set setSpatiotemporalDenosing:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.UNo), Integer.valueOf(paramInt), Integer.valueOf(this.UNq) });
    this.UNq = paramInt;
    AppMethodBeat.o(292971);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115665);
    Log.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.UNo), Integer.valueOf(paramInt), Integer.valueOf(this.UNp) });
    this.UNp = paramInt;
    AppMethodBeat.o(115665);
  }
  
  final class a
    extends MMHandler
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
    public abstract void iaQ();
    
    public abstract void wV(long paramLong);
    
    public abstract void wW(long paramLong);
    
    public abstract void wX(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender
 * JD-Core Version:    0.7.0.1
 */