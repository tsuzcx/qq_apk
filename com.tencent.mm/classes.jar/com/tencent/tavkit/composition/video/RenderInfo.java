package com.tencent.tavkit.composition.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RenderInfo
{
  private final CIContext ciContext;
  private final CGSize renderSize;
  private final CMTime time;
  private final List<TAVVideoCompositionTrack> tracks;
  
  public RenderInfo(CMTime paramCMTime, CGSize paramCGSize, CIContext paramCIContext)
  {
    AppMethodBeat.i(218938);
    this.tracks = new ArrayList();
    this.time = paramCMTime;
    this.renderSize = paramCGSize;
    this.ciContext = paramCIContext;
    AppMethodBeat.o(218938);
  }
  
  void addTrack(TAVVideoCompositionTrack paramTAVVideoCompositionTrack)
  {
    AppMethodBeat.i(218985);
    if (!this.tracks.contains(paramTAVVideoCompositionTrack)) {
      this.tracks.add(paramTAVVideoCompositionTrack);
    }
    AppMethodBeat.o(218985);
  }
  
  public CIContext getCiContext()
  {
    return this.ciContext;
  }
  
  public Object getParam(String paramString)
  {
    AppMethodBeat.i(218981);
    RenderContextParams localRenderContextParams = this.ciContext.getRenderContext().getParams();
    if (localRenderContextParams != null)
    {
      paramString = localRenderContextParams.getParam(paramString);
      AppMethodBeat.o(218981);
      return paramString;
    }
    AppMethodBeat.o(218981);
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
  
  public Object getTrackExtraInfo(String paramString)
  {
    AppMethodBeat.i(218998);
    Iterator localIterator = this.tracks.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((TAVVideoCompositionTrack)localIterator.next()).getExtraTrackInfo(paramString);
      if (localObject != null)
      {
        AppMethodBeat.o(218998);
        return localObject;
      }
    }
    AppMethodBeat.o(218998);
    return null;
  }
  
  public List<TAVVideoCompositionTrack> getTracks()
  {
    return this.tracks;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(218976);
    RenderContextParams localRenderContextParams = this.ciContext.getRenderContext().getParams();
    if (localRenderContextParams != null) {
      localRenderContextParams.putParam(paramString, paramObject);
    }
    AppMethodBeat.o(218976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.RenderInfo
 * JD-Core Version:    0.7.0.1
 */