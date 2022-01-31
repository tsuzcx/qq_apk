package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import com.tencent.mm.R.l;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavRecordDetailUI$3
  implements Runnable
{
  FavRecordDetailUI$3(FavRecordDetailUI paramFavRecordDetailUI, Dialog paramDialog) {}
  
  public final void run()
  {
    this.kbH.dismiss();
    b.h(this.ntD, this.ntD.getString(R.l.finish_sent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.3
 * JD-Core Version:    0.7.0.1
 */