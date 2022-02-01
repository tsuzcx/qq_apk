package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.smiley.o;
import java.util.List;

public final class b
  extends a
{
  private static final int Xsg;
  private static final int Xsh;
  
  static
  {
    AppMethodBeat.i(82337);
    Xsg = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 48);
    Xsh = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 43);
    AppMethodBeat.o(82337);
  }
  
  private int iCM()
  {
    AppMethodBeat.i(82331);
    c localc = this.Xsf;
    if (localc.Xsw <= 1) {
      localc.Xsw = c.cSk()[0];
    }
    int i = localc.Xsw;
    AppMethodBeat.o(82331);
    return i;
  }
  
  public final View avb(int paramInt)
  {
    AppMethodBeat.i(82330);
    Object localObject1 = this.xNl;
    Object localObject2 = this.Xsf;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.Xsx = this;
    locald.mContext = ((Context)localObject1);
    locald.Xsf = ((c)localObject2);
    if ((locald.mContext == null) || (locald.Xsx == null))
    {
      AppMethodBeat.o(82330);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, c.g.webview_smiley_panel_page, null);
    if ((localObject1 instanceof WebViewSmileyGrid))
    {
      ((WebViewSmileyGrid)localObject1).setPanelManager(locald.Xsf);
      localObject2 = (WebViewSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.Xsx.iCJ();
      int j = locald.Xsx.iCK();
      int k = locald.Xsx.iCL();
      int m = locald.Xsx.getRowCount();
      int n = locald.Xsx.getRowSpacing();
      ((WebViewSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((WebViewSmileyGrid)localObject2).setBackgroundResource(0);
      ((WebViewSmileyGrid)localObject2).setStretchMode(2);
      ((WebViewSmileyGrid)localObject2).setOnItemClickListener(((WebViewSmileyGrid)localObject2).vT);
      ((WebViewSmileyGrid)localObject2).uQL = paramInt;
      ((WebViewSmileyGrid)localObject2).Xsj = i;
      ((WebViewSmileyGrid)localObject2).Xsk = j;
      ((WebViewSmileyGrid)localObject2).Xsl = n;
      ((WebViewSmileyGrid)localObject2).Xsm = k;
      ((WebViewSmileyGrid)localObject2).Xsn = m;
      ((WebViewSmileyGrid)localObject2).setNumColumns(k);
      i = ((WebViewSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cd.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cd.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cd.a.fromDPToPix(((WebViewSmileyGrid)localObject2).getContext(), 6);
      }
      ((WebViewSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((WebViewSmileyGrid)localObject2).Xsi = new WebViewSmileyGrid.a((WebViewSmileyGrid)localObject2, (byte)0);
      ((WebViewSmileyGrid)localObject2).setAdapter(((WebViewSmileyGrid)localObject2).Xsi);
      ((WebViewSmileyGrid)localObject2).Xsi.notifyDataSetChanged();
    }
    AppMethodBeat.o(82330);
    return localObject1;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(82334);
    if (iCK() <= 0)
    {
      AppMethodBeat.o(82334);
      return 0;
    }
    int i = iCJ();
    int j = iCK();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(82334);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.Xsf.Xsv / Xsg;
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
    int i = (this.Xsf.Xsv - Xsg * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(82336);
    return i;
  }
  
  public final int iCJ()
  {
    AppMethodBeat.i(82332);
    o localo = c.iCQ();
    if (localo.acyr == null)
    {
      AppMethodBeat.o(82332);
      return 0;
    }
    int i = localo.acyr.size();
    AppMethodBeat.o(82332);
    return i;
  }
  
  public final int iCK()
  {
    AppMethodBeat.i(82333);
    int i = iCL();
    int j = getRowCount();
    AppMethodBeat.o(82333);
    return i * j;
  }
  
  public final int iCL()
  {
    AppMethodBeat.i(82335);
    if (this.Xsf.Xsr)
    {
      AppMethodBeat.o(82335);
      return 7;
    }
    int i = iCM() / Xsh;
    AppMethodBeat.o(82335);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.input.b
 * JD-Core Version:    0.7.0.1
 */