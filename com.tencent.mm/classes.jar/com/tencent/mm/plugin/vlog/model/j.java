package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "", "()V", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "cropRect", "getCropRect", "setCropRect", "(Landroid/graphics/Rect;)V", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "plugin-vlog_release"})
public final class j
{
  public float aXt;
  public float aXu;
  public Matrix gT;
  public Rect iiw;
  public final Rect rwL;
  public Rect viewRect;
  public float xnf;
  
  public j()
  {
    AppMethodBeat.i(190562);
    this.gT = new Matrix();
    this.iiw = new Rect();
    this.viewRect = new Rect();
    this.rwL = new Rect();
    this.xnf = 1.0F;
    this.aXt = 1.0F;
    this.aXu = 1.0F;
    AppMethodBeat.o(190562);
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(190561);
    float[] arrayOfFloat = new float[9];
    this.gT.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(190561);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.j
 * JD-Core Version:    0.7.0.1
 */