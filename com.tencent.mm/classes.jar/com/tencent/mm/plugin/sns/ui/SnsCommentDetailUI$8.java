package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.n;

final class SnsCommentDetailUI$8
  implements View.OnClickListener
{
  SnsCommentDetailUI$8(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void onClick(View paramView)
  {
    if (this.oNX.yr(32)) {
      return;
    }
    aj.xP(this.oNX.oLk);
    aj.xN(this.oNX.oLk);
    af.bDB().bCp();
    paramView = new Intent();
    this.oWW.setResult(-1, paramView);
    if (SnsCommentDetailUI.s(this.oWW)) {
      paramView.putExtra("sns_gallery_force_finish", true);
    }
    this.oWW.finish();
    this.oWW.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.8
 * JD-Core Version:    0.7.0.1
 */