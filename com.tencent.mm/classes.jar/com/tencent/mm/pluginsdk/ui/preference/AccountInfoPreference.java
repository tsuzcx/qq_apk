package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.q;

public class AccountInfoPreference
  extends Preference
{
  public SpannableString shX;
  public String shY;
  private int shZ;
  public View.OnClickListener sia = null;
  public String userName;
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AccountInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    Object localObject = (ImageView)paramView.findViewById(R.h.avatar_iv);
    if ((this.userName != null) && (localObject != null) && (g.DK())) {
      a.b.a((ImageView)localObject, this.userName);
    }
    NoMeasuredTextView localNoMeasuredTextView = (NoMeasuredTextView)paramView.findViewById(R.h.nick_name_tv);
    if ((this.userName != null) && (localNoMeasuredTextView != null))
    {
      localNoMeasuredTextView.setShouldEllipsize(true);
      localNoMeasuredTextView.setTextSize(0, a.aa(this.mContext, R.f.NormalTextSize));
      localNoMeasuredTextView.setTextColor(a.h(this.mContext, R.e.normal_text_color));
      if (this.shX == null)
      {
        localObject = this.userName;
        localNoMeasuredTextView.setText((CharSequence)localObject);
      }
    }
    else
    {
      localObject = (TextView)paramView.findViewById(R.h.user_name_tv);
      if ((this.shY == null) || (localObject == null)) {
        break label249;
      }
      ((TextView)localObject).setText(paramView.getResources().getString(R.l.app_account, new Object[] { this.shY }));
      label162:
      localObject = (TextView)paramView.findViewById(R.h.right_prospect);
      if (localObject != null)
      {
        if (this.shZ <= 99) {
          break label262;
        }
        ((TextView)localObject).setText(this.mContext.getString(R.l.tab_msg_tip_over));
        ((TextView)localObject).setBackgroundResource(q.hh(this.mContext));
        ((TextView)localObject).setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.sia != null) {
        ((ImageView)paramView.findViewById(R.h.account_info_qr_code)).setOnClickListener(this.sia);
      }
      return;
      localObject = this.shX;
      break;
      label249:
      if (localObject == null) {
        break label162;
      }
      ((TextView)localObject).setVisibility(8);
      break label162;
      label262:
      if (this.shZ > 0)
      {
        ((TextView)localObject).setText(this.shZ);
        ((TextView)localObject).setVisibility(0);
      }
      else
      {
        ((TextView)localObject).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference
 * JD-Core Version:    0.7.0.1
 */