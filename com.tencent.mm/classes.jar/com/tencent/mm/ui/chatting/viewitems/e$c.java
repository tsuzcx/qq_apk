package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.tt;
import com.tencent.mm.h.a.tt.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.e;

public final class e$c
  extends c
{
  private com.tencent.mm.ui.chatting.c.a vko;
  
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_appmsg_c2c);
      ((View)localObject).setTag(new e.a().dO((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    e.a locala1 = (e.a)parama;
    paramString = parambi.field_content;
    if (paramString != null) {}
    for (g.a locala = g.a.M(paramString, parambi.field_reserved);; locala = null)
    {
      tt localtt;
      boolean bool1;
      int k;
      int m;
      label230:
      Object localObject;
      label263:
      label336:
      label358:
      com.tencent.mm.ae.c localc;
      int j;
      if (locala != null)
      {
        boolean bool2 = "1001".equals(locala.dSh);
        localtt = new tt();
        if ((!bk.bl(locala.dSi)) && (!bool2))
        {
          localtt.cdZ.ceb = locala.dSi;
          com.tencent.mm.sdk.b.a.udP.m(localtt);
        }
        e.a.Y(locala1.igg, locala1.vBZ);
        if (!"1001".equals(locala.dSh)) {
          break label763;
        }
        paramString = locala1.igg;
        if (parambi.field_isSend != 1) {
          break label757;
        }
        bool1 = true;
        paramString.setBackgroundResource(com.tencent.mm.ui.chatting.g.c(locala, bool1));
        locala1.vCo.setTypeface(Typeface.defaultFromStyle(1));
        k = com.tencent.mm.cb.a.fromDPToPix(parama1.vtz.getContext(), 13);
        m = parama1.vtz.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding);
        locala1.igg.setPadding(m, 0, k, 0);
        if (parambi.field_isSend != 1) {
          break label874;
        }
        paramString = locala.dSc;
        if (!bk.bl(paramString)) {
          break label884;
        }
        paramString = locala.description;
        locala1.vCo.setSingleLine(false);
        locala1.vCo.setMaxLines(3);
        locala1.vCo.setText(j.b(parama1.vtz.getContext(), paramString, locala1.vCr));
        locala1.vCo.setTextSize(0, locala1.vCr);
        if (!bool2) {
          break label902;
        }
        localObject = locala1.vCp;
        paramString = parama1.vtz.getContext();
        if (parambi.field_isSend != 1) {
          break label896;
        }
        bool1 = true;
        paramString = j.a(paramString, com.tencent.mm.ui.chatting.g.b(locala, bool1), locala1.vCp.getTextSize());
        ((TextView)localObject).setText(paramString);
        localObject = locala.dSf;
        paramString = (String)localObject;
        if (bk.bl((String)localObject)) {
          paramString = locala.title;
        }
        locala1.vCq.setText(paramString);
        localc = (com.tencent.mm.ae.c)locala.A(com.tencent.mm.ae.c.class);
        i = 0;
        if (!bk.bl(localc.dQn))
        {
          o.ON().a("", locala1.vCn);
          j = parama1.vtz.getMMResources().getIdentifier(localc.dQn, "drawable", ae.getPackageName());
          i = j;
          if (j <= 0) {
            i = parama1.vtz.getMMResources().getIdentifier(localc.dQn, "raw", ae.getPackageName());
          }
        }
        y.v("MicroMsg.ChattingItemAppMsgC2CTo", "c2c localResId: %s", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          y.v("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from localRes");
          locala1.vCn.setImageResource(i);
        }
        if (!"1001".equals(locala.dSh)) {
          break label1016;
        }
        if (parambi.field_isSend != 1) {
          break label1010;
        }
        bool1 = true;
        label565:
        j = com.tencent.mm.ui.chatting.g.a(locala, bool1);
        if (j <= 0) {
          break label1068;
        }
        y.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconRes");
        locala1.vCn.setImageResource(j);
        label598:
        if (bk.bl(localc.dQo)) {
          break label1183;
        }
      }
      label896:
      label902:
      label1183:
      for (int i = parama1.vtz.getMMResources().getIdentifier(localc.dQo, "drawable", ae.getPackageName());; i = -1)
      {
        y.i("MicroMsg.ChattingItemAppMsgC2CTo", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          locala1.igg.setBackgroundResource(i);
          locala1.igg.setPadding(m, 0, k, 0);
        }
        parama.igg.setOnClickListener(d(parama1));
        parama.igg.setOnLongClickListener(c(parama1));
        parama.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
        parama1 = new aw(parambi, this.vko.cFE(), paramInt, null, '\000');
        parama.igg.setTag(parama1);
        return;
        label757:
        bool1 = false;
        break;
        label763:
        paramString = locala1.igg;
        i = localtt.cea.cec;
        j = localtt.cea.ced;
        if (parambi.field_isSend == 1)
        {
          bool1 = true;
          label802:
          paramString.setBackgroundResource(com.tencent.mm.ui.chatting.g.s(i, j, bool1));
          locala1.vCo.setTypeface(Typeface.defaultFromStyle(0));
          if (locala1.vCr <= locala1.maxSize) {
            break label864;
          }
        }
        label864:
        for (i = locala1.maxSize;; i = locala1.vCr)
        {
          locala1.vCr = i;
          break;
          bool1 = false;
          break label802;
        }
        label874:
        paramString = locala.dSb;
        break label230;
        label884:
        locala1.vCo.setSingleLine(true);
        break label263;
        bool1 = false;
        break label336;
        if (!bk.bl(locala.dSi))
        {
          localObject = locala1.vCp;
          i = localtt.cea.cec;
          j = localtt.cea.ced;
          if (parambi.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = com.tencent.mm.ui.chatting.g.a(i, j, bool1, locala);
            break;
          }
        }
        localObject = locala1.vCp;
        if (parambi.field_isSend == 1)
        {
          paramString = locala.dSd;
          break label358;
        }
        paramString = locala.dSe;
        break label358;
        label1010:
        bool1 = false;
        break label565;
        label1016:
        j = localtt.cea.cec;
        int n = localtt.cea.ced;
        if (parambi.field_isSend == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          j = com.tencent.mm.ui.chatting.g.t(j, n, bool1);
          break;
        }
        label1068:
        if (i > 0) {
          break label598;
        }
        y.i("MicroMsg.ChattingItemAppMsgC2CTo", "set c2cIcon from iconUrl");
        localObject = locala.dSa;
        paramString = (String)localObject;
        if (bk.bl((String)localObject)) {
          paramString = locala.thumburl;
        }
        locala1.vCn.setImageBitmap(null);
        if (bk.bl(paramString)) {
          break label598;
        }
        localObject = new com.tencent.mm.as.a.a.c.a();
        au.Hx();
        ((com.tencent.mm.as.a.a.c.a)localObject).eri = com.tencent.mm.model.c.FH();
        ((com.tencent.mm.as.a.a.c.a)localObject).erf = true;
        ((com.tencent.mm.as.a.a.c.a)localObject).erC = true;
        localObject = ((com.tencent.mm.as.a.a.c.a)localObject).OV();
        o.ON().a(paramString, locala1.vCn, (com.tencent.mm.as.a.a.c)localObject);
        break label598;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    paramContextMenu.add(((aw)paramView.getTag()).position, 100, 0, this.vko.vtz.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    switch (paramMenuItem.getItemId())
    {
    case 101: 
    case 102: 
    default: 
      return false;
    case 100: 
      bd.bC(parambi.field_msgId);
      return true;
    }
    String str1 = parambi.field_content;
    paramMenuItem = null;
    if (str1 != null) {
      paramMenuItem = g.a.M(str1, parambi.field_reserved);
    }
    if (paramMenuItem != null)
    {
      parambi = parambi.field_talker;
      str1 = paramMenuItem.dSb;
      String str2 = paramMenuItem.dSc;
      String str3 = paramMenuItem.dSd;
      String str4 = paramMenuItem.dSe;
      String str5 = paramMenuItem.dRZ;
      String str6 = paramMenuItem.dSg;
      paramMenuItem = paramMenuItem.dSh;
      com.tencent.mm.ui.base.h.a(parama.vtz.getContext(), parama.vtz.getMMResources().getString(R.l.chatting_resend_content), parama.vtz.getMMResources().getString(R.l.app_remind), parama.vtz.getMMResources().getString(R.l.chatting_resend_title), parama.vtz.getMMResources().getString(R.l.app_cancel), new e.c.1(this, parambi, str1, str2, str3, str4, str5, str6, paramMenuItem, parama), new e.c.2(this));
    }
    return true;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 436207665);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView = parambi.field_content;
    if (paramView != null) {}
    for (paramView = g.a.M(paramView, parambi.field_reserved);; paramView = null)
    {
      if (paramView != null)
      {
        if (!bk.bl(paramView.dRZ)) {
          break label167;
        }
        parambi = paramView.url;
        y.i("MicroMsg.ChattingItemAppMsgC2CTo", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bk.bl(parambi)), Boolean.valueOf(bk.bl(paramView.dSq)) });
        if (bk.bl(paramView.dSi)) {
          break label344;
        }
        if (!paramView.dSi.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
          break label175;
        }
        parambi = new Intent();
        parambi.putExtra("key_way", 1);
        parambi.putExtra("key_native_url", paramView.dSi);
        parambi.putExtra("key_username", parama.getTalkerUserName());
        parambi.putExtra("key_static_from_scene", 100002);
        d.b(parama.vtz.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambi);
      }
      label167:
      label175:
      label344:
      do
      {
        do
        {
          return true;
          parambi = paramView.dRZ;
          break;
          if (paramView.dSi.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            parambi = new Intent();
            if (parama.cFE()) {}
            for (int i = 0;; i = 1)
            {
              parambi.putExtra("key_way", i);
              parambi.putExtra("key_native_url", paramView.dSi);
              parambi.putExtra("key_username", parama.getTalkerUserName());
              d.b(parama.vtz.getContext(), "luckymoney", ".ui.LuckyMoneyReceiveUI", parambi);
              return true;
            }
          }
          y.i("MicroMsg.ChattingItemAppMsgC2CTo", "native url not match:" + paramView.dSi + ", go webview:" + parambi);
        } while (bk.bl(parambi));
        paramView = new Intent();
        paramView.putExtra("rawUrl", parambi);
        d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
        return true;
        if (!bk.bl(paramView.dSq))
        {
          y.i("MicroMsg.ChattingItemAppMsgC2CTo", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.dSq, Integer.valueOf(paramView.dSr), paramView.bRO });
          parambi = new Intent();
          parambi.putExtra("bill_no", paramView.dSq);
          parambi.putExtra("launcher_user_name", paramView.bRO);
          parambi.putExtra("enter_scene", 1);
          parambi.putExtra("chatroom", parama.getTalkerUserName());
          d.b(parama.vtz.getContext(), "aa", ".ui.PaylistAAUI", parambi);
          com.tencent.mm.plugin.report.service.h.nFQ.f(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(1) });
          return true;
        }
      } while ((bk.bl(parambi)) || (bk.bl(parambi)));
      paramView = new Intent();
      paramView.putExtra("rawUrl", parambi);
      d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      return true;
    }
  }
  
  public final boolean bfO()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.c
 * JD-Core Version:    0.7.0.1
 */