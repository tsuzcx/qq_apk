package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import junit.framework.Assert;

public abstract class p
  extends BaseAdapter
{
  private SparseArray<a> GBQ;
  public n Iwg;
  boolean Iwh;
  boolean Iwi;
  protected int scene;
  
  public p(n paramn, boolean paramBoolean, int paramInt)
  {
    this(paramn, paramBoolean, paramInt, false);
  }
  
  public p(n paramn, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.Iwg = paramn;
    this.Iwh = paramBoolean1;
    this.GBQ = new SparseArray();
    this.scene = paramInt;
    this.Iwi = paramBoolean2;
  }
  
  public final a abQ(int paramInt)
  {
    if (this.GBQ.indexOfKey(paramInt) >= 0) {
      return (a)this.GBQ.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = qH(paramInt);
      if (locala != null)
      {
        locala.nww = c(locala);
        this.GBQ.put(paramInt, locala);
        ac.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.oeH), Integer.valueOf(paramInt) });
        return locala;
      }
      ac.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    ac.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean abR(int paramInt)
  {
    return false;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.GBQ != null) {
      this.GBQ.clear();
    }
  }
  
  public boolean dFi()
  {
    return this.Iwh;
  }
  
  public void finish()
  {
    clearCache();
  }
  
  public int fqU()
  {
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (abQ(paramInt) != null) {
      return abQ(paramInt).oeH;
    }
    ac.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = abQ(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.aOg().a(this.Iwg.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.Izz)
    {
      locala.a(this.Iwg.getActivity(), paramView);
      locala.Izz = true;
    }
    locala.Iwh = dFi();
    locala.aOg().a(this.Iwg.getActivity(), paramView, locala, this.Iwg.b(locala), this.Iwg.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  protected abstract a qH(int paramInt);
  
  public final void xA(boolean paramBoolean)
  {
    this.Iwh = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.p
 * JD-Core Version:    0.7.0.1
 */