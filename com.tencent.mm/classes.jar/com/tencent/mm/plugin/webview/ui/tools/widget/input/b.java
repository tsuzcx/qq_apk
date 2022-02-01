package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cl.f;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.List;

public final class b
  extends a
{
  private static final int Qzn;
  private static final int Qzo;
  
  static
  {
    AppMethodBeat.i(82337);
    Qzn = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 48);
    Qzo = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 43);
    AppMethodBeat.o(82337);
  }
  
  private int hcl()
  {
    AppMethodBeat.i(82331);
    c localc = this.Qzm;
    if (localc.QzC <= 1) {
      localc.QzC = c.hcp()[0];
    }
    int i = localc.QzC;
    AppMethodBeat.o(82331);
    return i;
  }
  
  public final View apd(int paramInt)
  {
    AppMethodBeat.i(82330);
    Object localObject1 = this.uEJ;
    Object localObject2 = this.Qzm;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.QzD = this;
    locald.mContext = ((Context)localObject1);
    locald.Qzm = ((c)localObject2);
    if ((locald.mContext == null) || (locald.QzD == null))
    {
      AppMethodBeat.o(82330);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, c.g.webview_smiley_panel_page, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.Qzm);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.QzD.hci();
      int j = locald.QzD.hcj();
      int k = locald.QzD.hck();
      int m = locald.QzD.getRowCount();
      int n = locald.QzD.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).uX);
      ((WebViewSmileyGrid)localObject2).rFz = paramInt;
      ((WebViewSmileyGrid)localObject2).Qzq = i;
      ((WebViewSmileyGrid)localObject2).Qzr = j;
      ((WebViewSmileyGrid)localObject2).Qzs = n;
      ((WebViewSmileyGrid)localObject2).Qzt = k;
      ((WebViewSmileyGrid)localObject2).jyZ = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.ci.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.ci.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.ci.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).Qzp = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).Qzp);
      ((WebViewSmileyGrid)localObject2).Qzp.notifyDataSetChanged();
    }
    AppMethodBeat.o(82330);
    return localObject1;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(82334);
    if (hcj() <= 0)
    {
      AppMethodBeat.o(82334);
      return 0;
    }
    int i = hci();
    int j = hcj();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(82334);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.Qzm.QzB / Qzn;
    if (j > 3) {}
    for (;;)
    {
      j = i;
      if (i <= 0) {
        j = 1;
      }
      return j;
      i = j;
    }
  }
  
  public final int getRowSpacing()
  {
    AppMethodBeat.i(82336);
    int i = (this.Qzm.QzB - Qzn * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(82336);
    return i;
  }
  
  public final int hci()
  {
    AppMethodBeat.i(82332);
    f localf = c.hcq();
    if (localf.UYA == null)
    {
      AppMethodBeat.o(82332);
      return 0;
    }
    int i = localf.UYA.size();
    AppMethodBeat.o(82332);
    return i;
  }
  
  public final int hcj()
  {
    AppMethodBeat.i(82333);
    int i = hck();
    int j = getRowCount();
    AppMethodBeat.o(82333);
    return i * j;
  }
  
  public final int hck()
  {
    AppMethodBeat.i(82335);
    if (this.Qzm.Qzx)
    {
      AppMethodBeat.o(82335);
      return 7;
    }
    int i = hcl() / Qzo;
    AppMethodBeat.o(82335);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */