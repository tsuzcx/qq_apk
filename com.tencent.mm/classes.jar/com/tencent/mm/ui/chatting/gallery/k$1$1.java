package com.tencent.mm.ui.chatting.gallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.io.File;

final class k$1$1
  implements Runnable
{
  k$1$1(k.1 param1, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(32378);
    if (bo.isNullOrNil(this.hZn))
    {
      h.h(this.zNM.zNL.zKg.zJK, 2131304519, 2131298283);
      AppMethodBeat.o(32378);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    com.tencent.mm.sdk.platformtools.k.a(this.zNM.zNL.zKg.zJK, localIntent, new File(this.hZn), "video/*");
    try
    {
      this.zNM.zNL.zKg.zJK.startActivity(Intent.createChooser(localIntent, this.zNM.zNL.zKg.zJK.getContext().getString(2131299853)));
      AppMethodBeat.o(32378);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ImageGalleryViewHolder", "startActivity fail, activity not found");
      h.h(this.zNM.zNL.zKg.zJK, 2131299759, 2131299760);
      AppMethodBeat.o(32378);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.k.1.1
 * JD-Core Version:    0.7.0.1
 */