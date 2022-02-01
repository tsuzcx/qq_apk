package com.tencent.tav.core.compositing;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;

public class VideoCompositionRenderContext
{
  RectF edgeWidths;
  private RenderContext renderContext;
  private float renderScale;
  private Matrix renderTransform;
  private CGSize size;
  private VideoComposition videoComposition;
  private TextureInfo videoTexture;
  
  public VideoCompositionRenderContext(RenderContext paramRenderContext)
  {
    AppMethodBeat.i(189622);
    this.renderContext = paramRenderContext;
    this.size = new CGSize(paramRenderContext.width(), paramRenderContext.height());
    AppMethodBeat.o(189622);
  }
  
  public RectF getEdgeWidths()
  {
    return this.edgeWidths;
  }
  
  public RenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public float getRenderScale()
  {
    return this.renderScale;
  }
  
  public Matrix getRenderTransform()
  {
    return this.renderTransform;
  }
  
  public CGSize getSize()
  {
    return this.size;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public TextureInfo newTextureInfo()
  {
    AppMethodBeat.i(189626);
    if (this.videoTexture == null)
    {
      RenderContext.checkEglError("newSampleBuffer");
      this.videoTexture = new TextureInfo(RenderContext.createTexture(3553), 3553, (int)this.size.width, (int)this.size.height, 0);
    }
    TextureInfo localTextureInfo = this.videoTexture;
    AppMethodBeat.o(189626);
    return localTextureInfo;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public String toString()
  {
    AppMethodBeat.i(189627);
    String str = "VideoCompositionRenderContext{size=" + this.size + ", renderContext=" + this.renderContext + '}';
    AppMethodBeat.o(189627);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.compositing.VideoCompositionRenderContext
 * JD-Core Version:    0.7.0.1
 */