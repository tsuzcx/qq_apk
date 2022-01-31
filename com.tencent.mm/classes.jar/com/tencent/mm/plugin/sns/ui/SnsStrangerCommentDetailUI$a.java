package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.p;

final class SnsStrangerCommentDetailUI$a
  extends p<com.tencent.mm.plugin.sns.storage.j>
{
  private Activity cup;
  private View.OnClickListener jVW;
  
  public SnsStrangerCommentDetailUI$a(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI, Activity paramActivity)
  {
    super(paramActivity, new com.tencent.mm.plugin.sns.storage.j());
    AppMethodBeat.i(39324);
    this.jVW = new SnsStrangerCommentDetailUI.a.1(this);
    this.cup = paramActivity;
    AppMethodBeat.o(39324);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(39326);
    k localk = ag.cpk();
    String str = SnsStrangerCommentDetailUI.l(this.rWw);
    long l = SnsStrangerCommentDetailUI.m(this.rWw);
    str = k.csr() + " where talker = " + h.escape(str) + " and  snsID = " + l + " and ( type = 3 or type = 5 )";
    ab.v("MicroMsg.SnsCommentStorage", "comment sql:".concat(String.valueOf(str)));
    setCursor(localk.fnw.a(str, null, 0));
    AppMethodBeat.o(39326);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(39327);
    Ku();
    AppMethodBeat.o(39327);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(39325);
    com.tencent.mm.plugin.sns.storage.j localj;
    if (paramView == null)
    {
      paramViewGroup = new SnsStrangerCommentDetailUI.a.a(this);
      paramView = View.inflate(this.cup, 2130970869, null);
      paramViewGroup.egq = ((ImageView)paramView.findViewById(2131828095));
      paramViewGroup.gMp = ((TextView)paramView.findViewById(2131828097));
      paramViewGroup.pAN = ((TextView)paramView.findViewById(2131828096));
      paramViewGroup.qzL = ((TextView)paramView.findViewById(2131828099));
      paramViewGroup.timeTv = ((TextView)paramView.findViewById(2131828100));
      paramViewGroup.rWz = ((ImageView)paramView.findViewById(2131828098));
      paramView.setTag(paramViewGroup);
      localj = (com.tencent.mm.plugin.sns.storage.j)getItem(paramInt);
    }
    Object localObject;
    for (;;)
    {
      try
      {
        localcdm = (cdm)new cdm().parseFrom(localj.field_curActionBuf);
        a.b.u(paramViewGroup.egq, localcdm.xCG);
        paramViewGroup.egq.setTag(localcdm.xCG);
        paramViewGroup.egq.setOnClickListener(this.jVW);
        if (localcdm.xNV == null) {
          continue;
        }
        localObject = localcdm.xNV;
        paramViewGroup.pAN.setTag(localcdm.xCG);
        SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.d.j.b(this.cup, (CharSequence)localObject, paramViewGroup.pAN.getTextSize());
        localSpannableString.setSpan(new SnsStrangerCommentDetailUI.a.2(this, localcdm.xCG), 0, ((String)localObject).length(), 33);
        paramViewGroup.pAN.setText(localSpannableString, TextView.BufferType.SPANNABLE);
        paramViewGroup.pAN.setOnTouchListener(new aa());
        if (localj.field_type != 3) {
          continue;
        }
        paramViewGroup.gMp.setVisibility(0);
        paramViewGroup.rWz.setVisibility(8);
        ab.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + localcdm.niK + "  time:" + localcdm.CreateTime + " timeFormatted:" + ax.l(this.cup, localcdm.CreateTime * 1000L));
        paramViewGroup.gMp.setText(localcdm.ntu + " ");
        com.tencent.mm.pluginsdk.ui.d.j.k(paramViewGroup.gMp, 2);
        paramViewGroup.gMp.setVisibility(0);
        if (!r.Zn().equals(localcdm.xCG)) {
          continue;
        }
        paramViewGroup.qzL.setVisibility(8);
        paramViewGroup.timeTv.setText(ax.l(this.cup, localcdm.CreateTime * 1000L));
      }
      catch (Exception paramViewGroup)
      {
        cdm localcdm;
        ab.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", paramViewGroup, "", new Object[0]);
        continue;
        paramViewGroup.qzL.setVisibility(0);
        localObject = paramViewGroup.qzL;
        switch (localcdm.niK)
        {
        }
      }
      AppMethodBeat.o(39325);
      return paramView;
      paramViewGroup = (SnsStrangerCommentDetailUI.a.a)paramView.getTag();
      break;
      localObject = ((com.tencent.mm.plugin.sns.storage.j)this.zan).field_talker;
      continue;
      paramViewGroup.gMp.setVisibility(8);
      paramViewGroup.rWz.setVisibility(0);
    }
    for (;;)
    {
      ((TextView)localObject).setText(this.rWw.getString(2131303823));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, a.k(this.cup, 2130839934), null);
      break;
      ((TextView)localObject).setText(this.rWw.getString(2131303822));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, a.k(this.cup, 2130839935), null);
      break;
      ((TextView)localObject).setText(this.rWw.getString(2131303820));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, a.k(this.cup, 2130839933), null);
      break;
      ((TextView)localObject).setText(this.rWw.getString(2131303819));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, a.k(this.cup, 2130839931), null);
      break;
      ((TextView)localObject).setText(this.rWw.getString(2131303821));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, a.k(this.cup, 2130839932), null);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a
 * JD-Core Version:    0.7.0.1
 */