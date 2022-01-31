package com.tencent.mm.ui.contact;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class ContactRemarkImagePreviewUI$3
  implements AdapterView.OnItemClickListener
{
  ContactRemarkImagePreviewUI$3(ContactRemarkImagePreviewUI paramContactRemarkImagePreviewUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.vKp.mController.isTitleShowing())
    {
      this.vKp.mController.showTitleView();
      return;
    }
    this.vKp.mController.hideTitleView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI.3
 * JD-Core Version:    0.7.0.1
 */