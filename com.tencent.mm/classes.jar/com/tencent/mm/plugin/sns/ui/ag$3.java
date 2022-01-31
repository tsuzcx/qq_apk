package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

final class ag$3
  extends v.a
{
  ag$3(ag paramag) {}
  
  public final void yx(int paramInt)
  {
    y.d("MicroMsg.PicWidget", "I click");
    if (paramInt < 0)
    {
      this.oSk.bHY();
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(this.oSk.bER, SnsUploadBrowseUI.class);
    localIntent.putExtra("sns_gallery_position", paramInt);
    localIntent.putExtra("sns_gallery_temp_paths", this.oSk.oSd.oSo);
    this.oSk.bER.startActivityForResult(localIntent, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag.3
 * JD-Core Version:    0.7.0.1
 */