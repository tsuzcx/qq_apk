package com.tencent.tav.coremedia;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextureInfo
{
  private int format = 6407;
  private int frameBuffer = -1;
  public final int height;
  private boolean mixAlpha = true;
  private boolean needRelease = false;
  public final int preferRotation;
  private boolean released;
  public final int textureID;
  private Matrix textureMatrix;
  public final int textureType;
  public final int width;
  
  public TextureInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.textureMatrix = null;
    this.textureID = paramInt1;
    this.textureType = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.preferRotation = paramInt5;
  }
  
  public TextureInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, int paramInt5)
  {
    this.textureMatrix = paramMatrix;
    this.textureID = paramInt1;
    this.textureType = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.preferRotation = paramInt5;
  }
  
  public TextureInfo clone()
  {
    AppMethodBeat.i(219465);
    TextureInfo localTextureInfo = new TextureInfo(this.textureID, this.textureType, this.width, this.height, this.textureMatrix, this.preferRotation);
    localTextureInfo.needRelease = true;
    AppMethodBeat.o(219465);
    return localTextureInfo;
  }
  
  public int getFormat()
  {
    return this.format;
  }
  
  public int getFrameBuffer()
  {
    return this.frameBuffer;
  }
  
  public Matrix getTextureMatrix()
  {
    return this.textureMatrix;
  }
  
  public boolean isMixAlpha()
  {
    return this.mixAlpha;
  }
  
  public boolean isNeedRelease()
  {
    return this.needRelease;
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public void release()
  {
    AppMethodBeat.i(219466);
    this.released = true;
    if (this.frameBuffer != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.frameBuffer }, 0);
      this.frameBuffer = -1;
    }
    GLES20.glDeleteTextures(1, new int[] { this.textureID }, 0);
    AppMethodBeat.o(219466);
  }
  
  public void setFormat(int paramInt)
  {
    this.format = paramInt;
  }
  
  public void setFrameBuffer(int paramInt)
  {
    this.frameBuffer = paramInt;
  }
  
  public void setMixAlpha(boolean paramBoolean)
  {
    this.mixAlpha = paramBoolean;
  }
  
  public void setTextureMatrix(Matrix paramMatrix)
  {
    this.textureMatrix = paramMatrix;
  }
  
  public String toString()
  {
    AppMethodBeat.i(219467);
    String str = "TextureInfo{textureID=" + this.textureID + ", textureType=" + this.textureType + ", width=" + this.width + ", height=" + this.height + ", preferRotation=" + this.preferRotation + ", textureMatrix=" + this.textureMatrix + ", frameBuffer=" + this.frameBuffer + ", needRelease=" + this.needRelease + ", mixAlpha=" + this.mixAlpha + ", format=" + this.format + '}';
    AppMethodBeat.o(219467);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.coremedia.TextureInfo
 * JD-Core Version:    0.7.0.1
 */