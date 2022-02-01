package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView
  extends GridView
{
  public ArrayList<a> FVc;
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(141668);
    this.FVc = new ArrayList();
    super.setClipChildren(false);
    AppMethodBeat.o(141668);
  }
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141669);
    this.FVc = new ArrayList();
    super.setClipChildren(false);
    AppMethodBeat.o(141669);
  }
  
  public int getHeaderViewCount()
  {
    AppMethodBeat.i(141671);
    int i = this.FVc.size();
    AppMethodBeat.o(141671);
    return i;
  }
  
  @TargetApi(11)
  public int getNumColumns()
  {
    AppMethodBeat.i(141670);
    int i;
    if (Build.VERSION.SDK_INT >= 11)
    {
      i = super.getNumColumns();
      AppMethodBeat.o(141670);
      return i;
    }
    try
    {
      Field localField = getClass().getSuperclass().getDeclaredField("mNumColumns");
      localField.setAccessible(true);
      i = localField.getInt(this);
      AppMethodBeat.o(141670);
      return i;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(141670);
    }
    return 1;
  }
  
  public final void setAdapter$159aa965(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(141672);
    if (this.FVc.size() > 0)
    {
      paramListAdapter = new c(this.FVc, paramListAdapter);
      if (paramListAdapter.mNumColumns != 5)
      {
        paramListAdapter.mNumColumns = 5;
        paramListAdapter.mDataSetObservable.notifyChanged();
      }
      super.setAdapter(paramListAdapter);
      AppMethodBeat.o(141672);
      return;
    }
    super.setAdapter(paramListAdapter);
    AppMethodBeat.o(141672);
  }
  
  public void setClipChildren(boolean paramBoolean) {}
  
  public static final class a
  {
    public ViewGroup FVd;
    public Object data;
    public boolean isSelectable;
    public View view;
  }
  
  public final class b
    extends FrameLayout
  {
    public b(Context paramContext)
    {
      super();
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(141651);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft() - HeaderGridView.this.getPaddingRight(), 1073741824), paramInt2);
      AppMethodBeat.o(141651);
    }
  }
  
  public static final class c
    implements Filterable, WrapperListAdapter
  {
    private final ListAdapter DP;
    ArrayList<HeaderGridView.a> FVc;
    boolean FVf;
    private final boolean FVg;
    public final DataSetObservable mDataSetObservable;
    int mNumColumns;
    
    public c(ArrayList<HeaderGridView.a> paramArrayList, ListAdapter paramListAdapter)
    {
      AppMethodBeat.i(141653);
      this.mDataSetObservable = new DataSetObservable();
      this.mNumColumns = 1;
      this.DP = paramListAdapter;
      this.FVg = (paramListAdapter instanceof Filterable);
      if (paramArrayList == null)
      {
        paramArrayList = new IllegalArgumentException("headerViewInfos cannot be null");
        AppMethodBeat.o(141653);
        throw paramArrayList;
      }
      this.FVc = paramArrayList;
      this.FVf = aN(this.FVc);
      AppMethodBeat.o(141653);
    }
    
    private static boolean aN(ArrayList<HeaderGridView.a> paramArrayList)
    {
      AppMethodBeat.i(141655);
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          if (!((HeaderGridView.a)paramArrayList.next()).isSelectable)
          {
            AppMethodBeat.o(141655);
            return false;
          }
        }
      }
      AppMethodBeat.o(141655);
      return true;
    }
    
    public final boolean areAllItemsEnabled()
    {
      AppMethodBeat.i(141657);
      if (this.DP != null)
      {
        if ((this.FVf) && (this.DP.areAllItemsEnabled()))
        {
          AppMethodBeat.o(141657);
          return true;
        }
        AppMethodBeat.o(141657);
        return false;
      }
      AppMethodBeat.o(141657);
      return true;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(141656);
      if (this.DP != null)
      {
        i = this.FVc.size();
        j = this.mNumColumns;
        int k = this.DP.getCount();
        AppMethodBeat.o(141656);
        return i * j + k;
      }
      int i = this.FVc.size();
      int j = this.mNumColumns;
      AppMethodBeat.o(141656);
      return i * j;
    }
    
    public final Filter getFilter()
    {
      AppMethodBeat.i(141667);
      if (this.FVg)
      {
        Filter localFilter = ((Filterable)this.DP).getFilter();
        AppMethodBeat.o(141667);
        return localFilter;
      }
      AppMethodBeat.o(141667);
      return null;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(141659);
      int i = this.FVc.size() * this.mNumColumns;
      Object localObject;
      if (paramInt < i)
      {
        if (paramInt % this.mNumColumns == 0)
        {
          localObject = ((HeaderGridView.a)this.FVc.get(paramInt / this.mNumColumns)).data;
          AppMethodBeat.o(141659);
          return localObject;
        }
        AppMethodBeat.o(141659);
        return null;
      }
      paramInt -= i;
      if ((this.DP != null) && (paramInt < this.DP.getCount()))
      {
        localObject = this.DP.getItem(paramInt);
        AppMethodBeat.o(141659);
        return localObject;
      }
      AppMethodBeat.o(141659);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(141660);
      int i = this.FVc.size() * this.mNumColumns;
      if ((this.DP != null) && (paramInt >= i))
      {
        paramInt -= i;
        if (paramInt < this.DP.getCount())
        {
          long l = this.DP.getItemId(paramInt);
          AppMethodBeat.o(141660);
          return l;
        }
      }
      AppMethodBeat.o(141660);
      return -1L;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(141663);
      int i = this.FVc.size() * this.mNumColumns;
      if ((paramInt < i) && (paramInt % this.mNumColumns != 0))
      {
        if (this.DP != null)
        {
          paramInt = this.DP.getViewTypeCount();
          AppMethodBeat.o(141663);
          return paramInt;
        }
        AppMethodBeat.o(141663);
        return 1;
      }
      if ((this.DP != null) && (paramInt >= i))
      {
        paramInt -= i;
        if (paramInt < this.DP.getCount())
        {
          paramInt = this.DP.getItemViewType(paramInt);
          AppMethodBeat.o(141663);
          return paramInt;
        }
      }
      AppMethodBeat.o(141663);
      return -2;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(141662);
      int i = this.FVc.size() * this.mNumColumns;
      if (paramInt < i)
      {
        ViewGroup localViewGroup = ((HeaderGridView.a)this.FVc.get(paramInt / this.mNumColumns)).FVd;
        if (paramInt % this.mNumColumns == 0)
        {
          AppMethodBeat.o(141662);
          return localViewGroup;
        }
        localView = paramView;
        if (paramView == null) {
          localView = new View(paramViewGroup.getContext());
        }
        localView.setVisibility(4);
        localView.setMinimumHeight(localViewGroup.getHeight());
        AppMethodBeat.o(141662);
        return localView;
      }
      paramInt -= i;
      if ((this.DP != null) && (paramInt < this.DP.getCount()))
      {
        paramView = this.DP.getView(paramInt, paramView, paramViewGroup);
        AppMethodBeat.o(141662);
        return paramView;
      }
      View localView = paramView;
      if (paramView == null) {
        localView = new View(paramViewGroup.getContext());
      }
      localView.setVisibility(4);
      AppMethodBeat.o(141662);
      return localView;
    }
    
    public final int getViewTypeCount()
    {
      AppMethodBeat.i(141664);
      if (this.DP != null)
      {
        int i = this.DP.getViewTypeCount();
        AppMethodBeat.o(141664);
        return i + 1;
      }
      AppMethodBeat.o(141664);
      return 2;
    }
    
    public final ListAdapter getWrappedAdapter()
    {
      return this.DP;
    }
    
    public final boolean hasStableIds()
    {
      AppMethodBeat.i(141661);
      if (this.DP != null)
      {
        boolean bool = this.DP.hasStableIds();
        AppMethodBeat.o(141661);
        return bool;
      }
      AppMethodBeat.o(141661);
      return false;
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(141654);
      if (((this.DP == null) || (this.DP.isEmpty())) && (this.FVc.size() == 0))
      {
        AppMethodBeat.o(141654);
        return true;
      }
      AppMethodBeat.o(141654);
      return false;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(141658);
      int i = this.FVc.size() * this.mNumColumns;
      if (paramInt < i)
      {
        if ((paramInt % this.mNumColumns == 0) && (((HeaderGridView.a)this.FVc.get(paramInt / this.mNumColumns)).isSelectable))
        {
          AppMethodBeat.o(141658);
          return true;
        }
        AppMethodBeat.o(141658);
        return false;
      }
      paramInt -= i;
      if ((this.DP != null) && (paramInt < this.DP.getCount()))
      {
        boolean bool = this.DP.isEnabled(paramInt);
        AppMethodBeat.o(141658);
        return bool;
      }
      AppMethodBeat.o(141658);
      return false;
    }
    
    public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      AppMethodBeat.i(141665);
      this.mDataSetObservable.registerObserver(paramDataSetObserver);
      if (this.DP != null) {
        this.DP.registerDataSetObserver(paramDataSetObserver);
      }
      AppMethodBeat.o(141665);
    }
    
    public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      AppMethodBeat.i(141666);
      this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
      if (this.DP != null) {
        this.DP.unregisterDataSetObserver(paramDataSetObserver);
      }
      AppMethodBeat.o(141666);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.HeaderGridView
 * JD-Core Version:    0.7.0.1
 */