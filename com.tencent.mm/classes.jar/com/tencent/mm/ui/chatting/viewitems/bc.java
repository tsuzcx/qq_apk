package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.f;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class bc
  extends c
{
  private a JWz;
  private a KDq;
  private com.tencent.mm.ak.f onSceneEndCallback;
  
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
      localObject = new ah(paramLayoutInflater, 2131493512);
      ((View)localObject).setTag(new bs().gU((View)localObject));
    }
    AppMethodBeat.o(37513);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, a parama1, final bv parambv, String paramString)
  {
    AppMethodBeat.i(37514);
    bs localbs = (bs)parama;
    this.JWz = parama1;
    Object localObject2 = ao.fdU().yb(parambv.field_msgId);
    Object localObject1 = parambv.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = k.b.aB((String)localObject1, parambv.field_reserved);
      }
    }
    if (parama != null) {
      localbs.iFO.setText(parama.description);
    }
    ae.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + parambv.field_content);
    paramString = e.aDP((String)localObject1);
    if ((paramString != null) && (paramString.Bzo != null) && (paramString.Bzo.length() > 0) && (paramString.Bzp > 0) && (this.onSceneEndCallback == null) && (parama != null) && (bu.isNullOrNil(parambv.field_imgPath)))
    {
      localObject1 = k.HI(v.aAC());
      localObject2 = h.ch((String)localObject1, false);
      parambv.uj((String)localObject1);
      com.tencent.mm.model.bc.aCg();
      com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
      parama = m.a((String)localObject2, parambv.field_msgId, parama.sdkVer, parama.appId, paramString.Bzo, paramString.Bzp, parama.type, parama.hCG);
      if (parama != null)
      {
        paramString = com.tencent.mm.model.bc.ajj();
        localObject1 = new com.tencent.mm.ak.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(37511);
            ae.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
            boolean bool = false;
            if (au.a.hIJ != null) {
              bool = au.a.hIJ.rV(parambv.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.f)paramAnonymousn).getMediaId().equals(parama))) {
              ((at)bc.a(bc.this).bh(at.class)).fJn().a(paramInt, parambv);
            }
            com.tencent.mm.model.bc.ajj().b(221, bc.b(bc.this));
            bc.c(bc.this);
            AppMethodBeat.o(37511);
          }
        };
        this.onSceneEndCallback = ((com.tencent.mm.ak.f)localObject1);
        paramString.a(221, (com.tencent.mm.ak.f)localObject1);
        parama = new com.tencent.mm.plugin.record.b.f(parama);
        parama.dHz();
        com.tencent.mm.model.bc.ajj().a(parama, 0);
      }
    }
    localbs.iFO.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
    parama = localbs.iFO;
    if (this.KDq == null) {
      this.KDq = new a(this.JWz);
    }
    parama.setOnClickListener(this.KDq);
    com.tencent.mm.model.bc.aCg();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localbs.iFO.setOnLongClickListener(c(parama1));
    }
    AppMethodBeat.o(37514);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    AppMethodBeat.i(37516);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37516);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187915);
    int i = ((bk)paramView.getTag()).position;
    if (!this.JWz.fJD()) {
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187915);
    return true;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean fLz()
  {
    return false;
  }
  
  final class a
    extends t.e
  {
    public a(a parama)
    {
      super();
    }
    
    public final void a(View paramView, a parama, bv parambv)
    {
      AppMethodBeat.i(37512);
      paramView = (bk)paramView.getTag();
      com.tencent.mm.model.bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.JWz.Kkd.getContext(), this.JWz.Kkd.getContentView());
        AppMethodBeat.o(37512);
        return;
      }
      ((at)this.JWz.bh(at.class)).fJn().a(paramView.position, paramView.dCi);
      AppMethodBeat.o(37512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc
 * JD-Core Version:    0.7.0.1
 */