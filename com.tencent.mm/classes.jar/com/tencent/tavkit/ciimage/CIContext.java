package com.tencent.tavkit.ciimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;

public class CIContext
{
  private final String TAG;
  private CIImageFilter copyFilter;
  private CIImageFilter filter;
  private final RenderContext renderContext;
  private TextureInfo textureInfo;
  
  public CIContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(204419);
    this.TAG = ("CIContext@" + Integer.toHexString(hashCode()));
    this.renderContext = paramRenderContext;
    AppMethodBeat.o(204419);
  }
  
  public static TextureInfo newTextureInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204421);
    TextureInfo localTextureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, paramInt1, paramInt2, null, 0);
    AppMethodBeat.o(204421);
    return localTextureInfo;
  }
  
  private void setDestImage(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(204424);
    if (this.filter == null) {
      this.filter = new CIImageFilter();
    }
    this.filter.setOutputTextureInfo(paramTextureInfo);
    AppMethodBeat.o(204424);
  }
  
  public void clear(int paramInt)
  {
    AppMethodBeat.i(204423);
    this.filter.clearBufferBuffer(paramInt);
    AppMethodBeat.o(204423);
  }
  
  public TextureInfo convertImageToTexture(CIImage paramCIImage, TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(204422);
    if (paramTextureInfo == null)
    {
      AppMethodBeat.o(204422);
      return null;
    }
    if (this.copyFilter == null) {
      this.copyFilter = new CIImageFilter();
    }
    this.copyFilter.setOutputTextureInfo(paramTextureInfo);
    this.copyFilter.clearBufferBuffer(-16777216);
    paramCIImage.draw(this.copyFilter);
    AppMethodBeat.o(204422);
    return paramTextureInfo;
  }
  
  public RenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public void release()
  {
    AppMethodBeat.i(204425);
    Logger.d(this.TAG, "release: begin, currentThread = " + Thread.currentThread().getName());
    if (this.filter != null) {
      this.filter.release();
    }
    if (this.textureInfo != null) {
      this.textureInfo.release();
    }
    if (this.copyFilter != null) {
      this.copyFilter.release();
    }
    Logger.d(this.TAG, "release: end, currentThread = " + Thread.currentThread().getName());
    AppMethodBeat.o(204425);
  }
  
  public CMSampleBuffer renderToSampleBuffer(CIImage paramCIImage, CMTime paramCMTime, RenderContext paramRenderContext)
  {
    AppMethodBeat.i(204420);
    paramRenderContext.makeCurrent();
    if ((this.textureInfo != null) && ((this.textureInfo.width != paramRenderContext.width()) || (this.textureInfo.height != paramRenderContext.height())))
    {
      this.textureInfo.release();
      this.textureInfo = null;
    }
    if (this.textureInfo == null) {
      this.textureInfo = newTextureInfo(paramRenderContext.width(), paramRenderContext.height());
    }
    setDestImage(this.textureInfo);
    clear(-16777216);
    paramCIImage.draw(this.filter);
    paramCIImage = new CMSampleBuffer(paramCMTime, this.textureInfo, false);
    AppMethodBeat.o(204420);
    return paramCIImage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.CIContext
 * JD-Core Version:    0.7.0.1
 */