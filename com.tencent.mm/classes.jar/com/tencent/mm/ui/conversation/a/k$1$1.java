package com.tencent.mm.ui.conversation.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.sdk.platformtools.ab;

final class k$1$1
  implements Runnable
{
  k$1$1(k.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(34671);
    if (this.AmO.AmN.AmM != null)
    {
      this.AmO.AmN.AmM.setVisibility(8);
      this.AmO.AmN.AmM.removeAllViews();
    }
    a locala = e.a(this.AmO.val$context, e.a.Amu, null);
    Object localObject = locala;
    if (locala == null) {
      localObject = e.a(this.AmO.val$context, e.a.Amm, null);
    }
    if ((localObject != null) && (((a)localObject).getView() != null))
    {
      ab.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", new Object[] { localObject, ((a)localObject).getView() });
      this.AmO.AmN.AmM.setVisibility(0);
      localObject = ((a)localObject).getView();
      this.AmO.AmN.AmM.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
    }
    AppMethodBeat.o(34671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.k.1.1
 * JD-Core Version:    0.7.0.1
 */