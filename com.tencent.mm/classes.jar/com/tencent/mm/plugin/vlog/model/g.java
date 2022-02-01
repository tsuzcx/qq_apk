package com.tencent.mm.plugin.vlog.model;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "", "()V", "contentRect", "Landroid/graphics/Rect;", "getContentRect", "()Landroid/graphics/Rect;", "cropRect", "getCropRect", "setCropRect", "(Landroid/graphics/Rect;)V", "initScale", "", "getInitScale", "()F", "setInitScale", "(F)V", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "setMatrix", "(Landroid/graphics/Matrix;)V", "maxScale", "getMaxScale", "setMaxScale", "minScale", "getMinScale", "setMinScale", "rotation", "getRotation", "setRotation", "scale", "getScale", "setScale", "viewRect", "getViewRect", "setViewRect", "plugin-vlog_release"})
public final class g
{
  public float aXE;
  public float aXF;
  public Matrix gR;
  public Rect hmm;
  public final Rect pZj;
  public float tLe;
  public Rect viewRect;
  
  public g()
  {
    AppMethodBeat.i(195717);
    this.gR = new Matrix();
    this.hmm = new Rect();
    this.viewRect = new Rect();
    this.pZj = new Rect();
    this.tLe = 1.0F;
    this.aXE = 1.0F;
    this.aXF = 1.0F;
    AppMethodBeat.o(195717);
  }
  
  public final float getScale()
  {
    AppMethodBeat.i(195716);
    float[] arrayOfFloat = new float[9];
    this.gR.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[3];
    double d1 = f1 * f1;
    double d2 = f2;
    f1 = (float)Math.sqrt(f2 * d2 + d1);
    AppMethodBeat.o(195716);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.g
 * JD-Core Version:    0.7.0.1
 */