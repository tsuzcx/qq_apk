package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b
  implements GLSurfaceView.Renderer
{
  static float[] ilm = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] iln = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] kxU = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private int dYT;
  private byte[] frameData;
  private FloatBuffer hDT;
  private FloatBuffer hDU;
  private int hEy;
  private int hEz;
  private int ikE;
  ByteBuffer ikI;
  private int ikO;
  ByteBuffer ikP;
  private boolean iqo;
  boolean kxV;
  private int kxW;
  private int kxX;
  private int kxY;
  private int kxZ;
  private int kya;
  private float[] kyb;
  boolean kyc;
  private float[] kyd;
  private int programId;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(94767);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.kxV = false;
    this.frameData = null;
    this.kxW = 0;
    this.kxX = 0;
    this.dYT = 0;
    this.kyb = new float[16];
    this.kyc = false;
    this.kyd = ilm;
    this.iqo = false;
    Point localPoint = d.ejr();
    float f = localPoint.x / localPoint.y / 2.0F;
    kxU = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    AppMethodBeat.o(94767);
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(94768);
    for (;;)
    {
      try
      {
        if ((this.kxX != paramInt2) || (this.kxW != paramInt1) || (this.dYT != paramInt3)) {
          break label329;
        }
        if (this.iqo == paramBoolean) {
          break label323;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        Log.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { paramArrayOfByte.getMessage() });
        AppMethodBeat.o(94768);
        return;
      }
      if (i != 0) {
        Log.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean), Boolean.TRUE, this });
      }
      this.frameData = paramArrayOfByte;
      this.kxW = paramInt1;
      this.kxX = paramInt2;
      this.dYT = paramInt3;
      this.iqo = paramBoolean;
      if (i != 0)
      {
        this.ikI = ByteBuffer.allocateDirect(paramInt2 * paramInt1);
        this.ikP = ByteBuffer.allocateDirect(paramInt1 * paramInt2 / 2);
        this.ikI.order(ByteOrder.nativeOrder());
        this.ikP.order(ByteOrder.nativeOrder());
        if (paramBoolean) {
          continue;
        }
        this.kyd = ilm;
        if (this.kyd != null)
        {
          this.hDU.put(this.kyd);
          this.hDU.position(0);
        }
      }
      if ((this.ikI != null) && (this.ikP != null))
      {
        this.ikI.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
        this.ikI.position(0);
        this.ikP.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
        this.ikP.position(0);
      }
      AppMethodBeat.o(94768);
      return;
      this.kyd = kxU;
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
    Util.currentTicks();
    this.kxV = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.kyc)
    {
      Log.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.kyc = false;
      this.kxV = false;
      this.frameData = null;
      this.kxW = -1;
      this.kxX = -1;
      AppMethodBeat.o(94771);
      return;
    }
    if ((this.programId != 0) && (this.kxY != -1) && (this.kxZ != -1) && (this.kxW > 0) && (this.kxX > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.kxY);
      GLES20.glTexImage2D(3553, 0, 6409, this.kxW, this.kxX, 0, 6409, 5121, this.ikI);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.ikE, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.kxZ);
      GLES20.glTexImage2D(3553, 0, 6410, this.kxW / 2, this.kxX / 2, 0, 6410, 5121, this.ikP);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.ikO, 1);
      Matrix.setIdentityM(this.kyb, 0);
      Matrix.setRotateM(this.kyb, 0, this.dYT, 0.0F, 0.0F, -1.0F);
      GLES20.glUniformMatrix4fv(this.kya, 1, false, this.kyb, 0);
      this.hDU.position(0);
      GLES20.glVertexAttribPointer(this.hEy, 2, 5126, false, 0, this.hDU);
      GLES20.glEnableVertexAttribArray(this.hEy);
      this.hDT.position(0);
      GLES20.glVertexAttribPointer(this.hEz, 2, 5126, false, 0, this.hDT);
      GLES20.glEnableVertexAttribArray(this.hEz);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.hEy);
      GLES20.glDisableVertexAttribArray(this.hEz);
      GLES20.glBindTexture(3553, 0);
    }
    this.kxV = false;
    AppMethodBeat.o(94771);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94770);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
    AppMethodBeat.o(94770);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(94769);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.programId = com.tencent.mm.plugin.api.recordView.b.aB("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.programId == 0) {
      Log.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.hEy = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.hEz = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.ikE = GLES20.glGetUniformLocation(this.programId, "y_texture");
    this.ikO = GLES20.glGetUniformLocation(this.programId, "uv_texture");
    this.kya = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.kxY = com.tencent.mm.plugin.api.recordView.b.aMZ();
    this.kxZ = com.tencent.mm.plugin.api.recordView.b.aMZ();
    this.hDU = ByteBuffer.allocateDirect(this.kyd.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.hDU.put(this.kyd);
    this.hDU.position(0);
    this.hDT = ByteBuffer.allocateDirect(iln.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.hDT.put(iln);
    this.hDT.position(0);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.kxY), Integer.valueOf(this.kxZ), this });
    AppMethodBeat.o(94769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.b
 * JD-Core Version:    0.7.0.1
 */