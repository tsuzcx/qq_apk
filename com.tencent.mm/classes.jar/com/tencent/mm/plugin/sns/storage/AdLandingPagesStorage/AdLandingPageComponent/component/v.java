package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.ay;
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
  private static final Map<String, Bitmap> Eer;
  AutoPlayViewPager Ees;
  a Eet;
  ViewPagerControlView Eeu;
  private int Eev;
  private ak Eew;
  private boolean autoCarousel;
  private int zaD;
  
  static
  {
    AppMethodBeat.i(96612);
    Eer = new WeakHashMap();
    AppMethodBeat.o(96612);
  }
  
  public v(Context paramContext, ak paramak, ViewGroup paramViewGroup)
  {
    super(paramContext, paramak, paramViewGroup);
    AppMethodBeat.i(96602);
    this.Eev = 1;
    this.zaD = 0;
    this.autoCarousel = false;
    this.Eeu = new ViewPagerControlView(paramContext);
    AppMethodBeat.o(96602);
  }
  
  private ak a(ak paramak)
  {
    AppMethodBeat.i(202985);
    this.Eew = new ak();
    if (paramak == null)
    {
      paramak = this.Eew;
      AppMethodBeat.o(202985);
      return paramak;
    }
    this.Eew.DZi = paramak.DZi;
    this.Eew.DZj = paramak.DZj;
    this.Eew.paddingTop = paramak.paddingTop;
    this.Eew.paddingBottom = paramak.paddingBottom;
    this.Eew.paddingLeft = paramak.paddingLeft;
    this.Eew.paddingRight = paramak.paddingRight;
    this.Eew.DZk = paramak.DZk;
    this.Eew.DZl = paramak.DZl;
    this.Eew.DZm = paramak.DZm;
    this.Eew.subType = paramak.subType;
    this.Eew.type = paramak.type;
    this.Eew.DZn = paramak.DZn;
    this.Eew.width = paramak.width;
    this.Eew.height = paramak.height;
    this.Eew.DZo = paramak.DZo;
    this.Eew.DZp = paramak.DZp;
    this.Eew.DZq = paramak.DZq;
    this.Eew.DZr = paramak.DZr;
    this.Eew.Eac = paramak.Eac;
    this.Eew.onr = paramak.onr;
    this.Eew.autoCarousel = paramak.autoCarousel;
    this.Eew.DYI.add(paramak.DYI.getLast());
    this.Eew.DYI.addAll(paramak.DYI);
    this.Eew.DYI.add(paramak.DYI.getFirst());
    paramak = this.Eew;
    AppMethodBeat.o(202985);
    return paramak;
  }
  
  public final void aQ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(96606);
    super.aQ(paramMap);
    try
    {
      if (paramMap.containsKey("startIndex")) {
        this.Eev = (((Integer)paramMap.get("startIndex")).intValue() + 1);
      }
      if (this.Ees != null)
      {
        this.Ees.setCurrentItem(this.Eev, false);
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
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96610);
    if (!super.bp(paramJSONObject))
    {
      AppMethodBeat.o(96610);
      return false;
    }
    AppMethodBeat.o(96610);
    return true;
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96608);
    int k = this.mEX - (int)((ak)this.EcX).paddingLeft - (int)((ak)this.EcX).paddingRight;
    int m = this.mEY;
    Object localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    a((ak)this.EcX);
    final a locala;
    if (this.Ees.getAdapter() == null)
    {
      locala = new a(this.context, (LayoutInflater)localObject1, this.Eew, this.backgroundColor, this.Ees);
      this.Ees.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
        {
          AppMethodBeat.i(202981);
          v.this.Eeu.v(paramAnonymousInt1, paramAnonymousFloat);
          AppMethodBeat.o(202981);
        }
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(96584);
          Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          v.a(v.this, paramAnonymousInt);
          if (v.this.EcZ)
          {
            locala.YV(paramAnonymousInt);
            locala.YW(paramAnonymousInt);
          }
          AppMethodBeat.o(96584);
        }
      });
      this.Ees.setAdapter(locala);
      this.autoCarousel = ((ak)this.EcX).autoCarousel;
      this.Eeu.aX(this.Eew.DYI.size(), this.autoCarousel);
      this.Ees.bindViewPagerControlView(this.Eeu, this.autoCarousel);
      if (!((ak)this.EcX).onr) {
        break label259;
      }
      this.Ees.setLayoutParams(new RelativeLayout.LayoutParams(k, m));
    }
    label259:
    while (((ak)this.EcX).DYI.size() <= 0)
    {
      this.Eet = locala;
      locala.notifyDataSetChanged();
      AppMethodBeat.o(96608);
      return;
      locala = (a)this.Ees.getAdapter();
      locala.Eez = a((ak)this.EcX);
      break;
    }
    Object localObject2 = (r)((ak)this.EcX).DYI.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((r)localObject2).DYI.iterator();
    label322:
    z localz;
    int j;
    ag localag;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localz = (z)((Iterator)localObject2).next();
      j = (int)(i + localz.paddingTop);
      if ((localz instanceof ag))
      {
        localag = (ag)localz;
        localObject4 = ((LayoutInflater)localObject1).inflate(2131496396, null);
        ((View)localObject4).setBackgroundColor(this.backgroundColor);
        i = j;
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = (TextView)((View)localObject4).findViewById(2131308034);
        i = j;
        ((TextView)localObject4).setText(localag.DZP);
        i = j;
        if (localag.textSize > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setTextSize(0, localag.textSize);
        }
        i = j;
        if (localag.DZT > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setLineSpacing(0.0F, localag.DZT + 1.0F);
        }
        i = j;
        if (localag.DZQ)
        {
          i = j;
          ((TextView)localObject4).getPaint().setFakeBoldText(true);
        }
        i = j;
        ((TextView)localObject4).measure(View.MeasureSpec.makeMeasureSpec((int)(k - localag.paddingLeft - localag.paddingRight), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
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
      i = (int)(localz.paddingBottom + f1);
      break label322;
      Object localObject3;
      if ((localz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q))
      {
        localObject3 = (Button)((LayoutInflater)localObject1).inflate(2131496381, null).findViewById(2131308038);
        ((Button)localObject3).setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localz).title);
        ((Button)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = ((Button)localObject3).getPaddingTop() + j;
        if ((localz.DZl > 0.0F) && ((int)localz.DZl != 2147483647)) {
          i = (int)(i + localz.DZl);
        }
        for (;;)
        {
          i = ((Button)localObject3).getPaddingBottom() + i;
          break;
          if ((localz.height > 0.0F) && ((int)localz.height != 2147483647)) {
            i = (int)(i + localz.height);
          } else {
            i += ((Button)localObject3).getMeasuredHeight();
          }
        }
      }
      if ((localz instanceof t))
      {
        float f2 = 0.0F;
        f1 = 0.0F;
        float f3 = localz.paddingTop;
        float f4 = localz.paddingBottom;
        if ((localz instanceof t))
        {
          localObject3 = (t)localz;
          f2 = ((t)localObject3).height;
          f1 = ((t)localObject3).width;
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
      if ((localz instanceof s))
      {
        i = j + m;
      }
      else if ((localz instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v))
      {
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localz;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).DYW == 1)
        {
          i = j + m;
        }
        else if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).width > 0)
        {
          i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).height * k / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).width + j;
        }
        else
        {
          f1 = j;
          i = (int)(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v)localObject3).height + f1);
        }
      }
      else if ((localz instanceof am))
      {
        localObject3 = (am)localz;
        if (((am)localObject3).Eae == 1)
        {
          if ((int)((am)localObject3).width > 0)
          {
            i = (int)((am)localObject3).height * k / (int)((am)localObject3).width + j;
          }
          else
          {
            f1 = j;
            i = (int)(((am)localObject3).height + f1);
          }
        }
        else {
          i = j + m;
        }
      }
      else
      {
        if ((localz instanceof al))
        {
          i = j + m;
          continue;
          localObject1 = new RelativeLayout.LayoutParams(k, i);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)((ak)this.EcX).paddingLeft);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((ak)this.EcX).paddingRight);
          this.Ees.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break;
        }
        i = j;
      }
    }
  }
  
  public final List<m> eWU()
  {
    AppMethodBeat.i(96611);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((a)this.Ees.getAdapter()).eXi());
    AppMethodBeat.o(96611);
    return localArrayList;
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96603);
    this.Eet.YV(this.zaD);
    this.Eet.YW(this.zaD);
    super.eWZ();
    AppMethodBeat.o(96603);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96604);
    this.Eet.YW(-1);
    super.eXa();
    if (this.Ees != null) {
      this.Ees.pauseAutoPlay();
    }
    AppMethodBeat.o(96604);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(202984);
    super.eXb();
    if (this.Ees != null) {
      this.Ees.startAutoPlay();
    }
    AppMethodBeat.o(202984);
  }
  
  public final void eXc()
  {
    AppMethodBeat.i(96605);
    this.Eet.YW(this.zaD);
    AppMethodBeat.o(96605);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96609);
    View localView = this.contentView;
    this.Ees = ((AutoPlayViewPager)localView.findViewById(2131308053));
    this.Eeu = ((ViewPagerControlView)localView.findViewById(2131308035));
    AppMethodBeat.o(96609);
  }
  
  public final void fdq()
  {
    AppMethodBeat.i(96607);
    super.fdq();
    this.Ees.setCurrentItem(this.Eev, false);
    AppMethodBeat.o(96607);
  }
  
  protected final int getLayout()
  {
    return 2131496398;
  }
  
  static final class a
    extends android.support.v4.view.q
  {
    private int EeA;
    int EeB;
    int EeC;
    HashMap<Integer, View> EeD;
    HashMap<Integer, a> EeE;
    Set<String> EeF;
    ak Eez;
    int backgroundColor;
    Context mContext;
    int mEX;
    int mEY;
    LayoutInflater mLayoutInflater;
    private ViewPager riH;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, ak paramak, int paramInt, ViewPager paramViewPager)
    {
      AppMethodBeat.i(202982);
      this.EeA = 600;
      this.EeB = 700;
      this.EeC = 250;
      this.EeD = new HashMap();
      this.EeE = new HashMap();
      this.EeF = new HashSet();
      this.mContext = paramContext;
      this.mLayoutInflater = paramLayoutInflater;
      this.Eez = paramak;
      this.backgroundColor = paramInt;
      paramContext = ap.ha(paramContext);
      this.mEX = paramContext[0];
      this.mEY = paramContext[1];
      this.riH = paramViewPager;
      AppMethodBeat.o(202982);
    }
    
    private void k(final ImageView paramImageView)
    {
      AppMethodBeat.i(96597);
      paramImageView.setAlpha(0.0F);
      paramImageView.setTag("1");
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
      localAlphaAnimation.setDuration(this.EeA);
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
              v.a.a(v.a.this, v.a.2.this.EeG);
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
    
    public final void YV(int paramInt)
    {
      AppMethodBeat.i(96598);
      Object localObject = (View)this.EeD.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        AppMethodBeat.o(96598);
        return;
      }
      localObject = (ImageView)((View)localObject).findViewById(2131308049);
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
        k((ImageView)localObject);
      }
      AppMethodBeat.o(96598);
    }
    
    public final void YW(int paramInt)
    {
      AppMethodBeat.i(96599);
      Iterator localIterator = this.EeE.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        a locala = (a)this.EeE.get(localObject);
        if ((locala != null) && (locala.EeL.size() != 0))
        {
          if (((Integer)localObject).intValue() == paramInt)
          {
            i = 0;
            label79:
            if (i < locala.EeL.size())
            {
              localObject = (m)locala.EeL.get(i);
              if (!((m)localObject).fdm()) {
                break label145;
              }
              ((m)localObject).eWZ();
              ((m)localObject).eXb();
              this.EeF.add(((m)localObject).fdn());
            }
            for (;;)
            {
              i += 1;
              break label79;
              break;
              label145:
              if (this.EeF.contains(((m)localObject).fdn()))
              {
                ((m)localObject).eXa();
                this.EeF.remove(((m)localObject).fdn());
              }
            }
          }
          int i = 0;
          while (i < locala.EeL.size())
          {
            localObject = (m)locala.EeL.get(i);
            if (this.EeF.contains(((m)localObject).fdn()))
            {
              ((m)localObject).eXa();
              this.EeF.remove(((m)localObject).fdn());
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
      this.EeD.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(96595);
    }
    
    public final List<m> eXi()
    {
      AppMethodBeat.i(96600);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.EeE.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((a)localIterator.next()).EeL);
      }
      AppMethodBeat.o(96600);
      return localArrayList;
    }
    
    public final void finishUpdate(ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(202983);
      super.finishUpdate(paramViewGroup);
      int j = this.riH.getCurrentItem();
      int i;
      if (j == 0) {
        i = getCount() - 2;
      }
      for (;;)
      {
        this.riH.setCurrentItem(i, false);
        AppMethodBeat.o(202983);
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
      int i = this.Eez.DYI.size();
      AppMethodBeat.o(96592);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(96596);
      Iterator localIterator = this.EeD.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (this.EeD.get(Integer.valueOf(i)) == paramObject)
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
      if (this.EeD.containsKey(Integer.valueOf(paramInt)))
      {
        paramViewGroup = this.EeD.get(Integer.valueOf(paramInt));
        AppMethodBeat.o(96594);
        return paramViewGroup;
      }
      Log.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", new Object[] { Integer.valueOf(paramInt) });
      View localView = this.mLayoutInflater.inflate(2131496397, paramViewGroup, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131308047);
      localLinearLayout.setBackgroundColor(this.backgroundColor);
      Object localObject2 = (a)this.EeE.get(Integer.valueOf(paramInt));
      LinkedList localLinkedList = ((r)this.Eez.DYI.get(paramInt)).DYI;
      int i;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((a)localObject2).EeL.size() != 0) {}
      }
      else
      {
        localObject1 = new a();
        if (localLinkedList != null)
        {
          i = 0;
          while (i < localLinkedList.size())
          {
            localObject2 = (z)localLinkedList.get(i);
            Log.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", new Object[] { ((z)localObject2).DZi });
            localObject2 = ay.a(this.mContext, (z)localObject2, localLinearLayout, this.backgroundColor);
            ((a)localObject1).EeL.add(localObject2);
            i += 1;
          }
        }
        this.EeE.put(Integer.valueOf(paramInt), localObject1);
      }
      Object localObject1 = ((a)localObject1).EeL.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((m)((Iterator)localObject1).next()).getView();
        if ((((View)localObject2).getParent() != null) && ((((View)localObject2).getParent() instanceof ViewGroup))) {
          ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
        }
        localLinearLayout.addView((View)localObject2);
      }
      localObject1 = (ImageView)localView.findViewById(2131308049);
      localObject2 = (TextView)localView.findViewById(2131308048);
      if (this.backgroundColor + 16777216 <= -1 - this.backgroundColor) {
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131234349));
      }
      while (this.Eez.Eac == 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        localView.setLayoutParams(new RelativeLayout.LayoutParams(this.mEX, localLinearLayout.getMeasuredHeight()));
        localView.setBackgroundColor(this.backgroundColor);
        paramViewGroup.addView(localView);
        paramViewGroup.setBackgroundColor(this.backgroundColor);
        this.EeD.put(Integer.valueOf(paramInt), localView);
        AppMethodBeat.o(96594);
        return localView;
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131234352));
      }
      label549:
      int j;
      if (paramInt == this.Eez.DYI.size() - 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        j = getCount() - 2;
        if (paramInt != 0) {
          break label613;
        }
        ((ImageView)localObject1).setVisibility(8);
        i = j;
      }
      for (;;)
      {
        ((TextView)localObject2).setText(i + "/" + j);
        break;
        ((ImageView)localObject1).setVisibility(0);
        break label549;
        label613:
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
      public LinkedList<m> EeL;
      
      public a()
      {
        AppMethodBeat.i(96590);
        this.EeL = new LinkedList();
        AppMethodBeat.o(96590);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */