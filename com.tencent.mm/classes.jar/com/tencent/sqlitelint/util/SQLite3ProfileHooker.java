package com.tencent.sqlitelint.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class SQLite3ProfileHooker
{
  private static final String TAG = "SQLiteLint.SQLite3ProfileHooker";
  private static volatile boolean sIsTryHook;
  
  private static boolean doHook()
  {
    AppMethodBeat.i(52961);
    if (!hookOpenSQLite3Profile())
    {
      SLog.i("SQLiteLint.SQLite3ProfileHooker", "doHook hookOpenSQLite3Profile failed", new Object[0]);
      AppMethodBeat.o(52961);
      return false;
    }
    boolean bool = nativeDoHook();
    AppMethodBeat.o(52961);
    return bool;
  }
  
  private static boolean doUnHook()
  {
    AppMethodBeat.i(52962);
    unHookOpenSQLite3Profile();
    nativeStopProfile();
    AppMethodBeat.o(52962);
    return true;
  }
  
  public static void hook()
  {
    AppMethodBeat.i(52959);
    SLog.i("SQLiteLint.SQLite3ProfileHooker", "hook sIsTryHook: %b", new Object[] { Boolean.valueOf(sIsTryHook) });
    nativeStartProfile();
    if (!sIsTryHook)
    {
      SLog.i("SQLiteLint.SQLite3ProfileHooker", "hook hookRet: %b", new Object[] { Boolean.valueOf(doHook()) });
      sIsTryHook = true;
    }
    AppMethodBeat.o(52959);
  }
  
  private static boolean hookOpenSQLite3Profile()
  {
    AppMethodBeat.i(52963);
    try
    {
      Class localClass = Class.forName("android.database.sqlite.SQLiteDebug");
      Field localField = localClass.getDeclaredField("DEBUG_SQL_TIME");
      localField.setAccessible(true);
      localField.setBoolean(localClass, true);
      localField.setAccessible(false);
      AppMethodBeat.o(52963);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      SLog.e("SQLiteLint.SQLite3ProfileHooker", "prepareHookBeforeOpenDatabase: e=%s", new Object[] { localClassNotFoundException.getLocalizedMessage() });
      AppMethodBeat.o(52963);
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        SLog.e("SQLiteLint.SQLite3ProfileHooker", "prepareHookBeforeOpenDatabase: e=%s", new Object[] { localIllegalAccessException.getLocalizedMessage() });
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        SLog.e("SQLiteLint.SQLite3ProfileHooker", "prepareHookBeforeOpenDatabase: e=%s", new Object[] { localNoSuchFieldException.getLocalizedMessage() });
      }
    }
  }
  
  private static native boolean nativeDoHook();
  
  private static native void nativeStartProfile();
  
  private static native void nativeStopProfile();
  
  public static void unHook()
  {
    AppMethodBeat.i(52960);
    if (sIsTryHook)
    {
      SLog.i("SQLiteLint.SQLite3ProfileHooker", "unHook unHookRet: %b", new Object[] { Boolean.valueOf(doUnHook()) });
      sIsTryHook = false;
    }
    AppMethodBeat.o(52960);
  }
  
  private static boolean unHookOpenSQLite3Profile()
  {
    AppMethodBeat.i(52964);
    try
    {
      Class localClass = Class.forName("android.database.sqlite.SQLiteDebug");
      Field localField = localClass.getDeclaredField("DEBUG_SQL_TIME");
      localField.setAccessible(true);
      localField.setBoolean(localClass, false);
      localField.setAccessible(false);
      AppMethodBeat.o(52964);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      SLog.e("SQLiteLint.SQLite3ProfileHooker", "unHookOpenSQLite3Profile: e=%s", new Object[] { localClassNotFoundException.getLocalizedMessage() });
      AppMethodBeat.o(52964);
      return false;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        SLog.e("SQLiteLint.SQLite3ProfileHooker", "unHookOpenSQLite3Profile: e=%s", new Object[] { localIllegalAccessException.getLocalizedMessage() });
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        SLog.e("SQLiteLint.SQLite3ProfileHooker", "unHookOpenSQLite3Profile: e=%s", new Object[] { localNoSuchFieldException.getLocalizedMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.util.SQLite3ProfileHooker
 * JD-Core Version:    0.7.0.1
 */