package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.c.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;

public final class be
{
  private String lCN;
  private LinearLayout pjH;
  public TextView pjI;
  public TextView pjJ;
  private View pjK;
  private View pjL;
  public com.tencent.mm.plugin.sns.storage.b pjM;
  public com.tencent.mm.plugin.sns.storage.a pjN;
  private View view;
  
  public be(View paramView)
  {
    this.view = paramView;
    this.lCN = x.fB(ae.getContext());
    y.i("MicroMsg.TimeLineAdView", "adView init lan " + this.lCN);
    this.pjI = ((TextView)this.view.findViewById(i.f.ad_info_tv));
    this.pjJ = ((TextView)this.view.findViewById(i.f.ad_link_tv));
    this.pjK = this.view.findViewById(i.f.ad_info_tv_arrow);
    this.pjL = this.view.findViewById(i.f.ad_lbs_icon_tv);
    this.pjH = ((LinearLayout)this.view.findViewById(i.f.ad_info_ll));
    paramView = " " + this.view.getResources().getString(i.j.sns_ad_tip) + " ";
    this.pjI.setText(paramView);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.pjJ.setOnClickListener(paramOnClickListener1);
    this.pjI.setOnClickListener(paramOnClickListener2);
    if (this.pjK != null) {
      this.pjK.setOnClickListener(paramOnClickListener2);
    }
    if (this.pjH != null) {
      this.pjH.setOnClickListener(paramOnClickListener2);
    }
  }
  
  public final void a(com.tencent.mm.plugin.sns.storage.b paramb, com.tencent.mm.plugin.sns.storage.a parama)
  {
    this.pjN = parama;
    this.pjM = paramb;
    Object localObject1 = "";
    Context localContext;
    if (paramb != null)
    {
      if ("zh_CN".equals(this.lCN)) {
        localObject1 = paramb.oAK;
      }
    }
    else
    {
      Object localObject2 = localObject1;
      if (paramb != null)
      {
        localObject2 = localObject1;
        if (bk.bl((String)localObject1)) {
          localObject2 = paramb.oAI;
        }
      }
      localContext = this.pjJ.getContext();
      localObject1 = localObject2;
      if (bk.bl((String)localObject2)) {
        localObject1 = localContext.getString(i.j.sns_ad_view_more);
      }
      localObject1 = (String)localObject1 + " ";
      final int i = ((String)localObject1).length();
      localObject2 = new SpannableString((String)localObject1 + "ad_");
      if ((parama == null) || (!parama.bEC())) {
        break label375;
      }
      localObject1 = localContext.getResources().getDrawable(i.i.album_ad_link_tag_weapp);
      ((Drawable)localObject1).setBounds(0, 0, (int)(this.pjJ.getTextSize() * 0.8D), (int)(this.pjJ.getTextSize() * 0.8D));
      localObject1 = new ImageSpan((Drawable)localObject1, 1);
      label219:
      if (!bk.bl(paramb.oAJ)) {
        h.c("adId", paramb.oAJ, false, 41, new f.a()
        {
          public final void Op(String paramAnonymousString)
          {
            if (bk.bl(paramAnonymousString)) {}
            do
            {
              return;
              paramAnonymousString = Drawable.createFromPath(paramAnonymousString);
            } while (paramAnonymousString == null);
            paramAnonymousString.setBounds(0, 0, (int)(be.this.pjJ.getTextSize() * 1.3D), (int)(be.this.pjJ.getTextSize() * 1.3D));
            paramAnonymousString = new ImageSpan(paramAnonymousString, 0);
            this.pjO.setSpan(paramAnonymousString, i, i + 3, 33);
            be.this.pjJ.setText(this.pjO);
          }
          
          public final void bCF() {}
          
          public final void bFl() {}
        });
      }
      ((SpannableString)localObject2).setSpan(localObject1, i, i + 3, 33);
      this.pjJ.setText((CharSequence)localObject2);
      if ((parama == null) || (bk.bl(parama.oAd))) {
        break label436;
      }
      this.pjL.setVisibility(0);
      label296:
      if (paramb != null)
      {
        if (!"zh_CN".equals(this.lCN)) {
          break label448;
        }
        paramb = paramb.oAT;
      }
    }
    for (;;)
    {
      if (!bk.bl(paramb)) {
        this.pjI.setText(paramb);
      }
      return;
      if (("zh_TW".equals(this.lCN)) || ("zh_HK".equals(this.lCN)))
      {
        localObject1 = paramb.oAM;
        break;
      }
      localObject1 = paramb.oAL;
      break;
      label375:
      localObject1 = localContext.getResources().getDrawable(i.i.album_advertise_link_icon);
      ((Drawable)localObject1).setBounds(0, 0, (int)(this.pjJ.getTextSize() * 1.3D), (int)(this.pjJ.getTextSize() * 1.3D));
      localObject1 = new ImageSpan((Drawable)localObject1, 0);
      break label219;
      label436:
      this.pjL.setVisibility(8);
      break label296;
      label448:
      if (("zh_TW".equals(this.lCN)) || ("zh_HK".equals(this.lCN))) {
        paramb = paramb.oAV;
      } else {
        paramb = paramb.oAU;
      }
    }
  }
  
  public final String bKe()
  {
    if (this.pjN == null) {
      return "";
    }
    if (this.pjN.ovV == null) {
      return "";
    }
    return this.pjN.ovV;
  }
  
  public final int[] bKf()
  {
    int[] arrayOfInt = new int[2];
    if (this.pjH != null)
    {
      this.pjK.getLocationInWindow(arrayOfInt);
      arrayOfInt[0] += this.pjK.getMeasuredWidth();
    }
    while (this.pjK == null) {
      return arrayOfInt;
    }
    this.pjK.getLocationInWindow(arrayOfInt);
    arrayOfInt[0] += this.pjK.getMeasuredWidth();
    return arrayOfInt;
  }
  
  public final void m(Object paramObject1, Object paramObject2)
  {
    this.pjJ.setTag(paramObject1);
    this.pjI.setTag(paramObject2);
    if (this.pjK != null) {
      this.pjK.setTag(paramObject2);
    }
    if (this.pjH != null) {
      this.pjH.setTag(paramObject2);
    }
  }
  
  public final void setVisibility(int paramInt)
  {
    com.tencent.mm.storage.a locala;
    if ((this.pjM != null) && (this.pjM.oAH == 1))
    {
      this.pjJ.setVisibility(8);
      locala = c.IY().aaB("Sns_CanvasAd_DetailLink_JumpWay");
      if (!locala.isValid()) {
        break label184;
      }
    }
    label184:
    for (int i = bk.getInt(locala.field_value, -1);; i = -1)
    {
      if ((i != -1) && (this.pjM != null) && (this.pjM.bEE()) && (i.Ow(this.pjM.bUr))) {
        this.pjJ.setVisibility(paramInt);
      }
      this.pjI.setVisibility(paramInt);
      if (this.pjK != null) {
        this.pjK.setVisibility(paramInt);
      }
      if (this.pjH != null) {
        this.pjH.setVisibility(paramInt);
      }
      if ((this.pjN != null) && (!bk.bl(this.pjN.oAd)))
      {
        this.pjL.setVisibility(paramInt);
        return;
        this.pjJ.setVisibility(paramInt);
        break;
      }
      this.pjL.setVisibility(8);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.be
 * JD-Core Version:    0.7.0.1
 */