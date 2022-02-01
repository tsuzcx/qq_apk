package com.tencent.mm.plugin.webview.ui.tools;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.h;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import java.util.ArrayList;

final class WebViewLongClickHelper$12$1
  implements h
{
  WebViewLongClickHelper$12$1(WebViewLongClickHelper.12 param12) {}
  
  public final void a(ImageQBarDataBean paramImageQBarDataBean, ArrayList<ImageQBarDataBean> paramArrayList) {}
  
  public final void a(ArrayList<PointF> paramArrayList, ArrayList<ImageQBarDataBean> paramArrayList1, ArrayList<ImageQBarDataBean> paramArrayList2)
  {
    AppMethodBeat.i(293218);
    WebViewLongClickHelper.a(this.SuM.Qdp, paramArrayList2, paramArrayList, paramArrayList1);
    paramArrayList1 = j.IAG;
    j.b(this.SuM.Qdp.BrO.longValue(), paramArrayList2.size(), paramArrayList.size(), 3, this.SuM.Qdp.gXq().PIQ.PFK);
    if (paramArrayList.size() > 1)
    {
      paramArrayList = j.IAG;
      j.a(this.SuM.Qdp.BrO.longValue(), 11, paramArrayList2, null, this.SuM.Qdp.BrP.longValue(), 1);
    }
    AppMethodBeat.o(293218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewLongClickHelper.12.1
 * JD-Core Version:    0.7.0.1
 */