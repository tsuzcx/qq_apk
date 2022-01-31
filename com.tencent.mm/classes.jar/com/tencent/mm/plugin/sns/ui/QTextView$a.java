package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import java.util.ArrayList;
import java.util.HashMap;

final class QTextView$a
{
  private static HashMap<String, Integer> oSQ = new HashMap();
  private String key = "";
  private int oSK = 0;
  boolean oSL = false;
  ArrayList<int[]> oSM = new ArrayList();
  float oSN;
  float oSO;
  float oSP;
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    String str = paramString1 + paramString2 + paramString3 + paramInt1 + paramInt2;
    if (str.equals(this.key)) {
      return this.oSK;
    }
    this.key = str;
    this.oSM.clear();
    this.oSL = false;
    this.oSN = 0.0F;
    this.oSO = 0.0F;
    this.oSP = 0.0F;
    if (paramInt2 == -1)
    {
      this.oSM.add(new int[] { 0, paramString1.length() });
      this.oSK = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
      return this.oSK;
    }
    if (paramString2 != null) {
      this.oSO = paramTextPaint.measureText(paramString2);
    }
    if (paramString3 != null) {
      this.oSP = paramTextPaint.measureText(paramString3);
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
        break label643;
      }
      this.oSK = 0;
      return this.oSK;
    }
    float f2 = paramTextPaint.measureText(paramString1.charAt(paramInt2));
    k = 0;
    int j;
    label357:
    int i2;
    int i1;
    if (paramString1.charAt(paramInt2) == '\n')
    {
      k = 1;
      this.oSM.add(new int[] { i, paramInt2 - 1 });
      j = paramInt2;
      if (k == 0) {
        break label569;
      }
      paramInt2 = -1;
      f2 = 0.0F;
      i2 = n;
      f1 = f2;
      k = paramInt2;
      i1 = m;
      if (this.oSM.size() == paramInt1 - 1)
      {
        i1 = (int)(m - (this.oSO + this.oSP));
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
        break label357;
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
        this.oSM.add(new int[] { i, j });
        break label357;
      }
      do
      {
        paramInt2 = j;
        if (paramString1.charAt(j) == ' ') {
          break;
        }
        paramInt2 = j - 1;
        j = paramInt2;
      } while (paramInt2 != 0);
      this.oSM.add(new int[] { i, paramInt2 });
      j = paramInt2;
      break label357;
      label569:
      f2 = f1 + f2;
      i2 = n;
      f1 = f2;
      k = i;
      i1 = m;
      if (j == paramString1.length() - 1)
      {
        this.oSM.add(new int[] { i, j });
        i2 = n;
        f1 = f2;
        k = i;
        i1 = m;
      }
    }
    label643:
    if (this.oSM.size() == 1)
    {
      this.oSK = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
      return this.oSK;
    }
    this.oSK = m;
    return this.oSK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView.a
 * JD-Core Version:    0.7.0.1
 */