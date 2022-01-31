package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class fs
  extends gi
{
  private Intent b;
  
  public fs() {}
  
  public fs(fz paramfz)
  {
    super(paramfz);
  }
  
  public String getMessage()
  {
    AppMethodBeat.i(147962);
    if (this.b != null)
    {
      AppMethodBeat.o(147962);
      return "User needs to (re)enter credentials.";
    }
    String str = super.getMessage();
    AppMethodBeat.o(147962);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.fs
 * JD-Core Version:    0.7.0.1
 */