package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.autogen.a.ht.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.record.ui.a.b;

public final class i
{
  public static String a(b paramb)
  {
    AppMethodBeat.i(27800);
    ht localht = new ht();
    localht.hIR.type = 2;
    localht.hIR.hIT = paramb.hIy;
    localht.publish();
    paramb = localht.hIS.path;
    AppMethodBeat.o(27800);
    return paramb;
  }
  
  public static String b(b paramb)
  {
    AppMethodBeat.i(27801);
    ht localht = new ht();
    localht.hIR.type = 2;
    localht.hIR.hIT = paramb.hIy;
    localht.publish();
    paramb = localht.hIS.thumbPath;
    AppMethodBeat.o(27801);
    return paramb;
  }
  
  public static boolean c(b paramb)
  {
    AppMethodBeat.i(27802);
    ht localht = new ht();
    localht.hIR.type = 14;
    localht.hIR.hIT = paramb.hIy;
    localht.publish();
    if (localht.hIS.ret == 1)
    {
      AppMethodBeat.o(27802);
      return true;
    }
    AppMethodBeat.o(27802);
    return false;
  }
  
  public static g to(long paramLong)
  {
    AppMethodBeat.i(27803);
    g localg = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
    AppMethodBeat.o(27803);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.i
 * JD-Core Version:    0.7.0.1
 */