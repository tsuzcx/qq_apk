package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsCommentDetailUI$37
  implements View.OnClickListener
{
  SnsCommentDetailUI$37(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38822);
    paramView = (String)paramView.getTag();
    ab.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:".concat(String.valueOf(paramView)));
    Intent localIntent = new Intent();
    com.tencent.mm.plugin.sns.storage.n localn = SnsCommentDetailUI.e(this.rPu);
    if ((localn != null) && (localn.Ex(32)))
    {
      i.a(new SnsAdClick(SnsCommentDetailUI.f(this.rPu), 2, localn.field_snsId, 1, 0));
      localIntent.putExtra("Contact_User", paramView);
      localIntent.putExtra("Contact_Scene", 37);
      a.gmO.c(localIntent, this.rPu);
      AppMethodBeat.o(38822);
      return;
    }
    localIntent.putExtra("Contact_User", paramView);
    a.gmO.c(localIntent, this.rPu);
    AppMethodBeat.o(38822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.37
 * JD-Core Version:    0.7.0.1
 */