package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sight.decode.ui.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class ak$2
  implements View.OnClickListener
{
  ak$2(ak paramak) {}
  
  public final void onClick(View paramView)
  {
    if (!e.bK(this.oTO.videoPath))
    {
      y.i("MicroMsg.SightWidget", "click videopath is not exist " + this.oTO.videoPath);
      return;
    }
    if (this.oTO.oTN != null)
    {
      this.oTO.oTN.dismiss();
      this.oTO.oTN = null;
    }
    this.oTO.oTN = new c(this.oTO.bER);
    paramView = this.oTO.oTN;
    String str1 = this.oTO.videoPath;
    String str2 = this.oTO.thumbPath;
    paramView.erh = str1;
    paramView.imagePath = str2;
    paramView = this.oTO.oTN;
    paramView.cbW = 0;
    paramView.ofb = 0;
    paramView.hkH = 1;
    this.oTO.oTN.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ak.2
 * JD-Core Version:    0.7.0.1
 */