package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabPaddingVertical", "init", "", "onAddTab", "tab", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "onTabSelected", "index", "onTabUnselected", "Companion", "plugin-scan_release"})
public final class ScanScrollTabView
  extends BaseScrollTabView
{
  public static final ScanScrollTabView.a yOI;
  private int yOH;
  
  static
  {
    AppMethodBeat.i(52448);
    yOI = new ScanScrollTabView.a((byte)0);
    AppMethodBeat.o(52448);
  }
  
  public ScanScrollTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52446);
    AppMethodBeat.o(52446);
  }
  
  public ScanScrollTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52447);
    this.yOH = paramContext.getResources().getDimensionPixelSize(2131165480);
    AppMethodBeat.o(52447);
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(52443);
    p.h(parama, "tab");
    if ((parama instanceof View)) {
      ((View)parama).setPadding(this.yOH, 0, this.yOH, 0);
    }
    AppMethodBeat.o(52443);
  }
  
  protected final void a(a parama, int paramInt)
  {
    AppMethodBeat.i(52444);
    p.h(parama, "tab");
    super.a(parama, paramInt);
    AppMethodBeat.o(52444);
  }
  
  protected final void b(a parama, int paramInt)
  {
    AppMethodBeat.i(52445);
    p.h(parama, "tab");
    super.b(parama, paramInt);
    AppMethodBeat.o(52445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanScrollTabView
 * JD-Core Version:    0.7.0.1
 */