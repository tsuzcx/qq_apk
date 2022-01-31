package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ak;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.n;

final class SnsCommentDetailUI$9
  implements View.OnClickListener
{
  SnsCommentDetailUI$9(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38786);
    if (this.rFG.Ex(32))
    {
      AppMethodBeat.o(38786);
      return;
    }
    ak.DP(this.rFG.rCV);
    ak.DN(this.rFG.rCV);
    ag.cpb().cnP();
    paramView = new Intent();
    this.rPu.setResult(-1, paramView);
    if (SnsCommentDetailUI.s(this.rPu)) {
      paramView.putExtra("sns_gallery_force_finish", true);
    }
    this.rPu.finish();
    this.rPu.finish();
    AppMethodBeat.o(38786);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.9
 * JD-Core Version:    0.7.0.1
 */