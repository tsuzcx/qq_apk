package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import junit.framework.Assert;

public abstract class o
  extends BaseAdapter
{
  public m Adk;
  private boolean Adl;
  boolean Adm;
  protected int scene;
  private SparseArray<a> ywy;
  
  public o(m paramm, boolean paramBoolean, int paramInt)
  {
    this(paramm, paramBoolean, paramInt, false);
  }
  
  public o(m paramm, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.Adk = paramm;
    this.Adl = paramBoolean1;
    this.ywy = new SparseArray();
    this.scene = paramInt;
    this.Adm = paramBoolean2;
  }
  
  public final a Qt(int paramInt)
  {
    if (this.ywy.indexOfKey(paramInt) >= 0) {
      return (a)this.ywy.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = mM(paramInt);
      if (locala != null)
      {
        locala.jTN = c(locala);
        this.ywy.put(paramInt, locala);
        ab.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.kwo), Integer.valueOf(paramInt) });
        return locala;
      }
      ab.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    ab.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean Qu(int paramInt)
  {
    return false;
  }
  
  protected boolean c(a parama)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.ywy != null) {
      this.ywy.clear();
    }
  }
  
  public boolean cni()
  {
    return this.Adl;
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
    if (Qt(paramInt) != null) {
      return Qt(paramInt).kwo;
    }
    ab.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[] { Integer.valueOf(getCount()), Integer.valueOf(paramInt) });
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala = Qt(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.aoY().a(this.Adk.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.AfQ)
    {
      locala.a(this.Adk.getActivity(), paramView);
      locala.AfQ = true;
    }
    locala.Adl = cni();
    locala.aoY().a(this.Adk.getActivity(), paramView, locala, this.Adk.b(locala), this.Adk.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 8;
  }
  
  protected abstract a mM(int paramInt);
  
  public final void ri(boolean paramBoolean)
  {
    this.Adl = paramBoolean;
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.o
 * JD-Core Version:    0.7.0.1
 */