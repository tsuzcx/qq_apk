package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.b;

final class FavRecordDetailUI$3
  implements Runnable
{
  FavRecordDetailUI$3(FavRecordDetailUI paramFavRecordDetailUI, Dialog paramDialog) {}
  
  public final void run()
  {
    AppMethodBeat.i(24208);
    this.mwd.dismiss();
    b.l(this.pZl, this.pZl.getString(2131299979));
    AppMethodBeat.o(24208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.3
 * JD-Core Version:    0.7.0.1
 */