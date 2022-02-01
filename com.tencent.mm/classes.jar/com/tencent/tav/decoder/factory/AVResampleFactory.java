package com.tencent.tav.decoder.factory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.IAVResample;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.resample.TAVResample;

public class AVResampleFactory
{
  private static final String TAG = "AVResampleFactory";
  private static AVResampleFactory instance = null;
  private boolean tavResampleEnable;
  
  public AVResampleFactory()
  {
    AppMethodBeat.i(218450);
    this.tavResampleEnable = false;
    try
    {
      if (Class.forName("com.tencent.tavkit.resample.TAVResample") != null) {
        bool = true;
      }
      this.tavResampleEnable = bool;
      AppMethodBeat.o(218450);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Logger.w("AVResampleFactory", "newAVResample: ".concat(String.valueOf(localClassNotFoundException)));
      AppMethodBeat.o(218450);
    }
  }
  
  public static AVResampleFactory getInstance()
  {
    try
    {
      AppMethodBeat.i(218449);
      if (instance == null) {
        instance = new AVResampleFactory();
      }
      AVResampleFactory localAVResampleFactory = instance;
      AppMethodBeat.o(218449);
      return localAVResampleFactory;
    }
    finally {}
  }
  
  public static void setInstance(AVResampleFactory paramAVResampleFactory)
  {
    try
    {
      instance = paramAVResampleFactory;
      return;
    }
    finally
    {
      paramAVResampleFactory = finally;
      throw paramAVResampleFactory;
    }
  }
  
  public boolean isResampleEnable()
  {
    return this.tavResampleEnable;
  }
  
  public IAVResample newAVResample(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(218451);
    if (this.tavResampleEnable)
    {
      TAVResample localTAVResample = new TAVResample(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(218451);
      return localTAVResample;
    }
    AppMethodBeat.o(218451);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.factory.AVResampleFactory
 * JD-Core Version:    0.7.0.1
 */