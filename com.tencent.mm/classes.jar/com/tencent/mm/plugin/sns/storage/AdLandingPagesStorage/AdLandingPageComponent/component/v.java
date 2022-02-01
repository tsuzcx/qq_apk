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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.aq;
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
  private static final Map<String, Bitmap> zWk;
  ViewPager uH;
  private int vFD;
  a zWl;
  AdLandingControlView zWm;
  private int zWn;
  
  static
  {
    AppMethodBeat.i(96612);
    zWk = new WeakHashMap();
    AppMethodBeat.o(96612);
  }
  
  public v(Context paramContext, ai paramai, ViewGroup paramViewGroup)
  {
    super(paramContext, paramai, paramViewGroup);
    AppMethodBeat.i(96602);
    this.zWn = 0;
    this.vFD = 0;
    this.zWm = new AdLandingControlView(paramContext);
    AppMethodBeat.o(96602);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96610);
    if (!super.aQ(paramJSONObject))
    {
      AppMethodBeat.o(96610);
      return false;
    }
    AppMethodBeat.o(96610);
    return true;
  }
  
  public final void aS(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(96606);
    super.aS(paramMap);
    if (paramMap.containsKey("startIndex")) {
      try
      {
        this.zWn = ((Integer)paramMap.get("startIndex")).intValue();
        this.uH.setCurrentItem(this.zWn, false);
        AppMethodBeat.o(96606);
        return;
      }
      catch (Exception paramMap) {}
    }
    AppMethodBeat.o(96606);
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96609);
    View localView = this.contentView;
    this.uH = ((ViewPager)localView.findViewById(2131304917));
    this.zWm = ((AdLandingControlView)localView.findViewById(2131304899));
    AppMethodBeat.o(96609);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96608);
    int k = this.lxZ - (int)((ai)this.zUP).paddingLeft - (int)((ai)this.zUP).paddingRight;
    int m = this.lya;
    Object localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    final a locala;
    if (this.uH.getAdapter() == null)
    {
      locala = new a(this.context, (LayoutInflater)localObject1, (ai)this.zUP, this.backgroundColor);
      this.uH.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(96584);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          v.this.zWm.setPage(paramAnonymousInt);
          v.a(v.this, paramAnonymousInt);
          if (v.this.zUS)
          {
            locala.QX(paramAnonymousInt);
            locala.QY(paramAnonymousInt);
          }
          AppMethodBeat.o(96584);
        }
      });
      this.uH.setAdapter(locala);
      this.zWm.jO(((ai)this.zUP).zQI.size(), 0);
      if (!((ai)this.zUP).ncj) {
        break label213;
      }
      this.uH.setLayoutParams(new RelativeLayout.LayoutParams(k, m));
    }
    label213:
    while (((ai)this.zUP).zQI.size() <= 0)
    {
      this.zWl = locala;
      locala.notifyDataSetChanged();
      AppMethodBeat.o(96608);
      return;
      locala = (a)this.uH.getAdapter();
      locala.zWq = ((ai)this.zUP);
      break;
    }
    Object localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)((ai)this.zUP).zQI.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject2).zQI.iterator();
    label276:
    y localy;
    int j;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae localae;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localy = (y)((Iterator)localObject2).next();
      j = (int)(i + localy.paddingTop);
      if ((localy instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae))
      {
        localae = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ae)localy;
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
        ((TextView)localObject4).setText(localae.zRI);
        i = j;
        if (localae.textSize > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setTextSize(0, localae.textSize);
        }
        i = j;
        if (localae.zRM > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setLineSpacing(0.0F, localae.zRM + 1.0F);
        }
        i = j;
        if (localae.zRJ)
        {
          i = j;
          ((TextView)localObject4).getPaint().setFakeBoldText(true);
        }
        i = j;
        ((TextView)localObject4).measure(View.MeasureSpec.makeMeasureSpec((int)(k - localae.paddingLeft - localae.paddingRight), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
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
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "txtComp measure exp=" + localException.toString());
        continue;
      }
      float f1 = i;
      i = (int)(localy.paddingBottom + f1);
      break label276;
      Object localObject3;
      if ((localy instanceof p))
      {
        localObject3 = (Button)((LayoutInflater)localObject1).inflate(2131495498, null).findViewById(2131304902);
        ((Button)localObject3).setText(((p)localy).title);
        ((Button)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = ((Button)localObject3).getPaddingTop() + j;
        if ((localy.zRj > 0.0F) && ((int)localy.zRj != 2147483647)) {
          i = (int)(i + localy.zRj);
        }
        for (;;)
        {
          i = ((Button)localObject3).getPaddingBottom() + i;
          break;
          if ((localy.height > 0.0F) && ((int)localy.height != 2147483647)) {
            i = (int)(i + localy.height);
          } else {
            i += ((Button)localObject3).getMeasuredHeight();
          }
        }
      }
      if ((localy instanceof s))
      {
        float f2 = 0.0F;
        f1 = 0.0F;
        float f3 = localy.paddingTop;
        float f4 = localy.paddingBottom;
        if ((localy instanceof s))
        {
          localObject3 = (s)localy;
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
      if ((localy instanceof r))
      {
        i = j + m;
      }
      else if ((localy instanceof u))
      {
        localObject3 = (u)localy;
        if (((u)localObject3).zQV == 1)
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
      else if ((localy instanceof ak))
      {
        localObject3 = (ak)localy;
        if (((ak)localObject3).zRW == 1)
        {
          if ((int)((ak)localObject3).width > 0)
          {
            i = (int)((ak)localObject3).height * k / (int)((ak)localObject3).width + j;
          }
          else
          {
            f1 = j;
            i = (int)(((ak)localObject3).height + f1);
          }
        }
        else {
          i = j + m;
        }
      }
      else
      {
        if ((localy instanceof aj))
        {
          i = j + m;
          continue;
          localObject1 = new RelativeLayout.LayoutParams(k, i);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)((ai)this.zUP).paddingLeft);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((ai)this.zUP).paddingRight);
          this.uH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break;
        }
        i = j;
      }
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96603);
    this.zWl.QX(this.vFD);
    this.zWl.QY(this.vFD);
    super.dUK();
    AppMethodBeat.o(96603);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96604);
    this.zWl.QY(-1);
    super.dUL();
    AppMethodBeat.o(96604);
  }
  
  public final void eaB()
  {
    AppMethodBeat.i(96607);
    super.eaB();
    this.uH.setCurrentItem(this.zWn, false);
    AppMethodBeat.o(96607);
  }
  
  public final void eai()
  {
    AppMethodBeat.i(96605);
    this.zWl.QY(this.vFD);
    AppMethodBeat.o(96605);
  }
  
  public final List<m> eaj()
  {
    AppMethodBeat.i(96611);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((a)this.uH.getAdapter()).dUP());
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
    int lxZ;
    int lya;
    Context mContext;
    LayoutInflater mLayoutInflater;
    ai zWq;
    private int zWr;
    int zWs;
    int zWt;
    HashMap<Integer, View> zWu;
    HashMap<Integer, a> zWv;
    Set<String> zWw;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, ai paramai, int paramInt)
    {
      AppMethodBeat.i(96591);
      this.zWr = 600;
      this.zWs = 700;
      this.zWt = 250;
      this.zWu = new HashMap();
      this.zWv = new HashMap();
      this.zWw = new HashSet();
      this.mContext = paramContext;
      this.mLayoutInflater = paramLayoutInflater;
      this.zWq = paramai;
      this.backgroundColor = paramInt;
      paramContext = an.gp(paramContext);
      this.lxZ = paramContext[0];
      this.lya = paramContext[1];
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
      localAlphaAnimation.setDuration(this.zWr);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(96589);
          new aq().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96588);
              v.a.a(v.a.this, v.a.2.this.zWx);
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
    
    public final void QX(int paramInt)
    {
      AppMethodBeat.i(96598);
      Object localObject = (View)this.zWu.get(String.valueOf(paramInt));
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
    
    public final void QY(int paramInt)
    {
      AppMethodBeat.i(96599);
      Iterator localIterator = this.zWv.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        a locala = (a)this.zWv.get(localObject);
        if ((locala != null) && (locala.zWC.size() != 0))
        {
          if (((Integer)localObject).intValue() == paramInt)
          {
            i = 0;
            label79:
            if (i < locala.zWC.size())
            {
              localObject = (m)locala.zWC.get(i);
              if (!((m)localObject).eay()) {
                break label145;
              }
              ((m)localObject).dUK();
              ((m)localObject).dZO();
              this.zWw.add(((m)localObject).eaz());
            }
            for (;;)
            {
              i += 1;
              break label79;
              break;
              label145:
              if (this.zWw.contains(((m)localObject).eaz()))
              {
                ((m)localObject).dUL();
                this.zWw.remove(((m)localObject).eaz());
              }
            }
          }
          int i = 0;
          while (i < locala.zWC.size())
          {
            localObject = (m)locala.zWC.get(i);
            if (this.zWw.contains(((m)localObject).eaz()))
            {
              ((m)localObject).dUL();
              this.zWw.remove(((m)localObject).eaz());
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(96599);
    }
    
    public final List<m> dUP()
    {
      AppMethodBeat.i(96600);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.zWv.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((a)localIterator.next()).zWC);
      }
      AppMethodBeat.o(96600);
      return localArrayList;
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(96595);
      paramViewGroup.removeView((View)paramObject);
      this.zWu.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(96595);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(96592);
      int i = this.zWq.zQI.size();
      AppMethodBeat.o(96592);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(96596);
      Iterator localIterator = this.zWu.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (this.zWu.get(Integer.valueOf(i)) == paramObject)
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", new Object[] { Integer.valueOf(paramInt) });
      if (this.zWu.containsKey(Integer.valueOf(paramInt)))
      {
        paramViewGroup = this.zWu.get(Integer.valueOf(paramInt));
        AppMethodBeat.o(96594);
        return paramViewGroup;
      }
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", new Object[] { Integer.valueOf(paramInt) });
      View localView = this.mLayoutInflater.inflate(2131495511, paramViewGroup, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131304911);
      localLinearLayout.setBackgroundColor(this.backgroundColor);
      Object localObject2 = (a)this.zWv.get(Integer.valueOf(paramInt));
      LinkedList localLinkedList = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.zWq.zQI.get(paramInt)).zQI;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((a)localObject2).zWC.size() != 0) {}
      }
      else
      {
        localObject1 = new a();
        if (localLinkedList != null)
        {
          int i = 0;
          while (i < localLinkedList.size())
          {
            localObject2 = (y)localLinkedList.get(i);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", new Object[] { ((y)localObject2).zRg });
            localObject2 = av.a(this.mContext, (y)localObject2, localLinearLayout, this.backgroundColor);
            ((a)localObject1).zWC.add(localObject2);
            i += 1;
          }
        }
        this.zWv.put(Integer.valueOf(paramInt), localObject1);
      }
      Object localObject1 = ((a)localObject1).zWC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((m)((Iterator)localObject1).next()).getView();
        if ((((View)localObject2).getParent() != null) && ((((View)localObject2).getParent() instanceof ViewGroup))) {
          ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
        }
        localLinearLayout.addView((View)localObject2);
      }
      localObject1 = (ImageView)localView.findViewById(2131304913);
      localObject2 = (TextView)localView.findViewById(2131304912);
      if (this.backgroundColor + 16777216 <= -1 - this.backgroundColor) {
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131233545));
      }
      while (this.zWq.zRU == 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        localView.setLayoutParams(new RelativeLayout.LayoutParams(this.lxZ, localLinearLayout.getMeasuredHeight()));
        localView.setBackgroundColor(this.backgroundColor);
        paramViewGroup.addView(localView);
        paramViewGroup.setBackgroundColor(this.backgroundColor);
        this.zWu.put(Integer.valueOf(paramInt), localView);
        AppMethodBeat.o(96594);
        return localView;
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cb.a.l(this.mContext, 2131233548));
      }
      if (paramInt == this.zWq.zQI.size() - 1) {
        ((ImageView)localObject1).setVisibility(8);
      }
      for (;;)
      {
        ((TextView)localObject2).setText(paramInt + 1 + "/" + this.zWq.zQI.size());
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
      public LinkedList<m> zWC;
      
      public a()
      {
        AppMethodBeat.i(96590);
        this.zWC = new LinkedList();
        AppMethodBeat.o(96590);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v
 * JD-Core Version:    0.7.0.1
 */