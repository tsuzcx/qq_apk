package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
  extends a
{
  private static final int nic;
  private static final int nid;
  
  static
  {
    AppMethodBeat.i(82337);
    nic = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 48);
    nid = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 43);
    AppMethodBeat.o(82337);
  }
  
  private int bFa()
  {
    AppMethodBeat.i(82331);
    c localc = this.EsP;
    if (localc.niu <= 1)
    {
      Display localDisplay = ((WindowManager)aj.getContext().getSystemService("window")).getDefaultDisplay();
      localc.niu = new int[] { localDisplay.getWidth(), localDisplay.getHeight() }[0];
    }
    int i = localc.niu;
    AppMethodBeat.o(82331);
    return i;
  }
  
  public final int bEX()
  {
    AppMethodBeat.i(82332);
    int i = e.fmZ().bES();
    AppMethodBeat.o(82332);
    return i;
  }
  
  public final int bEY()
  {
    AppMethodBeat.i(82333);
    int i = bEZ();
    int j = getRowCount();
    AppMethodBeat.o(82333);
    return i * j;
  }
  
  public final int bEZ()
  {
    AppMethodBeat.i(82335);
    if (this.EsP.nip)
    {
      AppMethodBeat.o(82335);
      return 7;
    }
    int i = bFa() / nid;
    AppMethodBeat.o(82335);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(82334);
    if (bEY() <= 0)
    {
      AppMethodBeat.o(82334);
      return 0;
    }
    int i = e.fmZ().bES();
    int j = bEY();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(82334);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.EsP.nit / nic;
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
    int i = (this.EsP.nit - nic * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(82336);
    return i;
  }
  
  public final View wC(int paramInt)
  {
    AppMethodBeat.i(82330);
    Object localObject1 = this.nhZ;
    Object localObject2 = this.EsP;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.EsX = this;
    locald.mContext = ((Context)localObject1);
    locald.EsP = ((c)localObject2);
    if ((locald.mContext == null) || (locald.EsX == null))
    {
      AppMethodBeat.o(82330);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131496091, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.EsP);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.EsX.bEX();
      int j = locald.EsX.bEY();
      int k = locald.EsX.bEZ();
      int m = locald.EsX.getRowCount();
      int n = locald.EsX.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).awt);
      ((WebViewSmileyGrid)localObject2).nih = paramInt;
      ((WebViewSmileyGrid)localObject2).nif = i;
      ((WebViewSmileyGrid)localObject2).nig = j;
      ((WebViewSmileyGrid)localObject2).nii = n;
      ((WebViewSmileyGrid)localObject2).nij = k;
      ((WebViewSmileyGrid)localObject2).nik = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cc.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cc.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cc.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).EsQ = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).EsQ);
      ((WebViewSmileyGrid)localObject2).EsQ.notifyDataSetChanged();
    }
    AppMethodBeat.o(82330);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */