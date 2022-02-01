package com.tencent.mm.plugin.scanner.f;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.box.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper;", "", "ocrViewModel", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;", "(Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel;)V", "animatingInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper$AnimatingZoomInfo;", "currentImageView", "Landroid/view/View;", "currentZoomScale", "", "currentZoomState", "", "currentZooming", "imageScaleInfo", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRViewModel$ImageScaleInfo;", "mImageOCRListener", "Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRListener;", "attachImageView", "", "imageView", "checkZoomStateChanged", "currentScale", "scaleRate", "zoomOut", "Lkotlin/Function0;", "zoomIn", "isZoomAnimating", "", "onImageScaleChanged", "oldScale", "newScale", "onZoomScaleChanged", "onZoomStateChanged", "zoomState", "processZoom", "centerX", "centerY", "release", "setImageOCRListener", "listener", "AnimatingZoomInfo", "Companion", "plugin-scan_release"})
public final class h
{
  public static final h.b INW;
  g.a ING;
  final g INM;
  int INR;
  float INS;
  int INU;
  a INV;
  View INi;
  c INm;
  
  static
  {
    AppMethodBeat.i(217337);
    INW = new h.b((byte)0);
    AppMethodBeat.o(217337);
  }
  
  public h(g paramg)
  {
    AppMethodBeat.i(217335);
    this.INM = paramg;
    this.INV = new a();
    AppMethodBeat.o(217335);
  }
  
  private final void adk(int paramInt)
  {
    AppMethodBeat.i(217331);
    Log.v("MicroMsg.ImageOCRZoomHelper", "alvinluo onZoomStateChanged currentZoomState: %s, target: %s", new Object[] { Integer.valueOf(this.INR), Integer.valueOf(paramInt) });
    if (this.INR != paramInt)
    {
      this.INR = paramInt;
      b localb = this.INM.fDo();
      if (localb != null)
      {
        localb.adk(paramInt);
        AppMethodBeat.o(217331);
        return;
      }
    }
    AppMethodBeat.o(217331);
  }
  
  public final void al(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217329);
    if (this.ING == null) {
      this.ING = this.INM.fDn();
    }
    Object localObject1 = this.INi;
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.IZoomableImageView");
      AppMethodBeat.o(217329);
      throw ((Throwable)localObject1);
    }
    localObject1 = (com.tencent.mm.ui.base.g)localObject1;
    float f1 = ((com.tencent.mm.ui.base.g)localObject1).getScale();
    float f2 = ((com.tencent.mm.ui.base.g)localObject1).getScaleRate();
    Object localObject2 = this.ING;
    if (localObject2 == null) {
      p.iCn();
    }
    boolean bool = ((g.a)localObject2).INO;
    localObject2 = this.ING;
    if (localObject2 == null) {
      p.iCn();
    }
    float f3 = ((g.a)localObject2).INP;
    localObject2 = this.ING;
    if (localObject2 == null) {
      p.iCn();
    }
    Log.i("MicroMsg.ImageOCRZoomHelper", "alvinluo processZoom currentScale: %s, isLongImage: %s, showDoubleScale: %s, showDefaultScale: %s, scaleRate: %s, centerX: %s, centerY: %s, zoomState: %s", new Object[] { Float.valueOf(f1), Boolean.valueOf(bool), Float.valueOf(f3), Float.valueOf(((g.a)localObject2).INQ), Float.valueOf(f2), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.INR) });
    localObject2 = this.ING;
    if (localObject2 == null) {
      p.iCn();
    }
    g.a locala;
    if (((g.a)localObject2).INO)
    {
      if (this.INR == 1)
      {
        localObject2 = this.INV;
        ((a)localObject2).INY = f1;
        locala = this.ING;
        if (locala == null) {
          p.iCn();
        }
        ((a)localObject2).aIU = locala.INP;
        ((a)localObject2).INX = true;
        localObject2 = this.INm;
        if (localObject2 != null) {
          ((c)localObject2).adJ(2);
        }
        localObject2 = this.ING;
        if (localObject2 == null) {
          p.iCn();
        }
        ((com.tencent.mm.ui.base.g)localObject1).m(((g.a)localObject2).INP, paramFloat1, paramFloat2);
        adk(2);
        AppMethodBeat.o(217329);
        return;
      }
      if (this.INR == 2)
      {
        localObject2 = this.INV;
        ((a)localObject2).INY = f1;
        locala = this.ING;
        if (locala == null) {
          p.iCn();
        }
        ((a)localObject2).aIU = locala.INQ;
        ((a)localObject2).INX = true;
        localObject2 = this.INm;
        if (localObject2 != null) {
          ((c)localObject2).adK(2);
        }
        localObject2 = this.ING;
        if (localObject2 == null) {
          p.iCn();
        }
        ((com.tencent.mm.ui.base.g)localObject1).m(((g.a)localObject2).INQ, paramFloat1, paramFloat2);
        adk(1);
      }
      AppMethodBeat.o(217329);
      return;
    }
    if (this.INR == 1)
    {
      paramFloat1 = ((com.tencent.mm.ui.base.g)localObject1).A(paramFloat1, paramFloat2);
      localObject1 = this.INV;
      ((a)localObject1).INY = f1;
      ((a)localObject1).aIU = paramFloat1;
      ((a)localObject1).INX = true;
      localObject1 = this.INm;
      if (localObject1 != null) {
        ((c)localObject1).adJ(2);
      }
      adk(2);
      AppMethodBeat.o(217329);
      return;
    }
    if (this.INR == 2)
    {
      localObject2 = this.INV;
      ((a)localObject2).INY = f1;
      locala = this.ING;
      if (locala == null) {
        p.iCn();
      }
      ((a)localObject2).aIU = locala.INQ;
      ((a)localObject2).INX = true;
      localObject2 = this.INm;
      if (localObject2 != null) {
        ((c)localObject2).adK(2);
      }
      adk(1);
      localObject2 = this.ING;
      if (localObject2 == null) {
        p.iCn();
      }
      ((com.tencent.mm.ui.base.g)localObject1).m(((g.a)localObject2).INQ, paramFloat1, paramFloat2);
    }
    AppMethodBeat.o(217329);
  }
  
  final boolean fDv()
  {
    AppMethodBeat.i(217333);
    if ((this.INM.fDm()) || (this.INV.INX))
    {
      AppMethodBeat.o(217333);
      return true;
    }
    AppMethodBeat.o(217333);
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ocr/ImageOCRZoomHelper$AnimatingZoomInfo;", "", "()V", "isZoomAnimating", "", "()Z", "setZoomAnimating", "(Z)V", "startScale", "", "getStartScale", "()F", "setStartScale", "(F)V", "targetScale", "getTargetScale", "setTargetScale", "plugin-scan_release"})
  static final class a
  {
    boolean INX;
    float INY;
    float aIU;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.f.h
 * JD-Core Version:    0.7.0.1
 */