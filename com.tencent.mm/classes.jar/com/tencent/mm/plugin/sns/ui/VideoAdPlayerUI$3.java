package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.d;

final class VideoAdPlayerUI$3
  implements View.OnClickListener
{
  VideoAdPlayerUI$3(VideoAdPlayerUI paramVideoAdPlayerUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99789);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = this.RGs;
    if (VideoAdPlayerUI.k(this.RGs)) {}
    for (paramView = VideoAdPlayerUI.l(this.RGs);; paramView = VideoAdPlayerUI.m(this.RGs))
    {
      k.a((Context)localObject, null, paramView, null, new k.d()
      {
        public final void qz(int paramAnonymousInt)
        {
          AppMethodBeat.i(99788);
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(99788);
            return;
            Intent localIntent = new Intent();
            localIntent.putExtra("Select_Conv_Type", 3);
            localIntent.putExtra("select_is_ret", true);
            localIntent.putExtra("mutil_select_is_ret", true);
            localIntent.putExtra("ad_video_title", VideoAdPlayerUI.n(VideoAdPlayerUI.3.this.RGs));
            localIntent.putExtra("Retr_Msg_Type", 2);
            c.d(VideoAdPlayerUI.3.this.RGs, ".ui.transmit.SelectConversationUI", localIntent, 4097);
            AppMethodBeat.o(99788);
            return;
            VideoAdPlayerUI.o(VideoAdPlayerUI.3.this.RGs);
            AppMethodBeat.o(99788);
            return;
            VideoAdPlayerUI.p(VideoAdPlayerUI.3.this.RGs);
          }
        }
      });
      a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(99789);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI.3
 * JD-Core Version:    0.7.0.1
 */