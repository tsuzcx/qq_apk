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
import com.tencent.mm.cc.a;
import com.tencent.mm.g.b.a.em;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class ServiceWidgetView
  implements com.tencent.mm.plugin.websearch.api.g
{
  e DEJ;
  private a DEK;
  List<ab> DEL;
  b.b DEM;
  MMActivity activity;
  List<WidgetData> dataList;
  ViewPager uH;
  
  public final void a(final int paramInt, m paramm)
  {
    AppMethodBeat.i(116688);
    Object localObject = this.DEK;
    int i = this.uH.getCurrentItem();
    if ((i < 0) || (i >= ((a)localObject).fragments.size())) {}
    for (localObject = null;; localObject = ((MyFragment)((a)localObject).fragments.get(i)).DEO)
    {
      if ((paramm == localObject) && (paramInt != this.uH.getHeight())) {
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116675);
            ServiceWidgetView localServiceWidgetView = ServiceWidgetView.this;
            int j = paramInt;
            ad.i("ServiceWidgetView", "update viewpager height %d", new Object[] { Integer.valueOf(j) });
            Object localObject = (WidgetData)localServiceWidgetView.dataList.get(localServiceWidgetView.uH.getCurrentItem());
            int i = j;
            if (localObject != null)
            {
              i = j;
              if (!((WidgetData)localObject).DCO.sSB) {
                i = j - a.fromDPToPix(localServiceWidgetView.activity.getContext(), 46);
              }
            }
            localObject = (LinearLayout.LayoutParams)localServiceWidgetView.uH.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).height = i;
            localServiceWidgetView.uH.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(116675);
          }
        });
      }
      AppMethodBeat.o(116688);
      return;
    }
  }
  
  public final void eLS()
  {
    AppMethodBeat.i(116686);
    int j = this.uH.getCurrentItem() + 1;
    int i = this.uH.getCurrentItem();
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
      localObject2 = new em().nO(((WidgetData)localObject1).DCO.hKC).nP(((WidgetData)localObject1).DCO.hKC);
      ((em)localObject2).eig = 0L;
      ((em)localObject2).nM(((WidgetData)localObject1).query).nN(((WidgetData)localObject1).dDE).aLk();
      AppMethodBeat.o(116686);
      return;
    }
    ad.i("ServiceWidgetView", "switch widget to %d", new Object[] { Integer.valueOf(j) });
    Object localObject2 = (WidgetData)this.dataList.get(j);
    localObject1 = new em().nO(((WidgetData)localObject1).DCO.hKC).nP(((WidgetData)localObject2).DCO.hKC);
    ((em)localObject1).eig = 1L;
    ((em)localObject1).nM(((WidgetData)localObject2).query).nN(((WidgetData)localObject2).dDE).aLk();
    this.uH.setCurrentItem(j, true);
    i = 0;
    if (i < this.DEL.size())
    {
      localObject1 = (ab)this.DEL.get(i);
      if (i == j) {}
      for (((ab)localObject1).isSelected = true;; ((ab)localObject1).isSelected = false)
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(116686);
  }
  
  public final void eLT()
  {
    AppMethodBeat.i(116687);
    this.uH.setCurrentItem(this.uH.getCurrentItem() - 1);
    AppMethodBeat.o(116687);
  }
  
  public static class MyFragment
    extends Fragment
  {
    b DEO;
    
    public MyFragment()
    {
      AppMethodBeat.i(116676);
      this.DEO = new b();
      AppMethodBeat.o(116676);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(116677);
      ad.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
      paramLayoutInflater = this.DEO;
      paramLayoutInflater.gqv = paramViewGroup;
      if (paramLayoutInflater.DES == null)
      {
        if (paramLayoutInflater.view == null)
        {
          paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.activity.getContext()).inflate(2131495374, paramLayoutInflater.gqv, false);
          paramLayoutInflater.DER = ((LinearLayout)paramLayoutInflater.view.findViewById(2131298736));
          paramLayoutInflater.sFi = paramLayoutInflater.view.findViewById(2131300199);
          paramLayoutInflater.DEQ = paramLayoutInflater.view.findViewById(2131303975);
          paramLayoutInflater.DEY = ((LinearLayout)paramLayoutInflater.view.findViewById(2131305580));
          paramLayoutInflater.DEZ = ((MoreFooter)paramLayoutInflater.view.findViewById(2131302468));
          paramLayoutInflater.xTV = ((TextView)paramLayoutInflater.view.findViewById(2131300734));
          paramLayoutInflater.DEW = paramLayoutInflater.view.findViewById(2131306992);
          paramLayoutInflater.DFh = paramLayoutInflater.view.findViewById(2131301493);
          paramLayoutInflater.DFg = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(2131301514));
          paramLayoutInflater.DFi = paramLayoutInflater.view.findViewById(2131299752);
          paramLayoutInflater.DEQ.setVisibility(8);
          paramLayoutInflater.DER.setVisibility(8);
          paramLayoutInflater.DEQ.setVisibility(8);
          paramLayoutInflater.DER.setVisibility(8);
          paramLayoutInflater.DFh.setVisibility(0);
          paramLayoutInflater.DFg.fLJ();
          if (paramLayoutInflater.DES != null) {
            paramLayoutInflater.DES.aFK(paramLayoutInflater.DET);
          }
          paramLayoutInflater.view.findViewById(2131303974).setOnClickListener(new b.4(paramLayoutInflater));
          paramLayoutInflater.view.findViewById(2131303973).setOnClickListener(new b.5(paramLayoutInflater));
          paramLayoutInflater.DER.setOnTouchListener(new b.6(paramLayoutInflater));
          paramLayoutInflater.DER.setOnClickListener(new b.7(paramLayoutInflater));
          paramLayoutInflater.DEZ.setOnClickLsn(paramLayoutInflater.DFk);
          paramLayoutInflater.xTV.setOnLongClickListener(new b.8(paramLayoutInflater));
        }
        paramLayoutInflater.DES = ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(paramLayoutInflater.gqv.getContext(), new b.3(paramLayoutInflater));
        paramLayoutInflater.DES.eLQ();
      }
      paramLayoutInflater.updateView();
      if (paramLayoutInflater.isSelected) {
        paramLayoutInflater.eMU();
      }
      paramLayoutInflater = this.DEO.view;
      AppMethodBeat.o(116677);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(116680);
      super.onDestroy();
      if ((this.DEO != null) && (this.DEO.DFe != null))
      {
        b localb = this.DEO;
        if (localb.DES != null)
        {
          localb.DES.aFK(localb.DET);
          localb.DES.onDestroy();
          localb.DFe = null;
          localb.DET = null;
          localb.activity = null;
        }
      }
      AppMethodBeat.o(116680);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(116679);
      super.onPause();
      if ((this.DEO != null) && (this.DEO.DFe != null))
      {
        b localb = this.DEO;
        if (localb.isSelected)
        {
          if (localb.DES != null) {
            localb.DES.onPause();
          }
          localb.uaS = false;
          ad.v("WidgetView", "%s paused", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116679);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(116678);
      super.onResume();
      if ((this.DEO != null) && (this.DEO.DFe != null))
      {
        b localb = this.DEO;
        if (localb.isSelected)
        {
          localb.DES.onResume();
          localb.eMT();
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
    List<WidgetData> pdB;
    
    public final int getCount()
    {
      AppMethodBeat.i(116685);
      if (this.pdB == null)
      {
        AppMethodBeat.o(116685);
        return 0;
      }
      int i = this.pdB.size();
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
        ((Bundle)localObject).putParcelable("data", (Parcelable)this.pdB.get(paramInt));
        localMyFragment.setArguments((Bundle)localObject);
        this.fragments.add(localMyFragment);
        localObject = localMyFragment.DEO;
        MMActivity localMMActivity = this.DEN.activity;
        ServiceWidgetView localServiceWidgetView = this.DEN;
        b.b localb = this.DEN.DEM;
        b.a local1 = new b.a()
        {
          public final int eMQ()
          {
            AppMethodBeat.i(116681);
            if (ServiceWidgetView.a.this.pdB == null)
            {
              AppMethodBeat.o(116681);
              return 0;
            }
            int i = ServiceWidgetView.a.this.pdB.size();
            AppMethodBeat.o(116681);
            return i;
          }
          
          public final List<ab> eMR()
          {
            return ServiceWidgetView.a.this.DEN.DEL;
          }
          
          public final boolean eMS()
          {
            return paramInt > 0;
          }
          
          public final boolean hasNext()
          {
            AppMethodBeat.i(116682);
            if (paramInt < ServiceWidgetView.a.this.pdB.size() - 1)
            {
              AppMethodBeat.o(116682);
              return true;
            }
            AppMethodBeat.o(116682);
            return false;
          }
        };
        e locale = this.DEN.DEJ;
        WidgetData localWidgetData = (WidgetData)this.pdB.get(paramInt);
        ((b)localObject).activity = localMMActivity;
        ((b)localObject).DFc = localServiceWidgetView;
        ((b)localObject).DEM = localb;
        ((b)localObject).DFd = local1;
        ((b)localObject).DEJ = locale;
        ((b)localObject).DFe = localWidgetData;
        if (paramInt != this.DEN.uH.getCurrentItem()) {
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
      paramObject = ((ServiceWidgetView.MyFragment)paramObject).DEO;
      if (paramObject != null)
      {
        int i = this.pdB.indexOf(paramObject.DFe);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView
 * JD-Core Version:    0.7.0.1
 */