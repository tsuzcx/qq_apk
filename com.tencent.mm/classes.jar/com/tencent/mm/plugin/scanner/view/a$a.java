package com.tencent.mm.plugin.scanner.view;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "", "viewType", "", "showTips", "", "infoIconResId", "title", "", "tips", "showOpButton", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "(IZILjava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;)V", "getInfoIconResId", "()I", "getOpButtonClickListener", "()Landroid/view/View$OnClickListener;", "getShowOpButton", "()Z", "getShowTips", "getTips", "()Ljava/lang/String;", "getTitle", "getViewType", "scan-sdk_release"})
public final class a$a
{
  public final int CUX;
  public final boolean CUY;
  public final View.OnClickListener CUZ;
  public final boolean mVp;
  public final String pWf;
  private final int qcr;
  public final String title;
  
  public a$a(int paramInt1, boolean paramBoolean1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(194807);
    this.qcr = paramInt1;
    this.mVp = paramBoolean1;
    this.CUX = paramInt2;
    this.title = paramString1;
    this.pWf = paramString2;
    this.CUY = paramBoolean2;
    this.CUZ = paramOnClickListener;
    AppMethodBeat.o(194807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.a.a
 * JD-Core Version:    0.7.0.1
 */