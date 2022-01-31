package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.ab;

final class m$b$1
  implements View.OnClickListener
{
  m$b$1(m.b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34690);
    paramView = (m.b)paramView.getTag();
    ab.i("MicroMsg.MassSightBanner", "on click, massSendId %d, failed %B", new Object[] { Long.valueOf(paramView.AmV), Boolean.valueOf(paramView.AmW) });
    if (paramView.AmW) {
      u.hf(paramView.AmV);
    }
    AppMethodBeat.o(34690);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.m.b.1
 * JD-Core Version:    0.7.0.1
 */