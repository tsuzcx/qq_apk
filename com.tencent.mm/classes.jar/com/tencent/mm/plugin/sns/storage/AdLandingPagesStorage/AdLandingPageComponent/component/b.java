package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
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
  extends k
{
  int wYF;
  private RecyclerView wYG;
  private b wYH;
  private Map<Integer, a> wYI;
  LinearLayoutManager wYJ;
  Set<Integer> wYK;
  
  public b(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(96405);
    this.wYF = com.tencent.mm.cd.a.fromDPToPix(paramContext, 12);
    this.wYI = new HashMap();
    this.wYK = new HashSet();
    AppMethodBeat.o(96405);
  }
  
  private void dvJ()
  {
    AppMethodBeat.i(96407);
    if (this.wYJ != null) {
      hd(this.wYJ.jO(), this.wYJ.jQ());
    }
    AppMethodBeat.o(96407);
  }
  
  private void hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96408);
    while (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.wYI.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.wYI.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.dvK();
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
    if (super.aG((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.wYI;
      localObject1 = this.wYK;
      this.wYK = new HashSet();
      this.wYI = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (x)((q)this.xab).wWn.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((x)localObject3).wWN) && ((localObject3 instanceof s)))
        {
          Object localObject5 = (s)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((x)((q)this.xab).wWn.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).wWE);
          ((JSONObject)localObject3).put("exposureCount", ((a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = ai.du(((s)localObject5).wWp);
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
      ad.e("AdLandingCarouselComp", bt.m(paramJSONArray));
      AppMethodBeat.o(96411);
      return false;
    }
    return true;
  }
  
  public final void dvA()
  {
    AppMethodBeat.i(96410);
    super.dvA();
    if (this.wYJ != null)
    {
      int i = this.wYJ.jO();
      int j = this.wYJ.jQ();
      while (i <= j)
      {
        a locala = (a)this.wYI.get(Integer.valueOf(i));
        if (locala != null) {
          locala.dvL();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(96410);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(96406);
    this.wYG = ((RecyclerView)this.contentView.findViewById(2131303914));
    this.wYG.setBackgroundColor(((q)this.xab).backgroundColor);
    Object localObject = ((q)this.xab).wWn.iterator();
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
      j = (int)(localx.paddingTop + f + locals.height) + (this.wYF << 1);
    } while (i > j);
    label259:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.wYG.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.wYG.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.wYH = new b((byte)0);
      this.wYG.setAdapter(this.wYH);
      this.wYJ = new LinearLayoutManager();
      this.wYJ.setOrientation(0);
      this.wYG.setLayoutManager(this.wYJ);
      this.wYG.a(new c(this.wYG, this.wYJ));
      this.wYG.setNestedScrollingEnabled(false);
      this.wYG.setHasFixedSize(true);
      AppMethodBeat.o(96406);
      return;
    }
  }
  
  public final void dvz()
  {
    AppMethodBeat.i(96409);
    super.dvz();
    dvJ();
    AppMethodBeat.o(96409);
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
    long wYL;
    
    private a() {}
    
    final void dvK()
    {
      AppMethodBeat.i(96394);
      if (this.isVisible)
      {
        AppMethodBeat.o(96394);
        return;
      }
      this.isVisible = true;
      this.wYL = System.currentTimeMillis();
      this.count += 1;
      AppMethodBeat.o(96394);
    }
    
    final void dvL()
    {
      AppMethodBeat.i(96395);
      if (this.isVisible)
      {
        this.isVisible = false;
        if (this.wYL > 0L)
        {
          this.time += System.currentTimeMillis() - this.wYL;
          this.wYL = 0L;
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
      int i = b.b(b.this).wWn.size();
      AppMethodBeat.o(96396);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      private g wYN;
      
      public a(View paramView, g paramg)
      {
        super();
        this.wYN = paramg;
      }
    }
  }
  
  final class c
    extends RecyclerView.m
  {
    RecyclerView fPw;
    private LinearLayoutManager mJn;
    int wYP;
    private int wYQ;
    private int wYR;
    private long wYS;
    Runnable wYT;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(96400);
      this.wYP = 2147483647;
      this.wYQ = -1;
      this.wYR = -1;
      this.wYS = 0L;
      this.wYT = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(96399);
          if (b.c.this.wYP == 1)
          {
            b.c localc = b.c.this;
            ad.d("AdLandingCarouselComp", "onDraggin first visible " + localc.wYM.wYJ.jO() + ", last visible " + localc.wYM.wYJ.jQ());
            b.a(localc.wYM);
            b.c.this.fPw.postDelayed(b.c.this.wYT, 100L);
          }
          AppMethodBeat.o(96399);
        }
      };
      this.fPw = paramRecyclerView;
      this.mJn = paramLinearLayoutManager;
      AppMethodBeat.o(96400);
    }
    
    private void dvM()
    {
      AppMethodBeat.i(96401);
      this.fPw.getHandler().removeCallbacks(this.wYT);
      AppMethodBeat.o(96401);
    }
    
    private void l(int paramInt1, int paramInt2, long paramLong)
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
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(96403);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(96402);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      if (paramInt != this.wYP)
      {
        if (paramInt != 1) {
          dvM();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.wYP = paramInt;
        ad.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(96402);
        return;
        b.a(b.this);
        if (this.wYP == 2)
        {
          int i = this.mJn.jO();
          int j = this.mJn.jQ();
          if (j < this.wYQ)
          {
            l(j, this.wYQ, System.currentTimeMillis() - this.wYS);
          }
          else if (i > this.wYR)
          {
            l(this.wYR, i, System.currentTimeMillis() - this.wYS);
            continue;
            dvM();
            this.fPw.postDelayed(this.wYT, 100L);
            continue;
            this.wYQ = this.mJn.jO();
            this.wYR = this.mJn.jQ();
            this.wYS = System.currentTimeMillis();
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