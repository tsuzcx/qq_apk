package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.ah;

final class r$1
  implements View.OnClickListener
{
  r$1(r paramr) {}
  
  public final void onClick(View paramView)
  {
    if (r.a(this.oPe) == null) {
      return;
    }
    if (r.a(this.oPe).field_likeFlag == 0) {
      if (r.a(this.oPe).bGD())
      {
        am.a.a(r.a(this.oPe), 1, "", "", r.b(this.oPe));
        r.a(this.oPe).field_likeFlag = 1;
        af.bDF().C(r.a(this.oPe));
        label85:
        if (r.a(this.oPe).field_snsId != 0L) {
          break label255;
        }
      }
    }
    label255:
    for (paramView = "";; paramView = i.fN(r.a(this.oPe).field_snsId))
    {
      h.nFQ.f(11989, new Object[] { Integer.valueOf(1), paramView, Integer.valueOf(0) });
      new ah().postDelayed(new r.1.1(this), 500L);
      return;
      am.a.a(r.a(this.oPe).field_userName, 5, "", r.a(this.oPe), r.b(this.oPe));
      break;
      r.a(this.oPe).field_likeFlag = 0;
      af.bDF().C(r.a(this.oPe));
      am.a.NI(r.a(this.oPe).bGk());
      r.a(this.oPe, af.bDF().gt(r.a(this.oPe).field_snsId));
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r.1
 * JD-Core Version:    0.7.0.1
 */