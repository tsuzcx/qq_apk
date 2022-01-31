package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;

final class d$1
  implements p
{
  d$1(d paramd) {}
  
  public final void d(c paramc)
  {
    b localb = (b)this.ntx.ntO;
    if (paramc.field_favLocalId != localb.khA.field_localId)
    {
      y.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", new Object[] { Long.valueOf(paramc.field_favLocalId), Long.valueOf(localb.khA.field_localId) });
      return;
    }
    y.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[] { Long.valueOf(paramc.field_favLocalId), paramc.field_dataId, Integer.valueOf(paramc.field_status) });
    if (4 == paramc.field_status) {
      d.aYI().put(bk.aM(paramc.field_dataId, "null"), Boolean.valueOf(true));
    }
    if (paramc.isFinished()) {
      this.ntx.ntK.post(new d.1.1(this, paramc));
    }
    this.ntx.bvK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.d.1
 * JD-Core Version:    0.7.0.1
 */