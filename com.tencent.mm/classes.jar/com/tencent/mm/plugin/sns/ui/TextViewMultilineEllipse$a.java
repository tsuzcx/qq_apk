package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class TextViewMultilineEllipse$a
{
  boolean rKD;
  ArrayList<int[]> rKE;
  float rKF;
  float rKG;
  float rKH;
  
  public TextViewMultilineEllipse$a()
  {
    AppMethodBeat.i(39843);
    this.rKD = false;
    this.rKE = new ArrayList();
    AppMethodBeat.o(39843);
  }
  
  public final int a(String paramString, int paramInt, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(39844);
    paramInt = a(paramString, null, null, -1, paramInt, paramTextPaint);
    AppMethodBeat.o(39844);
    return paramInt;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(39845);
    this.rKE.clear();
    this.rKD = false;
    this.rKF = 0.0F;
    this.rKG = 0.0F;
    this.rKH = 0.0F;
    if (paramInt2 == -1)
    {
      this.rKE.add(new int[] { 0, paramString1.length() });
      paramInt1 = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
      AppMethodBeat.o(39845);
      return paramInt1;
    }
    if (paramString2 != null) {
      this.rKG = paramTextPaint.measureText(paramString2);
    }
    if (paramString3 != null) {
      this.rKH = paramTextPaint.measureText(paramString3);
    }
    int k = -1;
    float f1 = 0.0F;
    int n = 1;
    int i = 0;
    int m = paramInt2;
    paramInt2 = i;
    if (paramInt2 < paramString1.length())
    {
      i = k;
      if (k == -1) {
        i = paramInt2;
      }
      if (this.rKE.size() == paramInt1) {
        this.rKD = true;
      }
    }
    else
    {
      if (this.rKD)
      {
        paramString2 = (int[])this.rKE.get(this.rKE.size() - 1);
        this.rKF = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
      }
      if (this.rKE.size() != 0) {
        break label575;
      }
      AppMethodBeat.o(39845);
      return 0;
    }
    float f2 = paramTextPaint.measureText(paramString1.charAt(paramInt2));
    k = 0;
    int j;
    label303:
    int i2;
    int i1;
    if (paramString1.charAt(paramInt2) == '\n')
    {
      k = 1;
      this.rKE.add(new int[] { i, paramInt2 - 1 });
      j = paramInt2;
      if (k == 0) {
        break label501;
      }
      paramInt2 = -1;
      f2 = 0.0F;
      i2 = n;
      f1 = f2;
      k = paramInt2;
      i1 = m;
      if (this.rKE.size() == paramInt1 - 1)
      {
        i1 = (int)(m - (this.rKG + this.rKH));
        i2 = 0;
        k = paramInt2;
        f1 = f2;
      }
    }
    for (;;)
    {
      paramInt2 = j + 1;
      n = i2;
      m = i1;
      break;
      j = paramInt2;
      if (f1 + f2 < m) {
        break label303;
      }
      k = 1;
      if (paramString1.charAt(paramInt2) != ' ')
      {
        j = paramInt2;
        if (n != 0) {}
      }
      else
      {
        j = paramInt2 - 1;
        this.rKE.add(new int[] { i, j });
        break label303;
      }
      while (paramString1.charAt(j) != ' ') {
        j -= 1;
      }
      this.rKE.add(new int[] { i, j });
      break label303;
      label501:
      f2 = f1 + f2;
      i2 = n;
      f1 = f2;
      k = i;
      i1 = m;
      if (j == paramString1.length() - 1)
      {
        this.rKE.add(new int[] { i, j });
        i2 = n;
        f1 = f2;
        k = i;
        i1 = m;
      }
    }
    label575:
    if (this.rKE.size() == 1)
    {
      paramInt1 = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
      AppMethodBeat.o(39845);
      return paramInt1;
    }
    AppMethodBeat.o(39845);
    return m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TextViewMultilineEllipse.a
 * JD-Core Version:    0.7.0.1
 */