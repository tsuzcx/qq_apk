package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b
  implements GLSurfaceView.Renderer
{
  static float[] hoI = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] hoJ = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] juq = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private int dGc;
  private byte[] frameData;
  private int gLM;
  private int gLN;
  private int gLO;
  private FloatBuffer gLl;
  private FloatBuffer gLm;
  private int hoE;
  ByteBuffer hoF;
  private int hou;
  ByteBuffer hoy;
  private boolean htY;
  boolean jur;
  private int jus;
  private int jut;
  private int juu;
  private int juv;
  private int juw;
  private float[] jux;
  boolean juy;
  private float[] juz;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(94767);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jur = false;
    this.frameData = null;
    this.jus = 0;
    this.jut = 0;
    this.dGc = 0;
    this.jux = new float[16];
    this.juy = false;
    this.juz = hoI;
    this.htY = false;
    Point localPoint = d.dmE();
    float f = localPoint.x / localPoint.y / 2.0F;
    juq = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    AppMethodBeat.o(94767);
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(94768);
    for (;;)
    {
      try
      {
        if ((this.jut != paramInt2) || (this.jus != paramInt1) || (this.dGc != paramInt3)) {
          break label329;
        }
        if (this.htY == paramBoolean) {
          break label323;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ad.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { paramArrayOfByte.getMessage() });
        AppMethodBeat.o(94768);
        return;
      }
      if (i != 0) {
        ad.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean), Boolean.TRUE, this });
      }
      this.frameData = paramArrayOfByte;
      this.jus = paramInt1;
      this.jut = paramInt2;
      this.dGc = paramInt3;
      this.htY = paramBoolean;
      if (i != 0)
      {
        this.hoy = ByteBuffer.allocateDirect(paramInt2 * paramInt1);
        this.hoF = ByteBuffer.allocateDirect(paramInt1 * paramInt2 / 2);
        this.hoy.order(ByteOrder.nativeOrder());
        this.hoF.order(ByteOrder.nativeOrder());
        if (paramBoolean) {
          continue;
        }
        this.juz = hoI;
        if (this.juz != null)
        {
          this.gLm.put(this.juz);
          this.gLm.position(0);
        }
      }
      if ((this.hoy != null) && (this.hoF != null))
      {
        this.hoy.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
        this.hoy.position(0);
        this.hoF.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
        this.hoF.position(0);
      }
      AppMethodBeat.o(94768);
      return;
      this.juz = juq;
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
    bt.HI();
    this.jur = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.juy)
    {
      ad.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.juy = false;
      this.jur = false;
      this.frameData = null;
      this.jus = -1;
      this.jut = -1;
      AppMethodBeat.o(94771);
      return;
    }
    if ((this.gLM != 0) && (this.juu != -1) && (this.juv != -1) && (this.jus > 0) && (this.jut > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.gLM);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.juu);
      GLES20.glTexImage2D(3553, 0, 6409, this.jus, this.jut, 0, 6409, 5121, this.hoy);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hou, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.juv);
      GLES20.glTexImage2D(3553, 0, 6410, this.jus / 2, this.jut / 2, 0, 6410, 5121, this.hoF);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.hoE, 1);
      Matrix.setIdentityM(this.jux, 0);
      Matrix.setRotateM(this.jux, 0, this.dGc, 0.0F, 0.0F, -1.0F);
      GLES20.glUniformMatrix4fv(this.juw, 1, false, this.jux, 0);
      this.gLm.position(0);
      GLES20.glVertexAttribPointer(this.gLN, 2, 5126, false, 0, this.gLm);
      GLES20.glEnableVertexAttribArray(this.gLN);
      this.gLl.position(0);
      GLES20.glVertexAttribPointer(this.gLO, 2, 5126, false, 0, this.gLl);
      GLES20.glEnableVertexAttribArray(this.gLO);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gLN);
      GLES20.glDisableVertexAttribArray(this.gLO);
      GLES20.glBindTexture(3553, 0);
    }
    this.jur = false;
    AppMethodBeat.o(94771);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94770);
    ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
    AppMethodBeat.o(94770);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(94769);
    ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gLM = com.tencent.mm.plugin.api.recordView.b.ay("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gLM == 0) {
      ad.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gLN = GLES20.glGetAttribLocation(this.gLM, "a_position");
    this.gLO = GLES20.glGetAttribLocation(this.gLM, "a_texCoord");
    this.hou = GLES20.glGetUniformLocation(this.gLM, "y_texture");
    this.hoE = GLES20.glGetUniformLocation(this.gLM, "uv_texture");
    this.juw = GLES20.glGetUniformLocation(this.gLM, "uMatrix");
    this.juu = com.tencent.mm.plugin.api.recordView.b.auh();
    this.juv = com.tencent.mm.plugin.api.recordView.b.auh();
    this.gLm = ByteBuffer.allocateDirect(this.juz.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gLm.put(this.juz);
    this.gLm.position(0);
    this.gLl = ByteBuffer.allocateDirect(hoJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.gLl.put(hoJ);
    this.gLl.position(0);
    ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.juu), Integer.valueOf(this.juv), this });
    AppMethodBeat.o(94769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.b
 * JD-Core Version:    0.7.0.1
 */