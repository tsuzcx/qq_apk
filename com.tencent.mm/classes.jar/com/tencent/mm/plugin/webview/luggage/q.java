package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.f;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.LinkedList;
import java.util.Set;

public class q
  extends f
{
  private com.tencent.mm.plugin.webview.modeltools.a uSO;
  
  public q(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(6225);
    this.byN = com.tencent.mm.plugin.webview.luggage.d.a.class;
    this.byQ.z(bj.bjM());
    this.uSO = new com.tencent.mm.plugin.webview.modeltools.a();
    com.tencent.luggage.g.e locale = this.byV.up();
    paramActivity = new q.1(this, paramActivity);
    locale.bFA.add(paramActivity);
    AppMethodBeat.o(6225);
  }
  
  private void dbv()
  {
    AppMethodBeat.i(6227);
    if ((this.mContext instanceof MMActivity))
    {
      SwipeBackLayout localSwipeBackLayout = ((MMActivity)this.mContext).getSwipeBackLayout();
      if (localSwipeBackLayout != null)
      {
        if (this.byV.um().size() <= 1)
        {
          localSwipeBackLayout.setEnableGesture(true);
          AppMethodBeat.o(6227);
          return;
        }
        localSwipeBackLayout.setEnableGesture(false);
      }
    }
    AppMethodBeat.o(6227);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(6226);
    super.onResume();
    dbv();
    AppMethodBeat.o(6226);
  }
  
  public final void uk()
  {
    AppMethodBeat.i(6228);
    ((e)uf()).daR();
    dbv();
    AppMethodBeat.o(6228);
  }
  
  public final void ul()
  {
    AppMethodBeat.i(6229);
    dbv();
    AppMethodBeat.o(6229);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.q
 * JD-Core Version:    0.7.0.1
 */