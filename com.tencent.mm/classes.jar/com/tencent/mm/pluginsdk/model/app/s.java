package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class s
{
  public String appId;
  public int ilN;
  
  public s(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.ilN = paramInt;
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
    if ((paramObject.appId.equals(this.appId)) && (paramObject.ilN == this.ilN))
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
    String str = this.appId + this.ilN;
    AppMethodBeat.o(151792);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.s
 * JD-Core Version:    0.7.0.1
 */