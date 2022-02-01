package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class bb
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  private com.tencent.mm.al.f onSceneEndCallback;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37506);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493511);
      ((View)localObject).setTag(new br().gO((View)localObject));
    }
    AppMethodBeat.o(37506);
    return localObject;
  }
  
  public final void a(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, String paramString)
  {
    AppMethodBeat.i(37508);
    localbr = (br)parama;
    this.JBI = parama1;
    Object localObject2 = ao.fag().xH(parambu.field_msgId);
    Object localObject1 = parambu.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = k.b.aA((String)localObject1, parambu.field_reserved);
      }
    }
    localObject2 = e.aCw((String)localObject1);
    if ((localObject2 != null) && (((e)localObject2).BhO != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.i.i.aq(parama1.JOR.getContext(), ((e)localObject2).BhO);
      localObject1 = "";
      parama = (c.a)localObject1;
      if (localObject3 != null)
      {
        parama = (c.a)localObject1;
        if (((String)localObject3).length() > 0)
        {
          localObject3 = ((String)localObject3).split(";");
          localObject1 = "" + localObject3[0].replace(" ", "");
          parama = (c.a)localObject1;
          if (localObject3.length > 1) {
            parama = (String)localObject1 + localObject3[1];
          }
        }
      }
      localObject1 = parama;
      if (paramString != null)
      {
        localObject1 = parama;
        if (paramString.description != null) {
          localObject1 = parama + " " + paramString.description;
        }
      }
      localbr.iCV.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        ad.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localbr.KiB.setImageResource(2131233395);
      }
    }
    ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + parambu.field_content);
    if ((bt.isNullOrNil(parambu.field_imgPath)) && (((e)localObject2).BhU > 0))
    {
      ba.aBQ();
      parama = com.tencent.mm.model.c.azs().aI(parambu.field_talker, ((e)localObject2).BhU);
      if (!bt.isNullOrNil(parama.field_imgPath))
      {
        localObject1 = k.Hg(u.aAm());
        localObject3 = com.tencent.mm.plugin.subapp.d.h.cd((String)localObject1, false);
        if (com.tencent.mm.vfs.i.mz(com.tencent.mm.plugin.subapp.d.h.cd(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          parambu.tO((String)localObject1);
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
        }
      }
    }
    if ((bt.isNullOrNil(parambu.field_imgPath)) && (localObject2 != null) && (((e)localObject2).dks != null) && (((e)localObject2).dks.length() > 0) && (((e)localObject2).hzO > 0) && (this.onSceneEndCallback == null))
    {
      parama = k.Hg(u.aAm());
      localObject1 = com.tencent.mm.plugin.subapp.d.h.cd(parama, false);
      if (bt.isNullOrNil(parambu.field_imgPath))
      {
        parambu.tO(parama);
        ba.aBQ();
        com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
        ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.dks);
        parama = m.a((String)localObject1, parambu.field_msgId, paramString.sdkVer, paramString.appId, paramString.dks, paramString.hzO);
        ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = ba.aiU();
          localObject1 = new com.tencent.mm.al.f()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(37504);
              ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
              ba.aiU().b(221, bb.a(bb.this));
              bb.b(bb.this);
              AppMethodBeat.o(37504);
            }
          };
          this.onSceneEndCallback = ((com.tencent.mm.al.f)localObject1);
          paramString.a(221, (com.tencent.mm.al.f)localObject1);
          ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new com.tencent.mm.plugin.record.b.f(parama);
          ba.aiU().a(parama, 0);
        }
      }
    }
    localbr.KiB.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37505);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
        if (bt.isNullOrNil(parambu.field_imgPath))
        {
          ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
        }
        paramAnonymousView = ((as)bb.c(bb.this).bh(as.class)).fFk();
        int i = paramInt;
        localObject = parambu;
        if (localObject != null)
        {
          paramAnonymousView.fAF();
          ba.aBQ();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajl().get(4115, null);
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(4115, Boolean.TRUE);
            paramAnonymousView.fAK();
            paramAnonymousView.Jyq = t.a(paramAnonymousView.cWM.JOR.getActivity(), paramAnonymousView.context.getString(2131757255), 4000L);
          }
          if ((!paramAnonymousView.pyq.isPlaying()) || (((ei)localObject).field_msgId != paramAnonymousView.Jyn)) {
            break label238;
          }
          paramAnonymousView.aoV();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
          label238:
          paramAnonymousView.aQ((bu)localObject);
          if ((((ei)localObject).field_isSend == 0) && (!s.Z((bu)localObject))) {
            paramAnonymousView.acI(i + 1);
          }
          paramAnonymousView.xO(true);
        }
      }
    });
    l = parambu.field_msgId;
    parama = ((as)this.JBI.bh(as.class)).fFk();
    if ((parama.isPlaying()) && (parama.Jyn == l))
    {
      i = 1;
      if (i == 0) {
        break label796;
      }
      localbr.KiB.setImageResource(2131233393);
      localbr.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
      ba.aBQ();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localbr.ofK.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37508);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37510);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37510);
      return false;
    }
    paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37510);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194513);
    int i = ((bk)paramView.getTag()).position;
    int j = m.aLM(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    paramView = k.b.yr(bj.b(this.JBI.fFv(), parambu.field_content, parambu.field_isSend));
    if ((paramView.hzO <= 0) || ((paramView.hzO > 0) && (j >= 100))) {
      paraml.a(i, 111, this.JBI.JOR.getMMResources().getString(2131762559), 2131690478);
    }
    if (!this.JBI.fFw()) {
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194513);
    return true;
  }
  
  public final String b(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37507);
    parama = parama.getTalkerUserName();
    AppMethodBeat.o(37507);
    return parama;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb
 * JD-Core Version:    0.7.0.1
 */