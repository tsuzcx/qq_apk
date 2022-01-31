package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FullFrameRect
{
  private Texture2dProgram mProgram;
  private final Drawable2d mRectDrawable;
  
  public FullFrameRect(Texture2dProgram paramTexture2dProgram)
  {
    AppMethodBeat.i(49985);
    this.mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
    this.mProgram = paramTexture2dProgram;
    AppMethodBeat.o(49985);
  }
  
  public void changeProgram(Texture2dProgram paramTexture2dProgram)
  {
    AppMethodBeat.i(49987);
    this.mProgram.release();
    this.mProgram = paramTexture2dProgram;
    AppMethodBeat.o(49987);
  }
  
  public int createTextureObject()
  {
    AppMethodBeat.i(49988);
    int i = this.mProgram.createTextureObject();
    AppMethodBeat.o(49988);
    return i;
  }
  
  public void drawFrame(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(49989);
    this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), paramArrayOfFloat, this.mRectDrawable.getTexCoordArray(), paramInt, this.mRectDrawable.getTexCoordStride());
    AppMethodBeat.o(49989);
  }
  
  public Texture2dProgram getProgram()
  {
    return this.mProgram;
  }
  
  public void release(boolean paramBoolean)
  {
    AppMethodBeat.i(49986);
    if (this.mProgram != null)
    {
      if (paramBoolean) {
        this.mProgram.release();
      }
      this.mProgram = null;
    }
    AppMethodBeat.o(49986);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.gles.FullFrameRect
 * JD-Core Version:    0.7.0.1
 */