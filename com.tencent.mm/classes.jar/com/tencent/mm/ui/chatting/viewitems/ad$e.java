package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;

final class ad$e
{
  public static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, View paramView, long paramLong, MsgQuoteItem paramMsgQuoteItem, boolean paramBoolean)
  {
    AppMethodBeat.i(37034);
    if (paramMsgQuoteItem == null)
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem is null!");
      AppMethodBeat.o(37034);
      return;
    }
    Object localObject3 = ((n)h.ae(n.class)).eSe().Oq(paramLong);
    Log.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((et)localObject3).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.FkS), Util.secPrint(paramMsgQuoteItem.content) });
    Object localObject1 = paramMsgQuoteItem;
    Object localObject2;
    int i;
    if (Util.isNullOrNil(paramMsgQuoteItem.FkT))
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(1)");
      localObject1 = null;
      localObject2 = ((et)localObject3).field_content;
      paramMsgQuoteItem = (MsgQuoteItem)localObject2;
      if (parama.hRi())
      {
        i = ((et)localObject3).field_content.indexOf(':');
        paramMsgQuoteItem = (MsgQuoteItem)localObject2;
        if (i != -1) {
          paramMsgQuoteItem = ((et)localObject3).field_content.substring(i + 1);
        }
      }
      if (paramMsgQuoteItem != null) {
        localObject1 = k.b.aG(paramMsgQuoteItem, ((et)localObject3).field_reserved);
      }
      localObject1 = ((k.b)localObject1).loR;
    }
    if (Util.isNullOrNil(((MsgQuoteItem)localObject1).FkT))
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(2)");
      AppMethodBeat.o(37034);
      return;
    }
    paramMsgQuoteItem = ((n)h.ae(n.class)).eSe().aL(((MsgQuoteItem)localObject1).FkT, ((MsgQuoteItem)localObject1).FkS);
    if (paramMsgQuoteItem.field_msgId == 0L)
    {
      paramMsgQuoteItem = new ca();
      paramMsgQuoteItem.setType(((MsgQuoteItem)localObject1).type);
      paramMsgQuoteItem.EG(((MsgQuoteItem)localObject1).FkS);
      paramMsgQuoteItem.Jm(((MsgQuoteItem)localObject1).FkT);
      paramMsgQuoteItem.Ip(((MsgQuoteItem)localObject1).FkW);
      paramMsgQuoteItem.setContent(((MsgQuoteItem)localObject1).content);
      if (Util.isEqual(((MsgQuoteItem)localObject1).FkU, z.bcZ())) {
        paramMsgQuoteItem.pJ(1);
      }
    }
    for (;;)
    {
      switch (((MsgQuoteItem)localObject1).type)
      {
      }
      for (;;)
      {
        if ((((MsgQuoteItem)localObject1).type != 49) && (((MsgQuoteItem)localObject1).type != 805306417) && (((MsgQuoteItem)localObject1).type != 822083633) && (((MsgQuoteItem)localObject1).type != 1090519089)) {
          com.tencent.mm.plugin.msgquote.model.b.c(1L, ((MsgQuoteItem)localObject1).FkS, ((MsgQuoteItem)localObject1).type, 0L);
        }
        AppMethodBeat.o(37034);
        return;
        paramc = new Intent(parama.WQv.getContext(), TextPreviewUI.class);
        paramc.addFlags(67108864);
        paramc.putExtra("key_chat_text", ((MsgQuoteItem)localObject1).content);
        paramc.putExtra("Chat_Msg_Id", paramMsgQuoteItem.field_msgId);
        paramc.putExtra("key_msg_type", 1);
        paramc.putExtra("is_group_chat", parama.hRi());
        paramView = parama.WQv.getContext();
        paramc = new com.tencent.mm.hellhoundlib.b.a().bm(paramc);
        com.tencent.mm.hellhoundlib.a.a.b(paramView, paramc.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramc.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.la(parama.WQv.getContext());
        continue;
        if (paramMsgQuoteItem.field_msgId == 0L)
        {
          paramc = new Intent();
          paramc.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramc.putExtra("clean_view_type", 1);
          paramc = new com.tencent.mm.hellhoundlib.b.a().bm(paramc);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramc.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramc.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          new az.c(parama, paramc, paramMsgQuoteItem, paramView);
          continue;
          if (paramMsgQuoteItem.field_msgId == 0L)
          {
            paramc = new Intent();
            paramc.setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramc.putExtra("clean_view_type", 0);
            paramc = new com.tencent.mm.hellhoundlib.b.a().bm(paramc);
            com.tencent.mm.hellhoundlib.a.a.b(parama, paramc.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramc.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            new bj.c(parama, paramMsgQuoteItem, paramView);
            continue;
            new ba.c(parama, paramMsgQuoteItem);
            continue;
            paramc = bi.nM(((MsgQuoteItem)localObject1).FkT, paramMsgQuoteItem.field_content);
            if (paramc != null) {
              paramMsgQuoteItem.Jn(paramc.md5);
            }
            new at.d(parama, paramMsgQuoteItem);
            continue;
            paramView = k.b.OQ(paramMsgQuoteItem.field_content);
            if (paramView != null)
            {
              int j = 0;
              i = j;
              switch (paramView.type)
              {
              default: 
                i = j;
                if (!aS(paramMsgQuoteItem)) {
                  i = 1;
                }
                break;
              }
              for (;;)
              {
                com.tencent.mm.plugin.msgquote.model.b.c(1L, ((MsgQuoteItem)localObject1).FkS, 49L, paramView.type);
                if (!aS(paramMsgQuoteItem)) {
                  break label1817;
                }
                if (i == 0) {
                  break;
                }
                e.e.i(paramView, parama, paramc, paramMsgQuoteItem);
                break;
                if (!paramBoolean)
                {
                  w.g(parama.WQv.getContext(), parama.WQv.getContentView());
                  AppMethodBeat.o(37034);
                  return;
                }
                localObject2 = new Intent();
                ((Intent)localObject2).setClassName(parama.WQv.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                ((Intent)localObject2).putExtra("scene", 2);
                ((Intent)localObject2).putExtra("app_msg_id", paramMsgQuoteItem.field_msgId);
                ((Intent)localObject2).putExtra("key_msg_type", 1);
                ((Intent)localObject2).putExtra("msg_type", 1);
                ((Intent)localObject2).putExtra("key_quoted_msg", (Parcelable)localObject1);
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
                com.tencent.mm.hellhoundlib.a.a.b(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = j;
                continue;
                if (aS(paramMsgQuoteItem))
                {
                  e.e.j(paramView, parama, paramc, paramMsgQuoteItem);
                  i = j;
                }
                else
                {
                  e.d.e(paramView, parama, paramc, paramMsgQuoteItem);
                  i = j;
                  continue;
                  if (aS(paramMsgQuoteItem))
                  {
                    e.e.b(paramView, parama, paramc, paramMsgQuoteItem);
                    i = j;
                  }
                  else
                  {
                    e.d.b(paramView, parama, paramc, paramMsgQuoteItem);
                    i = j;
                    continue;
                    if (aS(paramMsgQuoteItem))
                    {
                      i = j;
                      if (!e.e.g(paramView, parama, paramc, paramMsgQuoteItem)) {
                        i = 1;
                      }
                    }
                    else
                    {
                      i = j;
                      if (!e.d.d(paramView, parama, paramc, paramMsgQuoteItem))
                      {
                        i = 1;
                        continue;
                        if (aS(paramMsgQuoteItem))
                        {
                          e.e.h(paramView, parama, paramc, paramMsgQuoteItem);
                          i = j;
                        }
                        else
                        {
                          i = j;
                          if (!e.d.c(paramView, parama, paramc, paramMsgQuoteItem))
                          {
                            i = 1;
                            continue;
                            e.a(paramView, parama, paramMsgQuoteItem);
                            i = j;
                            continue;
                            localObject3 = new Intent(parama.WQv.getContext(), TextPreviewUI.class);
                            ((Intent)localObject3).addFlags(67108864);
                            ((Intent)localObject3).putExtra("key_chat_text", paramView.title);
                            ((Intent)localObject3).putExtra("Chat_Msg_Id", paramMsgQuoteItem.field_msgId);
                            ((Intent)localObject3).putExtra("key_msg_type", 1);
                            ((Intent)localObject3).putExtra("is_group_chat", parama.hRi());
                            localObject2 = parama.WQv.getContext();
                            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject3);
                            com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ((Activity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).sf(0));
                            com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.ui.base.b.la(parama.WQv.getContext());
                            i = j;
                            continue;
                            if (aS(paramMsgQuoteItem))
                            {
                              e.e.f(paramView, parama, paramc, paramMsgQuoteItem);
                              i = j;
                            }
                            else
                            {
                              e.d.a(paramView, parama, paramc, paramMsgQuoteItem);
                              i = j;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              label1817:
              if (i != 0) {
                e.d.e(paramView, parama, paramc, paramMsgQuoteItem);
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean aS(ca paramca)
  {
    return paramca.field_isSend == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.e
 * JD-Core Version:    0.7.0.1
 */