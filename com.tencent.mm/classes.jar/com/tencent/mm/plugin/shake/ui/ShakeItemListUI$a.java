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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.c;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.applet.b.a;
import com.tencent.mm.ui.applet.b.b;
import com.tencent.mm.ui.r;

final class ShakeItemListUI$a
  extends r<d>
{
  com.tencent.mm.ui.applet.b ffG = new com.tencent.mm.ui.applet.b(new b.a()
  {
    public final Bitmap pM(String paramAnonymousString)
    {
      return com.tencent.mm.ag.b.a(paramAnonymousString, false, -1);
    }
  });
  private b.b ffH = null;
  private int showType = 0;
  
  public ShakeItemListUI$a(ShakeItemListUI paramShakeItemListUI1, ShakeItemListUI paramShakeItemListUI2)
  {
    super(paramShakeItemListUI2, new d());
    yd();
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.ffH == null) {
      this.ffH = new ShakeItemListUI.a.2(this);
    }
    if (this.ffG != null) {
      this.ffG.a(paramInt, this.ffH);
    }
    if (paramView == null)
    {
      paramViewGroup = new ShakeItemListUI.a.a(this);
      paramView = View.inflate(this.context, R.i.shake_friend_item, null);
      paramViewGroup.ffK = ((ImageView)paramView.findViewById(R.h.nearby_friend_avatar_iv));
      paramViewGroup.fdY = ((TextView)paramView.findViewById(R.h.nearby_friend_name));
      paramViewGroup.ffL = ((TextView)paramView.findViewById(R.h.nearby_friend_is_friend));
      paramViewGroup.obJ = ((ImageView)paramView.findViewById(R.h.nearby_friend_sex));
      paramViewGroup.mDy = ((TextView)paramView.findViewById(R.h.nearby_friend_distance));
      paramViewGroup.mDz = ((TextView)paramView.findViewById(R.h.nearby_friend_sign));
      paramViewGroup.mDA = ((ImageView)paramView.findViewById(R.h.nearby_friend_vuserinfo));
      paramViewGroup.obK = ((TextView)paramView.findViewById(R.h.shake_tran_img_listitem_title));
      paramViewGroup.obI = paramView.findViewById(R.h.right_span);
      paramViewGroup.obL = ((LinearLayout)paramView.findViewById(R.h.shake_item_desc));
      paramViewGroup.obM = ((TextView)paramView.findViewById(R.h.shake_item_simple_desc));
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
      return paramView;
      paramViewGroup = (ShakeItemListUI.a.a)paramView.getTag();
    }
    paramViewGroup.clear();
    if ((4 == ((d)localObject1).field_type) || ((k.xo(((d)localObject1).field_type)) && (6 != ((d)localObject1).field_type)))
    {
      if (4 != ((d)localObject1).field_type) {
        paramViewGroup.ffK.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      e.a(paramViewGroup.ffK, ((d)localObject1).field_sns_bgurl, R.k.app_attach_file_icon_webpage, false);
      paramViewGroup.ffK.setVisibility(0);
      if ((7 != ((d)localObject1).field_type) && (10 != ((d)localObject1).field_type) && (12 != ((d)localObject1).field_type) && (13 != ((d)localObject1).field_type) && ((8 != ((d)localObject1).field_type) || (!bk.bl(((d)localObject1).field_nickname)) || (!bk.bl(((d)localObject1).field_username)))) {
        break label503;
      }
      if (8 != ((d)localObject1).field_type) {
        break label488;
      }
      paramViewGroup.obM.setText(((d)localObject1).field_distance);
    }
    for (;;)
    {
      paramViewGroup.obM.setVisibility(0);
      paramViewGroup.obL.setVisibility(8);
      return paramView;
      if (11 == ((d)localObject1).field_type)
      {
        ShakeItemListUI.g(this.obE).a(((d)localObject1).getProvince(), paramViewGroup.ffK);
        break;
      }
      a.b.a(paramViewGroup.ffK, ((d)localObject1).field_username);
      break;
      label488:
      paramViewGroup.obM.setText(((d)localObject1).field_nickname);
    }
    label503:
    paramViewGroup.obM.setVisibility(8);
    paramViewGroup.obL.setVisibility(0);
    if ((8 == ((d)localObject1).field_type) && (bk.bl(((d)localObject1).field_nickname)))
    {
      ((d)localObject1).field_nickname = ((d)localObject1).field_distance;
      ((d)localObject1).field_distance = ((d)localObject1).field_username;
    }
    Object localObject2 = bk.pm(((d)localObject1).field_nickname);
    paramViewGroup.fdY.setText(j.a(this.context, (CharSequence)localObject2, paramViewGroup.fdY.getTextSize()));
    paramViewGroup.fdY.setVisibility(0);
    paramInt = paramView.getPaddingBottom();
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingRight();
    int k = paramView.getPaddingLeft();
    if (((d)localObject1).field_insertBatch == 2)
    {
      paramView.setBackgroundDrawable(com.tencent.mm.cb.a.g(this.context, R.g.comm_item_highlight_selector));
      paramView.setPadding(k, i, j, paramInt);
      switch (((d)localObject1).field_type)
      {
      default: 
        paramViewGroup.obI.setVisibility(0);
        paramViewGroup.mDy.setText(((d)localObject1).field_distance);
        paramViewGroup.mDy.setVisibility(0);
        if ((((d)localObject1).field_signature == null) || (((d)localObject1).field_signature.trim().equals("")))
        {
          paramViewGroup.mDz.setVisibility(8);
          label754:
          if (((d)localObject1).field_sex != 1) {
            break label1043;
          }
          paramViewGroup.obJ.setVisibility(0);
          paramViewGroup.obJ.setImageDrawable(com.tencent.mm.cb.a.g(this.context, R.k.ic_sex_male));
          paramViewGroup.obJ.setContentDescription(this.context.getString(R.l.male_Imgbtn));
          label805:
          au.Hx();
          localObject2 = c.Fw().abl(((d)localObject1).field_username);
          if ((localObject2 == null) || (!com.tencent.mm.n.a.gR(((ao)localObject2).field_type))) {
            break label1129;
          }
          paramViewGroup.ffL.setVisibility(0);
          if (!ad.Fn(((d)localObject1).field_reserved1)) {
            break label1109;
          }
          paramViewGroup.ffL.setText(this.context.getString(R.l.nearby_friend_followed));
        }
        break;
      }
    }
    for (;;)
    {
      if (6 == ((d)localObject1).field_type)
      {
        paramViewGroup.mDy.setText(this.context.getString(R.l.shake_history_biz_type_name));
        paramViewGroup.ffL.setVisibility(8);
      }
      if (((d)localObject1).field_reserved1 == 0) {
        break label1141;
      }
      paramViewGroup.mDA.setVisibility(0);
      localObject1 = BackwardSupportUtil.b.e(am.a.dVA.hL(((d)localObject1).field_reserved1), 2.0F);
      paramViewGroup.mDA.setImageBitmap((Bitmap)localObject1);
      paramViewGroup.obJ.setVisibility(8);
      return paramView;
      paramView.setBackgroundDrawable(com.tencent.mm.cb.a.g(this.context, R.g.comm_list_item_selector));
      break;
      paramViewGroup.obK.setText(((d)localObject1).field_nickname);
      paramViewGroup.obK.setVisibility(0);
      return paramView;
      paramViewGroup.mDz.setVisibility(0);
      paramViewGroup.mDz.setText(j.a(this.context, ((d)localObject1).field_signature, paramViewGroup.fdY.getTextSize()));
      break label754;
      label1043:
      if (((d)localObject1).field_sex == 2)
      {
        paramViewGroup.obJ.setVisibility(0);
        paramViewGroup.obJ.setImageDrawable(com.tencent.mm.cb.a.g(this.context, R.k.ic_sex_female));
        paramViewGroup.obJ.setContentDescription(this.context.getString(R.l.female_Imgbtn));
        break label805;
      }
      paramViewGroup.obJ.setVisibility(8);
      break label805;
      label1109:
      paramViewGroup.ffL.setText(this.context.getString(R.l.nearby_friend_is_contact));
      continue;
      label1129:
      paramViewGroup.ffL.setVisibility(8);
    }
    label1141:
    paramViewGroup.mDA.setVisibility(8);
    return paramView;
  }
  
  protected final void xq(int paramInt)
  {
    this.showType = paramInt;
    yd();
  }
  
  public final void yc()
  {
    if (!au.DK()) {
      return;
    }
    switch (this.showType)
    {
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]));
      continue;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[] { "0" }));
      continue;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", new String[] { "0", "2" }));
      continue;
      setCursor(m.bzU().bzJ());
      continue;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[] { "4", "2" }));
      continue;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", new String[] { "7", "6", "8", "9", "10", "12" }));
      continue;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[] { "8", "2" }));
      continue;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[] { "11" }));
      continue;
      setCursor(m.bzU().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", new String[] { "11", String.valueOf(this.obE.getIntent().getIntExtra("_ibeacon_new_insert_size", 2)) }));
    }
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.ShakeItemListUI.a
 * JD-Core Version:    0.7.0.1
 */