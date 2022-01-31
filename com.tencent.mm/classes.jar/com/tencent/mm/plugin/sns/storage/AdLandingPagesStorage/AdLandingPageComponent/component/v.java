package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;

public final class v
  extends i
{
  TextView flb;
  private RelativeLayout oHF;
  ImageView oHG;
  
  public v(Context paramContext, t paramt, ViewGroup paramViewGroup)
  {
    super(paramContext, paramt, paramViewGroup);
    this.oFE = paramt;
  }
  
  public final void bES()
  {
    super.bES();
  }
  
  public final void bET()
  {
    super.bET();
  }
  
  public final void bEU()
  {
    super.bEU();
  }
  
  public final View bFf()
  {
    View localView = this.contentView;
    localView.setBackgroundColor(this.backgroundColor);
    this.flb = ((TextView)localView.findViewById(i.f.sns_ad_landingpage_processbar_label));
    this.oHF = ((RelativeLayout)localView.findViewById(i.f.sns_ad_landingpage_processbar_bg));
    this.oHG = ((ImageView)localView.findViewById(i.f.sns_ad_landingpage_processbar_front));
    return localView;
  }
  
  protected final void bFj()
  {
    this.flb.setText(((t)this.oFE).label);
    this.flb.setTextSize(0, ((t)this.oFE).fontSize);
    if ((((t)this.oFE).fNR != null) && (((t)this.oFE).fNR.length() > 0))
    {
      int i = Color.parseColor(((t)this.oFE).fNR);
      this.oHF.setBackgroundColor(i);
    }
    h.a(((t)this.oFE).oDx, ((t)this.oFE).oDh, new v.1(this));
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_process_bar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */