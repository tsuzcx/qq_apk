package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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
  public static final Pattern FCa;
  f FCb;
  String FCc = "";
  public boolean FCd = false;
  String FCe = "";
  public boolean FCf = false;
  private String errMsg = "";
  private boolean isNew = false;
  String key;
  
  static
  {
    AppMethodBeat.i(133323);
    FCa = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    AppMethodBeat.o(133323);
  }
  
  private static void a(f paramf)
  {
    AppMethodBeat.i(133319);
    if (paramf.FCl != null) {}
    for (paramf = paramf.FCl;; paramf = paramf.FCm)
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
  
  private boolean a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(133321);
    if (this.FCb != null)
    {
      paramString1 = new AssertionError();
      AppMethodBeat.o(133321);
      throw paramString1;
    }
    boolean bool;
    if (!i.eK(paramString1)) {
      bool = true;
    }
    int i;
    for (;;)
    {
      this.isNew = bool;
      i = 0;
      Iterator localIterator = IMEISave.eNY().iterator();
      label56:
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.key = com.tencent.mm.b.g.getMessageDigest((str + paramLong).getBytes()).substring(0, 7);
        try
        {
          this.FCb = f.E(paramString1, this.key, paramBoolean);
          a(this.FCb);
          if (!q.cG(true).equals(str))
          {
            ad.i("MicroMsg.DBInit", "IMEI changed detected: ".concat(String.valueOf(str)));
            l.WE().set(258, str);
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, 5L, 1L, false);
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
            break label56;
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
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, i, 1L, true);
        f.aJJ(paramString1);
        if (paramString1.endsWith("EnMicroMsg.db")) {
          f.aJJ(com.tencent.mm.kernel.g.afB().gcW + "dbback/EnMicroMsg.db");
        }
        try
        {
          this.key = com.tencent.mm.b.g.getMessageDigest((q.cG(true) + paramLong).getBytes()).substring(0, 7);
          this.FCb = f.E(paramString1, this.key, paramBoolean);
          a(this.FCb);
          this.isNew = true;
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, 6L, 1L, false);
          AppMethodBeat.o(133321);
          return true;
        }
        catch (SQLiteException paramString1)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, 7L, 1L, false);
        }
        if (f.eOc()) {
          i = 43;
        } else {
          i = 41;
        }
      }
    }
    for (;;)
    {
      if (this.FCb != null)
      {
        this.FCb.close();
        this.FCb = null;
      }
      this.key = null;
      AppMethodBeat.o(133321);
      return false;
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        if (!i.eK(paramString2)) {}
        for (bool = true;; bool = false)
        {
          this.isNew = bool;
          try
          {
            this.FCb = f.E(paramString2, this.key, paramBoolean);
            a(this.FCb);
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, 6L, 1L, false);
            AppMethodBeat.o(133321);
            return true;
          }
          catch (SQLiteException paramString1)
          {
            com.tencent.mm.plugin.report.e.vIY.idkeyStat(181L, 7L, 1L, false);
          }
        }
      }
    }
  }
  
  private boolean a(HashMap<Integer, h.b> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133322);
    if (this.FCb == null)
    {
      AppMethodBeat.o(133322);
      return false;
    }
    if (paramHashMap == null) {}
    Object localObject3;
    for (int i = -1;; i = paramHashMap.size())
    {
      ad.d("MicroMsg.DBInit", "createtables checkCreateIni:%b  tables:%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      localObject1 = "";
      if (!paramBoolean1) {
        break label345;
      }
      this.FCc = (this.FCb.getPath() + ".ini");
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
          ad.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", new Object[] { localObject3.getClass().toString() });
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
    Object localObject2 = com.tencent.mm.b.g.getMessageDigest(((StringBuilder)localObject1).toString().getBytes());
    Object localObject1 = localObject2;
    if (!paramBoolean2)
    {
      localObject3 = com.tencent.mm.sdk.e.a.getValue(this.FCc, "createmd5");
      localObject1 = localObject2;
      if (!bt.isNullOrNil((String)localObject3))
      {
        localObject1 = localObject2;
        if (((String)localObject2).equals(localObject3))
        {
          ad.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", new Object[] { this.FCb.getPath() });
          AppMethodBeat.o(133322);
          return true;
        }
      }
    }
    label345:
    this.FCb.execSQL("pragma auto_vacuum = 0 ");
    localObject2 = new f.a();
    this.FCb.beginTransaction();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.values().iterator();
      i = 0;
      String str;
      label579:
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
            break label579;
          }
          str = localObject3[j];
          try
          {
            this.FCb.execSQL(str);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Matcher localMatcher = FCa.matcher(str);
              if ((localMatcher != null) && (localMatcher.matches())) {
                Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
              } else {
                ad.w("MicroMsg.DBInit", "CreateTable failed:[" + str + "][" + localException.getMessage() + "]");
              }
            }
          }
          j += 1;
        }
      }
    }
    int j = 0;
    long l = ((f.a)localObject2).XK();
    this.FCb.endTransaction();
    ad.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(l), Long.valueOf(((f.a)localObject2).XK()), Integer.valueOf(j) });
    if (paramBoolean1) {
      com.tencent.mm.sdk.e.a.aS(this.FCc, "createmd5", (String)localObject1);
    }
    AppMethodBeat.o(133322);
    return true;
  }
  
  private void li(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133312);
    HashSet localHashSet = new HashSet();
    Object localObject = this.FCb.a("select * from " + paramString1 + " limit 1 ", null, 0);
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
    Cursor localCursor = this.FCb.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
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
    this.FCb.execSQL(paramString1);
    AppMethodBeat.o(133312);
  }
  
  private List<String> lj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133314);
    ArrayList localArrayList = new ArrayList();
    if (this.FCb == null)
    {
      AppMethodBeat.o(133314);
      return localArrayList;
    }
    Object localObject1 = this.FCb.a("PRAGMA table_info( " + paramString1 + " )", null, 0);
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
    Object localObject2 = this.FCb.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
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
          ad.e("MicroMsg.DBInit", "conflicting alter table on column: " + str1 + ", " + str2 + "<o-n>" + (String)localObject3);
          paramString1.remove(str1);
        }
      }
    }
    AppMethodBeat.o(133314);
    return localArrayList;
  }
  
  private boolean lk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133315);
    Cursor localCursor = this.FCb.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(133315);
      return false;
    }
    try
    {
      if (bt.isNullOrNil(paramString2)) {
        this.FCb.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY ''");
      }
      while (!r(localCursor))
      {
        AppMethodBeat.o(133315);
        return false;
        this.FCb.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY '" + paramString2 + "'");
      }
      this.FCb.beginTransaction();
    }
    catch (SQLiteDatabaseCorruptException paramString2)
    {
      ad.e("MicroMsg.DBInit", "Attached database is corrupted: ".concat(String.valueOf(paramString1)));
      i.deleteFile(paramString1);
      AppMethodBeat.o(133315);
      throw paramString2;
    }
    int i = 0;
    int j;
    if (i < localCursor.getCount())
    {
      localCursor.moveToPosition(i);
      paramString1 = this.FCb.a("select * from old.sqlite_master where tbl_name = '" + localCursor.getString(0) + "'", null, 0);
      if (paramString1 == null) {
        break label463;
      }
      j = paramString1.getCount();
      paramString1.close();
    }
    for (;;)
    {
      if (j == 0) {
        ad.w("MicroMsg.DBInit", "In old db not found :" + localCursor.getString(0));
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          paramString1 = lj("old." + localCursor.getString(0), localCursor.getString(0)).iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            this.FCb.execSQL(paramString2);
          }
        }
        catch (Exception paramString1)
        {
          ad.w("MicroMsg.DBInit", "Insertselect FAILED :" + localCursor.getString(0));
        }
        li("old." + localCursor.getString(0), localCursor.getString(0));
      }
      this.FCb.endTransaction();
      localCursor.close();
      this.FCb.execSQL("DETACH DATABASE old;");
      AppMethodBeat.o(133315);
      return true;
      label463:
      j = 0;
    }
  }
  
  private boolean ll(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133318);
    if (lk(paramString1, paramString2))
    {
      ad.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", new Object[] { paramString1 });
      ad.i("MicroMsg.DBInit", "delete result :%b", new Object[] { Boolean.valueOf(i.deleteFile(paramString1)) });
      AppMethodBeat.o(133318);
      return true;
    }
    ad.i("MicroMsg.DBInit", "system transfer fail path %s", new Object[] { paramString1 });
    AppMethodBeat.o(133318);
    return false;
  }
  
  private boolean r(Cursor paramCursor)
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
    paramCursor = this.FCb.a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
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
    this.FCb.beginTransaction();
    paramCursor = ((HashSet)localObject).iterator();
    while (paramCursor.hasNext())
    {
      localObject = (String)paramCursor.next();
      if (!localHashSet.contains(localObject))
      {
        localObject = this.FCb.a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + (String)localObject + "'", null, 0);
        if (localObject != null)
        {
          String str = ((Cursor)localObject).getString(0);
          this.FCb.execSQL(str);
          ((Cursor)localObject).close();
        }
      }
    }
    this.FCb.endTransaction();
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
    if (!bt.isNullOrNil(paramString2))
    {
      bool1 = true;
      Assert.assertTrue("create SqliteDB enDbCachePath == null ", bool1);
      this.FCe = (paramString2 + ".errreport");
      if (this.FCb != null)
      {
        this.FCb.close();
        this.FCb = null;
      }
      boolean bool2 = i.eK(paramString2);
      bool3 = i.eK(paramString1);
      bool4 = i.eK(paramString3);
      if ((bool2) || (!bool3)) {
        break label264;
      }
      i = 1;
      this.FCd = a(paramString2, paramLong, f.eOb(), paramString3);
      Boolean localBoolean = Boolean.TRUE;
      boolean bool5 = this.FCd;
      if (this.FCb == null) {
        break label270;
      }
      bool1 = true;
      label134:
      ad.i("MicroMsg.DBInit", "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s", new Object[] { paramString2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), localBoolean, Boolean.valueOf(bool5), Boolean.valueOf(bool1), Thread.currentThread().getName() });
      if ((this.FCb == null) || (this.FCb.getPath().equals(paramString3)) || (!bool4)) {
        break label422;
      }
      j = 1;
      ad.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
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
        this.FCf = true;
      }
      if (j != 0)
      {
        this.key = com.tencent.mm.b.g.getMessageDigest((q.cG(true) + paramLong).getBytes()).substring(0, 7);
        ll(paramString3, this.key);
        com.tencent.mm.blink.a.v(201L, 1L);
      }
      if (i != 0)
      {
        paramBoolean = ll(paramString1, "");
        com.tencent.mm.blink.a.v(200L, 1L);
        AppMethodBeat.o(133317);
        return paramBoolean;
      }
      if (this.FCb != null)
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
  
  public final boolean a(String paramString, HashMap<Integer, h.b> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(133316);
    if (this.FCb != null)
    {
      this.FCb.close();
      this.FCb = null;
    }
    boolean bool = i.eK(paramString);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool), paramString });
        this.FCb = f.cA(paramString, paramBoolean);
        if (!bool)
        {
          paramBoolean = true;
          if (a(paramHashMap, true, paramBoolean)) {
            break;
          }
          if (this.FCb != null)
          {
            this.FCb.close();
            this.FCb = null;
          }
          AppMethodBeat.o(133316);
          return false;
        }
      }
      catch (SQLiteException paramString)
      {
        AppMethodBeat.o(133316);
        return false;
      }
      paramBoolean = false;
    }
    AppMethodBeat.o(133316);
    return true;
  }
  
  public final String getError()
  {
    AppMethodBeat.i(133311);
    if ((bt.isNullOrNil(this.errMsg)) || (bt.isNullOrNil(this.FCe)))
    {
      AppMethodBeat.o(133311);
      return "";
    }
    if (!bt.isNullOrNil(com.tencent.mm.sdk.e.a.getValue(this.FCe, "Reported")))
    {
      AppMethodBeat.o(133311);
      return "";
    }
    com.tencent.mm.sdk.e.a.aS(this.FCe, "Reported", "true");
    String str = this.errMsg;
    AppMethodBeat.o(133311);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a
 * JD-Core Version:    0.7.0.1
 */