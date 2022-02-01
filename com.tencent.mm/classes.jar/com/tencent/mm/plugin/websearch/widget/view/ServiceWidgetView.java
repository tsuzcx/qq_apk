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
import com.tencent.mm.g.b.a.hw;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class ServiceWidgetView
  implements com.tencent.mm.plugin.websearch.api.g
{
  List<af> IIA;
  b.b IIB;
  e IIy;
  private a IIz;
  MMActivity activity;
  List<WidgetData> dataList;
  ViewPager uO;
  
  public final void a(final int paramInt, m paramm)
  {
    AppMethodBeat.i(116688);
    Object localObject = this.IIz;
    int i = this.uO.getCurrentItem();
    if ((i < 0) || (i >= ((a)localObject).fragments.size())) {}
    for (localObject = null;; localObject = ((MyFragment)((a)localObject).fragments.get(i)).IID)
    {
      if ((paramm == localObject) && (paramInt != this.uO.getHeight())) {
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(116675);
            ServiceWidgetView localServiceWidgetView = ServiceWidgetView.this;
            int j = paramInt;
            Log.i("ServiceWidgetView", "update viewpager height %d", new Object[] { Integer.valueOf(j) });
            Object localObject = (WidgetData)localServiceWidgetView.dataList.get(localServiceWidgetView.uO.getCurrentItem());
            int i = j;
            if (localObject != null)
            {
              i = j;
              if (!((WidgetData)localObject).IFG.wkz) {
                i = j - a.fromDPToPix(localServiceWidgetView.activity.getContext(), 46);
              }
            }
            localObject = (LinearLayout.LayoutParams)localServiceWidgetView.uO.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject).height = i;
            localServiceWidgetView.uO.setLayoutParams((ViewGroup.LayoutParams)localObject);
            AppMethodBeat.o(116675);
          }
        });
      }
      AppMethodBeat.o(116688);
      return;
    }
  }
  
  public final void fXH()
  {
    AppMethodBeat.i(116686);
    int j = this.uO.getCurrentItem() + 1;
    int i = this.uO.getCurrentItem();
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
      localObject2 = new hw().vD(((WidgetData)localObject1).IFG.iIA).vE(((WidgetData)localObject1).IFG.iIA);
      ((hw)localObject2).eMC = 0L;
      ((hw)localObject2).vB(((WidgetData)localObject1).query).vC(((WidgetData)localObject1).dWw).bfK();
      AppMethodBeat.o(116686);
      return;
    }
    Log.i("ServiceWidgetView", "switch widget to %d", new Object[] { Integer.valueOf(j) });
    Object localObject2 = (WidgetData)this.dataList.get(j);
    localObject1 = new hw().vD(((WidgetData)localObject1).IFG.iIA).vE(((WidgetData)localObject2).IFG.iIA);
    ((hw)localObject1).eMC = 1L;
    ((hw)localObject1).vB(((WidgetData)localObject2).query).vC(((WidgetData)localObject2).dWw).bfK();
    this.uO.setCurrentItem(j, true);
    i = 0;
    if (i < this.IIA.size())
    {
      localObject1 = (af)this.IIA.get(i);
      if (i == j) {}
      for (((af)localObject1).isSelected = true;; ((af)localObject1).isSelected = false)
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(116686);
  }
  
  public final void fXI()
  {
    AppMethodBeat.i(116687);
    this.uO.setCurrentItem(this.uO.getCurrentItem() - 1);
    AppMethodBeat.o(116687);
  }
  
  public static class MyFragment
    extends Fragment
  {
    b IID;
    
    public MyFragment()
    {
      AppMethodBeat.i(116676);
      this.IID = new b();
      AppMethodBeat.o(116676);
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(116677);
      Log.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
      paramLayoutInflater = this.IID;
      paramLayoutInflater.parent = paramViewGroup;
      if (paramLayoutInflater.IIH == null)
      {
        if (paramLayoutInflater.view == null)
        {
          paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.activity.getContext()).inflate(2131496235, paramLayoutInflater.parent, false);
          paramLayoutInflater.IIG = ((LinearLayout)paramLayoutInflater.view.findViewById(2131299174));
          paramLayoutInflater.uGQ = paramLayoutInflater.view.findViewById(2131301665);
          paramLayoutInflater.IIF = paramLayoutInflater.view.findViewById(2131306829);
          paramLayoutInflater.IIM = ((LinearLayout)paramLayoutInflater.view.findViewById(2131308803));
          paramLayoutInflater.IIN = ((MoreFooter)paramLayoutInflater.view.findViewById(2131304878));
          paramLayoutInflater.CkP = ((TextView)paramLayoutInflater.view.findViewById(2131302315));
          paramLayoutInflater.IIK = paramLayoutInflater.view.findViewById(2131310504);
          paramLayoutInflater.IIV = paramLayoutInflater.view.findViewById(2131303695);
          paramLayoutInflater.IIU = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(2131303719));
          paramLayoutInflater.IIW = paramLayoutInflater.view.findViewById(2131300418);
          paramLayoutInflater.IIF.setVisibility(8);
          paramLayoutInflater.IIG.setVisibility(8);
          paramLayoutInflater.IIF.setVisibility(8);
          paramLayoutInflater.IIG.setVisibility(8);
          paramLayoutInflater.IIV.setVisibility(0);
          paramLayoutInflater.IIU.gZh();
          if (paramLayoutInflater.IIH != null) {
            paramLayoutInflater.IIH.aWZ(paramLayoutInflater.III);
          }
          paramLayoutInflater.view.findViewById(2131306828).setOnClickListener(new b.4(paramLayoutInflater));
          paramLayoutInflater.view.findViewById(2131306827).setOnClickListener(new b.5(paramLayoutInflater));
          paramLayoutInflater.IIG.setOnTouchListener(new b.6(paramLayoutInflater));
          paramLayoutInflater.IIG.setOnClickListener(new b.7(paramLayoutInflater));
          paramLayoutInflater.IIN.setOnClickLsn(paramLayoutInflater.IIY);
          paramLayoutInflater.CkP.setOnLongClickListener(new b.8(paramLayoutInflater));
        }
        paramLayoutInflater.IIH = ((com.tencent.mm.plugin.websearch.api.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.f.class)).a(paramLayoutInflater.parent.getContext(), new b.3(paramLayoutInflater));
        paramLayoutInflater.IIH.fXF();
      }
      paramLayoutInflater.updateView();
      if (paramLayoutInflater.isSelected) {
        paramLayoutInflater.fZe();
      }
      paramLayoutInflater = this.IID.view;
      AppMethodBeat.o(116677);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(116680);
      super.onDestroy();
      if ((this.IID != null) && (this.IID.IIS != null))
      {
        b localb = this.IID;
        if (localb.IIH != null)
        {
          localb.IIH.aWZ(localb.III);
          localb.IIH.onDestroy();
          localb.IIS = null;
          localb.III = null;
          localb.activity = null;
        }
      }
      AppMethodBeat.o(116680);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(116679);
      super.onPause();
      if ((this.IID != null) && (this.IID.IIS != null))
      {
        b localb = this.IID;
        if (localb.isSelected)
        {
          if (localb.IIH != null) {
            localb.IIH.onPause();
          }
          localb.xEm = false;
          Log.v("WidgetView", "%s paused", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116679);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(116678);
      super.onResume();
      if ((this.IID != null) && (this.IID.IIS != null))
      {
        b localb = this.IID;
        if (localb.isSelected)
        {
          localb.IIH.onResume();
          localb.fZd();
          Log.v("WidgetView", "%s resume", new Object[] { localb.toString() });
        }
      }
      AppMethodBeat.o(116678);
    }
  }
  
  final class a
    extends i
  {
    List<ServiceWidgetView.MyFragment> fragments;
    List<WidgetData> qzs;
    
    public final int getCount()
    {
      AppMethodBeat.i(116685);
      if (this.qzs == null)
      {
        AppMethodBeat.o(116685);
        return 0;
      }
      int i = this.qzs.size();
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
        ((Bundle)localObject).putParcelable("data", (Parcelable)this.qzs.get(paramInt));
        localMyFragment.setArguments((Bundle)localObject);
        this.fragments.add(localMyFragment);
        localObject = localMyFragment.IID;
        MMActivity localMMActivity = this.IIC.activity;
        ServiceWidgetView localServiceWidgetView = this.IIC;
        b.b localb = this.IIC.IIB;
        b.a local1 = new b.a()
        {
          public final int fZa()
          {
            AppMethodBeat.i(116681);
            if (ServiceWidgetView.a.this.qzs == null)
            {
              AppMethodBeat.o(116681);
              return 0;
            }
            int i = ServiceWidgetView.a.this.qzs.size();
            AppMethodBeat.o(116681);
            return i;
          }
          
          public final List<af> fZb()
          {
            return ServiceWidgetView.a.this.IIC.IIA;
          }
          
          public final boolean fZc()
          {
            return paramInt > 0;
          }
          
          public final boolean hasNext()
          {
            AppMethodBeat.i(116682);
            if (paramInt < ServiceWidgetView.a.this.qzs.size() - 1)
            {
              AppMethodBeat.o(116682);
              return true;
            }
            AppMethodBeat.o(116682);
            return false;
          }
        };
        e locale = this.IIC.IIy;
        WidgetData localWidgetData = (WidgetData)this.qzs.get(paramInt);
        ((b)localObject).activity = localMMActivity;
        ((b)localObject).IIQ = localServiceWidgetView;
        ((b)localObject).IIB = localb;
        ((b)localObject).IIR = local1;
        ((b)localObject).IIy = locale;
        ((b)localObject).IIS = localWidgetData;
        if (paramInt != this.IIC.uO.getCurrentItem()) {
          break label240;
        }
        ServiceWidgetView.MyFragment.a(localMyFragment).setSelected(true);
      }
      for (;;)
      {
        Log.i("ServiceWidgetView", "getItem %s, fragment %s", new Object[] { Integer.valueOf(paramInt), localMyFragment.toString() });
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
      paramObject = ((ServiceWidgetView.MyFragment)paramObject).IID;
      if (paramObject != null)
      {
        int i = this.qzs.indexOf(paramObject.IIS);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView
 * JD-Core Version:    0.7.0.1
 */