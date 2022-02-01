package com.tencent.mm.storagebase.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends AbstractCursor
  implements d
{
  public static final SQLiteDatabase.CursorFactory FACTORY;
  private final h adnZ;
  private final Throwable adoa;
  public a adob;
  private boolean adoc;
  private b<a> adod;
  c adoe;
  private boolean adof;
  private Map<String, Integer> mColumnNameMap;
  private final String[] mColumns;
  private int mCount;
  private final SQLiteCursorDriver mDriver;
  private final String mEditTable;
  private int pageSize;
  
  static
  {
    AppMethodBeat.i(133502);
    FACTORY = new SQLiteDatabase.CursorFactory()
    {
      public final Cursor newCursor(SQLiteDatabase paramAnonymousSQLiteDatabase, SQLiteCursorDriver paramAnonymousSQLiteCursorDriver, String paramAnonymousString, SQLiteProgram paramAnonymousSQLiteProgram)
      {
        AppMethodBeat.i(133477);
        paramAnonymousSQLiteDatabase = new f(paramAnonymousSQLiteCursorDriver, paramAnonymousString, (h)paramAnonymousSQLiteProgram);
        AppMethodBeat.o(133477);
        return paramAnonymousSQLiteDatabase;
      }
      
      public final SQLiteProgram newQuery(SQLiteDatabase paramAnonymousSQLiteDatabase, String paramAnonymousString, Object[] paramAnonymousArrayOfObject, CancellationSignal paramAnonymousCancellationSignal)
      {
        AppMethodBeat.i(133478);
        paramAnonymousSQLiteDatabase = new h(paramAnonymousSQLiteDatabase, paramAnonymousString, paramAnonymousCancellationSignal);
        AppMethodBeat.o(133478);
        return paramAnonymousSQLiteDatabase;
      }
    };
    AppMethodBeat.o(133502);
  }
  
  public f(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, h paramh)
  {
    AppMethodBeat.i(133479);
    this.mCount = -1;
    this.pageSize = 3000;
    if (paramh == null)
    {
      paramSQLiteCursorDriver = new IllegalArgumentException("query object cannot be null");
      AppMethodBeat.o(133479);
      throw paramSQLiteCursorDriver;
    }
    this.adoa = null;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.adnZ = paramh;
    this.mColumns = paramh.getColumnNames();
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    AppMethodBeat.o(133479);
  }
  
  private int azp(int paramInt)
  {
    AppMethodBeat.i(133484);
    if (this.adoc)
    {
      if (this.adod == null) {
        this.adod = new b()
        {
          public final ArrayList<a> ce(ArrayList<Object> paramAnonymousArrayList)
          {
            AppMethodBeat.i(133476);
            f localf = f.this;
            if (localf.adob != null)
            {
              paramAnonymousArrayList = localf.adob.ce(paramAnonymousArrayList);
              AppMethodBeat.o(133476);
              return paramAnonymousArrayList;
            }
            AppMethodBeat.o(133476);
            return null;
          }
          
          public final a jeg()
          {
            AppMethodBeat.i(133475);
            Object localObject = f.this;
            if (((f)localObject).adob != null)
            {
              localObject = ((f)localObject).adob.jeg();
              AppMethodBeat.o(133475);
              return localObject;
            }
            AppMethodBeat.o(133475);
            return null;
          }
        };
      }
      this.adod.mStartPos = paramInt;
      paramInt = this.adnZ.a(this.adod, paramInt, this.pageSize);
      AppMethodBeat.o(133484);
      return paramInt;
    }
    jeh();
    paramInt = this.adnZ.a(this.adoe, paramInt, this.pageSize);
    AppMethodBeat.o(133484);
    return paramInt;
  }
  
  private void jeh()
  {
    AppMethodBeat.i(133481);
    if (this.adoe == null) {
      this.adoe = new c(this.mColumns, (byte)0);
    }
    AppMethodBeat.o(133481);
  }
  
  public final void KF(boolean paramBoolean)
  {
    this.adoc = paramBoolean;
  }
  
  public final void a(a parama)
  {
    this.adob = parama;
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    AppMethodBeat.i(133499);
    if ((this.adoc) && (this.adod != null))
    {
      if ((!this.adof) && ((paramObject instanceof Object[])) && (this.adod.gF(paramObject)))
      {
        this.mCount -= ((Object[])paramObject).length;
        this.pageSize -= ((Object[])paramObject).length;
      }
      b localb = this.adod;
      if (parama != null)
      {
        com.tencent.mm.sdk.platformtools.Log.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + paramObject + "values : " + parama);
        localb.b(paramObject, parama);
      }
      for (;;)
      {
        AppMethodBeat.o(133499);
        return false;
        if ((paramObject instanceof Object[]))
        {
          paramObject = (Object[])paramObject;
          int j = paramObject.length;
          int i = 0;
          while (i < j)
          {
            parama = paramObject[i];
            localb.adnO.remove(parama);
            i += 1;
          }
          localb.I(paramObject);
        }
        else
        {
          if (localb.adnP == null) {
            localb.adnP = new ArrayList();
          }
          if (!localb.adnP.contains(paramObject))
          {
            localb.adnP.add(paramObject);
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : ".concat(String.valueOf(paramObject)));
          }
          localb.adnO.remove(paramObject);
        }
      }
    }
    if (!this.adoc)
    {
      paramObject = this.adoe;
      paramObject.mPos = 0;
      paramObject.adnR.clear();
    }
    AppMethodBeat.o(133499);
    return false;
  }
  
  public final boolean azm(int paramInt)
  {
    if (!this.adoc) {}
    b localb;
    do
    {
      do
      {
        return false;
        localb = this.adod;
      } while (paramInt > 50);
      if (localb.adnN < 10) {
        return true;
      }
    } while (paramInt / localb.adnN >= 0.1D);
    return true;
  }
  
  public final a azn(int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(133498);
    if (this.adod != null)
    {
      b localb = this.adod;
      if (localb.azo(paramInt))
      {
        Object localObject2 = localb.adnM.get(paramInt);
        a locala = (a)localb.adnO.get(localObject2);
        localObject1 = locala;
        if (locala == null)
        {
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.CursorDataWindow", "get data null %s", new Object[] { localObject2 });
          if (localb.adnP.size() != 0)
          {
            localObject1 = localb.ce(localb.adnP);
            if (localObject1 != null) {
              if (i < ((ArrayList)localObject1).size())
              {
                locala = (a)((ArrayList)localObject1).get(i);
                if (locala != null) {
                  localb.b(locala.getKey(), locala);
                }
                for (;;)
                {
                  i += 1;
                  break;
                  com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                }
              }
            }
            localb.adnP.clear();
          }
          locala = (a)localb.adnO.get(localObject2);
          localObject1 = locala;
          if (locala == null)
          {
            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + localObject2 + "pos:" + paramInt);
            localObject1 = locala;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(133498);
        return localObject1;
        com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + paramInt + " loaded num :" + localb.adnM.size());
      }
    }
    AppMethodBeat.o(133498);
    return null;
  }
  
  public final void checkPosition()
  {
    AppMethodBeat.i(133483);
    super.checkPosition();
    AppMethodBeat.o(133483);
  }
  
  public final void close()
  {
    AppMethodBeat.i(133487);
    super.close();
    try
    {
      this.adnZ.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally
    {
      AppMethodBeat.o(133487);
    }
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final void deactivate()
  {
    AppMethodBeat.i(133486);
    super.deactivate();
    this.mDriver.cursorDeactivated();
    AppMethodBeat.o(133486);
  }
  
  public final void fi(int paramInt)
  {
    if ((paramInt <= 15000) && (paramInt >= 2000)) {
      this.pageSize = paramInt;
    }
  }
  
  public final void finalize()
  {
    AppMethodBeat.i(133489);
    try
    {
      if (this.adod != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
      AppMethodBeat.o(133489);
    }
  }
  
  public final boolean gF(Object paramObject)
  {
    AppMethodBeat.i(133500);
    if (!this.adoc)
    {
      AppMethodBeat.o(133500);
      return false;
    }
    if (this.adod == null)
    {
      AppMethodBeat.o(133500);
      return false;
    }
    boolean bool = this.adod.gF(paramObject);
    AppMethodBeat.o(133500);
    return bool;
  }
  
  public final a gG(Object paramObject)
  {
    AppMethodBeat.i(133501);
    if (!this.adoc)
    {
      com.tencent.wcdb.support.Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error ".concat(String.valueOf(paramObject)));
      AppMethodBeat.o(133501);
      return null;
    }
    if (this.adod == null)
    {
      com.tencent.wcdb.support.Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
      AppMethodBeat.o(133501);
      return null;
    }
    b localb = this.adod;
    if (localb.adnO == null)
    {
      AppMethodBeat.o(133501);
      return null;
    }
    paramObject = (a)localb.adnO.get(paramObject);
    AppMethodBeat.o(133501);
    return paramObject;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(133497);
    if (!this.adoc)
    {
      byte[] arrayOfByte = this.adoe.getBlob(paramInt);
      AppMethodBeat.o(133497);
      return arrayOfByte;
    }
    AppMethodBeat.o(133497);
    return null;
  }
  
  public final int getColumnIndex(String paramString)
  {
    AppMethodBeat.i(133485);
    if (this.mColumnNameMap == null)
    {
      localObject = this.mColumns;
      int j = localObject.length;
      HashMap localHashMap = new HashMap(j, 1.0F);
      i = 0;
      while (i < j)
      {
        localHashMap.put(localObject[i], Integer.valueOf(i));
        i += 1;
      }
      this.mColumnNameMap = localHashMap;
    }
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      localObject = new Exception();
      com.tencent.wcdb.support.Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- ".concat(String.valueOf(paramString)), new Object[] { localObject });
      localObject = paramString.substring(i + 1);
    }
    paramString = (Integer)this.mColumnNameMap.get(localObject);
    if (paramString != null)
    {
      i = paramString.intValue();
      AppMethodBeat.o(133485);
      return i;
    }
    AppMethodBeat.o(133485);
    return -1;
  }
  
  public final String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(133482);
    if (this.mCount == -1)
    {
      this.mCount = azp(0);
      if (this.adod != null) {
        if ((this.mCount == -1) || (this.mCount != this.adod.adnM.size())) {
          break label91;
        }
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      this.adof = bool;
      if ((!this.adoc) || (!this.adof)) {
        break label115;
      }
      if (this.adod != null) {
        break;
      }
      AppMethodBeat.o(133482);
      return 0;
    }
    int i = this.adod.adnM.size();
    AppMethodBeat.o(133482);
    return i;
    label115:
    i = this.mCount;
    AppMethodBeat.o(133482);
    return i;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(133495);
    if (!this.adoc)
    {
      double d = this.adoe.getDouble(paramInt);
      AppMethodBeat.o(133495);
      return d;
    }
    AppMethodBeat.o(133495);
    return 0.0D;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(133494);
    if (!this.adoc)
    {
      float f = this.adoe.getFloat(paramInt);
      AppMethodBeat.o(133494);
      return f;
    }
    AppMethodBeat.o(133494);
    return 0.0F;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(133492);
    if (!this.adoc)
    {
      paramInt = this.adoe.getInt(paramInt);
      AppMethodBeat.o(133492);
      return paramInt;
    }
    AppMethodBeat.o(133492);
    return 0;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(133493);
    if (!this.adoc)
    {
      long l = this.adoe.getLong(paramInt);
      AppMethodBeat.o(133493);
      return l;
    }
    AppMethodBeat.o(133493);
    return 0L;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(133491);
    if (!this.adoc)
    {
      short s = this.adoe.getShort(paramInt);
      AppMethodBeat.o(133491);
      return s;
    }
    AppMethodBeat.o(133491);
    return 0;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(133490);
    if (!this.adoc)
    {
      String str = this.adoe.getString(paramInt);
      AppMethodBeat.o(133490);
      return str;
    }
    AppMethodBeat.o(133490);
    return null;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(133496);
    if (!this.adoc)
    {
      boolean bool = this.adoe.isNull(paramInt);
      AppMethodBeat.o(133496);
      return bool;
    }
    AppMethodBeat.o(133496);
    return false;
  }
  
  public final SparseArray<Object>[] jdT()
  {
    if (!this.adoc) {
      return null;
    }
    return new SparseArray[] { this.adod.adnM };
  }
  
  public final HashMap jdU()
  {
    return this.adod.adnO;
  }
  
  public final boolean jdV()
  {
    return this.adof;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133480);
    if (this.adoc)
    {
      if ((this.adod == null) || (!this.adod.azo(paramInt2))) {
        azp(paramInt2 / this.pageSize * this.pageSize);
      }
      AppMethodBeat.o(133480);
      return true;
    }
    if (this.adoe == null) {
      jeh();
    }
    c localc = this.adoe;
    paramInt1 = paramInt2 / localc.adnS;
    if (localc.adnR.indexOfKey(paramInt1) >= 0)
    {
      int i = localc.adnS;
      int j = localc.columnCount;
      if (((Object[])localc.adnR.get(paramInt1))[(paramInt2 % i * j)] == null) {}
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        azp(paramInt2 / this.pageSize * this.pageSize);
      }
      this.adoe.moveToPosition(paramInt2);
      break;
    }
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  /* Error */
  public final boolean requery()
  {
    // Byte code:
    //   0: ldc_w 440
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 443	com/tencent/mm/storagebase/a/f:isClosed	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 440
    //   16: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 83	com/tencent/mm/storagebase/a/f:adnZ	Lcom/tencent/mm/storagebase/a/h;
    //   27: invokevirtual 447	com/tencent/mm/storagebase/a/h:getDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   30: invokevirtual 452	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: monitorexit
    //   38: ldc_w 440
    //   41: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 107	com/tencent/mm/storagebase/a/f:adod	Lcom/tencent/mm/storagebase/a/b;
    //   50: ifnull +10 -> 60
    //   53: aload_0
    //   54: getfield 107	com/tencent/mm/storagebase/a/f:adod	Lcom/tencent/mm/storagebase/a/b;
    //   57: invokevirtual 455	com/tencent/mm/storagebase/a/b:clearData	()V
    //   60: aload_0
    //   61: iconst_m1
    //   62: putfield 456	com/tencent/mm/storagebase/a/f:mPos	I
    //   65: aload_0
    //   66: iconst_m1
    //   67: putfield 64	com/tencent/mm/storagebase/a/f:mCount	I
    //   70: aload_0
    //   71: getfield 77	com/tencent/mm/storagebase/a/f:mDriver	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   74: aload_0
    //   75: invokeinterface 460 2 0
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_0
    //   83: invokespecial 462	com/tencent/wcdb/AbstractCursor:requery	()Z
    //   86: istore_1
    //   87: ldc_w 440
    //   90: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iload_1
    //   94: ireturn
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc_w 440
    //   101: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_2
    //   105: athrow
    //   106: astore_2
    //   107: ldc_w 326
    //   110: new 151	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 464
    //   117: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 467	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_1
    //   131: anewarray 257	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: aastore
    //   138: invokestatic 470	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: ldc_w 440
    //   144: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: iconst_0
    //   148: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	f
    //   86	8	1	bool	boolean
    //   95	10	2	localObject	Object
    //   106	31	2	localIllegalStateException	java.lang.IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   23	38	95	finally
    //   46	60	95	finally
    //   60	82	95	finally
    //   82	87	106	java/lang/IllegalStateException
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public static abstract interface a
  {
    public abstract ArrayList<a> ce(ArrayList<Object> paramArrayList);
    
    public abstract a jeg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.f
 * JD-Core Version:    0.7.0.1
 */