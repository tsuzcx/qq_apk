package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;

final class aa$e
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
    Object localObject3 = ((l)g.af(l.class)).eiy().Hb(paramLong);
    Log.i("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "handleQuoteMsgClick msgId:%s msgSvrId:%s MsgQuoteItem(type:%s svrid:%s content:%s)", new Object[] { Long.valueOf(paramLong), Long.valueOf(((eo)localObject3).field_msgSvrId), Integer.valueOf(paramMsgQuoteItem.type), Long.valueOf(paramMsgQuoteItem.zFI), Util.secPrint(paramMsgQuoteItem.content) });
    Object localObject1 = paramMsgQuoteItem;
    Object localObject2;
    int i;
    if (Util.isNullOrNil(paramMsgQuoteItem.zFJ))
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(1)");
      localObject1 = null;
      localObject2 = ((eo)localObject3).field_content;
      paramMsgQuoteItem = (MsgQuoteItem)localObject2;
      if (parama.gRM())
      {
        i = ((eo)localObject3).field_content.indexOf(':');
        paramMsgQuoteItem = (MsgQuoteItem)localObject2;
        if (i != -1) {
          paramMsgQuoteItem = ((eo)localObject3).field_content.substring(i + 1);
        }
      }
      if (paramMsgQuoteItem != null) {
        localObject1 = k.b.aD(paramMsgQuoteItem, ((eo)localObject3).field_reserved);
      }
      localObject1 = ((k.b)localObject1).izy;
    }
    if (Util.isNullOrNil(((MsgQuoteItem)localObject1).zFJ))
    {
      Log.e("MicroMsg.msgquote.QuoteMsgSourceClickLogic", "msgQuoteItem.fromusr is null!(2)");
      AppMethodBeat.o(37034);
      return;
    }
    paramMsgQuoteItem = ((l)g.af(l.class)).eiy().aJ(((MsgQuoteItem)localObject1).zFJ, ((MsgQuoteItem)localObject1).zFI);
    if (paramMsgQuoteItem.field_msgId == 0L)
    {
      paramMsgQuoteItem = new ca();
      paramMsgQuoteItem.setType(((MsgQuoteItem)localObject1).type);
      paramMsgQuoteItem.yF(((MsgQuoteItem)localObject1).zFI);
      paramMsgQuoteItem.Cy(((MsgQuoteItem)localObject1).zFJ);
      paramMsgQuoteItem.BB(((MsgQuoteItem)localObject1).zFM);
      paramMsgQuoteItem.setContent(((MsgQuoteItem)localObject1).content);
      if (Util.isEqual(((MsgQuoteItem)localObject1).zFK, z.aTY())) {
        paramMsgQuoteItem.nv(1);
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
          com.tencent.mm.plugin.msgquote.model.b.b(1L, ((MsgQuoteItem)localObject1).zFI, ((MsgQuoteItem)localObject1).type, 0L);
        }
        AppMethodBeat.o(37034);
        return;
        paramc = new Intent(parama.Pwc.getContext(), TextPreviewUI.class);
        paramc.addFlags(67108864);
        paramc.putExtra("key_chat_text", ((MsgQuoteItem)localObject1).content);
        paramc.putExtra("Chat_Msg_Id", paramMsgQuoteItem.field_msgId);
        paramc.putExtra("key_msg_type", 1);
        paramc.putExtra("is_group_chat", parama.gRM());
        paramView = parama.Pwc.getContext();
        paramc = new com.tencent.mm.hellhoundlib.b.a().bl(paramc);
        com.tencent.mm.hellhoundlib.a.a.a(paramView, paramc.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramView.startActivity((Intent)paramc.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.ui.base.b.kc(parama.Pwc.getContext());
        continue;
        if (paramMsgQuoteItem.field_msgId == 0L)
        {
          paramc = new Intent();
          paramc.setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
          paramc.putExtra("clean_view_type", 1);
          paramc = new com.tencent.mm.hellhoundlib.b.a().bl(paramc);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramc.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          new av.c(parama, paramc, paramMsgQuoteItem, paramView);
          continue;
          if (paramMsgQuoteItem.field_msgId == 0L)
          {
            paramc = new Intent();
            paramc.setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
            paramc.putExtra("clean_view_type", 0);
            paramc = new com.tencent.mm.hellhoundlib.b.a().bl(paramc);
            com.tencent.mm.hellhoundlib.a.a.a(parama, paramc.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            parama.startActivity((Intent)paramc.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            new be.c(parama, paramMsgQuoteItem, paramView);
            continue;
            new aw.c(parama, paramMsgQuoteItem);
            continue;
            paramc = bi.mU(((MsgQuoteItem)localObject1).zFJ, paramMsgQuoteItem.field_content);
            if (paramc != null) {
              paramMsgQuoteItem.Cz(paramc.md5);
            }
            new aq.d(parama, paramMsgQuoteItem);
            continue;
            paramView = k.b.HD(paramMsgQuoteItem.field_content);
            if (paramView != null)
            {
              int j = 0;
              i = j;
              switch (paramView.type)
              {
              default: 
                i = j;
                if (!aI(paramMsgQuoteItem)) {
                  i = 1;
                }
                break;
              }
              for (;;)
              {
                com.tencent.mm.plugin.msgquote.model.b.b(1L, ((MsgQuoteItem)localObject1).zFI, 49L, paramView.type);
                if (!aI(paramMsgQuoteItem)) {
                  break label1793;
                }
                if (i == 0) {
                  break;
                }
                e.e.i(paramView, parama, paramc, paramMsgQuoteItem);
                break;
                if (!paramBoolean)
                {
                  u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
                  AppMethodBeat.o(37034);
                  return;
                }
                localObject2 = new Intent();
                ((Intent)localObject2).setClassName(parama.Pwc.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                ((Intent)localObject2).putExtra("scene", 2);
                ((Intent)localObject2).putExtra("app_msg_id", paramMsgQuoteItem.field_msgId);
                ((Intent)localObject2).putExtra("key_msg_type", 1);
                ((Intent)localObject2).putExtra("msg_type", 1);
                ((Intent)localObject2).putExtra("key_quoted_msg", (Parcelable)localObject1);
                localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
                com.tencent.mm.hellhoundlib.a.a.a(parama, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                parama.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                i = j;
                continue;
                if (aI(paramMsgQuoteItem))
                {
                  e.e.j(paramView, parama, paramc, paramMsgQuoteItem);
                  i = j;
                }
                else
                {
                  e.d.e(paramView, parama, paramc, paramMsgQuoteItem);
                  i = j;
                  continue;
                  if (aI(paramMsgQuoteItem))
                  {
                    e.e.b(paramView, parama, paramc, paramMsgQuoteItem);
                    i = j;
                  }
                  else
                  {
                    e.d.b(paramView, parama, paramc, paramMsgQuoteItem);
                    i = j;
                    continue;
                    if (aI(paramMsgQuoteItem))
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
                        if (aI(paramMsgQuoteItem))
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
                            localObject3 = new Intent(parama.Pwc.getContext(), TextPreviewUI.class);
                            ((Intent)localObject3).addFlags(67108864);
                            ((Intent)localObject3).putExtra("key_chat_text", paramView.title);
                            ((Intent)localObject3).putExtra("Chat_Msg_Id", paramMsgQuoteItem.field_msgId);
                            ((Intent)localObject3).putExtra("key_msg_type", 1);
                            ((Intent)localObject3).putExtra("is_group_chat", parama.gRM());
                            localObject2 = parama.Pwc.getContext();
                            localObject3 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject3);
                            com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            ((Activity)localObject2).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject3).pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgMsgQuote$QuoteMsgSourceClickLogic", "handleItemClickEvent", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/ui/chatting/viewitems/ChattingItem;Landroid/view/View;JLcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            com.tencent.mm.ui.base.b.kc(parama.Pwc.getContext());
                            i = j;
                            continue;
                            if (aI(paramMsgQuoteItem))
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
              label1793:
              if (i != 0) {
                e.d.e(paramView, parama, paramc, paramMsgQuoteItem);
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean aI(ca paramca)
  {
    return paramca.field_isSend == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.e
 * JD-Core Version:    0.7.0.1
 */