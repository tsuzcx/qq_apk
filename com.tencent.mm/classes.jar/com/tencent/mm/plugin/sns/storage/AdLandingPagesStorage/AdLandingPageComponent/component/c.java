package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public final class c
  extends i
{
  int oEX;
  private RecyclerView oEY;
  private c.b oEZ;
  Map<Integer, c.a> oFa;
  LinearLayoutManager oFb;
  Set<Integer> oFc;
  
  public c(Context paramContext, m paramm, ViewGroup paramViewGroup)
  {
    super(paramContext, paramm, paramViewGroup);
    this.oEX = a.fromDPToPix(paramContext, 12);
    this.oFa = new HashMap();
    this.oFc = new HashSet();
  }
  
  private void bFg()
  {
    if (this.oFb != null) {
      dO(this.oFb.gY(), this.oFb.ha());
    }
  }
  
  public final void bET()
  {
    super.bET();
    bFg();
  }
  
  public final void bEU()
  {
    super.bEU();
    if (this.oFb != null)
    {
      int i = this.oFb.gY();
      int j = this.oFb.ha();
      while (i <= j)
      {
        c.a locala = (c.a)this.oFa.get(Integer.valueOf(i));
        if (locala != null) {
          locala.bFh();
        }
        i += 1;
      }
    }
  }
  
  public final View bFf()
  {
    this.oEY = ((RecyclerView)this.contentView.findViewById(i.f.recyclerView));
    this.oEY.setBackgroundColor(((m)this.oFE).backgroundColor);
    Object localObject = ((m)this.oFE).oCS.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      s locals = (s)((Iterator)localObject).next();
      if (!(locals instanceof p)) {
        break label251;
      }
      p localp = (p)locals;
      float f = locals.oDj;
      j = (int)(locals.oDi + f + localp.height) + (this.oEX << 1);
    } while (i > j);
    label251:
    for (;;)
    {
      i = j;
      continue;
      localObject = this.oEY.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i;
      this.oEY.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.oEZ = new c.b(this, (byte)0);
      this.oEY.setAdapter(this.oEZ);
      this.oFb = new LinearLayoutManager();
      this.oFb.setOrientation(0);
      this.oEY.setLayoutManager(this.oFb);
      this.oEY.a(new c.c(this, this.oEY, this.oFb));
      this.oEY.setNestedScrollingEnabled(false);
      this.oEY.setHasFixedSize(true);
      return this.contentView;
    }
  }
  
  final void dO(int paramInt1, int paramInt2)
  {
    while (paramInt1 <= paramInt2)
    {
      c.a locala2 = (c.a)this.oFa.get(Integer.valueOf(paramInt1));
      c.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new c.a(this, (byte)0);
        this.oFa.put(Integer.valueOf(paramInt1), locala1);
      }
      if (!locala1.isVisible)
      {
        locala1.isVisible = true;
        locala1.oFd = System.currentTimeMillis();
        locala1.count += 1;
      }
      paramInt1 += 1;
    }
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_carousel;
  }
  
  public final boolean v(JSONArray paramJSONArray)
  {
    Object localObject1 = new JSONObject();
    if (super.ah((JSONObject)localObject1)) {
      paramJSONArray.put(localObject1);
    }
    try
    {
      Object localObject2 = this.oFa;
      localObject1 = this.oFc;
      this.oFc = new HashSet();
      this.oFa = new HashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = (s)((m)this.oFE).oCS.get(((Integer)((Map.Entry)localObject4).getKey()).intValue());
        if ((!((s)localObject3).oDt) && ((localObject3 instanceof p)))
        {
          Object localObject5 = (p)localObject3;
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("cid", ((s)((m)this.oFE).oCS.get(((Integer)((Map.Entry)localObject4).getKey()).intValue())).oDg);
          ((JSONObject)localObject3).put("exposureCount", ((c.a)((Map.Entry)localObject4).getValue()).count);
          ((JSONObject)localObject3).put("stayTime", ((c.a)((Map.Entry)localObject4).getValue()).time);
          if (((Set)localObject1).contains(((Map.Entry)localObject4).getKey()))
          {
            localObject4 = ad.bB(((p)localObject5).oCV);
            localObject5 = new JSONObject();
            ((JSONObject)localObject5).put("urlMd5", localObject4);
            ((JSONObject)localObject5).put("needDownload", 1);
            ((JSONObject)localObject3).put("imgUrlInfo", localObject5);
          }
          paramJSONArray.put(localObject3);
        }
      }
      return true;
    }
    catch (JSONException paramJSONArray)
    {
      y.e("AdLandingCarouselComp", bk.j(paramJSONArray));
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c
 * JD-Core Version:    0.7.0.1
 */