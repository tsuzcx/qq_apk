package com.tencent.mm.plugin.sns.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.sdk.platformtools.ak;

final class SnsCommentDetailUI$19
  implements ao.b.a
{
  SnsCommentDetailUI$19(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(38799);
    new ak(Looper.getMainLooper()).postDelayed(new SnsCommentDetailUI.19.1(this, paramBoolean), 500L);
    AppMethodBeat.o(38799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.19
 * JD-Core Version:    0.7.0.1
 */