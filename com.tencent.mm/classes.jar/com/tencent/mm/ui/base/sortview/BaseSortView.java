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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSortView
  extends LinearLayout
  implements VerticalScrollBar.a
{
  private c aeaA = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener aeaB;
  private List<d> aeaC = new ArrayList();
  public boolean aeaD;
  public boolean aeaE;
  private a aeaF;
  private VerticalScrollBar aeay;
  private View aeaz;
  private AdapterView.OnItemSelectedListener gz;
  private int mMode;
  private ListView vEX;
  private AdapterView.OnItemClickListener vT;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    fF();
    this.aeay = getScrollBar();
    this.vEX = getListView();
    this.aeaz = getNoResultView();
    this.aeaD = true;
    LL(true);
    this.vEX.setAdapter(this.aeaA);
    if (this.aeay != null) {
      this.aeay.setOnScrollBarTouchListener(this);
    }
    this.aeaA.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142687);
        if (BaseSortView.a(BaseSortView.this) != null) {
          BaseSortView.a(BaseSortView.this).onChanged(BaseSortView.b(BaseSortView.this).aeaC);
        }
        AppMethodBeat.o(142687);
      }
    });
    this.vEX.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142688);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (BaseSortView.c(BaseSortView.this) != null) {
          BaseSortView.c(BaseSortView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142688);
      }
    });
    this.vEX.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.vEX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142690);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/base/sortview/BaseSortView$4", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (BaseSortView.e(BaseSortView.this) != null) {
          BaseSortView.e(BaseSortView.this).onItemSelected(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/ui/base/sortview/BaseSortView$4", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
  
  protected static void I(View paramView, boolean paramBoolean)
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
  
  public final void LL(boolean paramBoolean)
  {
    this.aeaE = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.aeay != null)
    {
      localVerticalScrollBar = this.aeay;
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
  
  public abstract boolean a(String paramString, d paramd);
  
  public final void bAo(String paramString)
  {
    boolean bool2 = true;
    if (this.mMode != 1)
    {
      Log.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!Util.isNullOrNil(paramString))
    {
      localArrayList.clear();
      Iterator localIterator = this.aeaC.iterator();
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
      paramString = this.vEX;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        I(paramString, bool1);
        paramString = this.aeaz;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        I(paramString, bool1);
        lG(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public void bDL()
  {
    this.aeaA.bDL();
  }
  
  public abstract View fF();
  
  public c getAdapter()
  {
    return this.aeaA;
  }
  
  public a getDataSetObserver()
  {
    return this.aeaF;
  }
  
  public List<d> getDatas()
  {
    return this.aeaA.aeaC;
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
    return this.vT;
  }
  
  public AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.aeaB;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.gz;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public final void jnG()
  {
    this.aeaD = false;
    this.aeaA.bDL();
  }
  
  public final void lG(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.aeaC != paramList))
    {
      this.aeaC.clear();
      if (paramList != null) {
        this.aeaC.addAll(paramList);
      }
    }
    this.aeaA.lG(paramList);
  }
  
  public void onScollBarTouch(String paramString)
  {
    int i = this.aeaA.bAp(paramString);
    if (i >= 0) {
      this.vEX.setSelection(i);
    }
  }
  
  public void setDataSetObserver(a parama)
  {
    this.aeaF = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      bAo("");
      return;
    }
    this.mMode = 0;
    I(this.aeaz, false);
    I(this.vEX, true);
    lG(this.aeaC);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.vT = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.aeaB = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.gz = paramOnItemSelectedListener;
  }
  
  public static abstract interface a
  {
    public abstract void onChanged(List<d> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */