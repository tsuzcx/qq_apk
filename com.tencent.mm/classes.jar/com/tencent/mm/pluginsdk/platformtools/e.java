package com.tencent.mm.pluginsdk.platformtools;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.format.DateUtils;
import android.text.format.Time;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class e
{
  private static int a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151897);
    if ((paramInt1 + 1 < paramInt2) && (paramSpannableStringBuilder.charAt(paramInt1 + 1) == '\''))
    {
      paramSpannableStringBuilder.delete(paramInt1, paramInt1 + 1);
      AppMethodBeat.o(151897);
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
        AppMethodBeat.o(151897);
        return paramInt2;
      }
      paramInt1 += 1;
      paramInt2 += 1;
    }
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Time paramTime)
  {
    AppMethodBeat.i(151896);
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
      Object localObject;
      switch (k)
      {
      default: 
        localObject = null;
      }
      for (;;)
      {
        if (localObject != null)
        {
          localSpannableStringBuilder.replace(m, m + j, (CharSequence)localObject);
          j = ((String)localObject).length();
          i = localSpannableStringBuilder.length();
          break;
          if (paramTime.hour < 12) {}
          for (k = 0;; k = 1)
          {
            localObject = DateUtils.getAMPMString(k);
            break;
          }
          if (paramTime.hour < 12) {}
          for (k = 0;; k = 1)
          {
            localObject = DateUtils.getAMPMString(k);
            break;
          }
          localObject = nI(paramTime.monthDay, j);
          continue;
          int n = paramTime.weekDay;
          if (j < 4) {}
          for (k = 20;; k = 10)
          {
            localObject = DateUtils.getDayOfWeekString(n + 1, k);
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
          localObject = String.valueOf(n);
          continue;
          localObject = nI(paramTime.hour, j);
          continue;
          localObject = nI(paramTime.minute, j);
          continue;
          k = paramTime.month;
          if (j >= 4)
          {
            localObject = DateUtils.getMonthString(k, 10);
          }
          else if (j == 3)
          {
            localObject = DateUtils.getMonthString(k, 20);
          }
          else
          {
            localObject = nI(k + 1, j);
            continue;
            localObject = nI(paramTime.second, j);
            continue;
            localObject = TimeZone.getDefault();
            ((TimeZone)localObject).inDaylightTime(new Date(paramTime.toMillis(false)));
            if (j < 2)
            {
              long l = (((TimeZone)localObject).getRawOffset() + paramTime.gmtoff) / 1000L;
              localObject = new StringBuilder();
              if (l < 0L)
              {
                ((StringBuilder)localObject).insert(0, "-");
                l = -l;
              }
              for (;;)
              {
                k = (int)(l / 3600L);
                n = (int)(l % 3600L / 60L);
                ((StringBuilder)localObject).append(nI(k, 2));
                ((StringBuilder)localObject).append(nI(n, 2));
                localObject = ((StringBuilder)localObject).toString();
                break;
                ((StringBuilder)localObject).insert(0, "+");
              }
            }
            if (paramTime.isDst != 0) {}
            for (boolean bool = true;; bool = false)
            {
              localObject = ((TimeZone)localObject).getDisplayName(bool, 0);
              break;
            }
            k = paramTime.year;
            if (j <= 2)
            {
              localObject = nI(k % 100, 2);
            }
            else
            {
              localObject = String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(k) });
              continue;
              if ((paramCharSequence instanceof Spanned))
              {
                paramCharSequence = new SpannedString(localSpannableStringBuilder);
                AppMethodBeat.o(151896);
                return paramCharSequence;
              }
              paramCharSequence = localSpannableStringBuilder.toString();
              AppMethodBeat.o(151896);
              return paramCharSequence;
            }
          }
        }
      }
    }
  }
  
  private static String nI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151898);
    if (paramInt2 == 2)
    {
      if (paramInt1 < 10)
      {
        str = "0".concat(String.valueOf(paramInt1));
        AppMethodBeat.o(151898);
        return str;
      }
      AppMethodBeat.o(151898);
      return String.valueOf(paramInt1);
    }
    String str = String.format(Locale.getDefault(), "%0" + paramInt2 + "d", new Object[] { Integer.valueOf(paramInt1) });
    AppMethodBeat.o(151898);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.platformtools.e
 * JD-Core Version:    0.7.0.1
 */