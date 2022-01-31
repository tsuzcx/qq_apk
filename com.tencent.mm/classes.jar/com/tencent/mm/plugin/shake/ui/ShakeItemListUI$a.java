package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.p;

final class ShakeItemListUI$a
  extends p<d>
{
  com.tencent.mm.ui.applet.b gxo;
  private b.b gxp;
  private int showType;
  
  public ShakeItemListUI$a(ShakeItemListUI paramShakeItemListUI1, ShakeItemListUI paramShakeItemListUI2)
  {
    super(paramShakeItemListUI2, new d());
    AppMethodBeat.i(24732);
    this.showType = 0;
    this.gxp = null;
    this.gxo = new com.tencent.mm.ui.applet.b(new b.a()
    {
      public final Bitmap xh(String paramAnonymousString)
      {
        AppMethodBeat.i(24728);
        paramAnonymousString = com.tencent.mm.ah.b.b(paramAnonymousString, false, -1);
        AppMethodBeat.o(24728);
        return paramAnonymousString;
      }
    });
    Kv();
    AppMethodBeat.o(24732);
  }
  
  protected final void Dq(int paramInt)
  {
    AppMethodBeat.i(24736);
    this.showType = paramInt;
    Kv();
    AppMethodBeat.o(24736);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(24735);
    if (!aw.RG())
    {
      AppMethodBeat.o(24735);
      return;
    }
    switch (this.showType)
    {
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      AppMethodBeat.o(24735);
      return;
      setCursor(m.cln().ckT());
      continue;
      setCursor(m.cln().ckV());
      continue;
      setCursor(m.cln().ckU());
      continue;
      setCursor(m.cln().ckW());
      continue;
      setCursor(m.cln().ckX());
      continue;
      setCursor(m.cln().ckY());
      continue;
      setCursor(m.cln().ckZ());
      continue;
      setCursor(m.cln().cla());
      continue;
      setCursor(m.cln().Dh(this.qPL.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)));
    }
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(24734);
    bKb();
    Ku();
    AppMethodBeat.o(24734);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24733);
    if (this.gxp == null) {
      this.gxp = new ShakeItemListUI.a.2(this);
    }
    if (this.gxo != null) {
      this.gxo.a(paramInt, this.gxp);
    }
    if (paramView == null)
    {
      paramViewGroup = new ShakeItemListUI.a.a(this);
      paramView = View.inflate(this.context, 2130970711, null);
      paramViewGroup.gxs = ((ImageView)paramView.findViewById(2131823731));
      paramViewGroup.gvI = ((TextView)paramView.findViewById(2131823732));
      paramViewGroup.gxt = ((TextView)paramView.findViewById(2131826492));
      paramViewGroup.qPQ = ((ImageView)paramView.findViewById(2131826493));
      paramViewGroup.pdA = ((TextView)paramView.findViewById(2131826495));
      paramViewGroup.pdB = ((TextView)paramView.findViewById(2131826501));
      paramViewGroup.pdC = ((ImageView)paramView.findViewById(2131826494));
      paramViewGroup.qPR = ((TextView)paramView.findViewById(2131827700));
      paramViewGroup.qPP = paramView.findViewById(2131826500);
      paramViewGroup.qPS = ((LinearLayout)paramView.findViewById(2131827702));
      paramViewGroup.qPT = ((TextView)paramView.findViewById(2131827701));
      paramView.setTag(paramViewGroup);
    }
    Object localObject1;
    for (;;)
    {
      localObject1 = (d)getItem(paramInt);
      if (localObject1 != null) {
        break;
      }
      paramViewGroup.clear();
      AppMethodBeat.o(24733);
      return paramView;
      paramViewGroup = (ShakeItemListUI.a.a)paramView.getTag();
    }
    paramViewGroup.clear();
    if ((4 == ((d)localObject1).field_type) || ((k.Do(((d)localObject1).field_type)) && (6 != ((d)localObject1).field_type)))
    {
      if (4 != ((d)localObject1).field_type) {
        paramViewGroup.gxs.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      e.a(paramViewGroup.gxs, ((d)localObject1).field_sns_bgurl, 2131230829, false);
      paramViewGroup.gxs.setVisibility(0);
      if ((7 != ((d)localObject1).field_type) && (10 != ((d)localObject1).field_type) && (12 != ((d)localObject1).field_type) && (13 != ((d)localObject1).field_type) && ((8 != ((d)localObject1).field_type) || (!bo.isNullOrNil(((d)localObject1).field_nickname)) || (!bo.isNullOrNil(((d)localObject1).field_username)))) {
        break label508;
      }
      if (8 != ((d)localObject1).field_type) {
        break label493;
      }
      paramViewGroup.qPT.setText(((d)localObject1).field_distance);
    }
    for (;;)
    {
      paramViewGroup.qPT.setVisibility(0);
      paramViewGroup.qPS.setVisibility(8);
      AppMethodBeat.o(24733);
      return paramView;
      if (11 == ((d)localObject1).field_type)
      {
        ShakeItemListUI.g(this.qPL).a(((d)localObject1).getProvince(), paramViewGroup.gxs);
        break;
      }
      a.b.c(paramViewGroup.gxs, ((d)localObject1).field_username);
      break;
      label493:
      paramViewGroup.qPT.setText(((d)localObject1).field_nickname);
    }
    label508:
    paramViewGroup.qPT.setVisibility(8);
    paramViewGroup.qPS.setVisibility(0);
    if ((8 == ((d)localObject1).field_type) && (bo.isNullOrNil(((d)localObject1).field_nickname)))
    {
      ((d)localObject1).field_nickname = ((d)localObject1).field_distance;
      ((d)localObject1).field_distance = ((d)localObject1).field_username;
    }
    Object localObject2 = bo.nullAsNil(((d)localObject1).field_nickname);
    paramViewGroup.gvI.setText(j.b(this.context, (CharSequence)localObject2, paramViewGroup.gvI.getTextSize()));
    paramViewGroup.gvI.setVisibility(0);
    paramInt = paramView.getPaddingBottom();
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    if (((d)localObject1).field_insertBatch == 2)
    {
      paramView.setBackgroundDrawable(com.tencent.mm.cb.a.k(this.context, 2130838444));
      paramView.setPadding(k, i, j, paramInt);
      switch (((d)localObject1).field_type)
      {
      default: 
        paramViewGroup.qPP.setVisibility(0);
        paramViewGroup.pdA.setText(((d)localObject1).field_distance);
        paramViewGroup.pdA.setVisibility(0);
        if ((((d)localObject1).field_signature == null) || (((d)localObject1).field_signature.trim().equals("")))
        {
          paramViewGroup.pdB.setVisibility(8);
          label758:
          if (((d)localObject1).field_sex != 1) {
            break label1059;
          }
          paramViewGroup.qPQ.setVisibility(0);
          paramViewGroup.qPQ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231426));
          paramViewGroup.qPQ.setContentDescription(this.context.getString(2131301431));
          label809:
          aw.aaz();
          localObject2 = c.YA().arw(((d)localObject1).field_username);
          if ((localObject2 == null) || (!com.tencent.mm.n.a.je(((aq)localObject2).field_type))) {
            break label1145;
          }
          paramViewGroup.gxt.setVisibility(0);
          if (!ad.Nt(((d)localObject1).field_reserved1)) {
            break label1125;
          }
          paramViewGroup.gxt.setText(this.context.getString(2131301755));
          label880:
          if (6 == ((d)localObject1).field_type)
          {
            paramViewGroup.pdA.setText(this.context.getString(2131303580));
            paramViewGroup.gxt.setVisibility(8);
          }
          if (((d)localObject1).field_reserved1 == 0) {
            break label1157;
          }
          paramViewGroup.pdC.setVisibility(0);
          localObject1 = BackwardSupportUtil.b.k(ao.a.flK.kx(((d)localObject1).field_reserved1), 2.0F);
          paramViewGroup.pdC.setImageBitmap((Bitmap)localObject1);
          paramViewGroup.qPQ.setVisibility(8);
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24733);
      return paramView;
      paramView.setBackgroundDrawable(com.tencent.mm.cb.a.k(this.context, 2130838445));
      break;
      paramViewGroup.qPR.setText(((d)localObject1).field_nickname);
      paramViewGroup.qPR.setVisibility(0);
      AppMethodBeat.o(24733);
      return paramView;
      paramViewGroup.pdB.setVisibility(0);
      paramViewGroup.pdB.setText(j.b(this.context, ((d)localObject1).field_signature, paramViewGroup.gvI.getTextSize()));
      break label758;
      label1059:
      if (((d)localObject1).field_sex == 2)
      {
        paramViewGroup.qPQ.setVisibility(0);
        paramViewGroup.qPQ.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231425));
        paramViewGroup.qPQ.setContentDescription(this.context.getString(2131299866));
        break label809;
      }
      paramViewGroup.qPQ.setVisibility(8);
      break label809;
      label1125:
      paramViewGroup.gxt.setText(this.context.getString(2131301760));
      break label880;
      label1145:
      paramViewGroup.gxt.setVisibility(8);
      break label880;
      label1157:
      paramViewGroup.pdC.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a
 * JD-Core Version:    0.7.0.1
 */