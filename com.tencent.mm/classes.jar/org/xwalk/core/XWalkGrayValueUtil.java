package org.xwalk.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.l;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class XWalkGrayValueUtil
{
  private static final int SPECIAL_TEST_USER_ID = 10001;
  public static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
  private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
  private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
  private static final String SP_KEY_USER_ID = "USER_ID";
  public static final String TAG = "XWalkGrayValueUtil";
  public static int sNDeviceRd = 0;
  private static int s_grayValue = 0;
  private static String s_todayDate = "";
  private static int s_todayGrayValue = 0;
  
  public static int getDeviceRd()
  {
    AppMethodBeat.i(187590);
    if (sNDeviceRd <= 0)
    {
      i = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getInt("sNDeviceRd", -1);
      sNDeviceRd = i;
      if (i <= 0)
      {
        sNDeviceRd = new Random().nextInt(10000000) + 1;
        XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putInt("sNDeviceRd", sNDeviceRd).commit();
      }
    }
    int i = sNDeviceRd;
    AppMethodBeat.o(187590);
    return i % 10000 + 1;
  }
  
  public static int getGrayValue()
  {
    AppMethodBeat.i(187587);
    int i;
    if (s_grayValue != 0)
    {
      i = s_grayValue;
      AppMethodBeat.o(187587);
      return i;
    }
    try
    {
      i = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getInt("TEST_GRAY_VALUE", -1);
      s_grayValue = i;
      if (i > 0)
      {
        Log.i("XWalkGrayValueUtil", "getGrayValue, using test gray value:" + s_grayValue);
        i = s_grayValue;
        AppMethodBeat.o(187587);
        return i;
      }
      i = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getInt("GRAY_VALUE", -1);
      s_grayValue = i;
      if (i > 0)
      {
        Log.i("XWalkGrayValueUtil", "getGrayValue, using uin gray value:" + s_grayValue);
        i = s_grayValue;
        AppMethodBeat.o(187587);
        return i;
      }
      i = getDeviceRd();
      s_grayValue = i;
      if (i > 0)
      {
        Log.i("XWalkGrayValueUtil", "getGrayValue, using device gray value:" + s_grayValue);
        i = s_grayValue;
        AppMethodBeat.o(187587);
        return i;
      }
    }
    finally
    {
      Log.e("XWalkGrayValueUtil", "getGrayValue error:".concat(String.valueOf(localObject)));
      s_grayValue = 0;
      i = s_grayValue;
      AppMethodBeat.o(187587);
    }
    return i;
  }
  
  public static int getTodayGrayValue()
  {
    AppMethodBeat.i(187623);
    Object localObject1 = new SimpleDateFormat("yyyyMMdd").format(new Date());
    if ((s_todayGrayValue != 0) && (((String)localObject1).equals(s_todayDate)))
    {
      i = s_todayGrayValue;
      AppMethodBeat.o(187623);
      return i;
    }
    s_todayDate = (String)localObject1;
    i = getUserId();
    if (i != 0) {}
    for (;;)
    {
      long l = i;
      localObject1 = (0xFFFFFFFF & l) + "@" + (String)localObject1;
      try
      {
        localObject1 = MessageDigest.getInstance("MD5").digest(((String)localObject1).getBytes());
        if ((localObject1 == null) || (localObject1.length <= 3))
        {
          s_todayGrayValue = i;
          AppMethodBeat.o(187623);
          return i;
          i = getGrayValue();
        }
        else
        {
          int j = localObject1[3];
          int k = localObject1[2];
          int m = localObject1[1];
          j = (localObject1[0] & 0x7F) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
          if (j == 0)
          {
            s_todayGrayValue = i;
            AppMethodBeat.o(187623);
            return i;
          }
          s_todayGrayValue = j % 10000 + 1;
        }
      }
      finally
      {
        for (;;)
        {
          Log.e("XWalkGrayValueUtil", "getTodayGrayValue error:".concat(String.valueOf(localObject2)));
          s_todayGrayValue = i;
        }
      }
    }
    i = s_todayGrayValue;
    AppMethodBeat.o(187623);
    return i;
  }
  
  public static int getTodayGrayValueByKey(String paramString)
  {
    AppMethodBeat.i(187629);
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date());
    int i = getUserId();
    if (i != 0) {}
    for (;;)
    {
      long l = i;
      paramString = (0xFFFFFFFF & l) + "@" + str + "key=" + paramString;
      try
      {
        paramString = MessageDigest.getInstance("MD5").digest(paramString.getBytes());
        if ((paramString == null) || (paramString.length <= 3))
        {
          i = s_todayGrayValue;
          AppMethodBeat.o(187629);
          return i;
          i = getGrayValue();
        }
        else
        {
          i = paramString[3];
          int j = paramString[2];
          int k = paramString[1];
          i = (paramString[0] & 0x7F) << 24 | i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16;
          if (i == 0)
          {
            i = s_todayGrayValue;
            AppMethodBeat.o(187629);
            return i;
          }
          AppMethodBeat.o(187629);
          return i % 10000 + 1;
        }
      }
      finally
      {
        Log.e("XWalkGrayValueUtil", "getTodayGrayValueByKey error:".concat(String.valueOf(paramString)));
        i = s_todayGrayValue;
        AppMethodBeat.o(187629);
      }
    }
    return i;
  }
  
  public static int getUserId()
  {
    AppMethodBeat.i(187596);
    int i = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForXWebUserInfo().getInt("USER_ID", 0);
    AppMethodBeat.o(187596);
    return i;
  }
  
  public static boolean hasUin()
  {
    AppMethodBeat.i(187594);
    if (getUserId() != 0)
    {
      AppMethodBeat.o(187594);
      return true;
    }
    AppMethodBeat.o(187594);
    return false;
  }
  
  public static void resetGrayValue()
  {
    AppMethodBeat.i(187583);
    s_grayValue = 0;
    s_grayValue = getGrayValue();
    Log.i("XWalkGrayValueUtil", "resetGrayValue, gray value:" + s_grayValue);
    AppMethodBeat.o(187583);
  }
  
  @Deprecated
  public static boolean setGrayValueByUserId(int paramInt)
  {
    AppMethodBeat.i(187609);
    if (paramInt == 0)
    {
      AppMethodBeat.o(187609);
      return false;
    }
    setUserId(paramInt);
    Object localObject1 = "xweb_gray_value".concat(String.valueOf(0xFFFFFFFF & paramInt));
    try
    {
      localObject1 = MessageDigest.getInstance("MD5").digest(((String)localObject1).getBytes());
      if (localObject1 != null)
      {
        paramInt = localObject1.length;
        if (paramInt > 3) {}
      }
      else
      {
        AppMethodBeat.o(187609);
        return false;
      }
      paramInt = localObject1[3];
      int i = localObject1[2];
      int j = localObject1[1];
      paramInt = (localObject1[0] & 0x7F) << 24 | paramInt & 0xFF | (i & 0xFF) << 8 | (j & 0xFF) << 16;
      if (paramInt == 0)
      {
        AppMethodBeat.o(187609);
        return false;
      }
      s_grayValue = paramInt % 10000 + 1;
    }
    finally
    {
      for (;;)
      {
        s_grayValue = 0;
        Log.w("XWalkGrayValueUtil", "setGrayValueByUserId, gray value reset to 0, error:".concat(String.valueOf(localObject2)));
      }
      AppMethodBeat.o(187609);
    }
    paramInt = XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().getInt("GRAY_VALUE", -1);
    XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putInt("GRAY_VALUE", s_grayValue).commit();
    if (paramInt != s_grayValue)
    {
      Log.i("XWalkGrayValueUtil", "setGrayValueByUserId, gray value changed from " + paramInt + " to " + s_grayValue);
      l.y(1749L, 29L, 1L);
      AppMethodBeat.o(187609);
      return true;
    }
    return false;
  }
  
  @Deprecated
  public static void setGrayValueForTest(int paramInt)
  {
    AppMethodBeat.i(187580);
    if (paramInt != 10001) {
      s_grayValue = paramInt % 10000;
    }
    Log.i("XWalkGrayValueUtil", "setGrayValueForTest, gray value:" + s_grayValue);
    XWalkSharedPreferenceUtil.getSharedPreferencesForXWalkCore().edit().putInt("TEST_GRAY_VALUE", s_grayValue).commit();
    AppMethodBeat.o(187580);
  }
  
  public static void setTodayGrayValueForTest(int paramInt)
  {
    AppMethodBeat.i(187612);
    s_todayGrayValue = paramInt;
    s_todayDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
    AppMethodBeat.o(187612);
  }
  
  private static void setUserId(int paramInt)
  {
    AppMethodBeat.i(187601);
    XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForXWebUserInfo().edit().putInt("USER_ID", paramInt).commit();
    AppMethodBeat.o(187601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     org.xwalk.core.XWalkGrayValueUtil
 * JD-Core Version:    0.7.0.1
 */