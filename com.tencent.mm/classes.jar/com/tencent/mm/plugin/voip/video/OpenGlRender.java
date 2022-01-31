package com.tencent.mm.plugin.voip.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.a.c;
import com.tencent.mm.plugin.voip.video.a.e;
import com.tencent.mm.plugin.voip.video.b.a.b;
import com.tencent.mm.plugin.voip.video.b.d;
import com.tencent.mm.plugin.voip.video.b.d.a;
import com.tencent.mm.plugin.voip.video.b.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender
  implements GLSurfaceView.Renderer
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
  public static int tGO;
  private static final Object tGX;
  private static final Object tGY;
  private static final Object tGZ;
  static boolean tHc;
  public float mBrightness;
  public float mContrast;
  int mRenderMode;
  public float mSaturation;
  boolean tGA;
  boolean tGB;
  int tGC;
  int tGD;
  WeakReference<OpenGlView> tGE;
  public boolean tGF;
  public Bitmap tGG;
  private int tGH;
  private int tGI;
  private byte[] tGJ;
  private int[] tGK;
  private int tGL;
  private int tGM;
  private int tGN;
  private c tGP;
  f tGQ;
  private boolean tGR;
  private int tGS;
  private int tGT;
  private volatile boolean tGU;
  private volatile boolean tGV;
  public int tGW;
  boolean tGr;
  int tGs;
  long tGt;
  long tGu;
  int tGv;
  OpenGlRender.a tGw;
  boolean tGx;
  boolean tGy;
  boolean tGz;
  public int tHa;
  WeakReference<Object> tHb;
  private boolean tHd;
  boolean tHe;
  public int txY;
  public int txZ;
  
  static
  {
    AppMethodBeat.i(140210);
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
    tGO = 0;
    tGX = new Object();
    tGY = new Object();
    tGZ = new Object();
    tHc = false;
    AppMethodBeat.o(140210);
  }
  
  public OpenGlRender(OpenGlView paramOpenGlView, int paramInt)
  {
    AppMethodBeat.i(5072);
    this.tGr = false;
    this.tGs = 0;
    this.tGt = 0L;
    this.tGu = 0L;
    this.tGv = 0;
    this.mBrightness = 1.2F;
    this.mContrast = 1.93F;
    this.mSaturation = 1.05F;
    this.tGx = false;
    this.tGy = false;
    this.tGz = false;
    this.tGA = false;
    this.tGB = false;
    this.tGC = 0;
    this.tGD = 0;
    this.mRenderMode = RenderLocal;
    this.tGF = false;
    this.tGG = null;
    this.tGH = 0;
    this.tGI = 0;
    this.tGJ = null;
    this.tGK = null;
    this.tGU = false;
    this.tGV = false;
    this.tGW = 0;
    this.tHa = 0;
    this.txY = 0;
    this.txZ = 0;
    this.tHd = false;
    this.tHe = false;
    if (!tHc)
    {
      k.a("mm_gl_disp", OpenGlRender.class.getClassLoader());
      tHc = true;
    }
    this.mRenderMode = paramInt;
    this.tGE = new WeakReference(paramOpenGlView);
    paramOpenGlView = Looper.myLooper();
    if (paramOpenGlView != null) {
      this.tGw = new OpenGlRender.a(this, paramOpenGlView);
    }
    for (;;)
    {
      this.tHb = null;
      if (getGLVersion() == 2) {
        this.tGP = new c();
      }
      this.tGS = 0;
      this.tGQ = new f();
      AppMethodBeat.o(5072);
      return;
      paramOpenGlView = Looper.getMainLooper();
      if (paramOpenGlView != null) {
        this.tGw = new OpenGlRender.a(this, paramOpenGlView);
      } else {
        this.tGw = null;
      }
    }
  }
  
  private native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  private native void Uninit(int paramInt);
  
  private void cPH()
  {
    AppMethodBeat.i(140206);
    if (this.tGP != null)
    {
      if (this.tGE != null)
      {
        OpenGlView localOpenGlView = (OpenGlView)this.tGE.get();
        if (localOpenGlView != null)
        {
          localOpenGlView.queueEvent(new OpenGlRender.3(this));
          AppMethodBeat.o(140206);
          return;
        }
      }
      if (this.tGP != null) {
        this.tGP.destroy();
      }
    }
    AppMethodBeat.o(140206);
  }
  
  public static int getGLVersion()
  {
    AppMethodBeat.i(5071);
    if (tGO == 0)
    {
      tGO = 2;
      ab.i(TAG, "init gl version: %s", new Object[] { Integer.valueOf(tGO) });
    }
    int i = tGO;
    AppMethodBeat.o(5071);
    return i;
  }
  
  private void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(140208);
    if ((this.tGE != null) && (this.tGE.get() != null))
    {
      if (!paramBoolean)
      {
        ??? = (OpenGlView)this.tGE.get();
        ab.i(TAG, "attachGLContext:%s", new Object[] { ??? });
        ((OpenGlView)???).queueEvent(new Runnable()
        {
          public final void run()
          {
            boolean bool = false;
            AppMethodBeat.i(140197);
            if (OpenGlRender.g(OpenGlRender.this))
            {
              ab.i(OpenGlRender.TAG, "attachGLContext");
              ??? = OpenGlRender.this;
              if (!OpenGlRender.b(OpenGlRender.this).cPZ()) {
                bool = true;
              }
              OpenGlRender.a((OpenGlRender)???, bool);
              OpenGlRender.e(OpenGlRender.this);
              OpenGlRender.f(OpenGlRender.this);
              ab.i(OpenGlRender.TAG, "attach finish");
            }
            synchronized (OpenGlRender.cPK())
            {
              try
              {
                OpenGlRender.cPK().notifyAll();
                AppMethodBeat.o(140197);
                return;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  ab.printErrStackTrace(OpenGlRender.TAG, localException, "", new Object[0]);
                }
              }
            }
          }
        });
        synchronized (tGY)
        {
          try
          {
            tGY.wait(100L);
            ab.i(TAG, "attachGLContext wait finish, bNeedAttach:%s", new Object[] { Boolean.valueOf(this.tHd) });
            AppMethodBeat.o(140208);
            return;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              ab.printErrStackTrace(TAG, localException, "", new Object[0]);
            }
          }
        }
      }
      if (this.tHd)
      {
        ab.i(TAG, "attachGLContext");
        if (this.tGQ.cPZ()) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.tHd = paramBoolean;
      this.tGJ = null;
      this.tGK = null;
      ab.i(TAG, "attach finish");
      AppMethodBeat.o(140208);
      return;
    }
  }
  
  private native void render32(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void render8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void setParam(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  public final void HV(int paramInt)
  {
    AppMethodBeat.i(140198);
    this.tGW = paramInt;
    if (this.tGQ != null)
    {
      ab.i(TAG, "setShowMode, mode:%d, uiWidth: %s, uiHeight: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tGC), Integer.valueOf(this.tGD) });
      if (paramInt == 1) {
        break label90;
      }
      this.tHe = true;
      cPI();
    }
    for (;;)
    {
      this.tGQ.HY(this.tGW);
      AppMethodBeat.o(140198);
      return;
      label90:
      this.tHd = true;
      ne(false);
    }
  }
  
  public final void a(SurfaceTexture paramSurfaceTexture, int paramInt)
  {
    AppMethodBeat.i(140199);
    if (this.tGQ != null) {
      this.tGQ.a(paramSurfaceTexture, paramInt);
    }
    AppMethodBeat.o(140199);
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(5082);
    if ((this.tGP != null) && (this.tGP.cPS() != null)) {
      parame.bx(this.tGP.cPS());
    }
    AppMethodBeat.o(5082);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(140209);
    if ((this.tGQ != null) && (this.tGQ.cPW() != null)) {
      paramb.a(this.tGQ.cPW());
    }
    AppMethodBeat.o(140209);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(140201);
    if ((this.tGx) && (this.tGJ == null))
    {
      this.tGL = paramInt1;
      this.tGM = paramInt2;
      this.tGN = paramInt3;
      this.tGJ = paramArrayOfByte;
      this.tGR = paramBoolean;
      this.tGT = paramInt4;
      requestRender();
    }
    AppMethodBeat.o(140201);
  }
  
  public final void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(5076);
    if ((this.tGx) && (this.tGK == null))
    {
      this.tGL = paramInt1;
      this.tGM = paramInt2;
      this.tGN = paramInt3;
      this.tGK = paramArrayOfInt;
      this.tGR = paramBoolean;
      requestRender();
    }
    AppMethodBeat.o(5076);
  }
  
  public final void cOQ()
  {
    AppMethodBeat.i(140200);
    if ((this.tGE != null) && (this.tGE.get() != null))
    {
      ??? = (OpenGlView)this.tGE.get();
      ab.b(TAG, "releaseSurfaceTexture:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new OpenGlRender.1(this));
      synchronized (tGZ)
      {
        try
        {
          tGZ.wait(100L);
          ab.i(TAG, "releaseSurfaceTexture wait finish");
          AppMethodBeat.o(140200);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace(TAG, localException, "", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(140200);
  }
  
  public final void cPF()
  {
    AppMethodBeat.i(5078);
    ab.i(TAG, "%s onStop, renderMode: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
    this.tGy = false;
    this.tGB = false;
    AppMethodBeat.o(5078);
  }
  
  public final void cPG()
  {
    AppMethodBeat.i(5079);
    ab.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.tGx), Boolean.valueOf(this.tGy) });
    if ((this.tGx) && (this.tGy))
    {
      ab.i(TAG, "%s steve: Reset GLRender first! mode=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
      if (this.tGQ != null)
      {
        ab.i(TAG, "onResetRender need detach");
        this.tHe = true;
        cPI();
      }
      this.tGx = false;
      this.tGy = false;
      cPH();
    }
    AppMethodBeat.o(5079);
  }
  
  final void cPI()
  {
    AppMethodBeat.i(140207);
    if ((this.tGE != null) && (this.tGE.get() != null))
    {
      ??? = (OpenGlView)this.tGE.get();
      ab.i(TAG, "detachGLContext:%s", new Object[] { ??? });
      ((OpenGlView)???).queueEvent(new OpenGlRender.4(this));
      synchronized (tGX)
      {
        try
        {
          tGX.wait(100L);
          ab.i(TAG, "detachGLContext wait finish, bNeedDetach:%s", new Object[] { Boolean.valueOf(this.tHe) });
          AppMethodBeat.o(140207);
          return;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ab.printErrStackTrace(TAG, localException, "", new Object[0]);
          }
        }
      }
    }
    if (this.tHe)
    {
      this.tGQ.cQa();
      this.tHe = false;
      this.tGJ = null;
      this.tGK = null;
      ab.i(TAG, "detach finish");
    }
    AppMethodBeat.o(140207);
  }
  
  public final void g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(140202);
    if ((this.tGx) && (this.tGJ == null))
    {
      this.tGL = paramInt1;
      this.tGM = paramInt2;
      this.tGN = paramInt3;
      this.tGJ = paramArrayOfByte;
      this.tGR = false;
      requestRender();
    }
    AppMethodBeat.o(140202);
  }
  
  public final void gj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140203);
    ab.i(TAG, "video=" + paramInt1 + "x" + paramInt2);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.txY = paramInt1;
      this.txZ = paramInt2;
      if (this.tGQ != null) {
        this.tGQ.gr(paramInt1, paramInt2);
      }
      AppMethodBeat.o(140203);
      return;
    }
    ab.e(TAG, "ERROR video size:%dx%d, lastviddeosize:%dx%d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.txY), Integer.valueOf(this.txZ) });
    AppMethodBeat.o(140203);
  }
  
  public final void nd(boolean paramBoolean)
  {
    AppMethodBeat.i(5074);
    ab.i(TAG, "drawTransparent: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tGU = paramBoolean;
    requestRender();
    AppMethodBeat.o(5074);
  }
  
  /* Error */
  public final void onDrawFrame(GL10 paramGL10)
  {
    // Byte code:
    //   0: sipush 5073
    //   3: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 198	com/tencent/mm/plugin/voip/video/OpenGlRender:tGW	I
    //   10: ifne +2138 -> 2148
    //   13: aload_0
    //   14: getfield 168	com/tencent/mm/plugin/voip/video/OpenGlRender:tGy	Z
    //   17: ifeq +20 -> 37
    //   20: aload_0
    //   21: getfield 166	com/tencent/mm/plugin/voip/video/OpenGlRender:tGx	Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 229	com/tencent/mm/plugin/voip/video/OpenGlRender:tGE	Ljava/lang/ref/WeakReference;
    //   31: invokevirtual 279	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   34: ifnonnull +63 -> 97
    //   37: aload_0
    //   38: aconst_null
    //   39: putfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 192	com/tencent/mm/plugin/voip/video/OpenGlRender:tGK	[I
    //   47: getstatic 99	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   50: ldc_w 491
    //   53: iconst_3
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 168	com/tencent/mm/plugin/voip/video/OpenGlRender:tGy	Z
    //   63: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_0
    //   70: getfield 166	com/tencent/mm/plugin/voip/video/OpenGlRender:tGx	Z
    //   73: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: aload_0
    //   80: getfield 408	com/tencent/mm/plugin/voip/video/OpenGlRender:tGR	Z
    //   83: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   86: aastore
    //   87: invokestatic 493	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: sipush 5073
    //   93: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: return
    //   97: aload_0
    //   98: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   101: ifnull +623 -> 724
    //   104: aload_0
    //   105: getfield 406	com/tencent/mm/plugin/voip/video/OpenGlRender:tGN	I
    //   108: getstatic 123	com/tencent/mm/plugin/voip/video/OpenGlRender:FLAG_Mirror	I
    //   111: iand
    //   112: ifeq +646 -> 758
    //   115: iconst_1
    //   116: istore_2
    //   117: aload_0
    //   118: getfield 253	com/tencent/mm/plugin/voip/video/OpenGlRender:tGS	I
    //   121: bipush 8
    //   123: iand
    //   124: ifeq +639 -> 763
    //   127: iconst_1
    //   128: istore_3
    //   129: aload_0
    //   130: getfield 251	com/tencent/mm/plugin/voip/video/OpenGlRender:tGP	Lcom/tencent/mm/plugin/voip/video/a/c;
    //   133: ifnull +665 -> 798
    //   136: aload_0
    //   137: getfield 408	com/tencent/mm/plugin/voip/video/OpenGlRender:tGR	Z
    //   140: ifeq +658 -> 798
    //   143: aload_0
    //   144: getfield 253	com/tencent/mm/plugin/voip/video/OpenGlRender:tGS	I
    //   147: ifeq +651 -> 798
    //   150: iload_3
    //   151: ifne +647 -> 798
    //   154: aload_0
    //   155: getfield 251	com/tencent/mm/plugin/voip/video/OpenGlRender:tGP	Lcom/tencent/mm/plugin/voip/video/a/c;
    //   158: astore_1
    //   159: aload_0
    //   160: getfield 253	com/tencent/mm/plugin/voip/video/OpenGlRender:tGS	I
    //   163: istore_3
    //   164: aload_1
    //   165: getfield 496	com/tencent/mm/plugin/voip/video/a/c:eLc	Z
    //   168: ifne +508 -> 676
    //   171: aload_1
    //   172: ldc_w 498
    //   175: ldc_w 500
    //   178: invokestatic 503	com/tencent/mm/plugin/voip/video/a/c:Z	(Ljava/lang/String;Ljava/lang/String;)I
    //   181: putfield 506	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   184: aload_1
    //   185: getfield 506	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   188: ifne +12 -> 200
    //   191: ldc_w 508
    //   194: ldc_w 510
    //   197: invokestatic 512	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload_1
    //   201: aload_1
    //   202: getfield 506	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   205: ldc_w 514
    //   208: invokestatic 520	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   211: putfield 523	com/tencent/mm/plugin/voip/video/a/c:eZi	I
    //   214: aload_1
    //   215: aload_1
    //   216: getfield 506	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   219: ldc_w 525
    //   222: invokestatic 520	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   225: putfield 528	com/tencent/mm/plugin/voip/video/a/c:eZh	I
    //   228: aload_1
    //   229: aload_1
    //   230: getfield 506	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   233: ldc_w 530
    //   236: invokestatic 533	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   239: putfield 536	com/tencent/mm/plugin/voip/video/a/c:eZj	I
    //   242: aload_1
    //   243: aload_1
    //   244: getfield 506	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   247: ldc_w 538
    //   250: invokestatic 533	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   253: putfield 541	com/tencent/mm/plugin/voip/video/a/c:eZk	I
    //   256: aload_1
    //   257: aload_1
    //   258: getfield 506	com/tencent/mm/plugin/voip/video/a/c:eZg	I
    //   261: ldc_w 543
    //   264: invokestatic 533	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   267: putfield 546	com/tencent/mm/plugin/voip/video/a/c:eZl	I
    //   270: aload_1
    //   271: invokestatic 549	com/tencent/mm/plugin/voip/video/a/c:Vm	()I
    //   274: putfield 552	com/tencent/mm/plugin/voip/video/a/c:eZe	I
    //   277: aload_1
    //   278: invokestatic 549	com/tencent/mm/plugin/voip/video/a/c:Vm	()I
    //   281: putfield 555	com/tencent/mm/plugin/voip/video/a/c:eZf	I
    //   284: aload_1
    //   285: ldc_w 498
    //   288: ldc_w 557
    //   291: invokestatic 503	com/tencent/mm/plugin/voip/video/a/c:Z	(Ljava/lang/String;Ljava/lang/String;)I
    //   294: putfield 560	com/tencent/mm/plugin/voip/video/a/c:tHP	I
    //   297: aload_1
    //   298: aload_1
    //   299: getfield 560	com/tencent/mm/plugin/voip/video/a/c:tHP	I
    //   302: ldc_w 514
    //   305: invokestatic 520	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   308: putfield 563	com/tencent/mm/plugin/voip/video/a/c:lBy	I
    //   311: aload_1
    //   312: aload_1
    //   313: getfield 560	com/tencent/mm/plugin/voip/video/a/c:tHP	I
    //   316: ldc_w 525
    //   319: invokestatic 520	android/opengl/GLES20:glGetAttribLocation	(ILjava/lang/String;)I
    //   322: putfield 566	com/tencent/mm/plugin/voip/video/a/c:lBx	I
    //   325: aload_1
    //   326: aload_1
    //   327: getfield 560	com/tencent/mm/plugin/voip/video/a/c:tHP	I
    //   330: ldc_w 568
    //   333: invokestatic 533	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   336: putfield 571	com/tencent/mm/plugin/voip/video/a/c:lBz	I
    //   339: aload_1
    //   340: aload_1
    //   341: getfield 560	com/tencent/mm/plugin/voip/video/a/c:tHP	I
    //   344: ldc_w 543
    //   347: invokestatic 533	android/opengl/GLES20:glGetUniformLocation	(ILjava/lang/String;)I
    //   350: putfield 574	com/tencent/mm/plugin/voip/video/a/c:lBA	I
    //   353: aload_1
    //   354: invokestatic 549	com/tencent/mm/plugin/voip/video/a/c:Vm	()I
    //   357: putfield 577	com/tencent/mm/plugin/voip/video/a/c:lBw	I
    //   360: aload_1
    //   361: invokestatic 549	com/tencent/mm/plugin/voip/video/a/c:Vm	()I
    //   364: putfield 580	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   367: getstatic 584	com/tencent/mm/plugin/voip/video/a/c:eZq	[F
    //   370: astore 11
    //   372: aload_1
    //   373: aload 11
    //   375: aload 11
    //   377: arraylength
    //   378: invokestatic 590	java/util/Arrays:copyOf	([FI)[F
    //   381: putfield 593	com/tencent/mm/plugin/voip/video/a/c:gNF	[F
    //   384: aload_1
    //   385: aload_1
    //   386: getfield 593	com/tencent/mm/plugin/voip/video/a/c:gNF	[F
    //   389: arraylength
    //   390: iconst_4
    //   391: imul
    //   392: invokestatic 599	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   395: invokestatic 605	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   398: invokevirtual 609	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   401: invokevirtual 613	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   404: putfield 617	com/tencent/mm/plugin/voip/video/a/c:eYv	Ljava/nio/FloatBuffer;
    //   407: aload_1
    //   408: getfield 617	com/tencent/mm/plugin/voip/video/a/c:eYv	Ljava/nio/FloatBuffer;
    //   411: aload_1
    //   412: getfield 593	com/tencent/mm/plugin/voip/video/a/c:gNF	[F
    //   415: invokevirtual 623	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   418: pop
    //   419: aload_1
    //   420: getfield 617	com/tencent/mm/plugin/voip/video/a/c:eYv	Ljava/nio/FloatBuffer;
    //   423: iconst_0
    //   424: invokevirtual 627	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   427: pop
    //   428: aload_1
    //   429: getstatic 630	com/tencent/mm/plugin/voip/video/a/c:eZr	[F
    //   432: arraylength
    //   433: iconst_4
    //   434: imul
    //   435: invokestatic 599	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   438: invokestatic 605	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   441: invokevirtual 609	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   444: invokevirtual 613	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   447: putfield 633	com/tencent/mm/plugin/voip/video/a/c:eYu	Ljava/nio/FloatBuffer;
    //   450: aload_1
    //   451: getfield 633	com/tencent/mm/plugin/voip/video/a/c:eYu	Ljava/nio/FloatBuffer;
    //   454: getstatic 630	com/tencent/mm/plugin/voip/video/a/c:eZr	[F
    //   457: invokevirtual 623	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   460: pop
    //   461: aload_1
    //   462: getfield 633	com/tencent/mm/plugin/voip/video/a/c:eYu	Ljava/nio/FloatBuffer;
    //   465: iconst_0
    //   466: invokevirtual 627	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   469: pop
    //   470: getstatic 636	com/tencent/mm/plugin/voip/video/a/c:tHO	[F
    //   473: astore 11
    //   475: aload_1
    //   476: aload 11
    //   478: aload 11
    //   480: arraylength
    //   481: invokestatic 590	java/util/Arrays:copyOf	([FI)[F
    //   484: putfield 639	com/tencent/mm/plugin/voip/video/a/c:lBJ	[F
    //   487: aload_1
    //   488: aload_1
    //   489: getfield 639	com/tencent/mm/plugin/voip/video/a/c:lBJ	[F
    //   492: arraylength
    //   493: iconst_4
    //   494: imul
    //   495: invokestatic 599	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   498: invokestatic 605	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   501: invokevirtual 609	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   504: invokevirtual 613	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   507: putfield 642	com/tencent/mm/plugin/voip/video/a/c:lBE	Ljava/nio/FloatBuffer;
    //   510: aload_1
    //   511: getfield 642	com/tencent/mm/plugin/voip/video/a/c:lBE	Ljava/nio/FloatBuffer;
    //   514: aload_1
    //   515: getfield 639	com/tencent/mm/plugin/voip/video/a/c:lBJ	[F
    //   518: invokevirtual 623	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   521: pop
    //   522: aload_1
    //   523: getfield 642	com/tencent/mm/plugin/voip/video/a/c:lBE	Ljava/nio/FloatBuffer;
    //   526: iconst_0
    //   527: invokevirtual 627	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   530: pop
    //   531: getstatic 584	com/tencent/mm/plugin/voip/video/a/c:eZq	[F
    //   534: astore 11
    //   536: aload_1
    //   537: aload 11
    //   539: aload 11
    //   541: arraylength
    //   542: invokestatic 590	java/util/Arrays:copyOf	([FI)[F
    //   545: putfield 645	com/tencent/mm/plugin/voip/video/a/c:lBI	[F
    //   548: aload_1
    //   549: aload_1
    //   550: getfield 645	com/tencent/mm/plugin/voip/video/a/c:lBI	[F
    //   553: arraylength
    //   554: iconst_4
    //   555: imul
    //   556: invokestatic 599	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   559: invokestatic 605	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   562: invokevirtual 609	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   565: invokevirtual 613	java/nio/ByteBuffer:asFloatBuffer	()Ljava/nio/FloatBuffer;
    //   568: putfield 648	com/tencent/mm/plugin/voip/video/a/c:lBF	Ljava/nio/FloatBuffer;
    //   571: aload_1
    //   572: getfield 648	com/tencent/mm/plugin/voip/video/a/c:lBF	Ljava/nio/FloatBuffer;
    //   575: aload_1
    //   576: getfield 645	com/tencent/mm/plugin/voip/video/a/c:lBI	[F
    //   579: invokevirtual 623	java/nio/FloatBuffer:put	([F)Ljava/nio/FloatBuffer;
    //   582: pop
    //   583: aload_1
    //   584: getfield 648	com/tencent/mm/plugin/voip/video/a/c:lBF	Ljava/nio/FloatBuffer;
    //   587: iconst_0
    //   588: invokevirtual 627	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   591: pop
    //   592: aload_1
    //   593: invokestatic 651	com/tencent/mm/plugin/voip/video/a/c:Vn	()I
    //   596: putfield 654	com/tencent/mm/plugin/voip/video/a/c:lBK	I
    //   599: aload_1
    //   600: aconst_null
    //   601: putfield 657	com/tencent/mm/plugin/voip/video/a/c:tCl	[B
    //   604: aload_1
    //   605: invokestatic 651	com/tencent/mm/plugin/voip/video/a/c:Vn	()I
    //   608: putfield 660	com/tencent/mm/plugin/voip/video/a/c:lBL	I
    //   611: aload_1
    //   612: invokestatic 549	com/tencent/mm/plugin/voip/video/a/c:Vm	()I
    //   615: putfield 663	com/tencent/mm/plugin/voip/video/a/c:lBO	I
    //   618: iload_3
    //   619: ifeq +29 -> 648
    //   622: aload_1
    //   623: new 665	com/tencent/mm/plugin/voip/video/a/b
    //   626: dup
    //   627: invokespecial 666	com/tencent/mm/plugin/voip/video/a/b:<init>	()V
    //   630: putfield 670	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   633: aload_1
    //   634: getfield 670	com/tencent/mm/plugin/voip/video/a/c:tHT	Lcom/tencent/mm/plugin/voip/video/a/b;
    //   637: aload_1
    //   638: getfield 580	com/tencent/mm/plugin/voip/video/a/c:lBM	I
    //   641: aload_1
    //   642: getfield 663	com/tencent/mm/plugin/voip/video/a/c:lBO	I
    //   645: invokevirtual 673	com/tencent/mm/plugin/voip/video/a/b:initial	(II)V
    //   648: ldc_w 508
    //   651: ldc_w 675
    //   654: iconst_1
    //   655: anewarray 4	java/lang/Object
    //   658: dup
    //   659: iconst_0
    //   660: aload_1
    //   661: invokevirtual 431	java/lang/Object:hashCode	()I
    //   664: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: aastore
    //   668: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   671: aload_1
    //   672: iconst_1
    //   673: putfield 496	com/tencent/mm/plugin/voip/video/a/c:eLc	Z
    //   676: aload_0
    //   677: getfield 251	com/tencent/mm/plugin/voip/video/OpenGlRender:tGP	Lcom/tencent/mm/plugin/voip/video/a/c;
    //   680: aload_0
    //   681: getfield 176	com/tencent/mm/plugin/voip/video/OpenGlRender:tGC	I
    //   684: aload_0
    //   685: getfield 178	com/tencent/mm/plugin/voip/video/OpenGlRender:tGD	I
    //   688: invokevirtual 678	com/tencent/mm/plugin/voip/video/a/c:updateSize	(II)V
    //   691: iload_2
    //   692: ifne +76 -> 768
    //   695: aload_0
    //   696: getfield 251	com/tencent/mm/plugin/voip/video/OpenGlRender:tGP	Lcom/tencent/mm/plugin/voip/video/a/c;
    //   699: aload_0
    //   700: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   703: aload_0
    //   704: getfield 402	com/tencent/mm/plugin/voip/video/OpenGlRender:tGL	I
    //   707: aload_0
    //   708: getfield 404	com/tencent/mm/plugin/voip/video/OpenGlRender:tGM	I
    //   711: aload_0
    //   712: getfield 406	com/tencent/mm/plugin/voip/video/OpenGlRender:tGN	I
    //   715: iconst_0
    //   716: invokevirtual 680	com/tencent/mm/plugin/voip/video/a/c:c	([BIIII)V
    //   719: aload_0
    //   720: aconst_null
    //   721: putfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   724: aload_0
    //   725: getfield 194	com/tencent/mm/plugin/voip/video/OpenGlRender:tGU	Z
    //   728: ifeq +1541 -> 2269
    //   731: invokestatic 246	com/tencent/mm/plugin/voip/video/OpenGlRender:getGLVersion	()I
    //   734: iconst_2
    //   735: if_icmpne +1534 -> 2269
    //   738: fconst_0
    //   739: fconst_0
    //   740: fconst_0
    //   741: fconst_0
    //   742: invokestatic 684	android/opengl/GLES20:glClearColor	(FFFF)V
    //   745: sipush 16640
    //   748: invokestatic 687	android/opengl/GLES20:glClear	(I)V
    //   751: sipush 5073
    //   754: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   757: return
    //   758: iconst_0
    //   759: istore_2
    //   760: goto -643 -> 117
    //   763: iconst_0
    //   764: istore_3
    //   765: goto -636 -> 129
    //   768: aload_0
    //   769: getfield 251	com/tencent/mm/plugin/voip/video/OpenGlRender:tGP	Lcom/tencent/mm/plugin/voip/video/a/c;
    //   772: aload_0
    //   773: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   776: aload_0
    //   777: getfield 402	com/tencent/mm/plugin/voip/video/OpenGlRender:tGL	I
    //   780: aload_0
    //   781: getfield 404	com/tencent/mm/plugin/voip/video/OpenGlRender:tGM	I
    //   784: aload_0
    //   785: getfield 406	com/tencent/mm/plugin/voip/video/OpenGlRender:tGN	I
    //   788: aload_0
    //   789: getfield 253	com/tencent/mm/plugin/voip/video/OpenGlRender:tGS	I
    //   792: invokevirtual 680	com/tencent/mm/plugin/voip/video/a/c:c	([BIIII)V
    //   795: goto -76 -> 719
    //   798: aload_0
    //   799: getfield 258	com/tencent/mm/plugin/voip/video/OpenGlRender:tGQ	Lcom/tencent/mm/plugin/voip/video/b/f;
    //   802: ifnull -83 -> 719
    //   805: iconst_0
    //   806: istore 4
    //   808: iload 4
    //   810: istore_2
    //   811: aload_0
    //   812: getfield 408	com/tencent/mm/plugin/voip/video/OpenGlRender:tGR	Z
    //   815: ifeq +15 -> 830
    //   818: iload 4
    //   820: istore_2
    //   821: iload_3
    //   822: ifeq +8 -> 830
    //   825: aload_0
    //   826: getfield 253	com/tencent/mm/plugin/voip/video/OpenGlRender:tGS	I
    //   829: istore_2
    //   830: aload_0
    //   831: getfield 258	com/tencent/mm/plugin/voip/video/OpenGlRender:tGQ	Lcom/tencent/mm/plugin/voip/video/b/f;
    //   834: iconst_0
    //   835: invokevirtual 370	com/tencent/mm/plugin/voip/video/b/f:HY	(I)V
    //   838: aload_0
    //   839: getfield 258	com/tencent/mm/plugin/voip/video/OpenGlRender:tGQ	Lcom/tencent/mm/plugin/voip/video/b/f;
    //   842: astore 11
    //   844: aload_0
    //   845: getfield 402	com/tencent/mm/plugin/voip/video/OpenGlRender:tGL	I
    //   848: istore_3
    //   849: aload_0
    //   850: getfield 404	com/tencent/mm/plugin/voip/video/OpenGlRender:tGM	I
    //   853: istore 4
    //   855: aload_0
    //   856: getfield 176	com/tencent/mm/plugin/voip/video/OpenGlRender:tGC	I
    //   859: istore 6
    //   861: aload_0
    //   862: getfield 178	com/tencent/mm/plugin/voip/video/OpenGlRender:tGD	I
    //   865: istore 7
    //   867: aload_0
    //   868: getfield 410	com/tencent/mm/plugin/voip/video/OpenGlRender:tGT	I
    //   871: istore 5
    //   873: aload_0
    //   874: getfield 406	com/tencent/mm/plugin/voip/video/OpenGlRender:tGN	I
    //   877: istore 8
    //   879: iload_3
    //   880: ifle +531 -> 1411
    //   883: iload 4
    //   885: ifle +526 -> 1411
    //   888: iload 8
    //   890: iconst_2
    //   891: ishr
    //   892: iconst_3
    //   893: iand
    //   894: istore 9
    //   896: iload 8
    //   898: iconst_4
    //   899: ishr
    //   900: iconst_1
    //   901: iand
    //   902: iconst_1
    //   903: if_icmpne +715 -> 1618
    //   906: iconst_1
    //   907: istore 10
    //   909: aload 11
    //   911: iload_2
    //   912: putfield 690	com/tencent/mm/plugin/voip/video/b/f:tIV	I
    //   915: iload_3
    //   916: aload 11
    //   918: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   921: if_icmpne +63 -> 984
    //   924: iload 4
    //   926: aload 11
    //   928: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   931: if_icmpne +53 -> 984
    //   934: iload 6
    //   936: aload 11
    //   938: getfield 699	com/tencent/mm/plugin/voip/video/b/f:mScreenWidth	I
    //   941: if_icmpne +43 -> 984
    //   944: iload 7
    //   946: aload 11
    //   948: getfield 702	com/tencent/mm/plugin/voip/video/b/f:mScreenHeight	I
    //   951: if_icmpne +33 -> 984
    //   954: aload 11
    //   956: getfield 705	com/tencent/mm/plugin/voip/video/b/f:tIU	I
    //   959: iload 9
    //   961: if_icmpne +23 -> 984
    //   964: aload 11
    //   966: getfield 708	com/tencent/mm/plugin/voip/video/b/f:bHo	Z
    //   969: iload 10
    //   971: if_icmpne +13 -> 984
    //   974: aload 11
    //   976: getfield 711	com/tencent/mm/plugin/voip/video/b/f:tIP	I
    //   979: iload 5
    //   981: if_icmpeq +430 -> 1411
    //   984: aload 11
    //   986: iload 9
    //   988: putfield 705	com/tencent/mm/plugin/voip/video/b/f:tIU	I
    //   991: aload 11
    //   993: iload 10
    //   995: putfield 708	com/tencent/mm/plugin/voip/video/b/f:bHo	Z
    //   998: aload 11
    //   1000: iload 5
    //   1002: putfield 711	com/tencent/mm/plugin/voip/video/b/f:tIP	I
    //   1005: ldc_w 713
    //   1008: ldc_w 715
    //   1011: bipush 11
    //   1013: anewarray 4	java/lang/Object
    //   1016: dup
    //   1017: iconst_0
    //   1018: iload 5
    //   1020: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1023: aastore
    //   1024: dup
    //   1025: iconst_1
    //   1026: aload 11
    //   1028: getfield 705	com/tencent/mm/plugin/voip/video/b/f:tIU	I
    //   1031: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1034: aastore
    //   1035: dup
    //   1036: iconst_2
    //   1037: aload 11
    //   1039: getfield 708	com/tencent/mm/plugin/voip/video/b/f:bHo	Z
    //   1042: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1045: aastore
    //   1046: dup
    //   1047: iconst_3
    //   1048: iload_3
    //   1049: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1052: aastore
    //   1053: dup
    //   1054: iconst_4
    //   1055: iload 4
    //   1057: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1060: aastore
    //   1061: dup
    //   1062: iconst_5
    //   1063: iload 6
    //   1065: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1068: aastore
    //   1069: dup
    //   1070: bipush 6
    //   1072: iload 7
    //   1074: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1077: aastore
    //   1078: dup
    //   1079: bipush 7
    //   1081: aload 11
    //   1083: getfield 718	com/tencent/mm/plugin/voip/video/b/f:tIO	I
    //   1086: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1089: aastore
    //   1090: dup
    //   1091: bipush 8
    //   1093: aload 11
    //   1095: getfield 721	com/tencent/mm/plugin/voip/video/b/f:tIY	I
    //   1098: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1101: aastore
    //   1102: dup
    //   1103: bipush 9
    //   1105: aload 11
    //   1107: getfield 724	com/tencent/mm/plugin/voip/video/b/f:tIZ	I
    //   1110: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1113: aastore
    //   1114: dup
    //   1115: bipush 10
    //   1117: aload 11
    //   1119: getfield 690	com/tencent/mm/plugin/voip/video/b/f:tIV	I
    //   1122: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1125: aastore
    //   1126: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1129: aload 11
    //   1131: iload_3
    //   1132: putfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1135: aload 11
    //   1137: iload 4
    //   1139: putfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1142: aload 11
    //   1144: iload 6
    //   1146: putfield 699	com/tencent/mm/plugin/voip/video/b/f:mScreenWidth	I
    //   1149: aload 11
    //   1151: iload 7
    //   1153: putfield 702	com/tencent/mm/plugin/voip/video/b/f:mScreenHeight	I
    //   1156: aload 11
    //   1158: aload 11
    //   1160: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1163: aload 11
    //   1165: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1168: invokevirtual 727	com/tencent/mm/plugin/voip/video/b/f:gs	(II)V
    //   1171: iload_3
    //   1172: iload 4
    //   1174: imul
    //   1175: istore_2
    //   1176: iload_2
    //   1177: iconst_4
    //   1178: idiv
    //   1179: istore 6
    //   1181: aload 11
    //   1183: monitorenter
    //   1184: aload 11
    //   1186: iload 6
    //   1188: iconst_2
    //   1189: imul
    //   1190: iload_2
    //   1191: iadd
    //   1192: invokestatic 730	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1195: putfield 734	com/tencent/mm/plugin/voip/video/b/f:tIQ	Ljava/nio/ByteBuffer;
    //   1198: aload 11
    //   1200: iload_2
    //   1201: invokestatic 730	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1204: putfield 737	com/tencent/mm/plugin/voip/video/b/f:y	Ljava/nio/ByteBuffer;
    //   1207: aload 11
    //   1209: iload 6
    //   1211: invokestatic 730	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1214: putfield 740	com/tencent/mm/plugin/voip/video/b/f:tIR	Ljava/nio/ByteBuffer;
    //   1217: aload 11
    //   1219: iload 6
    //   1221: invokestatic 730	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1224: putfield 743	com/tencent/mm/plugin/voip/video/b/f:tIS	Ljava/nio/ByteBuffer;
    //   1227: aload 11
    //   1229: iload 6
    //   1231: iconst_2
    //   1232: imul
    //   1233: invokestatic 730	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   1236: putfield 746	com/tencent/mm/plugin/voip/video/b/f:tIT	Ljava/nio/ByteBuffer;
    //   1239: aload 11
    //   1241: monitorexit
    //   1242: aload 11
    //   1244: getfield 750	com/tencent/mm/plugin/voip/video/b/f:tIK	Lcom/tencent/mm/plugin/voip/video/b/c;
    //   1247: ifnull +164 -> 1411
    //   1250: iload 5
    //   1252: iconst_3
    //   1253: if_icmpne +158 -> 1411
    //   1256: aload 11
    //   1258: getfield 750	com/tencent/mm/plugin/voip/video/b/f:tIK	Lcom/tencent/mm/plugin/voip/video/b/c;
    //   1261: astore 11
    //   1263: ldc_w 752
    //   1266: ldc_w 754
    //   1269: iconst_4
    //   1270: anewarray 4	java/lang/Object
    //   1273: dup
    //   1274: iconst_0
    //   1275: iload_3
    //   1276: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1279: aastore
    //   1280: dup
    //   1281: iconst_1
    //   1282: iload 4
    //   1284: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1287: aastore
    //   1288: dup
    //   1289: iconst_2
    //   1290: aload 11
    //   1292: getfield 759	com/tencent/mm/plugin/voip/video/b/c:eXo	I
    //   1295: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1298: aastore
    //   1299: dup
    //   1300: iconst_3
    //   1301: aload 11
    //   1303: getfield 762	com/tencent/mm/plugin/voip/video/b/c:eXp	I
    //   1306: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1309: aastore
    //   1310: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1313: iload_3
    //   1314: aload 11
    //   1316: getfield 759	com/tencent/mm/plugin/voip/video/b/c:eXo	I
    //   1319: if_icmpne +13 -> 1332
    //   1322: aload 11
    //   1324: getfield 762	com/tencent/mm/plugin/voip/video/b/c:eXp	I
    //   1327: iload 4
    //   1329: if_icmpeq +82 -> 1411
    //   1332: aload 11
    //   1334: iload_3
    //   1335: putfield 759	com/tencent/mm/plugin/voip/video/b/c:eXo	I
    //   1338: aload 11
    //   1340: iload 4
    //   1342: putfield 762	com/tencent/mm/plugin/voip/video/b/c:eXp	I
    //   1345: aload 11
    //   1347: getfield 766	com/tencent/mm/plugin/voip/video/b/c:tIA	Lcom/tencent/mm/plugin/voip/video/b/a;
    //   1350: astore 11
    //   1352: ldc_w 752
    //   1355: ldc_w 768
    //   1358: iconst_4
    //   1359: anewarray 4	java/lang/Object
    //   1362: dup
    //   1363: iconst_0
    //   1364: iload_3
    //   1365: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_1
    //   1371: iload 4
    //   1373: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1376: aastore
    //   1377: dup
    //   1378: iconst_2
    //   1379: aload 11
    //   1381: getfield 773	com/tencent/mm/plugin/voip/video/b/a:fbH	I
    //   1384: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1387: aastore
    //   1388: dup
    //   1389: iconst_3
    //   1390: aload 11
    //   1392: getfield 776	com/tencent/mm/plugin/voip/video/b/a:fbI	I
    //   1395: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1398: aastore
    //   1399: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1402: iload_3
    //   1403: ifle +8 -> 1411
    //   1406: iload 4
    //   1408: ifgt +228 -> 1636
    //   1411: aload_0
    //   1412: getfield 258	com/tencent/mm/plugin/voip/video/OpenGlRender:tGQ	Lcom/tencent/mm/plugin/voip/video/b/f;
    //   1415: astore 11
    //   1417: aload_0
    //   1418: getfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   1421: astore 12
    //   1423: aload_0
    //   1424: getfield 410	com/tencent/mm/plugin/voip/video/OpenGlRender:tGT	I
    //   1427: istore_2
    //   1428: aload 11
    //   1430: monitorenter
    //   1431: aload 11
    //   1433: iconst_0
    //   1434: putfield 779	com/tencent/mm/plugin/voip/video/b/f:tIX	Z
    //   1437: aload 11
    //   1439: getfield 782	com/tencent/mm/plugin/voip/video/b/f:tIW	Z
    //   1442: ifeq +162 -> 1604
    //   1445: aload 12
    //   1447: ifnull +157 -> 1604
    //   1450: aload 11
    //   1452: iload_2
    //   1453: putfield 711	com/tencent/mm/plugin/voip/video/b/f:tIP	I
    //   1456: aload 11
    //   1458: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1461: aload 11
    //   1463: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1466: imul
    //   1467: iconst_3
    //   1468: imul
    //   1469: iconst_2
    //   1470: idiv
    //   1471: istore 5
    //   1473: iload_2
    //   1474: iconst_3
    //   1475: if_icmpne +327 -> 1802
    //   1478: aload 12
    //   1480: arraylength
    //   1481: iload 5
    //   1483: if_icmpne +238 -> 1721
    //   1486: aload 11
    //   1488: getfield 734	com/tencent/mm/plugin/voip/video/b/f:tIQ	Ljava/nio/ByteBuffer;
    //   1491: invokevirtual 786	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1494: pop
    //   1495: aload 11
    //   1497: getfield 737	com/tencent/mm/plugin/voip/video/b/f:y	Ljava/nio/ByteBuffer;
    //   1500: invokevirtual 786	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1503: pop
    //   1504: aload 11
    //   1506: getfield 746	com/tencent/mm/plugin/voip/video/b/f:tIT	Ljava/nio/ByteBuffer;
    //   1509: invokevirtual 786	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1512: pop
    //   1513: aload 11
    //   1515: getfield 734	com/tencent/mm/plugin/voip/video/b/f:tIQ	Ljava/nio/ByteBuffer;
    //   1518: aload 12
    //   1520: iconst_0
    //   1521: aload 11
    //   1523: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1526: aload 11
    //   1528: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1531: imul
    //   1532: iconst_3
    //   1533: imul
    //   1534: iconst_2
    //   1535: idiv
    //   1536: invokevirtual 789	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1539: pop
    //   1540: aload 11
    //   1542: getfield 737	com/tencent/mm/plugin/voip/video/b/f:y	Ljava/nio/ByteBuffer;
    //   1545: aload 12
    //   1547: iconst_0
    //   1548: aload 11
    //   1550: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1553: aload 11
    //   1555: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1558: imul
    //   1559: invokevirtual 789	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1562: pop
    //   1563: aload 11
    //   1565: getfield 746	com/tencent/mm/plugin/voip/video/b/f:tIT	Ljava/nio/ByteBuffer;
    //   1568: aload 12
    //   1570: aload 11
    //   1572: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1575: aload 11
    //   1577: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1580: imul
    //   1581: aload 11
    //   1583: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1586: aload 11
    //   1588: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1591: imul
    //   1592: iconst_2
    //   1593: idiv
    //   1594: invokevirtual 789	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1597: pop
    //   1598: aload 11
    //   1600: iconst_1
    //   1601: putfield 779	com/tencent/mm/plugin/voip/video/b/f:tIX	Z
    //   1604: aload 11
    //   1606: monitorexit
    //   1607: aload_0
    //   1608: getfield 258	com/tencent/mm/plugin/voip/video/OpenGlRender:tGQ	Lcom/tencent/mm/plugin/voip/video/b/f;
    //   1611: aload_1
    //   1612: invokevirtual 791	com/tencent/mm/plugin/voip/video/b/f:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   1615: goto -896 -> 719
    //   1618: iconst_0
    //   1619: istore 10
    //   1621: goto -712 -> 909
    //   1624: astore_1
    //   1625: aload 11
    //   1627: monitorexit
    //   1628: sipush 5073
    //   1631: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1634: aload_1
    //   1635: athrow
    //   1636: aload 11
    //   1638: getfield 792	com/tencent/mm/plugin/voip/video/b/a:eXo	I
    //   1641: iload_3
    //   1642: if_icmpne +13 -> 1655
    //   1645: aload 11
    //   1647: getfield 793	com/tencent/mm/plugin/voip/video/b/a:eXp	I
    //   1650: iload 4
    //   1652: if_icmpeq -241 -> 1411
    //   1655: aload 11
    //   1657: iload_3
    //   1658: putfield 792	com/tencent/mm/plugin/voip/video/b/a:eXo	I
    //   1661: aload 11
    //   1663: iload 4
    //   1665: putfield 793	com/tencent/mm/plugin/voip/video/b/a:eXp	I
    //   1668: ldc_w 752
    //   1671: ldc_w 795
    //   1674: iconst_2
    //   1675: anewarray 4	java/lang/Object
    //   1678: dup
    //   1679: iconst_0
    //   1680: aload 11
    //   1682: getfield 792	com/tencent/mm/plugin/voip/video/b/a:eXo	I
    //   1685: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1688: aastore
    //   1689: dup
    //   1690: iconst_1
    //   1691: aload 11
    //   1693: getfield 793	com/tencent/mm/plugin/voip/video/b/a:eXp	I
    //   1696: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1699: aastore
    //   1700: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1703: aload 11
    //   1705: aload 11
    //   1707: getfield 792	com/tencent/mm/plugin/voip/video/b/a:eXo	I
    //   1710: aload 11
    //   1712: getfield 793	com/tencent/mm/plugin/voip/video/b/a:eXp	I
    //   1715: invokevirtual 798	com/tencent/mm/plugin/voip/video/b/a:gq	(II)V
    //   1718: goto -307 -> 1411
    //   1721: ldc_w 713
    //   1724: ldc_w 800
    //   1727: iconst_4
    //   1728: anewarray 4	java/lang/Object
    //   1731: dup
    //   1732: iconst_0
    //   1733: aload 12
    //   1735: arraylength
    //   1736: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1739: aastore
    //   1740: dup
    //   1741: iconst_1
    //   1742: iload 5
    //   1744: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1747: aastore
    //   1748: dup
    //   1749: iconst_2
    //   1750: aload 11
    //   1752: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1755: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1758: aastore
    //   1759: dup
    //   1760: iconst_3
    //   1761: aload 11
    //   1763: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1766: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1769: aastore
    //   1770: invokestatic 484	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1773: aload 11
    //   1775: iconst_0
    //   1776: putfield 779	com/tencent/mm/plugin/voip/video/b/f:tIX	Z
    //   1779: getstatic 806	com/tencent/mm/plugin/voip/model/s:tyN	Lcom/tencent/mm/plugin/voip/model/s;
    //   1782: astore 12
    //   1784: invokestatic 809	com/tencent/mm/plugin/voip/model/s:cNO	()V
    //   1787: goto -183 -> 1604
    //   1790: astore_1
    //   1791: aload 11
    //   1793: monitorexit
    //   1794: sipush 5073
    //   1797: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1800: aload_1
    //   1801: athrow
    //   1802: aload 11
    //   1804: aload 11
    //   1806: getfield 721	com/tencent/mm/plugin/voip/video/b/f:tIY	I
    //   1809: iconst_1
    //   1810: iadd
    //   1811: putfield 721	com/tencent/mm/plugin/voip/video/b/f:tIY	I
    //   1814: aload 11
    //   1816: getfield 721	com/tencent/mm/plugin/voip/video/b/f:tIY	I
    //   1819: bipush 100
    //   1821: irem
    //   1822: ifne +60 -> 1882
    //   1825: ldc_w 713
    //   1828: ldc_w 811
    //   1831: iconst_4
    //   1832: anewarray 4	java/lang/Object
    //   1835: dup
    //   1836: iconst_0
    //   1837: aload 11
    //   1839: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1842: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1845: aastore
    //   1846: dup
    //   1847: iconst_1
    //   1848: aload 11
    //   1850: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1853: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1856: aastore
    //   1857: dup
    //   1858: iconst_2
    //   1859: aload 11
    //   1861: getfield 721	com/tencent/mm/plugin/voip/video/b/f:tIY	I
    //   1864: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1867: aastore
    //   1868: dup
    //   1869: iconst_3
    //   1870: aload 11
    //   1872: getfield 690	com/tencent/mm/plugin/voip/video/b/f:tIV	I
    //   1875: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1878: aastore
    //   1879: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1882: aload 12
    //   1884: arraylength
    //   1885: iload 5
    //   1887: if_icmplt +192 -> 2079
    //   1890: aload 11
    //   1892: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1895: istore 6
    //   1897: aload 11
    //   1899: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1902: istore 7
    //   1904: aload 11
    //   1906: getfield 721	com/tencent/mm/plugin/voip/video/b/f:tIY	I
    //   1909: bipush 100
    //   1911: irem
    //   1912: ifne +417 -> 2329
    //   1915: aload 12
    //   1917: ifnull +407 -> 2324
    //   1920: aload 12
    //   1922: arraylength
    //   1923: iload 6
    //   1925: iload 7
    //   1927: imul
    //   1928: iconst_3
    //   1929: imul
    //   1930: iconst_2
    //   1931: idiv
    //   1932: if_icmple +392 -> 2324
    //   1935: iconst_0
    //   1936: istore_2
    //   1937: iconst_0
    //   1938: istore_3
    //   1939: goto +337 -> 2276
    //   1942: iload_2
    //   1943: ifeq +136 -> 2079
    //   1946: aload 11
    //   1948: getfield 737	com/tencent/mm/plugin/voip/video/b/f:y	Ljava/nio/ByteBuffer;
    //   1951: invokevirtual 786	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1954: pop
    //   1955: aload 11
    //   1957: getfield 740	com/tencent/mm/plugin/voip/video/b/f:tIR	Ljava/nio/ByteBuffer;
    //   1960: invokevirtual 786	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1963: pop
    //   1964: aload 11
    //   1966: getfield 743	com/tencent/mm/plugin/voip/video/b/f:tIS	Ljava/nio/ByteBuffer;
    //   1969: invokevirtual 786	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1972: pop
    //   1973: aload 11
    //   1975: getfield 737	com/tencent/mm/plugin/voip/video/b/f:y	Ljava/nio/ByteBuffer;
    //   1978: aload 12
    //   1980: iconst_0
    //   1981: aload 11
    //   1983: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   1986: aload 11
    //   1988: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   1991: imul
    //   1992: invokevirtual 789	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1995: pop
    //   1996: aload 11
    //   1998: getfield 740	com/tencent/mm/plugin/voip/video/b/f:tIR	Ljava/nio/ByteBuffer;
    //   2001: aload 12
    //   2003: aload 11
    //   2005: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   2008: aload 11
    //   2010: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   2013: imul
    //   2014: aload 11
    //   2016: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   2019: aload 11
    //   2021: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   2024: imul
    //   2025: iconst_4
    //   2026: idiv
    //   2027: invokevirtual 789	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2030: pop
    //   2031: aload 11
    //   2033: getfield 743	com/tencent/mm/plugin/voip/video/b/f:tIS	Ljava/nio/ByteBuffer;
    //   2036: aload 12
    //   2038: aload 11
    //   2040: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   2043: aload 11
    //   2045: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   2048: imul
    //   2049: iconst_5
    //   2050: imul
    //   2051: iconst_4
    //   2052: idiv
    //   2053: aload 11
    //   2055: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   2058: aload 11
    //   2060: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   2063: imul
    //   2064: iconst_4
    //   2065: idiv
    //   2066: invokevirtual 789	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   2069: pop
    //   2070: aload 11
    //   2072: iconst_1
    //   2073: putfield 779	com/tencent/mm/plugin/voip/video/b/f:tIX	Z
    //   2076: goto -472 -> 1604
    //   2079: ldc_w 713
    //   2082: ldc_w 813
    //   2085: iconst_4
    //   2086: anewarray 4	java/lang/Object
    //   2089: dup
    //   2090: iconst_0
    //   2091: aload 12
    //   2093: arraylength
    //   2094: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2097: aastore
    //   2098: dup
    //   2099: iconst_1
    //   2100: iload 5
    //   2102: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2105: aastore
    //   2106: dup
    //   2107: iconst_2
    //   2108: aload 11
    //   2110: getfield 693	com/tencent/mm/plugin/voip/video/b/f:mVideoWidth	I
    //   2113: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2116: aastore
    //   2117: dup
    //   2118: iconst_3
    //   2119: aload 11
    //   2121: getfield 696	com/tencent/mm/plugin/voip/video/b/f:mVideoHeight	I
    //   2124: invokestatic 309	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2127: aastore
    //   2128: invokestatic 484	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2131: aload 11
    //   2133: iconst_0
    //   2134: putfield 779	com/tencent/mm/plugin/voip/video/b/f:tIX	Z
    //   2137: getstatic 806	com/tencent/mm/plugin/voip/model/s:tyN	Lcom/tencent/mm/plugin/voip/model/s;
    //   2140: astore 12
    //   2142: invokestatic 816	com/tencent/mm/plugin/voip/model/s:cNP	()V
    //   2145: goto -541 -> 1604
    //   2148: aload_0
    //   2149: getfield 168	com/tencent/mm/plugin/voip/video/OpenGlRender:tGy	Z
    //   2152: ifeq +20 -> 2172
    //   2155: aload_0
    //   2156: getfield 166	com/tencent/mm/plugin/voip/video/OpenGlRender:tGx	Z
    //   2159: ifeq +13 -> 2172
    //   2162: aload_0
    //   2163: getfield 229	com/tencent/mm/plugin/voip/video/OpenGlRender:tGE	Ljava/lang/ref/WeakReference;
    //   2166: invokevirtual 279	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   2169: ifnonnull +63 -> 2232
    //   2172: aload_0
    //   2173: aconst_null
    //   2174: putfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   2177: aload_0
    //   2178: aconst_null
    //   2179: putfield 192	com/tencent/mm/plugin/voip/video/OpenGlRender:tGK	[I
    //   2182: getstatic 99	com/tencent/mm/plugin/voip/video/OpenGlRender:TAG	Ljava/lang/String;
    //   2185: ldc_w 818
    //   2188: iconst_3
    //   2189: anewarray 4	java/lang/Object
    //   2192: dup
    //   2193: iconst_0
    //   2194: aload_0
    //   2195: getfield 168	com/tencent/mm/plugin/voip/video/OpenGlRender:tGy	Z
    //   2198: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2201: aastore
    //   2202: dup
    //   2203: iconst_1
    //   2204: aload_0
    //   2205: getfield 166	com/tencent/mm/plugin/voip/video/OpenGlRender:tGx	Z
    //   2208: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2211: aastore
    //   2212: dup
    //   2213: iconst_2
    //   2214: aload_0
    //   2215: getfield 408	com/tencent/mm/plugin/voip/video/OpenGlRender:tGR	Z
    //   2218: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2221: aastore
    //   2222: invokestatic 493	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2225: sipush 5073
    //   2228: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2231: return
    //   2232: aload_0
    //   2233: getfield 258	com/tencent/mm/plugin/voip/video/OpenGlRender:tGQ	Lcom/tencent/mm/plugin/voip/video/b/f;
    //   2236: ifnull +33 -> 2269
    //   2239: aload_0
    //   2240: getfield 206	com/tencent/mm/plugin/voip/video/OpenGlRender:tHd	Z
    //   2243: ifeq +8 -> 2251
    //   2246: aload_0
    //   2247: iconst_1
    //   2248: invokespecial 372	com/tencent/mm/plugin/voip/video/OpenGlRender:ne	(Z)V
    //   2251: aload_0
    //   2252: getfield 258	com/tencent/mm/plugin/voip/video/OpenGlRender:tGQ	Lcom/tencent/mm/plugin/voip/video/b/f;
    //   2255: aload_1
    //   2256: invokevirtual 791	com/tencent/mm/plugin/voip/video/b/f:onDrawFrame	(Ljavax/microedition/khronos/opengles/GL10;)V
    //   2259: aload_0
    //   2260: aconst_null
    //   2261: putfield 190	com/tencent/mm/plugin/voip/video/OpenGlRender:tGJ	[B
    //   2264: aload_0
    //   2265: aconst_null
    //   2266: putfield 192	com/tencent/mm/plugin/voip/video/OpenGlRender:tGK	[I
    //   2269: sipush 5073
    //   2272: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2275: return
    //   2276: iload_3
    //   2277: iload 6
    //   2279: iload 7
    //   2281: imul
    //   2282: if_icmpge +28 -> 2310
    //   2285: iload_2
    //   2286: istore 4
    //   2288: aload 12
    //   2290: iload_3
    //   2291: baload
    //   2292: ifne +8 -> 2300
    //   2295: iload_2
    //   2296: iconst_1
    //   2297: iadd
    //   2298: istore 4
    //   2300: iload_3
    //   2301: iconst_1
    //   2302: iadd
    //   2303: istore_3
    //   2304: iload 4
    //   2306: istore_2
    //   2307: goto -31 -> 2276
    //   2310: iload_2
    //   2311: iload 6
    //   2313: iload 7
    //   2315: imul
    //   2316: if_icmplt +13 -> 2329
    //   2319: iconst_0
    //   2320: istore_2
    //   2321: goto -379 -> 1942
    //   2324: iconst_0
    //   2325: istore_2
    //   2326: goto -384 -> 1942
    //   2329: iconst_1
    //   2330: istore_2
    //   2331: goto -389 -> 1942
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2334	0	this	OpenGlRender
    //   0	2334	1	paramGL10	GL10
    //   116	2215	2	i	int
    //   128	2176	3	j	int
    //   806	1499	4	k	int
    //   871	1230	5	m	int
    //   859	1457	6	n	int
    //   865	1451	7	i1	int
    //   877	23	8	i2	int
    //   894	93	9	i3	int
    //   907	713	10	bool	boolean
    //   370	1762	11	localObject1	Object
    //   1421	868	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   1184	1242	1624	finally
    //   1625	1628	1624	finally
    //   1431	1445	1790	finally
    //   1450	1473	1790	finally
    //   1478	1604	1790	finally
    //   1604	1607	1790	finally
    //   1721	1787	1790	finally
    //   1791	1794	1790	finally
    //   1802	1882	1790	finally
    //   1882	1915	1790	finally
    //   1920	1935	1790	finally
    //   1946	2076	1790	finally
    //   2079	2145	1790	finally
  }
  
  public final void onStarted()
  {
    AppMethodBeat.i(140205);
    this.tGy = true;
    requestRender();
    AppMethodBeat.o(140205);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5077);
    ab.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d, lastHWDecSize:%dx%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.tGR), Integer.valueOf(this.tGC), Integer.valueOf(this.tGD), Integer.valueOf(this.mRenderMode), Integer.valueOf(this.txY), Integer.valueOf(this.txZ) });
    if ((this.tGC != paramInt1) || (this.tGD != paramInt2))
    {
      paramGL10.glViewport(0, 0, paramInt1, paramInt2);
      this.tGC = paramInt1;
      this.tGD = paramInt2;
    }
    if (this.tGP != null) {
      this.tGP.updateSize(paramInt1, paramInt2);
    }
    if (this.tGQ != null) {
      this.tGQ.onSurfaceChanged(paramGL10, paramInt1, paramInt2);
    }
    HV(this.tGW);
    gj(this.txY, this.txZ);
    AppMethodBeat.o(5077);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(140204);
    ab.i(TAG, "onSurfaceCreated...");
    if (getGLVersion() == 2)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glDisable(2929);
    }
    if (this.tGQ != null) {
      this.tGQ.onSurfaceCreated(paramGL10, paramEGLConfig);
    }
    if (v2protocal.tBR == null)
    {
      paramGL10 = d.cPX();
      try
      {
        paramEGLConfig = new int[1];
        GLES20.glGenTextures(1, paramEGLConfig, 0);
        GLES20.glBindTexture(36197, paramEGLConfig[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0F);
        GLES20.glTexParameterf(36197, 10240, 9729.0F);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        ab.i("MicroMsg.VoipHardDecodeUtil", "init texture id is %s", new Object[] { Integer.valueOf(paramEGLConfig[0]) });
        paramGL10.textureId = paramEGLConfig[0];
        paramEGLConfig = s.tyN;
        s.cNz();
        if (paramGL10.textureId <= 0)
        {
          paramEGLConfig = s.tyN;
          s.cNA();
        }
        paramGL10.mSurfaceTexture = new SurfaceTexture(paramGL10.textureId);
        paramGL10.mSurfaceTexture.detachFromGLContext();
        GLES20.glDeleteTextures(1, new int[] { paramGL10.textureId }, 0);
        paramGL10.textureId = -1;
        paramGL10.mSurfaceTexture = paramGL10.mSurfaceTexture;
        paramGL10.tIH = false;
        paramEGLConfig = new Surface(paramGL10.mSurfaceTexture);
        v2protocal.mSurfaceTexture = paramGL10.mSurfaceTexture;
        v2protocal.textureId = paramGL10.textureId;
        v2protocal.tBR = paramEGLConfig;
        paramGL10.tII.tW();
        AppMethodBeat.o(140204);
        return;
      }
      catch (Exception paramGL10)
      {
        ab.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", paramGL10, "initSurfaceTexutre error", new Object[0]);
        paramGL10 = s.tyN;
        s.cNB();
      }
    }
    AppMethodBeat.o(140204);
  }
  
  public final void requestRender()
  {
    AppMethodBeat.i(5081);
    if (this.tGE.get() != null) {
      ((OpenGlView)this.tGE.get()).cPL();
    }
    AppMethodBeat.o(5081);
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(5080);
    ab.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.tGR), Integer.valueOf(paramInt), Integer.valueOf(this.tGS) });
    this.tGS = paramInt;
    AppMethodBeat.o(5080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender
 * JD-Core Version:    0.7.0.1
 */