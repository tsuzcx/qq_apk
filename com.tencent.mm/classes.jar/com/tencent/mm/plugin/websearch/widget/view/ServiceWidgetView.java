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
import com.tencent.mm.cb.a;
import com.tencent.mm.g.b.a.eo;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class ServiceWidgetView
  implements com.tencent.mm.plugin.websearch.api.g
{
  e DWH;
  private a DWI;
  List<ab> DWJ;
  b.b DWK;
  MMActivity activity;
  List<WidgetData> dataList;
  ViewPager uH;
  
  public final void a(final int paramInt, m paramm)
  {
    AppMethodBeat.i(116688);
    Object localObject = this.DWI;
    int i = this.uH.getCurrentItem();
    if ((i < 0) || (i >= ((a)localObject).fragments.size())) {}
    for (localObject = null;; localObject = ((MyFragment)((a)localObject).fragments.get(i)).DWM)
    {
      if ((paramm == localObject) && (paramInt != this.uH.getHeight())) {
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116675);
            ServiceWidgetView localServiceWidgetView = ServiceWidgetView.this;
            int j = paramInt;
            ae.i("ServiceWidgetView", "update viewpager height %d", new Object[] { Integer.valueOf(j) });
            Object localObject = (WidgetData)localServiceWidgetView.dataList.get(localServiceWidgetView.uH.getCurrentItem());
            int i = j;
            if (localObject != null)
            {
              i = j;
              if (!((WidgetData)localObject).DUM.tdN) {
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
  
  public final void ePB()
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
      localObject2 = new eo().oj(((WidgetData)localObject1).DUM.hNv).ok(((WidgetData)localObject1).DUM.hNv);
      ((eo)localObject2).ejQ = 0L;
      ((eo)localObject2).oh(((WidgetData)localObject1).query).oi(((WidgetData)localObject1).dEJ).aLH();
      AppMethodBeat.o(116686);
      return;
    }
    ae.i("ServiceWidgetView", "switch widget to %d", new Object[] { Integer.valueOf(j) });
    Object localObject2 = (WidgetData)this.dataList.get(j);
    localObject1 = new eo().oj(((WidgetData)localObject1).DUM.hNv).ok(((WidgetData)localObject2).DUM.hNv);
    ((eo)localObject1).ejQ = 1L;
    ((eo)localObject1).oh(((WidgetData)localObject2).query).oi(((WidgetData)localObject2).dEJ).aLH();
    this.uH.setCurrentItem(j, true);
    i = 0;
    if (i < this.DWJ.size())
    {
      localObject1 = (ab)this.DWJ.get(i);
      if (i == j) {}
      for (((ab)localObject1).isSelected = true;; ((ab)localObject1).isSelected = false)
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(116686);
  }
  
  public final void ePC()
  {
    AppMethodBeat.i(116687);
    this.uH.setCurrentItem(this.uH.getCurrentItem() - 1);
    AppMethodBeat.o(116687);
  }
  
  public static class MyFragment
    extends Fragment
  {
    b DWM;
    
    public MyFragment()
    {
      AppMethodBeat.i(116676);
      this.DWM = new b();
      AppMethodBeat.o(116676);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(116677);
      ae.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
      paramLayoutInflater = this.DWM;
      paramLayoutInflater.gsV = paramViewGroup;
      if (paramLayoutInflater.DWQ == null)
      {
        if (paramLayoutInflater.view == null)
        {
          paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.activity.getContext()).inflate(2131495374, paramLayoutInflater.gsV, false);
          paramLayoutInflater.DWP = ((LinearLayout)paramLayoutInflater.view.findViewById(2131298736));
          paramLayoutInflater.sQh = paramLayoutInflater.view.findViewById(2131300199);
          paramLayoutInflater.DWO = paramLayoutInflater.view.findViewById(2131303975);
          paramLayoutInflater.DWV = ((LinearLayout)paramLayoutInflater.view.findViewById(2131305580));
          paramLayoutInflater.DWW = ((MoreFooter)paramLayoutInflater.view.findViewById(2131302468));
          paramLayoutInflater.yjO = ((TextView)paramLayoutInflater.view.findViewById(2131300734));
          paramLayoutInflater.DWT = paramLayoutInflater.view.findViewById(2131306992);
          paramLayoutInflater.DXe = paramLayoutInflater.view.findViewById(2131301493);
          paramLayoutInflater.DXd = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(2131301514));
          paramLayoutInflater.DXf = paramLayoutInflater.view.findViewById(2131299752);
          paramLayoutInflater.DWO.setVisibility(8);
          paramLayoutInflater.DWP.setVisibility(8);
          paramLayoutInflater.DWO.setVisibility(8);
          paramLayoutInflater.DWP.setVisibility(8);
          paramLayoutInflater.DXe.setVisibility(0);
          paramLayoutInflater.DXd.fQd();
          if (paramLayoutInflater.DWQ != null) {
            paramLayoutInflater.DWQ.aHe(paramLayoutInflater.DWR);
          }
          paramLayoutInflater.view.findViewById(2131303974).setOnClickListener(new b.4(paramLayoutInflater));
          paramLayoutInflater.view.findViewById(2131303973).setOnClickListener(new b.5(paramLayoutInflater));
          paramLayoutInflater.DWP.setOnTouchListener(new b.6(paramLayoutInflater));
          paramLayoutInflater.DWP.setOnClickListener(new b.7(paramLayoutInflater));
          paramLayoutInflater.DWW.setOnClickLsn(paramLayoutInflater.DXh);
          paramLayoutInflater.yjO.setOnLongClickListener(new b.8(paramLayoutInflater));
        }
        paramLayoutInflater.DWQ = ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.websearch.api.f.class)).a(paramLayoutInflater.gsV.getContext(), new b.3(paramLayoutInflater));
        paramLayoutInflater.DWQ.ePz();
      }
      paramLayoutInflater.updateView();
      if (paramLayoutInflater.isSelected) {
        paramLayoutInflater.eQF();
      }
      paramLayoutInflater = this.DWM.view;
      AppMethodBeat.o(116677);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(116680);
      super.onDestroy();
      if ((this.DWM != null) && (this.DWM.DXb != null))
      {
        b localb = this.DWM;
        if (localb.DWQ != null)
        {
          localb.DWQ.aHe(localb.DWR);
          localb.DWQ.onDestroy();
          localb.DXb = null;
          localb.DWR = null;
          localb.activity = null;
        }
      }
      AppMethodBeat.o(116680);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(116679);
      super.onPause();
      if ((this.DWM != null) && (this.DWM.DXb != null))
      {
        b localb = this.DWM;
        if (localb.isSelected)
        {
          if (localb.DWQ != null) {
            localb.DWQ.onPause();
          }
          localb.ulU = false;
          ae.v("WidgetView", "%s paused", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116679);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(116678);
      super.onResume();
      if ((this.DWM != null) && (this.DWM.DXb != null))
      {
        b localb = this.DWM;
        if (localb.isSelected)
        {
          localb.DWQ.onResume();
          localb.eQE();
          ae.v("WidgetView", "%s resume", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116678);
    }
  }
  
  final class a
    extends i
  {
    List<ServiceWidgetView.MyFragment> fragments;
    List<WidgetData> pkh;
    
    public final int getCount()
    {
      AppMethodBeat.i(116685);
      if (this.pkh == null)
      {
        AppMethodBeat.o(116685);
        return 0;
      }
      int i = this.pkh.size();
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
        ((Bundle)localObject).putParcelable("data", (Parcelable)this.pkh.get(paramInt));
        localMyFragment.setArguments((Bundle)localObject);
        this.fragments.add(localMyFragment);
        localObject = localMyFragment.DWM;
        MMActivity localMMActivity = this.DWL.activity;
        ServiceWidgetView localServiceWidgetView = this.DWL;
        b.b localb = this.DWL.DWK;
        b.a local1 = new b.a()
        {
          public final int eQB()
          {
            AppMethodBeat.i(116681);
            if (ServiceWidgetView.a.this.pkh == null)
            {
              AppMethodBeat.o(116681);
              return 0;
            }
            int i = ServiceWidgetView.a.this.pkh.size();
            AppMethodBeat.o(116681);
            return i;
          }
          
          public final List<ab> eQC()
          {
            return ServiceWidgetView.a.this.DWL.DWJ;
          }
          
          public final boolean eQD()
          {
            return paramInt > 0;
          }
          
          public final boolean hasNext()
          {
            AppMethodBeat.i(116682);
            if (paramInt < ServiceWidgetView.a.this.pkh.size() - 1)
            {
              AppMethodBeat.o(116682);
              return true;
            }
            AppMethodBeat.o(116682);
            return false;
          }
        };
        e locale = this.DWL.DWH;
        WidgetData localWidgetData = (WidgetData)this.pkh.get(paramInt);
        ((b)localObject).activity = localMMActivity;
        ((b)localObject).DWZ = localServiceWidgetView;
        ((b)localObject).DWK = localb;
        ((b)localObject).DXa = local1;
        ((b)localObject).DWH = locale;
        ((b)localObject).DXb = localWidgetData;
        if (paramInt != this.DWL.uH.getCurrentItem()) {
          break label240;
        }
        ServiceWidgetView.MyFragment.a(localMyFragment).setSelected(true);
      }
      for (;;)
      {
        ae.i("ServiceWidgetView", "getItem %s, fragment %s", new Object[] { Integer.valueOf(paramInt), localMyFragment.toString() });
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
      paramObject = ((ServiceWidgetView.MyFragment)paramObject).DWM;
      if (paramObject != null)
      {
        int i = this.pkh.indexOf(paramObject.DXb);
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