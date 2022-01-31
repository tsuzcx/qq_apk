package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.e;

public final class c
  implements com.tencent.mm.plugin.wenote.model.b.a, b
{
  View gNi;
  ImageButton vCN;
  LinearLayout vCO;
  ImageButton vCP;
  ImageButton vCQ;
  ImageButton vCR;
  ImageButton vCS;
  LinearLayout vCT;
  LinearLayout vCU;
  LinearLayout vCV;
  LinearLayout vCW;
  LinearLayout vCX;
  public boolean vCY;
  c vCZ;
  boolean vDa;
  boolean vDb;
  boolean vDc;
  boolean vDd;
  String vwP;
  
  public c()
  {
    AppMethodBeat.i(27128);
    this.vCY = false;
    this.vwP = "";
    this.vDa = false;
    this.vDb = false;
    this.vDc = false;
    this.vDd = false;
    this.vCZ = this;
    AppMethodBeat.o(27128);
  }
  
  public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(27131);
    this.vCS.setImageResource(2130840954);
    if (!this.vCY)
    {
      AppMethodBeat.o(27131);
      return;
    }
    this.vCY = false;
    com.tencent.mm.plugin.wenote.model.k.dhL().dhM();
    String str = com.tencent.mm.plugin.wenote.model.k.dhL().dhN();
    int i = (int)com.tencent.mm.plugin.wenote.model.k.dhL().duration;
    int j = (int)com.tencent.mm.bk.a.hi(i);
    int k = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().dis();
    com.tencent.mm.plugin.wenote.model.a.c localc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Lj(k);
    if (!e.cN(str))
    {
      ab.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().av(k, false);
      if (parama != null) {
        parama.Le(k);
      }
      parama = new i();
      parama.content = "";
      parama.vwW = true;
      parama.vxc = false;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().a(k, parama);
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().gW(k - 1, k + 1);
      AppMethodBeat.o(27131);
      return;
    }
    if ((k != -1) && (localc != null) && (localc.getType() == 4))
    {
      ((l)localc).vxk = Boolean.FALSE;
      ((l)localc).type = 4;
      ((l)localc).vxs = true;
      ((l)localc).vxG = "";
      ((l)localc).length = j;
      ((l)localc).vxF = com.tencent.mm.bk.a.C(ah.getContext(), j).toString();
      ((l)localc).hPe = (an.bwZ() + "/fav_fileicon_recording.png");
      ((l)localc).cBD = str;
      ((l)localc).cvf = i;
      com.tencent.mm.plugin.wenote.model.nativenote.manager.c.din().Ll(k);
    }
    AppMethodBeat.o(27131);
  }
  
  public final void dhT()
  {
    AppMethodBeat.i(27130);
    a(null);
    AppMethodBeat.o(27130);
  }
  
  public final void dhU()
  {
    AppMethodBeat.i(27129);
    com.tencent.mm.ui.base.h.a(this.vCS.getContext(), this.vCS.getContext().getString(2131301886), "", true, new c.3(this), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(27129);
  }
  
  public final void oN(boolean paramBoolean)
  {
    AppMethodBeat.i(27132);
    this.vDa = paramBoolean;
    this.vCT.setPressed(paramBoolean);
    AppMethodBeat.o(27132);
  }
  
  public final void oO(boolean paramBoolean)
  {
    AppMethodBeat.i(27133);
    this.vDb = paramBoolean;
    this.vCU.setPressed(paramBoolean);
    AppMethodBeat.o(27133);
  }
  
  public final void oP(boolean paramBoolean)
  {
    AppMethodBeat.i(27134);
    this.vDc = paramBoolean;
    this.vCV.setPressed(paramBoolean);
    AppMethodBeat.o(27134);
  }
  
  public final void oQ(boolean paramBoolean)
  {
    AppMethodBeat.i(27135);
    this.vDd = paramBoolean;
    this.vCX.setPressed(paramBoolean);
    AppMethodBeat.o(27135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.c
 * JD-Core Version:    0.7.0.1
 */