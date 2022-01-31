package com.tencent.mm.pluginsdk.f;

import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class g
{
  private static int a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79454);
    if ((paramInt1 + 1 < paramInt2) && (paramSpannableStringBuilder.charAt(paramInt1 + 1) == '\''))
    {
      paramSpannableStringBuilder.delete(paramInt1, paramInt1 + 1);
      AppMethodBeat.o(79454);
      return 1;
    }
    int j = 0;
    paramSpannableStringBuilder.delete(paramInt1, paramInt1 + 1);
    int i = paramInt2 - 1;
    paramInt2 = j;
    for (;;)
    {
      if (paramInt1 < i)
      {
        if (paramSpannableStringBuilder.charAt(paramInt1) == '\'')
        {
          if ((paramInt1 + 1 < i) && (paramSpannableStringBuilder.charAt(paramInt1 + 1) == '\''))
          {
            paramSpannableStringBuilder.delete(paramInt1, paramInt1 + 1);
            i -= 1;
            paramInt2 += 1;
            paramInt1 += 1;
            continue;
          }
          paramSpannableStringBuilder.delete(paramInt1, paramInt1 + 1);
        }
      }
      else
      {
        AppMethodBeat.o(79454);
        return paramInt2;
      }
      paramInt1 += 1;
      paramInt2 += 1;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Time paramTime)
  {
    AppMethodBeat.i(79453);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    int i = paramCharSequence.length();
    int m = 0;
    int j;
    int k;
    if (m < i)
    {
      j = 1;
      k = localSpannableStringBuilder.charAt(m);
      if (k == 39)
      {
        j = a(localSpannableStringBuilder, m, i);
        i = localSpannableStringBuilder.length();
      }
    }
    for (;;)
    {
      m = j + m;
      break;
      while ((m + j < i) && (localSpannableStringBuilder.charAt(m + j) == k)) {
        j += 1;
      }
      switch (k)
      {
      default: 
        paramCharSequence = null;
      }
      for (;;)
      {
        if (paramCharSequence != null)
        {
          localSpannableStringBuilder.replace(m, m + j, paramCharSequence);
          j = paramCharSequence.length();
          i = localSpannableStringBuilder.length();
          break;
          if (paramTime.hour < 12) {}
          for (k = 0;; k = 1)
          {
            paramCharSequence = DateUtils.getAMPMString(k);
            break;
          }
          if (paramTime.hour < 12) {}
          for (k = 0;; k = 1)
          {
            paramCharSequence = DateUtils.getAMPMString(k);
            break;
          }
          paramCharSequence = hb(paramTime.monthDay, j);
          continue;
          int n = paramTime.weekDay;
          if (j < 4) {}
          for (k = 20;; k = 10)
          {
            paramCharSequence = DateUtils.getDayOfWeekString(n + 1, k);
            break;
          }
          n = paramTime.hour;
          k = n;
          if (n == 0) {
            k = 12;
          }
          n = k;
          if (k > 12) {
            n = k - 12;
          }
          paramCharSequence = String.valueOf(n);
          continue;
          paramCharSequence = hb(paramTime.hour, j);
          continue;
          paramCharSequence = hb(paramTime.minute, j);
          continue;
          k = paramTime.month;
          if (j >= 4)
          {
            paramCharSequence = DateUtils.getMonthString(k, 10);
          }
          else if (j == 3)
          {
            paramCharSequence = DateUtils.getMonthString(k, 20);
          }
          else
          {
            paramCharSequence = hb(k + 1, j);
            continue;
            paramCharSequence = hb(paramTime.second, j);
            continue;
            paramCharSequence = TimeZone.getDefault();
            paramCharSequence.inDaylightTime(new Date(paramTime.toMillis(false)));
            if (j < 2)
            {
              long l = (paramCharSequence.getRawOffset() + paramTime.gmtoff) / 1000L;
              paramCharSequence = new StringBuilder();
              if (l < 0L)
              {
                paramCharSequence.insert(0, "-");
                l = -l;
              }
              for (;;)
              {
                k = (int)(l / 3600L);
                n = (int)(l % 3600L / 60L);
                paramCharSequence.append(hb(k, 2));
                paramCharSequence.append(hb(n, 2));
                paramCharSequence = paramCharSequence.toString();
                break;
                paramCharSequence.insert(0, "+");
              }
            }
            if (paramTime.isDst != 0) {}
            for (boolean bool = true;; bool = false)
            {
              paramCharSequence = paramCharSequence.getDisplayName(bool, 0);
              break;
            }
            k = paramTime.year;
            if (j <= 2)
            {
              paramCharSequence = hb(k % 100, 2);
            }
            else
            {
              paramCharSequence = String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(k) });
              continue;
              paramCharSequence = localSpannableStringBuilder.toString();
              AppMethodBeat.o(79453);
              return paramCharSequence;
            }
          }
        }
      }
    }
  }
  
  private static String hb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79455);
    String str = String.format(Locale.getDefault(), "%0" + paramInt2 + "d", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(79455);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.g
 * JD-Core Version:    0.7.0.1
 */