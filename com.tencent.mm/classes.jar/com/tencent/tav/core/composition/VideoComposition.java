package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.Composition;
import com.tencent.tav.core.VideoCompositor;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VideoComposition
  implements Cloneable
{
  private static final String TAG = "VideoComposition";
  private Asset asset;
  private Class<? extends VideoCompositing> customVideoCompositorClass;
  private CMTime frameDuration;
  private List<? extends VideoCompositionInstruction> instructions;
  private RenderLayoutMode renderLayoutMode;
  private float renderScale;
  private CGSize renderSize;
  private int sourceTrackIDForFrameTiming;
  
  public VideoComposition() {}
  
  public VideoComposition(Asset paramAsset)
  {
    AppMethodBeat.i(197704);
    this.asset = paramAsset;
    this.instructions = new ArrayList();
    fillSourceProperty();
    AppMethodBeat.o(197704);
  }
  
  private void fillSourceProperty()
  {
    AppMethodBeat.i(197705);
    Object localObject2 = this.asset.tracksWithMediaType(1);
    this.frameDuration = null;
    this.renderSize = null;
    Object localObject3;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject3 = ((List)localObject2).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = (AssetTrack)((Iterator)localObject3).next();
        if (this.frameDuration == null) {
          localObject1 = new CMTime(1L, (int)((AssetTrack)localObject1).getNominalFrameRate());
        }
        for (;;)
        {
          this.frameDuration = ((CMTime)localObject1);
          break;
          if (this.frameDuration.timeScale > ((AssetTrack)localObject1).getNominalFrameRate()) {
            localObject1 = this.frameDuration;
          } else {
            localObject1 = new CMTime(1L, (int)((AssetTrack)localObject1).getNominalFrameRate());
          }
        }
      }
    }
    if ((this.frameDuration == null) || (this.frameDuration.timeScale == 0)) {
      this.frameDuration = new CMTime(1L, 30);
    }
    if ((this.asset instanceof Composition)) {
      this.renderSize = this.asset.getNaturalSize();
    }
    for (;;)
    {
      this.instructions = new ArrayList();
      if ((localObject2 == null) || ((this.asset instanceof Composition))) {
        break;
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AssetTrack)((Iterator)localObject1).next();
        localObject3 = new VideoCompositionInstruction();
        ((VideoCompositionInstruction)localObject3).backgroundColor = -16777216;
        ((VideoCompositionInstruction)localObject3).enablePostProcessing = true;
        ((VideoCompositionInstruction)localObject3).passthroughTrackID = ((AssetTrack)localObject2).getTrackID();
        ((VideoCompositionInstruction)localObject3).timeRange = new CMTimeRange(CMTime.CMTimeZero, ((AssetTrack)localObject2).getDuration());
        ((VideoCompositionInstruction)localObject3).requiredSourceTrackIDs = Arrays.asList(new Integer[] { Integer.valueOf(((AssetTrack)localObject2).getTrackID()) });
        MutableVideoCompositionLayerInstruction localMutableVideoCompositionLayerInstruction = new MutableVideoCompositionLayerInstruction();
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setTrackID(((AssetTrack)localObject2).getTrackID());
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setTransformRampFromStartTransform(null, null, ((VideoCompositionInstruction)localObject3).timeRange);
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setCropRectangleRampFromStartCropRectangle(null, null, ((VideoCompositionInstruction)localObject3).timeRange);
        ((MutableVideoCompositionLayerInstruction)localMutableVideoCompositionLayerInstruction).setOpacityRampFromStartOpacity(1.0F, 1.0F, ((VideoCompositionInstruction)localObject3).timeRange);
        ((VideoCompositionInstruction)localObject3).layerInstructions.add(localMutableVideoCompositionLayerInstruction);
      }
      if (localObject2 != null)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (AssetTrack)((Iterator)localObject1).next();
          if (this.renderSize == null) {
            this.renderSize = ((AssetTrack)localObject3).getNaturalSize();
          } else if (((AssetTrack)localObject3).getNaturalSize() != null) {
            this.renderSize = new CGSize(Math.max(this.renderSize.width, ((AssetTrack)localObject3).getNaturalSize().width), Math.max(this.renderSize.height, ((AssetTrack)localObject3).getNaturalSize().height));
          }
        }
      }
    }
    this.renderScale = 1.0F;
    AppMethodBeat.o(197705);
  }
  
  public static VideoCompositionInstruction findInstruction(VideoComposition paramVideoComposition, CMTime paramCMTime)
  {
    Object localObject = null;
    AppMethodBeat.i(197707);
    if (paramVideoComposition.getInstructions() == null)
    {
      AppMethodBeat.o(197707);
      return null;
    }
    Iterator localIterator = paramVideoComposition.getInstructions().iterator();
    paramVideoComposition = (VideoComposition)localObject;
    while (localIterator.hasNext())
    {
      VideoCompositionInstruction localVideoCompositionInstruction = (VideoCompositionInstruction)localIterator.next();
      localObject = paramVideoComposition;
      if (localVideoCompositionInstruction.getTimeRange() != null) {
        if (paramVideoComposition != null)
        {
          localObject = paramVideoComposition;
          if (!paramVideoComposition.getTimeRange().getEnd().smallThan(localVideoCompositionInstruction.getTimeRange().getEnd())) {}
        }
        else
        {
          localObject = localVideoCompositionInstruction;
        }
      }
      CMTimeRange localCMTimeRange = localVideoCompositionInstruction.getTimeRange();
      paramVideoComposition = (VideoComposition)localObject;
      if (localCMTimeRange != null)
      {
        paramVideoComposition = (VideoComposition)localObject;
        if (localCMTimeRange.getStartUs() <= paramCMTime.getTimeUs())
        {
          paramVideoComposition = (VideoComposition)localObject;
          if (localCMTimeRange.getEndUs() > paramCMTime.getTimeUs())
          {
            AppMethodBeat.o(197707);
            return localVideoCompositionInstruction;
          }
        }
      }
    }
    AppMethodBeat.o(197707);
    return paramVideoComposition;
  }
  
  public VideoCompositing getCustomVideoCompositor()
  {
    AppMethodBeat.i(197706);
    if (this.customVideoCompositorClass != null) {
      try
      {
        VideoCompositing localVideoCompositing = (VideoCompositing)this.customVideoCompositorClass.newInstance();
        AppMethodBeat.o(197706);
        return localVideoCompositing;
      }
      catch (InstantiationException localInstantiationException)
      {
        for (;;)
        {
          VideoCompositor localVideoCompositor1 = new VideoCompositor();
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localVideoCompositor2 = new VideoCompositor();
        }
      }
    }
    VideoCompositor localVideoCompositor2 = new VideoCompositor();
    AppMethodBeat.o(197706);
    return localVideoCompositor2;
  }
  
  public Class<? extends VideoCompositing> getCustomVideoCompositorClass()
  {
    return this.customVideoCompositorClass;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public <T extends VideoCompositionInstruction> List<T> getInstructions()
  {
    return this.instructions;
  }
  
  public RenderLayoutMode getRenderLayoutMode()
  {
    return this.renderLayoutMode;
  }
  
  public float getRenderScale()
  {
    return this.renderScale;
  }
  
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public int getSourceTrackIDForFrameTiming()
  {
    return this.sourceTrackIDForFrameTiming;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197708);
    String str = "MutableVideoComposition{, frameDuration=" + this.frameDuration + ", renderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", instructions=" + this.instructions + '}';
    AppMethodBeat.o(197708);
    return str;
  }
  
  public static enum RenderLayoutMode
  {
    static
    {
      AppMethodBeat.i(197703);
      aspectFit = new RenderLayoutMode("aspectFit", 0);
      aspectFill = new RenderLayoutMode("aspectFill", 1);
      $VALUES = new RenderLayoutMode[] { aspectFit, aspectFill };
      AppMethodBeat.o(197703);
    }
    
    private RenderLayoutMode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.composition.VideoComposition
 * JD-Core Version:    0.7.0.1
 */