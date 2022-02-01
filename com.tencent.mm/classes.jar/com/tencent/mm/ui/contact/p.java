package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import junit.framework.Assert;

public abstract class p
  extends BaseAdapter
{
  private SparseArray<a> IHV;
  public n KJi;
  boolean KJj;
  boolean KJk;
  protected int scene;
  
  public p(n paramn, boolean paramBoolean, int paramInt)
  {
    this(paramn, paramBoolean, paramInt, false);
  }
  
  public p(n paramn, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.KJi = paramn;
    this.KJj = paramBoolean1;
    this.IHV = new SparseArray();
    this.scene = paramInt;
    this.KJk = paramBoolean2;
  }
  
  public final a aeW(int paramInt)
  {
    if (this.IHV.indexOfKey(paramInt) >= 0) {
      return (a)this.IHV.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = rk(paramInt);
      if (locala != null)
      {
        locala.odD = c(locala);
        this.IHV.put(paramInt, locala);
        ae.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.oOD), Integer.valueOf(paramInt) });
        return locala;
      }
      ae.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    ae.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean aeX(int paramInt)
  {
    return false;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.IHV != null) {
      this.IHV.clear();
    }
  }
  
  public boolean dUh()
  {
    return this.KJj;
  }
  
  public int fLZ()
  {
    return 0;
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
    if (aeW(paramInt) != null) {
      return aeW(paramInt).oOD;
    }
    ae.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = aeW(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.aRR().a(this.KJi.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.KMZ)
    {
      locala.a(this.KJi.getActivity(), paramView);
      locala.KMZ = true;
    }
    locala.KJj = dUh();
    locala.aRR().a(this.KJi.getActivity(), paramView, locala, this.KJi.b(locala), this.KJi.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  protected abstract a rk(int paramInt);
  
  public final void yA(boolean paramBoolean)
  {
    this.KJj = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.p
 * JD-Core Version:    0.7.0.1
 */