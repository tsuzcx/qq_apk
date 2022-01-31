package com.tencent.mm.z.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;

final class c$a
  implements a
{
  e eGt;
  v.b eGu;
  Context mContext;
  
  c$a(Context paramContext, e parame)
  {
    AppMethodBeat.i(115303);
    this.mContext = paramContext;
    this.eGt = parame;
    this.eGu = new v.b();
    AppMethodBeat.o(115303);
  }
  
  public final v.b Qx()
  {
    return this.eGu;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.z.c.c.a
 * JD-Core Version:    0.7.0.1
 */