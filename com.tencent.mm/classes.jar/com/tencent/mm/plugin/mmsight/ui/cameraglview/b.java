package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b
  implements GLSurfaceView.Renderer
{
  static float[] gWC = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final float[] gWD = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  static float[] jbh = { -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 0.5F, 1.0F, 0.5F };
  private int duc;
  private byte[] frameData;
  private int gWo;
  ByteBuffer gWs;
  private int gWy;
  ByteBuffer gWz;
  private FloatBuffer grD;
  private FloatBuffer grE;
  private int gse;
  private int gsf;
  private int gsg;
  private boolean hbQ;
  boolean jbi;
  private int jbj;
  private int jbk;
  private int jbl;
  private int jbm;
  private int jbn;
  private float[] jbo;
  boolean jbp;
  private float[] jbq;
  private int surfaceHeight;
  private int surfaceWidth;
  
  public b()
  {
    AppMethodBeat.i(94767);
    this.surfaceWidth = 0;
    this.surfaceHeight = 0;
    this.jbi = false;
    this.frameData = null;
    this.jbj = 0;
    this.jbk = 0;
    this.duc = 0;
    this.jbo = new float[16];
    this.jbp = false;
    this.jbq = gWC;
    this.hbQ = false;
    Point localPoint = d.ddi();
    float f = localPoint.x / localPoint.y / 2.0F;
    jbh = new float[] { -1.0F, -f, 1.0F, -f, -1.0F, f, 1.0F, f };
    AppMethodBeat.o(94767);
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(94768);
    for (;;)
    {
      try
      {
        if ((this.jbk != paramInt2) || (this.jbj != paramInt1) || (this.duc != paramInt3)) {
          break label329;
        }
        if (this.hbQ == paramBoolean) {
          break label323;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        ac.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[] { paramArrayOfByte.getMessage() });
        AppMethodBeat.o(94768);
        return;
      }
      if (i != 0) {
        ac.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean), Boolean.TRUE, this });
      }
      this.frameData = paramArrayOfByte;
      this.jbj = paramInt1;
      this.jbk = paramInt2;
      this.duc = paramInt3;
      this.hbQ = paramBoolean;
      if (i != 0)
      {
        this.gWs = ByteBuffer.allocateDirect(paramInt2 * paramInt1);
        this.gWz = ByteBuffer.allocateDirect(paramInt1 * paramInt2 / 2);
        this.gWs.order(ByteOrder.nativeOrder());
        this.gWz.order(ByteOrder.nativeOrder());
        if (paramBoolean) {
          continue;
        }
        this.jbq = gWC;
        if (this.jbq != null)
        {
          this.grE.put(this.jbq);
          this.grE.position(0);
        }
      }
      if ((this.gWs != null) && (this.gWz != null))
      {
        this.gWs.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
        this.gWs.position(0);
        this.gWz.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
        this.gWz.position(0);
      }
      AppMethodBeat.o(94768);
      return;
      this.jbq = jbh;
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
    bs.Gn();
    this.jbi = true;
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16640);
    if (this.jbp)
    {
      ac.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
      this.jbp = false;
      this.jbi = false;
      this.frameData = null;
      this.jbj = -1;
      this.jbk = -1;
      AppMethodBeat.o(94771);
      return;
    }
    if ((this.gse != 0) && (this.jbl != -1) && (this.jbm != -1) && (this.jbj > 0) && (this.jbk > 0) && (this.frameData != null))
    {
      GLES20.glUseProgram(this.gse);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.jbl);
      GLES20.glTexImage2D(3553, 0, 6409, this.jbj, this.jbk, 0, 6409, 5121, this.gWs);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gWo, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jbm);
      GLES20.glTexImage2D(3553, 0, 6410, this.jbj / 2, this.jbk / 2, 0, 6410, 5121, this.gWz);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(this.gWy, 1);
      Matrix.setIdentityM(this.jbo, 0);
      Matrix.setRotateM(this.jbo, 0, this.duc, 0.0F, 0.0F, -1.0F);
      GLES20.glUniformMatrix4fv(this.jbn, 1, false, this.jbo, 0);
      this.grE.position(0);
      GLES20.glVertexAttribPointer(this.gsf, 2, 5126, false, 0, this.grE);
      GLES20.glEnableVertexAttribArray(this.gsf);
      this.grD.position(0);
      GLES20.glVertexAttribPointer(this.gsg, 2, 5126, false, 0, this.grD);
      GLES20.glEnableVertexAttribArray(this.gsg);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(this.gsf);
      GLES20.glDisableVertexAttribArray(this.gsg);
      GLES20.glBindTexture(3553, 0);
    }
    this.jbi = false;
    AppMethodBeat.o(94771);
  }
  
  public final void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94770);
    ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this });
    if ((paramInt1 != this.surfaceWidth) || (paramInt2 != this.surfaceHeight))
    {
      ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
      GLES20.glViewport(0, 0, paramInt1, paramInt2);
      this.surfaceWidth = paramInt1;
      this.surfaceHeight = paramInt2;
    }
    AppMethodBeat.o(94770);
  }
  
  public final void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    AppMethodBeat.i(94769);
    ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[] { this });
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glDisable(2929);
    this.gse = com.tencent.mm.plugin.api.recordView.b.ax("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n");
    if (this.gse == 0) {
      ac.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
    }
    this.gsf = GLES20.glGetAttribLocation(this.gse, "a_position");
    this.gsg = GLES20.glGetAttribLocation(this.gse, "a_texCoord");
    this.gWo = GLES20.glGetUniformLocation(this.gse, "y_texture");
    this.gWy = GLES20.glGetUniformLocation(this.gse, "uv_texture");
    this.jbn = GLES20.glGetUniformLocation(this.gse, "uMatrix");
    this.jbl = com.tencent.mm.plugin.api.recordView.b.aru();
    this.jbm = com.tencent.mm.plugin.api.recordView.b.aru();
    this.grE = ByteBuffer.allocateDirect(this.jbq.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.grE.put(this.jbq);
    this.grE.position(0);
    this.grD = ByteBuffer.allocateDirect(gWD.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.grD.put(gWD);
    this.grD.position(0);
    ac.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[] { Integer.valueOf(this.jbl), Integer.valueOf(this.jbm), this });
    AppMethodBeat.o(94769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.cameraglview.b
 * JD-Core Version:    0.7.0.1
 */