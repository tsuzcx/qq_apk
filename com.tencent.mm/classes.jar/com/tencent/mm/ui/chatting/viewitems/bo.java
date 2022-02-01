package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.plugin.subapp.modelvoiceremind.e;
import com.tencent.mm.plugin.subapp.modelvoiceremind.k;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v.e;

public final class bo
  extends c
{
  private a aeXl;
  private a aeiK;
  private com.tencent.mm.am.h onSceneEndCallback;
  
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
      localObject = new ap(paramLayoutInflater, R.i.ghm);
      ((View)localObject).setTag(new ci().lT((View)localObject));
    }
    AppMethodBeat.o(37513);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, a parama1, final cc paramcc, String paramString)
  {
    AppMethodBeat.i(37514);
    ci localci = (ci)parama;
    this.aeiK = parama1;
    Object localObject2 = as.iIJ().rI(paramcc.field_msgId);
    Object localObject1 = paramcc.field_content;
    paramString = null;
    parama = paramString;
    if (localObject2 != null)
    {
      parama = paramString;
      if (localObject1 != null) {
        parama = k.b.aP((String)localObject1, paramcc.field_reserved);
      }
    }
    if (parama != null) {
      localci.plr.setText(parama.description);
    }
    Log.d("MicroMsg.ChattingItemVoiceRemindSys", "content sys " + Util.secPrint(paramcc.field_content));
    paramString = e.bcA((String)localObject1);
    if ((paramString != null) && (paramString.SFm != null) && (paramString.SFm.length() > 0) && (paramString.SFn > 0) && (this.onSceneEndCallback == null) && (parama != null) && (Util.isNullOrNil(paramcc.field_imgPath)))
    {
      localObject1 = k.PW(z.bAM());
      localObject2 = com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt((String)localObject1, false);
      paramcc.BT((String)localObject1);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
      parama = n.a((String)localObject2, paramcc.field_msgId, parama.sdkVer, parama.appId, paramString.SFm, paramString.SFn, parama.type, parama.nRh);
      if (parama != null)
      {
        paramString = bh.aZW();
        localObject1 = new com.tencent.mm.am.h()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(37511);
            Log.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousp.getType());
            boolean bool = false;
            if (az.a.okS != null) {
              bool = az.a.okS.it(paramcc.field_msgId);
            }
            if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((g)paramAnonymousp).getMediaId().equals(parama))) {
              ((bf)bo.a(bo.this).cm(bf.class)).jut().b(paramInt, paramcc);
            }
            bh.aZW().b(221, bo.b(bo.this));
            bo.c(bo.this);
            AppMethodBeat.o(37511);
          }
        };
        this.onSceneEndCallback = ((com.tencent.mm.am.h)localObject1);
        paramString.a(221, (com.tencent.mm.am.h)localObject1);
        parama = new g(parama);
        parama.gGg();
        bh.aZW().a(parama, 0);
      }
    }
    localci.plr.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
    parama = localci.plr;
    if (this.aeXl == null) {
      this.aeXl = new a(this.aeiK);
    }
    parama.setOnClickListener(this.aeXl);
    bh.bCz();
    if (com.tencent.mm.model.c.isSDCardAvailable()) {
      localci.plr.setOnLongClickListener(c(parama1));
    }
    AppMethodBeat.o(37514);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    AppMethodBeat.i(37516);
    paramMenuItem.getItemId();
    AppMethodBeat.o(37516);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255314);
    int i = ((bz)paramView.getTag()).position;
    if (!this.aeiK.juH()) {
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255314);
    return true;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048191;
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  final class a
    extends v.e
  {
    public a(a parama)
    {
      super();
    }
    
    public final void a(View paramView, a parama, cc paramcc)
    {
      AppMethodBeat.i(37512);
      paramView = (bz)paramView.getTag();
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        aa.j(this.aeiK.aezO.getContext(), this.aeiK.aezO.getContentView());
        AppMethodBeat.o(37512);
        return;
      }
      ((bf)this.aeiK.cm(bf.class)).jut().b(paramView.position, paramView.hTm);
      AppMethodBeat.o(37512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bo
 * JD-Core Version:    0.7.0.1
 */