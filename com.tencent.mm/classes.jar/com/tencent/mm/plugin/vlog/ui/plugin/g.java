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
import com.tencent.mm.plugin.vlog.model.n;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import d.g.a.b;
import d.g.b.k;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$cropChangeListener$1;", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$operationCallback$1;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoSize", "Landroid/util/Size;", "visibleRect", "Landroid/graphics/RectF;", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "", "onPreview", "setVideoSize", "size", "setVisibleRect", "rect", "plugin-vlog_release"})
public final class g
  implements d
{
  private v Lqf;
  public final RectF Lqo;
  final n Lru;
  final e LtR;
  private Size LtV;
  private final a LtW;
  private final c LtX;
  private final String TAG;
  
  public g(e parame)
  {
    AppMethodBeat.i(201135);
    this.LtR = parame;
    this.TAG = "MicroMsg.VLogPreviewImpl";
    this.Lqo = new RectF();
    this.Lru = new n();
    this.LtW = new a(this);
    this.LtX = new c(this);
    AppMethodBeat.o(201135);
  }
  
  public final void a(Size paramSize)
  {
    AppMethodBeat.i(201134);
    k.h(paramSize, "size");
    ad.i(this.TAG, "setVideoSize: ".concat(String.valueOf(paramSize)));
    this.LtV = paramSize;
    AppMethodBeat.o(201134);
  }
  
  public final Rect fZe()
  {
    return null;
  }
  
  public final CropLayout.b fZl()
  {
    return (CropLayout.b)this.LtW;
  }
  
  public final WxCropOperationLayout.i fZm()
  {
    return (WxCropOperationLayout.i)this.LtX;
  }
  
  public final void h(final v paramv)
  {
    AppMethodBeat.i(201133);
    k.h(paramv, "composition");
    ad.i(this.TAG, "onPreview: ");
    if ((k.g(this.Lqf, paramv)) && (k.g(this.LtR.fZi().getParent(), this.LtR.fZh())))
    {
      this.LtR.fZi().a(paramv);
      AppMethodBeat.o(201133);
      return;
    }
    this.Lqf = paramv;
    this.LtR.fZh().wS(true);
    this.LtR.fZh().setEnableScale(true);
    ViewParent localViewParent = this.LtR.fZi().getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    localObject = (ViewGroup)localObject;
    if (localObject != null) {
      ((ViewGroup)localObject).removeView((View)this.LtR.fZi());
    }
    this.LtR.fZi().a(paramv);
    this.Lqo.set(this.LtR.getOperationLayout().getVisibilityRect());
    this.LtR.fZh().getVisibilityRect().set(this.Lqo);
    paramv = ((Iterable)paramv.LqL).iterator();
    while (paramv.hasNext())
    {
      localObject = (y)paramv.next();
      this.Lqo.round(((y)localObject).Lru.viewRect);
    }
    int k = this.LtR.fZg().getWidth();
    int m = (int)(this.LtR.fZg().getWidth() * 3.5F / 3.0F);
    paramv = this.LtV;
    int i;
    if (paramv != null)
    {
      i = paramv.getWidth();
      paramv = this.LtV;
      if (paramv == null) {
        break label506;
      }
    }
    label506:
    for (int j = paramv.getHeight();; j = m)
    {
      ad.i(this.TAG, "onPreview vlog, view size:[" + i + ", " + j + "], full size:[" + k + ", " + m + "], cropInfo.rect:" + this.Lru.viewRect + ", visibleRect:" + this.Lqo);
      this.Lru.dY.reset();
      paramv = new Matrix(this.Lru.dY);
      this.LtR.fZh().a((View)this.LtR.fZi(), i, j, this.Lru.dY, CropLayout.c.HDI, (b)new b(this, paramv));
      AppMethodBeat.o(201133);
      return;
      i = k;
      break;
    }
  }
  
  public final void zg(boolean paramBoolean) {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "onChange", "", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.b
  {
    public final void onChange()
    {
      AppMethodBeat.i(201130);
      this.LtY.Lru.oSt.set(this.LtY.LtR.fZh().getContentRect());
      AppMethodBeat.o(201130);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class b
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    b(g paramg, Matrix paramMatrix)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class c
    implements WxCropOperationLayout.i
  {
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(201132);
      k.h(paramRectF, "rectF");
      paramRectF.round(this.LtY.Lru.gtE);
      this.LtY.LtR.fZh().g(paramRectF);
      AppMethodBeat.o(201132);
    }
    
    public final void yV(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.g
 * JD-Core Version:    0.7.0.1
 */