package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.o;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class x
  extends c
{
  static int zVi;
  static int zVj;
  private View.OnClickListener lNc;
  private String mAppId;
  private p sHO;
  private com.tencent.mm.sdk.b.c<lt> zJp;
  private View.OnClickListener zVa;
  private View.OnClickListener zVb;
  private View.OnClickListener zVc;
  private View.OnClickListener zVd;
  private l zVe;
  private View.OnClickListener zVf;
  private String zVg;
  private int zVh;
  private com.tencent.mm.at.a.a.c zeX;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  static
  {
    AppMethodBeat.i(33177);
    zVi = Color.parseColor("#888888");
    zVj = Color.parseColor("#888888");
    AppMethodBeat.o(33177);
  }
  
  public x()
  {
    AppMethodBeat.i(33157);
    com.tencent.mm.at.a.a.c.a locala = new com.tencent.mm.at.a.a.c.a();
    locala.eOk = true;
    locala.eNY = 2130838028;
    this.zeX = locala.ahY();
    this.zVb = new x.a(this, (byte)0);
    this.zVa = new x.1(this);
    this.zVf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33138);
        paramAnonymousView = (az)paramAnonymousView.getTag();
        ab.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", new Object[] { paramAnonymousView.userName });
        Object localObject2 = br.F(paramAnonymousView.cEE.field_content, "msg");
        Object localObject1 = bo.nullAsNil((String)((Map)localObject2).get(".msg.fromusername"));
        com.tencent.mm.plugin.report.service.h.qsU.e(11608, new Object[] { x.d(x.this), localObject1, Integer.valueOf(66666) });
        localObject1 = bo.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_username"));
        if (bo.isNullOrNil((String)localObject1))
        {
          paramAnonymousView = bo.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.header_jump_url"));
          if (!bo.isNullOrNil(paramAnonymousView))
          {
            localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", paramAnonymousView);
            com.tencent.mm.bq.d.b(x.b(x.this).zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
          }
          AppMethodBeat.o(33138);
          return;
        }
        String str = bo.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_path"));
        int i = bo.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
        int j = bo.getInt((String)((Map)localObject2).get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
        localObject2 = bo.nullAsNil((String)((Map)localObject2).get(".msg.appmsg.template_id"));
        AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
        localAppBrandStatObject.cmF = (paramAnonymousView.cEE.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + x.b(x.this).getTalkerUserName() + ":" + (String)localObject2);
        localAppBrandStatObject.scene = x.aup((String)localObject2);
        ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(x.b(x.this).zJz.getContext(), (String)localObject1, null, i, j, str, localAppBrandStatObject);
        AppMethodBeat.o(33138);
      }
    };
    this.zVc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33139);
        az localaz = (az)paramAnonymousView.getTag();
        ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) name click", new Object[] { localaz.userName });
        Object localObject = br.F(localaz.cEE.field_content, "msg");
        if ((localObject != null) && (((Map)localObject).size() != 0)) {
          bo.getInt((String)((Map)localObject).get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
        }
        localObject = x.this;
        paramAnonymousView.getContext();
        x.a((x)localObject, localaz.userName);
        AppMethodBeat.o(33139);
      }
    };
    this.zJp = new x.13(this);
    this.zVe = new x.14(this);
    this.zVd = new x.15(this);
    this.lNc = new x.16(this);
    AppMethodBeat.o(33157);
  }
  
  private static void J(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(33168);
    ab.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", new Object[] { Integer.valueOf(13796), Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.mm.plugin.report.service.h.qsU.e(13796, new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, Integer.valueOf(0), Long.valueOf(bo.aox()) });
    AppMethodBeat.o(33168);
  }
  
  private void a(ImageView paramImageView, com.tencent.mm.ui.chatting.d.a parama, String paramString1, bi parambi, String paramString2)
  {
    AppMethodBeat.i(33163);
    if (paramImageView == null)
    {
      AppMethodBeat.o(33163);
      return;
    }
    if (t.oD(paramString1))
    {
      paramImageView.setVisibility(8);
      AppMethodBeat.o(33163);
      return;
    }
    paramImageView.setVisibility(0);
    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(paramString1))
    {
      o.ahG().a(paramString2, paramImageView, this.zeX);
      paramImageView.setTag(new az(parambi, paramString1));
      paramImageView.setOnClickListener(this.zVc);
      paramImageView.setOnLongClickListener(f(parama));
      paramImageView.setContentDescription(s.nE(paramString1) + parama.zJz.getContext().getString(2131297217));
      AppMethodBeat.o(33163);
      return;
    }
    a.b.s(paramImageView, paramString1);
    if (parama.dJG()) {}
    for (parambi = parama.getTalkerUserName();; parambi = null)
    {
      paramImageView.setTag(new az(paramString1, parambi));
      paramImageView.setOnClickListener(e(parama));
      break;
    }
  }
  
  private void a(be parambe, bi parambi, Map<String, String> paramMap)
  {
    AppMethodBeat.i(33166);
    LinearLayout localLinearLayout = parambe.zZt;
    int j = localLinearLayout.getChildCount();
    int i = 0;
    if (i < 10)
    {
      if (i == 0) {}
      String str1;
      String str2;
      for (parambe = ".msg.appmsg.mmreader.template_detail.opitems.opitem";; parambe = ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i)))
      {
        str1 = (String)paramMap.get(parambe + ".word");
        str2 = (String)paramMap.get(parambe + ".hint_word");
        if (!bo.isNullOrNil(str1)) {
          break label193;
        }
        ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", new Object[] { Integer.valueOf(i) });
        j = localLinearLayout.getChildCount();
        if (j <= i) {
          break label1026;
        }
        if (i != 0) {
          break;
        }
        localLinearLayout.removeAllViews();
        AppMethodBeat.o(33166);
        return;
      }
      localLinearLayout.removeViews(i, j - i);
      AppMethodBeat.o(33166);
      return;
      label193:
      Object localObject1;
      label212:
      Object localObject2;
      int k;
      label358:
      int m;
      if (i < j)
      {
        localObject1 = (LinearLayout)localLinearLayout.getChildAt(i);
        localObject1 = (a)((LinearLayout)localObject1).getTag();
        localObject2 = (String)paramMap.get(parambe + ".icon");
        k = e(paramMap, parambe + ".color", -16777216);
        ((a)localObject1).gui.setTextColor(k);
        if (bo.getInt((String)paramMap.get(parambe + ".is_rich_text"), 0) != 0) {
          break label827;
        }
        ((a)localObject1).gui.setSingleLine(true);
        ((a)localObject1).gui.setEllipsize(TextUtils.TruncateAt.END);
        ((a)localObject1).gui.setText(str1);
        ((a)localObject1).gtP.setText(str2);
        if (!bo.isNullOrNil((String)localObject2)) {
          break label925;
        }
        ((a)localObject1).iTH.setVisibility(8);
        ((a)localObject1).gui.setPadding(0, 0, 0, 0);
        label398:
        localObject2 = (String)paramMap.get(parambe + ".url");
        str1 = bo.nullAsNil((String)paramMap.get(".msg.fromusername"));
        m = bo.getInt((String)paramMap.get(parambe + ".op_type"), 0);
        str2 = (String)paramMap.get(parambe + ".weapp_username");
        az localaz = new az(parambi, str1, (String)localObject2);
        ((a)localObject1).zRf.setTag(localaz);
        k = i + 1;
        if ((m != 1) || (TextUtils.isEmpty(str2))) {
          break label973;
        }
        localObject2 = (String)paramMap.get(parambe + ".weapp_path");
        m = bo.getInt((String)paramMap.get(parambe + ".weapp_version"), 0);
        int n = bo.getInt((String)paramMap.get(parambe + ".weapp_state"), 0);
        parambe = new x.8(this, str2, bo.nullAsNil((String)paramMap.get(".msg.appmsg.template_id")), n, m, (String)localObject2, str1, k);
        ((a)localObject1).zRf.setOnClickListener(parambe);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (LinearLayout)LayoutInflater.from(this.zzP.zJz.getContext()).inflate(2130969032, null, false);
        localObject2 = new a();
        ((a)localObject2).gui = ((TextView)((LinearLayout)localObject1).findViewById(2131822463));
        ((a)localObject2).iTH = ((ImageView)((LinearLayout)localObject1).findViewById(2131822464));
        ((a)localObject2).zRf = ((LinearLayout)((LinearLayout)localObject1).findViewById(2131822461));
        ((a)localObject2).gtP = ((TextView)((LinearLayout)localObject1).findViewById(2131822465));
        ((LinearLayout)localObject1).setTag(localObject2);
        localLinearLayout.addView((View)localObject1);
        break label212;
        label827:
        k = bo.getInt((String)paramMap.get(parambe + ".display_line_number"), 1);
        ab.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", new Object[] { Integer.valueOf(k) });
        ((a)localObject1).gui.setSingleLine(false);
        ((a)localObject1).gui.setText(str1);
        ((a)localObject1).gui.setMaxLines(k);
        com.tencent.mm.pluginsdk.ui.d.j.a(((a)localObject1).gui, false, null);
        break label358;
        label925:
        ((a)localObject1).iTH.setVisibility(0);
        i(((a)localObject1).iTH, (String)localObject2);
        ((a)localObject1).gui.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.zzP.zJz.getContext(), 28), 0);
        break label398;
        label973:
        if (m == 2) {
          ((a)localObject1).zRf.setOnClickListener(new x.9(this, k, paramMap));
        } else {
          ((a)localObject1).zRf.setOnClickListener(new x.10(this, (String)localObject2, str1, k));
        }
      }
    }
    label1026:
    AppMethodBeat.o(33166);
  }
  
  private void a(be parambe, String paramString1, String paramString2, Map<String, String> paramMap, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(33164);
    parambe.zZb.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.zzP.zJz.getContext(), paramString2, parambe.zZb.getTextSize()));
    o.ahG().a(paramString1, parambe.zZa, this.zeX);
    parambe.zZa.setTag(null);
    parambe.zZa.setOnClickListener(null);
    parambe.zYZ.setTag(null);
    parambe.zYZ.setOnClickListener(null);
    parambe.zYZ.setVisibility(0);
    paramString1 = bo.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.weapp_username"));
    paramString2 = bo.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
    if ((!bo.isNullOrNil(paramString1)) || (!bo.isNullOrNil(paramString2)))
    {
      paramString1 = bo.nullAsNil((String)paramMap.get(".msg.fromusername"));
      parambe.zYZ.setTag(new az(parambi, paramString1));
      parambe.zYZ.setOnClickListener(this.zVf);
    }
    for (;;)
    {
      paramString1 = bo.nullAsNil((String)paramMap.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
      if ((!paramBoolean) || (bo.isNullOrNil(paramString1))) {
        break;
      }
      ((View)parambe.zZd.getParent()).setVisibility(0);
      o.ahG().a(paramString1, parambe.zZd, this.zeX);
      AppMethodBeat.o(33164);
      return;
      parambe.zYZ.setOnClickListener(null);
    }
    ((View)parambe.zZd.getParent()).setVisibility(8);
    AppMethodBeat.o(33164);
  }
  
  private void a(Map<String, String> paramMap, bi parambi, be parambe, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(33165);
    LinearLayout localLinearLayout = parambe.zZG;
    int i;
    if (paramBoolean1)
    {
      i = 0;
      localLinearLayout.setVisibility(i);
      if (!paramBoolean2) {
        break label108;
      }
      parambe.zZc.setVisibility(0);
      parambe.zZH.setText(this.zzP.zJz.getMMResources().getString(2131301988));
    }
    for (;;)
    {
      parambe.zZG.setTag(2131822566, parambi);
      parambe.zZG.setOnClickListener(new x.18(this, paramMap, paramBoolean2, parambe, parambi));
      AppMethodBeat.o(33165);
      return;
      i = 8;
      break;
      label108:
      parambe.zZc.setVisibility(8);
      parambe.zZH.setText(this.zzP.zJz.getMMResources().getString(2131301970));
    }
  }
  
  private static int auo(String paramString)
  {
    AppMethodBeat.i(33170);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(33170);
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
    AppMethodBeat.o(33170);
    return i;
  }
  
  private static int e(Map<String, String> paramMap, String paramString, int paramInt)
  {
    AppMethodBeat.i(33169);
    if ((paramMap == null) || (bo.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(33169);
      return paramInt;
    }
    try
    {
      int i = Color.parseColor(bo.nullAsNil((String)paramMap.get(paramString)));
      paramInt = i;
    }
    catch (Exception paramMap)
    {
      label44:
      break label44;
    }
    AppMethodBeat.o(33169);
    return paramInt;
  }
  
  private static void i(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(33167);
    if ((bo.isNullOrNil(paramString)) || (paramImageView == null))
    {
      AppMethodBeat.o(33167);
      return;
    }
    Object localObject = new com.tencent.mm.at.a.a.c.a();
    com.tencent.mm.model.aw.aaz();
    ((com.tencent.mm.at.a.a.c.a)localObject).eNP = com.tencent.mm.model.c.YL();
    ((com.tencent.mm.at.a.a.c.a)localObject).eNM = true;
    ((com.tencent.mm.at.a.a.c.a)localObject).eOe = true;
    localObject = ((com.tencent.mm.at.a.a.c.a)localObject).ahY();
    o.ahG().a(paramString, paramImageView, (com.tencent.mm.at.a.a.c)localObject);
    AppMethodBeat.o(33167);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33158);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969059);
      paramLayoutInflater = new ax();
      paramLayoutInflater.mCC = ((CheckBox)((View)localObject).findViewById(2131820579));
      paramLayoutInflater.jbK = ((View)localObject).findViewById(2131820586);
      paramLayoutInflater.qFY = ((TextView)((View)localObject).findViewById(2131821122));
      paramLayoutInflater.zRz = ((AvatarImageView)((View)localObject).findViewById(2131821121));
      paramLayoutInflater.ekh = ((TextView)((View)localObject).findViewById(2131820587));
      paramLayoutInflater.jYa = ((LinearLayout)((View)localObject).findViewById(2131822517));
      paramLayoutInflater.zYw.jXr = ((View)localObject).findViewById(2131822525);
      paramLayoutInflater.zYw.zYz = ((View)localObject).findViewById(2131822567);
      paramLayoutInflater.zYw.gui = ((TextView)paramLayoutInflater.zYw.jXr.findViewById(2131820680));
      paramLayoutInflater.zYw.nxi = ((TextView)paramLayoutInflater.zYw.jXr.findViewById(2131822569));
      paramLayoutInflater.zYw.zYD = ((LinearLayout)paramLayoutInflater.zYw.jXr.findViewById(2131822571));
      paramLayoutInflater.zYw.zYC = ((TextView)paramLayoutInflater.jYa.findViewById(2131822524));
      paramLayoutInflater.zYw.zYE = paramLayoutInflater.jYa.findViewById(2131822572);
      paramLayoutInflater.zYw.zYA = ((View)localObject).findViewById(2131822568);
      paramLayoutInflater.zYw.zYB = ((View)localObject).findViewById(2131822570);
      paramLayoutInflater.zYx.zYX = ((View)localObject).findViewById(2131822526);
      paramLayoutInflater.zYx.zYY = ((ImageView)((View)localObject).findViewById(2131822535));
      paramLayoutInflater.zYx.zYZ = ((View)localObject).findViewById(2131822529);
      paramLayoutInflater.zYx.zZb = ((TextView)((View)localObject).findViewById(2131822531));
      paramLayoutInflater.zYx.zZa = ((ImageView)((View)localObject).findViewById(2131822530));
      paramLayoutInflater.zYx.zZc = ((View)localObject).findViewById(2131822532);
      paramLayoutInflater.zYx.zZd = ((ImageView)((View)localObject).findViewById(2131822534));
      paramLayoutInflater.zYx.zZe = ((View)localObject).findViewById(2131822533);
      paramLayoutInflater.zYx.zZf = ((View)localObject).findViewById(2131822539);
      paramLayoutInflater.zYx.zZg = ((TextView)((View)localObject).findViewById(2131822537));
      paramLayoutInflater.zYx.zZh = ((TextView)((View)localObject).findViewById(2131822538));
      paramLayoutInflater.zYx.zZi = ((TextView)((View)localObject).findViewById(2131822540));
      paramLayoutInflater.zYx.zZj = ((View)localObject).findViewById(2131822536);
      paramLayoutInflater.zYx.zZk = ((LinearLayout)((View)localObject).findViewById(2131822541));
      paramLayoutInflater.zYx.zZl = ((TextView)((View)localObject).findViewById(2131822542));
      paramLayoutInflater.zYx.zZn = ((TextView)((View)localObject).findViewById(2131822544));
      paramLayoutInflater.zYx.zZm = ((TextView)((View)localObject).findViewById(2131822543));
      paramLayoutInflater.zYx.zZo = ((TextView)((View)localObject).findViewById(2131822545));
      paramLayoutInflater.zYx.zZp = ((View)localObject).findViewById(2131822546);
      paramLayoutInflater.zYx.zZq = ((LinearLayout)((View)localObject).findViewById(2131822551));
      paramLayoutInflater.zYx.zZu = ((View)localObject).findViewById(2131821513);
      paramLayoutInflater.zYx.zZr = ((View)localObject).findViewById(2131822552);
      paramLayoutInflater.zYx.zZs = ((LinearLayout)((View)localObject).findViewById(2131822553));
      paramLayoutInflater.zYx.zZt = ((LinearLayout)((View)localObject).findViewById(2131822564));
      paramLayoutInflater.zYx.zZv = ((LinearLayout)((View)localObject).findViewById(2131822554));
      paramLayoutInflater.zYx.zZy = ((TextView)((View)localObject).findViewById(2131822555));
      paramLayoutInflater.zYx.zZA = ((ImageView)((View)localObject).findViewById(2131822556));
      paramLayoutInflater.zYx.zZx = ((View)localObject).findViewById(2131822557);
      paramLayoutInflater.zYx.zZw = ((LinearLayout)((View)localObject).findViewById(2131822558));
      paramLayoutInflater.zYx.zZz = ((TextView)((View)localObject).findViewById(2131822559));
      paramLayoutInflater.zYx.zZB = ((ImageView)((View)localObject).findViewById(2131822560));
      paramLayoutInflater.zYx.zZC = ((ImageView)((View)localObject).findViewById(2131822466));
      paramLayoutInflater.zSa = ((ImageView)((View)localObject).findViewById(2131822527));
      paramLayoutInflater.zYx.zZD = ((View)localObject).findViewById(2131822561);
      paramLayoutInflater.zYx.zZE = ((ImageView)((View)localObject).findViewById(2131822562));
      paramLayoutInflater.zYx.zZF = ((TextView)((View)localObject).findViewById(2131822563));
      paramLayoutInflater.zYx.zZG = ((LinearLayout)((View)localObject).findViewById(2131822565));
      paramLayoutInflater.zYx.zZH = ((TextView)((View)localObject).findViewById(2131822566));
      paramLayoutInflater.zYy.zRg = ((LinearLayout)((View)localObject).findViewById(2131822547));
      paramLayoutInflater.zYy.zRh = ((CdnImageView)((View)localObject).findViewById(2131822548));
      paramLayoutInflater.zYy.zRi = ((TextView)((View)localObject).findViewById(2131822549));
      paramLayoutInflater.zYy.zRj = ((TextView)((View)localObject).findViewById(2131822550));
      ((View)localObject).setTag(paramLayoutInflater);
    }
    AppMethodBeat.o(33158);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, bi parambi, final String paramString)
  {
    AppMethodBeat.i(33159);
    this.zzP = parama1;
    ax localax = (ax)parama;
    Map localMap = br.F(parambi.field_content, "msg");
    if ((localMap == null) || (localMap.size() == 0))
    {
      ab.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
      localax.jYa.setVisibility(8);
      AppMethodBeat.o(33159);
      return;
    }
    localax.jYa.setVisibility(0);
    final int j = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
    this.zVg = bo.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
    this.zVh = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
    com.tencent.mm.sdk.b.a.ymk.d(this.zJp);
    ((com.tencent.mm.ui.chatting.c.b.g)parama1.ay(com.tencent.mm.ui.chatting.c.b.g.class)).b(this.zVe);
    Object localObject1;
    if (j != 0)
    {
      localax.zYw.jXr.setVisibility(8);
      localObject1 = localax.zYx;
      if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1)
      {
        a((be)localObject1, bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), localMap, parambi, false);
        if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) == 0) {
          break label2355;
        }
        ((be)localObject1).zYZ.setBackgroundResource(2130839676);
        label289:
        if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) != 0) {
          break label6566;
        }
      }
    }
    label526:
    label3346:
    label3873:
    label6563:
    label6566:
    for (final int i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);; i = 0)
    {
      int m = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
      int k = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.hide_time"), 0);
      ((be)localObject1).zZg.setVisibility(8);
      ((be)localObject1).zZh.setVisibility(8);
      if (i == 0)
      {
        if (m == 0)
        {
          ((be)localObject1).zZg.setVisibility(0);
          parama = bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.title"));
          m = e(localMap, ".msg.appmsg.mmreader.template_header.title_color", -16777216);
          ((be)localObject1).zZg.setTextColor(m);
          ((be)localObject1).zZg.setText(parama);
        }
        if (k == 0)
        {
          long l = bo.getLong(bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.pub_time")), 0L);
          if (l <= 0L) {
            break label2392;
          }
          ((be)localObject1).zZh.setText(com.tencent.mm.pluginsdk.f.h.formatTime(this.zzP.zJz.getMMResources().getString(2131300034), l));
          ((be)localObject1).zZh.setVisibility(0);
        }
      }
      parama = bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
      k = e(localMap, ".msg.appmsg.mmreader.template_header.first_color", zVj);
      label573:
      label595:
      boolean bool1;
      boolean bool4;
      boolean bool2;
      boolean bool3;
      if (bo.isNullOrNil(parama))
      {
        ((be)localObject1).zZi.setVisibility(8);
        if ((i == 0) || (!bo.isNullOrNil(parama))) {
          break label2484;
        }
        ((be)localObject1).zZj.setVisibility(8);
        bool1 = false;
        bool4 = false;
        bool2 = bool4;
        if ("notifymessage".equals(parambi.field_talker))
        {
          parama = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
          bool3 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(parama);
          bool1 = bool3;
          bool2 = bool4;
          if (bool3)
          {
            ((com.tencent.mm.ui.chatting.c.b.g)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.g.class)).a(this.zVe);
            com.tencent.mm.sdk.b.a.ymk.c(this.zJp);
            parama1 = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(parama);
            if (parama1 == null) {
              break label2502;
            }
            this.mAppId = parama1.field_appId;
            if ((parama1.field_appOpt & 0x1) <= 0) {
              break label2496;
            }
            bool1 = true;
            label738:
            bool2 = bool1;
            bool1 = bool3;
          }
        }
        label746:
        parama = ((be)localObject1).zZe;
        if (!bool1) {
          break label2558;
        }
        i = 0;
        label760:
        parama.setVisibility(i);
        ((be)localObject1).zZe.setTag(2131822533, parambi);
        ((be)localObject1).zZe.setOnClickListener(this.zVa);
        a(localMap, parambi, (be)localObject1, bool1, bool2);
        ((be)localObject1).zYY.setVisibility(8);
        parama = bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.first_data"));
        ((be)localObject1).zZi.setText(parama);
        parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
        parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
        paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
        if (bo.isNullOrNil(parama1)) {
          break label2622;
        }
        i = e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", -16777216);
        j = e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", -16777216);
        k = e(localMap, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", -16777216);
        m = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
        ((be)localObject1).zZl.setTextColor(i);
        ((be)localObject1).zZn.setTextColor(j);
        ((be)localObject1).zZo.setTextColor(k);
        ((be)localObject1).zZo.getPaint().setFlags(16);
        ((be)localObject1).zZl.setText(parama);
        if ((m <= 0) || (m >= parama1.length())) {
          break label2565;
        }
        ((be)localObject1).zZm.setVisibility(0);
        ((be)localObject1).zZm.setText(parama1.substring(0, m));
        ((be)localObject1).zZm.setTextColor(j);
        ((be)localObject1).zZm.setTypeface(((com.tencent.mm.pluginsdk.wallet.c)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.c.class)).eA(this.zzP.zJz.getContext()));
        ((be)localObject1).zZn.setTypeface(((com.tencent.mm.pluginsdk.wallet.c)com.tencent.mm.kernel.g.E(com.tencent.mm.pluginsdk.wallet.c.class)).eA(this.zzP.zJz.getContext()));
        ((be)localObject1).zZn.setText(parama1.substring(m));
        label1127:
        if (bo.isNullOrNil(paramString)) {
          break label2609;
        }
        ((be)localObject1).zZo.setText(paramString);
        ((be)localObject1).zZo.setVisibility(0);
        ((be)localObject1).zZk.setVisibility(0);
        m = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
        if (m != 2) {
          break label2787;
        }
        ab.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
        ((be)localObject1).zZh.setVisibility(8);
        ((be)localObject1).zZq.setVisibility(8);
        parama1 = (ViewGroup)((be)localObject1).zZq.getParent();
        parama = parama1.findViewById(2131824682);
        if (parama != null) {
          break label6563;
        }
        parama = LayoutInflater.from(parama1.getContext()).inflate(2130970566, null);
        paramString = new aw();
        paramString.iTH = ((ImageView)parama.findViewById(2131823820));
        paramString.zYv = ((TextView)parama.findViewById(2131827179));
        paramString.nxi = ((TextView)parama.findViewById(2131822569));
        paramString.gui = ((TextView)parama.findViewById(2131820680));
        parama.setTag(paramString);
        parama1.addView(parama);
      }
      for (;;)
      {
        parama.setVisibility(0);
        paramString = (aw)parama.getTag();
        parama = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_content");
        Object localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_username");
        parama1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
        Object localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_time");
        i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
        paramString.gui.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramString.gui.getContext(), parama));
        Object localObject4 = paramString.zYv;
        Object localObject5 = paramString.gui.getContext();
        if (bo.isNullOrNil((String)localObject2)) {
          parama = "";
        }
        for (;;)
        {
          ((TextView)localObject4).setText(com.tencent.mm.pluginsdk.ui.d.j.b((Context)localObject5, parama));
          paramString.nxi.setText((CharSequence)localObject3);
          if (i == 2)
          {
            paramString.iTH.setImageDrawable(ah.getContext().getResources().getDrawable(2130837707));
            label1522:
            if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) == 0) {
              break label3548;
            }
            ((be)localObject1).zZD.setVisibility(8);
            ((be)localObject1).zZs.setVisibility(8);
            ((be)localObject1).zZu.setVisibility(8);
            ((be)localObject1).zZt.setVisibility(0);
            ((be)localObject1).zZr.setVisibility(0);
            a((be)localObject1, parambi, localMap);
            label1600:
            paramString = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
            parama = null;
            if (!bo.isNullOrNil(paramString))
            {
              com.tencent.mm.model.aw.aaz();
              parama = com.tencent.mm.model.c.YA().arw(paramString).Oe();
            }
            localObject3 = (String)localMap.get(".msg.appmsg.mmreader.category.item.title");
            localObject4 = (String)localMap.get(".msg.appmsg.mmreader.category.item.url");
            localObject2 = (String)localMap.get(".msg.appmsg.mmreader.category.item.native_url");
            parama1 = (String)localMap.get(".msg.appmsg.template_id");
            localObject5 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if ((m != 1) || (TextUtils.isEmpty((CharSequence)localObject5))) {
              break label4998;
            }
            paramString = new az(parambi, paramString, (String)localObject4);
            paramString.position = paramInt;
            ((be)localObject1).zYX.setTag(paramString);
            ((be)localObject1).zYX.setOnClickListener(this.lNc);
            label1777:
            ((be)localObject1).zYX.setOnLongClickListener(c(this.zzP));
            ((be)localObject1).zYX.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
            if (com.tencent.mm.m.g.Nr().Nf())
            {
              localax.zSa.setVisibility(0);
              c(this.zzP, localax.zSa, new s.o(parama1, parambi, parama));
            }
            parama = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
            if ((!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(parama)) || (!"notifymessage".equals(parambi.field_talker))) {
              break label5228;
            }
            ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
            ((be)localObject1).zZf.setTag(null);
            ((be)localObject1).zZf.setVisibility(8);
          }
          for (;;)
          {
            localax.zYx.zYX.setVisibility(0);
            AppMethodBeat.o(33159);
            return;
            if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0)
            {
              a((be)localObject1, bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.icon_url")), bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_header.display_name")), localMap, parambi, true);
              break;
            }
            ((View)((be)localObject1).zZd.getParent()).setVisibility(8);
            if ("notifymessage".equals(parambi.field_talker))
            {
              parama1 = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
              if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(parama1))
              {
                paramString = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(parama1);
                if (paramString == null)
                {
                  parama = null;
                  label2108:
                  a(((be)localObject1).zZa, this.zzP, parama1, parambi, parama);
                  if (paramString != null) {
                    break label2230;
                  }
                  parama = parama1;
                }
              }
              for (;;)
              {
                ((be)localObject1).zZb.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.zzP.zJz.getContext(), parama, ((be)localObject1).zZb.getTextSize()));
                if (!((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(parama1)) {
                  break label2279;
                }
                ((be)localObject1).zYZ.setTag(new az(parambi, parama1));
                ((be)localObject1).zYZ.setOnClickListener(this.zVc);
                ((be)localObject1).zYZ.setVisibility(0);
                break;
                parama = paramString.field_brandIconURL;
                break label2108;
                label2230:
                parama = paramString.field_nickname;
                continue;
                a(((be)localObject1).zZa, this.zzP, parama1, parambi, null);
                parama = ((com.tencent.mm.ui.chatting.c.b.f)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.f.class)).atS(parama1);
              }
              label2279:
              paramString = ((be)localObject1).zYZ;
              if (this.zzP.dJG()) {}
              for (parama = this.zzP.getTalkerUserName();; parama = null)
              {
                paramString.setTag(new az(parama1, parama));
                ((be)localObject1).zYZ.setOnClickListener(e(this.zzP));
                break;
              }
            }
            ((be)localObject1).zYZ.setVisibility(8);
            break;
            label2355:
            i = ((be)localObject1).zYZ.getPaddingLeft();
            ((be)localObject1).zYZ.setBackgroundResource(2130839276);
            ((be)localObject1).zYZ.setPadding(i, 0, 0, 0);
            break label289;
            label2392:
            ((be)localObject1).zZh.setVisibility(8);
            break label526;
            ((be)localObject1).zZi.setTextColor(k);
            ((be)localObject1).zZi.setText(parama);
            ((be)localObject1).zZi.setVisibility(0);
            if (j == 2)
            {
              ((be)localObject1).zZi.setPadding(0, this.zzP.zJz.getMMResources().getDimensionPixelOffset(2131427772), 0, 0);
              break label573;
            }
            ((be)localObject1).zZi.setPadding(0, 0, 0, 0);
            break label573;
            label2484:
            ((be)localObject1).zZj.setVisibility(0);
            break label595;
            label2496:
            bool1 = false;
            break label738;
            label2502:
            ab.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", new Object[] { parama });
            ((i)com.tencent.mm.kernel.g.E(i.class)).a(parama, new x.17(this, localMap, parambi, (be)localObject1));
            bool1 = bool3;
            bool2 = bool4;
            break label746;
            label2558:
            i = 8;
            break label760;
            ((be)localObject1).zZm.setTypeface(Typeface.DEFAULT);
            ((be)localObject1).zZm.setVisibility(8);
            ((be)localObject1).zZn.setTypeface(Typeface.DEFAULT);
            ((be)localObject1).zZn.setText(parama1);
            break label1127;
            label2609:
            ((be)localObject1).zZo.setVisibility(8);
            break label1154;
            label2622:
            ((be)localObject1).zZk.setVisibility(8);
            break label1163;
            parama = null;
            ad localad;
            if (t.lA((String)localObject2))
            {
              com.tencent.mm.model.aw.aaz();
              localad = com.tencent.mm.model.c.YA().arw((String)localObject2);
              if (localad != null)
              {
                if (localad.Of() != null) {
                  break label2727;
                }
                parama = localad.Oe();
              }
            }
            for (;;)
            {
              if (!bo.isNullOrNil(parama)) {
                break label6560;
              }
              ab.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", new Object[] { localObject2, parama1 });
              parama = parama1;
              if (parama1 != null) {
                break;
              }
              parama = ah.getContext().getString(2131298302);
              break;
              label2727:
              parama = localad.Of();
              continue;
              com.tencent.mm.model.aw.aaz();
              parama = com.tencent.mm.model.c.YA().arw((String)localObject2);
              if (parama.Of() == null) {
                parama = parama.Oe();
              } else {
                parama = parama.Of();
              }
            }
            a.b.c(paramString.iTH, (String)localObject2);
            break label1522;
            label2787:
            parama1 = new ArrayList();
            i = 0;
            j = 0;
            if (j < 100)
            {
              if (j == 0)
              {
                parama = ".msg.appmsg.mmreader.template_detail.line_content.lines.line";
                paramString = (String)localMap.get(parama + ".value.word");
                localObject2 = (String)localMap.get(parama + ".key.word");
                if ((!bo.isNullOrNil(paramString)) || (!bo.isNullOrNil((String)localObject2))) {
                  break label3122;
                }
                ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", new Object[] { Integer.valueOf(j) });
              }
            }
            else
            {
              if (i <= 8) {
                break label3313;
              }
              i = 8;
              label2928:
              paramString = ((be)localObject1).zZq;
              paramString.setVisibility(0);
              parama = ((ViewGroup)((be)localObject1).zZq.getParent()).findViewById(2131824682);
              if (parama != null) {
                parama.setVisibility(8);
              }
              if (paramString.getChildCount() > parama1.size())
              {
                if (parama1.size() != 0) {
                  break label3316;
                }
                paramString.removeAllViews();
              }
              label2997:
              k = paramString.getChildCount();
              j = 0;
              label3007:
              if (j >= parama1.size()) {
                break label3469;
              }
              localObject2 = (bb)parama1.get(j);
              if (j >= k) {
                break label3346;
              }
              parama = (LinearLayout)paramString.getChildAt(j);
              label3049:
              parama = (bc)parama.getTag();
              if (!((bb)localObject2).zYT) {
                break label3425;
              }
              parama.zYU.setVisibility(8);
            }
            for (;;)
            {
              parama.zYV.setTextColor(((bb)localObject2).zYS);
              parama.zYV.setText(((bb)localObject2).zYQ);
              j += 1;
              break label3007;
              parama = ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(j));
              break label2817;
              label3122:
              localObject3 = new bb();
              ((bb)localObject3).zYQ = paramString;
              ((bb)localObject3).zYP = bo.nullAsNil((String)localObject2);
              ((bb)localObject3).zYR = e(localMap, parama + ".key.color", zVi);
              ((bb)localObject3).zYS = e(localMap, parama + ".value.color", -16777216);
              if (bo.getInt((String)localMap.get(parama + ".key.hide"), 0) != 0)
              {
                bool1 = true;
                label3254:
                ((bb)localObject3).zYT = bool1;
                k = (auo(((bb)localObject3).zYP) + 1) / 2;
                if (k <= i) {
                  break label3310;
                }
                i = k;
              }
              label3310:
              for (;;)
              {
                parama1.add(localObject3);
                j += 1;
                break;
                bool1 = false;
                break label3254;
              }
              label3313:
              break label2928;
              label3316:
              j = paramString.getChildCount();
              paramString.removeViews(parama1.size(), j - parama1.size());
              break label2997;
              parama = (LinearLayout)LayoutInflater.from(this.zzP.zJz.getContext()).inflate(2130969033, null, false);
              localObject3 = new bc();
              ((bc)localObject3).zYU = ((TextView)parama.findViewById(2131822467));
              ((bc)localObject3).zYV = ((TextView)parama.findViewById(2131822468));
              parama.setTag(localObject3);
              paramString.addView(parama);
              break label3049;
              label3425:
              parama.zYU.setVisibility(0);
              parama.zYU.setEms(i);
              parama.zYU.setTextColor(((bb)localObject2).zYR);
              parama.zYU.setText(((bb)localObject2).zYP);
            }
            if (paramString.getChildCount() == 0)
            {
              ((be)localObject1).zZp.setVisibility(8);
              paramString.setVisibility(8);
              break label1522;
            }
            if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
              ((be)localObject1).zZp.setVisibility(8);
            }
            for (;;)
            {
              paramString.setVisibility(0);
              break;
              ((be)localObject1).zZp.setVisibility(0);
            }
            label3548:
            ((be)localObject1).zZt.setVisibility(8);
            parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
            parama = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
            if (!bo.isNullOrNil(parama1))
            {
              i = e(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", -16777216);
              ((be)localObject1).zZy.setTextColor(i);
              ((be)localObject1).zZy.setText(parama1);
              if (bo.isNullOrNil(parama))
              {
                ((be)localObject1).zZA.setVisibility(8);
                ((be)localObject1).zZy.setPadding(0, 0, 0, 0);
                label3654:
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                parama1 = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
                i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                localObject3 = new az(parambi, parama1, (String)localObject2);
                ((be)localObject1).zZv.setTag(localObject3);
                ((be)localObject1).zZD.setTag(localObject3);
                if ((i != 1) || (TextUtils.isEmpty(paramString))) {
                  break label4546;
                }
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                j = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                parama1 = new View.OnClickListener()
                {
                  public final void onClick(View paramAnonymousView)
                  {
                    AppMethodBeat.i(33129);
                    paramAnonymousView = (az)paramAnonymousView.getTag();
                    ab.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[] { paramString });
                    AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
                    localAppBrandStatObject.cmF = (paramAnonymousView.cEE.field_msgSvrId + ":" + paramAnonymousView.userName + ":" + x.b(x.this).getTalkerUserName() + ":" + this.hZl);
                    if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(paramAnonymousView.userName))
                    {
                      localAppBrandStatObject.scene = x.aup(this.hZl);
                      ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(x.b(x.this).zJz.getContext(), paramString, null, j, i, this.zVv, localAppBrandStatObject);
                      x.K(9, x.c(x.this), x.d(x.this));
                      com.tencent.mm.plugin.report.service.h.qsU.e(11608, new Object[] { x.d(x.this), parama1, Integer.valueOf(1) });
                      AppMethodBeat.o(33129);
                      return;
                    }
                    localAppBrandStatObject.scene = 1043;
                    paramAnonymousView = com.tencent.mm.aj.f.rS(paramAnonymousView.userName);
                    com.tencent.mm.plugin.appbrand.service.j localj = (com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class);
                    Activity localActivity = x.b(x.this).zJz.getContext();
                    String str1 = paramString;
                    int i = j;
                    int j = i;
                    String str2 = this.zVv;
                    if (paramAnonymousView == null) {}
                    for (paramAnonymousView = null;; paramAnonymousView = paramAnonymousView.field_appId)
                    {
                      localj.a(localActivity, str1, null, i, j, str2, localAppBrandStatObject, paramAnonymousView);
                      break;
                    }
                  }
                };
                ((be)localObject1).zZv.setOnClickListener(parama1);
                ((be)localObject1).zZD.setOnClickListener(parama1);
                ((be)localObject1).zZv.setVisibility(0);
                label3882:
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                parama1 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                if (bo.isNullOrNil(paramString)) {
                  break label4660;
                }
                i = e(localMap, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", -16777216);
                ((be)localObject1).zZz.setTextColor(i);
                ((be)localObject1).zZz.setText(paramString);
                if (!bo.isNullOrNil(parama1)) {
                  break label4590;
                }
                ((be)localObject1).zZB.setVisibility(8);
                ((be)localObject1).zZz.setPadding(0, 0, 0, 0);
                localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                paramString = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
                i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                localObject2 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                ((be)localObject1).zZw.setTag(new az(parambi, paramString, (String)localObject3));
                if ((i != 1) || (TextUtils.isEmpty((CharSequence)localObject2))) {
                  break label4637;
                }
                localObject3 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                j = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                localObject4 = bo.nullAsNil((String)localMap.get(".msg.appmsg.template_id"));
                ((be)localObject1).zZw.setOnClickListener(new x.5(this, (String)localObject2, (String)localObject4, j, i, (String)localObject3, paramString));
                label4182:
                ((be)localObject1).zZw.setVisibility(0);
                label4191:
                ((be)localObject1).zZC.setVisibility(8);
                if ((((be)localObject1).zZv.getVisibility() != 8) || (((be)localObject1).zZw.getVisibility() != 8)) {
                  break label4673;
                }
                ((be)localObject1).zZs.setVisibility(8);
                ((be)localObject1).zZr.setVisibility(8);
                ((be)localObject1).zZu.setVisibility(8);
                if ((((be)localObject1).zZv.getVisibility() != 0) || (((be)localObject1).zZw.getVisibility() != 0)) {
                  break label4954;
                }
                ((be)localObject1).zZx.setVisibility(0);
                label4288:
                parama = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
                i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                paramString = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if ((ad.na(parama)) || (((be)localObject1).zZv.getVisibility() == 8) || (((be)localObject1).zZw.getVisibility() != 8) || (i != 1) || (!ad.na(paramString))) {
                  break label4985;
                }
                localObject2 = ((i)com.tencent.mm.kernel.g.E(i.class)).Ae(paramString);
                if (localObject2 != null) {
                  break label4967;
                }
                parama = null;
                label4411:
                if (localObject2 != null) {
                  break label4976;
                }
              }
            }
            label4546:
            label4590:
            label4976:
            for (parama1 = paramString;; parama1 = ((WxaAttributes)localObject2).field_nickname)
            {
              o.ahG().a(parama, ((be)localObject1).zZE, this.zeX);
              ((be)localObject1).zZF.setText(parama1);
              if (localObject2 == null) {
                ((i)com.tencent.mm.kernel.g.E(i.class)).a(paramString, new x.7(this, (be)localObject1, paramString));
              }
              ((be)localObject1).zZD.setVisibility(0);
              ((be)localObject1).zZs.setVisibility(8);
              break;
              ((be)localObject1).zZA.setVisibility(0);
              i(((be)localObject1).zZA, parama);
              ((be)localObject1).zZy.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.zzP.zJz.getContext(), 16), 0);
              break label3654;
              ((be)localObject1).zZv.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(33130);
                  if (!bo.isNullOrNil(this.val$url))
                  {
                    paramAnonymousView = new Intent();
                    paramAnonymousView.putExtra("rawUrl", this.val$url);
                    com.tencent.mm.bq.d.b(x.b(x.this).zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousView);
                    com.tencent.mm.plugin.report.service.h.qsU.e(11608, new Object[] { x.d(x.this), parama1, Integer.valueOf(1) });
                  }
                  AppMethodBeat.o(33130);
                }
              });
              ((be)localObject1).zZD.setOnClickListener(null);
              break label3873;
              ((be)localObject1).zZv.setVisibility(8);
              break label3882;
              ((be)localObject1).zZB.setVisibility(0);
              i(((be)localObject1).zZB, parama1);
              ((be)localObject1).zZz.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.zzP.zJz.getContext(), 16), 0);
              break label3981;
              ((be)localObject1).zZw.setOnClickListener(new x.6(this, (String)localObject3, paramString));
              break label4182;
              ((be)localObject1).zZw.setVisibility(8);
              break label4191;
              ((be)localObject1).zZu.setVisibility(0);
              i = this.zzP.zJz.getMMResources().getDimensionPixelOffset(2131427772);
              if ((((be)localObject1).zZv.getVisibility() == 0) && (((be)localObject1).zZw.getVisibility() == 0))
              {
                ((be)localObject1).zZv.setGravity(17);
                ((be)localObject1).zZw.setGravity(17);
                ((be)localObject1).zZv.setPadding(i, 0, i, 0);
                ((be)localObject1).zZw.setPadding(i, 0, i, 0);
              }
              for (;;)
              {
                ((be)localObject1).zZs.setVisibility(0);
                ((be)localObject1).zZr.setVisibility(0);
                break;
                if (((be)localObject1).zZv.getVisibility() == 0)
                {
                  if (bo.isNullOrNil(parama))
                  {
                    ((be)localObject1).zZv.setGravity(19);
                    ((be)localObject1).zZv.setPadding(i, 0, 0, 0);
                    ((be)localObject1).zZC.setVisibility(0);
                  }
                  else
                  {
                    ((be)localObject1).zZv.setGravity(17);
                    ((be)localObject1).zZv.setPadding(i, 0, i, 0);
                  }
                }
                else if (bo.isNullOrNil(parama1))
                {
                  ((be)localObject1).zZw.setGravity(19);
                  ((be)localObject1).zZw.setPadding(this.zzP.zJz.getMMResources().getDimensionPixelOffset(2131427772), 0, 0, 0);
                  ((be)localObject1).zZC.setVisibility(0);
                }
                else
                {
                  ((be)localObject1).zZw.setGravity(17);
                  ((be)localObject1).zZw.setPadding(i, 0, i, 0);
                }
              }
              ((be)localObject1).zZx.setVisibility(8);
              break label4288;
              parama = ((WxaAttributes)localObject2).field_brandIconURL;
              break label4411;
            }
            label4660:
            label4673:
            label4954:
            label4967:
            label4985:
            ((be)localObject1).zZD.setVisibility(8);
            break label1600;
            if ((m == -1) && (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(paramString)))
            {
              localObject4 = (String)localMap.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
              localObject5 = ((be)localObject1).zYX;
              paramString = new az(parambi, false, paramInt, paramString, false, this.zzP.dHF(), paramString, parama, (String)localObject3);
              paramString.cMO = ((String)localObject2);
              paramString.hAg = ((String)localObject4);
              ((View)localObject5).setTag(paramString);
              ((be)localObject1).zYX.setOnClickListener(this.zVd);
              break label1777;
            }
            if (m == 2)
            {
              paramString = new az(parambi, paramString, (String)localObject4);
              paramString.position = paramInt;
              ((be)localObject1).zYX.setTag(paramString);
              ((be)localObject1).zYX.setOnClickListener(this.lNc);
              break label1777;
            }
            localObject5 = ((be)localObject1).zYX;
            paramString = new az(parambi, false, paramInt, (String)localObject4, false, this.zzP.dHF(), paramString, parama, (String)localObject3);
            paramString.cMO = ((String)localObject2);
            ((View)localObject5).setTag(paramString);
            ((be)localObject1).zYX.setOnClickListener(h(this.zzP));
            break label1777;
            label5228:
            if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)
            {
              paramInt = 1;
              if (paramInt != 0) {
                break label5309;
              }
              ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            }
            label5309:
            do
            {
              ((be)localObject1).zZe.setTag(null);
              ((be)localObject1).zZf.setTag(null);
              ((be)localObject1).zZe.setVisibility(8);
              ((be)localObject1).zZf.setVisibility(8);
              break;
              paramInt = 0;
              break label5251;
              if (((be)localObject1).zYZ.getVisibility() == 0)
              {
                ((be)localObject1).zZe.setTag(parambi);
                ((be)localObject1).zZe.setOnClickListener(this.zVb);
                ((be)localObject1).zZe.setVisibility(0);
                ((be)localObject1).zZf.setVisibility(8);
                break;
              }
            } while (((be)localObject1).zZj.getVisibility() != 0);
            ((be)localObject1).zZf.setTag(parambi);
            ((be)localObject1).zZf.setOnClickListener(this.zVb);
            ((be)localObject1).zZf.setVisibility(0);
            ((be)localObject1).zZe.setVisibility(8);
          }
          localax.zYx.zYX.setVisibility(8);
          parama1 = bo.nullAsNil((String)localMap.get(".msg.fromusername"));
          i = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
          ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", new Object[] { Integer.valueOf(i) });
          if (i == 1)
          {
            parama = bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            paramString = bo.nullAsNil((String)localMap.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name"));
            a(localax, com.tencent.mm.pluginsdk.ui.d.j.b(this.zzP.zJz.getContext(), paramString, localax.qFY.getTextSize()));
            localax.zRz.setTag(null);
            localax.zRz.setOnClickListener(null);
            o.ahG().a(parama, localax.zRz, this.zeX);
            ab.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", new Object[] { parambi.field_talker });
            if ((!"notifymessage".equals(parambi.field_talker)) && (i != 1)) {
              break label6291;
            }
            localax.zYw.zYz.setVisibility(0);
            localax.zYw.gui.setTextSize(0, com.tencent.mm.cb.a.ao(localax.zYw.gui.getContext(), 2131427809));
            label5673:
            localax.zYw.jXr.setVisibility(0);
            paramString = x.b.aY(localMap);
            localax.zYw.gui.setText(paramString.title);
            if (paramString.time <= 0L) {
              break label6337;
            }
            localax.zYw.nxi.setVisibility(0);
            localax.zYw.nxi.setText(com.tencent.mm.pluginsdk.f.h.formatTime(this.zzP.zJz.getMMResources().getString(2131300031), paramString.time));
            y.a(localax.zYw.zYD, localMap);
            parama = null;
            if (!bo.isNullOrNil(parama1))
            {
              com.tencent.mm.model.aw.aaz();
              parama = com.tencent.mm.model.c.YA().arw(parama1).Oe();
            }
            if (bo.isNullOrNil(paramString.url)) {
              break label6353;
            }
            i = 1;
            label5819:
            j = bo.getInt((String)localMap.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
            localObject1 = (String)localMap.get(".msg.appmsg.mmreader.category.item.weapp_username");
            if ((j != 1) || (TextUtils.isEmpty((CharSequence)localObject1))) {
              break label6359;
            }
            parama1 = new az(parambi, parama1, paramString.url);
            parama1.position = paramInt;
            localax.zYw.jXr.setTag(parama1);
            localax.zYw.jXr.setOnClickListener(this.lNc);
            i = 1;
            localax.zYw.jXr.setOnLongClickListener(c(this.zzP));
            localax.zYw.jXr.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)this.zzP.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
            if (i != 0) {
              break label6438;
            }
            localax.zYw.zYE.setVisibility(8);
            localax.zYw.zYC.setVisibility(8);
            label5997:
            if (com.tencent.mm.m.g.Nr().Nf())
            {
              localax.zSa.setVisibility(0);
              c(this.zzP, localax.zSa, new s.o(paramString.fhC, parambi, parama));
            }
            parama = localax.zYw;
            if (bo.getInt((String)localMap.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) != 1) {
              break label6465;
            }
            paramInt = 1;
            label6071:
            if (paramInt != 0) {
              break label6470;
            }
            ab.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            parama.zYA.setTag(null);
            parama.zYB.setTag(null);
            parama.zYA.setVisibility(8);
            parama.zYB.setVisibility(8);
          }
          for (;;)
          {
            localax.zYw.jXr.setVisibility(0);
            AppMethodBeat.o(33159);
            return;
            a(localax, this.zzP, parambi, parama1);
            a(localax.zRz, this.zzP, parama1, parambi, null);
            if (((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).na(parama1))
            {
              localax.zYw.zYz.setTag(new az(parambi, parama1));
              localax.zYw.zYz.setOnClickListener(this.zVc);
              break;
            }
            paramString = localax.zYw.zYz;
            if (this.zzP.dJG()) {}
            for (parama = this.zzP.getTalkerUserName();; parama = null)
            {
              paramString.setTag(new az(parama1, parama));
              localax.zYw.zYz.setOnClickListener(e(this.zzP));
              break;
            }
            localax.zYw.zYz.setVisibility(8);
            localax.zYw.gui.setTextSize(0, com.tencent.mm.cb.a.ao(localax.zYw.gui.getContext(), 2131427493));
            break label5673;
            label6337:
            localax.zYw.nxi.setVisibility(8);
            break label5765;
            label6353:
            i = 0;
            break label5819;
            label6359:
            localObject1 = localax.zYw.jXr;
            parama1 = new az(parambi, false, paramInt, paramString.url, false, this.zzP.dHF(), parama1, parama, paramString.title);
            parama1.cMO = paramString.cMO;
            ((View)localObject1).setTag(parama1);
            localax.zYw.jXr.setOnClickListener(h(this.zzP));
            break label5918;
            label6438:
            localax.zYw.zYE.setVisibility(0);
            localax.zYw.zYC.setVisibility(0);
            break label5997;
            label6465:
            paramInt = 0;
            break label6071;
            label6470:
            if (parama.zYz.getVisibility() == 0)
            {
              parama.zYA.setTag(parambi);
              parama.zYA.setOnClickListener(this.zVb);
              parama.zYA.setVisibility(0);
              parama.zYB.setVisibility(8);
            }
            else
            {
              parama.zYB.setTag(parambi);
              parama.zYB.setOnClickListener(this.zVb);
              parama.zYB.setVisibility(0);
              parama.zYA.setVisibility(8);
            }
          }
        }
      }
    }
  }
  
  protected final void a(c.a parama, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33162);
    if ((paramString == null) || (parama.qFY == null))
    {
      AppMethodBeat.o(33162);
      return;
    }
    parambi = ((com.tencent.mm.ui.chatting.c.b.f)parama1.ay(com.tencent.mm.ui.chatting.c.b.f.class)).atS(paramString);
    a(parama, com.tencent.mm.pluginsdk.ui.d.j.b(parama1.zJz.getContext(), parambi, parama.qFY.getTextSize()));
    AppMethodBeat.o(33162);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33160);
    parambi = (az)paramView.getTag();
    if (parambi == null)
    {
      AppMethodBeat.o(33160);
      return false;
    }
    int i = parambi.position;
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
    }
    AppMethodBeat.o(33160);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33161);
    paramMenuItem.getItemId();
    AppMethodBeat.o(33161);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == 318767153;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  protected final boolean dLo()
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
  
  protected final boolean dLs()
  {
    return this.zVh == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x
 * JD-Core Version:    0.7.0.1
 */