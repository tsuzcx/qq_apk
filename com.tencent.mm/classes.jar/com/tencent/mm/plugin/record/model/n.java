package com.tencent.mm.plugin.record.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.pluginsdk.model.app.ar.a;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.storage.cc;

public final class n
  implements g
{
  public final boolean a(Context paramContext, cc paramcc, dl paramdl)
  {
    AppMethodBeat.i(305335);
    boolean bool = d.b(paramContext, paramcc, paramdl);
    AppMethodBeat.o(305335);
    return bool;
  }
  
  public final boolean g(String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(27805);
    boolean bool = q.b(q.lh(paramString1, paramString2), paramLong, true);
    AppMethodBeat.o(27805);
    return bool;
  }
  
  public final void tm(long paramLong)
  {
    AppMethodBeat.i(27804);
    as.iIL();
    ar.a.tm(paramLong);
    AppMethodBeat.o(27804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.n
 * JD-Core Version:    0.7.0.1
 */