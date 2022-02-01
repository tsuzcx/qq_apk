package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h.d;

final class ContactRemarkInfoModUI$7
  implements h.d
{
  ContactRemarkInfoModUI$7(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(286144);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(286144);
      return;
      Log.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
      Intent localIntent = new Intent();
      localIntent.putExtra("max_select_count", 1);
      localIntent.putExtra("query_source_type", 0);
      localIntent.putExtra("send_btn_string", " ");
      localIntent.addFlags(67108864);
      c.b(this.XrY, "gallery", ".ui.GalleryEntryUI", localIntent, 200);
      AppMethodBeat.o(286144);
      return;
      Log.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
      ContactRemarkInfoModUI.z(this.XrY);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.7
 * JD-Core Version:    0.7.0.1
 */