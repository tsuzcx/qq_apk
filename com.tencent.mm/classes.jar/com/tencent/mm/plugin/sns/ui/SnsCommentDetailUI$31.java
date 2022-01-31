package com.tencent.mm.plugin.sns.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class SnsCommentDetailUI$31
  implements View.OnClickListener
{
  SnsCommentDetailUI$31(SnsCommentDetailUI paramSnsCommentDetailUI, n paramn, TextView paramTextView1, TextView paramTextView2, ImageView paramImageView1, ImageView paramImageView2) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.SnsCommentDetailUI", "showComment click" + SnsCommentDetailUI.F(this.oWW).getVisibility());
    paramView = this.oNX.bGe();
    if ((paramView != null) && (paramView.tNr.sPI == 21) && (!m.Nj(this.oNX.bGE())))
    {
      a.e(this.oWW.mController.uMN, this.oWW.oWS.yD(0));
      return;
    }
    if (SnsCommentDetailUI.F(this.oWW).getVisibility() == 0)
    {
      SnsCommentDetailUI.g(this.oWW);
      return;
    }
    SnsCommentDetailUI.F(this.oWW).setVisibility(0);
    SnsCommentDetailUI.F(this.oWW).startAnimation(SnsCommentDetailUI.G(this.oWW));
    if (SnsCommentDetailUI.C(this.oWW) == 10) {
      SnsCommentDetailUI.v(this.oWW).findViewById(i.f.album_comment_container).setBackgroundResource(i.e.friendactivity_comment_frame_bg_golden);
    }
    if (!v.OW(SnsCommentDetailUI.o(this.oWW)))
    {
      this.oWW.oWc.setEnabled(false);
      this.oWW.oWd.setEnabled(false);
      this.oXh.setText(this.oWW.getString(i.j.sns_like));
      this.oXh.setTextColor(this.oWW.getResources().getColor(i.c.sns_like_color));
      this.oXi.setTextColor(this.oWW.getResources().getColor(i.c.sns_like_color));
      if (SnsCommentDetailUI.C(this.oWW) == 10)
      {
        this.oXj.setImageResource(i.i.friendactivity_comment_likeicon_golden_normal);
        return;
      }
      this.oXj.setImageResource(i.i.friendactivity_comment_likeicon_normal);
      return;
    }
    this.oWW.oWc.setEnabled(true);
    this.oXj.setImageResource(i.e.friendactivity_comment_likeicon);
    this.oWW.oWd.setEnabled(true);
    this.oXh.setTextColor(this.oWW.getResources().getColor(i.c.white));
    this.oXi.setTextColor(this.oWW.getResources().getColor(i.c.white));
    paramView = h.OA(SnsCommentDetailUI.o(this.oWW));
    if (SnsCommentDetailUI.C(this.oWW) == 10)
    {
      this.oXj.setImageResource(i.e.lucky_friendactivity_comment_likeicon);
      this.oXk.setImageResource(i.e.lucky_friendactivity_comment_writeicon);
      this.oXh.setTextColor(this.oWW.getResources().getColor(i.c.sns_lucky_comment));
      this.oXi.setTextColor(this.oWW.getResources().getColor(i.c.sns_lucky_comment));
    }
    while (paramView.field_likeFlag == 0)
    {
      this.oXh.setText(this.oWW.getString(i.j.sns_like));
      return;
      this.oXj.setImageResource(i.e.friendactivity_comment_likeicon);
      this.oXh.setTextColor(this.oWW.getResources().getColor(i.c.white));
      this.oXi.setTextColor(this.oWW.getResources().getColor(i.c.white));
    }
    this.oXh.setText(this.oWW.getString(i.j.sns_has_liked));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.31
 * JD-Core Version:    0.7.0.1
 */