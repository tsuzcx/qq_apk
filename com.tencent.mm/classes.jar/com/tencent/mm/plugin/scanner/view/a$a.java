package com.tencent.mm.plugin.scanner.view;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "", "viewType", "", "showTips", "", "infoIconResId", "title", "", "tips", "showOpButton", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "(IZILjava/lang/String;Ljava/lang/String;ZLandroid/view/View$OnClickListener;)V", "getInfoIconResId", "()I", "getOpButtonClickListener", "()Landroid/view/View$OnClickListener;", "getShowOpButton", "()Z", "getShowTips", "getTips", "()Ljava/lang/String;", "getTitle", "getViewType", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public final boolean Pko;
  public final int Pkp;
  public final boolean Pkq;
  public final View.OnClickListener Pkr;
  public final String lym;
  public final String title;
  private final int viewType;
  
  public a$a(int paramInt1, boolean paramBoolean1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(314066);
    this.viewType = paramInt1;
    this.Pko = paramBoolean1;
    this.Pkp = paramInt2;
    this.title = paramString1;
    this.lym = paramString2;
    this.Pkq = paramBoolean2;
    this.Pkr = paramOnClickListener;
    AppMethodBeat.o(314066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.a.a
 * JD-Core Version:    0.7.0.1
 */