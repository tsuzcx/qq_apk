package com.tencent.mm.ui.gridviewheaders;

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
  private e Apl;
  private List<f.b> Apm;
  
  public f(e parame)
  {
    AppMethodBeat.i(107414);
    this.Apl = parame;
    parame.registerDataSetObserver(new f.a(this, (byte)0));
    this.Apm = a(parame);
    AppMethodBeat.o(107414);
  }
  
  public final int QG(int paramInt)
  {
    AppMethodBeat.i(107416);
    try
    {
      paramInt = ((f.b)this.Apm.get(paramInt)).mCount;
      AppMethodBeat.o(107416);
      return paramInt;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      AppMethodBeat.o(107416);
    }
    return 0;
  }
  
  public final View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107417);
    paramView = this.Apl.a(((f.b)this.Apm.get(paramInt)).Apo, paramView, paramViewGroup);
    AppMethodBeat.o(107417);
    return paramView;
  }
  
  protected final List<f.b> a(e parame)
  {
    AppMethodBeat.i(107422);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < parame.getCount())
    {
      long l = parame.tC(i);
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
    AppMethodBeat.o(107422);
    return localArrayList;
  }
  
  public final int dNk()
  {
    AppMethodBeat.i(107420);
    int i = this.Apm.size();
    AppMethodBeat.o(107420);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107415);
    int i = this.Apl.getCount();
    AppMethodBeat.o(107415);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(107418);
    Object localObject = this.Apl.getItem(paramInt);
    AppMethodBeat.o(107418);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(107419);
    long l = this.Apl.getItemId(paramInt);
    AppMethodBeat.o(107419);
    return l;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(107421);
    paramView = this.Apl.getView(paramInt, paramView, paramViewGroup);
    AppMethodBeat.o(107421);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.gridviewheaders.f
 * JD-Core Version:    0.7.0.1
 */