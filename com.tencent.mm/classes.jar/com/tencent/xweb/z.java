package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class z
{
  private static final Object BEw;
  
  static
  {
    AppMethodBeat.i(3956);
    BEw = new Object();
    AppMethodBeat.o(3956);
  }
  
  public static void ab(String[] paramArrayOfString)
  {
    AppMethodBeat.i(3955);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(3955);
      return;
    }
    synchronized (BEw)
    {
      Object localObject2 = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetect", "resetCrashInfo sp is null");
        AppMethodBeat.o(3955);
        return;
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetect", "resetCrashInfo editor is null");
        AppMethodBeat.o(3955);
        return;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i].toLowerCase();
        ((SharedPreferences.Editor)localObject2).remove(str + "_count");
        ((SharedPreferences.Editor)localObject2).remove(str + "_time");
        ((SharedPreferences.Editor)localObject2).commit();
        i += 1;
      }
      AppMethodBeat.o(3955);
      return;
    }
  }
  
  public static boolean axZ(String arg0)
  {
    AppMethodBeat.i(151436);
    if ((??? == null) || (???.isEmpty()))
    {
      Log.e("FileReaderCrashDetect", "isRecentCrashed fileExt is empty");
      AppMethodBeat.o(151436);
      return false;
    }
    String str = ???.toLowerCase();
    synchronized (BEw)
    {
      SharedPreferences localSharedPreferences = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
      if (localSharedPreferences == null)
      {
        Log.e("FileReaderCrashDetect", "isRecentCrashed sp is null");
        AppMethodBeat.o(151436);
        return false;
      }
      long l1 = localSharedPreferences.getLong(str + "_count", 0L);
      long l2 = localSharedPreferences.getLong(str + "_time", 0L);
      long l3 = System.currentTimeMillis();
      if ((l1 >= 3L) && (l3 - l2 < 86400000L))
      {
        AppMethodBeat.o(151436);
        return true;
      }
      AppMethodBeat.o(151436);
      return false;
    }
  }
  
  public static void mP(String arg0)
  {
    AppMethodBeat.i(151435);
    if ((??? == null) || (???.isEmpty()))
    {
      Log.e("FileReaderCrashDetect", "onFinish param is empty");
      AppMethodBeat.o(151435);
      return;
    }
    String str = ???.toLowerCase();
    synchronized (BEw)
    {
      Object localObject2 = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetect", "onFinish sp is null");
        AppMethodBeat.o(151435);
        return;
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetect", "onFinish editor is null");
        AppMethodBeat.o(151435);
        return;
      }
      ((SharedPreferences.Editor)localObject2).putLong(str + "_count", 0L);
      ((SharedPreferences.Editor)localObject2).putLong(str + "_time", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject2).commit();
      AppMethodBeat.o(151435);
      return;
    }
  }
  
  public static void onStart(String arg0)
  {
    AppMethodBeat.i(151434);
    if ((??? == null) || (???.isEmpty()))
    {
      Log.e("FileReaderCrashDetect", "onStart param is empty");
      AppMethodBeat.o(151434);
      return;
    }
    String str = ???.toLowerCase();
    synchronized (BEw)
    {
      Object localObject2 = XWalkEnvironment.getSharedPreferencesForFileReaderRecord();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetect", "onStart sp is null");
        AppMethodBeat.o(151434);
        return;
      }
      long l = ((SharedPreferences)localObject2).getLong(str + "_count", 0L);
      localObject2 = ((SharedPreferences)localObject2).edit();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetect", "onStart editor is null");
        AppMethodBeat.o(151434);
        return;
      }
      ((SharedPreferences.Editor)localObject2).putLong(str + "_count", l + 1L);
      ((SharedPreferences.Editor)localObject2).putLong(str + "_time", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject2).commit();
      AppMethodBeat.o(151434);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.z
 * JD-Core Version:    0.7.0.1
 */