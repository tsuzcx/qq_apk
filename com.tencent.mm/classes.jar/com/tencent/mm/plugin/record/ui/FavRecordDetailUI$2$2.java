package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.ui.base.n.d;

final class FavRecordDetailUI$2$2
  implements n.d
{
  FavRecordDetailUI$2$2(FavRecordDetailUI.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(24206);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(24206);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", FavRecordDetailUI.b(this.pZo.pZl).field_localId);
      d.b(this.pZo.pZl, ".ui.transmit.SelectConversationUI", paramMenuItem, 4097);
      com.tencent.mm.plugin.fav.a.h.i(FavRecordDetailUI.b(this.pZo.pZl).field_localId, 1, 0);
      AppMethodBeat.o(24206);
      return;
      com.tencent.mm.ui.base.h.a(this.pZo.pZl.getContext(), this.pZo.pZl.getString(2131296902), "", new FavRecordDetailUI.2.2.1(this), null);
      AppMethodBeat.o(24206);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavRecordDetailUI.a(this.pZo.pZl));
      b.b(this.pZo.pZl.getContext(), ".ui.FavTagEditUI", paramMenuItem);
      AppMethodBeat.o(24206);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 1);
      paramMenuItem.putExtra("key_fav_item_id", FavRecordDetailUI.b(this.pZo.pZl).field_localId);
      b.b(this.pZo.pZl.getContext(), ".ui.FavTagEditUI", paramMenuItem);
      AppMethodBeat.o(24206);
      return;
      com.tencent.mm.plugin.fav.ui.g.a(this.pZo.pZl, FavRecordDetailUI.a(this.pZo.pZl), FavRecordDetailUI.d(this.pZo.pZl));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */