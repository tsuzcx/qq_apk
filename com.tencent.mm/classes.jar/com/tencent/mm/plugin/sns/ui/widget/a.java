package com.tencent.mm.plugin.sns.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class a
  extends Animation
{
  private final float buA;
  private final float buB;
  private Context context;
  private final float pqW;
  private final float pqX;
  private final float pqY;
  private final boolean pqZ;
  private Camera pra;
  private float scale = 1.0F;
  
  public a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.context = paramContext;
    this.pqW = paramFloat1;
    this.pqX = paramFloat2;
    this.buA = paramFloat3;
    this.buB = paramFloat4;
    this.pqY = 150.0F;
    this.pqZ = paramBoolean;
    this.scale = paramContext.getResources().getDisplayMetrics().density;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.pqW;
    float f2 = this.pqX;
    float f3 = this.pqW;
    float f4 = this.buA;
    float f5 = this.buB;
    Object localObject = this.pra;
    paramTransformation = paramTransformation.getMatrix();
    ((Camera)localObject).save();
    if (this.pqZ) {
      ((Camera)localObject).translate(0.0F, 0.0F, this.pqY * paramFloat);
    }
    for (;;)
    {
      ((Camera)localObject).rotateY(f1 + (f2 - f3) * paramFloat);
      ((Camera)localObject).getMatrix(paramTransformation);
      ((Camera)localObject).restore();
      localObject = new float[9];
      Object tmp98_96 = localObject;
      tmp98_96[0] = 0.0F;
      Object tmp102_98 = tmp98_96;
      tmp102_98[1] = 0.0F;
      Object tmp106_102 = tmp102_98;
      tmp106_102[2] = 0.0F;
      Object tmp110_106 = tmp106_102;
      tmp110_106[3] = 0.0F;
      Object tmp114_110 = tmp110_106;
      tmp114_110[4] = 0.0F;
      Object tmp118_114 = tmp114_110;
      tmp118_114[5] = 0.0F;
      Object tmp122_118 = tmp118_114;
      tmp122_118[6] = 0.0F;
      Object tmp127_122 = tmp122_118;
      tmp127_122[7] = 0.0F;
      Object tmp132_127 = tmp127_122;
      tmp132_127[8] = 0.0F;
      tmp132_127;
      paramTransformation.getValues((float[])localObject);
      localObject[6] /= this.scale;
      paramTransformation.setValues((float[])localObject);
      paramTransformation.preTranslate(-f4, -f5);
      paramTransformation.postTranslate(f4, f5);
      return;
      ((Camera)localObject).translate(0.0F, 0.0F, this.pqY * (1.0F - paramFloat));
    }
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.pra = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.a
 * JD-Core Version:    0.7.0.1
 */