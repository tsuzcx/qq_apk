package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s
{
  public String appId;
  public int jjN;
  
  public s(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.jjN = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(151791);
    if (paramObject == null)
    {
      AppMethodBeat.o(151791);
      return false;
    }
    if (!(paramObject instanceof s))
    {
      AppMethodBeat.o(151791);
      return false;
    }
    paramObject = (s)paramObject;
    if ((paramObject.appId.equals(this.appId)) && (paramObject.jjN == this.jjN))
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
    String str = this.appId + this.jjN;
    AppMethodBeat.o(151792);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.s
 * JD-Core Version:    0.7.0.1
 */