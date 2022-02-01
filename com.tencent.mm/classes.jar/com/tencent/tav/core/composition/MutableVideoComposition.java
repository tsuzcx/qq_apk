package com.tencent.tav.core.composition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.Composition;
import com.tencent.tav.core.VideoCompositor;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MutableVideoComposition
  extends VideoComposition
{
  private static final String TAG = "VideoComposition";
  private Asset asset;
  private Class<? extends VideoCompositing> customVideoCompositorClass;
  private CMTime frameDuration;
  private List<? extends VideoCompositionInstruction> instructions;
  private VideoComposition.RenderLayoutMode renderLayoutMode;
  private float renderScale;
  private CGSize renderSize;
  private int sourceTrackIDForFrameTiming;
  
  public MutableVideoComposition() {}
  
  public MutableVideoComposition(Asset paramAsset)
  {
    AppMethodBeat.i(189629);
    this.asset = paramAsset;
    this.instructions = new ArrayList();
    fillSourceProperty();
    AppMethodBeat.o(189629);
  }
  
  private void fillSourceProperty()
  {
    AppMethodBeat.i(189631);
    Object localObject2 = this.asset.tracksWithMediaType(1);
    this.frameDuration = null;
    this.renderSize = null;
    Object localObject1;
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = (AssetTrack)localIterator.next();
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
      this.renderScale = 1.0F;
      AppMethodBeat.o(189631);
      return;
      if (localObject2 != null)
      {
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AssetTrack)((Iterator)localObject1).next();
          if (this.renderSize == null) {
            this.renderSize = ((AssetTrack)localObject2).getNaturalSize();
          } else if (((AssetTrack)localObject2).getNaturalSize() != null) {
            this.renderSize = new CGSize(Math.max(this.renderSize.width, ((AssetTrack)localObject2).getNaturalSize().width), Math.max(this.renderSize.height, ((AssetTrack)localObject2).getNaturalSize().height));
          }
        }
      }
    }
  }
  
  public VideoCompositing getCustomVideoCompositor()
  {
    AppMethodBeat.i(189643);
    if (this.customVideoCompositorClass != null) {}
    try
    {
      VideoCompositing localVideoCompositing = (VideoCompositing)this.customVideoCompositorClass.newInstance();
      AppMethodBeat.o(189643);
      return localVideoCompositing;
    }
    catch (InstantiationException localInstantiationException)
    {
      for (;;)
      {
        localVideoCompositor = new VideoCompositor();
      }
      VideoCompositor localVideoCompositor = new VideoCompositor();
      AppMethodBeat.o(189643);
      return localVideoCompositor;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label31:
      break label31;
    }
  }
  
  public Class<? extends VideoCompositing> getCustomVideoCompositorClass()
  {
    return this.customVideoCompositorClass;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public List<? extends VideoCompositionInstruction> getInstructions()
  {
    return this.instructions;
  }
  
  public VideoComposition.RenderLayoutMode getRenderLayoutMode()
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
  
  public void setCustomVideoCompositorClass(Class<? extends VideoCompositing> paramClass)
  {
    this.customVideoCompositorClass = paramClass;
  }
  
  public void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setInstructions(List<? extends VideoCompositionInstruction> paramList)
  {
    this.instructions = paramList;
  }
  
  public void setRenderLayoutMode(VideoComposition.RenderLayoutMode paramRenderLayoutMode)
  {
    this.renderLayoutMode = paramRenderLayoutMode;
  }
  
  public void setRenderScale(float paramFloat)
  {
    this.renderScale = paramFloat;
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    this.renderSize = paramCGSize;
  }
  
  public void setSourceTrackIDForFrameTiming(int paramInt)
  {
    this.sourceTrackIDForFrameTiming = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(189645);
    String str = "MutableVideoComposition{, frameDuration=" + this.frameDuration + ", renderSize=" + this.renderSize + ", renderLayoutMode=" + this.renderLayoutMode + ", instructions=" + this.instructions + '}';
    AppMethodBeat.o(189645);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.composition.MutableVideoComposition
 * JD-Core Version:    0.7.0.1
 */