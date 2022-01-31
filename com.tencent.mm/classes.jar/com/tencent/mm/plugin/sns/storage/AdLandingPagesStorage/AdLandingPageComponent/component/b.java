package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
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
  extends h
{
  private b ruA;
  private Map<Integer, b.a> ruB;
  LinearLayoutManager ruC;
  Set<Integer> ruD;
  int ruy;
  private RecyclerView ruz;
  
  public b(Context paramContext, m paramm, ViewGroup paramViewGroup)
  {
    super(paramContext, paramm, paramViewGroup);
    AppMethodBeat.i(37024);
    this.ruy = a.fromDPToPix(paramContext, 12);
    this.ruB = new HashMap();
    this.ruD = new HashSet();
    AppMethodBeat.o(37024);
  }
  
  private void cqL()
  {
    AppMethodBeat.i(37026);
    if (this.ruC != null) {
      fx(this.ruC.it(), this.ruC.iv());
    }
    AppMethodBeat.o(37026);
  }
  
  private void fx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37027);
    while (paramInt1 <= paramInt2)
    {
      b.a locala2 = (b.a)this.ruB.get(Integer.valueOf(paramInt1));
      b.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new b.a(this, (byte)0);
        this.ruB.put(Integer.valueOf(paramInt1), locala1);
      }
      locala1.cqM();
      paramInt1 += 1;
    }
    AppMethodBeat.o(37027);
  }
  
  public final boolean A(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(37030);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(37030);
      return false;
    }
    Object localObject1 = new JSONObject();
    if (super.aq((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.ruB;
      localObject1 = this.ruD;
      this.ruD = new HashSet();
      this.ruB = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (t)((m)this.rve).rsu.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((t)localObject3).rsR) && ((localObject3 instanceof o)))
        {
          Object localObject5 = (o)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((t)((m)this.rve).rsu.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).rsI);
          ((JSONObject)localObject3).put("exposureCount", ((b.a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((b.a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = ag.cE(((o)localObject5).rsw);
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("urlMd5", localObject4);
            ((JSONObject)localObject5).put("needDownload", 1);
            ((JSONObject)localObject3).put("imgUrlInfo", localObject5);
          }
          paramJSONArray.put(localObject3);
        }
      }
      AppMethodBeat.o(37030);
    }
    catch (JSONException paramJSONArray)
    {
      ab.e("AdLandingCarouselComp", bo.l(paramJSONArray));
      AppMethodBeat.o(37030);
      return false;
    }
    return true;
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37028);
    super.cqA();
    cqL();
    AppMethodBeat.o(37028);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37029);
    super.cqB();
    if (this.ruC != null)
    {
      int i = this.ruC.it();
      int j = this.ruC.iv();
      while (i <= j)
      {
        b.a locala = (b.a)this.ruB.get(Integer.valueOf(i));
        if (locala != null) {
          locala.cqN();
        }
        i += 1;
      }
    }
    AppMethodBeat.o(37029);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37025);
    this.ruz = ((RecyclerView)this.contentView.findViewById(2131827853));
    this.ruz.setBackgroundColor(((m)this.rve).backgroundColor);
    Object localObject = ((m)this.rve).rsu.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      t localt = (t)((Iterator)localObject).next();
      if (!(localt instanceof o)) {
        break label259;
      }
      o localo = (o)localt;
      float f = localt.paddingBottom;
      j = (int)(localt.paddingTop + f + localo.height) + (this.ruy << 1);
    } while (i > j);
    label259:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.ruz.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.ruz.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.ruA = new b((byte)0);
      this.ruz.setAdapter(this.ruA);
      this.ruC = new LinearLayoutManager();
      this.ruC.setOrientation(0);
      this.ruz.setLayoutManager(this.ruC);
      this.ruz.a(new b.c(this, this.ruz, this.ruC));
      this.ruz.setNestedScrollingEnabled(false);
      this.ruz.setHasFixedSize(true);
      AppMethodBeat.o(37025);
      return;
    }
  }
  
  protected final int getLayout()
  {
    return 2130970780;
  }
  
  final class b
    extends RecyclerView.a<b.b.a>
  {
    private b() {}
    
    public final int getItemCount()
    {
      AppMethodBeat.i(37015);
      int i = b.b(b.this).rsu.size();
      AppMethodBeat.o(37015);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b
 * JD-Core Version:    0.7.0.1
 */