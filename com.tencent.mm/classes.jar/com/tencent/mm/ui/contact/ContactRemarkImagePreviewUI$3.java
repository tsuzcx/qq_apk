package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ContactRemarkImagePreviewUI$3
  implements AdapterView.OnItemClickListener
{
  ContactRemarkImagePreviewUI$3(ContactRemarkImagePreviewUI paramContactRemarkImagePreviewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(37739);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/ui/contact/ContactRemarkImagePreviewUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    if (!this.PUD.isTitleShowing()) {
      this.PUD.showTitleView();
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/ui/contact/ContactRemarkImagePreviewUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(37739);
      return;
      this.PUD.hideTitleView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.3
 * JD-Core Version:    0.7.0.1
 */