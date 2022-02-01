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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class bh
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  private com.tencent.mm.ak.i onSceneEndCallback;
  
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
      localObject = new an(paramLayoutInflater, 2131493620);
      ((View)localObject).setTag(new bx().hj((View)localObject));
    }
    AppMethodBeat.o(37506);
    return localObject;
  }
  
  public final String a(com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37507);
    parama = parama.getTalkerUserName();
    AppMethodBeat.o(37507);
    return parama;
  }
  
  public final void a(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
  {
    AppMethodBeat.i(37508);
    localbx = (bx)parama;
    this.PhN = parama1;
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.ao.gnf().GL(paramca.field_msgId);
    Object localObject1 = paramca.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = k.b.aD((String)localObject1, paramca.field_reserved);
      }
    }
    localObject2 = e.aSK((String)localObject1);
    if ((localObject2 != null) && (((e)localObject2).FJX != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.i.f.az(parama1.Pwc.getContext(), ((e)localObject2).FJX);
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
      localbx.jBR.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        Log.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localbx.PRJ.setImageResource(2131234185);
      }
    }
    Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + paramca.field_content);
    if ((Util.isNullOrNil(paramca.field_imgPath)) && (((e)localObject2).FKd > 0))
    {
      bg.aVF();
      parama = com.tencent.mm.model.c.aSQ().aJ(paramca.field_talker, ((e)localObject2).FKd);
      if (!Util.isNullOrNil(parama.field_imgPath))
      {
        localObject1 = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
        localObject3 = h.cz((String)localObject1, false);
        if (com.tencent.mm.vfs.s.nw(h.cz(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          paramca.Cz((String)localObject1);
          bg.aVF();
          com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
        }
      }
    }
    if ((Util.isNullOrNil(paramca.field_imgPath)) && (localObject2 != null) && (((e)localObject2).dCK != null) && (((e)localObject2).dCK.length() > 0) && (((e)localObject2).iwI > 0) && (this.onSceneEndCallback == null))
    {
      parama = com.tencent.mm.plugin.subapp.d.k.Qv(z.aTY());
      localObject1 = h.cz(parama, false);
      if (Util.isNullOrNil(paramca.field_imgPath))
      {
        paramca.Cz(parama);
        bg.aVF();
        com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
        Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.dCK);
        parama = com.tencent.mm.pluginsdk.model.app.m.a((String)localObject1, paramca.field_msgId, paramString.sdkVer, paramString.appId, paramString.dCK, paramString.iwI);
        Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = bg.azz();
          localObject1 = new com.tencent.mm.ak.i()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
            {
              AppMethodBeat.i(37504);
              Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
              bg.azz().b(221, bh.a(bh.this));
              bh.b(bh.this);
              AppMethodBeat.o(37504);
            }
          };
          this.onSceneEndCallback = ((com.tencent.mm.ak.i)localObject1);
          paramString.a(221, (com.tencent.mm.ak.i)localObject1);
          Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new com.tencent.mm.plugin.record.b.f(parama);
          bg.azz().a(parama, 0);
        }
      }
    }
    localbx.PRJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37505);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        if (Util.isNullOrNil(paramca.field_imgPath))
        {
          Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
        }
        paramAnonymousView = ((aw)bh.c(bh.this).bh(aw.class)).gRx();
        int i = paramInt;
        localObject = paramca;
        if (localObject != null)
        {
          paramAnonymousView.gMO();
          bg.aVF();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.azQ().get(4115, null);
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
            paramAnonymousView.gMU();
            paramAnonymousView.Pel = u.a(paramAnonymousView.dom.Pwc.getActivity(), paramAnonymousView.context.getString(2131757468), 4000L);
          }
          if ((!paramAnonymousView.qUl.isPlaying()) || (((eo)localObject).field_msgId != paramAnonymousView.Pei)) {
            break label238;
          }
          paramAnonymousView.gMT();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
          label238:
          paramAnonymousView.bf((ca)localObject);
          if ((((eo)localObject).field_isSend == 0) && (!com.tencent.mm.modelvoice.s.ai((ca)localObject))) {
            paramAnonymousView.ama(i + 1);
          }
          paramAnonymousView.BK(true);
        }
      }
    });
    l = paramca.field_msgId;
    parama = ((aw)this.PhN.bh(aw.class)).gRx();
    if ((parama.isPlaying()) && (parama.Pei == l))
    {
      i = 1;
      if (i == 0) {
        break label797;
      }
      localbx.PRJ.setImageResource(2131234170);
      localbx.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
      bg.aVF();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localbx.clickArea.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37508);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37510);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37510);
      return false;
    }
    paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37510);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233969);
    int i = ((bq)paramView.getTag()).position;
    int j = com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    paramView = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    if ((paramView.iwI <= 0) || ((paramView.iwI > 0) && (j >= 100))) {
      paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
    }
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    AppMethodBeat.o(233969);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return true;
  }
  
  public final boolean gTT()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bh
 * JD-Core Version:    0.7.0.1
 */