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
  static float[] gwe = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] gwf = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] iBg = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private int dwp;
  private byte[] frameData;
  private boolean gBu;
  private FloatBuffer guS;
  private FloatBuffer guT;
  private int gvL;
  private int gvM;
  private int gvN;
  private int gvW;
  private int gvX;
  ByteBuffer gvZ;
  ByteBuffer gwa;
  boolean iBh;
  private int iBi;
  private int iBj;
  private int iBk;
  private int iBl;
  private int iBm;
  private float[] iBn;
  boolean iBo;
  private float[] iBp;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(94767);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.iBh = false;
    this.frameData = null;
    this.iBi = 0;
    this.iBj = 0;
    this.dwp = 0;
    this.iBn = new float[16];
    this.iBo = false;
    this.iBp = gwe;
    this.gBu = false;
    Point localPoint = d.cPz();
    float f = localPoint.x / localPoint.y / 2.0F;
    iBg = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    AppMethodBeat.o(94767);
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(94768);
    for (;;)
    {
      try
      {
        if ((this.iBj != paramInt2) || (this.iBi != paramInt1) || (this.dwp != paramInt3)) {
          break label329;
        }
        if (this.gBu == paramBoolean) {
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
      this.iBi = paramInt1;
      this.iBj = paramInt2;
      this.dwp = paramInt3;
      this.gBu = paramBoolean;
      if (i != 0)
      {
        this.gvZ = ByteBuffer.allocateDirect(paramInt2 * paramInt1);
        this.gwa = ByteBuffer.allocateDirect(paramInt1 * paramInt2 / 2);
        this.gvZ.order(ByteOrder.nativeOrder());
        this.gwa.order(ByteOrder.nativeOrder());
        if (paramBoolean) {
          continue;
        }
        this.iBp = gwe;
        if (this.iBp != null)
        {
          this.guT.put(this.iBp);
          this.guT.position(0);
        }
      }
      if ((this.gvZ != null) && (this.gwa != null))
      {
        this.gvZ.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
        this.gvZ.position(0);
        this.gwa.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
        this.gwa.position(0);
      }
      AppMethodBeat.o(94768);
      return;
      this.iBp = iBg;
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
    bt.GC();
    this.iBh = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.iBo)
    {
      ad.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.iBo = false;
      this.iBh = false;
      this.frameData = null;
      this.iBi = -1;
      this.iBj = -1;
      AppMethodBeat.o(94771);
      return;
    }
    if ((this.gvL != 0) && (this.iBk != -1) && (this.iBl != -1) && (this.iBi > 0) && (this.iBj > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.gvL);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.iBk);
      GLES20.glTexImage2D(3553, 0, 6409, this.iBi, this.iBj, 0, 6409, 5121, this.gvZ);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gvW, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.iBl);
      GLES20.glTexImage2D(3553, 0, 6410, this.iBi / 2, this.iBj / 2, 0, 6410, 5121, this.gwa);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gvX, 1);
      Matrix.setIdentityM(this.iBn, 0);
      Matrix.setRotateM(this.iBn, 0, this.dwp, 0.0F, 0.0F, -1.0F);
      GLES20.glUniformMatrix4fv(this.iBm, 1, false, this.iBn, 0);
      this.guT.position(0);
      GLES20.glVertexAttribPointer(this.gvM, 2, 5126, false, 0, this.guT);
      GLES20.glEnableVertexAttribArray(this.gvM);
      this.guS.position(0);
      GLES20.glVertexAttribPointer(this.gvN, 2, 5126, false, 0, this.guS);
      GLES20.glEnableVertexAttribArray(this.gvN);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gvM);
      GLES20.glDisableVertexAttribArray(this.gvN);
      GLES20.glBindTexture(3553, 0);
    }
    this.iBh = false;
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
    this.gvL = com.tencent.mm.plugin.api.recordView.b.ap("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gvL == 0) {
      ad.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gvM = GLES20.glGetAttribLocation(this.gvL, "a_position");
    this.gvN = GLES20.glGetAttribLocation(this.gvL, "a_texCoord");
    this.gvW = GLES20.glGetUniformLocation(this.gvL, "y_texture");
    this.gvX = GLES20.glGetUniformLocation(this.gvL, "uv_texture");
    this.iBm = GLES20.glGetUniformLocation(this.gvL, "uMatrix");
    this.iBk = com.tencent.mm.plugin.api.recordView.b.akA();
    this.iBl = com.tencent.mm.plugin.api.recordView.b.akA();
    this.guT = ByteBuffer.allocateDirect(this.iBp.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.guT.put(this.iBp);
    this.guT.position(0);
    this.guS = ByteBuffer.allocateDirect(gwf.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.guS.put(gwf);
    this.guS.position(0);
    ad.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.iBk), Integer.valueOf(this.iBl), this });
    AppMethodBeat.o(94769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.b
 * JD-Core Version:    0.7.0.1
 */