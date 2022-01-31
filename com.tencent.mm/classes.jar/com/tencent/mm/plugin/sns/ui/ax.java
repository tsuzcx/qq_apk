package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ax
{
  private static HashMap<Long, Long> kiU;
  private static HashMap<Long, String> kiV;
  private static Map<String, List<String>> nEa;
  private static Map<String, List<String>> nEb;
  
  static
  {
    AppMethodBeat.i(39614);
    nEa = new HashMap();
    nEb = new HashMap();
    kiU = new HashMap();
    kiV = new HashMap();
    AppMethodBeat.o(39614);
  }
  
  private static String X(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(39609);
    paramContext = paramContext.getResources().getStringArray(2131755061);
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
      AppMethodBeat.o(39609);
      return "";
    }
    paramContext = (String)localArrayList.get(paramInt);
    AppMethodBeat.o(39609);
    return paramContext;
  }
  
  public static CharSequence a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(39611);
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    if (paramLong < 3600000L)
    {
      AppMethodBeat.o(39611);
      return "";
    }
    localGregorianCalendar = new GregorianCalendar(localGregorianCalendar.get(1), localGregorianCalendar.get(2), localGregorianCalendar.get(5));
    long l = paramLong - localGregorianCalendar.getTimeInMillis();
    if ((l > 0L) && (l <= 86400000L) && (paramBoolean))
    {
      paramContext = paramContext.getString(2131300075);
      AppMethodBeat.o(39611);
      return paramContext;
    }
    l = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
    if ((l > 0L) && (l <= 86400000L) && (paramBoolean))
    {
      paramContext = paramContext.getString(2131300084);
      AppMethodBeat.o(39611);
      return paramContext;
    }
    new GregorianCalendar().setTimeInMillis(paramLong);
    paramContext = DateFormat.format(paramContext.getString(2131300032), paramLong);
    AppMethodBeat.o(39611);
    return paramContext;
  }
  
  private static void aR(Context paramContext, String paramString)
  {
    AppMethodBeat.i(39608);
    paramContext = paramContext.getResources().getStringArray(2131755061);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    int i = 0;
    while (i < paramContext.length)
    {
      localArrayList.add(paramContext[i]);
      i += 1;
    }
    nEb.put(paramString, localArrayList);
    AppMethodBeat.o(39608);
  }
  
  public static void clean()
  {
    try
    {
      AppMethodBeat.i(39606);
      kiU.clear();
      kiV.clear();
      AppMethodBeat.o(39606);
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
    AppMethodBeat.i(39613);
    int i = new GregorianCalendar().get(1);
    AppMethodBeat.o(39613);
    return i;
  }
  
  public static String h(Context paramContext, long paramLong)
  {
    for (;;)
    {
      GregorianCalendar localGregorianCalendar;
      long l1;
      try
      {
        AppMethodBeat.i(39607);
        localGregorianCalendar = new GregorianCalendar();
        if (paramLong < 3600000L)
        {
          paramContext = "";
          AppMethodBeat.o(39607);
          return paramContext;
        }
        l1 = localGregorianCalendar.getTimeInMillis();
        if (kiU.containsKey(Long.valueOf(paramLong))) {
          if (l1 - ((Long)kiU.get(Long.valueOf(paramLong))).longValue() < 60000L)
          {
            if (kiV.containsKey(Long.valueOf(paramLong)))
            {
              paramContext = (String)kiV.get(Long.valueOf(paramLong));
              AppMethodBeat.o(39607);
            }
          }
          else {
            kiU.remove(Long.valueOf(paramLong));
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
        paramContext = paramContext.getResources().getQuantityString(2131361802, i, new Object[] { Integer.valueOf(i) });
        kiV.put(Long.valueOf(paramLong), paramContext);
        kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
        AppMethodBeat.o(39607);
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
          paramContext = paramContext.getResources().getQuantityString(2131361801, i, new Object[] { Integer.valueOf(i) });
          kiV.put(Long.valueOf(paramLong), paramContext);
          kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
          AppMethodBeat.o(39607);
        }
        else
        {
          l2 = paramLong - localGregorianCalendar.getTimeInMillis() + 86400000L;
          if ((l2 > 0L) && (l2 <= 86400000L))
          {
            paramContext = paramContext.getString(2131300084);
            kiV.put(Long.valueOf(paramLong), paramContext);
            kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(39607);
          }
          else
          {
            j = (int)((localGregorianCalendar.getTimeInMillis() + 86400000L - paramLong) / 86400000L);
            i = j;
            if (j <= 0) {
              i = 1;
            }
            paramContext = paramContext.getResources().getQuantityString(2131361803, i, new Object[] { Integer.valueOf(i) });
            kiV.put(Long.valueOf(paramLong), paramContext);
            kiU.put(Long.valueOf(paramLong), Long.valueOf(l1));
            AppMethodBeat.o(39607);
          }
        }
      }
    }
  }
  
  private static CharSequence i(Context paramContext, long paramLong)
  {
    AppMethodBeat.i(39603);
    paramContext = DateFormat.format(paramContext.getString(2131300062), paramLong);
    AppMethodBeat.o(39603);
    return paramContext;
  }
  
  public static String l(Context paramContext, long paramLong)
  {
    int n = 0;
    AppMethodBeat.i(39604);
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
        break label511;
      }
      if ((k == 0) || (((Calendar)localObject).get(2) - 1 != localCalendar.get(2))) {
        break label259;
      }
      j = 1;
    }
    label514:
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
      label243:
      label248:
      label254:
      label511:
      for (;;)
      {
        if (m != 0)
        {
          paramContext = (String)i(paramContext, paramLong);
          AppMethodBeat.o(39604);
          return paramContext;
          k = 0;
          break;
          i = 0;
          break label64;
          m = 0;
          break label91;
          i = 0;
          break label119;
          if (((Calendar)localObject).get(1) - localCalendar.get(1) != 1) {
            break label514;
          }
          j = 1;
          break label148;
        }
        if (i != 0)
        {
          paramContext = paramContext.getString(2131300084) + " " + (String)i(paramContext, paramLong);
          AppMethodBeat.o(39604);
          return paramContext;
        }
        if (k != 0) {}
        for (String str = (String)DateFormat.format(paramContext.getString(2131300031), paramLong);; str = (String)DateFormat.format(paramContext.getString(2131300050), paramLong))
        {
          localObject = str;
          if (str.indexOf("-") > 0)
          {
            i = localCalendar.get(2);
            j = localCalendar.get(5);
            localObject = X(paramContext, i + 1);
            str = j + " " + (String)localObject;
            localObject = str;
            if (k == 0) {
              localObject = str + " " + localCalendar.get(1);
            }
          }
          paramContext = (String)localObject + " " + (String)i(paramContext, paramLong);
          AppMethodBeat.o(39604);
          return paramContext;
        }
      }
      label259:
      j = 0;
    }
  }
  
  public static String m(Context paramContext, long paramLong)
  {
    int n = 0;
    AppMethodBeat.i(39605);
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
        break label488;
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
      label488:
      for (;;)
      {
        if (m != 0)
        {
          paramContext = (String)i(paramContext, paramLong);
          AppMethodBeat.o(39605);
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
            break label491;
          }
          j = 1;
          break label148;
        }
        if (i != 0)
        {
          paramContext = paramContext.getString(2131300084) + " " + (String)i(paramContext, paramLong);
          AppMethodBeat.o(39605);
          return paramContext;
        }
        String str = (String)DateFormat.format(paramContext.getString(2131300050), paramLong);
        localObject = str;
        if (str.indexOf("-") > 0)
        {
          i = localCalendar.get(2);
          j = localCalendar.get(5);
          localObject = X(paramContext, i + 1);
          str = j + " " + (String)localObject;
          localObject = str;
          if (k == 0) {
            localObject = str + " " + localCalendar.get(1);
          }
        }
        paramContext = (String)localObject + " " + (String)i(paramContext, paramLong);
        AppMethodBeat.o(39605);
        return paramContext;
      }
      label491:
      j = 0;
    }
  }
  
  public static CharSequence mh(long paramLong)
  {
    AppMethodBeat.i(39612);
    Object localObject = new GregorianCalendar();
    long l1 = paramLong - new GregorianCalendar(((GregorianCalendar)localObject).get(1), ((GregorianCalendar)localObject).get(2), ((GregorianCalendar)localObject).get(5)).getTimeInMillis();
    if ((l1 > 0L) && (l1 <= 86400000L)) {}
    for (int i = 1; i != 0; i = 0)
    {
      localObject = ah.getContext().getResources().getString(2131300075);
      AppMethodBeat.o(39612);
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
      localObject = ah.getContext().getResources().getString(2131300041);
      AppMethodBeat.o(39612);
      return localObject;
    }
    localObject = DateFormat.format(ah.getContext().getString(2131300113), paramLong);
    AppMethodBeat.o(39612);
    return localObject;
  }
  
  public static String x(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(39610);
    if (nEb.get(paramString2) == null) {
      aR(paramContext, paramString2);
    }
    int i = bo.getInt(paramString1, 0);
    paramString1 = (List)nEb.get(paramString2);
    if ((i >= paramString1.size()) || (paramString1.get(i) == null) || (((String)paramString1.get(i)).equals(""))) {
      aR(paramContext, paramString2);
    }
    paramContext = (List)nEb.get(paramString2);
    if (i < paramContext.size())
    {
      paramContext = (String)paramContext.get(i);
      AppMethodBeat.o(39610);
      return paramContext;
    }
    AppMethodBeat.o(39610);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ax
 * JD-Core Version:    0.7.0.1
 */