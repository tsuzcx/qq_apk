package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
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
  int Ebt;
  private RecyclerView Ebu;
  private b Ebv;
  private Map<Integer, a> Ebw;
  Set<Integer> Ebx;
  LinearLayoutManager vKp;
  
  public b(Context paramContext, r paramr, ViewGroup paramViewGroup)
  {
    super(paramContext, paramr, paramViewGroup);
    AppMethodBeat.i(96405);
    this.Ebt = com.tencent.mm.cb.a.fromDPToPix(paramContext, 12);
    this.Ebw = new HashMap();
    this.Ebx = new HashSet();
    AppMethodBeat.o(96405);
  }
  
  private void fcS()
  {
    AppMethodBeat.i(96407);
    if (this.vKp != null) {
      iz(this.vKp.ks(), this.vKp.ku());
    }
    AppMethodBeat.o(96407);
  }
  
  private void iz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96408);
    while (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.Ebw.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.Ebw.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.fcT();
      paramInt1 += 1;
    }
    AppMethodBeat.o(96408);
  }
  
  public final boolean G(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(96411);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(96411);
      return false;
    }
    Object localObject1 = new JSONObject();
    if (super.bp((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.Ebw;
      localObject1 = this.Ebx;
      this.Ebx = new HashSet();
      this.Ebw = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (z)((r)this.EcX).DYI.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((z)localObject3).DZr) && ((localObject3 instanceof t)))
        {
          Object localObject5 = (t)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((z)((r)this.EcX).DYI.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).DZi);
          ((JSONObject)localObject3).put("exposureCount", ((a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = MD5Util.getMD5String(((t)localObject5).DYK);
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
  
  public final void eWZ()
  {
    AppMethodBeat.i(96409);
    super.eWZ();
    fcS();
    AppMethodBeat.o(96409);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96410);
    super.eXa();
    if (this.vKp != null)
    {
      int i = this.vKp.ks();
      int j = this.vKp.ku();
      while (i <= j)
      {
        a locala = (a)this.Ebw.get(Integer.valueOf(i));
        if (locala != null) {
          locala.fcU();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(96410);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96406);
    this.Ebu = ((RecyclerView)this.contentView.findViewById(2131306755));
    this.Ebu.setBackgroundColor(((r)this.EcX).backgroundColor);
    Object localObject = ((r)this.EcX).DYI.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      z localz = (z)((Iterator)localObject).next();
      if (!(localz instanceof t)) {
        break label259;
      }
      t localt = (t)localz;
      float f = localz.paddingBottom;
      j = (int)(localz.paddingTop + f + localt.height) + (this.Ebt << 1);
    } while (i > j);
    label259:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.Ebu.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.Ebu.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Ebv = new b((byte)0);
      this.Ebu.setAdapter(this.Ebv);
      this.vKp = new LinearLayoutManager();
      this.vKp.setOrientation(0);
      this.Ebu.setLayoutManager(this.vKp);
      this.Ebu.a(new c(this.Ebu, this.vKp));
      this.Ebu.setNestedScrollingEnabled(false);
      this.Ebu.setHasFixedSize(true);
      AppMethodBeat.o(96406);
      return;
    }
  }
  
  protected final int getLayout()
  {
    return 2131496382;
  }
  
  final class a
  {
    long Eby;
    int count;
    boolean isVisible;
    long time;
    
    private a() {}
    
    final void fcT()
    {
      AppMethodBeat.i(96394);
      if (this.isVisible)
      {
        AppMethodBeat.o(96394);
        return;
      }
      this.isVisible = true;
      this.Eby = System.currentTimeMillis();
      this.count += 1;
      AppMethodBeat.o(96394);
    }
    
    final void fcU()
    {
      AppMethodBeat.i(96395);
      if (this.isVisible)
      {
        this.isVisible = false;
        if (this.Eby > 0L)
        {
          this.time += System.currentTimeMillis() - this.Eby;
          this.Eby = 0L;
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
      int i = b.b(b.this).DYI.size();
      AppMethodBeat.o(96396);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      private h EbA;
      
      public a(View paramView, h paramh)
      {
        super();
        this.EbA = paramh;
      }
    }
  }
  
  final class c
    extends RecyclerView.l
  {
    int EbC;
    private int EbD;
    private int EbE;
    private long EbF;
    Runnable EbG;
    RecyclerView hak;
    private LinearLayoutManager pcs;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96400);
      this.EbC = 2147483647;
      this.EbD = -1;
      this.EbE = -1;
      this.EbF = 0L;
      this.EbG = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96399);
          if (b.c.this.EbC == 1)
          {
            b.c localc = b.c.this;
            Log.d("AdLandingCarouselComp", "onDraggin first visible " + localc.Ebz.vKp.ks() + ", last visible " + localc.Ebz.vKp.ku());
            b.a(localc.Ebz);
            b.c.this.hak.postDelayed(b.c.this.EbG, 100L);
          }
          AppMethodBeat.o(96399);
        }
      };
      this.hak = paramRecyclerView;
      this.pcs = paramLinearLayoutManager;
      AppMethodBeat.o(96400);
    }
    
    private void fcV()
    {
      AppMethodBeat.i(96401);
      this.hak.getHandler().removeCallbacks(this.EbG);
      AppMethodBeat.o(96401);
    }
    
    private void m(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(96404);
      Log.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      b.a(b.this, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(96404);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96402);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt != this.EbC)
      {
        if (paramInt != 1) {
          fcV();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.EbC = paramInt;
        Log.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96402);
        return;
        b.a(b.this);
        if (this.EbC == 2)
        {
          int i = this.pcs.ks();
          int j = this.pcs.ku();
          if (j < this.EbD)
          {
            m(j, this.EbD, System.currentTimeMillis() - this.EbF);
          }
          else if (i > this.EbE)
          {
            m(this.EbE, i, System.currentTimeMillis() - this.EbF);
            continue;
            fcV();
            this.hak.postDelayed(this.EbG, 100L);
            continue;
            this.EbD = this.pcs.ks();
            this.EbE = this.pcs.ku();
            this.EbF = System.currentTimeMillis();
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96403);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96403);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */