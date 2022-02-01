package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.sdk.platformtools.ak;

public final class b
  extends a
{
  private static final int nnk;
  private static final int nnl;
  
  static
  {
    AppMethodBeat.i(82337);
    nnk = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 48);
    nnl = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 43);
    AppMethodBeat.o(82337);
  }
  
  private int bFS()
  {
    AppMethodBeat.i(82331);
    c localc = this.ELj;
    if (localc.nnC <= 1)
    {
      Display localDisplay = ((WindowManager)ak.getContext().getSystemService("window")).getDefaultDisplay();
      localc.nnC = new int[] { localDisplay.getWidth(), localDisplay.getHeight() }[0];
    }
    int i = localc.nnC;
    AppMethodBeat.o(82331);
    return i;
  }
  
  public final int bFP()
  {
    AppMethodBeat.i(82332);
    int i = e.fqT().bFK();
    AppMethodBeat.o(82332);
    return i;
  }
  
  public final int bFQ()
  {
    AppMethodBeat.i(82333);
    int i = bFR();
    int j = getRowCount();
    AppMethodBeat.o(82333);
    return i * j;
  }
  
  public final int bFR()
  {
    AppMethodBeat.i(82335);
    if (this.ELj.nnx)
    {
      AppMethodBeat.o(82335);
      return 7;
    }
    int i = bFS() / nnl;
    AppMethodBeat.o(82335);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(82334);
    if (bFQ() <= 0)
    {
      AppMethodBeat.o(82334);
      return 0;
    }
    int i = e.fqT().bFK();
    int j = bFQ();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(82334);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.ELj.nnB / nnk;
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
    int i = (this.ELj.nnB - nnk * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(82336);
    return i;
  }
  
  public final View wH(int paramInt)
  {
    AppMethodBeat.i(82330);
    Object localObject1 = this.nnh;
    Object localObject2 = this.ELj;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.ELr = this;
    locald.mContext = ((Context)localObject1);
    locald.ELj = ((c)localObject2);
    if ((locald.mContext == null) || (locald.ELr == null))
    {
      AppMethodBeat.o(82330);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131496091, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.ELj);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.ELr.bFP();
      int j = locald.ELr.bFQ();
      int k = locald.ELr.bFR();
      int m = locald.ELr.getRowCount();
      int n = locald.ELr.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).awt);
      ((WebViewSmileyGrid)localObject2).nnp = paramInt;
      ((WebViewSmileyGrid)localObject2).nnn = i;
      ((WebViewSmileyGrid)localObject2).nno = j;
      ((WebViewSmileyGrid)localObject2).nnq = n;
      ((WebViewSmileyGrid)localObject2).nnr = k;
      ((WebViewSmileyGrid)localObject2).nns = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).ELk = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).ELk);
      ((WebViewSmileyGrid)localObject2).ELk.notifyDataSetChanged();
    }
    AppMethodBeat.o(82330);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */