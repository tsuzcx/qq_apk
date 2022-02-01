package org.xwalk.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XWalkInitializeLog
{
  public static final String TAG = "XWalkInitializeLog";
  private static int sPid;
  
  static
  {
    AppMethodBeat.i(187743);
    sPid = Process.myPid();
    AppMethodBeat.o(187743);
  }
  
  private static void addXWalkInitializeLog(String paramString)
  {
    AppMethodBeat.i(187729);
    String str = new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
    paramString = sPid + " | " + str + " | " + paramString;
    SharedPreferences localSharedPreferences = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForLog();
    str = localSharedPreferences.getString("log", "");
    try
    {
      str = paramString + "\n" + str;
      paramString = str;
      if (str.length() > 10240) {
        paramString = str.substring(0, 5120);
      }
      localSharedPreferences.edit().putString("log", paramString).apply();
      AppMethodBeat.o(187729);
      return;
    }
    finally
    {
      Log.e("XWalkInitializeLog", "addXWalkInitializeLog error:".concat(String.valueOf(paramString)));
      AppMethodBeat.o(187729);
    }
  }
  
  public static void addXWalkInitializeLog(String paramString1, String paramString2)
  {
    AppMethodBeat.i(187715);
    if ((paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(187715);
      return;
    }
    Log.i(paramString1, paramString2);
    if (!XWalkEnvironment.isTurnOnKVLog)
    {
      AppMethodBeat.o(187715);
      return;
    }
    addXWalkInitializeLog(" " + paramString1 + " | " + paramString2);
    AppMethodBeat.o(187715);
  }
  
  public static String getXWalkInitializeLog()
  {
    AppMethodBeat.i(187736);
    Object localObject = XWalkSharedPreferenceUtil.getMMKVSharedPreferencesForLog();
    if (localObject == null)
    {
      AppMethodBeat.o(187736);
      return "";
    }
    localObject = ((SharedPreferences)localObject).getString("log", "");
    AppMethodBeat.o(187736);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     org.xwalk.core.XWalkInitializeLog
 * JD-Core Version:    0.7.0.1
 */