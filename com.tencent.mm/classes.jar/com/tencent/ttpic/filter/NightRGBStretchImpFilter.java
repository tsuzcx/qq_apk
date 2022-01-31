package com.tencent.ttpic.filter;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.view.g;

public class NightRGBStretchImpFilter
  extends BaseFilter
{
  private static final String TAG;
  private int[] mHistogram;
  private float param;
  private int paramTEXTRUEID;
  private float recordParam;
  
  static
  {
    AppMethodBeat.i(82684);
    TAG = NightRGBStretchImpFilter.class.getSimpleName();
    AppMethodBeat.o(82684);
  }
  
  public NightRGBStretchImpFilter()
  {
    super(GLSLRender.buR);
    AppMethodBeat.i(82678);
    this.paramTEXTRUEID = 0;
    this.recordParam = 0.5F;
    initParams();
    AppMethodBeat.o(82678);
  }
  
  private void initParams()
  {
    AppMethodBeat.i(82679);
    this.param = 0.0F;
    addParam(new m.f("param", 0.5F));
    addParam(new m.f("scale", 2.0F));
    AppMethodBeat.o(82679);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82680);
    this.paramTEXTRUEID = g.dXe();
    super.ApplyGLSLFilter();
    AppMethodBeat.o(82680);
  }
  
  public void ClearGLSL()
  {
    AppMethodBeat.i(82683);
    g.Tn(this.paramTEXTRUEID);
    super.ClearGLSL();
    AppMethodBeat.o(82683);
  }
  
  public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    AppMethodBeat.i(82681);
    if ((this.mHistogram == null) || (this.mHistogram.length < 256))
    {
      AppMethodBeat.o(82681);
      return;
    }
    float f2;
    float f1;
    if (this.param > 0.5D)
    {
      f2 = this.param;
      f1 = f2;
      if (f2 > 0.6D) {
        f1 = 0.6F;
      }
      if (f1 > this.recordParam)
      {
        addParam(new m.f("param", f1));
        LogUtils.e(TAG, "night filter param = ".concat(String.valueOf(f1)));
        this.recordParam = f1;
      }
    }
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt3 < 256)
    {
      paramInt1 += this.mHistogram[paramInt3];
      paramInt2 += this.mHistogram[paramInt3] * paramInt3;
      paramInt3 += 1;
    }
    if (paramInt1 == 0)
    {
      AppMethodBeat.o(82681);
      return;
    }
    int i = paramInt2 / paramInt1;
    int m = (int)(paramInt1 * 0.001F);
    int k = (int)(paramInt1 * 0.99F);
    paramInt3 = 0;
    paramInt2 = 0;
    if (paramInt2 < 256)
    {
      paramInt3 += this.mHistogram[paramInt2];
      if (paramInt3 <= m) {}
    }
    for (paramInt1 = paramInt2;; paramInt1 = 0)
    {
      paramInt2 += 1;
      label219:
      if (paramInt2 < 256)
      {
        paramInt3 += this.mHistogram[paramInt2];
        if (paramInt3 <= k) {}
      }
      for (;;)
      {
        f1 = (i - paramInt1) / (paramInt2 - paramInt1);
        f2 = (float)(Math.log(0.5D) / Math.log(f1));
        if (f2 < 0.1D) {}
        for (f1 = 0.1F;; f1 = f2)
        {
          if (f2 > 10.0D) {
            f1 = 10.0F;
          }
          float[] arrayOfFloat = new float[256];
          paramInt3 = 0;
          for (;;)
          {
            if (paramInt3 < paramInt1)
            {
              arrayOfFloat[paramInt3] = 0.0F;
              paramInt3 += 1;
              continue;
              paramInt2 += 1;
              break;
              paramInt2 += 1;
              break label219;
            }
          }
          paramInt3 = paramInt1;
          for (;;)
          {
            i = paramInt2;
            if (paramInt3 >= paramInt2) {
              break;
            }
            arrayOfFloat[paramInt3] = ((float)Math.pow((paramInt3 - paramInt1) / (paramInt2 - paramInt1), f1));
            paramInt3 += 1;
          }
          while (i < 256)
          {
            arrayOfFloat[i] = 1.0F;
            i += 1;
          }
          int[] arrayOfInt = new int[256];
          paramInt1 = j;
          while (paramInt1 < 256)
          {
            arrayOfInt[paramInt1] = ((int)(arrayOfFloat[paramInt1] * 255.0F));
            paramInt1 += 1;
          }
          GLES20.glActiveTexture(33984);
          GLSLRender.nativeTextCure(arrayOfInt, this.paramTEXTRUEID);
          AppMethodBeat.o(82681);
          return;
        }
        paramInt2 = 255;
      }
    }
  }
  
  public boolean needRender()
  {
    return this.param > 0.5D;
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82682);
    setTextureParam(this.paramTEXTRUEID, 1);
    boolean bool = super.renderTexture(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(82682);
    return bool;
  }
  
  public void reset()
  {
    this.recordParam = 0.5F;
  }
  
  public void setHistogram(int[] paramArrayOfInt)
  {
    this.mHistogram = paramArrayOfInt;
    this.param = 0.0F;
    if (this.mHistogram == null) {
      return;
    }
    int j = 0;
    int i = 0;
    int k = 0;
    label25:
    if (j < this.mHistogram.length)
    {
      k += this.mHistogram[j];
      if (j >= 80) {
        break label85;
      }
      i = this.mHistogram[j] + i;
    }
    label85:
    for (;;)
    {
      j += 1;
      break label25;
      if (k == 0) {
        break;
      }
      this.param = (i * 1.0F / k);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.filter.NightRGBStretchImpFilter
 * JD-Core Version:    0.7.0.1
 */