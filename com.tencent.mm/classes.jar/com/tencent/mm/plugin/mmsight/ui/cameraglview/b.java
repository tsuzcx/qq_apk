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

public class b
  implements GLSurfaceView.Renderer
{
  static float[] nFt = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] nFu = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] qpB = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private byte[] frameData;
  private int hYK;
  private FloatBuffer mVU;
  private FloatBuffer mVV;
  private int mWv;
  private int mWw;
  private int nEF;
  ByteBuffer nEJ;
  private int nEP;
  ByteBuffer nEQ;
  private boolean nKe;
  private int programId;
  boolean qpC;
  private int qpD;
  private int qpE;
  private int qpF;
  private int qpG;
  private int qpH;
  private float[] qpI;
  boolean qpJ;
  private float[] qpK;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(94767);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.qpC = false;
    this.frameData = null;
    this.qpD = 0;
    this.qpE = 0;
    this.hYK = 0;
    this.qpI = new float[16];
    this.qpJ = false;
    this.qpK = nFt;
    this.nKe = false;
    Point localPoint = d.gbR();
    float f = localPoint.x / localPoint.y / 2.0F;
    qpB = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    AppMethodBeat.o(94767);
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(94768);
    for (;;)
    {
      try
      {
        if ((this.qpE != paramInt2) || (this.qpD != paramInt1) || (this.hYK != paramInt3)) {
          break label329;
        }
        if (this.nKe == paramBoolean) {
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
      this.qpD = paramInt1;
      this.qpE = paramInt2;
      this.hYK = paramInt3;
      this.nKe = paramBoolean;
      if (i != 0)
      {
        this.nEJ = ByteBuffer.allocateDirect(paramInt2 * paramInt1);
        this.nEQ = ByteBuffer.allocateDirect(paramInt1 * paramInt2 / 2);
        this.nEJ.order(ByteOrder.nativeOrder());
        this.nEQ.order(ByteOrder.nativeOrder());
        if (paramBoolean) {
          continue;
        }
        this.qpK = nFt;
        if (this.qpK != null)
        {
          this.mVV.put(this.qpK);
          this.mVV.position(0);
        }
      }
      if ((this.nEJ != null) && (this.nEQ != null))
      {
        this.nEJ.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
        this.nEJ.position(0);
        this.nEQ.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
        this.nEQ.position(0);
      }
      AppMethodBeat.o(94768);
      return;
      this.qpK = qpB;
      continue;
      label323:
      int i = 0;
      continue;
      label329:
      i = 1;
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    AppMethodBeat.i(94771);
    Util.currentTicks();
    this.qpC = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.qpJ)
    {
      Log.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.qpJ = false;
      this.qpC = false;
      this.frameData = null;
      this.qpD = -1;
      this.qpE = -1;
      AppMethodBeat.o(94771);
      return;
    }
    if ((this.programId != 0) && (this.qpF != -1) && (this.qpG != -1) && (this.qpD > 0) && (this.qpE > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.programId);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.qpF);
      GLES20.glTexImage2D(3553, 0, 6409, this.qpD, this.qpE, 0, 6409, 5121, this.nEJ);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.nEF, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.qpG);
      GLES20.glTexImage2D(3553, 0, 6410, this.qpD / 2, this.qpE / 2, 0, 6410, 5121, this.nEQ);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.nEP, 1);
      Matrix.setIdentityM(this.qpI, 0);
      Matrix.setRotateM(this.qpI, 0, this.hYK, 0.0F, 0.0F, -1.0F);
      GLES20.glUniformMatrix4fv(this.qpH, 1, false, this.qpI, 0);
      this.mVV.position(0);
      GLES20.glVertexAttribPointer(this.mWv, 2, 5126, false, 0, this.mVV);
      GLES20.glEnableVertexAttribArray(this.mWv);
      this.mVU.position(0);
      GLES20.glVertexAttribPointer(this.mWw, 2, 5126, false, 0, this.mVU);
      GLES20.glEnableVertexAttribArray(this.mWw);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.mWv);
      GLES20.glDisableVertexAttribArray(this.mWw);
      GLES20.glBindTexture(3553, 0);
    }
    this.qpC = false;
    AppMethodBeat.o(94771);
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
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
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(94769);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.programId = com.tencent.mm.plugin.api.recordView.b.aN("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.programId == 0) {
      Log.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.mWv = GLES20.glGetAttribLocation(this.programId, "a_position");
    this.mWw = GLES20.glGetAttribLocation(this.programId, "a_texCoord");
    this.nEF = GLES20.glGetUniformLocation(this.programId, "y_texture");
    this.nEP = GLES20.glGetUniformLocation(this.programId, "uv_texture");
    this.qpH = GLES20.glGetUniformLocation(this.programId, "uMatrix");
    this.qpF = com.tencent.mm.plugin.api.recordView.b.bql();
    this.qpG = com.tencent.mm.plugin.api.recordView.b.bql();
    this.mVV = ByteBuffer.allocateDirect(this.qpK.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVV.put(this.qpK);
    this.mVV.position(0);
    this.mVU = ByteBuffer.allocateDirect(nFu.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mVU.put(nFu);
    this.mVU.position(0);
    Log.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.qpF), Integer.valueOf(this.qpG), this });
    AppMethodBeat.o(94769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.b
 * JD-Core Version:    0.7.0.1
 */