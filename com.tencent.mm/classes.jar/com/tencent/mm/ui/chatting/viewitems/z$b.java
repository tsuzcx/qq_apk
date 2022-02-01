package com.tencent.mm.ui.chatting.viewitems;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.bk;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class z$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493447);
      ((View)localObject).setTag(new z.a().go((View)localObject));
    }
    AppMethodBeat.o(37059);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37060);
    this.HNS = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.bf(com.tencent.mm.ui.chatting.c.b.k.class)).bE(parambo);
    z.a locala = (z.a)parama;
    paramString = parambo.field_content;
    parama = paramString;
    if (parama1.foQ())
    {
      int i = parambo.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambo.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.az(parama, parambo.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.k(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label430;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eC(paramString))) {
          break label440;
        }
        locala.qTn.setText(parama1.HZF.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.HZF.getContext(), localg, paramString) }));
        locala.qTn.setVisibility(0);
        a(parama1, locala.qTn, parama.appId);
        a(parama1, locala.qTn, parama.appId);
        label254:
        if ((parama.eSb == null) || (parama.eSb.length() <= 0)) {
          break label453;
        }
        b(parama1, locala.IiR, bj.aQO(parama.eSb));
        locala.IiR.setVisibility(0);
      }
      for (;;)
      {
        locala.Ily.setClickable(true);
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.Ily.getContext(), parama.title, (int)locala.Ily.getTextSize(), 1);
        locala.Ily.ar(paramString);
        locala.Ily.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
        az.ayM();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.Ily.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.Ily.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          }
        }
        AppMethodBeat.o(37060);
        return;
        label430:
        paramString = localg.field_appName;
        break;
        label440:
        locala.qTn.setVisibility(8);
        break label254;
        label453:
        locala.IiR.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37061);
    int i = ((bj)paramView.getTag()).position;
    paramContextMenu.add(i, 102, 0, this.HNS.HZF.getMMResources().getString(2131757218));
    paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
    if (d.aCT("favorite")) {
      paramContextMenu.add(i, 116, 0, this.HNS.HZF.getMMResources().getString(2131761941));
    }
    if (bk.x(parambo)) {
      paramContextMenu.clear();
    }
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37061);
    return true;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
  {
    AppMethodBeat.i(37062);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37062);
      return false;
    case 102: 
      paramMenuItem = (ClipboardManager)ai.getContext().getSystemService("clipboard");
      parama = k.b.vA(bi.b(parama.foP(), parambo.field_content, parambo.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.xnM;
      com.tencent.mm.plugin.secinforeport.a.a.o(1, parambo.field_msgSvrId, bs.aLq(parama));
      AppMethodBeat.o(37062);
      return false;
    }
    paramMenuItem = bk.C(parambo);
    if (bs.isNullOrNil(paramMenuItem))
    {
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(37062);
      return false;
      com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(parama.HZF.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37057);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.DIs);
          d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(37057);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37058);
          Object localObject = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 2);
          ((Intent)localObject).putExtra("Retr_Msg_Id", parambo.field_msgId);
          paramAnonymousDialogInterface = parama;
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.wUl.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(37058);
        }
      });
    }
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.z.b
 * JD-Core Version:    0.7.0.1
 */