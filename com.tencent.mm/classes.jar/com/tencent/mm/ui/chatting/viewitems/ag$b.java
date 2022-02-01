package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class ag$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493548);
      ((View)localObject).setTag(new ag.a().ha((View)localObject));
    }
    AppMethodBeat.o(37059);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37060);
    this.PhN = parama1;
    ((com.tencent.mm.ui.chatting.d.b.m)parama1.bh(com.tencent.mm.ui.chatting.d.b.m.class)).bZ(paramca);
    ag.a locala = (ag.a)parama;
    paramString = paramca.field_content;
    parama = paramString;
    if (parama1.gRM())
    {
      int i = paramca.field_content.indexOf(':');
      parama = paramString;
      if (i != -1) {
        parama = paramca.field_content.substring(i + 1);
      }
    }
    if (parama != null) {}
    for (parama = k.b.aD(parama, paramca.field_reserved);; parama = null)
    {
      g localg;
      if ((parama != null) && (parama.type == 1))
      {
        localg = com.tencent.mm.pluginsdk.model.app.h.o(parama.appId, true, false);
        if ((localg != null) && (localg.field_appName != null) && (localg.field_appName.trim().length() > 0)) {
          break label430;
        }
        paramString = parama.appName;
        if ((parama.appId == null) || (parama.appId.length() <= 0) || (!com.tencent.mm.pluginsdk.model.app.h.gp(paramString))) {
          break label440;
        }
        locala.tln.setText(parama1.Pwc.getMMResources().getString(2131757531, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(parama1.Pwc.getContext(), localg, paramString) }));
        locala.tln.setVisibility(0);
        a(parama1, locala.tln, parama.appId);
        a(parama1, locala.tln, parama.appId);
        label254:
        if ((parama.fQR == null) || (parama.fQR.length() <= 0)) {
          break label453;
        }
        b(parama1, locala.PHZ, bq.bnn(parama.fQR));
        locala.PHZ.setVisibility(0);
      }
      for (;;)
      {
        locala.PKD.setClickable(true);
        paramString = l.a(locala.PKD.getContext(), parama.title, (int)locala.PKD.getTextSize(), 1);
        locala.PKD.aw(paramString);
        locala.PKD.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
        bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable())
        {
          locala.PKD.setOnLongClickListener(c(parama1));
          if ((parama != null) && (parama.type == 1)) {
            locala.PKD.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
          }
        }
        AppMethodBeat.o(37060);
        return;
        label430:
        paramString = localg.field_appName;
        break;
        label440:
        locala.tln.setVisibility(8);
        break label254;
        label453:
        locala.PHZ.setVisibility(8);
      }
    }
  }
  
  public final boolean a(final MenuItem paramMenuItem, final com.tencent.mm.ui.chatting.e.a parama, final ca paramca)
  {
    AppMethodBeat.i(37062);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37062);
      return false;
    case 102: 
      paramMenuItem = k.b.HD(bp.b(parama.gRL(), paramca.field_content, paramca.field_isSend)).title;
      ClipboardHelper.setText(paramMenuItem);
      parama = com.tencent.mm.plugin.secinforeport.a.a.CWD;
      com.tencent.mm.plugin.secinforeport.a.a.q(1, paramca.field_msgSvrId, Util.getUTF8ByteLength(paramMenuItem));
      AppMethodBeat.o(37062);
      return false;
    }
    paramMenuItem = br.N(paramca);
    if (Util.isNullOrNil(paramMenuItem))
    {
      paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(37062);
      return false;
      com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(3), paramMenuItem });
      com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), 2131765108, 2131765109, 2131756020, 2131757502, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37057);
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("rawUrl", paramMenuItem);
          paramAnonymousDialogInterface.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
          paramAnonymousDialogInterface.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
          com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramAnonymousDialogInterface);
          com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(1), paramMenuItem });
          AppMethodBeat.o(37057);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(37058);
          Object localObject = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
          ((Intent)localObject).putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
          ((Intent)localObject).putExtra("Retr_Msg_Type", 2);
          ((Intent)localObject).putExtra("Retr_Msg_Id", paramca.field_msgId);
          paramAnonymousDialogInterface = parama;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousDialogInterface.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousDialogInterface, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsgText$ChattingItemAppMsgTextFrom$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          com.tencent.mm.plugin.report.service.h.CyF.a(17509, new Object[] { Integer.valueOf(2), paramMenuItem });
          AppMethodBeat.o(37058);
        }
      });
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233804);
    int i = ((bq)paramView.getTag()).position;
    paramm.a(i, 102, this.PhN.Pwc.getMMResources().getString(2131757430), 2131690525);
    paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
    if (com.tencent.mm.br.c.aZU("favorite")) {
      paramm.a(i, 116, this.PhN.Pwc.getMMResources().getString(2131763947), 2131690551);
    }
    if (br.B(paramca)) {
      paramm.clear();
    }
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    AppMethodBeat.o(233804);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 16777265);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag.b
 * JD-Core Version:    0.7.0.1
 */