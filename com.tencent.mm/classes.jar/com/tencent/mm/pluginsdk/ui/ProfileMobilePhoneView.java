package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;

public class ProfileMobilePhoneView
  extends ProfileItemView
{
  public TextView haW;
  private Context mContext;
  public String saA;
  public String saB;
  public String[] saC;
  public LinearLayout saJ;
  public boolean saK = false;
  
  public ProfileMobilePhoneView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ProfileMobilePhoneView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  @Deprecated
  public final boolean P(ad paramad)
  {
    return false;
  }
  
  public final boolean bsP()
  {
    Object localObject;
    if (this.haW != null)
    {
      localObject = this.haW.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = a.aa(getContext(), R.f.FixedTitleWidth);
      this.haW.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.saJ == null) {
      return false;
    }
    int k;
    if ((!bk.bl(this.saA)) && (bk.aaa(this.saA).booleanValue()))
    {
      localObject = this.saJ.getChildAt(0);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        ((TextView)localObject).setText(this.saA);
      }
      k = 1;
    }
    int j;
    for (int i = 1;; i = 0)
    {
      if (bk.bl(this.saB)) {
        break label287;
      }
      this.saC = this.saB.split(",");
      setVisibility(0);
      for (;;)
      {
        j = i;
        if (i >= this.saC.length + k) {
          break;
        }
        localObject = this.saJ.getChildAt(i);
        if (localObject != null)
        {
          ((View)localObject).setVisibility(0);
          ((TextView)localObject).setText(this.saC[(i - k)]);
        }
        i += 1;
      }
      if ((this.saA != null) && (!bk.aaa(this.saA).booleanValue())) {
        y.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[] { this.saA });
      }
      k = 0;
    }
    for (;;)
    {
      if (j < 5)
      {
        this.saJ.getChildAt(j).setVisibility(8);
        j += 1;
      }
      else
      {
        if ((k == 1) || (!bk.bl(this.saB))) {
          break;
        }
        setVisibility(8);
        return false;
        label287:
        j = i;
      }
    }
  }
  
  public int getLayout()
  {
    return R.i.profile_mobile_phone_layout;
  }
  
  public final void init()
  {
    this.haW = ((TextView)findViewById(R.h.phone_list_title));
    this.saJ = ((LinearLayout)findViewById(R.h.phone_list));
    int i = 0;
    while (i < 5)
    {
      this.saJ.getChildAt(i).setOnClickListener(new ProfileMobilePhoneView.1(this));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView
 * JD-Core Version:    0.7.0.1
 */