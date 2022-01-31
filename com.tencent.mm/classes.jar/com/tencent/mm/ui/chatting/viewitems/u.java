package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.le;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.b.b.f;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class u
  extends c
{
  static int vDX = Color.parseColor("#888888");
  static int vDY = Color.parseColor("#888888");
  private View.OnClickListener jDE;
  private String mAppId;
  private com.tencent.mm.ui.base.p uQF;
  private com.tencent.mm.as.a.a.c uQN;
  private View.OnClickListener vDP;
  private View.OnClickListener vDQ;
  private View.OnClickListener vDR;
  private View.OnClickListener vDS;
  private m vDT;
  private View.OnClickListener vDU;
  private String vDV;
  private int vDW;
  private com.tencent.mm.sdk.b.c<le> vhg;
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public u()
  {
    com.tencent.mm.as.a.a.c.a locala = new com.tencent.mm.as.a.a.c.a();
    locala.erD = true;
    locala.eru = R.g.brand_default_head;
    this.uQN = locala.OV();
    this.vDQ = new u.a(this, (byte)0);
    this.vDP = new u.1(this);
    this.vDU = new u.11(this);
    this.vDR = new u.12(this);
    this.vhg = new u.13(this);
    this.vDT = new u.14(this);
    this.vDS = new u.15(this);
    this.jDE = new u.16(this);
  }
  
  private static void B(int paramInt, String paramString1, String paramString2)
  {
    y.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.nFQ.f(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(bk.UX()) });
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ui.chatting.c.a parama, String paramString1, bi parambi, String paramString2)
  {
    if (paramImageView == null) {
      return;
    }
    if (com.tencent.mm.model.s.hU(paramString1))
    {
      paramImageView.setVisibility(8);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(paramString1))
    {
      o.ON().a(paramString2, paramImageView, this.uQN);
      paramImageView.setTag(new aw(parambi, paramString1));
      paramImageView.setOnClickListener(this.vDR);
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(r.gV(paramString1) + parama.vtz.getContext().getString(R.l.avatar_desc));
      return;
    }
    a.b.n(paramImageView, paramString1);
    if (parama.cFE()) {}
    for (parambi = parama.getTalkerUserName();; parambi = null)
    {
      paramImageView.setTag(new aw(paramString1, parambi));
      paramImageView.setOnClickListener(e(parama));
      break;
    }
  }
  
  private void a(bb parambb, bi parambi, Map<String, String> paramMap)
  {
    LinearLayout localLinearLayout = parambb.vHY;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    if (i < 10) {
      if (i != 0) {
        break label147;
      }
    }
    String str1;
    String str2;
    label147:
    for (parambb = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; parambb = ".msg.appmsg.mmreader.template_detail.opitems.opitem" + i)
    {
      str1 = (String)paramMap.get(parambb + ".word");
      str2 = (String)paramMap.get(parambb + ".hint_word");
      if (!bk.bl(str1)) {
        break label182;
      }
      y.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
      j = localLinearLayout.getChildCount();
      if (j > i)
      {
        if (i != 0) {
          break;
        }
        localLinearLayout.removeAllViews();
      }
      return;
    }
    localLinearLayout.removeViews(i, j - i);
    return;
    label182:
    Object localObject1;
    label201:
    Object localObject2;
    int k;
    label347:
    int m;
    if (i < j)
    {
      localObject1 = (LinearLayout)localLinearLayout.getChildAt(i);
      localObject1 = (a)((LinearLayout)localObject1).getTag();
      localObject2 = (String)paramMap.get(parambb + ".icon");
      k = d(paramMap, parambb + ".color", -16777216);
      ((a)localObject1).fcy.setTextColor(k);
      if (bk.getInt((String)paramMap.get(parambb + ".is_rich_text"), 0) != 0) {
        break label816;
      }
      ((a)localObject1).fcy.setSingleLine(true);
      ((a)localObject1).fcy.setEllipsize(TextUtils.TruncateAt.END);
      ((a)localObject1).fcy.setText(str1);
      ((a)localObject1).fce.setText(str2);
      if (!bk.bl((String)localObject2)) {
        break label914;
      }
      ((a)localObject1).hic.setVisibility(8);
      ((a)localObject1).fcy.setPadding(0, 0, 0, 0);
      label387:
      localObject2 = (String)paramMap.get(parambb + ".url");
      str1 = bk.pm((String)paramMap.get(".msg.fromusername"));
      m = bk.getInt((String)paramMap.get(parambb + ".op_type"), 0);
      str2 = (String)paramMap.get(parambb + ".weapp_username");
      aw localaw = new aw(parambi, str1, (String)localObject2);
      ((a)localObject1).vAG.setTag(localaw);
      k = i + 1;
      if ((m != 1) || (TextUtils.isEmpty(str2))) {
        break label962;
      }
      localObject2 = (String)paramMap.get(parambb + ".weapp_path");
      m = bk.getInt((String)paramMap.get(parambb + ".weapp_version"), 0);
      int n = bk.getInt((String)paramMap.get(parambb + ".weapp_state"), 0);
      parambb = new u.8(this, str2, bk.pm((String)paramMap.get(".msg.appmsg.template_id")), n, m, (String)localObject2, str1, k);
      ((a)localObject1).vAG.setOnClickListener(parambb);
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = (LinearLayout)LayoutInflater.from(this.vko.vtz.getContext()).inflate(R.i.chatting_dyeing_template_button_item, null, false);
      localObject2 = new a();
      ((a)localObject2).fcy = ((TextView)((LinearLayout)localObject1).findViewById(R.h.new_dyeing_template_button_text));
      ((a)localObject2).hic = ((ImageView)((LinearLayout)localObject1).findViewById(R.h.new_dyeing_template_button_icon));
      ((a)localObject2).vAG = ((LinearLayout)((LinearLayout)localObject1).findViewById(R.h.new_dyeing_template_button_Ll));
      ((a)localObject2).fce = ((TextView)((LinearLayout)localObject1).findViewById(R.h.new_dyeing_template_button_hint));
      ((LinearLayout)localObject1).setTag(localObject2);
      localLinearLayout.addView((View)localObject1);
      break label201;
      label816:
      k = bk.getInt((String)paramMap.get(parambb + ".display_line_number"), 1);
      y.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(k) });
      ((a)localObject1).fcy.setSingleLine(false);
      ((a)localObject1).fcy.setText(str1);
      ((a)localObject1).fcy.setMaxLines(k);
      j.a(((a)localObject1).fcy, false, null);
      break label347;
      label914:
      ((a)localObject1).hic.setVisibility(0);
      g(((a)localObject1).hic, (String)localObject2);
      ((a)localObject1).fcy.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.vko.vtz.getContext(), 28), 0);
      break label387;
      label962:
      if (m == 2) {
        ((a)localObject1).vAG.setOnClickListener(new u.9(this, k, paramMap));
      } else {
        ((a)localObject1).vAG.setOnClickListener(new u.10(this, (String)localObject2, str1, k));
      }
    }
  }
  
  private void a(bb parambb, String paramString1, String paramString2, Map<String, String> paramMap, bi parambi, boolean paramBoolean)
  {
    parambb.vHG.setText(j.a(this.vko.vtz.getContext(), paramString2, parambb.vHG.getTextSize()));
    o.ON().a(paramString1, parambb.vHF, this.uQN);
    parambb.vHF.setTag(null);
    parambb.vHF.setOnClickListener(null);
    parambb.vHE.setTag(null);
    parambb.vHE.setOnClickListener(null);
    parambb.vHE.setVisibility(0);
    paramString1 = bk.pm((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
    paramString2 = bk.pm((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
    if ((!bk.bl(paramString1)) || (!bk.bl(paramString2)))
    {
      paramString1 = bk.pm((String)paramMap.get(".msg.fromusername"));
      parambb.vHE.setTag(new aw(parambi, paramString1));
      parambb.vHE.setOnClickListener(this.vDU);
    }
    for (;;)
    {
      paramString1 = bk.pm((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (bk.bl(paramString1))) {
        break;
      }
      ((View)parambb.vHI.getParent()).setVisibility(0);
      o.ON().a(paramString1, parambb.vHI, this.uQN);
      return;
      parambb.vHE.setOnClickListener(null);
    }
    ((View)parambb.vHI.getParent()).setVisibility(8);
  }
  
  private void a(Map<String, String> paramMap, bi parambi, bb parambb, boolean paramBoolean1, boolean paramBoolean2)
  {
    LinearLayout localLinearLayout = parambb.vIl;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localLinearLayout.setVisibility(i);
      if (!paramBoolean2) {
        break label96;
      }
      parambb.vHH.setVisibility(0);
      parambb.vIm.setText(this.vko.vtz.getMMResources().getString(R.l.notify_message_settings_receive_app_brand_msg_short));
    }
    for (;;)
    {
      parambb.vIl.setTag(R.h.new_dyeing_template_ban_toggle_text, parambi);
      parambb.vIl.setOnClickListener(new u.18(this, paramMap, paramBoolean2, parambb, parambi));
      return;
      i = 8;
      break;
      label96:
      parambb.vHH.setVisibility(8);
      parambb.vIm.setText(this.vko.vtz.getMMResources().getString(R.l.notify_message_settings_ban_app_brand_msg_short));
    }
  }
  
  private static int adI(String paramString)
  {
    if (bk.bl(paramString)) {
      return 0;
    }
    int j = 0;
    int i = 0;
    if (j < paramString.length())
    {
      if (paramString.substring(j, j + 1).matches("[Α-￥]")) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  private static int d(Map<String, String> paramMap, String paramString, int paramInt)
  {
    if ((paramMap == null) || (bk.bl(paramString))) {
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(bk.pm((String)paramMap.get(paramString)));
      return i;
    }
    catch (Exception paramMap) {}
    return paramInt;
  }
  
  private static void g(ImageView paramImageView, String paramString)
  {
    if ((bk.bl(paramString)) || (paramImageView == null)) {
      return;
    }
    Object localObject = new com.tencent.mm.as.a.a.c.a();
    com.tencent.mm.model.au.Hx();
    ((com.tencent.mm.as.a.a.c.a)localObject).eri = com.tencent.mm.model.c.FH();
    ((com.tencent.mm.as.a.a.c.a)localObject).erf = true;
    ((com.tencent.mm.as.a.a.c.a)localObject).erC = true;
    localObject = ((com.tencent.mm.as.a.a.c.a)localObject).OV();
    o.ON().a(paramString, paramImageView, (com.tencent.mm.as.a.a.c)localObject);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_dyeing_template);
      paramLayoutInflater = new au();
      paramLayoutInflater.khV = ((CheckBox)((View)localObject).findViewById(R.h.chatting_checkbox));
      paramLayoutInflater.hoY = ((View)localObject).findViewById(R.h.chatting_maskview);
      paramLayoutInflater.nSa = ((TextView)((View)localObject).findViewById(R.h.chatting_user_tv));
      paramLayoutInflater.doU = ((ImageView)((View)localObject).findViewById(R.h.chatting_avatar_iv));
      paramLayoutInflater.dsz = ((TextView)((View)localObject).findViewById(R.h.chatting_time_tv));
      paramLayoutInflater.ifV = ((LinearLayout)((View)localObject).findViewById(R.h.chatting_content_ll));
      paramLayoutInflater.vHa.ifA = ((View)localObject).findViewById(R.h.chatting_item_dyeing_template_old);
      paramLayoutInflater.vHa.vHd = ((View)localObject).findViewById(R.h.headerV);
      paramLayoutInflater.vHa.fcy = ((TextView)paramLayoutInflater.vHa.ifA.findViewById(R.h.title));
      paramLayoutInflater.vHa.kZl = ((TextView)paramLayoutInflater.vHa.ifA.findViewById(R.h.time));
      paramLayoutInflater.vHa.vHh = ((LinearLayout)paramLayoutInflater.vHa.ifA.findViewById(R.h.digest_ll));
      paramLayoutInflater.vHa.vHg = ((TextView)paramLayoutInflater.ifV.findViewById(R.h.detail));
      paramLayoutInflater.vHa.vHi = paramLayoutInflater.ifV.findViewById(R.h.separatorLineV);
      paramLayoutInflater.vHa.vHe = ((View)localObject).findViewById(R.h.more_v);
      paramLayoutInflater.vHa.vHf = ((View)localObject).findViewById(R.h.more_v_clone);
      paramLayoutInflater.vHb.vHC = ((View)localObject).findViewById(R.h.chatting_item_dyeing_template_new);
      paramLayoutInflater.vHb.vHD = ((ImageView)((View)localObject).findViewById(R.h.new_dyeing_template_img));
      paramLayoutInflater.vHb.vHE = ((View)localObject).findViewById(R.h.new_dyeing_template_headerV);
      paramLayoutInflater.vHb.vHG = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_user_tv));
      paramLayoutInflater.vHb.vHF = ((ImageView)((View)localObject).findViewById(R.h.new_dyeing_template_avatar_iv));
      paramLayoutInflater.vHb.vHH = ((View)localObject).findViewById(R.h.new_dyeing_template_ban_v);
      paramLayoutInflater.vHb.vHI = ((ImageView)((View)localObject).findViewById(R.h.new_dyeing_template_shortcut_iv));
      paramLayoutInflater.vHb.vHJ = ((View)localObject).findViewById(R.h.new_dyeing_template_more_v);
      paramLayoutInflater.vHb.vHK = ((View)localObject).findViewById(R.h.new_dyeing_template_more_v_clone);
      paramLayoutInflater.vHb.vHL = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_title));
      paramLayoutInflater.vHb.vHM = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_time));
      paramLayoutInflater.vHb.vHN = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_first_data));
      paramLayoutInflater.vHb.vHO = ((View)localObject).findViewById(R.h.new_dyeing_template_header_layout);
      paramLayoutInflater.vHb.vHP = ((LinearLayout)((View)localObject).findViewById(R.h.new_dyeing_template_top_line));
      paramLayoutInflater.vHb.vHQ = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_top_line_key));
      paramLayoutInflater.vHb.vHS = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_top_line_value));
      paramLayoutInflater.vHb.vHR = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_top_line_value_prefix));
      paramLayoutInflater.vHb.vHT = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_top_line_value_strikethrough));
      paramLayoutInflater.vHb.vHU = ((View)localObject).findViewById(R.h.new_dyeing_template_top_line_divider);
      paramLayoutInflater.vHb.vHV = ((LinearLayout)((View)localObject).findViewById(R.h.new_dyeing_template_key_value_lines));
      paramLayoutInflater.vHb.vHZ = ((View)localObject).findViewById(R.h.new_dyeing_template_buttons_top_divider);
      paramLayoutInflater.vHb.vHW = ((View)localObject).findViewById(R.h.bottom_buttons_container);
      paramLayoutInflater.vHb.vHX = ((LinearLayout)((View)localObject).findViewById(R.h.new_dyeing_template_buttons));
      paramLayoutInflater.vHb.vHY = ((LinearLayout)((View)localObject).findViewById(R.h.dyeing_template_vertical_buttons_container));
      paramLayoutInflater.vHb.vIa = ((LinearLayout)((View)localObject).findViewById(R.h.new_dyeing_template_button1));
      paramLayoutInflater.vHb.vId = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_button1_text));
      paramLayoutInflater.vHb.vIf = ((ImageView)((View)localObject).findViewById(R.h.new_dyeing_template_button1_icon));
      paramLayoutInflater.vHb.vIc = ((View)localObject).findViewById(R.h.new_dyeing_template_buttons_divider);
      paramLayoutInflater.vHb.vIb = ((LinearLayout)((View)localObject).findViewById(R.h.new_dyeing_template_button2));
      paramLayoutInflater.vHb.vIe = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_button2_text));
      paramLayoutInflater.vHb.vIg = ((ImageView)((View)localObject).findViewById(R.h.new_dyeing_template_button2_icon));
      paramLayoutInflater.vHb.vIh = ((ImageView)((View)localObject).findViewById(R.h.new_dyeing_template_arrow));
      paramLayoutInflater.vBB = ((ImageView)((View)localObject).findViewById(R.h.chatting_item_dyeding_template_refuse_iv));
      paramLayoutInflater.vHb.vIi = ((View)localObject).findViewById(R.h.new_dyeing_template_single_wxa_button);
      paramLayoutInflater.vHb.vIj = ((ImageView)((View)localObject).findViewById(R.h.new_dyeing_template_single_wxa_icon_iv));
      paramLayoutInflater.vHb.vIk = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_single_wxa_name_tv));
      paramLayoutInflater.vHb.vIl = ((LinearLayout)((View)localObject).findViewById(R.h.new_dyeing_template_ban_toggle));
      paramLayoutInflater.vHb.vIm = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_ban_toggle_text));
      paramLayoutInflater.vHc.vAH = ((LinearLayout)((View)localObject).findViewById(R.h.new_dyeing_template_card_layout));
      paramLayoutInflater.vHc.vAI = ((CdnImageView)((View)localObject).findViewById(R.h.new_dyeing_template_card_icon_iv));
      paramLayoutInflater.vHc.vAJ = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_card_title_tv));
      paramLayoutInflater.vHc.vAK = ((TextView)((View)localObject).findViewById(R.h.new_dyeing_template_card_desc_tv));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    au localau = (au)parama;
    Map localMap = bn.s(parambi.field_content, "msg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      y.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localau.ifV.setVisibility(8);
      return;
    }
    localau.ifV.setVisibility(0);
    int j = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.vDV = bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.template_msg_id"));
    this.vDW = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    com.tencent.mm.sdk.b.a.udP.d(this.vhg);
    ((f)parama1.ac(f.class)).b(this.vDT);
    Object localObject1;
    if (j != 0)
    {
      localau.vHa.ifA.setVisibility(8);
      localObject1 = localau.vHb;
      if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a((bb)localObject1, bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), localMap, parambi, false);
        if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label2311;
        }
        ((bb)localObject1).vHE.setBackgroundResource(R.g.mm_trans);
        label277:
        if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) != 0) {
          break label6456;
        }
      }
    }
    label514:
    label561:
    label1588:
    label2743:
    label3511:
    label6456:
    for (int i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      int m = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      int k = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_time"), 0);
      ((bb)localObject1).vHL.setVisibility(8);
      ((bb)localObject1).vHM.setVisibility(8);
      if (i == 0)
      {
        if (m == 0)
        {
          ((bb)localObject1).vHL.setVisibility(0);
          parama = bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
          m = d(localMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
          ((bb)localObject1).vHL.setTextColor(m);
          ((bb)localObject1).vHL.setText(parama);
        }
        if (k == 0)
        {
          long l = bk.getLong(bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.pub_time")), 0L);
          if (l <= 0L) {
            break label2348;
          }
          ((bb)localObject1).vHM.setText(com.tencent.mm.pluginsdk.f.h.g(this.vko.vtz.getMMResources().getString(R.l.fmt_datetime_normal), l));
          ((bb)localObject1).vHM.setVisibility(0);
        }
      }
      parama = bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      k = d(localMap, ".msg.appmsg.mmreader.template_header.first_color", vDY);
      label583:
      boolean bool1;
      boolean bool4;
      boolean bool2;
      boolean bool3;
      if (bk.bl(parama))
      {
        ((bb)localObject1).vHN.setVisibility(8);
        if ((i == 0) || (!bk.bl(parama))) {
          break label2440;
        }
        ((bb)localObject1).vHO.setVisibility(8);
        bool1 = false;
        bool4 = false;
        bool2 = bool4;
        if ("notifymessage".equals(parambi.field_talker))
        {
          parama = bk.pm((String)localMap.get(".msg.fromusername"));
          bool3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(parama);
          bool1 = bool3;
          bool2 = bool4;
          if (bool3)
          {
            ((f)this.vko.ac(f.class)).a(this.vDT);
            com.tencent.mm.sdk.b.a.udP.c(this.vhg);
            parama1 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(parama);
            if (parama1 == null) {
              break label2458;
            }
            this.mAppId = parama1.field_appId;
            if ((parama1.field_appOpt & 0x1) <= 0) {
              break label2452;
            }
            bool1 = true;
            label726:
            bool2 = bool1;
            bool1 = bool3;
          }
        }
        label734:
        parama = ((bb)localObject1).vHJ;
        if (!bool1) {
          break label2514;
        }
        i = 0;
        label748:
        parama.setVisibility(i);
        ((bb)localObject1).vHJ.setTag(R.h.new_dyeing_template_more_v, parambi);
        ((bb)localObject1).vHJ.setOnClickListener(this.vDP);
        a(localMap, parambi, (bb)localObject1, bool1, bool2);
        ((bb)localObject1).vHD.setVisibility(8);
        parama = bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
        ((bb)localObject1).vHN.setText(parama);
        parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
        parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
        paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
        if (bk.bl(parama1)) {
          break label2578;
        }
        i = d(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", -16777216);
        j = d(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", -16777216);
        k = d(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", -16777216);
        m = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
        ((bb)localObject1).vHQ.setTextColor(i);
        ((bb)localObject1).vHS.setTextColor(j);
        ((bb)localObject1).vHT.setTextColor(k);
        ((bb)localObject1).vHT.getPaint().setFlags(16);
        ((bb)localObject1).vHQ.setText(parama);
        if ((m <= 0) || (m >= parama1.length())) {
          break label2521;
        }
        ((bb)localObject1).vHR.setVisibility(0);
        ((bb)localObject1).vHR.setText(parama1.substring(0, m));
        ((bb)localObject1).vHR.setTextColor(j);
        ((bb)localObject1).vHR.setTypeface(((b)com.tencent.mm.kernel.g.r(b.class)).dO(this.vko.vtz.getContext()));
        ((bb)localObject1).vHS.setTypeface(((b)com.tencent.mm.kernel.g.r(b.class)).dO(this.vko.vtz.getContext()));
        ((bb)localObject1).vHS.setText(parama1.substring(m));
        label1115:
        if (bk.bl(paramString)) {
          break label2565;
        }
        ((bb)localObject1).vHT.setText(paramString);
        ((bb)localObject1).vHT.setVisibility(0);
        label1142:
        ((bb)localObject1).vHP.setVisibility(0);
        label1151:
        m = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        if (m != 2) {
          break label2743;
        }
        y.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
        ((bb)localObject1).vHM.setVisibility(8);
        ((bb)localObject1).vHV.setVisibility(8);
        parama1 = (ViewGroup)((bb)localObject1).vHV.getParent();
        parama = parama1.findViewById(R.h.custom_view);
        if (parama != null) {
          break label6453;
        }
        parama = LayoutInflater.from(parama1.getContext()).inflate(R.i.remind_template_item, null);
        paramString = new at();
        paramString.hic = ((ImageView)parama.findViewById(R.h.avatar));
        paramString.vGZ = ((TextView)parama.findViewById(R.h.nickname));
        paramString.kZl = ((TextView)parama.findViewById(R.h.time));
        paramString.fcy = ((TextView)parama.findViewById(R.h.title));
        parama.setTag(paramString);
        parama1.addView(parama);
      }
      for (;;)
      {
        parama.setVisibility(0);
        paramString = (at)parama.getTag();
        parama = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
        Object localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
        parama1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
        Object localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
        i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
        paramString.fcy.setText(j.b(paramString.fcy.getContext(), parama));
        Object localObject4 = paramString.vGZ;
        Object localObject5 = paramString.fcy.getContext();
        if (bk.bl((String)localObject2)) {
          parama = "";
        }
        for (;;)
        {
          ((TextView)localObject4).setText(j.b((Context)localObject5, parama));
          paramString.kZl.setText((CharSequence)localObject3);
          if (i == 2)
          {
            paramString.hic.setImageDrawable(ae.getContext().getResources().getDrawable(R.g.app_add_to_favorite));
            label1510:
            if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
              break label3511;
            }
            ((bb)localObject1).vIi.setVisibility(8);
            ((bb)localObject1).vHX.setVisibility(8);
            ((bb)localObject1).vHZ.setVisibility(8);
            ((bb)localObject1).vHY.setVisibility(0);
            ((bb)localObject1).vHW.setVisibility(0);
            a((bb)localObject1, parambi, localMap);
            paramString = bk.pm((String)localMap.get(".msg.fromusername"));
            parama = null;
            if (!bk.bl(paramString))
            {
              com.tencent.mm.model.au.Hx();
              parama = com.tencent.mm.model.c.Fw().abl(paramString).Bp();
            }
            localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
            localObject4 = (String)localMap.get(".msg.appmsg.mmreader.category.item.url");
            localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.native_url");
            parama1 = (String)localMap.get(".msg.appmsg.template_id");
            localObject5 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if ((m != 1) || (TextUtils.isEmpty((CharSequence)localObject5))) {
              break label4961;
            }
            paramString = new aw(parambi, paramString, (String)localObject4);
            paramString.position = paramInt;
            ((bb)localObject1).vHC.setTag(paramString);
            ((bb)localObject1).vHC.setOnClickListener(this.jDE);
            label1765:
            ((bb)localObject1).vHC.setOnLongClickListener(c(this.vko));
            if (com.tencent.mm.m.g.AB().Ap())
            {
              localau.vBB.setVisibility(0);
              c(this.vko, localau.vBB, new t.n(parama1, parambi, parama));
            }
            parama = bk.pm((String)localMap.get(".msg.fromusername"));
            if ((!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(parama)) || (!"notifymessage".equals(parambi.field_talker))) {
              break label5191;
            }
            y.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
            ((bb)localObject1).vHK.setTag(null);
            ((bb)localObject1).vHK.setVisibility(8);
          }
          for (;;)
          {
            localau.vHb.vHC.setVisibility(0);
            return;
            if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
            {
              a((bb)localObject1, bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.icon_url")), bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_header.display_name")), localMap, parambi, true);
              break;
            }
            ((View)((bb)localObject1).vHI.getParent()).setVisibility(8);
            if ("notifymessage".equals(parambi.field_talker))
            {
              parama1 = bk.pm((String)localMap.get(".msg.fromusername"));
              if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(parama1))
              {
                paramString = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(parama1);
                if (paramString == null)
                {
                  parama = null;
                  a(((bb)localObject1).vHF, this.vko, parama1, parambi, parama);
                  if (paramString != null) {
                    break label2186;
                  }
                  parama = parama1;
                }
              }
              for (;;)
              {
                ((bb)localObject1).vHG.setText(j.a(this.vko.vtz.getContext(), parama, ((bb)localObject1).vHG.getTextSize()));
                if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(parama1)) {
                  break label2235;
                }
                ((bb)localObject1).vHE.setTag(new aw(parambi, parama1));
                ((bb)localObject1).vHE.setOnClickListener(this.vDR);
                ((bb)localObject1).vHE.setVisibility(0);
                break;
                parama = paramString.field_brandIconURL;
                break label2064;
                parama = paramString.field_nickname;
                continue;
                a(((bb)localObject1).vHF, this.vko, parama1, parambi, null);
                parama = ((com.tencent.mm.ui.chatting.b.b.e)this.vko.ac(com.tencent.mm.ui.chatting.b.b.e.class)).adr(parama1);
              }
              label2235:
              paramString = ((bb)localObject1).vHE;
              if (this.vko.cFE()) {}
              for (parama = this.vko.getTalkerUserName();; parama = null)
              {
                paramString.setTag(new aw(parama1, parama));
                ((bb)localObject1).vHE.setOnClickListener(e(this.vko));
                break;
              }
            }
            ((bb)localObject1).vHE.setVisibility(8);
            break;
            i = ((bb)localObject1).vHE.getPaddingLeft();
            ((bb)localObject1).vHE.setBackgroundResource(R.g.list_item_normal);
            ((bb)localObject1).vHE.setPadding(i, 0, 0, 0);
            break label277;
            ((bb)localObject1).vHM.setVisibility(8);
            break label514;
            ((bb)localObject1).vHN.setTextColor(k);
            ((bb)localObject1).vHN.setText(parama);
            ((bb)localObject1).vHN.setVisibility(0);
            if (j == 2)
            {
              ((bb)localObject1).vHN.setPadding(0, this.vko.vtz.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0);
              break label561;
            }
            ((bb)localObject1).vHN.setPadding(0, 0, 0, 0);
            break label561;
            ((bb)localObject1).vHO.setVisibility(0);
            break label583;
            bool1 = false;
            break label726;
            y.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama });
            ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).a(parama, new u.17(this, localMap, parambi, (bb)localObject1));
            bool1 = bool3;
            bool2 = bool4;
            break label734;
            label2514:
            i = 8;
            break label748;
            label2521:
            ((bb)localObject1).vHR.setTypeface(Typeface.DEFAULT);
            ((bb)localObject1).vHR.setVisibility(8);
            ((bb)localObject1).vHS.setTypeface(Typeface.DEFAULT);
            ((bb)localObject1).vHS.setText(parama1);
            break label1115;
            ((bb)localObject1).vHT.setVisibility(8);
            break label1142;
            ((bb)localObject1).vHP.setVisibility(8);
            break label1151;
            parama = null;
            ad localad;
            if (com.tencent.mm.model.s.fn((String)localObject2))
            {
              com.tencent.mm.model.au.Hx();
              localad = com.tencent.mm.model.c.Fw().abl((String)localObject2);
              if (localad != null)
              {
                if (localad.Bq() != null) {
                  break label2683;
                }
                parama = localad.Bp();
              }
            }
            for (;;)
            {
              if (!bk.bl(parama)) {
                break label6450;
              }
              y.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { localObject2, parama1 });
              parama = parama1;
              if (parama1 != null) {
                break;
              }
              parama = ae.getContext().getString(R.l.chatting_roominfo_noname);
              break;
              label2683:
              parama = localad.Bq();
              continue;
              com.tencent.mm.model.au.Hx();
              parama = com.tencent.mm.model.c.Fw().abl((String)localObject2);
              if (parama.Bq() == null) {
                parama = parama.Bp();
              } else {
                parama = parama.Bq();
              }
            }
            a.b.a(paramString.hic, (String)localObject2);
            break label1510;
            parama1 = new ArrayList();
            i = 0;
            j = 0;
            if (j < 100)
            {
              if (j == 0)
              {
                parama = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
                label2773:
                paramString = (String)localMap.get(parama + ".value.word");
                localObject2 = (String)localMap.get(parama + ".key.word");
                if ((!bk.bl(paramString)) || (!bk.bl((String)localObject2))) {
                  break label3085;
                }
                y.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[] { Integer.valueOf(j) });
              }
            }
            else
            {
              if (i <= 8) {
                break label3276;
              }
              i = 8;
              label2884:
              paramString = ((bb)localObject1).vHV;
              paramString.setVisibility(0);
              parama = ((ViewGroup)((bb)localObject1).vHV.getParent()).findViewById(R.h.custom_view);
              if (parama != null) {
                parama.setVisibility(8);
              }
              if (paramString.getChildCount() > parama1.size())
              {
                if (parama1.size() != 0) {
                  break label3279;
                }
                paramString.removeAllViews();
              }
              k = paramString.getChildCount();
              j = 0;
              if (j >= parama1.size()) {
                break label3432;
              }
              localObject2 = (ay)parama1.get(j);
              if (j >= k) {
                break label3309;
              }
              parama = (LinearLayout)paramString.getChildAt(j);
              label3005:
              parama = (az)parama.getTag();
              if (!((ay)localObject2).vHy) {
                break label3388;
              }
              parama.vHz.setVisibility(8);
            }
            for (;;)
            {
              parama.vHA.setTextColor(((ay)localObject2).vHx);
              parama.vHA.setText(((ay)localObject2).vHv);
              j += 1;
              break label2963;
              parama = ".msg.appmsg.mmreader.template_detail.line_content.lines.line" + j;
              break label2773;
              localObject3 = new ay();
              ((ay)localObject3).vHv = paramString;
              ((ay)localObject3).vHu = bk.pm((String)localObject2);
              ((ay)localObject3).vHw = d(localMap, parama + ".key.color", vDX);
              ((ay)localObject3).vHx = d(localMap, parama + ".value.color", -16777216);
              if (bk.getInt((String)localMap.get(parama + ".key.hide"), 0) != 0)
              {
                bool1 = true;
                ((ay)localObject3).vHy = bool1;
                k = (adI(((ay)localObject3).vHu) + 1) / 2;
                if (k <= i) {
                  break label3273;
                }
                i = k;
              }
              label3273:
              for (;;)
              {
                parama1.add(localObject3);
                j += 1;
                break;
                bool1 = false;
                break label3217;
              }
              label3276:
              break label2884;
              label3279:
              j = paramString.getChildCount();
              paramString.removeViews(parama1.size(), j - parama1.size());
              break label2953;
              label3309:
              parama = (LinearLayout)LayoutInflater.from(this.vko.vtz.getContext()).inflate(R.i.chatting_dyeing_template_line_item, null, false);
              localObject3 = new az();
              ((az)localObject3).vHz = ((TextView)parama.findViewById(R.h.line_key));
              ((az)localObject3).vHA = ((TextView)parama.findViewById(R.h.line_value));
              parama.setTag(localObject3);
              paramString.addView(parama);
              break label3005;
              label3388:
              parama.vHz.setVisibility(0);
              parama.vHz.setEms(i);
              parama.vHz.setTextColor(((ay)localObject2).vHw);
              parama.vHz.setText(((ay)localObject2).vHu);
            }
            label3432:
            if (paramString.getChildCount() == 0)
            {
              ((bb)localObject1).vHU.setVisibility(8);
              paramString.setVisibility(8);
              break label1510;
            }
            if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
              ((bb)localObject1).vHU.setVisibility(8);
            }
            for (;;)
            {
              paramString.setVisibility(0);
              break;
              ((bb)localObject1).vHU.setVisibility(0);
            }
            ((bb)localObject1).vHY.setVisibility(8);
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
            parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
            if (!bk.bl(parama1))
            {
              i = d(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", -16777216);
              ((bb)localObject1).vId.setTextColor(i);
              ((bb)localObject1).vId.setText(parama1);
              if (bk.bl(parama))
              {
                ((bb)localObject1).vIf.setVisibility(8);
                ((bb)localObject1).vId.setPadding(0, 0, 0, 0);
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                parama1 = bk.pm((String)localMap.get(".msg.fromusername"));
                i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                localObject3 = new aw(parambi, parama1, (String)localObject2);
                ((bb)localObject1).vIa.setTag(localObject3);
                ((bb)localObject1).vIi.setTag(localObject3);
                if ((i != 1) || (TextUtils.isEmpty(paramString))) {
                  break label4509;
                }
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                j = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                parama1 = new u.3(this, paramString, bk.pm((String)localMap.get(".msg.appmsg.template_id")), j, i, (String)localObject2, parama1);
                ((bb)localObject1).vIa.setOnClickListener(parama1);
                ((bb)localObject1).vIi.setOnClickListener(parama1);
                label3836:
                ((bb)localObject1).vIa.setVisibility(0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (bk.bl(paramString)) {
                  break label4623;
                }
                i = d(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", -16777216);
                ((bb)localObject1).vIe.setTextColor(i);
                ((bb)localObject1).vIe.setText(paramString);
                if (!bk.bl(parama1)) {
                  break label4553;
                }
                ((bb)localObject1).vIg.setVisibility(8);
                ((bb)localObject1).vIe.setPadding(0, 0, 0, 0);
                label3944:
                localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                paramString = bk.pm((String)localMap.get(".msg.fromusername"));
                i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                ((bb)localObject1).vIb.setTag(new aw(parambi, paramString, (String)localObject3));
                if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                  break label4600;
                }
                localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                j = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                localObject4 = bk.pm((String)localMap.get(".msg.appmsg.template_id"));
                ((bb)localObject1).vIb.setOnClickListener(new u.5(this, (String)localObject2, (String)localObject4, j, i, (String)localObject3, paramString));
                ((bb)localObject1).vIb.setVisibility(0);
                label4154:
                ((bb)localObject1).vIh.setVisibility(8);
                if ((((bb)localObject1).vIa.getVisibility() != 8) || (((bb)localObject1).vIb.getVisibility() != 8)) {
                  break label4636;
                }
                ((bb)localObject1).vHX.setVisibility(8);
                ((bb)localObject1).vHW.setVisibility(8);
                ((bb)localObject1).vHZ.setVisibility(8);
                if ((((bb)localObject1).vIa.getVisibility() != 0) || (((bb)localObject1).vIb.getVisibility() != 0)) {
                  break label4917;
                }
                ((bb)localObject1).vIc.setVisibility(0);
                parama = bk.pm((String)localMap.get(".msg.fromusername"));
                i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if ((ad.gr(parama)) || (((bb)localObject1).vIa.getVisibility() == 8) || (((bb)localObject1).vIb.getVisibility() != 8) || (i != 1) || (!ad.gr(paramString))) {
                  break label4948;
                }
                localObject2 = ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).so(paramString);
                if (localObject2 != null) {
                  break label4930;
                }
                parama = null;
                if (localObject2 != null) {
                  break label4939;
                }
              }
            }
            label4553:
            label4939:
            for (parama1 = paramString;; parama1 = ((WxaAttributes)localObject2).field_nickname)
            {
              o.ON().a(parama, ((bb)localObject1).vIj, this.uQN);
              ((bb)localObject1).vIk.setText(parama1);
              if (localObject2 == null) {
                ((com.tencent.mm.plugin.appbrand.r.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.c.class)).a(paramString, new u.7(this, (bb)localObject1, paramString));
              }
              ((bb)localObject1).vIi.setVisibility(0);
              ((bb)localObject1).vHX.setVisibility(8);
              break;
              ((bb)localObject1).vIf.setVisibility(0);
              g(((bb)localObject1).vIf, parama);
              ((bb)localObject1).vId.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.vko.vtz.getContext(), 16), 0);
              break label3617;
              ((bb)localObject1).vIa.setOnClickListener(new u.4(this, (String)localObject2, parama1));
              ((bb)localObject1).vIi.setOnClickListener(null);
              break label3836;
              ((bb)localObject1).vIa.setVisibility(8);
              break label3845;
              ((bb)localObject1).vIg.setVisibility(0);
              g(((bb)localObject1).vIg, parama1);
              ((bb)localObject1).vIe.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.vko.vtz.getContext(), 16), 0);
              break label3944;
              label4600:
              ((bb)localObject1).vIb.setOnClickListener(new u.6(this, (String)localObject3, paramString));
              break label4145;
              ((bb)localObject1).vIb.setVisibility(8);
              break label4154;
              ((bb)localObject1).vHZ.setVisibility(0);
              i = this.vko.vtz.getMMResources().getDimensionPixelOffset(R.f.LargePadding);
              if ((((bb)localObject1).vIa.getVisibility() == 0) && (((bb)localObject1).vIb.getVisibility() == 0))
              {
                ((bb)localObject1).vIa.setGravity(17);
                ((bb)localObject1).vIb.setGravity(17);
                ((bb)localObject1).vIa.setPadding(i, 0, i, 0);
                ((bb)localObject1).vIb.setPadding(i, 0, i, 0);
              }
              for (;;)
              {
                ((bb)localObject1).vHX.setVisibility(0);
                ((bb)localObject1).vHW.setVisibility(0);
                break;
                if (((bb)localObject1).vIa.getVisibility() == 0)
                {
                  if (bk.bl(parama))
                  {
                    ((bb)localObject1).vIa.setGravity(19);
                    ((bb)localObject1).vIa.setPadding(i, 0, 0, 0);
                    ((bb)localObject1).vIh.setVisibility(0);
                  }
                  else
                  {
                    ((bb)localObject1).vIa.setGravity(17);
                    ((bb)localObject1).vIa.setPadding(i, 0, i, 0);
                  }
                }
                else if (bk.bl(parama1))
                {
                  ((bb)localObject1).vIb.setGravity(19);
                  ((bb)localObject1).vIb.setPadding(this.vko.vtz.getMMResources().getDimensionPixelOffset(R.f.LargePadding), 0, 0, 0);
                  ((bb)localObject1).vIh.setVisibility(0);
                }
                else
                {
                  ((bb)localObject1).vIb.setGravity(17);
                  ((bb)localObject1).vIb.setPadding(i, 0, i, 0);
                }
              }
              ((bb)localObject1).vIc.setVisibility(8);
              break label4251;
              parama = ((WxaAttributes)localObject2).field_brandIconURL;
              break label4374;
            }
            label4930:
            label4948:
            ((bb)localObject1).vIi.setVisibility(8);
            break label1588;
            label4961:
            if ((m == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(paramString)))
            {
              localObject4 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
              localObject5 = ((bb)localObject1).vHC;
              paramString = new aw(parambi, false, paramInt, paramString, false, this.vko.cDP(), paramString, parama, (String)localObject3);
              paramString.ceb = ((String)localObject2);
              paramString.vHp = ((String)localObject4);
              ((View)localObject5).setTag(paramString);
              ((bb)localObject1).vHC.setOnClickListener(this.vDS);
              break label1765;
            }
            if (m == 2)
            {
              paramString = new aw(parambi, paramString, (String)localObject4);
              paramString.position = paramInt;
              ((bb)localObject1).vHC.setTag(paramString);
              ((bb)localObject1).vHC.setOnClickListener(this.jDE);
              break label1765;
            }
            localObject5 = ((bb)localObject1).vHC;
            paramString = new aw(parambi, false, paramInt, (String)localObject4, false, this.vko.cDP(), paramString, parama, (String)localObject3);
            paramString.ceb = ((String)localObject2);
            ((View)localObject5).setTag(paramString);
            ((bb)localObject1).vHC.setOnClickListener(g(this.vko));
            break label1765;
            label5191:
            if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)
            {
              paramInt = 1;
              label5214:
              if (paramInt != 0) {
                break label5272;
              }
              y.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            }
            do
            {
              ((bb)localObject1).vHJ.setTag(null);
              ((bb)localObject1).vHK.setTag(null);
              ((bb)localObject1).vHJ.setVisibility(8);
              ((bb)localObject1).vHK.setVisibility(8);
              break;
              paramInt = 0;
              break label5214;
              if (((bb)localObject1).vHE.getVisibility() == 0)
              {
                ((bb)localObject1).vHJ.setTag(parambi);
                ((bb)localObject1).vHJ.setOnClickListener(this.vDQ);
                ((bb)localObject1).vHJ.setVisibility(0);
                ((bb)localObject1).vHK.setVisibility(8);
                break;
              }
            } while (((bb)localObject1).vHO.getVisibility() != 0);
            ((bb)localObject1).vHK.setTag(parambi);
            ((bb)localObject1).vHK.setOnClickListener(this.vDQ);
            ((bb)localObject1).vHK.setVisibility(0);
            ((bb)localObject1).vHJ.setVisibility(8);
          }
          localau.vHb.vHC.setVisibility(8);
          parama1 = bk.pm((String)localMap.get(".msg.fromusername"));
          i = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
          y.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
          if (i == 1)
          {
            parama = bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            paramString = bk.pm((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
            a(localau, j.a(this.vko.vtz.getContext(), paramString, localau.nSa.getTextSize()));
            localau.doU.setTag(null);
            localau.doU.setOnClickListener(null);
            o.ON().a(parama, localau.doU, this.uQN);
            y.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { parambi.field_talker });
            if ((!"notifymessage".equals(parambi.field_talker)) && (i != 1)) {
              break label6197;
            }
            localau.vHa.vHd.setVisibility(0);
            localau.vHa.fcy.setTextSize(0, com.tencent.mm.cb.a.aa(localau.vHa.fcy.getContext(), R.f.NormalTextSize));
            localau.vHa.ifA.setVisibility(0);
            paramString = u.b.az(localMap);
            localau.vHa.fcy.setText(paramString.title);
            localau.vHa.kZl.setText(com.tencent.mm.pluginsdk.f.h.g(this.vko.vtz.getMMResources().getString(R.l.fmt_date), paramString.time));
            v.a(localau.vHa.vHh, localMap);
            parama = null;
            if (!bk.bl(parama1))
            {
              com.tencent.mm.model.au.Hx();
              parama = com.tencent.mm.model.c.Fw().abl(parama1).Bp();
            }
            if (bk.bl(paramString.url)) {
              break label6243;
            }
            i = 1;
            j = bk.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
            localObject1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              break label6249;
            }
            parama1 = new aw(parambi, parama1, paramString.url);
            parama1.position = paramInt;
            localau.vHa.ifA.setTag(parama1);
            localau.vHa.ifA.setOnClickListener(this.jDE);
            i = 1;
            label5859:
            localau.vHa.ifA.setOnLongClickListener(c(this.vko));
            if (i != 0) {
              break label6328;
            }
            localau.vHa.vHi.setVisibility(8);
            localau.vHa.vHg.setVisibility(8);
            if (com.tencent.mm.m.g.AB().Ap())
            {
              localau.vBB.setVisibility(0);
              c(this.vko, localau.vBB, new t.n(paramString.dRD, parambi, parama));
            }
            parama = localau.vHa;
            if (bk.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) != 1) {
              break label6355;
            }
            paramInt = 1;
            label5983:
            if (paramInt != 0) {
              break label6360;
            }
            y.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            parama.vHe.setTag(null);
            parama.vHf.setTag(null);
            parama.vHe.setVisibility(8);
            parama.vHf.setVisibility(8);
          }
          for (;;)
          {
            localau.vHa.ifA.setVisibility(0);
            return;
            a(localau, this.vko, parambi, parama1);
            a(localau.doU, this.vko, parama1, parambi, null);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(parama1))
            {
              localau.vHa.vHd.setTag(new aw(parambi, parama1));
              localau.vHa.vHd.setOnClickListener(this.vDR);
              break;
            }
            paramString = localau.vHa.vHd;
            if (this.vko.cFE()) {}
            for (parama = this.vko.getTalkerUserName();; parama = null)
            {
              paramString.setTag(new aw(parama1, parama));
              localau.vHa.vHd.setOnClickListener(e(this.vko));
              break;
            }
            localau.vHa.vHd.setVisibility(8);
            localau.vHa.fcy.setTextSize(0, com.tencent.mm.cb.a.aa(localau.vHa.fcy.getContext(), R.f.ActionBarTextSize));
            break label5636;
            label6243:
            i = 0;
            break label5760;
            label6249:
            localObject1 = localau.vHa.ifA;
            parama1 = new aw(parambi, false, paramInt, paramString.url, false, this.vko.cDP(), parama1, parama, paramString.title);
            parama1.ceb = paramString.ceb;
            ((View)localObject1).setTag(parama1);
            localau.vHa.ifA.setOnClickListener(g(this.vko));
            break label5859;
            label6328:
            localau.vHa.vHi.setVisibility(0);
            localau.vHa.vHg.setVisibility(0);
            break label5909;
            label6355:
            paramInt = 0;
            break label5983;
            label6360:
            if (parama.vHd.getVisibility() == 0)
            {
              parama.vHe.setTag(parambi);
              parama.vHe.setOnClickListener(this.vDQ);
              parama.vHe.setVisibility(0);
              parama.vHf.setVisibility(8);
            }
            else
            {
              parama.vHf.setTag(parambi);
              parama.vHf.setOnClickListener(this.vDQ);
              parama.vHf.setVisibility(0);
              parama.vHe.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    if ((paramString == null) || (parama.nSa == null)) {
      return;
    }
    parambi = ((com.tencent.mm.ui.chatting.b.b.e)parama1.ac(com.tencent.mm.ui.chatting.b.b.e.class)).adr(paramString);
    a(parama, j.a(parama1.vtz.getContext(), parambi, parama.nSa.getTextSize()));
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    parambi = (aw)paramView.getTag();
    if (parambi == null) {
      return false;
    }
    int i = parambi.position;
    if (!this.vko.cFF()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
    }
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    do
    {
      do
      {
        return false;
        paramMenuItem = bn.s(parambi.field_content, "msg");
      } while ((paramMenuItem == null) || (paramMenuItem.size() == 0));
      paramMenuItem = bk.pm((String)paramMenuItem.get(".msg.fromusername"));
    } while (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.biz.a.a.class)).gr(paramMenuItem));
    B(7, this.mAppId, this.vDV);
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected final boolean cHb()
  {
    return false;
  }
  
  protected final boolean cHd()
  {
    return this.vDW == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u
 * JD-Core Version:    0.7.0.1
 */