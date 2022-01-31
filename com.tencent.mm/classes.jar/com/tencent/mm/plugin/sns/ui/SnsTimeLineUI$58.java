package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.QFadeImageView;

final class SnsTimeLineUI$58
  implements Runnable
{
  SnsTimeLineUI$58(SnsTimeLineUI paramSnsTimeLineUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(145618);
    SnsTimeLineUI.l(this.rYv).list.setSelection(0);
    Object localObject = SnsTimeLineUI.j(this.rYv);
    if (((SnsTimeLineUI.a)localObject).rZb)
    {
      if (SnsTimeLineUI.rYc.booleanValue()) {
        ab.i("MicroMsg.SnsTimeLineUI", "force init %s %s %s", new Object[] { Boolean.valueOf(((SnsTimeLineUI.a)localObject).rZb), Float.valueOf(((SnsTimeLineUI.a)localObject).rZe), Integer.valueOf(((SnsTimeLineUI.a)localObject).rZc) });
      }
      AbsoluteLayout.LayoutParams localLayoutParams = (AbsoluteLayout.LayoutParams)SnsTimeLineUI.t(((SnsTimeLineUI.a)localObject).rYv).getLayoutParams();
      localLayoutParams.y = ((SnsTimeLineUI.a)localObject).rZc;
      SnsTimeLineUI.t(((SnsTimeLineUI.a)localObject).rYv).setLayoutParams(localLayoutParams);
      ((SnsTimeLineUI.a)localObject).rYR = ((SnsTimeLineUI.a)localObject).rZd;
      ((SnsTimeLineUI.a)localObject).rYV = ((SnsTimeLineUI.a)localObject).rZe;
    }
    SnsTimeLineUI.j(this.rYv).cwq();
    localObject = SnsTimeLineUI.q(this.rYv);
    SnsTimeLineUI.m(this.rYv);
    ((c)localObject).d(SnsTimeLineUI.n(this.rYv), SnsTimeLineUI.o(this.rYv), SnsTimeLineUI.p(this.rYv), SnsTimeLineUI.z(this.rYv));
    g.RL().Ru().set(ac.a.yLj, Integer.valueOf(2));
    AppMethodBeat.o(145618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.58
 * JD-Core Version:    0.7.0.1
 */