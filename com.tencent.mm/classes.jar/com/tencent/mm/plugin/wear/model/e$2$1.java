package com.tencent.mm.plugin.wear.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.e.j;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f.c;
import java.io.UnsupportedEncodingException;

final class e$2$1
  extends c
{
  e$2$1(e.2 param2) {}
  
  public final String getName()
  {
    return "SendMsgSyncTask";
  }
  
  public final void send()
  {
    AppMethodBeat.i(26297);
    try
    {
      a.cYy();
      r.a(20007, a.cYy().uGC.uGU.uHI.getBytes("utf8"), false);
      AppMethodBeat.o(26297);
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      AppMethodBeat.o(26297);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.2.1
 * JD-Core Version:    0.7.0.1
 */