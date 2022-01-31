package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class o
  extends i
{
  private static final Map<String, Bitmap> oGt = new WeakHashMap();
  ViewPager oGu;
  o.a oGv;
  AdLandingControlView oGw;
  private int oGx = 0;
  private int oGy = 0;
  boolean oGz = true;
  
  public o(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n paramn, ViewGroup paramViewGroup)
  {
    super(paramContext, paramn, paramViewGroup);
    this.oGw = new AdLandingControlView(paramContext);
  }
  
  public final void L(Map<String, Object> paramMap)
  {
    super.L(paramMap);
    if (paramMap.containsKey("startIndex")) {}
    try
    {
      this.oGx = ((Integer)paramMap.get("startIndex")).intValue();
      this.oGu.m(this.oGx, false);
      return;
    }
    catch (Exception paramMap) {}
  }
  
  public final boolean ah(JSONObject paramJSONObject)
  {
    return super.ah(paramJSONObject);
  }
  
  public final void bET()
  {
    int i = this.oGu.getCurrentItem();
    this.oGv.yd(i);
    if (this.oGz)
    {
      this.oGv.ye(0);
      this.oGz = false;
    }
    for (;;)
    {
      super.bET();
      return;
      this.oGv.ye(this.oGy);
    }
  }
  
  public final void bEU()
  {
    this.oGv.ye(-1);
    super.bEU();
  }
  
  public final View bFf()
  {
    View localView = this.contentView;
    this.oGu = ((ViewPager)localView.findViewById(i.f.sns_ad_native_landing_pages_items_turnimages_viewpager));
    this.oGw = ((AdLandingControlView)localView.findViewById(i.f.sns_ad_native_lading_pages_turnimages_indicator));
    return localView;
  }
  
  protected final void bFj()
  {
    Object localObject1 = (WindowManager)this.context.getSystemService("window");
    int j = ((WindowManager)localObject1).getDefaultDisplay().getWidth() - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).oDk - (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).oDl;
    int k = ((WindowManager)localObject1).getDefaultDisplay().getHeight();
    Object localObject2 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    if (this.oGu.getAdapter() == null)
    {
      localObject1 = new o.a(this.context, (LayoutInflater)localObject2, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE, this.backgroundColor);
      this.oGu.setOnPageChangeListener(new o.1(this, (o.a)localObject1));
      this.oGu.setAdapter((android.support.v4.view.n)localObject1);
      this.oGw.fr(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).oCS.size(), 0);
      if (!((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).hqp) {
        break label229;
      }
      this.oGu.setLayoutParams(new RelativeLayout.LayoutParams(j, k));
    }
    label229:
    while (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).oCS.size() <= 0)
    {
      this.oGv = ((o.a)localObject1);
      ((o.a)localObject1).notifyDataSetChanged();
      return;
      localObject1 = (o.a)this.oGu.getAdapter();
      ((o.a)localObject1).oGC = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE);
      break;
    }
    Object localObject3 = (m)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).oCS.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject3 = ((m)localObject3).oCS.iterator();
    label292:
    s locals;
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      locals = (s)((Iterator)localObject3).next();
      i = (int)(i + locals.oDi);
      if ((locals instanceof u))
      {
        localObject4 = (u)locals;
        View localView = ((LayoutInflater)localObject2).inflate(i.g.sns_ad_native_landing_pages_item_text, null);
        localView.setBackgroundColor(this.backgroundColor);
        ((TextView)localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle)).setText(((u)localObject4).oDD);
        int m = View.MeasureSpec.makeMeasureSpec(0, 0);
        int n = View.MeasureSpec.makeMeasureSpec(0, 0);
        ((TextView)localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle)).measure(m, n);
        m = ((TextView)localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle)).getPaddingTop();
        n = ((TextView)localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle)).getHeight();
        i = ((TextView)localView.findViewById(i.f.sns_ad_landingpage_text_wordTitle)).getPaddingBottom() + (i + m + n);
      }
    }
    for (;;)
    {
      float f1 = i;
      i = (int)(locals.oDj + f1);
      break label292;
      if ((locals instanceof l))
      {
        localObject4 = (Button)((LayoutInflater)localObject2).inflate(i.g.sns_ad_native_landing_pages_item_btn, null).findViewById(i.f.sns_ad_native_landing_pages_item_btn_btn);
        ((Button)localObject4).setText(((l)locals).title);
        ((Button)localObject4).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = ((Button)localObject4).getPaddingTop() + i;
        if ((locals.oDn > 0.0F) && ((int)locals.oDn != 2147483647)) {
          i = (int)(i + locals.oDn);
        }
        for (;;)
        {
          i = ((Button)localObject4).getPaddingBottom() + i;
          break;
          if ((locals.height > 0.0F) && ((int)locals.height != 2147483647)) {
            i = (int)(i + locals.height);
          } else {
            i += ((Button)localObject4).getHeight();
          }
        }
      }
      if ((locals instanceof p))
      {
        float f2 = 0.0F;
        f1 = 0.0F;
        float f3 = locals.oDi;
        float f4 = locals.oDj;
        if ((locals instanceof p))
        {
          localObject4 = (p)locals;
          f2 = ((p)localObject4).height;
          f1 = ((p)localObject4).width;
        }
        if (((int)f2 != 0) && ((int)f1 != 0))
        {
          float f5 = i;
          i = (int)(f2 * j / f1 + f5);
        }
        for (;;)
        {
          i = (int)((int)(i + f3) + f4);
          break;
          i += k;
        }
      }
      if ((locals instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o))
      {
        i += k;
      }
      else if ((locals instanceof q))
      {
        localObject4 = (q)locals;
        if (((q)localObject4).oDd == 1)
        {
          i += k;
        }
        else if ((int)((q)localObject4).width > 0)
        {
          i = (int)((q)localObject4).height * j / (int)((q)localObject4).width + i;
        }
        else
        {
          f1 = i;
          i = (int)(((q)localObject4).height + f1);
        }
      }
      else if ((locals instanceof w))
      {
        localObject4 = (w)locals;
        if (((w)localObject4).oDL == 1)
        {
          if ((int)((w)localObject4).width > 0)
          {
            i = (int)((w)localObject4).height * j / (int)((w)localObject4).width + i;
          }
          else
          {
            f1 = i;
            i = (int)(((w)localObject4).height + f1);
          }
        }
        else {
          i += k;
        }
      }
      else if ((locals instanceof v))
      {
        i += k;
        continue;
        localObject2 = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).oDk);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n)this.oFE).oDl);
        this.oGu.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
      }
    }
  }
  
  public final void bFo()
  {
    super.bFo();
    this.oGu.m(this.oGx, false);
  }
  
  public final LinkedList<JSONObject> bFx()
  {
    o.a locala = this.oGv;
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = locala.oGH.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (o.a.a)locala.oGH.get(localObject);
      if ((localObject != null) && (((o.a.a)localObject).oGN.size() != 0))
      {
        int i = 0;
        while (i < ((o.a.a)localObject).oGN.size())
        {
          i locali = (i)((o.a.a)localObject).oGN.get(i);
          JSONObject localJSONObject = new JSONObject();
          if (locali.ah(localJSONObject)) {
            localLinkedList.add(localJSONObject);
          }
          i += 1;
        }
      }
    }
    return localLinkedList;
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_turnimages;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */