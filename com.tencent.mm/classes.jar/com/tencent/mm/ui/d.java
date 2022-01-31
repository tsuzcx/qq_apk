package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public final class d
{
  private static a yUQ;
  private static HashMap<Integer, Long> yUR;
  private static int yUS;
  private static int yUT;
  private static long yUU;
  
  static
  {
    AppMethodBeat.i(105951);
    yUR = new HashMap();
    yUS = 1100;
    yUT = 2000;
    yUU = 0L;
    AppMethodBeat.o(105951);
  }
  
  public static void a(a parama)
  {
    yUQ = parama;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, Intent[] paramArrayOfIntent, Object... paramVarArgs)
  {
    for (;;)
    {
      long l;
      Object localObject;
      Long localLong2;
      try
      {
        AppMethodBeat.i(105948);
        int j = paramArrayOfIntent.length;
        int i = 0;
        if (i < j)
        {
          if (aN(paramArrayOfIntent[i]))
          {
            paramBoolean = false;
            AppMethodBeat.o(105948);
            return paramBoolean;
          }
          i += 1;
          continue;
        }
        l = System.currentTimeMillis();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramContext.toString()).append(",");
        j = paramArrayOfIntent.length;
        i = 0;
        if (i < j)
        {
          ((StringBuilder)localObject).append(paramArrayOfIntent[i]);
          ((StringBuilder)localObject).append(",");
          i += 1;
          continue;
        }
        j = paramVarArgs.length;
        i = 0;
        if (i < j)
        {
          ((StringBuilder)localObject).append(paramVarArgs[i]);
          ((StringBuilder)localObject).append(",");
          i += 1;
          continue;
        }
        paramVarArgs = ((StringBuilder)localObject).toString();
        localObject = Integer.valueOf(paramVarArgs.hashCode());
        Long localLong1 = (Long)yUR.get(localObject);
        localLong2 = Long.valueOf(System.currentTimeMillis());
        if ((!paramBoolean) || (localLong1 == null)) {
          break label370;
        }
        if (localLong2.longValue() - localLong1.longValue() <= yUT)
        {
          String str = atk(paramContext.getClass().toString());
          if (paramArrayOfIntent[0].getComponent() != null)
          {
            paramContext = atk(paramArrayOfIntent[0].getComponent().getClassName());
            yUQ.b(localLong2.longValue() - localLong1.longValue(), str, paramContext);
          }
        }
        else
        {
          if (localLong2.longValue() - localLong1.longValue() > yUS) {
            break label370;
          }
          yUR.put(localObject, localLong2);
          ab.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", new Object[] { Integer.valueOf(yUS), paramVarArgs, localLong1, localLong2 });
          paramBoolean = true;
          AppMethodBeat.o(105948);
          continue;
        }
        paramContext = "None";
      }
      finally {}
      continue;
      label370:
      if ((yUR.size() > 100) && (yUU != 0L) && (System.currentTimeMillis() - yUU > yUS)) {
        yUR.clear();
      }
      yUR.put(localObject, localLong2);
      yUU = System.currentTimeMillis();
      ab.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramBoolean = false;
      AppMethodBeat.o(105948);
    }
  }
  
  private static boolean aN(Intent paramIntent)
  {
    AppMethodBeat.i(105950);
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.getComponent() != null)
      {
        boolean bool = bo.isNullOrNil(paramIntent.getComponent().getClassName());
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(105950);
        return false;
      }
      if (Class.forName(paramIntent.getComponent().getClassName()).getAnnotation(b.class) != null)
      {
        AppMethodBeat.o(105950);
        return true;
      }
    }
    catch (Exception paramIntent)
    {
      ab.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", new Object[] { paramIntent });
      AppMethodBeat.o(105950);
      return false;
    }
    AppMethodBeat.o(105950);
    return false;
  }
  
  private static String atk(String paramString)
  {
    AppMethodBeat.i(105949);
    paramString = paramString.split("\\.");
    if (paramString.length > 0)
    {
      paramString = paramString[(paramString.length - 1)];
      AppMethodBeat.o(105949);
      return paramString;
    }
    AppMethodBeat.o(105949);
    return "";
  }
  
  public static int dAU()
  {
    return yUS;
  }
  
  public static abstract interface a
  {
    public abstract void b(long paramLong, String paramString1, String paramString2);
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.d
 * JD-Core Version:    0.7.0.1
 */