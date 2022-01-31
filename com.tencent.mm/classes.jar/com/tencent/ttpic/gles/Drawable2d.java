package com.tencent.ttpic.gles;

import java.nio.FloatBuffer;

public class Drawable2d
{
  private static final FloatBuffer FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_COORDS);
  private static final float[] FULL_RECTANGLE_COORDS;
  private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
  private static final float[] FULL_RECTANGLE_TEX_COORDS;
  private static final FloatBuffer RECTANGLE_BUF;
  private static final float[] RECTANGLE_COORDS;
  private static final FloatBuffer RECTANGLE_TEX_BUF;
  private static final float[] RECTANGLE_TEX_COORDS;
  private static final int SIZEOF_FLOAT = 4;
  private static final FloatBuffer TRIANGLE_BUF;
  private static final float[] TRIANGLE_COORDS = { 0.0F, 0.5773503F, -0.5F, -0.2886751F, 0.5F, -0.2886751F };
  private static final FloatBuffer TRIANGLE_TEX_BUF;
  private static final float[] TRIANGLE_TEX_COORDS = { 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  private int mCoordsPerVertex;
  private Drawable2d.Prefab mPrefab;
  private FloatBuffer mTexCoordArray;
  private int mTexCoordStride;
  private FloatBuffer mVertexArray;
  private int mVertexCount;
  private int mVertexStride;
  
  static
  {
    TRIANGLE_BUF = GlUtil.createFloatBuffer(TRIANGLE_COORDS);
    TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
    RECTANGLE_COORDS = new float[] { -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F };
    RECTANGLE_TEX_COORDS = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    RECTANGLE_BUF = GlUtil.createFloatBuffer(RECTANGLE_COORDS);
    RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
    FULL_RECTANGLE_COORDS = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    FULL_RECTANGLE_TEX_COORDS = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public Drawable2d(Drawable2d.Prefab paramPrefab)
  {
    switch (Drawable2d.1.$SwitchMap$com$tencent$ttpic$gles$Drawable2d$Prefab[paramPrefab.ordinal()])
    {
    default: 
      throw new RuntimeException("Unknown shape " + paramPrefab);
    case 1: 
      this.mVertexArray = TRIANGLE_BUF;
      this.mTexCoordArray = TRIANGLE_TEX_BUF;
      this.mCoordsPerVertex = 2;
      this.mVertexStride = (this.mCoordsPerVertex * 4);
      this.mVertexCount = (TRIANGLE_COORDS.length / this.mCoordsPerVertex);
    }
    for (;;)
    {
      this.mTexCoordStride = 8;
      this.mPrefab = paramPrefab;
      return;
      this.mVertexArray = RECTANGLE_BUF;
      this.mTexCoordArray = RECTANGLE_TEX_BUF;
      this.mCoordsPerVertex = 2;
      this.mVertexStride = (this.mCoordsPerVertex * 4);
      this.mVertexCount = (RECTANGLE_COORDS.length / this.mCoordsPerVertex);
      continue;
      this.mVertexArray = FULL_RECTANGLE_BUF;
      this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
      this.mCoordsPerVertex = 2;
      this.mVertexStride = (this.mCoordsPerVertex * 4);
      this.mVertexCount = (FULL_RECTANGLE_COORDS.length / this.mCoordsPerVertex);
    }
  }
  
  public int getCoordsPerVertex()
  {
    return this.mCoordsPerVertex;
  }
  
  public FloatBuffer getTexCoordArray()
  {
    return this.mTexCoordArray;
  }
  
  public int getTexCoordStride()
  {
    return this.mTexCoordStride;
  }
  
  public FloatBuffer getVertexArray()
  {
    return this.mVertexArray;
  }
  
  public int getVertexCount()
  {
    return this.mVertexCount;
  }
  
  public int getVertexStride()
  {
    return this.mVertexStride;
  }
  
  public String toString()
  {
    if (this.mPrefab != null) {
      return "[Drawable2d: " + this.mPrefab + "]";
    }
    return "[Drawable2d: ...]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.gles.Drawable2d
 * JD-Core Version:    0.7.0.1
 */