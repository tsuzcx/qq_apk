package com.tencent.mm.plugin.sns.ui.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.bj;
import com.tencent.mm.protocal.protobuf.TimeLineObject;

final class c$22
  implements View.OnClickListener
{
  c$22(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(100232);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    if ((paramView.getTag() instanceof bj))
    {
      paramView = (bj)paramView.getTag();
      localObject = al.hgB().aZK(paramView.hQX);
      if (localObject == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(100232);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("sns_text_show", ((SnsInfo)localObject).getTimeLine().ContentDesc);
      paramView.putExtra("sns_local_id", ((SnsInfo)localObject).getLocalid());
      paramView.putExtra("sns_content_source", 1);
      paramView.setClass(c.f(this.RQM), SnsSingleTextViewUI.class);
      localObject = c.f(this.RQM);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(localObject, paramView.aYi(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Activity)localObject).startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(100232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.listener.c.22
 * JD-Core Version:    0.7.0.1
 */