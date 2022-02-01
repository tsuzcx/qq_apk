package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanDebugView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "debugInfo", "Landroid/widget/TextView;", "init", "", "onPreviewReady", "updateDebugView", "info", "Landroid/os/Bundle;", "Companion", "plugin-scan_release"})
public final class ScanDebugView
  extends RelativeLayout
{
  public static final a CRR;
  public TextView zUR;
  
  static
  {
    AppMethodBeat.i(240642);
    CRR = new a((byte)0);
    AppMethodBeat.o(240642);
  }
  
  public ScanDebugView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(240639);
    AppMethodBeat.o(240639);
  }
  
  public ScanDebugView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(240640);
    AppMethodBeat.o(240640);
  }
  
  public ScanDebugView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240641);
    paramContext = LayoutInflater.from(paramContext).inflate(2131495185, (ViewGroup)this).findViewById(2131307239);
    p.g(paramContext, "view.findViewById(R.id.scan_debug_info)");
    this.zUR = ((TextView)paramContext);
    setVisibility(8);
    AppMethodBeat.o(240641);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanDebugView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView
 * JD-Core Version:    0.7.0.1
 */