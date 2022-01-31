package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.an.a;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.ak;

final class r$1
  implements View.OnClickListener
{
  r$1(r paramr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38235);
    if (r.a(this.rGQ) == null)
    {
      AppMethodBeat.o(38235);
      return;
    }
    if (r.a(this.rGQ).field_likeFlag == 0) {
      if (r.a(this.rGQ).csG())
      {
        an.a.a(r.a(this.rGQ), 1, "", "", r.b(this.rGQ));
        r.a(this.rGQ).field_likeFlag = 1;
        ag.cpf().B(r.a(this.rGQ));
        label95:
        if (r.a(this.rGQ).field_snsId != 0L) {
          break label270;
        }
      }
    }
    label270:
    for (paramView = "";; paramView = i.lq(r.a(this.rGQ).field_snsId))
    {
      h.qsU.e(11989, new Object[] { Integer.valueOf(1), paramView, Integer.valueOf(0) });
      new ak().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38234);
          r.1.this.rGQ.refresh();
          AppMethodBeat.o(38234);
        }
      }, 500L);
      AppMethodBeat.o(38235);
      return;
      an.a.a(r.a(this.rGQ).field_userName, 5, "", r.a(this.rGQ), r.b(this.rGQ));
      break;
      r.a(this.rGQ).field_likeFlag = 0;
      ag.cpf().B(r.a(this.rGQ));
      an.a.aaC(r.a(this.rGQ).getSnsId());
      r.a(this.rGQ, ag.cpf().lZ(r.a(this.rGQ).field_snsId));
      break label95;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.r.1
 * JD-Core Version:    0.7.0.1
 */