package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.preference.Preference;

public class DomainMailListPreference
  extends Preference
{
  private TextView eXr;
  private boolean jAt;
  private String title;
  private String vLb;
  private TextView vLc;
  private TextView vLd;
  private TextView vLe;
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public DomainMailListPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.jAt = false;
    this.title = "";
    this.vLb = "";
  }
  
  public final void onBindView(View paramView)
  {
    this.eXr = ((TextView)paramView.findViewById(R.h.title));
    this.vLc = ((TextView)paramView.findViewById(R.h.firstDomainMail));
    this.vLd = ((TextView)paramView.findViewById(R.h.secondDomainMail));
    this.vLe = ((TextView)paramView.findViewById(R.h.thirdDomainMail));
    this.jAt = true;
    if (!this.jAt)
    {
      y.e("MicroMsg.DomainMailPreference", "initView : unbind view");
      super.onBindView(paramView);
      return;
    }
    this.eXr.setText(ah.pm(this.title));
    String[] arrayOfString = this.vLb.split(";");
    if (ah.pm(this.vLb).length() <= 0)
    {
      this.vLc.setVisibility(8);
      this.vLd.setVisibility(8);
    }
    label174:
    label243:
    label253:
    for (;;)
    {
      this.vLe.setVisibility(8);
      break;
      if (arrayOfString.length > 0)
      {
        this.vLc.setVisibility(0);
        this.vLc.setText(ah.pm(arrayOfString[0]));
        if (arrayOfString.length <= 1) {
          break label243;
        }
        this.vLd.setVisibility(0);
        this.vLd.setText(ah.pm(arrayOfString[1]));
      }
      for (;;)
      {
        if (arrayOfString.length <= 2) {
          break label253;
        }
        this.vLe.setVisibility(0);
        this.vLe.setText(ah.pm(arrayOfString[2]));
        break;
        this.vLc.setVisibility(8);
        break label174;
        this.vLd.setVisibility(8);
      }
    }
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_domainmaillist, localViewGroup);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.DomainMailListPreference
 * JD-Core Version:    0.7.0.1
 */