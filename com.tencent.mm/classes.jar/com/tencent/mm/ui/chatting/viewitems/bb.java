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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.o;

public final class bb
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  private com.tencent.mm.ak.f onSceneEndCallback;
  
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
      ((View)localObject).setTag(new br().gT((View)localObject));
    }
    AppMethodBeat.o(37506);
    return localObject;
  }
  
  public final void a(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, String paramString)
  {
    AppMethodBeat.i(37508);
    localbr = (br)parama;
    this.JWz = parama1;
    Object localObject2 = ao.fdU().yb(parambv.field_msgId);
    Object localObject1 = parambv.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = k.b.aB((String)localObject1, parambv.field_reserved);
      }
    }
    localObject2 = e.aDP((String)localObject1);
    if ((localObject2 != null) && (((e)localObject2).Bzm != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.i.i.aq(parama1.Kkd.getContext(), ((e)localObject2).Bzm);
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
      localbr.iFO.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        ae.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localbr.KEV.setImageResource(2131233395);
      }
    }
    ae.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + parambv.field_content);
    if ((bu.isNullOrNil(parambv.field_imgPath)) && (((e)localObject2).Bzs > 0))
    {
      bc.aCg();
      parama = com.tencent.mm.model.c.azI().aJ(parambv.field_talker, ((e)localObject2).Bzs);
      if (!bu.isNullOrNil(parama.field_imgPath))
      {
        localObject1 = k.HI(v.aAC());
        localObject3 = com.tencent.mm.plugin.subapp.d.h.ch((String)localObject1, false);
        if (o.mF(com.tencent.mm.plugin.subapp.d.h.ch(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          parambv.uj((String)localObject1);
          bc.aCg();
          com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
        }
      }
    }
    if ((bu.isNullOrNil(parambv.field_imgPath)) && (localObject2 != null) && (((e)localObject2).dlu != null) && (((e)localObject2).dlu.length() > 0) && (((e)localObject2).hCC > 0) && (this.onSceneEndCallback == null))
    {
      parama = k.HI(v.aAC());
      localObject1 = com.tencent.mm.plugin.subapp.d.h.ch(parama, false);
      if (bu.isNullOrNil(parambv.field_imgPath))
      {
        parambv.uj(parama);
        bc.aCg();
        com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
        ae.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.dlu);
        parama = m.a((String)localObject1, parambv.field_msgId, paramString.sdkVer, paramString.appId, paramString.dlu, paramString.hCC);
        ae.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = bc.ajj();
          localObject1 = new com.tencent.mm.ak.f()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
            {
              AppMethodBeat.i(37504);
              ae.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
              bc.ajj().b(221, bb.a(bb.this));
              bb.b(bb.this);
              AppMethodBeat.o(37504);
            }
          };
          this.onSceneEndCallback = ((com.tencent.mm.ak.f)localObject1);
          paramString.a(221, (com.tencent.mm.ak.f)localObject1);
          ae.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new com.tencent.mm.plugin.record.b.f(parama);
          bc.ajj().a(parama, 0);
        }
      }
    }
    localbr.KEV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37505);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        if (bu.isNullOrNil(parambv.field_imgPath))
        {
          ae.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
        }
        paramAnonymousView = ((at)bb.c(bb.this).bh(at.class)).fJn();
        int i = paramInt;
        localObject = parambv;
        if (localObject != null)
        {
          paramAnonymousView.fEH();
          bc.aCg();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajA().get(4115, null);
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(4115, Boolean.TRUE);
            paramAnonymousView.fEM();
            paramAnonymousView.JTg = t.a(paramAnonymousView.cXJ.Kkd.getActivity(), paramAnonymousView.context.getString(2131757255), 4000L);
          }
          if ((!paramAnonymousView.pEU.isPlaying()) || (((ei)localObject).field_msgId != paramAnonymousView.JTd)) {
            break label238;
          }
          paramAnonymousView.apj();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
          label238:
          paramAnonymousView.aP((bv)localObject);
          if ((((ei)localObject).field_isSend == 0) && (!s.Y((bv)localObject))) {
            paramAnonymousView.adq(i + 1);
          }
          paramAnonymousView.xV(true);
        }
      }
    });
    l = parambv.field_msgId;
    parama = ((at)this.JWz.bh(at.class)).fJn();
    if ((parama.isPlaying()) && (parama.JTd == l))
    {
      i = 1;
      if (i == 0) {
        break label796;
      }
      localbr.KEV.setImageResource(2131233393);
      localbr.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
      bc.aCg();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localbr.olI.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37508);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37510);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37510);
      return false;
    }
    paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37510);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187914);
    int i = ((bk)paramView.getTag()).position;
    int j = m.aNi(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    paramView = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    if ((paramView.hCC <= 0) || ((paramView.hCC > 0) && (j >= 100))) {
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
    }
    if (!this.JWz.fJD()) {
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187914);
    return true;
  }
  
  public final String b(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37507);
    parama = parama.getTalkerUserName();
    AppMethodBeat.o(37507);
    return parama;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb
 * JD-Core Version:    0.7.0.1
 */