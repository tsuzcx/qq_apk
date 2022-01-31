package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.List;

public final class d
  extends h
{
  private static HashMap<String, Boolean> pZc;
  public p pZd;
  
  static
  {
    AppMethodBeat.i(24200);
    pZc = new HashMap();
    AppMethodBeat.o(24200);
  }
  
  public d(Context paramContext, h.a parama)
  {
    super(paramContext, parama);
    AppMethodBeat.i(24197);
    this.pZd = new d.1(this);
    AppMethodBeat.o(24197);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(24198);
    ab.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[] { Long.valueOf(((b)parama).mCk.field_localId), Integer.valueOf(((b)parama).mCk.field_itemStatus) });
    this.pZv = parama;
    this.pZa.clear();
    this.pZa.addAll(parama.pZa);
    notifyDataSetChanged();
    AppMethodBeat.o(24198);
  }
  
  public final void d(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    AppMethodBeat.i(24199);
    ab.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[] { Long.valueOf(((b)this.pZv).mCk.field_localId) });
    paramb.fromScene = 1;
    paramb.dataType = 1;
    paramb.mCk = ((b)this.pZv).mCk;
    AppMethodBeat.o(24199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d
 * JD-Core Version:    0.7.0.1
 */