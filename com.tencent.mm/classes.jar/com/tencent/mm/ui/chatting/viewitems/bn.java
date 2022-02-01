package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.h;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.ax;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.t.e;

public final class bn
  extends c
{
  private a WBq;
  private a Xmi;
  private com.tencent.mm.an.i onSceneEndCallback;
  
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
      localObject = new aq(paramLayoutInflater, R.i.eew);
      ((View)localObject).setTag(new cg().iw((View)localObject));
    }
    AppMethodBeat.o(37513);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, a parama1, final ca paramca, String paramString)
  {
    AppMethodBeat.i(37514);
    cg localcg = (cg)parama;
    this.WBq = parama1;
    Object localObject2 = ao.hhH().NR(paramca.field_msgId);
    Object localObject1 = paramca.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = k.b.aG((String)localObject1, paramca.field_reserved);
      }
    }
    if (parama != null) {
      localcg.mrM.setText(parama.description);
    }
    Log.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + Util.secPrint(paramca.field_content));
    paramString = e.bdO((String)localObject1);
    if ((paramString != null) && (paramString.MdW != null) && (paramString.MdW.length() > 0) && (paramString.MdX > 0) && (this.onSceneEndCallback == null) && (parama != null) && (Util.isNullOrNil(paramca.field_imgPath)))
    {
      localObject1 = k.XS(z.bcZ());
      localObject2 = h.cN((String)localObject1, false);
      paramca.Jn((String)localObject1);
      bh.beI();
      com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      parama = m.a((String)localObject2, paramca.field_msgId, parama.sdkVer, parama.appId, paramString.MdW, paramString.MdX, parama.type, parama.lmb);
      if (parama != null)
      {
        paramString = bh.aGY();
        localObject1 = new com.tencent.mm.an.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
          {
            AppMethodBeat.i(37511);
            Log.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
            boolean bool = false;
            if (az.a.ltu != null) {
              bool = az.a.ltu.Gj(paramca.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((f)paramAnonymousq).getMediaId().equals(parama))) {
              ((ax)bn.a(bn.this).bC(ax.class)).hQU().a(paramInt, paramca);
            }
            bh.aGY().b(221, bn.b(bn.this));
            bn.c(bn.this);
            AppMethodBeat.o(37511);
          }
        };
        this.onSceneEndCallback = ((com.tencent.mm.an.i)localObject1);
        paramString.a(221, (com.tencent.mm.an.i)localObject1);
        parama = new f(parama);
        parama.fur();
        bh.aGY().a(parama, 0);
      }
    }
    localcg.mrM.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
    parama = localcg.mrM;
    if (this.Xmi == null) {
      this.Xmi = new a(this.WBq);
    }
    parama.setOnClickListener(this.Xmi);
    bh.beI();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localcg.mrM.setOnLongClickListener(c(parama1));
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
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    AppMethodBeat.i(285237);
    int i = ((by)paramView.getTag()).position;
    if (!this.WBq.hRj()) {
      paramo.a(i, 100, this.WBq.WQv.getMMResources().getString(R.l.evO), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(285237);
    return true;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return true;
  }
  
  public final boolean hTD()
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
      paramView = (by)paramView.getTag();
      bh.beI();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        w.g(this.WBq.WQv.getContext(), this.WBq.WQv.getContentView());
        AppMethodBeat.o(37512);
        return;
      }
      ((ax)this.WBq.bC(ax.class)).hQU().a(paramView.position, paramView.fNz);
      AppMethodBeat.o(37512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bn
 * JD-Core Version:    0.7.0.1
 */