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
  private static c afl = null;
  public static int aft = 6;
  private static final Comparator<d> afu = new Comparator() {};
  private String[] afm = null;
  private String[] afn = null;
  private String[] afo = null;
  private String[] afp = null;
  private String[] afq = null;
  private String[] afr = null;
  private d[] afs = null;
  
  private c(Context paramContext)
  {
    this.afm = paramContext.getResources().getStringArray(2131492882);
    this.afn = paramContext.getResources().getStringArray(2131492885);
    this.afo = paramContext.getResources().getStringArray(2131492883);
    this.afp = paramContext.getResources().getStringArray(2131492887);
    this.afq = paramContext.getResources().getStringArray(2131492884);
    this.afr = paramContext.getResources().getStringArray(2131492886);
    this.afs = new d[this.afm.length * 6];
    int j = 0;
    int i = 0;
    while (j < this.afm.length)
    {
      this.afs[i] = new d(j, this.afm[j]);
      i += 1;
      j += 1;
    }
    j = 0;
    while (j < this.afn.length)
    {
      this.afs[i] = new d(j, this.afn[j]);
      i += 1;
      j += 1;
    }
    j = 0;
    while (j < this.afo.length)
    {
      this.afs[i] = new d(j, this.afo[j]);
      i += 1;
      j += 1;
    }
    j = 0;
    while (j < this.afp.length)
    {
      this.afs[i] = new d(j, this.afp[j]);
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
      if (j >= this.afq.length) {
        break;
      }
      this.afs[i] = new d(j, this.afq[j]);
      i += 1;
      j += 1;
    }
    while (k < this.afr.length)
    {
      this.afs[m] = new d(k, this.afr[k]);
      m += 1;
      k += 1;
    }
    Arrays.sort(this.afs, afu);
  }
  
  private static d K(String paramString)
  {
    d[] arrayOfd = nm().afs;
    int j = Arrays.binarySearch(arrayOfd, new d(0, paramString), afu);
    int i = j;
    if (j < 0) {
      i = -j - 2;
    }
    if ((i >= 0) && (paramString.startsWith(arrayOfd[i].afv))) {
      return arrayOfd[i];
    }
    return null;
  }
  
  private static boolean a(int paramInt1, SpannableString paramSpannableString, int paramInt2)
  {
    d locald = K(paramSpannableString.subSequence(paramInt1, paramSpannableString.length()));
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (locald != null)
    {
      Drawable localDrawable = a.ni().cf(locald.pos);
      bool1 = bool2;
      if (localDrawable != null)
      {
        bool1 = bool2;
        if (paramInt1 <= paramSpannableString.length())
        {
          bool1 = bool2;
          if (locald.afv.length() + paramInt1 <= paramSpannableString.length())
          {
            a.ni().a(paramSpannableString, localDrawable, paramInt1, paramInt1 + locald.afv.length(), paramInt2);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static c nm()
  {
    if (afl == null) {
      afl = new c(MMApplication.getContext());
    }
    return afl;
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