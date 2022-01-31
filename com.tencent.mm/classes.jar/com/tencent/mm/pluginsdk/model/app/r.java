package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class r
{
  public String appId;
  public int fPp;
  
  public r(String paramString, int paramInt)
  {
    this.appId = paramString;
    this.fPp = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(79360);
    if (paramObject == null)
    {
      AppMethodBeat.o(79360);
      return false;
    }
    if (!(paramObject instanceof r))
    {
      AppMethodBeat.o(79360);
      return false;
    }
    paramObject = (r)paramObject;
    if ((paramObject.appId.equals(this.appId)) && (paramObject.fPp == this.fPp))
    {
      AppMethodBeat.o(79360);
      return true;
    }
    AppMethodBeat.o(79360);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(79361);
    String str = this.appId + this.fPp;
    AppMethodBeat.o(79361);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.r
 * JD-Core Version:    0.7.0.1
 */