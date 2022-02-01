package com.tencent.mm.ui.base.sortview;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c
  extends BaseAdapter
{
  List<d> Wti;
  private Map<String, Integer> Wtn;
  private a Wto;
  
  public c(a parama)
  {
    AppMethodBeat.i(142694);
    this.Wti = null;
    if (parama == null)
    {
      parama = new RuntimeException("ViewCreator can not be null.");
      AppMethodBeat.o(142694);
      throw parama;
    }
    this.Wto = parama;
    this.Wti = new ArrayList();
    this.Wtn = new HashMap();
    AppMethodBeat.o(142694);
  }
  
  private static String a(d paramd)
  {
    if ((paramd != null) && (paramd.Wtr != null)) {
      return paramd.Wtr;
    }
    return null;
  }
  
  private String auP(int paramInt)
  {
    AppMethodBeat.i(142702);
    if ((paramInt < 0) || (paramInt >= this.Wti.size()))
    {
      AppMethodBeat.o(142702);
      return null;
    }
    String str = ((d)this.Wti.get(paramInt)).Wtr;
    AppMethodBeat.o(142702);
    return str;
  }
  
  private void hLe()
  {
    AppMethodBeat.i(142698);
    this.Wtn.clear();
    Object localObject = null;
    int i = 0;
    if (i < this.Wti.size())
    {
      String str = a((d)this.Wti.get(i));
      if ((str == null) || (str.equalsIgnoreCase((String)localObject))) {
        break label90;
      }
      this.Wtn.put(str, Integer.valueOf(i));
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
  
  private void jX(List<d> paramList)
  {
    AppMethodBeat.i(142697);
    if (this.Wti != paramList)
    {
      this.Wti.clear();
      if (paramList != null) {
        this.Wti.addAll(paramList);
      }
    }
    hLe();
    notifyDataSetChanged();
    AppMethodBeat.o(142697);
  }
  
  public final void bfU()
  {
    AppMethodBeat.i(142695);
    ig(this.Wti);
    AppMethodBeat.o(142695);
  }
  
  public final int byM(String paramString)
  {
    AppMethodBeat.i(142703);
    int i = Util.nullAs((Integer)this.Wtn.get(paramString), -1);
    AppMethodBeat.o(142703);
    return i;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(142699);
    int i = this.Wti.size();
    AppMethodBeat.o(142699);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(142700);
    Object localObject = this.Wti.get(paramInt);
    AppMethodBeat.o(142700);
    return localObject;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool2 = true;
    AppMethodBeat.i(142701);
    paramViewGroup = (d)getItem(paramInt);
    Object localObject = auP(paramInt);
    String str = auP(paramInt + 1);
    boolean bool1;
    if (paramInt == byM((String)localObject))
    {
      bool1 = true;
      if ((localObject == null) || (((String)localObject).equalsIgnoreCase(str))) {
        break label100;
      }
    }
    for (;;)
    {
      localObject = this.Wto;
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
  
  public final void ig(final List<d> paramList)
  {
    AppMethodBeat.i(142696);
    if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId())
    {
      MMHandlerThread.postToMainThread(new Runnable()
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
    jX(paramList);
    AppMethodBeat.o(142696);
  }
  
  public static abstract interface a
  {
    public abstract View a(d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.c
 * JD-Core Version:    0.7.0.1
 */