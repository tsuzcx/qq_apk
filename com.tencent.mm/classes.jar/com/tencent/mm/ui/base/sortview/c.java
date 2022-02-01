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
  List<d> aeaC;
  private Map<String, Integer> aeaH;
  private a aeaI;
  
  public c(a parama)
  {
    AppMethodBeat.i(142694);
    this.aeaC = null;
    if (parama == null)
    {
      parama = new RuntimeException("ViewCreator can not be null.");
      AppMethodBeat.o(142694);
      throw parama;
    }
    this.aeaI = parama;
    this.aeaC = new ArrayList();
    this.aeaH = new HashMap();
    AppMethodBeat.o(142694);
  }
  
  private static String a(d paramd)
  {
    if ((paramd != null) && (paramd.aeaK != null)) {
      return paramd.aeaK;
    }
    return null;
  }
  
  private String aBr(int paramInt)
  {
    AppMethodBeat.i(142702);
    if ((paramInt < 0) || (paramInt >= this.aeaC.size()))
    {
      AppMethodBeat.o(142702);
      return null;
    }
    String str = ((d)this.aeaC.get(paramInt)).aeaK;
    AppMethodBeat.o(142702);
    return str;
  }
  
  private void jnH()
  {
    AppMethodBeat.i(142698);
    this.aeaH.clear();
    Object localObject = null;
    int i = 0;
    if (i < this.aeaC.size())
    {
      String str = a((d)this.aeaC.get(i));
      if ((str == null) || (str.equalsIgnoreCase((String)localObject))) {
        break label90;
      }
      this.aeaH.put(str, Integer.valueOf(i));
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
  
  private void nm(List<d> paramList)
  {
    AppMethodBeat.i(142697);
    if (this.aeaC != paramList)
    {
      this.aeaC.clear();
      if (paramList != null) {
        this.aeaC.addAll(paramList);
      }
    }
    jnH();
    notifyDataSetChanged();
    AppMethodBeat.o(142697);
  }
  
  public final int bAp(String paramString)
  {
    AppMethodBeat.i(142703);
    int i = Util.nullAs((Integer)this.aeaH.get(paramString), -1);
    AppMethodBeat.o(142703);
    return i;
  }
  
  public final void bDL()
  {
    AppMethodBeat.i(142695);
    lG(this.aeaC);
    AppMethodBeat.o(142695);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(142699);
    int i = this.aeaC.size();
    AppMethodBeat.o(142699);
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    AppMethodBeat.i(142700);
    Object localObject = this.aeaC.get(paramInt);
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
    d locald = (d)getItem(paramInt);
    String str1 = aBr(paramInt);
    String str2 = aBr(paramInt + 1);
    boolean bool1;
    if (paramInt == bAp(str1))
    {
      bool1 = true;
      if ((str1 == null) || (str1.equalsIgnoreCase(str2))) {
        break label98;
      }
    }
    for (;;)
    {
      paramView = this.aeaI.createView(locald, paramView, paramViewGroup, paramInt, getCount(), bool1, bool2);
      AppMethodBeat.o(142701);
      return paramView;
      bool1 = false;
      break;
      label98:
      bool2 = false;
    }
  }
  
  public final void lG(final List<d> paramList)
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
    nm(paramList);
    AppMethodBeat.o(142696);
  }
  
  public static abstract interface a
  {
    public abstract View createView(d paramd, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.sortview.c
 * JD-Core Version:    0.7.0.1
 */