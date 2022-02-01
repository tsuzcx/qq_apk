package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class t$a
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(279823);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.ecT);
      ((View)localObject).setTag(new t.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(279823);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(279826);
    Object localObject1;
    Object localObject2;
    if ((parama instanceof t.c))
    {
      localObject1 = (t.c)parama;
      localObject2 = paramca.field_content;
      if (localObject2 == null) {
        break label233;
      }
    }
    for (paramString = k.b.aG((String)localObject2, paramca.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        paramString = (com.tencent.mm.plugin.findersdk.a.a)paramString.ar(com.tencent.mm.plugin.findersdk.a.a.class);
        if (paramString != null)
        {
          localObject2 = paramString.Bvb;
          ((t.c)localObject1).Xgs.aL(l.c(parama1.WQv.getContext(), ((bcp)localObject2).nickName));
          paramString = t.ztT;
          paramString = t.dJe();
          localObject2 = new x(((bcp)localObject2).coverUrl, u.Alz);
          localObject1 = ((t.c)localObject1).jiu;
          t localt = t.ztT;
          paramString.a(localObject2, (ImageView)localObject1, t.a(com.tencent.mm.plugin.finder.loader.t.a.zub));
        }
      }
      paramca = new by(paramca, parama1.hRi(), paramInt, null, '\000');
      parama.clickArea.setTag(paramca);
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      parama.clickArea.setOnLongClickListener(c(parama1));
      Log.i("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "filling");
      AppMethodBeat.o(279826);
      return;
      label233:
      Log.e("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramca.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(279827);
    paramView.getTag();
    AppMethodBeat.o(279827);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 989855793);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(279828);
    ((com.tencent.mm.plugin.comm.a.b)h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
    Object localObject = paramca.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aG((String)localObject, paramca.field_reserved);
    }
    if ((paramView != null) && (paramView.type == 65)) {
      try
      {
        paramView = (com.tencent.mm.plugin.findersdk.a.a)paramView.ar(com.tencent.mm.plugin.findersdk.a.a.class);
        if ((paramView != null) && (paramView.Bvb != null))
        {
          localObject = paramView.Bvb;
          paramca = a(parama, paramca);
          paramView = paramca;
          if (paramca == null) {
            paramView = parama.NKq.field_username;
          }
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkl = paramView;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkm = com.tencent.mm.plugin.expt.hellhound.core.b.Fw((int)parama.NKq.jxt);
          ((com.tencent.c.a.a.a.b)h.ag(com.tencent.c.a.a.a.b.class)).enterFinderLiveInvitedUI(MMApplicationContext.getContext(), ((bcp)localObject).username, ((bcp)localObject).nickName, ((bcp)localObject).headUrl, ((bcp)localObject).feedId, ((bcp)localObject).kwM);
        }
        AppMethodBeat.o(279828);
        return true;
      }
      catch (Exception paramView)
      {
        Log.w("MicroMsg.ChattingItemAppMsgLiveInviteFrom", "jump to live fail: %s", new Object[] { paramView.getMessage() });
      }
    }
    AppMethodBeat.o(279828);
    return false;
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  final boolean hTF()
  {
    return false;
  }
  
  protected final boolean hTH()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.t.a
 * JD-Core Version:    0.7.0.1
 */