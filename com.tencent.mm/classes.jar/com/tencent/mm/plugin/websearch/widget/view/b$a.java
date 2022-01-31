package com.tencent.mm.plugin.websearch.widget.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.a.a;
import com.tencent.mm.plugin.websearch.a.b;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.widget.view.footer.MoreFooter;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public final class b$a
  extends Fragment
{
  c qXD = new c();
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    y.i("ServiceWidgetView", "onCreateView %s", new Object[] { toString() });
    paramLayoutInflater = this.qXD;
    paramLayoutInflater.hpb = paramViewGroup;
    if (paramLayoutInflater.qXH == null)
    {
      if (paramLayoutInflater.view == null)
      {
        paramLayoutInflater.view = LayoutInflater.from(paramLayoutInflater.gfb.mController.uMN).inflate(a.b.service_widget_view, paramLayoutInflater.hpb, false);
        paramLayoutInflater.qXG = ((LinearLayout)paramLayoutInflater.view.findViewById(a.a.container));
        paramLayoutInflater.qXK = paramLayoutInflater.view.findViewById(a.a.footer_content);
        paramLayoutInflater.qXF = paramLayoutInflater.view.findViewById(a.a.reload_ll);
        paramLayoutInflater.qXN = ((LinearLayout)paramLayoutInflater.view.findViewById(a.a.switch_footer_container));
        paramLayoutInflater.qXO = ((MoreFooter)paramLayoutInflater.view.findViewById(a.a.more_footer));
        paramLayoutInflater.nwK = ((TextView)paramLayoutInflater.view.findViewById(a.a.header_tv));
        paramLayoutInflater.qXL = paramLayoutInflater.view.findViewById(a.a.widget_bottom_padding);
        paramLayoutInflater.qXV = paramLayoutInflater.view.findViewById(a.a.loading_container);
        paramLayoutInflater.qXU = ((ThreeDotsLoadingView)paramLayoutInflater.view.findViewById(a.a.loading_view));
        paramLayoutInflater.qXW = paramLayoutInflater.view.findViewById(a.a.fail_again_container);
        paramLayoutInflater.qXF.setVisibility(8);
        paramLayoutInflater.qXG.setVisibility(8);
        paramLayoutInflater.caq();
        paramLayoutInflater.view.findViewById(a.a.reload_fail_btn).setOnClickListener(new c.4(paramLayoutInflater));
        paramLayoutInflater.view.findViewById(a.a.reload_btn).setOnClickListener(new c.5(paramLayoutInflater));
        paramLayoutInflater.qXG.setOnTouchListener(new c.6(paramLayoutInflater));
        paramLayoutInflater.qXG.setOnClickListener(new c.7(paramLayoutInflater));
        paramLayoutInflater.qXO.setOnClickLsn(paramLayoutInflater.qXY);
        paramLayoutInflater.nwK.setOnLongClickListener(new c.8(paramLayoutInflater));
      }
      paramLayoutInflater.qXH = ((h)g.r(h.class)).a(paramLayoutInflater.hpb.getContext(), new c.3(paramLayoutInflater));
      paramLayoutInflater.qXH.bZk();
    }
    paramLayoutInflater.aZ();
    if (paramLayoutInflater.fmm) {
      paramLayoutInflater.car();
    }
    return this.qXD.view;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if ((this.qXD != null) && (this.qXD.qXS != null)) {
      this.qXD.onDestroy();
    }
  }
  
  public final void onPause()
  {
    super.onPause();
    if ((this.qXD != null) && (this.qXD.qXS != null)) {
      this.qXD.onPause();
    }
  }
  
  public final void onResume()
  {
    super.onResume();
    if ((this.qXD != null) && (this.qXD.qXS != null)) {
      this.qXD.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.a
 * JD-Core Version:    0.7.0.1
 */