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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bk;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class y$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493447);
      ((View)localObject).setTag(new y.a().gb((View)localObject));
    }
    AppMethodBeat.o(37059);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37060);
    this.Gob = parama1;
    ((com.tencent.mm.ui.chatting.c.b.k)parama1.be(com.tencent.mm.ui.chatting.c.b.k.class)).bC(parambl);
    y.a locala = (y.a)parama;
    paramString = parambl.field_content;
    parama = paramString;
    if (parama1.eZb())
    {
      int i = parambl.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = parambl.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.ar(parama, parambl.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.j(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label430;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.eM(paramString))) {
          break label440;
        }
        locala.qkL.setText(parama1.GzJ.getMMResources().getString(2131757317, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.GzJ.getContext(), localg, paramString) }));
        locala.qkL.setVisibility(0);
        a(parama1, locala.qkL, parama.appId);
        a(parama1, locala.qkL, parama.appId);
        label254:
        if ((parama.eOT == null) || (parama.eOT.length() <= 0)) {
          break label453;
        }
        b(parama1, locala.GIU, bi.aLk(parama.eOT));
        locala.GIU.setVisibility(0);
      }
      for (;;)
      {
        locala.GLB.setClickable(true);
        paramString = com.tencent.mm.pluginsdk.ui.span.k.a(locala.GLB.getContext(), parama.title, (int)locala.GLB.getTextSize(), 1);
        locala.GLB.aq(paramString);
        locala.GLB.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
        az.arV();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.GLB.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.GLB.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          }
        }
        AppMethodBeat.o(37060);
        return;
        label430:
        paramString = localg.field_appName;
        break;
        label440:
        locala.qkL.setVisibility(8);
        break label254;
        label453:
        locala.GIU.setVisibility(8);
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37061);
    int i = ((bi)paramView.getTag()).position;
    paramContextMenu.add(i, 102, 0, this.Gob.GzJ.getMMResources().getString(2131757218));
    paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
    if (d.axB("favorite")) {
      paramContextMenu.add(i, 116, 0, this.Gob.GzJ.getMMResources().getString(2131761941));
    }
    if (bk.x(parambl)) {
      paramContextMenu.clear();
    }
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37061);
    return true;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
  {
    AppMethodBeat.i(37062);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37062);
      return false;
    case 102: 
      paramMenuItem = (ClipboardManager)aj.getContext().getSystemService("clipboard");
      parama = k.b.rx(com.tencent.mm.model.bi.b(parama.eZa(), parambl.field_content, parambl.field_isSend)).title;
      paramMenuItem.setText(parama);
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.wcB;
      com.tencent.mm.plugin.secinforeport.a.a.m(1, parambl.field_msgSvrId, bt.aFZ(parama));
      AppMethodBeat.o(37062);
      return false;
    }
    paramMenuItem = bk.C(parambl);
    if (bt.isNullOrNil(paramMenuItem))
    {
      paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(37062);
      return false;
      com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(parama.GzJ.getContext(), 2131762971, 2131762972, 2131755928, 2131757288, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37057);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Cqa);
          d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(37057);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37058);
          Object localObject = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 2);
          ((Intent)localObject).putExtra("Retr_Msg_Id", parambl.field_msgId);
          paramAnonymousDialogInterface = parama;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.vKh.f(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(37058);
        }
      });
    }
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.b
 * JD-Core Version:    0.7.0.1
 */