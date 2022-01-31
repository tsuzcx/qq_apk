package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.product.b.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

final class MallProductUI$3
  implements AdapterView.OnItemClickListener
{
  MallProductUI$3(MallProductUI paramMallProductUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(44159);
    paramAdapterView = (b)paramView.getTag();
    switch (paramAdapterView.type)
    {
    }
    for (;;)
    {
      MallProductUI.f(this.pxl).a(this.pxl, paramView, paramInt);
      AppMethodBeat.o(44159);
      return;
      Object localObject = this.pxl.pvR.ptU;
      if ((((m)localObject).puA.puO != null) && (((m)localObject).puA.puO.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((m)localObject).puA.puO.iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((String)((Iterator)localObject).next());
        }
        paramAdapterView.pvy = localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.3
 * JD-Core Version:    0.7.0.1
 */