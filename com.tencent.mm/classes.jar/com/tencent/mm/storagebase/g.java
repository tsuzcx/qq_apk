package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g
  implements e
{
  private static String JjF = "";
  public boolean FfS;
  public h JjE;
  public Map<String, i> JjG;
  public Queue<a> JjH;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  public f iQT;
  
  public final Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(133397);
    paramString = rawQuery(paramString, paramArrayOfString);
    AppMethodBeat.o(133397);
    return paramString;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(133395);
    paramString1 = query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(133395);
    return paramString1;
  }
  
  public final int aWA(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(133388);
    if (!this.FfS)
    {
      AppMethodBeat.o(133388);
      return -4;
    }
    if ((this.JjE == null) || (this.JjE.inTransaction()))
    {
      ae.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
      AppMethodBeat.o(133388);
      return -3;
    }
    try
    {
      if (f.a(this.iQT, paramString))
      {
        this.iQT.execSQL("drop table ".concat(String.valueOf(paramString)));
        ae.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", new Object[] { paramString });
      }
      Cursor localCursor = this.JjE.a(" select sql from sqlite_master where tbl_name=\"" + paramString + "\" and type = \"table\"", null, 0);
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.getCount() == 1)
        {
          localCursor.moveToFirst();
          localObject1 = localCursor.getString(0);
        }
        localCursor.close();
      }
      if (localObject1 == null)
      {
        ae.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
        AppMethodBeat.o(133388);
        return -1;
      }
      this.iQT.execSQL((String)localObject1);
      this.iQT.execSQL("insert into " + paramString + " select * from old." + paramString);
      ae.d("MicroMsg.MemoryStorage", "copy table %s success", new Object[] { paramString });
      AppMethodBeat.o(133388);
      return 0;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.MemoryStorage", paramString, "copy table failed with exception.\n", new Object[0]);
      AppMethodBeat.o(133388);
    }
    return -2;
  }
  
  public final void closeDB()
  {
    AppMethodBeat.i(133386);
    JjF = bu.fpN().toString();
    if (this.iQT != null)
    {
      this.iQT.close();
      this.iQT = null;
    }
    AppMethodBeat.o(133386);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133389);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.JjG.containsKey(paramString1));
    int i;
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      i locali = (i)this.JjG.get(paramString1);
      i.a locala = new i.a();
      locala.IzP = 5;
      locala.JjQ = paramString2;
      locala.Y(paramArrayOfString);
      locali.b(locala);
      i = this.iQT.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(133389);
      return i;
    }
    ae.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", new Object[] { paramString1, JjF });
    if ((this.JjE != null) && (this.JjE.isOpen()))
    {
      i = this.JjE.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(133389);
      return i;
    }
    AppMethodBeat.o(133389);
    return -1;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133390);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.JjG.containsKey(paramString1));
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      paramString1 = (i)this.JjG.get(paramString1);
      i.a locala = new i.a();
      locala.IzP = 1;
      locala.sql = paramString2;
      paramString1.b(locala);
      this.iQT.execSQL(paramString2);
      AppMethodBeat.o(133390);
      return true;
    }
    ae.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", new Object[] { paramString1, JjF });
    if ((this.JjE != null) && (this.JjE.isOpen()))
    {
      this.JjE.execSQL(paramString2, paramString1);
      AppMethodBeat.o(133390);
      return true;
    }
    AppMethodBeat.o(133390);
    return false;
  }
  
  public final boolean fqe()
  {
    AppMethodBeat.i(133387);
    if ((this.iQT == null) || (!this.iQT.isOpen()))
    {
      ae.e("MicroMsg.MemoryStorage", "memory db is close [%s]", new Object[] { JjF });
      AppMethodBeat.o(133387);
      return true;
    }
    AppMethodBeat.o(133387);
    return false;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133391);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.JjG.containsKey(paramString1));
    long l;
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      i locali = (i)this.JjG.get(paramString1);
      i.a locala = new i.a();
      locala.IzP = 2;
      locala.IBM = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.iQT.insert(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133391);
      return l;
    }
    ae.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", new Object[] { paramString1, JjF });
    if ((this.JjE != null) && (this.JjE.isOpen()))
    {
      l = this.JjE.a(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133391);
      return l;
    }
    AppMethodBeat.o(133391);
    return -1L;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(133394);
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      paramString1 = this.iQT.b(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
      AppMethodBeat.o(133394);
      return paramString1;
    }
    ae.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", new Object[] { paramString1, JjF });
    paramString1 = d.fxH();
    AppMethodBeat.o(133394);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133396);
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      paramString = this.iQT.a(paramString, paramArrayOfString, 0);
      AppMethodBeat.o(133396);
      return paramString;
    }
    ae.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", new Object[] { paramString, JjF });
    paramString = d.fxH();
    AppMethodBeat.o(133396);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133392);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.JjG.containsKey(paramString1));
    long l;
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      i locali = (i)this.JjG.get(paramString1);
      i.a locala = new i.a();
      locala.IzP = 4;
      locala.IBM = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.iQT.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133392);
      return l;
    }
    ae.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", new Object[] { paramString1, JjF });
    if ((this.JjE != null) && (this.JjE.isOpen()))
    {
      l = this.JjE.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133392);
      return l;
    }
    AppMethodBeat.o(133392);
    return -1L;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133393);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.JjG.containsKey(paramString1));
    int i;
    if ((this.iQT != null) && (this.iQT.isOpen()))
    {
      i locali = (i)this.JjG.get(paramString1);
      i.a locala = new i.a();
      locala.IzP = 3;
      locala.JjQ = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locala.Y(paramArrayOfString);
      locali.b(locala);
      i = this.iQT.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      AppMethodBeat.o(133393);
      return i;
    }
    ae.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", new Object[] { paramString1, JjF });
    if ((this.JjE != null) && (this.JjE.isOpen()))
    {
      i = this.JjE.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      AppMethodBeat.o(133393);
      return i;
    }
    AppMethodBeat.o(133393);
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract int a(g paramg);
    
    public abstract String getTableName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storagebase.g
 * JD-Core Version:    0.7.0.1
 */