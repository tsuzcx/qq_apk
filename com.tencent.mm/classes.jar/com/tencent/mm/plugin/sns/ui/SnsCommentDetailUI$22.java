package com.tencent.mm.plugin.sns.ui;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

final class SnsCommentDetailUI$22
  implements ay.b.a
{
  SnsCommentDetailUI$22(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void p(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(203516);
    Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, getContactCallBack, userName=" + paramString + ", succ=" + paramBoolean + ", retryCount=" + this.ECd.ECa);
    new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(203515);
        if ((paramBoolean) && (!SnsCommentDetailUI.22.this.ECd.isFinishing()) && (SnsCommentDetailUI.22.this.ECd.ECa < 5))
        {
          Log.i("MicroMsg.SnsCommentDetailUI", "setAvatar, setHeader after getContact, userName=" + paramString);
          SnsCommentDetailUI.22.this.ECd.fhP();
        }
        SnsCommentDetailUI localSnsCommentDetailUI = SnsCommentDetailUI.22.this.ECd;
        localSnsCommentDetailUI.ECa += 1;
        AppMethodBeat.o(203515);
      }
    }, 500L);
    AppMethodBeat.o(203516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.22
 * JD-Core Version:    0.7.0.1
 */