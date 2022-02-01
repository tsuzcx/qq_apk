package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;

final class SnsMsgUI$a$2
  implements View.OnClickListener
{
  SnsMsgUI$a$2(SnsMsgUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(98878);
    ad.v("MicroMsg.SnsMsgUI", "on delView clicked");
    this.xBC.mRn.cIh();
    if (this.xBC.xBB != null) {
      this.xBC.xBB.cO(paramView.getTag());
    }
    AppMethodBeat.o(98878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.a.2
 * JD-Core Version:    0.7.0.1
 */