package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends a
{
  private static final int owR;
  private static final int owS;
  
  static
  {
    AppMethodBeat.i(82337);
    owR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 48);
    owS = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 43);
    AppMethodBeat.o(82337);
  }
  
  private int cci()
  {
    AppMethodBeat.i(82331);
    c localc = this.JBa;
    if (localc.oxi <= 1)
    {
      Display localDisplay = ((WindowManager)MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
      localc.oxi = new int[] { localDisplay.getWidth(), localDisplay.getHeight() }[0];
    }
    int i = localc.oxi;
    AppMethodBeat.o(82331);
    return i;
  }
  
  public final View Ap(int paramInt)
  {
    AppMethodBeat.i(82330);
    Object localObject1 = this.owO;
    Object localObject2 = this.JBa;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.JBi = this;
    locald.mContext = ((Context)localObject1);
    locald.JBa = ((c)localObject2);
    if ((locald.mContext == null) || (locald.JBi == null))
    {
      AppMethodBeat.o(82330);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131497079, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.JBa);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.JBi.ccf();
      int j = locald.JBi.ccg();
      int k = locald.JBi.cch();
      int m = locald.JBi.getRowCount();
      int n = locald.JBi.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).awr);
      ((WebViewSmileyGrid)localObject2).owW = paramInt;
      ((WebViewSmileyGrid)localObject2).owU = i;
      ((WebViewSmileyGrid)localObject2).owV = j;
      ((WebViewSmileyGrid)localObject2).owX = n;
      ((WebViewSmileyGrid)localObject2).owY = k;
      ((WebViewSmileyGrid)localObject2).gOF = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).JBb = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).JBb);
      ((WebViewSmileyGrid)localObject2).JBb.notifyDataSetChanged();
    }
    AppMethodBeat.o(82330);
    return localObject1;
  }
  
  public final int ccf()
  {
    AppMethodBeat.i(82332);
    int i = e.gxR().cca();
    AppMethodBeat.o(82332);
    return i;
  }
  
  public final int ccg()
  {
    AppMethodBeat.i(82333);
    int i = cch();
    int j = getRowCount();
    AppMethodBeat.o(82333);
    return i * j;
  }
  
  public final int cch()
  {
    AppMethodBeat.i(82335);
    if (this.JBa.oxd)
    {
      AppMethodBeat.o(82335);
      return 7;
    }
    int i = cci() / owS;
    AppMethodBeat.o(82335);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(82334);
    if (ccg() <= 0)
    {
      AppMethodBeat.o(82334);
      return 0;
    }
    int i = e.gxR().cca();
    int j = ccg();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(82334);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.JBa.oxh / owR;
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
    int i = (this.JBa.oxh - owR * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(82336);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */