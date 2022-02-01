package com.tencent.tavkit.composition.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TAVVideoConfiguration$TAVVideoConfigurationContentMode
{
  static
  {
    AppMethodBeat.i(212449);
    aspectFit = new TAVVideoConfigurationContentMode("aspectFit", 0);
    aspectFill = new TAVVideoConfigurationContentMode("aspectFill", 1);
    scaleToFit = new TAVVideoConfigurationContentMode("scaleToFit", 2);
    $VALUES = new TAVVideoConfigurationContentMode[] { aspectFit, aspectFill, scaleToFit };
    AppMethodBeat.o(212449);
  }
  
  private TAVVideoConfiguration$TAVVideoConfigurationContentMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode
 * JD-Core Version:    0.7.0.1
 */