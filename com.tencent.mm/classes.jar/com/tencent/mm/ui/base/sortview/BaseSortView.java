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
  private VerticalScrollBar JtW;
  private View JtX;
  private c JtY = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener JtZ;
  private List<d> Jua = new ArrayList();
  public boolean Jub;
  public boolean Juc;
  private a Jud;
  private AdapterView.OnItemSelectedListener XW;
  private AdapterView.OnItemClickListener awt;
  private int mMode;
  private ListView nZM;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate();
    this.JtW = getScrollBar();
    this.nZM = getListView();
    this.JtX = getNoResultView();
    this.Jub = true;
    xJ(true);
    this.nZM.setAdapter(this.JtY);
    if (this.JtW != null) {
      this.JtW.setOnScrollBarTouchListener(this);
    }
    this.JtY.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142687);
        if (BaseSortView.a(BaseSortView.this) != null) {
          BaseSortView.a(BaseSortView.this).ci(BaseSortView.b(BaseSortView.this).Jua);
        }
        AppMethodBeat.o(142687);
      }
    });
    this.nZM.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142688);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (BaseSortView.c(BaseSortView.this) != null) {
          BaseSortView.c(BaseSortView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142688);
      }
    });
    this.nZM.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.nZM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142690);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/sortview/BaseSortView$4", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
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
  
  public final void aVH(String paramString)
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
      Iterator localIterator = this.Jua.iterator();
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
      paramString = this.nZM;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        x(paramString, bool1);
        paramString = this.JtX;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        x(paramString, bool1);
        gs(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final boolean fzL()
  {
    return this.Jub;
  }
  
  public final void fzM()
  {
    this.Jub = false;
    this.JtY.refresh();
  }
  
  public c getAdapter()
  {
    return this.JtY;
  }
  
  public a getDataSetObserver()
  {
    return this.Jud;
  }
  
  public List<d> getDatas()
  {
    return this.JtY.Jua;
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
    return this.awt;
  }
  
  public AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.JtZ;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.XW;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public final void gs(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.Jua != paramList))
    {
      this.Jua.clear();
      if (paramList != null) {
        this.Jua.addAll(paramList);
      }
    }
    this.JtY.gs(paramList);
  }
  
  public abstract View inflate();
  
  public void refresh()
  {
    this.JtY.refresh();
  }
  
  public void setDataSetObserver(a parama)
  {
    this.Jud = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      aVH("");
      return;
    }
    this.mMode = 0;
    x(this.JtX, false);
    x(this.nZM, true);
    gs(this.Jua);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.awt = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.JtZ = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.XW = paramOnItemSelectedListener;
  }
  
  public final void vc(String paramString)
  {
    int i = this.JtY.aVI(paramString);
    if (i >= 0) {
      this.nZM.setSelection(i);
    }
  }
  
  public final void xJ(boolean paramBoolean)
  {
    this.Juc = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.JtW != null)
    {
      localVerticalScrollBar = this.JtW;
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
    public abstract void ci(List<d> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */