package com.tencent.tavkit.composition.model;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVVideoConfiguration
  implements Cloneable
{
  public static CGRect DEFAULT_VIDEO_FRAME;
  public static final CGRect FIX_RENDER_SIZE;
  public static final CGRect SOURCE_SIZE;
  private TAVVideoConfigurationContentMode contentMode;
  private List<TAVVideoEffect> effects;
  private CGRect frame;
  private int preferRotation;
  private Matrix transform;
  
  static
  {
    AppMethodBeat.i(197579);
    FIX_RENDER_SIZE = new CGRect();
    CGRect localCGRect = new CGRect();
    SOURCE_SIZE = localCGRect;
    DEFAULT_VIDEO_FRAME = localCGRect;
    AppMethodBeat.o(197579);
  }
  
  public TAVVideoConfiguration()
  {
    AppMethodBeat.i(197572);
    this.frame = DEFAULT_VIDEO_FRAME;
    this.preferRotation = 0;
    this.contentMode = TAVVideoConfigurationContentMode.aspectFit;
    this.transform = new Matrix();
    this.effects = new ArrayList();
    AppMethodBeat.o(197572);
  }
  
  public void addEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(197574);
    if (this.effects == null) {
      this.effects = new ArrayList();
    }
    this.effects.add(paramTAVVideoEffect);
    AppMethodBeat.o(197574);
  }
  
  public TAVVideoConfiguration clone()
  {
    AppMethodBeat.i(197575);
    TAVVideoConfiguration localTAVVideoConfiguration = new TAVVideoConfiguration();
    localTAVVideoConfiguration.contentMode = this.contentMode;
    localTAVVideoConfiguration.frame = this.frame;
    localTAVVideoConfiguration.transform = this.transform;
    localTAVVideoConfiguration.effects = new ArrayList(this.effects);
    localTAVVideoConfiguration.preferRotation = this.preferRotation;
    AppMethodBeat.o(197575);
    return localTAVVideoConfiguration;
  }
  
  public boolean frameEnable()
  {
    AppMethodBeat.i(197573);
    if ((this.frame != null) && (this.frame != FIX_RENDER_SIZE) && (this.frame != SOURCE_SIZE) && (Utils.isRectValid(this.frame)))
    {
      AppMethodBeat.o(197573);
      return true;
    }
    AppMethodBeat.o(197573);
    return false;
  }
  
  public TAVVideoConfigurationContentMode getContentMode()
  {
    return this.contentMode;
  }
  
  public List<TAVVideoEffect> getEffects()
  {
    return this.effects;
  }
  
  public CGRect getFrame()
  {
    return this.frame;
  }
  
  public int getPreferRotation()
  {
    return this.preferRotation;
  }
  
  public Matrix getTransform()
  {
    return this.transform;
  }
  
  public void setContentMode(TAVVideoConfigurationContentMode paramTAVVideoConfigurationContentMode)
  {
    this.contentMode = paramTAVVideoConfigurationContentMode;
  }
  
  public void setEffects(List<TAVVideoEffect> paramList)
  {
    this.effects = paramList;
  }
  
  public void setFrame(CGRect paramCGRect)
  {
    this.frame = paramCGRect;
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setTransform(Matrix paramMatrix)
  {
    this.transform = paramMatrix;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197577);
    String str = "TAVVideoConfiguration{contentMode=" + this.contentMode + ", frame=" + this.frame + ", transform=" + this.transform + '}';
    AppMethodBeat.o(197577);
    return str;
  }
  
  public void updateTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(197576);
    if (this.effects == null)
    {
      AppMethodBeat.o(197576);
      return;
    }
    Iterator localIterator = this.effects.iterator();
    while (localIterator.hasNext())
    {
      TAVVideoEffect localTAVVideoEffect = (TAVVideoEffect)localIterator.next();
      if ((localTAVVideoEffect instanceof TAVAttachTimeRangeSourceEffect)) {
        ((TAVAttachTimeRangeSourceEffect)localTAVVideoEffect).attachTimeRange(paramCMTimeRange);
      }
    }
    AppMethodBeat.o(197576);
  }
  
  public static enum TAVVideoConfigurationContentMode
  {
    static
    {
      AppMethodBeat.i(197571);
      aspectFit = new TAVVideoConfigurationContentMode("aspectFit", 0);
      aspectFill = new TAVVideoConfigurationContentMode("aspectFill", 1);
      scaleToFit = new TAVVideoConfigurationContentMode("scaleToFit", 2);
      $VALUES = new TAVVideoConfigurationContentMode[] { aspectFit, aspectFill, scaleToFit };
      AppMethodBeat.o(197571);
    }
    
    private TAVVideoConfigurationContentMode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVVideoConfiguration
 * JD-Core Version:    0.7.0.1
 */