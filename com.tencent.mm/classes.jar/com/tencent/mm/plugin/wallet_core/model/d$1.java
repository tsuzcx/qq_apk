package com.tencent.mm.plugin.wallet_core.model;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.g.a.vf.b;

final class d$1
  implements Runnable
{
  d$1(d paramd, vf paramvf) {}
  
  public final void run()
  {
    AppMethodBeat.i(142480);
    if (this.ufw.ufv != null) {
      this.ufw.ufv.r(new Object[] { this.ucv });
    }
    if ((this.ucv.cLK.cMo) && (this.ucv.cLK.errCode == 0))
    {
      this.ufw.oBa = true;
      this.ufw.oAW.setVisibility(0);
      this.ufw.gvS.setVisibility(8);
    }
    AppMethodBeat.o(142480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.d.1
 * JD-Core Version:    0.7.0.1
 */