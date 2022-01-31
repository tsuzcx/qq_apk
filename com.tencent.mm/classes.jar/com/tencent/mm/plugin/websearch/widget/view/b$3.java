package com.tencent.mm.plugin.websearch.widget.view;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class b$3
  implements r
{
  b$3(b paramb) {}
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    AppMethodBeat.i(91523);
    u.i("WidgetView", "on tap callback eventId %s, consume %b, errMsg %s", new Object[] { paramString1, Boolean.valueOf(paramBoolean), paramString2 });
    if ((paramString3.equals(this.uNn.uMW)) && (paramString1.equals(this.uNn.uMX)))
    {
      if (paramBoolean) {
        break label85;
      }
      b.b(this.uNn);
    }
    for (;;)
    {
      this.uNn.uMX = null;
      AppMethodBeat.o(91523);
      return;
      label85:
      ab.i("WidgetView", "click event %s consumed by widget", new Object[] { this.uNn.uMX });
    }
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(91519);
    this.uNn.uMU.removeAllViews();
    this.uNn.uMU.addView(paramView);
    AppMethodBeat.o(91519);
  }
  
  public final void agq(String paramString)
  {
    AppMethodBeat.i(91524);
    if (paramString.equals(this.uNn.uMW)) {
      b.c(this.uNn);
    }
    AppMethodBeat.o(91524);
  }
  
  public final void cZh()
  {
    AppMethodBeat.i(91528);
    b.c(this.uNn);
    AppMethodBeat.o(91528);
  }
  
  public final void dI(String paramString, int paramInt)
  {
    AppMethodBeat.i(91521);
    if (paramInt == 3)
    {
      if (this.uNn.isRetry) {
        break label122;
      }
      this.uNn.uMT.setVisibility(0);
      this.uNn.uMU.setVisibility(8);
      this.uNn.uMZ.setVisibility(8);
    }
    for (;;)
    {
      if (paramInt != 1)
      {
        this.uNn.isLoading = false;
        if (this.uNn.uMP != null) {
          this.uNn.uMP.a(this.uNn);
        }
        if (!this.uNn.gDG) {
          this.uNn.uMV.onPause();
        }
      }
      AppMethodBeat.o(91521);
      return;
      label122:
      this.uNn.uMT.setVisibility(8);
      this.uNn.uMU.setVisibility(8);
      this.uNn.uNk.setVisibility(0);
      this.uNn.uMZ.setVisibility(8);
    }
  }
  
  public final void dJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(91527);
    this.uNn.uNg.uKB.height = paramInt;
    this.uNn.uMV.a(this.uNn.uNg, this.uNn.uMW);
    this.uNn.mXR.a(a.fromDPToPix(this.uNn.hwZ.getContext(), paramInt + 131), this.uNn);
    AppMethodBeat.o(91527);
  }
  
  public final void g(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(91526);
    if (paramString1.equals(this.uNn.uMW))
    {
      this.uNn.P(paramString2, paramString3, paramInt);
      AppMethodBeat.o(91526);
      return;
    }
    ab.e("WidgetView", "callback for expired widget %s", new Object[] { paramString1 });
    AppMethodBeat.o(91526);
  }
  
  public final void g(String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(91522);
    a(paramString1, paramBoolean, "", paramString2);
    AppMethodBeat.o(91522);
  }
  
  public final void hh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(91525);
    ab.i("WidgetView", "onSearchWAWidgetDataPush %s", new Object[] { paramString1 });
    AppMethodBeat.o(91525);
  }
  
  public final void removeView(View paramView)
  {
    AppMethodBeat.i(91520);
    this.uNn.uMU.removeAllViews();
    AppMethodBeat.o(91520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.3
 * JD-Core Version:    0.7.0.1
 */