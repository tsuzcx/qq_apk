package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.n.f;
import com.tencent.mm.n.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;

final class SnsCommentFooter$9
  implements View.OnClickListener
{
  SnsCommentFooter$9(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98643);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (h.aqJ().getInt("SnsAdAtFriendRedDot", 0) == 1) {
      g.aAh().azQ().set(ar.a.Oiq, Boolean.FALSE);
    }
    SnsCommentFooter.g(this.EDc).setVisibility(8);
    paramView = new Intent();
    paramView.putExtra("list_attr", 16391);
    paramView.putExtra("block_contact", z.aTY());
    paramView.putExtra("max_limit_num", 1);
    paramView.putExtra("titile", SnsCommentFooter.h(this.EDc).getString(2131765940));
    c.c(SnsCommentFooter.h(this.EDc), ".ui.contact.SelectContactUI", paramView, 2333);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(98643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.9
 * JD-Core Version:    0.7.0.1
 */