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
  private VerticalScrollBar OZR;
  private View OZS;
  private c OZT = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener OZU;
  private List<d> OZV = new ArrayList();
  public boolean OZW;
  public boolean OZX;
  private a OZY;
  private AdapterView.OnItemSelectedListener Yj;
  private AdapterView.OnItemClickListener awr;
  private int mMode;
  private ListView pqt;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate();
    this.OZR = getScrollBar();
    this.pqt = getListView();
    this.OZS = getNoResultView();
    this.OZW = true;
    BF(true);
    this.pqt.setAdapter(this.OZT);
    if (this.OZR != null) {
      this.OZR.setOnScrollBarTouchListener(this);
    }
    this.OZT.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142687);
        if (BaseSortView.a(BaseSortView.this) != null) {
          BaseSortView.a(BaseSortView.this).cz(BaseSortView.b(BaseSortView.this).OZV);
        }
        AppMethodBeat.o(142687);
      }
    });
    this.pqt.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142688);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (BaseSortView.c(BaseSortView.this) != null) {
          BaseSortView.c(BaseSortView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142688);
      }
    });
    this.pqt.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.pqt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142690);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/sortview/BaseSortView$4", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
  
  protected static void A(View paramView, boolean paramBoolean)
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
  
  public final void BF(boolean paramBoolean)
  {
    this.OZX = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.OZR != null)
    {
      localVerticalScrollBar = this.OZR;
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
  
  public final void DP(String paramString)
  {
    int i = this.OZT.bmn(paramString);
    if (i >= 0) {
      this.pqt.setSelection(i);
    }
  }
  
  public abstract boolean a(String paramString, d paramd);
  
  public final void bmm(String paramString)
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
      Iterator localIterator = this.OZV.iterator();
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
      paramString = this.pqt;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        A(paramString, bool1);
        paramString = this.OZS;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        A(paramString, bool1);
        hy(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final boolean gLU()
  {
    return this.OZW;
  }
  
  public final void gLV()
  {
    this.OZW = false;
    this.OZT.refresh();
  }
  
  public c getAdapter()
  {
    return this.OZT;
  }
  
  public a getDataSetObserver()
  {
    return this.OZY;
  }
  
  public List<d> getDatas()
  {
    return this.OZT.OZV;
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
    return this.awr;
  }
  
  public AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.OZU;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.Yj;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public final void hy(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.OZV != paramList))
    {
      this.OZV.clear();
      if (paramList != null) {
        this.OZV.addAll(paramList);
      }
    }
    this.OZT.hy(paramList);
  }
  
  public abstract View inflate();
  
  public void refresh()
  {
    this.OZT.refresh();
  }
  
  public void setDataSetObserver(a parama)
  {
    this.OZY = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      bmm("");
      return;
    }
    this.mMode = 0;
    A(this.OZS, false);
    A(this.pqt, true);
    hy(this.OZV);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.awr = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.OZU = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.Yj = paramOnItemSelectedListener;
  }
  
  public static abstract interface a
  {
    public abstract void cz(List<d> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */