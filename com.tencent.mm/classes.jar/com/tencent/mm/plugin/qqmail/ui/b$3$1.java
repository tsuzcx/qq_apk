package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mm.ah.p;
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
    ai localai;
    if ((this.nhM.nhK.state == 0) || (this.nhM.nhK.state == 1))
    {
      paramDialogInterface = this.nhM.nhJ;
      localai = this.nhM.nhK;
      if (paramDialogInterface.mode != 5) {
        break label196;
      }
      ac.btF().cancel(localai.nfq);
    }
    for (;;)
    {
      this.nhM.nhJ.nhC.remove(this.nhM.nhK.path);
      this.nhM.nhJ.nhD.remove(this.nhM.nhK.path);
      this.nhM.nhJ.nhE.remove(this.nhM.nhK.path);
      this.nhM.nhJ.nhF.remove(this.nhM.nhK.path);
      this.nhM.nhJ.nhB.removeView(this.nhM.nhL);
      this.nhM.nhJ.bue();
      return;
      label196:
      if (paramDialogInterface.mode == 6)
      {
        u localu = (u)paramDialogInterface.nhD.get(localai.path);
        if (localu != null) {
          g.DO().dJT.c(localu);
        }
        paramDialogInterface.nhE.remove(localai.path);
        paramDialogInterface.nhF.remove(localai.path);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b.3.1
 * JD-Core Version:    0.7.0.1
 */