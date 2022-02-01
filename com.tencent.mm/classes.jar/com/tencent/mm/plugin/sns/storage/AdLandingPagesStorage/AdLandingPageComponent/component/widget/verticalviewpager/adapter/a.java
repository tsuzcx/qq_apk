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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.ui.as;
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
  extends RecyclerView.a<RecyclerView.v>
  implements c.b
{
  int bgColor;
  private Context context;
  private LinearLayoutManager wYJ;
  g xeJ;
  private LinkedHashMap<String, k> xeK;
  int xeL;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(97063);
    this.wYJ = paramLinearLayoutManager;
    this.xeJ = paramg;
    this.xeK = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(97063);
  }
  
  private k MR(int paramInt)
  {
    AppMethodBeat.i(97073);
    Object localObject = (x)this.xeJ.xhI.get(paramInt);
    localObject = (k)this.xeK.get(((x)localObject).wWE);
    AppMethodBeat.o(97073);
    return localObject;
  }
  
  public final void MM(int paramInt)
  {
    AppMethodBeat.i(97074);
    if ((paramInt < 0) || (paramInt >= this.xeJ.xhI.size()))
    {
      ad.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xeJ.xhI.size()) });
      AppMethodBeat.o(97074);
      return;
    }
    Object localObject = (x)this.xeJ.xhI.get(paramInt);
    localObject = (k)this.xeK.get(((x)localObject).wWE);
    if (localObject != null) {
      ((k)localObject).dvA();
    }
    AppMethodBeat.o(97074);
  }
  
  public final boolean MN(int paramInt)
  {
    AppMethodBeat.i(97067);
    if ((paramInt < this.wYJ.jO()) || (paramInt > this.wYJ.jQ()))
    {
      ad.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(97067);
      return false;
    }
    Object localObject = (x)this.xeJ.xhI.get(paramInt);
    localObject = (k)this.xeK.get(((x)localObject).wWE);
    if (localObject != null)
    {
      ad.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((k)localObject).dwd()) });
      boolean bool = ((k)localObject).dwd();
      AppMethodBeat.o(97067);
      return bool;
    }
    AppMethodBeat.o(97067);
    return false;
  }
  
  public final boolean MO(int paramInt)
  {
    AppMethodBeat.i(97070);
    boolean bool = i.MS(((x)this.xeJ.xhI.get(paramInt)).type);
    AppMethodBeat.o(97070);
    return bool;
  }
  
  public final void MP(int paramInt)
  {
    AppMethodBeat.i(97072);
    k localk = MR(paramInt);
    if (i.MS(localk.dwb().type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localk).dvU();
    }
    AppMethodBeat.o(97072);
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(97064);
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492938, paramViewGroup, false));
    AppMethodBeat.o(97064);
    return paramViewGroup;
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(97071);
    Object localObject = (x)this.xeJ.xhI.get(paramInt);
    k localk = (k)this.xeK.get(((x)localObject).wWE);
    if (localk != null)
    {
      localk.dvz();
      localk.dvB();
      if ((((x)localObject).type == 61) || (((x)localObject).type == 62))
      {
        localObject = new ArrayList();
        paramc = paramc.wYI.entrySet().iterator();
        while (paramc.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramc.next();
          if (((c.a)localEntry.getValue()).wVd) {
            ((List)localObject).add(localEntry.getKey());
          }
        }
        paramc = ((List)localObject).iterator();
        while (paramc.hasNext())
        {
          int i = ((Integer)paramc.next()).intValue();
          if ((i != paramInt) && (MN(i)))
          {
            localObject = MR(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).wUZ) && (this.xeJ.rOT) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localk).dvw();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localk).wUZ) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).dvw();
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
    ad.i("MicroMsg.ContentAdapter", "display page " + this.xeJ.id + ", pos " + paramInt);
    a locala = (a)paramv;
    a.a(locala).removeAllViews();
    x localx = (x)this.xeJ.xhI.get(paramInt);
    paramv = (k)this.xeK.get(localx.wWE);
    int j = this.bgColor;
    int i = j;
    if (localx.wWJ != null)
    {
      i = j;
      if (localx.wWJ.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localx.wWJ);
      a.a(locala).setBackgroundColor(i);
      if (paramv != null)
      {
        paramv.a((x)this.xeJ.xhI.get(paramInt));
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
          paramv = (k)dwO().iterator().next();
          if ((paramv != null) && ((paramv instanceof t)))
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("startIndex", Integer.valueOf(this.xeL));
            paramv.aF(localHashMap);
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
        ad.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localx.wWJ });
        i = j;
        continue;
        k localk = as.a(a.a(locala).getContext(), localx, a.a(locala), i);
        paramv = localk;
        if (localk != null)
        {
          this.xeK.put(localx.wWE, localk);
          paramv = localk;
        }
      }
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(97076);
    if (this.xeJ != paramg)
    {
      this.xeJ = paramg;
      this.aql.notifyChanged();
    }
    AppMethodBeat.o(97076);
  }
  
  public final k dwM()
  {
    AppMethodBeat.i(97068);
    try
    {
      int i = this.wYJ.jQ();
      Object localObject = (x)this.xeJ.xhI.get(i);
      localObject = (k)this.xeK.get(((x)localObject).wWE);
      AppMethodBeat.o(97068);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97068);
    }
    return null;
  }
  
  public final k dwN()
  {
    AppMethodBeat.i(97069);
    try
    {
      int i = this.wYJ.jQ();
      Object localObject = (x)this.xeJ.xhI.get(i - 1);
      localObject = (k)this.xeK.get(((x)localObject).wWE);
      AppMethodBeat.o(97069);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97069);
    }
    return null;
  }
  
  public final Collection<k> dwO()
  {
    AppMethodBeat.i(97077);
    if (this.xeK == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97077);
      return localObject;
    }
    Object localObject = this.xeK.values();
    AppMethodBeat.o(97077);
    return localObject;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(97066);
    int i = this.xeJ.xhI.size();
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
    Iterator localIterator = this.xeK.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((k)((Map.Entry)localIterator.next()).getValue()).dvy();
    }
    AppMethodBeat.o(97075);
  }
  
  public final class a
    extends RecyclerView.v
  {
    private LinearLayout lYp;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(97062);
      this.lYp = ((LinearLayout)paramView.findViewById(2131298739));
      AppMethodBeat.o(97062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */