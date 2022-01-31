package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.ui.al;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

final class o$a
  extends android.support.v4.view.n
{
  int backgroundColor;
  int gHR;
  int gHS;
  Context mContext;
  LayoutInflater mLayoutInflater;
  com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n oGC;
  private int oGD = 600;
  int oGE = 700;
  int oGF = 250;
  HashMap<String, View> oGG = new HashMap();
  HashMap<String, o.a.a> oGH = new HashMap();
  
  public o$a(Context paramContext, LayoutInflater paramLayoutInflater, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n paramn, int paramInt)
  {
    this.mContext = paramContext;
    this.mLayoutInflater = paramLayoutInflater;
    this.oGC = paramn;
    this.backgroundColor = paramInt;
    paramContext = (WindowManager)this.mContext.getSystemService("window");
    this.gHR = paramContext.getDefaultDisplay().getWidth();
    this.gHS = paramContext.getDefaultDisplay().getHeight();
  }
  
  private o.a.a a(List<s> paramList, int paramInt1, int paramInt2, ViewGroup paramViewGroup)
  {
    o.a.a locala = new o.a.a(this);
    if (paramList == null) {
      return locala;
    }
    paramInt1 = Math.max(0, paramInt1);
    paramInt2 = Math.min(paramList.size(), paramInt2);
    while (paramInt1 < paramInt2)
    {
      Object localObject = (s)paramList.get(paramInt1);
      localObject = al.a(this.mContext, (s)localObject, paramViewGroup, this.backgroundColor);
      locala.oGN.add(localObject);
      paramViewGroup.addView(((i)localObject).getView());
      paramInt1 += 1;
    }
    return locala;
  }
  
  public final int F(Object paramObject)
  {
    return -2;
  }
  
  public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public final boolean a(View paramView, Object paramObject)
  {
    return paramView == (View)paramObject;
  }
  
  public final Object b(ViewGroup paramViewGroup, int paramInt)
  {
    View localView = this.mLayoutInflater.inflate(i.g.sns_ad_native_landing_pages_item_trunpages, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_linaerlayout);
    localLinearLayout.setBackgroundColor(this.backgroundColor);
    Object localObject1 = (o.a.a)this.oGH.get(String.valueOf(paramInt));
    Object localObject2 = ((m)this.oGC.oCS.get(paramInt)).oCS;
    if ((localObject1 == null) || (((o.a.a)localObject1).oGN.size() == 0))
    {
      localObject1 = a((List)localObject2, 0, ((List)localObject2).size(), localLinearLayout);
      this.oGH.put(String.valueOf(paramInt), localObject1);
      localObject1 = (ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_right_icon);
      localObject2 = (TextView)localView.findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_page_tv);
      if (this.backgroundColor + 16777216 > -1 - this.backgroundColor) {
        break label441;
      }
      ((ImageView)localObject1).setImageDrawable(a.g(this.mContext, i.e.page_icon_direction_right));
    }
    for (;;)
    {
      if (this.oGC.oCU != 1) {
        break label459;
      }
      ((ImageView)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.gHR, localLinearLayout.getMeasuredHeight()));
      localView.setBackgroundColor(this.backgroundColor);
      paramViewGroup.addView(localView);
      paramViewGroup.setBackgroundColor(this.backgroundColor);
      this.oGG.put(String.valueOf(paramInt), localView);
      return localView;
      Object localObject3 = a((List)localObject2, ((o.a.a)localObject1).oGN.size(), ((List)localObject2).size(), localLinearLayout);
      ((o.a.a)localObject1).oGN.addAll(((o.a.a)localObject3).oGN);
      localObject3 = ((o.a.a)localObject1).oGN.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        i locali = (i)((Iterator)localObject3).next();
        if ((locali.getView().getParent() != null) && ((locali.getView().getParent() instanceof ViewGroup))) {
          ((ViewGroup)locali.getView().getParent()).removeView(locali.getView());
        }
      }
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject3 = (i)((o.a.a)localObject1).oGN.get(i);
        localLinearLayout.addView(((i)localObject3).getView());
        ((i)localObject3).a((s)((List)localObject2).get(i));
        i += 1;
      }
      break;
      label441:
      ((ImageView)localObject1).setImageDrawable(a.g(this.mContext, i.e.page_right_dark_xxhdpi));
    }
    label459:
    if (paramInt == this.oGC.oCS.size() - 1) {
      ((ImageView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramInt + 1 + "/" + this.oGC.oCS.size());
      break;
      ((ImageView)localObject1).setVisibility(0);
    }
  }
  
  public final int getCount()
  {
    return this.oGC.oCS.size();
  }
  
  public final void j(Object paramObject) {}
  
  public final void yd(int paramInt)
  {
    Object localObject = (View)this.oGG.get(String.valueOf(paramInt));
    if (localObject == null) {}
    do
    {
      return;
      localObject = (ImageView)((View)localObject).findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_right_icon);
    } while ((localObject == null) || (((ImageView)localObject).getVisibility() != 0) || ((((ImageView)localObject).getTag() != null) && ((((ImageView)localObject).getTag() instanceof String)) && (new BigInteger((String)((ImageView)localObject).getTag()).longValue() >= 1L)));
    ((ImageView)localObject).setTag("1");
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
    localAlphaAnimation.setDuration(this.oGD);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
    localAlphaAnimation.setAnimationListener(new o.a.2(this, (ImageView)localObject));
    ((ImageView)localObject).startAnimation(localAlphaAnimation);
  }
  
  public final void ye(int paramInt)
  {
    Iterator localIterator = this.oGH.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      o.a.a locala = (o.a.a)this.oGH.get(localObject);
      if ((locala != null) && (locala.oGN.size() != 0))
      {
        int i;
        if (((String)localObject).equals(String.valueOf(paramInt)))
        {
          i = 0;
          while (i < locala.oGN.size())
          {
            localObject = (i)locala.oGN.get(i);
            if (!((i)localObject).oFH) {
              ((i)localObject).bET();
            }
            i += 1;
          }
        }
        else
        {
          i = 0;
          while (i < locala.oGN.size())
          {
            localObject = (i)locala.oGN.get(i);
            if (((i)localObject).oFH) {
              ((i)localObject).bEU();
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a
 * JD-Core Version:    0.7.0.1
 */