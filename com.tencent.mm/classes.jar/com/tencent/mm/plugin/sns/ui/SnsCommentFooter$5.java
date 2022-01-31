package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.MMActivity;

final class SnsCommentFooter$5
  implements View.OnClickListener
{
  SnsCommentFooter$5(SnsCommentFooter paramSnsCommentFooter) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("list_attr", 16391);
    paramView.putExtra("block_contact", q.Gj());
    paramView.putExtra("max_limit_num", 1);
    paramView.putExtra("titile", SnsCommentFooter.j(this.oXQ).getString(i.j.sns_ad_comment_at_title));
    d.c(SnsCommentFooter.j(this.oXQ), ".ui.contact.SelectContactUI", paramView, 2333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentFooter.5
 * JD-Core Version:    0.7.0.1
 */