package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

final class b
{
  private static final Map<Class<?>, Object> ecy;
  private static final Map<Class<?>, Object> ecz;
  private static final Map<Class<?>, String> yrJ;
  
  static
  {
    AppMethodBeat.i(52514);
    ecy = new HashMap();
    ecz = new HashMap();
    yrJ = new HashMap();
    try
    {
      ecy.put([B.class, new Object() {});
      ecy.put(Short.TYPE, new Object() {});
      ecy.put(Short.class, new Object() {});
      ecy.put(Boolean.TYPE, new Object() {});
      ecy.put(Boolean.class, new Object() {});
      ecy.put(Integer.TYPE, new Object() {});
      ecy.put(Integer.class, new Object() {});
      ecy.put(Float.TYPE, new Object() {});
      ecy.put(Float.class, new Object() {});
      ecy.put(Double.TYPE, new Object() {});
      ecy.put(Double.class, new Object() {});
      ecy.put(Long.TYPE, new Object() {});
      ecy.put(Long.class, new Object() {});
      ecy.put(String.class, new Object() {});
      ecz.put([B.class, new Object() {});
      ecz.put(Short.TYPE, new Object() {});
      ecz.put(Short.class, new Object() {});
      ecz.put(Boolean.TYPE, new Object() {});
      ecz.put(Boolean.class, new Object() {});
      ecz.put(Integer.TYPE, new Object() {});
      ecz.put(Integer.class, new Object() {});
      ecz.put(Float.TYPE, new Object() {});
      ecz.put(Float.class, new Object() {});
      ecz.put(Double.TYPE, new Object() {});
      ecz.put(Double.class, new Object() {});
      ecz.put(Long.TYPE, new Object() {});
      ecz.put(Long.class, new Object() {});
      ecz.put(String.class, new Object() {});
      yrJ.put([B.class, "BLOB");
      yrJ.put(Short.TYPE, "SHORT");
      yrJ.put(Short.class, "SHORT");
      yrJ.put(Boolean.TYPE, "INTEGER");
      yrJ.put(Boolean.class, "INTEGER");
      yrJ.put(Integer.TYPE, "INTEGER");
      yrJ.put(Integer.class, "INTEGER");
      yrJ.put(Float.TYPE, "FLOAT");
      yrJ.put(Float.class, "FLOAT");
      yrJ.put(Double.TYPE, "DOUBLE");
      yrJ.put(Double.class, "DOUBLE");
      yrJ.put(Long.TYPE, "LONG");
      yrJ.put(Long.class, "LONG");
      yrJ.put(String.class, "TEXT");
      AppMethodBeat.o(52514);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", localException, "", new Object[0]);
      AppMethodBeat.o(52514);
    }
  }
  
  public static String ar(Class<?> paramClass)
  {
    AppMethodBeat.i(52497);
    paramClass = (String)yrJ.get(paramClass);
    AppMethodBeat.o(52497);
    return paramClass;
  }
  
  public static void keep_getBlob(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52499);
    try
    {
      paramContentValues.put(c.getColName(paramField), (byte[])paramField.get(paramObject));
      AppMethodBeat.o(52499);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52499);
    }
  }
  
  public static void keep_getBoolean(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52503);
    try
    {
      String str = c.getColName(paramField);
      if (paramField.getBoolean(paramObject)) {}
      for (int i = 1;; i = 0)
      {
        paramContentValues.put(str, Integer.valueOf(i));
        AppMethodBeat.o(52503);
        return;
      }
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52503);
    }
  }
  
  public static void keep_getDouble(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52509);
    try
    {
      if (!paramField.getType().equals(Double.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Double)paramField.get(paramObject));
        AppMethodBeat.o(52509);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Double.valueOf(paramField.getDouble(paramObject)));
      AppMethodBeat.o(52509);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52509);
    }
  }
  
  public static void keep_getFloat(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52507);
    try
    {
      if (!paramField.getType().equals(Float.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Float)paramField.get(paramObject));
        AppMethodBeat.o(52507);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Float.valueOf(paramField.getFloat(paramObject)));
      AppMethodBeat.o(52507);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52507);
    }
  }
  
  public static void keep_getInt(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52505);
    try
    {
      if (!paramField.getType().equals(Integer.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Integer)paramField.get(paramObject));
        AppMethodBeat.o(52505);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Integer.valueOf(paramField.getInt(paramObject)));
      AppMethodBeat.o(52505);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52505);
    }
  }
  
  public static void keep_getLong(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52511);
    try
    {
      if (!paramField.getType().equals(Long.TYPE))
      {
        paramContentValues.put(c.getColName(paramField), (Long)paramField.get(paramObject));
        AppMethodBeat.o(52511);
        return;
      }
      paramContentValues.put(c.getColName(paramField), Long.valueOf(paramField.getLong(paramObject)));
      AppMethodBeat.o(52511);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52511);
    }
  }
  
  public static void keep_getShort(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52501);
    try
    {
      paramContentValues.put(c.getColName(paramField), Short.valueOf(paramField.getShort(paramObject)));
      AppMethodBeat.o(52501);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52501);
    }
  }
  
  public static void keep_getString(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(52513);
    try
    {
      paramContentValues.put(c.getColName(paramField), (String)paramField.get(paramObject));
      AppMethodBeat.o(52513);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52513);
    }
  }
  
  public static void keep_setBlob(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52498);
    try
    {
      paramField.set(paramObject, paramCursor.getBlob(paramInt));
      AppMethodBeat.o(52498);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52498);
    }
  }
  
  public static void keep_setBoolean(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52502);
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
            AppMethodBeat.o(52502);
          }
        }
        else
        {
          paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
          AppMethodBeat.o(52502);
          return;
        }
      }
      catch (Exception paramField)
      {
        ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
        AppMethodBeat.o(52502);
        return;
      }
      boolean bool = false;
    }
  }
  
  public static void keep_setDouble(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52508);
    try
    {
      if (paramField.getType().equals(Double.TYPE))
      {
        paramField.setDouble(paramObject, paramCursor.getDouble(paramInt));
        AppMethodBeat.o(52508);
        return;
      }
      paramField.set(paramObject, Double.valueOf(paramCursor.getDouble(paramInt)));
      AppMethodBeat.o(52508);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52508);
    }
  }
  
  public static void keep_setFloat(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52506);
    try
    {
      if (paramField.getType().equals(Float.TYPE))
      {
        paramField.setFloat(paramObject, paramCursor.getFloat(paramInt));
        AppMethodBeat.o(52506);
        return;
      }
      paramField.set(paramObject, Float.valueOf(paramCursor.getFloat(paramInt)));
      AppMethodBeat.o(52506);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52506);
    }
  }
  
  public static void keep_setInt(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52504);
    try
    {
      if (paramField.getType().equals(Integer.TYPE))
      {
        paramField.setInt(paramObject, paramCursor.getInt(paramInt));
        AppMethodBeat.o(52504);
        return;
      }
      paramField.set(paramObject, Integer.valueOf(paramCursor.getInt(paramInt)));
      AppMethodBeat.o(52504);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52504);
    }
  }
  
  public static void keep_setLong(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52510);
    try
    {
      if (paramField.getType().equals(Long.TYPE))
      {
        paramField.setLong(paramObject, paramCursor.getLong(paramInt));
        AppMethodBeat.o(52510);
        return;
      }
      paramField.set(paramObject, Long.valueOf(paramCursor.getLong(paramInt)));
      AppMethodBeat.o(52510);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52510);
    }
  }
  
  public static void keep_setShort(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52500);
    try
    {
      if (paramField.getType().equals(Short.TYPE))
      {
        paramField.setShort(paramObject, paramCursor.getShort(paramInt));
        AppMethodBeat.o(52500);
        return;
      }
      paramField.set(paramObject, Short.valueOf(paramCursor.getShort(paramInt)));
      AppMethodBeat.o(52500);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52500);
    }
  }
  
  public static void keep_setString(Field paramField, Object paramObject, Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(52512);
    try
    {
      paramField.set(paramObject, paramCursor.getString(paramInt));
      AppMethodBeat.o(52512);
      return;
    }
    catch (Exception paramField)
    {
      ab.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(52512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.b
 * JD-Core Version:    0.7.0.1
 */