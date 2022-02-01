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
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.ui.ba;
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

public final class v
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
{
  private static final Map<String, Bitmap> KrX;
  AutoPlayViewPager KrY;
  a KrZ;
  ViewPagerControlView Ksa;
  private int Ksb;
  private al Ksc;
  private boolean autoCarousel;
  private int zrB;
  
  static
  {
    AppMethodBeat.i(96612);
    KrX = new WeakHashMap();
    AppMethodBeat.o(96612);
  }
  
  public v(Context paramContext, al paramal, ViewGroup paramViewGroup)
  {
    super(paramContext, paramal, paramViewGroup);
    AppMethodBeat.i(96602);
    this.Ksb = 1;
    this.zrB = 0;
    this.autoCarousel = false;
    this.Ksa = new ViewPagerControlView(paramContext);
    AppMethodBeat.o(96602);
  }
  
  private al a(al paramal)
  {
    AppMethodBeat.i(195552);
    this.Ksc = new al();
    if (paramal == null)
    {
      paramal = this.Ksc;
      AppMethodBeat.o(195552);
      return paramal;
    }
    this.Ksc.KmB = paramal.KmB;
    this.Ksc.KmC = paramal.KmC;
    this.Ksc.paddingTop = paramal.paddingTop;
    this.Ksc.paddingBottom = paramal.paddingBottom;
    this.Ksc.paddingLeft = paramal.paddingLeft;
    this.Ksc.paddingRight = paramal.paddingRight;
    this.Ksc.KmD = paramal.KmD;
    this.Ksc.KmE = paramal.KmE;
    this.Ksc.KmF = paramal.KmF;
    this.Ksc.subType = paramal.subType;
    this.Ksc.type = paramal.type;
    this.Ksc.KmG = paramal.KmG;
    this.Ksc.width = paramal.width;
    this.Ksc.height = paramal.height;
    this.Ksc.KmH = paramal.KmH;
    this.Ksc.KmI = paramal.KmI;
    this.Ksc.KmJ = paramal.KmJ;
    this.Ksc.KmK = paramal.KmK;
    this.Ksc.Kny = paramal.Kny;
    this.Ksc.AJP = paramal.AJP;
    this.Ksc.autoCarousel = paramal.autoCarousel;
    this.Ksc.Kmd.add(paramal.Kmd.getLast());
    this.Ksc.Kmd.addAll(paramal.Kmd);
    this.Ksc.Kmd.add(paramal.Kmd.getFirst());
    paramal = this.Ksc;
    AppMethodBeat.o(195552);
    return paramal;
  }
  
  public final void aK(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(96606);
    super.aK(paramMap);
    try
    {
      if (paramMap.containsKey("startIndex")) {
        this.Ksb = (((Integer)paramMap.get("startIndex")).intValue() + 1);
      }
      if (this.KrY != null)
      {
        this.KrY.setCurrentItem(this.Ksb, false);
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
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96610);
    if (!super.by(paramJSONObject))
    {
      AppMethodBeat.o(96610);
      return false;
    }
    AppMethodBeat.o(96610);
    return true;
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96608);
    int k = this.pEj - (int)((al)this.KqB).paddingLeft - (int)((al)this.KqB).paddingRight;
    int m = this.pEk;
    Object localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    a((al)this.KqB);
    final a locala;
    if (this.KrY.getAdapter() == null)
    {
      locala = new a(this.context, (LayoutInflater)localObject1, this.Ksc, this.backgroundColor, this.KrY);
      this.KrY.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          AppMethodBeat.i(215995);
          v.this.Ksa.w(paramAnonymousInt1, paramAnonymousFloat);
          AppMethodBeat.o(215995);
        }
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(96584);
          Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          v.a(v.this, paramAnonymousInt);
          if (v.this.KqC)
          {
            locala.agm(paramAnonymousInt);
            locala.agn(paramAnonymousInt);
          }
          AppMethodBeat.o(96584);
        }
      });
      this.KrY.setAdapter(locala);
      this.autoCarousel = ((al)this.KqB).autoCarousel;
      this.Ksa.bi(this.Ksc.Kmd.size(), this.autoCarousel);
      this.KrY.bindViewPagerControlView(this.Ksa, this.autoCarousel);
      if (!((al)this.KqB).AJP) {
        break label259;
      }
      this.KrY.setLayoutParams(new RelativeLayout.LayoutParams(k, m));
    }
    label259:
    while (((al)this.KqB).Kmd.size() <= 0)
    {
      this.KrZ = locala;
      locala.notifyDataSetChanged();
      AppMethodBeat.o(96608);
      return;
      locala = (a)this.KrY.getAdapter();
      locala.Ksf = a((al)this.KqB);
      break;
    }
    Object localObject2 = (s)((al)this.KqB).Kmd.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((s)localObject2).Kmd.iterator();
    label322:
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
        localObject4 = ((LayoutInflater)localObject1).inflate(i.g.sns_ad_native_landing_pages_item_text, null);
        ((View)localObject4).setBackgroundColor(this.backgroundColor);
        i = j;
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = (TextView)((View)localObject4).findViewById(i.f.sns_ad_landingpage_text_wordTitle);
        i = j;
        ((TextView)localObject4).setText(localah.Knk);
        i = j;
        if (localah.textSize > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setTextSize(0, localah.textSize);
        }
        i = j;
        if (localah.Kno > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setLineSpacing(0.0F, localah.Kno + 1.0F);
        }
        i = j;
        if (localah.Knl)
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
      break label322;
      Object localObject3;
      if ((localaa instanceof r))
      {
        localObject3 = (Button)((LayoutInflater)localObject1).inflate(i.g.sns_ad_native_landing_pages_item_btn, null).findViewById(i.f.sns_ad_native_landing_pages_item_btn_btn);
        ((Button)localObject3).setText(((r)localaa).title);
        ((Button)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = ((Button)localObject3).getPaddingTop() + j;
        if ((localaa.KmE > 0.0F) && ((int)localaa.KmE != 2147483647)) {
          i = (int)(i + localaa.KmE);
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
        if (((w)localObject3).Kmq == 1)
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
      else if ((localaa instanceof an))
      {
        localObject3 = (an)localaa;
        if (((an)localObject3).KnA == 1)
        {
          if ((int)((an)localObject3).width > 0)
          {
            i = (int)((an)localObject3).height * k / (int)((an)localObject3).width + j;
          }
          else
          {
            f1 = j;
            i = (int)(((an)localObject3).height + f1);
          }
        }
        else {
          i = j + m;
        }
      }
      else
      {
        if ((localaa instanceof am))
        {
          i = j + m;
          continue;
          localObject1 = new RelativeLayout.LayoutParams(k, i);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)((al)this.KqB).paddingLeft);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((al)this.KqB).paddingRight);
          this.KrY.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break;
        }
        i = j;
      }
    }
  }
  
  public final List<m> fKf()
  {
    AppMethodBeat.i(96611);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((a)this.KrY.getAdapter()).fKI());
    AppMethodBeat.o(96611);
    return localArrayList;
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96603);
    this.KrZ.agm(this.zrB);
    this.KrZ.agn(this.zrB);
    super.fKk();
    AppMethodBeat.o(96603);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96604);
    this.KrZ.agn(-1);
    super.fKl();
    if (this.KrY != null) {
      this.KrY.pauseAutoPlay();
    }
    AppMethodBeat.o(96604);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(195541);
    super.fKm();
    if (this.KrY != null) {
      this.KrY.startAutoPlay();
    }
    AppMethodBeat.o(195541);
  }
  
  public final void fKn()
  {
    AppMethodBeat.i(96605);
    this.KrZ.agn(this.zrB);
    AppMethodBeat.o(96605);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96609);
    View localView = this.contentView;
    this.KrY = ((AutoPlayViewPager)localView.findViewById(i.f.sns_ad_native_landing_pages_items_turnimages_viewpager));
    this.Ksa = ((ViewPagerControlView)localView.findViewById(i.f.sns_ad_native_lading_pages_turnimages_indicator));
    AppMethodBeat.o(96609);
  }
  
  public final void fRn()
  {
    AppMethodBeat.i(96607);
    super.fRn();
    this.KrY.setCurrentItem(this.Ksb, false);
    AppMethodBeat.o(96607);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_turnimages;
  }
  
  static final class a
    extends androidx.viewpager.widget.a
  {
    al Ksf;
    private int Ksg;
    private int Ksh;
    private int Ksi;
    HashMap<Integer, View> Ksj;
    HashMap<Integer, a> Ksk;
    Set<String> Ksl;
    int backgroundColor;
    Context mContext;
    LayoutInflater mLayoutInflater;
    int pEj;
    int pEk;
    private ViewPager uLQ;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, al paramal, int paramInt, ViewPager paramViewPager)
    {
      AppMethodBeat.i(270467);
      this.Ksg = 600;
      this.Ksh = 700;
      this.Ksi = 250;
      this.Ksj = new HashMap();
      this.Ksk = new HashMap();
      this.Ksl = new HashSet();
      this.mContext = paramContext;
      this.mLayoutInflater = paramLayoutInflater;
      this.Ksf = paramal;
      this.backgroundColor = paramInt;
      paramContext = ao.ib(paramContext);
      this.pEj = paramContext[0];
      this.pEk = paramContext[1];
      this.uLQ = paramViewPager;
      AppMethodBeat.o(270467);
    }
    
    private void l(final ImageView paramImageView)
    {
      AppMethodBeat.i(96597);
      paramImageView.setAlpha(0.0F);
      paramImageView.setTag("1");
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
      localAlphaAnimation.setDuration(this.Ksg);
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
              v.a.a(v.a.this, v.a.2.this.Ksm);
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
    
    public final void agm(int paramInt)
    {
      AppMethodBeat.i(96598);
      Object localObject = (View)this.Ksj.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        AppMethodBeat.o(96598);
        return;
      }
      localObject = (ImageView)((View)localObject).findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_right_icon);
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
        l((ImageView)localObject);
      }
      AppMethodBeat.o(96598);
    }
    
    public final void agn(int paramInt)
    {
      AppMethodBeat.i(96599);
      Iterator localIterator = this.Ksk.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        a locala = (a)this.Ksk.get(localObject);
        if ((locala != null) && (locala.Ksr.size() != 0))
        {
          if (((Integer)localObject).intValue() == paramInt)
          {
            i = 0;
            label79:
            if (i < locala.Ksr.size())
            {
              localObject = (m)locala.Ksr.get(i);
              if (!((m)localObject).fRj()) {
                break label148;
              }
              ((m)localObject).fKk();
              ((m)localObject).fKm();
              this.Ksl.add(((m)localObject).KqB.KmB);
            }
            for (;;)
            {
              i += 1;
              break label79;
              break;
              label148:
              if (this.Ksl.contains(((m)localObject).KqB.KmB))
              {
                ((m)localObject).fKl();
                this.Ksl.remove(((m)localObject).KqB.KmB);
              }
            }
          }
          int i = 0;
          while (i < locala.Ksr.size())
          {
            localObject = (m)locala.Ksr.get(i);
            if (this.Ksl.contains(((m)localObject).KqB.KmB))
            {
              ((m)localObject).fKl();
              this.Ksl.remove(((m)localObject).KqB.KmB);
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
      this.Ksj.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(96595);
    }
    
    public final List<m> fKI()
    {
      AppMethodBeat.i(96600);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.Ksk.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((a)localIterator.next()).Ksr);
      }
      AppMethodBeat.o(96600);
      return localArrayList;
    }
    
    public final void finishUpdate(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(270469);
      super.finishUpdate(paramViewGroup);
      int j = this.uLQ.getCurrentItem();
      int i;
      if (j == 0) {
        i = getCount() - 2;
      }
      for (;;)
      {
        this.uLQ.setCurrentItem(i, false);
        AppMethodBeat.o(270469);
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
      int i = this.Ksf.Kmd.size();
      AppMethodBeat.o(96592);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(96596);
      Iterator localIterator = this.Ksj.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (this.Ksj.get(Integer.valueOf(i)) == paramObject)
        {
          AppMethodBeat.o(96596);
          return i;
        }
      }
      AppMethodBeat.o(96596);
      return -2;
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(96594);
      Log.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", new Object[] { Integer.valueOf(paramInt) });
      if (this.Ksj.containsKey(Integer.valueOf(paramInt)))
      {
        paramViewGroup = this.Ksj.get(Integer.valueOf(paramInt));
        AppMethodBeat.o(96594);
        return paramViewGroup;
      }
      Log.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", new Object[] { Integer.valueOf(paramInt) });
      View localView = this.mLayoutInflater.inflate(i.g.sns_ad_native_landing_pages_item_trunpages, paramViewGroup, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_linaerlayout);
      localLinearLayout.setBackgroundColor(this.backgroundColor);
      Object localObject2 = (a)this.Ksk.get(Integer.valueOf(paramInt));
      LinkedList localLinkedList = ((s)this.Ksf.Kmd.get(paramInt)).Kmd;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((a)localObject2).Ksr.size() != 0) {}
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
            Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", new Object[] { ((aa)localObject2).KmB });
            localObject2 = ba.a(this.mContext, (aa)localObject2, localLinearLayout, this.backgroundColor);
            ((a)localObject1).Ksr.add(localObject2);
            i += 1;
          }
        }
        this.Ksk.put(Integer.valueOf(paramInt), localObject1);
      }
      Object localObject1 = ((a)localObject1).Ksr.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((m)((Iterator)localObject1).next()).getView();
        if ((((View)localObject2).getParent() != null) && ((((View)localObject2).getParent() instanceof ViewGroup))) {
          ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
        }
        localLinearLayout.addView((View)localObject2);
      }
      localObject1 = (ImageView)localView.findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_right_icon);
      localObject2 = (TextView)localView.findViewById(i.f.sns_ad_native_landing_pages_item_turnpages_page_tv);
      if (this.backgroundColor + 16777216 <= -1 - this.backgroundColor) {
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.e.page_icon_direction_right));
      }
      while (this.Ksf.Kny == 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        localView.setLayoutParams(new RelativeLayout.LayoutParams(this.pEj, localLinearLayout.getMeasuredHeight()));
        localView.setBackgroundColor(this.backgroundColor);
        paramViewGroup.addView(localView);
        paramViewGroup.setBackgroundColor(this.backgroundColor);
        this.Ksj.put(Integer.valueOf(paramInt), localView);
        AppMethodBeat.o(96594);
        return localView;
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.e.page_right_dark_xxhdpi));
      }
      label550:
      int j;
      if (paramInt == this.Ksf.Kmd.size() - 1)
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
      public LinkedList<m> Ksr;
      
      public a()
      {
        AppMethodBeat.i(96590);
        this.Ksr = new LinkedList();
        AppMethodBeat.o(96590);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */