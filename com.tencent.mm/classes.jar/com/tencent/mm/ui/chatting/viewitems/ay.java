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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public final class ay
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  private g onSceneEndCallback;
  private ProgressDialog wfA;
  
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
      localObject = new af(paramLayoutInflater, 2131493510);
      ((View)localObject).setTag(new be().gi((View)localObject));
    }
    AppMethodBeat.o(37500);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, String paramString)
  {
    AppMethodBeat.i(37501);
    paramString = (be)parama;
    this.Gob = parama1;
    parama = ap.evR().vk(parambl.field_msgId);
    parama1 = parambl.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = k.b.rx(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = com.tencent.mm.plugin.subapp.d.e.asj(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.yCZ == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.g.h.ah(this.Gob.GzJ.getContext(), parama1.yCZ);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.hJe.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.GQB.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.GQC.setText(localObject1[1]);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          long l;
          Object localObject3;
          ad.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
          continue;
          paramString.GQF.setVisibility(8);
          paramString.hJe.setTextColor(this.Gob.GzJ.getMMResources().getColor(2131101084));
          paramString.GQC.setTextColor(this.Gob.GzJ.getMMResources().getColor(2131101084));
          paramString.GQB.setTextColor(this.Gob.GzJ.getMMResources().getColor(2131101084));
          continue;
          int i = 0;
          continue;
          paramString.GQD.setBackgroundResource(2131234498);
          continue;
        }
        bool1 = ae.pM(parama1.yCZ);
        if (!bool1) {
          continue;
        }
        paramString.GQF.setVisibility(0);
        paramString.hJe.setTextColor(this.Gob.GzJ.getMMResources().getColor(2131101085));
        paramString.GQC.setTextColor(this.Gob.GzJ.getMMResources().getColor(2131101085));
        paramString.GQB.setTextColor(this.Gob.GzJ.getMMResources().getColor(2131101085));
        paramString.GQD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37493);
            if (ae.isNullOrNil(parambl.field_imgPath))
            {
              ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
              AppMethodBeat.o(37493);
              return;
            }
            ((ao)ay.a(ay.this).be(ao.class)).eYQ().b(paramInt, parambl);
            AppMethodBeat.o(37493);
          }
        });
        l = parambl.field_msgId;
        localObject1 = ((ao)this.Gob.be(ao.class)).eYQ();
        if ((localObject1 == null) || (!((com.tencent.mm.ui.chatting.d)localObject1).isPlaying()) || (((com.tencent.mm.ui.chatting.d)localObject1).GkH != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.GQD.setBackgroundResource(2131234497);
        if ((parama1 != null) && (!ae.isNullOrNil(parama1.yDb)) && (parama1.yDc > 0) && (ae.isNullOrNil(parambl.field_reserved)) && (parama != null))
        {
          localObject1 = k.zP(u.aqG());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.bP((String)localObject1, false);
          parambl.oa((String)localObject1);
          az.arV();
          com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
          localObject1 = m.a((String)localObject2, parambl.field_msgId, parama.sdkVer, parama.appId, parama1.yDb, parama1.yDc, parama.type, parama.gHi);
          if (localObject1 != null)
          {
            localObject2 = az.aeS();
            localObject3 = new g()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37494);
                ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                boolean bool = false;
                if (ar.a.gMZ != null) {
                  bool = ar.a.gMZ.lV(parambl.field_msgId);
                }
                if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.e)paramAnonymousn).getMediaId().equals(this.Jd)))
                {
                  paramAnonymousString = bl.aI(parambl);
                  paramAnonymousString.nZ(parambl.field_reserved);
                  paramAnonymousString.setMsgId(-1L);
                  ((ao)ay.a(ay.this).be(ao.class)).eYQ().b(paramInt, paramAnonymousString);
                }
                az.aeS().b(221, ay.b(ay.this));
                ay.a(ay.this, null);
                AppMethodBeat.o(37494);
              }
            };
            this.onSceneEndCallback = ((g)localObject3);
            ((q)localObject2).a(221, (g)localObject3);
            localObject1 = new com.tencent.mm.plugin.record.b.e((String)localObject1);
            ((com.tencent.mm.plugin.record.b.e)localObject1).dge();
            az.aeS().a((n)localObject1, 0);
          }
        }
        if ((ae.isNullOrNil(parambl.field_imgPath)) && (parama1.yDf > 0))
        {
          az.arV();
          localObject1 = com.tencent.mm.model.c.apO().aD(parambl.field_talker, parama1.yDf);
          if (!ae.isNullOrNil(((du)localObject1).field_imgPath))
          {
            localObject2 = k.zP(u.aqG());
            localObject3 = com.tencent.mm.plugin.subapp.d.h.bP((String)localObject2, false);
            if (i.lC(com.tencent.mm.plugin.subapp.d.h.bP(((du)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              parambl.nZ((String)localObject2);
              az.arV();
              com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
            }
          }
        }
        if ((ae.isNullOrNil(parambl.field_imgPath)) && (parama1 != null) && (!ae.isNullOrNil(parama1.dbA)) && (parama1.gHe > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = k.zP(u.aqG());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.bP((String)localObject1, false);
          parambl.nZ((String)localObject1);
          az.arV();
          com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
          parama = m.a((String)localObject2, parambl.field_msgId, parama.sdkVer, parama.appId, parama.dbA, parama.gHe);
          ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = az.aeS();
            localObject2 = new g()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37495);
                ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                if (((com.tencent.mm.plugin.record.b.e)paramAnonymousn).getMediaId().equals(parama.field_mediaSvrId))
                {
                  az.aeS().b(221, ay.b(ay.this));
                  ay.a(ay.this, null);
                }
                AppMethodBeat.o(37495);
              }
            };
            this.onSceneEndCallback = ((g)localObject2);
            ((q)localObject1).a(221, (g)localObject2);
            parama = new com.tencent.mm.plugin.record.b.e(parama);
            az.aeS().a(parama, 0);
          }
        }
        paramString.GQE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37499);
            com.tencent.mm.ui.base.h.a(ay.a(ay.this).GzJ.getContext(), 2131764758, 2131764760, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(37498);
                az.aeS().a(331, ay.a(ay.this, new g()
                {
                  public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, n paramAnonymous3n)
                  {
                    AppMethodBeat.i(37496);
                    ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3n.getType());
                    if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                    {
                      paramAnonymous3String = ay.4.this.GQj.field_content;
                      if (paramAnonymous3String == null) {
                        break label330;
                      }
                    }
                    label330:
                    for (paramAnonymous3String = k.b.rx(paramAnonymous3String);; paramAnonymous3String = null)
                    {
                      if (paramAnonymous3String != null)
                      {
                        long l = ay.4.this.GQj.field_msgId;
                        paramAnonymous3String = ap.bxS().vj(l);
                        if (paramAnonymous3String != null) {
                          ad.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(i.deleteFile(paramAnonymous3String.field_fileFullPath)), Boolean.valueOf(ap.bxS().delete(paramAnonymous3String, new String[] { "msgInfoId" })), Long.valueOf(paramAnonymous3String.field_msgInfoId), paramAnonymous3String.field_mediaSvrId, paramAnonymous3String.field_fileFullPath, bt.eGN() });
                        }
                      }
                      com.tencent.mm.model.bi.lW(ay.4.this.GQj.field_msgId);
                      Toast.makeText(ay.a(ay.this).GzJ.getContext(), ay.a(ay.this).GzJ.getMMResources().getString(2131757209), 0).show();
                      az.aeS().b(331, ay.b(ay.this));
                      ay.a(ay.this, null);
                      if (ay.c(ay.this) != null) {
                        ay.c(ay.this).dismiss();
                      }
                      AppMethodBeat.o(37496);
                      return;
                    }
                  }
                }));
                paramAnonymous2DialogInterface = new LinkedList();
                Object localObject = new dla();
                ((dla)localObject).CyH = ay.4.this.GQn.yDa;
                paramAnonymous2DialogInterface.add(localObject);
                paramAnonymous2DialogInterface = new com.tencent.mm.plugin.subapp.d.a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
                az.aeS().a(paramAnonymous2DialogInterface, 0);
                localObject = ay.this;
                Activity localActivity = ay.a(ay.this).GzJ.getContext();
                ay.a(ay.this).GzJ.getMMResources().getString(2131755906);
                ay.a((ay)localObject, com.tencent.mm.ui.base.h.b(localActivity, ay.a(ay.this).GzJ.getMMResources().getString(2131757210), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(37497);
                    az.aeS().a(paramAnonymous2DialogInterface);
                    az.aeS().b(331, ay.b(ay.this));
                    ay.a(ay.this, null);
                    if (ay.c(ay.this) != null) {
                      ay.c(ay.this).dismiss();
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
        paramString.naN.setTag(new bi(parambl, this.Gob.eZb(), paramInt, null, '\000'));
        az.arV();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.naN.setOnLongClickListener(c(this.Gob));
        }
        AppMethodBeat.o(37501);
        return;
        paramString.hJe.setText("");
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37502);
    int i = ((bi)paramView.getTag()).position;
    int j = m.aAU(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    paramView = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    if ((paramView.gHe <= 0) || ((paramView.gHe > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
    }
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37502);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37503);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37503);
      return false;
    }
    paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return true;
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay
 * JD-Core Version:    0.7.0.1
 */