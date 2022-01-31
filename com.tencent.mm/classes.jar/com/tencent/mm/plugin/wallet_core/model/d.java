package com.tencent.mm.plugin.wallet_core.model;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends a
{
  ProgressBar gvS;
  TextView oAW;
  boolean oBa = false;
  private int scene;
  a.a ufv;
  
  public d(TextView paramTextView, ProgressBar paramProgressBar, int paramInt)
  {
    this.oAW = paramTextView;
    this.gvS = paramProgressBar;
    this.scene = paramInt;
  }
  
  protected final void a(a.a parama)
  {
    AppMethodBeat.i(142482);
    this.oBa = false;
    this.ufv = parama;
    parama = new vf();
    parama.cLJ.scene = this.scene;
    parama.cLJ.cLL = true;
    parama.cLJ.retryCount = 0;
    parama.cLJ.cLM = true;
    parama.cLK.cLC = new d.1(this, parama);
    com.tencent.mm.sdk.b.a.ymk.l(parama);
    AppMethodBeat.o(142482);
  }
  
  protected final void bOR()
  {
    AppMethodBeat.i(142481);
    ab.i("MicroMsg.BalanceLoadingLogic", "time expired: %s", new Object[] { Boolean.valueOf(this.oBa) });
    if (!this.oBa)
    {
      this.oAW.setVisibility(8);
      this.gvS.setVisibility(0);
    }
    AppMethodBeat.o(142481);
  }
  
  public final void release()
  {
    AppMethodBeat.i(142483);
    super.release();
    this.ufv = null;
    AppMethodBeat.o(142483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.d
 * JD-Core Version:    0.7.0.1
 */