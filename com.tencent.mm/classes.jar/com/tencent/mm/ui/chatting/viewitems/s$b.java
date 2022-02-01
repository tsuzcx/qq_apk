package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.widget.MMNeat7extView;

public final class s$b
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(254974);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggH);
      ((View)localObject).setTag(new s.c((View)localObject, Boolean.TRUE));
    }
    AppMethodBeat.o(254974);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(254977);
    this.aeiK = parama1;
    Object localObject1;
    Object localObject2;
    if ((parama instanceof s.c))
    {
      localObject1 = (s.c)parama;
      localObject2 = paramcc.field_content;
      if (localObject2 == null) {
        break label238;
      }
    }
    for (paramString = k.b.aP((String)localObject2, paramcc.field_reserved);; paramString = null)
    {
      if (paramString != null)
      {
        paramString = (com.tencent.mm.plugin.findersdk.a.a)paramString.aK(com.tencent.mm.plugin.findersdk.a.a.class);
        if (paramString != null)
        {
          localObject2 = paramString.HbV;
          ((s.c)localObject1).aeQk.aZ(com.tencent.mm.pluginsdk.ui.span.p.b(parama1.aezO.getContext(), ((bmr)localObject2).nickName));
          paramString = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString = com.tencent.mm.plugin.finder.loader.p.eCl();
          localObject2 = new com.tencent.mm.plugin.finder.loader.s(((bmr)localObject2).coverUrl, v.FKZ);
          localObject1 = ((s.c)localObject1).lKK;
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          paramString.a(localObject2, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExQ));
        }
      }
      paramcc = new bz(paramcc, parama1.juG(), paramInt, null, '\000');
      parama.clickArea.setTag(paramcc);
      parama.clickArea.setOnClickListener(d(parama1));
      parama.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      parama.clickArea.setOnLongClickListener(c(parama1));
      Log.i("MicroMsg.ChattingItemAppMsgLiveInviteTo", "filling");
      AppMethodBeat.o(254977);
      return;
      label238:
      Log.e("MicroMsg.ChattingItemAppMsgLiveInviteTo", "amessage, msgid:%s, user:%s", new Object[] { Long.valueOf(paramcc.field_msgId), paramString });
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(254981);
    int i = ((bz)paramView.getTag()).position;
    if (((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker)) && (!au.Hh(this.aeiK.getTalkerUserName()))) {
      params.a(i, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
    }
    AppMethodBeat.o(254981);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(254986);
    ((com.tencent.mm.plugin.comm.a.c)h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    Object localObject = paramcc.field_content;
    paramView = null;
    if (localObject != null) {
      paramView = k.b.aP((String)localObject, paramcc.field_reserved);
    }
    if ((paramView != null) && (paramView.type == 65)) {
      try
      {
        paramView = (com.tencent.mm.plugin.findersdk.a.a)paramView.aK(com.tencent.mm.plugin.findersdk.a.a.class);
        if ((paramView != null) && (paramView.HbV != null))
        {
          localObject = paramView.HbV;
          long l1 = com.tencent.mm.ae.d.FK(((bmr)localObject).feedId);
          long l2 = com.tencent.mm.ae.d.FK(((bmr)localObject).liveId);
          paramcc = a(parama, paramcc);
          paramView = paramcc;
          if (paramcc == null) {
            paramView = parama.Uxa.field_username;
          }
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGq = paramView;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGr = com.tencent.mm.plugin.expt.hellhound.core.b.hF((int)parama.Uxa.maN);
          new Intent().putExtra("KEY_PARAMS_SOURCE_TYPE", ((bmr)localObject).sourceType);
          ((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).enterFinderLiveAnchorUI(null, MMApplicationContext.getContext(), l1, Long.valueOf(l2), ((bmr)localObject).objectNonceId, ((bmr)localObject).desc, "", "", "");
        }
        AppMethodBeat.o(254986);
        return true;
      }
      catch (Exception paramView)
      {
        Log.w("MicroMsg.ChattingItemAppMsgLiveInviteTo", "jump to live fail: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(254986);
        return true;
      }
    }
    AppMethodBeat.o(254986);
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 989855793);
  }
  
  public final boolean fXn()
  {
    return true;
  }
  
  final boolean jxi()
  {
    return false;
  }
  
  protected final boolean jxk()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.b
 * JD-Core Version:    0.7.0.1
 */