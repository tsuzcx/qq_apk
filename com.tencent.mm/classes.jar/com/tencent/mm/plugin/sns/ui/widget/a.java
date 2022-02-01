package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends Animation
{
  private final float FdR;
  private final float FdS;
  private final float FdT;
  private final boolean FdU;
  private Camera FdV;
  private Context context;
  private final float dhi;
  private final float dhj;
  private float scale;
  
  public a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    AppMethodBeat.i(100450);
    this.scale = 1.0F;
    this.context = paramContext;
    this.FdR = paramFloat1;
    this.FdS = paramFloat2;
    this.dhi = paramFloat3;
    this.dhj = paramFloat4;
    this.FdT = 150.0F;
    this.FdU = paramBoolean;
    this.scale = paramContext.getResources().getDisplayMetrics().density;
    AppMethodBeat.o(100450);
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    AppMethodBeat.i(100452);
    float f1 = this.FdR;
    float f2 = this.FdS;
    float f3 = this.FdR;
    float f4 = this.dhi;
    float f5 = this.dhj;
    Object localObject = this.FdV;
    paramTransformation = paramTransformation.getMatrix();
    ((Camera)localObject).save();
    if (this.FdU) {
      ((Camera)localObject).translate(0.0F, 0.0F, this.FdT * paramFloat);
    }
    for (;;)
    {
      ((Camera)localObject).rotateY(f1 + (f2 - f3) * paramFloat);
      ((Camera)localObject).getMatrix(paramTransformation);
      ((Camera)localObject).restore();
      localObject = new float[9];
      Object tmp103_101 = localObject;
      tmp103_101[0] = 0.0F;
      Object tmp107_103 = tmp103_101;
      tmp107_103[1] = 0.0F;
      Object tmp111_107 = tmp107_103;
      tmp111_107[2] = 0.0F;
      Object tmp115_111 = tmp111_107;
      tmp115_111[3] = 0.0F;
      Object tmp119_115 = tmp115_111;
      tmp119_115[4] = 0.0F;
      Object tmp123_119 = tmp119_115;
      tmp123_119[5] = 0.0F;
      Object tmp127_123 = tmp123_119;
      tmp127_123[6] = 0.0F;
      Object tmp132_127 = tmp127_123;
      tmp132_127[7] = 0.0F;
      Object tmp137_132 = tmp132_127;
      tmp137_132[8] = 0.0F;
      tmp137_132;
      paramTransformation.getValues((float[])localObject);
      localObject[6] /= this.scale;
      paramTransformation.setValues((float[])localObject);
      paramTransformation.preTranslate(-f4, -f5);
      paramTransformation.postTranslate(f4, f5);
      AppMethodBeat.o(100452);
      return;
      ((Camera)localObject).translate(0.0F, 0.0F, this.FdT * (1.0F - paramFloat));
    }
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(100451);
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.FdV = new Camera();
    AppMethodBeat.o(100451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */