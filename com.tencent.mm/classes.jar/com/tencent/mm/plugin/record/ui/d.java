package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.List;

public final class d
  extends h
{
  private static HashMap<String, Boolean> ntv = new HashMap();
  public p ntw = new d.1(this);
  
  public d(Context paramContext, h.a parama)
  {
    super(paramContext, parama);
  }
  
  public final void a(a parama)
  {
    y.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[] { Long.valueOf(((b)parama).khA.field_localId), Integer.valueOf(((b)parama).khA.field_itemStatus) });
    this.ntO = parama;
    this.ntu.clear();
    this.ntu.addAll(parama.ntu);
    notifyDataSetChanged();
  }
  
  public final void d(com.tencent.mm.plugin.record.ui.a.b paramb)
  {
    y.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[] { Long.valueOf(((b)this.ntO).khA.field_localId) });
    paramb.fromScene = 1;
    paramb.aYU = 1;
    paramb.khA = ((b)this.ntO).khA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d
 * JD-Core Version:    0.7.0.1
 */