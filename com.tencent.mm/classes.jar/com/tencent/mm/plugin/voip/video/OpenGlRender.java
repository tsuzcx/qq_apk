package com.tencent.mm.plugin.voip.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.plugin.voip.video.b.c;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.d.b.b;
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
  private static final Object HiJ;
  private static final Object HiK;
  private static final Object HiL;
  private static final Object HiM;
  static boolean HiS;
  public static int His;
  public static int MSG_FLUSH;
  public static int MSG_RENDER;
  public static int MSG_RESET;
  public static int RenderLocal;
  public static int RenderRemote;
  static String TAG;
  public int GUK;
  public int GUL;
  boolean HhU;
  int HhV;
  long HhW;
  long HhX;
  int HhY;
  a HhZ;
  private int HiA;
  private int HiB;
  private boolean HiC;
  private int HiD;
  private int HiE;
  private int HiF;
  private volatile boolean HiG;
  private volatile boolean HiH;
  public int HiI;
  public int HiN;
  public boolean HiO;
  long HiP;
  public b HiQ;
  WeakReference<Object> HiR;
  private boolean HiT;
  boolean HiU;
  boolean Hia;
  boolean Hib;
  boolean Hic;
  boolean Hid;
  boolean Hie;
  int Hif;
  int Hig;
  public WeakReference<OpenGlView> Hih;
  public boolean Hii;
  public Bitmap Hij;
  private int Hik;
  private int Hil;
  private byte[] Him;
  private int[] Hin;
  private int Hio;
  private int Hip;
  private int Hiq;
  public int Hir;
  private com.tencent.mm.plugin.voip.video.a.b Hit;
  com.tencent.mm.plugin.voip.video.b.g Hiu;
  public com.tencent.mm.plugin.xlabeffect.b Hiv;
  public byte[] Hiw;
  public int Hix;
  public int Hiy;
  public boolean Hiz;
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
    His = 0;
    HiJ = new Object();
    HiK = new Object();
    HiL = new Object();
    HiM = new Object();
    HiS = false;
    AppMethodBeat.o(115668);
  }
  
  public OpenGlRender(OpenGlView paramOpenGlView, int paramInt)
  {
    AppMethodBeat.i(115648);
    this.HhU = false;
    this.HhV = 0;
    this.HhW = 0L;
    this.HhX = 0L;
    this.HhY = 0;
    this.mBrightness = 1.2F;
    this.mContrast = 1.93F;
    this.mSaturation = 1.05F;
    this.Hia = false;
    this.Hib = false;
    this.Hic = false;
    this.Hid = false;
    this.Hie = false;
    this.Hif = 0;
    this.Hig = 0;
    this.mRenderMode = RenderLocal;
    this.Hii = false;
    this.Hij = null;
    this.Hik = 0;
    this.Hil = 0;
    this.Him = null;
    this.Hin = null;
    this.Hir = 0;
    this.Hit = null;
    this.Hiv = null;
    this.Hiz = false;
    this.HiG = false;
    this.HiH = false;
    this.HiI = 0;
    this.HiN = 0;
    this.GUK = 0;
    this.GUL = 0;
    this.HiO = false;
    this.HiP = -1L;
    this.HiT = false;
    this.HiU = false;
    if (!HiS)
    {
      OpenGlRender.class.getClassLoader();
      j.Ed("mm_gl_disp");
      HiS = true;
    }
    this.mRenderMode = paramInt;
    this.Hih = new WeakReference(paramOpenGlView);
    paramOpenGlView = Looper.myLooper();
    if (paramOpenGlView != null) {
      this.HhZ = new a(paramOpenGlView);
    }
    for (;;)
    {
      this.HiR = null;
      if (getGLVersion() == 2) {
        this.Hit = new com.tencent.mm.plugin.voip.video.a.b();
      }
      this.HiD = 0;
      this.HiE = 0;
      this.Hiu = new com.tencent.mm.plugin.voip.video.b.g();
      this.HiA = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXf, 0);
      this.HiB = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXg, 0);
      Log.d(TAG, "WeEffect face beauty skin smooth param %d", new Object[] { Integer.valueOf(this.HiA) });
      Log.d(TAG, "WeEffect face beauty skin bright param %d", new Object[] { Integer.valueOf(this.HiB) });
      if (this.HiA < 0) {
        this.HiA = 0;
      }
      if (this.HiA >= 100) {
        this.HiA = 100;
      }
      if (this.HiB < 0) {
        this.HiB = 0;
      }
      if (this.HiB >= 100) {
        this.HiB = 100;
      }
      if ((this.HiA != 0) && (this.HiB != 0)) {
        this.Hiz = true;
      }
      this.Him = null;
      AppMethodBeat.o(115648);
      return;
      paramOpenGlView = Looper.getMainLooper();
      if (paramOpenGlView != null) {
        this.HhZ = new a(paramOpenGlView);
      } else {
        this.HhZ = null;
      }
    }
  }
  
  private native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  private native void Uninit(int paramInt);
  
  private void fKO()
  {
    AppMethodBeat.i(115662);
    if (this.Hit != null)
    {
      if (this.Hih != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)this.Hih.get();
        if (localOpenGlView != null)
        {
          localOpenGlView.queueEvent(new Runnable()
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
      if (this.Hit != null) {
        this.Hit.destroy();
      }
    }
    AppMethodBeat.o(115662);
  }
  
  public static int getGLVersion()
  {
    AppMethodBeat.i(115647);
    if (His == 0)
    {
      His = 2;
      Log.i(TAG, "init gl version: %s", new Object[] { Integer.valueOf(His) });
    }
    int i = His;
    AppMethodBeat.o(115647);
    return i;
  }
  
  private native void render32(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void render8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setParam(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  private void xu(boolean paramBoolean)
  {
    AppMethodBeat.i(115664);
    if ((this.Hih != null) && (this.Hih.get() != null))
    {
      if (!paramBoolean)
      {
        ??? = (OpenGlView)this.Hih.get();
        Log.i(TAG, "attachGLContext:%s", new Object[] { ??? });
        ((OpenGlView)???).queueEvent(new Runnable()
        {
          public final void run()
          {
            boolean bool = false;
            AppMethodBeat.i(235829);
            if (OpenGlRender.l(OpenGlRender.this))
            {
              Log.i(OpenGlRender.TAG, "attachGLContext");
              ??? = OpenGlRender.this;
              if (!OpenGlRender.f(OpenGlRender.this).fLM()) {
                bool = true;
              }
              OpenGlRender.a((OpenGlRender)???, bool);
              OpenGlRender.j(OpenGlRender.this);
              OpenGlRender.k(OpenGlRender.this);
              Log.i(OpenGlRender.TAG, "attach finish");
            }
            synchronized (OpenGlRender.fKS())
            {
              try
              {
                OpenGlRender.fKS().notifyAll();
                AppMethodBeat.o(235829);
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
        synchronized (HiK)
        {
          try
          {
            HiK.wait(100L);
            Log.i(TAG, "attachGLContext wait finish, bNeedAttach:%s", new Object[] { Boolean.valueOf(this.HiT) });
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
      if (this.HiT)
      {
        Log.i(TAG, "attachGLContext");
        if (this.Hiu.fLM()) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.HiT = paramBoolean;
      this.Him = null;
      this.Hin = null;
      Log.i(TAG, "attach finish");
      AppMethodBeat.o(115664);
      return;
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
      if ((this.Hiu != null) && (this.Hiu.fLJ() != null))
      {
        paramb.a(this.Hiu.fLJ());
        AppMethodBeat.o(115667);
        return;
        if ((this.Hit != null) && (this.Hit.fLB() != null)) {
          paramb.a(this.Hit.fLB());
        }
      }
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, com.tencent.mm.media.g.d paramd)
  {
    AppMethodBeat.i(115651);
    if (this.Hiu != null) {
      this.Hiu.a(paramSurfaceTexture, paramd);
    }
    AppMethodBeat.o(115651);
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(235831);
    if ((this.Hiu != null) && (this.Hiu.fJk() != null)) {
      paramb.a(this.Hiu.fJk());
    }
    AppMethodBeat.o(235831);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(115653);
    if ((this.Hia) && (this.Him == null))
    {
      this.Hio = paramInt1;
      this.Hip = paramInt2;
      this.Hiq = paramInt3;
      this.Him = paramArrayOfByte;
      this.HiC = paramBoolean;
      this.HiF = paramInt4;
      requestRender();
    }
    AppMethodBeat.o(115653);
  }
  
  public final void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(115655);
    if ((this.Hia) && (this.Hin == null))
    {
      this.Hio = paramInt1;
      this.Hip = paramInt2;
      this.Hiq = paramInt3;
      this.Hin = paramArrayOfInt;
      this.HiC = paramBoolean;
      requestRender();
    }
    AppMethodBeat.o(115655);
  }
  
  public final void fKM()
  {
    AppMethodBeat.i(115660);
    Log.i(TAG, "%s onStop, renderMode: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
    this.Hib = false;
    this.Hie = false;
    AppMethodBeat.o(115660);
  }
  
  public final void fKN()
  {
    AppMethodBeat.i(115661);
    Log.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.Hia), Boolean.valueOf(this.Hib) });
    if ((this.Hia) && (this.Hib))
    {
      Log.i(TAG, "%s steve: Reset GLRender first! mode=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
      if (this.Hiu != null)
      {
        Log.i(TAG, "onResetRender need detach");
        this.HiU = true;
        fKP();
      }
      this.Hia = false;
      this.Hib = false;
      fKO();
    }
    AppMethodBeat.o(115661);
  }
  
  final void fKP()
  {
    AppMethodBeat.i(115663);
    if ((this.Hih != null) && (this.Hih.get() != null))
    {
      ??? = (OpenGlView)this.Hih.get();
      Log.i(TAG, "detachGLContext:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(161661);
          if (OpenGlRender.h(OpenGlRender.this))
          {
            OpenGlRender.f(OpenGlRender.this).fLN();
            OpenGlRender.i(OpenGlRender.this);
            OpenGlRender.j(OpenGlRender.this);
            OpenGlRender.k(OpenGlRender.this);
            Log.i(OpenGlRender.TAG, "detach finish");
          }
          synchronized (OpenGlRender.fKR())
          {
            try
            {
              OpenGlRender.fKR().notifyAll();
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
      synchronized (HiJ)
      {
        try
        {
          HiJ.wait(100L);
          Log.i(TAG, "detachGLContext wait finish, bNeedDetach:%s", new Object[] { Boolean.valueOf(this.HiU) });
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
    if (this.HiU) {
      ((OpenGlView)this.Hih.get()).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235828);
          OpenGlRender.f(OpenGlRender.this).fLN();
          OpenGlRender.i(OpenGlRender.this);
          OpenGlRender.j(OpenGlRender.this);
          OpenGlRender.k(OpenGlRender.this);
          Log.i(OpenGlRender.TAG, "detach finish");
          AppMethodBeat.o(235828);
        }
      });
    }
    AppMethodBeat.o(115663);
  }
  
  public final void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(115654);
    if ((this.Hia) && (this.Him == null))
    {
      this.Hio = paramInt1;
      this.Hip = paramInt2;
      this.Hiq = paramInt3;
      this.Him = paramArrayOfByte;
      this.HiC = false;
      requestRender();
    }
    AppMethodBeat.o(115654);
  }
  
  public final void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115656);
    Log.i(TAG, "video=" + paramInt1 + "x" + paramInt2);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.GUK = paramInt1;
      this.GUL = paramInt2;
      if (this.Hiu != null) {
        this.Hiu.jK(paramInt1, paramInt2);
      }
      AppMethodBeat.o(115656);
      return;
    }
    Log.e(TAG, "ERROR video size:%dx%d, lastviddeosize:%dx%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.GUK), Integer.valueOf(this.GUL) });
    AppMethodBeat.o(115656);
  }
  
  /* Error */
  public final void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: ldc_w 558
    //   3: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 242	com/tencent/mm/plugin/voip/video/OpenGlRender:HiI	I
    //   10: ifne +2482 -> 2492
    //   13: aload_0
    //   14: getfield 204	com/tencent/mm/plugin/voip/video/OpenGlRender:Hib	Z
    //   17: ifeq +20 -> 37
    //   20: aload_0
    //   21: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:Hia	Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 279	com/tencent/mm/plugin/voip/video/OpenGlRender:Hih	Ljava/lang/ref/WeakReference;
    //   31: invokevirtual 379	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   34: ifnonnull +63 -> 97
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 228	com/tencent/mm/plugin/voip/video/OpenGlRender:Hin	[I
    //   47: getstatic 132	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   50: ldc_w 560
    //   53: iconst_3
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 204	com/tencent/mm/plugin/voip/video/OpenGlRender:Hib	Z
    //   63: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_0
    //   70: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:Hia	Z
    //   73: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: aload_0
    //   80: getfield 491	com/tencent/mm/plugin/voip/video/OpenGlRender:HiC	Z
    //   83: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: ldc_w 558
    //   93: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: aload_0
    //   98: getfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   101: ifnull +765 -> 866
    //   104: aload_0
    //   105: invokestatic 566	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   108: putfield 254	com/tencent/mm/plugin/voip/video/OpenGlRender:HiP	J
    //   111: aload_0
    //   112: getfield 489	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiq	I
    //   115: getstatic 156	com/tencent/mm/plugin/voip/video/OpenGlRender:FLAG_Mirror	I
    //   118: iand
    //   119: ifeq +782 -> 901
    //   122: iconst_1
    //   123: istore_2
    //   124: aload_0
    //   125: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:HiD	I
    //   128: bipush 8
    //   130: iand
    //   131: ifeq +775 -> 906
    //   134: iconst_1
    //   135: istore_3
    //   136: aload_0
    //   137: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:HiD	I
    //   140: ifne +771 -> 911
    //   143: iconst_0
    //   144: istore 4
    //   146: aload_0
    //   147: iload 4
    //   149: putfield 303	com/tencent/mm/plugin/voip/video/OpenGlRender:HiE	I
    //   152: aload_0
    //   153: getfield 303	com/tencent/mm/plugin/voip/video/OpenGlRender:HiE	I
    //   156: iconst_1
    //   157: iand
    //   158: ifeq +762 -> 920
    //   161: iconst_1
    //   162: istore 4
    //   164: aload_0
    //   165: getfield 232	com/tencent/mm/plugin/voip/video/OpenGlRender:Hit	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   168: ifnull +822 -> 990
    //   171: aload_0
    //   172: getfield 491	com/tencent/mm/plugin/voip/video/OpenGlRender:HiC	Z
    //   175: ifeq +815 -> 990
    //   178: aload_0
    //   179: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:HiD	I
    //   182: ifeq +808 -> 990
    //   185: iload_3
    //   186: ifne +804 -> 990
    //   189: aload_0
    //   190: getfield 232	com/tencent/mm/plugin/voip/video/OpenGlRender:Hit	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   193: astore_1
    //   194: aload_0
    //   195: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:HiD	I
    //   198: istore_3
    //   199: aload_0
    //   200: getfield 303	com/tencent/mm/plugin/voip/video/OpenGlRender:HiE	I
    //   203: istore 4
    //   205: aload_1
    //   206: getfield 569	com/tencent/mm/plugin/voip/video/a/b:htU	Z
    //   209: ifne +574 -> 783
    //   212: aload_1
    //   213: ldc_w 571
    //   216: ldc_w 573
    //   219: invokestatic 577	com/tencent/mm/plugin/voip/video/a/b:aB	(Ljava/lang/String;Ljava/lang/String;)I
    //   222: putfield 580	com/tencent/mm/plugin/voip/video/a/b:ikB	I
    //   225: aload_1
    //   226: getfield 580	com/tencent/mm/plugin/voip/video/a/b:ikB	I
    //   229: ifne +12 -> 241
    //   232: ldc_w 582
    //   235: ldc_w 584
    //   238: invokestatic 586	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_1
    //   242: aload_1
    //   243: getfield 580	com/tencent/mm/plugin/voip/video/a/b:ikB	I
    //   246: ldc_w 588
    //   249: invokestatic 594	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   252: putfield 597	com/tencent/mm/plugin/voip/video/a/b:ikD	I
    //   255: aload_1
    //   256: aload_1
    //   257: getfield 580	com/tencent/mm/plugin/voip/video/a/b:ikB	I
    //   260: ldc_w 599
    //   263: invokestatic 594	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   266: putfield 602	com/tencent/mm/plugin/voip/video/a/b:ikC	I
    //   269: aload_1
    //   270: aload_1
    //   271: getfield 580	com/tencent/mm/plugin/voip/video/a/b:ikB	I
    //   274: ldc_w 604
    //   277: invokestatic 607	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   280: putfield 610	com/tencent/mm/plugin/voip/video/a/b:ikE	I
    //   283: aload_1
    //   284: aload_1
    //   285: getfield 580	com/tencent/mm/plugin/voip/video/a/b:ikB	I
    //   288: ldc_w 612
    //   291: invokestatic 607	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   294: putfield 615	com/tencent/mm/plugin/voip/video/a/b:ikO	I
    //   297: aload_1
    //   298: aload_1
    //   299: getfield 580	com/tencent/mm/plugin/voip/video/a/b:ikB	I
    //   302: ldc_w 617
    //   305: invokestatic 607	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   308: putfield 620	com/tencent/mm/plugin/voip/video/a/b:ikH	I
    //   311: aload_1
    //   312: invokestatic 624	com/tencent/mm/plugin/voip/video/a/b:fLz	()Lcom/tencent/mm/media/g/d;
    //   315: putfield 628	com/tencent/mm/plugin/voip/video/a/b:Hku	Lcom/tencent/mm/media/g/d;
    //   318: aload_1
    //   319: invokestatic 624	com/tencent/mm/plugin/voip/video/a/b:fLz	()Lcom/tencent/mm/media/g/d;
    //   322: putfield 631	com/tencent/mm/plugin/voip/video/a/b:Hkv	Lcom/tencent/mm/media/g/d;
    //   325: aload_1
    //   326: ldc_w 571
    //   329: ldc_w 633
    //   332: invokestatic 577	com/tencent/mm/plugin/voip/video/a/b:aB	(Ljava/lang/String;Ljava/lang/String;)I
    //   335: putfield 636	com/tencent/mm/plugin/voip/video/a/b:Hkw	I
    //   338: aload_1
    //   339: aload_1
    //   340: getfield 636	com/tencent/mm/plugin/voip/video/a/b:Hkw	I
    //   343: ldc_w 588
    //   346: invokestatic 594	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   349: putfield 639	com/tencent/mm/plugin/voip/video/a/b:Hkz	I
    //   352: aload_1
    //   353: aload_1
    //   354: getfield 636	com/tencent/mm/plugin/voip/video/a/b:Hkw	I
    //   357: ldc_w 599
    //   360: invokestatic 594	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   363: putfield 642	com/tencent/mm/plugin/voip/video/a/b:Hky	I
    //   366: aload_1
    //   367: aload_1
    //   368: getfield 636	com/tencent/mm/plugin/voip/video/a/b:Hkw	I
    //   371: ldc_w 644
    //   374: invokestatic 607	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   377: putfield 647	com/tencent/mm/plugin/voip/video/a/b:HkA	I
    //   380: aload_1
    //   381: new 649	com/tencent/mm/plugin/voip/video/render/l
    //   384: dup
    //   385: iconst_0
    //   386: iconst_0
    //   387: invokespecial 651	com/tencent/mm/plugin/voip/video/render/l:<init>	(II)V
    //   390: putfield 655	com/tencent/mm/plugin/voip/video/a/b:HkS	Lcom/tencent/mm/plugin/voip/video/render/l;
    //   393: aload_1
    //   394: aload_1
    //   395: getfield 636	com/tencent/mm/plugin/voip/video/a/b:Hkw	I
    //   398: ldc_w 617
    //   401: invokestatic 607	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   404: putfield 658	com/tencent/mm/plugin/voip/video/a/b:HkB	I
    //   407: aload_1
    //   408: invokestatic 624	com/tencent/mm/plugin/voip/video/a/b:fLz	()Lcom/tencent/mm/media/g/d;
    //   411: putfield 661	com/tencent/mm/plugin/voip/video/a/b:Hkx	Lcom/tencent/mm/media/g/d;
    //   414: aload_1
    //   415: invokestatic 624	com/tencent/mm/plugin/voip/video/a/b:fLz	()Lcom/tencent/mm/media/g/d;
    //   418: putfield 664	com/tencent/mm/plugin/voip/video/a/b:HkJ	Lcom/tencent/mm/media/g/d;
    //   421: getstatic 668	com/tencent/mm/plugin/voip/video/a/b:ilm	[F
    //   424: astore 12
    //   426: aload_1
    //   427: aload 12
    //   429: aload 12
    //   431: arraylength
    //   432: invokestatic 674	java/util/Arrays:copyOf	([FI)[F
    //   435: putfield 677	com/tencent/mm/plugin/voip/video/a/b:kyd	[F
    //   438: aload_1
    //   439: aload_1
    //   440: getfield 677	com/tencent/mm/plugin/voip/video/a/b:kyd	[F
    //   443: arraylength
    //   444: iconst_4
    //   445: imul
    //   446: invokestatic 683	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   449: invokestatic 689	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   452: invokevirtual 693	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   455: invokevirtual 697	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   458: putfield 701	com/tencent/mm/plugin/voip/video/a/b:hDU	Ljava/nio/FloatBuffer;
    //   461: aload_1
    //   462: getfield 701	com/tencent/mm/plugin/voip/video/a/b:hDU	Ljava/nio/FloatBuffer;
    //   465: aload_1
    //   466: getfield 677	com/tencent/mm/plugin/voip/video/a/b:kyd	[F
    //   469: invokevirtual 707	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   472: pop
    //   473: aload_1
    //   474: getfield 701	com/tencent/mm/plugin/voip/video/a/b:hDU	Ljava/nio/FloatBuffer;
    //   477: iconst_0
    //   478: invokevirtual 711	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   481: pop
    //   482: aload_1
    //   483: getstatic 714	com/tencent/mm/plugin/voip/video/a/b:iln	[F
    //   486: arraylength
    //   487: iconst_4
    //   488: imul
    //   489: invokestatic 683	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   492: invokestatic 689	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   495: invokevirtual 693	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   498: invokevirtual 697	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   501: putfield 717	com/tencent/mm/plugin/voip/video/a/b:hDT	Ljava/nio/FloatBuffer;
    //   504: aload_1
    //   505: getfield 717	com/tencent/mm/plugin/voip/video/a/b:hDT	Ljava/nio/FloatBuffer;
    //   508: getstatic 714	com/tencent/mm/plugin/voip/video/a/b:iln	[F
    //   511: invokevirtual 707	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   514: pop
    //   515: aload_1
    //   516: getfield 717	com/tencent/mm/plugin/voip/video/a/b:hDT	Ljava/nio/FloatBuffer;
    //   519: iconst_0
    //   520: invokevirtual 711	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   523: pop
    //   524: getstatic 720	com/tencent/mm/plugin/voip/video/a/b:Hkt	[F
    //   527: astore 12
    //   529: aload_1
    //   530: aload 12
    //   532: aload 12
    //   534: arraylength
    //   535: invokestatic 674	java/util/Arrays:copyOf	([FI)[F
    //   538: putfield 723	com/tencent/mm/plugin/voip/video/a/b:HkG	[F
    //   541: aload_1
    //   542: aload_1
    //   543: getfield 723	com/tencent/mm/plugin/voip/video/a/b:HkG	[F
    //   546: arraylength
    //   547: iconst_4
    //   548: imul
    //   549: invokestatic 683	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   552: invokestatic 689	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   555: invokevirtual 693	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   558: invokevirtual 697	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   561: putfield 726	com/tencent/mm/plugin/voip/video/a/b:HkC	Ljava/nio/FloatBuffer;
    //   564: aload_1
    //   565: getfield 726	com/tencent/mm/plugin/voip/video/a/b:HkC	Ljava/nio/FloatBuffer;
    //   568: aload_1
    //   569: getfield 723	com/tencent/mm/plugin/voip/video/a/b:HkG	[F
    //   572: invokevirtual 707	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   575: pop
    //   576: aload_1
    //   577: getfield 726	com/tencent/mm/plugin/voip/video/a/b:HkC	Ljava/nio/FloatBuffer;
    //   580: iconst_0
    //   581: invokevirtual 711	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   584: pop
    //   585: getstatic 668	com/tencent/mm/plugin/voip/video/a/b:ilm	[F
    //   588: astore 12
    //   590: aload_1
    //   591: aload 12
    //   593: aload 12
    //   595: arraylength
    //   596: invokestatic 674	java/util/Arrays:copyOf	([FI)[F
    //   599: putfield 729	com/tencent/mm/plugin/voip/video/a/b:HkF	[F
    //   602: aload_1
    //   603: aload_1
    //   604: getfield 729	com/tencent/mm/plugin/voip/video/a/b:HkF	[F
    //   607: arraylength
    //   608: iconst_4
    //   609: imul
    //   610: invokestatic 683	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   613: invokestatic 689	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   616: invokevirtual 693	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   619: invokevirtual 697	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   622: putfield 732	com/tencent/mm/plugin/voip/video/a/b:HkD	Ljava/nio/FloatBuffer;
    //   625: aload_1
    //   626: getfield 732	com/tencent/mm/plugin/voip/video/a/b:HkD	Ljava/nio/FloatBuffer;
    //   629: aload_1
    //   630: getfield 729	com/tencent/mm/plugin/voip/video/a/b:HkF	[F
    //   633: invokevirtual 707	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   636: pop
    //   637: aload_1
    //   638: getfield 732	com/tencent/mm/plugin/voip/video/a/b:HkD	Ljava/nio/FloatBuffer;
    //   641: iconst_0
    //   642: invokevirtual 711	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   645: pop
    //   646: aload_1
    //   647: invokestatic 736	com/tencent/mm/plugin/voip/video/a/b:fLA	()Lcom/tencent/mm/media/g/a;
    //   650: putfield 740	com/tencent/mm/plugin/voip/video/a/b:HkH	Lcom/tencent/mm/media/g/a;
    //   653: aload_1
    //   654: aconst_null
    //   655: putfield 743	com/tencent/mm/plugin/voip/video/a/b:HkQ	[B
    //   658: aload_1
    //   659: invokestatic 736	com/tencent/mm/plugin/voip/video/a/b:fLA	()Lcom/tencent/mm/media/g/a;
    //   662: putfield 746	com/tencent/mm/plugin/voip/video/a/b:HkI	Lcom/tencent/mm/media/g/a;
    //   665: aload_1
    //   666: invokestatic 624	com/tencent/mm/plugin/voip/video/a/b:fLz	()Lcom/tencent/mm/media/g/d;
    //   669: putfield 749	com/tencent/mm/plugin/voip/video/a/b:hEv	Lcom/tencent/mm/media/g/d;
    //   672: iload 4
    //   674: ifeq +45 -> 719
    //   677: aload_1
    //   678: iload 4
    //   680: putfield 752	com/tencent/mm/plugin/voip/video/a/b:HkT	I
    //   683: aload_1
    //   684: new 754	com/tencent/mm/cm/a/k
    //   687: dup
    //   688: invokespecial 755	com/tencent/mm/cm/a/k:<init>	()V
    //   691: putfield 759	com/tencent/mm/plugin/voip/video/a/b:HkU	Lcom/tencent/mm/cm/a/k;
    //   694: aload_1
    //   695: invokestatic 624	com/tencent/mm/plugin/voip/video/a/b:fLz	()Lcom/tencent/mm/media/g/d;
    //   698: putfield 762	com/tencent/mm/plugin/voip/video/a/b:HkK	Lcom/tencent/mm/media/g/d;
    //   701: aload_1
    //   702: new 764	com/tencent/mm/cm/a/f
    //   705: dup
    //   706: invokespecial 765	com/tencent/mm/cm/a/f:<init>	()V
    //   709: putfield 769	com/tencent/mm/plugin/voip/video/a/b:HkZ	Lcom/tencent/mm/cm/a/f;
    //   712: aload_1
    //   713: getfield 769	com/tencent/mm/plugin/voip/video/a/b:HkZ	Lcom/tencent/mm/cm/a/f;
    //   716: invokevirtual 772	com/tencent/mm/cm/a/f:MC	()V
    //   719: iload_3
    //   720: ifeq +35 -> 755
    //   723: iload 4
    //   725: ifeq +201 -> 926
    //   728: aload_1
    //   729: new 774	com/tencent/mm/plugin/voip/video/a/a
    //   732: dup
    //   733: invokespecial 775	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   736: putfield 779	com/tencent/mm/plugin/voip/video/a/b:HkN	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   739: aload_1
    //   740: getfield 779	com/tencent/mm/plugin/voip/video/a/b:HkN	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   743: aload_1
    //   744: getfield 762	com/tencent/mm/plugin/voip/video/a/b:HkK	Lcom/tencent/mm/media/g/d;
    //   747: aload_1
    //   748: getfield 749	com/tencent/mm/plugin/voip/video/a/b:hEv	Lcom/tencent/mm/media/g/d;
    //   751: iload_3
    //   752: invokevirtual 782	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/g/d;Lcom/tencent/mm/media/g/d;I)V
    //   755: ldc_w 582
    //   758: ldc_w 784
    //   761: iconst_1
    //   762: anewarray 4	java/lang/Object
    //   765: dup
    //   766: iconst_0
    //   767: aload_1
    //   768: invokevirtual 505	java/lang/Object:hashCode	()I
    //   771: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: aastore
    //   775: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   778: aload_1
    //   779: iconst_1
    //   780: putfield 569	com/tencent/mm/plugin/voip/video/a/b:htU	Z
    //   783: aload_0
    //   784: getfield 232	com/tencent/mm/plugin/voip/video/OpenGlRender:Hit	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   787: aload_0
    //   788: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:Hif	I
    //   791: aload_0
    //   792: getfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:Hig	I
    //   795: invokevirtual 787	com/tencent/mm/plugin/voip/video/a/b:jj	(II)V
    //   798: iload_2
    //   799: ifne +157 -> 956
    //   802: aload_0
    //   803: getfield 232	com/tencent/mm/plugin/voip/video/OpenGlRender:Hit	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   806: aload_0
    //   807: getfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   810: aload_0
    //   811: getfield 485	com/tencent/mm/plugin/voip/video/OpenGlRender:Hio	I
    //   814: aload_0
    //   815: getfield 487	com/tencent/mm/plugin/voip/video/OpenGlRender:Hip	I
    //   818: aload_0
    //   819: getfield 489	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiq	I
    //   822: iconst_0
    //   823: aload_0
    //   824: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:Hir	I
    //   827: invokevirtual 790	com/tencent/mm/plugin/voip/video/a/b:b	([BIIIII)V
    //   830: aload_0
    //   831: aconst_null
    //   832: putfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   835: aload_0
    //   836: getfield 792	com/tencent/mm/plugin/voip/video/OpenGlRender:HiQ	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   839: ifnull +27 -> 866
    //   842: aload_0
    //   843: getfield 493	com/tencent/mm/plugin/voip/video/OpenGlRender:HiF	I
    //   846: iconst_3
    //   847: if_icmpne +1626 -> 2473
    //   850: aload_0
    //   851: getfield 792	com/tencent/mm/plugin/voip/video/OpenGlRender:HiQ	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   854: aload_0
    //   855: getfield 254	com/tencent/mm/plugin/voip/video/OpenGlRender:HiP	J
    //   858: invokestatic 796	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   861: invokeinterface 799 3 0
    //   866: aload_0
    //   867: getfield 250	com/tencent/mm/plugin/voip/video/OpenGlRender:HiO	Z
    //   870: ifeq +24 -> 894
    //   873: aload_0
    //   874: getfield 792	com/tencent/mm/plugin/voip/video/OpenGlRender:HiQ	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   877: ifnull +17 -> 894
    //   880: aload_0
    //   881: iconst_0
    //   882: putfield 250	com/tencent/mm/plugin/voip/video/OpenGlRender:HiO	Z
    //   885: aload_0
    //   886: getfield 792	com/tencent/mm/plugin/voip/video/OpenGlRender:HiQ	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   889: invokeinterface 802 1 0
    //   894: ldc_w 558
    //   897: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   900: return
    //   901: iconst_0
    //   902: istore_2
    //   903: goto -779 -> 124
    //   906: iconst_0
    //   907: istore_3
    //   908: goto -772 -> 136
    //   911: aload_0
    //   912: getfield 303	com/tencent/mm/plugin/voip/video/OpenGlRender:HiE	I
    //   915: istore 4
    //   917: goto -771 -> 146
    //   920: iconst_0
    //   921: istore 4
    //   923: goto -759 -> 164
    //   926: aload_1
    //   927: new 774	com/tencent/mm/plugin/voip/video/a/a
    //   930: dup
    //   931: invokespecial 775	com/tencent/mm/plugin/voip/video/a/a:<init>	()V
    //   934: putfield 779	com/tencent/mm/plugin/voip/video/a/b:HkN	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   937: aload_1
    //   938: getfield 779	com/tencent/mm/plugin/voip/video/a/b:HkN	Lcom/tencent/mm/plugin/voip/video/a/a;
    //   941: aload_1
    //   942: getfield 664	com/tencent/mm/plugin/voip/video/a/b:HkJ	Lcom/tencent/mm/media/g/d;
    //   945: aload_1
    //   946: getfield 749	com/tencent/mm/plugin/voip/video/a/b:hEv	Lcom/tencent/mm/media/g/d;
    //   949: iload_3
    //   950: invokevirtual 782	com/tencent/mm/plugin/voip/video/a/a:a	(Lcom/tencent/mm/media/g/d;Lcom/tencent/mm/media/g/d;I)V
    //   953: goto -198 -> 755
    //   956: aload_0
    //   957: getfield 232	com/tencent/mm/plugin/voip/video/OpenGlRender:Hit	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   960: aload_0
    //   961: getfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   964: aload_0
    //   965: getfield 485	com/tencent/mm/plugin/voip/video/OpenGlRender:Hio	I
    //   968: aload_0
    //   969: getfield 487	com/tencent/mm/plugin/voip/video/OpenGlRender:Hip	I
    //   972: aload_0
    //   973: getfield 489	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiq	I
    //   976: aload_0
    //   977: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:HiD	I
    //   980: aload_0
    //   981: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:Hir	I
    //   984: invokevirtual 790	com/tencent/mm/plugin/voip/video/a/b:b	([BIIIII)V
    //   987: goto -157 -> 830
    //   990: aload_0
    //   991: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   994: ifnull -164 -> 830
    //   997: iconst_0
    //   998: istore 5
    //   1000: iload 5
    //   1002: istore_2
    //   1003: aload_0
    //   1004: getfield 491	com/tencent/mm/plugin/voip/video/OpenGlRender:HiC	Z
    //   1007: ifeq +27 -> 1034
    //   1010: iload_3
    //   1011: ifne +11 -> 1022
    //   1014: iload 5
    //   1016: istore_2
    //   1017: iload 4
    //   1019: ifeq +15 -> 1034
    //   1022: aload_0
    //   1023: getfield 301	com/tencent/mm/plugin/voip/video/OpenGlRender:HiD	I
    //   1026: aload_0
    //   1027: getfield 303	com/tencent/mm/plugin/voip/video/OpenGlRender:HiE	I
    //   1030: iconst_5
    //   1031: ishl
    //   1032: iadd
    //   1033: istore_2
    //   1034: aload_0
    //   1035: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1038: iconst_0
    //   1039: invokevirtual 805	com/tencent/mm/plugin/voip/video/b/g:adY	(I)V
    //   1042: aload_0
    //   1043: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1046: astore 12
    //   1048: aload_0
    //   1049: getfield 485	com/tencent/mm/plugin/voip/video/OpenGlRender:Hio	I
    //   1052: istore_3
    //   1053: aload_0
    //   1054: getfield 487	com/tencent/mm/plugin/voip/video/OpenGlRender:Hip	I
    //   1057: istore 4
    //   1059: aload_0
    //   1060: getfield 212	com/tencent/mm/plugin/voip/video/OpenGlRender:Hif	I
    //   1063: istore 6
    //   1065: aload_0
    //   1066: getfield 214	com/tencent/mm/plugin/voip/video/OpenGlRender:Hig	I
    //   1069: istore 7
    //   1071: aload_0
    //   1072: getfield 493	com/tencent/mm/plugin/voip/video/OpenGlRender:HiF	I
    //   1075: istore 5
    //   1077: aload_0
    //   1078: getfield 489	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiq	I
    //   1081: istore 8
    //   1083: aload_0
    //   1084: getfield 230	com/tencent/mm/plugin/voip/video/OpenGlRender:Hir	I
    //   1087: istore 9
    //   1089: iload_3
    //   1090: ifle +580 -> 1670
    //   1093: iload 4
    //   1095: ifle +575 -> 1670
    //   1098: iload 8
    //   1100: iconst_2
    //   1101: ishr
    //   1102: iconst_3
    //   1103: iand
    //   1104: istore 10
    //   1106: iload 8
    //   1108: iconst_4
    //   1109: ishr
    //   1110: iconst_1
    //   1111: iand
    //   1112: iconst_1
    //   1113: if_icmpne +830 -> 1943
    //   1116: iconst_1
    //   1117: istore 11
    //   1119: aload 12
    //   1121: iload_2
    //   1122: putfield 808	com/tencent/mm/plugin/voip/video/b/g:Hml	I
    //   1125: aload 12
    //   1127: iload_2
    //   1128: iconst_5
    //   1129: ishr
    //   1130: putfield 811	com/tencent/mm/plugin/voip/video/b/g:Hmm	I
    //   1133: iload_3
    //   1134: aload 12
    //   1136: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1139: if_icmpne +73 -> 1212
    //   1142: iload 4
    //   1144: aload 12
    //   1146: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1149: if_icmpne +63 -> 1212
    //   1152: iload 6
    //   1154: aload 12
    //   1156: getfield 820	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   1159: if_icmpne +53 -> 1212
    //   1162: iload 7
    //   1164: aload 12
    //   1166: getfield 823	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   1169: if_icmpne +43 -> 1212
    //   1172: aload 12
    //   1174: getfield 826	com/tencent/mm/plugin/voip/video/b/g:FfM	I
    //   1177: iload 10
    //   1179: if_icmpne +33 -> 1212
    //   1182: aload 12
    //   1184: getfield 829	com/tencent/mm/plugin/voip/video/b/g:Hmk	Z
    //   1187: iload 11
    //   1189: if_icmpne +23 -> 1212
    //   1192: aload 12
    //   1194: getfield 832	com/tencent/mm/plugin/voip/video/b/g:Hmf	I
    //   1197: iload 5
    //   1199: if_icmpne +13 -> 1212
    //   1202: aload 12
    //   1204: getfield 835	com/tencent/mm/plugin/voip/video/b/g:Hmr	I
    //   1207: iload 9
    //   1209: if_icmpeq +461 -> 1670
    //   1212: aload 12
    //   1214: iload 10
    //   1216: putfield 826	com/tencent/mm/plugin/voip/video/b/g:FfM	I
    //   1219: aload 12
    //   1221: iload 11
    //   1223: putfield 829	com/tencent/mm/plugin/voip/video/b/g:Hmk	Z
    //   1226: aload 12
    //   1228: iload 5
    //   1230: putfield 832	com/tencent/mm/plugin/voip/video/b/g:Hmf	I
    //   1233: aload 12
    //   1235: iload 9
    //   1237: putfield 835	com/tencent/mm/plugin/voip/video/b/g:Hmr	I
    //   1240: ldc_w 837
    //   1243: ldc_w 839
    //   1246: bipush 12
    //   1248: anewarray 4	java/lang/Object
    //   1251: dup
    //   1252: iconst_0
    //   1253: iload 5
    //   1255: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1258: aastore
    //   1259: dup
    //   1260: iconst_1
    //   1261: aload 12
    //   1263: getfield 826	com/tencent/mm/plugin/voip/video/b/g:FfM	I
    //   1266: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1269: aastore
    //   1270: dup
    //   1271: iconst_2
    //   1272: aload 12
    //   1274: getfield 829	com/tencent/mm/plugin/voip/video/b/g:Hmk	Z
    //   1277: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1280: aastore
    //   1281: dup
    //   1282: iconst_3
    //   1283: iload_3
    //   1284: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1287: aastore
    //   1288: dup
    //   1289: iconst_4
    //   1290: iload 4
    //   1292: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1295: aastore
    //   1296: dup
    //   1297: iconst_5
    //   1298: iload 6
    //   1300: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1303: aastore
    //   1304: dup
    //   1305: bipush 6
    //   1307: iload 7
    //   1309: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1312: aastore
    //   1313: dup
    //   1314: bipush 7
    //   1316: aload 12
    //   1318: getfield 842	com/tencent/mm/plugin/voip/video/b/g:hEm	I
    //   1321: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1324: aastore
    //   1325: dup
    //   1326: bipush 8
    //   1328: aload 12
    //   1330: getfield 845	com/tencent/mm/plugin/voip/video/b/g:Hmp	I
    //   1333: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1336: aastore
    //   1337: dup
    //   1338: bipush 9
    //   1340: aload 12
    //   1342: getfield 848	com/tencent/mm/plugin/voip/video/b/g:Hmq	I
    //   1345: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1348: aastore
    //   1349: dup
    //   1350: bipush 10
    //   1352: iload_2
    //   1353: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1356: aastore
    //   1357: dup
    //   1358: bipush 11
    //   1360: aload 12
    //   1362: getfield 835	com/tencent/mm/plugin/voip/video/b/g:Hmr	I
    //   1365: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1368: aastore
    //   1369: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1372: aload 12
    //   1374: iload_3
    //   1375: putfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1378: aload 12
    //   1380: iload 4
    //   1382: putfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1385: aload 12
    //   1387: iload 6
    //   1389: putfield 820	com/tencent/mm/plugin/voip/video/b/g:mScreenWidth	I
    //   1392: aload 12
    //   1394: iload 7
    //   1396: putfield 823	com/tencent/mm/plugin/voip/video/b/g:mScreenHeight	I
    //   1399: aload 12
    //   1401: aload 12
    //   1403: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1406: aload 12
    //   1408: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1411: aload 12
    //   1413: getfield 835	com/tencent/mm/plugin/voip/video/b/g:Hmr	I
    //   1416: invokevirtual 852	com/tencent/mm/plugin/voip/video/b/g:aE	(III)V
    //   1419: iload_3
    //   1420: iload 4
    //   1422: imul
    //   1423: istore_2
    //   1424: iload_2
    //   1425: iconst_4
    //   1426: idiv
    //   1427: istore 6
    //   1429: aload 12
    //   1431: monitorenter
    //   1432: aload 12
    //   1434: iload 6
    //   1436: iconst_2
    //   1437: imul
    //   1438: iload_2
    //   1439: iadd
    //   1440: invokestatic 855	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1443: putfield 859	com/tencent/mm/plugin/voip/video/b/g:Hmg	Ljava/nio/ByteBuffer;
    //   1446: aload 12
    //   1448: iload_2
    //   1449: invokestatic 855	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1452: putfield 862	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1455: aload 12
    //   1457: iload 6
    //   1459: invokestatic 855	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1462: putfield 865	com/tencent/mm/plugin/voip/video/b/g:Hmh	Ljava/nio/ByteBuffer;
    //   1465: aload 12
    //   1467: iload 6
    //   1469: invokestatic 855	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1472: putfield 868	com/tencent/mm/plugin/voip/video/b/g:Hmi	Ljava/nio/ByteBuffer;
    //   1475: aload 12
    //   1477: iload 6
    //   1479: iconst_2
    //   1480: imul
    //   1481: invokestatic 855	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1484: putfield 871	com/tencent/mm/plugin/voip/video/b/g:Hmj	Ljava/nio/ByteBuffer;
    //   1487: aload 12
    //   1489: monitorexit
    //   1490: aload 12
    //   1492: getfield 875	com/tencent/mm/plugin/voip/video/b/g:Hma	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1495: ifnull +175 -> 1670
    //   1498: iload 5
    //   1500: iconst_3
    //   1501: if_icmpne +169 -> 1670
    //   1504: aload 12
    //   1506: getfield 875	com/tencent/mm/plugin/voip/video/b/g:Hma	Lcom/tencent/mm/plugin/voip/video/b/d;
    //   1509: astore 12
    //   1511: ldc_w 877
    //   1514: ldc_w 879
    //   1517: iconst_4
    //   1518: anewarray 4	java/lang/Object
    //   1521: dup
    //   1522: iconst_0
    //   1523: iload_3
    //   1524: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1527: aastore
    //   1528: dup
    //   1529: iconst_1
    //   1530: iload 4
    //   1532: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1535: aastore
    //   1536: dup
    //   1537: iconst_2
    //   1538: aload 12
    //   1540: getfield 884	com/tencent/mm/plugin/voip/video/b/d:outputWidth	I
    //   1543: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1546: aastore
    //   1547: dup
    //   1548: iconst_3
    //   1549: aload 12
    //   1551: getfield 887	com/tencent/mm/plugin/voip/video/b/d:outputHeight	I
    //   1554: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1557: aastore
    //   1558: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1561: iload_3
    //   1562: aload 12
    //   1564: getfield 884	com/tencent/mm/plugin/voip/video/b/d:outputWidth	I
    //   1567: if_icmpne +13 -> 1580
    //   1570: aload 12
    //   1572: getfield 887	com/tencent/mm/plugin/voip/video/b/d:outputHeight	I
    //   1575: iload 4
    //   1577: if_icmpeq +93 -> 1670
    //   1580: aload 12
    //   1582: iload_3
    //   1583: putfield 884	com/tencent/mm/plugin/voip/video/b/d:outputWidth	I
    //   1586: aload 12
    //   1588: iload 4
    //   1590: putfield 887	com/tencent/mm/plugin/voip/video/b/d:outputHeight	I
    //   1593: aload 12
    //   1595: getfield 891	com/tencent/mm/plugin/voip/video/b/d:HlI	Lcom/tencent/mm/plugin/voip/video/b/b;
    //   1598: astore 13
    //   1600: ldc_w 877
    //   1603: ldc_w 893
    //   1606: iconst_4
    //   1607: anewarray 4	java/lang/Object
    //   1610: dup
    //   1611: iconst_0
    //   1612: iload_3
    //   1613: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1616: aastore
    //   1617: dup
    //   1618: iconst_1
    //   1619: iload 4
    //   1621: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1624: aastore
    //   1625: dup
    //   1626: iconst_2
    //   1627: aload 13
    //   1629: getfield 898	com/tencent/mm/plugin/voip/video/b/b:surfaceWidth	I
    //   1632: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1635: aastore
    //   1636: dup
    //   1637: iconst_3
    //   1638: aload 13
    //   1640: getfield 901	com/tencent/mm/plugin/voip/video/b/b:surfaceHeight	I
    //   1643: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1646: aastore
    //   1647: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1650: iload_3
    //   1651: ifle +8 -> 1659
    //   1654: iload 4
    //   1656: ifgt +305 -> 1961
    //   1659: aload 12
    //   1661: getfield 902	com/tencent/mm/plugin/voip/video/b/d:HkZ	Lcom/tencent/mm/cm/a/f;
    //   1664: iload_3
    //   1665: iload 4
    //   1667: invokevirtual 905	com/tencent/mm/cm/a/f:lS	(II)V
    //   1670: aload_0
    //   1671: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1674: aload_0
    //   1675: getfield 491	com/tencent/mm/plugin/voip/video/OpenGlRender:HiC	Z
    //   1678: putfield 906	com/tencent/mm/plugin/voip/video/b/g:HiC	Z
    //   1681: aload_0
    //   1682: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1685: astore 12
    //   1687: aload_0
    //   1688: getfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   1691: astore 13
    //   1693: aload_0
    //   1694: getfield 493	com/tencent/mm/plugin/voip/video/OpenGlRender:HiF	I
    //   1697: istore_2
    //   1698: aload 12
    //   1700: monitorenter
    //   1701: aload 12
    //   1703: iconst_0
    //   1704: putfield 909	com/tencent/mm/plugin/voip/video/b/g:Hmo	Z
    //   1707: aload 12
    //   1709: getfield 912	com/tencent/mm/plugin/voip/video/b/g:Hmn	Z
    //   1712: ifeq +217 -> 1929
    //   1715: aload 13
    //   1717: ifnull +212 -> 1929
    //   1720: aload 12
    //   1722: iload_2
    //   1723: putfield 832	com/tencent/mm/plugin/voip/video/b/g:Hmf	I
    //   1726: aload 12
    //   1728: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1731: aload 12
    //   1733: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1736: imul
    //   1737: iconst_3
    //   1738: imul
    //   1739: iconst_2
    //   1740: idiv
    //   1741: istore 5
    //   1743: iload_2
    //   1744: iconst_3
    //   1745: if_icmpne +382 -> 2127
    //   1748: aload 13
    //   1750: arraylength
    //   1751: iload 5
    //   1753: if_icmpne +293 -> 2046
    //   1756: aload 12
    //   1758: getfield 811	com/tencent/mm/plugin/voip/video/b/g:Hmm	I
    //   1761: iconst_1
    //   1762: if_icmpne +49 -> 1811
    //   1765: aload 12
    //   1767: getfield 913	com/tencent/mm/plugin/voip/video/b/g:HkU	Lcom/tencent/mm/cm/a/k;
    //   1770: ifnull +41 -> 1811
    //   1773: aload 12
    //   1775: aload 12
    //   1777: getfield 913	com/tencent/mm/plugin/voip/video/b/g:HkU	Lcom/tencent/mm/cm/a/k;
    //   1780: aload 13
    //   1782: aload 12
    //   1784: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1787: aload 12
    //   1789: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1792: invokevirtual 917	com/tencent/mm/cm/a/k:R	([BII)I
    //   1795: putfield 920	com/tencent/mm/plugin/voip/video/b/g:HkV	I
    //   1798: aload 12
    //   1800: aload 12
    //   1802: getfield 913	com/tencent/mm/plugin/voip/video/b/g:HkU	Lcom/tencent/mm/cm/a/k;
    //   1805: invokevirtual 924	com/tencent/mm/cm/a/k:hff	()F
    //   1808: putfield 927	com/tencent/mm/plugin/voip/video/b/g:HkW	F
    //   1811: aload 12
    //   1813: getfield 859	com/tencent/mm/plugin/voip/video/b/g:Hmg	Ljava/nio/ByteBuffer;
    //   1816: invokevirtual 931	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1819: pop
    //   1820: aload 12
    //   1822: getfield 862	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1825: invokevirtual 931	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1828: pop
    //   1829: aload 12
    //   1831: getfield 871	com/tencent/mm/plugin/voip/video/b/g:Hmj	Ljava/nio/ByteBuffer;
    //   1834: invokevirtual 931	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1837: pop
    //   1838: aload 12
    //   1840: getfield 859	com/tencent/mm/plugin/voip/video/b/g:Hmg	Ljava/nio/ByteBuffer;
    //   1843: aload 13
    //   1845: iconst_0
    //   1846: aload 12
    //   1848: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1851: aload 12
    //   1853: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1856: imul
    //   1857: iconst_3
    //   1858: imul
    //   1859: iconst_2
    //   1860: idiv
    //   1861: invokevirtual 934	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1864: pop
    //   1865: aload 12
    //   1867: getfield 862	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   1870: aload 13
    //   1872: iconst_0
    //   1873: aload 12
    //   1875: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1878: aload 12
    //   1880: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1883: imul
    //   1884: invokevirtual 934	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1887: pop
    //   1888: aload 12
    //   1890: getfield 871	com/tencent/mm/plugin/voip/video/b/g:Hmj	Ljava/nio/ByteBuffer;
    //   1893: aload 13
    //   1895: aload 12
    //   1897: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1900: aload 12
    //   1902: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1905: imul
    //   1906: aload 12
    //   1908: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   1911: aload 12
    //   1913: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   1916: imul
    //   1917: iconst_2
    //   1918: idiv
    //   1919: invokevirtual 934	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1922: pop
    //   1923: aload 12
    //   1925: iconst_1
    //   1926: putfield 909	com/tencent/mm/plugin/voip/video/b/g:Hmo	Z
    //   1929: aload 12
    //   1931: monitorexit
    //   1932: aload_0
    //   1933: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   1936: aload_1
    //   1937: invokevirtual 936	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1940: goto -1110 -> 830
    //   1943: iconst_0
    //   1944: istore 11
    //   1946: goto -827 -> 1119
    //   1949: astore_1
    //   1950: aload 12
    //   1952: monitorexit
    //   1953: ldc_w 558
    //   1956: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1959: aload_1
    //   1960: athrow
    //   1961: aload 13
    //   1963: getfield 937	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   1966: iload_3
    //   1967: if_icmpne +13 -> 1980
    //   1970: aload 13
    //   1972: getfield 938	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   1975: iload 4
    //   1977: if_icmpeq -318 -> 1659
    //   1980: aload 13
    //   1982: iload_3
    //   1983: putfield 937	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   1986: aload 13
    //   1988: iload 4
    //   1990: putfield 938	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   1993: ldc_w 877
    //   1996: ldc_w 940
    //   1999: iconst_2
    //   2000: anewarray 4	java/lang/Object
    //   2003: dup
    //   2004: iconst_0
    //   2005: aload 13
    //   2007: getfield 937	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   2010: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2013: aastore
    //   2014: dup
    //   2015: iconst_1
    //   2016: aload 13
    //   2018: getfield 938	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   2021: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2024: aastore
    //   2025: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2028: aload 13
    //   2030: aload 13
    //   2032: getfield 937	com/tencent/mm/plugin/voip/video/b/b:outputWidth	I
    //   2035: aload 13
    //   2037: getfield 938	com/tencent/mm/plugin/voip/video/b/b:outputHeight	I
    //   2040: invokevirtual 943	com/tencent/mm/plugin/voip/video/b/b:jJ	(II)V
    //   2043: goto -384 -> 1659
    //   2046: ldc_w 837
    //   2049: ldc_w 945
    //   2052: iconst_4
    //   2053: anewarray 4	java/lang/Object
    //   2056: dup
    //   2057: iconst_0
    //   2058: aload 13
    //   2060: arraylength
    //   2061: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2064: aastore
    //   2065: dup
    //   2066: iconst_1
    //   2067: iload 5
    //   2069: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2072: aastore
    //   2073: dup
    //   2074: iconst_2
    //   2075: aload 12
    //   2077: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2080: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2083: aastore
    //   2084: dup
    //   2085: iconst_3
    //   2086: aload 12
    //   2088: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2091: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2094: aastore
    //   2095: invokestatic 555	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2098: aload 12
    //   2100: iconst_0
    //   2101: putfield 909	com/tencent/mm/plugin/voip/video/b/g:Hmo	Z
    //   2104: getstatic 951	com/tencent/mm/plugin/voip/model/t:GYO	Lcom/tencent/mm/plugin/voip/model/t;
    //   2107: astore 13
    //   2109: invokestatic 954	com/tencent/mm/plugin/voip/model/t:fHL	()V
    //   2112: goto -183 -> 1929
    //   2115: astore_1
    //   2116: aload 12
    //   2118: monitorexit
    //   2119: ldc_w 558
    //   2122: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2125: aload_1
    //   2126: athrow
    //   2127: aload 12
    //   2129: aload 12
    //   2131: getfield 845	com/tencent/mm/plugin/voip/video/b/g:Hmp	I
    //   2134: iconst_1
    //   2135: iadd
    //   2136: putfield 845	com/tencent/mm/plugin/voip/video/b/g:Hmp	I
    //   2139: aload 12
    //   2141: getfield 845	com/tencent/mm/plugin/voip/video/b/g:Hmp	I
    //   2144: bipush 100
    //   2146: irem
    //   2147: ifne +60 -> 2207
    //   2150: ldc_w 837
    //   2153: ldc_w 956
    //   2156: iconst_4
    //   2157: anewarray 4	java/lang/Object
    //   2160: dup
    //   2161: iconst_0
    //   2162: aload 12
    //   2164: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2167: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2170: aastore
    //   2171: dup
    //   2172: iconst_1
    //   2173: aload 12
    //   2175: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2178: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2181: aastore
    //   2182: dup
    //   2183: iconst_2
    //   2184: aload 12
    //   2186: getfield 845	com/tencent/mm/plugin/voip/video/b/g:Hmp	I
    //   2189: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2192: aastore
    //   2193: dup
    //   2194: iconst_3
    //   2195: aload 12
    //   2197: getfield 808	com/tencent/mm/plugin/voip/video/b/g:Hml	I
    //   2200: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2203: aastore
    //   2204: invokestatic 400	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2207: aload 13
    //   2209: arraylength
    //   2210: iload 5
    //   2212: if_icmplt +192 -> 2404
    //   2215: aload 12
    //   2217: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2220: istore 6
    //   2222: aload 12
    //   2224: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2227: istore 7
    //   2229: aload 12
    //   2231: getfield 845	com/tencent/mm/plugin/voip/video/b/g:Hmp	I
    //   2234: bipush 100
    //   2236: irem
    //   2237: ifne +462 -> 2699
    //   2240: aload 13
    //   2242: ifnull +452 -> 2694
    //   2245: aload 13
    //   2247: arraylength
    //   2248: iload 6
    //   2250: iload 7
    //   2252: imul
    //   2253: iconst_3
    //   2254: imul
    //   2255: iconst_2
    //   2256: idiv
    //   2257: if_icmple +437 -> 2694
    //   2260: iconst_0
    //   2261: istore_2
    //   2262: iconst_0
    //   2263: istore_3
    //   2264: goto +382 -> 2646
    //   2267: iload_2
    //   2268: ifeq +136 -> 2404
    //   2271: aload 12
    //   2273: getfield 862	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   2276: invokevirtual 931	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2279: pop
    //   2280: aload 12
    //   2282: getfield 865	com/tencent/mm/plugin/voip/video/b/g:Hmh	Ljava/nio/ByteBuffer;
    //   2285: invokevirtual 931	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2288: pop
    //   2289: aload 12
    //   2291: getfield 868	com/tencent/mm/plugin/voip/video/b/g:Hmi	Ljava/nio/ByteBuffer;
    //   2294: invokevirtual 931	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2297: pop
    //   2298: aload 12
    //   2300: getfield 862	com/tencent/mm/plugin/voip/video/b/g:y	Ljava/nio/ByteBuffer;
    //   2303: aload 13
    //   2305: iconst_0
    //   2306: aload 12
    //   2308: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2311: aload 12
    //   2313: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2316: imul
    //   2317: invokevirtual 934	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2320: pop
    //   2321: aload 12
    //   2323: getfield 865	com/tencent/mm/plugin/voip/video/b/g:Hmh	Ljava/nio/ByteBuffer;
    //   2326: aload 13
    //   2328: aload 12
    //   2330: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2333: aload 12
    //   2335: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2338: imul
    //   2339: aload 12
    //   2341: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2344: aload 12
    //   2346: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2349: imul
    //   2350: iconst_4
    //   2351: idiv
    //   2352: invokevirtual 934	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2355: pop
    //   2356: aload 12
    //   2358: getfield 868	com/tencent/mm/plugin/voip/video/b/g:Hmi	Ljava/nio/ByteBuffer;
    //   2361: aload 13
    //   2363: aload 12
    //   2365: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2368: aload 12
    //   2370: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2373: imul
    //   2374: iconst_5
    //   2375: imul
    //   2376: iconst_4
    //   2377: idiv
    //   2378: aload 12
    //   2380: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2383: aload 12
    //   2385: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2388: imul
    //   2389: iconst_4
    //   2390: idiv
    //   2391: invokevirtual 934	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2394: pop
    //   2395: aload 12
    //   2397: iconst_1
    //   2398: putfield 909	com/tencent/mm/plugin/voip/video/b/g:Hmo	Z
    //   2401: goto -472 -> 1929
    //   2404: ldc_w 837
    //   2407: ldc_w 958
    //   2410: iconst_4
    //   2411: anewarray 4	java/lang/Object
    //   2414: dup
    //   2415: iconst_0
    //   2416: aload 13
    //   2418: arraylength
    //   2419: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2422: aastore
    //   2423: dup
    //   2424: iconst_1
    //   2425: iload 5
    //   2427: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2430: aastore
    //   2431: dup
    //   2432: iconst_2
    //   2433: aload 12
    //   2435: getfield 814	com/tencent/mm/plugin/voip/video/b/g:mVideoWidth	I
    //   2438: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2441: aastore
    //   2442: dup
    //   2443: iconst_3
    //   2444: aload 12
    //   2446: getfield 817	com/tencent/mm/plugin/voip/video/b/g:mVideoHeight	I
    //   2449: invokestatic 340	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2452: aastore
    //   2453: invokestatic 555	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2456: aload 12
    //   2458: iconst_0
    //   2459: putfield 909	com/tencent/mm/plugin/voip/video/b/g:Hmo	Z
    //   2462: getstatic 951	com/tencent/mm/plugin/voip/model/t:GYO	Lcom/tencent/mm/plugin/voip/model/t;
    //   2465: astore 13
    //   2467: invokestatic 961	com/tencent/mm/plugin/voip/model/t:fHM	()V
    //   2470: goto -541 -> 1929
    //   2473: aload_0
    //   2474: getfield 792	com/tencent/mm/plugin/voip/video/OpenGlRender:HiQ	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2477: aload_0
    //   2478: getfield 254	com/tencent/mm/plugin/voip/video/OpenGlRender:HiP	J
    //   2481: invokestatic 796	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   2484: invokeinterface 964 3 0
    //   2489: goto -1623 -> 866
    //   2492: aload_0
    //   2493: invokestatic 566	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   2496: putfield 254	com/tencent/mm/plugin/voip/video/OpenGlRender:HiP	J
    //   2499: aload_0
    //   2500: getfield 204	com/tencent/mm/plugin/voip/video/OpenGlRender:Hib	Z
    //   2503: ifeq +20 -> 2523
    //   2506: aload_0
    //   2507: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:Hia	Z
    //   2510: ifeq +13 -> 2523
    //   2513: aload_0
    //   2514: getfield 279	com/tencent/mm/plugin/voip/video/OpenGlRender:Hih	Ljava/lang/ref/WeakReference;
    //   2517: invokevirtual 379	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2520: ifnonnull +63 -> 2583
    //   2523: aload_0
    //   2524: aconst_null
    //   2525: putfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   2528: aload_0
    //   2529: aconst_null
    //   2530: putfield 228	com/tencent/mm/plugin/voip/video/OpenGlRender:Hin	[I
    //   2533: getstatic 132	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   2536: ldc_w 966
    //   2539: iconst_3
    //   2540: anewarray 4	java/lang/Object
    //   2543: dup
    //   2544: iconst_0
    //   2545: aload_0
    //   2546: getfield 204	com/tencent/mm/plugin/voip/video/OpenGlRender:Hib	Z
    //   2549: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2552: aastore
    //   2553: dup
    //   2554: iconst_1
    //   2555: aload_0
    //   2556: getfield 202	com/tencent/mm/plugin/voip/video/OpenGlRender:Hia	Z
    //   2559: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2562: aastore
    //   2563: dup
    //   2564: iconst_2
    //   2565: aload_0
    //   2566: getfield 491	com/tencent/mm/plugin/voip/video/OpenGlRender:HiC	Z
    //   2569: invokestatic 435	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2572: aastore
    //   2573: invokestatic 346	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2576: ldc_w 558
    //   2579: invokestatic 178	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2582: return
    //   2583: aload_0
    //   2584: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2587: ifnull +33 -> 2620
    //   2590: aload_0
    //   2591: getfield 256	com/tencent/mm/plugin/voip/video/OpenGlRender:HiT	Z
    //   2594: ifeq +8 -> 2602
    //   2597: aload_0
    //   2598: iconst_1
    //   2599: invokespecial 968	com/tencent/mm/plugin/voip/video/OpenGlRender:xu	(Z)V
    //   2602: aload_0
    //   2603: getfield 308	com/tencent/mm/plugin/voip/video/OpenGlRender:Hiu	Lcom/tencent/mm/plugin/voip/video/b/g;
    //   2606: aload_1
    //   2607: invokevirtual 936	com/tencent/mm/plugin/voip/video/b/g:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   2610: aload_0
    //   2611: aconst_null
    //   2612: putfield 226	com/tencent/mm/plugin/voip/video/OpenGlRender:Him	[B
    //   2615: aload_0
    //   2616: aconst_null
    //   2617: putfield 228	com/tencent/mm/plugin/voip/video/OpenGlRender:Hin	[I
    //   2620: aload_0
    //   2621: getfield 792	com/tencent/mm/plugin/voip/video/OpenGlRender:HiQ	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2624: ifnull -1758 -> 866
    //   2627: aload_0
    //   2628: getfield 792	com/tencent/mm/plugin/voip/video/OpenGlRender:HiQ	Lcom/tencent/mm/plugin/voip/video/OpenGlRender$b;
    //   2631: aload_0
    //   2632: getfield 254	com/tencent/mm/plugin/voip/video/OpenGlRender:HiP	J
    //   2635: invokestatic 796	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   2638: invokeinterface 971 3 0
    //   2643: goto -1777 -> 866
    //   2646: iload_3
    //   2647: iload 6
    //   2649: iload 7
    //   2651: imul
    //   2652: if_icmpge +28 -> 2680
    //   2655: iload_2
    //   2656: istore 4
    //   2658: aload 13
    //   2660: iload_3
    //   2661: baload
    //   2662: ifne +8 -> 2670
    //   2665: iload_2
    //   2666: iconst_1
    //   2667: iadd
    //   2668: istore 4
    //   2670: iload_3
    //   2671: iconst_1
    //   2672: iadd
    //   2673: istore_3
    //   2674: iload 4
    //   2676: istore_2
    //   2677: goto -31 -> 2646
    //   2680: iload_2
    //   2681: iload 6
    //   2683: iload 7
    //   2685: imul
    //   2686: if_icmplt +13 -> 2699
    //   2689: iconst_0
    //   2690: istore_2
    //   2691: goto -424 -> 2267
    //   2694: iconst_0
    //   2695: istore_2
    //   2696: goto -429 -> 2267
    //   2699: iconst_1
    //   2700: istore_2
    //   2701: goto -434 -> 2267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2704	0	this	OpenGlRender
    //   0	2704	1	paramGL10	GL10
    //   123	2578	2	i	int
    //   135	2539	3	j	int
    //   144	2531	4	k	int
    //   998	1428	5	m	int
    //   1063	1623	6	n	int
    //   1069	1617	7	i1	int
    //   1081	29	8	i2	int
    //   1087	149	9	i3	int
    //   1104	111	10	i4	int
    //   1117	828	11	bool	boolean
    //   424	2033	12	localObject1	Object
    //   1598	1061	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1432	1490	1949	finally
    //   1950	1953	1949	finally
    //   1701	1715	2115	finally
    //   1720	1743	2115	finally
    //   1748	1811	2115	finally
    //   1811	1929	2115	finally
    //   1929	1932	2115	finally
    //   2046	2112	2115	finally
    //   2116	2119	2115	finally
    //   2127	2207	2115	finally
    //   2207	2240	2115	finally
    //   2245	2260	2115	finally
    //   2271	2401	2115	finally
    //   2404	2470	2115	finally
  }
  
  public final void onStarted()
  {
    AppMethodBeat.i(115659);
    this.Hib = true;
    requestRender();
    AppMethodBeat.o(115659);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115657);
    Log.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d, lastHWDecSize:%dx%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.HiC), Integer.valueOf(this.Hif), Integer.valueOf(this.Hig), Integer.valueOf(this.mRenderMode), Integer.valueOf(this.GUK), Integer.valueOf(this.GUL) });
    if ((this.Hif != paramInt1) || (this.Hig != paramInt2))
    {
      paramGL10.glViewport(0, 0, paramInt1, paramInt2);
      this.Hif = paramInt1;
      this.Hig = paramInt2;
    }
    if (this.Hit != null) {
      this.Hit.jj(paramInt1, paramInt2);
    }
    if (this.Hiu != null) {
      this.Hiu.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
    if (this.Hiv == null)
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWU, false);
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rWS, 50);
      if ((bool) && (com.tencent.mm.media.k.d.aNd() < i)) {
        this.Hiz = false;
      }
    }
    if (this.Hiz)
    {
      if (this.Hiv == null)
      {
        this.Hiv = new com.tencent.mm.plugin.xlabeffect.b(0, 0);
        this.Hiv.l(this.HiA, -1, -1, this.HiB, -1);
        this.Hiv.zG(false);
        this.Hiv.glh();
      }
      if (this.Hiv != null)
      {
        this.Hiv.setSize(paramInt1, paramInt2);
        this.Hix = paramInt1;
        this.Hiy = paramInt2;
      }
    }
    setShowMode(this.HiI);
    jA(this.GUK, this.GUL);
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
    if (this.Hiu != null) {
      this.Hiu.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    if (v2protocal.HcC == null)
    {
      paramGL10 = e.fLK();
      try
      {
        paramGL10.HlX = paramGL10.fLL();
        paramGL10.HlW.set(false);
        paramEGLConfig = new Surface(paramGL10.HlX);
        v2protocal.mSurfaceTexture = paramGL10.HlX;
        v2protocal.HcD = null;
        v2protocal.HcC = paramEGLConfig;
        paramGL10.HlY.MC();
        AppMethodBeat.o(115658);
        return;
      }
      catch (Exception paramGL10)
      {
        Log.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", paramGL10, "initSurfaceTexutre error", new Object[0]);
        paramGL10 = t.GYO;
        t.fHy();
      }
    }
    AppMethodBeat.o(115658);
  }
  
  public final void releaseSurfaceTexture()
  {
    AppMethodBeat.i(115652);
    if ((this.Hih != null) && (this.Hih.get() != null))
    {
      ??? = (OpenGlView)this.Hih.get();
      Log.printInfoStack(TAG, "releaseSurfaceTexture:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(115641);
          ??? = e.fLK();
          try
          {
            if (((e)???).HlX != null)
            {
              t localt2 = t.GYO;
              t.fHz();
              if (((e)???).HcD != null) {
                ((e)???).HcD.close();
              }
              ((e)???).HlX.release();
              ((e)???).HlX = null;
              Log.i("MicroMsg.VoipHardDecodeUtil", "uninit surface texture");
            }
          }
          catch (Exception localException1)
          {
            t localt1;
            synchronized (OpenGlRender.fKQ())
            {
              try
              {
                OpenGlRender.fKQ().notifyAll();
                AppMethodBeat.o(115641);
                return;
                localException1 = localException1;
                Log.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", localException1, "uninitSurfaceTexture error", new Object[0]);
                localt1 = t.GYO;
                t.fHA();
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Log.printErrStackTrace(OpenGlRender.TAG, localException2, "", new Object[0]);
                }
              }
            }
          }
          Log.i(OpenGlRender.TAG, "releaseSurfaceTexture call finish");
        }
      });
      synchronized (HiL)
      {
        try
        {
          HiL.wait(100L);
          Log.i(TAG, "releaseSurfaceTexture wait finish");
          AppMethodBeat.o(115652);
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
    AppMethodBeat.o(115652);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(115666);
    if (this.Hih.get() != null) {
      ((OpenGlView)this.Hih.get()).fKT();
    }
    AppMethodBeat.o(115666);
  }
  
  public final void setShowMode(int paramInt)
  {
    AppMethodBeat.i(115650);
    this.HiI = paramInt;
    if (this.Hiu != null)
    {
      Log.printInfoStack(TAG, "setShowMode, mode:%d, uiWidth: %s, uiHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Hif), Integer.valueOf(this.Hig) });
      if (paramInt == 1) {
        break label90;
      }
      this.HiU = true;
      fKP();
    }
    for (;;)
    {
      this.Hiu.adY(this.HiI);
      AppMethodBeat.o(115650);
      return;
      label90:
      if (this.HiU)
      {
        Log.i(TAG, "is need to detach");
        fKP();
      }
      this.HiT = true;
      xu(false);
    }
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(235830);
    Log.i(TAG, "hseasun: isDrawingSelf:%b, set setSpatiotemporalDenosing:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.HiC), Integer.valueOf(paramInt), Integer.valueOf(this.HiE) });
    this.HiE = paramInt;
    AppMethodBeat.o(235830);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115665);
    Log.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.HiC), Integer.valueOf(paramInt), Integer.valueOf(this.HiD) });
    this.HiD = paramInt;
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
    public abstract void Lj(long paramLong);
    
    public abstract void Lk(long paramLong);
    
    public abstract void Ll(long paramLong);
    
    public abstract void fJD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender
 * JD-Core Version:    0.7.0.1
 */