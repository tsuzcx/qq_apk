package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanDebugView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "debugInfo", "Landroid/widget/TextView;", "init", "", "onPreviewReady", "updateDebugView", "info", "Landroid/os/Bundle;", "Companion", "plugin-scan_release"})
public final class ScanDebugView
  extends RelativeLayout
{
  public static final ScanDebugView.a yOb;
  public TextView yOa;
  
  static
  {
    AppMethodBeat.i(189694);
    yOb = new ScanDebugView.a((byte)0);
    AppMethodBeat.o(189694);
  }
  
  public ScanDebugView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(189691);
    AppMethodBeat.o(189691);
  }
  
  public ScanDebugView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(189692);
    AppMethodBeat.o(189692);
  }
  
  public ScanDebugView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(189693);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494566, (ViewGroup)this).findViewById(2131304311);
    p.g(paramContext, "view.findViewById(R.id.scan_debug_info)");
    this.yOa = ((TextView)paramContext);
    setVisibility(8);
    AppMethodBeat.o(189693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView
 * JD-Core Version:    0.7.0.1
 */