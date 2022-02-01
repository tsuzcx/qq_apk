package com.tencent.tav.coremedia;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class TextureInfo
{
  public static boolean enableDebugInfo;
  private static final ArrayList<TextureInfo> textureList;
  private int format;
  private int frameBuffer;
  public final int height;
  private boolean mixAlpha;
  private boolean needRelease;
  public final int preferRotation;
  private boolean released;
  public final int textureID;
  private Matrix textureMatrix;
  private Rect textureRect;
  public final int textureType;
  public final int width;
  
  static
  {
    AppMethodBeat.i(215813);
    enableDebugInfo = false;
    textureList = new ArrayList();
    AppMethodBeat.o(215813);
  }
  
  public TextureInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(215789);
    this.frameBuffer = -1;
    this.needRelease = false;
    this.textureRect = null;
    this.mixAlpha = true;
    this.format = 6407;
    this.textureMatrix = null;
    this.textureID = paramInt1;
    this.textureType = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.preferRotation = paramInt5;
    addTextureInfo(this);
    AppMethodBeat.o(215789);
  }
  
  public TextureInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, int paramInt5)
  {
    AppMethodBeat.i(215795);
    this.frameBuffer = -1;
    this.needRelease = false;
    this.textureRect = null;
    this.mixAlpha = true;
    this.format = 6407;
    this.textureMatrix = paramMatrix;
    this.textureID = paramInt1;
    this.textureType = paramInt2;
    this.width = paramInt3;
    this.height = paramInt4;
    this.preferRotation = paramInt5;
    addTextureInfo(this);
    AppMethodBeat.o(215795);
  }
  
  private void addTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(215803);
    if (enableDebugInfo) {
      synchronized (textureList)
      {
        if (!textureList.contains(paramTextureInfo)) {
          textureList.add(paramTextureInfo);
        }
        AppMethodBeat.o(215803);
        return;
      }
    }
    AppMethodBeat.o(215803);
  }
  
  public static String printTextureInfo()
  {
    AppMethodBeat.i(215777);
    Object localObject = new StringBuilder();
    Iterator localIterator = textureList.iterator();
    TextureInfo localTextureInfo;
    int i;
    for (float f = 0.0F; localIterator.hasNext(); f = localTextureInfo.height * i * 3.0F / 1024.0F / 1024.0F + f)
    {
      localTextureInfo = (TextureInfo)localIterator.next();
      ((StringBuilder)localObject).append("id:" + localTextureInfo.textureID);
      ((StringBuilder)localObject).append(",size:" + localTextureInfo.width + "x" + localTextureInfo.height);
      ((StringBuilder)localObject).append("\n");
      i = localTextureInfo.width;
    }
    localObject = String.format("size:%d memory:%d info:%s", new Object[] { Integer.valueOf(textureList.size()), Integer.valueOf((int)f), ((StringBuilder)localObject).toString() });
    AppMethodBeat.o(215777);
    return localObject;
  }
  
  public TextureInfo clone()
  {
    AppMethodBeat.i(215819);
    TextureInfo localTextureInfo = new TextureInfo(this.textureID, this.textureType, this.width, this.height, this.textureMatrix, this.preferRotation);
    localTextureInfo.needRelease = true;
    localTextureInfo.textureRect = this.textureRect;
    AppMethodBeat.o(215819);
    return localTextureInfo;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(215888);
    if ((paramObject instanceof TextureInfo))
    {
      if (((TextureInfo)paramObject).textureID == this.textureID)
      {
        AppMethodBeat.o(215888);
        return true;
      }
      AppMethodBeat.o(215888);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(215888);
    return bool;
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
  
  public Rect getTextureRect()
  {
    return this.textureRect;
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
    AppMethodBeat.i(215844);
    this.released = true;
    if (this.frameBuffer != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.frameBuffer }, 0);
      this.frameBuffer = -1;
    }
    GLES20.glDeleteTextures(1, new int[] { this.textureID }, 0);
    if (enableDebugInfo) {
      synchronized (textureList)
      {
        textureList.remove(this);
        AppMethodBeat.o(215844);
        return;
      }
    }
    AppMethodBeat.o(215844);
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
  
  public void setTextureRect(Rect paramRect)
  {
    this.textureRect = paramRect;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215881);
    String str = "TextureInfo{textureID=" + this.textureID + ", textureType=" + this.textureType + ", width=" + this.width + ", height=" + this.height + ", preferRotation=" + this.preferRotation + ", textureMatrix=" + this.textureMatrix + ", frameBuffer=" + this.frameBuffer + ", needRelease=" + this.needRelease + ", mixAlpha=" + this.mixAlpha + ", format=" + this.format + '}';
    AppMethodBeat.o(215881);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.TextureInfo
 * JD-Core Version:    0.7.0.1
 */