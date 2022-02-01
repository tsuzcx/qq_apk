package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g
  implements ISQLiteDatabase
{
  private static String Otx = "";
  public boolean JWJ;
  public h Otw;
  public Map<String, i> Oty;
  public Queue<a> Otz;
  public int field_MARK_CURSOR_CHECK_IGNORE;
  public f jNN;
  
  public final int blz(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(133388);
    if (!this.JWJ)
    {
      AppMethodBeat.o(133388);
      return -4;
    }
    if ((this.Otw == null) || (this.Otw.inTransaction()))
    {
      Log.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
      AppMethodBeat.o(133388);
      return -3;
    }
    try
    {
      if (f.a(this.jNN, paramString))
      {
        this.jNN.execSQL("drop table ".concat(String.valueOf(paramString)));
        Log.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", new Object[] { paramString });
      }
      Cursor localCursor = this.Otw.rawQuery(" select sql from sqlite_master where tbl_name=\"" + paramString + "\" and type = \"table\"", null);
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
        Log.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
        AppMethodBeat.o(133388);
        return -1;
      }
      this.jNN.execSQL((String)localObject1);
      this.jNN.execSQL("insert into " + paramString + " select * from old." + paramString);
      Log.d("MicroMsg.MemoryStorage", "copy table %s success", new Object[] { paramString });
      AppMethodBeat.o(133388);
      return 0;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.MemoryStorage", paramString, "copy table failed with exception.\n", new Object[0]);
      AppMethodBeat.o(133388);
    }
    return -2;
  }
  
  public final void closeDB()
  {
    AppMethodBeat.i(133386);
    Otx = Util.getStack().toString();
    if (this.jNN != null)
    {
      this.jNN.close();
      this.jNN = null;
    }
    AppMethodBeat.o(133386);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133389);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.Oty.containsKey(paramString1));
    int i;
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      i locali = (i)this.Oty.get(paramString1);
      i.a locala = new i.a();
      locala.funcType = 5;
      locala.OtI = paramString2;
      locala.Z(paramArrayOfString);
      locali.b(locala);
      i = this.jNN.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(133389);
      return i;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", new Object[] { paramString1, Otx });
    if ((this.Otw != null) && (this.Otw.isOpen()))
    {
      i = this.Otw.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(133389);
      return i;
    }
    AppMethodBeat.o(133389);
    return -1;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(133390);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.Oty.containsKey(paramString1));
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      paramString1 = (i)this.Oty.get(paramString1);
      i.a locala = new i.a();
      locala.funcType = 1;
      locala.sql = paramString2;
      paramString1.b(locala);
      this.jNN.execSQL(paramString2);
      AppMethodBeat.o(133390);
      return true;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", new Object[] { paramString1, Otx });
    if ((this.Otw != null) && (this.Otw.isOpen()))
    {
      this.Otw.execSQL(paramString2, paramString1);
      AppMethodBeat.o(133390);
      return true;
    }
    AppMethodBeat.o(133390);
    return false;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133391);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.Oty.containsKey(paramString1));
    long l;
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      i locali = (i)this.Oty.get(paramString1);
      i.a locala = new i.a();
      locala.funcType = 2;
      locala.primaryKey = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.jNN.insert(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133391);
      return l;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", new Object[] { paramString1, Otx });
    if ((this.Otw != null) && (this.Otw.isOpen()))
    {
      l = this.Otw.insert(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133391);
      return l;
    }
    AppMethodBeat.o(133391);
    return -1L;
  }
  
  public final boolean isClose()
  {
    AppMethodBeat.i(133387);
    if ((this.jNN == null) || (!this.jNN.isOpen()))
    {
      Log.e("MicroMsg.MemoryStorage", "memory db is close [%s]", new Object[] { Otx });
      AppMethodBeat.o(133387);
      return true;
    }
    AppMethodBeat.o(133387);
    return false;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(133394);
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      paramString1 = this.jNN.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0, null);
      AppMethodBeat.o(133394);
      return paramString1;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", new Object[] { paramString1, Otx });
    paramString1 = d.gFu();
    AppMethodBeat.o(133394);
    return paramString1;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(133395);
    paramString1 = query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(133395);
    return paramString1;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6)
  {
    AppMethodBeat.i(197184);
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      paramString1 = this.jNN.query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0, paramString6);
      AppMethodBeat.o(197184);
      return paramString1;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", new Object[] { paramString1, Otx });
    paramString1 = d.gFu();
    AppMethodBeat.o(197184);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133396);
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      paramString = this.jNN.rawQuery(paramString, paramArrayOfString, 0);
      AppMethodBeat.o(133396);
      return paramString;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", new Object[] { paramString, Otx });
    paramString = d.gFu();
    AppMethodBeat.o(133396);
    return paramString;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(133397);
    paramString = rawQuery(paramString, paramArrayOfString);
    AppMethodBeat.o(133397);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(133392);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.Oty.containsKey(paramString1));
    long l;
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      i locali = (i)this.Oty.get(paramString1);
      i.a locala = new i.a();
      locala.funcType = 4;
      locala.primaryKey = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.jNN.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133392);
      return l;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", new Object[] { paramString1, Otx });
    if ((this.Otw != null) && (this.Otw.isOpen()))
    {
      l = this.Otw.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(133392);
      return l;
    }
    AppMethodBeat.o(133392);
    return -1L;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(133393);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.Oty.containsKey(paramString1));
    int i;
    if ((this.jNN != null) && (this.jNN.isOpen()))
    {
      i locali = (i)this.Oty.get(paramString1);
      i.a locala = new i.a();
      locala.funcType = 3;
      locala.OtI = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locala.Z(paramArrayOfString);
      locali.b(locala);
      i = this.jNN.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      AppMethodBeat.o(133393);
      return i;
    }
    Log.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", new Object[] { paramString1, Otx });
    if ((this.Otw != null) && (this.Otw.isOpen()))
    {
      i = this.Otw.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
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