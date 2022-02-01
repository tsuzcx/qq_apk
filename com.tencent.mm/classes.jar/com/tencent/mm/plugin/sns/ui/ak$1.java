package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

final class ak$1
  extends x.a
{
  ak$1(ak paramak) {}
  
  public final void Je(int paramInt)
  {
    AppMethodBeat.i(98155);
    ad.d("MicroMsg.PicWidget", "I click");
    if (paramInt < 0)
    {
      this.xqH.dzZ();
      AppMethodBeat.o(98155);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.xqH.imP, SnsUploadBrowseUI.class);
    localIntent.putExtra("sns_gallery_position", paramInt);
    localIntent.putExtra("sns_gallery_temp_paths", this.xqH.xqA.xqL);
    this.xqH.imP.startActivityForResult(localIntent, 7);
    AppMethodBeat.o(98155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.1
 * JD-Core Version:    0.7.0.1
 */