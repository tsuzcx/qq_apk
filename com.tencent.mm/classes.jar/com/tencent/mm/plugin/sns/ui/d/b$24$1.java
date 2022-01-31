package com.tencent.mm.plugin.sns.ui.d;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class b$24$1
  implements Runnable
{
  b$24$1(b.24 param24, bcs parambcs, aj paramaj, n paramn, TimeLineObject paramTimeLineObject, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(40278);
    if (ag.cpc().u(this.rdM))
    {
      this.skl.qVe.bl(null, false);
      g localg = ag.cpc();
      n localn = this.skf;
      bcs localbcs = this.rdM;
      com.tencent.mm.plugin.sight.decode.a.a locala = this.skl.qVe;
      int i = this.sko.skd.activity.hashCode();
      int j = this.skl.position;
      az localaz = az.dxG();
      localaz.oLs = this.skm.CreateTime;
      localg.a(localn, localbcs, locala, i, j, localaz, this.skn);
      this.skl.rwJ.setVisibility(0);
      this.skl.rLF.setVisibility(8);
      this.skl.rwJ.setImageDrawable(com.tencent.mm.cb.a.k(this.sko.skd.activity, 2131231980));
    }
    AppMethodBeat.o(40278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.24.1
 * JD-Core Version:    0.7.0.1
 */