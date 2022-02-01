package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.ba;
import com.tencent.mm.sdk.platformtools.Log;
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
  private LinearLayoutManager Arh;
  g Kvn;
  private LinkedHashMap<String, m> Kvo;
  int Kvp;
  int bgColor;
  private Context context;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(256815);
    this.Arh = paramLinearLayoutManager;
    this.Kvn = paramg;
    this.Kvo = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(256815);
  }
  
  private m agy(int paramInt)
  {
    AppMethodBeat.i(97073);
    Object localObject = (aa)this.Kvn.Kyp.get(paramInt);
    localObject = (m)this.Kvo.get(((aa)localObject).KmB);
    AppMethodBeat.o(97073);
    return localObject;
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(97071);
    Object localObject = (aa)this.Kvn.Kyp.get(paramInt);
    m localm = (m)this.Kvo.get(((aa)localObject).KmB);
    if (localm != null)
    {
      localm.fKk();
      localm.fKm();
      if ((((aa)localObject).type == 61) || (((aa)localObject).type == 62) || (((aa)localObject).type == 142))
      {
        localObject = new ArrayList();
        paramc = paramc.KoR.entrySet().iterator();
        while (paramc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramc.next();
          if (((c.a)localEntry.getValue()).KkF) {
            ((List)localObject).add(localEntry.getKey());
          }
        }
        paramc = ((List)localObject).iterator();
        while (paramc.hasNext())
        {
          int i = ((Integer)paramc.next()).intValue();
          if ((i != paramInt) && (agt(i)))
          {
            localObject = agy(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).KkA) && (this.Kvn.CAd) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localm).fKr();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localm).KkA) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).fKr();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(97071);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97076);
    if (this.Kvn != paramg)
    {
      this.Kvn = paramg;
      this.alc.notifyChanged();
    }
    AppMethodBeat.o(97076);
  }
  
  public final void ags(int paramInt)
  {
    AppMethodBeat.i(97074);
    if ((paramInt < 0) || (paramInt >= this.Kvn.Kyp.size()))
    {
      Log.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Kvn.Kyp.size()) });
      AppMethodBeat.o(97074);
      return;
    }
    Object localObject = (aa)this.Kvn.Kyp.get(paramInt);
    localObject = (m)this.Kvo.get(((aa)localObject).KmB);
    if (localObject != null) {
      ((m)localObject).fKl();
    }
    AppMethodBeat.o(97074);
  }
  
  public final boolean agt(int paramInt)
  {
    AppMethodBeat.i(97067);
    if ((paramInt < this.Arh.kJ()) || (paramInt > this.Arh.kL()))
    {
      Log.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(97067);
      return false;
    }
    Object localObject = (aa)this.Kvn.Kyp.get(paramInt);
    localObject = (m)this.Kvo.get(((aa)localObject).KmB);
    if (localObject != null)
    {
      Log.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((m)localObject).fRj()) });
      boolean bool = ((m)localObject).fRj();
      AppMethodBeat.o(97067);
      return bool;
    }
    AppMethodBeat.o(97067);
    return false;
  }
  
  public final boolean agu(int paramInt)
  {
    AppMethodBeat.i(97070);
    boolean bool = i.agz(((aa)this.Kvn.Kyp.get(paramInt)).type);
    AppMethodBeat.o(97070);
    return bool;
  }
  
  public final void agv(int paramInt)
  {
    AppMethodBeat.i(97072);
    m localm = agy(paramInt);
    if (i.agz(localm.KqB.type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localm).fKn();
    }
    AppMethodBeat.o(97072);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(256818);
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(i.g.ad_landing_comp_item, paramViewGroup, false));
    AppMethodBeat.o(256818);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(256825);
    Log.i("MicroMsg.ContentAdapter", "display page " + this.Kvn.id + ", pos " + paramInt);
    a locala = (a)paramv;
    a.a(locala).removeAllViews();
    aa localaa = (aa)this.Kvn.Kyp.get(paramInt);
    paramv = (m)this.Kvo.get(localaa.KmB);
    int j = this.bgColor;
    int i = j;
    if (localaa.KmG != null)
    {
      i = j;
      if (localaa.KmG.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localaa.KmG);
      a.a(locala).setBackgroundColor(i);
      if (paramv != null)
      {
        paramv.c((aa)this.Kvn.Kyp.get(paramInt));
        Object localObject;
        if (paramv != null)
        {
          localObject = paramv.getView();
          if ((((View)localObject).getParent() != null) && ((((View)localObject).getParent() instanceof ViewGroup))) {
            ((ViewGroup)((View)localObject).getParent()).removeView((View)localObject);
          }
          a.a(locala).addView((View)localObject);
        }
        if (paramInt != 0) {
          break label362;
        }
        paramv = (m)fRQ().iterator().next();
        if ((paramv != null) && ((paramv instanceof v)))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("startIndex", Integer.valueOf(this.Kvp));
          paramv.aK((Map)localObject);
        }
        AppMethodBeat.o(256825);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localaa.KmG });
        i = j;
        continue;
        m localm = ba.a(a.a(locala).getContext(), localaa, a.a(locala), i);
        paramv = localm;
        if (localm != null)
        {
          this.Kvo.put(localaa.KmB, localm);
          paramv = localm;
        }
      }
      label362:
      if ((paramv instanceof v)) {
        paramv.aK(new HashMap());
      }
      AppMethodBeat.o(256825);
    }
  }
  
  public final m fRO()
  {
    AppMethodBeat.i(97068);
    try
    {
      int i = this.Arh.kL();
      Object localObject = (aa)this.Kvn.Kyp.get(i);
      localObject = (m)this.Kvo.get(((aa)localObject).KmB);
      AppMethodBeat.o(97068);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97068);
    }
    return null;
  }
  
  public final m fRP()
  {
    AppMethodBeat.i(97069);
    try
    {
      int i = this.Arh.kL();
      Object localObject = (aa)this.Kvn.Kyp.get(i - 1);
      localObject = (m)this.Kvo.get(((aa)localObject).KmB);
      AppMethodBeat.o(97069);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97069);
    }
    return null;
  }
  
  public final Collection<m> fRQ()
  {
    AppMethodBeat.i(97077);
    if (this.Kvo == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97077);
      return localObject;
    }
    Object localObject = this.Kvo.values();
    AppMethodBeat.o(97077);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(97066);
    int i = this.Kvn.Kyp.size();
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
    Iterator localIterator = this.Kvo.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).fKo();
    }
    AppMethodBeat.o(97075);
  }
  
  public final class a
    extends RecyclerView.v
  {
    private LinearLayout rrr;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(97062);
      this.rrr = ((LinearLayout)paramView.findViewById(i.f.content));
      AppMethodBeat.o(97062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */