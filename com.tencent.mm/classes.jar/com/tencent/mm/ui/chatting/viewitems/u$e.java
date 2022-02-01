package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;

final class u$e
{
  public static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, View paramView, long paramLong, MsgQuoteItem paramMsgQuoteItem, boolean paramBoolean)
  {
    AppMethodBeat.i(37034);
    if (paramMsgQuoteItem == null)
    {
      ad.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem is null!");
      AppMethodBeat.o(37034);
      return;
    }
    ad.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((k)g.ab(k.class)).cOI().rm(paramLong).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.tNr), bt.aGs(paramMsgQuoteItem.content) });
    bl localbl = ((k)g.ab(k.class)).cOI().aD(paramMsgQuoteItem.tNs, paramMsgQuoteItem.tNr);
    if (localbl.field_msgId == 0L)
    {
      localbl = new bl();
      localbl.setType(paramMsgQuoteItem.type);
      localbl.kX(paramMsgQuoteItem.tNr);
      localbl.nY(paramMsgQuoteItem.tNs);
      localbl.mZ(paramMsgQuoteItem.tNv);
      localbl.setContent(paramMsgQuoteItem.content);
      if (bt.kU(paramMsgQuoteItem.tNt, u.aqG())) {
        localbl.jV(1);
      }
    }
    for (;;)
    {
      switch (paramMsgQuoteItem.type)
      {
      }
      for (;;)
      {
        if ((paramMsgQuoteItem.type != 49) && (paramMsgQuoteItem.type != 805306417) && (paramMsgQuoteItem.type != 822083633)) {
          com.tencent.mm.plugin.msgquote.model.b.b(1L, paramMsgQuoteItem.tNr, paramMsgQuoteItem.type, 0L);
        }
        AppMethodBeat.o(37034);
        return;
        paramc = new Intent(parama.GzJ.getContext(), TextPreviewUI.class);
        paramc.addFlags(67108864);
        paramc.putExtra("key_chat_text", paramMsgQuoteItem.content);
        paramc.putExtra("Chat_Msg_Id", localbl.field_msgId);
        paramc.putExtra("key_msg_type", 1);
        paramView = parama.GzJ.getContext();
        paramc = new com.tencent.mm.hellhoundlib.b.a().bd(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramc.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramc.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jH(parama.GzJ.getContext());
        continue;
        if (localbl.field_msgId == 0L)
        {
          paramc = new Intent();
          paramc.setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramc.putExtra("clean_view_type", 1);
          paramc = new com.tencent.mm.hellhoundlib.b.a().bd(paramc);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramc.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          new an.c(parama, paramc, localbl, paramView);
          continue;
          if (localbl.field_msgId == 0L)
          {
            paramc = new Intent();
            paramc.setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramc.putExtra("clean_view_type", 0);
            paramc = new com.tencent.mm.hellhoundlib.b.a().bd(paramc);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramc.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            new aw.c(parama, localbl, paramView);
            continue;
            new ao.c(parama, localbl);
            continue;
            paramc = av.le(paramMsgQuoteItem.tNs, localbl.field_content);
            if (paramc != null) {
              localbl.nZ(paramc.md5);
            }
            new ai.d(parama, localbl);
            continue;
            paramView = k.b.rx(localbl.field_content);
            if (paramView != null)
            {
              int j = 0;
              int i = j;
              switch (paramView.type)
              {
              default: 
                i = j;
                if (!at(localbl)) {
                  i = 1;
                }
                break;
              }
              for (;;)
              {
                com.tencent.mm.plugin.msgquote.model.b.b(1L, paramMsgQuoteItem.tNr, 49L, paramView.type);
                if (!at(localbl)) {
                  break label1625;
                }
                if (i == 0) {
                  break;
                }
                e.e.i(paramView, parama, paramc, localbl);
                break;
                if (!paramBoolean)
                {
                  t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
                  AppMethodBeat.o(37034);
                  return;
                }
                Object localObject1 = new Intent();
                ((Intent)localObject1).setClassName(parama.GzJ.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                ((Intent)localObject1).putExtra("scene", 2);
                ((Intent)localObject1).putExtra("app_msg_id", localbl.field_msgId);
                ((Intent)localObject1).putExtra("key_msg_type", 1);
                ((Intent)localObject1).putExtra("msg_type", 1);
                ((Intent)localObject1).putExtra("key_quoted_msg", paramMsgQuoteItem);
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject1);
                com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
                com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = j;
                continue;
                if (at(localbl))
                {
                  e.e.j(paramView, parama, paramc, localbl);
                  i = j;
                }
                else
                {
                  e.d.e(paramView, parama, paramc, localbl);
                  i = j;
                  continue;
                  if (at(localbl))
                  {
                    e.e.b(paramView, parama, paramc, localbl);
                    i = j;
                  }
                  else
                  {
                    e.d.b(paramView, parama, paramc, localbl);
                    i = j;
                    continue;
                    if (at(localbl))
                    {
                      i = j;
                      if (!e.e.g(paramView, parama, paramc, localbl)) {
                        i = 1;
                      }
                    }
                    else
                    {
                      i = j;
                      if (!e.d.d(paramView, parama, paramc, localbl))
                      {
                        i = 1;
                        continue;
                        if (at(localbl))
                        {
                          e.e.h(paramView, parama, paramc, localbl);
                          i = j;
                        }
                        else
                        {
                          i = j;
                          if (!e.d.c(paramView, parama, paramc, localbl))
                          {
                            i = 1;
                            continue;
                            e.a(paramView, parama, localbl);
                            i = j;
                            continue;
                            Object localObject2 = new Intent(parama.GzJ.getContext(), TextPreviewUI.class);
                            ((Intent)localObject2).addFlags(67108864);
                            ((Intent)localObject2).putExtra("key_chat_text", paramView.title);
                            ((Intent)localObject2).putExtra("Chat_Msg_Id", localbl.field_msgId);
                            ((Intent)localObject2).putExtra("key_msg_type", 1);
                            localObject1 = parama.GzJ.getContext();
                            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
                            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
                            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.ui.base.b.jH(parama.GzJ.getContext());
                            i = j;
                            continue;
                            if (at(localbl))
                            {
                              e.e.f(paramView, parama, paramc, localbl);
                              i = j;
                            }
                            else
                            {
                              e.d.a(paramView, parama, paramc, localbl);
                              i = j;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              label1625:
              if (i != 0) {
                e.d.e(paramView, parama, paramc, localbl);
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean at(bl parambl)
  {
    return parambl.field_isSend == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.e
 * JD-Core Version:    0.7.0.1
 */