package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanGoodsDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanGoodsDialogView
  extends BaseBoxDialogView
{
  public static final ScanGoodsDialogView.a ONS;
  
  static
  {
    AppMethodBeat.i(313720);
    ONS = new ScanGoodsDialogView.a((byte)0);
    AppMethodBeat.o(313720);
  }
  
  public ScanGoodsDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(313706);
    AppMethodBeat.o(313706);
  }
  
  public ScanGoodsDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(313709);
    AppMethodBeat.o(313709);
  }
  
  public ScanGoodsDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(313716);
    AppMethodBeat.o(313716);
  }
  
  public final View jdMethod_do(View paramView)
  {
    AppMethodBeat.i(313730);
    s.u(paramView, "root");
    paramView = paramView.findViewById(l.f.close_img);
    s.s(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(313730);
    return paramView;
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(313734);
    int i = getContext().getResources().getDimensionPixelSize(l.d.OId);
    AppMethodBeat.o(313734);
    return i;
  }
  
  public final int getLayoutId()
  {
    return l.g.OJY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanGoodsDialogView
 * JD-Core Version:    0.7.0.1
 */