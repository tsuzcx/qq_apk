package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.y;
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
  int bgColor;
  private Context context;
  private int gHR;
  private int gHS;
  private LinearLayoutManager oFb;
  g oJg;
  LinkedHashMap<String, i> oJh;
  private LayoutInflater oJi;
  int oJj;
  
  public a(g paramg, int paramInt, Context paramContext, LinearLayoutManager paramLinearLayoutManager)
  {
    this.oFb = paramLinearLayoutManager;
    this.oJg = paramg;
    this.oJh = new LinkedHashMap();
    this.bgColor = paramInt;
    this.context = paramContext;
    this.oJi = ((LayoutInflater)this.context.getSystemService("layout_inflater"));
    paramg = ad.ed(this.context);
    this.gHR = paramg[0];
    this.gHS = paramg[1];
  }
  
  private int a(i parami)
  {
    if (parami != null)
    {
      View localView = parami.getView();
      int[] arrayOfInt = new int[2];
      localView.getLocationOnScreen(arrayOfInt);
      int k = arrayOfInt[1];
      int j = localView.getHeight() + k;
      y.v("MicroMsg.ContentAdapter", "comp %s , top %d,bottom %d ", new Object[] { parami, Integer.valueOf(k), Integer.valueOf(j) });
      int i;
      if ((k >= 0) && (j <= this.gHS)) {
        i = localView.getHeight();
      }
      do
      {
        return i;
        if ((k >= 0) || (j <= 0)) {
          break;
        }
        i = j;
      } while (j <= this.gHS);
      if ((k < 0) && (j > this.gHS)) {
        return this.gHS;
      }
      if ((k < this.gHS) && (j > this.gHS)) {
        return this.gHS - k;
      }
    }
    return 0;
  }
  
  public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
  {
    return new a.a(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(i.g.ad_landing_comp_item, paramViewGroup, false));
  }
  
  public final void a(int paramInt, b paramb)
  {
    Object localObject1 = (s)this.oJg.oKx.get(paramInt);
    i locali = (i)this.oJh.get(((s)localObject1).oDg);
    if (locali != null)
    {
      locali.bET();
      Object localObject2 = locali.getView();
      locali.W(a(locali), ((View)localObject2).getHeight(), this.gHS);
      if ((((s)localObject1).type == 61) || (((s)localObject1).type == 62))
      {
        localObject1 = new ArrayList();
        paramb = paramb.oFa.entrySet().iterator();
        while (paramb.hasNext())
        {
          localObject2 = (Map.Entry)paramb.next();
          if (((b.a)((Map.Entry)localObject2).getValue()).oCc) {
            ((List)localObject1).add(((Map.Entry)localObject2).getKey());
          }
        }
        paramb = ((List)localObject1).iterator();
        while (paramb.hasNext())
        {
          int i = ((Integer)paramb.next()).intValue();
          if ((i != paramInt) && (yk(i)))
          {
            localObject1 = (s)this.oJg.oKx.get(i);
            localObject1 = (i)this.oJh.get(((s)localObject1).oDg);
            if ((localObject1 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a))
            {
              localObject1 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject1;
              if ((((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject1).oCa) && (this.oJg.oKz) && (i == 0)) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)locali).bER();
              } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)locali).oCa) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a)localObject1).bER();
              }
            }
          }
        }
      }
    }
  }
  
  public final void a(RecyclerView.v paramv, int paramInt)
  {
    y.i("MicroMsg.ContentAdapter", "display page " + this.oJg.id + ", pos " + paramInt);
    locala = (a.a)paramv;
    a.a.a(locala).removeAllViews();
    locals = (s)this.oJg.oKx.get(paramInt);
    paramv = (i)this.oJh.get(locals.oDg);
    int j = this.bgColor;
    i = j;
    if (locals.oDp != null)
    {
      i = j;
      if (locals.oDp.length() > 0) {
        i = j;
      }
    }
    try
    {
      j = Color.parseColor(locals.oDp);
      i = j;
      a.a.a(locala).setBackgroundColor(j);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        HashMap localHashMap;
        y.e("MicroMsg.ContentAdapter", "parse cellBackgroundColor error: %s", new Object[] { locals.oDp });
        continue;
        i locali = al.a(a.a.a(locala).getContext(), locals, a.a.a(locala), i);
        paramv = locali;
        if (locali != null)
        {
          this.oJh.put(locals.oDg, locali);
          paramv = locali;
        }
      }
    }
    if (paramv != null)
    {
      paramv.a((s)this.oJg.oKx.get(paramInt));
      if (paramv != null)
      {
        if ((paramv.getView().getParent() != null) && ((paramv.getView().getParent() instanceof ViewGroup))) {
          ((ViewGroup)paramv.getView().getParent()).removeView(paramv.getView());
        }
        a.a.a(locala).addView(paramv.getView());
      }
      if (paramInt == 0)
      {
        paramv = (i)bFL().iterator().next();
        if ((paramv != null) && ((paramv instanceof o)))
        {
          localHashMap = new HashMap();
          localHashMap.put("startIndex", Integer.valueOf(this.oJj));
          paramv.L(localHashMap);
        }
      }
      return;
    }
  }
  
  public final Collection<i> bFL()
  {
    if (this.oJh == null) {
      return Collections.EMPTY_LIST;
    }
    return this.oJh.values();
  }
  
  public final int getItemCount()
  {
    return this.oJg.oKx.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return paramInt;
  }
  
  public final void onDestroy()
  {
    Iterator localIterator = this.oJh.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((i)((Map.Entry)localIterator.next()).getValue()).bES();
    }
  }
  
  public final void yj(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.oJg.oKx.size())) {
      y.w("MicroMsg.ContentAdapter", "endExposure index[%d], size[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.oJg.oKx.size()) });
    }
    Object localObject;
    do
    {
      return;
      localObject = (s)this.oJg.oKx.get(paramInt);
      localObject = (i)this.oJh.get(((s)localObject).oDg);
    } while (localObject == null);
    ((i)localObject).bEU();
  }
  
  public final boolean yk(int paramInt)
  {
    if ((paramInt < this.oFb.gY()) || (paramInt > this.oFb.ha()))
    {
      y.v("MicroMsg.ContentAdapter", "index %d not visible");
      return false;
    }
    Object localObject = (s)this.oJg.oKx.get(paramInt);
    localObject = (i)this.oJh.get(((s)localObject).oDg);
    if (localObject != null)
    {
      paramInt = a((i)localObject);
      y.v("MicroMsg.ContentAdapter", "comp %s, inScreenH %d", new Object[] { localObject, Integer.valueOf(paramInt) });
      return paramInt >= ((i)localObject).getView().getHeight() >>> 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.a
 * JD-Core Version:    0.7.0.1
 */