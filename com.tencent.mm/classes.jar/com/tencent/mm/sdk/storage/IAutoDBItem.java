package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public abstract class IAutoDBItem
  implements MDBItem
{
  public static final String COL_ROWID = "rowid";
  public static final String FIELD_PREFIX = "field_";
  public static final String SYSTEM_ROWID_FIELD = "rowid";
  private static final String TAG = "MicroMsg.SDK.IAutoDBItem";
  public long systemRowid = -1L;
  
  private static boolean checkBlobEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (paramArrayOfByte1 != null) {
            break;
          }
          bool1 = bool2;
        } while (paramArrayOfByte2 != null);
        if (paramArrayOfByte1 == null) {
          break;
        }
        bool1 = bool2;
      } while (paramArrayOfByte2 == null);
      bool1 = bool2;
    } while (paramArrayOfByte1.length != paramArrayOfByte2.length);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayOfByte1.length) {
        break label74;
      }
      bool1 = bool2;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        break;
      }
      i += 1;
    }
    label74:
    return true;
  }
  
  public static boolean checkIOEqual(ContentValues paramContentValues, Cursor paramCursor)
  {
    if (paramContentValues == null) {
      return paramCursor == null;
    }
    if ((paramCursor == null) || (paramCursor.getCount() != 1)) {
      return false;
    }
    paramCursor.moveToFirst();
    int k = paramCursor.getColumnCount();
    int j = paramContentValues.size();
    int i = j;
    if (paramContentValues.containsKey("rowid")) {
      i = j - 1;
    }
    j = k;
    if (paramCursor.getColumnIndex("rowid") != -1) {
      j = k - 1;
    }
    if (i != j) {
      return false;
    }
    try
    {
      Iterator localIterator = paramContentValues.valueSet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        if (!str.equals("rowid"))
        {
          i = paramCursor.getColumnIndex(str);
          if (i == -1) {
            return false;
          }
          if ((paramContentValues.get(str) instanceof byte[]))
          {
            if (!checkBlobEqual((byte[])paramContentValues.get(str), paramCursor.getBlob(i))) {
              return false;
            }
          }
          else
          {
            if ((paramCursor.getString(i) == null) && (paramContentValues.get(str) != null)) {
              return false;
            }
            if (paramContentValues.get(str) == null) {
              return false;
            }
            boolean bool = paramContentValues.get(str).toString().equals(paramCursor.getString(i));
            if (!bool) {
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramContentValues)
    {
      Log.printErrStackTrace("MicroMsg.SDK.IAutoDBItem", paramContentValues, "", new Object[0]);
      return false;
    }
    return true;
  }
  
  public static String getColName(Field paramField)
  {
    if (paramField == null) {}
    do
    {
      return null;
      paramField = paramField.getName();
    } while ((paramField == null) || (paramField.length() <= 0));
    if (paramField.startsWith("field_")) {
      return paramField.substring(6);
    }
    return paramField;
  }
  
  private static Map<String, String> getColsMap(Field[] paramArrayOfField)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramArrayOfField.length)
    {
      Object localObject = paramArrayOfField[i];
      String str = CursorFieldHelper.type(((Field)localObject).getType());
      if (str == null) {
        Log.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + ((Field)localObject).getName() + ", skipped");
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = getColName((Field)localObject);
        if (!Util.isNullOrNil((String)localObject)) {
          localHashMap.put(localObject, str);
        }
      }
    }
    return localHashMap;
  }
  
  public static Cursor getCursorForProjection(ContentValues paramContentValues, String[] paramArrayOfString)
  {
    Object[] arrayOfObject = new Object[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfObject.length)
    {
      arrayOfObject[i] = paramContentValues.get(paramArrayOfString[i]);
      i += 1;
    }
    paramContentValues = new MatrixCursor(paramArrayOfString);
    paramContentValues.addRow(arrayOfObject);
    return paramContentValues;
  }
  
  private static String[] getFullColumns(Field[] paramArrayOfField)
  {
    String[] arrayOfString = new String[paramArrayOfField.length + 1];
    int i = 0;
    if (i < paramArrayOfField.length)
    {
      arrayOfString[i] = getColName(paramArrayOfField[i]);
      String str = "getFullColumns failed:" + paramArrayOfField[i].getName();
      if (!Util.isNullOrNil(arrayOfString[i])) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(str, bool);
        i += 1;
        break;
      }
    }
    arrayOfString[paramArrayOfField.length] = "rowid";
    return arrayOfString;
  }
  
  private static String getSql(Field[] paramArrayOfField)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    Field localField;
    Object localObject;
    String str2;
    String str1;
    if (i < paramArrayOfField.length)
    {
      localField = paramArrayOfField[i];
      localObject = CursorFieldHelper.type(localField.getType());
      if (localObject == null) {
        Log.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + localField.getName() + ", skipped");
      }
      do
      {
        i += 1;
        break;
        str2 = getColName(localField);
      } while (Util.isNullOrNil(str2));
      str1 = "";
      if (!localField.isAnnotationPresent(MAutoDBFieldAnnotation.class)) {
        break label244;
      }
      str1 = " default '" + ((MAutoDBFieldAnnotation)localField.getAnnotation(MAutoDBFieldAnnotation.class)).defValue() + "' ";
    }
    label190:
    label232:
    label244:
    for (int j = ((MAutoDBFieldAnnotation)localField.getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey();; j = 0)
    {
      localObject = new StringBuilder().append(str2).append(" ").append((String)localObject).append(str1);
      if (j == 1)
      {
        str1 = " PRIMARY KEY ";
        localStringBuilder.append(str1);
        if (i != paramArrayOfField.length - 1) {
          break label232;
        }
      }
      for (str1 = "";; str1 = ", ")
      {
        localStringBuilder.append(str1);
        break;
        str1 = "";
        break label190;
      }
      return localStringBuilder.toString();
    }
  }
  
  public static Field[] getValidFields(Class<?> paramClass)
  {
    return initAutoDBInfo(paramClass).fields;
  }
  
  public static MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    MAutoDBInfo localMAutoDBInfo = new MAutoDBInfo();
    LinkedList localLinkedList = new LinkedList();
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Field localField = arrayOfField[i];
      int k = localField.getModifiers();
      String str = localField.getName();
      if ((str != null) && (Modifier.isPublic(k)) && (!Modifier.isFinal(k)))
      {
        if (!str.startsWith("field_")) {
          break label166;
        }
        paramClass = str.substring(6);
        label91:
        if (!localField.isAnnotationPresent(MAutoDBFieldAnnotation.class)) {
          break label172;
        }
        if (((MAutoDBFieldAnnotation)localField.getAnnotation(MAutoDBFieldAnnotation.class)).primaryKey() == 1) {
          localMAutoDBInfo.primaryKey = paramClass;
        }
      }
      for (;;)
      {
        if (!Util.isNullOrNil(paramClass))
        {
          if (paramClass.equals("rowid")) {
            Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
          }
          localLinkedList.add(localField);
        }
        label166:
        label172:
        do
        {
          i += 1;
          break;
          paramClass = str;
          break label91;
        } while (!str.startsWith("field_"));
      }
    }
    localMAutoDBInfo.fields = ((Field[])localLinkedList.toArray(new Field[0]));
    localMAutoDBInfo.columns = getFullColumns(localMAutoDBInfo.fields);
    localMAutoDBInfo.colsMap = getColsMap(localMAutoDBInfo.fields);
    localMAutoDBInfo.sql = getSql(localMAutoDBInfo.fields);
    return localMAutoDBInfo;
  }
  
  public abstract void convertFrom(Cursor paramCursor);
  
  public abstract ContentValues convertTo();
  
  protected abstract MAutoDBInfo getDBInfo();
  
  public static class MAutoDBInfo
  {
    public Map<String, String> colsMap;
    public String[] columns;
    public Field[] fields;
    public String primaryKey;
    public String sql;
    
    public MAutoDBInfo()
    {
      AppMethodBeat.i(158082);
      this.colsMap = new HashMap();
      AppMethodBeat.o(158082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.IAutoDBItem
 * JD-Core Version:    0.7.0.1
 */