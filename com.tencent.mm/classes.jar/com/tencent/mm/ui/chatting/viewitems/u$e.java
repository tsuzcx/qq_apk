package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bo;
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
      ac.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem is null!");
      AppMethodBeat.o(37034);
      return;
    }
    ac.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((k)g.ab(k.class)).dcr().vP(paramLong).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.uVU), bs.aLJ(paramMsgQuoteItem.content) });
    bo localbo = ((k)g.ab(k.class)).dcr().aF(paramMsgQuoteItem.uVV, paramMsgQuoteItem.uVU);
    if (localbo.field_msgId == 0L)
    {
      localbo = new bo();
      localbo.setType(paramMsgQuoteItem.type);
      localbo.oz(paramMsgQuoteItem.uVU);
      localbo.re(paramMsgQuoteItem.uVV);
      localbo.qf(paramMsgQuoteItem.uVY);
      localbo.setContent(paramMsgQuoteItem.content);
      if (bs.lr(paramMsgQuoteItem.uVW, u.axw())) {
        localbo.jT(1);
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
          com.tencent.mm.plugin.msgquote.model.b.b(1L, paramMsgQuoteItem.uVU, paramMsgQuoteItem.type, 0L);
        }
        AppMethodBeat.o(37034);
        return;
        paramc = new Intent(parama.HZF.getContext(), TextPreviewUI.class);
        paramc.addFlags(67108864);
        paramc.putExtra("key_chat_text", paramMsgQuoteItem.content);
        paramc.putExtra("Chat_Msg_Id", localbo.field_msgId);
        paramc.putExtra("key_msg_type", 1);
        paramView = parama.HZF.getContext();
        paramc = new com.tencent.mm.hellhoundlib.b.a().ba(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramc.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramc.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.jS(parama.HZF.getContext());
        continue;
        if (localbo.field_msgId == 0L)
        {
          paramc = new Intent();
          paramc.setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramc.putExtra("clean_view_type", 1);
          paramc = new com.tencent.mm.hellhoundlib.b.a().ba(paramc);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramc.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          new ao.c(parama, paramc, localbo, paramView);
          continue;
          if (localbo.field_msgId == 0L)
          {
            paramc = new Intent();
            paramc.setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramc.putExtra("clean_view_type", 0);
            paramc = new com.tencent.mm.hellhoundlib.b.a().ba(paramc);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramc.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            new ax.c(parama, localbo, paramView);
            continue;
            new ap.c(parama, localbo);
            continue;
            paramc = ay.lB(paramMsgQuoteItem.uVV, localbo.field_content);
            if (paramc != null) {
              localbo.rf(paramc.md5);
            }
            new aj.d(parama, localbo);
            continue;
            paramView = k.b.vA(localbo.field_content);
            if (paramView != null)
            {
              int j = 0;
              int i = j;
              switch (paramView.type)
              {
              default: 
                i = j;
                if (!av(localbo)) {
                  i = 1;
                }
                break;
              }
              for (;;)
              {
                com.tencent.mm.plugin.msgquote.model.b.b(1L, paramMsgQuoteItem.uVU, 49L, paramView.type);
                if (!av(localbo)) {
                  break label1625;
                }
                if (i == 0) {
                  break;
                }
                e.e.i(paramView, parama, paramc, localbo);
                break;
                if (!paramBoolean)
                {
                  t.g(parama.HZF.getContext(), parama.HZF.getContentView());
                  AppMethodBeat.o(37034);
                  return;
                }
                Object localObject1 = new Intent();
                ((Intent)localObject1).setClassName(parama.HZF.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                ((Intent)localObject1).putExtra("scene", 2);
                ((Intent)localObject1).putExtra("app_msg_id", localbo.field_msgId);
                ((Intent)localObject1).putExtra("key_msg_type", 1);
                ((Intent)localObject1).putExtra("msg_type", 1);
                ((Intent)localObject1).putExtra("key_quoted_msg", paramMsgQuoteItem);
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject1);
                com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
                com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = j;
                continue;
                if (av(localbo))
                {
                  e.e.j(paramView, parama, paramc, localbo);
                  i = j;
                }
                else
                {
                  e.d.e(paramView, parama, paramc, localbo);
                  i = j;
                  continue;
                  if (av(localbo))
                  {
                    e.e.b(paramView, parama, paramc, localbo);
                    i = j;
                  }
                  else
                  {
                    e.d.b(paramView, parama, paramc, localbo);
                    i = j;
                    continue;
                    if (av(localbo))
                    {
                      i = j;
                      if (!e.e.g(paramView, parama, paramc, localbo)) {
                        i = 1;
                      }
                    }
                    else
                    {
                      i = j;
                      if (!e.d.d(paramView, parama, paramc, localbo))
                      {
                        i = 1;
                        continue;
                        if (av(localbo))
                        {
                          e.e.h(paramView, parama, paramc, localbo);
                          i = j;
                        }
                        else
                        {
                          i = j;
                          if (!e.d.c(paramView, parama, paramc, localbo))
                          {
                            i = 1;
                            continue;
                            e.a(paramView, parama, localbo);
                            i = j;
                            continue;
                            Object localObject2 = new Intent(parama.HZF.getContext(), TextPreviewUI.class);
                            ((Intent)localObject2).addFlags(67108864);
                            ((Intent)localObject2).putExtra("key_chat_text", paramView.title);
                            ((Intent)localObject2).putExtra("Chat_Msg_Id", localbo.field_msgId);
                            ((Intent)localObject2).putExtra("key_msg_type", 1);
                            localObject1 = parama.HZF.getContext();
                            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
                            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ((Activity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
                            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.ui.base.b.jS(parama.HZF.getContext());
                            i = j;
                            continue;
                            if (av(localbo))
                            {
                              e.e.f(paramView, parama, paramc, localbo);
                              i = j;
                            }
                            else
                            {
                              e.d.a(paramView, parama, paramc, localbo);
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
                e.d.e(paramView, parama, paramc, localbo);
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean av(bo parambo)
  {
    return parambo.field_isSend == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.e
 * JD-Core Version:    0.7.0.1
 */