package com.tencent.mm.plugin.scanner.view;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "", "viewType", "", "showTips", "", "infoIconResId", "title", "", "tips", "showOpButton", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "(IZILjava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;)V", "getInfoIconResId", "()I", "getOpButtonClickListener", "()Landroid/view/View$OnClickListener;", "getShowOpButton", "()Z", "getShowTips", "getTips", "()Ljava/lang/String;", "getTitle", "getViewType", "scan-sdk_release"})
public final class a$a
{
  public final boolean Jaw;
  public final int Jax;
  public final boolean Jay;
  public final View.OnClickListener Jaz;
  public final String title;
  public final String tsf;
  private final int viewType;
  
  public a$a(int paramInt1, boolean paramBoolean1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(193582);
    this.viewType = paramInt1;
    this.Jaw = paramBoolean1;
    this.Jax = paramInt2;
    this.title = paramString1;
    this.tsf = paramString2;
    this.Jay = paramBoolean2;
    this.Jaz = paramOnClickListener;
    AppMethodBeat.o(193582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.a.a
 * JD-Core Version:    0.7.0.1
 */