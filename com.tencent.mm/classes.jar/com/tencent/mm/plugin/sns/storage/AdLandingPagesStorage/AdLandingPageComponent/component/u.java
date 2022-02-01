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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.sdk.platformtools.ap;
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

public final class u
  extends com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a
{
  private static final Map<String, Bitmap> zFe;
  ViewPager uH;
  private int vty;
  a zFf;
  AdLandingControlView zFg;
  private int zFh;
  
  static
  {
    AppMethodBeat.i(96612);
    zFe = new WeakHashMap();
    AppMethodBeat.o(96612);
  }
  
  public u(Context paramContext, ah paramah, ViewGroup paramViewGroup)
  {
    super(paramContext, paramah, paramViewGroup);
    AppMethodBeat.i(96602);
    this.zFh = 0;
    this.vty = 0;
    this.zFg = new AdLandingControlView(paramContext);
    AppMethodBeat.o(96602);
  }
  
  public final void aM(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(96606);
    super.aM(paramMap);
    if (paramMap.containsKey("startIndex")) {
      try
      {
        this.zFh = ((Integer)paramMap.get("startIndex")).intValue();
        this.uH.setCurrentItem(this.zFh, false);
        AppMethodBeat.o(96606);
        return;
      }
      catch (Exception paramMap) {}
    }
    AppMethodBeat.o(96606);
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
  
  public final void dRk()
  {
    AppMethodBeat.i(96609);
    View localView = this.contentView;
    this.uH = ((ViewPager)localView.findViewById(2131304917));
    this.zFg = ((AdLandingControlView)localView.findViewById(2131304899));
    AppMethodBeat.o(96609);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96608);
    int k = this.ltA - (int)((ah)this.zDK).paddingLeft - (int)((ah)this.zDK).paddingRight;
    int m = this.ltB;
    Object localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    final a locala;
    if (this.uH.getAdapter() == null)
    {
      locala = new a(this.context, (LayoutInflater)localObject1, (ah)this.zDK, this.backgroundColor);
      this.uH.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
      {
        public final void onPageScrollStateChanged(int paramAnonymousInt) {}
        
        public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void onPageSelected(int paramAnonymousInt)
        {
          AppMethodBeat.i(96584);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "onPageSelected %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          u.this.zFg.setPage(paramAnonymousInt);
          u.a(u.this, paramAnonymousInt);
          if (u.this.zDN)
          {
            locala.Qq(paramAnonymousInt);
            locala.Qr(paramAnonymousInt);
          }
          AppMethodBeat.o(96584);
        }
      });
      this.uH.setAdapter(locala);
      this.zFg.jK(((ah)this.zDK).zzJ.size(), 0);
      if (!((ah)this.zDK).mXd) {
        break label213;
      }
      this.uH.setLayoutParams(new RelativeLayout.LayoutParams(k, m));
    }
    label213:
    while (((ah)this.zDK).zzJ.size() <= 0)
    {
      this.zFf = locala;
      locala.notifyDataSetChanged();
      AppMethodBeat.o(96608);
      return;
      locala = (a)this.uH.getAdapter();
      locala.zFk = ((ah)this.zDK);
      break;
    }
    Object localObject2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)((ah)this.zDK).zzJ.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)localObject2).zzJ.iterator();
    label276:
    x localx;
    int j;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad localad;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localx = (x)((Iterator)localObject2).next();
      j = (int)(i + localx.paddingTop);
      if ((localx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad))
      {
        localad = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad)localx;
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
        ((TextView)localObject4).setText(localad.zAI);
        i = j;
        if (localad.textSize > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setTextSize(0, localad.textSize);
        }
        i = j;
        if (localad.zAM > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setLineSpacing(0.0F, localad.zAM + 1.0F);
        }
        i = j;
        if (localad.zAJ)
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
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "txtComp measure exp=" + localException.toString());
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
        if ((localx.zAj > 0.0F) && ((int)localx.zAj != 2147483647)) {
          i = (int)(i + localx.zAj);
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
      else if ((localx instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u))
      {
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localx;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).zzW == 1)
        {
          i = j + m;
        }
        else if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).width > 0)
        {
          i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).height * k / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).width + j;
        }
        else
        {
          f1 = j;
          i = (int)(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u)localObject3).height + f1);
        }
      }
      else if ((localx instanceof aj))
      {
        localObject3 = (aj)localx;
        if (((aj)localObject3).zAW == 1)
        {
          if ((int)((aj)localObject3).width > 0)
          {
            i = (int)((aj)localObject3).height * k / (int)((aj)localObject3).width + j;
          }
          else
          {
            f1 = j;
            i = (int)(((aj)localObject3).height + f1);
          }
        }
        else {
          i = j + m;
        }
      }
      else
      {
        if ((localx instanceof ai))
        {
          i = j + m;
          continue;
          localObject1 = new RelativeLayout.LayoutParams(k, i);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)((ah)this.zDK).paddingLeft);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((ah)this.zDK).paddingRight);
          this.uH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break;
        }
        i = j;
      }
    }
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96603);
    this.zFf.Qq(this.vty);
    this.zFf.Qr(this.vty);
    super.dRm();
    AppMethodBeat.o(96603);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96604);
    this.zFf.Qr(-1);
    super.dRn();
    AppMethodBeat.o(96604);
  }
  
  public final void dWG()
  {
    AppMethodBeat.i(96605);
    this.zFf.Qr(this.vty);
    AppMethodBeat.o(96605);
  }
  
  public final List<l> dWH()
  {
    AppMethodBeat.i(96611);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((a)this.uH.getAdapter()).dRr());
    AppMethodBeat.o(96611);
    return localArrayList;
  }
  
  public final void dWX()
  {
    AppMethodBeat.i(96607);
    super.dWX();
    this.uH.setCurrentItem(this.zFh, false);
    AppMethodBeat.o(96607);
  }
  
  protected final int getLayout()
  {
    return 2131495512;
  }
  
  static final class a
    extends android.support.v4.view.q
  {
    int backgroundColor;
    int ltA;
    int ltB;
    Context mContext;
    LayoutInflater mLayoutInflater;
    ah zFk;
    private int zFl;
    int zFm;
    int zFn;
    HashMap<Integer, View> zFo;
    HashMap<Integer, a> zFp;
    Set<String> zFq;
    
    public a(Context paramContext, LayoutInflater paramLayoutInflater, ah paramah, int paramInt)
    {
      AppMethodBeat.i(96591);
      this.zFl = 600;
      this.zFm = 700;
      this.zFn = 250;
      this.zFo = new HashMap();
      this.zFp = new HashMap();
      this.zFq = new HashSet();
      this.mContext = paramContext;
      this.mLayoutInflater = paramLayoutInflater;
      this.zFk = paramah;
      this.backgroundColor = paramInt;
      paramContext = am.gk(paramContext);
      this.ltA = paramContext[0];
      this.ltB = paramContext[1];
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
      localAlphaAnimation.setDuration(this.zFl);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
      localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(96589);
          new ap().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(96588);
              u.a.a(u.a.this, u.a.2.this.zFr);
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
    
    public final void Qq(int paramInt)
    {
      AppMethodBeat.i(96598);
      Object localObject = (View)this.zFo.get(String.valueOf(paramInt));
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
    
    public final void Qr(int paramInt)
    {
      AppMethodBeat.i(96599);
      Iterator localIterator = this.zFp.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Integer)localIterator.next();
        a locala = (a)this.zFp.get(localObject);
        if ((locala != null) && (locala.zFw.size() != 0))
        {
          if (((Integer)localObject).intValue() == paramInt)
          {
            i = 0;
            label79:
            if (i < locala.zFw.size())
            {
              localObject = (l)locala.zFw.get(i);
              if (!((l)localObject).dWU()) {
                break label145;
              }
              ((l)localObject).dRm();
              ((l)localObject).dWm();
              this.zFq.add(((l)localObject).dWV());
            }
            for (;;)
            {
              i += 1;
              break label79;
              break;
              label145:
              if (this.zFq.contains(((l)localObject).dWV()))
              {
                ((l)localObject).dRn();
                this.zFq.remove(((l)localObject).dWV());
              }
            }
          }
          int i = 0;
          while (i < locala.zFw.size())
          {
            localObject = (l)locala.zFw.get(i);
            if (this.zFq.contains(((l)localObject).dWV()))
            {
              ((l)localObject).dRn();
              this.zFq.remove(((l)localObject).dWV());
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(96599);
    }
    
    public final List<l> dRr()
    {
      AppMethodBeat.i(96600);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.zFp.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.addAll(((a)localIterator.next()).zFw);
      }
      AppMethodBeat.o(96600);
      return localArrayList;
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      AppMethodBeat.i(96595);
      paramViewGroup.removeView((View)paramObject);
      this.zFo.remove(Integer.valueOf(paramInt));
      AppMethodBeat.o(96595);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(96592);
      int i = this.zFk.zzJ.size();
      AppMethodBeat.o(96592);
      return i;
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(96596);
      Iterator localIterator = this.zFo.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (this.zFo.get(Integer.valueOf(i)) == paramObject)
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
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", new Object[] { Integer.valueOf(paramInt) });
      if (this.zFo.containsKey(Integer.valueOf(paramInt)))
      {
        paramViewGroup = this.zFo.get(Integer.valueOf(paramInt));
        AppMethodBeat.o(96594);
        return paramViewGroup;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", new Object[] { Integer.valueOf(paramInt) });
      View localView = this.mLayoutInflater.inflate(2131495511, paramViewGroup, false);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131304911);
      localLinearLayout.setBackgroundColor(this.backgroundColor);
      Object localObject2 = (a)this.zFp.get(Integer.valueOf(paramInt));
      LinkedList localLinkedList = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q)this.zFk.zzJ.get(paramInt)).zzJ;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((a)localObject2).zFw.size() != 0) {}
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
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", new Object[] { ((x)localObject2).zAg });
            localObject2 = av.a(this.mContext, (x)localObject2, localLinearLayout, this.backgroundColor);
            ((a)localObject1).zFw.add(localObject2);
            i += 1;
          }
        }
        this.zFp.put(Integer.valueOf(paramInt), localObject1);
      }
      Object localObject1 = ((a)localObject1).zFw.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((l)((Iterator)localObject1).next()).getView();
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
      while (this.zFk.zAU == 1)
      {
        ((ImageView)localObject1).setVisibility(8);
        ((TextView)localObject2).setVisibility(8);
        localView.setLayoutParams(new RelativeLayout.LayoutParams(this.ltA, localLinearLayout.getMeasuredHeight()));
        localView.setBackgroundColor(this.backgroundColor);
        paramViewGroup.addView(localView);
        paramViewGroup.setBackgroundColor(this.backgroundColor);
        this.zFo.put(Integer.valueOf(paramInt), localView);
        AppMethodBeat.o(96594);
        return localView;
        ((ImageView)localObject1).setImageDrawable(com.tencent.mm.cc.a.l(this.mContext, 2131233548));
      }
      if (paramInt == this.zFk.zzJ.size() - 1) {
        ((ImageView)localObject1).setVisibility(8);
      }
      for (;;)
      {
        ((TextView)localObject2).setText(paramInt + 1 + "/" + this.zFk.zzJ.size());
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
      public LinkedList<l> zFw;
      
      public a()
      {
        AppMethodBeat.i(96590);
        this.zFw = new LinkedList();
        AppMethodBeat.o(96590);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */