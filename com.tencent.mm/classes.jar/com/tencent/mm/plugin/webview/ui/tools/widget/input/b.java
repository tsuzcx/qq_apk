package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.e;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
  extends a
{
  private static final int mfF;
  private static final int mfG;
  
  static
  {
    AppMethodBeat.i(82337);
    mfF = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 48);
    mfG = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 43);
    AppMethodBeat.o(82337);
  }
  
  private int btZ()
  {
    AppMethodBeat.i(82331);
    c localc = this.BwH;
    if (localc.mfX <= 1)
    {
      Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
      localc.mfX = new int[] { localDisplay.getWidth(), localDisplay.getHeight() }[0];
    }
    int i = localc.mfX;
    AppMethodBeat.o(82331);
    return i;
  }
  
  public final int btW()
  {
    AppMethodBeat.i(82332);
    int i = e.eHT().btR();
    AppMethodBeat.o(82332);
    return i;
  }
  
  public final int btX()
  {
    AppMethodBeat.i(82333);
    int i = btY();
    int j = getRowCount();
    AppMethodBeat.o(82333);
    return i * j;
  }
  
  public final int btY()
  {
    AppMethodBeat.i(82335);
    if (this.BwH.mfS)
    {
      AppMethodBeat.o(82335);
      return 7;
    }
    int i = btZ() / mfG;
    AppMethodBeat.o(82335);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(82334);
    if (btX() <= 0)
    {
      AppMethodBeat.o(82334);
      return 0;
    }
    int i = e.eHT().btR();
    int j = btX();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(82334);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.BwH.mfW / mfF;
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
    int i = (this.BwH.mfW - mfF * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(82336);
    return i;
  }
  
  public final View vg(int paramInt)
  {
    AppMethodBeat.i(82330);
    Object localObject1 = this.mfC;
    Object localObject2 = this.BwH;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.BwP = this;
    locald.mContext = ((Context)localObject1);
    locald.BwH = ((c)localObject2);
    if ((locald.mContext == null) || (locald.BwP == null))
    {
      AppMethodBeat.o(82330);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131496091, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.BwH);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.BwP.btW();
      int j = locald.BwP.btX();
      int k = locald.BwP.btY();
      int m = locald.BwP.getRowCount();
      int n = locald.BwP.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).atG);
      ((WebViewSmileyGrid)localObject2).mfK = paramInt;
      ((WebViewSmileyGrid)localObject2).mfI = i;
      ((WebViewSmileyGrid)localObject2).mfJ = j;
      ((WebViewSmileyGrid)localObject2).mfL = n;
      ((WebViewSmileyGrid)localObject2).mfM = k;
      ((WebViewSmileyGrid)localObject2).mfN = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cd.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cd.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cd.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).BwI = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).BwI);
      ((WebViewSmileyGrid)localObject2).BwI.notifyDataSetChanged();
    }
    AppMethodBeat.o(82330);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */