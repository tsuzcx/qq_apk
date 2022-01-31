package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
  extends a
{
  private static final int jpM;
  private static final int jpN;
  
  static
  {
    AppMethodBeat.i(10103);
    jpM = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 48);
    jpN = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 43);
    AppMethodBeat.o(10103);
  }
  
  private int aRI()
  {
    AppMethodBeat.i(10097);
    c localc = this.vtC;
    if (localc.jqf <= 1)
    {
      Display localDisplay = ((WindowManager)ah.getContext().getSystemService("window")).getDefaultDisplay();
      localc.jqf = new int[] { localDisplay.getWidth(), localDisplay.getHeight() }[0];
    }
    int i = localc.jqf;
    AppMethodBeat.o(10097);
    return i;
  }
  
  public final int aRF()
  {
    AppMethodBeat.i(10098);
    int i = e.dve().aRA();
    AppMethodBeat.o(10098);
    return i;
  }
  
  public final int aRG()
  {
    AppMethodBeat.i(10099);
    int i = aRH();
    int j = getRowCount();
    AppMethodBeat.o(10099);
    return i * j;
  }
  
  public final int aRH()
  {
    AppMethodBeat.i(10101);
    if (this.vtC.jqa)
    {
      AppMethodBeat.o(10101);
      return 7;
    }
    int i = aRI() / jpN;
    AppMethodBeat.o(10101);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(10100);
    if (aRG() <= 0)
    {
      AppMethodBeat.o(10100);
      return 0;
    }
    int i = e.dve().aRA();
    int j = aRG();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(10100);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.vtC.jqe / jpM;
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
    AppMethodBeat.i(10102);
    int i = (this.vtC.jqe - jpM * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(10102);
    return i;
  }
  
  public final View qE(int paramInt)
  {
    AppMethodBeat.i(10096);
    Object localObject1 = this.jpJ;
    Object localObject2 = this.vtC;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.vtK = this;
    locald.mContext = ((Context)localObject1);
    locald.vtC = ((c)localObject2);
    if ((locald.mContext == null) || (locald.vtK == null))
    {
      AppMethodBeat.o(10096);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2130971309, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.vtC);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.vtK.aRF();
      int j = locald.vtK.aRG();
      int k = locald.vtK.aRH();
      int m = locald.vtK.getRowCount();
      int n = locald.vtK.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).amh);
      ((WebViewSmileyGrid)localObject2).jpR = paramInt;
      ((WebViewSmileyGrid)localObject2).jpP = i;
      ((WebViewSmileyGrid)localObject2).jpQ = j;
      ((WebViewSmileyGrid)localObject2).jpS = n;
      ((WebViewSmileyGrid)localObject2).jpT = k;
      ((WebViewSmileyGrid)localObject2).jpU = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).vtD = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).vtD);
      ((WebViewSmileyGrid)localObject2).vtD.notifyDataSetChanged();
    }
    AppMethodBeat.o(10096);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */