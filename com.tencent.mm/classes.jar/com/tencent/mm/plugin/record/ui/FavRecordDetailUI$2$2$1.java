package com.tencent.mm.plugin.record.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;

final class FavRecordDetailUI$2$2$1
  implements DialogInterface.OnClickListener
{
  FavRecordDetailUI$2$2$1(FavRecordDetailUI.2.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(24205);
    paramDialogInterface = h.b(this.pZp.pZo.pZl.getContext(), this.pZp.pZo.pZl.getString(2131296902), false, null);
    gi localgi = new gi();
    localgi.cuX.type = 12;
    localgi.cuX.cpM = FavRecordDetailUI.a(this.pZp.pZo.pZl);
    localgi.cuX.cvc = new FavRecordDetailUI.2.2.1.1(this, paramDialogInterface);
    a.ymk.l(localgi);
    AppMethodBeat.o(24205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.FavRecordDetailUI.2.2.1
 * JD-Core Version:    0.7.0.1
 */