package com.tencent.mm.w.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.e.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ao;
import java.util.HashSet;

public final class b
  extends com.tencent.mm.plugin.fts.ui.a
{
  public b(Context paramContext, e.b paramb, int paramInt)
  {
    super(paramContext, paramb, paramInt);
  }
  
  public final com.tencent.mm.plugin.fts.a.a.a a(ao paramao, HashSet<String> paramHashSet)
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt1, int paramInt2, m paramm, e.a parama)
  {
    AppMethodBeat.i(127651);
    c localc = new c(paramInt2);
    localc.jPN = paramm;
    localc.sxM = parama.sxM;
    localc.fP(paramm.type, paramm.sxF);
    AppMethodBeat.o(127651);
    return localc;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a a(int paramInt, e.a parama)
  {
    return null;
  }
  
  public final void a(k paramk, HashSet<String> paramHashSet) {}
  
  public final int getType()
  {
    return 33;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.w.a.b
 * JD-Core Version:    0.7.0.1
 */