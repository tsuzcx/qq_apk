package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsStrangerCommentDetailUI$a$1
  implements View.OnClickListener
{
  SnsStrangerCommentDetailUI$a$1(SnsStrangerCommentDetailUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(39322);
    paramView = (String)paramView.getTag();
    ab.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:".concat(String.valueOf(paramView)));
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", paramView);
    a.gmO.c(localIntent, SnsStrangerCommentDetailUI.a.a(this.rWy));
    AppMethodBeat.o(39322);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a.1
 * JD-Core Version:    0.7.0.1
 */