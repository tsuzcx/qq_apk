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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.sdk.platformtools.ac;
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
  private LinearLayoutManager ylx;
  int yrA;
  g yry;
  private LinkedHashMap<String, k> yrz;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(97063);
    this.ylx = paramLinearLayoutManager;
    this.yry = paramg;
    this.yrz = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(97063);
  }
  
  private k OU(int paramInt)
  {
    AppMethodBeat.i(97073);
    Object localObject = (x)this.yry.yuw.get(paramInt);
    localObject = (k)this.yrz.get(((x)localObject).yjs);
    AppMethodBeat.o(97073);
    return localObject;
  }
  
  public final void OP(int paramInt)
  {
    AppMethodBeat.i(97074);
    if ((paramInt < 0) || (paramInt >= this.yry.yuw.size()))
    {
      ac.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.yry.yuw.size()) });
      AppMethodBeat.o(97074);
      return;
    }
    Object localObject = (x)this.yry.yuw.get(paramInt);
    localObject = (k)this.yrz.get(((x)localObject).yjs);
    if (localObject != null) {
      ((k)localObject).dJZ();
    }
    AppMethodBeat.o(97074);
  }
  
  public final boolean OQ(int paramInt)
  {
    AppMethodBeat.i(97067);
    if ((paramInt < this.ylx.jW()) || (paramInt > this.ylx.jY()))
    {
      ac.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(97067);
      return false;
    }
    Object localObject = (x)this.yry.yuw.get(paramInt);
    localObject = (k)this.yrz.get(((x)localObject).yjs);
    if (localObject != null)
    {
      ac.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((k)localObject).dKC()) });
      boolean bool = ((k)localObject).dKC();
      AppMethodBeat.o(97067);
      return bool;
    }
    AppMethodBeat.o(97067);
    return false;
  }
  
  public final boolean OR(int paramInt)
  {
    AppMethodBeat.i(97070);
    boolean bool = i.OV(((x)this.yry.yuw.get(paramInt)).type);
    AppMethodBeat.o(97070);
    return bool;
  }
  
  public final void OS(int paramInt)
  {
    AppMethodBeat.i(97072);
    k localk = OU(paramInt);
    if (i.OV(localk.dKA().type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localk).dKt();
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
    Object localObject = (x)this.yry.yuw.get(paramInt);
    k localk = (k)this.yrz.get(((x)localObject).yjs);
    if (localk != null)
    {
      localk.dJY();
      localk.dKa();
      if ((((x)localObject).type == 61) || (((x)localObject).type == 62))
      {
        localObject = new ArrayList();
        paramc = paramc.ylw.entrySet().iterator();
        while (paramc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramc.next();
          if (((c.a)localEntry.getValue()).yhR) {
            ((List)localObject).add(localEntry.getKey());
          }
        }
        paramc = ((List)localObject).iterator();
        while (paramc.hasNext())
        {
          int i = ((Integer)paramc.next()).intValue();
          if ((i != paramInt) && (OQ(i)))
          {
            localObject = OU(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).yhN) && (this.yry.sWJ) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localk).dJV();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localk).yhN) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dJV();
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
    ac.i("MicroMsg.ContentAdapter", "display page " + this.yry.id + ", pos " + paramInt);
    a locala = (a)paramw;
    a.a(locala).removeAllViews();
    x localx = (x)this.yry.yuw.get(paramInt);
    paramw = (k)this.yrz.get(localx.yjs);
    int j = this.bgColor;
    int i = j;
    if (localx.yjx != null)
    {
      i = j;
      if (localx.yjx.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localx.yjx);
      a.a(locala).setBackgroundColor(i);
      if (paramw != null)
      {
        paramw.a((x)this.yry.yuw.get(paramInt));
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
          paramw = (k)dLn().iterator().next();
          if ((paramw != null) && ((paramw instanceof t)))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("startIndex", Integer.valueOf(this.yrA));
            paramw.aJ(localHashMap);
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
        ac.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localx.yjx });
        i = j;
        continue;
        k localk = as.a(a.a(locala).getContext(), localx, a.a(locala), i);
        paramw = localk;
        if (localk != null)
        {
          this.yrz.put(localx.yjs, localk);
          paramw = localk;
        }
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97076);
    if (this.yry != paramg)
    {
      this.yry = paramg;
      this.arg.notifyChanged();
    }
    AppMethodBeat.o(97076);
  }
  
  public final k dLl()
  {
    AppMethodBeat.i(97068);
    try
    {
      int i = this.ylx.jY();
      Object localObject = (x)this.yry.yuw.get(i);
      localObject = (k)this.yrz.get(((x)localObject).yjs);
      AppMethodBeat.o(97068);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97068);
    }
    return null;
  }
  
  public final k dLm()
  {
    AppMethodBeat.i(97069);
    try
    {
      int i = this.ylx.jY();
      Object localObject = (x)this.yry.yuw.get(i - 1);
      localObject = (k)this.yrz.get(((x)localObject).yjs);
      AppMethodBeat.o(97069);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97069);
    }
    return null;
  }
  
  public final Collection<k> dLn()
  {
    AppMethodBeat.i(97077);
    if (this.yrz == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97077);
      return localObject;
    }
    Object localObject = this.yrz.values();
    AppMethodBeat.o(97077);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(97066);
    int i = this.yry.yuw.size();
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
    Iterator localIterator = this.yrz.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((k)((Map.Entry)localIterator.next()).getValue()).dJX();
    }
    AppMethodBeat.o(97075);
  }
  
  public final class a
    extends RecyclerView.w
  {
    private LinearLayout mAr;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(97062);
      this.mAr = ((LinearLayout)paramView.findViewById(2131298739));
      AppMethodBeat.o(97062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */