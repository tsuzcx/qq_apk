package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public final class d
{
  private static a uHF;
  private static HashMap<Integer, Long> uHG = new HashMap();
  private static int uHH = 1100;
  private static int uHI = 2000;
  private static long uHJ = 0L;
  
  public static void a(a parama)
  {
    uHF = parama;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, Intent[] paramArrayOfIntent, Object... paramVarArgs)
  {
    label438:
    for (;;)
    {
      try
      {
        int j = paramArrayOfIntent.length;
        int i = 0;
        if (i < j)
        {
          boolean bool = am(paramArrayOfIntent[i]);
          if (bool)
          {
            paramBoolean = false;
            return paramBoolean;
          }
          i += 1;
        }
        else
        {
          long l = System.currentTimeMillis();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.toString()).append(",");
          j = paramArrayOfIntent.length;
          i = 0;
          if (i < j)
          {
            ((StringBuilder)localObject).append(paramArrayOfIntent[i]);
            ((StringBuilder)localObject).append(",");
            i += 1;
          }
          else
          {
            j = paramVarArgs.length;
            i = 0;
            if (i < j)
            {
              ((StringBuilder)localObject).append(paramVarArgs[i]);
              ((StringBuilder)localObject).append(",");
              i += 1;
            }
            else
            {
              paramVarArgs = ((StringBuilder)localObject).toString();
              localObject = Integer.valueOf(paramVarArgs.hashCode());
              Long localLong1 = (Long)uHG.get(localObject);
              Long localLong2 = Long.valueOf(System.currentTimeMillis());
              if ((paramBoolean) && (localLong1 != null))
              {
                if (localLong2.longValue() - localLong1.longValue() <= uHI)
                {
                  String str = acU(paramContext.getClass().toString());
                  if (paramArrayOfIntent[0].getComponent() == null) {
                    break label438;
                  }
                  paramContext = acU(paramArrayOfIntent[0].getComponent().getClassName());
                  uHF.a(localLong2.longValue() - localLong1.longValue(), str, paramContext);
                }
                if (localLong2.longValue() - localLong1.longValue() <= uHH)
                {
                  uHG.put(localObject, localLong2);
                  y.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", new Object[] { Integer.valueOf(uHH), paramVarArgs, localLong1, localLong2 });
                  paramBoolean = true;
                  continue;
                }
              }
              if ((uHG.size() > 100) && (uHJ != 0L) && (System.currentTimeMillis() - uHJ > uHH)) {
                uHG.clear();
              }
              uHG.put(localObject, localLong2);
              uHJ = System.currentTimeMillis();
              y.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              paramBoolean = false;
              continue;
              paramContext = "None";
            }
          }
        }
      }
      finally {}
    }
  }
  
  private static String acU(String paramString)
  {
    paramString = paramString.split("\\.");
    if (paramString.length > 0) {
      return paramString[(paramString.length - 1)];
    }
    return "";
  }
  
  private static boolean am(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent != null) {
      try
      {
        if ((paramIntent.getComponent() != null) && (!bk.bl(paramIntent.getComponent().getClassName())))
        {
          paramIntent = Class.forName(paramIntent.getComponent().getClassName()).getAnnotation(b.class);
          if (paramIntent != null) {
            return bool;
          }
          return false;
        }
      }
      catch (Exception paramIntent)
      {
        y.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", new Object[] { paramIntent });
        return false;
      }
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static int cxX()
  {
    return uHH;
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong, String paramString1, String paramString2);
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.d
 * JD-Core Version:    0.7.0.1
 */