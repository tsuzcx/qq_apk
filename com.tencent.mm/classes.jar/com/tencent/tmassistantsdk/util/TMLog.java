package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(76299);
    mHardDebugFlag = true;
    mUseTimeStringList = new HashMap();
    mUseTimeLongList = new HashMap();
    mDebugFlagForSDK = true;
    mDebugFlagForSDKTag = "";
    AppMethodBeat.o(76299);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76292);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ab.d(paramString1, str);
    }
    AppMethodBeat.o(76292);
  }
  
  public static void debugE(String paramString)
  {
    AppMethodBeat.i(76289);
    if ((mDebugFlagForSDK) && (!TextUtils.isEmpty(mDebugFlagForSDKTag))) {
      ab.e(mDebugFlagForSDKTag, paramString);
    }
    AppMethodBeat.o(76289);
  }
  
  public static void debugV(String paramString)
  {
    AppMethodBeat.i(76288);
    if ((mDebugFlagForSDK) && (!TextUtils.isEmpty(mDebugFlagForSDKTag))) {
      ab.v(mDebugFlagForSDKTag, paramString);
    }
    AppMethodBeat.o(76288);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76294);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ab.e(paramString1, str);
    }
    AppMethodBeat.o(76294);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76291);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ab.i(paramString1, str);
    }
    AppMethodBeat.o(76291);
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
    AppMethodBeat.i(76295);
    time("UseTime", paramString, false);
    AppMethodBeat.o(76295);
  }
  
  public static void time(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76297);
    time(paramString1, paramString2, false);
    AppMethodBeat.o(76297);
  }
  
  public static void time(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(76298);
    if (!isForDebug())
    {
      AppMethodBeat.o(76298);
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
          ab.v(paramString1, localStringBuffer.toString());
          localArrayList.clear();
          paramString2.clear();
        }
        AppMethodBeat.o(76298);
        return;
      }
    }
  }
  
  public static void time(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(76296);
    time("UseTime", paramString, paramBoolean);
    AppMethodBeat.o(76296);
  }
  
  public static void v(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76290);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ab.v(paramString1, str);
    }
    AppMethodBeat.o(76290);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76293);
    if (isForDebug())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "............";
      }
      ab.w(paramString1, str);
    }
    AppMethodBeat.o(76293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.util.TMLog
 * JD-Core Version:    0.7.0.1
 */