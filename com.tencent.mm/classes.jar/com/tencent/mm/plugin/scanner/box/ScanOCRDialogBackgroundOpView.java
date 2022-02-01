package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "opListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel$OpListener;", "viewHeight", "zoomButton", "Landroid/widget/ImageView;", "getVieHeight", "init", "", "onZoomStateChanged", "zoomState", "release", "setOpListener", "listener", "Companion", "plugin-scan_release"})
public final class ScanOCRDialogBackgroundOpView
  extends RelativeLayout
  implements b
{
  public static final a CDw;
  private b.a CDu;
  private ImageView CDv;
  private int gRE;
  
  static
  {
    AppMethodBeat.i(240334);
    CDw = new a((byte)0);
    AppMethodBeat.o(240334);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(240331);
    AppMethodBeat.o(240331);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(240332);
    AppMethodBeat.o(240332);
  }
  
  public ScanOCRDialogBackgroundOpView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(240333);
    this.CDv = ((ImageView)LayoutInflater.from(paramContext).inflate(2131495189, (ViewGroup)this, true).findViewById(2131310682));
    paramAttributeSet = this.CDv;
    if (paramAttributeSet != null) {
      paramAttributeSet.setOnClickListener((View.OnClickListener)new b(this));
    }
    this.gRE = com.tencent.mm.cb.a.fromDPToPix(paramContext, 28);
    AppMethodBeat.o(240333);
  }
  
  public final void Ws(int paramInt)
  {
    AppMethodBeat.i(240330);
    if (paramInt == 1)
    {
      localImageView = this.CDv;
      if (localImageView != null)
      {
        localImageView.setImageResource(2131233153);
        AppMethodBeat.o(240330);
        return;
      }
      AppMethodBeat.o(240330);
      return;
    }
    ImageView localImageView = this.CDv;
    if (localImageView != null)
    {
      localImageView.setImageResource(2131233154);
      AppMethodBeat.o(240330);
      return;
    }
    AppMethodBeat.o(240330);
  }
  
  public final int getVieHeight()
  {
    return this.gRE;
  }
  
  public final void release()
  {
    this.CDu = null;
  }
  
  public final void setOpListener(b.a parama)
  {
    this.CDu = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(ScanOCRDialogBackgroundOpView paramScanOCRDialogBackgroundOpView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240329);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = ScanOCRDialogBackgroundOpView.a(this.CDx);
      if (paramView != null) {
        paramView.bmr();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/box/ScanOCRDialogBackgroundOpView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240329);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.ScanOCRDialogBackgroundOpView
 * JD-Core Version:    0.7.0.1
 */