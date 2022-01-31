package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.y;

public final class g$a
{
  public Class<? extends v> aov;
  public Class<? extends v> vpm;
  
  public g$a(Class<? extends v> paramClass1, Class<? extends v> paramClass2)
  {
    this.aov = paramClass1;
    this.vpm = paramClass2;
  }
  
  public final v cEe()
  {
    try
    {
      v localv = (v)this.vpm.newInstance();
      return localv;
    }
    catch (InstantiationException localInstantiationException)
    {
      y.printErrStackTrace("ChattingComponentFactory", localInstantiationException, "", new Object[0]);
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        y.printErrStackTrace("ChattingComponentFactory", localIllegalAccessException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.g.a
 * JD-Core Version:    0.7.0.1
 */