package com.tencent.mm.ui.base.sortview;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
  extends BaseAdapter
{
  List<d> JOP;
  private Map<String, Integer> JOU;
  private a JOV;
  
  public c(a parama)
  {
    AppMethodBeat.i(142694);
    this.JOP = null;
    if (parama == null)
    {
      parama = new RuntimeException("ViewCreator can not be null.");
      AppMethodBeat.o(142694);
      throw parama;
    }
    this.JOV = parama;
    this.JOP = new ArrayList();
    this.JOU = new HashMap();
    AppMethodBeat.o(142694);
  }
  
  private static String a(d paramd)
  {
    if ((paramd != null) && (paramd.JOY != null)) {
      return paramd.JOY;
    }
    return null;
  }
  
  private String adf(int paramInt)
  {
    AppMethodBeat.i(142702);
    if ((paramInt < 0) || (paramInt >= this.JOP.size()))
    {
      AppMethodBeat.o(142702);
      return null;
    }
    String str = ((d)this.JOP.get(paramInt)).JOY;
    AppMethodBeat.o(142702);
    return str;
  }
  
  private void fDP()
  {
    AppMethodBeat.i(142698);
    this.JOU.clear();
    Object localObject = null;
    int i = 0;
    if (i < this.JOP.size())
    {
      String str = a((d)this.JOP.get(i));
      if ((str == null) || (str.equalsIgnoreCase((String)localObject))) {
        break label90;
      }
      this.JOU.put(str, Integer.valueOf(i));
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
  
  private void ib(List<d> paramList)
  {
    AppMethodBeat.i(142697);
    if (this.JOP != paramList)
    {
      this.JOP.clear();
      if (paramList != null) {
        this.JOP.addAll(paramList);
      }
    }
    fDP();
    notifyDataSetChanged();
    AppMethodBeat.o(142697);
  }
  
  public final int aXj(String paramString)
  {
    AppMethodBeat.i(142703);
    int i = bu.a((Integer)this.JOU.get(paramString), -1);
    AppMethodBeat.o(142703);
    return i;
  }
  
  public final void gB(final List<d> paramList)
  {
    AppMethodBeat.i(142696);
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      ar.f(new Runnable()
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
    ib(paramList);
    AppMethodBeat.o(142696);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(142699);
    int i = this.JOP.size();
    AppMethodBeat.o(142699);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(142700);
    Object localObject = this.JOP.get(paramInt);
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
    Object localObject = adf(paramInt);
    String str = adf(paramInt + 1);
    boolean bool1;
    if (paramInt == aXj((String)localObject))
    {
      bool1 = true;
      if ((localObject == null) || (((String)localObject).equalsIgnoreCase(str))) {
        break label100;
      }
    }
    for (;;)
    {
      localObject = this.JOV;
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
  
  public final void refresh()
  {
    AppMethodBeat.i(142695);
    gB(this.JOP);
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