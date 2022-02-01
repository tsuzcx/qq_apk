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
  private SparseArray<a> acDH;
  public o afex;
  public boolean afey;
  private boolean afez;
  private int scene;
  
  public q(o paramo, boolean paramBoolean, int paramInt)
  {
    this(paramo, paramBoolean, paramInt, false);
  }
  
  public q(o paramo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    this.afex = paramo;
    this.afey = paramBoolean1;
    this.acDH = new SparseArray();
    this.scene = paramInt;
    this.afez = paramBoolean2;
  }
  
  public void Mz(boolean paramBoolean)
  {
    this.afey = paramBoolean;
    notifyDataSetChanged();
  }
  
  public final a aDt(int paramInt)
  {
    if (this.acDH.indexOfKey(paramInt) >= 0) {
      return (a)this.acDH.get(paramInt);
    }
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      a locala = yk(paramInt);
      if (locala != null)
      {
        locala.vDh = d(locala);
        this.acDH.put(paramInt, locala);
        Log.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[] { Integer.valueOf(locala.viewType), Integer.valueOf(paramInt) });
        return locala;
      }
      Log.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
      return locala;
    }
    Log.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[] { Integer.valueOf(paramInt) });
    return null;
  }
  
  public boolean aDu(int paramInt)
  {
    return false;
  }
  
  public final void clearCache()
  {
    if (this.acDH != null) {
      this.acDH.clear();
    }
  }
  
  protected boolean d(a parama)
  {
    return false;
  }
  
  public void finish()
  {
    clearCache();
  }
  
  public boolean gZe()
  {
    return this.afey;
  }
  
  public long getItemId(int paramInt)
  {
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    if (aDt(paramInt) != null) {
      return aDt(paramInt).viewType;
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
    a locala = aDt(paramInt);
    View localView = paramView;
    if (paramView == null) {
      localView = locala.bVv().a(this.afex.getActivity(), paramViewGroup);
    }
    paramView = (a.a)localView.getTag();
    Assert.assertNotNull(paramView);
    if (!locala.afjz)
    {
      locala.a(this.afex.getActivity(), paramView);
      locala.afjz = true;
    }
    locala.afey = gZe();
    locala.desc = this.afex.c(locala);
    locala.bVv().a(this.afex.getActivity(), paramView, locala, this.afex.b(locala), this.afex.a(locala));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 10;
  }
  
  public final boolean jyD()
  {
    return this.afez;
  }
  
  public int jyc()
  {
    return 0;
  }
  
  protected abstract a yk(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.q
 * JD-Core Version:    0.7.0.1
 */