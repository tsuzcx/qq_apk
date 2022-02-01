package com.tencent.mm.ui.gridviewheaders;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c
  extends BaseAdapter
{
  private static boolean IJq;
  final b IJr;
  private GridHeadersGridView IJs;
  private final List<View> IJt;
  private View[] IJu;
  private DataSetObserver Rq;
  private final Context mContext;
  int mCount;
  int mNumColumns;
  
  public c(Context paramContext, GridHeadersGridView paramGridHeadersGridView, b paramb)
  {
    AppMethodBeat.i(142775);
    this.Rq = new DataSetObserver()
    {
      public final void onChanged()
      {
        int i = 0;
        AppMethodBeat.i(142759);
        c localc = c.this;
        localc.mCount = 0;
        int j = localc.IJr.fsT();
        if (j == 0) {
          localc.mCount = localc.IJr.getCount();
        }
        for (;;)
        {
          c.this.notifyDataSetChanged();
          AppMethodBeat.o(142759);
          return;
          while (i < j)
          {
            localc.mCount += localc.IJr.ack(i) + localc.mNumColumns;
            i += 1;
          }
        }
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(142760);
        c.a(c.this).clear();
        c.this.notifyDataSetInvalidated();
        AppMethodBeat.o(142760);
      }
    };
    this.IJt = new ArrayList();
    this.mNumColumns = 1;
    this.mContext = paramContext;
    this.IJr = paramb;
    this.IJs = paramGridHeadersGridView;
    paramb.registerDataSetObserver(this.Rq);
    AppMethodBeat.o(142775);
  }
  
  private void acl(int paramInt)
  {
    AppMethodBeat.i(142788);
    this.IJu = new View[paramInt];
    Arrays.fill(this.IJu, null);
    AppMethodBeat.o(142788);
  }
  
  private int acm(int paramInt)
  {
    AppMethodBeat.i(142789);
    paramInt = this.IJr.ack(paramInt) % this.mNumColumns;
    if (paramInt == 0)
    {
      AppMethodBeat.o(142789);
      return 0;
    }
    int i = this.mNumColumns;
    AppMethodBeat.o(142789);
    return i - paramInt;
  }
  
  protected final long An(int paramInt)
  {
    AppMethodBeat.i(142790);
    long l = acn(paramInt).IJy;
    AppMethodBeat.o(142790);
    return l;
  }
  
  protected final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142791);
    if (this.IJr.fsT() == 0)
    {
      AppMethodBeat.o(142791);
      return null;
    }
    paramView = this.IJr.a(acn(paramInt).IJy, paramView, paramViewGroup);
    AppMethodBeat.o(142791);
    return paramView;
  }
  
  protected final c acn(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(142792);
    int m = this.IJr.fsT();
    if (m == 0)
    {
      if (paramInt >= this.IJr.getCount())
      {
        localc = new c(-1, 0);
        AppMethodBeat.o(142792);
        return localc;
      }
      localc = new c(paramInt, 0);
      AppMethodBeat.o(142792);
      return localc;
    }
    int i = paramInt;
    int j = paramInt;
    paramInt = k;
    while (paramInt < m)
    {
      k = this.IJr.ack(paramInt);
      if (j == 0)
      {
        localc = new c(-2, paramInt);
        AppMethodBeat.o(142792);
        return localc;
      }
      j -= this.mNumColumns;
      if (j < 0)
      {
        localc = new c(-1, paramInt);
        AppMethodBeat.o(142792);
        return localc;
      }
      i -= this.mNumColumns;
      if (j < k)
      {
        localc = new c(i, paramInt);
        AppMethodBeat.o(142792);
        return localc;
      }
      int n = acm(paramInt);
      j -= k + n;
      paramInt += 1;
      i -= n;
    }
    c localc = new c(-1, paramInt);
    AppMethodBeat.o(142792);
    return localc;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(142776);
    this.mCount = 0;
    int j = this.IJr.fsT();
    if (j == 0)
    {
      i = this.IJr.getCount();
      AppMethodBeat.o(142776);
      return i;
    }
    while (i < j)
    {
      this.mCount += this.IJr.ack(i) + acm(i) + this.mNumColumns;
      i += 1;
    }
    i = this.mCount;
    AppMethodBeat.o(142776);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(142777);
    Object localObject = acn(paramInt);
    if ((((c)localObject).mPosition == -1) || (((c)localObject).mPosition == -2))
    {
      AppMethodBeat.o(142777);
      return null;
    }
    localObject = this.IJr.getItem(((c)localObject).mPosition);
    AppMethodBeat.o(142777);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(142778);
    c localc = acn(paramInt);
    if (localc.mPosition == -2)
    {
      AppMethodBeat.o(142778);
      return -1L;
    }
    if (localc.mPosition == -1)
    {
      AppMethodBeat.o(142778);
      return -2L;
    }
    long l = this.IJr.getItemId(localc.mPosition);
    AppMethodBeat.o(142778);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(142779);
    c localc = acn(paramInt);
    if (localc.mPosition == -2)
    {
      AppMethodBeat.o(142779);
      return 1;
    }
    if (localc.mPosition == -1)
    {
      AppMethodBeat.o(142779);
      return 0;
    }
    paramInt = this.IJr.getItemViewType(localc.mPosition);
    if (paramInt == -1)
    {
      AppMethodBeat.o(142779);
      return paramInt;
    }
    AppMethodBeat.o(142779);
    return paramInt + 2;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142780);
    Object localObject1;
    if ((paramView instanceof d))
    {
      paramView = (d)paramView;
      localObject1 = paramView.getChildAt(0);
    }
    for (;;)
    {
      Object localObject2 = acn(paramInt);
      if (((c)localObject2).mPosition == -2)
      {
        localObject1 = new b(this.mContext);
        ((b)localObject1).setHeaderWidth(this.IJs.getWidth());
        ((b)localObject1).setHeaderId(((c)localObject2).IJy);
        View localView = (View)((View)localObject1).getTag();
        ((View)localObject1).setTag(this.IJr.a(((c)localObject2).IJy, localView, paramViewGroup));
      }
      for (;;)
      {
        localObject2 = paramView;
        if (paramView == null) {
          localObject2 = new d(this.mContext);
        }
        ((d)localObject2).removeAllViews();
        ((d)localObject2).addView((View)localObject1);
        ((d)localObject2).setPosition(paramInt);
        ((d)localObject2).setNumColumns(this.mNumColumns);
        this.IJu[(paramInt % this.mNumColumns)] = localObject2;
        if (paramInt % this.mNumColumns != 0) {
          break label293;
        }
        IJq = true;
        int i = 1;
        while (i < this.IJu.length)
        {
          this.IJu[i] = getView(paramInt + i, null, paramViewGroup);
          i += 1;
        }
        if (((c)localObject2).mPosition == -1)
        {
          localObject2 = (a)localObject1;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new a(this.mContext);
          }
        }
        else
        {
          localObject1 = this.IJr.getView(((c)localObject2).mPosition, (View)localObject1, paramViewGroup);
        }
      }
      IJq = false;
      label293:
      ((d)localObject2).setRowSiblings(this.IJu);
      if ((!IJq) && ((paramInt % this.mNumColumns == this.mNumColumns - 1) || (paramInt == getCount() - 1))) {
        acl(this.mNumColumns);
      }
      AppMethodBeat.o(142780);
      return localObject2;
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
  }
  
  public final int getViewTypeCount()
  {
    AppMethodBeat.i(142781);
    int i = this.IJr.getViewTypeCount();
    AppMethodBeat.o(142781);
    return i + 2;
  }
  
  public final boolean hasStableIds()
  {
    AppMethodBeat.i(142782);
    boolean bool = this.IJr.hasStableIds();
    AppMethodBeat.o(142782);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(142783);
    boolean bool = this.IJr.isEmpty();
    AppMethodBeat.o(142783);
    return bool;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(142784);
    c localc = acn(paramInt);
    if ((localc.mPosition == -1) || (localc.mPosition == -2))
    {
      AppMethodBeat.o(142784);
      return false;
    }
    boolean bool = this.IJr.isEnabled(localc.mPosition);
    AppMethodBeat.o(142784);
    return bool;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(142785);
    this.IJr.registerDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(142785);
  }
  
  public final void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142786);
    this.mNumColumns = paramInt;
    acl(paramInt);
    AppMethodBeat.o(142786);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(142787);
    this.IJr.unregisterDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(142787);
  }
  
  protected final class a
    extends View
  {
    public a(Context paramContext)
    {
      super();
    }
  }
  
  protected final class b
    extends FrameLayout
  {
    private int IJw;
    private int IJx;
    
    public b(Context paramContext)
    {
      super();
    }
    
    protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
    {
      AppMethodBeat.i(142763);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      AppMethodBeat.o(142763);
      return localLayoutParams;
    }
    
    public final int getHeaderId()
    {
      return this.IJw;
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(142762);
      View localView = (View)getTag();
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(generateDefaultLayoutParams());
      }
      if ((localView.getVisibility() != 8) && (localView.getMeasuredHeight() == 0)) {
        localView.measure(View.MeasureSpec.makeMeasureSpec(this.IJx, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      }
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), localView.getMeasuredHeight());
      AppMethodBeat.o(142762);
    }
    
    public final void setHeaderId(int paramInt)
    {
      this.IJw = paramInt;
    }
    
    public final void setHeaderWidth(int paramInt)
    {
      this.IJx = paramInt;
    }
  }
  
  protected final class c
  {
    protected int IJy;
    protected int mPosition;
    
    protected c(int paramInt1, int paramInt2)
    {
      this.mPosition = paramInt1;
      this.IJy = paramInt2;
    }
  }
  
  protected final class d
    extends FrameLayout
  {
    private View[] IJu;
    private boolean IJz;
    private int mNumColumns;
    private int mPosition;
    
    public d(Context paramContext)
    {
      super();
    }
    
    protected final FrameLayout.LayoutParams generateDefaultLayoutParams()
    {
      AppMethodBeat.i(142771);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      AppMethodBeat.o(142771);
      return localLayoutParams;
    }
    
    public final Object getTag()
    {
      AppMethodBeat.i(142766);
      Object localObject = getChildAt(0).getTag();
      AppMethodBeat.o(142766);
      return localObject;
    }
    
    public final Object getTag(int paramInt)
    {
      AppMethodBeat.i(142767);
      Object localObject = getChildAt(0).getTag(paramInt);
      AppMethodBeat.o(142767);
      return localObject;
    }
    
    public final View getView()
    {
      AppMethodBeat.i(142768);
      View localView = getChildAt(0);
      AppMethodBeat.o(142768);
      return localView;
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      int j = 0;
      AppMethodBeat.i(142772);
      super.onMeasure(paramInt1, paramInt2);
      if ((this.mNumColumns == 1) || (c.b(c.this) == null))
      {
        AppMethodBeat.o(142772);
        return;
      }
      if ((this.mPosition % this.mNumColumns == 0) && (!this.IJz))
      {
        this.IJz = true;
        arrayOfView = this.IJu;
        k = arrayOfView.length;
        i = 0;
        while (i < k)
        {
          arrayOfView[i].measure(paramInt1, paramInt2);
          i += 1;
        }
        this.IJz = false;
      }
      int k = getMeasuredHeight();
      View[] arrayOfView = this.IJu;
      int m = arrayOfView.length;
      int i = k;
      paramInt2 = j;
      while (paramInt2 < m)
      {
        View localView = arrayOfView[paramInt2];
        j = i;
        if (localView != null) {
          j = Math.max(i, localView.getMeasuredHeight());
        }
        paramInt2 += 1;
        i = j;
      }
      if (i == k)
      {
        AppMethodBeat.o(142772);
        return;
      }
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(i, 1073741824));
      AppMethodBeat.o(142772);
    }
    
    public final void setNumColumns(int paramInt)
    {
      this.mNumColumns = paramInt;
    }
    
    public final void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
    
    @SuppressLint({"NewApi"})
    public final void setRowSiblings(View[] paramArrayOfView)
    {
      this.IJu = paramArrayOfView;
    }
    
    public final void setTag(int paramInt, Object paramObject)
    {
      AppMethodBeat.i(142769);
      getChildAt(0).setTag(paramInt, paramObject);
      AppMethodBeat.o(142769);
    }
    
    public final void setTag(Object paramObject)
    {
      AppMethodBeat.i(142770);
      getChildAt(0).setTag(paramObject);
      AppMethodBeat.o(142770);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c
 * JD-Core Version:    0.7.0.1
 */