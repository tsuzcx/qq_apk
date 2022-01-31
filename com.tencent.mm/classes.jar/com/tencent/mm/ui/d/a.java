package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private String lyg = null;
  String mUrl = null;
  private boolean uSD = false;
  private b.b uSE = null;
  private String uSF = "";
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    this.uSE = paramb;
    refresh();
  }
  
  private void refresh()
  {
    au.Hx().FZ();
    if (com.tencent.mm.model.b.b.a(this.uSE))
    {
      y.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { this.uSE, this.lyg, this.mUrl, Boolean.valueOf(this.uSD) });
      Object localObject;
      ImageView localImageView;
      if (this.uSE == b.b.dYr)
      {
        au.Hx().FZ();
        this.lyg = com.tencent.mm.model.b.b.IE();
        au.Hx().FZ();
        this.mUrl = com.tencent.mm.model.b.b.IF();
        au.Hx().FZ();
        this.uSD = com.tencent.mm.model.b.b.IG();
        localObject = (TextView)getView().findViewById(R.h.chatting_monitored_banner_text);
        localImageView = (ImageView)getView().findViewById(R.h.close_icon);
        if (bk.bl(this.lyg)) {
          break label353;
        }
        ((TextView)localObject).setText(this.lyg);
        label157:
        ((TextView)localObject).setSelected(true);
        if (bk.bl(this.mUrl)) {
          break label363;
        }
        getView().findViewById(R.h.monitor_content).setBackgroundResource(R.g.tips_bar_white_selector);
        localImageView.setImageResource(R.g.monitor_close_dark);
        ((TextView)localObject).setTextColor(ae.getContext().getResources().getColor(R.e.tipsbar_text_color));
      }
      for (;;)
      {
        getView().setOnClickListener(new a.1(this));
        if (getView().getVisibility() != 0)
        {
          localObject = new StringBuilder();
          g.DN();
          this.uSF = (com.tencent.mm.kernel.a.CK() + "_" + System.currentTimeMillis());
          Gg(0);
        }
        setVisibility(0);
        if (!this.uSD) {
          break label405;
        }
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new a.2(this));
        return;
        au.Hx().FZ();
        this.lyg = com.tencent.mm.model.b.b.IB();
        au.Hx().FZ();
        this.mUrl = com.tencent.mm.model.b.b.IC();
        au.Hx().FZ();
        this.uSD = com.tencent.mm.model.b.b.ID();
        break;
        label353:
        ((TextView)localObject).setText(R.l.app_waiting);
        break label157;
        label363:
        getView().findViewById(R.h.monitor_content).setBackgroundResource(R.e.tipsbar_black_bg_color);
        localImageView.setImageResource(R.g.monitor_close);
        ((TextView)localObject).setTextColor(ae.getContext().getResources().getColor(R.e.white));
      }
      label405:
      localImageView.setVisibility(8);
      return;
    }
    y.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
    setVisibility(8);
  }
  
  final void Gg(int paramInt)
  {
    int i = 1;
    h localh = h.nFQ;
    String str = this.uSF;
    if (this.uSE == b.b.dYq) {
      i = 0;
    }
    localh.f(14439, new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(i) });
    h.nFQ.a(633L, paramInt, 1L, false);
  }
  
  public final boolean apu()
  {
    refresh();
    return super.apu();
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return R.i.chatting_monitored_banner;
  }
  
  public final void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    getView().findViewById(R.h.monitor_content).setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */