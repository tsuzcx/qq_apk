package com.tencent.ttpic.gles;

import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GLSharedData
{
  public EGLContext mSharedContext;
  public TextureDataPipe[] mTexturePile;
  
  public GLSharedData(EGLContext paramEGLContext)
  {
    AppMethodBeat.i(83236);
    this.mSharedContext = paramEGLContext;
    this.mTexturePile = new TextureDataPipe[2];
    this.mTexturePile[0] = new TextureDataPipe();
    this.mTexturePile[1] = new TextureDataPipe();
    AppMethodBeat.o(83236);
  }
  
  public void clear()
  {
    AppMethodBeat.i(83240);
    TextureDataPipe[] arrayOfTextureDataPipe = this.mTexturePile;
    int j = arrayOfTextureDataPipe.length;
    int i = 0;
    while (i < j)
    {
      arrayOfTextureDataPipe[i].release();
      i += 1;
    }
    AppMethodBeat.o(83240);
  }
  
  public TextureDataPipe getCurrentTexturePile()
  {
    AppMethodBeat.i(83237);
    int i;
    int j;
    label35:
    TextureDataPipe localTextureDataPipe;
    if (this.mTexturePile[0].getTexureCurrentStatus() == 2)
    {
      i = 1;
      if (this.mTexturePile[1].getTexureCurrentStatus() != 2) {
        break label84;
      }
      j = 1;
      if ((i == 0) || (j == 0)) {
        break label99;
      }
      if (this.mTexturePile[0].mTimestamp >= this.mTexturePile[1].mTimestamp) {
        break label89;
      }
      localTextureDataPipe = this.mTexturePile[0];
    }
    for (;;)
    {
      AppMethodBeat.o(83237);
      return localTextureDataPipe;
      i = 0;
      break;
      label84:
      j = 0;
      break label35;
      label89:
      localTextureDataPipe = this.mTexturePile[1];
      continue;
      label99:
      if (i != 0) {
        localTextureDataPipe = this.mTexturePile[0];
      } else if (j != 0) {
        localTextureDataPipe = this.mTexturePile[1];
      } else {
        localTextureDataPipe = null;
      }
    }
  }
  
  public TextureDataPipe getFreeTexturePileMakeBusy()
  {
    AppMethodBeat.i(83238);
    int i = 0;
    TextureDataPipe localTextureDataPipe;
    if (i < this.mTexturePile.length) {
      if (this.mTexturePile[i].getTexureCurrentStatus() == 0)
      {
        localTextureDataPipe = this.mTexturePile[i];
        localTextureDataPipe.makeBusy();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(83238);
      return localTextureDataPipe;
      i += 1;
      break;
      localTextureDataPipe = null;
    }
  }
  
  public boolean judgeBrotherTextureIsReady(TextureDataPipe paramTextureDataPipe)
  {
    AppMethodBeat.i(83239);
    TextureDataPipe localTextureDataPipe = this.mTexturePile[0];
    if (this.mTexturePile[0] == paramTextureDataPipe) {
      localTextureDataPipe = this.mTexturePile[1];
    }
    if (localTextureDataPipe.getTexureCurrentStatus() == 2)
    {
      AppMethodBeat.o(83239);
      return true;
    }
    AppMethodBeat.o(83239);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.gles.GLSharedData
 * JD-Core Version:    0.7.0.1
 */