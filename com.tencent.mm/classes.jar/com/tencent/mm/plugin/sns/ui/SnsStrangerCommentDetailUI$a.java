package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.cf.h;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.r;

final class SnsStrangerCommentDetailUI$a
  extends r<com.tencent.mm.plugin.sns.storage.j>
{
  private Activity bMV;
  private View.OnClickListener ifg = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (String)paramAnonymousView.getTag();
      y.d("MicroMsg.SnsStrangerCommentDetailUI", "onCommentClick:" + paramAnonymousView);
      Intent localIntent = new Intent();
      localIntent.putExtra("Contact_User", paramAnonymousView);
      com.tencent.mm.plugin.sns.c.a.eUR.d(localIntent, SnsStrangerCommentDetailUI.a.a(SnsStrangerCommentDetailUI.a.this));
    }
  };
  
  public SnsStrangerCommentDetailUI$a(SnsStrangerCommentDetailUI paramSnsStrangerCommentDetailUI, Activity paramActivity)
  {
    super(paramActivity, new com.tencent.mm.plugin.sns.storage.j());
    this.bMV = paramActivity;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new SnsStrangerCommentDetailUI.a.a(this);
      paramView = View.inflate(this.bMV, i.g.sns_stranger_comment_item, null);
      paramViewGroup.doU = ((ImageView)paramView.findViewById(i.f.sns_comment_avatar_iv));
      paramViewGroup.fuN = ((TextView)paramView.findViewById(i.f.sns_comment_content_tv));
      paramViewGroup.mYa = ((TextView)paramView.findViewById(i.f.sns_comment_nickname_tv));
      paramViewGroup.nMe = ((TextView)paramView.findViewById(i.f.sns_comment_source));
      paramViewGroup.igx = ((TextView)paramView.findViewById(i.f.sns_comment_time));
      paramViewGroup.pdM = ((ImageView)paramView.findViewById(i.f.sns_comment_heart_iv));
      paramView.setTag(paramViewGroup);
    }
    bsx localbsx;
    for (;;)
    {
      com.tencent.mm.plugin.sns.storage.j localj = (com.tencent.mm.plugin.sns.storage.j)getItem(paramInt);
      try
      {
        localbsx = (bsx)new bsx().aH(localj.field_curActionBuf);
        a.b.p(paramViewGroup.doU, localbsx.tAY);
        paramViewGroup.doU.setTag(localbsx.tAY);
        paramViewGroup.doU.setOnClickListener(this.ifg);
        if (localbsx.tJr != null)
        {
          localObject = localbsx.tJr;
          label194:
          paramViewGroup.mYa.setTag(localbsx.tAY);
          SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.d.j.a(this.bMV, (CharSequence)localObject, paramViewGroup.mYa.getTextSize());
          localSpannableString.setSpan(new SnsStrangerCommentDetailUI.a.2(this, localbsx.tAY), 0, ((String)localObject).length(), 33);
          paramViewGroup.mYa.setText(localSpannableString, TextView.BufferType.SPANNABLE);
          paramViewGroup.mYa.setOnTouchListener(new aa());
          if (localj.field_type != 3) {
            break label500;
          }
          paramViewGroup.fuN.setVisibility(0);
          paramViewGroup.pdM.setVisibility(8);
          y.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + localbsx.swS + "  time:" + localbsx.mPL + " timeFormatted:" + ay.k(this.bMV, localbsx.mPL * 1000L));
          paramViewGroup.fuN.setText(localbsx.kVs + " ");
          com.tencent.mm.pluginsdk.ui.d.j.h(paramViewGroup.fuN, 2);
          paramViewGroup.fuN.setVisibility(0);
        }
        for (;;)
        {
          if (!q.Gj().equals(localbsx.tAY)) {
            break label536;
          }
          paramViewGroup.nMe.setVisibility(8);
          paramViewGroup.igx.setText(ay.k(this.bMV, localbsx.mPL * 1000L));
          return paramView;
          paramViewGroup = (SnsStrangerCommentDetailUI.a.a)paramView.getTag();
          break;
          localObject = ((com.tencent.mm.plugin.sns.storage.j)this.uMg).field_talker;
          break label194;
          label500:
          paramViewGroup.fuN.setVisibility(8);
          paramViewGroup.pdM.setVisibility(0);
        }
        paramViewGroup.nMe.setVisibility(0);
      }
      catch (Exception paramViewGroup)
      {
        y.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", paramViewGroup, "", new Object[0]);
        return paramView;
      }
    }
    label536:
    Object localObject = paramViewGroup.nMe;
    switch (localbsx.swS)
    {
    }
    for (;;)
    {
      ((TextView)localObject).setText(this.pdJ.getString(i.j.sns_from_stranger));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.g(this.bMV, i.e.personactivity_notice_stranger_searchicon), null);
      break;
      ((TextView)localObject).setText(this.pdJ.getString(i.j.sns_from_shake));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.g(this.bMV, i.e.personactivity_notice_stranger_shakeicon), null);
      break;
      ((TextView)localObject).setText(this.pdJ.getString(i.j.sns_from_lbs));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.g(this.bMV, i.e.personactivity_notice_stranger_nearicon), null);
      break;
      ((TextView)localObject).setText(this.pdJ.getString(i.j.sns_from_bottle));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.g(this.bMV, i.e.personactivity_notice_stranger_bottleicon), null);
      break;
      ((TextView)localObject).setText(this.pdJ.getString(i.j.sns_from_qrcode));
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cb.a.g(this.bMV, i.e.personactivity_notice_stranger_codeicon), null);
      break;
    }
  }
  
  public final void yc()
  {
    k localk = af.bDK();
    String str = SnsStrangerCommentDetailUI.l(this.pdJ);
    long l = SnsStrangerCommentDetailUI.m(this.pdJ);
    str = k.bGo() + " where talker = " + h.fA(str) + " and  snsID = " + l + " and ( type = 3 or type = 5 )";
    y.v("MicroMsg.SnsCommentStorage", "comment sql:" + str);
    setCursor(localk.dXo.a(str, null, 0));
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.a
 * JD-Core Version:    0.7.0.1
 */