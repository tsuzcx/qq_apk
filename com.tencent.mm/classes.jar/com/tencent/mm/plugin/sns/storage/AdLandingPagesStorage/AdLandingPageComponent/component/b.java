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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
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
  extends k
{
  int ylt;
  private RecyclerView ylu;
  private b ylv;
  private Map<Integer, a> ylw;
  LinearLayoutManager ylx;
  Set<Integer> yly;
  
  public b(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(96405);
    this.ylt = com.tencent.mm.cc.a.fromDPToPix(paramContext, 12);
    this.ylw = new HashMap();
    this.yly = new HashSet();
    AppMethodBeat.o(96405);
  }
  
  private void dKi()
  {
    AppMethodBeat.i(96407);
    if (this.ylx != null) {
      hm(this.ylx.jW(), this.ylx.jY());
    }
    AppMethodBeat.o(96407);
  }
  
  private void hm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96408);
    while (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.ylw.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.ylw.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.dKj();
      paramInt1 += 1;
    }
    AppMethodBeat.o(96408);
  }
  
  public final boolean C(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(96411);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(96411);
      return false;
    }
    Object localObject1 = new JSONObject();
    if (super.aH((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.ylw;
      localObject1 = this.yly;
      this.yly = new HashSet();
      this.ylw = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (x)((q)this.ymQ).yjb.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((x)localObject3).yjB) && ((localObject3 instanceof s)))
        {
          Object localObject5 = (s)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((x)((q)this.ymQ).yjb.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).yjs);
          ((JSONObject)localObject3).put("exposureCount", ((a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = ah.dg(((s)localObject5).yjd);
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
      ac.e("AdLandingCarouselComp", bs.m(paramJSONArray));
      AppMethodBeat.o(96411);
      return false;
    }
    return true;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96406);
    this.ylu = ((RecyclerView)this.contentView.findViewById(2131303914));
    this.ylu.setBackgroundColor(((q)this.ymQ).backgroundColor);
    Object localObject = ((q)this.ymQ).yjb.iterator();
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
      j = (int)(localx.paddingTop + f + locals.height) + (this.ylt << 1);
    } while (i > j);
    label259:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.ylu.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.ylu.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ylv = new b((byte)0);
      this.ylu.setAdapter(this.ylv);
      this.ylx = new LinearLayoutManager();
      this.ylx.setOrientation(0);
      this.ylu.setLayoutManager(this.ylx);
      this.ylu.a(new c(this.ylu, this.ylx));
      this.ylu.setNestedScrollingEnabled(false);
      this.ylu.setHasFixedSize(true);
      AppMethodBeat.o(96406);
      return;
    }
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96409);
    super.dJY();
    dKi();
    AppMethodBeat.o(96409);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96410);
    super.dJZ();
    if (this.ylx != null)
    {
      int i = this.ylx.jW();
      int j = this.ylx.jY();
      while (i <= j)
      {
        a locala = (a)this.ylw.get(Integer.valueOf(i));
        if (locala != null) {
          locala.dKk();
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
    long ylz;
    
    private a() {}
    
    final void dKj()
    {
      AppMethodBeat.i(96394);
      if (this.isVisible)
      {
        AppMethodBeat.o(96394);
        return;
      }
      this.isVisible = true;
      this.ylz = System.currentTimeMillis();
      this.count += 1;
      AppMethodBeat.o(96394);
    }
    
    final void dKk()
    {
      AppMethodBeat.i(96395);
      if (this.isVisible)
      {
        this.isVisible = false;
        if (this.ylz > 0L)
        {
          this.time += System.currentTimeMillis() - this.ylz;
          this.ylz = 0L;
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
      int i = b.b(b.this).yjb.size();
      AppMethodBeat.o(96396);
      return i;
    }
    
    final class a
      extends RecyclerView.w
    {
      private g ylB;
      
      public a(View paramView, g paramg)
      {
        super();
        this.ylB = paramg;
      }
    }
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView fTr;
    private LinearLayoutManager nlq;
    int ylD;
    private int ylE;
    private int ylF;
    private long ylG;
    Runnable ylH;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96400);
      this.ylD = 2147483647;
      this.ylE = -1;
      this.ylF = -1;
      this.ylG = 0L;
      this.ylH = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96399);
          if (b.c.this.ylD == 1)
          {
            b.c localc = b.c.this;
            ac.d("AdLandingCarouselComp", "onDraggin first visible " + localc.ylA.ylx.jW() + ", last visible " + localc.ylA.ylx.jY());
            b.a(localc.ylA);
            b.c.this.fTr.postDelayed(b.c.this.ylH, 100L);
          }
          AppMethodBeat.o(96399);
        }
      };
      this.fTr = paramRecyclerView;
      this.nlq = paramLinearLayoutManager;
      AppMethodBeat.o(96400);
    }
    
    private void dKl()
    {
      AppMethodBeat.i(96401);
      this.fTr.getHandler().removeCallbacks(this.ylH);
      AppMethodBeat.o(96401);
    }
    
    private void l(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(96404);
      ac.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      b.a(b.this, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(96404);
    }
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(96403);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96403);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96402);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.ylD)
      {
        if (paramInt != 1) {
          dKl();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.ylD = paramInt;
        ac.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96402);
        return;
        b.a(b.this);
        if (this.ylD == 2)
        {
          int i = this.nlq.jW();
          int j = this.nlq.jY();
          if (j < this.ylE)
          {
            l(j, this.ylE, System.currentTimeMillis() - this.ylG);
          }
          else if (i > this.ylF)
          {
            l(this.ylF, i, System.currentTimeMillis() - this.ylG);
            continue;
            dKl();
            this.fTr.postDelayed(this.ylH, 100L);
            continue;
            this.ylE = this.nlq.jW();
            this.ylF = this.nlq.jY();
            this.ylG = System.currentTimeMillis();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */