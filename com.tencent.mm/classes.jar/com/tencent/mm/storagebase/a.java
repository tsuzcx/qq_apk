package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.vfs.u;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a
{
  public static final Pattern VIU;
  String VIV = "";
  public boolean VIW = false;
  String VIX = "";
  public boolean VIY = false;
  private String errMsg = "";
  private boolean isNew = false;
  String key;
  f mEV;
  
  static
  {
    AppMethodBeat.i(133323);
    VIU = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    AppMethodBeat.o(133323);
  }
  
  private boolean a(HashMap<Integer, h.b> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133322);
    if (this.mEV == null)
    {
      AppMethodBeat.o(133322);
      return false;
    }
    if (paramHashMap == null) {}
    Object localObject3;
    for (int i = -1;; i = paramHashMap.size())
    {
      Log.d("MicroMsg.DBInit", "createtables checkCreateIni:%b  tables:%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      localObject1 = "";
      if (!paramBoolean1) {
        break label336;
      }
      this.VIV = (this.mEV.getPath() + ".ini");
      localObject1 = new StringBuilder();
      if (paramHashMap == null) {
        break;
      }
      localObject2 = paramHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h.b)((Iterator)localObject2).next();
        if (((h.b)localObject3).getSQLs() == null)
        {
          Log.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", new Object[] { localObject3.getClass().toString() });
          Assert.assertTrue("factory.getSQLs() is null:" + localObject3.getClass().toString(), false);
        }
        localObject3 = ((h.b)localObject3).getSQLs();
        j = localObject3.length;
        i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject1).append(localObject3[i].hashCode());
          i += 1;
        }
      }
    }
    Object localObject2 = g.getMessageDigest(((StringBuilder)localObject1).toString().getBytes());
    Object localObject1 = localObject2;
    if (!paramBoolean2)
    {
      localObject3 = ConfigFile.getValue(this.VIV, "createmd5");
      localObject1 = localObject2;
      if (!Util.isNullOrNil((String)localObject3))
      {
        localObject1 = localObject2;
        if (((String)localObject2).equals(localObject3))
        {
          Log.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", new Object[] { this.mEV.getPath() });
          AppMethodBeat.o(133322);
          return true;
        }
      }
    }
    label336:
    this.mEV.execSQL("pragma auto_vacuum = 0 ");
    localObject2 = new f.a();
    this.mEV.beginTransaction();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.values().iterator();
      i = 0;
      String str;
      label563:
      for (;;)
      {
        j = i;
        if (!paramHashMap.hasNext()) {
          break;
        }
        localObject3 = ((h.b)paramHashMap.next()).getSQLs();
        int k = localObject3.length;
        j = 0;
        for (;;)
        {
          if (j >= k) {
            break label563;
          }
          str = localObject3[j];
          try
          {
            this.mEV.execSQL(str);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Matcher localMatcher = VIU.matcher(str);
              if ((localMatcher != null) && (localMatcher.matches())) {
                Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
              } else {
                Log.w("MicroMsg.DBInit", "CreateTable failed:[" + str + "][" + localException.getMessage() + "]");
              }
            }
          }
          j += 1;
        }
      }
    }
    int j = 0;
    long l = ((f.a)localObject2).avE();
    this.mEV.endTransaction();
    Log.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(l), Long.valueOf(((f.a)localObject2).avE()), Integer.valueOf(j) });
    if (paramBoolean1) {
      ConfigFile.saveValue(this.VIV, "createmd5", (String)localObject1);
    }
    AppMethodBeat.o(133322);
    return true;
  }
  
  private boolean b(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(133321);
    if (this.mEV != null)
    {
      paramString1 = new AssertionError();
      AppMethodBeat.o(133321);
      throw paramString1;
    }
    boolean bool;
    if (!u.agG(paramString1)) {
      bool = true;
    }
    int i;
    for (;;)
    {
      this.isNew = bool;
      i = 0;
      Iterator localIterator = IMEISave.hBQ().iterator();
      label58:
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.key = g.getMessageDigest((str + paramLong).getBytes()).substring(0, 7);
        try
        {
          this.mEV = f.G(paramString1, this.key, paramBoolean);
          c(this.mEV);
          if (!q.dR(true).equals(str))
          {
            Log.i("MicroMsg.DBInit", "IMEI changed detected: ".concat(String.valueOf(str)));
            l.auq().i(258, str);
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 5L, 1L, false);
          }
          AppMethodBeat.o(133321);
          return true;
          bool = false;
        }
        catch (SQLiteException localSQLiteException)
        {
          if ((localSQLiteException instanceof SQLiteDatabaseCorruptException))
          {
            i = 1;
            break label58;
          }
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      if (!paramBoolean) {
        i = 42;
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, i, 1L, true);
        f.bxY(paramString1);
        if (paramString1.endsWith("EnMicroMsg.db")) {
          f.bxY(h.aHG().kcB + "dbback/EnMicroMsg.db");
        }
        try
        {
          this.key = g.getMessageDigest((q.dR(true) + paramLong).getBytes()).substring(0, 7);
          this.mEV = f.G(paramString1, this.key, paramBoolean);
          c(this.mEV);
          this.isNew = true;
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 6L, 1L, false);
          AppMethodBeat.o(133321);
          return true;
        }
        catch (SQLiteException paramString1)
        {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 7L, 1L, false);
        }
        if (f.hBU()) {
          i = 43;
        } else {
          i = 41;
        }
      }
    }
    for (;;)
    {
      if (this.mEV != null)
      {
        this.mEV.close();
        this.mEV = null;
      }
      this.key = null;
      AppMethodBeat.o(133321);
      return false;
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        if (!u.agG(paramString2)) {}
        for (bool = true;; bool = false)
        {
          this.isNew = bool;
          try
          {
            this.mEV = f.G(paramString2, this.key, paramBoolean);
            c(this.mEV);
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 6L, 1L, false);
            AppMethodBeat.o(133321);
            return true;
          }
          catch (SQLiteException paramString1)
          {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(181L, 7L, 1L, false);
          }
        }
      }
    }
  }
  
  private static void c(f paramf)
  {
    AppMethodBeat.i(133319);
    if (paramf.VJf != null) {}
    for (paramf = paramf.VJf;; paramf = paramf.VJg)
    {
      paramf = paramf.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
      if (paramf.moveToFirst()) {
        break;
      }
      paramf = new SQLiteException("Cannot get count for sqlite_master");
      AppMethodBeat.o(133319);
      throw paramf;
    }
    paramf.close();
    AppMethodBeat.o(133319);
  }
  
  private void nQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133312);
    HashSet localHashSet = new HashSet();
    Object localObject = this.mEV.rawQuery("select * from " + paramString1 + " limit 1 ", null, 0);
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(133312);
      return;
    }
    ((Cursor)localObject).moveToFirst();
    int i = 0;
    while (i < ((Cursor)localObject).getColumnCount())
    {
      localHashSet.add(((Cursor)localObject).getColumnName(i));
      i += 1;
    }
    ((Cursor)localObject).close();
    Cursor localCursor = this.mEV.rawQuery("PRAGMA table_info( " + paramString2 + " )", null, 0);
    localObject = "";
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("name"));
      if (localHashSet.contains(str))
      {
        localObject = (String)localObject + str;
        localObject = (String)localObject + ",";
      }
    }
    localCursor.close();
    localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    paramString1 = "insert into " + paramString2 + "(" + (String)localObject + ") select " + (String)localObject + " from " + paramString1 + ";";
    this.mEV.execSQL(paramString1);
    AppMethodBeat.o(133312);
  }
  
  private List<String> nR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133314);
    ArrayList localArrayList = new ArrayList();
    if (this.mEV == null)
    {
      AppMethodBeat.o(133314);
      return localArrayList;
    }
    Object localObject1 = this.mEV.rawQuery("PRAGMA table_info( " + paramString1 + " )", null, 0);
    if (localObject1 == null)
    {
      AppMethodBeat.o(133314);
      return localArrayList;
    }
    paramString1 = new HashMap();
    int i = ((Cursor)localObject1).getColumnIndex("name");
    int j = ((Cursor)localObject1).getColumnIndex("type");
    while (((Cursor)localObject1).moveToNext()) {
      paramString1.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
    }
    ((Cursor)localObject1).close();
    Object localObject2 = this.mEV.rawQuery("PRAGMA table_info( " + paramString2 + " )", null, 0);
    if (localObject2 == null)
    {
      AppMethodBeat.o(133314);
      return localArrayList;
    }
    localObject1 = new HashMap();
    i = ((Cursor)localObject2).getColumnIndex("name");
    j = ((Cursor)localObject2).getColumnIndex("type");
    while (((Cursor)localObject2).moveToNext()) {
      paramString1.put(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashSet(paramString1.entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      String str1 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      if ((localObject3 != null) && (((String)localObject3).length() > 0))
      {
        String str2 = (String)((Map)localObject1).get(str1);
        if (str2 == null)
        {
          localArrayList.add("ALTER TABLE " + paramString2 + " ADD COLUMN " + str1 + " " + (String)localObject3 + ";");
          paramString1.remove(str1);
        }
        else if (!((String)localObject3).toLowerCase().startsWith(str2.toLowerCase()))
        {
          Log.e("MicroMsg.DBInit", "conflicting alter table on column: " + str1 + ", " + str2 + "<o-n>" + (String)localObject3);
          paramString1.remove(str1);
        }
      }
    }
    AppMethodBeat.o(133314);
    return localArrayList;
  }
  
  private boolean nS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133315);
    Cursor localCursor = this.mEV.rawQuery("select DISTINCT  tbl_name from sqlite_master;", null, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(133315);
      return false;
    }
    try
    {
      if (Util.isNullOrNil(paramString2)) {
        this.mEV.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY ''");
      }
      while (!t(localCursor))
      {
        AppMethodBeat.o(133315);
        return false;
        this.mEV.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY '" + paramString2 + "'");
      }
      this.mEV.beginTransaction();
    }
    catch (SQLiteDatabaseCorruptException paramString2)
    {
      Log.e("MicroMsg.DBInit", "Attached database is corrupted: ".concat(String.valueOf(paramString1)));
      u.deleteFile(paramString1);
      AppMethodBeat.o(133315);
      throw paramString2;
    }
    int i = 0;
    int j;
    if (i < localCursor.getCount())
    {
      localCursor.moveToPosition(i);
      paramString1 = this.mEV.rawQuery("select * from old.sqlite_master where tbl_name = '" + localCursor.getString(0) + "'", null, 0);
      if (paramString1 == null) {
        break label463;
      }
      j = paramString1.getCount();
      paramString1.close();
    }
    for (;;)
    {
      if (j == 0) {
        Log.w("MicroMsg.DBInit", "In old db not found :" + localCursor.getString(0));
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          paramString1 = nR("old." + localCursor.getString(0), localCursor.getString(0)).iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            this.mEV.execSQL(paramString2);
          }
        }
        catch (Exception paramString1)
        {
          Log.w("MicroMsg.DBInit", "Insertselect FAILED :" + localCursor.getString(0));
        }
        nQ("old." + localCursor.getString(0), localCursor.getString(0));
      }
      this.mEV.endTransaction();
      localCursor.close();
      this.mEV.execSQL("DETACH DATABASE old;");
      AppMethodBeat.o(133315);
      return true;
      label463:
      j = 0;
    }
  }
  
  private boolean nT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133318);
    if (nS(paramString1, paramString2))
    {
      Log.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", new Object[] { paramString1 });
      Log.i("MicroMsg.DBInit", "delete result :%b", new Object[] { Boolean.valueOf(u.deleteFile(paramString1)) });
      AppMethodBeat.o(133318);
      return true;
    }
    Log.i("MicroMsg.DBInit", "system transfer fail path %s", new Object[] { paramString1 });
    AppMethodBeat.o(133318);
    return false;
  }
  
  private boolean t(Cursor paramCursor)
  {
    AppMethodBeat.i(133313);
    HashSet localHashSet = new HashSet();
    Object localObject = new HashSet();
    int i = 0;
    while (i < paramCursor.getCount())
    {
      paramCursor.moveToPosition(i);
      localHashSet.add(paramCursor.getString(0));
      i += 1;
    }
    paramCursor = this.mEV.rawQuery("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
    if (paramCursor == null)
    {
      AppMethodBeat.o(133313);
      return false;
    }
    i = 0;
    while (i < paramCursor.getCount())
    {
      paramCursor.moveToPosition(i);
      ((HashSet)localObject).add(paramCursor.getString(0));
      i += 1;
    }
    paramCursor.close();
    this.mEV.beginTransaction();
    paramCursor = ((HashSet)localObject).iterator();
    while (paramCursor.hasNext())
    {
      localObject = (String)paramCursor.next();
      if (!localHashSet.contains(localObject))
      {
        localObject = this.mEV.rawQuery("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + (String)localObject + "'", null, 0);
        if (localObject != null)
        {
          String str = ((Cursor)localObject).getString(0);
          this.mEV.execSQL(str);
          ((Cursor)localObject).close();
        }
      }
    }
    this.mEV.endTransaction();
    AppMethodBeat.o(133313);
    return true;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, long paramLong, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133317);
    boolean bool1;
    boolean bool3;
    boolean bool4;
    int i;
    label98:
    int j;
    if (!Util.isNullOrNil(paramString2))
    {
      bool1 = true;
      Assert.assertTrue("create SqliteDB enDbCachePath == null ", bool1);
      this.VIX = (paramString2 + ".errreport");
      if (this.mEV != null)
      {
        this.mEV.close();
        this.mEV = null;
      }
      boolean bool2 = u.agG(paramString2);
      bool3 = u.agG(paramString1);
      bool4 = u.agG(paramString3);
      if ((bool2) || (!bool3)) {
        break label264;
      }
      i = 1;
      this.VIW = b(paramString2, paramLong, f.hBT(), paramString3);
      Boolean localBoolean = Boolean.TRUE;
      boolean bool5 = this.VIW;
      if (this.mEV == null) {
        break label270;
      }
      bool1 = true;
      label134:
      Log.i("MicroMsg.DBInit", "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s", new Object[] { paramString2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), localBoolean, Boolean.valueOf(bool5), Boolean.valueOf(bool1), Thread.currentThread().getName() });
      if ((this.mEV == null) || (this.mEV.getPath().equals(paramString3)) || (!bool4)) {
        break label422;
      }
      j = 1;
      Log.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
    }
    for (;;)
    {
      if (!a(paramHashMap, paramBoolean, this.isNew))
      {
        AppMethodBeat.o(133317);
        return false;
        bool1 = false;
        break;
        label264:
        i = 0;
        break label98;
        label270:
        bool1 = false;
        break label134;
      }
      if ((!bool3) && (!bool4))
      {
        AppMethodBeat.o(133317);
        return true;
      }
      if ((j != 0) || (i != 0)) {
        this.VIY = true;
      }
      if (j != 0)
      {
        this.key = g.getMessageDigest((q.dR(true) + paramLong).getBytes()).substring(0, 7);
        nT(paramString3, this.key);
        com.tencent.mm.blink.a.s(201L, 1L);
      }
      if (i != 0)
      {
        paramBoolean = nT(paramString1, "");
        com.tencent.mm.blink.a.s(200L, 1L);
        AppMethodBeat.o(133317);
        return paramBoolean;
      }
      if (this.mEV != null)
      {
        AppMethodBeat.o(133317);
        return true;
      }
      AppMethodBeat.o(133317);
      return false;
      label422:
      j = 0;
    }
  }
  
  public final boolean a(String paramString, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(205783);
    if (this.mEV != null)
    {
      this.mEV.close();
      this.mEV = null;
    }
    for (paramBoolean1 = u.agG(paramString);; paramBoolean1 = false) {
      try
      {
        Log.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", new Object[] { Boolean.TRUE, Boolean.valueOf(paramBoolean1), paramString });
        this.mEV = f.dv(paramString, paramBoolean2);
        if (!paramBoolean1)
        {
          paramBoolean1 = true;
          if (a(paramHashMap, true, paramBoolean1)) {
            break;
          }
          if (this.mEV != null)
          {
            this.mEV.close();
            this.mEV = null;
          }
          AppMethodBeat.o(205783);
          return false;
        }
      }
      catch (SQLiteException paramString)
      {
        AppMethodBeat.o(205783);
        return false;
      }
    }
    AppMethodBeat.o(205783);
    return true;
  }
  
  public final String getError()
  {
    AppMethodBeat.i(133311);
    if ((Util.isNullOrNil(this.errMsg)) || (Util.isNullOrNil(this.VIX)))
    {
      AppMethodBeat.o(133311);
      return "";
    }
    if (!Util.isNullOrNil(ConfigFile.getValue(this.VIX, "Reported")))
    {
      AppMethodBeat.o(133311);
      return "";
    }
    ConfigFile.saveValue(this.VIX, "Reported", "true");
    String str = this.errMsg;
    AppMethodBeat.o(133311);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storagebase.a
 * JD-Core Version:    0.7.0.1
 */