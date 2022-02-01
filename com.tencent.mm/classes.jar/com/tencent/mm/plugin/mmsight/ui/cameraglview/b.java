package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b
  implements GLSurfaceView.Renderer
{
  static float[] hrw = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] hrx = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] jxl = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private int dHi;
  private byte[] frameData;
  private FloatBuffer gNU;
  private FloatBuffer gNV;
  private int gOv;
  private int gOw;
  private int gOx;
  private int hri;
  ByteBuffer hrm;
  private int hrs;
  ByteBuffer hrt;
  private boolean hwM;
  boolean jxm;
  private int jxn;
  private int jxo;
  private int jxp;
  private int jxq;
  private int jxr;
  private float[] jxs;
  boolean jxt;
  private float[] jxu;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(94767);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jxm = false;
    this.frameData = null;
    this.jxn = 0;
    this.jxo = 0;
    this.dHi = 0;
    this.jxs = new float[16];
    this.jxt = false;
    this.jxu = hrw;
    this.hwM = false;
    Point localPoint = d.dpC();
    float f = localPoint.x / localPoint.y / 2.0F;
    jxl = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    AppMethodBeat.o(94767);
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(94768);
    for (;;)
    {
      try
      {
        if ((this.jxo != paramInt2) || (this.jxn != paramInt1) || (this.dHi != paramInt3)) {
          break label329;
        }
        if (this.hwM == paramBoolean) {
          break label323;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ae.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { paramArrayOfByte.getMessage() });
        AppMethodBeat.o(94768);
        return;
      }
      if (i != 0) {
        ae.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean), Boolean.TRUE, this });
      }
      this.frameData = paramArrayOfByte;
      this.jxn = paramInt1;
      this.jxo = paramInt2;
      this.dHi = paramInt3;
      this.hwM = paramBoolean;
      if (i != 0)
      {
        this.hrm = ByteBuffer.allocateDirect(paramInt2 * paramInt1);
        this.hrt = ByteBuffer.allocateDirect(paramInt1 * paramInt2 / 2);
        this.hrm.order(ByteOrder.nativeOrder());
        this.hrt.order(ByteOrder.nativeOrder());
        if (paramBoolean) {
          continue;
        }
        this.jxu = hrw;
        if (this.jxu != null)
        {
          this.gNV.put(this.jxu);
          this.gNV.position(0);
        }
      }
      if ((this.hrm != null) && (this.hrt != null))
      {
        this.hrm.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
        this.hrm.position(0);
        this.hrt.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
        this.hrt.position(0);
      }
      AppMethodBeat.o(94768);
      return;
      this.jxu = jxl;
      continue;
      label323:
      int i = 0;
      continue;
      label329:
      i = 1;
    }
  }
  
  public final void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(94771);
    bu.HQ();
    this.jxm = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.jxt)
    {
      ae.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.jxt = false;
      this.jxm = false;
      this.frameData = null;
      this.jxn = -1;
      this.jxo = -1;
      AppMethodBeat.o(94771);
      return;
    }
    if ((this.gOv != 0) && (this.jxp != -1) && (this.jxq != -1) && (this.jxn > 0) && (this.jxo > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.gOv);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.jxp);
      GLES20.glTexImage2D(3553, 0, 6409, this.jxn, this.jxo, 0, 6409, 5121, this.hrm);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hri, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jxq);
      GLES20.glTexImage2D(3553, 0, 6410, this.jxn / 2, this.jxo / 2, 0, 6410, 5121, this.hrt);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hrs, 1);
      Matrix.setIdentityM(this.jxs, 0);
      Matrix.setRotateM(this.jxs, 0, this.dHi, 0.0F, 0.0F, -1.0F);
      GLES20.glUniformMatrix4fv(this.jxr, 1, false, this.jxs, 0);
      this.gNV.position(0);
      GLES20.glVertexAttribPointer(this.gOw, 2, 5126, false, 0, this.gNV);
      GLES20.glEnableVertexAttribArray(this.gOw);
      this.gNU.position(0);
      GLES20.glVertexAttribPointer(this.gOx, 2, 5126, false, 0, this.gNU);
      GLES20.glEnableVertexAttribArray(this.gOx);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gOw);
      GLES20.glDisableVertexAttribArray(this.gOx);
      GLES20.glBindTexture(3553, 0);
    }
    this.jxm = false;
    AppMethodBeat.o(94771);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94770);
    ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
    AppMethodBeat.o(94770);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(94769);
    ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gOv = com.tencent.mm.plugin.api.recordView.b.az("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gOv == 0) {
      ae.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gOw = GLES20.glGetAttribLocation(this.gOv, "a_position");
    this.gOx = GLES20.glGetAttribLocation(this.gOv, "a_texCoord");
    this.hri = GLES20.glGetUniformLocation(this.gOv, "y_texture");
    this.hrs = GLES20.glGetUniformLocation(this.gOv, "uv_texture");
    this.jxr = GLES20.glGetUniformLocation(this.gOv, "uMatrix");
    this.jxp = com.tencent.mm.plugin.api.recordView.b.auw();
    this.jxq = com.tencent.mm.plugin.api.recordView.b.auw();
    this.gNV = ByteBuffer.allocateDirect(this.jxu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gNV.put(this.jxu);
    this.gNV.position(0);
    this.gNU = ByteBuffer.allocateDirect(hrx.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gNU.put(hrx);
    this.gNU.position(0);
    ae.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.jxp), Integer.valueOf(this.jxq), this });
    AppMethodBeat.o(94769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.b
 * JD-Core Version:    0.7.0.1
 */