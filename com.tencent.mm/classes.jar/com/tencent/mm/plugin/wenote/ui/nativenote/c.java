package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, com.tencent.mm.plugin.wenote.model.nativenote.b.b
{
  ImageButton JKA;
  LinearLayout JKB;
  LinearLayout JKC;
  LinearLayout JKD;
  LinearLayout JKE;
  LinearLayout JKF;
  c JKG;
  ImageButton JKv;
  LinearLayout JKw;
  ImageButton JKx;
  ImageButton JKy;
  ImageButton JKz;
  View kvj;
  String qPr;
  public boolean qTX;
  boolean qTZ;
  boolean qUa;
  boolean qUb;
  boolean qUc;
  
  public c()
  {
    AppMethodBeat.i(30825);
    this.qTX = false;
    this.qPr = "";
    this.qUc = false;
    this.qTZ = false;
    this.qUa = false;
    this.qUb = false;
    this.JKG = this;
    AppMethodBeat.o(30825);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(30828);
    this.JKA.setImageResource(2131235761);
    if (!this.qTX)
    {
      AppMethodBeat.o(30828);
      return;
    }
    this.qTX = false;
    com.tencent.mm.plugin.wenote.model.k.gjD().cDa();
    String str = com.tencent.mm.plugin.wenote.model.k.gjD().cDb();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.gjD().duration;
    int j = (int)com.tencent.mm.bl.a.AO(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().cDt();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ahp(k);
    if (!s.YS(str))
    {
      Log.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().ae(k, false);
      if (parama != null) {
        parama.Ft(k);
      }
      parama = new i();
      parama.content = "";
      parama.qPA = true;
      parama.qPG = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().fx(k - 1, k + 1);
      AppMethodBeat.o(30828);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).qPX = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).qPO = true;
      ((l)localc).qPS = "";
      ((l)localc).length = j;
      ((l)localc).qPR = com.tencent.mm.bl.a.J(MMApplicationContext.getContext(), j).toString();
      ((l)localc).mav = (com.tencent.mm.plugin.fav.a.ao.cVg() + "/fav_fileicon_recording.png");
      ((l)localc).dUs = str;
      ((l)localc).dLu = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.gjL().Fy(k);
    }
    AppMethodBeat.o(30828);
  }
  
  public final void cDh()
  {
    AppMethodBeat.i(30827);
    a(null);
    AppMethodBeat.o(30827);
  }
  
  public final void cDi()
  {
    AppMethodBeat.i(30826);
    com.tencent.mm.ui.base.h.a(this.JKA.getContext(), this.JKA.getContext().getString(2131763616), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void lh(boolean paramBoolean)
  {
    AppMethodBeat.i(30829);
    this.qUc = paramBoolean;
    this.JKB.setPressed(paramBoolean);
    AppMethodBeat.o(30829);
  }
  
  public final void li(boolean paramBoolean)
  {
    AppMethodBeat.i(30830);
    this.qTZ = paramBoolean;
    this.JKC.setPressed(paramBoolean);
    AppMethodBeat.o(30830);
  }
  
  public final void lj(boolean paramBoolean)
  {
    AppMethodBeat.i(30831);
    this.qUa = paramBoolean;
    this.JKD.setPressed(paramBoolean);
    AppMethodBeat.o(30831);
  }
  
  public final void lk(boolean paramBoolean)
  {
    AppMethodBeat.i(30832);
    this.qUb = paramBoolean;
    this.JKF.setPressed(paramBoolean);
    AppMethodBeat.o(30832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */