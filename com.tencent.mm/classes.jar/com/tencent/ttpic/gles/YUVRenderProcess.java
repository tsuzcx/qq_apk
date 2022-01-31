package com.tencent.ttpic.gles;

import android.opengl.GLES20;
import com.tencent.filter.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class YUVRenderProcess
{
  private static final int COORDS_PER_VERTEX = 3;
  private static int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "precision mediump float;varying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0, \t\t-.34414, 1.772,\n1.402, \t-.71414, 0) * yuv;\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n";
  private static int SHORT_SIZE_BYTES = 2;
  private static final int TEXTURE_COORS_PER_VERTEX = 2;
  private static final String VERTEX_SHADER = "precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n";
  private static short[] drawIndices = { 0, 1, 2, 0, 2, 3 };
  private static float[] squareVertices = { -1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F };
  private static float[] textureVertices = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  private ShortBuffer mDrawIndicesBuffer;
  private h mEffectFrame = new h();
  private int mHeight = 720;
  private int mProgram = -1;
  private FloatBuffer mSquareVerticesBuffer;
  private FloatBuffer mTextureVerticesBuffer;
  private int mWidth = 1280;
  private int sampleULoaction;
  private int sampleVLoaction;
  private int sampleYLoaction;
  private int sh;
  private int sw;
  private byte[] u;
  private ByteBuffer uBuf;
  private int uSize = this.uvSize >> 1;
  private int[] uTexture = new int[1];
  private int uvSize = this.ySize >> 1;
  private byte[] v;
  private ByteBuffer vBuf;
  private int[] vTexture = new int[1];
  private byte[] y;
  private ByteBuffer yBuf;
  private int ySize = this.mWidth * this.mHeight;
  private int[] yTexture = new int[1];
  
  private void drawFrame()
  {
    GLES20.glViewport(0, 0, this.sw, this.sh);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    GLES20.glUseProgram(this.mProgram);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.yTexture[0]);
    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mWidth, this.mHeight, 6409, 5121, this.yBuf);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.uTexture[0]);
    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mWidth >> 1, this.mHeight >> 1, 6409, 5121, this.uBuf);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.vTexture[0]);
    GLES20.glTexSubImage2D(3553, 0, 0, 0, this.mWidth >> 1, this.mHeight >> 1, 6409, 5121, this.vBuf);
    GLES20.glUniform1i(this.sampleYLoaction, 0);
    GLES20.glUniform1i(this.sampleULoaction, 1);
    GLES20.glUniform1i(this.sampleVLoaction, 2);
    GLES20.glDrawElements(4, drawIndices.length, 5123, this.mDrawIndicesBuffer);
    GLES20.glFinish();
  }
  
  private void initDataBuffer()
  {
    this.ySize = (this.mWidth * this.mHeight);
    this.uvSize = (this.ySize >> 1);
    this.uSize = (this.uvSize >> 1);
    this.y = new byte[this.ySize];
    this.u = new byte[this.uSize];
    this.v = new byte[this.uSize];
    this.yBuf = ByteBuffer.allocateDirect(this.ySize);
    this.uBuf = ByteBuffer.allocateDirect(this.ySize >> 2);
    this.vBuf = ByteBuffer.allocateDirect(this.ySize >> 2);
  }
  
  private void initTexture()
  {
    GLES20.glEnable(3553);
    GLES20.glActiveTexture(33984);
    GLES20.glActiveTexture(33985);
    GLES20.glActiveTexture(33986);
    ProgramTools.createTexture(this.mWidth, this.mHeight, 6409, this.yTexture);
    ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.uTexture);
    ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.vTexture);
    GLES20.glUseProgram(this.mProgram);
    this.sampleYLoaction = GLES20.glGetUniformLocation(this.mProgram, "SamplerY");
    this.sampleULoaction = GLES20.glGetUniformLocation(this.mProgram, "SamplerU");
    this.sampleVLoaction = GLES20.glGetUniformLocation(this.mProgram, "SamplerV");
    GLES20.glUniform1i(this.sampleYLoaction, 0);
    GLES20.glUniform1i(this.sampleULoaction, 1);
    GLES20.glUniform1i(this.sampleVLoaction, 2);
    int i = GLES20.glGetAttribLocation(this.mProgram, "position");
    int j = GLES20.glGetAttribLocation(this.mProgram, "textureCoordinateIn");
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, 3, 5126, false, 12, this.mSquareVerticesBuffer);
    GLES20.glEnableVertexAttribArray(j);
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, this.mTextureVerticesBuffer);
  }
  
  private void initVertex()
  {
    this.mSquareVerticesBuffer = ByteBuffer.allocateDirect(FLOAT_SIZE_BYTES * squareVertices.length).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mSquareVerticesBuffer.put(squareVertices);
    this.mSquareVerticesBuffer.position(0);
    this.mTextureVerticesBuffer = ByteBuffer.allocateDirect(FLOAT_SIZE_BYTES * textureVertices.length).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.mTextureVerticesBuffer.put(textureVertices);
    this.mTextureVerticesBuffer.position(0);
    this.mDrawIndicesBuffer = ByteBuffer.allocateDirect(SHORT_SIZE_BYTES * drawIndices.length).order(ByteOrder.nativeOrder()).asShortBuffer();
    this.mDrawIndicesBuffer.put(drawIndices);
    this.mDrawIndicesBuffer.position(0);
  }
  
  private void rebuildTextures()
  {
    GLES20.glDeleteTextures(this.yTexture.length, this.yTexture, 0);
    GLES20.glDeleteTextures(this.uTexture.length, this.uTexture, 0);
    GLES20.glDeleteTextures(this.vTexture.length, this.vTexture, 0);
    ProgramTools.createTexture(this.mWidth, this.mHeight, 6409, this.yTexture);
    ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.uTexture);
    ProgramTools.createTexture(this.mWidth >> 1, this.mHeight >> 1, 6409, this.vTexture);
  }
  
  public void changeViewPort(int paramInt1, int paramInt2)
  {
    this.sw = Math.max(paramInt1, paramInt2);
    this.sh = Math.min(paramInt1, paramInt2);
  }
  
  public byte[] getY()
  {
    return this.y;
  }
  
  public void init()
  {
    this.mProgram = ProgramTools.createProgram("precision highp float;\nattribute vec4 position;\nattribute vec2 textureCoordinateIn;\nvarying   vec2 texturecoordinateOut;\nvoid main()\n{\ntexturecoordinateOut = textureCoordinateIn;\ngl_Position = position;\n}\n", "precision mediump float;varying   vec2 texturecoordinateOut;\nuniform sampler2D SamplerY;\nuniform sampler2D SamplerU;\nuniform sampler2D SamplerV;\nvoid main()\n{\nvec3 yuv;\nvec3 rgb;\nvec4 rgba;\nyuv.x = texture2D(SamplerY, texturecoordinateOut).r;\nyuv.y = texture2D(SamplerU, texturecoordinateOut).r-0.5;\nyuv.z = texture2D(SamplerV, texturecoordinateOut).r-0.5;\nrgb = mat3(      1,       1,      1,\n0, \t\t-.34414, 1.772,\n1.402, \t-.71414, 0) * yuv;\nrgba = vec4(rgb, 1);\ngl_FragColor = rgba;\n}\n");
    initVertex();
    initTexture();
    initDataBuffer();
  }
  
  public h queueYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.mWidth != paramInt1) || (this.mHeight != paramInt2))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      initDataBuffer();
      rebuildTextures();
    }
    System.arraycopy(paramArrayOfByte, 0, this.y, 0, this.ySize);
    System.arraycopy(paramArrayOfByte, this.ySize, this.v, 0, this.uSize);
    System.arraycopy(paramArrayOfByte, this.ySize + this.uSize, this.u, 0, this.uSize);
    this.yBuf.position(0);
    this.yBuf.put(this.y).position(0);
    this.uBuf.position(0);
    this.uBuf.put(this.u).position(0);
    this.vBuf.position(0);
    this.vBuf.put(this.v).position(0);
    this.mEffectFrame.a(-1, this.sw, this.sh, 0.0D);
    drawFrame();
    return this.mEffectFrame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.gles.YUVRenderProcess
 * JD-Core Version:    0.7.0.1
 */