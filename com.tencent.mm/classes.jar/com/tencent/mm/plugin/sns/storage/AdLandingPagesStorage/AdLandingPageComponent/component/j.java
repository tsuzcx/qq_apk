package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class j
{
  public String dIX = "";
  public String iZG = "";
  public View ipf;
  public Context mContext;
  public String mTitle = "";
  public c oFJ;
  private int oFK = -1;
  private int oFL = -1;
  private boolean oFM = false;
  private boolean oFN = false;
  public j.a oFO;
  
  public j(Context paramContext, i parami, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.dIX = paramString1;
    this.mTitle = paramString2;
    this.iZG = paramString3;
    this.mContext = paramContext;
    this.oFM = paramBoolean1;
    this.oFN = paramBoolean2;
    if ((parami != null) && (parami.getView() != null))
    {
      this.oFJ = new c(paramContext);
      this.oFJ.setCanceledOnTouchOutside(true);
      this.ipf = View.inflate(paramContext, i.g.sns_ad_native_landing_pages_item_bottom_sheet, null);
      if (this.ipf == null) {
        y.e("MicroMsg.AdLandingPageBottomSheet", "mRootView init fail!");
      }
    }
    else
    {
      return;
    }
    paramContext = (LinearLayout)this.ipf.findViewById(i.f.component_container);
    paramString1 = parami.getView();
    if (paramString1.getParent() != null) {
      ((ViewGroup)paramString1.getParent()).removeView(paramString1);
    }
    this.oFK = ((int)parami.bFm().oDm);
    this.oFL = ((int)parami.bFm().oDn);
    parami = new LinearLayout.LayoutParams(-1, -1);
    if ((this.oFK != 2147483647) && (this.oFL != 2147483647)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        parami.width = this.oFK;
        parami.height = this.oFL;
      }
      paramContext.addView(paramString1, parami);
      ((TextView)this.ipf.findViewById(i.f.bottom_sheet_title)).setText(paramString2);
      paramContext = this.ipf.findViewById(i.f.close_dialog_area);
      paramContext.setOnClickListener(new j.1(this));
      parami = this.ipf.findViewById(i.f.bottom_sheet_cancel_area);
      parami.setOnClickListener(new j.2(this));
      if (!this.oFN) {
        parami.setVisibility(8);
      }
      if (this.oFM) {
        paramContext.setVisibility(8);
      }
      paramContext = (ImageView)this.ipf.findViewById(i.f.tips_icon);
      paramContext.setVisibility(8);
      if (bk.bl(paramString3)) {
        break;
      }
      parami = h.eV("adId", paramString3);
      if (parami == null) {
        break label400;
      }
      paramContext.setImageBitmap(parami);
      paramContext.setVisibility(0);
      return;
    }
    label400:
    h.a(paramString3, 0, new j.3(this, paramContext));
  }
  
  public final void bFp()
  {
    if (this.oFJ != null) {
      this.oFJ.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j
 * JD-Core Version:    0.7.0.1
 */