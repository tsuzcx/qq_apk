package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "", "()V", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "cropRect", "getCropRect", "setCropRect", "(Landroid/graphics/Rect;)V", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public Rect Gl;
  public float HLs;
  public Matrix matrix;
  public float maxScale;
  public float minScale;
  public Rect viewRect;
  public final Rect yok;
  
  public i()
  {
    AppMethodBeat.i(283365);
    this.matrix = new Matrix();
    this.Gl = new Rect();
    this.viewRect = new Rect();
    this.yok = new Rect();
    this.HLs = 1.0F;
    this.maxScale = 1.0F;
    this.minScale = 1.0F;
    AppMethodBeat.o(283365);
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(283374);
    float[] arrayOfFloat = new float[9];
    this.matrix.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(283374);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.i
 * JD-Core Version:    0.7.0.1
 */