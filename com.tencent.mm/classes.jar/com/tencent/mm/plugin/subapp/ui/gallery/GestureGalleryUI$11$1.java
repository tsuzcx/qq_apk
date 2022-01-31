package com.tencent.mm.plugin.subapp.ui.gallery;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.ui.base.h.c;

final class GestureGalleryUI$11$1
  implements h.c
{
  GestureGalleryUI$11$1(GestureGalleryUI.11 param11) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(25385);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(25385);
      return;
      GestureGalleryUI.a(this.sYD.sYB, GestureGalleryUI.c(this.sYD.sYB));
      AppMethodBeat.o(25385);
      return;
      GestureGalleryUI localGestureGalleryUI = this.sYD.sYB;
      String str = GestureGalleryUI.c(this.sYD.sYB);
      if ((str == null) || (str.length() == 0))
      {
        AppMethodBeat.o(25385);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("Retr_File_Name", str);
      localIntent.putExtra("Retr_Msg_Type", 0);
      localIntent.putExtra("Retr_Compress_Type", 0);
      b.gmO.k(localIntent, localGestureGalleryUI.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.gallery.GestureGalleryUI.11.1
 * JD-Core Version:    0.7.0.1
 */