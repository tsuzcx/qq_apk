package com.tencent.neattextview.textview.layout;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.neattextview.textview.a.a;
import java.util.ArrayList;

public class NeatLayout
  extends c
{
  private int RBI = 0;
  
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
  
  private native int nComputeBreak(String paramString, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float paramFloat1, int[] paramArrayOfInt, float[] paramArrayOfFloat3, float paramFloat2, boolean[] paramArrayOfBoolean1, char[] paramArrayOfChar1, float[] paramArrayOfFloat4, char[] paramArrayOfChar2, float[] paramArrayOfFloat5, boolean[] paramArrayOfBoolean2);
  
  public final void a(TextPaint paramTextPaint, float[] paramArrayOfFloat, float paramFloat, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192277);
    float f6 = Math.round(paramTextPaint.getTextSize() / 2.0F);
    if (paramBoolean) {}
    float[] arrayOfFloat1;
    boolean[] arrayOfBoolean;
    for (float f3 = paramTextPaint.getTextSize() / 6.0F;; f3 = 0.0F)
    {
      i = this.RAP.length();
      paramTextPaint = new int[i];
      arrayOfFloat1 = new float[i];
      arrayOfBoolean = new boolean[i];
      i = 0;
      while (i < paramArrayOfFloat.length)
      {
        paramArrayOfFloat[i] += f6;
        i += 1;
      }
    }
    int i3 = nComputeBreak(this.RAP, this.RAR, paramArrayOfFloat, paramFloat + f6, paramTextPaint, arrayOfFloat1, f3, arrayOfBoolean, a.RAK, this.RAU, a.RAJ, this.RAT, this.RBq);
    this.RBI = i3;
    float f2 = 0.0F;
    int i = 0;
    float f5;
    float f1;
    float f4;
    if ((i < i3) && (i < paramInt))
    {
      f5 = arrayOfFloat1[i];
      if (i < paramArrayOfFloat.length) {}
      for (f1 = paramArrayOfFloat[i];; f1 = paramFloat)
      {
        f4 = f2;
        if (f2 < f5) {
          f4 = Math.min(f5, f1);
        }
        i += 1;
        f2 = f4;
        break;
      }
    }
    i = 0;
    int k = 0;
    int i2;
    int n;
    if ((k < i3) && (k < paramInt))
    {
      i2 = paramTextPaint[k];
      paramBoolean = arrayOfBoolean[k];
      n = i2 - i;
      if (k < paramArrayOfFloat.length)
      {
        f1 = paramArrayOfFloat[k] - f6;
        f4 = 0.0F;
        f5 = f1 - arrayOfFloat1[k];
        if (f5 <= 0.0F) {
          break label551;
        }
        f5 -= 2.0F;
      }
    }
    label538:
    label551:
    for (;;)
    {
      int m;
      if ((f5 < 0.0F) || (Math.abs(f5) - 1.0F <= f6)) {
        m = 1;
      }
      label328:
      int j;
      for (;;)
      {
        if (m != 0)
        {
          j = n;
          if (i2 - 1 >= 0)
          {
            j = n;
            if (this.RAQ[(i2 - 1)] == '\n') {
              j = n - 1;
            }
          }
          n = i;
          for (;;)
          {
            if (n < i2)
            {
              int i1 = j;
              if (this.RAQ[n] != '\n')
              {
                i1 = j;
                if (this.RAR[n] == 0.0F) {
                  i1 = j - 1;
                }
              }
              n += 1;
              j = i1;
              continue;
              f1 = paramFloat;
              break;
              m = 0;
              break label328;
            }
          }
          f4 = f5 / (Math.max(2, j) - 1);
        }
      }
      label465:
      char[] arrayOfChar;
      float[] arrayOfFloat2;
      if (m != 0)
      {
        f5 = f1;
        arrayOfChar = this.RAQ;
        arrayOfFloat2 = this.RAR;
        j = this.RAX.size();
        if (m == 0) {
          break label538;
        }
      }
      for (;;)
      {
        a(arrayOfChar, i, i2, f5, arrayOfFloat2, j, f4, paramBoolean, f3, f1);
        k += 1;
        i = i2;
        break;
        f5 = arrayOfFloat1[k];
        break label465;
        f1 = f2;
      }
      AppMethodBeat.o(192277);
      return;
    }
  }
  
  public final int hiG()
  {
    return this.RBI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.NeatLayout
 * JD-Core Version:    0.7.0.1
 */