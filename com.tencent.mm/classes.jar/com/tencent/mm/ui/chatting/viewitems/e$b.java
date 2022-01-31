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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.g.a.vp.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.ui.chatting.f.a;

public final class e$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32864);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969065);
      ((View)localObject).setTag(new e.a().eY((View)localObject));
    }
    AppMethodBeat.o(32864);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32865);
    this.zzP = parama1;
    e.a locala = (e.a)parama;
    if (locala.zTr == parambi.field_msgId)
    {
      locala.zTs = true;
      locala.zTr = parambi.field_msgId;
      paramString = parambi.field_content;
      if (paramString == null) {
        break label1323;
      }
    }
    label275:
    label403:
    label419:
    label1317:
    label1323:
    for (j.b localb = j.b.ab(paramString, parambi.field_reserved);; localb = null)
    {
      com.tencent.mm.af.c localc;
      vp localvp;
      label191:
      Object localObject;
      label308:
      label381:
      int i;
      int j;
      if (localb != null)
      {
        localc = (com.tencent.mm.af.c)localb.R(com.tencent.mm.af.c.class);
        boolean bool2 = "1001".equals(localb.fig);
        localvp = new vp();
        if ((!bo.isNullOrNil(localb.fih)) && (!bool2))
        {
          localvp.cMM.cMO = localb.fih;
          com.tencent.mm.sdk.b.a.ymk.l(localvp);
        }
        e.a.ar(locala.jYu, locala.zSN);
        if (!"1001".equals(localb.fig)) {
          break label862;
        }
        paramString = locala.jYu;
        if (parambi.field_isSend != 1) {
          break label856;
        }
        bool1 = true;
        paramString.setBackgroundResource(f.c(localb, bool1));
        locala.zTl.setTypeface(Typeface.defaultFromStyle(1));
        parama1.zJz.getContext().getResources().getDimensionPixelSize(2131427854);
        parama1.zJz.getContext().getResources().getDimensionPixelSize(2131428207);
        locala.jYu.setPadding(0, 0, 0, 0);
        if (parambi.field_isSend != 1) {
          break label973;
        }
        paramString = localb.fib;
        if (!bo.isNullOrNil(paramString)) {
          break label983;
        }
        paramString = localb.description;
        locala.zTl.setSingleLine(false);
        locala.zTl.setMaxLines(3);
        locala.zTl.setText(j.b(parama1.zJz.getContext(), paramString, locala.zTq));
        locala.zTl.setTextSize(0, locala.zTq);
        if (!bool2) {
          break label1001;
        }
        localObject = locala.zTm;
        paramString = parama1.zJz.getContext();
        if (parambi.field_isSend != 1) {
          break label995;
        }
        bool1 = true;
        paramString = j.b(paramString, f.b(localb, bool1), locala.zTm.getTextSize());
        ((TextView)localObject).setText(paramString);
        locala.zTm.setVisibility(0);
        localObject = localb.fie;
        paramString = (String)localObject;
        if (bo.isNullOrNil((String)localObject)) {
          paramString = localb.title;
        }
        locala.zTn.setText(paramString);
        i = 0;
        if (!bo.isNullOrNil(localc.ffV))
        {
          o.ahG().a("", locala.zTk);
          j = parama1.zJz.getMMResources().getIdentifier(localc.ffV, "drawable", ah.getPackageName());
          i = j;
          if (j <= 0) {
            i = parama1.zJz.getMMResources().getIdentifier(localc.ffV, "raw", ah.getPackageName());
          }
        }
        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "c2c loaclResId: %s", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from localRes");
          locala.zTk.setImageResource(i);
        }
        if (!"1001".equals(localb.fig)) {
          break label1150;
        }
        if (parambi.field_isSend != 1) {
          break label1144;
        }
        bool1 = true;
        label608:
        j = f.a(localb, bool1);
        if (j <= 0) {
          break label1202;
        }
        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from iconRes");
        locala.zTk.setImageResource(j);
        i = -1;
        if (!bo.isNullOrNil(localc.ffW)) {
          i = parama1.zJz.getMMResources().getIdentifier(localc.ffW, "drawable", ah.getPackageName());
        }
        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "backgroundResId: %s", new Object[] { Integer.valueOf(i) });
        if (i > 0) {
          locala.jYu.setBackgroundResource(i);
        }
        i = localvp.cMN.cMQ;
        j = localvp.cMN.cMR;
        if (parambi.field_isSend != 1) {
          break label1317;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        e.a(locala, localc, true, f.w(i, j, bool1), parama1.getTalkerUserName());
        parama.jYu.setOnClickListener(d(parama1));
        parama.jYu.setOnLongClickListener(c(parama1));
        parama.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
        parama1 = new az(parambi, this.zzP.dJG(), paramInt, null, '\000');
        parama.jYu.setTag(parama1);
        AppMethodBeat.o(32865);
        return;
        locala.zTs = false;
        break;
        label856:
        bool1 = false;
        break label191;
        label862:
        paramString = locala.jYu;
        i = localvp.cMN.cMQ;
        j = localvp.cMN.cMR;
        if (parambi.field_isSend == 1)
        {
          bool1 = true;
          paramString.setBackgroundResource(f.u(i, j, bool1));
          locala.zTl.setTypeface(Typeface.defaultFromStyle(1));
          if (locala.zTq <= locala.maxSize) {
            break label963;
          }
        }
        label963:
        for (i = locala.maxSize;; i = locala.zTq)
        {
          locala.zTq = i;
          break;
          bool1 = false;
          break label901;
        }
        label973:
        paramString = localb.fia;
        break label275;
        label983:
        locala.zTl.setSingleLine(true);
        break label308;
        label995:
        bool1 = false;
        break label381;
        label1001:
        if (!bo.isNullOrNil(localb.fih))
        {
          i = localvp.cMN.cMP;
          j = localvp.cMN.cMQ;
          k = localvp.cMN.cMR;
          if (parambi.field_isSend == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            paramString = f.a(i, j, k, bool1, parama1.dJG());
            if (bo.isNullOrNil(paramString)) {
              break label1095;
            }
            localObject = locala.zTm;
            break;
          }
          locala.zTm.setVisibility(8);
          break label419;
        }
        label1095:
        localObject = locala.zTm;
        if (parambi.field_isSend == 1)
        {
          paramString = localb.fic;
          break label403;
        }
        paramString = localb.fid;
        break label403;
        label1144:
        bool1 = false;
        break label608;
        label1150:
        j = localvp.cMN.cMQ;
        int k = localvp.cMN.cMR;
        if (parambi.field_isSend == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          j = f.v(j, k, bool1);
          break;
        }
        label1202:
        if (i > 0) {
          break label641;
        }
        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "set c2cIcon from c2cIconUrl");
        localObject = localb.fhZ;
        paramString = (String)localObject;
        if (bo.isNullOrNil((String)localObject)) {
          paramString = localb.thumburl;
        }
        locala.zTk.setImageBitmap(null);
        if (bo.isNullOrNil(paramString)) {
          break label641;
        }
        localObject = new com.tencent.mm.at.a.a.c.a();
        aw.aaz();
        ((com.tencent.mm.at.a.a.c.a)localObject).eNP = com.tencent.mm.model.c.YL();
        ((com.tencent.mm.at.a.a.c.a)localObject).eNM = true;
        ((com.tencent.mm.at.a.a.c.a)localObject).eOe = true;
        localObject = ((com.tencent.mm.at.a.a.c.a)localObject).ahY();
        o.ahG().a(paramString, locala.zTk, (com.tencent.mm.at.a.a.c)localObject);
        break label641;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32866);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    AppMethodBeat.o(32866);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32867);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(32867);
      return false;
    }
    AppMethodBeat.o(32867);
    return true;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 436207665);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(32868);
    paramView = parambi.field_content;
    if (paramView != null) {}
    for (paramView = j.b.ab(paramView, parambi.field_reserved);; paramView = null)
    {
      if (paramView != null)
      {
        if (!bo.isNullOrNil(paramView.fhY)) {
          break label179;
        }
        parambi = paramView.url;
        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "url==null: %s, billNo==null: %s", new Object[] { Boolean.valueOf(bo.isNullOrNil(parambi)), Boolean.valueOf(bo.isNullOrNil(paramView.fip)) });
        if (bo.isNullOrNil(paramView.fih)) {
          break label386;
        }
        if (!paramView.fih.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
          break label187;
        }
        parambi = new Intent();
        parambi.putExtra("key_way", 1);
        parambi.putExtra("key_native_url", paramView.fih);
        parambi.putExtra("key_username", parama.getTalkerUserName());
        parambi.putExtra("key_static_from_scene", 100002);
        com.tencent.mm.bq.d.b(parama.zJz.getContext(), "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", parambi);
      }
      for (;;)
      {
        AppMethodBeat.o(32868);
        return true;
        label179:
        parambi = paramView.fhY;
        break;
        label187:
        if (paramView.fih.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
        {
          parambi = new Intent();
          paramView.R(com.tencent.mm.af.d.class);
          if (parama.dJG()) {}
          for (int i = 0;; i = 1)
          {
            parambi.putExtra("key_way", i);
            parambi.putExtra("key_native_url", paramView.fih);
            parambi.putExtra("key_username", parama.getTalkerUserName());
            parambi.putExtra("key_cropname", ((com.tencent.mm.af.c)paramView.R(com.tencent.mm.af.c.class)).ffY);
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "luckymoney", ".ui.LuckyMoneyNotHookReceiveUI", parambi);
            break;
          }
        }
        ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "native url not match:" + paramView.fih + ", go webview:" + parambi);
        if (!bo.isNullOrNil(parambi))
        {
          paramView = new Intent();
          paramView.putExtra("rawUrl", parambi);
          com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          continue;
          label386:
          if (!bo.isNullOrNil(paramView.fip))
          {
            ab.i("MicroMsg.ChattingItemAppMsgC2CFrom", "tofuliu billNo: %s, c2cNewAAType: %s, fromUser: %s", new Object[] { paramView.fip, Integer.valueOf(paramView.fiq), paramView.czp });
            parambi = new Intent();
            parambi.putExtra("bill_no", paramView.fip);
            parambi.putExtra("launcher_user_name", paramView.czp);
            parambi.putExtra("enter_scene", 1);
            parambi.putExtra("chatroom", parama.getTalkerUserName());
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "aa", ".ui.PaylistAAUI", parambi);
            if (f.d(paramView).wkh == 2) {
              com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(2) });
            } else {
              com.tencent.mm.plugin.report.service.h.qsU.e(13721, new Object[] { Integer.valueOf(4), Integer.valueOf(3) });
            }
          }
          else if (!bo.isNullOrNil(parambi))
          {
            paramView = new Intent();
            paramView.putExtra("rawUrl", parambi);
            com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
          }
        }
      }
    }
  }
  
  public final boolean dLp()
  {
    return false;
  }
  
  final boolean dLq()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.b
 * JD-Core Version:    0.7.0.1
 */