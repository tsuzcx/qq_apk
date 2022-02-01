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

public abstract class p
  extends BaseAdapter
{
  private SparseArray<a> NOO;
  public n PWg;
  boolean PWh;
  boolean PWi;
  protected int scene;
  
  public p(n paramn, boolean paramBoolean, int paramInt)
  {
    this(paramn, paramBoolean, paramInt, false);
  }
  
  public p(n paramn, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.PWg = paramn;
    this.PWh = paramBoolean1;
    this.NOO = new SparseArray();
    this.scene = paramInt;
    this.PWi = paramBoolean2;
  }
  
  public final void Cp(boolean paramBoolean)
  {
    this.PWh = paramBoolean;
    notifyDataSetChanged();
  }
  
  public final a anH(int paramInt)
  {
    if (this.NOO.indexOfKey(paramInt) >= 0) {
      return (a)this.NOO.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = va(paramInt);
      if (locala != null)
      {
        locala.poB = c(locala);
        this.NOO.put(paramInt, locala);
        Log.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.qcr), Integer.valueOf(paramInt) });
        return locala;
      }
      Log.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    Log.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean anI(int paramInt)
  {
    return false;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.NOO != null) {
      this.NOO.clear();
    }
  }
  
  public boolean eWh()
  {
    return this.PWh;
  }
  
  public void finish()
  {
    clearCache();
  }
  
  public int gUt()
  {
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (anH(paramInt) != null) {
      return anH(paramInt).qcr;
    }
    Log.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = anH(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.bmx().a(this.PWg.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.PZZ)
    {
      locala.a(this.PWg.getActivity(), paramView);
      locala.PZZ = true;
    }
    locala.PWh = eWh();
    locala.bmx().a(this.PWg.getActivity(), paramView, locala, this.PWg.b(locala), this.PWg.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  protected abstract a va(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.p
 * JD-Core Version:    0.7.0.1
 */