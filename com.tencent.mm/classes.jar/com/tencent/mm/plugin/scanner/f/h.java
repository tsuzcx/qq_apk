package com.tencent.mm.plugin.scanner.f;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper;", "", "ocrViewModel", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;", "(Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;)V", "animatingInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper$AnimatingZoomInfo;", "currentImageView", "Landroid/view/View;", "currentZoomScale", "", "currentZoomState", "", "currentZooming", "imageScaleInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "mImageOCRListener", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "attachImageView", "", "imageView", "checkZoomStateChanged", "currentScale", "scaleRate", "zoomOut", "Lkotlin/Function0;", "zoomIn", "isZoomAnimating", "", "onImageScaleChanged", "oldScale", "newScale", "onZoomScaleChanged", "onZoomStateChanged", "zoomState", "processZoom", "centerX", "centerY", "release", "setImageOCRListener", "listener", "AnimatingZoomInfo", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h.b OUU;
  final g OUF;
  g.a OUL;
  int OUV;
  float OUW;
  int OUX;
  a OUY;
  View OUm;
  c OUr;
  
  static
  {
    AppMethodBeat.i(313492);
    OUU = new h.b((byte)0);
    AppMethodBeat.o(313492);
  }
  
  public h(g paramg)
  {
    AppMethodBeat.i(313464);
    this.OUF = paramg;
    this.OUY = new a();
    AppMethodBeat.o(313464);
  }
  
  private final void ahH(int paramInt)
  {
    AppMethodBeat.i(313470);
    Log.v("MicroMsg.ImageOCRZoomHelper", "alvinluo onZoomStateChanged currentZoomState: %s, target: %s", new Object[] { Integer.valueOf(this.OUV), Integer.valueOf(paramInt) });
    if (this.OUV != paramInt)
    {
      this.OUV = paramInt;
      b localb = this.OUF.gRA();
      if (localb != null) {
        localb.ahH(paramInt);
      }
    }
    AppMethodBeat.o(313470);
  }
  
  public final void aP(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(313505);
    if (this.OUL == null) {
      this.OUL = this.OUF.gRz();
    }
    Object localObject1 = this.OUm;
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      AppMethodBeat.o(313505);
      throw ((Throwable)localObject1);
    }
    localObject1 = (i)localObject1;
    float f1 = ((i)localObject1).getScale();
    float f2 = ((i)localObject1).getScaleRate();
    Object localObject2 = this.OUL;
    s.checkNotNull(localObject2);
    boolean bool = ((g.a)localObject2).OUR;
    localObject2 = this.OUL;
    s.checkNotNull(localObject2);
    float f3 = ((g.a)localObject2).OUS;
    localObject2 = this.OUL;
    s.checkNotNull(localObject2);
    Log.i("MicroMsg.ImageOCRZoomHelper", "alvinluo processZoom currentScale: %s, isLongImage: %s, showDoubleScale: %s, showDefaultScale: %s, scaleRate: %s, centerX: %s, centerY: %s, zoomState: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(bool), Float.valueOf(f3), Float.valueOf(((g.a)localObject2).OUT), Float.valueOf(f2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.OUV) });
    localObject2 = this.OUL;
    s.checkNotNull(localObject2);
    g.a locala;
    if (((g.a)localObject2).OUR)
    {
      if (this.OUV == 1)
      {
        localObject2 = this.OUY;
        ((a)localObject2).OVa = f1;
        locala = this.OUL;
        s.checkNotNull(locala);
        ((a)localObject2).targetScale = locala.OUS;
        ((a)localObject2).OUZ = true;
        localObject2 = this.OUr;
        if (localObject2 != null) {
          ((c)localObject2).aig(2);
        }
        localObject2 = this.OUL;
        s.checkNotNull(localObject2);
        ((i)localObject1).zoomToWithAnimation(((g.a)localObject2).OUS, paramFloat1, paramFloat2);
        ahH(2);
        AppMethodBeat.o(313505);
        return;
      }
      if (this.OUV == 2)
      {
        localObject2 = this.OUY;
        ((a)localObject2).OVa = f1;
        locala = this.OUL;
        s.checkNotNull(locala);
        ((a)localObject2).targetScale = locala.OUT;
        ((a)localObject2).OUZ = true;
        localObject2 = this.OUr;
        if (localObject2 != null) {
          ((c)localObject2).aih(2);
        }
        localObject2 = this.OUL;
        s.checkNotNull(localObject2);
        ((i)localObject1).zoomToWithAnimation(((g.a)localObject2).OUT, paramFloat1, paramFloat2);
        ahH(1);
        AppMethodBeat.o(313505);
      }
    }
    else
    {
      if (this.OUV == 1)
      {
        paramFloat1 = ((i)localObject1).ag(paramFloat1, paramFloat2);
        localObject1 = this.OUY;
        ((a)localObject1).OVa = f1;
        ((a)localObject1).targetScale = paramFloat1;
        ((a)localObject1).OUZ = true;
        localObject1 = this.OUr;
        if (localObject1 != null) {
          ((c)localObject1).aig(2);
        }
        ahH(2);
        AppMethodBeat.o(313505);
        return;
      }
      if (this.OUV == 2)
      {
        localObject2 = this.OUY;
        ((a)localObject2).OVa = f1;
        locala = this.OUL;
        s.checkNotNull(locala);
        ((a)localObject2).targetScale = locala.OUT;
        ((a)localObject2).OUZ = true;
        localObject2 = this.OUr;
        if (localObject2 != null) {
          ((c)localObject2).aih(2);
        }
        ahH(1);
        localObject2 = this.OUL;
        s.checkNotNull(localObject2);
        ((i)localObject1).zoomToWithAnimation(((g.a)localObject2).OUT, paramFloat1, paramFloat2);
      }
    }
    AppMethodBeat.o(313505);
  }
  
  final boolean gRH()
  {
    AppMethodBeat.i(313507);
    if ((this.OUF.gRy()) || (this.OUY.OUZ))
    {
      AppMethodBeat.o(313507);
      return true;
    }
    AppMethodBeat.o(313507);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper$AnimatingZoomInfo;", "", "()V", "isZoomAnimating", "", "()Z", "setZoomAnimating", "(Z)V", "startScale", "", "getStartScale", "()F", "setStartScale", "(F)V", "targetScale", "getTargetScale", "setTargetScale", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
  {
    boolean OUZ;
    float OVa;
    float targetScale;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.h
 * JD-Core Version:    0.7.0.1
 */