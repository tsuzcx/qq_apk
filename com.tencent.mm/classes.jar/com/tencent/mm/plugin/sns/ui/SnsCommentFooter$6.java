package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;

final class SnsCommentFooter$6
  implements View.OnClickListener
{
  SnsCommentFooter$6(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38884);
    if (com.tencent.mm.m.g.Nq().getInt("SnsAdAtFriendRedDot", 0) == 1) {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLq, Boolean.FALSE);
    }
    SnsCommentFooter.g(this.rQk).setVisibility(8);
    paramView = new Intent();
    paramView.putExtra("list_attr", 16391);
    paramView.putExtra("block_contact", r.Zn());
    paramView.putExtra("max_limit_num", 1);
    paramView.putExtra("titile", SnsCommentFooter.h(this.rQk).getString(2131303746));
    d.b(SnsCommentFooter.h(this.rQk), ".ui.contact.SelectContactUI", paramView, 2333);
    AppMethodBeat.o(38884);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.6
 * JD-Core Version:    0.7.0.1
 */