package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.y;
import junit.framework.Assert;

public abstract class b
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  protected Context mContext;
  public SparseArray<a> vdW;
  public Runnable vdX;
  
  public b(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null.");
    }
    this.mContext = paramContext;
    this.vdW = new SparseArray();
    this.vdX = new b.1(this);
  }
  
  public int getCount()
  {
    return this.vdW.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (ow(paramInt) != null)
    {
      if (ow(paramInt) == null) {
        return 0;
      }
      return ow(paramInt).type;
    }
    y.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    a locala = ow(paramInt);
    if (locala == null)
    {
      y.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
      return paramView;
    }
    long l2 = System.currentTimeMillis();
    a.b localb = locala.axw();
    if (localb == null)
    {
      y.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
      return paramView;
    }
    if (paramView == null)
    {
      paramView = localb.b(this.mContext, paramView);
      paramViewGroup = locala.axx();
      localb.a(paramView, paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object[] arrayOfObject = ou(paramInt);
      Assert.assertNotNull(paramViewGroup);
      if (!locala.vdV) {
        locala.a(this.mContext, paramViewGroup, arrayOfObject);
      }
      long l3 = System.currentTimeMillis();
      localb.a(this.mContext, paramViewGroup, locala);
      y.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
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
    paramAdapterView = ow(paramInt);
    if (paramAdapterView == null) {}
    do
    {
      return;
      paramView = paramAdapterView.axw();
    } while ((paramView == null) || (!paramView.a(this.mContext, paramAdapterView, ou(paramInt))));
  }
  
  public abstract a ot(int paramInt);
  
  public abstract Object[] ou(int paramInt);
  
  public a ow(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getCount()))
    {
      y.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[] { Integer.valueOf(paramInt) });
      localObject = null;
    }
    a locala;
    do
    {
      return localObject;
      locala = (a)this.vdW.get(paramInt);
      localObject = locala;
    } while (locala != null);
    Object localObject = ot(paramInt);
    this.vdW.put(paramInt, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.b
 * JD-Core Version:    0.7.0.1
 */