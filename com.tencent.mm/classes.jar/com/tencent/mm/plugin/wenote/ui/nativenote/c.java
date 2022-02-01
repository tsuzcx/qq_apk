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
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.k.1;
import com.tencent.mm.plugin.wenote.model.k.2;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, com.tencent.mm.plugin.wenote.model.nativenote.b.b
{
  ImageButton CYk;
  LinearLayout CYl;
  ImageButton CYm;
  ImageButton CYn;
  ImageButton CYo;
  ImageButton CYp;
  LinearLayout CYq;
  LinearLayout CYr;
  LinearLayout CYs;
  LinearLayout CYt;
  LinearLayout CYu;
  c CYv;
  View jaR;
  String oPM;
  public boolean oUs;
  boolean oUu;
  boolean oUv;
  boolean oUw;
  boolean oUx;
  
  public c()
  {
    AppMethodBeat.i(30825);
    this.oUs = false;
    this.oPM = "";
    this.oUx = false;
    this.oUu = false;
    this.oUv = false;
    this.oUw = false;
    this.CYv = this;
    AppMethodBeat.o(30825);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(30828);
    this.CYp.setImageResource(2131234782);
    if (!this.oUs)
    {
      AppMethodBeat.o(30828);
      return;
    }
    this.oUs = false;
    com.tencent.mm.plugin.wenote.model.k.eHT().bZr();
    String str = com.tencent.mm.plugin.wenote.model.k.eHT().bZs();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.eHT().duration;
    int j = (int)com.tencent.mm.bl.a.qw(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().bZK();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().Wh(k);
    if (!com.tencent.mm.vfs.i.eA(str))
    {
      ac.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().W(k, false);
      if (parama != null) {
        parama.AP(k);
      }
      parama = new com.tencent.mm.plugin.wenote.model.a.i();
      parama.content = "";
      parama.oPV = true;
      parama.oQb = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().fc(k - 1, k + 1);
      AppMethodBeat.o(30828);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).oQs = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).oQj = true;
      ((l)localc).oQn = "";
      ((l)localc).length = j;
      ((l)localc).oQm = com.tencent.mm.bl.a.F(ai.getContext(), j).toString();
      ((l)localc).kvC = (com.tencent.mm.plugin.fav.a.ao.cpW() + "/fav_fileicon_recording.png");
      ((l)localc).dpK = str;
      ((l)localc).dhF = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.eIb().AU(k);
    }
    AppMethodBeat.o(30828);
  }
  
  public final void bZy()
  {
    AppMethodBeat.i(30827);
    a(null);
    AppMethodBeat.o(30827);
  }
  
  public final void bZz()
  {
    AppMethodBeat.i(30826);
    com.tencent.mm.ui.base.h.a(this.CYp.getContext(), this.CYp.getContext().getString(2131761648), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void jU(boolean paramBoolean)
  {
    AppMethodBeat.i(30829);
    this.oUx = paramBoolean;
    this.CYq.setPressed(paramBoolean);
    AppMethodBeat.o(30829);
  }
  
  public final void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(30830);
    this.oUu = paramBoolean;
    this.CYr.setPressed(paramBoolean);
    AppMethodBeat.o(30830);
  }
  
  public final void jW(boolean paramBoolean)
  {
    AppMethodBeat.i(30831);
    this.oUv = paramBoolean;
    this.CYs.setPressed(paramBoolean);
    AppMethodBeat.o(30831);
  }
  
  public final void jX(boolean paramBoolean)
  {
    AppMethodBeat.i(30832);
    this.oUw = paramBoolean;
    this.CYu.setPressed(paramBoolean);
    AppMethodBeat.o(30832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */