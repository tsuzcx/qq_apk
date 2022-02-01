package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class e
{
  private static a VRJ;
  private static HashMap<Integer, Long> VRK;
  private static int VRL;
  private static int VRM;
  private static long VRN;
  
  static
  {
    AppMethodBeat.i(141281);
    VRK = new HashMap();
    VRL = 1100;
    VRM = 2000;
    VRN = 0L;
    AppMethodBeat.o(141281);
  }
  
  public static void a(a parama)
  {
    VRJ = parama;
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
          if (bx(paramArrayOfIntent[i]))
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
        Long localLong1 = (Long)VRK.get(localObject);
        localLong2 = Long.valueOf(System.currentTimeMillis());
        if ((!paramBoolean) || (localLong1 == null)) {
          break label370;
        }
        if (localLong2.longValue() - localLong1.longValue() <= VRM)
        {
          String str = byk(paramContext.getClass().toString());
          if (paramArrayOfIntent[0].getComponent() != null)
          {
            paramContext = byk(paramArrayOfIntent[0].getComponent().getClassName());
            VRJ.d(localLong2.longValue() - localLong1.longValue(), str, paramContext);
          }
        }
        else
        {
          if (localLong2.longValue() - localLong1.longValue() > VRL) {
            break label370;
          }
          VRK.put(localObject, localLong2);
          Log.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", new Object[] { Integer.valueOf(VRL), paramVarArgs, localLong1, localLong2 });
          paramBoolean = true;
          AppMethodBeat.o(141278);
          continue;
        }
        paramContext = "None";
      }
      finally {}
      continue;
      label370:
      if ((VRK.size() > 100) && (VRN != 0L) && (System.currentTimeMillis() - VRN > VRL)) {
        VRK.clear();
      }
      VRK.put(localObject, localLong2);
      VRN = System.currentTimeMillis();
      Log.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      paramBoolean = false;
      AppMethodBeat.o(141278);
    }
  }
  
  private static boolean bx(Intent paramIntent)
  {
    AppMethodBeat.i(141280);
    if (paramIntent != null) {}
    try
    {
      if (paramIntent.getComponent() != null)
      {
        boolean bool = Util.isNullOrNil(paramIntent.getComponent().getClassName());
        if (!bool) {}
      }
      else
      {
        AppMethodBeat.o(141280);
        return false;
      }
      if (Class.forName(paramIntent.getComponent().getClassName()).getAnnotation(e.b.class) != null)
      {
        AppMethodBeat.o(141280);
        return true;
      }
    }
    catch (Exception paramIntent)
    {
      Log.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", new Object[] { paramIntent });
      AppMethodBeat.o(141280);
      return false;
    }
    AppMethodBeat.o(141280);
    return false;
  }
  
  private static String byk(String paramString)
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
  
  public static int hFA()
  {
    return VRL;
  }
  
  public static abstract interface a
  {
    public abstract void d(long paramLong, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.e
 * JD-Core Version:    0.7.0.1
 */