package com.tencent.mm.plugin.webview.fts.ui;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.c;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.sdk.platformtools.ab;

final class FtsWebVideoView$12
  implements a.b
{
  FtsWebVideoView$12(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void aEX()
  {
    AppMethodBeat.i(5837);
    ab.d("MicroMsg.FtsWebVideoView", "onSingleTap");
    if (FtsWebVideoView.e(this.uQE)) {
      FtsWebVideoView.c(this.uQE).oj(FtsWebVideoView.f(this.uQE));
    }
    AppMethodBeat.o(5837);
  }
  
  public final void aEY()
  {
    AppMethodBeat.i(5838);
    ab.d("MicroMsg.FtsWebVideoView", "onDoubleTap");
    AppMethodBeat.o(5838);
  }
  
  public final void aEZ()
  {
    AppMethodBeat.i(5839);
    if (FtsWebVideoView.d(this.uQE).isLive())
    {
      ab.i("MicroMsg.FtsWebVideoView", "onStartDragProgress isLive: no seek");
      AppMethodBeat.o(5839);
      return;
    }
    FtsWebVideoView.g(this.uQE).setVisibility(0);
    FtsWebVideoView.c(this.uQE).cKo();
    AppMethodBeat.o(5839);
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(5846);
    FtsWebVideoView.m(this.uQE).setVisibility(8);
    AppMethodBeat.o(5846);
  }
  
  public final void aFb()
  {
    AppMethodBeat.i(5847);
    FtsWebVideoView.m(this.uQE).setVisibility(8);
    AppMethodBeat.o(5847);
  }
  
  public final void aw(float paramFloat)
  {
    AppMethodBeat.i(5844);
    ab.d("MicroMsg.FtsWebVideoView", "onAdjustVolume:".concat(String.valueOf(paramFloat)));
    FtsWebVideoView.j(this.uQE).setPercent(paramFloat);
    FtsWebVideoView.k(this.uQE).setText(2131300262);
    FtsWebVideoView.l(this.uQE).setImageResource(2131231393);
    FtsWebVideoView.m(this.uQE).setVisibility(0);
    AppMethodBeat.o(5844);
  }
  
  public final void ax(float paramFloat)
  {
    AppMethodBeat.i(5845);
    ab.d("MicroMsg.FtsWebVideoView", "onAdjustBrightness:".concat(String.valueOf(paramFloat)));
    FtsWebVideoView.j(this.uQE).setPercent(paramFloat);
    FtsWebVideoView.k(this.uQE).setText(2131300259);
    FtsWebVideoView.l(this.uQE).setImageResource(2131231385);
    FtsWebVideoView.m(this.uQE).setVisibility(0);
    AppMethodBeat.o(5845);
  }
  
  public final boolean cJx()
  {
    AppMethodBeat.i(5842);
    if (FtsWebVideoView.i(this.uQE))
    {
      AppMethodBeat.o(5842);
      return false;
    }
    AppMethodBeat.o(5842);
    return true;
  }
  
  public final int getCurrentPosition()
  {
    AppMethodBeat.i(5843);
    int i = FtsWebVideoView.d(this.uQE).getCurrPosSec();
    AppMethodBeat.o(5843);
    return i;
  }
  
  public final int h(int paramInt, float paramFloat)
  {
    int j = 0;
    AppMethodBeat.i(5840);
    if (FtsWebVideoView.d(this.uQE).isLive())
    {
      ab.i("MicroMsg.FtsWebVideoView", "onDragProgress isLive: no seek");
      AppMethodBeat.o(5840);
      return 0;
    }
    ab.i("MicroMsg.FtsWebVideoView", "onDragProgress:" + paramInt + "/" + paramFloat);
    paramFloat /= this.uQE.getMeasuredWidth();
    int i = FtsWebVideoView.d(this.uQE).getVideoDurationSec();
    paramInt = getCurrentPosition();
    paramInt = (int)(paramFloat * i) + paramInt;
    if (paramInt < 0) {
      paramInt = j;
    }
    for (;;)
    {
      String str = c.ha(i * 1000L);
      FtsWebVideoView.g(this.uQE).setText(c.ha(paramInt * 1000L) + "/" + str);
      AppMethodBeat.o(5840);
      return paramInt;
      if (paramInt > i) {
        paramInt = i;
      }
    }
  }
  
  public final void i(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(5841);
    FtsWebVideoView.c(this.uQE).cKp();
    FtsWebVideoView.g(this.uQE).setVisibility(8);
    ab.i("MicroMsg.FtsWebVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(FtsWebVideoView.d(this.uQE).getCurrPosSec()), Float.valueOf(paramFloat) });
    if (FtsWebVideoView.d(this.uQE).isLive())
    {
      ab.i("MicroMsg.FtsWebVideoView", "onEndDragProgress isLive: no seek");
      AppMethodBeat.o(5841);
      return;
    }
    this.uQE.at(paramInt, false);
    FtsWebVideoView.c(this.uQE).cKp();
    if (FtsWebVideoView.h(this.uQE) != null) {
      FtsWebVideoView.h(this.uQE).daP();
    }
    AppMethodBeat.o(5841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.12
 * JD-Core Version:    0.7.0.1
 */