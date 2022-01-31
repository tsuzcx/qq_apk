package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.y;

final class SnsCommentDetailUI$35
  implements View.OnClickListener
{
  SnsCommentDetailUI$35(SnsCommentDetailUI paramSnsCommentDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    y.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:" + paramView);
    Intent localIntent = new Intent();
    n localn = SnsCommentDetailUI.e(this.oWW);
    if (localn.yr(32))
    {
      i.a(new SnsAdClick(SnsCommentDetailUI.f(this.oWW), 2, localn.field_snsId, 1, 0));
      localIntent.putExtra("Contact_User", paramView);
      localIntent.putExtra("Contact_Scene", 37);
      a.eUR.d(localIntent, this.oWW);
      return;
    }
    localIntent.putExtra("Contact_User", paramView);
    a.eUR.d(localIntent, this.oWW);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.35
 * JD-Core Version:    0.7.0.1
 */