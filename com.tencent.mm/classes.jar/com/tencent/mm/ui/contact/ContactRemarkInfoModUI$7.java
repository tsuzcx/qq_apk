package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;

final class ContactRemarkInfoModUI$7
  implements h.c
{
  ContactRemarkInfoModUI$7(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      y.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
      Intent localIntent = new Intent();
      localIntent.putExtra("max_select_count", 1);
      localIntent.putExtra("query_source_type", 0);
      localIntent.putExtra("send_btn_string", " ");
      localIntent.addFlags(67108864);
      d.b(this.vKT, "gallery", ".ui.GalleryEntryUI", localIntent, 200);
      return;
    }
    y.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
    ContactRemarkInfoModUI.w(this.vKT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.7
 * JD-Core Version:    0.7.0.1
 */