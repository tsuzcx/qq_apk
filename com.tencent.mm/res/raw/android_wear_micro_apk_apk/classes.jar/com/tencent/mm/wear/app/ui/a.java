package com.tencent.mm.wear.app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.e.a.s;
import com.tencent.mm.wear.app.ui.a.b;

public abstract class a
  extends BaseAdapter
{
  private boolean aev;
  private SparseArray<com.tencent.mm.wear.app.ui.a.a> aew;
  private Context context;
  private int count;
  
  public a(Context paramContext)
  {
    this.context = paramContext;
    this.aew = new SparseArray();
    paramContext = paramContext.getResources().getDisplayMetrics();
    if (paramContext.widthPixels != paramContext.heightPixels) {}
    for (boolean bool = true;; bool = false)
    {
      this.aev = bool;
      return;
    }
  }
  
  public final com.tencent.mm.wear.app.ui.a.a bR(int paramInt)
  {
    Object localObject;
    if (this.aew.indexOfKey(paramInt) >= 0) {
      localObject = (com.tencent.mm.wear.app.ui.a.a)this.aew.get(paramInt);
    }
    com.tencent.mm.wear.app.ui.a.a locala;
    do
    {
      return localObject;
      locala = bS(paramInt);
      localObject = locala;
    } while (locala == null);
    this.aew.put(paramInt, locala);
    return locala;
  }
  
  public abstract com.tencent.mm.wear.app.ui.a.a bS(int paramInt);
  
  protected final void clearCache()
  {
    this.aew.clear();
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public long getItemId(int paramInt)
  {
    com.tencent.mm.wear.app.ui.a.a locala = bR(paramInt);
    if (locala != null) {
      return locala.ahe.afg.VO;
    }
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return bR(paramInt).nw();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.tencent.mm.wear.app.ui.a.a locala = bR(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.a(this.context, paramViewGroup);
    }
    paramView = (b)localView.getTag();
    if (!locala.nv()) {
      locala.nu();
    }
    locala.a(this.context, paramView);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 12;
  }
  
  protected final void setCount(int paramInt)
  {
    this.count = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.ui.a
 * JD-Core Version:    0.7.0.1
 */