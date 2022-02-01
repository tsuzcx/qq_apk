package com.tencent.thumbplayer.core.postprocessor;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SharpenFilterGroup
{
  public boolean ifsharpen;
  private BlurFilter mBlurFilter;
  private OES2TextureFilter mOES2TextureFilter;
  private Texture2OESFIlter mTexture2OESFilter;
  private USM3FusionFilter mUSM3FusionFilter;
  
  public SharpenFilterGroup(String paramString)
  {
    AppMethodBeat.i(227327);
    this.ifsharpen = true;
    this.mOES2TextureFilter = new OES2TextureFilter(paramString);
    this.mUSM3FusionFilter = new USM3FusionFilter(paramString);
    this.mBlurFilter = new BlurFilter(paramString);
    this.mTexture2OESFilter = new Texture2OESFIlter(paramString);
    AppMethodBeat.o(227327);
  }
  
  public void checkGlError(String paramString)
  {
    AppMethodBeat.i(227375);
    if (GLES20.glGetError() != 0)
    {
      paramString = new RuntimeException(paramString);
      AppMethodBeat.o(227375);
      throw paramString;
    }
    AppMethodBeat.o(227375);
  }
  
  void destroyBuffers()
  {
    AppMethodBeat.i(227355);
    this.mOES2TextureFilter.destroyBuffers();
    this.mUSM3FusionFilter.destroyBuffers();
    this.mBlurFilter.destroyBuffers();
    this.mTexture2OESFilter.destroyBuffers();
    AppMethodBeat.o(227355);
  }
  
  void genOESTexture()
  {
    AppMethodBeat.i(227336);
    if (this.mOES2TextureFilter != null)
    {
      this.mOES2TextureFilter.genOESTexture();
      AppMethodBeat.o(227336);
      return;
    }
    RuntimeException localRuntimeException = new RuntimeException("sifeng: OES2TextureFilter(null) generate texture failed");
    AppMethodBeat.o(227336);
    throw localRuntimeException;
  }
  
  int getOESTextureid()
  {
    AppMethodBeat.i(227347);
    int i = this.mOES2TextureFilter.getOESTextureid();
    AppMethodBeat.o(227347);
    return i;
  }
  
  void process(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    AppMethodBeat.i(227367);
    if (paramBoolean)
    {
      int i = this.mOES2TextureFilter.process(paramSurfaceTexture, paramInt1, paramInt2, paramBoolean);
      this.mBlurFilter.process(i, paramInt1, paramInt2);
      paramInt1 = this.mUSM3FusionFilter.process(i, this.mBlurFilter.getTexid(0), this.mBlurFilter.getTexid(1), this.mBlurFilter.getTexid(2), paramInt1, paramInt2, paramBoolean, paramInt5);
      this.mTexture2OESFilter.process(paramInt1, paramInt3, paramInt4, paramBoolean);
    }
    for (;;)
    {
      GLES20.glFlush();
      AppMethodBeat.o(227367);
      return;
      paramInt1 = this.mOES2TextureFilter.process(paramSurfaceTexture, paramInt1, paramInt2, paramBoolean);
      this.mTexture2OESFilter.process(paramInt1, paramInt3, paramInt4, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.thumbplayer.core.postprocessor.SharpenFilterGroup
 * JD-Core Version:    0.7.0.1
 */