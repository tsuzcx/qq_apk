package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class MallProductSubmitUI$2
  implements AdapterView.OnItemClickListener
{
  MallProductSubmitUI$2(MallProductSubmitUI paramMallProductSubmitUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44140);
    paramAdapterView = (b)paramView.getTag();
    switch (paramAdapterView.type)
    {
    }
    for (;;)
    {
      MallProductSubmitUI.c(this.pxb).a(this.pxb, paramView, paramInt);
      AppMethodBeat.o(44140);
      return;
      Object localObject = MallProductSubmitUI.b(this.pxb).ptU;
      if ((((m)localObject).puA.puO != null) && (((m)localObject).puA.puO.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((m)localObject).puA.puO.iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((String)((Iterator)localObject).next());
        }
        paramAdapterView.pvy = localArrayList;
        continue;
        if ((paramAdapterView.pvy instanceof String)) {
          MallProductSubmitUI.b(this.pxb).puf = ((String)paramAdapterView.pvy);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.2
 * JD-Core Version:    0.7.0.1
 */