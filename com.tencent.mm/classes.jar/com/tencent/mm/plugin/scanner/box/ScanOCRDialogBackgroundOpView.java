package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "opListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "viewHeight", "zoomButton", "Landroid/widget/ImageView;", "getVieHeight", "init", "", "onZoomStateChanged", "zoomState", "release", "setOpListener", "listener", "Companion", "plugin-scan_release"})
public final class ScanOCRDialogBackgroundOpView
  extends RelativeLayout
  implements b
{
  public static final ScanOCRDialogBackgroundOpView.a IHW;
  private b.a IHU;
  private ImageView IHV;
  private int jCa;
  
  static
  {
    AppMethodBeat.i(219896);
    IHW = new ScanOCRDialogBackgroundOpView.a((byte)0);
    AppMethodBeat.o(219896);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(219891);
    AppMethodBeat.o(219891);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(219893);
    AppMethodBeat.o(219893);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(219895);
    this.IHV = ((ImageView)LayoutInflater.from(paramContext).inflate(l.g.IDY, (ViewGroup)this, true).findViewById(l.f.IDS));
    paramAttributeSet = this.IHV;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)new b(this));
    }
    paramInt = getResources().getDimensionPixelSize(l.d.Edge_2A);
    Util.expandViewTouchArea((View)this.IHV, paramInt, paramInt, paramInt, paramInt);
    this.jCa = com.tencent.mm.ci.a.fromDPToPix(paramContext, 28);
    AppMethodBeat.o(219895);
  }
  
  public final void adk(int paramInt)
  {
    AppMethodBeat.i(219889);
    if (paramInt == 1)
    {
      localImageView = this.IHV;
      if (localImageView != null)
      {
        localImageView.setImageResource(l.e.ICj);
        AppMethodBeat.o(219889);
        return;
      }
      AppMethodBeat.o(219889);
      return;
    }
    ImageView localImageView = this.IHV;
    if (localImageView != null)
    {
      localImageView.setImageResource(l.e.ICk);
      AppMethodBeat.o(219889);
      return;
    }
    AppMethodBeat.o(219889);
  }
  
  public final int getVieHeight()
  {
    return this.jCa;
  }
  
  public final void release()
  {
    this.IHU = null;
  }
  
  public final void setOpListener(b.a parama)
  {
    this.IHU = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ScanOCRDialogBackgroundOpView paramScanOCRDialogBackgroundOpView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(217113);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = ScanOCRDialogBackgroundOpView.a(this.IHX);
      if (paramView != null) {
        paramView.bwz();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(217113);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanOCRDialogBackgroundOpView
 * JD-Core Version:    0.7.0.1
 */