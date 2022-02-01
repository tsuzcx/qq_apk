package com.tencent.tavkit.composition.video;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import java.util.Iterator;
import java.util.List;

class DefaultVideoMixFilter
  implements TAVVideoMixEffect.Filter
{
  private void checkFillInRenderSize(RenderInfo paramRenderInfo, ImageCollection.TrackImagePair paramTrackImagePair, CIImage paramCIImage)
  {
    AppMethodBeat.i(200933);
    if (!(paramTrackImagePair.getTrack() instanceof TAVClip))
    {
      AppMethodBeat.o(200933);
      return;
    }
    paramTrackImagePair = ((TAVClip)paramTrackImagePair.getTrack()).getVideoConfiguration();
    if (paramTrackImagePair.frameEnable())
    {
      AppMethodBeat.o(200933);
      return;
    }
    paramCIImage.applyFillInFrame(new CGRect(new PointF(0.0F, 0.0F), paramRenderInfo.getRenderSize()), paramTrackImagePair.getContentMode());
    AppMethodBeat.o(200933);
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    AppMethodBeat.i(200932);
    paramTAVVideoMixEffect = new CIImage(paramRenderInfo.getRenderSize());
    Object localObject1 = paramImageCollection.getVideoChannelImages().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ImageCollection.TrackImagePair)((Iterator)localObject1).next();
      CIImage localCIImage = ((ImageCollection.TrackImagePair)localObject2).getImage();
      checkFillInRenderSize(paramRenderInfo, (ImageCollection.TrackImagePair)localObject2, localCIImage);
      localCIImage.imageByCompositingOverImage(paramTAVVideoMixEffect);
    }
    paramImageCollection = paramImageCollection.getOverlayImages().iterator();
    while (paramImageCollection.hasNext())
    {
      localObject1 = (ImageCollection.TrackImagePair)paramImageCollection.next();
      localObject2 = ((ImageCollection.TrackImagePair)localObject1).getImage();
      checkFillInRenderSize(paramRenderInfo, (ImageCollection.TrackImagePair)localObject1, (CIImage)localObject2);
      ((CIImage)localObject2).imageByCompositingOverImage(paramTAVVideoMixEffect);
    }
    AppMethodBeat.o(200932);
    return paramTAVVideoMixEffect;
  }
  
  public void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.DefaultVideoMixFilter
 * JD-Core Version:    0.7.0.1
 */