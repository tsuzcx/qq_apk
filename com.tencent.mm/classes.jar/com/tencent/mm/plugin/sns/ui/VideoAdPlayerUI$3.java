package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;

final class VideoAdPlayerUI$3
  implements View.OnClickListener
{
  VideoAdPlayerUI$3(VideoAdPlayerUI paramVideoAdPlayerUI) {}
  
  public final void onClick(View paramView)
  {
    VideoAdPlayerUI localVideoAdPlayerUI = this.pkW;
    if (VideoAdPlayerUI.k(this.pkW)) {}
    for (paramView = VideoAdPlayerUI.l(this.pkW);; paramView = VideoAdPlayerUI.m(this.pkW))
    {
      h.a(localVideoAdPlayerUI, null, paramView, null, new h.c()
      {
        public final void gl(int paramAnonymousInt)
        {
          switch (paramAnonymousInt)
          {
          default: 
            return;
          case 0: 
            Intent localIntent = new Intent();
            localIntent.putExtra("Select_Conv_Type", 3);
            localIntent.putExtra("select_is_ret", true);
            localIntent.putExtra("mutil_select_is_ret", true);
            localIntent.putExtra("ad_video_title", VideoAdPlayerUI.n(VideoAdPlayerUI.3.this.pkW));
            localIntent.putExtra("Retr_Msg_Type", 2);
            d.c(VideoAdPlayerUI.3.this.pkW, ".ui.transmit.SelectConversationUI", localIntent, 4097);
            return;
          case 1: 
            VideoAdPlayerUI.o(VideoAdPlayerUI.3.this.pkW);
            return;
          }
          VideoAdPlayerUI.p(VideoAdPlayerUI.3.this.pkW);
        }
      });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.3
 * JD-Core Version:    0.7.0.1
 */