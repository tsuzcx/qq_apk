package com.tencent.mm.videocomposition.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/compositing/NoRenderVideoCompositing;", "Lcom/tencent/tav/core/compositing/VideoCompositing;", "()V", "cancelAllPendingVideoCompositionRequests", "", "release", "renderContextChanged", "newRenderContext", "Lcom/tencent/tav/core/compositing/VideoCompositionRenderContext;", "requiredPixelBufferAttributesForRenderContext", "Ljava/util/HashMap;", "", "", "sourcePixelBufferAttributes", "startVideoCompositionRequest", "asyncVideoCompositionRequest", "Lcom/tencent/tav/core/compositing/AsynchronousVideoCompositionRequest;", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class a
  implements VideoCompositing
{
  public final void cancelAllPendingVideoCompositionRequests() {}
  
  public final void release() {}
  
  public final void renderContextChanged(VideoCompositionRenderContext paramVideoCompositionRenderContext) {}
  
  public final HashMap<String, Object> requiredPixelBufferAttributesForRenderContext()
  {
    return null;
  }
  
  public final HashMap<String, Object> sourcePixelBufferAttributes()
  {
    return null;
  }
  
  public final void startVideoCompositionRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    AppMethodBeat.i(233526);
    if (paramAsynchronousVideoCompositionRequest != null)
    {
      Object localObject = paramAsynchronousVideoCompositionRequest.getSourceTrackIDs();
      if (localObject != null)
      {
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Integer localInteger = (Integer)((Iterator)localObject).next();
          s.r(localInteger, "it");
          paramAsynchronousVideoCompositionRequest.finishWithComposedVideoFrame(paramAsynchronousVideoCompositionRequest.sourceFrameByTrackID(localInteger.intValue()));
        }
        AppMethodBeat.o(233526);
        return;
      }
    }
    AppMethodBeat.o(233526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.b.a
 * JD-Core Version:    0.7.0.1
 */