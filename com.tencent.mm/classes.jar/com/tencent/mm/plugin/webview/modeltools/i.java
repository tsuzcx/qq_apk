package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.is;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class i
  extends is
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(79202);
    info = is.aJm();
    AppMethodBeat.o(79202);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.i
 * JD-Core Version:    0.7.0.1
 */