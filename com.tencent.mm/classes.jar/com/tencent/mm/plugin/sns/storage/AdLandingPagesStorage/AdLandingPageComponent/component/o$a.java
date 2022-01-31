package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.support.v4.view.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.al;
import com.tencent.mm.sdk.platformtools.ab;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

final class o$a
  extends q
{
  int backgroundColor;
  int iiW;
  int iiX;
  Context mContext;
  LayoutInflater mLayoutInflater;
  z rwq;
  private int rwr;
  int rws;
  int rwt;
  HashMap<Integer, View> rwu;
  HashMap<Integer, o.a.a> rwv;
  Set<String> rww;
  
  public o$a(Context paramContext, LayoutInflater paramLayoutInflater, z paramz, int paramInt)
  {
    AppMethodBeat.i(37170);
    this.rwr = 600;
    this.rws = 700;
    this.rwt = 250;
    this.rwu = new HashMap();
    this.rwv = new HashMap();
    this.rww = new HashSet();
    this.mContext = paramContext;
    this.mLayoutInflater = paramLayoutInflater;
    this.rwq = paramz;
    this.backgroundColor = paramInt;
    paramContext = ae.eU(paramContext);
    this.iiW = paramContext[0];
    this.iiX = paramContext[1];
    AppMethodBeat.o(37170);
  }
  
  private void j(ImageView paramImageView)
  {
    AppMethodBeat.i(37176);
    if ((paramImageView.getTag() != null) && ((paramImageView.getTag() instanceof String)) && (new BigInteger((String)paramImageView.getTag()).longValue() >= 1L))
    {
      AppMethodBeat.o(37176);
      return;
    }
    paramImageView.setTag("1");
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 0.8F);
    localAlphaAnimation.setDuration(this.rwr);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator(1.2F));
    localAlphaAnimation.setAnimationListener(new o.a.2(this, paramImageView));
    paramImageView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(37176);
  }
  
  public final void Ec(int paramInt)
  {
    AppMethodBeat.i(37177);
    Object localObject = (View)this.rwu.get(String.valueOf(paramInt));
    if (localObject == null)
    {
      AppMethodBeat.o(37177);
      return;
    }
    localObject = (ImageView)((View)localObject).findViewById(2131827876);
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
      j((ImageView)localObject);
    }
    AppMethodBeat.o(37177);
  }
  
  public final void Ed(int paramInt)
  {
    AppMethodBeat.i(37178);
    Iterator localIterator = this.rwv.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Integer)localIterator.next();
      o.a.a locala = (o.a.a)this.rwv.get(localObject);
      if ((locala != null) && (locala.rwC.size() != 0))
      {
        if (((Integer)localObject).intValue() == paramInt)
        {
          i = 0;
          label79:
          if (i < locala.rwC.size())
          {
            localObject = (h)locala.rwC.get(i);
            if (!((h)localObject).cqX()) {
              break label145;
            }
            ((h)localObject).cqA();
            ((h)localObject).cqC();
            this.rww.add(((h)localObject).cqY());
          }
          for (;;)
          {
            i += 1;
            break label79;
            break;
            label145:
            if (this.rww.contains(((h)localObject).cqY()))
            {
              ((h)localObject).cqB();
              this.rww.remove(((h)localObject).cqY());
            }
          }
        }
        int i = 0;
        while (i < locala.rwC.size())
        {
          localObject = (h)locala.rwC.get(i);
          if (this.rww.contains(((h)localObject).cqY()))
          {
            ((h)localObject).cqB();
            this.rww.remove(((h)localObject).cqY());
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(37178);
  }
  
  public final List<h> crm()
  {
    AppMethodBeat.i(37179);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.rwv.values().iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll(((o.a.a)localIterator.next()).rwC);
    }
    AppMethodBeat.o(37179);
    return localArrayList;
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(37174);
    paramViewGroup.removeView((View)paramObject);
    this.rwu.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(37174);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(37171);
    int i = this.rwq.rsu.size();
    AppMethodBeat.o(37171);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(37175);
    Iterator localIterator = this.rwu.keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      if (this.rwu.get(Integer.valueOf(i)) == paramObject)
      {
        AppMethodBeat.o(37175);
        return i;
      }
    }
    AppMethodBeat.o(37175);
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(37173);
    ab.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "instantiateItem %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.rwu.containsKey(Integer.valueOf(paramInt)))
    {
      paramViewGroup = this.rwu.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(37173);
      return paramViewGroup;
    }
    ab.d("MicroMsg.Sns.AdLandingPageGroupListComponent", "inflate Item %d", new Object[] { Integer.valueOf(paramInt) });
    View localView = this.mLayoutInflater.inflate(2130970791, paramViewGroup, false);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131827875);
    localLinearLayout.setBackgroundColor(this.backgroundColor);
    Object localObject2 = (o.a.a)this.rwv.get(Integer.valueOf(paramInt));
    LinkedList localLinkedList = ((m)this.rwq.rsu.get(paramInt)).rsu;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((o.a.a)localObject2).rwC.size() != 0) {}
    }
    else
    {
      localObject1 = new o.a.a(this);
      if (localLinkedList != null)
      {
        int i = 0;
        while (i < localLinkedList.size())
        {
          localObject2 = (t)localLinkedList.get(i);
          ab.i("MicroMsg.Sns.AdLandingPageGroupListComponent", "gen component %s", new Object[] { ((t)localObject2).rsI });
          localObject2 = al.a(this.mContext, (t)localObject2, localLinearLayout, this.backgroundColor);
          ((o.a.a)localObject1).rwC.add(localObject2);
          i += 1;
        }
      }
      this.rwv.put(Integer.valueOf(paramInt), localObject1);
    }
    Object localObject1 = ((o.a.a)localObject1).rwC.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((h)((Iterator)localObject1).next()).getView();
      if ((((View)localObject2).getParent() != null) && ((((View)localObject2).getParent() instanceof ViewGroup))) {
        ((ViewGroup)((View)localObject2).getParent()).removeView((View)localObject2);
      }
      localLinearLayout.addView((View)localObject2);
    }
    localObject1 = (ImageView)localView.findViewById(2131827876);
    localObject2 = (TextView)localView.findViewById(2131827877);
    if (this.backgroundColor + 16777216 <= -1 - this.backgroundColor) {
      ((ImageView)localObject1).setImageDrawable(a.k(this.mContext, 2130839882));
    }
    while (this.rwq.rtk == 1)
    {
      ((ImageView)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localView.setLayoutParams(new RelativeLayout.LayoutParams(this.iiW, localLinearLayout.getMeasuredHeight()));
      localView.setBackgroundColor(this.backgroundColor);
      paramViewGroup.addView(localView);
      paramViewGroup.setBackgroundColor(this.backgroundColor);
      this.rwu.put(Integer.valueOf(paramInt), localView);
      AppMethodBeat.o(37173);
      return localView;
      ((ImageView)localObject1).setImageDrawable(a.k(this.mContext, 2130839885));
    }
    if (paramInt == this.rwq.rsu.size() - 1) {
      ((ImageView)localObject1).setVisibility(8);
    }
    for (;;)
    {
      ((TextView)localObject2).setText(paramInt + 1 + "/" + this.rwq.rsu.size());
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
    AppMethodBeat.i(37172);
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    AppMethodBeat.o(37172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o.a
 * JD-Core Version:    0.7.0.1
 */