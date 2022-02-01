package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends RecyclerView.a<RecyclerView.w>
  implements c.b
{
  int bgColor;
  private Context context;
  private LinearLayoutManager zTo;
  g zZP;
  private LinkedHashMap<String, m> zZQ;
  int zZR;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(97063);
    this.zTo = paramLinearLayoutManager;
    this.zZP = paramg;
    this.zZQ = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(97063);
  }
  
  private m Rj(int paramInt)
  {
    AppMethodBeat.i(97073);
    Object localObject = (y)this.zZP.AcQ.get(paramInt);
    localObject = (m)this.zZQ.get(((y)localObject).zRg);
    AppMethodBeat.o(97073);
    return localObject;
  }
  
  public final void Re(int paramInt)
  {
    AppMethodBeat.i(97074);
    if ((paramInt < 0) || (paramInt >= this.zZP.AcQ.size()))
    {
      ae.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zZP.AcQ.size()) });
      AppMethodBeat.o(97074);
      return;
    }
    Object localObject = (y)this.zZP.AcQ.get(paramInt);
    localObject = (m)this.zZQ.get(((y)localObject).zRg);
    if (localObject != null) {
      ((m)localObject).dUL();
    }
    AppMethodBeat.o(97074);
  }
  
  public final boolean Rf(int paramInt)
  {
    AppMethodBeat.i(97067);
    if ((paramInt < this.zTo.km()) || (paramInt > this.zTo.ko()))
    {
      ae.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(97067);
      return false;
    }
    Object localObject = (y)this.zZP.AcQ.get(paramInt);
    localObject = (m)this.zZQ.get(((y)localObject).zRg);
    if (localObject != null)
    {
      ae.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((m)localObject).eay()) });
      boolean bool = ((m)localObject).eay();
      AppMethodBeat.o(97067);
      return bool;
    }
    AppMethodBeat.o(97067);
    return false;
  }
  
  public final boolean Rg(int paramInt)
  {
    AppMethodBeat.i(97070);
    boolean bool = i.Rk(((y)this.zZP.AcQ.get(paramInt)).type);
    AppMethodBeat.o(97070);
    return bool;
  }
  
  public final void Rh(int paramInt)
  {
    AppMethodBeat.i(97072);
    m localm = Rj(paramInt);
    if (i.Rk(localm.eaw().type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localm).eai();
    }
    AppMethodBeat.o(97072);
  }
  
  public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(97064);
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492938, paramViewGroup, false));
    AppMethodBeat.o(97064);
    return paramViewGroup;
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(97071);
    Object localObject = (y)this.zZP.AcQ.get(paramInt);
    m localm = (m)this.zZQ.get(((y)localObject).zRg);
    if (localm != null)
    {
      localm.dUK();
      localm.dZO();
      if ((((y)localObject).type == 61) || (((y)localObject).type == 62))
      {
        localObject = new ArrayList();
        paramc = paramc.zTn.entrySet().iterator();
        while (paramc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramc.next();
          if (((c.a)localEntry.getValue()).zPy) {
            ((List)localObject).add(localEntry.getKey());
          }
        }
        paramc = ((List)localObject).iterator();
        while (paramc.hasNext())
        {
          int i = ((Integer)paramc.next()).intValue();
          if ((i != paramInt) && (Rf(i)))
          {
            localObject = Rj(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).zPt) && (this.zZP.uej) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localm).dZN();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localm).zPt) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dZN();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(97071);
  }
  
  public final void a(RecyclerView.w paramw, int paramInt)
  {
    AppMethodBeat.i(97065);
    ae.i("MicroMsg.ContentAdapter", "display page " + this.zZP.id + ", pos " + paramInt);
    a locala = (a)paramw;
    a.a(locala).removeAllViews();
    y localy = (y)this.zZP.AcQ.get(paramInt);
    paramw = (m)this.zZQ.get(localy.zRg);
    int j = this.bgColor;
    int i = j;
    if (localy.zRl != null)
    {
      i = j;
      if (localy.zRl.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localy.zRl);
      a.a(locala).setBackgroundColor(i);
      if (paramw != null)
      {
        paramw.a((y)this.zZP.AcQ.get(paramInt));
        if (paramw != null)
        {
          paramw = paramw.getView();
          if ((paramw.getParent() != null) && ((paramw.getParent() instanceof ViewGroup))) {
            ((ViewGroup)paramw.getParent()).removeView(paramw);
          }
          a.a(locala).addView(paramw);
        }
        if (paramInt == 0)
        {
          paramw = (m)ebh().iterator().next();
          if ((paramw != null) && ((paramw instanceof v)))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("startIndex", Integer.valueOf(this.zZR));
            paramw.aS(localHashMap);
          }
        }
        AppMethodBeat.o(97065);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localy.zRl });
        i = j;
        continue;
        m localm = av.a(a.a(locala).getContext(), localy, a.a(locala), i);
        paramw = localm;
        if (localm != null)
        {
          this.zZQ.put(localy.zRg, localm);
          paramw = localm;
        }
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97076);
    if (this.zZP != paramg)
    {
      this.zZP = paramg;
      this.asY.notifyChanged();
    }
    AppMethodBeat.o(97076);
  }
  
  public final m ebf()
  {
    AppMethodBeat.i(97068);
    try
    {
      int i = this.zTo.ko();
      Object localObject = (y)this.zZP.AcQ.get(i);
      localObject = (m)this.zZQ.get(((y)localObject).zRg);
      AppMethodBeat.o(97068);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97068);
    }
    return null;
  }
  
  public final m ebg()
  {
    AppMethodBeat.i(97069);
    try
    {
      int i = this.zTo.ko();
      Object localObject = (y)this.zZP.AcQ.get(i - 1);
      localObject = (m)this.zZQ.get(((y)localObject).zRg);
      AppMethodBeat.o(97069);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97069);
    }
    return null;
  }
  
  public final Collection<m> ebh()
  {
    AppMethodBeat.i(97077);
    if (this.zZQ == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97077);
      return localObject;
    }
    Object localObject = this.zZQ.values();
    AppMethodBeat.o(97077);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(97066);
    int i = this.zZP.AcQ.size();
    AppMethodBeat.o(97066);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return paramInt;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(97075);
    Iterator localIterator = this.zZQ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).dUM();
    }
    AppMethodBeat.o(97075);
  }
  
  public final class a
    extends RecyclerView.w
  {
    private LinearLayout ngh;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(97062);
      this.ngh = ((LinearLayout)paramView.findViewById(2131298739));
      AppMethodBeat.o(97062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */