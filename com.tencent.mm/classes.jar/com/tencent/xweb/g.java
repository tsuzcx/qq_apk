package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkSharedPreferenceUtil;

public final class g
{
  private static final Object aieq;
  
  static
  {
    AppMethodBeat.i(156731);
    aieq = new Object();
    AppMethodBeat.o(156731);
  }
  
  public static void GO(String arg0)
  {
    AppMethodBeat.i(156728);
    if ((??? == null) || (???.isEmpty()))
    {
      Log.e("FileReaderCrashDetector", "onFinish param is empty");
      AppMethodBeat.o(156728);
      return;
    }
    String str = ???.toLowerCase();
    synchronized (aieq)
    {
      Object localObject2 = XWalkSharedPreferenceUtil.getSharedPreferencesForFileReaderRecord();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetector", "onFinish sp is null");
        AppMethodBeat.o(156728);
        return;
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetector", "onFinish editor is null");
        AppMethodBeat.o(156728);
        return;
      }
      ((SharedPreferences.Editor)localObject2).putLong(str + "_count", 0L);
      ((SharedPreferences.Editor)localObject2).putLong(str + "_time", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject2).commit();
      AppMethodBeat.o(156728);
      return;
    }
  }
  
  public static void aNZ(String arg0)
  {
    AppMethodBeat.i(156727);
    if ((??? == null) || (???.isEmpty()))
    {
      Log.e("FileReaderCrashDetector", "onStart param is empty");
      AppMethodBeat.o(156727);
      return;
    }
    String str = ???.toLowerCase();
    synchronized (aieq)
    {
      Object localObject2 = XWalkSharedPreferenceUtil.getSharedPreferencesForFileReaderRecord();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetector", "onStart sp is null");
        AppMethodBeat.o(156727);
        return;
      }
      long l = ((SharedPreferences)localObject2).getLong(str + "_count", 0L);
      localObject2 = ((SharedPreferences)localObject2).edit();
      if (localObject2 == null)
      {
        Log.e("FileReaderCrashDetector", "onStart editor is null");
        AppMethodBeat.o(156727);
        return;
      }
      ((SharedPreferences.Editor)localObject2).putLong(str + "_count", l + 1L);
      ((SharedPreferences.Editor)localObject2).putLong(str + "_time", System.currentTimeMillis());
      ((SharedPreferences.Editor)localObject2).commit();
      AppMethodBeat.o(156727);
      return;
    }
  }
  
  public static void aj(String[] paramArrayOfString)
  {
    AppMethodBeat.i(156730);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      AppMethodBeat.o(156730);
      return;
    }
    for (;;)
    {
      int i;
      synchronized (aieq)
      {
        Object localObject2 = XWalkSharedPreferenceUtil.getSharedPreferencesForFileReaderRecord();
        if (localObject2 == null)
        {
          Log.e("FileReaderCrashDetector", "resetCrashInfo sp is null");
          AppMethodBeat.o(156730);
          return;
        }
        localObject2 = ((SharedPreferences)localObject2).edit();
        if (localObject2 == null)
        {
          Log.e("FileReaderCrashDetector", "resetCrashInfo editor is null");
          AppMethodBeat.o(156730);
          return;
        }
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = paramArrayOfString[i];
          if ((str != null) && (!str.isEmpty()))
          {
            str = str.toLowerCase();
            ((SharedPreferences.Editor)localObject2).remove(str + "_count");
            ((SharedPreferences.Editor)localObject2).remove(str + "_time");
          }
        }
        else
        {
          ((SharedPreferences.Editor)localObject2).commit();
          AppMethodBeat.o(156730);
          return;
        }
      }
      i += 1;
    }
  }
  
  public static boolean bHq(String arg0)
  {
    AppMethodBeat.i(156729);
    if ((??? == null) || (???.isEmpty()))
    {
      Log.e("FileReaderCrashDetector", "isRecentCrashed fileExt is empty");
      AppMethodBeat.o(156729);
      return false;
    }
    String str = ???.toLowerCase();
    synchronized (aieq)
    {
      SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getSharedPreferencesForFileReaderRecord();
      if (localSharedPreferences == null)
      {
        Log.e("FileReaderCrashDetector", "isRecentCrashed sp is null");
        AppMethodBeat.o(156729);
        return false;
      }
      long l1 = localSharedPreferences.getLong(str + "_count", 0L);
      long l2 = localSharedPreferences.getLong(str + "_time", 0L);
      long l3 = System.currentTimeMillis();
      if ((l1 >= 3L) && (l3 - l2 < 86400000L))
      {
        AppMethodBeat.o(156729);
        return true;
      }
      AppMethodBeat.o(156729);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.g
 * JD-Core Version:    0.7.0.1
 */