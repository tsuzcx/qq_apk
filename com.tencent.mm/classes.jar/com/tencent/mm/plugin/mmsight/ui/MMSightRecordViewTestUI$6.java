package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;

final class MMSightRecordViewTestUI$6
  implements View.OnClickListener
{
  MMSightRecordViewTestUI$6(MMSightRecordViewTestUI paramMMSightRecordViewTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55124);
    MMSightRecordViewTestUI.a(this.oOk).oGg.switchCamera();
    AppMethodBeat.o(55124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.6
 * JD-Core Version:    0.7.0.1
 */