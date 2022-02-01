package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanGoodsDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "Companion", "plugin-scan_release"})
public final class ScanGoodsDialogView
  extends BaseBoxDialogView
{
  public static final a CDs;
  
  static
  {
    AppMethodBeat.i(240321);
    CDs = new a((byte)0);
    AppMethodBeat.o(240321);
  }
  
  public ScanGoodsDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(240318);
    AppMethodBeat.o(240318);
  }
  
  public ScanGoodsDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(240319);
    AppMethodBeat.o(240319);
  }
  
  public ScanGoodsDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240320);
    AppMethodBeat.o(240320);
  }
  
  public final View eQ(View paramView)
  {
    AppMethodBeat.i(240316);
    p.h(paramView, "root");
    paramView = paramView.findViewById(2131298781);
    p.g(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(240316);
    return paramView;
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(240317);
    Context localContext = getContext();
    p.g(localContext, "context");
    int i = localContext.getResources().getDimensionPixelSize(2131166877);
    AppMethodBeat.o(240317);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131495186;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanGoodsDialogView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanGoodsDialogView
 * JD-Core Version:    0.7.0.1
 */