package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class ag$1
  extends v.a
{
  ag$1(ag paramag) {}
  
  public final void ED(int paramInt)
  {
    AppMethodBeat.i(38476);
    ab.d("MicroMsg.PicWidget", "I click");
    if (paramInt < 0)
    {
      this.rKd.cuq();
      AppMethodBeat.o(38476);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.rKd.cmc, SnsUploadBrowseUI.class);
    localIntent.putExtra("sns_gallery_position", paramInt);
    localIntent.putExtra("sns_gallery_temp_paths", this.rKd.rJW.rKh);
    this.rKd.cmc.startActivityForResult(localIntent, 7);
    AppMethodBeat.o(38476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.1
 * JD-Core Version:    0.7.0.1
 */