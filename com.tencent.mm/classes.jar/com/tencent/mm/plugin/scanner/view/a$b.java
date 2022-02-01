package com.tencent.mm.plugin.scanner.view;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParamsBuilder;", "", "viewType", "", "(I)V", "infoIconResId", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "showOpButton", "", "showTips", "tips", "", "title", "build", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "setInfoIconResId", "iconResId", "setOpButton", "show", "clickListener", "setTips", "setTitle", "scan-sdk_release"})
public final class a$b
{
  public int CUX = -1;
  public boolean CUY;
  public View.OnClickListener CUZ;
  public boolean mVp;
  public String pWf = "";
  public int qcr;
  public String title = "";
  
  public a$b(int paramInt)
  {
    this.qcr = paramInt;
  }
  
  public final b aMW(String paramString)
  {
    AppMethodBeat.i(194808);
    p.h(paramString, "title");
    this.title = paramString;
    AppMethodBeat.o(194808);
    return this;
  }
  
  public final b aMX(String paramString)
  {
    AppMethodBeat.i(194809);
    p.h(paramString, "tips");
    this.pWf = paramString;
    AppMethodBeat.o(194809);
    return this;
  }
  
  public final b e(View.OnClickListener paramOnClickListener)
  {
    this.CUY = true;
    this.CUZ = paramOnClickListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.a.b
 * JD-Core Version:    0.7.0.1
 */