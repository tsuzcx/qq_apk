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
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230504);
          CursorFieldHelper.keep_setBlob(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230504);
        }
      });
      SET_METHODS.put(Short.TYPE, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230515);
          CursorFieldHelper.keep_setShort(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230515);
        }
      });
      SET_METHODS.put(Short.class, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230525);
          CursorFieldHelper.keep_setShort(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230525);
        }
      });
      SET_METHODS.put(Boolean.TYPE, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230526);
          CursorFieldHelper.keep_setBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230526);
        }
      });
      SET_METHODS.put(Boolean.class, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230527);
          CursorFieldHelper.keep_setBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230527);
        }
      });
      SET_METHODS.put(Integer.TYPE, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230528);
          CursorFieldHelper.keep_setInt(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230528);
        }
      });
      SET_METHODS.put(Integer.class, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230529);
          CursorFieldHelper.keep_setInt(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230529);
        }
      });
      SET_METHODS.put(Float.TYPE, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230530);
          CursorFieldHelper.keep_setFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230530);
        }
      });
      SET_METHODS.put(Float.class, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230531);
          CursorFieldHelper.keep_setFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230531);
        }
      });
      SET_METHODS.put(Double.TYPE, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230505);
          CursorFieldHelper.keep_setDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230505);
        }
      });
      SET_METHODS.put(Double.class, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230506);
          CursorFieldHelper.keep_setDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230506);
        }
      });
      SET_METHODS.put(Long.TYPE, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230507);
          CursorFieldHelper.keep_setLong(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230507);
        }
      });
      SET_METHODS.put(Long.class, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230508);
          CursorFieldHelper.keep_setLong(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230508);
        }
      });
      SET_METHODS.put(String.class, new ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(230509);
          CursorFieldHelper.keep_setString(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(230509);
        }
      });
      GET_METHODS.put([B.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230510);
          CursorFieldHelper.keep_getBlob(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230510);
        }
      });
      GET_METHODS.put(Short.TYPE, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230511);
          CursorFieldHelper.keep_getShort(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230511);
        }
      });
      GET_METHODS.put(Short.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230512);
          CursorFieldHelper.keep_getShort(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230512);
        }
      });
      GET_METHODS.put(Boolean.TYPE, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230513);
          CursorFieldHelper.keep_getBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230513);
        }
      });
      GET_METHODS.put(Boolean.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230514);
          CursorFieldHelper.keep_getBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230514);
        }
      });
      GET_METHODS.put(Integer.TYPE, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230516);
          CursorFieldHelper.keep_getInt(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230516);
        }
      });
      GET_METHODS.put(Integer.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230517);
          CursorFieldHelper.keep_getInt(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230517);
        }
      });
      GET_METHODS.put(Float.TYPE, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230518);
          CursorFieldHelper.keep_getFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230518);
        }
      });
      GET_METHODS.put(Float.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230519);
          CursorFieldHelper.keep_getFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230519);
        }
      });
      GET_METHODS.put(Double.TYPE, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230520);
          CursorFieldHelper.keep_getDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230520);
        }
      });
      GET_METHODS.put(Double.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230521);
          CursorFieldHelper.keep_getDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230521);
        }
      });
      GET_METHODS.put(Long.TYPE, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230522);
          CursorFieldHelper.keep_getLong(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230522);
        }
      });
      GET_METHODS.put(Long.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230523);
          CursorFieldHelper.keep_getLong(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230523);
        }
      });
      GET_METHODS.put(String.class, new IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(230524);
          CursorFieldHelper.keep_getString(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(230524);
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
    AppMethodBeat.i(230532);
    paramClass = (IGetMethod)GET_METHODS.get(paramClass);
    AppMethodBeat.o(230532);
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
    AppMethodBeat.i(230533);
    paramClass = (ISetMethod)SET_METHODS.get(paramClass);
    AppMethodBeat.o(230533);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.CursorFieldHelper
 * JD-Core Version:    0.7.0.1
 */