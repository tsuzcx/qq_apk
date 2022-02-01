package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public class Util$ActivityTaskInfo
{
  private Context context;
  
  public Util$ActivityTaskInfo(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static String getTaskInfo(Context paramContext)
  {
    AppMethodBeat.i(157855);
    if (paramContext == null)
    {
      AppMethodBeat.o(157855);
      return null;
    }
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = paramContext.getPackageName();
    if ((localObject1 == null) || (Util.isNullOrNil(paramContext)))
    {
      AppMethodBeat.o(157855);
      return null;
    }
    try
    {
      Object localObject2 = ((ActivityManager)localObject1).getRunningTasks(100);
      localObject1 = new StringBuffer();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)((Iterator)localObject2).next();
        if ((localRunningTaskInfo.baseActivity.getClassName().startsWith(paramContext)) || (localRunningTaskInfo.topActivity.getClassName().startsWith(paramContext))) {
          ((StringBuffer)localObject1).append(String.format("{id:%d num:%d/%d top:%s base:%s}", new Object[] { Integer.valueOf(localRunningTaskInfo.id), Integer.valueOf(localRunningTaskInfo.numRunning), Integer.valueOf(localRunningTaskInfo.numActivities), localRunningTaskInfo.topActivity.getShortClassName(), localRunningTaskInfo.baseActivity.getShortClassName() }));
        }
      }
      paramContext = ((StringBuffer)localObject1).toString();
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MicroMsg.Util", paramContext, "", new Object[0]);
      AppMethodBeat.o(157855);
      return "";
    }
    AppMethodBeat.o(157855);
    return paramContext;
  }
  
  public String toString()
  {
    AppMethodBeat.i(157854);
    String str = getTaskInfo(this.context);
    AppMethodBeat.o(157854);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Util.ActivityTaskInfo
 * JD-Core Version:    0.7.0.1
 */