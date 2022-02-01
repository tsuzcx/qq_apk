package com.tencent.mm.plugin.scanner.view;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParamsBuilder;", "", "viewType", "", "(I)V", "infoIconResId", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "showOpButton", "", "showTips", "tips", "", "title", "build", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "setInfoIconResId", "iconResId", "setOpButton", "show", "clickListener", "setTips", "setTitle", "scan-sdk_release"})
public final class a$b
{
  public boolean Jaw;
  public int Jax = -1;
  public boolean Jay;
  public View.OnClickListener Jaz;
  public String title = "";
  public String tsf = "";
  public int viewType;
  
  public a$b(int paramInt)
  {
    this.viewType = paramInt;
  }
  
  public final b aXG(String paramString)
  {
    AppMethodBeat.i(193699);
    p.k(paramString, "title");
    this.title = paramString;
    AppMethodBeat.o(193699);
    return this;
  }
  
  public final b aXH(String paramString)
  {
    AppMethodBeat.i(193700);
    p.k(paramString, "tips");
    this.tsf = paramString;
    AppMethodBeat.o(193700);
    return this;
  }
  
  public final b f(View.OnClickListener paramOnClickListener)
  {
    this.Jay = true;
    this.Jaz = paramOnClickListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.a.b
 * JD-Core Version:    0.7.0.1
 */