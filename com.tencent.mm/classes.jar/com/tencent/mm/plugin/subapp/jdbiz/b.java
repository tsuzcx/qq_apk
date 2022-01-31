package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public String path;
  public String username;
  public int version;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(153649);
    if (!bo.isNullOrNil(this.username))
    {
      AppMethodBeat.o(153649);
      return true;
    }
    AppMethodBeat.o(153649);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(153650);
    String str = "{username:" + this.username + ",path:" + this.path + ",version:" + this.version + "}";
    AppMethodBeat.o(153650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.b
 * JD-Core Version:    0.7.0.1
 */