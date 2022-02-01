package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.a.a;
import java.util.ArrayList;

public class NeatLayout
  extends c
{
  private int LEl = 0;
  
  static
  {
    AppMethodBeat.i(39759);
    System.loadLibrary("linebreak");
    AppMethodBeat.o(39759);
  }
  
  public NeatLayout(CharSequence paramCharSequence, float[] paramArrayOfFloat)
  {
    super(paramCharSequence, paramArrayOfFloat);
  }
  
  private native int nComputeBreak(String paramString, float[] paramArrayOfFloat1, float paramFloat1, float paramFloat2, int[] paramArrayOfInt, float[] paramArrayOfFloat2, float paramFloat3, boolean[] paramArrayOfBoolean1, char[] paramArrayOfChar1, float[] paramArrayOfFloat3, char[] paramArrayOfChar2, float[] paramArrayOfFloat4, boolean[] paramArrayOfBoolean2);
  
  public final void a(TextPaint paramTextPaint, float paramFloat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(39758);
    float f6 = Math.round(paramTextPaint.getTextSize() / 2.0F);
    float f2;
    int i;
    float[] arrayOfFloat1;
    boolean[] arrayOfBoolean;
    int i3;
    float f1;
    label113:
    float f3;
    if (paramBoolean)
    {
      f2 = paramTextPaint.getTextSize() / 6.0F;
      i = this.LDt.length();
      paramTextPaint = new int[i];
      arrayOfFloat1 = new float[i];
      arrayOfBoolean = new boolean[i];
      i3 = nComputeBreak(this.LDt, this.LDv, 0.0F, paramFloat + f6, paramTextPaint, arrayOfFloat1, f2, arrayOfBoolean, a.LDo, this.LDy, a.LDn, this.LDx, this.LDT);
      this.LEl = i3;
      f1 = 0.0F;
      i = 0;
      if ((i >= i3) || (i >= paramInt)) {
        break label160;
      }
      f3 = arrayOfFloat1[i];
      if (f1 >= f3) {
        break label454;
      }
      f1 = f3;
    }
    label160:
    label441:
    label454:
    for (;;)
    {
      i += 1;
      break label113;
      f2 = 0.0F;
      break;
      float f5 = Math.min(f1, paramFloat);
      i = 0;
      int k = 0;
      if ((k < i3) && (k < paramInt))
      {
        int i2 = paramTextPaint[k];
        paramBoolean = arrayOfBoolean[k];
        int n = i2 - i;
        f1 = 0.0F;
        f3 = paramFloat - arrayOfFloat1[k];
        int m;
        if (Math.abs(f3) - 1.0F <= f6) {
          m = 1;
        }
        int j;
        while (m != 0)
        {
          j = n;
          if (i2 - 1 >= 0)
          {
            j = n;
            if (this.LDu[(i2 - 1)] == '\n') {
              j = n - 1;
            }
          }
          n = i;
          for (;;)
          {
            if (n < i2)
            {
              int i1 = j;
              if (this.LDu[n] != '\n')
              {
                i1 = j;
                if (this.LDv[n] == 0.0F) {
                  i1 = j - 1;
                }
              }
              n += 1;
              j = i1;
              continue;
              m = 0;
              break;
            }
          }
          f1 = f3 / (Math.max(2, j) - 1);
        }
        label365:
        char[] arrayOfChar;
        float[] arrayOfFloat2;
        if (m != 0)
        {
          f3 = paramFloat;
          arrayOfChar = this.LDu;
          arrayOfFloat2 = this.LDv;
          j = this.LDA.size();
          if (m == 0) {
            break label441;
          }
        }
        for (float f4 = paramFloat;; f4 = f5)
        {
          a(arrayOfChar, i, i2, f3, arrayOfFloat2, j, f1, paramBoolean, f2, f4);
          k += 1;
          i = i2;
          break;
          f3 = arrayOfFloat1[k];
          break label365;
        }
      }
      AppMethodBeat.o(39758);
      return;
    }
  }
  
  public final int fSB()
  {
    return this.LEl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.NeatLayout
 * JD-Core Version:    0.7.0.1
 */