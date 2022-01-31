package com.tencent.mm.plugin.sns.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.au.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$17
  implements View.OnClickListener
{
  b$17(b paramb) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof String))
    {
      paramView = (String)paramView.getTag();
      y.d("MicroMsg.TimelineClickListener", "localId " + paramView);
      aj.xP(v.OV(paramView));
      aj.xN(v.OV(paramView));
      af.bDB().bCp();
      this.ppl.bHo();
      if (this.ppl.ppg != null) {
        this.ppl.ppg.bJw();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.17
 * JD-Core Version:    0.7.0.1
 */