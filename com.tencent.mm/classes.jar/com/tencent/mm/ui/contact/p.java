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
  private SparseArray<a> InK;
  public n KmO;
  boolean KmP;
  boolean KmQ;
  protected int scene;
  
  public p(n paramn, boolean paramBoolean, int paramInt)
  {
    this(paramn, paramBoolean, paramInt, false);
  }
  
  public p(n paramn, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.KmO = paramn;
    this.KmP = paramBoolean1;
    this.InK = new SparseArray();
    this.scene = paramInt;
    this.KmQ = paramBoolean2;
  }
  
  public final a aen(int paramInt)
  {
    if (this.InK.indexOfKey(paramInt) >= 0) {
      return (a)this.InK.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = rh(paramInt);
      if (locala != null)
      {
        locala.nXU = c(locala);
        this.InK.put(paramInt, locala);
        ad.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.oIb), Integer.valueOf(paramInt) });
        return locala;
      }
      ad.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    ad.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean aeo(int paramInt)
  {
    return false;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.InK != null) {
      this.InK.clear();
    }
  }
  
  public boolean dQK()
  {
    return this.KmP;
  }
  
  public int fHH()
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
    if (aen(paramInt) != null) {
      return aen(paramInt).oIb;
    }
    ad.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = aen(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.aRs().a(this.KmO.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.KqF)
    {
      locala.a(this.KmO.getActivity(), paramView);
      locala.KqF = true;
    }
    locala.KmP = dQK();
    locala.aRs().a(this.KmO.getActivity(), paramView, locala, this.KmO.b(locala), this.KmO.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  protected abstract a rh(int paramInt);
  
  public final void yn(boolean paramBoolean)
  {
    this.KmP = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.p
 * JD-Core Version:    0.7.0.1
 */