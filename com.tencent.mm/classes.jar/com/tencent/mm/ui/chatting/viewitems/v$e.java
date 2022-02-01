package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;

final class v$e
{
  public static void a(com.tencent.mm.ui.chatting.e.a parama, c paramc, View paramView, long paramLong, MsgQuoteItem paramMsgQuoteItem, boolean paramBoolean)
  {
    AppMethodBeat.i(37034);
    if (paramMsgQuoteItem == null)
    {
      ad.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem is null!");
      AppMethodBeat.o(37034);
      return;
    }
    Object localObject3 = ((l)g.ab(l.class)).dlK().xY(paramLong);
    ad.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((ei)localObject3).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.vZc), bt.aRp(paramMsgQuoteItem.content) });
    Object localObject1 = paramMsgQuoteItem;
    Object localObject2;
    int i;
    if (bt.isNullOrNil(paramMsgQuoteItem.vZd))
    {
      ad.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(1)");
      localObject1 = null;
      localObject2 = ((ei)localObject3).field_content;
      paramMsgQuoteItem = (MsgQuoteItem)localObject2;
      if (parama.fFv())
      {
        i = ((ei)localObject3).field_content.indexOf(':');
        paramMsgQuoteItem = (MsgQuoteItem)localObject2;
        if (i != -1) {
          paramMsgQuoteItem = ((ei)localObject3).field_content.substring(i + 1);
        }
      }
      if (paramMsgQuoteItem != null) {
        localObject1 = k.b.aA(paramMsgQuoteItem, ((ei)localObject3).field_reserved);
      }
      localObject1 = ((k.b)localObject1).hCy;
    }
    if (bt.isNullOrNil(((MsgQuoteItem)localObject1).vZd))
    {
      ad.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(2)");
      AppMethodBeat.o(37034);
      return;
    }
    paramMsgQuoteItem = ((l)g.ab(l.class)).dlK().aI(((MsgQuoteItem)localObject1).vZd, ((MsgQuoteItem)localObject1).vZc);
    if (paramMsgQuoteItem.field_msgId == 0L)
    {
      paramMsgQuoteItem = new bu();
      paramMsgQuoteItem.setType(((MsgQuoteItem)localObject1).type);
      paramMsgQuoteItem.qz(((MsgQuoteItem)localObject1).vZc);
      paramMsgQuoteItem.tN(((MsgQuoteItem)localObject1).vZd);
      paramMsgQuoteItem.sP(((MsgQuoteItem)localObject1).vZg);
      paramMsgQuoteItem.setContent(((MsgQuoteItem)localObject1).content);
      if (bt.lQ(((MsgQuoteItem)localObject1).vZe, u.aAm())) {
        paramMsgQuoteItem.kr(1);
      }
    }
    for (;;)
    {
      switch (((MsgQuoteItem)localObject1).type)
      {
      }
      for (;;)
      {
        if ((((MsgQuoteItem)localObject1).type != 49) && (((MsgQuoteItem)localObject1).type != 805306417) && (((MsgQuoteItem)localObject1).type != 822083633)) {
          com.tencent.mm.plugin.msgquote.model.b.b(1L, ((MsgQuoteItem)localObject1).vZc, ((MsgQuoteItem)localObject1).type, 0L);
        }
        AppMethodBeat.o(37034);
        return;
        paramc = new Intent(parama.JOR.getContext(), TextPreviewUI.class);
        paramc.addFlags(67108864);
        paramc.putExtra("key_chat_text", ((MsgQuoteItem)localObject1).content);
        paramc.putExtra("Chat_Msg_Id", paramMsgQuoteItem.field_msgId);
        paramc.putExtra("key_msg_type", 1);
        paramView = parama.JOR.getContext();
        paramc = new com.tencent.mm.hellhoundlib.b.a().bc(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramc.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramc.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kd(parama.JOR.getContext());
        continue;
        if (paramMsgQuoteItem.field_msgId == 0L)
        {
          paramc = new Intent();
          paramc.setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramc.putExtra("clean_view_type", 1);
          paramc = new com.tencent.mm.hellhoundlib.b.a().bc(paramc);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramc.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          new ap.c(parama, paramc, paramMsgQuoteItem, paramView);
          continue;
          if (paramMsgQuoteItem.field_msgId == 0L)
          {
            paramc = new Intent();
            paramc.setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramc.putExtra("clean_view_type", 0);
            paramc = new com.tencent.mm.hellhoundlib.b.a().bc(paramc);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramc.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            new ay.c(parama, paramMsgQuoteItem, paramView);
            continue;
            new aq.c(parama, paramMsgQuoteItem);
            continue;
            paramc = bc.lZ(((MsgQuoteItem)localObject1).vZd, paramMsgQuoteItem.field_content);
            if (paramc != null) {
              paramMsgQuoteItem.tO(paramc.md5);
            }
            new ak.d(parama, paramMsgQuoteItem);
            continue;
            paramView = k.b.yr(paramMsgQuoteItem.field_content);
            if (paramView != null)
            {
              int j = 0;
              i = j;
              switch (paramView.type)
              {
              default: 
                i = j;
                if (!ay(paramMsgQuoteItem)) {
                  i = 1;
                }
                break;
              }
              for (;;)
              {
                com.tencent.mm.plugin.msgquote.model.b.b(1L, ((MsgQuoteItem)localObject1).vZc, 49L, paramView.type);
                if (!ay(paramMsgQuoteItem)) {
                  break label1761;
                }
                if (i == 0) {
                  break;
                }
                e.e.i(paramView, parama, paramc, paramMsgQuoteItem);
                break;
                if (!paramBoolean)
                {
                  t.g(parama.JOR.getContext(), parama.JOR.getContentView());
                  AppMethodBeat.o(37034);
                  return;
                }
                localObject2 = new Intent();
                ((Intent)localObject2).setClassName(parama.JOR.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                ((Intent)localObject2).putExtra("scene", 2);
                ((Intent)localObject2).putExtra("app_msg_id", paramMsgQuoteItem.field_msgId);
                ((Intent)localObject2).putExtra("key_msg_type", 1);
                ((Intent)localObject2).putExtra("msg_type", 1);
                ((Intent)localObject2).putExtra("key_quoted_msg", (Parcelable)localObject1);
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = j;
                continue;
                if (ay(paramMsgQuoteItem))
                {
                  e.e.j(paramView, parama, paramc, paramMsgQuoteItem);
                  i = j;
                }
                else
                {
                  e.d.e(paramView, parama, paramc, paramMsgQuoteItem);
                  i = j;
                  continue;
                  if (ay(paramMsgQuoteItem))
                  {
                    e.e.b(paramView, parama, paramc, paramMsgQuoteItem);
                    i = j;
                  }
                  else
                  {
                    e.d.b(paramView, parama, paramc, paramMsgQuoteItem);
                    i = j;
                    continue;
                    if (ay(paramMsgQuoteItem))
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
                        if (ay(paramMsgQuoteItem))
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
                            localObject3 = new Intent(parama.JOR.getContext(), TextPreviewUI.class);
                            ((Intent)localObject3).addFlags(67108864);
                            ((Intent)localObject3).putExtra("key_chat_text", paramView.title);
                            ((Intent)localObject3).putExtra("Chat_Msg_Id", paramMsgQuoteItem.field_msgId);
                            ((Intent)localObject3).putExtra("key_msg_type", 1);
                            localObject2 = parama.JOR.getContext();
                            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject3);
                            com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ((Activity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).mq(0));
                            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.ui.base.b.kd(parama.JOR.getContext());
                            i = j;
                            continue;
                            if (ay(paramMsgQuoteItem))
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
              label1761:
              if (i != 0) {
                e.d.e(paramView, parama, paramc, paramMsgQuoteItem);
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean ay(bu parambu)
  {
    return parambu.field_isSend == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.e
 * JD-Core Version:    0.7.0.1
 */