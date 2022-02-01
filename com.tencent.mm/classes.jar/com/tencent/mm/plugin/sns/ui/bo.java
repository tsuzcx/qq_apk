package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.b;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bo
{
  private static Map<String, List<String>> ADv;
  private static Map<String, List<String>> ADw;
  private static HashMap<Long, Long> sTn;
  private static HashMap<Long, String> sTo;
  
  static
  {
    AppMethodBeat.i(99442);
    ADv = new HashMap();
    ADw = new HashMap();
    sTn = new HashMap();
    sTo = new HashMap();
    AppMethodBeat.o(99442);
  }
  
  public static String R(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(99438);
    if (ADw.get(paramString2) == null) {
      bO(paramContext, paramString2);
    }
    int i = Util.getInt(paramString1, 0);
    paramString1 = (List)ADw.get(paramString2);
    if ((i >= paramString1.size()) || (paramString1.get(i) == null) || (((String)paramString1.get(i)).equals(""))) {
      bO(paramContext, paramString2);
    }
    paramContext = (List)ADw.get(paramString2);
    if (i < paramContext.size())
    {
      paramContext = (String)paramContext.get(i);
      AppMethodBeat.o(99438);
      return paramContext;
    }
    AppMethodBeat.o(99438);
    return "";
  }
  
  public static CharSequence Ro(long paramLong)
  {
    AppMethodBeat.i(99440);
    Object localObject = new GregorianCalendar();
    long l1 = paramLong - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
    if ((l1 > 0L) && (l1 <= 86400000L)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = MMApplicationContext.getContext().getResources().getString(i.j.fmt_pre_nowday);
      AppMethodBeat.o(99440);
      return localObject;
    }
    localObject = new GregorianCalendar();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5));
    int j = ((GregorianCalendar)localObject).get(7) - 1;
    i = j;
    if (j == 0) {
      i = 7;
    }
    l1 = localGregorianCalendar.getTimeInMillis();
    long l2 = i;
    long l3 = localGregorianCalendar.getTimeInMillis();
    long l4 = 7 - i;
    if ((paramLong >= l1 - l2 * 86400000L) && (paramLong < l3 + l4 * 86400000L)) {}
    for (i = 1; i != 0; i = 0)
    {
      localObject = MMApplicationContext.getContext().getResources().getString(i.j.fmt_during_week);
      AppMethodBeat.o(99440);
      return localObject;
    }
    localObject = DateFormat.format(MMApplicationContext.getContext().getString(i.j.fmt_year_month_split), paramLong);
    AppMethodBeat.o(99440);
    return localObject;
  }
  
  private static String aI(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(99437);
    paramContext = paramContext.getResources().getStringArray(i.b.time_month);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    int i = 0;
    while (i < paramContext.length)
    {
      localArrayList.add(paramContext[i]);
      i += 1;
    }
    if (paramInt >= localArrayList.size())
    {
      AppMethodBeat.o(99437);
      return "";
    }
    paramContext = (String)localArrayList.get(paramInt);
    AppMethodBeat.o(99437);
    return paramContext;
  }
  
  public static CharSequence b(Context paramContext, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(99439);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(99439);
      return "";
    }
    localGregorianCalendar = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
    long l = paramLong - localGregorianCalendar.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L) && (paramBoolean))
    {
      paramContext = paramContext.getString(i.j.fmt_pre_nowday);
      AppMethodBeat.o(99439);
      return paramContext;
    }
    l = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l > 0L) && (l <= 86400000L) && (paramBoolean))
    {
      paramContext = paramContext.getString(i.j.fmt_pre_yesterday);
      AppMethodBeat.o(99439);
      return paramContext;
    }
    new GregorianCalendar().setTimeInMillis(paramLong);
    paramContext = DateFormat.format(paramContext.getString(i.j.fmt_date_split), paramLong);
    AppMethodBeat.o(99439);
    return paramContext;
  }
  
  private static void bO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(99436);
    paramContext = paramContext.getResources().getStringArray(i.b.time_month);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    int i = 0;
    while (i < paramContext.length)
    {
      localArrayList.add(paramContext[i]);
      i += 1;
    }
    ADw.put(paramString, localArrayList);
    AppMethodBeat.o(99436);
  }
  
  public static void clean()
  {
    try
    {
      AppMethodBeat.i(99434);
      sTn.clear();
      sTo.clear();
      AppMethodBeat.o(99434);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static int getYear()
  {
    AppMethodBeat.i(99441);
    int i = new GregorianCalendar().get(1);
    AppMethodBeat.o(99441);
    return i;
  }
  
  private static CharSequence k(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(99431);
    paramContext = DateFormat.format(paramContext.getString(i.j.fmt_normal_time_24), paramLong);
    AppMethodBeat.o(99431);
    return paramContext;
  }
  
  public static String p(Context paramContext, long paramLong)
  {
    for (;;)
    {
      GregorianCalendar localGregorianCalendar;
      long l1;
      try
      {
        AppMethodBeat.i(99435);
        localGregorianCalendar = new GregorianCalendar();
        if (paramLong < 3600000L)
        {
          paramContext = "";
          AppMethodBeat.o(99435);
          return paramContext;
        }
        l1 = localGregorianCalendar.getTimeInMillis();
        if (sTn.containsKey(Long.valueOf(paramLong))) {
          if (l1 - ((Long)sTn.get(Long.valueOf(paramLong))).longValue() < 60000L)
          {
            if (sTo.containsKey(Long.valueOf(paramLong)))
            {
              paramContext = (String)sTo.get(Long.valueOf(paramLong));
              AppMethodBeat.o(99435);
            }
          }
          else {
            sTn.remove(Long.valueOf(paramLong));
          }
        }
      }
      finally {}
      int j;
      int i;
      if ((l1 - paramLong) / 3600000L == 0L)
      {
        j = (int)((l1 - paramLong) / 60000L);
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramContext = paramContext.getResources().getQuantityString(i.h.fmt_in60min, i, new Object[] { Integer.valueOf(i) });
        sTo.put(Long.valueOf(paramLong), paramContext);
        sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
        AppMethodBeat.o(99435);
      }
      else
      {
        localGregorianCalendar = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
        long l2 = paramLong - localGregorianCalendar.getTimeInMillis();
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          j = (int)((l1 - paramLong) / 3600000L);
          i = j;
          if (j <= 0) {
            i = 1;
          }
          paramContext = paramContext.getResources().getQuantityString(i.h.fmt_in24h, i, new Object[] { Integer.valueOf(i) });
          sTo.put(Long.valueOf(paramLong), paramContext);
          sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
          AppMethodBeat.o(99435);
        }
        else
        {
          l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
          if ((l2 > 0L) && (l2 <= 86400000L))
          {
            paramContext = paramContext.getString(i.j.fmt_pre_yesterday);
            sTo.put(Long.valueOf(paramLong), paramContext);
            sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(99435);
          }
          else
          {
            j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
            i = j;
            if (j <= 0) {
              i = 1;
            }
            paramContext = paramContext.getResources().getQuantityString(i.h.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
            sTo.put(Long.valueOf(paramLong), paramContext);
            sTn.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(99435);
          }
        }
      }
    }
  }
  
  public static String s(Context paramContext, long paramLong)
  {
    int n = 0;
    AppMethodBeat.i(99432);
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int k;
    int i;
    label64:
    int m;
    label91:
    label119:
    int j;
    if (((Calendar)localObject).get(1) == localCalendar.get(1))
    {
      k = 1;
      if ((k == 0) || (((Calendar)localObject).get(2) != localCalendar.get(2))) {
        break label243;
      }
      i = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) != localCalendar.get(5))) {
        break label248;
      }
      m = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) - 1 != localCalendar.get(5))) {
        break label254;
      }
      i = 1;
      if (i != 0) {
        break label515;
      }
      if ((k == 0) || (((Calendar)localObject).get(2) - 1 != localCalendar.get(2))) {
        break label259;
      }
      j = 1;
    }
    for (;;)
    {
      label148:
      if (j != 0)
      {
        ((Calendar)localObject).add(5, -1);
        i = n;
        if (((Calendar)localObject).get(1) == localCalendar.get(1))
        {
          i = n;
          if (((Calendar)localObject).get(2) == localCalendar.get(2))
          {
            i = n;
            if (((Calendar)localObject).get(5) == localCalendar.get(5)) {
              i = 1;
            }
          }
        }
      }
      label259:
      label515:
      for (;;)
      {
        if (m != 0)
        {
          paramContext = (String)k(paramContext, paramLong);
          AppMethodBeat.o(99432);
          return paramContext;
          k = 0;
          break;
          label243:
          i = 0;
          break label64;
          label248:
          m = 0;
          break label91;
          label254:
          i = 0;
          break label119;
          if (((Calendar)localObject).get(1) - localCalendar.get(1) != 1) {
            break label518;
          }
          j = 1;
          break label148;
        }
        if (i != 0)
        {
          paramContext = paramContext.getString(i.j.fmt_pre_yesterday) + " " + (String)k(paramContext, paramLong);
          AppMethodBeat.o(99432);
          return paramContext;
        }
        if (k != 0) {}
        for (String str = (String)DateFormat.format(paramContext.getString(i.j.fmt_date), paramLong);; str = (String)DateFormat.format(paramContext.getString(i.j.fmt_longdate), paramLong))
        {
          localObject = str;
          if (str.indexOf("-") > 0)
          {
            i = localCalendar.get(2);
            j = localCalendar.get(5);
            localObject = aI(paramContext, i + 1);
            str = j + " " + (String)localObject;
            localObject = str;
            if (k == 0) {
              localObject = str + " " + localCalendar.get(1);
            }
          }
          paramContext = (String)localObject + " " + (String)k(paramContext, paramLong);
          AppMethodBeat.o(99432);
          return paramContext;
        }
      }
      label518:
      j = 0;
    }
  }
  
  public static String t(Context paramContext, long paramLong)
  {
    int n = 0;
    AppMethodBeat.i(99433);
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int k;
    int i;
    label65:
    int m;
    label92:
    label120:
    int j;
    if (((Calendar)localObject).get(1) == localCalendar.get(1))
    {
      k = 1;
      if ((k == 0) || (((Calendar)localObject).get(2) != localCalendar.get(2))) {
        break label245;
      }
      i = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) != localCalendar.get(5))) {
        break label250;
      }
      m = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) - 1 != localCalendar.get(5))) {
        break label256;
      }
      i = 1;
      if (i != 0) {
        break label495;
      }
      if ((k == 0) || (((Calendar)localObject).get(2) - 1 != localCalendar.get(2))) {
        break label261;
      }
      j = 1;
    }
    for (;;)
    {
      label149:
      if (j != 0)
      {
        ((Calendar)localObject).add(5, -1);
        i = n;
        if (((Calendar)localObject).get(1) == localCalendar.get(1))
        {
          i = n;
          if (((Calendar)localObject).get(2) == localCalendar.get(2))
          {
            i = n;
            if (((Calendar)localObject).get(5) == localCalendar.get(5)) {
              i = 1;
            }
          }
        }
      }
      label256:
      label261:
      label495:
      for (;;)
      {
        if (m != 0)
        {
          paramContext = (String)k(paramContext, paramLong);
          AppMethodBeat.o(99433);
          return paramContext;
          k = 0;
          break;
          label245:
          i = 0;
          break label65;
          label250:
          m = 0;
          break label92;
          i = 0;
          break label120;
          if (((Calendar)localObject).get(1) - localCalendar.get(1) != 1) {
            break label498;
          }
          j = 1;
          break label149;
        }
        if (i != 0)
        {
          paramContext = paramContext.getString(i.j.fmt_pre_yesterday) + " " + (String)k(paramContext, paramLong);
          AppMethodBeat.o(99433);
          return paramContext;
        }
        String str = (String)DateFormat.format(paramContext.getString(i.j.fmt_longdate), paramLong);
        localObject = str;
        if (str.indexOf("-") > 0)
        {
          i = localCalendar.get(2);
          j = localCalendar.get(5);
          localObject = aI(paramContext, i + 1);
          str = j + " " + (String)localObject;
          localObject = str;
          if (k == 0) {
            localObject = str + " " + localCalendar.get(1);
          }
        }
        paramContext = (String)localObject + " " + (String)k(paramContext, paramLong);
        AppMethodBeat.o(99433);
        return paramContext;
      }
      label498:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bo
 * JD-Core Version:    0.7.0.1
 */