package com.tencent.mm.plugin.subapp.jdbiz;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  public String path;
  public String username;
  public int version;
  
  public final boolean isValid()
  {
    AppMethodBeat.i(28867);
    if (!Util.isNullOrNil(this.username))
    {
      AppMethodBeat.o(28867);
      return true;
    }
    AppMethodBeat.o(28867);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(28868);
    String str = "{username:" + this.username + ",path:" + this.path + ",version:" + this.version + "}";
    AppMethodBeat.o(28868);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.jdbiz.b
 * JD-Core Version:    0.7.0.1
 */