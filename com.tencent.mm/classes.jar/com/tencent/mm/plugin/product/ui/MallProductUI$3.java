package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
    paramAdapterView = (b)paramView.getTag();
    switch (paramAdapterView.type)
    {
    }
    for (;;)
    {
      MallProductUI.f(this.mVg).a(this.mVg, paramView, paramInt);
      return;
      Object localObject = this.mVg.mTL.mRP;
      if ((((m)localObject).mSu.mSI != null) && (((m)localObject).mSu.mSI.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((m)localObject).mSu.mSI.iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((String)((Iterator)localObject).next());
        }
        paramAdapterView.mTs = localArrayList;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductUI.3
 * JD-Core Version:    0.7.0.1
 */