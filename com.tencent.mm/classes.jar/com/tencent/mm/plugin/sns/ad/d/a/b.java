package com.tencent.mm.plugin.sns.ad.d.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.ad.j.c;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.g;
import com.tencent.mm.plugin.sns.ad.landingpage.component.info.g.a;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class b
{
  public int FUI;
  public View POS;
  public TextView POT;
  public ImageView POU;
  public View POV;
  public TextView POW;
  public View POX;
  public TextView POY;
  public ImageView POZ;
  public TextView PPa;
  public TextView PPb;
  public WeImageView PPc;
  public View PPd;
  public TextView PPe;
  public GradientDrawable PPf;
  public Drawable PPg;
  public View contentView;
  public Context context;
  public View lBX;
  public TextView mll;
  public TextView pmf;
  
  public static b a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(310028);
    if (paramInt == 1) {
      paramViewGroup = LayoutInflater.from(paramContext).inflate(b.g.sns_ad_native_landing_pages_item_hb_card_get_view, paramViewGroup, false);
    }
    for (;;)
    {
      b localb;
      if (paramViewGroup != null)
      {
        localb = new b();
        localb.context = paramContext;
        localb.FUI = paramInt;
        localb.lBX = paramViewGroup;
        localb.contentView = paramViewGroup.findViewById(b.f.content);
        localb.POS = paramViewGroup.findViewById(b.f.shadow_bg);
        localb.POT = ((TextView)paramViewGroup.findViewById(b.f.headline_txt));
        localb.mll = ((TextView)paramViewGroup.findViewById(b.f.title_txt));
        localb.pmf = ((TextView)paramViewGroup.findViewById(b.f.desc_txt));
        localb.POU = ((ImageView)paramViewGroup.findViewById(b.f.hb_img));
        localb.POW = ((TextView)paramViewGroup.findViewById(b.f.btn));
        if (paramInt == 1)
        {
          localb.POV = localb.POW;
          label155:
          localb.POX = paramViewGroup.findViewById(b.f.sender_layout);
          localb.POY = ((TextView)paramViewGroup.findViewById(b.f.sender_nick));
          localb.POZ = ((ImageView)paramViewGroup.findViewById(b.f.sender_avatar));
          localb.PPa = ((TextView)paramViewGroup.findViewById(b.f.sender_suffix));
          localb.PPe = ((TextView)paramViewGroup.findViewById(b.f.decoration_txt));
          localb.PPc = ((WeImageView)paramViewGroup.findViewById(b.f.invite_link_icon));
          localb.PPb = ((TextView)paramViewGroup.findViewById(b.f.invite_link_txt));
          localb.PPd = paramViewGroup.findViewById(b.f.invite_link_layout);
        }
        for (;;)
        {
          try
          {
            Log.i("HBCardViewWrapper", "fontSizeIndx=".concat(String.valueOf(m.heN())));
            if (m.heN() <= 1) {
              continue;
            }
            Log.i("HBCardViewWrapper", "adapter old mode");
            localb.q(localb.POT, b.d.sns_ad_font_size_17);
            if (paramInt != 1) {
              continue;
            }
            localb.q(localb.mll, b.d.sns_ad_font_size_22);
            localb.q(localb.pmf, b.d.sns_ad_font_size_14);
            localb.q(localb.PPb, b.d.sns_ad_font_size_14);
            localb.q(localb.POW, b.d.sns_ad_font_size_17);
            y(localb.POU, 110, 185);
            y(localb.POV, 184, 40);
            if (localb.FUI != 1) {
              continue;
            }
            aS(localb.POT, 45);
            aS(localb.mll, 20);
            aS(localb.pmf, 8);
            aS(localb.POU, 30);
            aS(localb.POV, 30);
            aS(localb.PPd, 24);
          }
          finally
          {
            Log.e("HBCardViewWrapper", "adapter oldMode exp=" + paramContext.toString());
            continue;
            if (localb.FUI != 2) {
              continue;
            }
            aS(localb.POT, 50);
            aS(localb.POX, 50);
            aS(localb.lBX.findViewById(b.f.hb_img_layout), 40);
            y(localb.lBX.findViewById(b.f.decoration_bg), 150, 18);
            y(localb.PPe, 118, 27);
            aS(localb.mll, 22);
            aS(localb.pmf, 10);
            aS(localb.POV, 20);
            continue;
            Log.i("HBCardViewWrapper", "adapter normal mode");
            continue;
          }
          AppMethodBeat.o(310028);
          return localb;
          if (paramInt != 2) {
            break label682;
          }
          paramViewGroup = LayoutInflater.from(paramContext).inflate(b.g.sns_ad_native_landing_pages_item_hb_card_give_view, paramViewGroup, false);
          break;
          localb.POV = paramViewGroup.findViewById(b.f.btn_layout);
          break label155;
          localb.q(localb.POY, b.d.sns_ad_font_size_17);
          localb.q(localb.PPa, b.d.sns_ad_font_size_17);
          localb.q(localb.PPe, b.d.sns_ad_font_size_12);
          localb.q(localb.mll, b.d.sns_ad_font_size_17);
          localb.q(localb.pmf, b.d.sns_ad_font_size_14);
        }
      }
      AppMethodBeat.o(310028);
      return null;
      label682:
      paramViewGroup = null;
    }
  }
  
  private static void aS(View paramView, int paramInt)
  {
    AppMethodBeat.i(310050);
    if (paramView == null)
    {
      AppMethodBeat.o(310050);
      return;
    }
    paramInt = m.ako(paramInt);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localLayoutParams;
      if (localMarginLayoutParams.topMargin != paramInt)
      {
        localMarginLayoutParams.topMargin = paramInt;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
    AppMethodBeat.o(310050);
  }
  
  private static GradientDrawable aWq(String paramString)
  {
    AppMethodBeat.i(310071);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    try
    {
      localGradientDrawable.setShape(0);
      localGradientDrawable.setCornerRadius(a.fromDPToPix(MMApplicationContext.getContext(), 4));
      localGradientDrawable.setColor(Color.parseColor(paramString));
      AppMethodBeat.o(310071);
      return localGradientDrawable;
    }
    finally
    {
      for (;;)
      {
        Log.e("HBCardViewWrapper", "createBgDrawable exp=" + localObject.toString() + ", bgColor=" + paramString);
      }
    }
  }
  
  private void q(TextView paramTextView, int paramInt)
  {
    AppMethodBeat.i(310040);
    if (paramTextView == null)
    {
      AppMethodBeat.o(310040);
      return;
    }
    paramTextView.setTextSize(0, a.bs(this.context, paramInt));
    AppMethodBeat.o(310040);
  }
  
  private static void y(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310061);
    if (paramView == null)
    {
      AppMethodBeat.o(310061);
      return;
    }
    paramInt1 = m.ako(paramInt1);
    paramInt2 = m.ako(paramInt2);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams.width != paramInt1) || (localLayoutParams.height != paramInt2))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(310061);
  }
  
  public final void Dl(boolean paramBoolean)
  {
    AppMethodBeat.i(310116);
    if (paramBoolean)
    {
      this.PPf.setAlpha(255);
      this.POV.setBackground(this.PPf);
      this.POV.setEnabled(true);
      AppMethodBeat.o(310116);
      return;
    }
    this.PPf.setAlpha(153);
    this.POV.setBackground(this.PPf);
    this.POV.setEnabled(false);
    AppMethodBeat.o(310116);
  }
  
  public final void a(g.a parama)
  {
    AppMethodBeat.i(310098);
    this.POT.setText(parama.PSe);
    this.pmf.setText(parama.desc);
    aWr(parama.btnTitle);
    Dl(true);
    this.lBX.setRotation(0.0F);
    if (this.PPe != null) {
      this.PPe.setText(parama.PSf);
    }
    AppMethodBeat.o(310098);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(310089);
    this.mll.setText(paramg.title);
    try
    {
      int i;
      if (!TextUtils.isEmpty(paramg.PSb))
      {
        i = Color.parseColor(paramg.PSb);
        this.POW.setTextColor(i);
        if (this.FUI == 2) {
          this.PPg = bb.m(this.context, b.i.sns_ad_hb_card_share_icon, i);
        }
      }
      for (;;)
      {
        if (this.PPg != null)
        {
          i = a.fromDPToPix(this.context, 16);
          this.PPg.setBounds(0, 0, i, i);
        }
        this.PPf = aWq(paramg.PSc);
        c.o(paramg.PRX, this.POU);
        if (this.PPb == null) {
          break label256;
        }
        this.PPb.setText(paramg.PRY);
        if (TextUtils.isEmpty(paramg.PRZ)) {
          break label256;
        }
        try
        {
          i = Color.parseColor(paramg.PRZ);
          this.PPb.setTextColor(i);
          this.PPc.setIconColor(i);
          AppMethodBeat.o(310089);
          return;
        }
        catch (Exception paramg)
        {
          Log.e("HBCardViewWrapper", "setData, parseColor exp=" + paramg.toString());
        }
        if (this.FUI == 2) {
          this.PPg = bb.m(this.context, b.i.sns_ad_hb_card_share_icon, -1);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("HBCardViewWrapper", "parse btnTxtColor exp, color=" + paramg.PSb);
      }
      label256:
      AppMethodBeat.o(310089);
    }
  }
  
  public final void aWr(String paramString)
  {
    AppMethodBeat.i(310107);
    this.POW.setText(paramString);
    AppMethodBeat.o(310107);
  }
  
  public final void ajt(int paramInt)
  {
    AppMethodBeat.i(310112);
    if ((this.FUI != 2) || (this.POW == null))
    {
      AppMethodBeat.o(310112);
      return;
    }
    if ((paramInt == 0) && (this.PPg != null))
    {
      this.POW.setCompoundDrawables(this.PPg, null, null, null);
      this.POW.setCompoundDrawablePadding(a.fromDPToPix(this.context, 8));
      AppMethodBeat.o(310112);
      return;
    }
    this.POW.setCompoundDrawables(null, null, null, null);
    this.POW.setCompoundDrawablePadding(0);
    AppMethodBeat.o(310112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.d.a.b
 * JD-Core Version:    0.7.0.1
 */