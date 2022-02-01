package com.tencent.mm.plugin.surface.b.a;

import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.surface.c.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfaceCanvasJsApiContext;", "Lcom/tencent/mm/plugin/surface/jsapi/plain/SurfacePlainJsApiContext;", "magicBrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "TAG", "", "createCanvas", "", "frameSetId", "getFrameSet", "Lcom/tencent/mm/plugin/surface/render/FrameSet;", "getFrameSet$plugin_surface_app_release", "getFrameSetHeight", "", "getFrameSetName", "getFrameSetWidth", "getHeight", "", "canvasId", "getLeft", "getTop", "getView", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "getWidth", "has", "", "hasFrameSet", "remove", "", "setHeight", "height", "setLeft", "x", "setTop", "y", "setWidth", "width", "plugin-surface-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b
  implements i
{
  final e SKU;
  final String TAG;
  
  public b(e parame)
  {
    this.SKU = parame;
    this.TAG = "MicroMsg.SurfaceApp.SurfaceCanvasJsApiContext";
  }
  
  final MagicBrushView anL(int paramInt)
  {
    return this.SKU.eHD.find(paramInt);
  }
  
  public abstract c bcZ(String paramString);
  
  public abstract int createCanvas(String paramString);
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(b paramb, int paramInt)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<ah>
  {
    b(b paramb, int paramInt, Object paramObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(b paramb, int paramInt, Number paramNumber)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(b paramb, int paramInt, Number paramNumber)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<ah>
  {
    e(b paramb, int paramInt, Object paramObject)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.surface.b.a.b
 * JD-Core Version:    0.7.0.1
 */