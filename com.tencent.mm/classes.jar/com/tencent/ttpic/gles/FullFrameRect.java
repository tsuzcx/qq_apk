package com.tencent.ttpic.gles;

public class FullFrameRect
{
  private Texture2dProgram mProgram;
  private final Drawable2d mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
  
  public FullFrameRect(Texture2dProgram paramTexture2dProgram)
  {
    this.mProgram = paramTexture2dProgram;
  }
  
  public void changeProgram(Texture2dProgram paramTexture2dProgram)
  {
    this.mProgram.release();
    this.mProgram = paramTexture2dProgram;
  }
  
  public int createTextureObject()
  {
    return this.mProgram.createTextureObject();
  }
  
  public void drawFrame(int paramInt, float[] paramArrayOfFloat)
  {
    this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), paramArrayOfFloat, this.mRectDrawable.getTexCoordArray(), paramInt, this.mRectDrawable.getTexCoordStride());
  }
  
  public Texture2dProgram getProgram()
  {
    return this.mProgram;
  }
  
  public void release(boolean paramBoolean)
  {
    if (this.mProgram != null)
    {
      if (paramBoolean) {
        this.mProgram.release();
      }
      this.mProgram = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.gles.FullFrameRect
 * JD-Core Version:    0.7.0.1
 */