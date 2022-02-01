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
import com.tencent.mm.sdk.platformtools.ad;
import junit.framework.Assert;

public abstract class b
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  protected SparseArray<a> JtT;
  protected Runnable JtU;
  protected Context mContext;
  
  public b(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null.");
    }
    this.mContext = paramContext;
    this.JtT = new SparseArray();
    this.JtU = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142686);
        b.this.notifyDataSetChanged();
        AppMethodBeat.o(142686);
      }
    };
  }
  
  public int getCount()
  {
    return this.JtT.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (zo(paramInt) != null)
    {
      if (zo(paramInt) == null) {
        return 0;
      }
      return zo(paramInt).type;
    }
    ad.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    a locala = zo(paramInt);
    if (locala == null)
    {
      ad.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
      return paramView;
    }
    long l2 = System.currentTimeMillis();
    a.b localb = locala.bNP();
    if (localb == null)
    {
      ad.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
      return paramView;
    }
    if (paramView == null)
    {
      paramView = localb.c(this.mContext, paramView);
      paramViewGroup = locala.bNQ();
      localb.a(paramView, paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object[] arrayOfObject = zl(paramInt);
      Assert.assertNotNull(paramViewGroup);
      if (!locala.fzK()) {
        locala.a(this.mContext, paramViewGroup, arrayOfObject);
      }
      long l3 = System.currentTimeMillis();
      localb.a(this.mContext, paramViewGroup, locala);
      ad.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
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
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    paramAdapterView = zo(paramInt);
    if (paramAdapterView == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    paramView = paramAdapterView.bNP();
    if (paramView == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    if (paramView.a(this.mContext, paramAdapterView, zl(paramInt)))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      return;
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/sortview/BaseMultiDataItemAdapter", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
  }
  
  protected abstract a zk(int paramInt);
  
  protected abstract Object[] zl(int paramInt);
  
  public a zo(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getCount()))
    {
      ad.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[] { Integer.valueOf(paramInt) });
      localObject = null;
    }
    a locala;
    do
    {
      return localObject;
      locala = (a)this.JtT.get(paramInt);
      localObject = locala;
    } while (locala != null);
    Object localObject = zk(paramInt);
    this.JtT.put(paramInt, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.b
 * JD-Core Version:    0.7.0.1
 */