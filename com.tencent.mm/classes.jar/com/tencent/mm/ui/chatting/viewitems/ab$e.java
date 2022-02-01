package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.findersdk.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.api.x;
import com.tencent.mm.ui.chatting.f.d.a;
import java.math.BigInteger;

public final class ab$e
{
  private static long FK(String paramString)
  {
    AppMethodBeat.i(255276);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(255276);
      return 0L;
    }
    long l = new BigInteger(paramString).longValue();
    AppMethodBeat.o(255276);
    return l;
  }
  
  public static cc a(cc paramcc, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(255253);
    if (paramcc == null)
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "getFixQuoteMsgInfo,quotedMsg is null!");
      AppMethodBeat.o(255253);
      return null;
    }
    cc localcc = paramcc;
    if (paramcc.field_msgId == 0L)
    {
      paramcc = new cc();
      paramcc.setType(paramMsgQuoteItem.type);
      paramcc.gX(paramMsgQuoteItem.LgU);
      paramcc.BS(paramMsgQuoteItem.LgV);
      paramcc.AU(paramMsgQuoteItem.LgY);
      paramcc.setContent(paramMsgQuoteItem.content);
      localcc = paramcc;
      if (Util.isEqual(paramMsgQuoteItem.LgW, z.bAM()))
      {
        paramcc.pI(1);
        localcc = paramcc;
      }
    }
    AppMethodBeat.o(255253);
    return localcc;
  }
  
  private static cc a(cc paramcc, MsgQuoteItem paramMsgQuoteItem, String paramString)
  {
    AppMethodBeat.i(255257);
    Object localObject = paramcc;
    if (paramcc.field_msgId == 0L)
    {
      localObject = paramcc;
      if (paramMsgQuoteItem != null)
      {
        localObject = paramcc;
        if (!TextUtils.isEmpty(paramMsgQuoteItem.LgY))
        {
          long l = bt.JR(paramMsgQuoteItem.LgY);
          localObject = paramcc;
          if (l != -1L)
          {
            paramMsgQuoteItem = ((n)h.ax(n.class)).gaZ().aU(paramString, l);
            localObject = paramcc;
            if (paramMsgQuoteItem != null)
            {
              localObject = paramcc;
              if (paramMsgQuoteItem.field_msgId != 0L) {
                localObject = paramMsgQuoteItem;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(255257);
    return localObject;
  }
  
  public static cc a(com.tencent.mm.ui.chatting.d.a parama, long paramLong, MsgQuoteItem paramMsgQuoteItem, String paramString)
  {
    AppMethodBeat.i(255247);
    if (paramMsgQuoteItem == null)
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem is null!");
      AppMethodBeat.o(255247);
      return null;
    }
    cc localcc = ((n)h.ax(n.class)).gaZ().sl(paramLong);
    long l;
    if (localcc == null)
    {
      l = -1L;
      Log.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "%s msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(l), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.LgU), Util.secPrint(paramMsgQuoteItem.content) });
      paramString = paramMsgQuoteItem;
      if (Util.isNullOrNil(paramMsgQuoteItem.LgV))
      {
        Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(1)");
        paramString = localcc.field_content;
        paramMsgQuoteItem = paramString;
        if (parama.juG())
        {
          int i = localcc.field_content.indexOf(':');
          paramMsgQuoteItem = paramString;
          if (i != -1) {
            paramMsgQuoteItem = localcc.field_content.substring(i + 1);
          }
        }
        if (paramMsgQuoteItem == null) {
          break label287;
        }
      }
    }
    label287:
    for (paramMsgQuoteItem = k.b.aP(paramMsgQuoteItem, localcc.field_reserved);; paramMsgQuoteItem = null)
    {
      paramString = paramMsgQuoteItem.nTU;
      if (Util.isNullOrNil(paramString.LgV))
      {
        Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(2)");
        AppMethodBeat.o(255247);
        return null;
        l = localcc.field_msgSvrId;
        break;
      }
      parama = a(((n)h.ax(n.class)).gaZ().aU(paramString.LgV, paramString.LgU), paramString, parama.getTalkerUserName());
      AppMethodBeat.o(255247);
      return parama;
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, final cc paramcc, View paramView, long paramLong, MsgQuoteItem paramMsgQuoteItem, boolean paramBoolean)
  {
    AppMethodBeat.i(255250);
    final cc localcc = a(parama, paramLong, paramMsgQuoteItem, "handleQuoteMsgClick");
    if (localcc == null)
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleItemClickToPositionEvent,quotedMsg is null!");
      AppMethodBeat.o(255250);
      return;
    }
    if (localcc.field_msgId == 0L)
    {
      Log.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleItemClickToPositionEvent,show toast");
      switch (paramMsgQuoteItem.type)
      {
      default: 
        com.tencent.mm.plugin.msgquote.model.b.e(6L, paramMsgQuoteItem.LgU, paramMsgQuoteItem.type, 0L);
      }
      for (;;)
      {
        aa.makeText(paramView.getContext(), R.l.gzg, 0).show();
        AppMethodBeat.o(255250);
        return;
        parama = k.b.Hf(paramMsgQuoteItem.content);
        if (parama != null) {
          com.tencent.mm.plugin.msgquote.model.b.e(6L, paramMsgQuoteItem.LgU, 49L, parama.type);
        } else {
          Log.w("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "appMsgContent is null");
        }
      }
    }
    final int i = parama.getListView().getPositionForView(paramView);
    bh.bCz();
    com.tencent.mm.model.c.ban().set(at.a.acLT, Boolean.TRUE);
    int j = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), 120);
    ((m)parama.cm(m.class)).a(localcc.field_msgId, false, true, true, j, true, d.a.aeHU);
    ((x)parama.cm(x.class)).jsh();
    new MMHandler().postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(255730);
        ((com.tencent.mm.ui.chatting.component.api.ao)ab.e.this.cm(com.tencent.mm.ui.chatting.component.api.ao.class)).a(localcc, paramcc, i);
        AppMethodBeat.o(255730);
      }
    }, 500L);
    switch (paramMsgQuoteItem.type)
    {
    default: 
      com.tencent.mm.plugin.msgquote.model.b.e(3L, paramMsgQuoteItem.LgU, paramMsgQuoteItem.type, 0L);
    }
    do
    {
      AppMethodBeat.o(255250);
      return;
      paramcc = k.b.Hf(localcc.field_content);
    } while (paramcc == null);
    switch (paramcc.type)
    {
    }
    do
    {
      com.tencent.mm.plugin.msgquote.model.b.e(3L, paramMsgQuoteItem.LgU, 49L, paramcc.type);
      AppMethodBeat.o(255250);
      return;
    } while (paramBoolean);
    aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
    AppMethodBeat.o(255250);
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, View paramView, long paramLong, MsgQuoteItem paramMsgQuoteItem, boolean paramBoolean)
  {
    AppMethodBeat.i(255271);
    cc localcc = a(parama, paramLong, paramMsgQuoteItem, "handleQuoteMsgClick");
    Object localObject = ((n)h.ax(n.class)).gaZ().sl(paramLong);
    if (localcc == null)
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleItemClickEvent,quotedMsg is null!");
      AppMethodBeat.o(255271);
      return;
    }
    if (localcc.field_msgId == 0L)
    {
      aa.makeText(paramView.getContext(), R.l.gzg, 0).show();
      switch (paramMsgQuoteItem.type)
      {
      default: 
        com.tencent.mm.plugin.msgquote.model.b.e(5L, paramMsgQuoteItem.LgU, paramMsgQuoteItem.type, 0L);
        AppMethodBeat.o(255271);
        return;
      }
      parama = k.b.Hf(paramMsgQuoteItem.content);
      if (parama != null)
      {
        com.tencent.mm.plugin.msgquote.model.b.e(5L, paramMsgQuoteItem.LgU, 49L, parama.type);
        AppMethodBeat.o(255271);
        return;
      }
      Log.w("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "appMsgContent is null");
      AppMethodBeat.o(255271);
      return;
    }
    localcc = a(localcc, paramMsgQuoteItem);
    switch (paramMsgQuoteItem.type)
    {
    }
    k.b localb;
    do
    {
      for (;;)
      {
        if ((paramMsgQuoteItem.type != 49) && (paramMsgQuoteItem.type != 805306417) && (paramMsgQuoteItem.type != 822083633) && (paramMsgQuoteItem.type != 1090519089)) {
          com.tencent.mm.plugin.msgquote.model.b.e(1L, paramMsgQuoteItem.LgU, paramMsgQuoteItem.type, 0L);
        }
        AppMethodBeat.o(255271);
        return;
        paramc = new Intent(parama.aezO.getContext(), TextPreviewUI.class);
        paramc.addFlags(67108864);
        paramc.putExtra("key_chat_text", paramMsgQuoteItem.content);
        if (localcc != null) {
          paramc.putExtra("Chat_Msg_Id", localcc.field_msgId);
        }
        paramc.putExtra("key_msg_type", 1);
        paramc.putExtra("is_group_chat", parama.juG());
        paramView = parama.aezO.getContext();
        paramc = new com.tencent.mm.hellhoundlib.b.a().cG(paramc);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramc.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickOpenEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramc.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickOpenEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.ne(parama.aezO.getContext());
        continue;
        new az.c(parama, paramc, localcc, paramView);
        continue;
        new bk.c(parama, localcc, paramView);
        continue;
        new ba.c(parama, localcc);
        continue;
        paramc = bk.pK(paramMsgQuoteItem.LgV, localcc.field_content);
        if (paramc != null) {
          localcc.BT(paramc.md5);
        }
        new as.d(parama, localcc);
        continue;
        ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(localcc.field_talker);
        paramc = localcc.field_talker;
        paramView = localcc.field_content;
        boolean bool = parama.juG();
        if (localcc.field_isSend == 0) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          ao.a(parama, paramc, paramView, bool, paramBoolean, localcc);
          break;
        }
        paramc = new ChattingItemTranslate.a(localcc, parama.juG(), parama.aezR);
        if (dF(localcc)) {
          bl.b.a(paramView, parama, localcc, paramc);
        } else {
          bl.a.a(paramView, parama, localcc, paramc, paramMsgQuoteItem);
        }
      }
      localb = k.b.Hf(localcc.field_content);
    } while (localb == null);
    int i;
    switch (localb.type)
    {
    default: 
      if (!dF(localcc)) {
        i = 1;
      }
      break;
    }
    for (;;)
    {
      com.tencent.mm.plugin.msgquote.model.b.e(1L, paramMsgQuoteItem.LgU, 49L, localb.type);
      if (dF(localcc))
      {
        if (i != 0)
        {
          e.e.i(localb, parama, paramc, localcc);
          AppMethodBeat.o(255271);
          return;
          i = 0;
          continue;
          if (!paramBoolean)
          {
            aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
            AppMethodBeat.o(255271);
            return;
          }
          paramView = new Intent();
          paramView.setClassName(parama.aezO.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
          paramView.putExtra("scene", 2);
          paramView.putExtra("app_msg_id", localcc.field_msgId);
          paramView.putExtra("key_msg_type", 1);
          paramView.putExtra("msg_type", 1);
          paramView.putExtra("key_quoted_msg", paramMsgQuoteItem);
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramView.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickOpenEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickOpenEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          i = 0;
          continue;
          if (dF(localcc))
          {
            e.e.j(localb, parama, paramc, localcc);
            i = 0;
            continue;
          }
          e.d.e(localb, parama, paramc, localcc);
          i = 0;
          continue;
          if (dF(localcc))
          {
            if (!e.e.b(localb, parama, paramc, localcc)) {
              break label2613;
            }
            com.tencent.mm.ui.chatting.component.c.d(parama, paramView, (cc)localObject);
            i = 0;
            continue;
          }
          if (!e.d.b(localb, parama, paramc, localcc)) {
            break label2613;
          }
          com.tencent.mm.ui.chatting.component.c.d(parama, paramView, (cc)localObject);
          i = 0;
          continue;
          if (dF(localcc))
          {
            if (!e.e.g(localb, parama, paramc, localcc))
            {
              i = 1;
              continue;
            }
            com.tencent.mm.ui.chatting.component.c.d(parama, paramView, (cc)localObject);
            i = 0;
            continue;
          }
          if (!e.d.d(localb, parama, paramc, localcc))
          {
            i = 1;
            continue;
          }
          com.tencent.mm.ui.chatting.component.c.d(parama, paramView, (cc)localObject);
          i = 0;
          continue;
          if (dF(localcc))
          {
            e.e.h(localb, parama, paramc, localcc);
            i = 0;
            continue;
          }
          if (e.d.c(localb, parama, paramc, localcc)) {
            break label2613;
          }
          i = 1;
          continue;
          e.a(localb, parama, localcc);
          i = 0;
          continue;
          localObject = new Intent(parama.aezO.getContext(), TextPreviewUI.class);
          ((Intent)localObject).addFlags(67108864);
          ((Intent)localObject).putExtra("key_chat_text", localb.title);
          if (localcc != null) {
            ((Intent)localObject).putExtra("Chat_Msg_Id", localcc.field_msgId);
          }
          ((Intent)localObject).putExtra("key_msg_type", 1);
          ((Intent)localObject).putExtra("is_group_chat", parama.juG());
          paramView = parama.aezO.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickOpenEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickOpenEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.ui.base.b.ne(parama.aezO.getContext());
          i = 0;
          continue;
          if (dF(localcc))
          {
            e.e.f(localb, parama, paramc, localcc);
            i = 0;
            continue;
          }
          e.d.a(localb, parama, paramc, localcc);
          i = 0;
          continue;
          if (dF(localcc))
          {
            af.c.g(parama, localcc);
            i = 0;
            continue;
          }
          af.b.f(parama, localcc);
          i = 0;
          continue;
          if (dF(localcc))
          {
            f.c.g(parama, localcc);
            i = 0;
            continue;
          }
          f.b.f(parama, localcc);
          i = 0;
          continue;
          if (dF(localcc))
          {
            e.e.a(parama, localcc, paramc.a(parama, localcc), paramc);
            i = 0;
            continue;
          }
          e.d.a(parama, localcc, e.d.e(parama, localcc), c.d(parama, localcc), paramc.a(parama, localcc), paramc);
          i = 0;
          continue;
          try
          {
            paramView = (f)localb.aK(f.class);
            localObject = new Intent();
            if (au.bwE(localcc.field_talker)) {
              ((Intent)localObject).putExtra("report_scene", 2);
            }
            for (;;)
            {
              ((Intent)localObject).putExtra("from_user", localcc.field_talker);
              ((Intent)localObject).putExtra("feed_object_id", FK(paramView.oUc.objectId));
              ((Intent)localObject).putExtra("feed_object_nonceId", paramView.oUc.objectNonceId);
              ((Intent)localObject).putExtra("business_type", 0);
              ((Intent)localObject).putExtra("finder_user_name", paramView.oUc.username);
              ((cn)h.az(cn.class)).fillContextIdToIntent(6, 2, 25, (Intent)localObject);
              ((cn)h.az(cn.class)).enterFinderShareFeedUI(parama.aezO.getContext(), (Intent)localObject);
              i = 0;
              break;
              ((Intent)localObject).putExtra("report_scene", 1);
            }
          }
          catch (Exception paramView)
          {
            Log.w("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "jump to finder feed fail: %s", new Object[] { paramView.getMessage() });
            i = 0;
          }
          try
          {
            paramView = (com.tencent.mm.plugin.findersdk.a.a)localb.aK(com.tencent.mm.plugin.findersdk.a.a.class);
            if ((paramView != null) && (paramView.HbV != null))
            {
              bmr localbmr = paramView.HbV;
              localObject = paramc.a(parama, localcc);
              paramView = (View)localObject;
              if (localObject == null) {
                paramView = parama.Uxa.field_username;
              }
              com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramView;
              com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = com.tencent.mm.plugin.expt.hellhound.core.b.hF((int)parama.Uxa.maN);
              ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveInvitedUI(MMApplicationContext.getContext(), localbmr.username, localbmr.nickName, localbmr.headUrl, localbmr.feedId, localbmr.liveId);
            }
            i = 0;
          }
          catch (Exception paramView)
          {
            Log.w("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "jump to live fail: %s", new Object[] { paramView.getMessage() });
            i = 0;
          }
          continue;
          if (dF(localcc))
          {
            ChatingItemAppMsgFinderLiveFeed.c.a(paramView, parama, localcc, paramc.a(parama, localcc));
            i = 0;
            continue;
          }
          ChatingItemAppMsgFinderLiveFeed.b.a(paramView, parama, localcc, paramc.a(parama, localcc));
          i = 0;
          continue;
          localObject = ChattingItemAppMsgFinderProduct.aeQl;
          paramc.a(parama, localcc);
          ChattingItemAppMsgFinderProduct.c.d(paramView, parama, localcc);
          i = 0;
          continue;
          if (dF(localcc))
          {
            ah.b.b(parama, localcc, paramMsgQuoteItem.LgW);
            i = 0;
            continue;
          }
          ah.a.b(paramView, parama, localcc, paramMsgQuoteItem.LgW);
          i = 0;
          continue;
          t.h(parama, localcc);
          i = 0;
          continue;
          w.h(parama, localcc);
          i = 0;
        }
      }
      else if (i != 0) {
        e.d.e(localb, parama, paramc, localcc);
      }
      AppMethodBeat.o(255271);
      return;
      label2613:
      i = 0;
    }
  }
  
  private static boolean dF(cc paramcc)
  {
    return paramcc.field_isSend == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.e
 * JD-Core Version:    0.7.0.1
 */