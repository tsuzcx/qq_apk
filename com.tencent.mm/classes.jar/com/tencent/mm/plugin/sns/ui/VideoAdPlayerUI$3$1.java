package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.base.h.c;

final class VideoAdPlayerUI$3$1
  implements h.c
{
  VideoAdPlayerUI$3$1(VideoAdPlayerUI.3 param3) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(39913);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(39913);
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("Select_Conv_Type", 3);
      localIntent.putExtra("select_is_ret", true);
      localIntent.putExtra("mutil_select_is_ret", true);
      localIntent.putExtra("ad_video_title", VideoAdPlayerUI.n(this.sdm.sdl));
      localIntent.putExtra("Retr_Msg_Type", 2);
      d.b(this.sdm.sdl, ".ui.transmit.SelectConversationUI", localIntent, 4097);
      AppMethodBeat.o(39913);
      return;
      VideoAdPlayerUI.o(this.sdm.sdl);
      AppMethodBeat.o(39913);
      return;
      VideoAdPlayerUI.p(this.sdm.sdl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.3.1
 * JD-Core Version:    0.7.0.1
 */