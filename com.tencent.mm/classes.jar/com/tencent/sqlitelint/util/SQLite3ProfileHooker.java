package com.tencent.sqlitelint.util;

import java.lang.reflect.Field;

public final class SQLite3ProfileHooker
{
  private static volatile boolean wRM;
  
  public static void cPU()
  {
    SLog.i("SQLiteLint.SQLite3ProfileHooker", "hook sIsTryHook: %b", new Object[] { Boolean.valueOf(wRM) });
    nativeStartProfile();
    if (!wRM)
    {
      if (cPW()) {
        break label71;
      }
      SLog.i("SQLiteLint.SQLite3ProfileHooker", "doHook hookOpenSQLite3Profile failed", new Object[0]);
    }
    label71:
    for (boolean bool = false;; bool = nativeDoHook())
    {
      SLog.i("SQLiteLint.SQLite3ProfileHooker", "hook hookRet: %b", new Object[] { Boolean.valueOf(bool) });
      wRM = true;
      return;
    }
  }
  
  public static void cPV()
  {
    if (wRM)
    {
      cPX();
      nativeStopProfile();
      SLog.i("SQLiteLint.SQLite3ProfileHooker", "unHook unHookRet: %b", new Object[] { Boolean.valueOf(true) });
      wRM = false;
    }
  }
  
  private static boolean cPW()
  {
    try
    {
      Class localClass = Class.forName("android.database.sqlite.SQLiteDebug");
      Field localField = localClass.getDeclaredField("DEBUG_SQL_TIME");
      localField.setAccessible(true);
      localField.setBoolean(localClass, true);
      localField.setAccessible(false);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      SLog.e("SQLiteLint.SQLite3ProfileHooker", "prepareHookBeforeOpenDatabase: e=%s", new Object[] { localClassNotFoundException.getLocalizedMessage() });
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
  
  private static boolean cPX()
  {
    try
    {
      Class localClass = Class.forName("android.database.sqlite.SQLiteDebug");
      Field localField = localClass.getDeclaredField("DEBUG_SQL_TIME");
      localField.setAccessible(true);
      localField.setBoolean(localClass, false);
      localField.setAccessible(false);
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      SLog.e("SQLiteLint.SQLite3ProfileHooker", "unHookOpenSQLite3Profile: e=%s", new Object[] { localClassNotFoundException.getLocalizedMessage() });
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
  
  private static native boolean nativeDoHook();
  
  private static native void nativeStartProfile();
  
  private static native void nativeStopProfile();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.util.SQLite3ProfileHooker
 * JD-Core Version:    0.7.0.1
 */