package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dqr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public final class az
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  private g onSceneEndCallback;
  private ProgressDialog xqQ;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37500);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493510);
      ((View)localObject).setTag(new bf().gv((View)localObject));
    }
    AppMethodBeat.o(37500);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, String paramString)
  {
    AppMethodBeat.i(37501);
    paramString = (bf)parama;
    this.HNS = parama1;
    parama = ap.eLl().zN(parambo.field_msgId);
    parama1 = parambo.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = k.b.vA(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = com.tencent.mm.plugin.subapp.d.e.axs(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.zQn == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.g.h.an(this.HNS.HZF.getContext(), parama1.zQn);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.ijE.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.IqC.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.IqD.setText(localObject1[1]);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          long l;
          Object localObject3;
          ac.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
          continue;
          paramString.IqG.setVisibility(8);
          paramString.ijE.setTextColor(this.HNS.HZF.getMMResources().getColor(2131101084));
          paramString.IqD.setTextColor(this.HNS.HZF.getMMResources().getColor(2131101084));
          paramString.IqC.setTextColor(this.HNS.HZF.getMMResources().getColor(2131101084));
          continue;
          int i = 0;
          continue;
          paramString.IqE.setBackgroundResource(2131234498);
          continue;
        }
        bool1 = ae.qz(parama1.zQn);
        if (!bool1) {
          continue;
        }
        paramString.IqG.setVisibility(0);
        paramString.ijE.setTextColor(this.HNS.HZF.getMMResources().getColor(2131101085));
        paramString.IqD.setTextColor(this.HNS.HZF.getMMResources().getColor(2131101085));
        paramString.IqC.setTextColor(this.HNS.HZF.getMMResources().getColor(2131101085));
        paramString.IqE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37493);
            if (ae.isNullOrNil(parambo.field_imgPath))
            {
              ac.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
              AppMethodBeat.o(37493);
              return;
            }
            ((ao)az.a(az.this).bf(ao.class)).foG().b(paramInt, parambo);
            AppMethodBeat.o(37493);
          }
        });
        l = parambo.field_msgId;
        localObject1 = ((ao)this.HNS.bf(ao.class)).foG();
        if ((localObject1 == null) || (!((com.tencent.mm.ui.chatting.d)localObject1).isPlaying()) || (((com.tencent.mm.ui.chatting.d)localObject1).HKw != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.IqE.setBackgroundResource(2131234497);
        if ((parama1 != null) && (!ae.isNullOrNil(parama1.zQp)) && (parama1.zQq > 0) && (ae.isNullOrNil(parambo.field_reserved)) && (parama != null))
        {
          localObject1 = k.DU(u.axw());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.bW((String)localObject1, false);
          parambo.rg((String)localObject1);
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
          localObject1 = m.a((String)localObject2, parambo.field_msgId, parama.sdkVer, parama.appId, parama1.zQp, parama1.zQq, parama.type, parama.hhJ);
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.model.az.agi();
            localObject3 = new g()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37494);
                ac.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                boolean bool = false;
                if (ar.a.hnz != null) {
                  bool = ar.a.hnz.pJ(parambo.field_msgId);
                }
                if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.e)paramAnonymousn).getMediaId().equals(this.JY)))
                {
                  paramAnonymousString = bo.aK(parambo);
                  paramAnonymousString.rf(parambo.field_reserved);
                  paramAnonymousString.setMsgId(-1L);
                  ((ao)az.a(az.this).bf(ao.class)).foG().b(paramInt, paramAnonymousString);
                }
                com.tencent.mm.model.az.agi().b(221, az.b(az.this));
                az.a(az.this, null);
                AppMethodBeat.o(37494);
              }
            };
            this.onSceneEndCallback = ((g)localObject3);
            ((q)localObject2).a(221, (g)localObject3);
            localObject1 = new com.tencent.mm.plugin.record.b.e((String)localObject1);
            ((com.tencent.mm.plugin.record.b.e)localObject1).dtL();
            com.tencent.mm.model.az.agi().a((n)localObject1, 0);
          }
        }
        if ((ae.isNullOrNil(parambo.field_imgPath)) && (parama1.zQt > 0))
        {
          com.tencent.mm.model.az.ayM();
          localObject1 = com.tencent.mm.model.c.awD().aF(parambo.field_talker, parama1.zQt);
          if (!ae.isNullOrNil(((dy)localObject1).field_imgPath))
          {
            localObject2 = k.DU(u.axw());
            localObject3 = com.tencent.mm.plugin.subapp.d.h.bW((String)localObject2, false);
            if (i.lZ(com.tencent.mm.plugin.subapp.d.h.bW(((dy)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              parambo.rf((String)localObject2);
              com.tencent.mm.model.az.ayM();
              com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
            }
          }
        }
        if ((ae.isNullOrNil(parambo.field_imgPath)) && (parama1 != null) && (!ae.isNullOrNil(parama1.cZa)) && (parama1.hhF > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = k.DU(u.axw());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.bW((String)localObject1, false);
          parambo.rf((String)localObject1);
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
          parama = m.a((String)localObject2, parambo.field_msgId, parama.sdkVer, parama.appId, parama.cZa, parama.hhF);
          ac.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = com.tencent.mm.model.az.agi();
            localObject2 = new g()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37495);
                ac.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                if (((com.tencent.mm.plugin.record.b.e)paramAnonymousn).getMediaId().equals(parama.field_mediaSvrId))
                {
                  com.tencent.mm.model.az.agi().b(221, az.b(az.this));
                  az.a(az.this, null);
                }
                AppMethodBeat.o(37495);
              }
            };
            this.onSceneEndCallback = ((g)localObject2);
            ((q)localObject1).a(221, (g)localObject2);
            parama = new com.tencent.mm.plugin.record.b.e(parama);
            com.tencent.mm.model.az.agi().a(parama, 0);
          }
        }
        paramString.IqF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37499);
            com.tencent.mm.ui.base.h.a(az.a(az.this).HZF.getContext(), 2131764758, 2131764760, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(37498);
                com.tencent.mm.model.az.agi().a(331, az.a(az.this, new g()
                {
                  public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, n paramAnonymous3n)
                  {
                    AppMethodBeat.i(37496);
                    ac.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3n.getType());
                    if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                    {
                      paramAnonymous3String = az.4.this.Iqk.field_content;
                      if (paramAnonymous3String == null) {
                        break label330;
                      }
                    }
                    label330:
                    for (paramAnonymous3String = k.b.vA(paramAnonymous3String);; paramAnonymous3String = null)
                    {
                      if (paramAnonymous3String != null)
                      {
                        long l = az.4.this.Iqk.field_msgId;
                        paramAnonymous3String = ap.bEO().zM(l);
                        if (paramAnonymous3String != null) {
                          ac.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(i.deleteFile(paramAnonymous3String.field_fileFullPath)), Boolean.valueOf(ap.bEO().delete(paramAnonymous3String, new String[] { "msgInfoId" })), Long.valueOf(paramAnonymous3String.field_msgInfoId), paramAnonymous3String.field_mediaSvrId, paramAnonymous3String.field_fileFullPath, bs.eWi() });
                        }
                      }
                      bi.pK(az.4.this.Iqk.field_msgId);
                      Toast.makeText(az.a(az.this).HZF.getContext(), az.a(az.this).HZF.getMMResources().getString(2131757209), 0).show();
                      com.tencent.mm.model.az.agi().b(331, az.b(az.this));
                      az.a(az.this, null);
                      if (az.c(az.this) != null) {
                        az.c(az.this).dismiss();
                      }
                      AppMethodBeat.o(37496);
                      return;
                    }
                  }
                }));
                paramAnonymous2DialogInterface = new LinkedList();
                Object localObject = new dqr();
                ((dqr)localObject).DRd = az.4.this.Iqo.zQo;
                paramAnonymous2DialogInterface.add(localObject);
                paramAnonymous2DialogInterface = new com.tencent.mm.plugin.subapp.d.a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
                com.tencent.mm.model.az.agi().a(paramAnonymous2DialogInterface, 0);
                localObject = az.this;
                Activity localActivity = az.a(az.this).HZF.getContext();
                az.a(az.this).HZF.getMMResources().getString(2131755906);
                az.a((az)localObject, com.tencent.mm.ui.base.h.b(localActivity, az.a(az.this).HZF.getMMResources().getString(2131757210), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(37497);
                    com.tencent.mm.model.az.agi().a(paramAnonymous2DialogInterface);
                    com.tencent.mm.model.az.agi().b(331, az.b(az.this));
                    az.a(az.this, null);
                    if (az.c(az.this) != null) {
                      az.c(az.this).dismiss();
                    }
                    AppMethodBeat.o(37497);
                  }
                }));
                AppMethodBeat.o(37498);
              }
            }, null);
            AppMethodBeat.o(37499);
          }
        });
        paramString.nDl.setTag(new bj(parambo, this.HNS.foQ(), paramInt, null, '\000'));
        com.tencent.mm.model.az.ayM();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.nDl.setOnLongClickListener(c(this.HNS));
        }
        AppMethodBeat.o(37501);
        return;
        paramString.ijE.setText("");
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37502);
    int i = ((bj)paramView.getTag()).position;
    int j = m.aGm(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    paramView = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    if ((paramView.hhF <= 0) || ((paramView.hhF > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
    }
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37502);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37503);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37503);
      return false;
    }
    paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az
 * JD-Core Version:    0.7.0.1
 */