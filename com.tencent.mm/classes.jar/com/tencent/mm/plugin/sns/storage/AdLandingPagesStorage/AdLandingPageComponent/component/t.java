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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ag;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
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

public final class t
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
{
  private static final Map<String, Bitmap> yoj;
  ViewPager sO;
  private int uqT;
  a yok;
  AdLandingControlView yol;
  private int yom;
  
  static
  {
    AppMethodBeat.i(96612);
    yoj = new WeakHashMap();
    AppMethodBeat.o(96612);
  }
  
  public t(Context paramContext, ag paramag, ViewGroup paramViewGroup)
  {
    super(paramContext, paramag, paramViewGroup);
    AppMethodBeat.i(96602);
    this.yom = 0;
    this.uqT = 0;
    this.yol = new AdLandingControlView(paramContext);
    AppMethodBeat.o(96602);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96610);
    if (!super.aH(paramJSONObject))
    {
      AppMethodBeat.o(96610);
      return false;
    }
    AppMethodBeat.o(96610);
    return true;
  }
  
  public final void aJ(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(96606);
    super.aJ(paramMap);
    if (paramMap.containsKey("startIndex")) {
      try
      {
        this.yom = ((Integer)paramMap.get("startIndex")).intValue();
        this.sO.setCurrentItem(this.yom, false);
        AppMethodBeat.o(96606);
        return;
      }
      catch (Exception paramMap) {}
    }
    AppMethodBeat.o(96606);
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(96609);
    View localView = this.contentView;
    this.sO = ((ViewPager)localView.findViewById(2131304917));
    this.yol = ((AdLandingControlView)localView.findViewById(2131304899));
    AppMethodBeat.o(96609);
  }
  
  public final void dJY()
  {
    AppMethodBeat.i(96603);
    this.yok.OI(this.uqT);
    this.yok.OJ(this.uqT);
    super.dJY();
    AppMethodBeat.o(96603);
  }
  
  public final void dJZ()
  {
    AppMethodBeat.i(96604);
    this.yok.OJ(-1);
    super.dJZ();
    AppMethodBeat.o(96604);
  }
  
  public final void dKF()
  {
    AppMethodBeat.i(96607);
    super.dKF();
    this.sO.setCurrentItem(this.yom, false);
    AppMethodBeat.o(96607);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96608);
    int k = this.kWB - (int)((ag)this.ymQ).paddingLeft - (int)((ag)this.ymQ).paddingRight;
    int m = this.kWC;
    Object localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    final a locala;
    if (this.sO.getAdapter() == null)
    {
      locala = new a(this.context, (LayoutInflater)localObject1, (ag)this.ymQ, this.backgroundColor);
      this.sO.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(96584);
          ac.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          t.this.yol.setPage(paramAnonymousInt);
          t.a(t.this, paramAnonymousInt);
          if (t.this.ymT)
          {
            locala.OI(paramAnonymousInt);
            locala.OJ(paramAnonymousInt);
          }
          AppMethodBeat.o(96584);
        }
      });
      this.sO.setAdapter(locala);
      this.yol.jy(((ag)this.ymQ).yjb.size(), 0);
      if (!((ag)this.ymQ).mwy) {
        break label213;
      }
      this.sO.setLayoutParams(new RelativeLayout.LayoutParams(k, m));
    }
    label213:
    while (((ag)this.ymQ).yjb.size() <= 0)
    {
      this.yok = locala;
      locala.notifyDataSetChanged();
      AppMethodBeat.o(96608);
      return;
      locala = (a)this.sO.getAdapter();
      locala.yop = ((ag)this.ymQ);
      break;
    }
    Object localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)((ag)this.ymQ).yjb.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject2).yjb.iterator();
    label276:
    x localx;
    int j;
    ad localad;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localx = (x)((Iterator)localObject2).next();
      j = (int)(i + localx.paddingTop);
      if ((localx instanceof ad))
      {
        localad = (ad)localx;
        localObject4 = ((LayoutInflater)localObject1).inflate(2131495510, null);
        ((View)localObject4).setBackgroundColor(this.backgroundColor);
        i = j;
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = (TextView)((View)localObject4).findViewById(2131304898);
        i = j;
        ((TextView)localObject4).setText(localad.yjT);
        i = j;
        if (localad.textSize > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setTextSize(0, localad.textSize);
        }
        i = j;
        if (localad.yjX > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setLineSpacing(0.0F, localad.yjX + 1.0F);
        }
        i = j;
        if (localad.yjU)
        {
          i = j;
          ((TextView)localObject4).getPaint().setFakeBoldText(true);
        }
        i = j;
        ((TextView)localObject4).measure(View.MeasureSpec.makeMeasureSpec((int)(k - localad.paddingLeft - localad.paddingRight), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
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
        ac.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "txtComp measure exp=" + localException.toString());
        continue;
      }
      float f1 = i;
      i = (int)(localx.paddingBottom + f1);
      break label276;
      Object localObject3;
      if ((localx instanceof p))
      {
        localObject3 = (Button)((LayoutInflater)localObject1).inflate(2131495498, null).findViewById(2131304902);
        ((Button)localObject3).setText(((p)localx).title);
        ((Button)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = ((Button)localObject3).getPaddingTop() + j;
        if ((localx.yjv > 0.0F) && ((int)localx.yjv != 2147483647)) {
          i = (int)(i + localx.yjv);
        }
        for (;;)
        {
          i = ((Button)localObject3).getPaddingBottom() + i;
          break;
          if ((localx.height > 0.0F) && ((int)localx.height != 2147483647)) {
            i = (int)(i + localx.height);
          } else {
            i += ((Button)localObject3).getMeasuredHeight();
          }
        }
      }
      if ((localx instanceof s))
      {
        float f2 = 0.0F;
        f1 = 0.0F;
        float f3 = localx.paddingTop;
        float f4 = localx.paddingBottom;
        if ((localx instanceof s))
        {
          localObject3 = (s)localx;
          f2 = ((s)localObject3).height;
          f1 = ((s)localObject3).width;
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
      if ((localx instanceof r))
      {
        i = j + m;
      }
      else if ((localx instanceof u))
      {
        localObject3 = (u)localx;
        if (((u)localObject3).yjo == 1)
        {
          i = j + m;
        }
        else if ((int)((u)localObject3).width > 0)
        {
          i = (int)((u)localObject3).height * k / (int)((u)localObject3).width + j;
        }
        else
        {
          f1 = j;
          i = (int)(((u)localObject3).height + f1);
        }
      }
      else if ((localx instanceof ai))
      {
        localObject3 = (ai)localx;
        if (((ai)localObject3).ykh == 1)
        {
          if ((int)((ai)localObject3).width > 0)
          {
            i = (int)((ai)localObject3).height * k / (int)((ai)localObject3).width + j;
          }
          else
          {
            f1 = j;
            i = (int)(((ai)localObject3).height + f1);
          }
        }
        else {
          i = j + m;
        }
      }
      else
      {
        if ((localx instanceof ah))
        {
          i = j + m;
          continue;
          localObject1 = new RelativeLayout.LayoutParams(k, i);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)((ag)this.ymQ).paddingLeft);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((ag)this.ymQ).paddingRight);
          this.sO.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break;
        }
        i = j;
      }
    }
  }
  
  public final void dKt()
  {
    AppMethodBeat.i(96605);
    this.yok.OJ(this.uqT);
    AppMethodBeat.o(96605);
  }
  
  public final List<k> dKu()
  {
    AppMethodBeat.i(96611);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((a)this.sO.getAdapter()).dKR());
    AppMethodBeat.o(96611);
    return localArrayList;
  }
  
  protected final int getLayout()
  {
    return 2131495512;
  }
  
  static final class a
    extends android.support.v4.view.q
  {
    int backgroundColor;
    int kWB;
    int kWC;
    Context mContext;
    LayoutInflater mLayoutInflater;
    ag yop;
    private int yoq;
    int yor;
    int yos;
    HashMap<Integer, View> yot;
    HashMap<Integer, a> you;
    Set<String> yov;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, ag paramag, int paramInt)
    {
      AppMethodBeat.i(96591);
      this.yoq = 600;
      this.yor = 700;
      this.yos = 250;
      this.yot = new HashMap();
      this.you = new HashMap();
      this.yov = new HashSet();
      this.mContext = paramContext;
      this.mLayoutInflater = paramLayoutInflater;
      this.yop = paramag;
      this.backgroundColor = paramInt;
      paramContext = al.gg(paramContext);
      this.kWB = paramContext[0];
      this.kWC = paramContext[1];
      AppMethodBeat.o(96591);
    }
    
    private void i(final ImageView paramImageView)
    {
      AppMethodBeat.i(96597);
      if ((paramImageView.getTag() != null) && ((paramImageView.getTag() instanceof String)) && (new BigInteger((String)paramImageView.getTag()).longValue() >= 1L))
      {
        AppMethodBeat.o(96597);
        return;
      }
      paramImageView.setTag("1");
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
      localAlphaAnimation.setDuration(this.yoq);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(96589);
          new ao().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96588);
              t.a.a(t.a.this, t.a.2.this.yow);
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
    
    public final void OI(int paramInt)
    {
      AppMethodBeat.i(96598);
      Object localObject = (View)this.yot.get(String.valueOf(paramInt));
      if (localObject == null)
      {
        AppMethodBeat.o(96598);
        return;
      }
      localObject = (ImageView)((View)localObject).findViewById(2131304913);
      if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
        i((ImageView)localObject);
      }
      AppMethodBeat.o(96598);
    }
    
    public final void OJ(int paramInt)
    {
      AppMethodBeat.i(96599);
      Iterator localIterator = this.you.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        a locala = (a)this.you.get(localObject);
        if ((locala != null) && (locala.yoB.size() != 0))
        {
          if (((Integer)localObject).intValue() == paramInt)
          {
            i = 0;
            label79:
            if (i < locala.yoB.size())
            {
              localObject = (k)locala.yoB.get(i);
              if (!((k)localObject).dKC()) {
                break label145;
              }
              ((k)localObject).dJY();
              ((k)localObject).dKa();
              this.yov.add(((k)localObject).dKD());
            }
            for (;;)
            {
              i += 1;
              break label79;
              break;
              label145:
              if (this.yov.contains(((k)localObject).dKD()))
              {
                ((k)localObject).dJZ();
                this.yov.remove(((k)localObject).dKD());
              }
            }
          }
          int i = 0;
          while (i < locala.yoB.size())
          {
            localObject = (k)locala.yoB.get(i);
            if (this.yov.contains(((k)localObject).dKD()))
            {
              ((k)localObject).dJZ();
              this.yov.remove(((k)localObject).dKD());
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(96599);
    }
    
    public final List<k> dKR()
    {
      AppMethodBeat.i(96600);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.you.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((a)localIterator.next()).yoB);
      }
      AppMethodBeat.o(96600);
      return localArrayList;
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(96595);
      paramViewGroup.removeView((View)paramObject);
      this.yot.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(96595);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(96592);
      int i = this.yop.yjb.size();
      AppMethodBeat.o(96592);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(96596);
      Iterator localIterator = this.yot.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (this.yot.get(Integer.valueOf(i)) == paramObject)
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
      ac.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", new Object[] { Integer.valueOf(paramInt) });
      if (this.yot.containsKey(Integer.valueOf(paramInt)))
      {
        paramViewGroup = this.yot.get(Integer.valueOf(paramInt));
        AppMethodBeat.o(96594);
        return paramViewGroup;
      }
      ac.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", new Object[] { Integer.valueOf(paramInt) });
      View localView = this.mLayoutInflater.inflate(2131495511, paramViewGroup, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131304911);
      localLinearLayout.setBackgroundColor(this.backgroundColor);
      Object localObject2 = (a)this.you.get(Integer.valueOf(paramInt));
      LinkedList localLinkedList = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.yop.yjb.get(paramInt)).yjb;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((a)localObject2).yoB.size() != 0) {}
      }
      else
      {
        localObject1 = new a();
        if (localLinkedList != null)
        {
          int i = 0;
          while (i < localLinkedList.size())
          {
            localObject2 = (x)localLinkedList.get(i);
            ac.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", new Object[] { ((x)localObject2).yjs });
            localObject2 = as.a(this.mContext, (x)localObject2, localLinearLayout, this.backgroundColor);
            ((a)localObject1).yoB.add(localObject2);
            i += 1;
          }
        }
        this.you.put(Integer.valueOf(paramInt), localObject1);
      }
      Object localObject1 = ((a)localObject1).yoB.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((k)((Iterator)localObject1).next()).getView();
        if ((((View)localObject2).getParent() != null) && ((((View)localObject2).getParent() instanceof ViewGroup))) {
          ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
        }
        localLinearLayout.addView((View)localObject2);
      }
      localObject1 = (ImageView)localView.findViewById(2131304913);
      localObject2 = (TextView)localView.findViewById(2131304912);
      if (this.backgroundColor + 16777216 <= -1 - this.backgroundColor) {
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131233545));
      }
      while (this.yop.ykf == 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        localView.setLayoutParams(new RelativeLayout.LayoutParams(this.kWB, localLinearLayout.getMeasuredHeight()));
        localView.setBackgroundColor(this.backgroundColor);
        paramViewGroup.addView(localView);
        paramViewGroup.setBackgroundColor(this.backgroundColor);
        this.yot.put(Integer.valueOf(paramInt), localView);
        AppMethodBeat.o(96594);
        return localView;
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131233548));
      }
      if (paramInt == this.yop.yjb.size() - 1) {
        ((ImageView)localObject1).setVisibility(8);
      }
      for (;;)
      {
        ((TextView)localObject2).setText(paramInt + 1 + "/" + this.yop.yjb.size());
        break;
        ((ImageView)localObject1).setVisibility(0);
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
      public LinkedList<k> yoB;
      
      public a()
      {
        AppMethodBeat.i(96590);
        this.yoB = new LinkedList();
        AppMethodBeat.o(96590);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t
 * JD-Core Version:    0.7.0.1
 */