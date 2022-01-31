package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

final class SnsInfoFlip$1
  implements MMGestureGallery.f
{
  SnsInfoFlip$1(SnsInfoFlip paramSnsInfoFlip, Context paramContext) {}
  
  public final void bdW()
  {
    AppMethodBeat.i(38967);
    if ((this.val$context instanceof SnsBrowseUI))
    {
      ((SnsBrowseUI)this.val$context).bdV();
      AppMethodBeat.o(38967);
      return;
    }
    if (SnsInfoFlip.a(this.rRB))
    {
      ((MMActivity)this.val$context).finish();
      AppMethodBeat.o(38967);
      return;
    }
    SnsInfoFlip.c(this.rRB).post(new SnsInfoFlip.1.1(this));
    AppMethodBeat.o(38967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.1
 * JD-Core Version:    0.7.0.1
 */