package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.b;
import com.tencent.xweb.xwalk.a.e;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.XWalkEnvironment;

final class c$15
  implements View.OnClickListener
{
  c$15(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(85136);
    paramView = e.eap().iterator();
    while (paramView.hasNext()) {
      ((com.tencent.xweb.xwalk.a.c)paramView.next()).TI(-1);
    }
    paramView = XWalkEnvironment.getPluginBaseDir();
    if (paramView.isEmpty())
    {
      AppMethodBeat.o(85136);
      return;
    }
    b.ayf(paramView);
    this.BIO.aAd();
    AppMethodBeat.o(85136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.15
 * JD-Core Version:    0.7.0.1
 */