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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.ay;
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
  g Eig;
  private LinkedHashMap<String, m> Eih;
  int Eii;
  int bgColor;
  private Context context;
  private LinearLayoutManager vKp;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(97063);
    this.vKp = paramLinearLayoutManager;
    this.Eig = paramg;
    this.Eih = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(97063);
  }
  
  private m Zh(int paramInt)
  {
    AppMethodBeat.i(97073);
    Object localObject = (z)this.Eig.Eli.get(paramInt);
    localObject = (m)this.Eih.get(((z)localObject).DZi);
    AppMethodBeat.o(97073);
    return localObject;
  }
  
  public final void Zc(int paramInt)
  {
    AppMethodBeat.i(97074);
    if ((paramInt < 0) || (paramInt >= this.Eig.Eli.size()))
    {
      Log.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Eig.Eli.size()) });
      AppMethodBeat.o(97074);
      return;
    }
    Object localObject = (z)this.Eig.Eli.get(paramInt);
    localObject = (m)this.Eih.get(((z)localObject).DZi);
    if (localObject != null) {
      ((m)localObject).eXa();
    }
    AppMethodBeat.o(97074);
  }
  
  public final boolean Zd(int paramInt)
  {
    AppMethodBeat.i(97067);
    if ((paramInt < this.vKp.ks()) || (paramInt > this.vKp.ku()))
    {
      Log.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(97067);
      return false;
    }
    Object localObject = (z)this.Eig.Eli.get(paramInt);
    localObject = (m)this.Eih.get(((z)localObject).DZi);
    if (localObject != null)
    {
      Log.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((m)localObject).fdm()) });
      boolean bool = ((m)localObject).fdm();
      AppMethodBeat.o(97067);
      return bool;
    }
    AppMethodBeat.o(97067);
    return false;
  }
  
  public final boolean Ze(int paramInt)
  {
    AppMethodBeat.i(97070);
    boolean bool = i.Zi(((z)this.Eig.Eli.get(paramInt)).type);
    AppMethodBeat.o(97070);
    return bool;
  }
  
  public final void Zf(int paramInt)
  {
    AppMethodBeat.i(97072);
    m localm = Zh(paramInt);
    if (i.Zi(localm.fdk().type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localm).eXc();
    }
    AppMethodBeat.o(97072);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(97064);
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492969, paramViewGroup, false));
    AppMethodBeat.o(97064);
    return paramViewGroup;
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(97071);
    Object localObject = (z)this.Eig.Eli.get(paramInt);
    m localm = (m)this.Eih.get(((z)localObject).DZi);
    if (localm != null)
    {
      localm.eWZ();
      localm.eXb();
      if ((((z)localObject).type == 61) || (((z)localObject).type == 62))
      {
        localObject = new ArrayList();
        paramc = paramc.Ebw.entrySet().iterator();
        while (paramc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramc.next();
          if (((c.a)localEntry.getValue()).DXw) {
            ((List)localObject).add(localEntry.getKey());
          }
        }
        paramc = ((List)localObject).iterator();
        while (paramc.hasNext())
        {
          int i = ((Integer)paramc.next()).intValue();
          if ((i != paramInt) && (Zd(i)))
          {
            localObject = Zh(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).DXr) && (this.Eig.xwi) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localm).fcJ();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localm).DXr) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).fcJ();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(97071);
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(97065);
    Log.i("MicroMsg.ContentAdapter", "display page " + this.Eig.id + ", pos " + paramInt);
    a locala = (a)paramv;
    a.a(locala).removeAllViews();
    z localz = (z)this.Eig.Eli.get(paramInt);
    paramv = (m)this.Eih.get(localz.DZi);
    int j = this.bgColor;
    int i = j;
    if (localz.DZn != null)
    {
      i = j;
      if (localz.DZn.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localz.DZn);
      a.a(locala).setBackgroundColor(i);
      if (paramv != null)
      {
        paramv.b((z)this.Eig.Eli.get(paramInt));
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
        paramv = (m)fdY().iterator().next();
        if ((paramv != null) && ((paramv instanceof v)))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("startIndex", Integer.valueOf(this.Eii));
          paramv.aQ((Map)localObject);
        }
        AppMethodBeat.o(97065);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localz.DZn });
        i = j;
        continue;
        m localm = ay.a(a.a(locala).getContext(), localz, a.a(locala), i);
        paramv = localm;
        if (localm != null)
        {
          this.Eih.put(localz.DZi, localm);
          paramv = localm;
        }
      }
      label362:
      if ((paramv instanceof v)) {
        paramv.aQ(new HashMap());
      }
      AppMethodBeat.o(97065);
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97076);
    if (this.Eig != paramg)
    {
      this.Eig = paramg;
      this.atj.notifyChanged();
    }
    AppMethodBeat.o(97076);
  }
  
  public final m fdW()
  {
    AppMethodBeat.i(97068);
    try
    {
      int i = this.vKp.ku();
      Object localObject = (z)this.Eig.Eli.get(i);
      localObject = (m)this.Eih.get(((z)localObject).DZi);
      AppMethodBeat.o(97068);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97068);
    }
    return null;
  }
  
  public final m fdX()
  {
    AppMethodBeat.i(97069);
    try
    {
      int i = this.vKp.ku();
      Object localObject = (z)this.Eig.Eli.get(i - 1);
      localObject = (m)this.Eih.get(((z)localObject).DZi);
      AppMethodBeat.o(97069);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97069);
    }
    return null;
  }
  
  public final Collection<m> fdY()
  {
    AppMethodBeat.i(97077);
    if (this.Eih == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97077);
      return localObject;
    }
    Object localObject = this.Eih.values();
    AppMethodBeat.o(97077);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(97066);
    int i = this.Eig.Eli.size();
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
    Iterator localIterator = this.Eih.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((m)((Map.Entry)localIterator.next()).getValue()).eXd();
    }
    AppMethodBeat.o(97075);
  }
  
  public final class a
    extends RecyclerView.v
  {
    private LinearLayout opU;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(97062);
      this.opU = ((LinearLayout)paramView.findViewById(2131299180));
      AppMethodBeat.o(97062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */