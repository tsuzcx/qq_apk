package com.tencent.mm.sdk.e;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public abstract class i<T extends c>
  extends j
  implements d<T>
{
  private final e dXw;
  public int field_MARK_CURSOR_CHECK_IGNORE = 1;
  private final String table;
  public final c.a ujO;
  
  public i(e parame, c.a parama, String paramString, String[] paramArrayOfString)
  {
    this.dXw = parame;
    this.ujO = parama;
    parama = this.ujO;
    if (bk.bl(this.ujO.ujM)) {}
    int i;
    for (parame = "rowid";; parame = this.ujO.ujM)
    {
      parama.ujM = parame;
      this.table = paramString;
      parame = a(this.ujO, getTableName(), this.dXw);
      i = 0;
      while (i < parame.size())
      {
        if (!this.dXw.gk(this.table, (String)parame.get(i))) {
          y.i("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { this.table, parame.get(i) });
        }
        i += 1;
      }
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      i = j;
      while (i < paramArrayOfString.length)
      {
        this.dXw.gk(this.table, paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  public static String a(c.a parama, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + paramString + " ( ");
    localStringBuilder.append(parama.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  private static StringBuilder a(ContentValues paramContentValues, String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      localStringBuilder.append(str + " = ? AND ");
      if (paramContentValues.get(str) == null) {
        return null;
      }
      i += 1;
    }
    localStringBuilder.append(" 1=1");
    return localStringBuilder;
  }
  
  public static List<String> a(c.a parama, String paramString, e parame)
  {
    ArrayList localArrayList = new ArrayList();
    if ((parame == null) || (paramString == null))
    {
      if (parame == null) {}
      for (boolean bool = true;; bool = false)
      {
        y.e("MicroMsg.SDK.MAutoStorage", "dk getUpdateSQLs db==null :%b  table:%s", new Object[] { Boolean.valueOf(bool), paramString });
        return localArrayList;
      }
    }
    Object localObject1 = parame.a("PRAGMA table_info( " + paramString + " )", new String[0], 2);
    if (localObject1 == null) {
      return localArrayList;
    }
    parame = new HashMap();
    int i = ((Cursor)localObject1).getColumnIndex("name");
    int j = ((Cursor)localObject1).getColumnIndex("type");
    while (((Cursor)localObject1).moveToNext()) {
      parame.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
    }
    ((Cursor)localObject1).close();
    parama = parama.ujN.entrySet().iterator();
    while (parama.hasNext())
    {
      Object localObject2 = (Map.Entry)parama.next();
      localObject1 = (String)((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        String str = (String)parame.get(localObject2);
        if (str == null)
        {
          localArrayList.add("ALTER TABLE " + paramString + " ADD COLUMN " + (String)localObject2 + " " + (String)localObject1 + ";");
          parame.remove(localObject2);
        }
        else if (!((String)localObject1).toLowerCase().startsWith(str.toLowerCase()))
        {
          y.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + (String)localObject2 + ", " + str + "<o-n>" + (String)localObject1);
          parame.remove(localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private static String[] a(String[] paramArrayOfString, ContentValues paramContentValues)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = bk.pm(paramContentValues.getAsString(paramArrayOfString[i]));
      i += 1;
    }
    return arrayOfString;
  }
  
  private void aan(String paramString)
  {
    y.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
  }
  
  private void aao(String paramString)
  {
    y.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + paramString);
  }
  
  private boolean b(ContentValues paramContentValues)
  {
    Cursor localCursor = this.dXw.query(getTableName(), this.ujO.columns, this.ujO.ujM + " = ?", new String[] { bk.pm(paramContentValues.getAsString(this.ujO.ujM)) }, null, null, null);
    boolean bool = c.a(paramContentValues, localCursor);
    localCursor.close();
    return bool;
  }
  
  public boolean a(long paramLong, T paramT)
  {
    return a(paramLong, paramT, true);
  }
  
  public final boolean a(long paramLong, T paramT, boolean paramBoolean)
  {
    paramT = paramT.vf();
    boolean bool2;
    if ((paramT == null) || (paramT.size() <= 0))
    {
      aao("update failed, value.size <= 0");
      bool2 = false;
      return bool2;
    }
    Cursor localCursor = this.dXw.query(getTableName(), this.ujO.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null);
    if (c.a(paramT, localCursor))
    {
      localCursor.close();
      aan("no need replace , fields no change");
      return true;
    }
    localCursor.close();
    if (this.dXw.update(getTableName(), paramT, "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!paramBoolean) {
        break;
      }
      doNotify();
      return bool1;
    }
  }
  
  public boolean a(T paramT)
  {
    boolean bool;
    ContentValues localContentValues;
    int j;
    int k;
    if (!bk.bl(this.ujO.ujM))
    {
      bool = true;
      Assert.assertTrue("replace primaryKey == null", bool);
      localContentValues = paramT.vf();
      if (localContentValues != null)
      {
        j = localContentValues.size();
        k = paramT.rM().ujL.length;
        if (!localContentValues.containsKey("rowid")) {
          break label86;
        }
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      if (j == i + k) {
        break label91;
      }
      aao("replace failed, cv.size() != item.fields().length");
      return false;
      bool = false;
      break;
    }
    label91:
    if (b(localContentValues))
    {
      aan("no need replace , fields no change");
      return true;
    }
    if (this.dXw.replace(getTableName(), this.ujO.ujM, localContentValues) > 0L)
    {
      aam(this.ujO.ujM);
      return true;
    }
    aao("replace failed");
    return false;
  }
  
  public boolean a(T paramT, boolean paramBoolean)
  {
    ContentValues localContentValues = paramT.vf();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      aao("insert failed, value.size <= 0");
      return false;
    }
    paramT.ujK = this.dXw.insert(getTableName(), this.ujO.ujM, localContentValues);
    if (paramT.ujK <= 0L)
    {
      aao("insert failed");
      return false;
    }
    localContentValues.put("rowid", Long.valueOf(paramT.ujK));
    if (paramBoolean) {
      aam(localContentValues.getAsString(this.ujO.ujM));
    }
    return true;
  }
  
  public boolean a(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramT = paramT.vf();
    if ((paramT == null) || (paramT.size() <= 0)) {
      aao("delete failed, value.size <= 0");
    }
    do
    {
      do
      {
        return bool2;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          break;
        }
        aan("delete with primary key");
        if (this.dXw.delete(getTableName(), this.ujO.ujM + " = ?", new String[] { bk.pm(paramT.getAsString(this.ujO.ujM)) }) > 0) {
          bool1 = true;
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (!paramBoolean);
    doNotify();
    return bool1;
    StringBuilder localStringBuilder = a(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      aao("delete failed, check keys failed");
      return false;
    }
    if ((this.dXw.delete(getTableName(), localStringBuilder.toString(), a(paramVarArgs, paramT)) > 0) && (paramBoolean))
    {
      aam(this.ujO.ujM);
      return true;
    }
    aao("delete failed");
    return false;
  }
  
  public boolean a(T paramT, String... paramVarArgs)
  {
    return a(paramT, true, paramVarArgs);
  }
  
  public Cursor aAn()
  {
    return this.dXw.query(getTableName(), this.ujO.columns, null, null, null, null, null);
  }
  
  public final boolean b(long paramLong, T paramT)
  {
    Cursor localCursor = this.dXw.a(getTableName(), this.ujO.columns, "rowid = ?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      paramT.d(localCursor);
      localCursor.close();
      return true;
    }
    localCursor.close();
    return false;
  }
  
  public boolean b(T paramT)
  {
    return a(paramT, true);
  }
  
  public boolean b(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramT = paramT.vf();
    if ((paramT == null) || (paramT.size() <= 0)) {
      aao("update failed, value.size <= 0");
    }
    do
    {
      do
      {
        return bool2;
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          break;
        }
        aan("update with primary key");
        if (b(paramT))
        {
          aan("no need replace , fields no change");
          return true;
        }
        if (this.dXw.update(getTableName(), paramT, this.ujO.ujM + " = ?", new String[] { bk.pm(paramT.getAsString(this.ujO.ujM)) }) > 0) {
          bool1 = true;
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (!paramBoolean);
    doNotify();
    return bool1;
    StringBuilder localStringBuilder = a(paramT, paramVarArgs);
    if (localStringBuilder == null)
    {
      aao("update failed, check keys failed");
      return false;
    }
    if (this.dXw.update(getTableName(), paramT, localStringBuilder.toString(), a(paramVarArgs, paramT)) > 0)
    {
      if (paramBoolean) {
        aam(paramT.getAsString(this.ujO.ujM));
      }
      return true;
    }
    aao("update failed");
    return false;
  }
  
  public boolean b(T paramT, String... paramVarArgs)
  {
    ContentValues localContentValues = paramT.vf();
    if ((localContentValues == null) || (localContentValues.size() <= 0))
    {
      aao("get failed, value.size <= 0");
      return false;
    }
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0))
    {
      aan("get with primary key");
      paramVarArgs = this.dXw.a(getTableName(), this.ujO.columns, this.ujO.ujM + " = ?", new String[] { bk.pm(localContentValues.getAsString(this.ujO.ujM)) }, null, null, null, 2);
      if (paramVarArgs.moveToFirst())
      {
        paramT.d(paramVarArgs);
        paramVarArgs.close();
        return true;
      }
      paramVarArgs.close();
      return false;
    }
    StringBuilder localStringBuilder = a(localContentValues, paramVarArgs);
    if (localStringBuilder == null)
    {
      aao("get failed, check keys failed");
      return false;
    }
    paramVarArgs = this.dXw.a(getTableName(), this.ujO.columns, localStringBuilder.toString(), a(paramVarArgs, localContentValues), null, null, null, 2);
    if (paramVarArgs.moveToFirst())
    {
      paramT.d(paramVarArgs);
      paramVarArgs.close();
      return true;
    }
    paramVarArgs.close();
    aan("get failed, not found");
    return false;
  }
  
  public boolean c(T paramT, String... paramVarArgs)
  {
    return b(paramT, true, paramVarArgs);
  }
  
  public boolean delete(long paramLong)
  {
    boolean bool = true;
    if (this.dXw.delete(getTableName(), "rowid = ?", new String[] { String.valueOf(paramLong) }) > 0) {}
    for (;;)
    {
      if (bool) {
        doNotify();
      }
      return bool;
      bool = false;
    }
  }
  
  public int getCount()
  {
    int i = 0;
    Cursor localCursor = rawQuery("select count(*) from " + getTableName(), new String[0]);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      i = localCursor.getInt(0);
      localCursor.close();
    }
    return i;
  }
  
  public String getTableName()
  {
    return this.table;
  }
  
  public final boolean gk(String paramString1, String paramString2)
  {
    if (paramString1.length() == 0)
    {
      aao("null or nill table");
      return false;
    }
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      aao("null or nill sql");
      return false;
    }
    return this.dXw.gk(paramString1, paramString2);
  }
  
  public final Cursor rawQuery(String paramString, String... paramVarArgs)
  {
    return this.dXw.rawQuery(paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.i
 * JD-Core Version:    0.7.0.1
 */