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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ad;
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
  private LinearLayoutManager zCm;
  g zII;
  private LinkedHashMap<String, l> zIJ;
  int zIK;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(97063);
    this.zCm = paramLinearLayoutManager;
    this.zII = paramg;
    this.zIJ = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(97063);
  }
  
  private l QC(int paramInt)
  {
    AppMethodBeat.i(97073);
    Object localObject = (x)this.zII.zLJ.get(paramInt);
    localObject = (l)this.zIJ.get(((x)localObject).zAg);
    AppMethodBeat.o(97073);
    return localObject;
  }
  
  public final void QA(int paramInt)
  {
    AppMethodBeat.i(97072);
    l locall = QC(paramInt);
    if (i.QD(locall.dWS().type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)locall).dWG();
    }
    AppMethodBeat.o(97072);
  }
  
  public final void Qx(int paramInt)
  {
    AppMethodBeat.i(97074);
    if ((paramInt < 0) || (paramInt >= this.zII.zLJ.size()))
    {
      ad.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zII.zLJ.size()) });
      AppMethodBeat.o(97074);
      return;
    }
    Object localObject = (x)this.zII.zLJ.get(paramInt);
    localObject = (l)this.zIJ.get(((x)localObject).zAg);
    if (localObject != null) {
      ((l)localObject).dRn();
    }
    AppMethodBeat.o(97074);
  }
  
  public final boolean Qy(int paramInt)
  {
    AppMethodBeat.i(97067);
    if ((paramInt < this.zCm.km()) || (paramInt > this.zCm.ko()))
    {
      ad.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(97067);
      return false;
    }
    Object localObject = (x)this.zII.zLJ.get(paramInt);
    localObject = (l)this.zIJ.get(((x)localObject).zAg);
    if (localObject != null)
    {
      ad.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((l)localObject).dWU()) });
      boolean bool = ((l)localObject).dWU();
      AppMethodBeat.o(97067);
      return bool;
    }
    AppMethodBeat.o(97067);
    return false;
  }
  
  public final boolean Qz(int paramInt)
  {
    AppMethodBeat.i(97070);
    boolean bool = i.QD(((x)this.zII.zLJ.get(paramInt)).type);
    AppMethodBeat.o(97070);
    return bool;
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
    Object localObject = (x)this.zII.zLJ.get(paramInt);
    l locall = (l)this.zIJ.get(((x)localObject).zAg);
    if (locall != null)
    {
      locall.dRm();
      locall.dWm();
      if ((((x)localObject).type == 61) || (((x)localObject).type == 62))
      {
        localObject = new ArrayList();
        paramc = paramc.zCl.entrySet().iterator();
        while (paramc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramc.next();
          if (((c.a)localEntry.getValue()).zxZ) {
            ((List)localObject).add(localEntry.getKey());
          }
        }
        paramc = ((List)localObject).iterator();
        while (paramc.hasNext())
        {
          int i = ((Integer)paramc.next()).intValue();
          if ((i != paramInt) && (Qy(i)))
          {
            localObject = QC(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).zxU) && (this.zII.tTr) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)locall).dWl();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)locall).zxU) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dWl();
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
    ad.i("MicroMsg.ContentAdapter", "display page " + this.zII.id + ", pos " + paramInt);
    a locala = (a)paramw;
    a.a(locala).removeAllViews();
    x localx = (x)this.zII.zLJ.get(paramInt);
    paramw = (l)this.zIJ.get(localx.zAg);
    int j = this.bgColor;
    int i = j;
    if (localx.zAl != null)
    {
      i = j;
      if (localx.zAl.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localx.zAl);
      a.a(locala).setBackgroundColor(i);
      if (paramw != null)
      {
        paramw.a((x)this.zII.zLJ.get(paramInt));
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
          paramw = (l)dXE().iterator().next();
          if ((paramw != null) && ((paramw instanceof u)))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("startIndex", Integer.valueOf(this.zIK));
            paramw.aM(localHashMap);
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
        ad.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localx.zAl });
        i = j;
        continue;
        l locall = av.a(a.a(locala).getContext(), localx, a.a(locala), i);
        paramw = locall;
        if (locall != null)
        {
          this.zIJ.put(localx.zAg, locall);
          paramw = locall;
        }
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97076);
    if (this.zII != paramg)
    {
      this.zII = paramg;
      this.asY.notifyChanged();
    }
    AppMethodBeat.o(97076);
  }
  
  public final l dXC()
  {
    AppMethodBeat.i(97068);
    try
    {
      int i = this.zCm.ko();
      Object localObject = (x)this.zII.zLJ.get(i);
      localObject = (l)this.zIJ.get(((x)localObject).zAg);
      AppMethodBeat.o(97068);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97068);
    }
    return null;
  }
  
  public final l dXD()
  {
    AppMethodBeat.i(97069);
    try
    {
      int i = this.zCm.ko();
      Object localObject = (x)this.zII.zLJ.get(i - 1);
      localObject = (l)this.zIJ.get(((x)localObject).zAg);
      AppMethodBeat.o(97069);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97069);
    }
    return null;
  }
  
  public final Collection<l> dXE()
  {
    AppMethodBeat.i(97077);
    if (this.zIJ == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97077);
      return localObject;
    }
    Object localObject = this.zIJ.values();
    AppMethodBeat.o(97077);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(97066);
    int i = this.zII.zLJ.size();
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
    Iterator localIterator = this.zIJ.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((l)((Map.Entry)localIterator.next()).getValue()).dRo();
    }
    AppMethodBeat.o(97075);
  }
  
  public final class a
    extends RecyclerView.w
  {
    private LinearLayout naZ;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(97062);
      this.naZ = ((LinearLayout)paramView.findViewById(2131298739));
      AppMethodBeat.o(97062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */