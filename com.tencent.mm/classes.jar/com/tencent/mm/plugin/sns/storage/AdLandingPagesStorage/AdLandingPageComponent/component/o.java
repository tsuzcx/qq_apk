package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingControlView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class o
  extends a
{
  private static final Map<String, Bitmap> rwi;
  ViewPager rwj;
  o.a rwk;
  AdLandingControlView rwl;
  private int rwm;
  private int rwn;
  
  static
  {
    AppMethodBeat.i(37191);
    rwi = new WeakHashMap();
    AppMethodBeat.o(37191);
  }
  
  public o(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    AppMethodBeat.i(37181);
    this.rwm = 0;
    this.rwn = 0;
    this.rwl = new AdLandingControlView(paramContext);
    AppMethodBeat.o(37181);
  }
  
  public final void ae(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(37185);
    super.ae(paramMap);
    if (paramMap.containsKey("startIndex")) {
      try
      {
        this.rwm = ((Integer)paramMap.get("startIndex")).intValue();
        this.rwj.setCurrentItem(this.rwm, false);
        AppMethodBeat.o(37185);
        return;
      }
      catch (Exception paramMap) {}
    }
    AppMethodBeat.o(37185);
  }
  
  public final boolean aq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(37189);
    if (!super.aq(paramJSONObject))
    {
      AppMethodBeat.o(37189);
      return false;
    }
    AppMethodBeat.o(37189);
    return true;
  }
  
  public final void cqA()
  {
    AppMethodBeat.i(37182);
    this.rwk.Ec(this.rwn);
    this.rwk.Ed(this.rwn);
    super.cqA();
    AppMethodBeat.o(37182);
  }
  
  public final void cqB()
  {
    AppMethodBeat.i(37183);
    this.rwk.Ed(-1);
    super.cqB();
    AppMethodBeat.o(37183);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37188);
    View localView = this.contentView;
    this.rwj = ((ViewPager)localView.findViewById(2131827878));
    this.rwl = ((AdLandingControlView)localView.findViewById(2131827879));
    AppMethodBeat.o(37188);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37187);
    int k = this.iiW - (int)((z)this.rve).paddingLeft - (int)((z)this.rve).paddingRight;
    int m = this.iiX;
    Object localObject1 = (LayoutInflater)this.context.getSystemService("layout_inflater");
    o.a locala;
    if (this.rwj.getAdapter() == null)
    {
      locala = new o.a(this.context, (LayoutInflater)localObject1, (z)this.rve, this.backgroundColor);
      this.rwj.setOnPageChangeListener(new o.1(this, locala));
      this.rwj.setAdapter(locala);
      this.rwl.hy(((z)this.rve).rsu.size(), 0);
      if (!((z)this.rve).jew) {
        break label213;
      }
      this.rwj.setLayoutParams(new RelativeLayout.LayoutParams(k, m));
    }
    label213:
    while (((z)this.rve).rsu.size() <= 0)
    {
      this.rwk = locala;
      locala.notifyDataSetChanged();
      AppMethodBeat.o(37187);
      return;
      locala = (o.a)this.rwj.getAdapter();
      locala.rwq = ((z)this.rve);
      break;
    }
    Object localObject2 = (m)((z)this.rve).rsu.get(0);
    new LinearLayout(this.context).setOrientation(1);
    int i = 0;
    localObject2 = ((m)localObject2).rsu.iterator();
    label276:
    t localt;
    int j;
    w localw;
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localt = (t)((Iterator)localObject2).next();
      j = (int)(i + localt.paddingTop);
      if ((localt instanceof w))
      {
        localw = (w)localt;
        localObject4 = ((LayoutInflater)localObject1).inflate(2130970790, null);
        ((View)localObject4).setBackgroundColor(this.backgroundColor);
        i = j;
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = (TextView)((View)localObject4).findViewById(2131827874);
        i = j;
        ((TextView)localObject4).setText(localw.rta);
        i = j;
        if (localw.textSize > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setTextSize(0, localw.textSize);
        }
        i = j;
        if (localw.rte > 0.0F)
        {
          i = j;
          ((TextView)localObject4).setLineSpacing(0.0F, localw.rte + 1.0F);
        }
        i = j;
        if (localw.rtb)
        {
          i = j;
          ((TextView)localObject4).getPaint().setFakeBoldText(true);
        }
        i = j;
        ((TextView)localObject4).measure(View.MeasureSpec.makeMeasureSpec((int)(k - localw.paddingLeft - localw.paddingRight), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
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
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.Sns.AdLandingPageGroupListComponent", "txtComp measure exp=" + localException.toString());
        continue;
      }
      float f1 = i;
      i = (int)(localt.paddingBottom + f1);
      break label276;
      Object localObject3;
      if ((localt instanceof l))
      {
        localObject3 = (Button)((LayoutInflater)localObject1).inflate(2130970779, null).findViewById(2131827851);
        ((Button)localObject3).setText(((l)localt).title);
        ((Button)localObject3).measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = ((Button)localObject3).getPaddingTop() + j;
        if ((localt.rsL > 0.0F) && ((int)localt.rsL != 2147483647)) {
          i = (int)(i + localt.rsL);
        }
        for (;;)
        {
          i = ((Button)localObject3).getPaddingBottom() + i;
          break;
          if ((localt.height > 0.0F) && ((int)localt.height != 2147483647)) {
            i = (int)(i + localt.height);
          } else {
            i += ((Button)localObject3).getMeasuredHeight();
          }
        }
      }
      if ((localt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o))
      {
        float f2 = 0.0F;
        f1 = 0.0F;
        float f3 = localt.paddingTop;
        float f4 = localt.paddingBottom;
        if ((localt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o))
        {
          localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localt;
          f2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject3).height;
          f1 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)localObject3).width;
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
      if ((localt instanceof n))
      {
        i = j + m;
      }
      else if ((localt instanceof q))
      {
        localObject3 = (q)localt;
        if (((q)localObject3).rsF == 1)
        {
          i = j + m;
        }
        else if ((int)((q)localObject3).width > 0)
        {
          i = (int)((q)localObject3).height * k / (int)((q)localObject3).width + j;
        }
        else
        {
          f1 = j;
          i = (int)(((q)localObject3).height + f1);
        }
      }
      else if ((localt instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab))
      {
        localObject3 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localt;
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject3).rtm == 1)
        {
          if ((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject3).width > 0)
          {
            i = (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject3).height * k / (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject3).width + j;
          }
          else
          {
            f1 = j;
            i = (int)(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ab)localObject3).height + f1);
          }
        }
        else {
          i = j + m;
        }
      }
      else
      {
        if ((localt instanceof aa))
        {
          i = j + m;
          continue;
          localObject1 = new RelativeLayout.LayoutParams(k, i);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = ((int)((z)this.rve).paddingLeft);
          ((RelativeLayout.LayoutParams)localObject1).rightMargin = ((int)((z)this.rve).paddingRight);
          this.rwj.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          break;
        }
        i = j;
      }
    }
  }
  
  public final void cqS()
  {
    AppMethodBeat.i(37184);
    this.rwk.Ed(this.rwn);
    AppMethodBeat.o(37184);
  }
  
  public final List<h> cqT()
  {
    AppMethodBeat.i(37190);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((o.a)this.rwj.getAdapter()).crm());
    AppMethodBeat.o(37190);
    return localArrayList;
  }
  
  public final void cra()
  {
    AppMethodBeat.i(37186);
    super.cra();
    this.rwj.setCurrentItem(this.rwm, false);
    AppMethodBeat.o(37186);
  }
  
  protected final int getLayout()
  {
    return 2130970792;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */