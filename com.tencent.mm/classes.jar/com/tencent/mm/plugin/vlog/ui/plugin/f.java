package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import d.g.a.b;
import d.g.b.k;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$cropChangeListener$1;", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$operationCallback$1;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoSize", "Landroid/util/Size;", "visibleRect", "Landroid/graphics/RectF;", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "setVideoSize", "size", "setVisibleRect", "rect", "plugin-vlog_release"})
public final class f
  implements c
{
  private r AmR;
  public final RectF Ann;
  final com.tencent.mm.plugin.vlog.model.d AoD;
  final d Atj;
  private Size Atn;
  private final a Ato;
  private final c Atp;
  private final String TAG;
  
  public f(d paramd)
  {
    AppMethodBeat.i(207818);
    this.Atj = paramd;
    this.TAG = "MicroMsg.VLogPreviewImpl";
    this.Ann = new RectF();
    this.AoD = new com.tencent.mm.plugin.vlog.model.d();
    this.Ato = new a(this);
    this.Atp = new c(this);
    AppMethodBeat.o(207818);
  }
  
  public final void a(Size paramSize)
  {
    AppMethodBeat.i(207817);
    k.h(paramSize, "size");
    ac.i(this.TAG, "setVideoSize: ".concat(String.valueOf(paramSize)));
    this.Atn = paramSize;
    AppMethodBeat.o(207817);
  }
  
  public final Rect ege()
  {
    return null;
  }
  
  public final CropLayout.c egl()
  {
    return (CropLayout.c)this.Ato;
  }
  
  public final WxCropOperationLayout.i egm()
  {
    return (WxCropOperationLayout.i)this.Atp;
  }
  
  public final void h(final r paramr)
  {
    AppMethodBeat.i(207816);
    k.h(paramr, "composition");
    ac.i(this.TAG, "onPreview: ");
    if ((k.g(this.AmR, paramr)) && (k.g(this.Atj.egi().getParent(), this.Atj.egh())))
    {
      this.Atj.egi().a(paramr);
      AppMethodBeat.o(207816);
      return;
    }
    this.AmR = paramr;
    this.Atj.egh().ya(true);
    this.Atj.egh().setEnableScale(true);
    ViewParent localViewParent = this.Atj.egi().getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.Atj.egi());
    }
    this.Atj.egi().a(paramr);
    this.Ann.set(this.Atj.getOperationLayout().getVisibilityRect());
    this.Atj.egh().getVisibilityRect().set(this.Ann);
    paramr = ((Iterable)paramr.AnT).iterator();
    while (paramr.hasNext())
    {
      localObject = (u)paramr.next();
      this.Ann.round(((u)localObject).AoD.viewRect);
    }
    int k = this.Atj.egg().getWidth();
    int m = (int)(this.Atj.egg().getWidth() * 3.5F / 3.0F);
    paramr = this.Atn;
    int i;
    if (paramr != null)
    {
      i = paramr.getWidth();
      paramr = this.Atn;
      if (paramr == null) {
        break label506;
      }
    }
    label506:
    for (int j = paramr.getHeight();; j = m)
    {
      ac.i(this.TAG, "onPreview vlog, view size:[" + i + ", " + j + "], full size:[" + k + ", " + m + "], cropInfo.rect:" + this.AoD.viewRect + ", visibleRect:" + this.Ann);
      this.AoD.eY.reset();
      paramr = new Matrix(this.AoD.eY);
      this.Atj.egh().a((View)this.Atj.egi(), i, j, this.AoD.eY, CropLayout.e.Jef, (b)new b(this, paramr));
      AppMethodBeat.o(207816);
      return;
      i = k;
      break;
    }
  }
  
  public final void sn(boolean paramBoolean) {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.c
  {
    public final void onChange()
    {
      AppMethodBeat.i(207813);
      this.Atq.AoD.pvE.set(this.Atq.Atj.egh().getContentRect());
      AppMethodBeat.o(207813);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    b(f paramf, Matrix paramMatrix)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class c
    implements WxCropOperationLayout.i
  {
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(207815);
      k.h(paramRectF, "rectF");
      paramRectF.round(this.Atq.AoD.gUl);
      this.Atq.Atj.egh().g(paramRectF);
      AppMethodBeat.o(207815);
    }
    
    public final void mx(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.f
 * JD-Core Version:    0.7.0.1
 */