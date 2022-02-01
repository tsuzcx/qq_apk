package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.f;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.s.e;

public final class bc
  extends c
{
  private a JBI;
  private a KgV;
  private com.tencent.mm.al.f onSceneEndCallback;
  
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
      ((View)localObject).setTag(new bs().gP((View)localObject));
    }
    AppMethodBeat.o(37513);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, a parama1, final bu parambu, String paramString)
  {
    AppMethodBeat.i(37514);
    bs localbs = (bs)parama;
    this.JBI = parama1;
    Object localObject2 = ao.fag().xH(parambu.field_msgId);
    Object localObject1 = parambu.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = k.b.aA((String)localObject1, parambu.field_reserved);
      }
    }
    if (parama != null) {
      localbs.iCV.setText(parama.description);
    }
    ad.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + parambu.field_content);
    paramString = e.aCw((String)localObject1);
    if ((paramString != null) && (paramString.BhQ != null) && (paramString.BhQ.length() > 0) && (paramString.BhR > 0) && (this.onSceneEndCallback == null) && (parama != null) && (bt.isNullOrNil(parambu.field_imgPath)))
    {
      localObject1 = k.Hg(u.aAm());
      localObject2 = h.cd((String)localObject1, false);
      parambu.tO((String)localObject1);
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      parama = m.a((String)localObject2, parambu.field_msgId, parama.sdkVer, parama.appId, paramString.BhQ, paramString.BhR, parama.type, parama.hzS);
      if (parama != null)
      {
        paramString = ba.aiU();
        localObject1 = new com.tencent.mm.al.f()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
          {
            AppMethodBeat.i(37511);
            ad.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
            boolean bool = false;
            if (as.a.hFR != null) {
              bool = as.a.hFR.rI(parambu.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.f)paramAnonymousn).getMediaId().equals(parama))) {
              ((as)bc.a(bc.this).bh(as.class)).fFk().a(paramInt, parambu);
            }
            ba.aiU().b(221, bc.b(bc.this));
            bc.c(bc.this);
            AppMethodBeat.o(37511);
          }
        };
        this.onSceneEndCallback = ((com.tencent.mm.al.f)localObject1);
        paramString.a(221, (com.tencent.mm.al.f)localObject1);
        parama = new com.tencent.mm.plugin.record.b.f(parama);
        parama.dEi();
        ba.aiU().a(parama, 0);
      }
    }
    localbs.iCV.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
    parama = localbs.iCV;
    if (this.KgV == null) {
      this.KgV = new a(this.JBI);
    }
    parama.setOnClickListener(this.KgV);
    ba.aBQ();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localbs.iCV.setOnLongClickListener(c(parama1));
    }
    AppMethodBeat.o(37514);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    AppMethodBeat.i(37516);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37516);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    AppMethodBeat.i(194514);
    int i = ((bk)paramView.getTag()).position;
    if (!this.JBI.fFw()) {
      paraml.a(i, 100, this.JBI.JOR.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(194514);
    return true;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return true;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean fHh()
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
    
    public final void a(View paramView, a parama, bu parambu)
    {
      AppMethodBeat.i(37512);
      paramView = (bk)paramView.getTag();
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        t.g(this.JBI.JOR.getContext(), this.JBI.JOR.getContentView());
        AppMethodBeat.o(37512);
        return;
      }
      ((as)this.JBI.bh(as.class)).fFk().a(paramView.position, paramView.dBd);
      AppMethodBeat.o(37512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc
 * JD-Core Version:    0.7.0.1
 */