package com.tencent.mm.plugin.search.ui;

import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import java.util.Iterator;
import java.util.List;

final class FTSInfoUI$3
  implements View.OnClickListener
{
  FTSInfoUI$3(FTSInfoUI paramFTSInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(28075);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    int i = ((Integer)paramView.getTag()).intValue();
    if (i == 1)
    {
      paramView = (com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class);
      FTSInfoUI.dCy();
      paramView = paramView.ccQ();
    }
    for (;;)
    {
      localObject = new StringBuffer();
      paramView = paramView.iterator();
      while (paramView.hasNext())
      {
        Pair localPair = (Pair)paramView.next();
        ((StringBuffer)localObject).append("[");
        ((StringBuffer)localObject).append(((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP((String)localPair.first));
        ((StringBuffer)localObject).append("]\n");
        ((StringBuffer)localObject).append((String)localPair.second);
        ((StringBuffer)localObject).append("\n");
      }
      if (i == 2)
      {
        paramView = ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).ue(FTSInfoUI.dCy());
      }
      else
      {
        if (i != 3) {
          break;
        }
        paramView = ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).ud(FTSInfoUI.dCy());
      }
    }
    a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28075);
    return;
    FTSInfoUI.b(this.yRB).setText(((StringBuffer)localObject).toString());
    a.a(this, "com/tencent/mm/plugin/search/ui/FTSInfoUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(28075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.FTSInfoUI.3
 * JD-Core Version:    0.7.0.1
 */