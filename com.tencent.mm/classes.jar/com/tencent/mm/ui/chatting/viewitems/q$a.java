package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class q$a
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(233673);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493535);
      ((View)localObject).setTag(new q.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(233673);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(233674);
    Object localObject1;
    Object localObject2;
    if ((parama instanceof q.c))
    {
      localObject1 = (q.c)parama;
      localObject2 = paramca.field_content;
      if (localObject2 == null) {
        break label233;
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
      Log.i("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "filling");
      AppMethodBeat.o(233674);
      return;
      label233:
      Log.e("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233675);
    paramView.getTag();
    AppMethodBeat.o(233675);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 989855793);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(233676);
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
          paramca = a(parama, paramca);
          paramView = paramca;
          if (paramca == null) {
            paramView = parama.GUe.field_username;
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = paramView;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = com.tencent.mm.plugin.expt.hellhound.core.b.zs((int)parama.GUe.gMZ);
          ((aj)g.ah(aj.class)).enterFinderLiveInvitedUI(MMApplicationContext.getContext(), ((axf)localObject).username, ((axf)localObject).nickName, ((axf)localObject).headUrl, ((axf)localObject).feedId, ((axf)localObject).hJs);
        }
        AppMethodBeat.o(233676);
        return true;
      }
      catch (Exception paramView)
      {
        Log.w("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "jump to live fail: %s", new Object[] { paramView.getMessage() });
      }
    }
    AppMethodBeat.o(233676);
    return false;
  }
  
  public final boolean gTT()
  {
    return false;
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.q.a
 * JD-Core Version:    0.7.0.1
 */