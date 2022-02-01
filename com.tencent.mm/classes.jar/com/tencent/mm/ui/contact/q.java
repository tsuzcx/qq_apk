package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import junit.framework.Assert;

public abstract class q
  extends BaseAdapter
{
  private SparseArray<a> Vcx;
  public o XsW;
  public boolean XsX;
  private boolean XsY;
  private int scene;
  
  public q(o paramo, boolean paramBoolean, int paramInt)
  {
    this(paramo, paramBoolean, paramInt, false);
  }
  
  public q(o paramo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.XsW = paramo;
    this.XsX = paramBoolean1;
    this.Vcx = new SparseArray();
    this.scene = paramInt;
    this.XsY = paramBoolean2;
  }
  
  public final void GL(boolean paramBoolean)
  {
    this.XsX = paramBoolean;
    notifyDataSetChanged();
  }
  
  public final a awM(int paramInt)
  {
    if (this.Vcx.indexOfKey(paramInt) >= 0) {
      return (a)this.Vcx.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = ye(paramInt);
      if (locala != null)
      {
        locala.sxA = c(locala);
        this.Vcx.put(paramInt, locala);
        Log.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.viewType), Integer.valueOf(paramInt) });
        return locala;
      }
      Log.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    Log.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean awN(int paramInt)
  {
    return false;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.Vcx != null) {
      this.Vcx.clear();
    }
  }
  
  public boolean fJk()
  {
    return this.XsX;
  }
  
  public void finish()
  {
    clearCache();
  }
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (awM(paramInt) != null) {
      return awM(paramInt).viewType;
    }
    Log.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public final int getScene()
  {
    return this.scene;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = awM(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.bwF().a(this.XsW.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.Xxr)
    {
      locala.a(this.XsW.getActivity(), paramView);
      locala.Xxr = true;
    }
    locala.XsX = fJk();
    locala.bwF().a(this.XsW.getActivity(), paramView, locala, this.XsW.b(locala), this.XsW.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 9;
  }
  
  public final o hUM()
  {
    return this.XsW;
  }
  
  public final void hUN()
  {
    this.XsX = true;
  }
  
  public final boolean hUO()
  {
    return this.XsY;
  }
  
  public int hUm()
  {
    return 0;
  }
  
  protected abstract a ye(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.q
 * JD-Core Version:    0.7.0.1
 */