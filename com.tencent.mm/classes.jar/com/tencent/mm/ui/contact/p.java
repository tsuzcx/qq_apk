package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import junit.framework.Assert;

public abstract class p
  extends BaseAdapter
{
  private SparseArray<a> Feh;
  public n GVS;
  boolean GVT;
  boolean GVU;
  protected int scene;
  
  public p(n paramn, boolean paramBoolean, int paramInt)
  {
    this(paramn, paramBoolean, paramInt, false);
  }
  
  public p(n paramn, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.GVS = paramn;
    this.GVT = paramBoolean1;
    this.Feh = new SparseArray();
    this.scene = paramInt;
    this.GVU = paramBoolean2;
  }
  
  public final a ZC(int paramInt)
  {
    if (this.Feh.indexOfKey(paramInt) >= 0) {
      return (a)this.Feh.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = pU(paramInt);
      if (locala != null)
      {
        locala.mUe = c(locala);
        this.Feh.put(paramInt, locala);
        ad.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.nBH), Integer.valueOf(paramInt) });
        return locala;
      }
      ad.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    ad.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean ZD(int paramInt)
  {
    return false;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.Feh != null) {
      this.Feh.clear();
    }
  }
  
  public boolean dqZ()
  {
    return this.GVT;
  }
  
  public int fbd()
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
    if (ZC(paramInt) != null) {
      return ZC(paramInt).nBH;
    }
    ad.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = ZC(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.aHr().a(this.GVS.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.GZj)
    {
      locala.a(this.GVS.getActivity(), paramView);
      locala.GZj = true;
    }
    locala.GVT = dqZ();
    locala.aHr().a(this.GVS.getActivity(), paramView, locala, this.GVS.b(locala), this.GVS.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  protected abstract a pU(int paramInt);
  
  public final void wu(boolean paramBoolean)
  {
    this.GVT = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.p
 * JD-Core Version:    0.7.0.1
 */