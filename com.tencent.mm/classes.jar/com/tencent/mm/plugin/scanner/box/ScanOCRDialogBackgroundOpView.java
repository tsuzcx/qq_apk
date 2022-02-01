package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "opListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "viewHeight", "zoomButton", "Landroid/widget/ImageView;", "getVieHeight", "init", "", "onZoomStateChanged", "zoomState", "release", "setOpListener", "listener", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanOCRDialogBackgroundOpView
  extends RelativeLayout
  implements b
{
  public static final ScanOCRDialogBackgroundOpView.a ONU;
  private b.a ONV;
  private ImageView ONW;
  private int mbN;
  
  static
  {
    AppMethodBeat.i(313707);
    ONU = new ScanOCRDialogBackgroundOpView.a((byte)0);
    AppMethodBeat.o(313707);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(313678);
    AppMethodBeat.o(313678);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(313684);
    AppMethodBeat.o(313684);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(313690);
    this.ONW = ((ImageView)LayoutInflater.from(paramContext).inflate(l.g.OKb, (ViewGroup)this, true).findViewById(l.f.OJU));
    paramAttributeSet = this.ONW;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener(new ScanOCRDialogBackgroundOpView..ExternalSyntheticLambda0(this));
    }
    paramInt = getResources().getDimensionPixelSize(l.d.Edge_2A);
    Util.expandViewTouchArea((View)this.ONW, paramInt, paramInt, paramInt, paramInt);
    this.mbN = com.tencent.mm.cd.a.fromDPToPix(paramContext, 28);
    AppMethodBeat.o(313690);
  }
  
  private static final void a(ScanOCRDialogBackgroundOpView paramScanOCRDialogBackgroundOpView, View paramView)
  {
    AppMethodBeat.i(313697);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramScanOCRDialogBackgroundOpView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramScanOCRDialogBackgroundOpView, "this$0");
    paramScanOCRDialogBackgroundOpView = paramScanOCRDialogBackgroundOpView.ONV;
    if (paramScanOCRDialogBackgroundOpView != null) {
      paramScanOCRDialogBackgroundOpView.bVr();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(313697);
  }
  
  public final void ahH(int paramInt)
  {
    AppMethodBeat.i(313727);
    ImageView localImageView;
    if (paramInt == 1)
    {
      localImageView = this.ONW;
      if (localImageView != null)
      {
        localImageView.setImageResource(l.e.OIl);
        AppMethodBeat.o(313727);
      }
    }
    else
    {
      localImageView = this.ONW;
      if (localImageView != null) {
        localImageView.setImageResource(l.e.OIm);
      }
    }
    AppMethodBeat.o(313727);
  }
  
  public final int getVieHeight()
  {
    return this.mbN;
  }
  
  public final void release()
  {
    this.ONV = null;
  }
  
  public final void setOpListener(b.a parama)
  {
    this.ONV = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanOCRDialogBackgroundOpView
 * JD-Core Version:    0.7.0.1
 */