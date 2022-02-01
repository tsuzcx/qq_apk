package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.u;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.MMActivity;

final class SnsCommentFooter$7
  implements View.OnClickListener
{
  SnsCommentFooter$7(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98643);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (com.tencent.mm.n.g.acA().getInt("SnsAdAtFriendRedDot", 0) == 1) {
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IFk, Boolean.FALSE);
    }
    SnsCommentFooter.g(this.AcH).setVisibility(8);
    paramView = new Intent();
    paramView.putExtra("list_attr", 16391);
    paramView.putExtra("block_contact", u.aAm());
    paramView.putExtra("max_limit_num", 1);
    paramView.putExtra("titile", SnsCommentFooter.h(this.AcH).getString(2131763747));
    d.c(SnsCommentFooter.h(this.AcH), ".ui.contact.SelectContactUI", paramView, 2333);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(98643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7
 * JD-Core Version:    0.7.0.1
 */