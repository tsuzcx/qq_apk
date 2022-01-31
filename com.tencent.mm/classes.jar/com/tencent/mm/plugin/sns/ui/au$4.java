package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.y;

final class au$4
  implements View.OnClickListener
{
  au$4(au paramau) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
    this.pep.pec.oNE = false;
    com.tencent.mm.plugin.sns.abtest.a.bBV();
    if (!(paramView.getTag() instanceof a.c)) {
      y.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
    }
    do
    {
      return;
      a.c localc = (a.c)paramView.getTag();
      if ((localc.plP != null) && (localc.plP.tNr.sPI == 21))
      {
        awe localawe = localc.oLv;
        if ((!q.Gj().equals(localc.plP.hPY)) && ((localawe == null) || (localawe.cec == 0)))
        {
          com.tencent.mm.plugin.sns.lucky.ui.a.e(this.pep.bER, localc.pmZ.yD(0));
          return;
        }
      }
    } while (!(this.pep.bER instanceof t));
    ((t)this.pep.bER).cZ(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au.4
 * JD-Core Version:    0.7.0.1
 */