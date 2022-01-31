package com.tencent.mm.plugin.mmsight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.sdk.platformtools.al;

final class MMSightRecordViewTestUI$4
  implements View.OnClickListener
{
  MMSightRecordViewTestUI$4(MMSightRecordViewTestUI paramMMSightRecordViewTestUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(55122);
    MMSightRecordViewTestUI.a(this.oOk).oGg.EC();
    al.p(new MMSightRecordViewTestUI.4.1(this), 5000L);
    AppMethodBeat.o(55122);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.MMSightRecordViewTestUI.4
 * JD-Core Version:    0.7.0.1
 */