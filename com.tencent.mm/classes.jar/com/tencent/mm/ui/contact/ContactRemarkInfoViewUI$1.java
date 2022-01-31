package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bc.c;

final class ContactRemarkInfoViewUI$1
  implements View.OnClickListener
{
  ContactRemarkInfoViewUI$1(ContactRemarkInfoViewUI paramContactRemarkInfoViewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33687);
    if (!ContactRemarkInfoViewUI.a(this.AcA))
    {
      AppMethodBeat.o(33687);
      return;
    }
    paramView = new Intent(this.AcA, ContactRemarkImagePreviewUI.class);
    paramView.putExtra("Contact_User", ContactRemarkInfoViewUI.b(this.AcA));
    c.aiT();
    paramView.putExtra("remark_image_path", c.tU(ContactRemarkInfoViewUI.b(this.AcA)));
    paramView.putExtra("view_only", true);
    this.AcA.startActivity(paramView);
    AppMethodBeat.o(33687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoViewUI.1
 * JD-Core Version:    0.7.0.1
 */