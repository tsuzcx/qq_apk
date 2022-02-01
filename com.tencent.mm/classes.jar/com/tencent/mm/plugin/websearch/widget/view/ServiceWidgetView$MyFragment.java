package com.tencent.mm.plugin.websearch.widget.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ur;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.a.f;
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
  b Wty;
  
  public ServiceWidgetView$MyFragment()
  {
    AppMethodBeat.i(116676);
    this.Wty = new b();
    AppMethodBeat.o(116676);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(116677);
    Log.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
    paramLayoutInflater = this.Wty;
    paramLayoutInflater.parent = paramViewGroup;
    if (paramLayoutInflater.WtB == null)
    {
      if (paramLayoutInflater.view == null)
      {
        paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.activity.getContext()).inflate(a.f.service_widget_view, paramLayoutInflater.parent, false);
        paramLayoutInflater.WtA = ((LinearLayout)paramLayoutInflater.view.findViewById(a.e.container));
        paramLayoutInflater.ESX = paramLayoutInflater.view.findViewById(a.e.footer_content);
        paramLayoutInflater.Wtz = paramLayoutInflater.view.findViewById(a.e.reload_ll);
        paramLayoutInflater.WtG = ((LinearLayout)paramLayoutInflater.view.findViewById(a.e.switch_footer_container));
        paramLayoutInflater.WtH = ((MoreFooter)paramLayoutInflater.view.findViewById(a.e.more_footer));
        paramLayoutInflater.DGu = ((TextView)paramLayoutInflater.view.findViewById(a.e.header_tv));
        paramLayoutInflater.WtE = paramLayoutInflater.view.findViewById(a.e.widget_bottom_padding);
        paramLayoutInflater.WtP = paramLayoutInflater.view.findViewById(a.e.loading_container);
        paramLayoutInflater.WtO = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(a.e.loading_view));
        paramLayoutInflater.WtQ = paramLayoutInflater.view.findViewById(a.e.fail_again_container);
        paramLayoutInflater.Wtz.setVisibility(8);
        paramLayoutInflater.WtA.setVisibility(8);
        paramLayoutInflater.Wtz.setVisibility(8);
        paramLayoutInflater.WtA.setVisibility(8);
        paramLayoutInflater.WtP.setVisibility(0);
        paramLayoutInflater.WtO.jFe();
        if (paramLayoutInflater.WtB != null) {
          paramLayoutInflater.WtB.bis(paramLayoutInflater.WtC);
        }
        paramLayoutInflater.view.findViewById(a.e.reload_fail_btn).setOnClickListener(new b.4(paramLayoutInflater));
        paramLayoutInflater.view.findViewById(a.e.reload_btn).setOnClickListener(new b.5(paramLayoutInflater));
        paramLayoutInflater.WtA.setOnTouchListener(new b.6(paramLayoutInflater));
        paramLayoutInflater.WtA.setOnClickListener(new b.7(paramLayoutInflater));
        paramLayoutInflater.WtH.setOnClickLsn(paramLayoutInflater.WtS);
        paramLayoutInflater.DGu.setOnLongClickListener(new b.8(paramLayoutInflater));
      }
      paramLayoutInflater.WtB = ((f)h.ax(f.class)).a(paramLayoutInflater.parent.getContext(), new b.3(paramLayoutInflater));
      paramLayoutInflater.WtB.ipJ();
    }
    paramLayoutInflater.updateView();
    if (paramLayoutInflater.isSelected) {
      paramLayoutInflater.irg();
    }
    paramLayoutInflater = this.Wty.view;
    AppMethodBeat.o(116677);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(116680);
    super.onDestroy();
    if ((this.Wty != null) && (this.Wty.WtM != null))
    {
      b localb = this.Wty;
      if (localb.WtB != null)
      {
        localb.WtB.bis(localb.WtC);
        localb.WtB.onDestroy();
        localb.WtM = null;
        localb.WtC = null;
        localb.activity = null;
      }
    }
    AppMethodBeat.o(116680);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(116679);
    super.onPause();
    if ((this.Wty != null) && (this.Wty.WtM != null))
    {
      b localb = this.Wty;
      if (localb.isSelected)
      {
        if (localb.WtB != null) {
          localb.WtB.onPause();
        }
        localb.ICx = false;
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
    if ((this.Wty != null) && (this.Wty.WtM != null))
    {
      localb = this.Wty;
      if (localb.isSelected)
      {
        localb.WtB.onResume();
        if (localb.view != null)
        {
          bool = localb.ICx;
          if (localb.view.getVisibility() == 0) {
            break label102;
          }
          localb.ICx = false;
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
      if ((localb.WtL != null) && (localb.WtL.ipK())) {}
      for (localb.ICx = true;; localb.ICx = false)
      {
        if ((bool == localb.ICx) || (!localb.ICx)) {
          break label637;
        }
        Log.i("WidgetView", "exposure");
        localObject1 = String.format("262144:%s:%d:%s;", new Object[] { localb.WtM.Wqn.HsD, Long.valueOf(System.currentTimeMillis() / 1000L), localb.WtM.Wqn.Wqt });
        String str1 = localb.WtM.Wqn.serviceType + ";";
        String str2 = "262144:" + localb.WtM.Wqn.serviceType + ";";
        Object localObject2 = new HashMap();
        ((Map)localObject2).put("isexpose", "1");
        ((Map)localObject2).put("content", localObject1);
        ((Map)localObject2).put("searchid", localb.WtM.Wqn.mpa);
        ((Map)localObject2).put("scene", "47");
        ((Map)localObject2).put("query", localb.WtM.query);
        ((Map)localObject2).put("sessionid", localb.WtM.hVW);
        ((Map)localObject2).put("resulttype", str2);
        ((Map)localObject2).put("resultsubtypelist", str1);
        ((Map)localObject2).put("ishomepage", "1");
        ((Map)localObject2).put("height", localb.WtA.getHeight() + ";");
        ((Map)localObject2).put("requestid", System.currentTimeMillis());
        b.bu((Map)localObject2);
        localObject2 = new ur();
        ((ur)localObject2).jvJ = ((ur)localObject2).F("content", (String)localObject1, true);
        ((ur)localObject2).iKB = ((ur)localObject2).F("query", localb.WtM.query, true);
        ((ur)localObject2).jHO = ((ur)localObject2).F("resultsubtypelist", str1, true);
        ((ur)localObject2).jHN = ((ur)localObject2).F("resulttype", str2, true);
        ((ur)localObject2).jHI = ((ur)localObject2).F("searchid", localb.WtM.Wqn.mpa, true);
        ((ur)localObject2).inx = ((ur)localObject2).F("sessionid", localb.WtM.hVW, true);
        ((ur)localObject2).iuA = 47L;
        ((ur)localObject2).bMH();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.MyFragment
 * JD-Core Version:    0.7.0.1
 */