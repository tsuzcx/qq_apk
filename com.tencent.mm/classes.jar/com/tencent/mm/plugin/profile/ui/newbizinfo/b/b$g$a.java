package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class b$g$a
  implements View.OnClickListener
{
  b$g$a(b.g paramg, dor paramdor) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(169911);
    Object localObject = new b();
    ((b)localObject).bn(paramView);
    a.c("com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
    paramView = (CharSequence)this.HfQ.jump_url;
    if ((paramView == null) || (paramView.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramView = new Intent();
        paramView.putExtra("rawUrl", this.HfQ.jump_url);
        localObject = this.HfP.HeO.fqR();
        p.j(localObject, "widget.contact");
        paramView.putExtra("geta8key_username", ((as)localObject).getUsername());
        com.tencent.mm.by.c.b(this.HfP.context, "webview", ".ui.tools.WebViewUI", paramView);
        paramView = this.HfP.HeO.fqR();
        p.j(paramView, "widget.contact");
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(paramView.getUsername(), 1402, this.HfP.HeO.fqU(), this.HfP.HeO.amU());
      }
      a.a(this, "com/tencent/mm/plugin/profile/ui/newbizinfo/model/NewBizInfoAdapterInterpolator$VideoChannelViewHolder$fillVideoChannel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(169911);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.b.b.g.a
 * JD-Core Version:    0.7.0.1
 */