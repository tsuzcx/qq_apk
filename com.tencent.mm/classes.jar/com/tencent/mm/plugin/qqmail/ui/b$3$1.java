package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.plugin.qqmail.b.ai;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.v;
import java.util.Map;

final class b$3$1
  implements DialogInterface.OnClickListener
{
  b$3$1(b.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(68284);
    ai localai;
    if ((this.pMZ.pMX.state == 0) || (this.pMZ.pMX.state == 1))
    {
      paramDialogInterface = this.pMZ.pMW;
      localai = this.pMZ.pMX;
      if (paramDialogInterface.mode != 5) {
        break label206;
      }
      ac.cdQ().cancel(localai.pKF);
    }
    for (;;)
    {
      this.pMZ.pMW.pMP.remove(this.pMZ.pMX.path);
      this.pMZ.pMW.pMQ.remove(this.pMZ.pMX.path);
      this.pMZ.pMW.pMR.remove(this.pMZ.pMX.path);
      this.pMZ.pMW.pMS.remove(this.pMZ.pMX.path);
      this.pMZ.pMW.pMO.removeView(this.pMZ.pMY);
      this.pMZ.pMW.ceq();
      AppMethodBeat.o(68284);
      return;
      label206:
      if (paramDialogInterface.mode == 6)
      {
        u localu = (u)paramDialogInterface.pMQ.get(localai.path);
        if (localu != null) {
          g.RK().eHt.a(localu);
        }
        paramDialogInterface.pMR.remove(localai.path);
        paramDialogInterface.pMS.remove(localai.path);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b.3.1
 * JD-Core Version:    0.7.0.1
 */