package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R.l;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class FavRecordDetailUI$2$1
  implements n.c
{
  FavRecordDetailUI$2$1(FavRecordDetailUI.2 param2) {}
  
  public final void a(l paraml)
  {
    y.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[] { Integer.valueOf(FavRecordDetailUI.b(this.ntG.ntD).field_id), Integer.valueOf(FavRecordDetailUI.b(this.ntG.ntD).field_itemStatus) });
    if ((FavRecordDetailUI.b(this.ntG.ntD).field_id > 0) && (!FavRecordDetailUI.b(this.ntG.ntD).aPZ()) && (!FavRecordDetailUI.b(this.ntG.ntD).aQa()) && (FavRecordDetailUI.c(this.ntG.ntD))) {
      paraml.e(0, this.ntG.ntD.getString(R.l.favorite_share_with_friend));
    }
    paraml.e(5, this.ntG.ntD.getString(R.l.favorite_save_as_note));
    paraml.e(3, this.ntG.ntD.getString(R.l.favorite_edit_tag_tips));
    paraml.e(2, this.ntG.ntD.getString(R.l.app_delete));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.1
 * JD-Core Version:    0.7.0.1
 */