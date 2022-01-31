package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.model.m.a;
import com.tencent.mm.plugin.wallet_core.model.m.b;
import java.util.Vector;

final class j$2
  implements AdapterView.OnItemClickListener
{
  j$2(j paramj) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = j.b(this.qDx);
    paramView = paramAdapterView.qDB;
    if (paramInt < paramView.qwa.size())
    {
      m.a locala1 = ((m.b)paramView.qwa.get(paramInt)).qwi;
      m.a locala2 = m.a.qwe;
      switch (com.tencent.mm.plugin.wallet_core.model.m.1.qwc[locala1.ordinal()])
      {
      }
    }
    for (;;)
    {
      paramView.bVm();
      paramAdapterView.notifyDataSetChanged();
      return;
      paramView.a(paramInt, m.a.qwe);
      continue;
      paramView.a(paramInt, m.a.qwf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.j.2
 * JD-Core Version:    0.7.0.1
 */