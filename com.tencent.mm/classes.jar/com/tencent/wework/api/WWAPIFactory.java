package com.tencent.wework.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WWAPIFactory
{
  public static IWWAPI kS(Context paramContext)
  {
    AppMethodBeat.i(106526);
    paramContext = new WWAPIImpl(paramContext);
    AppMethodBeat.o(106526);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wework.api.WWAPIFactory
 * JD-Core Version:    0.7.0.1
 */