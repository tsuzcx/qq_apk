package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import java.util.ArrayList;

final class TextViewMultilineEllipse$a
{
  boolean oSL = false;
  ArrayList<int[]> oSM = new ArrayList();
  float oSN;
  float oSO;
  float oSP;
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    this.oSM.clear();
    this.oSL = false;
    this.oSN = 0.0F;
    this.oSO = 0.0F;
    this.oSP = 0.0F;
    int i;
    if (paramInt2 == -1)
    {
      this.oSM.add(new int[] { 0, paramString1.length() });
      i = (int)(paramTextPaint.measureText(paramString1) + 0.5F);
    }
    label288:
    label486:
    do
    {
      return i;
      if (paramString2 != null) {
        this.oSO = paramTextPaint.measureText(paramString2);
      }
      if (paramString3 != null) {
        this.oSP = paramTextPaint.measureText(paramString3);
      }
      int m = -1;
      float f1 = 0.0F;
      int n = 1;
      int j = 0;
      i = paramInt2;
      paramInt2 = j;
      if (paramInt2 < paramString1.length())
      {
        j = m;
        if (m == -1) {
          j = paramInt2;
        }
        if (this.oSM.size() == paramInt1) {
          this.oSL = true;
        }
      }
      else
      {
        if (this.oSL)
        {
          paramString2 = (int[])this.oSM.get(this.oSM.size() - 1);
          this.oSN = paramTextPaint.measureText(paramString1.substring(paramString2[0], paramString2[1] + 1));
        }
        if (this.oSM.size() != 0) {
          continue;
        }
        return 0;
      }
      float f2 = paramTextPaint.measureText(paramString1.charAt(paramInt2));
      m = 0;
      int k;
      int i2;
      int i1;
      if (paramString1.charAt(paramInt2) == '\n')
      {
        m = 1;
        this.oSM.add(new int[] { j, paramInt2 - 1 });
        k = paramInt2;
        if (m == 0) {
          break label486;
        }
        paramInt2 = -1;
        f2 = 0.0F;
        i2 = n;
        f1 = f2;
        m = paramInt2;
        i1 = i;
        if (this.oSM.size() == paramInt1 - 1)
        {
          i1 = (int)(i - (this.oSO + this.oSP));
          i2 = 0;
          m = paramInt2;
          f1 = f2;
        }
      }
      for (;;)
      {
        paramInt2 = k + 1;
        n = i2;
        i = i1;
        break;
        k = paramInt2;
        if (f1 + f2 < i) {
          break label288;
        }
        m = 1;
        if (paramString1.charAt(paramInt2) != ' ')
        {
          k = paramInt2;
          if (n != 0) {}
        }
        else
        {
          k = paramInt2 - 1;
          this.oSM.add(new int[] { j, k });
          break label288;
        }
        while (paramString1.charAt(k) != ' ') {
          k -= 1;
        }
        this.oSM.add(new int[] { j, k });
        break label288;
        f2 = f1 + f2;
        i2 = n;
        f1 = f2;
        m = j;
        i1 = i;
        if (k == paramString1.length() - 1)
        {
          this.oSM.add(new int[] { j, k });
          i2 = n;
          f1 = f2;
          m = j;
          i1 = i;
        }
      }
    } while (this.oSM.size() != 1);
    return (int)(paramTextPaint.measureText(paramString1) + 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.TextViewMultilineEllipse.a
 * JD-Core Version:    0.7.0.1
 */