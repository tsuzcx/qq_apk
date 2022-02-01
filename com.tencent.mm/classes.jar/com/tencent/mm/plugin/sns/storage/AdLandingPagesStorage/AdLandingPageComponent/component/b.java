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
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
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
  extends n
{
  LinearLayoutManager AJH;
  int QMV;
  private RecyclerView QMW;
  private b QMX;
  private Map<Integer, a> QMY;
  Set<Integer> QMZ;
  
  public b(Context paramContext, s params, ViewGroup paramViewGroup)
  {
    super(paramContext, params, paramViewGroup);
    AppMethodBeat.i(96405);
    this.QMV = com.tencent.mm.cd.a.fromDPToPix(paramContext, 12);
    this.QMY = new HashMap();
    this.QMZ = new HashSet();
    AppMethodBeat.o(96405);
  }
  
  private void hiH()
  {
    AppMethodBeat.i(96407);
    if (this.AJH != null) {
      lu(this.AJH.Ju(), this.AJH.Jw());
    }
    AppMethodBeat.o(96407);
  }
  
  private void lu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96408);
    while (paramInt1 <= paramInt2)
    {
      a locala2 = (a)this.QMY.get(Integer.valueOf(paramInt1));
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.QMY.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.hiI();
      paramInt1 += 1;
    }
    AppMethodBeat.o(96408);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96406);
    this.QMW = ((RecyclerView)this.contentView.findViewById(b.f.recyclerView));
    this.QMW.setBackgroundColor(((s)this.QOV).backgroundColor);
    Object localObject = ((s)this.QOV).QKh.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      aa localaa = (aa)((Iterator)localObject).next();
      if (!(localaa instanceof u)) {
        break label257;
      }
      u localu = (u)localaa;
      float f = localaa.paddingBottom;
      j = (int)(localaa.paddingTop + f + localu.height) + (this.QMV << 1);
    } while (i > j);
    label257:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.QMW.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.QMW.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.QMX = new b((byte)0);
      this.QMW.setAdapter(this.QMX);
      this.AJH = new LinearLayoutManager();
      this.AJH.setOrientation(0);
      this.QMW.setLayoutManager(this.AJH);
      this.QMW.a(new c(this.QMW, this.AJH));
      this.QMW.setNestedScrollingEnabled(false);
      this.QMW.setHasFixedSize(true);
      AppMethodBeat.o(96406);
      return;
    }
  }
  
  public final boolean M(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(96411);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(96411);
      return false;
    }
    Object localObject1 = new JSONObject();
    if (super.bP((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.QMY;
      localObject1 = this.QMZ;
      this.QMZ = new HashSet();
      this.QMY = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (aa)((s)this.QOV).QKh.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((aa)localObject3).QKP) && ((localObject3 instanceof u)))
        {
          Object localObject5 = (u)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((aa)((s)this.QOV).QKh.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).QKG);
          ((JSONObject)localObject3).put("exposureCount", ((a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = MD5Util.getMD5String(((u)localObject5).QKj);
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
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_carousel;
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96409);
    super.hao();
    hiH();
    AppMethodBeat.o(96409);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96410);
    super.hap();
    if (this.AJH != null)
    {
      int i = this.AJH.Ju();
      int j = this.AJH.Jw();
      while (i <= j)
      {
        a locala = (a)this.QMY.get(Integer.valueOf(i));
        if (locala != null) {
          locala.hiJ();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(96410);
  }
  
  final class a
  {
    long QNa;
    int count;
    boolean isVisible;
    long time;
    
    private a() {}
    
    final void hiI()
    {
      AppMethodBeat.i(96394);
      if (this.isVisible)
      {
        AppMethodBeat.o(96394);
        return;
      }
      this.isVisible = true;
      this.QNa = System.currentTimeMillis();
      this.count += 1;
      AppMethodBeat.o(96394);
    }
    
    final void hiJ()
    {
      AppMethodBeat.i(96395);
      if (this.isVisible)
      {
        this.isVisible = false;
        if (this.QNa > 0L)
        {
          this.time += System.currentTimeMillis() - this.QNa;
          this.QNa = 0L;
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
      int i = ((s)b.this.QOV).QKh.size();
      AppMethodBeat.o(96396);
      return i;
    }
    
    final class a
      extends RecyclerView.v
    {
      private h QNc;
      
      public a(View paramView, h paramh)
      {
        super();
        this.QNc = paramh;
      }
    }
  }
  
  final class c
    extends RecyclerView.l
  {
    private int QNe;
    private int QNf;
    private int QNg;
    private long QNh;
    private Runnable QNi;
    private RecyclerView mkw;
    private LinearLayoutManager vqi;
    
    public c(RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
    {
      AppMethodBeat.i(307191);
      this.QNe = 2147483647;
      this.QNf = -1;
      this.QNg = -1;
      this.QNh = 0L;
      this.QNi = new Runnable()
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
      this.mkw = paramRecyclerView;
      this.vqi = paramLinearLayoutManager;
      AppMethodBeat.o(307191);
    }
    
    private void hiK()
    {
      AppMethodBeat.i(96401);
      this.mkw.getHandler().removeCallbacks(this.QNi);
      AppMethodBeat.o(96401);
    }
    
    private void v(int paramInt1, int paramInt2, long paramLong)
    {
      AppMethodBeat.i(96404);
      Log.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
      b.a(b.this, paramInt1, paramInt2, paramLong);
      AppMethodBeat.o(96404);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(307215);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt != this.QNe)
      {
        if (paramInt != 1) {
          hiK();
        }
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.QNe = paramInt;
        Log.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(307215);
        return;
        b.a(b.this);
        if (this.QNe == 2)
        {
          int i = this.vqi.Ju();
          int j = this.vqi.Jw();
          if (j < this.QNf)
          {
            v(j, this.QNf, System.currentTimeMillis() - this.QNh);
          }
          else if (i > this.QNg)
          {
            v(this.QNg, i, System.currentTimeMillis() - this.QNh);
            continue;
            hiK();
            this.mkw.postDelayed(this.QNi, 100L);
            continue;
            this.QNf = this.vqi.Ju();
            this.QNg = this.vqi.Jw();
            this.QNh = System.currentTimeMillis();
          }
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(307219);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingCarouselComp$MyScrollListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(307219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */