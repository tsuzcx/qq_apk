package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ContactRemarkImagePreviewUI$3
  implements AdapterView.OnItemClickListener
{
  ContactRemarkImagePreviewUI$3(ContactRemarkImagePreviewUI paramContactRemarkImagePreviewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(37739);
    if (!this.IuE.isTitleShowing())
    {
      this.IuE.showTitleView();
      AppMethodBeat.o(37739);
      return;
    }
    this.IuE.hideTitleView();
    AppMethodBeat.o(37739);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.3
 * JD-Core Version:    0.7.0.1
 */