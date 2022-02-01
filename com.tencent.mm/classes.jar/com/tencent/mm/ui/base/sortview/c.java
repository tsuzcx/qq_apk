package com.tencent.mm.ui.base.sortview;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends BaseAdapter
{
  List<d> Jua;
  private Map<String, Integer> Juf;
  private a Jug;
  
  public c(a parama)
  {
    AppMethodBeat.i(142694);
    this.Jua = null;
    if (parama == null)
    {
      parama = new RuntimeException("ViewCreator can not be null.");
      AppMethodBeat.o(142694);
      throw parama;
    }
    this.Jug = parama;
    this.Jua = new ArrayList();
    this.Juf = new HashMap();
    AppMethodBeat.o(142694);
  }
  
  private static String a(d paramd)
  {
    if ((paramd != null) && (paramd.Juj != null)) {
      return paramd.Juj;
    }
    return null;
  }
  
  private String acx(int paramInt)
  {
    AppMethodBeat.i(142702);
    if ((paramInt < 0) || (paramInt >= this.Jua.size()))
    {
      AppMethodBeat.o(142702);
      return null;
    }
    String str = ((d)this.Jua.get(paramInt)).Juj;
    AppMethodBeat.o(142702);
    return str;
  }
  
  private void fzN()
  {
    AppMethodBeat.i(142698);
    this.Juf.clear();
    Object localObject = null;
    int i = 0;
    if (i < this.Jua.size())
    {
      String str = a((d)this.Jua.get(i));
      if ((str == null) || (str.equalsIgnoreCase((String)localObject))) {
        break label90;
      }
      this.Juf.put(str, Integer.valueOf(i));
      localObject = str;
    }
    label90:
    for (;;)
    {
      i += 1;
      break;
      AppMethodBeat.o(142698);
      return;
    }
  }
  
  private void hR(List<d> paramList)
  {
    AppMethodBeat.i(142697);
    if (this.Jua != paramList)
    {
      this.Jua.clear();
      if (paramList != null) {
        this.Jua.addAll(paramList);
      }
    }
    fzN();
    notifyDataSetChanged();
    AppMethodBeat.o(142697);
  }
  
  public final int aVI(String paramString)
  {
    AppMethodBeat.i(142703);
    int i = bt.a((Integer)this.Juf.get(paramString), -1);
    AppMethodBeat.o(142703);
    return i;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(142699);
    int i = this.Jua.size();
    AppMethodBeat.o(142699);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(142700);
    Object localObject = this.Jua.get(paramInt);
    AppMethodBeat.o(142700);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142701);
    paramViewGroup = (d)getItem(paramInt);
    Object localObject = acx(paramInt);
    String str = acx(paramInt + 1);
    boolean bool1;
    if (paramInt == aVI((String)localObject))
    {
      bool1 = true;
      if ((localObject == null) || (((String)localObject).equalsIgnoreCase(str))) {
        break label100;
      }
    }
    for (;;)
    {
      localObject = this.Jug;
      getCount();
      paramView = ((a)localObject).a(paramViewGroup, paramView, paramInt, bool1, bool2);
      AppMethodBeat.o(142701);
      return paramView;
      bool1 = false;
      break;
      label100:
      bool2 = false;
    }
  }
  
  public final void gs(final List<d> paramList)
  {
    AppMethodBeat.i(142696);
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(142693);
          c.a(c.this, paramList);
          AppMethodBeat.o(142693);
        }
      });
      AppMethodBeat.o(142696);
      return;
    }
    hR(paramList);
    AppMethodBeat.o(142696);
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(142695);
    gs(this.Jua);
    AppMethodBeat.o(142695);
  }
  
  public static abstract interface a
  {
    public abstract View a(d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.c
 * JD-Core Version:    0.7.0.1
 */