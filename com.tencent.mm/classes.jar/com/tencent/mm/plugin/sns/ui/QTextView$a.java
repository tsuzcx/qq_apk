package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;

final class QTextView$a
{
  private static HashMap<String, Integer> rKI;
  private String key;
  private int rKC;
  boolean rKD;
  ArrayList<int[]> rKE;
  float rKF;
  float rKG;
  float rKH;
  
  static
  {
    AppMethodBeat.i(38528);
    rKI = new HashMap();
    AppMethodBeat.o(38528);
  }
  
  public QTextView$a()
  {
    AppMethodBeat.i(38525);
    this.rKC = 0;
    this.key = "";
    this.rKD = false;
    this.rKE = new ArrayList();
    AppMethodBeat.o(38525);
  }
  
  public final int a(String paramString, int paramInt, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(38526);
    paramInt = a(paramString, null, null, -1, paramInt, paramTextPaint);
    AppMethodBeat.o(38526);
    return paramInt;
  }
  
  public final int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, TextPaint paramTextPaint)
  {
    AppMethodBeat.i(38527);
    String str = paramString1 + paramString2 + paramString3 + paramInt1 + paramInt2;
    if (str.equals(this.key))
    {
      paramInt1 = this.rKC;
      AppMethodBeat.o(38527);
      return paramInt1;
    }
    this.key = str;
    this.rKE.clear();
    this.rKD = false;
    this.rKF = 0.0F;
    this.rKG = 0.0F;
    this.rKH = 0.0F;
    if (paramInt2 == -1)
    {
      this.rKE.add(new int[] { 0, paramString1.length() });
      this.rKC = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
      paramInt1 = this.rKC;
      AppMethodBeat.o(38527);
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
        break label675;
      }
      this.rKC = 0;
      paramInt1 = this.rKC;
      AppMethodBeat.o(38527);
      return paramInt1;
    }
    float f2 = paramTextPaint.measureText(paramString1.charAt(paramInt2));
    k = 0;
    int j;
    label389:
    int i2;
    int i1;
    if (paramString1.charAt(paramInt2) == '\n')
    {
      k = 1;
      this.rKE.add(new int[] { i, paramInt2 - 1 });
      j = paramInt2;
      if (k == 0) {
        break label601;
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
        break label389;
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
        break label389;
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
      this.rKE.add(new int[] { i, paramInt2 });
      j = paramInt2;
      break label389;
      label601:
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
    label675:
    if (this.rKE.size() == 1)
    {
      this.rKC = ((int)(paramTextPaint.measureText(paramString1) + 0.5F));
      paramInt1 = this.rKC;
      AppMethodBeat.o(38527);
      return paramInt1;
    }
    this.rKC = m;
    paramInt1 = this.rKC;
    AppMethodBeat.o(38527);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.QTextView.a
 * JD-Core Version:    0.7.0.1
 */