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
  private static boolean XHD;
  private DataSetObserver QT;
  final b XHE;
  private GridHeadersGridView XHF;
  private final List<View> XHG;
  private View[] XHH;
  private final Context mContext;
  int mCount;
  int mNumColumns;
  
  public c(Context paramContext, GridHeadersGridView paramGridHeadersGridView, b paramb)
  {
    AppMethodBeat.i(142775);
    this.QT = new DataSetObserver()
    {
      public final void onChanged()
      {
        int i = 0;
        AppMethodBeat.i(142759);
        c localc = c.this;
        localc.mCount = 0;
        int j = localc.XHE.hXa();
        if (j == 0) {
          localc.mCount = localc.XHE.getCount();
        }
        for (;;)
        {
          c.this.notifyDataSetChanged();
          AppMethodBeat.o(142759);
          return;
          while (i < j)
          {
            localc.mCount += localc.XHE.axg(i) + localc.mNumColumns;
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
    this.XHG = new ArrayList();
    this.mNumColumns = 1;
    this.mContext = paramContext;
    this.XHE = paramb;
    this.XHF = paramGridHeadersGridView;
    paramb.registerDataSetObserver(this.QT);
    AppMethodBeat.o(142775);
  }
  
  private void axh(int paramInt)
  {
    AppMethodBeat.i(142788);
    this.XHH = new View[paramInt];
    Arrays.fill(this.XHH, null);
    AppMethodBeat.o(142788);
  }
  
  private int axi(int paramInt)
  {
    AppMethodBeat.i(142789);
    paramInt = this.XHE.axg(paramInt) % this.mNumColumns;
    if (paramInt == 0)
    {
      AppMethodBeat.o(142789);
      return 0;
    }
    int i = this.mNumColumns;
    AppMethodBeat.o(142789);
    return i - paramInt;
  }
  
  protected final long Ix(int paramInt)
  {
    AppMethodBeat.i(142790);
    long l = axj(paramInt).XHL;
    AppMethodBeat.o(142790);
    return l;
  }
  
  protected final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142791);
    if (this.XHE.hXa() == 0)
    {
      AppMethodBeat.o(142791);
      return null;
    }
    paramView = this.XHE.a(axj(paramInt).XHL, paramView, paramViewGroup);
    AppMethodBeat.o(142791);
    return paramView;
  }
  
  public final boolean areAllItemsEnabled()
  {
    return false;
  }
  
  protected final c axj(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(142792);
    int m = this.XHE.hXa();
    if (m == 0)
    {
      if (paramInt >= this.XHE.getCount())
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
      k = this.XHE.axg(paramInt);
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
      int n = axi(paramInt);
      j -= k + n;
      paramInt += 1;
      i -= n;
    }
    c localc = new c(-1, paramInt);
    AppMethodBeat.o(142792);
    return localc;
  }
  
  public final int getCount()
  {
    int i = 0;
    AppMethodBeat.i(142776);
    this.mCount = 0;
    int j = this.XHE.hXa();
    if (j == 0)
    {
      i = this.XHE.getCount();
      AppMethodBeat.o(142776);
      return i;
    }
    while (i < j)
    {
      this.mCount += this.XHE.axg(i) + axi(i) + this.mNumColumns;
      i += 1;
    }
    i = this.mCount;
    AppMethodBeat.o(142776);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(142777);
    Object localObject = axj(paramInt);
    if ((((c)localObject).mPosition == -1) || (((c)localObject).mPosition == -2))
    {
      AppMethodBeat.o(142777);
      return null;
    }
    localObject = this.XHE.getItem(((c)localObject).mPosition);
    AppMethodBeat.o(142777);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(142778);
    c localc = axj(paramInt);
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
    long l = this.XHE.getItemId(localc.mPosition);
    AppMethodBeat.o(142778);
    return l;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(142779);
    c localc = axj(paramInt);
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
    paramInt = this.XHE.getItemViewType(localc.mPosition);
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
      Object localObject2 = axj(paramInt);
      if (((c)localObject2).mPosition == -2)
      {
        localObject1 = new b(this.mContext);
        ((b)localObject1).setHeaderWidth(this.XHF.getWidth());
        ((b)localObject1).setHeaderId(((c)localObject2).XHL);
        View localView = (View)((View)localObject1).getTag();
        ((View)localObject1).setTag(this.XHE.a(((c)localObject2).XHL, localView, paramViewGroup));
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
        this.XHH[(paramInt % this.mNumColumns)] = localObject2;
        if (paramInt % this.mNumColumns != 0) {
          break label293;
        }
        XHD = true;
        int i = 1;
        while (i < this.XHH.length)
        {
          this.XHH[i] = getView(paramInt + i, null, paramViewGroup);
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
          localObject1 = this.XHE.getView(((c)localObject2).mPosition, (View)localObject1, paramViewGroup);
        }
      }
      XHD = false;
      label293:
      ((d)localObject2).setRowSiblings(this.XHH);
      if ((!XHD) && ((paramInt % this.mNumColumns == this.mNumColumns - 1) || (paramInt == getCount() - 1))) {
        axh(this.mNumColumns);
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
    int i = this.XHE.getViewTypeCount();
    AppMethodBeat.o(142781);
    return i + 2;
  }
  
  public final boolean hasStableIds()
  {
    AppMethodBeat.i(142782);
    boolean bool = this.XHE.hasStableIds();
    AppMethodBeat.o(142782);
    return bool;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(142783);
    boolean bool = this.XHE.isEmpty();
    AppMethodBeat.o(142783);
    return bool;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    AppMethodBeat.i(142784);
    c localc = axj(paramInt);
    if ((localc.mPosition == -1) || (localc.mPosition == -2))
    {
      AppMethodBeat.o(142784);
      return false;
    }
    boolean bool = this.XHE.isEnabled(localc.mPosition);
    AppMethodBeat.o(142784);
    return bool;
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(142785);
    this.XHE.registerDataSetObserver(paramDataSetObserver);
    AppMethodBeat.o(142785);
  }
  
  public final void setNumColumns(int paramInt)
  {
    AppMethodBeat.i(142786);
    this.mNumColumns = paramInt;
    axh(paramInt);
    AppMethodBeat.o(142786);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(142787);
    this.XHE.unregisterDataSetObserver(paramDataSetObserver);
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
    private int XHJ;
    private int XHK;
    
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
      return this.XHJ;
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(142762);
      View localView = (View)getTag();
      if (localView.getLayoutParams() == null) {
        localView.setLayoutParams(generateDefaultLayoutParams());
      }
      if ((localView.getVisibility() != 8) && (localView.getMeasuredHeight() == 0)) {
        localView.measure(View.MeasureSpec.makeMeasureSpec(this.XHK, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      }
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), localView.getMeasuredHeight());
      AppMethodBeat.o(142762);
    }
    
    public final void setHeaderId(int paramInt)
    {
      this.XHJ = paramInt;
    }
    
    public final void setHeaderWidth(int paramInt)
    {
      this.XHK = paramInt;
    }
  }
  
  protected final class c
  {
    protected int XHL;
    protected int mPosition;
    
    protected c(int paramInt1, int paramInt2)
    {
      this.mPosition = paramInt1;
      this.XHL = paramInt2;
    }
  }
  
  protected final class d
    extends FrameLayout
  {
    private View[] XHH;
    private boolean XHM;
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
      if ((this.mPosition % this.mNumColumns == 0) && (!this.XHM))
      {
        this.XHM = true;
        arrayOfView = this.XHH;
        k = arrayOfView.length;
        i = 0;
        while (i < k)
        {
          arrayOfView[i].measure(paramInt1, paramInt2);
          i += 1;
        }
        this.XHM = false;
      }
      int k = getMeasuredHeight();
      View[] arrayOfView = this.XHH;
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
      this.XHH = paramArrayOfView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.c
 * JD-Core Version:    0.7.0.1
 */