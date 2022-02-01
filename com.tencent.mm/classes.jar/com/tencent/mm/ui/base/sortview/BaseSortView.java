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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSortView
  extends LinearLayout
  implements VerticalScrollBar.a
{
  private VerticalScrollBar JOL;
  private View JOM;
  private c JON = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener JOO;
  private List<d> JOP = new ArrayList();
  public boolean JOQ;
  public boolean JOR;
  private a JOS;
  private AdapterView.OnItemSelectedListener XW;
  private AdapterView.OnItemClickListener awt;
  private int mMode;
  private ListView ofw;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate();
    this.JOL = getScrollBar();
    this.ofw = getListView();
    this.JOM = getNoResultView();
    this.JOQ = true;
    xQ(true);
    this.ofw.setAdapter(this.JON);
    if (this.JOL != null) {
      this.JOL.setOnScrollBarTouchListener(this);
    }
    this.JON.registerDataSetObserver(new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(142687);
        if (BaseSortView.a(BaseSortView.this) != null) {
          BaseSortView.a(BaseSortView.this).ck(BaseSortView.b(BaseSortView.this).JOP);
        }
        AppMethodBeat.o(142687);
      }
    });
    this.ofw.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142688);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        if (BaseSortView.c(BaseSortView.this) != null) {
          BaseSortView.c(BaseSortView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        a.a(this, "com/tencent/mm/ui/base/sortview/BaseSortView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142688);
      }
    });
    this.ofw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
    this.ofw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(142690);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/ui/base/sortview/BaseSortView$4", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
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
  
  protected static void y(View paramView, boolean paramBoolean)
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
  
  public final void aXi(String paramString)
  {
    boolean bool2 = true;
    if (this.mMode != 1)
    {
      ae.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!bu.isNullOrNil(paramString))
    {
      localArrayList.clear();
      Iterator localIterator = this.JOP.iterator();
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
      paramString = this.ofw;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        y(paramString, bool1);
        paramString = this.JOM;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        y(paramString, bool1);
        gB(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final boolean fDN()
  {
    return this.JOQ;
  }
  
  public final void fDO()
  {
    this.JOQ = false;
    this.JON.refresh();
  }
  
  public final void gB(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.JOP != paramList))
    {
      this.JOP.clear();
      if (paramList != null) {
        this.JOP.addAll(paramList);
      }
    }
    this.JON.gB(paramList);
  }
  
  public c getAdapter()
  {
    return this.JON;
  }
  
  public a getDataSetObserver()
  {
    return this.JOS;
  }
  
  public List<d> getDatas()
  {
    return this.JON.JOP;
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
    return this.JOO;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.XW;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public abstract View inflate();
  
  public void refresh()
  {
    this.JON.refresh();
  }
  
  public void setDataSetObserver(a parama)
  {
    this.JOS = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      aXi("");
      return;
    }
    this.mMode = 0;
    y(this.JOM, false);
    y(this.ofw, true);
    gB(this.JOP);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.awt = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.JOO = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.XW = paramOnItemSelectedListener;
  }
  
  public final void vy(String paramString)
  {
    int i = this.JON.aXj(paramString);
    if (i >= 0) {
      this.ofw.setSelection(i);
    }
  }
  
  public final void xQ(boolean paramBoolean)
  {
    this.JOR = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.JOL != null)
    {
      localVerticalScrollBar = this.JOL;
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
    public abstract void ck(List<d> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */