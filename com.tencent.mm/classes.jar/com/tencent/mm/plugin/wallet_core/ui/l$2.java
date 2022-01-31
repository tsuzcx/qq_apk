package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.model.r.a;
import com.tencent.mm.plugin.wallet_core.model.r.b;
import java.util.Vector;

final class l$2
  implements AdapterView.OnItemClickListener
{
  l$2(l paraml) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(47378);
    paramAdapterView = l.b(this.uqs);
    paramView = paramAdapterView.uqw;
    if (paramInt < paramView.uiz.size())
    {
      r.a locala1 = ((r.b)paramView.uiz.get(paramInt)).uiH;
      r.a locala2 = r.a.uiD;
      int i = 0;
      while (i < paramView.uiz.size())
      {
        paramView.a(i, r.a.uiE);
        i += 1;
      }
      switch (com.tencent.mm.plugin.wallet_core.model.r.1.uiB[locala1.ordinal()])
      {
      }
    }
    for (;;)
    {
      paramAdapterView.notifyDataSetChanged();
      AppMethodBeat.o(47378);
      return;
      paramView.a(paramInt, r.a.uiD);
      continue;
      paramView.a(paramInt, r.a.uiE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.l.2
 * JD-Core Version:    0.7.0.1
 */