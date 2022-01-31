package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private static boolean vWt;
  private DataSetObserver JP = new c.1(this);
  private final Context mContext;
  int mCount;
  int mNumColumns = 1;
  final b vWu;
  private GridHeadersGridView vWv;
  private final List<View> vWw = new ArrayList();
  private View[] vWx;
  
  public c(Context paramContext, GridHeadersGridView paramGridHeadersGridView, b paramb)
  {
    this.mContext = paramContext;
    this.vWu = paramb;
    this.vWv = paramGridHeadersGridView;
    paramb.registerDataSetObserver(this.JP);
  }
  
  private void HV(int paramInt)
  {
    this.vWx = new View[paramInt];
    Arrays.fill(this.vWx, null);
  }
  
  private int HW(int paramInt)
  {
    paramInt = this.vWu.HU(paramInt) % this.mNumColumns;
    if (paramInt == 0) {
      return 0;
    }
    return this.mNumColumns - paramInt;
  }
  
  protected final c.c HX(int paramInt)
  {
    int k = 0;
    int m = this.vWu.cIA();
    if (m == 0)
    {
      if (paramInt >= this.vWu.getCount()) {
        return new c.c(this, -1, 0);
      }
      return new c.c(this, paramInt, 0);
    }
    int i = paramInt;
    int j = paramInt;
    paramInt = k;
    while (paramInt < m)
    {
      k = this.vWu.HU(paramInt);
      if (j == 0) {
        return new c.c(this, -2, paramInt);
      }
      j -= this.mNumColumns;
      if (j < 0) {
        return new c.c(this, -1, paramInt);
      }
      i -= this.mNumColumns;
      if (j < k) {
        return new c.c(this, i, paramInt);
      }
      int n = HW(paramInt);
      j -= k + n;
      paramInt += 1;
      i -= n;
    }
    return new c.c(this, -1, paramInt);
  }
  
  protected final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.vWu.cIA() == 0) {
      return null;
    }
    return this.vWu.a(HX(paramInt).vWB, paramView, paramViewGroup);
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final int getCount()
  {
    int i = 0;
    this.mCount = 0;
    int j = this.vWu.cIA();
    if (j == 0) {
      return this.vWu.getCount();
    }
    while (i < j)
    {
      this.mCount += this.vWu.HU(i) + HW(i) + this.mNumColumns;
      i += 1;
    }
    return this.mCount;
  }
  
  public final Object getItem(int paramInt)
  {
    c.c localc = HX(paramInt);
    if ((localc.mPosition == -1) || (localc.mPosition == -2)) {
      return null;
    }
    return this.vWu.getItem(localc.mPosition);
  }
  
  public final long getItemId(int paramInt)
  {
    c.c localc = HX(paramInt);
    if (localc.mPosition == -2) {
      return -1L;
    }
    if (localc.mPosition == -1) {
      return -2L;
    }
    return this.vWu.getItemId(localc.mPosition);
  }
  
  public final int getItemViewType(int paramInt)
  {
    c.c localc = HX(paramInt);
    if (localc.mPosition == -2) {
      paramInt = 1;
    }
    int i;
    do
    {
      return paramInt;
      if (localc.mPosition == -1) {
        return 0;
      }
      i = this.vWu.getItemViewType(localc.mPosition);
      paramInt = i;
    } while (i == -1);
    return i + 2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if ((paramView instanceof c.d))
    {
      paramView = (c.d)paramView;
      localObject1 = paramView.getChildAt(0);
    }
    for (;;)
    {
      Object localObject2 = HX(paramInt);
      if (((c.c)localObject2).mPosition == -2)
      {
        localObject1 = new c.b(this, this.mContext);
        ((c.b)localObject1).setHeaderWidth(this.vWv.getWidth());
        ((c.b)localObject1).setHeaderId(((c.c)localObject2).vWB);
        View localView = (View)((View)localObject1).getTag();
        ((View)localObject1).setTag(this.vWu.a(((c.c)localObject2).vWB, localView, paramViewGroup));
      }
      for (;;)
      {
        localObject2 = paramView;
        if (paramView == null) {
          localObject2 = new c.d(this, this.mContext);
        }
        ((c.d)localObject2).removeAllViews();
        ((c.d)localObject2).addView((View)localObject1);
        ((c.d)localObject2).setPosition(paramInt);
        ((c.d)localObject2).setNumColumns(this.mNumColumns);
        this.vWx[(paramInt % this.mNumColumns)] = localObject2;
        if (paramInt % this.mNumColumns != 0) {
          break label288;
        }
        vWt = true;
        int i = 1;
        while (i < this.vWx.length)
        {
          this.vWx[i] = getView(paramInt + i, null, paramViewGroup);
          i += 1;
        }
        if (((c.c)localObject2).mPosition == -1)
        {
          localObject2 = (c.a)localObject1;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new c.a(this, this.mContext);
          }
        }
        else
        {
          localObject1 = this.vWu.getView(((c.c)localObject2).mPosition, (View)localObject1, paramViewGroup);
        }
      }
      vWt = false;
      label288:
      ((c.d)localObject2).setRowSiblings(this.vWx);
      if ((!vWt) && ((paramInt % this.mNumColumns == this.mNumColumns - 1) || (paramInt == getCount() - 1))) {
        HV(this.mNumColumns);
      }
      return localObject2;
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public final int getViewTypeCount()
  {
    return this.vWu.getViewTypeCount() + 2;
  }
  
  public final boolean hasStableIds()
  {
    return this.vWu.hasStableIds();
  }
  
  public final boolean isEmpty()
  {
    return this.vWu.isEmpty();
  }
  
  public final boolean isEnabled(int paramInt)
  {
    c.c localc = HX(paramInt);
    if ((localc.mPosition == -1) || (localc.mPosition == -2)) {
      return false;
    }
    return this.vWu.isEnabled(localc.mPosition);
  }
  
  protected final long pm(int paramInt)
  {
    return HX(paramInt).vWB;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.vWu.registerDataSetObserver(paramDataSetObserver);
  }
  
  public final void setNumColumns(int paramInt)
  {
    this.mNumColumns = paramInt;
    HV(paramInt);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.vWu.unregisterDataSetObserver(paramDataSetObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c
 * JD-Core Version:    0.7.0.1
 */