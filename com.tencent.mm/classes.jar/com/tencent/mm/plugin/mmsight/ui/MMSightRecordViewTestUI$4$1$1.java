package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;

final class MMSightRecordViewTestUI$4$1$1
  implements MMSightRecordView.h
{
  MMSightRecordViewTestUI$4$1$1(MMSightRecordViewTestUI.4.1 param1) {}
  
  public final void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(55120);
    Toast.makeText(this.oOn.oOm.oOk, "record finish, error: ".concat(String.valueOf(paramBoolean)), 0).show();
    AppMethodBeat.o(55120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.4.1.1
 * JD-Core Version:    0.7.0.1
 */