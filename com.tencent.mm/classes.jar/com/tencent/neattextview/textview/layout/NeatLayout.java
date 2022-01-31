package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import com.tencent.neattextview.textview.a.a;
import java.util.ArrayList;

public class NeatLayout
  extends b
{
  private int wEu = 0;
  
  static
  {
    System.loadLibrary("linebreak");
  }
  
  public NeatLayout(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    super(paramCharSequence, paramArrayOfFloat);
  }
  
  private native int nComputeBreak(String paramString, float[] paramArrayOfFloat1, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat2, float paramFloat3, boolean[] paramArrayOfBoolean1, char[] paramArrayOfChar1, float[] paramArrayOfFloat3, char[] paramArrayOfChar2, float[] paramArrayOfFloat4, boolean[] paramArrayOfBoolean2);
  
  public final void a(TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean)
  {
    float f3 = paramTextPaint.getTextSize() / 2.0F;
    float f1;
    int i;
    float[] arrayOfFloat;
    int k;
    int i2;
    int n;
    int m;
    if (paramBoolean)
    {
      f1 = paramTextPaint.getTextSize() / 6.0F;
      i = this.wDC.length();
      paramTextPaint = new int[i];
      arrayOfFloat = new float[i];
      boolean[] arrayOfBoolean = new boolean[i];
      int i3 = nComputeBreak(this.wDC, this.wDE, 0.0F, paramFloat + f3, paramTextPaint, arrayOfFloat, f1, arrayOfBoolean, a.wDx, this.wDH, a.wDw, this.wDG, this.wEb);
      this.wEu = i3;
      i = 0;
      k = 0;
      if ((k >= i3) || (k >= paramInt)) {
        return;
      }
      i2 = paramTextPaint[k];
      paramBoolean = arrayOfBoolean[k];
      n = i2 - i;
      f1 = 0.0F;
      f2 = paramFloat - arrayOfFloat[k];
      if (Math.abs(f2) > f3) {
        break label271;
      }
      m = 1;
    }
    label271:
    for (;;)
    {
      label163:
      if (m != 0)
      {
        int j = n;
        if (i2 - 1 >= 0)
        {
          j = n;
          if (this.wDD[(i2 - 1)] == '\n') {
            j = n - 1;
          }
        }
        n = i;
        for (;;)
        {
          if (n < i2)
          {
            int i1 = j;
            if (this.wDD[n] != '\n')
            {
              i1 = j;
              if (this.wDE[n] == 0.0F) {
                i1 = j - 1;
              }
            }
            n += 1;
            j = i1;
            continue;
            f1 = 0.0F;
            break;
            m = 0;
            break label163;
          }
        }
        f1 = f2 / (Math.max(2, j) - 1);
      }
    }
    if (m != 0) {}
    for (float f2 = paramFloat;; f2 = arrayOfFloat[k])
    {
      a(this.wDD, i, i2, f2, this.wDE, this.wDJ.size(), f1, paramBoolean);
      k += 1;
      i = i2;
      break;
    }
  }
  
  public final int cNL()
  {
    return this.wEu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.NeatLayout
 * JD-Core Version:    0.7.0.1
 */