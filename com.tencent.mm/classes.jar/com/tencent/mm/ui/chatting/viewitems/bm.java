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
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.ax;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.u;

public final class bm
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  private com.tencent.mm.an.i onSceneEndCallback;
  
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
      localObject = new aq(paramLayoutInflater, R.i.eev);
      ((View)localObject).setTag(new cf().iv((View)localObject));
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
    localcf = (cf)parama;
    this.WBq = parama1;
    Object localObject2 = com.tencent.mm.pluginsdk.model.app.ao.hhH().NR(paramca.field_msgId);
    Object localObject1 = paramca.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = k.b.aG((String)localObject1, paramca.field_reserved);
      }
    }
    localObject2 = e.bdO((String)localObject1);
    if ((localObject2 != null) && (((e)localObject2).MdU != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.j.f.aR(parama1.WQv.getContext(), ((e)localObject2).MdU);
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
      localcf.mrM.setText((CharSequence)localObject1);
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
        localcf.XnX.setImageResource(R.g.music_playicon);
      }
    }
    Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + Util.secPrint(paramca.field_content));
    if ((Util.isNullOrNil(paramca.field_imgPath)) && (((e)localObject2).Mea > 0))
    {
      bh.beI();
      parama = com.tencent.mm.model.c.bbO().aL(paramca.field_talker, ((e)localObject2).Mea);
      if (!Util.isNullOrNil(parama.field_imgPath))
      {
        localObject1 = com.tencent.mm.plugin.subapp.d.k.XS(z.bcZ());
        localObject3 = h.cN((String)localObject1, false);
        if (u.on(h.cN(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          paramca.Jn((String)localObject1);
          bh.beI();
          com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
        }
      }
    }
    if ((Util.isNullOrNil(paramca.field_imgPath)) && (localObject2 != null) && (((e)localObject2).fvr != null) && (((e)localObject2).fvr.length() > 0) && (((e)localObject2).llX > 0) && (this.onSceneEndCallback == null))
    {
      parama = com.tencent.mm.plugin.subapp.d.k.XS(z.bcZ());
      localObject1 = h.cN(parama, false);
      if (Util.isNullOrNil(paramca.field_imgPath))
      {
        paramca.Jn(parama);
        bh.beI();
        com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
        Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.fvr);
        parama = m.a((String)localObject1, paramca.field_msgId, paramString.sdkVer, paramString.appId, paramString.fvr, paramString.llX);
        Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = bh.aGY();
          localObject1 = new com.tencent.mm.an.i()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
            {
              AppMethodBeat.i(37504);
              Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
              bh.aGY().b(221, bm.a(bm.this));
              bm.b(bm.this);
              AppMethodBeat.o(37504);
            }
          };
          this.onSceneEndCallback = ((com.tencent.mm.an.i)localObject1);
          paramString.a(221, (com.tencent.mm.an.i)localObject1);
          Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new com.tencent.mm.plugin.record.b.f(parama);
          bh.aGY().a(parama, 0);
        }
      }
    }
    localcf.XnX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37505);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        if (Util.isNullOrNil(paramca.field_imgPath))
        {
          Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
        }
        paramAnonymousView = ((ax)bm.c(bm.this).bC(ax.class)).hQU();
        int i = paramInt;
        localObject = paramca;
        if (localObject != null)
        {
          paramAnonymousView.hLX();
          bh.beI();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.aHp().b(4115, null);
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            bh.beI();
            com.tencent.mm.model.c.aHp().i(4115, Boolean.TRUE);
            paramAnonymousView.hMd();
            paramAnonymousView.WxD = w.a(paramAnonymousView.fgR.WQv.getActivity(), paramAnonymousView.context.getString(R.l.ewq), 4000L);
          }
          if ((!paramAnonymousView.uwr.isPlaying()) || (((et)localObject).field_msgId != paramAnonymousView.WxA)) {
            break label239;
          }
          paramAnonymousView.hMc();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
          label239:
          paramAnonymousView.by((ca)localObject);
          if ((((et)localObject).field_isSend == 0) && (!s.aq((ca)localObject))) {
            paramAnonymousView.ava(i + 1);
          }
          paramAnonymousView.oO(true);
        }
      }
    });
    l = paramca.field_msgId;
    parama = ((ax)this.WBq.bC(ax.class)).hQU();
    if ((parama.isPlaying()) && (parama.WxA == l))
    {
      i = 1;
      if (i == 0) {
        break label800;
      }
      localcf.XnX.setImageResource(R.g.music_pauseicon);
      localcf.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
      bh.beI();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localcf.clickArea.setOnLongClickListener(c(parama1));
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
    paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37510);
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(282998);
    int i = ((by)paramView.getTag()).position;
    int j = m.bqe(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    paramView = k.b.OQ(bq.b(this.WBq.hRi(), paramca.field_content, paramca.field_isSend));
    if ((paramView.llX <= 0) || ((paramView.llX > 0) && (j >= 100))) {
      paramo.a(i, 111, this.WBq.WQv.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(282998);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
  {
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return true;
  }
  
  public final boolean hTD()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bm
 * JD-Core Version:    0.7.0.1
 */