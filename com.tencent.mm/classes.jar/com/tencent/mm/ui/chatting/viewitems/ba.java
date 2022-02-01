package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

public final class ba
  extends c
{
  private a GQs;
  private a Gob;
  private g onSceneEndCallback;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37513);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new af(paramLayoutInflater, 2131493512);
      ((View)localObject).setTag(new bq().gl((View)localObject));
    }
    AppMethodBeat.o(37513);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, a parama1, final bl parambl, String paramString)
  {
    AppMethodBeat.i(37514);
    bq localbq = (bq)parama;
    this.Gob = parama1;
    Object localObject2 = ap.evR().vk(parambl.field_msgId);
    Object localObject1 = parambl.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = k.b.ar((String)localObject1, parambl.field_reserved);
      }
    }
    if (parama != null) {
      localbq.hJe.setText(parama.description);
    }
    ad.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + parambl.field_content);
    paramString = com.tencent.mm.plugin.subapp.d.e.asj((String)localObject1);
    if ((paramString != null) && (paramString.yDb != null) && (paramString.yDb.length() > 0) && (paramString.yDc > 0) && (this.onSceneEndCallback == null) && (parama != null) && (bt.isNullOrNil(parambl.field_imgPath)))
    {
      localObject1 = k.zP(u.aqG());
      localObject2 = com.tencent.mm.plugin.subapp.d.h.bP((String)localObject1, false);
      parambl.nZ((String)localObject1);
      az.arV();
      com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
      parama = m.a((String)localObject2, parambl.field_msgId, parama.sdkVer, parama.appId, paramString.yDb, paramString.yDc, parama.type, parama.gHi);
      if (parama != null)
      {
        paramString = az.aeS();
        localObject1 = new g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(37511);
            ad.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
            boolean bool = false;
            if (ar.a.gMZ != null) {
              bool = ar.a.gMZ.lV(parambl.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.e)paramAnonymousn).getMediaId().equals(parama))) {
              ((ao)ba.a(ba.this).be(ao.class)).eYQ().a(paramInt, parambl);
            }
            az.aeS().b(221, ba.b(ba.this));
            ba.c(ba.this);
            AppMethodBeat.o(37511);
          }
        };
        this.onSceneEndCallback = ((g)localObject1);
        paramString.a(221, (g)localObject1);
        parama = new com.tencent.mm.plugin.record.b.e(parama);
        parama.dge();
        az.aeS().a(parama, 0);
      }
    }
    localbq.hJe.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
    parama = localbq.hJe;
    if (this.GQs == null) {
      this.GQs = new a(this.Gob);
    }
    parama.setOnClickListener(this.GQs);
    az.arV();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localbq.hJe.setOnLongClickListener(c(parama1));
    }
    AppMethodBeat.o(37514);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    AppMethodBeat.i(37515);
    int i = ((bi)paramView.getTag()).position;
    if (!this.Gob.eZc()) {
      paramContextMenu.add(i, 100, 0, this.Gob.GzJ.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37515);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    AppMethodBeat.i(37516);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37516);
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return true;
  }
  
  public final boolean faE()
  {
    return false;
  }
  
  final class a
    extends s.e
  {
    public a(a parama)
    {
      super();
    }
    
    public final void a(View paramView, a parama, bl parambl)
    {
      AppMethodBeat.i(37512);
      paramView = (bi)paramView.getTag();
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.Gob.GzJ.getContext(), this.Gob.GzJ.getContentView());
        AppMethodBeat.o(37512);
        return;
      }
      ((ao)this.Gob.be(ao.class)).eYQ().a(paramView.position, paramView.drF);
      AppMethodBeat.o(37512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba
 * JD-Core Version:    0.7.0.1
 */