package com.tencent.mm.plugin.product.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
    paramAdapterView = (b)paramView.getTag();
    switch (paramAdapterView.type)
    {
    }
    for (;;)
    {
      MallProductSubmitUI.c(this.mUW).a(this.mUW, paramView, paramInt);
      return;
      Object localObject = MallProductSubmitUI.b(this.mUW).mRP;
      if ((((m)localObject).mSu.mSI != null) && (((m)localObject).mSu.mSI.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((m)localObject).mSu.mSI.iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add((String)((Iterator)localObject).next());
        }
        paramAdapterView.mTs = localArrayList;
        continue;
        if ((paramAdapterView.mTs instanceof String)) {
          MallProductSubmitUI.b(this.mUW).mRY = ((String)paramAdapterView.mTs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSubmitUI.2
 * JD-Core Version:    0.7.0.1
 */