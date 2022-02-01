package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  extends a
{
  private static final int mHE;
  private static final int mHF;
  
  static
  {
    AppMethodBeat.i(82337);
    mHE = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 48);
    mHF = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 43);
    AppMethodBeat.o(82337);
  }
  
  private int bAY()
  {
    AppMethodBeat.i(82331);
    c localc = this.COP;
    if (localc.mHW <= 1)
    {
      Display localDisplay = ((WindowManager)ai.getContext().getSystemService("window")).getDefaultDisplay();
      localc.mHW = new int[] { localDisplay.getWidth(), localDisplay.getHeight() }[0];
    }
    int i = localc.mHW;
    AppMethodBeat.o(82331);
    return i;
  }
  
  public final int bAV()
  {
    AppMethodBeat.i(82332);
    int i = e.eXp().bAQ();
    AppMethodBeat.o(82332);
    return i;
  }
  
  public final int bAW()
  {
    AppMethodBeat.i(82333);
    int i = bAX();
    int j = getRowCount();
    AppMethodBeat.o(82333);
    return i * j;
  }
  
  public final int bAX()
  {
    AppMethodBeat.i(82335);
    if (this.COP.mHR)
    {
      AppMethodBeat.o(82335);
      return 7;
    }
    int i = bAY() / mHF;
    AppMethodBeat.o(82335);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(82334);
    if (bAW() <= 0)
    {
      AppMethodBeat.o(82334);
      return 0;
    }
    int i = e.eXp().bAQ();
    int j = bAW();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(82334);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.COP.mHV / mHE;
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
    int i = (this.COP.mHV - mHE * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(82336);
    return i;
  }
  
  public final View vX(int paramInt)
  {
    AppMethodBeat.i(82330);
    Object localObject1 = this.mHB;
    Object localObject2 = this.COP;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.COX = this;
    locald.mContext = ((Context)localObject1);
    locald.COP = ((c)localObject2);
    if ((locald.mContext == null) || (locald.COX == null))
    {
      AppMethodBeat.o(82330);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131496091, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.COP);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.COX.bAV();
      int j = locald.COX.bAW();
      int k = locald.COX.bAX();
      int m = locald.COX.getRowCount();
      int n = locald.COX.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).auB);
      ((WebViewSmileyGrid)localObject2).mHJ = paramInt;
      ((WebViewSmileyGrid)localObject2).mHH = i;
      ((WebViewSmileyGrid)localObject2).mHI = j;
      ((WebViewSmileyGrid)localObject2).mHK = n;
      ((WebViewSmileyGrid)localObject2).mHL = k;
      ((WebViewSmileyGrid)localObject2).mHM = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cc.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cc.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cc.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).COQ = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).COQ);
      ((WebViewSmileyGrid)localObject2).COQ.notifyDataSetChanged();
    }
    AppMethodBeat.o(82330);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */