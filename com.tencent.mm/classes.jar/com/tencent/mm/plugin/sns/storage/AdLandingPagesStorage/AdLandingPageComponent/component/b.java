package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
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
  extends m
{
  LinearLayoutManager Arh;
  int KoO;
  private RecyclerView KoP;
  private b KoQ;
  private Map<Integer, a> KoR;
  Set<Integer> KoS;
  
  public b(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
    AppMethodBeat.i(96405);
    this.KoO = com.tencent.mm.ci.a.fromDPToPix(paramContext, 12);
    this.KoR = new HashMap();
    this.KoS = new HashSet();
    AppMethodBeat.o(96405);
  }
  
  private void fQJ()
  {
    AppMethodBeat.i(96407);
    if (this.Arh != null) {
      jI(this.Arh.kJ(), this.Arh.kL());
    }
    AppMethodBeat.o(96407);
  }
  
  private void jI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96408);
    while (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.KoR.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.KoR.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.fQK();
      paramInt1 += 1;
    }
    AppMethodBeat.o(96408);
  }
  
  public final boolean H(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(96411);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(96411);
      return false;
    }
    Object localObject1 = new JSONObject();
    if (super.by((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.KoR;
      localObject1 = this.KoS;
      this.KoS = new HashSet();
      this.KoR = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (aa)((s)this.KqB).Kmd.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((aa)localObject3).KmK) && ((localObject3 instanceof u)))
        {
          Object localObject5 = (u)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((aa)((s)this.KqB).Kmd.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).KmB);
          ((JSONObject)localObject3).put("exposureCount", ((a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = MD5Util.getMD5String(((u)localObject5).Kmf);
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
      Log.e("AdLandingCarouselComp", Util.stackTraceToString(paramJSONArray));
      AppMethodBeat.o(96411);
      return false;
    }
    return true;
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96409);
    super.fKk();
    fQJ();
    AppMethodBeat.o(96409);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96410);
    super.fKl();
    if (this.Arh != null)
    {
      int i = this.Arh.kJ();
      int j = this.Arh.kL();
      while (i <= j)
      {
        a locala = (a)this.KoR.get(Integer.valueOf(i));
        if (locala != null) {
          locala.fQL();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(96410);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96406);
    this.KoP = ((RecyclerView)this.contentView.findViewById(i.f.recyclerView));
    this.KoP.setBackgroundColor(((s)this.KqB).backgroundColor);
    Object localObject = ((s)this.KqB).Kmd.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      aa localaa = (aa)((Iterator)localObject).next();
      if (!(localaa instanceof u)) {
        break label259;
      }
      u localu = (u)localaa;
      float f = localaa.paddingBottom;
      j = (int)(localaa.paddingTop + f + localu.height) + (this.KoO << 1);
    } while (i > j);
    label259:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.KoP.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.KoP.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.KoQ = new b((byte)0);
      this.KoP.setAdapter(this.KoQ);
      this.Arh = new LinearLayoutManager();
      this.Arh.setOrientation(0);
      this.KoP.setLayoutManager(this.Arh);
      this.KoP.a(new c(this.KoP, this.Arh));
      this.KoP.setNestedScrollingEnabled(false);
      this.KoP.setHasFixedSize(true);
      AppMethodBeat.o(96406);
      return;
    }
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_carousel;
  }
  
  final class a
  {
    long KoT;
    int count;
    boolean isVisible;
    long time;
    
    private a() {}
    
    final void fQK()
    {
      AppMethodBeat.i(96394);
      if (this.isVisible)
      {
        AppMethodBeat.o(96394);
        return;
      }
      this.isVisible = true;
      this.KoT = System.currentTimeMillis();
      this.count += 1;
      AppMethodBeat.o(96394);
    }
    
    final void fQL()
    {
      AppMethodBeat.i(96395);
      if (this.isVisible)
      {
        this.isVisible = false;
        if (this.KoT > 0L)
        {
          this.time += System.currentTimeMillis() - this.KoT;
          this.KoT = 0L;
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
      int i = ((s)b.this.KqB).Kmd.size();
      AppMethodBeat.o(96396);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      private h KoV;
      
      public a(View paramView, h paramh)
      {
        super();
        this.KoV = paramh;
      }
    }
  }
  
  final class c
    extends RecyclerView.l
  {
    private int KoX;
    private int KoY;
    private int KoZ;
    private long Kpa;
    private Runnable Kpb;
    private RecyclerView jLl;
    private LinearLayoutManager set;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(227829);
      this.KoX = 2147483647;
      this.KoY = -1;
      this.KoZ = -1;
      this.Kpa = 0L;
      this.Kpb = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96399);
          if (b.c.a(b.c.this) == 1)
          {
            b.c.b(b.c.this);
            b.c.d(b.c.this).postDelayed(b.c.c(b.c.this), 100L);
          }
          AppMethodBeat.o(96399);
        }
      };
      this.jLl = paramRecyclerView;
      this.set = paramLinearLayoutManager;
      AppMethodBeat.o(227829);
    }
    
    private void fQM()
    {
      AppMethodBeat.i(96401);
      this.jLl.getHandler().removeCallbacks(this.Kpb);
      AppMethodBeat.o(96401);
    }
    
    private void s(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(96404);
      Log.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      b.a(b.this, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(96404);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(227840);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt != this.KoX)
      {
        if (paramInt != 1) {
          fQM();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.KoX = paramInt;
        Log.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(227840);
        return;
        b.a(b.this);
        if (this.KoX == 2)
        {
          int i = this.set.kJ();
          int j = this.set.kL();
          if (j < this.KoY)
          {
            s(j, this.KoY, System.currentTimeMillis() - this.Kpa);
          }
          else if (i > this.KoZ)
          {
            s(this.KoZ, i, System.currentTimeMillis() - this.Kpa);
            continue;
            fQM();
            this.jLl.postDelayed(this.Kpb, 100L);
            continue;
            this.KoY = this.set.kJ();
            this.KoZ = this.set.kL();
            this.Kpa = System.currentTimeMillis();
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(227842);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(227842);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */