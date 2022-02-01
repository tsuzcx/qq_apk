package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.f;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dwl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.LinkedList;

public final class ba
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  private com.tencent.mm.al.f onSceneEndCallback;
  private ProgressDialog yFx;
  
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
      localObject = new ah(paramLayoutInflater, 2131493510);
      ((View)localObject).setTag(new bg().gM((View)localObject));
    }
    AppMethodBeat.o(37500);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, String paramString)
  {
    AppMethodBeat.i(37501);
    paramString = (bg)parama;
    this.JBI = parama1;
    parama = ao.fag().xH(parambu.field_msgId);
    parama1 = parambu.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = k.b.yr(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = e.aCw(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.BhO == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.i.i.aq(this.JBI.JOR.getContext(), parama1.BhO);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.iCV.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.Khe.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.Khf.setText(localObject1[1]);
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
          paramString.Khi.setVisibility(8);
          paramString.iCV.setTextColor(this.JBI.JOR.getMMResources().getColor(2131101084));
          paramString.Khf.setTextColor(this.JBI.JOR.getMMResources().getColor(2131101084));
          paramString.Khe.setTextColor(this.JBI.JOR.getMMResources().getColor(2131101084));
          continue;
          int i = 0;
          continue;
          paramString.Khg.setBackgroundResource(2131234498);
          continue;
        }
        bool1 = af.qZ(parama1.BhO);
        if (!bool1) {
          continue;
        }
        paramString.Khi.setVisibility(0);
        paramString.iCV.setTextColor(this.JBI.JOR.getMMResources().getColor(2131101085));
        paramString.Khf.setTextColor(this.JBI.JOR.getMMResources().getColor(2131101085));
        paramString.Khe.setTextColor(this.JBI.JOR.getMMResources().getColor(2131101085));
        paramString.Khg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37493);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            if (af.isNullOrNil(parambu.field_imgPath))
            {
              ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37493);
              return;
            }
            ((as)ba.a(ba.this).bh(as.class)).fFk().b(paramInt, parambu);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37493);
          }
        });
        l = parambu.field_msgId;
        localObject1 = ((as)this.JBI.bh(as.class)).fFk();
        if ((localObject1 == null) || (!((com.tencent.mm.ui.chatting.d)localObject1).isPlaying()) || (((com.tencent.mm.ui.chatting.d)localObject1).Jyn != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.Khg.setBackgroundResource(2131234497);
        if ((parama1 != null) && (!af.isNullOrNil(parama1.BhQ)) && (parama1.BhR > 0) && (af.isNullOrNil(parambu.field_reserved)) && (parama != null))
        {
          localObject1 = k.Hg(u.aAm());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.cd((String)localObject1, false);
          parambu.tP((String)localObject1);
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
          localObject1 = m.a((String)localObject2, parambu.field_msgId, parama.sdkVer, parama.appId, parama1.BhQ, parama1.BhR, parama.type, parama.hzS);
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.model.ba.aiU();
            localObject3 = new com.tencent.mm.al.f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37494);
                ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                boolean bool = false;
                if (as.a.hFR != null) {
                  bool = as.a.hFR.rI(parambu.field_msgId);
                }
                if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.f)paramAnonymousn).getMediaId().equals(this.LO)))
                {
                  paramAnonymousString = bu.aN(parambu);
                  paramAnonymousString.tO(parambu.field_reserved);
                  paramAnonymousString.setMsgId(-1L);
                  ((as)ba.a(ba.this).bh(as.class)).fFk().b(paramInt, paramAnonymousString);
                }
                com.tencent.mm.model.ba.aiU().b(221, ba.b(ba.this));
                ba.a(ba.this, null);
                AppMethodBeat.o(37494);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.al.f)localObject3);
            ((q)localObject2).a(221, (com.tencent.mm.al.f)localObject3);
            localObject1 = new com.tencent.mm.plugin.record.b.f((String)localObject1);
            ((com.tencent.mm.plugin.record.b.f)localObject1).dEi();
            com.tencent.mm.model.ba.aiU().a((n)localObject1, 0);
          }
        }
        if ((af.isNullOrNil(parambu.field_imgPath)) && (parama1.BhU > 0))
        {
          com.tencent.mm.model.ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azs().aI(parambu.field_talker, parama1.BhU);
          if (!af.isNullOrNil(((ei)localObject1).field_imgPath))
          {
            localObject2 = k.Hg(u.aAm());
            localObject3 = com.tencent.mm.plugin.subapp.d.h.cd((String)localObject2, false);
            if (com.tencent.mm.vfs.i.mz(com.tencent.mm.plugin.subapp.d.h.cd(((ei)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              parambu.tO((String)localObject2);
              com.tencent.mm.model.ba.aBQ();
              com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
            }
          }
        }
        if ((af.isNullOrNil(parambu.field_imgPath)) && (parama1 != null) && (!af.isNullOrNil(parama1.dks)) && (parama1.hzO > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = k.Hg(u.aAm());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.cd((String)localObject1, false);
          parambu.tO((String)localObject1);
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
          parama = m.a((String)localObject2, parambu.field_msgId, parama.sdkVer, parama.appId, parama.dks, parama.hzO);
          ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = com.tencent.mm.model.ba.aiU();
            localObject2 = new com.tencent.mm.al.f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37495);
                ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                if (((com.tencent.mm.plugin.record.b.f)paramAnonymousn).getMediaId().equals(parama.field_mediaSvrId))
                {
                  com.tencent.mm.model.ba.aiU().b(221, ba.b(ba.this));
                  ba.a(ba.this, null);
                }
                AppMethodBeat.o(37495);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.al.f)localObject2);
            ((q)localObject1).a(221, (com.tencent.mm.al.f)localObject2);
            parama = new com.tencent.mm.plugin.record.b.f(parama);
            com.tencent.mm.model.ba.aiU().a(parama, 0);
          }
        }
        paramString.Khh.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37499);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            com.tencent.mm.ui.base.h.a(ba.a(ba.this).JOR.getContext(), 2131764758, 2131764760, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(37498);
                com.tencent.mm.model.ba.aiU().a(331, ba.a(ba.this, new com.tencent.mm.al.f()
                {
                  public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, n paramAnonymous3n)
                  {
                    AppMethodBeat.i(37496);
                    ad.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3n.getType());
                    if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                    {
                      paramAnonymous3String = ba.4.this.KgM.field_content;
                      if (paramAnonymous3String == null) {
                        break label330;
                      }
                    }
                    label330:
                    for (paramAnonymous3String = k.b.yr(paramAnonymous3String);; paramAnonymous3String = null)
                    {
                      if (paramAnonymous3String != null)
                      {
                        long l = ba.4.this.KgM.field_msgId;
                        paramAnonymous3String = ao.bIX().CB(l);
                        if (paramAnonymous3String != null) {
                          ad.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.vfs.i.deleteFile(paramAnonymous3String.field_fileFullPath)), Boolean.valueOf(ao.bIX().delete(paramAnonymous3String, new String[] { "msgInfoId" })), Long.valueOf(paramAnonymous3String.field_msgInfoId), paramAnonymous3String.field_mediaSvrId, paramAnonymous3String.field_fileFullPath, bt.flS() });
                        }
                      }
                      bj.rJ(ba.4.this.KgM.field_msgId);
                      Toast.makeText(ba.a(ba.this).JOR.getContext(), ba.a(ba.this).JOR.getMMResources().getString(2131757209), 0).show();
                      com.tencent.mm.model.ba.aiU().b(331, ba.b(ba.this));
                      ba.a(ba.this, null);
                      if (ba.c(ba.this) != null) {
                        ba.c(ba.this).dismiss();
                      }
                      AppMethodBeat.o(37496);
                      return;
                    }
                  }
                }));
                paramAnonymous2DialogInterface = new LinkedList();
                Object localObject = new dwl();
                ((dwl)localObject).Fwv = ba.4.this.KgQ.BhP;
                paramAnonymous2DialogInterface.add(localObject);
                paramAnonymous2DialogInterface = new com.tencent.mm.plugin.subapp.d.a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
                com.tencent.mm.model.ba.aiU().a(paramAnonymous2DialogInterface, 0);
                localObject = ba.this;
                Activity localActivity = ba.a(ba.this).JOR.getContext();
                ba.a(ba.this).JOR.getMMResources().getString(2131755906);
                ba.a((ba)localObject, com.tencent.mm.ui.base.h.b(localActivity, ba.a(ba.this).JOR.getMMResources().getString(2131757210), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(37497);
                    com.tencent.mm.model.ba.aiU().a(paramAnonymous2DialogInterface);
                    com.tencent.mm.model.ba.aiU().b(331, ba.b(ba.this));
                    ba.a(ba.this, null);
                    if (ba.c(ba.this) != null) {
                      ba.c(ba.this).dismiss();
                    }
                    AppMethodBeat.o(37497);
                  }
                }));
                AppMethodBeat.o(37498);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37499);
          }
        });
        paramString.ofK.setTag(new bk(parambu, this.JBI.fFv(), paramInt, null, '\000'));
        com.tencent.mm.model.ba.aBQ();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.ofK.setOnLongClickListener(c(this.JBI));
        }
        AppMethodBeat.o(37501);
        return;
        paramString.iCV.setText("");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37503);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37503);
      return false;
    }
    paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194512);
    int i = ((bk)paramView.getTag()).position;
    int j = m.aLM(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    paramView = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    if ((paramView.hzO <= 0) || ((paramView.hzO > 0) && (j >= 100))) {
      paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
    }
    if (!this.JBI.fFw()) {
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194512);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba
 * JD-Core Version:    0.7.0.1
 */