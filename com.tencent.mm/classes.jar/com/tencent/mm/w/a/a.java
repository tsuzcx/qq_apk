package com.tencent.mm.w.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a
{
  public final e a(Context paramContext, e.b paramb, int paramInt)
  {
    AppMethodBeat.i(124492);
    paramContext = new b(paramContext, paramb, paramInt);
    AppMethodBeat.o(124492);
    return paramContext;
  }
  
  public final int getPriority()
  {
    return 33;
  }
  
  public final int getType()
  {
    return 33;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.w.a.a
 * JD-Core Version:    0.7.0.1
 */