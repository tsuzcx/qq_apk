package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public final class d
{
  private static a JoM;
  private static HashMap<Integer, Long> JoN;
  private static int JoO;
  private static int JoP;
  private static long JoQ;
  
  static
  {
    AppMethodBeat.i(141281);
    JoN = new HashMap();
    JoO = 1100;
    JoP = 2000;
    JoQ = 0L;
    AppMethodBeat.o(141281);
  }
  
  public static void a(a parama)
  {
    JoM = parama;
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
          if (bn(paramArrayOfIntent[i]))
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
        Long localLong1 = (Long)JoN.get(localObject);
        localLong2 = Long.valueOf(System.currentTimeMillis());
        if ((!paramBoolean) || (localLong1 == null)) {
          break label370;
        }
        if (localLong2.longValue() - localLong1.longValue() <= JoP)
        {
          String str = aWM(paramContext.getClass().toString());
          if (paramArrayOfIntent[0].getComponent() != null)
          {
            paramContext = aWM(paramArrayOfIntent[0].getComponent().getClassName());
            JoM.c(localLong2.longValue() - localLong1.longValue(), str, paramContext);
          }
        }
        else
        {
          if (localLong2.longValue() - localLong1.longValue() > JoO) {
            break label370;
          }
          JoN.put(localObject, localLong2);
          ae.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", new Object[] { Integer.valueOf(JoO), paramVarArgs, localLong1, localLong2 });
          paramBoolean = true;
          AppMethodBeat.o(141278);
          continue;
        }
        paramContext = "None";
      }
      finally {}
      continue;
      label370:
      if ((JoN.size() > 100) && (JoQ != 0L) && (System.currentTimeMillis() - JoQ > JoO)) {
        JoN.clear();
      }
      JoN.put(localObject, localLong2);
      JoQ = System.currentTimeMillis();
      ae.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramBoolean = false;
      AppMethodBeat.o(141278);
    }
  }
  
  private static String aWM(String paramString)
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
  
  private static boolean bn(Intent paramIntent)
  {
    AppMethodBeat.i(141280);
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.getComponent() != null)
      {
        boolean bool = bu.isNullOrNil(paramIntent.getComponent().getClassName());
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
      ae.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", new Object[] { paramIntent });
      AppMethodBeat.o(141280);
      return false;
    }
    AppMethodBeat.o(141280);
    return false;
  }
  
  public static int fzf()
  {
    return JoO;
  }
  
  public static abstract interface a
  {
    public abstract void c(long paramLong, String paramString1, String paramString2);
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.d
 * JD-Core Version:    0.7.0.1
 */