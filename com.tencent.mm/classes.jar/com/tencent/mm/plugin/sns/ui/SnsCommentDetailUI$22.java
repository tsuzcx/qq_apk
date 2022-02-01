package com.tencent.mm.plugin.sns.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

final class SnsCommentDetailUI$22
  implements ar.b.a
{
  SnsCommentDetailUI$22(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void p(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(200492);
    ac.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + paramString + ", succ=" + paramBoolean + ", retryCount=" + this.yKq.yKn);
    new ao(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200491);
        if ((paramBoolean) && (!SnsCommentDetailUI.22.this.yKq.isFinishing()) && (SnsCommentDetailUI.22.this.yKq.yKn < 5))
        {
          ac.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + paramString);
          SnsCommentDetailUI.22.this.yKq.dPt();
        }
        SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.22.this.yKq;
        localSnsCommentDetailUI.yKn += 1;
        AppMethodBeat.o(200491);
      }
    }, 500L);
    AppMethodBeat.o(200492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.22
 * JD-Core Version:    0.7.0.1
 */