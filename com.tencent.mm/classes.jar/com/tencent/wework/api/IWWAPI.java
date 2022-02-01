package com.tencent.wework.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;

public abstract interface IWWAPI
{
  public abstract boolean a(WWAppType paramWWAppType);
  
  public abstract boolean a(BaseMessage paramBaseMessage, WWAppType paramWWAppType);
  
  public abstract String b(WWAppType paramWWAppType);
  
  public abstract boolean keI();
  
  public static enum WWAppType
  {
    static
    {
      AppMethodBeat.i(210564);
      aicA = new WWAppType("WwAppTypeDefault", 0);
      aicB = new WWAppType("WwAppTypeWxwork", 1);
      aicC = new WWAppType("WwAppTypeLocal", 2);
      aicD = new WWAppType[] { aicA, aicB, aicC };
      AppMethodBeat.o(210564);
    }
    
    private WWAppType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.IWWAPI
 * JD-Core Version:    0.7.0.1
 */