package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
  extends BaseAdapter
  implements b
{
  private e vXd;
  private List<f.b> vXe;
  
  public f(e parame)
  {
    this.vXd = parame;
    parame.registerDataSetObserver(new a((byte)0));
    this.vXe = a(parame);
  }
  
  public final int HU(int paramInt)
  {
    try
    {
      paramInt = ((f.b)this.vXe.get(paramInt)).mCount;
      return paramInt;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      localIndexOutOfBoundsException.toString();
    }
    return 0;
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.vXd.a(((f.b)this.vXe.get(paramInt)).vXg, paramView, paramViewGroup);
  }
  
  protected final List<f.b> a(e parame)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < parame.getCount())
    {
      long l = parame.pm(i);
      f.b localb2 = (f.b)localHashMap.get(Long.valueOf(l));
      f.b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new f.b(this, i);
        localArrayList.add(localb1);
      }
      localb1.mCount += 1;
      localHashMap.put(Long.valueOf(l), localb1);
      i += 1;
    }
    return localArrayList;
  }
  
  public final int cIA()
  {
    return this.vXe.size();
  }
  
  public final int getCount()
  {
    return this.vXd.getCount();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.vXd.getItem(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return this.vXd.getItemId(paramInt);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.vXd.getView(paramInt, paramView, paramViewGroup);
  }
  
  private final class a
    extends DataSetObserver
  {
    private a() {}
    
    public final void onChanged()
    {
      f.a(f.this, f.this.a(f.a(f.this)));
      f.this.notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      f.a(f.this, f.this.a(f.a(f.this)));
      f.this.notifyDataSetInvalidated();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.f
 * JD-Core Version:    0.7.0.1
 */