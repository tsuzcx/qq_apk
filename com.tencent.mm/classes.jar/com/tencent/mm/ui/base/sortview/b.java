package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.ab;
import junit.framework.Assert;

public abstract class b
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  protected Context mContext;
  protected SparseArray<a> zsw;
  protected Runnable zsx;
  
  public b(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null.");
    }
    this.mContext = paramContext;
    this.zsw = new SparseArray();
    this.zsx = new b.1(this);
  }
  
  public int getCount()
  {
    return this.zsw.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (sc(paramInt) != null)
    {
      if (sc(paramInt) == null) {
        return 0;
      }
      return sc(paramInt).type;
    }
    ab.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    a locala = sc(paramInt);
    if (locala == null)
    {
      ab.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
      return paramView;
    }
    long l2 = System.currentTimeMillis();
    a.b localb = locala.aWu();
    if (localb == null)
    {
      ab.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
      return paramView;
    }
    if (paramView == null)
    {
      paramView = localb.c(this.mContext, paramView);
      paramViewGroup = locala.aWv();
      localb.a(paramView, paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object[] arrayOfObject = sa(paramInt);
      Assert.assertNotNull(paramViewGroup);
      if (!locala.dER()) {
        locala.a(this.mContext, paramViewGroup, arrayOfObject);
      }
      long l3 = System.currentTimeMillis();
      localb.a(this.mContext, paramViewGroup, locala);
      ab.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
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
    paramAdapterView = sc(paramInt);
    if (paramAdapterView == null) {}
    do
    {
      return;
      paramView = paramAdapterView.aWu();
    } while ((paramView == null) || (!paramView.a(this.mContext, paramAdapterView, sa(paramInt))));
  }
  
  protected abstract a rZ(int paramInt);
  
  protected abstract Object[] sa(int paramInt);
  
  public a sc(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getCount()))
    {
      ab.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[] { Integer.valueOf(paramInt) });
      localObject = null;
    }
    a locala;
    do
    {
      return localObject;
      locala = (a)this.zsw.get(paramInt);
      localObject = locala;
    } while (locala != null);
    Object localObject = rZ(paramInt);
    this.zsw.put(paramInt, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.b
 * JD-Core Version:    0.7.0.1
 */