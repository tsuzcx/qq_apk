package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.plugin.webview.fts.c.d;
import com.tencent.mm.plugin.webview.fts.c.d.1;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import org.json.JSONException;
import org.json.JSONObject;

final class FtsWebVideoView$13
  implements h.b
{
  FtsWebVideoView$13(FtsWebVideoView paramFtsWebVideoView) {}
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5848);
    ab.i("MicroMsg.FtsWebVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    h.qsU.e(14911, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), FtsWebVideoView.n(this.uQE), at.gU(this.uQE.getContext()) });
    if (FtsWebVideoView.h(this.uQE) != null)
    {
      paramString1 = FtsWebVideoView.h(this.uQE);
      ab.e("MicroMsg.JsApiVideoCallback", "onError what %d, extra %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      paramString1.clean();
    }
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("errCode", paramInt1);
      paramString2.put("errMsg", String.valueOf(paramInt2));
      paramString1.aR(paramString1.a(7, paramString2));
      this.uQE.pause();
      FtsWebVideoView.a(this.uQE, this.uQE.getContext().getString(2131304511, new Object[] { paramInt1 + ":" + paramInt2 }), this.uQE.getContext().getString(2131304536));
      AppMethodBeat.o(5848);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramString1, null, new Object[0]);
      }
    }
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5849);
    ab.i("MicroMsg.FtsWebVideoView", "onPrepared");
    paramString1 = FtsWebVideoView.o(this.uQE);
    paramString1.ieb = -1;
    paramString1.iec = 0;
    paramString1.iea = 0.0F;
    FtsWebVideoView.c(this.uQE).oj(FtsWebVideoView.f(this.uQE));
    AppMethodBeat.o(5849);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5850);
    ab.i("MicroMsg.FtsWebVideoView", "onVideoEnded");
    if (FtsWebVideoView.h(this.uQE) != null)
    {
      paramString1 = FtsWebVideoView.h(this.uQE);
      ab.d("MicroMsg.JsApiVideoCallback", "onVideoEnded %s", new Object[] { paramString1.toString() });
      paramString1.aFE();
    }
    try
    {
      paramString1.aR(paramString1.a(3, null));
      if (FtsWebVideoView.p(this.uQE))
      {
        this.uQE.at(0, true);
        AppMethodBeat.o(5850);
        return;
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramString1, null, new Object[0]);
      }
      this.uQE.at(0, false);
      this.uQE.pause();
      FtsWebVideoView.q(this.uQE);
      FtsWebVideoView.r(this.uQE).setImageResource(2130838941);
      FtsWebVideoView.c(this.uQE).setVisibility(8);
      AppMethodBeat.o(5850);
    }
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5852);
    ab.i("MicroMsg.FtsWebVideoView", "onVideoPause");
    if ((FtsWebVideoView.h(this.uQE) != null) && (FtsWebVideoView.h(this.uQE) != null))
    {
      paramString1 = FtsWebVideoView.h(this.uQE);
      ab.d("MicroMsg.JsApiVideoCallback", "onVideoPause %s", new Object[] { paramString1.toString() });
      paramString1.aFE();
      try
      {
        paramString1.aR(paramString1.a(2, null));
        AppMethodBeat.o(5852);
        return;
      }
      catch (JSONException paramString1)
      {
        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramString1, null, new Object[0]);
      }
    }
    AppMethodBeat.o(5852);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5853);
    ab.i("MicroMsg.FtsWebVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(FtsWebVideoView.t(this.uQE)) });
    if (FtsWebVideoView.h(this.uQE) != null)
    {
      paramString1 = FtsWebVideoView.h(this.uQE);
      ab.d("MicroMsg.JsApiVideoCallback", "onVideoPlay %s", new Object[] { paramString1.toString() });
      paramString1.idT = 0;
      if (paramString1.idS == null) {
        paramString1.idS = new ap(new d.1(paramString1), true);
      }
      paramString1.idS.ag(250L, 250L);
    }
    try
    {
      paramString1.aR(paramString1.a(1, null));
      if ((FtsWebVideoView.u(this.uQE) > 0L) && (FtsWebVideoView.u(this.uQE) != 9223372036854775807L))
      {
        long l = System.currentTimeMillis() - FtsWebVideoView.u(this.uQE);
        h.qsU.e(14909, new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis()), Long.valueOf(l), at.gU(this.uQE.getContext()), FtsWebVideoView.n(this.uQE) });
      }
      AppMethodBeat.o(5853);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", paramString1, null, new Object[0]);
      }
    }
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5854);
    ab.i("MicroMsg.FtsWebVideoView", "onVideoWaiting");
    FtsWebVideoView.c(this.uQE).cKo();
    FtsWebVideoView.a(this.uQE, true);
    AppMethodBeat.o(5854);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(5855);
    ab.i("MicroMsg.FtsWebVideoView", "onVideoWaitingEnd");
    FtsWebVideoView.a(this.uQE, false);
    FtsWebVideoView.c(this.uQE).cKp();
    FtsWebVideoView.c(this.uQE).aFn();
    AppMethodBeat.o(5855);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5851);
    ab.i("MicroMsg.FtsWebVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (FtsWebVideoView.s(this.uQE) == FtsWebVideoView.b.uQF)
    {
      paramString2 = this.uQE;
      if (paramInt1 >= paramInt2) {
        break label96;
      }
    }
    label96:
    for (paramString1 = FtsWebVideoView.b.uQH;; paramString1 = FtsWebVideoView.b.uQG)
    {
      FtsWebVideoView.a(paramString2, paramString1);
      ab.i("MicroMsg.FtsWebVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { FtsWebVideoView.s(this.uQE) });
      AppMethodBeat.o(5851);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.13
 * JD-Core Version:    0.7.0.1
 */