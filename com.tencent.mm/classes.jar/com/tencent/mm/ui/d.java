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
  private static a IUe;
  private static HashMap<Integer, Long> IUf;
  private static int IUg;
  private static int IUh;
  private static long IUi;
  
  static
  {
    AppMethodBeat.i(141281);
    IUf = new HashMap();
    IUg = 1100;
    IUh = 2000;
    IUi = 0L;
    AppMethodBeat.o(141281);
  }
  
  public static void a(a parama)
  {
    IUe = parama;
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
          if (bm(paramArrayOfIntent[i]))
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
        Long localLong1 = (Long)IUf.get(localObject);
        localLong2 = Long.valueOf(System.currentTimeMillis());
        if ((!paramBoolean) || (localLong1 == null)) {
          break label370;
        }
        if (localLong2.longValue() - localLong1.longValue() <= IUh)
        {
          String str = aVl(paramContext.getClass().toString());
          if (paramArrayOfIntent[0].getComponent() != null)
          {
            paramContext = aVl(paramArrayOfIntent[0].getComponent().getClassName());
            IUe.c(localLong2.longValue() - localLong1.longValue(), str, paramContext);
          }
        }
        else
        {
          if (localLong2.longValue() - localLong1.longValue() > IUg) {
            break label370;
          }
          IUf.put(localObject, localLong2);
          ad.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", new Object[] { Integer.valueOf(IUg), paramVarArgs, localLong1, localLong2 });
          paramBoolean = true;
          AppMethodBeat.o(141278);
          continue;
        }
        paramContext = "None";
      }
      finally {}
      continue;
      label370:
      if ((IUf.size() > 100) && (IUi != 0L) && (System.currentTimeMillis() - IUi > IUg)) {
        IUf.clear();
      }
      IUf.put(localObject, localLong2);
      IUi = System.currentTimeMillis();
      ad.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramBoolean = false;
      AppMethodBeat.o(141278);
    }
  }
  
  private static String aVl(String paramString)
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
  
  private static boolean bm(Intent paramIntent)
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
  
  public static int fve()
  {
    return IUg;
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