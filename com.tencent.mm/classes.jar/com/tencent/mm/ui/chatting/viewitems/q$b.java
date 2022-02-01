package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q$b
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233677);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493586);
      ((View)localObject).setTag(new q.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(233677);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(233678);
    this.PhN = parama1;
    Object localObject1;
    Object localObject2;
    if ((parama instanceof q.c))
    {
      localObject1 = (q.c)parama;
      localObject2 = paramca.field_content;
      if (localObject2 == null) {
        break label238;
      }
    }
    for (paramString = k.b.aD((String)localObject2, paramca.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        paramString = (com.tencent.mm.plugin.i.a.a)paramString.as(com.tencent.mm.plugin.i.a.a.class);
        if (paramString != null)
        {
          localObject2 = paramString.wDV;
          ((q.c)localObject1).PKy.aw(l.c(parama1.Pwc.getContext(), ((axf)localObject2).nickName));
          paramString = com.tencent.mm.plugin.finder.loader.m.uJa;
          paramString = com.tencent.mm.plugin.finder.loader.m.djY();
          localObject2 = new p(((axf)localObject2).coverUrl, x.vEo);
          localObject1 = ((q.c)localObject1).gyr;
          com.tencent.mm.plugin.finder.loader.m localm = com.tencent.mm.plugin.finder.loader.m.uJa;
          paramString.a(localObject2, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.m.a(m.a.uJi));
        }
      }
      paramca = new bq(paramca, parama1.gRM(), paramInt, null, '\000');
      parama.clickArea.setTag(paramca);
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      parama.clickArea.setOnLongClickListener(c(parama1));
      Log.i("MicroMsg.ChattingItemAppMsgLiveInviteTo", "filling");
      AppMethodBeat.o(233678);
      return;
      label238:
      Log.e("MicroMsg.ChattingItemAppMsgLiveInviteTo", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233679);
    int i = ((bq)paramView.getTag()).position;
    if (((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker)) && (!as.HF(this.PhN.getTalkerUserName()))) {
      paramm.a(i, 123, paramView.getContext().getString(2131757446), 2131690650);
    }
    AppMethodBeat.o(233679);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 989855793);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233680);
    ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
    Object localObject = paramca.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aD((String)localObject, paramca.field_reserved);
    }
    if ((paramView != null) && (paramView.type == 65)) {
      try
      {
        paramView = (com.tencent.mm.plugin.i.a.a)paramView.as(com.tencent.mm.plugin.i.a.a.class);
        if ((paramView != null) && (paramView.wDV != null))
        {
          localObject = paramView.wDV;
          long l1 = com.tencent.mm.ac.d.Ga(((axf)localObject).feedId);
          long l2 = com.tencent.mm.ac.d.Ga(((axf)localObject).hJs);
          paramca = a(parama, paramca);
          paramView = paramca;
          if (paramca == null) {
            paramView = parama.GUe.field_username;
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = paramView;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs((int)parama.GUe.gMZ);
          ((aj)g.ah(aj.class)).enterFinderLiveAnchorUI(MMApplicationContext.getContext(), l1, Long.valueOf(l2), ((axf)localObject).objectNonceId, ((axf)localObject).desc, "", "");
        }
        AppMethodBeat.o(233680);
        return true;
      }
      catch (Exception paramView)
      {
        Log.w("MicroMsg.ChattingItemAppMsgLiveInviteTo", "jump to live fail: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(233680);
        return true;
      }
    }
    AppMethodBeat.o(233680);
    return false;
  }
  
  public final boolean gTT()
  {
    return true;
  }
  
  final boolean gTV()
  {
    return false;
  }
  
  protected final boolean gTX()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.b
 * JD-Core Version:    0.7.0.1
 */