package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
  extends BaseAdapter
  implements b
{
  private e KBh;
  private List<b> KBi;
  
  public f(e parame)
  {
    AppMethodBeat.i(142848);
    this.KBh = parame;
    parame.registerDataSetObserver(new a((byte)0));
    this.KBi = a(parame);
    AppMethodBeat.o(142848);
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142851);
    paramView = this.KBh.a(((b)this.KBi.get(paramInt)).KBk, paramView, paramViewGroup);
    AppMethodBeat.o(142851);
    return paramView;
  }
  
  protected final List<b> a(e parame)
  {
    AppMethodBeat.i(142856);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < parame.getCount())
    {
      long l = parame.AW(i);
      b localb2 = (b)localHashMap.get(Long.valueOf(l));
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b(i);
        localArrayList.add(localb1);
      }
      localb1.mCount += 1;
      localHashMap.put(Long.valueOf(l), localb1);
      i += 1;
    }
    AppMethodBeat.o(142856);
    return localArrayList;
  }
  
  public final int aeI(int paramInt)
  {
    AppMethodBeat.i(142850);
    try
    {
      paramInt = ((b)this.KBi.get(paramInt)).mCount;
      AppMethodBeat.o(142850);
      return paramInt;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(142850);
    }
    return 0;
  }
  
  public final int fJH()
  {
    AppMethodBeat.i(142854);
    int i = this.KBi.size();
    AppMethodBeat.o(142854);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(142849);
    int i = this.KBh.getCount();
    AppMethodBeat.o(142849);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(142852);
    Object localObject = this.KBh.getItem(paramInt);
    AppMethodBeat.o(142852);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(142853);
    long l = this.KBh.getItemId(paramInt);
    AppMethodBeat.o(142853);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(142855);
    paramView = this.KBh.getView(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(142855);
    return paramView;
  }
  
  final class a
    extends DataSetObserver
  {
    private a() {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(142846);
      f.a(f.this, f.this.a(f.a(f.this)));
      f.this.notifyDataSetChanged();
      AppMethodBeat.o(142846);
    }
    
    public final void onInvalidated()
    {
      AppMethodBeat.i(142847);
      f.a(f.this, f.this.a(f.a(f.this)));
      f.this.notifyDataSetInvalidated();
      AppMethodBeat.o(142847);
    }
  }
  
  final class b
  {
    int KBk;
    int mCount;
    
    public b(int paramInt)
    {
      this.KBk = paramInt;
      this.mCount = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.f
 * JD-Core Version:    0.7.0.1
 */