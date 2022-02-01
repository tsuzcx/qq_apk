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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
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
  int zTk;
  private RecyclerView zTl;
  private b zTm;
  private Map<Integer, a> zTn;
  LinearLayoutManager zTo;
  Set<Integer> zTp;
  
  public b(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(96405);
    this.zTk = com.tencent.mm.cb.a.fromDPToPix(paramContext, 12);
    this.zTn = new HashMap();
    this.zTp = new HashSet();
    AppMethodBeat.o(96405);
  }
  
  private void dZY()
  {
    AppMethodBeat.i(96407);
    if (this.zTo != null) {
      hG(this.zTo.km(), this.zTo.ko());
    }
    AppMethodBeat.o(96407);
  }
  
  private void hG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96408);
    while (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.zTn.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.zTn.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.dZZ();
      paramInt1 += 1;
    }
    AppMethodBeat.o(96408);
  }
  
  public final boolean E(JSONArray paramJSONArray)
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
      Object localObject2 = this.zTn;
      localObject1 = this.zTp;
      this.zTp = new HashSet();
      this.zTn = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (y)((q)this.zUP).zQI.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((y)localObject3).zRp) && ((localObject3 instanceof s)))
        {
          Object localObject5 = (s)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((y)((q)this.zUP).zQI.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).zRg);
          ((JSONObject)localObject3).put("exposureCount", ((a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = aj.ej(((s)localObject5).zQK);
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
      ae.e("AdLandingCarouselComp", bu.o(paramJSONArray));
      AppMethodBeat.o(96411);
      return false;
    }
    return true;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96406);
    this.zTl = ((RecyclerView)this.contentView.findViewById(2131303914));
    this.zTl.setBackgroundColor(((q)this.zUP).backgroundColor);
    Object localObject = ((q)this.zUP).zQI.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      y localy = (y)((Iterator)localObject).next();
      if (!(localy instanceof s)) {
        break label259;
      }
      s locals = (s)localy;
      float f = localy.paddingBottom;
      j = (int)(localy.paddingTop + f + locals.height) + (this.zTk << 1);
    } while (i > j);
    label259:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.zTl.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.zTl.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.zTm = new b((byte)0);
      this.zTl.setAdapter(this.zTm);
      this.zTo = new LinearLayoutManager();
      this.zTo.setOrientation(0);
      this.zTl.setLayoutManager(this.zTo);
      this.zTl.a(new c(this.zTl, this.zTo));
      this.zTl.setNestedScrollingEnabled(false);
      this.zTl.setHasFixedSize(true);
      AppMethodBeat.o(96406);
      return;
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96409);
    super.dUK();
    dZY();
    AppMethodBeat.o(96409);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96410);
    super.dUL();
    if (this.zTo != null)
    {
      int i = this.zTo.km();
      int j = this.zTo.ko();
      while (i <= j)
      {
        a locala = (a)this.zTn.get(Integer.valueOf(i));
        if (locala != null) {
          locala.eaa();
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
    long zTq;
    
    private a() {}
    
    final void dZZ()
    {
      AppMethodBeat.i(96394);
      if (this.isVisible)
      {
        AppMethodBeat.o(96394);
        return;
      }
      this.isVisible = true;
      this.zTq = System.currentTimeMillis();
      this.count += 1;
      AppMethodBeat.o(96394);
    }
    
    final void eaa()
    {
      AppMethodBeat.i(96395);
      if (this.isVisible)
      {
        this.isVisible = false;
        if (this.zTq > 0L)
        {
          this.time += System.currentTimeMillis() - this.zTq;
          this.zTq = 0L;
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
      int i = b.b(b.this).zQI.size();
      AppMethodBeat.o(96396);
      return i;
    }
    
    final class a
      extends RecyclerView.w
    {
      private h zTs;
      
      public a(View paramView, h paramh)
      {
        super();
        this.zTs = paramh;
      }
    }
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView gpr;
    private LinearLayoutManager nRC;
    int zTu;
    private int zTv;
    private int zTw;
    private long zTx;
    Runnable zTy;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96400);
      this.zTu = 2147483647;
      this.zTv = -1;
      this.zTw = -1;
      this.zTx = 0L;
      this.zTy = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96399);
          if (b.c.this.zTu == 1)
          {
            b.c localc = b.c.this;
            ae.d("AdLandingCarouselComp", "onDraggin first visible " + localc.zTr.zTo.km() + ", last visible " + localc.zTr.zTo.ko());
            b.a(localc.zTr);
            b.c.this.gpr.postDelayed(b.c.this.zTy, 100L);
          }
          AppMethodBeat.o(96399);
        }
      };
      this.gpr = paramRecyclerView;
      this.nRC = paramLinearLayoutManager;
      AppMethodBeat.o(96400);
    }
    
    private void eab()
    {
      AppMethodBeat.i(96401);
      this.gpr.getHandler().removeCallbacks(this.zTy);
      AppMethodBeat.o(96401);
    }
    
    private void m(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(96404);
      ae.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      b.a(b.this, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(96404);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96403);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96403);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96402);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.zTu)
      {
        if (paramInt != 1) {
          eab();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.zTu = paramInt;
        ae.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96402);
        return;
        b.a(b.this);
        if (this.zTu == 2)
        {
          int i = this.nRC.km();
          int j = this.nRC.ko();
          if (j < this.zTv)
          {
            m(j, this.zTv, System.currentTimeMillis() - this.zTx);
          }
          else if (i > this.zTw)
          {
            m(this.zTw, i, System.currentTimeMillis() - this.zTx);
            continue;
            eab();
            this.gpr.postDelayed(this.zTy, 100L);
            continue;
            this.zTv = this.nRC.km();
            this.zTw = this.nRC.ko();
            this.zTx = System.currentTimeMillis();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */