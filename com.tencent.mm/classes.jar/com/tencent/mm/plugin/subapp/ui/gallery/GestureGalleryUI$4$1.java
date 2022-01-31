package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;

final class GestureGalleryUI$4$1
  implements h.c
{
  GestureGalleryUI$4$1(GestureGalleryUI.4 param4) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    }
    GestureGalleryUI localGestureGalleryUI;
    String str;
    do
    {
      return;
      GestureGalleryUI.a(this.pwP.pwN, GestureGalleryUI.c(this.pwP.pwN));
      return;
      localGestureGalleryUI = this.pwP.pwN;
      str = GestureGalleryUI.c(this.pwP.pwN);
    } while ((str == null) || (str.length() == 0));
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", str);
    localIntent.putExtra("Retr_Msg_Type", 0);
    localIntent.putExtra("Retr_Compress_Type", 0);
    b.eUR.l(localIntent, localGestureGalleryUI.mController.uMN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.4.1
 * JD-Core Version:    0.7.0.1
 */