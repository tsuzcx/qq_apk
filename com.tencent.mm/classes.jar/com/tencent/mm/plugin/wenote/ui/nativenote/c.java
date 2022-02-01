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
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, com.tencent.mm.plugin.wenote.model.nativenote.b.b
{
  ImageButton EUC;
  LinearLayout EUD;
  ImageButton EUE;
  ImageButton EUF;
  ImageButton EUG;
  ImageButton EUH;
  LinearLayout EUI;
  LinearLayout EUJ;
  LinearLayout EUK;
  LinearLayout EUL;
  LinearLayout EUM;
  c EUN;
  View jwV;
  String pAa;
  public boolean pEG;
  boolean pEI;
  boolean pEJ;
  boolean pEK;
  boolean pEL;
  
  public c()
  {
    AppMethodBeat.i(30825);
    this.pEG = false;
    this.pAa = "";
    this.pEL = false;
    this.pEI = false;
    this.pEJ = false;
    this.pEK = false;
    this.EUN = this;
    AppMethodBeat.o(30825);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(30828);
    this.EUH.setImageResource(2131234782);
    if (!this.pEG)
    {
      AppMethodBeat.o(30828);
      return;
    }
    this.pEG = false;
    com.tencent.mm.plugin.wenote.model.k.fay().cfk();
    String str = com.tencent.mm.plugin.wenote.model.k.fay().cfl();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.fay().duration;
    int j = (int)com.tencent.mm.bl.a.sI(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().cfD();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().YE(k);
    if (!o.fB(str))
    {
      ae.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().Y(k, false);
      if (parama != null) {
        parama.BJ(k);
      }
      parama = new i();
      parama.content = "";
      parama.pAj = true;
      parama.pAp = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().fh(k - 1, k + 1);
      AppMethodBeat.o(30828);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).pAG = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).pAx = true;
      ((l)localc).pAB = "";
      ((l)localc).length = j;
      ((l)localc).pAA = com.tencent.mm.bl.a.G(ak.getContext(), j).toString();
      ((l)localc).kVn = (ao.cxc() + "/fav_fileicon_recording.png");
      ((l)localc).dCC = str;
      ((l)localc).duj = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.faG().BO(k);
    }
    AppMethodBeat.o(30828);
  }
  
  public final void cfr()
  {
    AppMethodBeat.i(30827);
    a(null);
    AppMethodBeat.o(30827);
  }
  
  public final void cfs()
  {
    AppMethodBeat.i(30826);
    com.tencent.mm.ui.base.h.a(this.EUH.getContext(), this.EUH.getContext().getString(2131761648), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(30829);
    this.pEL = paramBoolean;
    this.EUI.setPressed(paramBoolean);
    AppMethodBeat.o(30829);
  }
  
  public final void kf(boolean paramBoolean)
  {
    AppMethodBeat.i(30830);
    this.pEI = paramBoolean;
    this.EUJ.setPressed(paramBoolean);
    AppMethodBeat.o(30830);
  }
  
  public final void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(30831);
    this.pEJ = paramBoolean;
    this.EUK.setPressed(paramBoolean);
    AppMethodBeat.o(30831);
  }
  
  public final void kh(boolean paramBoolean)
  {
    AppMethodBeat.i(30832);
    this.pEK = paramBoolean;
    this.EUM.setPressed(paramBoolean);
    AppMethodBeat.o(30832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */