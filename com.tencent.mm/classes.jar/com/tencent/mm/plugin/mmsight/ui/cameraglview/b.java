package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b
  implements GLSurfaceView.Renderer
{
  static float[] fvS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  static float[] fvT = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private static final float[] fvU = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  boolean brU = false;
  private int fvV = 0;
  private int fvW = 0;
  private byte[] fvX = null;
  private int fvY = 0;
  private int fvZ = 0;
  ByteBuffer fwa;
  ByteBuffer fwb;
  private int fwc;
  private int fwd;
  private int fwe;
  private int fwf;
  private int fwg;
  private int fwh;
  private int fwi;
  private int fwj;
  private FloatBuffer fwk;
  private FloatBuffer fwl;
  private float[] fwm = new float[16];
  boolean fwn = false;
  private float[] fwo = fvS;
  private boolean fwq = false;
  private int rotate = 0;
  
  public b()
  {
    Point localPoint = d.biC();
    float f = localPoint.x / localPoint.y / 2.0F;
    fvT = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((this.fvZ != paramInt2) || (this.fvY != paramInt1) || (this.rotate != paramInt3)) {
          break label315;
        }
        if (this.fwq == paramBoolean) {
          break label309;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        y.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { paramArrayOfByte.getMessage() });
        return;
      }
      if (i != 0) {
        y.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean), Boolean.valueOf(true), this });
      }
      this.fvX = paramArrayOfByte;
      this.fvY = paramInt1;
      this.fvZ = paramInt2;
      this.rotate = paramInt3;
      this.fwq = paramBoolean;
      if (i != 0)
      {
        this.fwa = ByteBuffer.allocateDirect(paramInt2 * paramInt1);
        this.fwb = ByteBuffer.allocateDirect(paramInt1 * paramInt2 / 2);
        this.fwa.order(ByteOrder.nativeOrder());
        this.fwb.order(ByteOrder.nativeOrder());
        if (paramBoolean) {
          continue;
        }
        this.fwo = fvS;
        if (this.fwo != null)
        {
          this.fwk.put(this.fwo);
          this.fwk.position(0);
        }
      }
      if ((this.fwa == null) || (this.fwb == null)) {
        break;
      }
      this.fwa.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
      this.fwa.position(0);
      this.fwb.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
      this.fwb.position(0);
      return;
      this.fwo = fvT;
      continue;
      label309:
      int i = 0;
      continue;
      label315:
      i = 1;
    }
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    bk.UZ();
    this.brU = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.fwn)
    {
      y.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.fwn = false;
      this.brU = false;
      this.fvX = null;
      this.fvY = -1;
      this.fvZ = -1;
      return;
    }
    if ((this.fwe != 0) && (this.fwc != -1) && (this.fwd != -1) && (this.fvY > 0) && (this.fvZ > 0) && (this.fvX != null))
    {
      GLES20.glUseProgram(this.fwe);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.fwc);
      GLES20.glTexImage2D(3553, 0, 6409, this.fvY, this.fvZ, 0, 6409, 5121, this.fwa);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.fwh, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.fwd);
      GLES20.glTexImage2D(3553, 0, 6410, this.fvY / 2, this.fvZ / 2, 0, 6410, 5121, this.fwb);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.fwi, 1);
      Matrix.setIdentityM(this.fwm, 0);
      Matrix.setRotateM(this.fwm, 0, this.rotate, 0.0F, 0.0F, -1.0F);
      GLES20.glUniformMatrix4fv(this.fwj, 1, false, this.fwm, 0);
      this.fwk.position(0);
      GLES20.glVertexAttribPointer(this.fwg, 2, 5126, false, 0, this.fwk);
      GLES20.glEnableVertexAttribArray(this.fwg);
      this.fwl.position(0);
      GLES20.glVertexAttribPointer(this.fwf, 2, 5126, false, 0, this.fwl);
      GLES20.glEnableVertexAttribArray(this.fwf);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.fwg);
      GLES20.glDisableVertexAttribArray(this.fwf);
      GLES20.glBindTexture(3553, 0);
    }
    this.brU = false;
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.fvV) || (paramInt2 != this.fvW))
    {
      y.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.fvV = paramInt1;
      this.fvW = paramInt2;
    }
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    y.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.fwe = com.tencent.mm.plugin.api.recordView.b.aW("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.fwe == 0) {
      y.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.fwg = GLES20.glGetAttribLocation(this.fwe, "a_position");
    this.fwf = GLES20.glGetAttribLocation(this.fwe, "a_texCoord");
    this.fwh = GLES20.glGetUniformLocation(this.fwe, "y_texture");
    this.fwi = GLES20.glGetUniformLocation(this.fwe, "uv_texture");
    this.fwj = GLES20.glGetUniformLocation(this.fwe, "uMatrix");
    this.fwc = com.tencent.mm.plugin.api.recordView.b.YW();
    this.fwd = com.tencent.mm.plugin.api.recordView.b.YW();
    this.fwk = ByteBuffer.allocateDirect(this.fwo.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.fwk.put(this.fwo);
    this.fwk.position(0);
    this.fwl = ByteBuffer.allocateDirect(fvU.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.fwl.put(fvU);
    this.fwl.position(0);
    y.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.fwc), Integer.valueOf(this.fwd), this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.b
 * JD-Core Version:    0.7.0.1
 */