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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.u;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class az
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
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
      localObject = new af(paramLayoutInflater, 2131493511);
      ((View)localObject).setTag(new bp().gk((View)localObject));
    }
    AppMethodBeat.o(37506);
    return localObject;
  }
  
  public final void a(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, String paramString)
  {
    AppMethodBeat.i(37508);
    localbp = (bp)parama;
    this.Gob = parama1;
    Object localObject2 = ap.evR().vk(parambl.field_msgId);
    Object localObject1 = parambl.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = k.b.ar((String)localObject1, parambl.field_reserved);
      }
    }
    localObject2 = com.tencent.mm.plugin.subapp.d.e.asj((String)localObject1);
    if ((localObject2 != null) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).yCZ != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.g.h.ah(parama1.GzJ.getContext(), ((com.tencent.mm.plugin.subapp.d.e)localObject2).yCZ);
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
      localbp.hJe.setText((CharSequence)localObject1);
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
        localbp.GRV.setImageResource(2131233395);
      }
    }
    ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + parambl.field_content);
    if ((bt.isNullOrNil(parambl.field_imgPath)) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).yDf > 0))
    {
      com.tencent.mm.model.az.arV();
      parama = com.tencent.mm.model.c.apO().aD(parambl.field_talker, ((com.tencent.mm.plugin.subapp.d.e)localObject2).yDf);
      if (!bt.isNullOrNil(parama.field_imgPath))
      {
        localObject1 = k.zP(u.aqG());
        localObject3 = com.tencent.mm.plugin.subapp.d.h.bP((String)localObject1, false);
        if (com.tencent.mm.vfs.i.lC(com.tencent.mm.plugin.subapp.d.h.bP(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          parambl.nZ((String)localObject1);
          com.tencent.mm.model.az.arV();
          com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
        }
      }
    }
    if ((bt.isNullOrNil(parambl.field_imgPath)) && (localObject2 != null) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).dbA != null) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).dbA.length() > 0) && (((com.tencent.mm.plugin.subapp.d.e)localObject2).gHe > 0) && (this.onSceneEndCallback == null))
    {
      parama = k.zP(u.aqG());
      localObject1 = com.tencent.mm.plugin.subapp.d.h.bP(parama, false);
      if (bt.isNullOrNil(parambl.field_imgPath))
      {
        parambl.nZ(parama);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
        ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.dbA);
        parama = m.a((String)localObject1, parambl.field_msgId, paramString.sdkVer, paramString.appId, paramString.dbA, paramString.gHe);
        ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = com.tencent.mm.model.az.aeS();
          localObject1 = new g()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(37504);
              ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
              com.tencent.mm.model.az.aeS().b(221, az.a(az.this));
              az.b(az.this);
              AppMethodBeat.o(37504);
            }
          };
          this.onSceneEndCallback = ((g)localObject1);
          paramString.a(221, (g)localObject1);
          ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new com.tencent.mm.plugin.record.b.e(parama);
          com.tencent.mm.model.az.aeS().a(parama, 0);
        }
      }
    }
    localbp.GRV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37505);
        if (bt.isNullOrNil(parambl.field_imgPath))
        {
          ad.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          AppMethodBeat.o(37505);
          return;
        }
        paramAnonymousView = ((ao)az.c(az.this).be(ao.class)).eYQ();
        int i = paramInt;
        bl localbl = parambl;
        if (localbl != null)
        {
          paramAnonymousView.eUD();
          com.tencent.mm.model.az.arV();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.afk().get(4115, null);
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            com.tencent.mm.model.az.arV();
            com.tencent.mm.model.c.afk().set(4115, Boolean.TRUE);
            paramAnonymousView.eUJ();
            paramAnonymousView.GkK = t.a(paramAnonymousView.cOd.GzJ.getActivity(), paramAnonymousView.context.getString(2131757255), 4000L);
          }
          if ((paramAnonymousView.org.isPlaying()) && (localbl.field_msgId == paramAnonymousView.GkH))
          {
            paramAnonymousView.eUI();
            AppMethodBeat.o(37505);
            return;
          }
          paramAnonymousView.aL(localbl);
          if ((localbl.field_isSend == 0) && (!s.W(localbl))) {
            paramAnonymousView.Yn(i + 1);
          }
          paramAnonymousView.vZ(true);
        }
        AppMethodBeat.o(37505);
      }
    });
    l = parambl.field_msgId;
    parama = ((ao)this.Gob.be(ao.class)).eYQ();
    if ((parama.isPlaying()) && (parama.GkH == l))
    {
      i = 1;
      if (i == 0) {
        break label796;
      }
      localbp.GRV.setImageResource(2131233393);
      localbp.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
      com.tencent.mm.model.az.arV();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localbp.naN.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37508);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37509);
    int i = ((bi)paramView.getTag()).position;
    int j = m.aAU(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    paramView = k.b.rx(com.tencent.mm.model.bi.b(this.Gob.eZb(), parambl.field_content, parambl.field_isSend));
    if ((paramView.gHe <= 0) || ((paramView.gHe > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.Gob.GzJ.getMMResources().getString(2131762559));
    }
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37509);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37510);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37510);
      return false;
    }
    paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37510);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final String b(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37507);
    parama = parama.getTalkerUserName();
    AppMethodBeat.o(37507);
    return parama;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az
 * JD-Core Version:    0.7.0.1
 */