package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public final class d
{
  private static a FHG;
  private static HashMap<Integer, Long> FHH;
  private static int FHI;
  private static int FHJ;
  private static long FHK;
  
  static
  {
    AppMethodBeat.i(141281);
    FHH = new HashMap();
    FHI = 1100;
    FHJ = 2000;
    FHK = 0L;
    AppMethodBeat.o(141281);
  }
  
  public static void a(a parama)
  {
    FHG = parama;
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
        AppMethodBeat.i(141278);
        int j = paramArrayOfIntent.length;
        int i = 0;
        if (i < j)
        {
          if (bg(paramArrayOfIntent[i]))
          {
            paramBoolean = false;
            AppMethodBeat.o(141278);
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
        Long localLong1 = (Long)FHH.get(localObject);
        localLong2 = Long.valueOf(System.currentTimeMillis());
        if ((!paramBoolean) || (localLong1 == null)) {
          break label370;
        }
        if (localLong2.longValue() - localLong1.longValue() <= FHJ)
        {
          String str = aJW(paramContext.getClass().toString());
          if (paramArrayOfIntent[0].getComponent() != null)
          {
            paramContext = aJW(paramArrayOfIntent[0].getComponent().getClassName());
            FHG.b(localLong2.longValue() - localLong1.longValue(), str, paramContext);
          }
        }
        else
        {
          if (localLong2.longValue() - localLong1.longValue() > FHI) {
            break label370;
          }
          FHH.put(localObject, localLong2);
          ad.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", new Object[] { Integer.valueOf(FHI), paramVarArgs, localLong1, localLong2 });
          paramBoolean = true;
          AppMethodBeat.o(141278);
          continue;
        }
        paramContext = "None";
      }
      finally {}
      continue;
      label370:
      if ((FHH.size() > 100) && (FHK != 0L) && (System.currentTimeMillis() - FHK > FHI)) {
        FHH.clear();
      }
      FHH.put(localObject, localLong2);
      FHK = System.currentTimeMillis();
      ad.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramBoolean = false;
      AppMethodBeat.o(141278);
    }
  }
  
  private static String aJW(String paramString)
  {
    AppMethodBeat.i(141279);
    paramString = paramString.split("\\.");
    if (paramString.length > 0)
    {
      paramString = paramString[(paramString.length - 1)];
      AppMethodBeat.o(141279);
      return paramString;
    }
    AppMethodBeat.o(141279);
    return "";
  }
  
  private static boolean bg(Intent paramIntent)
  {
    AppMethodBeat.i(141280);
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.getComponent() != null)
      {
        boolean bool = bt.isNullOrNil(paramIntent.getComponent().getClassName());
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(141280);
        return false;
      }
      if (Class.forName(paramIntent.getComponent().getClassName()).getAnnotation(b.class) != null)
      {
        AppMethodBeat.o(141280);
        return true;
      }
    }
    catch (Exception paramIntent)
    {
      ad.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", new Object[] { paramIntent });
      AppMethodBeat.o(141280);
      return false;
    }
    AppMethodBeat.o(141280);
    return false;
  }
  
  public static int ePs()
  {
    return FHI;
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