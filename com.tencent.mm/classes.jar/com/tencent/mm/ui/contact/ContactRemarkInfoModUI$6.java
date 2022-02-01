package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h.d;

final class ContactRemarkInfoModUI$6
  implements h.d
{
  ContactRemarkInfoModUI$6(ContactRemarkInfoModUI paramContactRemarkInfoModUI) {}
  
  public final void oj(int paramInt)
  {
    AppMethodBeat.i(37755);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37755);
      return;
      Log.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
      Intent localIntent = new Intent();
      localIntent.putExtra("max_select_count", 1);
      localIntent.putExtra("query_source_type", 0);
      localIntent.putExtra("send_btn_string", " ");
      localIntent.addFlags(67108864);
      c.b(this.PVk, "gallery", ".ui.GalleryEntryUI", localIntent, 200);
      AppMethodBeat.o(37755);
      return;
      Log.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
      ContactRemarkInfoModUI.v(this.PVk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.6
 * JD-Core Version:    0.7.0.1
 */