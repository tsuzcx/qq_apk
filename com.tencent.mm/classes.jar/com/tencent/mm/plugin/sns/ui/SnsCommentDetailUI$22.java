package com.tencent.mm.plugin.sns.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

final class SnsCommentDetailUI$22
  implements as.b.a
{
  SnsCommentDetailUI$22(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void p(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(198324);
    ad.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + paramString + ", succ=" + paramBoolean + ", retryCount=" + this.AbL.AbI);
    new ap(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(198323);
        if ((paramBoolean) && (!SnsCommentDetailUI.22.this.AbL.isFinishing()) && (SnsCommentDetailUI.22.this.AbL.AbI < 5))
        {
          ad.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + paramString);
          SnsCommentDetailUI.22.this.AbL.ebK();
        }
        SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.22.this.AbL;
        localSnsCommentDetailUI.AbI += 1;
        AppMethodBeat.o(198323);
      }
    }, 500L);
    AppMethodBeat.o(198324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.22
 * JD-Core Version:    0.7.0.1
 */