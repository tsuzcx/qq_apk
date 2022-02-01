package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;

public class TMLog
{
  protected static boolean mDebugFlagForSDK;
  protected static String mDebugFlagForSDKTag;
  protected static boolean mHardDebugFlag;
  protected static HashMap<String, ArrayList<Long>> mUseTimeLongList;
  protected static HashMap<String, ArrayList<String>> mUseTimeStringList;
  
  static
  {
    AppMethodBeat.i(102542);
    mHardDebugFlag = true;
    mUseTimeStringList = new HashMap();
    mUseTimeLongList = new HashMap();
    mDebugFlagForSDK = true;
    mDebugFlagForSDKTag = "";
    AppMethodBeat.o(102542);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102535);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ac.d(paramString1, str);
    }
    AppMethodBeat.o(102535);
  }
  
  public static void debugE(String paramString)
  {
    AppMethodBeat.i(102532);
    if ((mDebugFlagForSDK) && (!TextUtils.isEmpty(mDebugFlagForSDKTag))) {
      ac.e(mDebugFlagForSDKTag, paramString);
    }
    AppMethodBeat.o(102532);
  }
  
  public static void debugV(String paramString)
  {
    AppMethodBeat.i(102531);
    if ((mDebugFlagForSDK) && (!TextUtils.isEmpty(mDebugFlagForSDKTag))) {
      ac.v(mDebugFlagForSDKTag, paramString);
    }
    AppMethodBeat.o(102531);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102537);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ac.e(paramString1, str);
    }
    AppMethodBeat.o(102537);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102534);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ac.i(paramString1, str);
    }
    AppMethodBeat.o(102534);
  }
  
  public static boolean isForDebug()
  {
    return mHardDebugFlag;
  }
  
  public static void setDebugLog(boolean paramBoolean, String paramString)
  {
    mDebugFlagForSDK = paramBoolean;
    mDebugFlagForSDKTag = paramString;
  }
  
  public static void time(String paramString)
  {
    AppMethodBeat.i(102538);
    time("UseTime", paramString, false);
    AppMethodBeat.o(102538);
  }
  
  public static void time(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102540);
    time(paramString1, paramString2, false);
    AppMethodBeat.o(102540);
  }
  
  public static void time(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(102541);
    if (!isForDebug())
    {
      AppMethodBeat.o(102541);
      return;
    }
    ArrayList localArrayList = (ArrayList)mUseTimeStringList.get(paramString1);
    if (localArrayList == null)
    {
      localArrayList = new ArrayList();
      mUseTimeStringList.put(paramString1, localArrayList);
    }
    for (;;)
    {
      localArrayList.add(paramString2);
      paramString2 = (ArrayList)mUseTimeLongList.get(paramString1);
      if (paramString2 == null)
      {
        paramString2 = new ArrayList();
        mUseTimeLongList.put(paramString1, paramString2);
      }
      for (;;)
      {
        paramString2.add(Long.valueOf(System.currentTimeMillis()));
        if (paramBoolean)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          long l = ((Long)paramString2.get(0)).longValue();
          localStringBuffer.append("total time:");
          localStringBuffer.append(((Long)paramString2.get(paramString2.size() - 1)).longValue() - l);
          localStringBuffer.append(" ");
          while (i < localArrayList.size())
          {
            localStringBuffer.append(((Long)paramString2.get(i)).longValue() - l);
            l = ((Long)paramString2.get(i)).longValue();
            localStringBuffer.append(" ");
            localStringBuffer.append((String)localArrayList.get(i));
            localStringBuffer.append(" ");
            i += 1;
          }
          ac.v(paramString1, localStringBuffer.toString());
          localArrayList.clear();
          paramString2.clear();
        }
        AppMethodBeat.o(102541);
        return;
      }
    }
  }
  
  public static void time(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(102539);
    time("UseTime", paramString, paramBoolean);
    AppMethodBeat.o(102539);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102533);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ac.v(paramString1, str);
    }
    AppMethodBeat.o(102533);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102536);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ac.w(paramString1, str);
    }
    AppMethodBeat.o(102536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.TMLog
 * JD-Core Version:    0.7.0.1
 */