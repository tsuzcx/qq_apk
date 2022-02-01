package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bl;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class aa$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37059);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493447);
      ((View)localObject).setTag(new aa.a().gF((View)localObject));
    }
    AppMethodBeat.o(37059);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37060);
    this.JBI = parama1;
    ((m)parama1.bh(m.class)).bK(parambu);
    aa.a locala = (aa.a)parama;
    paramString = parambu.field_content;
    parama = paramString;
    if (parama1.fFv())
    {
      int i = parambu.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambu.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.aA(parama, parambu.field_reserved);; parama = null)
    {
      com.tencent.mm.pluginsdk.model.app.g localg;
      if ((parama != null) && (parama.type == 1))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.m(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label430;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.fx(paramString))) {
          break label440;
        }
        locala.rDq.setText(parama1.JOR.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.JOR.getContext(), localg, paramString) }));
        locala.rDq.setVisibility(0);
        a(parama1, locala.rDq, parama.appId);
        a(parama1, locala.rDq, parama.appId);
        label254:
        if ((parama.fkq == null) || (parama.fkq.length() <= 0)) {
          break label453;
        }
        b(parama1, locala.JZp, bk.aWI(parama.fkq));
        locala.JZp.setVisibility(0);
      }
      for (;;)
      {
        locala.KbY.setClickable(true);
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.KbY.getContext(), parama.title, (int)locala.KbY.getTextSize(), 1);
        locala.KbY.ar(paramString);
        locala.KbY.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
        ba.aBQ();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.KbY.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.KbY.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          }
        }
        AppMethodBeat.o(37060);
        return;
        label430:
        paramString = localg.field_appName;
        break;
        label440:
        locala.rDq.setVisibility(8);
        break label254;
        label453:
        locala.JZp.setVisibility(8);
      }
    }
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final bu parambu)
  {
    AppMethodBeat.i(37062);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37062);
      return false;
    case 102: 
      paramMenuItem = (ClipboardManager)aj.getContext().getSystemService("clipboard");
      parama = k.b.yr(bj.b(parama.fFu(), parambu.field_content, parambu.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yBN;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambu.field_msgSvrId, bt.aQW(parama));
      AppMethodBeat.o(37062);
      return false;
    }
    paramMenuItem = bl.E(parambu);
    if (bt.isNullOrNil(paramMenuItem))
    {
      paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(37062);
      return false;
      com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37057);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Fnz);
          d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(37057);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37058);
          Object localObject = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 2);
          ((Intent)localObject).putExtra("Retr_Msg_Id", parambu.field_msgId);
          paramAnonymousDialogInterface = parama;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.g.yhR.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(37058);
        }
      });
    }
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194412);
    int i = ((bk)paramView.getTag()).position;
    paraml.a(i, 102, this.JBI.JOR.getMMResources().getString(2131757218), 2131690381);
    paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
    if (d.aIu("favorite")) {
      paraml.a(i, 116, this.JBI.JOR.getMMResources().getString(2131761941), 2131690400);
    }
    if (bl.z(parambu)) {
      paraml.clear();
    }
    if (!this.JBI.fFw()) {
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194412);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.b
 * JD-Core Version:    0.7.0.1
 */