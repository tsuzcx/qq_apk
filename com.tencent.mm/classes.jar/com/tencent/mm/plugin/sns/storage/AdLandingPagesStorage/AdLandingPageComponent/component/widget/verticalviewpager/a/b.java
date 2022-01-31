package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public final class b
  extends Fragment
{
  private static int oJl;
  private int bgColor;
  private ai bjo;
  private boolean eXC;
  private boolean euf;
  private int fdf;
  private int gHR;
  private int gHS;
  private LinearLayoutManager oFb;
  private int oGD = 1000;
  private int oGE = 700;
  private final Map<String, Bitmap> oGt = new WeakHashMap();
  private g oJg;
  private int oJj;
  public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b oJm;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z oJn;
  private boolean oJo;
  private boolean oJp;
  private boolean oJq;
  public boolean oJr;
  public boolean oJs = false;
  private int oJt;
  public int oJu;
  private b.a oJv;
  public b.b oJw;
  private a oJx;
  private boolean oJy;
  
  private void L(Bitmap paramBitmap)
  {
    int i;
    if (paramBitmap != null)
    {
      this.oJw.khn.setBackgroundColor(0);
      this.oJw.oJI.setBackgroundColor(0);
      this.oJw.fXV.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.oJw.oJI.getLayoutParams();
      if (localLayoutParams.height >= this.gHS)
      {
        i = localLayoutParams.height;
        localLayoutParams.height = i;
        this.oJw.oJI.setLayoutParams(localLayoutParams);
        this.oJw.oJI.setImageBitmap(paramBitmap);
      }
    }
    for (;;)
    {
      bFO();
      return;
      i = this.gHS;
      break;
      bFN();
    }
  }
  
  private void aRr()
  {
    if (this.oJw == null) {
      return;
    }
    bFN();
    Object localObject;
    if ((this.oJg.oKv != null) && (this.oJg.oKv.length() > 0))
    {
      localObject = this.oJg.oKv;
      y.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.oJg.oKw), localObject });
      if (this.oGt.containsKey(localObject))
      {
        y.i("ContentFragment", "bg has cache bitmap");
        L((Bitmap)this.oGt.get(localObject));
        label110:
        if (this.oJx == null) {
          break label207;
        }
        if ((this.oJg.oKv == null) || (this.oJg.oKv.length() <= 0)) {
          break label209;
        }
      }
    }
    label207:
    label209:
    for (this.oJx.bgColor = 0;; this.oJx.bgColor = this.bgColor)
    {
      localObject = this.oJx;
      g localg = this.oJg;
      if (((a)localObject).oJg == localg) {
        break;
      }
      ((a)localObject).oJg = localg;
      ((RecyclerView.a)localObject).agL.notifyChanged();
      return;
      h.c("adId", (String)localObject, false, 1000000001, new b.2(this, (String)localObject));
      break label110;
      bFN();
      break label110;
      break;
    }
  }
  
  private void bFN()
  {
    if ((this.oJg.fNR != null) && (this.oJg.fNR.length() > 0)) {
      y.i("ContentFragment", "setting bg color %s", new Object[] { this.oJg.fNR });
    }
    try
    {
      this.bgColor = Color.parseColor(this.oJg.fNR);
      this.oJw.khn.setBackgroundColor(this.bgColor);
      this.oJw.oJI.setBackgroundColor(this.bgColor);
      this.oJw.fXV.setBackgroundColor(this.bgColor);
      bFO();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("ContentFragment", "the color is error : " + this.oJg.fNR);
      }
    }
  }
  
  private void bFO()
  {
    if ((this.bgColor == 0) && (this.oJg.fNR != null) && (this.oJg.fNR.length() > 0)) {
      y.i("ContentFragment", "setDirectionColor bg color %s", new Object[] { this.oJg.fNR });
    }
    try
    {
      this.bgColor = Color.parseColor(this.oJg.fNR);
      if (this.bgColor + 16777216 <= -1 - this.bgColor)
      {
        this.oJw.oJJ.setImageDrawable(com.tencent.mm.cb.a.g(getActivity(), i.e.page_down_direction_down));
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("ContentFragment", "the color is error : " + this.oJg.fNR);
      }
      this.oJw.oJJ.setImageDrawable(com.tencent.mm.cb.a.g(getActivity(), i.e.page_down_dark_xxhdpi));
    }
  }
  
  public final void a(g paramg)
  {
    if (this.oJg != paramg)
    {
      this.oJg = paramg;
      aRr();
    }
  }
  
  public final Collection<i> bFL()
  {
    if (this.oJx == null) {
      return Collections.EMPTY_LIST;
    }
    return this.oJx.bFL();
  }
  
  public final void bFM()
  {
    if (this.oJm != null) {
      this.oJm.bFH();
    }
  }
  
  public final void bFP()
  {
    if (this.oJw.oJJ.getVisibility() == 0)
    {
      this.oJw.oJJ.clearAnimation();
      this.oJw.oJJ.setVisibility(4);
    }
  }
  
  public final void bFQ()
  {
    if ((!bFR()) || (this.oJs)) {
      return;
    }
    this.oJw.oJJ.clearAnimation();
    this.oJw.oJJ.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
    localAlphaAnimation.setDuration(this.oGD);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
    localAlphaAnimation.setStartOffset(this.oGD);
    localAlphaAnimation.setAnimationListener(new b.4(this));
    if ((this.oJn != null) && (!this.oJn.equals(this.oJw.oJJ.getTag())))
    {
      this.oJw.oJJ.setTag(this.oJn);
      this.oJw.oJJ.setVisibility(8);
      h.a(this.oJn.iconUrl, 1000000001, new b.5(this, localAlphaAnimation));
      return;
    }
    this.oJw.oJJ.startAnimation(localAlphaAnimation);
  }
  
  public final boolean bFR()
  {
    if (!this.oJq) {}
    int j;
    int i;
    do
    {
      do
      {
        return false;
      } while ((this.oJt != 0) || (this.oJu != 0));
      j = this.oFb.gY();
      i = this.oFb.ha();
    } while ((j == i) && (j == -1));
    if (i >= j)
    {
      Object localObject = this.oJx;
      s locals = (s)((a)localObject).oJg.oKx.get(i);
      localObject = (i)((a)localObject).oJh.get(locals.oDg);
      if ((localObject instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z))
      {
        int k = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z)localObject).bFE();
        if ((k < 0) || (k >= oJl)) {}
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      boolean bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (this.eXC) {
          if (this.oFb.ha() == this.oJx.getItemCount() - 1) {
            break label178;
          }
        }
      }
      label178:
      for (bool2 = true;; bool2 = false)
      {
        return bool2;
        i -= 1;
        break;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    oJl = com.tencent.mm.cb.a.fromDPToPix(getContext(), 60);
    paramBundle = ad.ed(getContext());
    this.gHR = paramBundle[0];
    this.gHS = paramBundle[1];
    if (this.oJg == null) {
      this.oJg = ((g)getArguments().getSerializable("pageInfo"));
    }
    this.oJv = ((b.a)getArguments().getSerializable("lifecyleListener"));
    this.oJn = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z)getArguments().getSerializable("pageDownIconInfo"));
    this.oJo = getArguments().getBoolean("is_first_show_page", false);
    this.eXC = getArguments().getBoolean("is_last_shown_page", false);
    this.oJp = getArguments().getBoolean("needEnterAnimation", false);
    this.oJq = getArguments().getBoolean("needDirectionAnimation", false);
    this.oJj = getArguments().getInt("groupListCompShowIndex", 0);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(i.g.ad_landing_page_item, paramViewGroup, false);
    this.oJw = new b.b((byte)0);
    this.oJw.khn = paramLayoutInflater;
    this.oJw.oJI = ((ImageView)paramLayoutInflater.findViewById(i.f.sns_ad_native_landing_pages_background_img));
    this.oJw.fXV = ((LinearLayout)paramLayoutInflater.findViewById(i.f.sns_ad_native_landing_pages_sub_linear_layout));
    this.oJw.oJJ = ((ImageView)paramLayoutInflater.findViewById(i.f.sns_native_landing_pages_next_img));
    this.oJw.heQ = ((RecyclerView)paramLayoutInflater.findViewById(i.f.content_list));
    this.oJw.oJL = ((LinearLayout)paramLayoutInflater.findViewById(i.f.fake_container));
    paramViewGroup = this.oJw.heQ;
    paramViewGroup.setOverScrollMode(2);
    paramViewGroup.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a((DummyViewPager)getArguments().getSerializable("viewPager")));
    getActivity();
    this.oFb = new LinearLayoutManager();
    paramViewGroup.setLayoutManager(this.oFb);
    this.oJx = new a(this.oJg, this.bgColor, getActivity(), this.oFb);
    if (this.oJo) {
      this.oJx.oJj = this.oJj;
    }
    paramViewGroup.setAdapter(this.oJx);
    this.oJm = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b(paramViewGroup, this);
    paramViewGroup.a(new b.1(this));
    paramLayoutInflater.setTag(this.oJw);
    aRr();
    if (this.oJv != null) {
      this.oJv.p(this);
    }
    return paramLayoutInflater;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if (this.oJm != null) {
      this.oJm.oIM.onDestroy();
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    new StringBuilder().append(this).append(" onPause ").append(getUserVisibleHint());
    this.euf = false;
    if ((this.oJm != null) && (getUserVisibleHint())) {
      this.oJm.bFI();
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    y.i("ContentFragment", this + " onResume " + getUserVisibleHint());
    this.euf = true;
    if ((this.oJm != null) && (getUserVisibleHint())) {
      this.oJm.bFg();
    }
    if (this.oJv != null) {
      this.oJv.onResume();
    }
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      if (this.oJm != null) {
        this.oJm.bFg();
      }
    }
    while (this.oJm == null) {
      return;
    }
    this.oJm.bFI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b
 * JD-Core Version:    0.7.0.1
 */