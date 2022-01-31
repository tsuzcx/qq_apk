package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import java.util.Set;

public final class dt
  extends dq
{
  private final en<String, dq> a;
  
  public dt()
  {
    AppMethodBeat.i(147501);
    this.a = new en();
    AppMethodBeat.o(147501);
  }
  
  public final dq a(String paramString)
  {
    AppMethodBeat.i(147504);
    paramString = (dq)this.a.a(paramString);
    AppMethodBeat.o(147504);
    return paramString;
  }
  
  public final Set<Map.Entry<String, dq>> a()
  {
    AppMethodBeat.i(147503);
    Set localSet = this.a.entrySet();
    AppMethodBeat.o(147503);
    return localSet;
  }
  
  public final void a(String paramString, dq paramdq)
  {
    AppMethodBeat.i(147502);
    Object localObject = paramdq;
    if (paramdq == null) {
      localObject = ds.a;
    }
    this.a.a(paramString, localObject);
    AppMethodBeat.o(147502);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(147505);
    if ((paramObject == this) || (((paramObject instanceof dt)) && (((dt)paramObject).a.equals(this.a))))
    {
      AppMethodBeat.o(147505);
      return true;
    }
    AppMethodBeat.o(147505);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(147506);
    int i = this.a.hashCode();
    AppMethodBeat.o(147506);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.dt
 * JD-Core Version:    0.7.0.1
 */