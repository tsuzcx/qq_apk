package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.u;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;

final class SnsCommentFooter$7
  implements View.OnClickListener
{
  SnsCommentFooter$7(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98643);
    if (com.tencent.mm.m.g.ZY().getInt("SnsAdAtFriendRedDot", 0) == 1) {
      com.tencent.mm.kernel.g.agR().agA().set(ah.a.GSF, Boolean.FALSE);
    }
    SnsCommentFooter.g(this.yLl).setVisibility(8);
    paramView = new Intent();
    paramView.putExtra("list_attr", 16391);
    paramView.putExtra("block_contact", u.axw());
    paramView.putExtra("max_limit_num", 1);
    paramView.putExtra("titile", SnsCommentFooter.h(this.yLl).getString(2131763747));
    d.c(SnsCommentFooter.h(this.yLl), ".ui.contact.SelectContactUI", paramView, 2333);
    AppMethodBeat.o(98643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.7
 * JD-Core Version:    0.7.0.1
 */