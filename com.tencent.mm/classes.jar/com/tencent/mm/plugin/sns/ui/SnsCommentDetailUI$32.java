package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsCommentDetailUI$32
  implements View.OnClickListener
{
  SnsCommentDetailUI$32(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, ImageView paramImageView2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38815);
    ab.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.E(this.rPu).getVisibility());
    paramView = this.rFG.csh();
    if ((paramView != null) && (paramView.xTS.wNZ == 21) && (!m.ZV(this.rFG.csH())))
    {
      a.f(this.rPu.getContext(), this.rPu.rPq.EJ(0));
      AppMethodBeat.o(38815);
      return;
    }
    if (SnsCommentDetailUI.E(this.rPu).getVisibility() == 0)
    {
      SnsCommentDetailUI.g(this.rPu);
      AppMethodBeat.o(38815);
      return;
    }
    SnsCommentDetailUI.E(this.rPu).setVisibility(0);
    SnsCommentDetailUI.E(this.rPu).startAnimation(SnsCommentDetailUI.G(this.rPu));
    if (SnsCommentDetailUI.C(this.rPu) == 10) {
      SnsCommentDetailUI.v(this.rPu).findViewById(2131821045).setBackgroundResource(2130838910);
    }
    if (!v.abQ(SnsCommentDetailUI.o(this.rPu)))
    {
      this.rPu.rOA.setEnabled(false);
      this.rPu.rOB.setEnabled(false);
      this.rPF.setText(this.rPu.getString(2131303873));
      this.rPF.setTextColor(this.rPu.getResources().getColor(2131690486));
      this.rPG.setTextColor(this.rPu.getResources().getColor(2131690486));
      if (SnsCommentDetailUI.C(this.rPu) == 10)
      {
        this.rPH.setImageResource(2131231356);
        AppMethodBeat.o(38815);
        return;
      }
      this.rPH.setImageResource(2131231359);
      AppMethodBeat.o(38815);
      return;
    }
    this.rPu.rOA.setEnabled(true);
    this.rPH.setImageResource(2130838914);
    this.rPu.rOB.setEnabled(true);
    this.rPF.setTextColor(this.rPu.getResources().getColor(2131690709));
    this.rPG.setTextColor(this.rPu.getResources().getColor(2131690709));
    paramView = h.abu(SnsCommentDetailUI.o(this.rPu));
    if (SnsCommentDetailUI.C(this.rPu) == 10)
    {
      this.rPH.setImageResource(2130839332);
      this.rPI.setImageResource(2130839333);
      this.rPF.setTextColor(this.rPu.getResources().getColor(2131690495));
      this.rPG.setTextColor(this.rPu.getResources().getColor(2131690495));
    }
    while (paramView.field_likeFlag == 0)
    {
      this.rPF.setText(this.rPu.getString(2131303873));
      AppMethodBeat.o(38815);
      return;
      this.rPH.setImageResource(2130838914);
      this.rPF.setTextColor(this.rPu.getResources().getColor(2131690709));
      this.rPG.setTextColor(this.rPu.getResources().getColor(2131690709));
    }
    this.rPF.setText(this.rPu.getString(2131303830));
    AppMethodBeat.o(38815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.32
 * JD-Core Version:    0.7.0.1
 */