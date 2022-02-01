package com.tencent.shadow.core.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

public class d
{
  private static final Logger b = LoggerFactory.getLogger(d.class);
  private f a;
  
  public d(f paramf)
  {
    this.a = paramf;
  }
  
  private String[] a(String paramString, Cursor paramCursor)
  {
    int i = paramCursor.getColumnIndex(paramString);
    if ((paramCursor.isNull(i) ^ true))
    {
      paramString = paramCursor.getString(i);
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        paramCursor = new String[localJSONArray.length()];
        i = 0;
        for (;;)
        {
          paramString = paramCursor;
          if (i >= localJSONArray.length()) {
            break;
          }
          paramCursor[i] = localJSONArray.getString(i);
          i += 1;
        }
        paramString = null;
      }
      catch (JSONException paramString)
      {
        throw new RuntimeException(paramString);
      }
    }
    return paramString;
  }
  
  private Pair<e, List<ContentValues>> b(j paramj)
  {
    Object localObject2 = new ArrayList();
    e locale = new e();
    if (paramj.e != null)
    {
      locale.c = new e.a(3, paramj.e.a, null, null);
      ((List)localObject2).add(new g(paramj.e.b, null, paramj.e.a.getAbsolutePath(), 3));
    }
    if (paramj.f != null)
    {
      locale.d = new e.a(4, paramj.f.a, null, null);
      ((List)localObject2).add(new g(paramj.f.b, null, paramj.f.a.getAbsolutePath(), 4));
    }
    Object localObject3;
    if (paramj.g != null)
    {
      localObject1 = paramj.g.entrySet();
      localObject3 = new HashMap();
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        j.b localb = (j.b)localEntry.getValue();
        ((Map)localObject3).put(localEntry.getKey(), new e.b(1, localb.e, localb.a, null, null, localb.c, localb.d));
        ((List)localObject2).add(new g(localb.b, localb.e, (String)localEntry.getKey(), localb.c, localb.a.getAbsolutePath(), 1, localb.d));
      }
      locale.e = ((Map)localObject3);
    }
    Object localObject1 = new g();
    ((g)localObject1).h = 5;
    ((g)localObject1).g = paramj.c;
    ((List)localObject2).add(localObject1);
    localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (g)((Iterator)localObject2).next();
      ((g)localObject3).b = paramj.h.lastModified();
      ((g)localObject3).i = paramj.c;
      ((g)localObject3).j = paramj.d;
      ((List)localObject1).add(((g)localObject3).a());
    }
    locale.a = paramj.c;
    locale.b = paramj.d;
    return new Pair(locale, localObject1);
  }
  
  public e a(j paramj)
  {
    Object localObject1 = b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("insert, uuid {}, runtime {}, loader {}, storageDir {}, plugins {}");
    ((StringBuilder)localObject2).append(paramj.c);
    ((Logger)localObject1).info(((StringBuilder)localObject2).toString(), new Object[] { paramj.f, paramj.e, paramj.h, paramj.g });
    localObject1 = this.a.getWritableDatabase();
    localObject2 = b(paramj);
    Object localObject3 = (List)((Pair)localObject2).second;
    ((SQLiteDatabase)localObject1).beginTransaction();
    try
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((SQLiteDatabase)localObject1).replace("shadowPluginManager", null, (ContentValues)((Iterator)localObject3).next());
      }
      localObject3 = new ContentValues();
      ((ContentValues)localObject3).put("installedTime", Long.valueOf(paramj.h.lastModified()));
      ((SQLiteDatabase)localObject1).update("shadowPluginManager", (ContentValues)localObject3, "uuid = ?", new String[] { paramj.c });
      ((SQLiteDatabase)localObject1).setTransactionSuccessful();
      return (e)((Pair)localObject2).first;
    }
    finally
    {
      ((SQLiteDatabase)localObject1).endTransaction();
    }
  }
  
  public e a(String paramString)
  {
    Cursor localCursor = this.a.getReadableDatabase().rawQuery("select * from shadowPluginManager where uuid = ?", new String[] { paramString });
    e locale = new e();
    locale.a = paramString;
    while (localCursor.moveToNext())
    {
      int i = localCursor.getInt(localCursor.getColumnIndex("type"));
      if (i == 5)
      {
        locale.b = localCursor.getString(localCursor.getColumnIndex("version"));
      }
      else
      {
        File localFile = new File(localCursor.getString(localCursor.getColumnIndex("filePath")));
        paramString = localCursor.getString(localCursor.getColumnIndex("odexPath"));
        if (paramString == null) {
          paramString = null;
        } else {
          paramString = new File(paramString);
        }
        Object localObject = localCursor.getString(localCursor.getColumnIndex("libPath"));
        if (localObject == null) {
          localObject = null;
        } else {
          localObject = new File((String)localObject);
        }
        if (i == 3)
        {
          locale.c = new e.a(i, localFile, paramString, (File)localObject);
        }
        else if (i == 4)
        {
          locale.d = new e.a(i, localFile, paramString, (File)localObject);
        }
        else
        {
          String str2;
          try
          {
            String str1 = localCursor.getString(localCursor.getColumnIndex("businessName"));
          }
          catch (IllegalStateException localIllegalStateException1)
          {
            b.error(localIllegalStateException1.getMessage());
            str2 = null;
          }
          String str3 = localCursor.getString(localCursor.getColumnIndex("partKey"));
          if ((i != 1) && (i != 2))
          {
            paramString = new StringBuilder();
            paramString.append("出现不认识的type==");
            paramString.append(i);
            throw new RuntimeException(paramString.toString());
          }
          String[] arrayOfString2;
          try
          {
            String[] arrayOfString1 = a("dependsOn", localCursor);
          }
          catch (IllegalStateException localIllegalStateException2)
          {
            b.error(localIllegalStateException2.getMessage());
            arrayOfString2 = new String[0];
          }
          String[] arrayOfString4;
          try
          {
            String[] arrayOfString3 = a("hostWhiteList", localCursor);
          }
          catch (IllegalStateException localIllegalStateException3)
          {
            b.error(localIllegalStateException3.getMessage());
            arrayOfString4 = new String[0];
          }
          locale.e.put(str3, new e.b(i, str2, localFile, paramString, (File)localObject, arrayOfString2, arrayOfString4));
        }
      }
    }
    localCursor.close();
    return locale;
  }
  
  public boolean a(String paramString, int paramInt, ContentValues paramContentValues)
  {
    Object localObject = b;
    boolean bool = false;
    ((Logger)localObject).info("updatePlugin UUID = %s, type = %d, contentValues = %s", new Object[] { paramString, Integer.valueOf(paramInt), paramContentValues.toString() });
    if ((paramInt != 3) && (paramInt != 4))
    {
      paramString = new StringBuilder();
      paramString.append("不支持更新 type:");
      paramString.append(paramInt);
      throw new RuntimeException(paramString.toString());
    }
    localObject = this.a.getWritableDatabase();
    ((SQLiteDatabase)localObject).beginTransaction();
    try
    {
      paramInt = ((SQLiteDatabase)localObject).update("shadowPluginManager", paramContentValues, "uuid = ? and type = ?", new String[] { paramString, String.valueOf(paramInt) });
      ((SQLiteDatabase)localObject).setTransactionSuccessful();
      ((SQLiteDatabase)localObject).endTransaction();
      if (paramInt > 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      ((SQLiteDatabase)localObject).endTransaction();
    }
  }
  
  public boolean a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    Object localObject = b;
    boolean bool = false;
    ((Logger)localObject).info("updatePlugin UUID = %s, parrKey = %s, contentValues = %s", new Object[] { paramString1, paramString2, paramContentValues.toString() });
    localObject = this.a.getWritableDatabase();
    ((SQLiteDatabase)localObject).beginTransaction();
    try
    {
      int i = ((SQLiteDatabase)localObject).update("shadowPluginManager", paramContentValues, "uuid = ? and partKey = ?", new String[] { paramString1, paramString2 });
      ((SQLiteDatabase)localObject).setTransactionSuccessful();
      ((SQLiteDatabase)localObject).endTransaction();
      if (i > 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      ((SQLiteDatabase)localObject).endTransaction();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\assets\live_shopping_manager_apk\classes.jar
 * Qualified Name:     com.tencent.shadow.core.b.a.d
 * JD-Core Version:    0.7.0.1
 */