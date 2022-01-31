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
    AppMethodBeat.i(33617);
    if (!this.AbP.isTitleShowing())
    {
      this.AbP.showTitleView();
      AppMethodBeat.o(33617);
      return;
    }
    this.AbP.hideTitleView();
    AppMethodBeat.o(33617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.3
 * JD-Core Version:    0.7.0.1
 */