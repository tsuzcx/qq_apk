package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.mm.plugin.sns.i.b;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ay
{
  private static HashMap<Long, Long> iiU = new HashMap();
  private static HashMap<Long, String> iiV = new HashMap();
  private static Map<String, List<String>> lgf = new HashMap();
  private static Map<String, List<String>> lgg = new HashMap();
  
  private static String K(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources().getStringArray(i.b.time_month);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    int i = 0;
    while (i < paramContext.length)
    {
      localArrayList.add(paramContext[i]);
      i += 1;
    }
    if (paramInt >= localArrayList.size()) {
      return "";
    }
    return (String)localArrayList.get(paramInt);
  }
  
  public static CharSequence a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L) {
      return "";
    }
    localGregorianCalendar = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
    long l = paramLong - localGregorianCalendar.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L) && (paramBoolean)) {
      return paramContext.getString(i.j.fmt_pre_nowday);
    }
    l = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l > 0L) && (l <= 86400000L) && (paramBoolean)) {
      return paramContext.getString(i.j.fmt_pre_yesterday);
    }
    new GregorianCalendar().setTimeInMillis(paramLong);
    return DateFormat.format(paramContext.getString(i.j.fmt_date_split), paramLong);
  }
  
  private static void aI(Context paramContext, String paramString)
  {
    paramContext = paramContext.getResources().getStringArray(i.b.time_month);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    int i = 0;
    while (i < paramContext.length)
    {
      localArrayList.add(paramContext[i]);
      i += 1;
    }
    lgg.put(paramString, localArrayList);
  }
  
  public static void clean()
  {
    try
    {
      iiU.clear();
      iiV.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String g(Context paramContext, long paramLong)
  {
    for (;;)
    {
      GregorianCalendar localGregorianCalendar;
      long l1;
      int j;
      int i;
      try
      {
        localGregorianCalendar = new GregorianCalendar();
        if (paramLong < 3600000L)
        {
          paramContext = "";
          return paramContext;
        }
        l1 = localGregorianCalendar.getTimeInMillis();
        if (iiU.containsKey(Long.valueOf(paramLong))) {
          if (l1 - ((Long)iiU.get(Long.valueOf(paramLong))).longValue() < 60000L)
          {
            if (iiV.containsKey(Long.valueOf(paramLong))) {
              paramContext = (String)iiV.get(Long.valueOf(paramLong));
            }
          }
          else {
            iiU.remove(Long.valueOf(paramLong));
          }
        }
        if ((l1 - paramLong) / 3600000L == 0L)
        {
          j = (int)((l1 - paramLong) / 60000L);
          i = j;
          if (j <= 0) {
            i = 1;
          }
          paramContext = paramContext.getResources().getQuantityString(i.h.fmt_in60min, i, new Object[] { Integer.valueOf(i) });
          iiV.put(Long.valueOf(paramLong), paramContext);
          iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
          continue;
        }
        localGregorianCalendar = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
      }
      finally {}
      long l2 = paramLong - localGregorianCalendar.getTimeInMillis();
      if ((l2 > 0L) && (l2 <= 86400000L))
      {
        j = (int)((l1 - paramLong) / 3600000L);
        i = j;
        if (j <= 0) {
          i = 1;
        }
        paramContext = paramContext.getResources().getQuantityString(i.h.fmt_in24h, i, new Object[] { Integer.valueOf(i) });
        iiV.put(Long.valueOf(paramLong), paramContext);
        iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
      }
      else
      {
        l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
        if ((l2 > 0L) && (l2 <= 86400000L))
        {
          paramContext = paramContext.getString(i.j.fmt_pre_yesterday);
          iiV.put(Long.valueOf(paramLong), paramContext);
          iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
        }
        else
        {
          j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
          i = j;
          if (j <= 0) {
            i = 1;
          }
          paramContext = paramContext.getResources().getQuantityString(i.h.fmt_indayh, i, new Object[] { Integer.valueOf(i) });
          iiV.put(Long.valueOf(paramLong), paramContext);
          iiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
        }
      }
    }
  }
  
  private static CharSequence h(Context paramContext, long paramLong)
  {
    return DateFormat.format(paramContext.getString(i.j.fmt_normal_time_24), paramLong);
  }
  
  public static String k(Context paramContext, long paramLong)
  {
    int n = 0;
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int k;
    int i;
    label59:
    int m;
    label86:
    label114:
    int j;
    if (((Calendar)localObject).get(1) == localCalendar.get(1))
    {
      k = 1;
      if ((k == 0) || (((Calendar)localObject).get(2) != localCalendar.get(2))) {
        break label231;
      }
      i = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) != localCalendar.get(5))) {
        break label236;
      }
      m = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) - 1 != localCalendar.get(5))) {
        break label242;
      }
      i = 1;
      if (i != 0) {
        break label488;
      }
      if ((k == 0) || (((Calendar)localObject).get(2) - 1 != localCalendar.get(2))) {
        break label247;
      }
      j = 1;
    }
    for (;;)
    {
      label143:
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
      label231:
      label488:
      for (;;)
      {
        if (m != 0)
        {
          return (String)h(paramContext, paramLong);
          k = 0;
          break;
          i = 0;
          break label59;
          label236:
          m = 0;
          break label86;
          label242:
          i = 0;
          break label114;
          label247:
          if (((Calendar)localObject).get(1) - localCalendar.get(1) != 1) {
            break label491;
          }
          j = 1;
          break label143;
        }
        if (i != 0) {
          return paramContext.getString(i.j.fmt_pre_yesterday) + " " + (String)h(paramContext, paramLong);
        }
        if (k != 0) {}
        for (String str = (String)DateFormat.format(paramContext.getString(i.j.fmt_date), paramLong);; str = (String)DateFormat.format(paramContext.getString(i.j.fmt_longdate), paramLong))
        {
          localObject = str;
          if (str.indexOf("-") > 0)
          {
            i = localCalendar.get(2);
            j = localCalendar.get(5);
            localObject = K(paramContext, i + 1);
            str = j + " " + (String)localObject;
            localObject = str;
            if (k == 0) {
              localObject = str + " " + localCalendar.get(1);
            }
          }
          return (String)localObject + " " + (String)h(paramContext, paramLong);
        }
      }
      label491:
      j = 0;
    }
  }
  
  public static String l(Context paramContext, long paramLong)
  {
    int n = 0;
    Object localObject = Calendar.getInstance();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    int k;
    int i;
    label59:
    int m;
    label86:
    label114:
    int j;
    if (((Calendar)localObject).get(1) == localCalendar.get(1))
    {
      k = 1;
      if ((k == 0) || (((Calendar)localObject).get(2) != localCalendar.get(2))) {
        break label231;
      }
      i = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) != localCalendar.get(5))) {
        break label236;
      }
      m = 1;
      if ((k == 0) || (i == 0) || (((Calendar)localObject).get(5) - 1 != localCalendar.get(5))) {
        break label242;
      }
      i = 1;
      if (i != 0) {
        break label464;
      }
      if ((k == 0) || (((Calendar)localObject).get(2) - 1 != localCalendar.get(2))) {
        break label247;
      }
      j = 1;
    }
    for (;;)
    {
      label143:
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
      label464:
      for (;;)
      {
        if (m != 0)
        {
          return (String)h(paramContext, paramLong);
          k = 0;
          break;
          label231:
          i = 0;
          break label59;
          label236:
          m = 0;
          break label86;
          label242:
          i = 0;
          break label114;
          label247:
          if (((Calendar)localObject).get(1) - localCalendar.get(1) != 1) {
            break label467;
          }
          j = 1;
          break label143;
        }
        if (i != 0) {
          return paramContext.getString(i.j.fmt_pre_yesterday) + " " + (String)h(paramContext, paramLong);
        }
        String str = (String)DateFormat.format(paramContext.getString(i.j.fmt_longdate), paramLong);
        localObject = str;
        if (str.indexOf("-") > 0)
        {
          i = localCalendar.get(2);
          j = localCalendar.get(5);
          localObject = K(paramContext, i + 1);
          str = j + " " + (String)localObject;
          localObject = str;
          if (k == 0) {
            localObject = str + " " + localCalendar.get(1);
          }
        }
        return (String)localObject + " " + (String)h(paramContext, paramLong);
      }
      label467:
      j = 0;
    }
  }
  
  public static String s(Context paramContext, String paramString1, String paramString2)
  {
    if (lgg.get(paramString2) == null) {
      aI(paramContext, paramString2);
    }
    int i = bk.getInt(paramString1, 0);
    paramString1 = (List)lgg.get(paramString2);
    if ((i >= paramString1.size()) || (paramString1.get(i) == null) || (((String)paramString1.get(i)).equals(""))) {
      aI(paramContext, paramString2);
    }
    paramContext = (List)lgg.get(paramString2);
    if (i < paramContext.size()) {
      return (String)paramContext.get(i);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ay
 * JD-Core Version:    0.7.0.1
 */