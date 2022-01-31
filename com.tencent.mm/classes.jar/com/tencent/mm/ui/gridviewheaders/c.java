package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private static boolean AoB;
  final b AoC;
  private GridHeadersGridView AoD;
  private final List<View> AoE;
  private View[] AoF;
  private DataSetObserver Jv;
  private final Context mContext;
  int mCount;
  int mNumColumns;
  
  public c(Context paramContext, GridHeadersGridView paramGridHeadersGridView, b paramb)
  {
    AppMethodBeat.i(107342);
    this.Jv = new c.1(this);
    this.AoE = new ArrayList();
    this.mNumColumns = 1;
    this.mContext = paramContext;
    this.AoC = paramb;
    this.AoD = paramGridHeadersGridView;
    paramb.registerDataSetObserver(this.Jv);
    AppMethodBeat.o(107342);
  }
  
  private void QH(int paramInt)
  {
    AppMethodBeat.i(107355);
    this.AoF = new View[paramInt];
    Arrays.fill(this.AoF, null);
    AppMethodBeat.o(107355);
  }
  
  private int QI(int paramInt)
  {
    AppMethodBeat.i(107356);
    paramInt = this.AoC.QG(paramInt) % this.mNumColumns;
    if (paramInt == 0)
    {
      AppMethodBeat.o(107356);
      return 0;
    }
    int i = this.mNumColumns;
    AppMethodBeat.o(107356);
    return i - paramInt;
  }
  
  protected final c.c QJ(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(107359);
    int m = this.AoC.dNk();
    if (m == 0)
    {
      if (paramInt >= this.AoC.getCount())
      {
        localc = new c.c(this, -1, 0);
        AppMethodBeat.o(107359);
        return localc;
      }
      localc = new c.c(this, paramInt, 0);
      AppMethodBeat.o(107359);
      return localc;
    }
    int i = paramInt;
    int j = paramInt;
    paramInt = k;
    while (paramInt < m)
    {
      k = this.AoC.QG(paramInt);
      if (j == 0)
      {
        localc = new c.c(this, -2, paramInt);
        AppMethodBeat.o(107359);
        return localc;
      }
      j -= this.mNumColumns;
      if (j < 0)
      {
        localc = new c.c(this, -1, paramInt);
        AppMethodBeat.o(107359);
        return localc;
      }
      i -= this.mNumColumns;
      if (j < k)
      {
        localc = new c.c(this, i, paramInt);
        AppMethodBeat.o(107359);
        return localc;
      }
      int n = QI(paramInt);
      j -= k + n;
      paramInt += 1;
      i -= n;
    }
    c.c localc = new c.c(this, -1, paramInt);
    AppMethodBeat.o(107359);
    return localc;
  }
  
  protected final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107358);
    if (this.AoC.dNk() == 0)
    {
      AppMethodBeat.o(107358);
      return null;
    }
    paramView = this.AoC.a(QJ(paramInt).AoJ, paramView, paramViewGroup);
    AppMethodBeat.o(107358);
    return paramView;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(107343);
    this.mCount = 0;
    int j = this.AoC.dNk();
    if (j == 0)
    {
      i = this.AoC.getCount();
      AppMethodBeat.o(107343);
      return i;
    }
    while (i < j)
    {
      this.mCount += this.AoC.QG(i) + QI(i) + this.mNumColumns;
      i += 1;
    }
    i = this.mCount;
    AppMethodBeat.o(107343);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(107344);
    Object localObject = QJ(paramInt);
    if ((((c.c)localObject).mPosition == -1) || (((c.c)localObject).mPosition == -2))
    {
      AppMethodBeat.o(107344);
      return null;
    }
    localObject = this.AoC.getItem(((c.c)localObject).mPosition);
    AppMethodBeat.o(107344);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(107345);
    c.c localc = QJ(paramInt);
    if (localc.mPosition == -2)
    {
      AppMethodBeat.o(107345);
      return -1L;
    }
    if (localc.mPosition == -1)
    {
      AppMethodBeat.o(107345);
      return -2L;
    }
    long l = this.AoC.getItemId(localc.mPosition);
    AppMethodBeat.o(107345);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(107346);
    c.c localc = QJ(paramInt);
    if (localc.mPosition == -2)
    {
      AppMethodBeat.o(107346);
      return 1;
    }
    if (localc.mPosition == -1)
    {
      AppMethodBeat.o(107346);
      return 0;
    }
    paramInt = this.AoC.getItemViewType(localc.mPosition);
    if (paramInt == -1)
    {
      AppMethodBeat.o(107346);
      return paramInt;
    }
    AppMethodBeat.o(107346);
    return paramInt + 2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107347);
    Object localObject1;
    if ((paramView instanceof c.d))
    {
      paramView = (c.d)paramView;
      localObject1 = paramView.getChildAt(0);
    }
    for (;;)
    {
      Object localObject2 = QJ(paramInt);
      if (((c.c)localObject2).mPosition == -2)
      {
        localObject1 = new c.b(this, this.mContext);
        ((c.b)localObject1).setHeaderWidth(this.AoD.getWidth());
        ((c.b)localObject1).setHeaderId(((c.c)localObject2).AoJ);
        View localView = (View)((View)localObject1).getTag();
        ((View)localObject1).setTag(this.AoC.a(((c.c)localObject2).AoJ, localView, paramViewGroup));
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
        this.AoF[(paramInt % this.mNumColumns)] = localObject2;
        if (paramInt % this.mNumColumns != 0) {
          break label293;
        }
        AoB = true;
        int i = 1;
        while (i < this.AoF.length)
        {
          this.AoF[i] = getView(paramInt + i, null, paramViewGroup);
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
          localObject1 = this.AoC.getView(((c.c)localObject2).mPosition, (View)localObject1, paramViewGroup);
        }
      }
      AoB = false;
      label293:
      ((c.d)localObject2).setRowSiblings(this.AoF);
      if ((!AoB) && ((paramInt % this.mNumColumns == this.mNumColumns - 1) || (paramInt == getCount() - 1))) {
        QH(this.mNumColumns);
      }
      AppMethodBeat.o(107347);
      return localObject2;
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(107348);
    int i = this.AoC.getViewTypeCount();
    AppMethodBeat.o(107348);
    return i + 2;
  }
  
  public final boolean hasStableIds()
  {
    AppMethodBeat.i(107349);
    boolean bool = this.AoC.hasStableIds();
    AppMethodBeat.o(107349);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(107350);
    boolean bool = this.AoC.isEmpty();
    AppMethodBeat.o(107350);
    return bool;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(107351);
    c.c localc = QJ(paramInt);
    if ((localc.mPosition == -1) || (localc.mPosition == -2))
    {
      AppMethodBeat.o(107351);
      return false;
    }
    boolean bool = this.AoC.isEnabled(localc.mPosition);
    AppMethodBeat.o(107351);
    return bool;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(107352);
    this.AoC.registerDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(107352);
  }
  
  public final void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(107353);
    this.mNumColumns = paramInt;
    QH(paramInt);
    AppMethodBeat.o(107353);
  }
  
  protected final long tC(int paramInt)
  {
    AppMethodBeat.i(107357);
    long l = QJ(paramInt).AoJ;
    AppMethodBeat.o(107357);
    return l;
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(107354);
    this.AoC.unregisterDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(107354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c
 * JD-Core Version:    0.7.0.1
 */