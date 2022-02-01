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
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, com.tencent.mm.plugin.wenote.model.nativenote.b.b
{
  ImageButton BGd;
  LinearLayout BGe;
  ImageButton BGf;
  ImageButton BGg;
  ImageButton BGh;
  ImageButton BGi;
  LinearLayout BGj;
  LinearLayout BGk;
  LinearLayout BGl;
  LinearLayout BGm;
  LinearLayout BGn;
  c BGo;
  View iAQ;
  String omm;
  public boolean oqS;
  boolean oqU;
  boolean oqV;
  boolean oqW;
  boolean oqX;
  
  public c()
  {
    AppMethodBeat.i(30825);
    this.oqS = false;
    this.omm = "";
    this.oqX = false;
    this.oqU = false;
    this.oqV = false;
    this.oqW = false;
    this.BGo = this;
    AppMethodBeat.o(30825);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(30828);
    this.BGi.setImageResource(2131234782);
    if (!this.oqS)
    {
      AppMethodBeat.o(30828);
      return;
    }
    this.oqS = false;
    com.tencent.mm.plugin.wenote.model.k.esA().bSc();
    String str = com.tencent.mm.plugin.wenote.model.k.esA().bSd();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.esA().duration;
    int j = (int)com.tencent.mm.bm.a.mI(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().bSv();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().TZ(k);
    if (!com.tencent.mm.vfs.i.eK(str))
    {
      ad.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().W(k, false);
      if (parama != null) {
        parama.zX(k);
      }
      parama = new com.tencent.mm.plugin.wenote.model.a.i();
      parama.content = "";
      parama.omv = true;
      parama.omB = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().eZ(k - 1, k + 1);
      AppMethodBeat.o(30828);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).omS = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).omJ = true;
      ((l)localc).omN = "";
      ((l)localc).length = j;
      ((l)localc).omM = com.tencent.mm.bm.a.C(aj.getContext(), j).toString();
      ((l)localc).jUR = (ao.cip() + "/fav_fileicon_recording.png");
      ((l)localc).drZ = str;
      ((l)localc).dkk = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.esI().Ac(k);
    }
    AppMethodBeat.o(30828);
  }
  
  public final void bSj()
  {
    AppMethodBeat.i(30827);
    a(null);
    AppMethodBeat.o(30827);
  }
  
  public final void bSk()
  {
    AppMethodBeat.i(30826);
    com.tencent.mm.ui.base.h.a(this.BGi.getContext(), this.BGi.getContext().getString(2131761648), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void jr(boolean paramBoolean)
  {
    AppMethodBeat.i(30829);
    this.oqX = paramBoolean;
    this.BGj.setPressed(paramBoolean);
    AppMethodBeat.o(30829);
  }
  
  public final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(30830);
    this.oqU = paramBoolean;
    this.BGk.setPressed(paramBoolean);
    AppMethodBeat.o(30830);
  }
  
  public final void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(30831);
    this.oqV = paramBoolean;
    this.BGl.setPressed(paramBoolean);
    AppMethodBeat.o(30831);
  }
  
  public final void ju(boolean paramBoolean)
  {
    AppMethodBeat.i(30832);
    this.oqW = paramBoolean;
    this.BGn.setPressed(paramBoolean);
    AppMethodBeat.o(30832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */