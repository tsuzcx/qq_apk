package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b
{
  private static final Map<Class<?>, Object> dlc = new HashMap();
  private static final Map<Class<?>, Object> dld = new HashMap();
  private static final Map<Class<?>, String> ujJ = new HashMap();
  
  static
  {
    try
    {
      dlc.put([B.class, new Object() {});
      dlc.put(Short.TYPE, new Object() {});
      dlc.put(Short.class, new Object() {});
      dlc.put(Boolean.TYPE, new Object() {});
      dlc.put(Boolean.class, new Object() {});
      dlc.put(Integer.TYPE, new Object() {});
      dlc.put(Integer.class, new Object() {});
      dlc.put(Float.TYPE, new Object() {});
      dlc.put(Float.class, new Object() {});
      dlc.put(Double.TYPE, new Object() {});
      dlc.put(Double.class, new Object() {});
      dlc.put(Long.TYPE, new Object() {});
      dlc.put(Long.class, new Object() {});
      dlc.put(String.class, new Object() {});
      dld.put([B.class, new Object() {});
      dld.put(Short.TYPE, new Object() {});
      dld.put(Short.class, new Object() {});
      dld.put(Boolean.TYPE, new Object() {});
      dld.put(Boolean.class, new Object() {});
      dld.put(Integer.TYPE, new Object() {});
      dld.put(Integer.class, new Object() {});
      dld.put(Float.TYPE, new Object() {});
      dld.put(Float.class, new Object() {});
      dld.put(Double.TYPE, new Object() {});
      dld.put(Double.class, new Object() {});
      dld.put(Long.TYPE, new Object() {});
      dld.put(Long.class, new Object() {});
      dld.put(String.class, new Object() {});
      ujJ.put([B.class, "BLOB");
      ujJ.put(Short.TYPE, "SHORT");
      ujJ.put(Short.class, "SHORT");
      ujJ.put(Boolean.TYPE, "INTEGER");
      ujJ.put(Boolean.class, "INTEGER");
      ujJ.put(Integer.TYPE, "INTEGER");
      ujJ.put(Integer.class, "INTEGER");
      ujJ.put(Float.TYPE, "FLOAT");
      ujJ.put(Float.class, "FLOAT");
      ujJ.put(Double.TYPE, "DOUBLE");
      ujJ.put(Double.class, "DOUBLE");
      ujJ.put(Long.TYPE, "LONG");
      ujJ.put(Long.class, "LONG");
      ujJ.put(String.class, "TEXT");
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", localException, "", new Object[0]);
    }
  }
  
  public static String U(Class<?> paramClass)
  {
    return (String)ujJ.get(paramClass);
  }
  
  public static void keep_getBlob(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(c.a(paramField), (byte[])paramField.get(paramObject));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_getBoolean(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      String str = c.a(paramField);
      if (paramField.getBoolean(paramObject)) {}
      for (int i = 1;; i = 0)
      {
        paramContentValues.put(str, Integer.valueOf(i));
        return;
      }
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_getDouble(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Double.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Double)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(c.a(paramField), Double.valueOf(paramField.getDouble(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_getFloat(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Float.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Float)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(c.a(paramField), Float.valueOf(paramField.getFloat(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_getInt(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Integer.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Integer)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(c.a(paramField), Integer.valueOf(paramField.getInt(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_getLong(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      if (!paramField.getType().equals(Long.TYPE))
      {
        paramContentValues.put(c.a(paramField), (Long)paramField.get(paramObject));
        return;
      }
      paramContentValues.put(c.a(paramField), Long.valueOf(paramField.getLong(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_getShort(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(c.a(paramField), Short.valueOf(paramField.getShort(paramObject)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_getString(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    try
    {
      paramContentValues.put(c.a(paramField), (String)paramField.get(paramObject));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_setBlob(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      paramField.set(paramObject, paramCursor.getBlob(paramInt));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_setBoolean(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (paramField.getType().equals(Boolean.TYPE))
        {
          if (paramCursor.getInt(paramInt) != 0)
          {
            bool = true;
            paramField.setBoolean(paramObject, bool);
          }
        }
        else
        {
          paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
          return;
        }
      }
      catch (Exception paramField)
      {
        y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void keep_setDouble(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Double.TYPE))
      {
        paramField.setDouble(paramObject, paramCursor.getDouble(paramInt));
        return;
      }
      paramField.set(paramObject, Double.valueOf(paramCursor.getDouble(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_setFloat(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Float.TYPE))
      {
        paramField.setFloat(paramObject, paramCursor.getFloat(paramInt));
        return;
      }
      paramField.set(paramObject, Float.valueOf(paramCursor.getFloat(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_setInt(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Integer.TYPE))
      {
        paramField.setInt(paramObject, paramCursor.getInt(paramInt));
        return;
      }
      paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_setLong(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Long.TYPE))
      {
        paramField.setLong(paramObject, paramCursor.getLong(paramInt));
        return;
      }
      paramField.set(paramObject, Long.valueOf(paramCursor.getLong(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_setShort(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      if (paramField.getType().equals(Short.TYPE))
      {
        paramField.setShort(paramObject, paramCursor.getShort(paramInt));
        return;
      }
      paramField.set(paramObject, Short.valueOf(paramCursor.getShort(paramInt)));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
  
  public static void keep_setString(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    try
    {
      paramField.set(paramObject, paramCursor.getString(paramInt));
      return;
    }
    catch (Exception paramField)
    {
      y.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */