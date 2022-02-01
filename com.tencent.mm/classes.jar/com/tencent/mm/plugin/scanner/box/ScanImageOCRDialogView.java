package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanImageOCRDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "onCreateView", "", "view", "Companion", "plugin-scan_release"})
public final class ScanImageOCRDialogView
  extends BaseBoxDialogView
{
  public static final a IHT;
  
  static
  {
    AppMethodBeat.i(222623);
    IHT = new a((byte)0);
    AppMethodBeat.o(222623);
  }
  
  public ScanImageOCRDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(222619);
    AppMethodBeat.o(222619);
  }
  
  public ScanImageOCRDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(222620);
    AppMethodBeat.o(222620);
  }
  
  public ScanImageOCRDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(222622);
    AppMethodBeat.o(222622);
  }
  
  public final View eW(View paramView)
  {
    AppMethodBeat.i(222614);
    p.k(paramView, "root");
    paramView = paramView.findViewById(l.f.close_img);
    p.j(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(222614);
    return paramView;
  }
  
  public final void fU(View paramView)
  {
    AppMethodBeat.i(222613);
    p.k(paramView, "view");
    super.fU(paramView);
    paramView = (TextView)paramView.findViewById(l.f.dialog_title);
    p.j(paramView, "dialogTitle");
    ar.a((Paint)paramView.getPaint(), 0.8F);
    AppMethodBeat.o(222613);
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(222615);
    Context localContext = getContext();
    p.j(localContext, "context");
    int i = localContext.getResources().getDimensionPixelSize(l.d.ICb);
    AppMethodBeat.o(222615);
    return i;
  }
  
  public final int getLayoutId()
  {
    return l.g.IDX;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanImageOCRDialogView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanImageOCRDialogView
 * JD-Core Version:    0.7.0.1
 */