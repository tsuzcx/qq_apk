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
import com.tencent.mm.sdk.platformtools.ac;
import junit.framework.Assert;

public abstract class b
  extends BaseAdapter
  implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  protected SparseArray<a> HGc;
  protected Runnable HGd;
  protected Context mContext;
  
  public b(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException("context is null.");
    }
    this.mContext = paramContext;
    this.HGc = new SparseArray();
    this.HGd = new Runnable()
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
    return this.HGc.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (yE(paramInt) != null)
    {
      if (yE(paramInt) == null) {
        return 0;
      }
      return yE(paramInt).type;
    }
    ac.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    long l1 = System.currentTimeMillis();
    a locala = yE(paramInt);
    if (locala == null)
    {
      ac.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
      return paramView;
    }
    long l2 = System.currentTimeMillis();
    a.b localb = locala.bJw();
    if (localb == null)
    {
      ac.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
      return paramView;
    }
    if (paramView == null)
    {
      paramView = localb.c(this.mContext, paramView);
      paramViewGroup = locala.bJx();
      localb.a(paramView, paramViewGroup);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object[] arrayOfObject = yB(paramInt);
      Assert.assertNotNull(paramViewGroup);
      if (!locala.fjv()) {
        locala.a(this.mContext, paramViewGroup, arrayOfObject);
      }
      long l3 = System.currentTimeMillis();
      localb.a(this.mContext, paramViewGroup, locala);
      ac.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
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
    paramAdapterView = yE(paramInt);
    if (paramAdapterView == null) {}
    do
    {
      return;
      paramView = paramAdapterView.bJw();
    } while ((paramView == null) || (!paramView.a(this.mContext, paramAdapterView, yB(paramInt))));
  }
  
  protected abstract a yA(int paramInt);
  
  protected abstract Object[] yB(int paramInt);
  
  public a yE(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > getCount()))
    {
      ac.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[] { Integer.valueOf(paramInt) });
      localObject = null;
    }
    a locala;
    do
    {
      return localObject;
      locala = (a)this.HGc.get(paramInt);
      localObject = locala;
    } while (locala != null);
    Object localObject = yA(paramInt);
    this.HGc.put(paramInt, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.b
 * JD-Core Version:    0.7.0.1
 */