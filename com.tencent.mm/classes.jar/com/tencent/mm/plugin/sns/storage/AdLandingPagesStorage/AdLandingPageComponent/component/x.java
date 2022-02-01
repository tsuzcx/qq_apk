package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.widget.ad.AutoPlayViewPager;
import com.tencent.mm.plugin.sns.ui.widget.ad.ViewPagerControlView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class x
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
{
  private static final Map<String, Bitmap> QQt;
  private int EuH;
  AutoPlayViewPager QQu;
  a QQv;
  ViewPagerControlView QQw;
  private int QQx;
  private am QQy;
  private boolean autoCarousel;
  
  static
  {
    AppMethodBeat.i(96612);
    QQt = new WeakHashMap();
    AppMethodBeat.o(96612);
  }
  
  public x(Context paramContext, am paramam, ViewGroup paramViewGroup)
  {
    super(paramContext, paramam, paramViewGroup);
    AppMethodBeat.i(96602);
    this.QQx = 1;
    this.EuH = 0;
    this.autoCarousel = false;
    this.QQw = new ViewPagerControlView(paramContext);
    AppMethodBeat.o(96602);
  }
  
  private am a(am paramam)
  {
    AppMethodBeat.i(307213);
    this.QQy = new am();
    if (paramam == null)
    {
      paramam = this.QQy;
      AppMethodBeat.o(307213);
      return paramam;
    }
    this.QQy.QKG = paramam.QKG;
    this.QQy.QKH = paramam.QKH;
    this.QQy.paddingTop = paramam.paddingTop;
    this.QQy.paddingBottom = paramam.paddingBottom;
    this.QQy.paddingLeft = paramam.paddingLeft;
    this.QQy.paddingRight = paramam.paddingRight;
    this.QQy.QKI = paramam.QKI;
    this.QQy.QKJ = paramam.QKJ;
    this.QQy.QKK = paramam.QKK;
    this.QQy.subType = paramam.subType;
    this.QQy.type = paramam.type;
    this.QQy.QKL = paramam.QKL;
    this.QQy.width = paramam.width;
    this.QQy.height = paramam.height;
    this.QQy.QKM = paramam.QKM;
    this.QQy.QKN = paramam.QKN;
    this.QQy.QKO = paramam.QKO;
    this.QQy.QKP = paramam.QKP;
    this.QQy.QLE = paramam.QLE;
    this.QQy.Flq = paramam.Flq;
    this.QQy.autoCarousel = paramam.autoCarousel;
    this.QQy.QKh.add((s)paramam.QKh.getLast());
    this.QQy.QKh.addAll(paramam.QKh);
    this.QQy.QKh.add((s)paramam.QKh.getFirst());
    paramam = this.QQy;
    AppMethodBeat.o(307213);
    return paramam;
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(96609);
    View localView = this.contentView;
    this.QQu = ((AutoPlayViewPager)localView.findViewById(b.f.sns_ad_native_landing_pages_items_turnimages_viewpager));
    this.QQw = ((ViewPagerControlView)localView.findViewById(b.f.sns_ad_native_lading_pages_turnimages_indicator));
    AppMethodBeat.o(96609);
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96610);
    if (!super.bP(paramJSONObject))
    {
      AppMethodBeat.o(96610);
      return false;
    }
    AppMethodBeat.o(96610);
    return true;
  }
  
  public final void bb(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(96606);
    super.bb(paramMap);
    try
    {
      if (paramMap.containsKey("startIndex")) {
        this.QQx = (((Integer)paramMap.get("startIndex")).intValue() + 1);
      }
      if (this.QQu != null)
      {
        this.QQu.setCurrentItem(this.QQx, false);
        AppMethodBeat.o(96606);
        return;
      }
      Log.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "when setOriginState, but viewPager is null");
      AppMethodBeat.o(96606);
      return;
    }
    catch (Exception paramMap)
    {
      Log.e("MicroMsg.Sns.AdLandingPageGroupListComponent", paramMap.toString());
      AppMethodBeat.o(96606);
    }
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_turnimages;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96608);
    int k = this.sJv - (int)((am)this.QOV).paddingLeft - (int)((am)this.QOV).paddingRight;
    int m = this.pvg;
    Object localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    a((am)this.QOV);
    final a locala;
    if (this.QQu.getAdapter() == null)
    {
      locala = new a(this.context, (LayoutInflater)localObject1, this.QQy, this.backgroundColor, this.QQu);
      this.QQu.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          AppMethodBeat.i(307059);
          x.this.QQw.z(paramAnonymousInt1, paramAnonymousFloat);
          AppMethodBeat.o(307059);
        }
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(96584);
          Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          x.a(x.this, paramAnonymousInt);
          if (x.this.QOW)
          {
            locala.ale(paramAnonymousInt);
            locala.alf(paramAnonymousInt);
          }
          AppMethodBeat.o(96584);
        }
      });
      this.QQu.setAdapter(locala);
      this.autoCarousel = ((am)this.QOV).autoCarousel;
      this.QQw.bQ(this.QQy.QKh.size(), this.autoCarousel);
      this.QQu.bindViewPagerControlView(this.QQw, this.autoCarousel);
      if (!((am)this.QOV).Flq) {
        break label260;
      }
      this.QQu.setLayoutParams(new RelativeLayout.LayoutParams(k, m));
    }
    label260:
    while (((am)this.QOV).QKh.size() <= 0)
    {
      this.QQv = locala;
      locala.notifyDataSetChanged();
      AppMethodBeat.o(96608);
      return;
      locala = (a)this.QQu.getAdapter();
      locala.QQB = a((am)this.QOV);
      break;
    }
    Object localObject2 = (s)((am)this.QOV).QKh.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((s)localObject2).QKh.iterator();
    label323:
    aa localaa;
    int j;
    ah localah;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localaa = (aa)((Iterator)localObject2).next();
      j = (int)(i + localaa.paddingTop);
      if ((localaa instanceof ah))
      {
        localah = (ah)localaa;
        localObject4 = ((LayoutInflater)localObject1).inflate(b.g.sns_ad_native_landing_pages_item_text, null);
        ((View)localObject4).setBackgroundColor(this.backgroundColor);
        i = j;
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = (TextView)((View)localObject4).findViewById(b.f.sns_ad_landingpage_text_wordTitle);
        i = j;
        ((TextView)localObject4).setText(localah.QLp);
        i = j;
        if (localah.textSize > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setTextSize(0, localah.textSize);
        }
        i = j;
        if (localah.QLt > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setLineSpacing(0.0F, localah.QLt + 1.0F);
        }
        i = j;
        if (localah.QLq)
        {
          i = j;
          ((TextView)localObject4).getPaint().setFakeBoldText(true);
        }
        i = j;
        ((TextView)localObject4).measure(View.MeasureSpec.makeMeasureSpec((int)(k - localah.paddingLeft - localah.paddingRight), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = j;
        j += ((TextView)localObject4).getPaddingTop();
        i = j;
        j += ((TextView)localObject4).getMeasuredHeight();
        i = j;
        int n = ((TextView)localObject4).getPaddingBottom();
        i = n + j;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "txtComp measure exp=" + localException.toString());
        continue;
      }
      float f1 = i;
      i = (int)(localaa.paddingBottom + f1);
      break label323;
      Object localObject3;
      if ((localaa instanceof r))
      {
        localObject3 = (Button)((LayoutInflater)localObject1).inflate(b.g.sns_ad_native_landing_pages_item_btn, null).findViewById(b.f.sns_ad_native_landing_pages_item_btn_btn);
        ((Button)localObject3).setText(((r)localaa).title);
        ((Button)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = ((Button)localObject3).getPaddingTop() + j;
        if ((localaa.QKJ > 0.0F) && ((int)localaa.QKJ != 2147483647)) {
          i = (int)(i + localaa.QKJ);
        }
        for (;;)
        {
          i = ((Button)localObject3).getPaddingBottom() + i;
          break;
          if ((localaa.height > 0.0F) && ((int)localaa.height != 2147483647)) {
            i = (int)(i + localaa.height);
          } else {
            i += ((Button)localObject3).getMeasuredHeight();
          }
        }
      }
      if ((localaa instanceof u))
      {
        float f2 = 0.0F;
        f1 = 0.0F;
        float f3 = localaa.paddingTop;
        float f4 = localaa.paddingBottom;
        if ((localaa instanceof u))
        {
          localObject3 = (u)localaa;
          f2 = ((u)localObject3).height;
          f1 = ((u)localObject3).width;
        }
        float f5;
        if (((int)f2 != 0) && ((int)f1 != 0)) {
          f5 = j;
        }
        for (i = (int)(f2 * k / f1 + f5);; i = j + m)
        {
          i = (int)((int)(i + f3) + f4);
          break;
        }
      }
      if ((localaa instanceof t))
      {
        i = j + m;
      }
      else if ((localaa instanceof w))
      {
        localObject3 = (w)localaa;
        if (((w)localObject3).QKu == 1)
        {
          i = j + m;
        }
        else if ((int)((w)localObject3).width > 0)
        {
          i = (int)((w)localObject3).height * k / (int)((w)localObject3).width + j;
        }
        else
        {
          f1 = j;
          i = (int)(((w)localObject3).height + f1);
        }
      }
      else if ((localaa instanceof ap))
      {
        localObject3 = (ap)localaa;
        if (((ap)localObject3).QLH == 1)
        {
          if ((int)((ap)localObject3).width > 0)
          {
            i = (int)((ap)localObject3).height * k / (int)((ap)localObject3).width + j;
          }
          else
          {
            f1 = j;
            i = (int)(((ap)localObject3).height + f1);
          }
        }
        else {
          i = j + m;
        }
      }
      else
      {
        if ((localaa instanceof an))
        {
          i = j + m;
          continue;
          localObject1 = new RelativeLayout.LayoutParams(k, i);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)((am)this.QOV).paddingLeft);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((am)this.QOV).paddingRight);
          this.QQu.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break;
        }
        i = j;
      }
    }
  }
  
  public final List<n> hai()
  {
    AppMethodBeat.i(96611);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((a)this.QQu.getAdapter()).haX());
    AppMethodBeat.o(96611);
    return localArrayList;
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96603);
    this.QQv.ale(this.EuH);
    this.QQv.alf(this.EuH);
    super.hao();
    AppMethodBeat.o(96603);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96604);
    this.QQv.alf(-1);
    super.hap();
    if (this.QQu != null) {
      this.QQu.pauseAutoPlay();
    }
    AppMethodBeat.o(96604);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(307226);
    super.haq();
    if (this.QQu != null) {
      this.QQu.startAutoPlay();
    }
    AppMethodBeat.o(307226);
  }
  
  public final void har()
  {
    AppMethodBeat.i(96605);
    this.QQv.alf(this.EuH);
    AppMethodBeat.o(96605);
  }
  
  public final void hjl()
  {
    AppMethodBeat.i(96607);
    super.hjl();
    this.QQu.setCurrentItem(this.QQx, false);
    AppMethodBeat.o(96607);
  }
  
  static final class a
    extends androidx.viewpager.widget.a
  {
    am QQB;
    private int QQC;
    private int QQD;
    private int QQE;
    HashMap<Integer, View> QQF;
    HashMap<Integer, a> QQG;
    Set<String> QQH;
    int backgroundColor;
    Context mContext;
    LayoutInflater mLayoutInflater;
    int pvg;
    int sJv;
    private ViewPager xUr;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, am paramam, int paramInt, ViewPager paramViewPager)
    {
      AppMethodBeat.i(306980);
      this.QQC = 600;
      this.QQD = 700;
      this.QQE = 250;
      this.QQF = new HashMap();
      this.QQG = new HashMap();
      this.QQH = new HashSet();
      this.mContext = paramContext;
      this.mLayoutInflater = paramLayoutInflater;
      this.QQB = paramam;
      this.backgroundColor = paramInt;
      paramContext = ar.jR(paramContext);
      this.sJv = paramContext[0];
      this.pvg = paramContext[1];
      this.xUr = paramViewPager;
      AppMethodBeat.o(306980);
    }
    
    private void u(final ImageView paramImageView)
    {
      AppMethodBeat.i(96597);
      paramImageView.setAlpha(0.0F);
      paramImageView.setTag("1");
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
      localAlphaAnimation.setDuration(this.QQC);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(96589);
          paramImageView.setAlpha(0.8F);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96588);
              x.a.a(x.a.this, x.a.2.this.QQI);
              AppMethodBeat.o(96588);
            }
          }, 200L);
          AppMethodBeat.o(96589);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      paramImageView.startAnimation(localAlphaAnimation);
      AppMethodBeat.o(96597);
    }
    
    public final void ale(int paramInt)
    {
      AppMethodBeat.i(96598);
      Object localObject = (View)this.QQF.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        AppMethodBeat.o(96598);
        return;
      }
      localObject = (ImageView)((View)localObject).findViewById(b.f.sns_ad_native_landing_pages_item_turnpages_right_icon);
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
        u((ImageView)localObject);
      }
      AppMethodBeat.o(96598);
    }
    
    public final void alf(int paramInt)
    {
      AppMethodBeat.i(96599);
      Iterator localIterator = this.QQG.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        a locala = (a)this.QQG.get(localObject);
        if ((locala != null) && (locala.QQN.size() != 0))
        {
          if (((Integer)localObject).intValue() == paramInt)
          {
            i = 0;
            label79:
            if (i < locala.QQN.size())
            {
              localObject = (n)locala.QQN.get(i);
              if (!((n)localObject).hji()) {
                break label148;
              }
              ((n)localObject).hao();
              ((n)localObject).haq();
              this.QQH.add(((n)localObject).QOV.QKG);
            }
            for (;;)
            {
              i += 1;
              break label79;
              break;
              label148:
              if (this.QQH.contains(((n)localObject).QOV.QKG))
              {
                ((n)localObject).hap();
                this.QQH.remove(((n)localObject).QOV.QKG);
              }
            }
          }
          int i = 0;
          while (i < locala.QQN.size())
          {
            localObject = (n)locala.QQN.get(i);
            if (this.QQH.contains(((n)localObject).QOV.QKG))
            {
              ((n)localObject).hap();
              this.QQH.remove(((n)localObject).QOV.QKG);
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(96599);
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(96595);
      paramViewGroup.removeView((View)paramObject);
      this.QQF.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(96595);
    }
    
    public final void finishUpdate(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(307057);
      super.finishUpdate(paramViewGroup);
      int j = this.xUr.getCurrentItem();
      int i;
      if (j == 0) {
        i = getCount() - 2;
      }
      for (;;)
      {
        this.xUr.setCurrentItem(i, false);
        AppMethodBeat.o(307057);
        return;
        i = j;
        if (j >= getCount() - 1) {
          i = 1;
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(96592);
      int i = this.QQB.QKh.size();
      AppMethodBeat.o(96592);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(96596);
      Iterator localIterator = this.QQF.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (this.QQF.get(Integer.valueOf(i)) == paramObject)
        {
          AppMethodBeat.o(96596);
          return i;
        }
      }
      AppMethodBeat.o(96596);
      return -2;
    }
    
    public final List<n> haX()
    {
      AppMethodBeat.i(96600);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.QQG.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((a)localIterator.next()).QQN);
      }
      AppMethodBeat.o(96600);
      return localArrayList;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(96594);
      Log.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", new Object[] { Integer.valueOf(paramInt) });
      if (this.QQF.containsKey(Integer.valueOf(paramInt)))
      {
        paramViewGroup = this.QQF.get(Integer.valueOf(paramInt));
        AppMethodBeat.o(96594);
        return paramViewGroup;
      }
      Log.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", new Object[] { Integer.valueOf(paramInt) });
      View localView = this.mLayoutInflater.inflate(b.g.sns_ad_native_landing_pages_item_trunpages, paramViewGroup, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(b.f.sns_ad_native_landing_pages_item_turnpages_linaerlayout);
      localLinearLayout.setBackgroundColor(this.backgroundColor);
      Object localObject2 = (a)this.QQG.get(Integer.valueOf(paramInt));
      LinkedList localLinkedList = ((s)this.QQB.QKh.get(paramInt)).QKh;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((a)localObject2).QQN.size() != 0) {}
      }
      else
      {
        localObject1 = new a();
        if (localLinkedList != null)
        {
          i = 0;
          while (i < localLinkedList.size())
          {
            localObject2 = (aa)localLinkedList.get(i);
            Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", new Object[] { ((aa)localObject2).QKG });
            localObject2 = bb.a(this.mContext, (aa)localObject2, localLinearLayout, this.backgroundColor);
            ((a)localObject1).QQN.add(localObject2);
            i += 1;
          }
        }
        this.QQG.put(Integer.valueOf(paramInt), localObject1);
      }
      Object localObject1 = ((a)localObject1).QQN.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((n)((Iterator)localObject1).next()).getView();
        if ((((View)localObject2).getParent() != null) && ((((View)localObject2).getParent() instanceof ViewGroup))) {
          ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
        }
        localLinearLayout.addView((View)localObject2);
      }
      localObject1 = (ImageView)localView.findViewById(b.f.sns_ad_native_landing_pages_item_turnpages_right_icon);
      localObject2 = (TextView)localView.findViewById(b.f.sns_ad_native_landing_pages_item_turnpages_page_tv);
      if (this.backgroundColor + 16777216 <= -1 - this.backgroundColor) {
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.e.page_icon_direction_right));
      }
      while (this.QQB.QLE == 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        localView.setLayoutParams(new RelativeLayout.LayoutParams(this.sJv, localLinearLayout.getMeasuredHeight()));
        localView.setBackgroundColor(this.backgroundColor);
        paramViewGroup.addView(localView);
        paramViewGroup.setBackgroundColor(this.backgroundColor);
        this.QQF.put(Integer.valueOf(paramInt), localView);
        AppMethodBeat.o(96594);
        return localView;
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cd.a.m(this.mContext, b.e.page_right_dark_xxhdpi));
      }
      label550:
      int j;
      if (paramInt == this.QQB.QKh.size() - 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        j = getCount() - 2;
        if (paramInt != 0) {
          break label614;
        }
        ((ImageView)localObject1).setVisibility(8);
        i = j;
      }
      for (;;)
      {
        ((TextView)localObject2).setText(i + "/" + j);
        break;
        ((ImageView)localObject1).setVisibility(0);
        break label550;
        label614:
        if (paramInt >= getCount() - 1)
        {
          ((ImageView)localObject1).setVisibility(0);
          i = 1;
        }
        else
        {
          if (paramInt == j) {
            ((ImageView)localObject1).setVisibility(8);
          }
          i = paramInt;
        }
      }
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == (View)paramObject;
    }
    
    public final void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(96593);
      super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
      AppMethodBeat.o(96593);
    }
    
    public final class a
    {
      public LinkedList<n> QQN;
      
      public a()
      {
        AppMethodBeat.i(96590);
        this.QQN = new LinkedList();
        AppMethodBeat.o(96590);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */