package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

final class SnsInfoFlip$1
  implements MMGestureGallery.f
{
  SnsInfoFlip$1(SnsInfoFlip paramSnsInfoFlip, Context paramContext) {}
  
  public final void aBS()
  {
    if ((this.val$context instanceof SnsBrowseUI))
    {
      ((SnsBrowseUI)this.val$context).aBR();
      return;
    }
    if (SnsInfoFlip.a(this.oZi))
    {
      ((MMActivity)this.val$context).finish();
      return;
    }
    SnsInfoFlip.c(this.oZi).post(new SnsInfoFlip.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.1
 * JD-Core Version:    0.7.0.1
 */