package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ab;
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
  extends RecyclerView.a<RecyclerView.v>
  implements c.b
{
  int bgColor;
  private Context context;
  private LinearLayoutManager ruC;
  g rzb;
  private LinkedHashMap<String, h> rzc;
  int rzd;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(37600);
    this.ruC = paramLinearLayoutManager;
    this.rzb = paramg;
    this.rzc = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(37600);
  }
  
  private h En(int paramInt)
  {
    AppMethodBeat.i(37608);
    Object localObject = (t)this.rzb.rCg.get(paramInt);
    localObject = (h)this.rzc.get(((t)localObject).rsI);
    AppMethodBeat.o(37608);
    return localObject;
  }
  
  public final void Ei(int paramInt)
  {
    AppMethodBeat.i(37609);
    if ((paramInt < 0) || (paramInt >= this.rzb.rCg.size()))
    {
      ab.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rzb.rCg.size()) });
      AppMethodBeat.o(37609);
      return;
    }
    Object localObject = (t)this.rzb.rCg.get(paramInt);
    localObject = (h)this.rzc.get(((t)localObject).rsI);
    if (localObject != null) {
      ((h)localObject).cqB();
    }
    AppMethodBeat.o(37609);
  }
  
  public final boolean Ej(int paramInt)
  {
    AppMethodBeat.i(37604);
    if ((paramInt < this.ruC.it()) || (paramInt > this.ruC.iv()))
    {
      ab.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(37604);
      return false;
    }
    Object localObject = (t)this.rzb.rCg.get(paramInt);
    localObject = (h)this.rzc.get(((t)localObject).rsI);
    if (localObject != null)
    {
      ab.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((h)localObject).cqX()) });
      boolean bool = ((h)localObject).cqX();
      AppMethodBeat.o(37604);
      return bool;
    }
    AppMethodBeat.o(37604);
    return false;
  }
  
  public final boolean Ek(int paramInt)
  {
    AppMethodBeat.i(37605);
    boolean bool = i.Eo(((t)this.rzb.rCg.get(paramInt)).type);
    AppMethodBeat.o(37605);
    return bool;
  }
  
  public final void El(int paramInt)
  {
    AppMethodBeat.i(37607);
    h localh = En(paramInt);
    if (i.Eo(localh.cqV().type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localh).cqS();
    }
    AppMethodBeat.o(37607);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(37601);
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2130968630, paramViewGroup, false));
    AppMethodBeat.o(37601);
    return paramViewGroup;
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(37606);
    Object localObject = (t)this.rzb.rCg.get(paramInt);
    h localh = (h)this.rzc.get(((t)localObject).rsI);
    if (localh != null)
    {
      localh.cqA();
      localh.cqC();
      if ((((t)localObject).type == 61) || (((t)localObject).type == 62))
      {
        localObject = new ArrayList();
        paramc = paramc.ruB.entrySet().iterator();
        while (paramc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramc.next();
          if (((c.a)localEntry.getValue()).rrB) {
            ((List)localObject).add(localEntry.getKey());
          }
        }
        paramc = ((List)localObject).iterator();
        while (paramc.hasNext())
        {
          int i = ((Integer)paramc.next()).intValue();
          if ((i != paramInt) && (Ej(i)))
          {
            localObject = En(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).rrz) && (this.rzb.njm) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localh).cqy();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localh).rrz) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).cqy();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(37606);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(37602);
    ab.i("MicroMsg.ContentAdapter", "display page " + this.rzb.id + ", pos " + paramInt);
    a locala = (a)paramv;
    a.a(locala).removeAllViews();
    t localt = (t)this.rzb.rCg.get(paramInt);
    paramv = (h)this.rzc.get(localt.rsI);
    int j = this.bgColor;
    int i = j;
    if (localt.rsN != null)
    {
      i = j;
      if (localt.rsN.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localt.rsN);
      a.a(locala).setBackgroundColor(i);
      if (paramv != null)
      {
        paramv.a((t)this.rzb.rCg.get(paramInt));
        if (paramv != null)
        {
          paramv = paramv.getView();
          if ((paramv.getParent() != null) && ((paramv.getParent() instanceof ViewGroup))) {
            ((ViewGroup)paramv.getParent()).removeView(paramv);
          }
          a.a(locala).addView(paramv);
        }
        if (paramInt == 0)
        {
          paramv = (h)crG().iterator().next();
          if ((paramv != null) && ((paramv instanceof o)))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("startIndex", Integer.valueOf(this.rzd));
            paramv.ae(localHashMap);
          }
        }
        AppMethodBeat.o(37602);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localt.rsN });
        i = j;
        continue;
        h localh = al.a(a.a(locala).getContext(), localt, a.a(locala), i);
        paramv = localh;
        if (localh != null)
        {
          this.rzc.put(localt.rsI, localh);
          paramv = localh;
        }
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(37611);
    if (this.rzb != paramg)
    {
      this.rzb = paramg;
      this.ajb.notifyChanged();
    }
    AppMethodBeat.o(37611);
  }
  
  public final Collection<h> crG()
  {
    AppMethodBeat.i(37612);
    if (this.rzc == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(37612);
      return localObject;
    }
    Object localObject = this.rzc.values();
    AppMethodBeat.o(37612);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(37603);
    int i = this.rzb.rCg.size();
    AppMethodBeat.o(37603);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return paramInt;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(37610);
    Iterator localIterator = this.rzc.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((h)((Map.Entry)localIterator.next()).getValue()).cqz();
    }
    AppMethodBeat.o(37610);
  }
  
  public final class a
    extends RecyclerView.v
  {
    private LinearLayout jja;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(37599);
      this.jja = ((LinearLayout)paramView.findViewById(2131820946));
      AppMethodBeat.o(37599);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */