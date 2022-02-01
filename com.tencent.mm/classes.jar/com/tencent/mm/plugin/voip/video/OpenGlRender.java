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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender
  implements GLTextureView.m
{
  private static final Object AOA;
  static boolean AOG;
  public static int AOo;
  private static final Object AOx;
  private static final Object AOy;
  private static final Object AOz;
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
  public int AAu;
  public int AAv;
  boolean ANR;
  int ANS;
  long ANT;
  long ANU;
  int ANV;
  a ANW;
  boolean ANX;
  boolean ANY;
  boolean ANZ;
  public int AOB;
  public boolean AOC;
  long AOD;
  public b AOE;
  WeakReference<Object> AOF;
  private boolean AOH;
  boolean AOI;
  boolean AOa;
  boolean AOb;
  int AOc;
  int AOd;
  WeakReference<OpenGlView> AOe;
  public boolean AOf;
  public Bitmap AOg;
  private int AOh;
  private int AOi;
  private byte[] AOj;
  private int[] AOk;
  private int AOl;
  private int AOm;
  private int AOn;
  private b AOp;
  g AOq;
  private boolean AOr;
  private int AOs;
  private int AOt;
  private volatile boolean AOu;
  private volatile boolean AOv;
  public int AOw;
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
    AOo = 0;
    AOx = new Object();
    AOy = new Object();
    AOz = new Object();
    AOA = new Object();
    AOG = false;
    AppMethodBeat.o(115668);
  }
  
  public OpenGlRender(OpenGlView paramOpenGlView, int paramInt)
  {
    AppMethodBeat.i(115648);
    this.ANR = false;
    this.ANS = 0;
    this.ANT = 0L;
    this.ANU = 0L;
    this.ANV = 0;
    this.mBrightness = 1.2F;
    this.mContrast = 1.93F;
    this.mSaturation = 1.05F;
    this.ANX = false;
    this.ANY = false;
    this.ANZ = false;
    this.AOa = false;
    this.AOb = false;
    this.AOc = 0;
    this.AOd = 0;
    this.mRenderMode = RenderLocal;
    this.AOf = false;
    this.AOg = null;
    this.AOh = 0;
    this.AOi = 0;
    this.AOj = null;
    this.AOk = null;
    this.AOp = null;
    this.AOu = false;
    this.AOv = false;
    this.AOw = 0;
    this.AOB = 0;
    this.AAu = 0;
    this.AAv = 0;
    this.AOC = false;
    this.AOD = -1L;
    this.AOH = false;
    this.AOI = false;
    if (!AOG)
    {
      OpenGlRender.class.getClassLoader();
      j.sC("mm_gl_disp");
      AOG = true;
    }
    this.mRenderMode = paramInt;
    this.AOe = new WeakReference(paramOpenGlView);
    paramOpenGlView = Looper.myLooper();
    if (paramOpenGlView != null) {
      this.ANW = new a(paramOpenGlView);
    }
    for (;;)
    {
      this.AOF = null;
      if (getGLVersion() == 2) {
        this.AOp = new b();
      }
      this.AOs = 0;
      this.AOq = new g();
      AppMethodBeat.o(115648);
      return;
      paramOpenGlView = Looper.getMainLooper();
      if (paramOpenGlView != null) {
        this.ANW = new a(paramOpenGlView);
      } else {
        this.ANW = null;
      }
    }
  }
  
  private native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  private native void Uninit(int paramInt);
  
  private void emC()
  {
    AppMethodBeat.i(115662);
    if (this.AOp != null)
    {
      if (this.AOe != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)this.AOe.get();
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
      if (this.AOp != null) {
        this.AOp.destroy();
      }
    }
    AppMethodBeat.o(115662);
  }
  
  public static int getGLVersion()
  {
    AppMethodBeat.i(115647);
    if (AOo == 0)
    {
      AOo = 2;
      ac.i(TAG, "init gl version: %s", new Object[] { Integer.valueOf(AOo) });
    }
    int i = AOo;
    AppMethodBeat.o(115647);
    return i;
  }
  
  private native void render32(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void render8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private void sV(boolean paramBoolean)
  {
    AppMethodBeat.i(115664);
    if ((this.AOe != null) && (this.AOe.get() != null))
    {
      if (!paramBoolean)
      {
        ??? = (OpenGlView)this.AOe.get();
        ac.i(TAG, "attachGLContext:%s", new Object[] { ??? });
        ((OpenGlView)???).queueEvent(new Runnable()
        {
          public final void run()
          {
            boolean bool = false;
            AppMethodBeat.i(161661);
            if (OpenGlRender.g(OpenGlRender.this))
            {
              ac.i(OpenGlRender.TAG, "attachGLContext");
              ??? = OpenGlRender.this;
              if (!OpenGlRender.b(OpenGlRender.this).emZ()) {
                bool = true;
              }
              OpenGlRender.a((OpenGlRender)???, bool);
              OpenGlRender.e(OpenGlRender.this);
              OpenGlRender.f(OpenGlRender.this);
              ac.i(OpenGlRender.TAG, "attach finish");
            }
            synchronized (OpenGlRender.HS())
            {
              try
              {
                OpenGlRender.HS().notifyAll();
                AppMethodBeat.o(161661);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ac.printErrStackTrace(OpenGlRender.TAG, localException, "", new Object[0]);
                }
              }
            }
          }
        });
        synchronized (AOy)
        {
          try
          {
            AOy.wait(100L);
            ac.i(TAG, "attachGLContext wait finish, bNeedAttach:%s", new Object[] { Boolean.valueOf(this.AOH) });
            AppMethodBeat.o(115664);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ac.printErrStackTrace(TAG, localException, "", new Object[0]);
            }
          }
        }
      }
      if (this.AOH)
      {
        ac.i(TAG, "attachGLContext");
        if (this.AOq.emZ()) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.AOH = paramBoolean;
      this.AOj = null;
      this.AOk = null;
      ac.i(TAG, "attach finish");
      AppMethodBeat.o(115664);
      return;
    }
  }
  
  private native void setMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setParam(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  public final void Ta(int paramInt)
  {
    AppMethodBeat.i(115650);
    this.AOw = paramInt;
    if (this.AOq != null)
    {
      ac.m(TAG, "setShowMode, mode:%d, uiWidth: %s, uiHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.AOc), Integer.valueOf(this.AOd) });
      if (paramInt == 1) {
        break label90;
      }
      this.AOI = true;
      emD();
    }
    for (;;)
    {
      this.AOq.Tc(this.AOw);
      AppMethodBeat.o(115650);
      return;
      label90:
      if (this.AOI)
      {
        ac.i(TAG, "is need to detach");
        emD();
      }
      this.AOH = true;
      sV(false);
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
      if ((this.AOq != null) && (this.AOq.emW() != null))
      {
        paramb.a(this.AOq.emW());
        AppMethodBeat.o(115667);
        return;
        if ((this.AOp != null) && (this.AOp.emQ() != null)) {
          paramb.a(this.AOp.emQ());
        }
      }
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.f.d paramd)
  {
    AppMethodBeat.i(115651);
    if (this.AOq != null) {
      this.AOq.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115651);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(115653);
    if ((this.ANX) && (this.AOj == null))
    {
      this.AOl = paramInt1;
      this.AOm = paramInt2;
      this.AOn = paramInt3;
      this.AOj = paramArrayOfByte;
      this.AOr = paramBoolean;
      this.AOt = paramInt4;
      requestRender();
    }
    AppMethodBeat.o(115653);
  }
  
  public final void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(115655);
    if ((this.ANX) && (this.AOk == null))
    {
      this.AOl = paramInt1;
      this.AOm = paramInt2;
      this.AOn = paramInt3;
      this.AOk = paramArrayOfInt;
      this.AOr = paramBoolean;
      requestRender();
    }
    AppMethodBeat.o(115655);
  }
  
  public final void emA()
  {
    AppMethodBeat.i(115660);
    ac.i(TAG, "%s onStop, renderMode: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
    this.ANY = false;
    this.AOb = false;
    AppMethodBeat.o(115660);
  }
  
  public final void emB()
  {
    AppMethodBeat.i(115661);
    ac.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.ANX), Boolean.valueOf(this.ANY) });
    if ((this.ANX) && (this.ANY))
    {
      ac.i(TAG, "%s steve: Reset GLRender first! mode=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
      if (this.AOq != null)
      {
        ac.i(TAG, "onResetRender need detach");
        this.AOI = true;
        emD();
      }
      this.ANX = false;
      this.ANY = false;
      emC();
    }
    AppMethodBeat.o(115661);
  }
  
  final void emD()
  {
    AppMethodBeat.i(115663);
    if ((this.AOe != null) && (this.AOe.get() != null))
    {
      ??? = (OpenGlView)this.AOe.get();
      ac.i(TAG, "detachGLContext:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115644);
          if (OpenGlRender.c(OpenGlRender.this))
          {
            OpenGlRender.b(OpenGlRender.this).ena();
            OpenGlRender.d(OpenGlRender.this);
            OpenGlRender.e(OpenGlRender.this);
            OpenGlRender.f(OpenGlRender.this);
            ac.i(OpenGlRender.TAG, "detach finish");
          }
          synchronized (OpenGlRender.AOx)
          {
            try
            {
              OpenGlRender.AOx.notifyAll();
              AppMethodBeat.o(115644);
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ac.printErrStackTrace(OpenGlRender.TAG, localException, "", new Object[0]);
              }
            }
          }
        }
      });
      synchronized (AOx)
      {
        try
        {
          AOx.wait(100L);
          ac.i(TAG, "detachGLContext wait finish, bNeedDetach:%s", new Object[] { Boolean.valueOf(this.AOI) });
          AppMethodBeat.o(115663);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace(TAG, localException, "", new Object[0]);
          }
        }
      }
    }
    if (this.AOI) {
      ((OpenGlView)this.AOe.get()).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115645);
          OpenGlRender.b(OpenGlRender.this).ena();
          OpenGlRender.d(OpenGlRender.this);
          OpenGlRender.e(OpenGlRender.this);
          OpenGlRender.f(OpenGlRender.this);
          ac.i(OpenGlRender.TAG, "detach finish");
          AppMethodBeat.o(115645);
        }
      });
    }
    AppMethodBeat.o(115663);
  }
  
  public final void h(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115654);
    if ((this.ANX) && (this.AOj == null))
    {
      this.AOl = paramInt1;
      this.AOm = paramInt2;
      this.AOn = paramInt3;
      this.AOj = paramArrayOfByte;
      this.AOr = false;
      requestRender();
    }
    AppMethodBeat.o(115654);
  }
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115656);
    ac.i(TAG, "video=" + paramInt1 + "x" + paramInt2);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.AAu = paramInt1;
      this.AAv = paramInt2;
      if (this.AOq != null) {
        this.AOq.ip(paramInt1, paramInt2);
      }
      AppMethodBeat.o(115656);
      return;
    }
    ac.e(TAG, "ERROR video size:%dx%d, lastviddeosize:%dx%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.AAu), Integer.valueOf(this.AAv) });
    AppMethodBeat.o(115656);
  }
  
  /* Error */
  public final void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: ldc_w 496
    //   3: invokestatic 114	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 222	com/tencent/mm/plugin/voip/video/OpenGlRender:AOw	I
    //   10: ifne +2197 -> 2207
    //   13: aload_0
    //   14: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:ANY	Z
    //   17: ifeq +20 -> 37
    //   20: aload_0
    //   21: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:ANX	Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 259	com/tencent/mm/plugin/voip/video/OpenGlRender:AOe	Ljava/lang/ref/WeakReference;
    //   31: invokevirtual 310	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   34: ifnonnull +63 -> 97
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:AOk	[I
    //   47: getstatic 118	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   50: ldc_w 498
    //   53: iconst_3
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:ANY	Z
    //   63: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_0
    //   70: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:ANX	Z
    //   73: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: aload_0
    //   80: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:AOr	Z
    //   83: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: invokestatic 500	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 496
    //   93: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: aload_0
    //   98: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   101: ifnull +662 -> 763
    //   104: aload_0
    //   105: invokestatic 506	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   108: putfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:AOD	J
    //   111: aload_0
    //   112: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:AOn	I
    //   115: getstatic 142	com/tencent/mm/plugin/voip/video/OpenGlRender:FLAG_Mirror	I
    //   118: iand
    //   119: ifeq +679 -> 798
    //   122: iconst_1
    //   123: istore_2
    //   124: aload_0
    //   125: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:AOs	I
    //   128: bipush 8
    //   130: iand
    //   131: ifeq +672 -> 803
    //   134: iconst_1
    //   135: istore_3
    //   136: aload_0
    //   137: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:AOp	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   140: ifnull +698 -> 838
    //   143: aload_0
    //   144: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:AOr	Z
    //   147: ifeq +691 -> 838
    //   150: aload_0
    //   151: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:AOs	I
    //   154: ifeq +684 -> 838
    //   157: iload_3
    //   158: ifne +680 -> 838
    //   161: aload_0
    //   162: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:AOp	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:AOs	I
    //   170: istore_3
    //   171: aload_1
    //   172: getfield 509	com/tencent/mm/plugin/voip/video/a/b:gkP	Z
    //   175: ifne +509 -> 684
    //   178: aload_1
    //   179: ldc_w 511
    //   182: ldc_w 513
    //   185: invokestatic 517	com/tencent/mm/plugin/voip/video/a/b:ax	(Ljava/lang/String;Ljava/lang/String;)I
    //   188: putfield 520	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   191: aload_1
    //   192: getfield 520	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   195: ifne +12 -> 207
    //   198: ldc_w 522
    //   201: ldc_w 524
    //   204: invokestatic 526	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_1
    //   208: aload_1
    //   209: getfield 520	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   212: ldc_w 528
    //   215: invokestatic 534	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   218: putfield 537	com/tencent/mm/plugin/voip/video/a/b:gWn	I
    //   221: aload_1
    //   222: aload_1
    //   223: getfield 520	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   226: ldc_w 539
    //   229: invokestatic 534	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   232: putfield 542	com/tencent/mm/plugin/voip/video/a/b:gWm	I
    //   235: aload_1
    //   236: aload_1
    //   237: getfield 520	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   240: ldc_w 544
    //   243: invokestatic 547	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   246: putfield 550	com/tencent/mm/plugin/voip/video/a/b:gWo	I
    //   249: aload_1
    //   250: aload_1
    //   251: getfield 520	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   254: ldc_w 552
    //   257: invokestatic 547	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   260: putfield 555	com/tencent/mm/plugin/voip/video/a/b:gWy	I
    //   263: aload_1
    //   264: aload_1
    //   265: getfield 520	com/tencent/mm/plugin/voip/video/a/b:gWl	I
    //   268: ldc_w 557
    //   271: invokestatic 547	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   274: putfield 560	com/tencent/mm/plugin/voip/video/a/b:gWr	I
    //   277: aload_1
    //   278: invokestatic 564	com/tencent/mm/plugin/voip/video/a/b:emO	()Lcom/tencent/mm/media/f/d;
    //   281: putfield 568	com/tencent/mm/plugin/voip/video/a/b:APA	Lcom/tencent/mm/media/f/d;
    //   284: aload_1
    //   285: invokestatic 564	com/tencent/mm/plugin/voip/video/a/b:emO	()Lcom/tencent/mm/media/f/d;
    //   288: putfield 571	com/tencent/mm/plugin/voip/video/a/b:APB	Lcom/tencent/mm/media/f/d;
    //   291: aload_1
    //   292: ldc_w 511
    //   295: ldc_w 573
    //   298: invokestatic 517	com/tencent/mm/plugin/voip/video/a/b:ax	(Ljava/lang/String;Ljava/lang/String;)I
    //   301: putfield 576	com/tencent/mm/plugin/voip/video/a/b:APC	I
    //   304: aload_1
    //   305: aload_1
    //   306: getfield 576	com/tencent/mm/plugin/voip/video/a/b:APC	I
    //   309: ldc_w 528
    //   312: invokestatic 534	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   315: putfield 579	com/tencent/mm/plugin/voip/video/a/b:APG	I
    //   318: aload_1
    //   319: aload_1
    //   320: getfield 576	com/tencent/mm/plugin/voip/video/a/b:APC	I
    //   323: ldc_w 539
    //   326: invokestatic 534	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   329: putfield 582	com/tencent/mm/plugin/voip/video/a/b:APF	I
    //   332: aload_1
    //   333: aload_1
    //   334: getfield 576	com/tencent/mm/plugin/voip/video/a/b:APC	I
    //   337: ldc_w 584
    //   340: invokestatic 547	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   343: putfield 587	com/tencent/mm/plugin/voip/video/a/b:APH	I
    //   346: aload_1
    //   347: aload_1
    //   348: getfield 576	com/tencent/mm/plugin/voip/video/a/b:APC	I
    //   351: ldc_w 557
    //   354: invokestatic 547	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   357: putfield 590	com/tencent/mm/plugin/voip/video/a/b:APJ	I
    //   360: aload_1
    //   361: invokestatic 564	com/tencent/mm/plugin/voip/video/a/b:emO	()Lcom/tencent/mm/media/f/d;
    //   364: putfield 593	com/tencent/mm/plugin/voip/video/a/b:APD	Lcom/tencent/mm/media/f/d;
    //   367: aload_1
    //   368: invokestatic 564	com/tencent/mm/plugin/voip/video/a/b:emO	()Lcom/tencent/mm/media/f/d;
    //   371: putfield 596	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   374: getstatic 600	com/tencent/mm/plugin/voip/video/a/b:gWC	[F
    //   377: astore 11
    //   379: aload_1
    //   380: aload 11
    //   382: aload 11
    //   384: arraylength
    //   385: invokestatic 606	java/util/Arrays:copyOf	([FI)[F
    //   388: putfield 609	com/tencent/mm/plugin/voip/video/a/b:jbq	[F
    //   391: aload_1
    //   392: aload_1
    //   393: getfield 609	com/tencent/mm/plugin/voip/video/a/b:jbq	[F
    //   396: arraylength
    //   397: iconst_4
    //   398: imul
    //   399: invokestatic 615	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   402: invokestatic 621	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   405: invokevirtual 625	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   408: invokevirtual 629	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   411: putfield 633	com/tencent/mm/plugin/voip/video/a/b:grE	Ljava/nio/FloatBuffer;
    //   414: aload_1
    //   415: getfield 633	com/tencent/mm/plugin/voip/video/a/b:grE	Ljava/nio/FloatBuffer;
    //   418: aload_1
    //   419: getfield 609	com/tencent/mm/plugin/voip/video/a/b:jbq	[F
    //   422: invokevirtual 639	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   425: pop
    //   426: aload_1
    //   427: getfield 633	com/tencent/mm/plugin/voip/video/a/b:grE	Ljava/nio/FloatBuffer;
    //   430: iconst_0
    //   431: invokevirtual 643	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   434: pop
    //   435: aload_1
    //   436: getstatic 646	com/tencent/mm/plugin/voip/video/a/b:gWD	[F
    //   439: arraylength
    //   440: iconst_4
    //   441: imul
    //   442: invokestatic 615	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   445: invokestatic 621	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   448: invokevirtual 625	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   451: invokevirtual 629	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   454: putfield 649	com/tencent/mm/plugin/voip/video/a/b:grD	Ljava/nio/FloatBuffer;
    //   457: aload_1
    //   458: getfield 649	com/tencent/mm/plugin/voip/video/a/b:grD	Ljava/nio/FloatBuffer;
    //   461: getstatic 646	com/tencent/mm/plugin/voip/video/a/b:gWD	[F
    //   464: invokevirtual 639	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   467: pop
    //   468: aload_1
    //   469: getfield 649	com/tencent/mm/plugin/voip/video/a/b:grD	Ljava/nio/FloatBuffer;
    //   472: iconst_0
    //   473: invokevirtual 643	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   476: pop
    //   477: getstatic 652	com/tencent/mm/plugin/voip/video/a/b:APz	[F
    //   480: astore 11
    //   482: aload_1
    //   483: aload 11
    //   485: aload 11
    //   487: arraylength
    //   488: invokestatic 606	java/util/Arrays:copyOf	([FI)[F
    //   491: putfield 655	com/tencent/mm/plugin/voip/video/a/b:APO	[F
    //   494: aload_1
    //   495: aload_1
    //   496: getfield 655	com/tencent/mm/plugin/voip/video/a/b:APO	[F
    //   499: arraylength
    //   500: iconst_4
    //   501: imul
    //   502: invokestatic 615	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   505: invokestatic 621	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   508: invokevirtual 625	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   511: invokevirtual 629	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   514: putfield 658	com/tencent/mm/plugin/voip/video/a/b:APK	Ljava/nio/FloatBuffer;
    //   517: aload_1
    //   518: getfield 658	com/tencent/mm/plugin/voip/video/a/b:APK	Ljava/nio/FloatBuffer;
    //   521: aload_1
    //   522: getfield 655	com/tencent/mm/plugin/voip/video/a/b:APO	[F
    //   525: invokevirtual 639	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   528: pop
    //   529: aload_1
    //   530: getfield 658	com/tencent/mm/plugin/voip/video/a/b:APK	Ljava/nio/FloatBuffer;
    //   533: iconst_0
    //   534: invokevirtual 643	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   537: pop
    //   538: getstatic 600	com/tencent/mm/plugin/voip/video/a/b:gWC	[F
    //   541: astore 11
    //   543: aload_1
    //   544: aload 11
    //   546: aload 11
    //   548: arraylength
    //   549: invokestatic 606	java/util/Arrays:copyOf	([FI)[F
    //   552: putfield 661	com/tencent/mm/plugin/voip/video/a/b:APN	[F
    //   555: aload_1
    //   556: aload_1
    //   557: getfield 661	com/tencent/mm/plugin/voip/video/a/b:APN	[F
    //   560: arraylength
    //   561: iconst_4
    //   562: imul
    //   563: invokestatic 615	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   566: invokestatic 621	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   569: invokevirtual 625	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   572: invokevirtual 629	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   575: putfield 664	com/tencent/mm/plugin/voip/video/a/b:APL	Ljava/nio/FloatBuffer;
    //   578: aload_1
    //   579: getfield 664	com/tencent/mm/plugin/voip/video/a/b:APL	Ljava/nio/FloatBuffer;
    //   582: aload_1
    //   583: getfield 661	com/tencent/mm/plugin/voip/video/a/b:APN	[F
    //   586: invokevirtual 639	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   589: pop
    //   590: aload_1
    //   591: getfield 664	com/tencent/mm/plugin/voip/video/a/b:APL	Ljava/nio/FloatBuffer;
    //   594: iconst_0
    //   595: invokevirtual 643	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   598: pop
    //   599: aload_1
    //   600: invokestatic 668	com/tencent/mm/plugin/voip/video/a/b:emP	()Lcom/tencent/mm/media/f/a;
    //   603: putfield 672	com/tencent/mm/plugin/voip/video/a/b:APQ	Lcom/tencent/mm/media/f/a;
    //   606: aload_1
    //   607: aconst_null
    //   608: putfield 675	com/tencent/mm/plugin/voip/video/a/b:APY	[B
    //   611: aload_1
    //   612: invokestatic 668	com/tencent/mm/plugin/voip/video/a/b:emP	()Lcom/tencent/mm/media/f/a;
    //   615: putfield 678	com/tencent/mm/plugin/voip/video/a/b:APR	Lcom/tencent/mm/media/f/a;
    //   618: aload_1
    //   619: invokestatic 564	com/tencent/mm/plugin/voip/video/a/b:emO	()Lcom/tencent/mm/media/f/d;
    //   622: putfield 681	com/tencent/mm/plugin/voip/video/a/b:gsb	Lcom/tencent/mm/media/f/d;
    //   625: iload_3
    //   626: ifeq +30 -> 656
    //   629: aload_1
    //   630: new 683	com/tencent/mm/plugin/voip/video/a/a
    //   633: dup
    //   634: invokespecial 684	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   637: putfield 688	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   640: aload_1
    //   641: getfield 688	com/tencent/mm/plugin/voip/video/a/b:APV	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   644: aload_1
    //   645: getfield 596	com/tencent/mm/plugin/voip/video/a/b:APS	Lcom/tencent/mm/media/f/d;
    //   648: aload_1
    //   649: getfield 681	com/tencent/mm/plugin/voip/video/a/b:gsb	Lcom/tencent/mm/media/f/d;
    //   652: iload_3
    //   653: invokevirtual 691	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/f/d;Lcom/tencent/mm/media/f/d;I)V
    //   656: ldc_w 522
    //   659: ldc_w 693
    //   662: iconst_1
    //   663: anewarray 4	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: aload_1
    //   669: invokevirtual 445	java/lang/Object:hashCode	()I
    //   672: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   675: aastore
    //   676: invokestatic 340	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: aload_1
    //   680: iconst_1
    //   681: putfield 509	com/tencent/mm/plugin/voip/video/a/b:gkP	Z
    //   684: aload_0
    //   685: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:AOp	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   688: aload_0
    //   689: getfield 198	com/tencent/mm/plugin/voip/video/OpenGlRender:AOc	I
    //   692: aload_0
    //   693: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:AOd	I
    //   696: invokevirtual 696	com/tencent/mm/plugin/voip/video/a/b:in	(II)V
    //   699: iload_2
    //   700: ifne +108 -> 808
    //   703: aload_0
    //   704: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:AOp	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   707: aload_0
    //   708: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   711: aload_0
    //   712: getfield 425	com/tencent/mm/plugin/voip/video/OpenGlRender:AOl	I
    //   715: aload_0
    //   716: getfield 427	com/tencent/mm/plugin/voip/video/OpenGlRender:AOm	I
    //   719: aload_0
    //   720: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:AOn	I
    //   723: iconst_0
    //   724: invokevirtual 698	com/tencent/mm/plugin/voip/video/a/b:d	([BIIII)V
    //   727: aload_0
    //   728: aconst_null
    //   729: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   732: aload_0
    //   733: getfield 700	com/tencent/mm/plugin/voip/video/OpenGlRender:AOE	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   736: ifnull +27 -> 763
    //   739: aload_0
    //   740: getfield 433	com/tencent/mm/plugin/voip/video/OpenGlRender:AOt	I
    //   743: iconst_3
    //   744: if_icmpne +1444 -> 2188
    //   747: aload_0
    //   748: getfield 700	com/tencent/mm/plugin/voip/video/OpenGlRender:AOE	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   751: aload_0
    //   752: getfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:AOD	J
    //   755: invokestatic 704	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   758: invokeinterface 707 3 0
    //   763: aload_0
    //   764: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:AOC	Z
    //   767: ifeq +24 -> 791
    //   770: aload_0
    //   771: getfield 700	com/tencent/mm/plugin/voip/video/OpenGlRender:AOE	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   774: ifnull +17 -> 791
    //   777: aload_0
    //   778: iconst_0
    //   779: putfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:AOC	Z
    //   782: aload_0
    //   783: getfield 700	com/tencent/mm/plugin/voip/video/OpenGlRender:AOE	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   786: invokeinterface 710 1 0
    //   791: ldc_w 496
    //   794: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   797: return
    //   798: iconst_0
    //   799: istore_2
    //   800: goto -676 -> 124
    //   803: iconst_0
    //   804: istore_3
    //   805: goto -669 -> 136
    //   808: aload_0
    //   809: getfield 216	com/tencent/mm/plugin/voip/video/OpenGlRender:AOp	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   812: aload_0
    //   813: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   816: aload_0
    //   817: getfield 425	com/tencent/mm/plugin/voip/video/OpenGlRender:AOl	I
    //   820: aload_0
    //   821: getfield 427	com/tencent/mm/plugin/voip/video/OpenGlRender:AOm	I
    //   824: aload_0
    //   825: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:AOn	I
    //   828: aload_0
    //   829: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:AOs	I
    //   832: invokevirtual 698	com/tencent/mm/plugin/voip/video/a/b:d	([BIIII)V
    //   835: goto -108 -> 727
    //   838: aload_0
    //   839: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:AOq	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   842: ifnull -115 -> 727
    //   845: iconst_0
    //   846: istore 4
    //   848: iload 4
    //   850: istore_2
    //   851: aload_0
    //   852: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:AOr	Z
    //   855: ifeq +15 -> 870
    //   858: iload 4
    //   860: istore_2
    //   861: iload_3
    //   862: ifeq +8 -> 870
    //   865: aload_0
    //   866: getfield 281	com/tencent/mm/plugin/voip/video/OpenGlRender:AOs	I
    //   869: istore_2
    //   870: aload_0
    //   871: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:AOq	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   874: iconst_0
    //   875: invokevirtual 399	com/tencent/mm/plugin/voip/video/b/g:Tc	(I)V
    //   878: aload_0
    //   879: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:AOq	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   882: astore 11
    //   884: aload_0
    //   885: getfield 425	com/tencent/mm/plugin/voip/video/OpenGlRender:AOl	I
    //   888: istore_3
    //   889: aload_0
    //   890: getfield 427	com/tencent/mm/plugin/voip/video/OpenGlRender:AOm	I
    //   893: istore 4
    //   895: aload_0
    //   896: getfield 198	com/tencent/mm/plugin/voip/video/OpenGlRender:AOc	I
    //   899: istore 6
    //   901: aload_0
    //   902: getfield 200	com/tencent/mm/plugin/voip/video/OpenGlRender:AOd	I
    //   905: istore 7
    //   907: aload_0
    //   908: getfield 433	com/tencent/mm/plugin/voip/video/OpenGlRender:AOt	I
    //   911: istore 5
    //   913: aload_0
    //   914: getfield 429	com/tencent/mm/plugin/voip/video/OpenGlRender:AOn	I
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
    //   952: putfield 713	com/tencent/mm/plugin/voip/video/b/g:ARg	I
    //   955: iload_3
    //   956: aload 11
    //   958: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   961: if_icmpne +63 -> 1024
    //   964: iload 4
    //   966: aload 11
    //   968: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   971: if_icmpne +53 -> 1024
    //   974: iload 6
    //   976: aload 11
    //   978: getfield 722	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   981: if_icmpne +43 -> 1024
    //   984: iload 7
    //   986: aload 11
    //   988: getfield 725	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   991: if_icmpne +33 -> 1024
    //   994: aload 11
    //   996: getfield 728	com/tencent/mm/plugin/voip/video/b/g:zlw	I
    //   999: iload 9
    //   1001: if_icmpne +23 -> 1024
    //   1004: aload 11
    //   1006: getfield 731	com/tencent/mm/plugin/voip/video/b/g:ARf	Z
    //   1009: iload 10
    //   1011: if_icmpne +13 -> 1024
    //   1014: aload 11
    //   1016: getfield 734	com/tencent/mm/plugin/voip/video/b/g:ARa	I
    //   1019: iload 5
    //   1021: if_icmpeq +430 -> 1451
    //   1024: aload 11
    //   1026: iload 9
    //   1028: putfield 728	com/tencent/mm/plugin/voip/video/b/g:zlw	I
    //   1031: aload 11
    //   1033: iload 10
    //   1035: putfield 731	com/tencent/mm/plugin/voip/video/b/g:ARf	Z
    //   1038: aload 11
    //   1040: iload 5
    //   1042: putfield 734	com/tencent/mm/plugin/voip/video/b/g:ARa	I
    //   1045: ldc_w 736
    //   1048: ldc_w 738
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
    //   1068: getfield 728	com/tencent/mm/plugin/voip/video/b/g:zlw	I
    //   1071: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1074: aastore
    //   1075: dup
    //   1076: iconst_2
    //   1077: aload 11
    //   1079: getfield 731	com/tencent/mm/plugin/voip/video/b/g:ARf	Z
    //   1082: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
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
    //   1123: getfield 741	com/tencent/mm/plugin/voip/video/b/g:grS	I
    //   1126: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1129: aastore
    //   1130: dup
    //   1131: bipush 8
    //   1133: aload 11
    //   1135: getfield 744	com/tencent/mm/plugin/voip/video/b/g:ARj	I
    //   1138: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1141: aastore
    //   1142: dup
    //   1143: bipush 9
    //   1145: aload 11
    //   1147: getfield 747	com/tencent/mm/plugin/voip/video/b/g:ARk	I
    //   1150: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1153: aastore
    //   1154: dup
    //   1155: bipush 10
    //   1157: aload 11
    //   1159: getfield 713	com/tencent/mm/plugin/voip/video/b/g:ARg	I
    //   1162: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1165: aastore
    //   1166: invokestatic 340	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1169: aload 11
    //   1171: iload_3
    //   1172: putfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1175: aload 11
    //   1177: iload 4
    //   1179: putfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1182: aload 11
    //   1184: iload 6
    //   1186: putfield 722	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   1189: aload 11
    //   1191: iload 7
    //   1193: putfield 725	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   1196: aload 11
    //   1198: aload 11
    //   1200: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1203: aload 11
    //   1205: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1208: invokevirtual 750	com/tencent/mm/plugin/voip/video/b/g:iq	(II)V
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
    //   1232: invokestatic 753	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1235: putfield 757	com/tencent/mm/plugin/voip/video/b/g:ARb	Ljava/nio/ByteBuffer;
    //   1238: aload 11
    //   1240: iload_2
    //   1241: invokestatic 753	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1244: putfield 760	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1247: aload 11
    //   1249: iload 6
    //   1251: invokestatic 753	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1254: putfield 763	com/tencent/mm/plugin/voip/video/b/g:ARc	Ljava/nio/ByteBuffer;
    //   1257: aload 11
    //   1259: iload 6
    //   1261: invokestatic 753	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1264: putfield 766	com/tencent/mm/plugin/voip/video/b/g:ARd	Ljava/nio/ByteBuffer;
    //   1267: aload 11
    //   1269: iload 6
    //   1271: iconst_2
    //   1272: imul
    //   1273: invokestatic 753	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1276: putfield 769	com/tencent/mm/plugin/voip/video/b/g:ARe	Ljava/nio/ByteBuffer;
    //   1279: aload 11
    //   1281: monitorexit
    //   1282: aload 11
    //   1284: getfield 773	com/tencent/mm/plugin/voip/video/b/g:AQV	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1287: ifnull +164 -> 1451
    //   1290: iload 5
    //   1292: iconst_3
    //   1293: if_icmpne +158 -> 1451
    //   1296: aload 11
    //   1298: getfield 773	com/tencent/mm/plugin/voip/video/b/g:AQV	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1301: astore 11
    //   1303: ldc_w 775
    //   1306: ldc_w 777
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
    //   1332: getfield 782	com/tencent/mm/plugin/voip/video/b/d:grA	I
    //   1335: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1338: aastore
    //   1339: dup
    //   1340: iconst_3
    //   1341: aload 11
    //   1343: getfield 785	com/tencent/mm/plugin/voip/video/b/d:grB	I
    //   1346: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1349: aastore
    //   1350: invokestatic 340	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1353: iload_3
    //   1354: aload 11
    //   1356: getfield 782	com/tencent/mm/plugin/voip/video/b/d:grA	I
    //   1359: if_icmpne +13 -> 1372
    //   1362: aload 11
    //   1364: getfield 785	com/tencent/mm/plugin/voip/video/b/d:grB	I
    //   1367: iload 4
    //   1369: if_icmpeq +82 -> 1451
    //   1372: aload 11
    //   1374: iload_3
    //   1375: putfield 782	com/tencent/mm/plugin/voip/video/b/d:grA	I
    //   1378: aload 11
    //   1380: iload 4
    //   1382: putfield 785	com/tencent/mm/plugin/voip/video/b/d:grB	I
    //   1385: aload 11
    //   1387: getfield 789	com/tencent/mm/plugin/voip/video/b/d:AQI	Lcom/tencent/mm/plugin/voip/video/b/b;
    //   1390: astore 11
    //   1392: ldc_w 775
    //   1395: ldc_w 791
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
    //   1421: getfield 796	com/tencent/mm/plugin/voip/video/b/b:surfaceWidth	I
    //   1424: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1427: aastore
    //   1428: dup
    //   1429: iconst_3
    //   1430: aload 11
    //   1432: getfield 799	com/tencent/mm/plugin/voip/video/b/b:surfaceHeight	I
    //   1435: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1438: aastore
    //   1439: invokestatic 340	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1442: iload_3
    //   1443: ifle +8 -> 1451
    //   1446: iload 4
    //   1448: ifgt +228 -> 1676
    //   1451: aload_0
    //   1452: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:AOq	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1455: astore 11
    //   1457: aload_0
    //   1458: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   1461: astore 12
    //   1463: aload_0
    //   1464: getfield 433	com/tencent/mm/plugin/voip/video/OpenGlRender:AOt	I
    //   1467: istore_2
    //   1468: aload 11
    //   1470: monitorenter
    //   1471: aload 11
    //   1473: iconst_0
    //   1474: putfield 802	com/tencent/mm/plugin/voip/video/b/g:ARi	Z
    //   1477: aload 11
    //   1479: getfield 805	com/tencent/mm/plugin/voip/video/b/g:ARh	Z
    //   1482: ifeq +162 -> 1644
    //   1485: aload 12
    //   1487: ifnull +157 -> 1644
    //   1490: aload 11
    //   1492: iload_2
    //   1493: putfield 734	com/tencent/mm/plugin/voip/video/b/g:ARa	I
    //   1496: aload 11
    //   1498: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1501: aload 11
    //   1503: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
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
    //   1528: getfield 757	com/tencent/mm/plugin/voip/video/b/g:ARb	Ljava/nio/ByteBuffer;
    //   1531: invokevirtual 809	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1534: pop
    //   1535: aload 11
    //   1537: getfield 760	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1540: invokevirtual 809	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1543: pop
    //   1544: aload 11
    //   1546: getfield 769	com/tencent/mm/plugin/voip/video/b/g:ARe	Ljava/nio/ByteBuffer;
    //   1549: invokevirtual 809	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1552: pop
    //   1553: aload 11
    //   1555: getfield 757	com/tencent/mm/plugin/voip/video/b/g:ARb	Ljava/nio/ByteBuffer;
    //   1558: aload 12
    //   1560: iconst_0
    //   1561: aload 11
    //   1563: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1566: aload 11
    //   1568: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1571: imul
    //   1572: iconst_3
    //   1573: imul
    //   1574: iconst_2
    //   1575: idiv
    //   1576: invokevirtual 812	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1579: pop
    //   1580: aload 11
    //   1582: getfield 760	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1585: aload 12
    //   1587: iconst_0
    //   1588: aload 11
    //   1590: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1593: aload 11
    //   1595: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1598: imul
    //   1599: invokevirtual 812	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1602: pop
    //   1603: aload 11
    //   1605: getfield 769	com/tencent/mm/plugin/voip/video/b/g:ARe	Ljava/nio/ByteBuffer;
    //   1608: aload 12
    //   1610: aload 11
    //   1612: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1615: aload 11
    //   1617: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1620: imul
    //   1621: aload 11
    //   1623: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1626: aload 11
    //   1628: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1631: imul
    //   1632: iconst_2
    //   1633: idiv
    //   1634: invokevirtual 812	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1637: pop
    //   1638: aload 11
    //   1640: iconst_1
    //   1641: putfield 802	com/tencent/mm/plugin/voip/video/b/g:ARi	Z
    //   1644: aload 11
    //   1646: monitorexit
    //   1647: aload_0
    //   1648: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:AOq	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1651: aload_1
    //   1652: invokevirtual 814	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1655: goto -928 -> 727
    //   1658: iconst_0
    //   1659: istore 10
    //   1661: goto -712 -> 949
    //   1664: astore_1
    //   1665: aload 11
    //   1667: monitorexit
    //   1668: ldc_w 496
    //   1671: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1674: aload_1
    //   1675: athrow
    //   1676: aload 11
    //   1678: getfield 815	com/tencent/mm/plugin/voip/video/b/b:grA	I
    //   1681: iload_3
    //   1682: if_icmpne +13 -> 1695
    //   1685: aload 11
    //   1687: getfield 816	com/tencent/mm/plugin/voip/video/b/b:grB	I
    //   1690: iload 4
    //   1692: if_icmpeq -241 -> 1451
    //   1695: aload 11
    //   1697: iload_3
    //   1698: putfield 815	com/tencent/mm/plugin/voip/video/b/b:grA	I
    //   1701: aload 11
    //   1703: iload 4
    //   1705: putfield 816	com/tencent/mm/plugin/voip/video/b/b:grB	I
    //   1708: ldc_w 775
    //   1711: ldc_w 818
    //   1714: iconst_2
    //   1715: anewarray 4	java/lang/Object
    //   1718: dup
    //   1719: iconst_0
    //   1720: aload 11
    //   1722: getfield 815	com/tencent/mm/plugin/voip/video/b/b:grA	I
    //   1725: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1728: aastore
    //   1729: dup
    //   1730: iconst_1
    //   1731: aload 11
    //   1733: getfield 816	com/tencent/mm/plugin/voip/video/b/b:grB	I
    //   1736: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1739: aastore
    //   1740: invokestatic 340	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1743: aload 11
    //   1745: aload 11
    //   1747: getfield 815	com/tencent/mm/plugin/voip/video/b/b:grA	I
    //   1750: aload 11
    //   1752: getfield 816	com/tencent/mm/plugin/voip/video/b/b:grB	I
    //   1755: invokevirtual 821	com/tencent/mm/plugin/voip/video/b/b:io	(II)V
    //   1758: goto -307 -> 1451
    //   1761: ldc_w 736
    //   1764: ldc_w 823
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
    //   1792: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1795: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1798: aastore
    //   1799: dup
    //   1800: iconst_3
    //   1801: aload 11
    //   1803: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1806: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1809: aastore
    //   1810: invokestatic 493	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1813: aload 11
    //   1815: iconst_0
    //   1816: putfield 802	com/tencent/mm/plugin/voip/video/b/g:ARi	Z
    //   1819: getstatic 829	com/tencent/mm/plugin/voip/model/t:AEB	Lcom/tencent/mm/plugin/voip/model/t;
    //   1822: astore 12
    //   1824: invokestatic 832	com/tencent/mm/plugin/voip/model/t:ejC	()V
    //   1827: goto -183 -> 1644
    //   1830: astore_1
    //   1831: aload 11
    //   1833: monitorexit
    //   1834: ldc_w 496
    //   1837: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1840: aload_1
    //   1841: athrow
    //   1842: aload 11
    //   1844: aload 11
    //   1846: getfield 744	com/tencent/mm/plugin/voip/video/b/g:ARj	I
    //   1849: iconst_1
    //   1850: iadd
    //   1851: putfield 744	com/tencent/mm/plugin/voip/video/b/g:ARj	I
    //   1854: aload 11
    //   1856: getfield 744	com/tencent/mm/plugin/voip/video/b/g:ARj	I
    //   1859: bipush 100
    //   1861: irem
    //   1862: ifne +60 -> 1922
    //   1865: ldc_w 736
    //   1868: ldc_w 834
    //   1871: iconst_4
    //   1872: anewarray 4	java/lang/Object
    //   1875: dup
    //   1876: iconst_0
    //   1877: aload 11
    //   1879: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1882: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1885: aastore
    //   1886: dup
    //   1887: iconst_1
    //   1888: aload 11
    //   1890: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1893: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1896: aastore
    //   1897: dup
    //   1898: iconst_2
    //   1899: aload 11
    //   1901: getfield 744	com/tencent/mm/plugin/voip/video/b/g:ARj	I
    //   1904: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1907: aastore
    //   1908: dup
    //   1909: iconst_3
    //   1910: aload 11
    //   1912: getfield 713	com/tencent/mm/plugin/voip/video/b/g:ARg	I
    //   1915: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1918: aastore
    //   1919: invokestatic 340	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1922: aload 12
    //   1924: arraylength
    //   1925: iload 5
    //   1927: if_icmplt +192 -> 2119
    //   1930: aload 11
    //   1932: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1935: istore 6
    //   1937: aload 11
    //   1939: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1942: istore 7
    //   1944: aload 11
    //   1946: getfield 744	com/tencent/mm/plugin/voip/video/b/g:ARj	I
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
    //   1988: getfield 760	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1991: invokevirtual 809	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1994: pop
    //   1995: aload 11
    //   1997: getfield 763	com/tencent/mm/plugin/voip/video/b/g:ARc	Ljava/nio/ByteBuffer;
    //   2000: invokevirtual 809	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2003: pop
    //   2004: aload 11
    //   2006: getfield 766	com/tencent/mm/plugin/voip/video/b/g:ARd	Ljava/nio/ByteBuffer;
    //   2009: invokevirtual 809	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2012: pop
    //   2013: aload 11
    //   2015: getfield 760	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   2018: aload 12
    //   2020: iconst_0
    //   2021: aload 11
    //   2023: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2026: aload 11
    //   2028: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2031: imul
    //   2032: invokevirtual 812	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2035: pop
    //   2036: aload 11
    //   2038: getfield 763	com/tencent/mm/plugin/voip/video/b/g:ARc	Ljava/nio/ByteBuffer;
    //   2041: aload 12
    //   2043: aload 11
    //   2045: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2048: aload 11
    //   2050: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2053: imul
    //   2054: aload 11
    //   2056: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2059: aload 11
    //   2061: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2064: imul
    //   2065: iconst_4
    //   2066: idiv
    //   2067: invokevirtual 812	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2070: pop
    //   2071: aload 11
    //   2073: getfield 766	com/tencent/mm/plugin/voip/video/b/g:ARd	Ljava/nio/ByteBuffer;
    //   2076: aload 12
    //   2078: aload 11
    //   2080: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2083: aload 11
    //   2085: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2088: imul
    //   2089: iconst_5
    //   2090: imul
    //   2091: iconst_4
    //   2092: idiv
    //   2093: aload 11
    //   2095: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2098: aload 11
    //   2100: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2103: imul
    //   2104: iconst_4
    //   2105: idiv
    //   2106: invokevirtual 812	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2109: pop
    //   2110: aload 11
    //   2112: iconst_1
    //   2113: putfield 802	com/tencent/mm/plugin/voip/video/b/g:ARi	Z
    //   2116: goto -472 -> 1644
    //   2119: ldc_w 736
    //   2122: ldc_w 836
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
    //   2150: getfield 716	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2153: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2156: aastore
    //   2157: dup
    //   2158: iconst_3
    //   2159: aload 11
    //   2161: getfield 719	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2164: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2167: aastore
    //   2168: invokestatic 493	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2171: aload 11
    //   2173: iconst_0
    //   2174: putfield 802	com/tencent/mm/plugin/voip/video/b/g:ARi	Z
    //   2177: getstatic 829	com/tencent/mm/plugin/voip/model/t:AEB	Lcom/tencent/mm/plugin/voip/model/t;
    //   2180: astore 12
    //   2182: invokestatic 839	com/tencent/mm/plugin/voip/model/t:ejD	()V
    //   2185: goto -541 -> 1644
    //   2188: aload_0
    //   2189: getfield 700	com/tencent/mm/plugin/voip/video/OpenGlRender:AOE	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2192: aload_0
    //   2193: getfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:AOD	J
    //   2196: invokestatic 704	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   2199: invokeinterface 842 3 0
    //   2204: goto -1441 -> 763
    //   2207: aload_0
    //   2208: invokestatic 506	com/tencent/mm/sdk/platformtools/bs:Gn	()J
    //   2211: putfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:AOD	J
    //   2214: aload_0
    //   2215: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:ANY	Z
    //   2218: ifeq +20 -> 2238
    //   2221: aload_0
    //   2222: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:ANX	Z
    //   2225: ifeq +13 -> 2238
    //   2228: aload_0
    //   2229: getfield 259	com/tencent/mm/plugin/voip/video/OpenGlRender:AOe	Ljava/lang/ref/WeakReference;
    //   2232: invokevirtual 310	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2235: ifnonnull +63 -> 2298
    //   2238: aload_0
    //   2239: aconst_null
    //   2240: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   2243: aload_0
    //   2244: aconst_null
    //   2245: putfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:AOk	[I
    //   2248: getstatic 118	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   2251: ldc_w 844
    //   2254: iconst_3
    //   2255: anewarray 4	java/lang/Object
    //   2258: dup
    //   2259: iconst_0
    //   2260: aload_0
    //   2261: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:ANY	Z
    //   2264: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2267: aastore
    //   2268: dup
    //   2269: iconst_1
    //   2270: aload_0
    //   2271: getfield 188	com/tencent/mm/plugin/voip/video/OpenGlRender:ANX	Z
    //   2274: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2277: aastore
    //   2278: dup
    //   2279: iconst_2
    //   2280: aload_0
    //   2281: getfield 431	com/tencent/mm/plugin/voip/video/OpenGlRender:AOr	Z
    //   2284: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2287: aastore
    //   2288: invokestatic 500	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2291: ldc_w 496
    //   2294: invokestatic 164	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2297: return
    //   2298: aload_0
    //   2299: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:AOq	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2302: ifnull +33 -> 2335
    //   2305: aload_0
    //   2306: getfield 236	com/tencent/mm/plugin/voip/video/OpenGlRender:AOH	Z
    //   2309: ifeq +8 -> 2317
    //   2312: aload_0
    //   2313: iconst_1
    //   2314: invokespecial 403	com/tencent/mm/plugin/voip/video/OpenGlRender:sV	(Z)V
    //   2317: aload_0
    //   2318: getfield 286	com/tencent/mm/plugin/voip/video/OpenGlRender:AOq	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2321: aload_1
    //   2322: invokevirtual 814	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   2325: aload_0
    //   2326: aconst_null
    //   2327: putfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:AOj	[B
    //   2330: aload_0
    //   2331: aconst_null
    //   2332: putfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:AOk	[I
    //   2335: aload_0
    //   2336: getfield 700	com/tencent/mm/plugin/voip/video/OpenGlRender:AOE	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2339: ifnull -1576 -> 763
    //   2342: aload_0
    //   2343: getfield 700	com/tencent/mm/plugin/voip/video/OpenGlRender:AOE	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2346: aload_0
    //   2347: getfield 234	com/tencent/mm/plugin/voip/video/OpenGlRender:AOD	J
    //   2350: invokestatic 704	com/tencent/mm/sdk/platformtools/bs:aO	(J)J
    //   2353: invokeinterface 847 3 0
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
    this.ANY = true;
    requestRender();
    AppMethodBeat.o(115659);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115657);
    ac.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d, lastHWDecSize:%dx%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.AOr), Integer.valueOf(this.AOc), Integer.valueOf(this.AOd), Integer.valueOf(this.mRenderMode), Integer.valueOf(this.AAu), Integer.valueOf(this.AAv) });
    if ((this.AOc != paramInt1) || (this.AOd != paramInt2))
    {
      paramGL10.glViewport(0, 0, paramInt1, paramInt2);
      this.AOc = paramInt1;
      this.AOd = paramInt2;
    }
    if (this.AOp != null) {
      this.AOp.in(paramInt1, paramInt2);
    }
    if (this.AOq != null) {
      this.AOq.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
    Ta(this.AOw);
    ie(this.AAu, this.AAv);
    AppMethodBeat.o(115657);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(115658);
    ac.i(TAG, "onSurfaceCreated...");
    if (getGLVersion() == 2)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glDisable(2929);
    }
    if (this.AOq != null) {
      this.AOq.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    if (v2protocal.AIl == null)
    {
      paramGL10 = e.emX();
      try
      {
        paramGL10.AQS = paramGL10.emY();
        paramGL10.AQR.set(false);
        paramEGLConfig = new Surface(paramGL10.AQS);
        v2protocal.mSurfaceTexture = paramGL10.AQS;
        v2protocal.AIm = null;
        v2protocal.AIl = paramEGLConfig;
        paramGL10.AQT.BE();
        AppMethodBeat.o(115658);
        return;
      }
      catch (Exception paramGL10)
      {
        ac.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", paramGL10, "initSurfaceTexutre error", new Object[0]);
        paramGL10 = t.AEB;
        t.ejp();
      }
    }
    AppMethodBeat.o(115658);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115652);
    if ((this.AOe != null) && (this.AOe.get() != null))
    {
      ??? = (OpenGlView)this.AOe.get();
      ac.m(TAG, "releaseSurfaceTexture:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115641);
          ??? = e.emX();
          try
          {
            if (((e)???).AQS != null)
            {
              t localt2 = t.AEB;
              t.ejq();
              if (((e)???).AIm != null) {
                ((e)???).AIm.close();
              }
              ((e)???).AQS.release();
              ((e)???).AQS = null;
              ac.i("MicroMsg.VoipHardDecodeUtil", "uninit surface texture");
            }
          }
          catch (Exception localException1)
          {
            t localt1;
            synchronized (OpenGlRender.emE())
            {
              try
              {
                OpenGlRender.emE().notifyAll();
                AppMethodBeat.o(115641);
                return;
                localException1 = localException1;
                ac.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", localException1, "uninitSurfaceTexture error", new Object[0]);
                localt1 = t.AEB;
                t.ejr();
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ac.printErrStackTrace(OpenGlRender.TAG, localException2, "", new Object[0]);
                }
              }
            }
          }
          ac.i(OpenGlRender.TAG, "releaseSurfaceTexture call finish");
        }
      });
      synchronized (AOz)
      {
        try
        {
          AOz.wait(100L);
          ac.i(TAG, "releaseSurfaceTexture wait finish");
          AppMethodBeat.o(115652);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ac.printErrStackTrace(TAG, localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(115652);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115666);
    if (this.AOe.get() != null) {
      ((OpenGlView)this.AOe.get()).emF();
    }
    AppMethodBeat.o(115666);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115665);
    ac.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.AOr), Integer.valueOf(paramInt), Integer.valueOf(this.AOs) });
    this.AOs = paramInt;
    AppMethodBeat.o(115665);
  }
  
  final class a
    extends ao
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
    public abstract void elr();
    
    public abstract void yR(long paramLong);
    
    public abstract void yS(long paramLong);
    
    public abstract void yT(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender
 * JD-Core Version:    0.7.0.1
 */