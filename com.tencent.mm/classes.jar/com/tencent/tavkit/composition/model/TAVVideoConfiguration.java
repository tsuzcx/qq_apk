package com.tencent.tavkit.composition.model;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavkit.composition.video.TAVAttachTimeRangeSourceEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TAVVideoConfiguration
  implements Cloneable
{
  private TAVVideoConfigurationContentMode contentMode;
  private List<TAVVideoEffect> effects;
  private CGRect frame;
  private int preferRotation;
  private Matrix transform;
  
  public TAVVideoConfiguration()
  {
    AppMethodBeat.i(204702);
    this.preferRotation = 0;
    this.contentMode = TAVVideoConfigurationContentMode.aspectFit;
    this.transform = new Matrix();
    this.effects = new ArrayList();
    AppMethodBeat.o(204702);
  }
  
  public void addEffect(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(204703);
    if (this.effects == null) {
      this.effects = new ArrayList();
    }
    this.effects.add(paramTAVVideoEffect);
    AppMethodBeat.o(204703);
  }
  
  public TAVVideoConfiguration clone()
  {
    AppMethodBeat.i(204704);
    TAVVideoConfiguration localTAVVideoConfiguration = new TAVVideoConfiguration();
    localTAVVideoConfiguration.contentMode = this.contentMode;
    localTAVVideoConfiguration.frame = this.frame;
    localTAVVideoConfiguration.transform = this.transform;
    localTAVVideoConfiguration.effects = new ArrayList(this.effects);
    localTAVVideoConfiguration.preferRotation = this.preferRotation;
    AppMethodBeat.o(204704);
    return localTAVVideoConfiguration;
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
    AppMethodBeat.i(204706);
    String str = "TAVVideoConfiguration{contentMode=" + this.contentMode + ", frame=" + this.frame + ", transform=" + this.transform + '}';
    AppMethodBeat.o(204706);
    return str;
  }
  
  public void updateTimeRange(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(204705);
    if (this.effects == null)
    {
      AppMethodBeat.o(204705);
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
    AppMethodBeat.o(204705);
  }
  
  public static enum TAVVideoConfigurationContentMode
  {
    static
    {
      AppMethodBeat.i(204701);
      aspectFit = new TAVVideoConfigurationContentMode("aspectFit", 0);
      aspectFill = new TAVVideoConfigurationContentMode("aspectFill", 1);
      scaleToFit = new TAVVideoConfigurationContentMode("scaleToFit", 2);
      $VALUES = new TAVVideoConfigurationContentMode[] { aspectFit, aspectFill, scaleToFit };
      AppMethodBeat.o(204701);
    }
    
    private TAVVideoConfigurationContentMode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVVideoConfiguration
 * JD-Core Version:    0.7.0.1
 */