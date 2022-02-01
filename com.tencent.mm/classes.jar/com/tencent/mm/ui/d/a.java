package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  private boolean Huw;
  private b.b Hux;
  private String Huy;
  String mUrl;
  private String mWording;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(33849);
    this.mWording = null;
    this.mUrl = null;
    this.Huw = false;
    this.Hux = null;
    this.Huy = "";
    this.Hux = paramb;
    refresh();
    AppMethodBeat.o(33849);
  }
  
  private void refresh()
  {
    AppMethodBeat.i(33850);
    az.ayM().axb();
    if (com.tencent.mm.model.b.b.a(this.Hux))
    {
      ac.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { this.Hux, this.mWording, this.mUrl, Boolean.valueOf(this.Huw) });
      Object localObject;
      ImageView localImageView;
      if (this.Hux == b.b.hqx)
      {
        az.ayM().axb();
        this.mWording = com.tencent.mm.model.b.b.azU();
        az.ayM().axb();
        this.mUrl = com.tencent.mm.model.b.b.azV();
        az.ayM().axb();
        this.Huw = com.tencent.mm.model.b.b.azW();
        localObject = (TextView)getView().findViewById(2131298151);
        localImageView = (ImageView)getView().findViewById(2131298370);
        if (bs.isNullOrNil(this.mWording)) {
          break label357;
        }
        ((TextView)localObject).setText(this.mWording);
        label160:
        ((TextView)localObject).setSelected(true);
        if (bs.isNullOrNil(this.mUrl)) {
          break label366;
        }
        getView().findViewById(2131302449).setBackgroundResource(2131234377);
        localImageView.setImageResource(2131233342);
        ((TextView)localObject).setTextColor(ai.getContext().getResources().getColor(2131099676));
      }
      for (;;)
      {
        getView().setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33847);
            a.this.ZO(1);
            paramAnonymousView = a.this;
            String str = a.this.mUrl;
            if (bs.isNullOrNil(str))
            {
              ac.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
              AppMethodBeat.o(33847);
              return;
            }
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", str);
            localIntent.putExtra("showShare", false);
            localIntent.putExtra("show_bottom", false);
            d.b((Context)paramAnonymousView.Dsc.get(), "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(33847);
          }
        });
        if (getView().getVisibility() != 0)
        {
          localObject = new StringBuilder();
          g.agP();
          this.Huy = (com.tencent.mm.kernel.a.getUin() + "_" + System.currentTimeMillis());
          ZO(0);
        }
        setVisibility(0);
        if (!this.Huw) {
          break label404;
        }
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(33848);
            ac.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
            a.this.ZO(2);
            az.ayM().axb().c(b.b.hqw);
            az.ayM().axb().c(b.b.hqx);
            a.this.setVisibility(8);
            AppMethodBeat.o(33848);
          }
        });
        AppMethodBeat.o(33850);
        return;
        az.ayM().axb();
        this.mWording = com.tencent.mm.model.b.b.azR();
        az.ayM().axb();
        this.mUrl = com.tencent.mm.model.b.b.azS();
        az.ayM().axb();
        this.Huw = com.tencent.mm.model.b.b.azT();
        break;
        label357:
        ((TextView)localObject).setText(2131755936);
        break label160;
        label366:
        getView().findViewById(2131302449).setBackgroundResource(2131101030);
        localImageView.setImageResource(2131233341);
        ((TextView)localObject).setTextColor(ai.getContext().getResources().getColor(2131101182));
      }
      label404:
      localImageView.setVisibility(8);
      AppMethodBeat.o(33850);
      return;
    }
    ac.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
    setVisibility(8);
    AppMethodBeat.o(33850);
  }
  
  final void ZO(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(33853);
    h localh = h.wUl;
    String str = this.Huy;
    if (this.Hux == b.b.hqw) {
      i = 0;
    }
    localh.f(14439, new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(i) });
    h.wUl.idkeyStat(633L, paramInt, 1L, false);
    AppMethodBeat.o(33853);
  }
  
  public final boolean bvU()
  {
    AppMethodBeat.i(33852);
    refresh();
    boolean bool = super.bvU();
    AppMethodBeat.o(33852);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2131493516;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(33851);
    super.setVisibility(paramInt);
    getView().findViewById(2131302449).setVisibility(paramInt);
    AppMethodBeat.o(33851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */