package com.tencent.wework.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wework.api.model.BaseMessage;

public abstract interface IWWAPI
{
  public abstract boolean a(WWAppType paramWWAppType);
  
  public abstract boolean a(BaseMessage paramBaseMessage, WWAppType paramWWAppType);
  
  public abstract String b(WWAppType paramWWAppType);
  
  public abstract boolean ivm();
  
  public static enum WWAppType
  {
    static
    {
      AppMethodBeat.i(233270);
      ZYb = new WWAppType("WwAppTypeDefault", 0);
      ZYc = new WWAppType("WwAppTypeWxwork", 1);
      ZYd = new WWAppType("WwAppTypeLocal", 2);
      ZYe = new WWAppType[] { ZYb, ZYc, ZYd };
      AppMethodBeat.o(233270);
    }
    
    private WWAppType() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.IWWAPI
 * JD-Core Version:    0.7.0.1
 */