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
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.vfs.y;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, com.tencent.mm.plugin.wenote.model.nativenote.b.b
{
  ImageButton XDm;
  LinearLayout XDn;
  ImageButton XDo;
  ImageButton XDp;
  ImageButton XDq;
  ImageButton XDr;
  LinearLayout XDs;
  LinearLayout XDt;
  LinearLayout XDu;
  LinearLayout XDv;
  LinearLayout XDw;
  c XDx;
  View qkB;
  public boolean xCC;
  boolean xCE;
  boolean xCF;
  boolean xCG;
  boolean xCH;
  String xxS;
  
  public c()
  {
    AppMethodBeat.i(30825);
    this.xCC = false;
    this.xxS = "";
    this.xCH = false;
    this.xCE = false;
    this.xCF = false;
    this.xCG = false;
    this.XDx = this;
    AppMethodBeat.o(30825);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(30828);
    this.XDr.setImageResource(R.g.fpQ);
    if (!this.xCC)
    {
      AppMethodBeat.o(30828);
      return;
    }
    this.xCC = false;
    com.tencent.mm.plugin.wenote.model.k.iDY().dvY();
    String str = com.tencent.mm.plugin.wenote.model.k.iDY().dvZ();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.iDY().duration;
    int j = (int)com.tencent.mm.bf.a.jh(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().dwr();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().avf(k);
    if (!y.ZC(str))
    {
      Log.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().av(k, false);
      if (parama != null) {
        parama.JI(k);
      }
      parama = new i();
      parama.content = "";
      parama.xyb = true;
      parama.xyh = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().gL(k - 1, k + 1);
      AppMethodBeat.o(30828);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).xyz = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).xyp = true;
      ((l)localc).xyu = "";
      ((l)localc).length = j;
      ((l)localc).xyt = com.tencent.mm.bf.a.Q(MMApplicationContext.getContext(), j).toString();
      ((l)localc).sdM = (aq.dQY() + "/fav_fileicon_recording.png");
      ((l)localc).hTM = str;
      ((l)localc).hIZ = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.iEg().JN(k);
    }
    AppMethodBeat.o(30828);
  }
  
  public final void dwf()
  {
    AppMethodBeat.i(30827);
    a(null);
    AppMethodBeat.o(30827);
  }
  
  public final void dwg()
  {
    AppMethodBeat.i(30826);
    com.tencent.mm.ui.base.k.a(this.XDr.getContext(), this.XDr.getContext().getString(R.l.gPi), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(30829);
    this.xCH = paramBoolean;
    this.XDs.setPressed(paramBoolean);
    AppMethodBeat.o(30829);
  }
  
  public final void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(30830);
    this.xCE = paramBoolean;
    this.XDt.setPressed(paramBoolean);
    AppMethodBeat.o(30830);
  }
  
  public final void nR(boolean paramBoolean)
  {
    AppMethodBeat.i(30831);
    this.xCF = paramBoolean;
    this.XDu.setPressed(paramBoolean);
    AppMethodBeat.o(30831);
  }
  
  public final void nS(boolean paramBoolean)
  {
    AppMethodBeat.i(30832);
    this.xCG = paramBoolean;
    this.XDw.setPressed(paramBoolean);
    AppMethodBeat.o(30832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */