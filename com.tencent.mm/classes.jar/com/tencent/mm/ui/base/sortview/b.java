package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import junit.framework.Assert;

public abstract class b
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  private SparseArray<a> aeav;
  private Runnable aeaw;
  protected Context mContext;
  
  public b(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null.");
    }
    this.mContext = paramContext;
    this.aeav = new SparseArray();
    this.aeaw = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142686);
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(142686);
      }
    };
  }
  
  protected abstract a Hd(int paramInt);
  
  protected abstract Object[] He(int paramInt);
  
  public a Hh(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getCount()))
    {
      Log.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[] { Integer.valueOf(paramInt) });
      localObject = null;
    }
    a locala;
    do
    {
      return localObject;
      locala = (a)this.aeav.get(paramInt);
      localObject = locala;
    } while (locala != null);
    Object localObject = Hd(paramInt);
    this.aeav.put(paramInt, localObject);
    return localObject;
  }
  
  public final void bDL()
  {
    MMHandlerThread.postToMainThread(this.aeaw);
  }
  
  public final void clearData()
  {
    this.aeav.clear();
    MMHandlerThread.postToMainThread(this.aeaw);
  }
  
  public int getCount()
  {
    return this.aeav.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (Hh(paramInt) != null)
    {
      if (Hh(paramInt) == null) {
        return 0;
      }
      return Hh(paramInt).type;
    }
    Log.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    a locala = Hh(paramInt);
    if (locala == null)
    {
      Log.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
      return paramView;
    }
    long l2 = System.currentTimeMillis();
    a.b localb = locala.dco();
    if (localb == null)
    {
      Log.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
      return paramView;
    }
    if (paramView == null)
    {
      paramView = localb.c(this.mContext, paramView);
      paramViewGroup = locala.dcp();
      localb.a(paramView, paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object[] arrayOfObject = He(paramInt);
      Assert.assertNotNull(paramViewGroup);
      if (!locala.jnF()) {
        locala.a(this.mContext, paramViewGroup, arrayOfObject);
      }
      long l3 = System.currentTimeMillis();
      localb.a(this.mContext, paramViewGroup, locala);
      Log.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
      return paramView;
      paramViewGroup = (a.a)paramView.getTag();
    }
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    paramAdapterView = Hh(paramInt);
    if (paramAdapterView == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    paramView = paramAdapterView.dco();
    if (paramView == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    if (paramView.a(this.mContext, paramAdapterView, He(paramInt)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.b
 * JD-Core Version:    0.7.0.1
 */