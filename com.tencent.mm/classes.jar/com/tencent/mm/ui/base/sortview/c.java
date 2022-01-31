package com.tencent.mm.ui.base.sortview;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends BaseAdapter
{
  List<d> zsD;
  private Map<String, Integer> zsI;
  private c.a zsJ;
  
  public c(c.a parama)
  {
    AppMethodBeat.i(107310);
    this.zsD = null;
    if (parama == null)
    {
      parama = new RuntimeException("ViewCreator can not be null.");
      AppMethodBeat.o(107310);
      throw parama;
    }
    this.zsJ = parama;
    this.zsD = new ArrayList();
    this.zsI = new HashMap();
    AppMethodBeat.o(107310);
  }
  
  private String OX(int paramInt)
  {
    AppMethodBeat.i(107318);
    if ((paramInt < 0) || (paramInt >= this.zsD.size()))
    {
      AppMethodBeat.o(107318);
      return null;
    }
    String str = ((d)this.zsD.get(paramInt)).zsM;
    AppMethodBeat.o(107318);
    return str;
  }
  
  private static String a(d paramd)
  {
    if ((paramd != null) && (paramd.zsM != null)) {
      return paramd.zsM;
    }
    return null;
  }
  
  private void dET()
  {
    AppMethodBeat.i(107314);
    this.zsI.clear();
    Object localObject = null;
    int i = 0;
    if (i < this.zsD.size())
    {
      String str = a((d)this.zsD.get(i));
      if ((str == null) || (str.equalsIgnoreCase((String)localObject))) {
        break label90;
      }
      this.zsI.put(str, Integer.valueOf(i));
      localObject = str;
    }
    label90:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(107314);
      return;
    }
  }
  
  private void eV(List<d> paramList)
  {
    AppMethodBeat.i(107313);
    if (this.zsD != paramList)
    {
      this.zsD.clear();
      if (paramList != null) {
        this.zsD.addAll(paramList);
      }
    }
    dET();
    notifyDataSetChanged();
    AppMethodBeat.o(107313);
  }
  
  public final int atC(String paramString)
  {
    AppMethodBeat.i(107319);
    int i = bo.a((Integer)this.zsI.get(paramString), -1);
    AppMethodBeat.o(107319);
    return i;
  }
  
  public final void dI(List<d> paramList)
  {
    AppMethodBeat.i(107312);
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      al.d(new c.1(this, paramList));
      AppMethodBeat.o(107312);
      return;
    }
    eV(paramList);
    AppMethodBeat.o(107312);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(107315);
    int i = this.zsD.size();
    AppMethodBeat.o(107315);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(107316);
    Object localObject = this.zsD.get(paramInt);
    AppMethodBeat.o(107316);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    AppMethodBeat.i(107317);
    paramViewGroup = (d)getItem(paramInt);
    Object localObject = OX(paramInt);
    String str = OX(paramInt + 1);
    boolean bool1;
    if (paramInt == atC((String)localObject))
    {
      bool1 = true;
      if ((localObject == null) || (((String)localObject).equalsIgnoreCase(str))) {
        break label100;
      }
    }
    for (;;)
    {
      localObject = this.zsJ;
      getCount();
      paramView = ((c.a)localObject).a(paramViewGroup, paramView, paramInt, bool1, bool2);
      AppMethodBeat.o(107317);
      return paramView;
      bool1 = false;
      break;
      label100:
      bool2 = false;
    }
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(107311);
    dI(this.zsD);
    AppMethodBeat.o(107311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.c
 * JD-Core Version:    0.7.0.1
 */