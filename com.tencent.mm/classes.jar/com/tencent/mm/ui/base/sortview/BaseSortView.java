package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseSortView
  extends LinearLayout
  implements VerticalScrollBar.a
{
  private AdapterView.OnItemSelectedListener Ot;
  private AdapterView.OnItemClickListener ajR;
  private ListView ier;
  private int mMode;
  private VerticalScrollBar vdZ;
  private View vea;
  private c veb = new c(getItemViewCreator());
  private AdapterView.OnItemLongClickListener vec;
  private List<d> ved = new ArrayList();
  public boolean vee;
  public boolean vef;
  private BaseSortView.a veg;
  
  public BaseSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate();
    this.vdZ = getScrollBar();
    this.ier = getListView();
    this.vea = getNoResultView();
    this.vee = true;
    ng(true);
    this.ier.setAdapter(this.veb);
    if (this.vdZ != null) {
      this.vdZ.setOnScrollBarTouchListener(this);
    }
    this.veb.registerDataSetObserver(new BaseSortView.1(this));
    this.ier.setOnItemClickListener(new BaseSortView.2(this));
    this.ier.setOnItemLongClickListener(new BaseSortView.3(this));
    this.ier.setOnItemSelectedListener(new BaseSortView.4(this));
  }
  
  public static void q(View paramView, boolean paramBoolean)
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
  
  public final void adg(String paramString)
  {
    boolean bool2 = true;
    if (this.mMode != 1)
    {
      y.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!bk.bl(paramString))
    {
      localArrayList.clear();
      Iterator localIterator = this.ved.iterator();
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
      paramString = this.ier;
      if ((i != 0) && (localArrayList.size() > 0))
      {
        bool1 = true;
        q(paramString, bool1);
        paramString = this.vea;
        if ((i == 0) || (localArrayList.size() > 0)) {
          break label165;
        }
      }
      label165:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        q(paramString, bool1);
        dM(localArrayList);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public final void cBz()
  {
    this.vee = false;
    ai.d(this.veb.vek);
  }
  
  public final void dM(List<d> paramList)
  {
    if ((this.mMode == 0) && (this.ved != paramList))
    {
      this.ved.clear();
      if (paramList != null) {
        this.ved.addAll(paramList);
      }
    }
    this.veb.dM(paramList);
  }
  
  public final void eU(String paramString)
  {
    int i = this.veb.adh(paramString);
    if (i >= 0) {
      this.ier.setSelection(i);
    }
  }
  
  public c getAdapter()
  {
    return this.veb;
  }
  
  public BaseSortView.a getDataSetObserver()
  {
    return this.veg;
  }
  
  public List<d> getDatas()
  {
    return this.veb.ved;
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
    return this.ajR;
  }
  
  public AdapterView.OnItemLongClickListener getOnItemLongClickListener()
  {
    return this.vec;
  }
  
  public AdapterView.OnItemSelectedListener getOnItemSelectedListener()
  {
    return this.Ot;
  }
  
  public abstract VerticalScrollBar getScrollBar();
  
  public abstract View inflate();
  
  public final void ng(boolean paramBoolean)
  {
    this.vef = paramBoolean;
    VerticalScrollBar localVerticalScrollBar;
    if (this.vdZ != null)
    {
      localVerticalScrollBar = this.vdZ;
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
    ai.d(this.veb.vek);
  }
  
  public void setDataSetObserver(BaseSortView.a parama)
  {
    this.veg = parama;
  }
  
  public void setMode(int paramInt)
  {
    if (paramInt == 1)
    {
      this.mMode = 1;
      adg("");
      return;
    }
    this.mMode = 0;
    q(this.vea, false);
    q(this.ier, true);
    dM(this.ved);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.ajR = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.vec = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.Ot = paramOnItemSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.BaseSortView
 * JD-Core Version:    0.7.0.1
 */