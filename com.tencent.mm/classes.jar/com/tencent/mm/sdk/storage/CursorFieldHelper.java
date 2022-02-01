package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class CursorFieldHelper
{
  private static final Map<Class<?>, IGetMethod> GET_METHODS;
  private static final Map<Class<?>, String> GET_TYPE;
  private static final Map<Class<?>, ISetMethod> SET_METHODS;
  private static final String TAG = "MicroMsg.SDK.CursorFieldHelper";
  
  static
  {
    AppMethodBeat.i(158081);
    SET_METHODS = new HashMap();
    GET_METHODS = new HashMap();
    GET_TYPE = new HashMap();
    try
    {
      SET_METHODS.put([B.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244227);
          CursorFieldHelper.keep_setBlob(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244227);
        }
      });
      SET_METHODS.put(Short.TYPE, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244225);
          CursorFieldHelper.keep_setShort(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244225);
        }
      });
      SET_METHODS.put(Short.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244223);
          CursorFieldHelper.keep_setShort(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244223);
        }
      });
      SET_METHODS.put(Boolean.TYPE, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244237);
          CursorFieldHelper.keep_setBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244237);
        }
      });
      SET_METHODS.put(Boolean.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244234);
          CursorFieldHelper.keep_setBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244234);
        }
      });
      SET_METHODS.put(Integer.TYPE, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244233);
          CursorFieldHelper.keep_setInt(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244233);
        }
      });
      SET_METHODS.put(Integer.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244231);
          CursorFieldHelper.keep_setInt(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244231);
        }
      });
      SET_METHODS.put(Float.TYPE, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244230);
          CursorFieldHelper.keep_setFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244230);
        }
      });
      SET_METHODS.put(Float.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244240);
          CursorFieldHelper.keep_setFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244240);
        }
      });
      SET_METHODS.put(Double.TYPE, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244185);
          CursorFieldHelper.keep_setDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244185);
        }
      });
      SET_METHODS.put(Double.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244194);
          CursorFieldHelper.keep_setDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244194);
        }
      });
      SET_METHODS.put(Long.TYPE, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244188);
          CursorFieldHelper.keep_setLong(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244188);
        }
      });
      SET_METHODS.put(Long.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244190);
          CursorFieldHelper.keep_setLong(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244190);
        }
      });
      SET_METHODS.put(String.class, new ISetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(244191);
          CursorFieldHelper.keep_setString(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(244191);
        }
      });
      GET_METHODS.put([B.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244199);
          CursorFieldHelper.keep_getBlob(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244199);
        }
      });
      GET_METHODS.put(Short.TYPE, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244195);
          CursorFieldHelper.keep_getShort(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244195);
        }
      });
      GET_METHODS.put(Short.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244198);
          CursorFieldHelper.keep_getShort(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244198);
        }
      });
      GET_METHODS.put(Boolean.TYPE, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244197);
          CursorFieldHelper.keep_getBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244197);
        }
      });
      GET_METHODS.put(Boolean.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244202);
          CursorFieldHelper.keep_getBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244202);
        }
      });
      GET_METHODS.put(Integer.TYPE, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244203);
          CursorFieldHelper.keep_getInt(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244203);
        }
      });
      GET_METHODS.put(Integer.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244214);
          CursorFieldHelper.keep_getInt(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244214);
        }
      });
      GET_METHODS.put(Float.TYPE, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244205);
          CursorFieldHelper.keep_getFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244205);
        }
      });
      GET_METHODS.put(Float.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244206);
          CursorFieldHelper.keep_getFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244206);
        }
      });
      GET_METHODS.put(Double.TYPE, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244207);
          CursorFieldHelper.keep_getDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244207);
        }
      });
      GET_METHODS.put(Double.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244208);
          CursorFieldHelper.keep_getDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244208);
        }
      });
      GET_METHODS.put(Long.TYPE, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244216);
          CursorFieldHelper.keep_getLong(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244216);
        }
      });
      GET_METHODS.put(Long.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244212);
          CursorFieldHelper.keep_getLong(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244212);
        }
      });
      GET_METHODS.put(String.class, new IGetMethod()
      {
        public void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(244213);
          CursorFieldHelper.keep_getString(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(244213);
        }
      });
      GET_TYPE.put([B.class, "BLOB");
      GET_TYPE.put(Short.TYPE, "SHORT");
      GET_TYPE.put(Short.class, "SHORT");
      GET_TYPE.put(Boolean.TYPE, "INTEGER");
      GET_TYPE.put(Boolean.class, "INTEGER");
      GET_TYPE.put(Integer.TYPE, "INTEGER");
      GET_TYPE.put(Integer.class, "INTEGER");
      GET_TYPE.put(Float.TYPE, "FLOAT");
      GET_TYPE.put(Float.class, "FLOAT");
      GET_TYPE.put(Double.TYPE, "DOUBLE");
      GET_TYPE.put(Double.class, "DOUBLE");
      GET_TYPE.put(Long.TYPE, "LONG");
      GET_TYPE.put(Long.class, "LONG");
      GET_TYPE.put(String.class, "TEXT");
      AppMethodBeat.o(158081);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", localException, "", new Object[0]);
      AppMethodBeat.o(158081);
    }
  }
  
  public static IGetMethod getter(Class<?> paramClass)
  {
    AppMethodBeat.i(244280);
    paramClass = (IGetMethod)GET_METHODS.get(paramClass);
    AppMethodBeat.o(244280);
    return paramClass;
  }
  
  public static void keep_getBlob(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158066);
    try
    {
      paramContentValues.put(IAutoDBItem.getColName(paramField), (byte[])paramField.get(paramObject));
      AppMethodBeat.o(158066);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158066);
    }
  }
  
  public static void keep_getBoolean(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158070);
    try
    {
      String str = IAutoDBItem.getColName(paramField);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
        paramContentValues.put(IAutoDBItem.getColName(paramField), (Double)paramField.get(paramObject));
        AppMethodBeat.o(158076);
        return;
      }
      paramContentValues.put(IAutoDBItem.getColName(paramField), Double.valueOf(paramField.getDouble(paramObject)));
      AppMethodBeat.o(158076);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
        paramContentValues.put(IAutoDBItem.getColName(paramField), (Float)paramField.get(paramObject));
        AppMethodBeat.o(158074);
        return;
      }
      paramContentValues.put(IAutoDBItem.getColName(paramField), Float.valueOf(paramField.getFloat(paramObject)));
      AppMethodBeat.o(158074);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
        paramContentValues.put(IAutoDBItem.getColName(paramField), (Integer)paramField.get(paramObject));
        AppMethodBeat.o(158072);
        return;
      }
      paramContentValues.put(IAutoDBItem.getColName(paramField), Integer.valueOf(paramField.getInt(paramObject)));
      AppMethodBeat.o(158072);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
        paramContentValues.put(IAutoDBItem.getColName(paramField), (Long)paramField.get(paramObject));
        AppMethodBeat.o(158078);
        return;
      }
      paramContentValues.put(IAutoDBItem.getColName(paramField), Long.valueOf(paramField.getLong(paramObject)));
      AppMethodBeat.o(158078);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158078);
    }
  }
  
  public static void keep_getShort(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158068);
    try
    {
      paramContentValues.put(IAutoDBItem.getColName(paramField), Short.valueOf(paramField.getShort(paramObject)));
      AppMethodBeat.o(158068);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158068);
    }
  }
  
  public static void keep_getString(Field paramField, Object paramObject, ContentValues paramContentValues)
  {
    AppMethodBeat.i(158080);
    try
    {
      paramContentValues.put(IAutoDBItem.getColName(paramField), (String)paramField.get(paramObject));
      AppMethodBeat.o(158080);
      return;
    }
    catch (Exception paramField)
    {
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
        Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
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
      Log.printErrStackTrace("MicroMsg.SDK.CursorFieldHelper", paramField, "", new Object[0]);
      AppMethodBeat.o(158079);
    }
  }
  
  public static ISetMethod setter(Class<?> paramClass)
  {
    AppMethodBeat.i(244284);
    paramClass = (ISetMethod)SET_METHODS.get(paramClass);
    AppMethodBeat.o(244284);
    return paramClass;
  }
  
  public static String type(Class<?> paramClass)
  {
    AppMethodBeat.i(158064);
    paramClass = (String)GET_TYPE.get(paramClass);
    AppMethodBeat.o(158064);
    return paramClass;
  }
  
  public static abstract interface IGetMethod
  {
    public abstract void invoke(Field paramField, Object paramObject, ContentValues paramContentValues);
  }
  
  public static abstract interface ISetMethod
  {
    public abstract void invoke(Field paramField, Object paramObject, Cursor paramCursor, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.CursorFieldHelper
 * JD-Core Version:    0.7.0.1
 */