package com.tencent.mm.plugin.websearch.widget.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class ServiceWidgetView
  implements com.tencent.mm.plugin.websearch.api.f
{
  d AJu;
  private a AJv;
  List<y> AJw;
  b.b AJx;
  MMActivity activity;
  List<WidgetData> dataList;
  ViewPager rN;
  
  public final void a(final int paramInt, m paramm)
  {
    AppMethodBeat.i(116688);
    Object localObject = this.AJv;
    int i = this.rN.getCurrentItem();
    if ((i < 0) || (i >= ((a)localObject).fragments.size())) {}
    for (localObject = null;; localObject = ((MyFragment)((a)localObject).fragments.get(i)).AJz)
    {
      if ((paramm == localObject) && (paramInt != this.rN.getHeight())) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116675);
            ServiceWidgetView localServiceWidgetView = ServiceWidgetView.this;
            int j = paramInt;
            ad.i("ServiceWidgetView", "update viewpager height %d", new Object[] { Integer.valueOf(j) });
            Object localObject = (WidgetData)localServiceWidgetView.dataList.get(localServiceWidgetView.rN.getCurrentItem());
            int i = j;
            if (localObject != null)
            {
              i = j;
              if (!((WidgetData)localObject).AHB.qVF) {
                i = j - a.fromDPToPix(localServiceWidgetView.activity.getContext(), 46);
              }
            }
            localObject = (LinearLayout.LayoutParams)localServiceWidgetView.rN.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).height = i;
            localServiceWidgetView.rN.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(116675);
          }
        });
      }
      AppMethodBeat.o(116688);
      return;
    }
  }
  
  public final void ehK()
  {
    AppMethodBeat.i(116686);
    int j = this.rN.getCurrentItem() + 1;
    int i = this.rN.getCurrentItem();
    Object localObject1 = (WidgetData)this.dataList.get(i);
    if ((j < 0) || (j > this.dataList.size() - 1))
    {
      com.tencent.mm.plugin.websearch.widget.f.a(3, (WidgetData)localObject1, null);
      AppMethodBeat.o(116686);
      return;
    }
    com.tencent.mm.plugin.websearch.widget.f.a(2, (WidgetData)localObject1, (WidgetData)this.dataList.get(j));
    if (j == this.dataList.indexOf(localObject1))
    {
      localObject2 = new cd().iQ(((WidgetData)localObject1).AHB.gRK).iR(((WidgetData)localObject1).AHB.gRK);
      ((cd)localObject2).dQL = 0L;
      ((cd)localObject2).iO(((WidgetData)localObject1).query).iP(((WidgetData)localObject1).AHE).aBj();
      AppMethodBeat.o(116686);
      return;
    }
    ad.i("ServiceWidgetView", "switch widget to %d", new Object[] { Integer.valueOf(j) });
    Object localObject2 = (WidgetData)this.dataList.get(j);
    localObject1 = new cd().iQ(((WidgetData)localObject1).AHB.gRK).iR(((WidgetData)localObject2).AHB.gRK);
    ((cd)localObject1).dQL = 1L;
    ((cd)localObject1).iO(((WidgetData)localObject2).query).iP(((WidgetData)localObject2).AHE).aBj();
    this.rN.setCurrentItem(j, true);
    i = 0;
    if (i < this.AJw.size())
    {
      localObject1 = (y)this.AJw.get(i);
      if (i == j) {}
      for (((y)localObject1).ira = true;; ((y)localObject1).ira = false)
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(116686);
  }
  
  public final void ehL()
  {
    AppMethodBeat.i(116687);
    this.rN.setCurrentItem(this.rN.getCurrentItem() - 1);
    AppMethodBeat.o(116687);
  }
  
  public static class MyFragment
    extends Fragment
  {
    b AJz;
    
    public MyFragment()
    {
      AppMethodBeat.i(116676);
      this.AJz = new b();
      AppMethodBeat.o(116676);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(116677);
      ad.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
      paramLayoutInflater = this.AJz;
      paramLayoutInflater.fSZ = paramViewGroup;
      if (paramLayoutInflater.AJD == null)
      {
        if (paramLayoutInflater.view == null)
        {
          paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.activity.getContext()).inflate(2131495374, paramLayoutInflater.fSZ, false);
          paramLayoutInflater.AJC = ((LinearLayout)paramLayoutInflater.view.findViewById(2131298736));
          paramLayoutInflater.qOZ = paramLayoutInflater.view.findViewById(2131300199);
          paramLayoutInflater.AJB = paramLayoutInflater.view.findViewById(2131303975);
          paramLayoutInflater.AJI = ((LinearLayout)paramLayoutInflater.view.findViewById(2131305580));
          paramLayoutInflater.AJJ = ((MoreFooter)paramLayoutInflater.view.findViewById(2131302468));
          paramLayoutInflater.vwj = ((TextView)paramLayoutInflater.view.findViewById(2131300734));
          paramLayoutInflater.AJG = paramLayoutInflater.view.findViewById(2131306992);
          paramLayoutInflater.AJR = paramLayoutInflater.view.findViewById(2131301493);
          paramLayoutInflater.AJQ = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(2131301514));
          paramLayoutInflater.AJS = paramLayoutInflater.view.findViewById(2131299752);
          paramLayoutInflater.AJB.setVisibility(8);
          paramLayoutInflater.AJC.setVisibility(8);
          paramLayoutInflater.AJB.setVisibility(8);
          paramLayoutInflater.AJC.setVisibility(8);
          paramLayoutInflater.AJR.setVisibility(0);
          paramLayoutInflater.AJQ.ffb();
          if (paramLayoutInflater.AJD != null) {
            paramLayoutInflater.AJD.auZ(paramLayoutInflater.AJE);
          }
          paramLayoutInflater.view.findViewById(2131303974).setOnClickListener(new b.4(paramLayoutInflater));
          paramLayoutInflater.view.findViewById(2131303973).setOnClickListener(new b.5(paramLayoutInflater));
          paramLayoutInflater.AJC.setOnTouchListener(new b.6(paramLayoutInflater));
          paramLayoutInflater.AJC.setOnClickListener(new b.7(paramLayoutInflater));
          paramLayoutInflater.AJJ.setOnClickLsn(paramLayoutInflater.AJU);
          paramLayoutInflater.vwj.setOnLongClickListener(new b.8(paramLayoutInflater));
        }
        paramLayoutInflater.AJD = ((e)g.ab(e.class)).a(paramLayoutInflater.fSZ.getContext(), new b.3(paramLayoutInflater));
        paramLayoutInflater.AJD.ehI();
      }
      paramLayoutInflater.cE();
      if (paramLayoutInflater.ira) {
        paramLayoutInflater.eiJ();
      }
      paramLayoutInflater = this.AJz.view;
      AppMethodBeat.o(116677);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(116680);
      super.onDestroy();
      if ((this.AJz != null) && (this.AJz.AJO != null))
      {
        b localb = this.AJz;
        if (localb.AJD != null)
        {
          localb.AJD.auZ(localb.AJE);
          localb.AJD.onDestroy();
          localb.AJO = null;
          localb.AJE = null;
          localb.activity = null;
        }
      }
      AppMethodBeat.o(116680);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(116679);
      super.onPause();
      if ((this.AJz != null) && (this.AJz.AJO != null))
      {
        b localb = this.AJz;
        if (localb.ira)
        {
          if (localb.AJD != null) {
            localb.AJD.onPause();
          }
          localb.rVk = false;
          ad.v("WidgetView", "%s paused", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116679);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(116678);
      super.onResume();
      if ((this.AJz != null) && (this.AJz.AJO != null))
      {
        b localb = this.AJz;
        if (localb.ira)
        {
          localb.AJD.onResume();
          localb.eiI();
          ad.v("WidgetView", "%s resume", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116678);
    }
  }
  
  final class a
    extends i
  {
    List<ServiceWidgetView.MyFragment> fragments;
    List<WidgetData> nWL;
    
    public final int getCount()
    {
      AppMethodBeat.i(116685);
      if (this.nWL == null)
      {
        AppMethodBeat.o(116685);
        return 0;
      }
      int i = this.nWL.size();
      AppMethodBeat.o(116685);
      return i;
    }
    
    public final Fragment getItem(final int paramInt)
    {
      AppMethodBeat.i(116684);
      ServiceWidgetView.MyFragment localMyFragment;
      if (paramInt >= this.fragments.size())
      {
        localMyFragment = new ServiceWidgetView.MyFragment();
        Object localObject = new Bundle();
        ((Bundle)localObject).putParcelable("data", (Parcelable)this.nWL.get(paramInt));
        localMyFragment.setArguments((Bundle)localObject);
        this.fragments.add(localMyFragment);
        localObject = localMyFragment.AJz;
        MMActivity localMMActivity = this.AJy.activity;
        ServiceWidgetView localServiceWidgetView = this.AJy;
        b.b localb = this.AJy.AJx;
        b.a local1 = new b.a()
        {
          public final int eiF()
          {
            AppMethodBeat.i(116681);
            if (ServiceWidgetView.a.this.nWL == null)
            {
              AppMethodBeat.o(116681);
              return 0;
            }
            int i = ServiceWidgetView.a.this.nWL.size();
            AppMethodBeat.o(116681);
            return i;
          }
          
          public final List<y> eiG()
          {
            return ServiceWidgetView.a.this.AJy.AJw;
          }
          
          public final boolean eiH()
          {
            return paramInt > 0;
          }
          
          public final boolean hasNext()
          {
            AppMethodBeat.i(116682);
            if (paramInt < ServiceWidgetView.a.this.nWL.size() - 1)
            {
              AppMethodBeat.o(116682);
              return true;
            }
            AppMethodBeat.o(116682);
            return false;
          }
        };
        d locald = this.AJy.AJu;
        WidgetData localWidgetData = (WidgetData)this.nWL.get(paramInt);
        ((b)localObject).activity = localMMActivity;
        ((b)localObject).AJM = localServiceWidgetView;
        ((b)localObject).AJx = localb;
        ((b)localObject).AJN = local1;
        ((b)localObject).AJu = locald;
        ((b)localObject).AJO = localWidgetData;
        if (paramInt != this.AJy.rN.getCurrentItem()) {
          break label240;
        }
        ServiceWidgetView.MyFragment.a(localMyFragment).setSelected(true);
      }
      for (;;)
      {
        ad.i("ServiceWidgetView", "getItem %s, fragment %s", new Object[] { Integer.valueOf(paramInt), localMyFragment.toString() });
        AppMethodBeat.o(116684);
        return localMyFragment;
        localMyFragment = (ServiceWidgetView.MyFragment)this.fragments.get(paramInt);
        break;
        label240:
        ServiceWidgetView.MyFragment.a(localMyFragment).setSelected(false);
      }
    }
    
    public final int getItemPosition(Object paramObject)
    {
      AppMethodBeat.i(116683);
      paramObject = ((ServiceWidgetView.MyFragment)paramObject).AJz;
      if (paramObject != null)
      {
        int i = this.nWL.indexOf(paramObject.AJO);
        if (i >= 0)
        {
          AppMethodBeat.o(116683);
          return i;
        }
        AppMethodBeat.o(116683);
        return -2;
      }
      AppMethodBeat.o(116683);
      return -2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView
 * JD-Core Version:    0.7.0.1
 */