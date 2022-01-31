package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactListCustomPreference
  extends Preference
{
  int background = -1;
  View.OnClickListener nuB;
  private View rod;
  private final View.OnTouchListener sde = new ContactListCustomPreference.1(this);
  
  public ContactListCustomPreference(Context paramContext)
  {
    super(paramContext);
    setLayoutResource(a.f.mm_preference_contact_list_custom);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setLayoutResource(a.f.mm_preference_contact_list_custom);
  }
  
  public ContactListCustomPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(a.f.mm_preference_contact_list_custom);
  }
  
  public final void onBindView(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    if ((this.rod != null) && (this.rod != null))
    {
      localViewGroup.removeAllViews();
      if (this.rod.getParent() != null) {
        ((ViewGroup)this.rod.getParent()).removeAllViews();
      }
      localViewGroup.addView(this.rod);
      if (this.nuB == null) {
        break label85;
      }
      localViewGroup.setOnClickListener(this.nuB);
    }
    for (;;)
    {
      if (this.background >= 0) {
        paramView.setBackgroundResource(this.background);
      }
      return;
      label85:
      localViewGroup.setOnTouchListener(this.sde);
    }
  }
  
  public final void setCustomView(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.rod = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ContactListCustomPreference
 * JD-Core Version:    0.7.0.1
 */