package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import junit.framework.Assert;

public abstract class n
  extends BaseAdapter
{
  public int scene;
  private SparseArray<a> umS;
  public l vLI;
  private boolean vLJ;
  boolean vLK;
  
  public n(l paraml, boolean paramBoolean, int paramInt)
  {
    this(paraml, paramBoolean, paramInt, false);
  }
  
  public n(l paraml, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.vLI = paraml;
    this.vLJ = paramBoolean1;
    this.umS = new SparseArray();
    this.scene = paramInt;
    this.vLK = paramBoolean2;
  }
  
  public final a HK(int paramInt)
  {
    if (this.umS.indexOfKey(paramInt) >= 0) {
      return (a)this.umS.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = jQ(paramInt);
      if (locala != null)
      {
        locala.icY = c(locala);
        this.umS.put(paramInt, locala);
        y.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.ivk), Integer.valueOf(paramInt) });
        return locala;
      }
      y.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    y.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean HL(int paramInt)
  {
    return false;
  }
  
  public boolean bBJ()
  {
    return this.vLJ;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.umS != null) {
      this.umS.clear();
    }
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
    if (HK(paramInt) != null) {
      return HK(paramInt).ivk;
    }
    y.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = HK(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.Vz().a(this.vLI.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.vOi)
    {
      locala.bW(this.vLI.getActivity());
      locala.vOi = true;
    }
    locala.vLJ = bBJ();
    locala.Vz().a(this.vLI.getActivity(), paramView, locala, this.vLI.b(locala), this.vLI.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  public abstract a jQ(int paramInt);
  
  public final void nz(boolean paramBoolean)
  {
    this.vLJ = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.contact.n
 * JD-Core Version:    0.7.0.1
 */