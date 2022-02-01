package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.vfs.q;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, com.tencent.mm.plugin.wenote.model.nativenote.b.b
{
  ImageButton QJO;
  LinearLayout QJP;
  ImageButton QJQ;
  ImageButton QJR;
  ImageButton QJS;
  ImageButton QJT;
  LinearLayout QJU;
  LinearLayout QJV;
  LinearLayout QJW;
  LinearLayout QJX;
  LinearLayout QJY;
  c QJZ;
  View nnu;
  String urx;
  public boolean uwd;
  boolean uwf;
  boolean uwg;
  boolean uwh;
  boolean uwi;
  
  public c()
  {
    AppMethodBeat.i(30825);
    this.uwd = false;
    this.urx = "";
    this.uwi = false;
    this.uwf = false;
    this.uwg = false;
    this.uwh = false;
    this.QJZ = this;
    AppMethodBeat.o(30825);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(30828);
    this.QJT.setImageResource(R.g.dpB);
    if (!this.uwd)
    {
      AppMethodBeat.o(30828);
      return;
    }
    this.uwd = false;
    com.tencent.mm.plugin.wenote.model.k.hdr().cRF();
    String str = com.tencent.mm.plugin.wenote.model.k.hdr().cRG();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.hdr().duration;
    int j = (int)com.tencent.mm.bn.a.GW(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().cRY();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().aph(k);
    if (!com.tencent.mm.vfs.u.agG(str))
    {
      Log.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().ae(k, false);
      if (parama != null) {
        parama.Ja(k);
      }
      parama = new i();
      parama.content = "";
      parama.urG = true;
      parama.urM = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().fU(k - 1, k + 1);
      AppMethodBeat.o(30828);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).usd = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).urU = true;
      ((l)localc).urY = "";
      ((l)localc).length = j;
      ((l)localc).urX = com.tencent.mm.bn.a.N(MMApplicationContext.getContext(), j).toString();
      ((l)localc).oYm = (ap.dkm() + "/fav_fileicon_recording.png");
      ((l)localc).fNU = str;
      ((l)localc).fEj = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.hdz().Jf(k);
    }
    AppMethodBeat.o(30828);
  }
  
  public final void cRM()
  {
    AppMethodBeat.i(30827);
    a(null);
    AppMethodBeat.o(30827);
  }
  
  public final void cRN()
  {
    AppMethodBeat.i(30826);
    com.tencent.mm.ui.base.h.a(this.QJT.getContext(), this.QJT.getContext().getString(R.l.eMV), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(30815);
        c.this.a(null);
        AppMethodBeat.o(30815);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(30826);
  }
  
  public final void mt(boolean paramBoolean)
  {
    AppMethodBeat.i(30829);
    this.uwi = paramBoolean;
    this.QJU.setPressed(paramBoolean);
    AppMethodBeat.o(30829);
  }
  
  public final void mu(boolean paramBoolean)
  {
    AppMethodBeat.i(30830);
    this.uwf = paramBoolean;
    this.QJV.setPressed(paramBoolean);
    AppMethodBeat.o(30830);
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(30831);
    this.uwg = paramBoolean;
    this.QJW.setPressed(paramBoolean);
    AppMethodBeat.o(30831);
  }
  
  public final void mw(boolean paramBoolean)
  {
    AppMethodBeat.i(30832);
    this.uwh = paramBoolean;
    this.QJY.setPressed(paramBoolean);
    AppMethodBeat.o(30832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */