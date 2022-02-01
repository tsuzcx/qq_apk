package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "", "()V", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "cropRect", "getCropRect", "setCropRect", "(Landroid/graphics/Rect;)V", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "plugin-vlog_release"})
public final class n
{
  public float aMu;
  public float aMv;
  public Matrix dY;
  public Rect gtE;
  public final Rect oSt;
  public float rGL;
  public Rect viewRect;
  
  public n()
  {
    AppMethodBeat.i(200825);
    this.dY = new Matrix();
    this.gtE = new Rect();
    this.viewRect = new Rect();
    this.oSt = new Rect();
    this.rGL = 1.0F;
    this.aMu = 1.0F;
    this.aMv = 1.0F;
    AppMethodBeat.o(200825);
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(200824);
    float[] arrayOfFloat = new float[9];
    this.dY.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(200824);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.n
 * JD-Core Version:    0.7.0.1
 */