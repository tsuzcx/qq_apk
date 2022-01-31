package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSortView
  extends LinearLayout
  implements VerticalScrollBar.a
{
  private AdapterView.OnItemSelectedListener Oh;
  private AdapterView.OnItemClickListener amh;
  private ListView jVf;
  private int mMode;
  private View zsA;
  private c zsB = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener zsC;
  private List<d> zsD = new ArrayList();
  public boolean zsE;
  public boolean zsF;
  private BaseSortView.a zsG;
  private VerticalScrollBar zsz;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate();
    this.zsz = getScrollBar();
    this.jVf = getListView();
    this.zsA = getNoResultView();
    this.zsE = true;
    qM(true);
    this.jVf.setAdapter(this.zsB);
    if (this.zsz != null) {
      this.zsz.setOnScrollBarTouchListener(this);
    }
    this.zsB.registerDataSetObserver(new BaseSortView.1(this));
    this.jVf.setOnItemClickListener(new BaseSortView.2(this));
    this.jVf.setOnItemLongClickListener(new BaseSortView.3(this));
    this.jVf.setOnItemSelectedListener(new BaseSortView.4(this));
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
  
  public final void atB(String paramString)
  {
    boolean bool2 = true;
    if (this.mMode != 1)
    {
      ab.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!bo.isNullOrNil(paramString))
    {
      localArrayList.clear();
      Iterator localIterator = this.zsD.iterator();
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
      paramString = this.jVf;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        y(paramString, bool1);
        paramString = this.zsA;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        y(paramString, bool1);
        dI(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final void dES()
  {
    this.zsE = false;
    this.zsB.refresh();
  }
  
  public final void dI(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.zsD != paramList))
    {
      this.zsD.clear();
      if (paramList != null) {
        this.zsD.addAll(paramList);
      }
    }
    this.zsB.dI(paramList);
  }
  
  public c getAdapter()
  {
    return this.zsB;
  }
  
  public BaseSortView.a getDataSetObserver()
  {
    return this.zsG;
  }
  
  public List<d> getDatas()
  {
    return this.zsB.zsD;
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
    return this.amh;
  }
  
  public AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.zsC;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.Oh;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public abstract View inflate();
  
  public final void lf(String paramString)
  {
    int i = this.zsB.atC(paramString);
    if (i >= 0) {
      this.jVf.setSelection(i);
    }
  }
  
  public final void qM(boolean paramBoolean)
  {
    this.zsF = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.zsz != null)
    {
      localVerticalScrollBar = this.zsz;
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
  
  public void refresh()
  {
    this.zsB.refresh();
  }
  
  public void setDataSetObserver(BaseSortView.a parama)
  {
    this.zsG = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      atB("");
      return;
    }
    this.mMode = 0;
    y(this.zsA, false);
    y(this.jVf, true);
    dI(this.zsD);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.amh = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.zsC = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.Oh = paramOnItemSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */