package com.tencent.mm.wear.app.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.tencent.mm.wear.app.MMApplication;
import java.util.Arrays;
import java.util.Comparator;

public final class c
{
  private static c abK = null;
  public static int abS = 6;
  private static final Comparator<d> abT = new Comparator() {};
  private String[] abL = null;
  private String[] abM = null;
  private String[] abN = null;
  private String[] abO = null;
  private String[] abP = null;
  private String[] abQ = null;
  private d[] abR = null;
  
  private c(Context paramContext)
  {
    this.abL = paramContext.getResources().getStringArray(2131492882);
    this.abM = paramContext.getResources().getStringArray(2131492885);
    this.abN = paramContext.getResources().getStringArray(2131492883);
    this.abO = paramContext.getResources().getStringArray(2131492887);
    this.abP = paramContext.getResources().getStringArray(2131492884);
    this.abQ = paramContext.getResources().getStringArray(2131492886);
    this.abR = new d[this.abL.length * 6];
    int j = 0;
    int i = 0;
    while (j < this.abL.length)
    {
      this.abR[i] = new d(j, this.abL[j]);
      i += 1;
      j += 1;
    }
    j = 0;
    while (j < this.abM.length)
    {
      this.abR[i] = new d(j, this.abM[j]);
      i += 1;
      j += 1;
    }
    j = 0;
    while (j < this.abN.length)
    {
      this.abR[i] = new d(j, this.abN[j]);
      i += 1;
      j += 1;
    }
    j = 0;
    while (j < this.abO.length)
    {
      this.abR[i] = new d(j, this.abO[j]);
      i += 1;
      j += 1;
    }
    j = 0;
    int k;
    int m;
    for (;;)
    {
      k = n;
      m = i;
      if (j >= this.abP.length) {
        break;
      }
      this.abR[i] = new d(j, this.abP[j]);
      i += 1;
      j += 1;
    }
    while (k < this.abQ.length)
    {
      this.abR[m] = new d(k, this.abQ[k]);
      m += 1;
      k += 1;
    }
    Arrays.sort(this.abR, abT);
  }
  
  private static boolean a(int paramInt1, SpannableString paramSpannableString, int paramInt2)
  {
    boolean bool2 = false;
    String str = paramSpannableString.subSequence(paramInt1, paramSpannableString.length());
    Object localObject = mA().abR;
    int j = Arrays.binarySearch((Object[])localObject, new d(0, str), abT);
    int i = j;
    if (j < 0) {
      i = -j - 2;
    }
    if ((i >= 0) && (str.startsWith(localObject[i].abU))) {}
    for (str = localObject[i];; str = null)
    {
      boolean bool1 = bool2;
      if (str != null)
      {
        localObject = a.mw().bJ(str.pos);
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (paramInt1 <= paramSpannableString.length())
          {
            bool1 = bool2;
            if (str.abU.length() + paramInt1 <= paramSpannableString.length())
            {
              a.mw().a(paramSpannableString, (Drawable)localObject, paramInt1, paramInt1 + str.abU.length(), paramInt2);
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
  }
  
  public static c mA()
  {
    if (abK == null) {
      abK = new c(MMApplication.getContext());
    }
    return abK;
  }
  
  public final boolean a(Context paramContext, SpannableString paramSpannableString, int paramInt)
  {
    if ((paramSpannableString == null) || (paramSpannableString.length() == 0))
    {
      bool2 = false;
      return bool2;
    }
    paramContext = paramSpannableString.toString();
    int k = -1;
    boolean bool2 = false;
    int i = 0;
    boolean bool1;
    int m;
    for (;;)
    {
      int j = paramContext.indexOf('/', k + 1);
      k = j;
      bool1 = bool2;
      m = i;
      if (j == -1) {
        break;
      }
      k = j;
      if (j < paramContext.length() - 1)
      {
        k = j;
        if (i < 300)
        {
          k = j;
          if (a(j, paramSpannableString, paramInt))
          {
            bool2 = true;
            i += 1;
            k = j;
          }
        }
      }
    }
    for (;;)
    {
      i = paramContext.indexOf('[', k + 1);
      bool2 = bool1;
      if (i == -1) {
        break;
      }
      k = i;
      if (i < paramContext.length() - 1)
      {
        k = i;
        if (m < 300)
        {
          k = i;
          if (a(i, paramSpannableString, paramInt))
          {
            m += 1;
            bool1 = true;
            k = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.app.emoji.c
 * JD-Core Version:    0.7.0.1
 */