package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanDebugView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "debugInfo", "Landroid/widget/TextView;", "init", "", "onPreviewReady", "updateDebugView", "info", "Landroid/os/Bundle;", "Companion", "plugin-scan_release"})
public final class ScanDebugView
  extends RelativeLayout
{
  public static final a vYT;
  public TextView vYS;
  
  static
  {
    AppMethodBeat.i(195461);
    vYT = new a((byte)0);
    AppMethodBeat.o(195461);
  }
  
  public ScanDebugView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(195458);
    AppMethodBeat.o(195458);
  }
  
  public ScanDebugView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(195459);
    AppMethodBeat.o(195459);
  }
  
  public ScanDebugView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195460);
    paramContext = LayoutInflater.from(paramContext).inflate(2131494566, (ViewGroup)this).findViewById(2131304311);
    k.g(paramContext, "view.findViewById(R.id.scan_debug_info)");
    this.vYS = ((TextView)paramContext);
    setVisibility(8);
    AppMethodBeat.o(195460);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanDebugView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView
 * JD-Core Version:    0.7.0.1
 */