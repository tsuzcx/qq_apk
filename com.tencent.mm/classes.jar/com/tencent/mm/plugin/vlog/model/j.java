package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "", "()V", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "cropRect", "getCropRect", "setCropRect", "(Landroid/graphics/Rect;)V", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "plugin-vlog_release"})
public final class j
{
  public float BZx;
  public float aGN;
  public float aGO;
  public Matrix aHZ;
  public Rect kXj;
  public final Rect vcr;
  public Rect viewRect;
  
  public j()
  {
    AppMethodBeat.i(230926);
    this.aHZ = new Matrix();
    this.kXj = new Rect();
    this.viewRect = new Rect();
    this.vcr = new Rect();
    this.BZx = 1.0F;
    this.aGN = 1.0F;
    this.aGO = 1.0F;
    AppMethodBeat.o(230926);
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(230924);
    float[] arrayOfFloat = new float[9];
    this.aHZ.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(230924);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.j
 * JD-Core Version:    0.7.0.1
 */