package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class bi
  extends c
{
  private a PQg;
  private a PhN;
  private com.tencent.mm.ak.i onSceneEndCallback;
  
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
      localObject = new an(paramLayoutInflater, 2131493621);
      ((View)localObject).setTag(new by().hk((View)localObject));
    }
    AppMethodBeat.o(37513);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, a parama1, final ca paramca, String paramString)
  {
    AppMethodBeat.i(37514);
    by localby = (by)parama;
    this.PhN = parama1;
    Object localObject2 = ao.gnf().GL(paramca.field_msgId);
    Object localObject1 = paramca.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = k.b.aD((String)localObject1, paramca.field_reserved);
      }
    }
    if (parama != null) {
      localby.jBR.setText(parama.description);
    }
    Log.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + paramca.field_content);
    paramString = e.aSK((String)localObject1);
    if ((paramString != null) && (paramString.FJZ != null) && (paramString.FJZ.length() > 0) && (paramString.FKa > 0) && (this.onSceneEndCallback == null) && (parama != null) && (Util.isNullOrNil(paramca.field_imgPath)))
    {
      localObject1 = k.Qv(z.aTY());
      localObject2 = h.cz((String)localObject1, false);
      paramca.Cz((String)localObject1);
      bg.aVF();
      com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
      parama = com.tencent.mm.pluginsdk.model.app.m.a((String)localObject2, paramca.field_msgId, parama.sdkVer, parama.appId, paramString.FJZ, paramString.FKa, parama.type, parama.iwM);
      if (parama != null)
      {
        paramString = bg.azz();
        localObject1 = new com.tencent.mm.ak.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(37511);
            Log.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
            boolean bool = false;
            if (ay.a.iDt != null) {
              bool = ay.a.iDt.Ac(paramca.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((f)paramAnonymousq).getMediaId().equals(parama))) {
              ((aw)bi.a(bi.this).bh(aw.class)).gRx().a(paramInt, paramca);
            }
            bg.azz().b(221, bi.b(bi.this));
            bi.c(bi.this);
            AppMethodBeat.o(37511);
          }
        };
        this.onSceneEndCallback = ((com.tencent.mm.ak.i)localObject1);
        paramString.a(221, (com.tencent.mm.ak.i)localObject1);
        parama = new f(parama);
        parama.eIm();
        bg.azz().a(parama, 0);
      }
    }
    localby.jBR.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
    parama = localby.jBR;
    if (this.PQg == null) {
      this.PQg = new a(this.PhN);
    }
    parama.setOnClickListener(this.PQg);
    bg.aVF();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localby.jBR.setOnLongClickListener(c(parama1));
    }
    AppMethodBeat.o(37514);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    AppMethodBeat.i(37516);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37516);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233970);
    int i = ((bq)paramView.getTag()).position;
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    AppMethodBeat.o(233970);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return true;
  }
  
  public final boolean gTT()
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
    
    public final void a(View paramView, a parama, ca paramca)
    {
      AppMethodBeat.i(37512);
      paramView = (bq)paramView.getTag();
      bg.aVF();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        u.g(this.PhN.Pwc.getContext(), this.PhN.Pwc.getContentView());
        AppMethodBeat.o(37512);
        return;
      }
      ((aw)this.PhN.bh(aw.class)).gRx().a(paramView.position, paramView.dTX);
      AppMethodBeat.o(37512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bi
 * JD-Core Version:    0.7.0.1
 */