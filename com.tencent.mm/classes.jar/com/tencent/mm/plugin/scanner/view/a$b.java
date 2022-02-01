package com.tencent.mm.plugin.scanner.view;

import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParamsBuilder;", "", "viewType", "", "(I)V", "infoIconResId", "opButtonClickListener", "Landroid/view/View$OnClickListener;", "showOpButton", "", "showTips", "tips", "", "title", "build", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "setInfoIconResId", "iconResId", "setOpButton", "show", "clickListener", "setTips", "setTitle", "scan-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
{
  public boolean Pko;
  public int Pkp = -1;
  public boolean Pkq;
  public View.OnClickListener Pkr;
  public String lym = "";
  public String title = "";
  public int viewType;
  
  public a$b(int paramInt)
  {
    this.viewType = paramInt;
  }
  
  public final b aVp(String paramString)
  {
    AppMethodBeat.i(314071);
    s.u(paramString, "title");
    this.title = paramString;
    AppMethodBeat.o(314071);
    return this;
  }
  
  public final b aVq(String paramString)
  {
    AppMethodBeat.i(314073);
    s.u(paramString, "tips");
    this.lym = paramString;
    AppMethodBeat.o(314073);
    return this;
  }
  
  public final b f(View.OnClickListener paramOnClickListener)
  {
    this.Pkq = true;
    this.Pkr = paramOnClickListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.a.b
 * JD-Core Version:    0.7.0.1
 */