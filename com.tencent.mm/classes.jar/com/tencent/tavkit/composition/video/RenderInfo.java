package com.tencent.tavkit.composition.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.ciimage.CIContext;

public class RenderInfo
{
  private final CIContext ciContext;
  private final CGSize renderSize;
  private final CMTime time;
  
  public RenderInfo(CMTime paramCMTime, CGSize paramCGSize, CIContext paramCIContext)
  {
    this.time = paramCMTime;
    this.renderSize = paramCGSize;
    this.ciContext = paramCIContext;
  }
  
  public CIContext getCiContext()
  {
    return this.ciContext;
  }
  
  public Object getParam(String paramString)
  {
    AppMethodBeat.i(204737);
    RenderContextParams localRenderContextParams = this.ciContext.getRenderContext().getParams();
    if (localRenderContextParams != null)
    {
      paramString = localRenderContextParams.getParam(paramString);
      AppMethodBeat.o(204737);
      return paramString;
    }
    AppMethodBeat.o(204737);
    return null;
  }
  
  public int getRenderHeight()
  {
    return (int)this.renderSize.height;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public int getRenderWidth()
  {
    return (int)this.renderSize.width;
  }
  
  public CMTime getTime()
  {
    return this.time;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(204736);
    RenderContextParams localRenderContextParams = this.ciContext.getRenderContext().getParams();
    if (localRenderContextParams != null) {
      localRenderContextParams.putParam(paramString, paramObject);
    }
    AppMethodBeat.o(204736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.RenderInfo
 * JD-Core Version:    0.7.0.1
 */