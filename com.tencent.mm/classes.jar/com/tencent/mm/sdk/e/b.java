package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b
{
  private static final Map<Class<?>, String> IBK;
  private static final Map<Class<?>, Object> fKt;
  private static final Map<Class<?>, Object> fKu;
  
  static
  {
    AppMethodBeat.i(158081);
    fKt = new HashMap();
    fKu = new HashMap();
    IBK = new HashMap();
    try
    {
      fKt.put([B.class, new Object() {});
      fKt.put(Short.TYPE, new Object() {});
      fKt.put(Short.class, new Object() {});
      fKt.put(Boolean.TYPE, new Object() {});
      fKt.put(Boolean.class, new Object() {});
      fKt.put(Integer.TYPE, new Object() {});
      fKt.put(Integer.class, new Object() {});
      fKt.put(Float.TYPE, new Object() {});
      fKt.put(Float.class, new Object() {});
      fKt.put(Double.TYPE, new Object() {});
      fKt.put(Double.class, new Object() {});
      fKt.put(Long.TYPE, new Object() {});
      fKt.put(Long.class, new Object() {});
      fKt.put(String.class, new Object() {});
      fKu.put([B.class, new Object() {});
      fKu.put(Short.TYPE, new Object() {});
      fKu.put(Short.class, new Object() {});
      fKu.put(Boolean.TYPE, new Object() {});
      fKu.put(Boolean.class, new Object() {});
      fKu.put(Integer.TYPE, new Object() {});
      fKu.put(Integer.class, new Object() {});
      fKu.put(Float.TYPE, new Object() {});
      fKu.put(Float.class, new Object() {});
      fKu.put(Double.TYPE, new Object() {});
      fKu.put(Double.class, new Object() {});
      fKu.put(Long.TYPE, new Object() {});
      fKu.put(Long.class, new Object() {});
      fKu.put(String.class, new Object() {});
      IBK.put([B.class, "BLOB");
      IBK.put(Short.TYPE, "SHORT");
      IBK.put(Short.class, "SHORT");
      IBK.put(Boolean.TYPE, "INTEGER");
      IBK.put(Boolean.class, "INTEGER");
      IBK.put(Integer.TYPE, "INTEGER");
      IBK.put(Integer.class, "INTEGER");
      IBK.put(Float.TYPE, "FLOAT");
      IBK.put(Float.class, "FLOAT");
      IBK.put(Double.TYPE, "DOUBLE");
      IBK.put(Double.class, "DOUBLE");
      IBK.put(Long.TYPE, "LONG");
      IBK.put(Long.class, "LONG");
      IBK.put(String.class, "TEXT");
      AppMethodBeat.o(158081);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", localException, "", new Object[0]);
      AppMethodBeat.o(158081);
    }
  }
  
  public static String ba(Class<?> paramClass)
  {
    AppMethodBeat.i(158064);
    paramClass = (String)IBK.get(paramClass);
    AppMethodBeat.o(158064);
    return paramClass;
  }
  
  public static void keep_getBlob(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158066);
    try
    {
      paramContentValues.put(c.getColName(paramField), (byte[])paramField.get(paramObject));
      AppMethodBeat.o(158066);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158066);
    }
  }
  
  public static void keep_getBoolean(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158070);
    try
    {
      String str = c.getColName(paramField);
      if (paramField.getBoolean(paramObject)) {}
      for (int i = 1;; i = 0)
      {
        paramContentValues.put(str, Integer.valueOf(i));
        AppMethodBeat.o(158070);
        return;
      }
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158070);
    }
  }
  
  public static void keep_getDouble(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158076);
    try
    {
      if (!paramField.getType().equals(Double.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Double)paramField.get(paramObject));
        AppMethodBeat.o(158076);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Double.valueOf(paramField.getDouble(paramObject)));
      AppMethodBeat.o(158076);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158076);
    }
  }
  
  public static void keep_getFloat(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158074);
    try
    {
      if (!paramField.getType().equals(Float.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Float)paramField.get(paramObject));
        AppMethodBeat.o(158074);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Float.valueOf(paramField.getFloat(paramObject)));
      AppMethodBeat.o(158074);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158074);
    }
  }
  
  public static void keep_getInt(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158072);
    try
    {
      if (!paramField.getType().equals(Integer.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Integer)paramField.get(paramObject));
        AppMethodBeat.o(158072);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Integer.valueOf(paramField.getInt(paramObject)));
      AppMethodBeat.o(158072);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158072);
    }
  }
  
  public static void keep_getLong(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158078);
    try
    {
      if (!paramField.getType().equals(Long.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Long)paramField.get(paramObject));
        AppMethodBeat.o(158078);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Long.valueOf(paramField.getLong(paramObject)));
      AppMethodBeat.o(158078);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158078);
    }
  }
  
  public static void keep_getShort(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158068);
    try
    {
      paramContentValues.put(c.getColName(paramField), Short.valueOf(paramField.getShort(paramObject)));
      AppMethodBeat.o(158068);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158068);
    }
  }
  
  public static void keep_getString(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158080);
    try
    {
      paramContentValues.put(c.getColName(paramField), (String)paramField.get(paramObject));
      AppMethodBeat.o(158080);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158080);
    }
  }
  
  public static void keep_setBlob(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158065);
    try
    {
      paramField.set(paramObject, paramCursor.getBlob(paramInt));
      AppMethodBeat.o(158065);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158065);
    }
  }
  
  public static void keep_setBoolean(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158069);
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
            AppMethodBeat.o(158069);
          }
        }
        else
        {
          paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
          AppMethodBeat.o(158069);
          return;
        }
      }
      catch (Exception paramField)
      {
        ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
        AppMethodBeat.o(158069);
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void keep_setDouble(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158075);
    try
    {
      if (paramField.getType().equals(Double.TYPE))
      {
        paramField.setDouble(paramObject, paramCursor.getDouble(paramInt));
        AppMethodBeat.o(158075);
        return;
      }
      paramField.set(paramObject, Double.valueOf(paramCursor.getDouble(paramInt)));
      AppMethodBeat.o(158075);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158075);
    }
  }
  
  public static void keep_setFloat(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158073);
    try
    {
      if (paramField.getType().equals(Float.TYPE))
      {
        paramField.setFloat(paramObject, paramCursor.getFloat(paramInt));
        AppMethodBeat.o(158073);
        return;
      }
      paramField.set(paramObject, Float.valueOf(paramCursor.getFloat(paramInt)));
      AppMethodBeat.o(158073);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158073);
    }
  }
  
  public static void keep_setInt(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158071);
    try
    {
      if (paramField.getType().equals(Integer.TYPE))
      {
        paramField.setInt(paramObject, paramCursor.getInt(paramInt));
        AppMethodBeat.o(158071);
        return;
      }
      paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
      AppMethodBeat.o(158071);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158071);
    }
  }
  
  public static void keep_setLong(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158077);
    try
    {
      if (paramField.getType().equals(Long.TYPE))
      {
        paramField.setLong(paramObject, paramCursor.getLong(paramInt));
        AppMethodBeat.o(158077);
        return;
      }
      paramField.set(paramObject, Long.valueOf(paramCursor.getLong(paramInt)));
      AppMethodBeat.o(158077);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158077);
    }
  }
  
  public static void keep_setShort(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158067);
    try
    {
      if (paramField.getType().equals(Short.TYPE))
      {
        paramField.setShort(paramObject, paramCursor.getShort(paramInt));
        AppMethodBeat.o(158067);
        return;
      }
      paramField.set(paramObject, Short.valueOf(paramCursor.getShort(paramInt)));
      AppMethodBeat.o(158067);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158067);
    }
  }
  
  public static void keep_setString(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(158079);
    try
    {
      paramField.set(paramObject, paramCursor.getString(paramInt));
      AppMethodBeat.o(158079);
      return;
    }
    catch (Exception paramField)
    {
      ae.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158079);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */