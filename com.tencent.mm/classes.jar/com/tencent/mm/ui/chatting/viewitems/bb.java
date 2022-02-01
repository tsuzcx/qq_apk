package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

public final class bb
  extends c
{
  private a HNS;
  private a Iqt;
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
      localObject = new ag(paramLayoutInflater, 2131493512);
      ((View)localObject).setTag(new br().gy((View)localObject));
    }
    AppMethodBeat.o(37513);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, a parama1, final bo parambo, String paramString)
  {
    AppMethodBeat.i(37514);
    br localbr = (br)parama;
    this.HNS = parama1;
    Object localObject2 = ap.eLl().zN(parambo.field_msgId);
    Object localObject1 = parambo.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = k.b.az((String)localObject1, parambo.field_reserved);
      }
    }
    if (parama != null) {
      localbr.ijE.setText(parama.description);
    }
    ac.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + parambo.field_content);
    paramString = com.tencent.mm.plugin.subapp.d.e.axs((String)localObject1);
    if ((paramString != null) && (paramString.zQp != null) && (paramString.zQp.length() > 0) && (paramString.zQq > 0) && (this.onSceneEndCallback == null) && (parama != null) && (bs.isNullOrNil(parambo.field_imgPath)))
    {
      localObject1 = k.DU(u.axw());
      localObject2 = com.tencent.mm.plugin.subapp.d.h.bW((String)localObject1, false);
      parambo.rf((String)localObject1);
      az.ayM();
      com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
      parama = m.a((String)localObject2, parambo.field_msgId, parama.sdkVer, parama.appId, paramString.zQp, paramString.zQq, parama.type, parama.hhJ);
      if (parama != null)
      {
        paramString = az.agi();
        localObject1 = new g()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(37511);
            ac.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
            boolean bool = false;
            if (ar.a.hnz != null) {
              bool = ar.a.hnz.pJ(parambo.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.e)paramAnonymousn).getMediaId().equals(parama))) {
              ((ao)bb.a(bb.this).bf(ao.class)).foG().a(paramInt, parambo);
            }
            az.agi().b(221, bb.b(bb.this));
            bb.c(bb.this);
            AppMethodBeat.o(37511);
          }
        };
        this.onSceneEndCallback = ((g)localObject1);
        paramString.a(221, (g)localObject1);
        parama = new com.tencent.mm.plugin.record.b.e(parama);
        parama.dtL();
        az.agi().a(parama, 0);
      }
    }
    localbr.ijE.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
    parama = localbr.ijE;
    if (this.Iqt == null) {
      this.Iqt = new a(this.HNS);
    }
    parama.setOnClickListener(this.Iqt);
    az.ayM();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localbr.ijE.setOnLongClickListener(c(parama1));
    }
    AppMethodBeat.o(37514);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(37515);
    int i = ((bj)paramView.getTag()).position;
    if (!this.HNS.foR()) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(37515);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    AppMethodBeat.i(37516);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37516);
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return true;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean fqu()
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
    
    public final void a(View paramView, a parama, bo parambo)
    {
      AppMethodBeat.i(37512);
      paramView = (bj)paramView.getTag();
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.HNS.HZF.getContext(), this.HNS.HZF.getContentView());
        AppMethodBeat.o(37512);
        return;
      }
      ((ao)this.HNS.bf(ao.class)).foG().a(paramView.position, paramView.dpq);
      AppMethodBeat.o(37512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bb
 * JD-Core Version:    0.7.0.1
 */