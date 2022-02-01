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
import com.tencent.mm.g.b.a.dr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.c;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.l;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class ServiceWidgetView
  implements com.tencent.mm.plugin.websearch.api.f
{
  d CbL;
  private a CbM;
  List<x> CbN;
  b.b CbO;
  MMActivity activity;
  List<WidgetData> dataList;
  ViewPager sO;
  
  public final void a(final int paramInt, l paraml)
  {
    AppMethodBeat.i(116688);
    Object localObject = this.CbM;
    int i = this.sO.getCurrentItem();
    if ((i < 0) || (i >= ((a)localObject).fragments.size())) {}
    for (localObject = null;; localObject = ((MyFragment)((a)localObject).fragments.get(i)).CbQ)
    {
      if ((paraml == localObject) && (paramInt != this.sO.getHeight())) {
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116675);
            ServiceWidgetView localServiceWidgetView = ServiceWidgetView.this;
            int j = paramInt;
            ac.i("ServiceWidgetView", "update viewpager height %d", new Object[] { Integer.valueOf(j) });
            Object localObject = (WidgetData)localServiceWidgetView.dataList.get(localServiceWidgetView.sO.getCurrentItem());
            int i = j;
            if (localObject != null)
            {
              i = j;
              if (!((WidgetData)localObject).BZS.rVS) {
                i = j - a.fromDPToPix(localServiceWidgetView.activity.getContext(), 46);
              }
            }
            localObject = (LinearLayout.LayoutParams)localServiceWidgetView.sO.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).height = i;
            localServiceWidgetView.sO.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(116675);
          }
        });
      }
      AppMethodBeat.o(116688);
      return;
    }
  }
  
  public final void exe()
  {
    AppMethodBeat.i(116686);
    int j = this.sO.getCurrentItem() + 1;
    int i = this.sO.getCurrentItem();
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
      localObject2 = new dr().lG(((WidgetData)localObject1).BZS.hsk).lH(((WidgetData)localObject1).BZS.hsk);
      ((dr)localObject2).dSA = 0L;
      ((dr)localObject2).lE(((WidgetData)localObject1).query).lF(((WidgetData)localObject1).BZV).aHZ();
      AppMethodBeat.o(116686);
      return;
    }
    ac.i("ServiceWidgetView", "switch widget to %d", new Object[] { Integer.valueOf(j) });
    Object localObject2 = (WidgetData)this.dataList.get(j);
    localObject1 = new dr().lG(((WidgetData)localObject1).BZS.hsk).lH(((WidgetData)localObject2).BZS.hsk);
    ((dr)localObject1).dSA = 1L;
    ((dr)localObject1).lE(((WidgetData)localObject2).query).lF(((WidgetData)localObject2).BZV).aHZ();
    this.sO.setCurrentItem(j, true);
    i = 0;
    if (i < this.CbN.size())
    {
      localObject1 = (x)this.CbN.get(i);
      if (i == j) {}
      for (((x)localObject1).isSelected = true;; ((x)localObject1).isSelected = false)
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(116686);
  }
  
  public final void exf()
  {
    AppMethodBeat.i(116687);
    this.sO.setCurrentItem(this.sO.getCurrentItem() - 1);
    AppMethodBeat.o(116687);
  }
  
  public static class MyFragment
    extends Fragment
  {
    b CbQ;
    
    public MyFragment()
    {
      AppMethodBeat.i(116676);
      this.CbQ = new b();
      AppMethodBeat.o(116676);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(116677);
      ac.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
      paramLayoutInflater = this.CbQ;
      paramLayoutInflater.fWU = paramViewGroup;
      if (paramLayoutInflater.CbU == null)
      {
        if (paramLayoutInflater.view == null)
        {
          paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.activity.getContext()).inflate(2131495374, paramLayoutInflater.fWU, false);
          paramLayoutInflater.CbT = ((LinearLayout)paramLayoutInflater.view.findViewById(2131298736));
          paramLayoutInflater.rKi = paramLayoutInflater.view.findViewById(2131300199);
          paramLayoutInflater.CbS = paramLayoutInflater.view.findViewById(2131303975);
          paramLayoutInflater.CbZ = ((LinearLayout)paramLayoutInflater.view.findViewById(2131305580));
          paramLayoutInflater.Cca = ((MoreFooter)paramLayoutInflater.view.findViewById(2131302468));
          paramLayoutInflater.wGo = ((TextView)paramLayoutInflater.view.findViewById(2131300734));
          paramLayoutInflater.CbX = paramLayoutInflater.view.findViewById(2131306992);
          paramLayoutInflater.Cci = paramLayoutInflater.view.findViewById(2131301493);
          paramLayoutInflater.Cch = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(2131301514));
          paramLayoutInflater.Ccj = paramLayoutInflater.view.findViewById(2131299752);
          paramLayoutInflater.CbS.setVisibility(8);
          paramLayoutInflater.CbT.setVisibility(8);
          paramLayoutInflater.CbS.setVisibility(8);
          paramLayoutInflater.CbT.setVisibility(8);
          paramLayoutInflater.Cci.setVisibility(0);
          paramLayoutInflater.Cch.fuW();
          if (paramLayoutInflater.CbU != null) {
            paramLayoutInflater.CbU.aAq(paramLayoutInflater.CbV);
          }
          paramLayoutInflater.view.findViewById(2131303974).setOnClickListener(new b.4(paramLayoutInflater));
          paramLayoutInflater.view.findViewById(2131303973).setOnClickListener(new b.5(paramLayoutInflater));
          paramLayoutInflater.CbT.setOnTouchListener(new b.6(paramLayoutInflater));
          paramLayoutInflater.CbT.setOnClickListener(new b.7(paramLayoutInflater));
          paramLayoutInflater.Cca.setOnClickLsn(paramLayoutInflater.Ccl);
          paramLayoutInflater.wGo.setOnLongClickListener(new b.8(paramLayoutInflater));
        }
        paramLayoutInflater.CbU = ((e)g.ab(e.class)).a(paramLayoutInflater.fWU.getContext(), new b.3(paramLayoutInflater));
        paramLayoutInflater.CbU.exc();
      }
      paramLayoutInflater.cL();
      if (paramLayoutInflater.isSelected) {
        paramLayoutInflater.eyd();
      }
      paramLayoutInflater = this.CbQ.view;
      AppMethodBeat.o(116677);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(116680);
      super.onDestroy();
      if ((this.CbQ != null) && (this.CbQ.Ccf != null))
      {
        b localb = this.CbQ;
        if (localb.CbU != null)
        {
          localb.CbU.aAq(localb.CbV);
          localb.CbU.onDestroy();
          localb.Ccf = null;
          localb.CbV = null;
          localb.activity = null;
        }
      }
      AppMethodBeat.o(116680);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(116679);
      super.onPause();
      if ((this.CbQ != null) && (this.CbQ.Ccf != null))
      {
        b localb = this.CbQ;
        if (localb.isSelected)
        {
          if (localb.CbU != null) {
            localb.CbU.onPause();
          }
          localb.tdc = false;
          ac.v("WidgetView", "%s paused", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116679);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(116678);
      super.onResume();
      if ((this.CbQ != null) && (this.CbQ.Ccf != null))
      {
        b localb = this.CbQ;
        if (localb.isSelected)
        {
          localb.CbU.onResume();
          localb.eyc();
          ac.v("WidgetView", "%s resume", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116678);
    }
  }
  
  final class a
    extends i
  {
    List<ServiceWidgetView.MyFragment> fragments;
    List<WidgetData> oAg;
    
    public final int getCount()
    {
      AppMethodBeat.i(116685);
      if (this.oAg == null)
      {
        AppMethodBeat.o(116685);
        return 0;
      }
      int i = this.oAg.size();
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
        ((Bundle)localObject).putParcelable("data", (Parcelable)this.oAg.get(paramInt));
        localMyFragment.setArguments((Bundle)localObject);
        this.fragments.add(localMyFragment);
        localObject = localMyFragment.CbQ;
        MMActivity localMMActivity = this.CbP.activity;
        ServiceWidgetView localServiceWidgetView = this.CbP;
        b.b localb = this.CbP.CbO;
        b.a local1 = new b.a()
        {
          public final int exZ()
          {
            AppMethodBeat.i(116681);
            if (ServiceWidgetView.a.this.oAg == null)
            {
              AppMethodBeat.o(116681);
              return 0;
            }
            int i = ServiceWidgetView.a.this.oAg.size();
            AppMethodBeat.o(116681);
            return i;
          }
          
          public final List<x> eya()
          {
            return ServiceWidgetView.a.this.CbP.CbN;
          }
          
          public final boolean eyb()
          {
            return paramInt > 0;
          }
          
          public final boolean hasNext()
          {
            AppMethodBeat.i(116682);
            if (paramInt < ServiceWidgetView.a.this.oAg.size() - 1)
            {
              AppMethodBeat.o(116682);
              return true;
            }
            AppMethodBeat.o(116682);
            return false;
          }
        };
        d locald = this.CbP.CbL;
        WidgetData localWidgetData = (WidgetData)this.oAg.get(paramInt);
        ((b)localObject).activity = localMMActivity;
        ((b)localObject).Ccd = localServiceWidgetView;
        ((b)localObject).CbO = localb;
        ((b)localObject).Cce = local1;
        ((b)localObject).CbL = locald;
        ((b)localObject).Ccf = localWidgetData;
        if (paramInt != this.CbP.sO.getCurrentItem()) {
          break label240;
        }
        ServiceWidgetView.MyFragment.a(localMyFragment).setSelected(true);
      }
      for (;;)
      {
        ac.i("ServiceWidgetView", "getItem %s, fragment %s", new Object[] { Integer.valueOf(paramInt), localMyFragment.toString() });
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
      paramObject = ((ServiceWidgetView.MyFragment)paramObject).CbQ;
      if (paramObject != null)
      {
        int i = this.oAg.indexOf(paramObject.Ccf);
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