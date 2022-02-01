package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class w
{
  public String appId;
  public int qvo;
  
  public w(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.qvo = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(151791);
    if (paramObject == null)
    {
      AppMethodBeat.o(151791);
      return false;
    }
    if (!(paramObject instanceof w))
    {
      AppMethodBeat.o(151791);
      return false;
    }
    paramObject = (w)paramObject;
    if ((paramObject.appId.equals(this.appId)) && (paramObject.qvo == this.qvo))
    {
      AppMethodBeat.o(151791);
      return true;
    }
    AppMethodBeat.o(151791);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151792);
    String str = this.appId + this.qvo;
    AppMethodBeat.o(151792);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.w
 * JD-Core Version:    0.7.0.1
 */