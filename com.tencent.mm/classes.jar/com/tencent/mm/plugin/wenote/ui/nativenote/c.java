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
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, com.tencent.mm.plugin.wenote.model.nativenote.b.b
{
  ImageButton ECg;
  LinearLayout ECh;
  ImageButton ECi;
  ImageButton ECj;
  ImageButton ECk;
  ImageButton ECl;
  LinearLayout ECm;
  LinearLayout ECn;
  LinearLayout ECo;
  LinearLayout ECp;
  LinearLayout ECq;
  c ECr;
  View jua;
  String ptw;
  public boolean pyc;
  boolean pye;
  boolean pyf;
  boolean pyg;
  boolean pyh;
  
  public c()
  {
    AppMethodBeat.i(30825);
    this.pyc = false;
    this.ptw = "";
    this.pyh = false;
    this.pye = false;
    this.pyf = false;
    this.pyg = false;
    this.ECr = this;
    AppMethodBeat.o(30825);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(30828);
    this.ECl.setImageResource(2131234782);
    if (!this.pyc)
    {
      AppMethodBeat.o(30828);
      return;
    }
    this.pyc = false;
    com.tencent.mm.plugin.wenote.model.k.eWM().cdV();
    String str = com.tencent.mm.plugin.wenote.model.k.eWM().cdW();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.eWM().duration;
    int j = (int)com.tencent.mm.bm.a.sv(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().ceo();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().XY(k);
    if (!com.tencent.mm.vfs.i.fv(str))
    {
      ad.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().W(k, false);
      if (parama != null) {
        parama.Bx(k);
      }
      parama = new com.tencent.mm.plugin.wenote.model.a.i();
      parama.content = "";
      parama.ptF = true;
      parama.ptL = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().fg(k - 1, k + 1);
      AppMethodBeat.o(30828);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).puc = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).ptT = true;
      ((l)localc).ptX = "";
      ((l)localc).length = j;
      ((l)localc).ptW = com.tencent.mm.bm.a.G(aj.getContext(), j).toString();
      ((l)localc).kRE = (ao.cvB() + "/fav_fileicon_recording.png");
      ((l)localc).dBx = str;
      ((l)localc).dtd = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eWU().BC(k);
    }
    AppMethodBeat.o(30828);
  }
  
  public final void cec()
  {
    AppMethodBeat.i(30827);
    a(null);
    AppMethodBeat.o(30827);
  }
  
  public final void ced()
  {
    AppMethodBeat.i(30826);
    com.tencent.mm.ui.base.h.a(this.ECl.getContext(), this.ECl.getContext().getString(2131761648), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void kf(boolean paramBoolean)
  {
    AppMethodBeat.i(30829);
    this.pyh = paramBoolean;
    this.ECm.setPressed(paramBoolean);
    AppMethodBeat.o(30829);
  }
  
  public final void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(30830);
    this.pye = paramBoolean;
    this.ECn.setPressed(paramBoolean);
    AppMethodBeat.o(30830);
  }
  
  public final void kh(boolean paramBoolean)
  {
    AppMethodBeat.i(30831);
    this.pyf = paramBoolean;
    this.ECo.setPressed(paramBoolean);
    AppMethodBeat.o(30831);
  }
  
  public final void ki(boolean paramBoolean)
  {
    AppMethodBeat.i(30832);
    this.pyg = paramBoolean;
    this.ECq.setPressed(paramBoolean);
    AppMethodBeat.o(30832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */