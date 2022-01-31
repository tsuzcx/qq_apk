package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public class ContentFragment
  extends Fragment
{
  public boolean bSe;
  private int bgColor;
  private boolean gpz;
  private int guQ;
  private int iiW;
  private int iiX;
  public Map<String, Object> pJb;
  private LinearLayoutManager ruC;
  private final Map<String, Bitmap> rwi;
  public g rzb;
  private int rzd;
  public c rzf;
  private int rzg;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae rzh;
  private boolean rzi;
  private boolean rzj;
  private boolean rzk;
  public boolean rzl;
  private boolean rzm;
  private ValueAnimator rzn;
  private int rzo;
  public int rzp;
  private al rzq;
  public ContentFragment.a rzr;
  public ContentFragment.b rzs;
  private a rzt;
  private boolean rzu;
  protected final String rzv;
  protected boolean rzw;
  protected boolean rzx;
  private BroadcastReceiver rzy;
  protected View.OnClickListener rzz;
  
  public ContentFragment()
  {
    AppMethodBeat.i(37626);
    this.rwi = new WeakHashMap();
    this.rzg = 700;
    this.rzm = false;
    this.rzv = "ContentFragmentSphereImageView";
    this.rzw = false;
    this.rzx = false;
    this.rzy = new ContentFragment.8(this);
    this.rzz = new ContentFragment.9(this);
    AppMethodBeat.o(37626);
  }
  
  private void Vf()
  {
    AppMethodBeat.i(37636);
    if (this.rzs == null)
    {
      AppMethodBeat.o(37636);
      return;
    }
    crI();
    String str;
    if ((this.rzb.rCe != null) && (this.rzb.rCe.length() > 0))
    {
      str = this.rzb.rCe;
      ab.i("ContentFragment", "bg need blur %b, url %s", new Object[] { Boolean.valueOf(this.rzb.rCf), str });
      if (this.rwi.containsKey(str))
      {
        ab.i("ContentFragment", "bg has cache bitmap");
        X((Bitmap)this.rwi.get(str));
        if (this.rzt != null) {
          if ((this.rzb.rCe == null) || (this.rzb.rCe.length() <= 0)) {
            break label201;
          }
        }
      }
    }
    label201:
    for (this.rzt.bgColor = 0;; this.rzt.bgColor = this.bgColor)
    {
      this.rzt.a(this.rzb);
      AppMethodBeat.o(37636);
      return;
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.c("adId", str, false, 1000000001, new ContentFragment.2(this, str));
      break;
      crI();
      break;
    }
  }
  
  private void X(Bitmap paramBitmap)
  {
    AppMethodBeat.i(37638);
    if (paramBitmap != null)
    {
      this.rzs.kgr.setBackgroundColor(0);
      this.rzs.rzF.setBackgroundColor(0);
      this.rzs.jja.setBackgroundColor(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rzs.rzF.getLayoutParams();
      if (localLayoutParams.height >= this.iiX) {}
      for (int i = localLayoutParams.height;; i = this.iiX)
      {
        localLayoutParams.height = i;
        this.rzs.rzF.setLayoutParams(localLayoutParams);
        this.rzs.rzF.setImageBitmap(paramBitmap);
        AppMethodBeat.o(37638);
        return;
      }
    }
    crI();
    AppMethodBeat.o(37638);
  }
  
  private void b(g paramg)
  {
    AppMethodBeat.i(145331);
    this.rzw = false;
    this.rzx = false;
    if ((paramg != null) && (paramg.rCg != null))
    {
      paramg = paramg.rCg.iterator();
      while (paramg.hasNext())
      {
        t localt = (t)paramg.next();
        if ((localt instanceof p))
        {
          paramg = (p)localt;
          if ((paramg.rsv) || (paramg.width == 0.0F) || (paramg.height == 0.0F)) {
            this.rzx = true;
          }
          this.rzw = true;
        }
      }
    }
    ab.i("ContentFragmentSphereImageView", "checkSphereImageComp, isSphereImageViewCompPage=" + this.rzw + ", isFullScreen=" + this.rzx);
    AppMethodBeat.o(145331);
  }
  
  private void crI()
  {
    AppMethodBeat.i(37637);
    if ((this.rzb.hhh != null) && (this.rzb.hhh.length() > 0)) {
      ab.i("ContentFragment", "setting bg color %s", new Object[] { this.rzb.hhh });
    }
    try
    {
      this.bgColor = Color.parseColor(this.rzb.hhh);
      this.rzs.kgr.setBackgroundColor(this.bgColor);
      this.rzs.rzF.setBackgroundColor(this.bgColor);
      this.rzs.jja.setBackgroundColor(this.bgColor);
      AppMethodBeat.o(37637);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("ContentFragment", "the color is error : " + this.rzb.hhh);
      }
    }
  }
  
  private boolean crL()
  {
    boolean bool2 = true;
    AppMethodBeat.i(37642);
    if (!this.rzk)
    {
      AppMethodBeat.o(37642);
      return false;
    }
    if (this.rzo != 0)
    {
      AppMethodBeat.o(37642);
      return false;
    }
    if (this.rzp != 0)
    {
      AppMethodBeat.o(37642);
      return false;
    }
    if (this.rzw)
    {
      AppMethodBeat.o(37642);
      return false;
    }
    int i = this.ruC.it();
    if ((i == this.ruC.iv()) && (i == -1))
    {
      AppMethodBeat.o(37642);
      return false;
    }
    boolean bool1 = bool2;
    if (this.gpz) {
      if (this.ruC.iv() == this.rzt.getItemCount() - 1) {
        break label138;
      }
    }
    label138:
    for (bool1 = bool2;; bool1 = false)
    {
      AppMethodBeat.o(37642);
      return bool1;
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(37635);
    if (this.rzb != paramg)
    {
      this.rzb = paramg;
      b(paramg);
      Vf();
    }
    AppMethodBeat.o(37635);
  }
  
  public final Collection<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h> crG()
  {
    AppMethodBeat.i(37639);
    if (this.rzt == null)
    {
      localObject = Collections.EMPTY_LIST;
      AppMethodBeat.o(37639);
      return localObject;
    }
    Object localObject = this.rzt.crG();
    AppMethodBeat.o(37639);
    return localObject;
  }
  
  public final void crH()
  {
    AppMethodBeat.i(37633);
    if ((this.bSe) && (this.rzf != null)) {
      this.rzf.crD();
    }
    AppMethodBeat.o(37633);
  }
  
  public final void crJ()
  {
    AppMethodBeat.i(37640);
    if ((!crL()) || (this.rzm) || (this.rzs.rzI))
    {
      AppMethodBeat.o(37640);
      return;
    }
    this.rzs.rzG.setVisibility(0);
    this.rzs.rzG.setTranslationY(-com.tencent.mm.cb.a.fromDPToPix(getContext(), 5));
    this.rzn.setRepeatMode(2);
    this.rzn.setRepeatCount(-1);
    this.rzn.start();
    AppMethodBeat.o(37640);
  }
  
  public final void crK()
  {
    AppMethodBeat.i(37641);
    this.rzs.rzG.setVisibility(4);
    this.rzs.rzG.setTranslationY(-com.tencent.mm.cb.a.fromDPToPix(getContext(), 5));
    this.rzn.setRepeatMode(2);
    this.rzn.setRepeatCount(0);
    this.rzn.end();
    AppMethodBeat.o(37641);
  }
  
  public final void lt(boolean paramBoolean)
  {
    AppMethodBeat.i(145330);
    this.rzm = paramBoolean;
    if ((crL()) && (!paramBoolean))
    {
      crJ();
      AppMethodBeat.o(145330);
      return;
    }
    crK();
    AppMethodBeat.o(145330);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37627);
    super.onCreate(paramBundle);
    paramBundle = this.pJb;
    int[] arrayOfInt = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ae.eU(getContext());
    this.iiW = arrayOfInt[0];
    this.iiX = arrayOfInt[1];
    if (this.rzb == null)
    {
      this.rzb = ((g)paramBundle.get("pageInfo"));
      b(this.rzb);
    }
    this.rzh = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)paramBundle.get("pageDownIconInfo"));
    this.rzi = bo.e((Boolean)paramBundle.get("is_first_show_page"));
    this.gpz = bo.e((Boolean)paramBundle.get("is_last_shown_page"));
    this.rzj = bo.e((Boolean)paramBundle.get("needEnterAnimation"));
    this.rzk = bo.e((Boolean)paramBundle.get("needDirectionAnimation"));
    this.rzd = bo.f(paramBundle.get("groupListCompShowIndex"), 0);
    AppMethodBeat.o(37627);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(37628);
    paramLayoutInflater = paramLayoutInflater.inflate(2130968631, paramViewGroup, false);
    this.rzs = new ContentFragment.b((byte)0);
    this.rzs.kgr = paramLayoutInflater;
    this.rzs.rzF = ((ImageView)paramLayoutInflater.findViewById(2131821038));
    this.rzs.jja = ((LinearLayout)paramLayoutInflater.findViewById(2131821039));
    this.rzs.rzG = ((ImageView)paramLayoutInflater.findViewById(2131821041));
    this.rzs.rzH = paramLayoutInflater.findViewById(2131821042);
    this.rzs.rzH.setOnClickListener(this.rzz);
    this.rzs.iQe = ((RecyclerView)paramLayoutInflater.findViewById(2131821040));
    this.rzs.rzJ = ((LinearLayout)paramLayoutInflater.findViewById(2131821037));
    paramViewGroup = this.rzs.iQe;
    paramViewGroup.setOverScrollMode(2);
    paramViewGroup.setOnTouchListener(new b((DummyViewPager)this.pJb.get("viewPager")));
    getActivity();
    this.ruC = new LinearLayoutManager();
    paramViewGroup.setLayoutManager(this.ruC);
    this.rzt = new a(this.rzb, this.bgColor, getActivity(), this.ruC);
    if (this.rzi) {
      this.rzt.rzd = this.rzd;
    }
    paramViewGroup.setAdapter(this.rzt);
    paramViewGroup.setDescendantFocusability(131072);
    this.rzf = new c(paramViewGroup);
    paramViewGroup.a(new ContentFragment.1(this));
    paramLayoutInflater.setTag(this.rzs);
    Vf();
    this.rzn = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    this.rzn.setDuration(this.rzg);
    this.rzn.addUpdateListener(new ContentFragment.4(this));
    this.rzn.addListener(new ContentFragment.5(this));
    this.rzn.setRepeatCount(-1);
    this.rzn.setRepeatMode(2);
    if ((this.rzh != null) && (!this.rzh.equals(this.rzs.rzG.getTag())))
    {
      this.rzs.rzG.setTag(this.rzh);
      this.rzs.rzG.setVisibility(8);
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(this.rzh.iconUrl, 1000000001, new ContentFragment.6(this));
    }
    if (this.rzr != null) {
      this.rzr.n(this);
    }
    AppMethodBeat.o(37628);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37631);
    super.onDestroy();
    if (this.rzf != null) {
      this.rzf.ryK.onDestroy();
    }
    crK();
    AppMethodBeat.o(37631);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37630);
    super.onPause();
    ab.i("ContentFragment", this + " onPause " + getUserVisibleHint());
    this.bSe = false;
    this.rzf.bSe = this.bSe;
    if ((this.rzf != null) && (getUserVisibleHint())) {
      this.rzf.crE();
    }
    if (this.rzw) {
      try
      {
        ab.d("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, hash=" + hashCode());
        d.R(getContext()).unregisterReceiver(this.rzy);
        AppMethodBeat.o(37630);
        return;
      }
      catch (Exception localException)
      {
        ab.e("ContentFragmentSphereImageView", "unRegisterSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(37630);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37629);
    super.onResume();
    ab.i("ContentFragment", this + " onResume " + getUserVisibleHint());
    this.bSe = true;
    Object localObject;
    if ((this.rzs != null) && (this.rzs.kgr != null))
    {
      localObject = (ViewGroup)this.rzs.kgr.getParent();
      if ((localObject != null) && (((ViewGroup)localObject).getParent() != null) && (((ViewGroup)localObject).getParent().getParent() != null))
      {
        ViewGroup localViewGroup = (ViewGroup)((ViewGroup)localObject).getParent().getParent();
        if (localViewGroup.indexOfChild((View)((ViewGroup)localObject).getParent()) < localViewGroup.getChildCount() - 2) {
          this.bSe = false;
        }
      }
    }
    this.rzf.bSe = this.bSe;
    if ((this.rzf != null) && (getUserVisibleHint())) {
      this.rzf.cqL();
    }
    if (this.rzw) {
      try
      {
        ab.d("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, hash=" + hashCode());
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_show");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_none");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_alpha_half");
        ((IntentFilter)localObject).addAction("com.tencent.mm.adlanding.sphereimage.next_page_view_hide");
        d.R(getContext()).a(this.rzy, (IntentFilter)localObject);
        AppMethodBeat.o(37629);
        return;
      }
      catch (Exception localException)
      {
        ab.e("ContentFragmentSphereImageView", "registerSphereImageCompEventReceiver, exp:" + localException.toString());
      }
    }
    AppMethodBeat.o(37629);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(37632);
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean)
    {
      if (this.rzf != null)
      {
        this.rzf.cqL();
        AppMethodBeat.o(37632);
      }
    }
    else if (this.rzf != null) {
      this.rzf.crE();
    }
    AppMethodBeat.o(37632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment
 * JD-Core Version:    0.7.0.1
 */