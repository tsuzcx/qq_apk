package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsTimeLineUI$60$1
  implements View.OnClickListener
{
  SnsTimeLineUI$60$1(SnsTimeLineUI.60 param60, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(155765);
    ab.d("MicroMsg.SnsTimeLineUI", "collapse tips click");
    paramView = new Intent(this.rYO.rYv, SnsCommentDetailUI.class);
    paramView.putExtra("INTENT_TALKER", this.rYO.rFG.field_userName);
    paramView.putExtra("INTENT_SNS_LOCAL_ID", this.rYO.rFG.rCV);
    paramView.putExtra("INTENT_FROMGALLERY", false);
    paramView.putExtra("intent_show_collapse_info", true);
    paramView.putExtra("intent_content_collapse_hint", this.rYN);
    this.rYO.rYv.startActivity(paramView);
    i.lT(this.rYO.rQK);
    AppMethodBeat.o(155765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.60.1
 * JD-Core Version:    0.7.0.1
 */