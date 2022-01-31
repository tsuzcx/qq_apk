package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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

public abstract class c
{
  public long ujK = -1L;
  
  public static a V(Class<?> paramClass)
  {
    a locala = new a();
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
          break label165;
        }
        paramClass = str.substring(6);
        label91:
        if (!localField.isAnnotationPresent(h.class)) {
          break label171;
        }
        if (((h)localField.getAnnotation(h.class)).csr() == 1) {
          locala.ujM = paramClass;
        }
      }
      for (;;)
      {
        if (!bk.bl(paramClass))
        {
          if (paramClass.equals("rowid")) {
            Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
          }
          localLinkedList.add(localField);
        }
        label165:
        label171:
        do
        {
          i += 1;
          break;
          paramClass = str;
          break label91;
        } while (!str.startsWith("field_"));
      }
    }
    locala.ujL = ((Field[])localLinkedList.toArray(new Field[0]));
    locala.columns = a(locala.ujL);
    locala.ujN = b(locala.ujL);
    locala.sql = c(locala.ujL);
    return locala;
  }
  
  public static String a(Field paramField)
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
  
  public static boolean a(ContentValues paramContentValues, Cursor paramCursor)
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
    label219:
    label352:
    label357:
    label364:
    label367:
    for (;;)
    {
      Object localObject;
      byte[] arrayOfByte;
      try
      {
        Iterator localIterator = paramContentValues.valueSet().iterator();
        if (localIterator.hasNext())
        {
          localObject = (String)((Map.Entry)localIterator.next()).getKey();
          if (((String)localObject).equals("rowid")) {
            continue;
          }
          i = paramCursor.getColumnIndex((String)localObject);
          if (i == -1) {
            return false;
          }
          if ((paramContentValues.get((String)localObject) instanceof byte[]))
          {
            localObject = (byte[])paramContentValues.get((String)localObject);
            arrayOfByte = paramCursor.getBlob(i);
            if (localObject != null) {
              break label319;
            }
            if (arrayOfByte == null) {
              break label364;
            }
            break label319;
            if (localObject.length == arrayOfByte.length) {
              break label352;
            }
            i = 0;
            break label331;
            if (i >= localObject.length) {
              break label364;
            }
            if (localObject[i] == arrayOfByte[i]) {
              break label357;
            }
            i = 0;
            break label331;
          }
          if ((paramCursor.getString(i) == null) && (paramContentValues.get((String)localObject) != null)) {
            return false;
          }
          if (paramContentValues.get((String)localObject) == null) {
            return false;
          }
          boolean bool = paramContentValues.get((String)localObject).toString().equals(paramCursor.getString(i));
          if (bool) {
            continue;
          }
          return false;
        }
      }
      catch (Exception paramContentValues)
      {
        y.printErrStackTrace("MicroMsg.SDK.IAutoDBItem", paramContentValues, "", new Object[0]);
        return false;
      }
      return true;
      if ((localObject == null) && (arrayOfByte != null)) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0) {
          break label367;
        }
        return false;
        if ((localObject == null) || (arrayOfByte != null)) {
          break;
        }
        i = 0;
        continue;
        i = 0;
        break label219;
        i += 1;
        break label219;
        i = 1;
      }
    }
  }
  
  private static String[] a(Field[] paramArrayOfField)
  {
    String[] arrayOfString = new String[paramArrayOfField.length + 1];
    int i = 0;
    if (i < paramArrayOfField.length)
    {
      arrayOfString[i] = a(paramArrayOfField[i]);
      String str = "getFullColumns failed:" + paramArrayOfField[i].getName();
      if (!bk.bl(arrayOfString[i])) {}
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
  
  private static Map<String, String> b(Field[] paramArrayOfField)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramArrayOfField.length)
    {
      Object localObject = paramArrayOfField[i];
      String str = b.U(((Field)localObject).getType());
      if (str == null) {
        y.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + ((Field)localObject).getName() + ", skipped");
      }
      for (;;)
      {
        i += 1;
        break;
        localObject = a((Field)localObject);
        if (!bk.bl((String)localObject)) {
          localHashMap.put(localObject, str);
        }
      }
    }
    return localHashMap;
  }
  
  private static String c(Field[] paramArrayOfField)
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
      localObject = b.U(localField.getType());
      if (localObject == null) {
        y.e("MicroMsg.SDK.IAutoDBItem", "failed identify on column: " + localField.getName() + ", skipped");
      }
      do
      {
        i += 1;
        break;
        str2 = a(localField);
      } while (bk.bl(str2));
      str1 = "";
      if (!localField.isAnnotationPresent(h.class)) {
        break label249;
      }
      str1 = " default '" + ((h)localField.getAnnotation(h.class)).csq() + "' ";
    }
    label194:
    label236:
    label249:
    for (int j = ((h)localField.getAnnotation(h.class)).csr();; j = 0)
    {
      localObject = new StringBuilder().append(str2).append(" ").append((String)localObject).append(str1);
      if (j == 1)
      {
        str1 = " PRIMARY KEY ";
        localStringBuilder.append(str1);
        if (i != paramArrayOfField.length - 1) {
          break label236;
        }
      }
      for (str1 = "";; str1 = ", ")
      {
        localStringBuilder.append(str1);
        break;
        str1 = "";
        break label194;
      }
      return localStringBuilder.toString();
    }
  }
  
  public abstract void d(Cursor paramCursor);
  
  public abstract a rM();
  
  public abstract ContentValues vf();
  
  public static final class a
  {
    public String[] columns;
    public String sql;
    public Field[] ujL;
    public String ujM;
    public Map<String, String> ujN = new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.c
 * JD-Core Version:    0.7.0.1
 */