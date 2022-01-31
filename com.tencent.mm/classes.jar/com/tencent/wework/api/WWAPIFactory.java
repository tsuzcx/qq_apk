package com.tencent.wework.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWAPIFactory
{
  public static IWWAPI jO(Context paramContext)
  {
    AppMethodBeat.i(80490);
    paramContext = new WWAPIImpl(paramContext);
    AppMethodBeat.o(80490);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIFactory
 * JD-Core Version:    0.7.0.1
 */