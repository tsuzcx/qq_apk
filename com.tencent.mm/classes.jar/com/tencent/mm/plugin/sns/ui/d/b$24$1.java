package com.tencent.mm.plugin.sns.ui.d;

import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class b$24$1
  implements Runnable
{
  b$24$1(b.24 param24, awd paramawd, aj paramaj, n paramn, bxk parambxk, boolean paramBoolean) {}
  
  public final void run()
  {
    if (af.bDC().u(this.opu))
    {
      this.ppt.ogP.aW(null, false);
      g localg = af.bDC();
      n localn = this.ppn;
      awd localawd = this.opu;
      com.tencent.mm.plugin.sight.decode.a.a locala = this.ppt.ogP;
      int i = this.ppw.ppl.activity.hashCode();
      int j = this.ppt.position;
      az localaz = az.cvd();
      localaz.time = this.ppu.mPL;
      localg.a(localn, localawd, locala, i, j, localaz, this.ppv);
      this.ppt.oGT.setVisibility(0);
      this.ppt.oTI.setVisibility(8);
      this.ppt.oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.ppw.ppl.activity, i.i.shortvideo_play_btn));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.24.1
 * JD-Core Version:    0.7.0.1
 */