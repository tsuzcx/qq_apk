package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
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
  public static final Pattern JiZ;
  String Jja = "";
  public boolean Jjb = false;
  String Jjc = "";
  public boolean Jjd = false;
  private String errMsg = "";
  f iQT;
  private boolean isNew = false;
  String key;
  
  static
  {
    AppMethodBeat.i(133323);
    JiZ = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    AppMethodBeat.o(133323);
  }
  
  private boolean a(HashMap<Integer, h.b> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(133322);
    if (this.iQT == null)
    {
      AppMethodBeat.o(133322);
      return false;
    }
    if (paramHashMap == null) {}
    Object localObject3;
    for (int i = -1;; i = paramHashMap.size())
    {
      ae.d("MicroMsg.DBInit", "createtables checkCreateIni:%b  tables:%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      localObject1 = "";
      if (!paramBoolean1) {
        break label336;
      }
      this.Jja = (this.iQT.getPath() + ".ini");
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
          ae.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", new Object[] { localObject3.getClass().toString() });
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
      localObject3 = com.tencent.mm.sdk.e.a.getValue(this.Jja, "createmd5");
      localObject1 = localObject2;
      if (!bu.isNullOrNil((String)localObject3))
      {
        localObject1 = localObject2;
        if (((String)localObject2).equals(localObject3))
        {
          ae.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", new Object[] { this.iQT.getPath() });
          AppMethodBeat.o(133322);
          return true;
        }
      }
    }
    label336:
    this.iQT.execSQL("pragma auto_vacuum = 0 ");
    localObject2 = new f.a();
    this.iQT.beginTransaction();
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
            this.iQT.execSQL(str);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Matcher localMatcher = JiZ.matcher(str);
              if ((localMatcher != null) && (localMatcher.matches())) {
                Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
              } else {
                ae.w("MicroMsg.DBInit", "CreateTable failed:[" + str + "][" + localException.getMessage() + "]");
              }
            }
          }
          j += 1;
        }
      }
    }
    int j = 0;
    long l = ((f.a)localObject2).abs();
    this.iQT.endTransaction();
    ae.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(l), Long.valueOf(((f.a)localObject2).abs()), Integer.valueOf(j) });
    if (paramBoolean1) {
      com.tencent.mm.sdk.e.a.bf(this.Jja, "createmd5", (String)localObject1);
    }
    AppMethodBeat.o(133322);
    return true;
  }
  
  private boolean b(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(133321);
    if (this.iQT != null)
    {
      paramString1 = new AssertionError();
      AppMethodBeat.o(133321);
      throw paramString1;
    }
    boolean bool;
    if (!o.fB(paramString1)) {
      bool = true;
    }
    int i;
    for (;;)
    {
      this.isNew = bool;
      i = 0;
      Iterator localIterator = IMEISave.fxL().iterator();
      label58:
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.key = com.tencent.mm.b.g.getMessageDigest((str + paramLong).getBytes()).substring(0, 7);
        try
        {
          this.iQT = f.E(paramString1, this.key, paramBoolean);
          c(this.iQT);
          if (!q.cH(true).equals(str))
          {
            ae.i("MicroMsg.DBInit", "IMEI changed detected: ".concat(String.valueOf(str)));
            l.aam().set(258, str);
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(181L, 5L, 1L, false);
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
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(181L, i, 1L, true);
        f.aWz(paramString1);
        if (paramString1.endsWith("EnMicroMsg.db")) {
          f.aWz(com.tencent.mm.kernel.g.ajR().gDT + "dbback/EnMicroMsg.db");
        }
        try
        {
          this.key = com.tencent.mm.b.g.getMessageDigest((q.cH(true) + paramLong).getBytes()).substring(0, 7);
          this.iQT = f.E(paramString1, this.key, paramBoolean);
          c(this.iQT);
          this.isNew = true;
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(181L, 6L, 1L, false);
          AppMethodBeat.o(133321);
          return true;
        }
        catch (SQLiteException paramString1)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(181L, 7L, 1L, false);
        }
        if (f.fxP()) {
          i = 43;
        } else {
          i = 41;
        }
      }
    }
    for (;;)
    {
      if (this.iQT != null)
      {
        this.iQT.close();
        this.iQT = null;
      }
      this.key = null;
      AppMethodBeat.o(133321);
      return false;
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        if (!o.fB(paramString2)) {}
        for (bool = true;; bool = false)
        {
          this.isNew = bool;
          try
          {
            this.iQT = f.E(paramString2, this.key, paramBoolean);
            c(this.iQT);
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(181L, 6L, 1L, false);
            AppMethodBeat.o(133321);
            return true;
          }
          catch (SQLiteException paramString1)
          {
            com.tencent.mm.plugin.report.e.ywz.idkeyStat(181L, 7L, 1L, false);
          }
        }
      }
    }
  }
  
  private static void c(f paramf)
  {
    AppMethodBeat.i(133319);
    if (paramf.Jjj != null) {}
    for (paramf = paramf.Jjj;; paramf = paramf.Jjk)
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
  
  private void mk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133312);
    HashSet localHashSet = new HashSet();
    Object localObject = this.iQT.a("select * from " + paramString1 + " limit 1 ", null, 0);
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
    Cursor localCursor = this.iQT.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
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
    this.iQT.execSQL(paramString1);
    AppMethodBeat.o(133312);
  }
  
  private List<String> ml(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133314);
    ArrayList localArrayList = new ArrayList();
    if (this.iQT == null)
    {
      AppMethodBeat.o(133314);
      return localArrayList;
    }
    Object localObject1 = this.iQT.a("PRAGMA table_info( " + paramString1 + " )", null, 0);
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
    Object localObject2 = this.iQT.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
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
          ae.e("MicroMsg.DBInit", "conflicting alter table on column: " + str1 + ", " + str2 + "<o-n>" + (String)localObject3);
          paramString1.remove(str1);
        }
      }
    }
    AppMethodBeat.o(133314);
    return localArrayList;
  }
  
  private boolean mm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133315);
    Cursor localCursor = this.iQT.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(133315);
      return false;
    }
    try
    {
      if (bu.isNullOrNil(paramString2)) {
        this.iQT.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY ''");
      }
      while (!q(localCursor))
      {
        AppMethodBeat.o(133315);
        return false;
        this.iQT.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY '" + paramString2 + "'");
      }
      this.iQT.beginTransaction();
    }
    catch (SQLiteDatabaseCorruptException paramString2)
    {
      ae.e("MicroMsg.DBInit", "Attached database is corrupted: ".concat(String.valueOf(paramString1)));
      o.deleteFile(paramString1);
      AppMethodBeat.o(133315);
      throw paramString2;
    }
    int i = 0;
    int j;
    if (i < localCursor.getCount())
    {
      localCursor.moveToPosition(i);
      paramString1 = this.iQT.a("select * from old.sqlite_master where tbl_name = '" + localCursor.getString(0) + "'", null, 0);
      if (paramString1 == null) {
        break label463;
      }
      j = paramString1.getCount();
      paramString1.close();
    }
    for (;;)
    {
      if (j == 0) {
        ae.w("MicroMsg.DBInit", "In old db not found :" + localCursor.getString(0));
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          paramString1 = ml("old." + localCursor.getString(0), localCursor.getString(0)).iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            this.iQT.execSQL(paramString2);
          }
        }
        catch (Exception paramString1)
        {
          ae.w("MicroMsg.DBInit", "Insertselect FAILED :" + localCursor.getString(0));
        }
        mk("old." + localCursor.getString(0), localCursor.getString(0));
      }
      this.iQT.endTransaction();
      localCursor.close();
      this.iQT.execSQL("DETACH DATABASE old;");
      AppMethodBeat.o(133315);
      return true;
      label463:
      j = 0;
    }
  }
  
  private boolean mn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133318);
    if (mm(paramString1, paramString2))
    {
      ae.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", new Object[] { paramString1 });
      ae.i("MicroMsg.DBInit", "delete result :%b", new Object[] { Boolean.valueOf(o.deleteFile(paramString1)) });
      AppMethodBeat.o(133318);
      return true;
    }
    ae.i("MicroMsg.DBInit", "system transfer fail path %s", new Object[] { paramString1 });
    AppMethodBeat.o(133318);
    return false;
  }
  
  private boolean q(Cursor paramCursor)
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
    paramCursor = this.iQT.a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
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
    this.iQT.beginTransaction();
    paramCursor = ((HashSet)localObject).iterator();
    while (paramCursor.hasNext())
    {
      localObject = (String)paramCursor.next();
      if (!localHashSet.contains(localObject))
      {
        localObject = this.iQT.a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + (String)localObject + "'", null, 0);
        if (localObject != null)
        {
          String str = ((Cursor)localObject).getString(0);
          this.iQT.execSQL(str);
          ((Cursor)localObject).close();
        }
      }
    }
    this.iQT.endTransaction();
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
    if (!bu.isNullOrNil(paramString2))
    {
      bool1 = true;
      Assert.assertTrue("create SqliteDB enDbCachePath == null ", bool1);
      this.Jjc = (paramString2 + ".errreport");
      if (this.iQT != null)
      {
        this.iQT.close();
        this.iQT = null;
      }
      boolean bool2 = o.fB(paramString2);
      bool3 = o.fB(paramString1);
      bool4 = o.fB(paramString3);
      if ((bool2) || (!bool3)) {
        break label264;
      }
      i = 1;
      this.Jjb = b(paramString2, paramLong, f.fxO(), paramString3);
      Boolean localBoolean = Boolean.TRUE;
      boolean bool5 = this.Jjb;
      if (this.iQT == null) {
        break label270;
      }
      bool1 = true;
      label134:
      ae.i("MicroMsg.DBInit", "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s", new Object[] { paramString2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), localBoolean, Boolean.valueOf(bool5), Boolean.valueOf(bool1), Thread.currentThread().getName() });
      if ((this.iQT == null) || (this.iQT.getPath().equals(paramString3)) || (!bool4)) {
        break label422;
      }
      j = 1;
      ae.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
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
        this.Jjd = true;
      }
      if (j != 0)
      {
        this.key = com.tencent.mm.b.g.getMessageDigest((q.cH(true) + paramLong).getBytes()).substring(0, 7);
        mn(paramString3, this.key);
        com.tencent.mm.blink.a.r(201L, 1L);
      }
      if (i != 0)
      {
        paramBoolean = mn(paramString1, "");
        com.tencent.mm.blink.a.r(200L, 1L);
        AppMethodBeat.o(133317);
        return paramBoolean;
      }
      if (this.iQT != null)
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
    if (this.iQT != null)
    {
      this.iQT.close();
      this.iQT = null;
    }
    boolean bool = o.fB(paramString);
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool), paramString });
        this.iQT = f.cP(paramString, paramBoolean);
        if (!bool)
        {
          paramBoolean = true;
          if (a(paramHashMap, true, paramBoolean)) {
            break;
          }
          if (this.iQT != null)
          {
            this.iQT.close();
            this.iQT = null;
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
    if ((bu.isNullOrNil(this.errMsg)) || (bu.isNullOrNil(this.Jjc)))
    {
      AppMethodBeat.o(133311);
      return "";
    }
    if (!bu.isNullOrNil(com.tencent.mm.sdk.e.a.getValue(this.Jjc, "Reported")))
    {
      AppMethodBeat.o(133311);
      return "";
    }
    com.tencent.mm.sdk.e.a.bf(this.Jjc, "Reported", "true");
    String str = this.errMsg;
    AppMethodBeat.o(133311);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a
 * JD-Core Version:    0.7.0.1
 */