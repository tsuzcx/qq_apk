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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import com.tencent.mm.plugin.sns.ui.bb;
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
  implements b.b
{
  private LinearLayoutManager AJH;
  h QTX;
  private LinkedHashMap<String, n> QTY;
  int QTZ;
  int bgColor;
  private Context context;
  
  public a(h paramh, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(307282);
    this.AJH = paramLinearLayoutManager;
    this.QTX = paramh;
    this.QTY = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    AppMethodBeat.o(307282);
  }
  
  private n alq(int paramInt)
  {
    AppMethodBeat.i(97073);
    Object localObject = (aa)this.QTX.QXi.get(paramInt);
    localObject = (n)this.QTY.get(((aa)localObject).QKG);
    AppMethodBeat.o(97073);
    return localObject;
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(97071);
    Object localObject = (aa)this.QTX.QXi.get(paramInt);
    n localn = (n)this.QTY.get(((aa)localObject).QKG);
    if (localn != null)
    {
      localn.hao();
      localn.haq();
      if ((((aa)localObject).type == 61) || (((aa)localObject).type == 62) || (((aa)localObject).type == 142))
      {
        localObject = new ArrayList();
        paramb = paramb.QMY.entrySet().iterator();
        while (paramb.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramb.next();
          if (((b.a)localEntry.getValue()).QIM) {
            ((List)localObject).add((Integer)localEntry.getKey());
          }
        }
        paramb = ((List)localObject).iterator();
        while (paramb.hasNext())
        {
          int i = ((Integer)paramb.next()).intValue();
          if ((i != paramInt) && (all(i)))
          {
            localObject = alq(i);
            if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).QIH) && (this.QTX.AXE) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localn).haw();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localn).QIH) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject).haw();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(97071);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(97076);
    if (this.QTX != paramh)
    {
      this.QTX = paramh;
      this.bZE.notifyChanged();
    }
    AppMethodBeat.o(97076);
  }
  
  public final void alk(int paramInt)
  {
    AppMethodBeat.i(97074);
    if ((paramInt < 0) || (paramInt >= this.QTX.QXi.size()))
    {
      Log.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.QTX.QXi.size()) });
      AppMethodBeat.o(97074);
      return;
    }
    Object localObject = (aa)this.QTX.QXi.get(paramInt);
    localObject = (n)this.QTY.get(((aa)localObject).QKG);
    if (localObject != null) {
      ((n)localObject).hap();
    }
    AppMethodBeat.o(97074);
  }
  
  public final boolean all(int paramInt)
  {
    AppMethodBeat.i(97067);
    if ((paramInt < this.AJH.Ju()) || (paramInt > this.AJH.Jw()))
    {
      Log.v("MicroMsg.ContentAdapter", "index %d not visible");
      AppMethodBeat.o(97067);
      return false;
    }
    Object localObject = (aa)this.QTX.QXi.get(paramInt);
    localObject = (n)this.QTY.get(((aa)localObject).QKG);
    if (localObject != null)
    {
      Log.d("MicroMsg.ContentAdapter", "comp %s, isExposure %s", new Object[] { localObject, Boolean.valueOf(((n)localObject).hji()) });
      boolean bool = ((n)localObject).hji();
      AppMethodBeat.o(97067);
      return bool;
    }
    AppMethodBeat.o(97067);
    return false;
  }
  
  public final boolean alm(int paramInt)
  {
    AppMethodBeat.i(97070);
    boolean bool = l.als(((aa)this.QTX.QXi.get(paramInt)).type);
    AppMethodBeat.o(97070);
    return bool;
  }
  
  public final void aln(int paramInt)
  {
    AppMethodBeat.i(97072);
    n localn = alq(paramInt);
    if (l.als(localn.QOV.type)) {
      ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a)localn).har();
    }
    AppMethodBeat.o(97072);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(307285);
    paramViewGroup = new a(LayoutInflater.from(paramViewGroup.getContext()).inflate(b.g.ad_landing_comp_item, paramViewGroup, false));
    AppMethodBeat.o(307285);
    return paramViewGroup;
  }
  
  public final void d(RecyclerView.v paramv, int paramInt)
  {
    AppMethodBeat.i(307288);
    Log.i("MicroMsg.ContentAdapter", "display page " + this.QTX.id + ", pos " + paramInt);
    a locala = (a)paramv;
    a.a(locala).removeAllViews();
    aa localaa = (aa)this.QTX.QXi.get(paramInt);
    paramv = (n)this.QTY.get(localaa.QKG);
    int j = this.bgColor;
    int i = j;
    if (localaa.QKL != null)
    {
      i = j;
      if (localaa.QKL.length() <= 0) {}
    }
    try
    {
      i = Color.parseColor(localaa.QKL);
      a.a(locala).setBackgroundColor(i);
      if (paramv != null)
      {
        paramv.c((aa)this.QTX.QXi.get(paramInt));
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
        paramv = (n)hjV().iterator().next();
        if ((paramv != null) && ((paramv instanceof x)))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("startIndex", Integer.valueOf(this.QTZ));
          paramv.bb((Map)localObject);
        }
        AppMethodBeat.o(307288);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { localaa.QKL });
        i = j;
        continue;
        n localn = bb.a(a.a(locala).getContext(), localaa, a.a(locala), i);
        paramv = localn;
        if (localn != null)
        {
          this.QTY.put(localaa.QKG, localn);
          paramv = localn;
        }
      }
      label362:
      if ((paramv instanceof x)) {
        paramv.bb(new HashMap());
      }
      AppMethodBeat.o(307288);
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(97066);
    int i = this.QTX.QXi.size();
    AppMethodBeat.o(97066);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    return paramInt;
  }
  
  public final n hjT()
  {
    AppMethodBeat.i(97068);
    try
    {
      int i = this.AJH.Jw();
      Object localObject = (aa)this.QTX.QXi.get(i);
      localObject = (n)this.QTY.get(((aa)localObject).QKG);
      AppMethodBeat.o(97068);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97068);
    }
    return null;
  }
  
  public final n hjU()
  {
    AppMethodBeat.i(97069);
    try
    {
      int i = this.AJH.Jw();
      Object localObject = (aa)this.QTX.QXi.get(i - 1);
      localObject = (n)this.QTY.get(((aa)localObject).QKG);
      AppMethodBeat.o(97069);
      return localObject;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(97069);
    }
    return null;
  }
  
  public final Collection<n> hjV()
  {
    AppMethodBeat.i(97077);
    if (this.QTY == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(97077);
      return localObject;
    }
    Object localObject = this.QTY.values();
    AppMethodBeat.o(97077);
    return localObject;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(97075);
    Iterator localIterator = this.QTY.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((n)((Map.Entry)localIterator.next()).getValue()).has();
    }
    AppMethodBeat.o(97075);
  }
  
  public final class a
    extends RecyclerView.v
  {
    private LinearLayout uBC;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(97062);
      this.uBC = ((LinearLayout)paramView.findViewById(b.f.content));
      AppMethodBeat.o(97062);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.a
 * JD-Core Version:    0.7.0.1
 */