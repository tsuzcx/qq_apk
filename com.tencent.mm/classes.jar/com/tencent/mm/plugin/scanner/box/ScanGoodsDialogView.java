package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanGoodsDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "Companion", "plugin-scan_release"})
public final class ScanGoodsDialogView
  extends BaseBoxDialogView
{
  public static final a IHS;
  
  static
  {
    AppMethodBeat.i(218426);
    IHS = new a((byte)0);
    AppMethodBeat.o(218426);
  }
  
  public ScanGoodsDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(218423);
    AppMethodBeat.o(218423);
  }
  
  public ScanGoodsDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(218424);
    AppMethodBeat.o(218424);
  }
  
  public ScanGoodsDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(218425);
    AppMethodBeat.o(218425);
  }
  
  public final View eW(View paramView)
  {
    AppMethodBeat.i(218421);
    p.k(paramView, "root");
    paramView = paramView.findViewById(l.f.close_img);
    p.j(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(218421);
    return paramView;
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(218422);
    Context localContext = getContext();
    p.j(localContext, "context");
    int i = localContext.getResources().getDimensionPixelSize(l.d.ICb);
    AppMethodBeat.o(218422);
    return i;
  }
  
  public final int getLayoutId()
  {
    return l.g.IDV;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanGoodsDialogView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanGoodsDialogView
 * JD-Core Version:    0.7.0.1
 */