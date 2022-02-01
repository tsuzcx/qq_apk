package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g
  implements e
{
  private static String FCE = "";
  public h FCD;
  public Map<String, i> FCF;
  public Queue<g.a> FCG;
  public f FCb;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  public boolean ghP;
  
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
  
  public final int aJK(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(133388);
    if (!this.ghP)
    {
      AppMethodBeat.o(133388);
      return -4;
    }
    if ((this.FCD == null) || (this.FCD.inTransaction()))
    {
      ad.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
      AppMethodBeat.o(133388);
      return -3;
    }
    try
    {
      if (f.a(this.FCb, paramString))
      {
        this.FCb.execSQL("drop table ".concat(String.valueOf(paramString)));
        ad.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", new Object[] { paramString });
      }
      Cursor localCursor = this.FCD.a(" select sql from sqlite_master where tbl_name=\"" + paramString + "\" and type = \"table\"", null, 0);
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
        ad.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
        AppMethodBeat.o(133388);
        return -1;
      }
      this.FCb.execSQL((String)localObject1);
      this.FCb.execSQL("insert into " + paramString + " select * from old." + paramString);
      ad.d("MicroMsg.MemoryStorage", "copy table %s success", new Object[] { paramString });
      AppMethodBeat.o(133388);
      return 0;
    }
    catch (Exception paramString)
    {
      ad.printErrStackTrace("MicroMsg.MemoryStorage", paramString, "copy table failed with exception.\n", new Object[0]);
      AppMethodBeat.o(133388);
    }
    return -2;
  }
  
  public final void closeDB()
  {
    AppMethodBeat.i(133386);
    FCE = bt.eGN().toString();
    if (this.FCb != null)
    {
      this.FCb.close();
      this.FCb = null;
    }
    AppMethodBeat.o(133386);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133389);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.FCF.containsKey(paramString1));
    int i;
    if ((this.FCb != null) && (this.FCb.isOpen()))
    {
      i locali = (i)this.FCF.get(paramString1);
      i.a locala = new i.a();
      locala.EWD = 5;
      locala.FCP = paramString2;
      locala.W(paramArrayOfString);
      locali.b(locala);
      i = this.FCb.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(133389);
      return i;
    }
    ad.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", new Object[] { paramString1, FCE });
    if ((this.FCD != null) && (this.FCD.isOpen()))
    {
      i = this.FCD.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(133389);
      return i;
    }
    AppMethodBeat.o(133389);
    return -1;
  }
  
  public final boolean eHe()
  {
    AppMethodBeat.i(133387);
    if ((this.FCb == null) || (!this.FCb.isOpen()))
    {
      ad.e("MicroMsg.MemoryStorage", "memory db is close [%s]", new Object[] { FCE });
      AppMethodBeat.o(133387);
      return true;
    }
    AppMethodBeat.o(133387);
    return false;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133390);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.FCF.containsKey(paramString1));
    if ((this.FCb != null) && (this.FCb.isOpen()))
    {
      paramString1 = (i)this.FCF.get(paramString1);
      i.a locala = new i.a();
      locala.EWD = 1;
      locala.sql = paramString2;
      paramString1.b(locala);
      this.FCb.execSQL(paramString2);
      AppMethodBeat.o(133390);
      return true;
    }
    ad.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", new Object[] { paramString1, FCE });
    if ((this.FCD != null) && (this.FCD.isOpen()))
    {
      this.FCD.execSQL(paramString2, paramString1);
      AppMethodBeat.o(133390);
      return true;
    }
    AppMethodBeat.o(133390);
    return false;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133391);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.FCF.containsKey(paramString1));
    long l;
    if ((this.FCb != null) && (this.FCb.isOpen()))
    {
      i locali = (i)this.FCF.get(paramString1);
      i.a locala = new i.a();
      locala.EWD = 2;
      locala.EYu = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.FCb.insert(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133391);
      return l;
    }
    ad.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", new Object[] { paramString1, FCE });
    if ((this.FCD != null) && (this.FCD.isOpen()))
    {
      l = this.FCD.a(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133391);
      return l;
    }
    AppMethodBeat.o(133391);
    return -1L;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(133394);
    if ((this.FCb != null) && (this.FCb.isOpen()))
    {
      paramString1 = this.FCb.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
      AppMethodBeat.o(133394);
      return paramString1;
    }
    ad.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", new Object[] { paramString1, FCE });
    paramString1 = d.eNU();
    AppMethodBeat.o(133394);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133396);
    if ((this.FCb != null) && (this.FCb.isOpen()))
    {
      paramString = this.FCb.a(paramString, paramArrayOfString, 0);
      AppMethodBeat.o(133396);
      return paramString;
    }
    ad.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", new Object[] { paramString, FCE });
    paramString = d.eNU();
    AppMethodBeat.o(133396);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133392);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.FCF.containsKey(paramString1));
    long l;
    if ((this.FCb != null) && (this.FCb.isOpen()))
    {
      i locali = (i)this.FCF.get(paramString1);
      i.a locala = new i.a();
      locala.EWD = 4;
      locala.EYu = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.FCb.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133392);
      return l;
    }
    ad.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", new Object[] { paramString1, FCE });
    if ((this.FCD != null) && (this.FCD.isOpen()))
    {
      l = this.FCD.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133392);
      return l;
    }
    AppMethodBeat.o(133392);
    return -1L;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133393);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.FCF.containsKey(paramString1));
    int i;
    if ((this.FCb != null) && (this.FCb.isOpen()))
    {
      i locali = (i)this.FCF.get(paramString1);
      i.a locala = new i.a();
      locala.EWD = 3;
      locala.FCP = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locala.W(paramArrayOfString);
      locali.b(locala);
      i = this.FCb.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      AppMethodBeat.o(133393);
      return i;
    }
    ad.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", new Object[] { paramString1, FCE });
    if ((this.FCD != null) && (this.FCD.isOpen()))
    {
      i = this.FCD.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      AppMethodBeat.o(133393);
      return i;
    }
    AppMethodBeat.o(133393);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storagebase.g
 * JD-Core Version:    0.7.0.1
 */