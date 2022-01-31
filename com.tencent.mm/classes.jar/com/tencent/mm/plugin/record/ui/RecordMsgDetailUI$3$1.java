package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class RecordMsgDetailUI$3$1
  implements n.c
{
  RecordMsgDetailUI$3$1(RecordMsgDetailUI.3 param3) {}
  
  public final void a(l paraml)
  {
    paraml.e(0, this.nua.ntZ.getString(R.l.favorite_share_with_friend));
    if (this.nua.ntZ.getIntent().getIntExtra("from_scene", 0) == 0) {
      paraml.e(2, this.nua.ntZ.getString(R.l.plugin_favorite_opt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3.1
 * JD-Core Version:    0.7.0.1
 */