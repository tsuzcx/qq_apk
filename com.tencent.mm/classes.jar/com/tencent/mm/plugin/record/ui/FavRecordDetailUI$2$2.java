package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;

final class FavRecordDetailUI$2$2
  implements n.d
{
  FavRecordDetailUI$2$2(FavRecordDetailUI.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    switch (paramMenuItem.getItemId())
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Select_Conv_Type", 3);
      paramMenuItem.putExtra("scene_from", 1);
      paramMenuItem.putExtra("mutil_select_is_ret", true);
      paramMenuItem.putExtra("select_fav_local_id", FavRecordDetailUI.b(this.ntG.ntD).field_localId);
      d.c(this.ntG.ntD, ".ui.transmit.SelectConversationUI", paramMenuItem, 4097);
      com.tencent.mm.plugin.fav.a.h.f(FavRecordDetailUI.b(this.ntG.ntD).field_localId, 1, 0);
      return;
    case 2: 
      com.tencent.mm.ui.base.h.a(this.ntG.ntD.mController.uMN, this.ntG.ntD.getString(R.l.app_delete_tips), "", new FavRecordDetailUI.2.2.1(this), null);
      return;
    case 3: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 2);
      paramMenuItem.putExtra("key_fav_item_id", FavRecordDetailUI.a(this.ntG.ntD));
      b.a(this.ntG.ntD.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      return;
    case 4: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_scene", 1);
      paramMenuItem.putExtra("key_fav_item_id", FavRecordDetailUI.b(this.ntG.ntD).field_localId);
      b.a(this.ntG.ntD.mController.uMN, ".ui.FavTagEditUI", paramMenuItem);
      return;
    }
    com.tencent.mm.plugin.fav.ui.g.a(this.ntG.ntD, FavRecordDetailUI.a(this.ntG.ntD), FavRecordDetailUI.d(this.ntG.ntD));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2
 * JD-Core Version:    0.7.0.1
 */