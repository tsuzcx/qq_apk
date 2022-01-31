package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.y;

final class SnsTimeLineUI$51$1
  implements View.OnClickListener
{
  SnsTimeLineUI$51$1(SnsTimeLineUI.51 param51, String paramString) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.SnsTimeLineUI", "collapse tips click");
    paramView = new Intent(this.pfP.pfC, SnsCommentDetailUI.class);
    paramView.putExtra("INTENT_TALKER", this.pfP.oNX.field_userName);
    paramView.putExtra("INTENT_SNS_LOCAL_ID", this.pfP.oNX.oLk);
    paramView.putExtra("INTENT_FROMGALLERY", false);
    paramView.putExtra("intent_show_collapse_info", true);
    paramView.putExtra("intent_content_collapse_hint", this.pfO);
    this.pfP.pfC.startActivity(paramView);
    i.gn(this.pfP.oYr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.51.1
 * JD-Core Version:    0.7.0.1
 */