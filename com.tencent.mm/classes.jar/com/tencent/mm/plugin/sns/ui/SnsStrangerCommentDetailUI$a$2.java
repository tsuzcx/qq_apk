package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.n;
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
    AppMethodBeat.i(39323);
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramView.getTag().toString());
    a.gmO.c(localIntent, SnsStrangerCommentDetailUI.a.a(this.rWy));
    AppMethodBeat.o(39323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a.2
 * JD-Core Version:    0.7.0.1
 */