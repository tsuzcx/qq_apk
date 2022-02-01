package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanImageOCRDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "onCreateView", "", "view", "Companion", "plugin-scan_release"})
public final class ScanImageOCRDialogView
  extends BaseBoxDialogView
{
  public static final a CDt;
  
  static
  {
    AppMethodBeat.i(240328);
    CDt = new a((byte)0);
    AppMethodBeat.o(240328);
  }
  
  public ScanImageOCRDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(240325);
    AppMethodBeat.o(240325);
  }
  
  public ScanImageOCRDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(240326);
    AppMethodBeat.o(240326);
  }
  
  public ScanImageOCRDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240327);
    AppMethodBeat.o(240327);
  }
  
  public final void eP(View paramView)
  {
    AppMethodBeat.i(240322);
    p.h(paramView, "view");
    super.eP(paramView);
    paramView = (TextView)paramView.findViewById(2131299657);
    p.g(paramView, "dialogTitle");
    ao.a((Paint)paramView.getPaint(), 0.8F);
    AppMethodBeat.o(240322);
  }
  
  public final View eQ(View paramView)
  {
    AppMethodBeat.i(240323);
    p.h(paramView, "root");
    paramView = paramView.findViewById(2131298781);
    p.g(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(240323);
    return paramView;
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(240324);
    Context localContext = getContext();
    p.g(localContext, "context");
    int i = localContext.getResources().getDimensionPixelSize(2131166877);
    AppMethodBeat.o(240324);
    return i;
  }
  
  public final int getLayoutId()
  {
    return 2131495188;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanImageOCRDialogView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanImageOCRDialogView
 * JD-Core Version:    0.7.0.1
 */