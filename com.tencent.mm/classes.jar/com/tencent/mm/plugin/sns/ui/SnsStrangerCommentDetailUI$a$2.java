package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.d.o;

final class SnsStrangerCommentDetailUI$a$2
  extends o
{
  SnsStrangerCommentDetailUI$a$2(SnsStrangerCommentDetailUI.a parama, Object paramObject)
  {
    super(paramObject, null);
  }
  
  public final void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramView.getTag().toString());
    a.eUR.d(localIntent, SnsStrangerCommentDetailUI.a.a(this.pdL));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a.2
 * JD-Core Version:    0.7.0.1
 */