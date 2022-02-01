package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.span.p;

final class SnsStrangerCommentDetailUI$a$2
  extends p
{
  SnsStrangerCommentDetailUI$a$2(SnsStrangerCommentDetailUI.a parama, Object paramObject)
  {
    super(paramObject, null);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99151);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramView.getTag().toString());
    a.iRG.c(localIntent, SnsStrangerCommentDetailUI.a.a(this.Ajn));
    AppMethodBeat.o(99151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a.2
 * JD-Core Version:    0.7.0.1
 */