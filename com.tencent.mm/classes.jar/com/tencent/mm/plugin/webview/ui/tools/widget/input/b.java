package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.mm.R.i;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a
{
  private static final int hxC = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 48);
  private static final int hxD = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 43);
  
  public final int asC()
  {
    return e.csH().asw();
  }
  
  public final int asD()
  {
    return asE() * getRowCount();
  }
  
  public final int asE()
  {
    if (this.rDq.hxQ) {
      return 7;
    }
    c localc = this.rDq;
    if (localc.hxV <= 1)
    {
      Display localDisplay = ((WindowManager)ae.getContext().getSystemService("window")).getDefaultDisplay();
      localc.hxV = new int[] { localDisplay.getWidth(), localDisplay.getHeight() }[0];
    }
    return localc.hxV / hxD;
  }
  
  public final int getPageCount()
  {
    if (asD() <= 0) {
      return 0;
    }
    int i = e.csH().asw();
    int j = asD();
    return (int)Math.ceil(i / j);
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.rDq.hxU / hxC;
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
    return (this.rDq.hxU - hxC * getRowCount()) / (getRowCount() + 1);
  }
  
  public final View na(int paramInt)
  {
    View localView = null;
    Object localObject = this.hxz;
    c localc = this.rDq;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.rDy = this;
    locald.mContext = ((Context)localObject);
    locald.rDq = localc;
    localObject = localView;
    if (locald.mContext != null)
    {
      if (locald.rDy != null) {
        break label77;
      }
      localObject = localView;
    }
    label77:
    do
    {
      return localObject;
      localView = View.inflate(locald.mContext, R.i.webview_smiley_panel_page, null);
      localObject = localView;
    } while (!(localView instanceof WebViewSmileyGrid));
    ((WebViewSmileyGrid)localView).setPanelManager(locald.rDq);
    localObject = (WebViewSmileyGrid)localView;
    paramInt = locald.mIndex;
    int i = locald.rDy.asC();
    int j = locald.rDy.asD();
    int k = locald.rDy.asE();
    int m = locald.rDy.getRowCount();
    int n = locald.rDy.getRowSpacing();
    ((WebViewSmileyGrid)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((WebViewSmileyGrid)localObject).setBackgroundResource(0);
    ((WebViewSmileyGrid)localObject).setStretchMode(2);
    ((WebViewSmileyGrid)localObject).setOnItemClickListener(((WebViewSmileyGrid)localObject).ajR);
    ((WebViewSmileyGrid)localObject).hxH = paramInt;
    ((WebViewSmileyGrid)localObject).hxF = i;
    ((WebViewSmileyGrid)localObject).hxG = j;
    ((WebViewSmileyGrid)localObject).hxI = n;
    ((WebViewSmileyGrid)localObject).hxJ = k;
    ((WebViewSmileyGrid)localObject).hxK = m;
    ((WebViewSmileyGrid)localObject).setNumColumns(k);
    i = ((WebViewSmileyGrid)localObject).getRowSpacing();
    j = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject).getContext(), 6);
    k = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject).getContext(), 6);
    paramInt = i;
    if (i == 0) {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(((WebViewSmileyGrid)localObject).getContext(), 6);
    }
    ((WebViewSmileyGrid)localObject).setPadding(j, paramInt, k, 0);
    ((WebViewSmileyGrid)localObject).rDr = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject, (byte)0);
    ((WebViewSmileyGrid)localObject).setAdapter(((WebViewSmileyGrid)localObject).rDr);
    ((WebViewSmileyGrid)localObject).rDr.notifyDataSetChanged();
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */