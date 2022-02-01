package com.tencent.mm.plugin.music.ui.transition;

import android.content.Context;
import android.graphics.Path;
import android.transition.ArcMotion;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GravityArcMotion
  extends ArcMotion
{
  private static final float zI;
  private float zJ = 0.0F;
  private float zK = 0.0F;
  private float zL = 70.0F;
  private float zM = 0.0F;
  private float zN = 0.0F;
  private float zO = zI;
  
  static
  {
    AppMethodBeat.i(219892);
    zI = (float)Math.tan(Math.toRadians(35.0D));
    AppMethodBeat.o(219892);
  }
  
  public GravityArcMotion() {}
  
  public GravityArcMotion(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static float w(float paramFloat)
  {
    AppMethodBeat.i(219890);
    if ((paramFloat < 0.0F) || (paramFloat > 90.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Arc must be between 0 and 90 degrees");
      AppMethodBeat.o(219890);
      throw localIllegalArgumentException;
    }
    paramFloat = (float)Math.tan(Math.toRadians(paramFloat / 2.0F));
    AppMethodBeat.o(219890);
    return paramFloat;
  }
  
  public float getMaximumAngle()
  {
    return this.zL;
  }
  
  public float getMinimumHorizontalAngle()
  {
    return this.zJ;
  }
  
  public float getMinimumVerticalAngle()
  {
    return this.zK;
  }
  
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(219891);
    Path localPath = new Path();
    localPath.moveTo(paramFloat1, paramFloat2);
    float f1;
    if (paramFloat2 == paramFloat4) {
      f1 = (paramFloat1 + paramFloat3) / 2.0F;
    }
    for (float f2 = paramFloat2 + this.zM * Math.abs(paramFloat3 - paramFloat1) / 2.0F;; f2 = (paramFloat2 + paramFloat4) / 2.0F)
    {
      localPath.cubicTo((paramFloat1 + f1) / 2.0F, (paramFloat2 + f2) / 2.0F, (f1 + paramFloat3) / 2.0F, (f2 + paramFloat4) / 2.0F, paramFloat3, paramFloat4);
      AppMethodBeat.o(219891);
      return localPath;
      if (paramFloat1 != paramFloat3) {
        break;
      }
      f1 = paramFloat1 + this.zN * Math.abs(paramFloat4 - paramFloat2) / 2.0F;
    }
    f2 = paramFloat3 - paramFloat1;
    label146:
    float f3;
    float f6;
    float f5;
    float f4;
    label224:
    float f7;
    if (paramFloat4 < paramFloat2)
    {
      f1 = paramFloat2 - paramFloat4;
      f3 = f2 * f2 + f1 * f1;
      f6 = (paramFloat1 + paramFloat3) / 2.0F;
      f5 = (paramFloat2 + paramFloat4) / 2.0F;
      f4 = 0.25F * f3;
      if (Math.abs(f2) >= Math.abs(f1)) {
        break label338;
      }
      f1 = paramFloat4 + f3 / (f1 * 2.0F);
      f3 = this.zN * f4 * this.zN;
      f2 = paramFloat3;
      f7 = f6 - f2;
      float f8 = f5 - f1;
      f7 = f8 * f8 + f7 * f7;
      f4 = f4 * this.zO * this.zO;
      if (f7 >= f3) {
        break label370;
      }
    }
    for (;;)
    {
      if (f3 != 0.0F)
      {
        f3 = (float)Math.sqrt(f3 / f7);
        f2 = (f2 - f6) * f3 + f6;
        f3 = f5 + f3 * (f1 - f5);
        f1 = f2;
        f2 = f3;
        break;
        f1 = paramFloat4 - paramFloat2;
        break label146;
        label338:
        f2 = paramFloat3 + f3 / (2.0F * f2);
        f3 = this.zM * f4 * this.zM;
        f1 = paramFloat4;
        break label224;
        label370:
        if (f7 <= f4) {
          break label400;
        }
        f3 = f4;
        continue;
      }
      f3 = f1;
      f1 = f2;
      f2 = f3;
      break;
      label400:
      f3 = 0.0F;
    }
  }
  
  public void setMaximumAngle(float paramFloat)
  {
    AppMethodBeat.i(219889);
    this.zL = paramFloat;
    this.zO = w(paramFloat);
    AppMethodBeat.o(219889);
  }
  
  public void setMinimumHorizontalAngle(float paramFloat)
  {
    AppMethodBeat.i(219887);
    this.zJ = paramFloat;
    this.zM = w(paramFloat);
    AppMethodBeat.o(219887);
  }
  
  public void setMinimumVerticalAngle(float paramFloat)
  {
    AppMethodBeat.i(219888);
    this.zK = paramFloat;
    this.zN = w(paramFloat);
    AppMethodBeat.o(219888);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.transition.GravityArcMotion
 * JD-Core Version:    0.7.0.1
 */