package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.sns.i.j;
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
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (com.tencent.mm.n.h.axc().getInt("SnsAdAtFriendRedDot", 0) == 1) {
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VwG, Boolean.FALSE);
    }
    SnsCommentFooter.g(this.KQR).setVisibility(8);
    paramView = new Intent();
    paramView.putExtra("list_attr", 16391);
    paramView.putExtra("block_contact", z.bcZ());
    paramView.putExtra("max_limit_num", 1);
    paramView.putExtra("titile", SnsCommentFooter.h(this.KQR).getString(i.j.sns_ad_comment_at_title));
    c.d(SnsCommentFooter.h(this.KQR), ".ui.contact.SelectContactUI", paramView, 2333);
    a.a(this, "com/tencent/mm/plugin/sns/ui/SnsCommentFooter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(98643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.9
 * JD-Core Version:    0.7.0.1
 */