package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.c.e.a;
import com.tencent.mm.plugin.i.a.h;
import com.tencent.mm.protocal.protobuf.bcl;

public final class t
{
  private static e Aer;
  private static String TAG;
  
  static
  {
    AppMethodBeat.i(163379);
    TAG = "Finder.ChattingItemAppMsgFinderTopic";
    e.a locala = new e.a();
    locala.hZJ = true;
    locala.hZI = true;
    Aer = locala.aJT();
    AppMethodBeat.o(163379);
  }
  
  private static bcl s(k.b paramb)
  {
    AppMethodBeat.i(233703);
    paramb = (h)paramb.as(h.class);
    if (paramb != null)
    {
      paramb = paramb.jld;
      AppMethodBeat.o(233703);
      return paramb;
    }
    AppMethodBeat.o(233703);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t
 * JD-Core Version:    0.7.0.1
 */