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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSortView
  extends LinearLayout
  implements VerticalScrollBar.a
{
  private VerticalScrollBar HGf;
  private View HGg;
  private c HGh = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener HGi;
  private List<d> HGj = new ArrayList();
  public boolean HGk;
  public boolean HGl;
  private a HGm;
  private AdapterView.OnItemSelectedListener Wh;
  private AdapterView.OnItemClickListener auB;
  private int mMode;
  private ListView nyo;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate();
    this.HGf = getScrollBar();
    this.nyo = getListView();
    this.HGg = getNoResultView();
    this.HGk = true;
    wY(true);
    this.nyo.setAdapter(this.HGh);
    if (this.HGf != null) {
      this.HGf.setOnScrollBarTouchListener(this);
    }
    this.HGh.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142687);
        if (BaseSortView.a(BaseSortView.this) != null) {
          BaseSortView.a(BaseSortView.this).ch(BaseSortView.b(BaseSortView.this).HGj);
        }
        AppMethodBeat.o(142687);
      }
    });
    this.nyo.setOnItemClickListener(new AdapterView.OnItemClickListener()
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
    this.nyo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.nyo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
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
  
  public final void aPR(String paramString)
  {
    boolean bool2 = true;
    if (this.mMode != 1)
    {
      ac.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!bs.isNullOrNil(paramString))
    {
      localArrayList.clear();
      Iterator localIterator = this.HGj.iterator();
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
      paramString = this.nyo;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        x(paramString, bool1);
        paramString = this.HGg;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        x(paramString, bool1);
        gh(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final boolean fjw()
  {
    return this.HGk;
  }
  
  public final void fjx()
  {
    this.HGk = false;
    this.HGh.refresh();
  }
  
  public c getAdapter()
  {
    return this.HGh;
  }
  
  public a getDataSetObserver()
  {
    return this.HGm;
  }
  
  public List<d> getDatas()
  {
    return this.HGh.HGj;
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
    return this.auB;
  }
  
  public AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.HGi;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.Wh;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public final void gh(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.HGj != paramList))
    {
      this.HGj.clear();
      if (paramList != null) {
        this.HGj.addAll(paramList);
      }
    }
    this.HGh.gh(paramList);
  }
  
  public abstract View inflate();
  
  public void refresh()
  {
    this.HGh.refresh();
  }
  
  public void setDataSetObserver(a parama)
  {
    this.HGm = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      aPR("");
      return;
    }
    this.mMode = 0;
    x(this.HGg, false);
    x(this.nyo, true);
    gh(this.HGj);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.auB = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.HGi = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.Wh = paramOnItemSelectedListener;
  }
  
  public final void sn(String paramString)
  {
    int i = this.HGh.aPS(paramString);
    if (i >= 0) {
      this.nyo.setSelection(i);
    }
  }
  
  public final void wY(boolean paramBoolean)
  {
    this.HGl = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.HGf != null)
    {
      localVerticalScrollBar = this.HGf;
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
    public abstract void ch(List<d> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */