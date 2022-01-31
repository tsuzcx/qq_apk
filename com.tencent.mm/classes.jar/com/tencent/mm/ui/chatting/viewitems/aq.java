package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class aq
  extends c
{
  private f onSceneEndCallback;
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33396);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969131);
      ((View)localObject).setTag(new bf().fr((View)localObject));
    }
    AppMethodBeat.o(33396);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33398);
    localbf = (bf)parama;
    this.zzP = parama1;
    Object localObject2 = al.dlL().nx(parambi.field_msgId);
    Object localObject1 = parambi.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = j.b.ab((String)localObject1, parambi.field_reserved);
      }
    }
    localObject2 = com.tencent.mm.plugin.subapp.c.e.adQ((String)localObject1);
    if ((localObject2 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).sXm != 0)) {}
    try
    {
      localObject3 = com.tencent.mm.pluginsdk.f.h.ah(parama1.zJz.getContext(), ((com.tencent.mm.plugin.subapp.c.e)localObject2).sXm);
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
      localbf.gpM.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        ab.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localbf.zZI.setImageResource(2130839753);
      }
    }
    ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + parambi.field_content);
    if ((bo.isNullOrNil(parambi.field_imgPath)) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).sXs > 0))
    {
      aw.aaz();
      parama = com.tencent.mm.model.c.YC().ag(parambi.field_talker, ((com.tencent.mm.plugin.subapp.c.e)localObject2).sXs);
      if (!bo.isNullOrNil(parama.field_imgPath))
      {
        localObject1 = com.tencent.mm.plugin.subapp.c.k.ve(r.Zn());
        localObject3 = com.tencent.mm.plugin.subapp.c.h.bE((String)localObject1, false);
        if (com.tencent.mm.vfs.e.C(com.tencent.mm.plugin.subapp.c.h.bE(parama.field_imgPath, false), (String)localObject3) >= 0L)
        {
          parambi.kk((String)localObject1);
          aw.aaz();
          com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
        }
      }
    }
    if ((bo.isNullOrNil(parambi.field_imgPath)) && (localObject2 != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).cmN != null) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).cmN.length() > 0) && (((com.tencent.mm.plugin.subapp.c.e)localObject2).fgw > 0) && (this.onSceneEndCallback == null))
    {
      parama = com.tencent.mm.plugin.subapp.c.k.ve(r.Zn());
      localObject1 = com.tencent.mm.plugin.subapp.c.h.bE(parama, false);
      if (bo.isNullOrNil(parambi.field_imgPath))
      {
        parambi.kk(parama);
        aw.aaz();
        com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
        ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.cmN);
        parama = l.a((String)localObject1, parambi.field_msgId, paramString.sdkVer, paramString.appId, paramString.cmN, paramString.fgw);
        ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = aw.Rc();
          localObject1 = new aq.1(this);
          this.onSceneEndCallback = ((f)localObject1);
          paramString.a(221, (f)localObject1);
          ab.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new com.tencent.mm.plugin.record.b.e(parama);
          aw.Rc().a(parama, 0);
        }
      }
    }
    localbf.zZI.setOnClickListener(new aq.2(this, parambi, paramInt));
    l = parambi.field_msgId;
    parama = ((aj)this.zzP.ay(aj.class)).dJv();
    if ((parama.isPlaying()) && (parama.zwt == l))
    {
      i = 1;
      if (i == 0) {
        break label796;
      }
      localbf.zZI.setImageResource(2130839751);
      localbf.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
      aw.aaz();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localbf.jYu.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(33398);
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33399);
    int i = ((az)paramView.getTag()).position;
    int j = l.alu(com.tencent.mm.model.bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    paramView = j.b.mY(com.tencent.mm.model.bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if ((paramView.fgw <= 0) || ((paramView.fgw > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    }
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(33399);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33400);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33400);
      return false;
    }
    paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    AppMethodBeat.o(33400);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final String b(a parama, bi parambi)
  {
    AppMethodBeat.i(33397);
    parama = parama.getTalkerUserName();
    AppMethodBeat.o(33397);
    return parama;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return true;
  }
  
  protected final boolean b(a parama)
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aq
 * JD-Core Version:    0.7.0.1
 */