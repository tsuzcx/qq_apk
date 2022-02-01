package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSortView
  extends LinearLayout
  implements VerticalScrollBar.a
{
  private VerticalScrollBar Ggp;
  private View Ggq;
  private c Ggr = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener Ggs;
  private List<d> Ggt = new ArrayList();
  public boolean Ggu;
  public boolean Ggv;
  private a Ggw;
  private AdapterView.OnItemSelectedListener Vm;
  private AdapterView.OnItemClickListener atG;
  private int mMode;
  private ListView mVP;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate();
    this.Ggp = getScrollBar();
    this.mVP = getListView();
    this.Ggq = getNoResultView();
    this.Ggu = true;
    vU(true);
    this.mVP.setAdapter(this.Ggr);
    if (this.Ggp != null) {
      this.Ggp.setOnScrollBarTouchListener(this);
    }
    this.Ggr.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142687);
        if (BaseSortView.a(BaseSortView.this) != null) {
          BaseSortView.a(BaseSortView.this).cf(BaseSortView.b(BaseSortView.this).Ggt);
        }
        AppMethodBeat.o(142687);
      }
    });
    this.mVP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142688);
        if (BaseSortView.c(BaseSortView.this) != null) {
          BaseSortView.c(BaseSortView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(142688);
      }
    });
    this.mVP.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142689);
        if (BaseSortView.d(BaseSortView.this) != null)
        {
          boolean bool = BaseSortView.d(BaseSortView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(142689);
          return bool;
        }
        AppMethodBeat.o(142689);
        return false;
      }
    });
    this.mVP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142690);
        if (BaseSortView.e(BaseSortView.this) != null) {
          BaseSortView.e(BaseSortView.this).onItemSelected(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(142690);
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
        AppMethodBeat.i(142691);
        if (BaseSortView.e(BaseSortView.this) != null) {
          BaseSortView.e(BaseSortView.this).onNothingSelected(paramAnonymousAdapterView);
        }
        AppMethodBeat.o(142691);
      }
    });
  }
  
  protected static void x(View paramView, boolean paramBoolean)
  {
    if (paramView != null) {
      if (!paramBoolean) {
        break label16;
      }
    }
    label16:
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
  
  public abstract boolean a(String paramString, d paramd);
  
  public final void aKo(String paramString)
  {
    boolean bool2 = true;
    if (this.mMode != 1)
    {
      ad.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!bt.isNullOrNil(paramString))
    {
      localArrayList.clear();
      Iterator localIterator = this.Ggt.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (a(paramString, locald)) {
          localArrayList.add(locald);
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      paramString = this.mVP;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        x(paramString, bool1);
        paramString = this.Ggq;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        x(paramString, bool1);
        ga(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final boolean eTJ()
  {
    return this.Ggu;
  }
  
  public final void eTK()
  {
    this.Ggu = false;
    this.Ggr.refresh();
  }
  
  public final void ga(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.Ggt != paramList))
    {
      this.Ggt.clear();
      if (paramList != null) {
        this.Ggt.addAll(paramList);
      }
    }
    this.Ggr.ga(paramList);
  }
  
  public c getAdapter()
  {
    return this.Ggr;
  }
  
  public a getDataSetObserver()
  {
    return this.Ggw;
  }
  
  public List<d> getDatas()
  {
    return this.Ggr.Ggt;
  }
  
  public abstract c.a getItemViewCreator();
  
  public abstract ListView getListView();
  
  public int getMode()
  {
    return this.mMode;
  }
  
  public abstract View getNoResultView();
  
  public AdapterView.OnItemClickListener getOnItemClickListener()
  {
    return this.atG;
  }
  
  public AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.Ggs;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.Vm;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public abstract View inflate();
  
  public final void pb(String paramString)
  {
    int i = this.Ggr.aKp(paramString);
    if (i >= 0) {
      this.mVP.setSelection(i);
    }
  }
  
  public void refresh()
  {
    this.Ggr.refresh();
  }
  
  public void setDataSetObserver(a parama)
  {
    this.Ggw = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      aKo("");
      return;
    }
    this.mMode = 0;
    x(this.Ggq, false);
    x(this.mVP, true);
    ga(this.Ggt);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.atG = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.Ggs = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.Vm = paramOnItemSelectedListener;
  }
  
  public final void vU(boolean paramBoolean)
  {
    this.Ggv = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.Ggp != null)
    {
      localVerticalScrollBar = this.Ggp;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 8)
    {
      localVerticalScrollBar.setVisibility(i);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void cf(List<d> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */