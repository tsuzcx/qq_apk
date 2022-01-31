package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.cb.a;
import com.tencent.mm.ui.base.preference.Preference;

public class ContactMoreInfoPreference
  extends Preference
{
  private TextView iuO;
  private ImageView mVU;
  private ImageView mVV;
  private ImageView mVW;
  private ImageView mVX;
  private ImageView mVY;
  private ImageView mVZ;
  private int mWa = 8;
  private int mWb = 8;
  private int mWc = 8;
  private int mWd = 8;
  private int mWe = 8;
  private int mWf = 8;
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ContactMoreInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setLayoutResource(R.i.mm_preference);
  }
  
  private void aZ()
  {
    if (this.mVU != null) {
      this.mVU.setVisibility(this.mWa);
    }
    if (this.mVV != null) {
      this.mVV.setVisibility(this.mWb);
    }
    if (this.mVW != null) {
      this.mVW.setVisibility(this.mWc);
    }
    if (this.mVX != null) {
      this.mVX.setVisibility(this.mWd);
    }
    if (this.mVY != null) {
      this.mVY.setVisibility(this.mWe);
    }
    if (this.iuO != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.iuO.getLayoutParams();
      localLayoutParams.width = a.aa(this.mContext, R.f.FixedTitleWidth);
      this.iuO.setLayoutParams(localLayoutParams);
    }
    if (this.mVZ != null) {
      this.mVZ.setVisibility(this.mWf);
    }
  }
  
  public final void onBindView(View paramView)
  {
    this.mVU = ((ImageView)paramView.findViewById(R.h.image_mobile));
    this.mVV = ((ImageView)paramView.findViewById(R.h.image_qq));
    this.mVW = ((ImageView)paramView.findViewById(R.h.image_linkedin));
    this.mVX = ((ImageView)paramView.findViewById(R.h.image_facebook));
    this.mVY = ((ImageView)paramView.findViewById(R.h.image_googlecontacts));
    this.mVZ = ((ImageView)paramView.findViewById(R.h.image_weishop));
    this.iuO = ((TextView)paramView.findViewById(R.h.title));
    aZ();
    super.onBindView(paramView);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(R.i.mm_preference_content_more_info, localViewGroup);
    return paramViewGroup;
  }
  
  public final void vV(int paramInt)
  {
    this.mWb = paramInt;
    aZ();
  }
  
  public final void vW(int paramInt)
  {
    this.mWc = paramInt;
    aZ();
  }
  
  public final void vX(int paramInt)
  {
    this.mWe = paramInt;
    aZ();
  }
  
  public final void vY(int paramInt)
  {
    this.mWf = paramInt;
    aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.ContactMoreInfoPreference
 * JD-Core Version:    0.7.0.1
 */