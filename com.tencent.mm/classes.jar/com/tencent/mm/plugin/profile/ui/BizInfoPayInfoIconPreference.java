package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.Iterator;
import java.util.List;

public class BizInfoPayInfoIconPreference
  extends Preference
{
  private LayoutInflater Lu;
  private LinearLayout mVA;
  private List<String> mVB;
  private int mVC = -1;
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BizInfoPayInfoIconPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.Lu = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    setLayoutResource(R.i.mm_preference);
  }
  
  private void aZ()
  {
    if (this.mVA == null) {}
    for (;;)
    {
      return;
      this.mVA.removeAllViews();
      if (this.mVC >= 0)
      {
        int i = this.mVC;
        int j = 0;
        label29:
        if (j < 5)
        {
          if (i > 0) {
            break label52;
          }
          vU(R.k.biz_info_brand_unselect);
        }
        for (;;)
        {
          j += 1;
          break label29;
          break;
          label52:
          if (i <= 10)
          {
            vU(R.k.biz_info_brand_half_selected);
            i -= 20;
          }
          else
          {
            vU(R.k.biz_info_brand_selected);
            i -= 20;
          }
        }
      }
      if (this.mVB != null)
      {
        Iterator localIterator = this.mVB.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          CdnImageView localCdnImageView = new CdnImageView(this.mContext);
          localCdnImageView.setUrl((String)localObject);
          localObject = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
          ((LinearLayout.LayoutParams)localObject).rightMargin = a.fromDPToPix(this.mContext, 6);
          this.mVA.addView(localCdnImageView, (ViewGroup.LayoutParams)localObject);
        }
      }
    }
  }
  
  private void vU(int paramInt)
  {
    ImageView localImageView = (ImageView)this.Lu.inflate(R.i.contact_info_biz_info_icon, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(a.fromDPToPix(this.mContext, 20), a.fromDPToPix(this.mContext, 20));
    localLayoutParams.rightMargin = a.fromDPToPix(this.mContext, 6);
    localImageView.setImageResource(paramInt);
    this.mVA.addView(localImageView, localLayoutParams);
  }
  
  public final void bX(List<String> paramList)
  {
    this.mVB = paramList;
    aZ();
  }
  
  public final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.mVA = ((LinearLayout)paramView.findViewById(R.h.summary));
    aZ();
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(R.h.content);
    localViewGroup.removeAllViews();
    this.Lu.inflate(R.i.contact_info_pay_info_icon, localViewGroup);
    return paramViewGroup;
  }
  
  public final void vT(int paramInt)
  {
    if (paramInt == this.mVC) {
      return;
    }
    this.mVC = paramInt;
    aZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.BizInfoPayInfoIconPreference
 * JD-Core Version:    0.7.0.1
 */