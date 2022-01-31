package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.m.a;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoGlobalContext;

public class BrightnessAdjustmentFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER;
  private int counter;
  private int[] lastCurve;
  private boolean lastStable;
  
  static
  {
    AppMethodBeat.i(82067);
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/BrightnessAdjustmentFilter.dat");
    AppMethodBeat.o(82067);
  }
  
  public BrightnessAdjustmentFilter()
  {
    super(FRAGMENT_SHADER);
    AppMethodBeat.i(82063);
    this.lastCurve = new int[256];
    this.lastStable = true;
    this.counter = 5;
    AppMethodBeat.o(82063);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(82064);
    float[] arrayOfFloat = new float[''];
    arrayOfFloat[''] = 1.0F;
    arrayOfFloat[''] = 1.0F;
    int i = 0;
    while (i < 256)
    {
      this.lastCurve[i] = i;
      if (i % 2 == 0) {
        arrayOfFloat[(i / 2)] = (i / 255.0F);
      }
      i += 1;
    }
    addParam(new m.a("curve", arrayOfFloat));
    addParam(new m.f("alpha", 1.0F));
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    AppMethodBeat.o(82064);
  }
  
  public void setBlendAlpha(float paramFloat)
  {
    AppMethodBeat.i(82066);
    addParam(new m.f("alpha", paramFloat));
    AppMethodBeat.o(82066);
  }
  
  public void updateCurve(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    AppMethodBeat.i(82065);
    float[] arrayOfFloat = new float[''];
    arrayOfFloat[''] = 1.0F;
    arrayOfFloat[''] = 1.0F;
    if (paramBoolean)
    {
      this.lastStable = true;
      while (i < 256)
      {
        this.lastCurve[i] = paramArrayOfInt[i];
        if (i % 2 == 0) {
          arrayOfFloat[(i / 2)] = (paramArrayOfInt[i] / 255.0F);
        }
        i += 1;
      }
      addParam(new m.a("curve", arrayOfFloat));
      AppMethodBeat.o(82065);
      return;
    }
    if (paramArrayOfInt[''] == this.lastCurve['']) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((this.lastStable) && (!paramBoolean)) {
        this.counter = 5;
      }
      this.lastStable = paramBoolean;
      i = k;
      if (paramBoolean) {
        break label274;
      }
      this.counter = Math.max(1, this.counter - 1);
      int[] arrayOfInt = new int[256];
      i = j;
      while (i < 256)
      {
        arrayOfInt[i] = ((paramArrayOfInt[i] - this.lastCurve[i]) / this.counter + this.lastCurve[i]);
        this.lastCurve[i] = arrayOfInt[i];
        if (i % 2 == 0) {
          arrayOfFloat[(i / 2)] = (arrayOfInt[i] / 255.0F);
        }
        i += 1;
      }
    }
    addParam(new m.a("curve", arrayOfFloat));
    AppMethodBeat.o(82065);
    return;
    label274:
    while (i < 256)
    {
      if (i % 2 == 0) {
        arrayOfFloat[(i / 2)] = (paramArrayOfInt[i] / 255.0F);
      }
      i += 1;
    }
    addParam(new m.a("curve", arrayOfFloat));
    AppMethodBeat.o(82065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.filter.BrightnessAdjustmentFilter
 * JD-Core Version:    0.7.0.1
 */