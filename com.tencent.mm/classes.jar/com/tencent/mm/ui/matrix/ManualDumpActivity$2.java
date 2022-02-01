package com.tencent.mm.ui.matrix;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.ui.base.h;

final class ManualDumpActivity$2
  implements View.OnLongClickListener
{
  ManualDumpActivity$2(ManualDumpActivity paramManualDumpActivity) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(38864);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/matrix/ManualDumpActivity$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
    ClipboardHelper.setText(ManualDumpActivity.a(this.QmI).getText().toString());
    h.cD(this.QmI, this.QmI.getString(2131755773));
    a.a(true, this, "com/tencent/mm/ui/matrix/ManualDumpActivity$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(38864);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.ManualDumpActivity.2
 * JD-Core Version:    0.7.0.1
 */