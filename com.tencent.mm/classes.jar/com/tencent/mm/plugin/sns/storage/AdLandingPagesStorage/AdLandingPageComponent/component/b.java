package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends l
{
  int zCi;
  private RecyclerView zCj;
  private b zCk;
  private Map<Integer, a> zCl;
  LinearLayoutManager zCm;
  Set<Integer> zCn;
  
  public b(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(96405);
    this.zCi = com.tencent.mm.cc.a.fromDPToPix(paramContext, 12);
    this.zCl = new HashMap();
    this.zCn = new HashSet();
    AppMethodBeat.o(96405);
  }
  
  private void dWw()
  {
    AppMethodBeat.i(96407);
    if (this.zCm != null) {
      hD(this.zCm.km(), this.zCm.ko());
    }
    AppMethodBeat.o(96407);
  }
  
  private void hD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96408);
    while (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.zCl.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.zCl.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.dWx();
      paramInt1 += 1;
    }
    AppMethodBeat.o(96408);
  }
  
  public final boolean D(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(96411);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(96411);
      return false;
    }
    Object localObject1 = new JSONObject();
    if (super.aQ((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.zCl;
      localObject1 = this.zCn;
      this.zCn = new HashSet();
      this.zCl = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (x)((q)this.zDK).zzJ.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((x)localObject3).zAp) && ((localObject3 instanceof s)))
        {
          Object localObject5 = (s)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((x)((q)this.zDK).zzJ.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).zAg);
          ((JSONObject)localObject3).put("exposureCount", ((a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = ai.ee(((s)localObject5).zzL);
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("urlMd5", localObject4);
            ((JSONObject)localObject5).put("needDownload", 1);
            ((JSONObject)localObject3).put("imgUrlInfo", localObject5);
          }
          paramJSONArray.put(localObject3);
        }
      }
      AppMethodBeat.o(96411);
    }
    catch (JSONException paramJSONArray)
    {
      ad.e("AdLandingCarouselComp", bt.n(paramJSONArray));
      AppMethodBeat.o(96411);
      return false;
    }
    return true;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(96406);
    this.zCj = ((RecyclerView)this.contentView.findViewById(2131303914));
    this.zCj.setBackgroundColor(((q)this.zDK).backgroundColor);
    Object localObject = ((q)this.zDK).zzJ.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      x localx = (x)((Iterator)localObject).next();
      if (!(localx instanceof s)) {
        break label259;
      }
      s locals = (s)localx;
      float f = localx.paddingBottom;
      j = (int)(localx.paddingTop + f + locals.height) + (this.zCi << 1);
    } while (i > j);
    label259:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.zCj.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.zCj.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.zCk = new b((byte)0);
      this.zCj.setAdapter(this.zCk);
      this.zCm = new LinearLayoutManager();
      this.zCm.setOrientation(0);
      this.zCj.setLayoutManager(this.zCm);
      this.zCj.a(new c(this.zCj, this.zCm));
      this.zCj.setNestedScrollingEnabled(false);
      this.zCj.setHasFixedSize(true);
      AppMethodBeat.o(96406);
      return;
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96409);
    super.dRm();
    dWw();
    AppMethodBeat.o(96409);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96410);
    super.dRn();
    if (this.zCm != null)
    {
      int i = this.zCm.km();
      int j = this.zCm.ko();
      while (i <= j)
      {
        a locala = (a)this.zCl.get(Integer.valueOf(i));
        if (locala != null) {
          locala.dWy();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(96410);
  }
  
  protected final int getLayout()
  {
    return 2131495499;
  }
  
  final class a
  {
    int count;
    boolean isVisible;
    long time;
    long zCo;
    
    private a() {}
    
    final void dWx()
    {
      AppMethodBeat.i(96394);
      if (this.isVisible)
      {
        AppMethodBeat.o(96394);
        return;
      }
      this.isVisible = true;
      this.zCo = System.currentTimeMillis();
      this.count += 1;
      AppMethodBeat.o(96394);
    }
    
    final void dWy()
    {
      AppMethodBeat.i(96395);
      if (this.isVisible)
      {
        this.isVisible = false;
        if (this.zCo > 0L)
        {
          this.time += System.currentTimeMillis() - this.zCo;
          this.zCo = 0L;
        }
      }
      AppMethodBeat.o(96395);
    }
  }
  
  final class b
    extends RecyclerView.a<a>
  {
    private b() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(96396);
      int i = b.b(b.this).zzJ.size();
      AppMethodBeat.o(96396);
      return i;
    }
    
    final class a
      extends RecyclerView.w
    {
      private h zCq;
      
      public a(View paramView, h paramh)
      {
        super();
        this.zCq = paramh;
      }
    }
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView gmV;
    private LinearLayoutManager nLX;
    int zCs;
    private int zCt;
    private int zCu;
    private long zCv;
    Runnable zCw;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96400);
      this.zCs = 2147483647;
      this.zCt = -1;
      this.zCu = -1;
      this.zCv = 0L;
      this.zCw = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96399);
          if (b.c.this.zCs == 1)
          {
            b.c localc = b.c.this;
            ad.d("AdLandingCarouselComp", "onDraggin first visible " + localc.zCp.zCm.km() + ", last visible " + localc.zCp.zCm.ko());
            b.a(localc.zCp);
            b.c.this.gmV.postDelayed(b.c.this.zCw, 100L);
          }
          AppMethodBeat.o(96399);
        }
      };
      this.gmV = paramRecyclerView;
      this.nLX = paramLinearLayoutManager;
      AppMethodBeat.o(96400);
    }
    
    private void dWz()
    {
      AppMethodBeat.i(96401);
      this.gmV.getHandler().removeCallbacks(this.zCw);
      AppMethodBeat.o(96401);
    }
    
    private void m(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(96404);
      ad.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      b.a(b.this, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(96404);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96403);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96403);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96402);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.zCs)
      {
        if (paramInt != 1) {
          dWz();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.zCs = paramInt;
        ad.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96402);
        return;
        b.a(b.this);
        if (this.zCs == 2)
        {
          int i = this.nLX.km();
          int j = this.nLX.ko();
          if (j < this.zCt)
          {
            m(j, this.zCt, System.currentTimeMillis() - this.zCv);
          }
          else if (i > this.zCu)
          {
            m(this.zCu, i, System.currentTimeMillis() - this.zCv);
            continue;
            dWz();
            this.gmV.postDelayed(this.zCw, 100L);
            continue;
            this.zCt = this.nLX.km();
            this.zCu = this.nLX.ko();
            this.zCv = System.currentTimeMillis();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */