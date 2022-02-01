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
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanImageOCRDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "onCreateView", "", "view", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanImageOCRDialogView
  extends BaseBoxDialogView
{
  public static final ScanImageOCRDialogView.a ONT;
  
  static
  {
    AppMethodBeat.i(313731);
    ONT = new ScanImageOCRDialogView.a((byte)0);
    AppMethodBeat.o(313731);
  }
  
  public ScanImageOCRDialogView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(313717);
    AppMethodBeat.o(313717);
  }
  
  public ScanImageOCRDialogView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(313721);
    AppMethodBeat.o(313721);
  }
  
  public ScanImageOCRDialogView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(313725);
    AppMethodBeat.o(313725);
  }
  
  public final View jdMethod_do(View paramView)
  {
    AppMethodBeat.i(313744);
    s.u(paramView, "root");
    paramView = paramView.findViewById(l.f.close_img);
    s.s(paramView, "root.findViewById(R.id.close_img)");
    AppMethodBeat.o(313744);
    return paramView;
  }
  
  public final int getCloseLayoutHeight()
  {
    AppMethodBeat.i(313749);
    int i = getContext().getResources().getDimensionPixelSize(l.d.OId);
    AppMethodBeat.o(313749);
    return i;
  }
  
  public final int getLayoutId()
  {
    return l.g.OKa;
  }
  
  public final void iV(View paramView)
  {
    AppMethodBeat.i(313735);
    s.u(paramView, "view");
    super.iV(paramView);
    aw.a((Paint)((TextView)paramView.findViewById(l.f.dialog_title)).getPaint(), 0.8F);
    AppMethodBeat.o(313735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanImageOCRDialogView
 * JD-Core Version:    0.7.0.1
 */