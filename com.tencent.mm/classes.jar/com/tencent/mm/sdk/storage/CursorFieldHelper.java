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
  private static final Map<Class<?>, CursorFieldHelper.IGetMethod> GET_METHODS;
  private static final Map<Class<?>, String> GET_TYPE;
  private static final Map<Class<?>, CursorFieldHelper.ISetMethod> SET_METHODS;
  private static final String TAG = "MicroMsg.SDK.CursorFieldHelper";
  
  static
  {
    AppMethodBeat.i(158081);
    SET_METHODS = new HashMap();
    GET_METHODS = new HashMap();
    GET_TYPE = new HashMap();
    try
    {
      SET_METHODS.put([B.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(190195);
          CursorFieldHelper.keep_setBlob(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(190195);
        }
      });
      SET_METHODS.put(Short.TYPE, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(192463);
          CursorFieldHelper.keep_setShort(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(192463);
        }
      });
      SET_METHODS.put(Short.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(190831);
          CursorFieldHelper.keep_setShort(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(190831);
        }
      });
      SET_METHODS.put(Boolean.TYPE, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(193826);
          CursorFieldHelper.keep_setBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(193826);
        }
      });
      SET_METHODS.put(Boolean.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(194252);
          CursorFieldHelper.keep_setBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(194252);
        }
      });
      SET_METHODS.put(Integer.TYPE, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(194595);
          CursorFieldHelper.keep_setInt(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(194595);
        }
      });
      SET_METHODS.put(Integer.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(193560);
          CursorFieldHelper.keep_setInt(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(193560);
        }
      });
      SET_METHODS.put(Float.TYPE, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(192202);
          CursorFieldHelper.keep_setFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(192202);
        }
      });
      SET_METHODS.put(Float.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(193105);
          CursorFieldHelper.keep_setFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(193105);
        }
      });
      SET_METHODS.put(Double.TYPE, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(186266);
          CursorFieldHelper.keep_setDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(186266);
        }
      });
      SET_METHODS.put(Double.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(189565);
          CursorFieldHelper.keep_setDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(189565);
        }
      });
      SET_METHODS.put(Long.TYPE, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(190215);
          CursorFieldHelper.keep_setLong(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(190215);
        }
      });
      SET_METHODS.put(Long.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(191425);
          CursorFieldHelper.keep_setLong(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(191425);
        }
      });
      SET_METHODS.put(String.class, new CursorFieldHelper.ISetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, Cursor paramAnonymousCursor, int paramAnonymousInt)
        {
          AppMethodBeat.i(189958);
          CursorFieldHelper.keep_setString(paramAnonymousField, paramAnonymousObject, paramAnonymousCursor, paramAnonymousInt);
          AppMethodBeat.o(189958);
        }
      });
      GET_METHODS.put([B.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(188554);
          CursorFieldHelper.keep_getBlob(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(188554);
        }
      });
      GET_METHODS.put(Short.TYPE, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(187903);
          CursorFieldHelper.keep_getShort(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(187903);
        }
      });
      GET_METHODS.put(Short.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(194005);
          CursorFieldHelper.keep_getShort(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(194005);
        }
      });
      GET_METHODS.put(Boolean.TYPE, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(194377);
          CursorFieldHelper.keep_getBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(194377);
        }
      });
      GET_METHODS.put(Boolean.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(194135);
          CursorFieldHelper.keep_getBoolean(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(194135);
        }
      });
      GET_METHODS.put(Integer.TYPE, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(191170);
          CursorFieldHelper.keep_getInt(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(191170);
        }
      });
      GET_METHODS.put(Integer.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(192653);
          CursorFieldHelper.keep_getInt(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(192653);
        }
      });
      GET_METHODS.put(Float.TYPE, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(187513);
          CursorFieldHelper.keep_getFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(187513);
        }
      });
      GET_METHODS.put(Float.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(186505);
          CursorFieldHelper.keep_getFloat(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(186505);
        }
      });
      GET_METHODS.put(Double.TYPE, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(194562);
          CursorFieldHelper.keep_getDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(194562);
        }
      });
      GET_METHODS.put(Double.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(194140);
          CursorFieldHelper.keep_getDouble(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(194140);
        }
      });
      GET_METHODS.put(Long.TYPE, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(192529);
          CursorFieldHelper.keep_getLong(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(192529);
        }
      });
      GET_METHODS.put(Long.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(188812);
          CursorFieldHelper.keep_getLong(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(188812);
        }
      });
      GET_METHODS.put(String.class, new CursorFieldHelper.IGetMethod()
      {
        public final void invoke(Field paramAnonymousField, Object paramAnonymousObject, ContentValues paramAnonymousContentValues)
        {
          AppMethodBeat.i(186717);
          CursorFieldHelper.keep_getString(paramAnonymousField, paramAnonymousObject, paramAnonymousContentValues);
          AppMethodBeat.o(186717);
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
  
  public static CursorFieldHelper.IGetMethod getter(Class<?> paramClass)
  {
    AppMethodBeat.i(193284);
    paramClass = (CursorFieldHelper.IGetMethod)GET_METHODS.get(paramClass);
    AppMethodBeat.o(193284);
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
  
  public static CursorFieldHelper.ISetMethod setter(Class<?> paramClass)
  {
    AppMethodBeat.i(193289);
    paramClass = (CursorFieldHelper.ISetMethod)SET_METHODS.get(paramClass);
    AppMethodBeat.o(193289);
    return paramClass;
  }
  
  public static String type(Class<?> paramClass)
  {
    AppMethodBeat.i(158064);
    paramClass = (String)GET_TYPE.get(paramClass);
    AppMethodBeat.o(158064);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.CursorFieldHelper
 * JD-Core Version:    0.7.0.1
 */