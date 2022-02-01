package com.tencent.mm.plugin.websearch.widget.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.qw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.d;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.HashMap;
import java.util.Map;

public class ServiceWidgetView$MyFragment
  extends Fragment
{
  b PCT;
  
  public ServiceWidgetView$MyFragment()
  {
    AppMethodBeat.i(116676);
    this.PCT = new b();
    AppMethodBeat.o(116676);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(116677);
    Log.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
    paramLayoutInflater = this.PCT;
    paramLayoutInflater.parent = paramViewGroup;
    if (paramLayoutInflater.PCW == null)
    {
      if (paramLayoutInflater.view == null)
      {
        paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.activity.getContext()).inflate(a.e.service_widget_view, paramLayoutInflater.parent, false);
        paramLayoutInflater.PCV = ((LinearLayout)paramLayoutInflater.view.findViewById(a.d.container));
        paramLayoutInflater.yOC = paramLayoutInflater.view.findViewById(a.d.footer_content);
        paramLayoutInflater.PCU = paramLayoutInflater.view.findViewById(a.d.reload_ll);
        paramLayoutInflater.PDb = ((LinearLayout)paramLayoutInflater.view.findViewById(a.d.switch_footer_container));
        paramLayoutInflater.PDc = ((MoreFooter)paramLayoutInflater.view.findViewById(a.d.more_footer));
        paramLayoutInflater.IhI = ((TextView)paramLayoutInflater.view.findViewById(a.d.header_tv));
        paramLayoutInflater.PCZ = paramLayoutInflater.view.findViewById(a.d.widget_bottom_padding);
        paramLayoutInflater.PDk = paramLayoutInflater.view.findViewById(a.d.loading_container);
        paramLayoutInflater.PDj = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(a.d.loading_view));
        paramLayoutInflater.PDl = paramLayoutInflater.view.findViewById(a.d.fail_again_container);
        paramLayoutInflater.PCU.setVisibility(8);
        paramLayoutInflater.PCV.setVisibility(8);
        paramLayoutInflater.PCU.setVisibility(8);
        paramLayoutInflater.PCV.setVisibility(8);
        paramLayoutInflater.PDk.setVisibility(0);
        paramLayoutInflater.PDj.hZX();
        if (paramLayoutInflater.PCW != null) {
          paramLayoutInflater.PCW.biK(paramLayoutInflater.PCX);
        }
        paramLayoutInflater.view.findViewById(a.d.reload_fail_btn).setOnClickListener(new b.4(paramLayoutInflater));
        paramLayoutInflater.view.findViewById(a.d.reload_btn).setOnClickListener(new b.5(paramLayoutInflater));
        paramLayoutInflater.PCV.setOnTouchListener(new b.6(paramLayoutInflater));
        paramLayoutInflater.PCV.setOnClickListener(new b.7(paramLayoutInflater));
        paramLayoutInflater.PDc.setOnClickLsn(paramLayoutInflater.PDn);
        paramLayoutInflater.IhI.setOnLongClickListener(new b.8(paramLayoutInflater));
      }
      paramLayoutInflater.PCW = ((f)h.ae(f.class)).a(paramLayoutInflater.parent.getContext(), new b.3(paramLayoutInflater));
      paramLayoutInflater.PCW.gQs();
    }
    paramLayoutInflater.updateView();
    if (paramLayoutInflater.isSelected) {
      paramLayoutInflater.gRP();
    }
    paramLayoutInflater = this.PCT.view;
    AppMethodBeat.o(116677);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(116680);
    super.onDestroy();
    if ((this.PCT != null) && (this.PCT.PDh != null))
    {
      b localb = this.PCT;
      if (localb.PCW != null)
      {
        localb.PCW.biK(localb.PCX);
        localb.PCW.onDestroy();
        localb.PDh = null;
        localb.PCX = null;
        localb.activity = null;
      }
    }
    AppMethodBeat.o(116680);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(116679);
    super.onPause();
    if ((this.PCT != null) && (this.PCT.PDh != null))
    {
      b localb = this.PCT;
      if (localb.isSelected)
      {
        if (localb.PCW != null) {
          localb.PCW.onPause();
        }
        localb.CIn = false;
        Log.v("WidgetView", "%s paused", new Object[] { localb.toString() });
      }
    }
    AppMethodBeat.o(116679);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(116678);
    super.onResume();
    b localb;
    boolean bool;
    if ((this.PCT != null) && (this.PCT.PDh != null))
    {
      localb = this.PCT;
      if (localb.isSelected)
      {
        localb.PCW.onResume();
        if (localb.view != null)
        {
          bool = localb.CIn;
          if (localb.view.getVisibility() == 0) {
            break label102;
          }
          localb.CIn = false;
        }
      }
    }
    label102:
    label637:
    for (;;)
    {
      Log.v("WidgetView", "%s resume", new Object[] { localb.toString() });
      AppMethodBeat.o(116678);
      return;
      Object localObject1 = new int[2];
      localb.view.getLocationOnScreen((int[])localObject1);
      if ((localb.PDg != null) && (localb.PDg.gQt())) {}
      for (localb.CIn = true;; localb.CIn = false)
      {
        if ((bool == localb.CIn) || (!localb.CIn)) {
          break label637;
        }
        Log.i("WidgetView", "exposure");
        localObject1 = String.format("262144:%s:%d:%s;", new Object[] { localb.PDh.PzY.BHW, Long.valueOf(System.currentTimeMillis() / 1000L), localb.PDh.PzY.PAe });
        String str1 = localb.PDh.PzY.serviceType + ";";
        String str2 = "262144:" + localb.PDh.PzY.serviceType + ";";
        Object localObject2 = new HashMap();
        ((Map)localObject2).put("isexpose", "1");
        ((Map)localObject2).put("content", localObject1);
        ((Map)localObject2).put("searchid", localb.PDh.PzY.jQi);
        ((Map)localObject2).put("scene", "47");
        ((Map)localObject2).put("query", localb.PDh.query);
        ((Map)localObject2).put("sessionid", localb.PDh.fQb);
        ((Map)localObject2).put("resulttype", str2);
        ((Map)localObject2).put("resultsubtypelist", str1);
        ((Map)localObject2).put("ishomepage", "1");
        ((Map)localObject2).put("height", localb.PCV.getHeight() + ";");
        ((Map)localObject2).put("requestid", System.currentTimeMillis());
        b.bc((Map)localObject2);
        localObject2 = new qw();
        ((qw)localObject2).gZZ = ((qw)localObject2).z("content", (String)localObject1, true);
        ((qw)localObject2).gym = ((qw)localObject2).z("query", localb.PDh.query, true);
        ((qw)localObject2).hlO = ((qw)localObject2).z("resultsubtypelist", str1, true);
        ((qw)localObject2).hlN = ((qw)localObject2).z("resulttype", str2, true);
        ((qw)localObject2).hlH = ((qw)localObject2).z("searchid", localb.PDh.PzY.jQi, true);
        ((qw)localObject2).ggA = ((qw)localObject2).z("sessionid", localb.PDh.fQb, true);
        ((qw)localObject2).gmT = 47L;
        ((qw)localObject2).bpa();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.MyFragment
 * JD-Core Version:    0.7.0.1
 */