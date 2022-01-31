package com.tencent.mm.plugin.record.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class FavRecordDetailUI$2$1
  implements n.c
{
  FavRecordDetailUI$2$1(FavRecordDetailUI.2 param2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(24203);
    ab.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[] { Integer.valueOf(FavRecordDetailUI.b(this.pZo.pZl).field_id), Integer.valueOf(FavRecordDetailUI.b(this.pZo.pZl).field_itemStatus) });
    if ((FavRecordDetailUI.b(this.pZo.pZl).field_id > 0) && (!FavRecordDetailUI.b(this.pZo.pZl).bwo()) && (!FavRecordDetailUI.b(this.pZo.pZl).bwp()) && (FavRecordDetailUI.c(this.pZo.pZl))) {
      paraml.e(0, this.pZo.pZl.getString(2131299826));
    }
    paraml.e(5, this.pZo.pZl.getString(2131299814));
    paraml.e(3, this.pZo.pZl.getString(2131299703));
    paraml.e(2, this.pZo.pZl.getString(2131296901));
    AppMethodBeat.o(24203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.1
 * JD-Core Version:    0.7.0.1
 */