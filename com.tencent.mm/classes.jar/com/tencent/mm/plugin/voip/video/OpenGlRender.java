package com.tencent.mm.plugin.voip.video;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.voip.video.a.a;
import com.tencent.mm.plugin.voip.video.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender
  implements GLSurfaceView.Renderer
{
  public static int FLAG_Angle270 = 12;
  public static int FLAG_Angle90;
  public static int FLAG_Mirror = 16;
  public static int FLAG_NV12;
  public static int FLAG_NV21;
  public static int FLAG_RGBA;
  public static int FLAG_RGBAClip;
  public static int FLAG_YV12;
  public static int FLAG_YV12Edge;
  public static int MSG_FLUSH;
  public static int MSG_RENDER;
  public static int MSG_RESET;
  public static int RenderLocal = 0;
  public static int RenderRemote = 1;
  public static String TAG = "OpenGlRender";
  public static int qbn = 0;
  static boolean qbu = false;
  public float mBrightness = 1.2F;
  public float mContrast = 1.93F;
  int mRenderMode = RenderLocal;
  public float mSaturation = 1.05F;
  boolean qaQ = false;
  int qaR = 0;
  long qaS = 0L;
  long qaT = 0L;
  int qaU = 0;
  OpenGlRender.a qaV;
  boolean qaW = false;
  public boolean qaX = false;
  boolean qaY = false;
  boolean qaZ = false;
  boolean qba = false;
  int qbb = 0;
  int qbc = 0;
  WeakReference<OpenGlView> qbd;
  public boolean qbe = false;
  public Bitmap qbf = null;
  private int qbg = 0;
  private int qbh = 0;
  private byte[] qbi = null;
  private int[] qbj = null;
  private int qbk;
  private int qbl;
  private int qbm;
  b qbo;
  private boolean qbp;
  private int qbq;
  private volatile boolean qbr = false;
  public volatile boolean qbs = false;
  WeakReference<Object> qbt;
  
  static
  {
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
  }
  
  public OpenGlRender(OpenGlView paramOpenGlView, int paramInt)
  {
    if (!qbu)
    {
      k.b("mm_gl_disp", OpenGlRender.class.getClassLoader());
      qbu = true;
    }
    this.mRenderMode = paramInt;
    this.qbd = new WeakReference(paramOpenGlView);
    paramOpenGlView = Looper.myLooper();
    if (paramOpenGlView != null) {
      this.qaV = new OpenGlRender.a(this, paramOpenGlView);
    }
    for (;;)
    {
      this.qbt = null;
      if (getGLVersion() == 2) {
        this.qbo = new b();
      }
      this.qbq = 0;
      return;
      paramOpenGlView = Looper.getMainLooper();
      if (paramOpenGlView != null) {
        this.qaV = new OpenGlRender.a(this, paramOpenGlView);
      } else {
        this.qaV = null;
      }
    }
  }
  
  public static int getGLVersion()
  {
    if (qbn == 0)
    {
      if (com.tencent.mm.compatible.util.d.gF(21))
      {
        qbn = 2;
        y.i(TAG, "init gl version: %s", new Object[] { Integer.valueOf(qbn) });
      }
    }
    else {
      return qbn;
    }
    if (((ActivityManager)ae.getContext().getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion == 131072) {}
    for (int i = 2;; i = 1)
    {
      qbn = i;
      if (!Build.MODEL.equals("Nexus 6")) {
        break;
      }
      qbn = 2;
      break;
    }
  }
  
  private native void render32(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void render8(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  final native void Init(int paramInt1, Object paramObject, int paramInt2);
  
  final native void Uninit(int paramInt);
  
  public final void a(com.tencent.mm.plugin.voip.video.a.d paramd)
  {
    if ((this.qbo != null) && (this.qbo.bSF() != null)) {
      paramd.aW(this.qbo.bSF());
    }
  }
  
  public final void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.qaW) && (this.qbj == null))
    {
      this.qbk = paramInt1;
      this.qbl = paramInt2;
      this.qbm = paramInt3;
      this.qbj = paramArrayOfInt;
      this.qbp = paramBoolean;
      requestRender();
    }
  }
  
  public final void bSy()
  {
    y.i(TAG, "%s onStop, renderMode: %s", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
    this.qaX = false;
    this.qba = false;
  }
  
  public final void bSz()
  {
    y.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.qaW), Boolean.valueOf(this.qaX) });
    if ((this.qaW) && (this.qaX))
    {
      y.i(TAG, "%s steve: Reset GLRender first! mode=%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode) });
      this.qaW = false;
      this.qaX = false;
      Uninit(this.mRenderMode);
      if (this.qbo != null)
      {
        if ((this.qbd == null) || (this.qbd.get() == null)) {
          break label164;
        }
        ((OpenGlView)this.qbd.get()).queueEvent(new OpenGlRender.1(this));
      }
    }
    label164:
    while (this.qbo == null) {
      return;
    }
    this.qbo.destroy();
  }
  
  public final void c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.qaW) && (this.qbi == null))
    {
      this.qbk = paramInt1;
      this.qbl = paramInt2;
      this.qbm = paramInt3;
      this.qbi = paramArrayOfByte;
      this.qbp = paramBoolean;
      requestRender();
    }
  }
  
  public final void kf(boolean paramBoolean)
  {
    y.i(TAG, "drawTransparent: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.qbr = paramBoolean;
    requestRender();
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    if ((!this.qaX) || (!this.qaW) || (this.qbd.get() == null))
    {
      this.qbi = null;
      this.qbj = null;
      return;
    }
    int i;
    if (this.qbi != null)
    {
      if ((this.qbm & FLAG_Mirror) == 0) {
        break label745;
      }
      i = 1;
      label55:
      if ((this.qbo == null) || (((!this.qbp) || (this.qbq == 0)) && (!this.qbs))) {
        break label780;
      }
      y.d(TAG, "steve:doing voip beauty!beautyParam:%d", new Object[] { Integer.valueOf(this.qbq) });
      paramGL10 = this.qbo;
      int j = this.qbq;
      if (!paramGL10.dNv)
      {
        paramGL10.jrQ = b.aW("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
        if (paramGL10.jrQ == 0) {
          y.e("MicroMsg.FilterRenderer", "checkInit, load program failed!");
        }
        paramGL10.jrS = GLES20.glGetAttribLocation(paramGL10.jrQ, "a_position");
        paramGL10.jrR = GLES20.glGetAttribLocation(paramGL10.jrQ, "a_texCoord");
        paramGL10.fwh = GLES20.glGetUniformLocation(paramGL10.jrQ, "y_texture");
        paramGL10.fwi = GLES20.glGetUniformLocation(paramGL10.jrQ, "uv_texture");
        paramGL10.jrT = GLES20.glGetUniformLocation(paramGL10.jrQ, "uMatrix");
        paramGL10.fwc = b.YW();
        paramGL10.fwd = b.YW();
        paramGL10.qce = b.aW("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D texture;                       \nvoid main (void) {                                 \n   gl_FragColor = vec4(texture2D(texture, v_texCoord).rgb, 1.0); \n}");
        paramGL10.jrX = GLES20.glGetAttribLocation(paramGL10.qce, "a_position");
        paramGL10.jrW = GLES20.glGetAttribLocation(paramGL10.qce, "a_texCoord");
        paramGL10.jrY = GLES20.glGetUniformLocation(paramGL10.qce, "texture");
        paramGL10.jrZ = GLES20.glGetUniformLocation(paramGL10.qce, "uMatrix");
        paramGL10.jrV = b.YW();
        paramGL10.jsn = b.YW();
        paramGL10.fwo = Arrays.copyOf(b.fvS, b.fvS.length);
        paramGL10.fwk = ByteBuffer.allocateDirect(paramGL10.fwo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        paramGL10.fwk.put(paramGL10.fwo);
        paramGL10.fwk.position(0);
        paramGL10.fwl = ByteBuffer.allocateDirect(b.fvU.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        paramGL10.fwl.put(b.fvU);
        paramGL10.fwl.position(0);
        paramGL10.jsk = Arrays.copyOf(b.qcd, b.qcd.length);
        paramGL10.jse = ByteBuffer.allocateDirect(paramGL10.jsk.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        paramGL10.jse.put(paramGL10.jsk);
        paramGL10.jse.position(0);
        paramGL10.jsj = Arrays.copyOf(b.fvS, b.fvS.length);
        paramGL10.jsf = ByteBuffer.allocateDirect(paramGL10.jsj.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        paramGL10.jsf.put(paramGL10.jsj);
        paramGL10.jsf.position(0);
        paramGL10.jsl = b.aKY();
        paramGL10.pWI = null;
        paramGL10.jsm = b.aKY();
        paramGL10.jsp = b.YW();
        if (j != 0)
        {
          paramGL10.qch = new a();
          paramGL10.qch.er(paramGL10.jsn, paramGL10.jsp);
        }
        y.i("MicroMsg.FilterRenderer", "%s checkInit, finish init", new Object[] { Integer.valueOf(paramGL10.hashCode()) });
        paramGL10.dNv = true;
      }
      this.qbo.cJ(this.qbb, this.qbc);
      if (i != 0) {
        break label750;
      }
      this.qbo.c(this.qbi, this.qbk, this.qbl, this.qbm, 0);
    }
    for (;;)
    {
      this.qbi = null;
      if (this.qbj != null)
      {
        if (this.qbo != null) {
          this.qbo.reset();
        }
        render32(this.qbj, this.qbk, this.qbl, this.qbm, this.mRenderMode);
        this.qbj = null;
      }
      if ((!this.qbr) || (getGLVersion() != 2)) {
        break;
      }
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      GLES20.glClear(16640);
      return;
      label745:
      i = 0;
      break label55;
      label750:
      this.qbo.c(this.qbi, this.qbk, this.qbl, this.qbm, this.qbq);
      continue;
      label780:
      render8(this.qbi, this.qbk, this.qbl, this.qbm, this.mRenderMode);
    }
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    y.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(this.qbp), Integer.valueOf(this.qbb), Integer.valueOf(this.qbc), Integer.valueOf(this.mRenderMode) });
    if ((this.qbb != paramInt1) || (this.qbc != paramInt2))
    {
      paramGL10.glViewport(0, 0, paramInt1, paramInt2);
      this.qbb = paramInt1;
      this.qbc = paramInt2;
      if (Build.VERSION.SDK_INT >= 23) {
        setMode(this.qbb, this.qbc, 1, this.mRenderMode);
      }
    }
    if (this.qbo != null) {
      this.qbo.cJ(paramInt1, paramInt2);
    }
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (getGLVersion() == 2)
    {
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glDisable(2929);
    }
  }
  
  public final void requestRender()
  {
    if (!this.qaW) {}
    do
    {
      return;
      if (!this.qba)
      {
        setMode(((OpenGlView)this.qbd.get()).getWidth(), ((OpenGlView)this.qbd.get()).getHeight(), 0, this.mRenderMode);
        this.qba = true;
      }
    } while (this.qbd.get() == null);
    OpenGlView localOpenGlView = (OpenGlView)this.qbd.get();
    localOpenGlView.qbw = true;
    localOpenGlView.requestRender();
  }
  
  final native void setMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  final native void setParam(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  public final void setVoipBeauty(int paramInt)
  {
    y.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", new Object[] { Boolean.valueOf(this.qbp), Integer.valueOf(paramInt), Integer.valueOf(this.qbq) });
    this.qbq = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.OpenGlRender
 * JD-Core Version:    0.7.0.1
 */