package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ba
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  private g onSceneEndCallback;
  
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
      localObject = new ag(paramLayoutInflater, 2131493511);
      ((View)localObject).setTag(new bq().gx((View)localObject));
    }
    AppMethodBeat.o(37506);
    return localObject;
  }
  
  public final void a(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, String paramString)
  {
    AppMethodBeat.i(37508);
    localbq = (bq)parama;
    this.HNS = parama1;
    Object localObject2 = ap.eLl().zN(parambo.field_msgId);
    Object localObject1 = parambo.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = k.b.az((String)localObject1, parambo.field_reserved);
      }
    }
    localObject2 = com.tencent.mm.plugin.subapp.d.e.axs((String)localObject1);
    if ((localObject2 != null) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).zQn != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.g.h.an(parama1.HZF.getContext(), ((com.tencent.mm.plugin.subapp.d.e)localObject2).zQn);
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
      localbq.ijE.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        ac.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localbq.IrW.setImageResource(2131233395);
      }
    }
    ac.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + parambo.field_content);
    if ((bs.isNullOrNil(parambo.field_imgPath)) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).zQt > 0))
    {
      az.ayM();
      parama = com.tencent.mm.model.c.awD().aF(parambo.field_talker, ((com.tencent.mm.plugin.subapp.d.e)localObject2).zQt);
      if (!bs.isNullOrNil(parama.field_imgPath))
      {
        localObject1 = k.DU(u.axw());
        localObject3 = com.tencent.mm.plugin.subapp.d.h.bW((String)localObject1, false);
        if (com.tencent.mm.vfs.i.lZ(com.tencent.mm.plugin.subapp.d.h.bW(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          parambo.rf((String)localObject1);
          az.ayM();
          com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
        }
      }
    }
    if ((bs.isNullOrNil(parambo.field_imgPath)) && (localObject2 != null) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).cZa != null) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).cZa.length() > 0) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).hhF > 0) && (this.onSceneEndCallback == null))
    {
      parama = k.DU(u.axw());
      localObject1 = com.tencent.mm.plugin.subapp.d.h.bW(parama, false);
      if (bs.isNullOrNil(parambo.field_imgPath))
      {
        parambo.rf(parama);
        az.ayM();
        com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
        ac.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.cZa);
        parama = m.a((String)localObject1, parambo.field_msgId, paramString.sdkVer, paramString.appId, paramString.cZa, paramString.hhF);
        ac.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = az.agi();
          localObject1 = new g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(37504);
              ac.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
              az.agi().b(221, ba.a(ba.this));
              ba.b(ba.this);
              AppMethodBeat.o(37504);
            }
          };
          this.onSceneEndCallback = ((g)localObject1);
          paramString.a(221, (g)localObject1);
          ac.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new com.tencent.mm.plugin.record.b.e(parama);
          az.agi().a(parama, 0);
        }
      }
    }
    localbq.IrW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37505);
        if (bs.isNullOrNil(parambo.field_imgPath))
        {
          ac.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          AppMethodBeat.o(37505);
          return;
        }
        paramAnonymousView = ((ao)ba.c(ba.this).bf(ao.class)).foG();
        int i = paramInt;
        bo localbo = parambo;
        if (localbo != null)
        {
          paramAnonymousView.fkq();
          az.ayM();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.agA().get(4115, null);
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(4115, Boolean.TRUE);
            paramAnonymousView.fkv();
            paramAnonymousView.HKz = t.a(paramAnonymousView.cLy.HZF.getActivity(), paramAnonymousView.context.getString(2131757255), 4000L);
          }
          if ((paramAnonymousView.oUG.isPlaying()) && (localbo.field_msgId == paramAnonymousView.HKw))
          {
            paramAnonymousView.ami();
            AppMethodBeat.o(37505);
            return;
          }
          paramAnonymousView.aN(localbo);
          if ((localbo.field_isSend == 0) && (!s.W(localbo))) {
            paramAnonymousView.aay(i + 1);
          }
          paramAnonymousView.xd(true);
        }
        AppMethodBeat.o(37505);
      }
    });
    l = parambo.field_msgId;
    parama = ((ao)this.HNS.bf(ao.class)).foG();
    if ((parama.isPlaying()) && (parama.HKw == l))
    {
      i = 1;
      if (i == 0) {
        break label796;
      }
      localbq.IrW.setImageResource(2131233393);
      localbq.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
      az.ayM();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localbq.nDl.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37508);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37509);
    int i = ((bj)paramView.getTag()).position;
    int j = m.aGm(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    paramView = k.b.vA(bi.b(this.HNS.foQ(), parambo.field_content, parambo.field_isSend));
    if ((paramView.hhF <= 0) || ((paramView.hhF > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.HNS.HZF.getMMResources().getString(2131762559));
    }
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37509);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37510);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37510);
      return false;
    }
    paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37510);
    return false;
  }
  
  public final String b(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37507);
    parama = parama.getTalkerUserName();
    AppMethodBeat.o(37507);
    return parama;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba
 * JD-Core Version:    0.7.0.1
 */