package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.b.b.b;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
{
  String mUrl;
  private String mWording;
  private boolean zhe;
  private b.b zhf;
  private String zhg;
  
  public a(Context paramContext, b.b paramb)
  {
    super(paramContext);
    AppMethodBeat.i(29991);
    this.mWording = null;
    this.mUrl = null;
    this.zhe = false;
    this.zhf = null;
    this.zhg = "";
    this.zhf = paramb;
    refresh();
    AppMethodBeat.o(29991);
  }
  
  private void refresh()
  {
    AppMethodBeat.i(29992);
    aw.aaz().Za();
    if (com.tencent.mm.model.b.b.a(this.zhf))
    {
      ab.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", new Object[] { this.zhf, this.mWording, this.mUrl, Boolean.valueOf(this.zhe) });
      Object localObject;
      ImageView localImageView;
      if (this.zhf == b.b.fow)
      {
        aw.aaz().Za();
        this.mWording = com.tencent.mm.model.b.b.abC();
        aw.aaz().Za();
        this.mUrl = com.tencent.mm.model.b.b.abD();
        aw.aaz().Za();
        this.zhe = com.tencent.mm.model.b.b.abE();
        localObject = (TextView)getView().findViewById(2131822761);
        localImageView = (ImageView)getView().findViewById(2131822762);
        if (bo.isNullOrNil(this.mWording)) {
          break label359;
        }
        ((TextView)localObject).setText(this.mWording);
        label161:
        ((TextView)localObject).setSelected(true);
        if (bo.isNullOrNil(this.mUrl)) {
          break label368;
        }
        getView().findViewById(2131822760).setBackgroundResource(2130840583);
        localImageView.setImageResource(2130839717);
        ((TextView)localObject).setTextColor(ah.getContext().getResources().getColor(2131690589));
      }
      for (;;)
      {
        getView().setOnClickListener(new a.1(this));
        if (getView().getVisibility() != 0)
        {
          localObject = new StringBuilder();
          g.RJ();
          this.zhg = (com.tencent.mm.kernel.a.getUin() + "_" + System.currentTimeMillis());
          Ox(0);
        }
        setVisibility(0);
        if (!this.zhe) {
          break label406;
        }
        localImageView.setVisibility(0);
        localImageView.setOnClickListener(new a.2(this));
        AppMethodBeat.o(29992);
        return;
        aw.aaz().Za();
        this.mWording = com.tencent.mm.model.b.b.abz();
        aw.aaz().Za();
        this.mUrl = com.tencent.mm.model.b.b.abA();
        aw.aaz().Za();
        this.zhe = com.tencent.mm.model.b.b.abB();
        break;
        label359:
        ((TextView)localObject).setText(2131297112);
        break label161;
        label368:
        getView().findViewById(2131822760).setBackgroundResource(2131690583);
        localImageView.setImageResource(2130839716);
        ((TextView)localObject).setTextColor(ah.getContext().getResources().getColor(2131690709));
      }
      label406:
      localImageView.setVisibility(8);
      AppMethodBeat.o(29992);
      return;
    }
    ab.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
    setVisibility(8);
    AppMethodBeat.o(29992);
  }
  
  final void Ox(int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(29995);
    h localh = h.qsU;
    String str = this.zhg;
    if (this.zhf == b.b.fou) {
      i = 0;
    }
    localh.e(14439, new Object[] { str, Integer.valueOf(paramInt), Integer.valueOf(i) });
    h.qsU.idkeyStat(633L, paramInt, 1L, false);
    AppMethodBeat.o(29995);
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(29994);
    refresh();
    boolean bool = super.aMK();
    AppMethodBeat.o(29994);
    return bool;
  }
  
  public final void destroy() {}
  
  public final int getLayoutId()
  {
    return 2130969136;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(29993);
    super.setVisibility(paramInt);
    getView().findViewById(2131822760).setVisibility(paramInt);
    AppMethodBeat.o(29993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.d.a
 * JD-Core Version:    0.7.0.1
 */