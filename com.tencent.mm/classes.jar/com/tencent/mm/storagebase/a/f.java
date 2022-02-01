package com.tencent.mm.storagebase.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCursorDriver;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class f
  extends AbstractCursor
  implements d
{
  public static final SQLiteDatabase.CursorFactory FACTORY;
  private boolean IPA;
  private b<a> IPB;
  c IPC;
  private boolean IPD;
  private final h IPx;
  private final Throwable IPy;
  public a IPz;
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
    this.IPy = null;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.IPx = paramh;
    this.mColumns = paramh.getColumnNames();
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    AppMethodBeat.o(133479);
  }
  
  private int abm(int paramInt)
  {
    AppMethodBeat.i(133484);
    if (this.IPA)
    {
      if (this.IPB == null) {
        this.IPB = new b()
        {
          public final ArrayList<a> aV(ArrayList<Object> paramAnonymousArrayList)
          {
            AppMethodBeat.i(133476);
            f localf = f.this;
            if (localf.IPz != null)
            {
              paramAnonymousArrayList = localf.IPz.aV(paramAnonymousArrayList);
              AppMethodBeat.o(133476);
              return paramAnonymousArrayList;
            }
            AppMethodBeat.o(133476);
            return null;
          }
          
          public final a ftV()
          {
            AppMethodBeat.i(133475);
            Object localObject = f.this;
            if (((f)localObject).IPz != null)
            {
              localObject = ((f)localObject).IPz.ftV();
              AppMethodBeat.o(133475);
              return localObject;
            }
            AppMethodBeat.o(133475);
            return null;
          }
        };
      }
      this.IPB.mStartPos = paramInt;
      paramInt = this.IPx.a(this.IPB, paramInt, this.pageSize);
      AppMethodBeat.o(133484);
      return paramInt;
    }
    ftW();
    paramInt = this.IPx.a(this.IPC, paramInt, this.pageSize);
    AppMethodBeat.o(133484);
    return paramInt;
  }
  
  private void ftW()
  {
    AppMethodBeat.i(133481);
    if (this.IPC == null) {
      this.IPC = new c(this.mColumns, (byte)0);
    }
    AppMethodBeat.o(133481);
  }
  
  public final void a(a parama)
  {
    this.IPz = parama;
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    AppMethodBeat.i(133499);
    if ((this.IPA) && (this.IPB != null))
    {
      if ((!this.IPD) && ((paramObject instanceof Object[])) && (this.IPB.dX(paramObject)))
      {
        this.mCount -= ((Object[])paramObject).length;
        this.pageSize -= ((Object[])paramObject).length;
      }
      b localb = this.IPB;
      if (parama != null)
      {
        ad.v("MicroMsg.CursorDataWindow", "newcursor cursor update Memory key : " + paramObject + "values : " + parama);
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
            localb.IPm.remove(parama);
            i += 1;
          }
          localb.E(paramObject);
        }
        else
        {
          if (localb.IPn == null) {
            localb.IPn = new ArrayList();
          }
          if (!localb.IPn.contains(paramObject))
          {
            localb.IPn.add(paramObject);
            ad.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : ".concat(String.valueOf(paramObject)));
          }
          localb.IPm.remove(paramObject);
        }
      }
    }
    if (!this.IPA)
    {
      paramObject = this.IPC;
      paramObject.mPos = 0;
      paramObject.IPp.clear();
    }
    AppMethodBeat.o(133499);
    return false;
  }
  
  public final boolean abi(int paramInt)
  {
    if (!this.IPA) {}
    b localb;
    do
    {
      do
      {
        return false;
        localb = this.IPB;
      } while (paramInt > 50);
      if (localb.IPl < 10) {
        return true;
      }
    } while (paramInt / localb.IPl >= 0.1D);
    return true;
  }
  
  public final a abj(int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(133498);
    if (this.IPB != null)
    {
      b localb = this.IPB;
      if (localb.abl(paramInt))
      {
        Object localObject2 = localb.IPk.get(paramInt);
        a locala = (a)localb.IPm.get(localObject2);
        localObject1 = locala;
        if (locala == null)
        {
          ad.i("MicroMsg.CursorDataWindow", "get data null %s", new Object[] { localObject2 });
          if (localb.IPn.size() != 0)
          {
            localObject1 = localb.aV(localb.IPn);
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
                  ad.e("MicroMsg.CursorDataWindow", "newcursor obj is null");
                }
              }
            }
            localb.IPn.clear();
          }
          locala = (a)localb.IPm.get(localObject2);
          localObject1 = locala;
          if (locala == null)
          {
            ad.e("MicroMsg.CursorDataWindow", "newcursor error obj : " + localObject2 + "pos:" + paramInt);
            localObject1 = locala;
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(133498);
        return localObject1;
        ad.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + paramInt + " loaded num :" + localb.IPk.size());
      }
    }
    AppMethodBeat.o(133498);
    return null;
  }
  
  public final void abk(int paramInt)
  {
    if ((paramInt <= 15000) && (paramInt >= 2000)) {
      this.pageSize = paramInt;
    }
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
      this.IPx.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally
    {
      AppMethodBeat.o(133487);
    }
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final boolean dX(Object paramObject)
  {
    AppMethodBeat.i(133500);
    if (!this.IPA)
    {
      AppMethodBeat.o(133500);
      return false;
    }
    if (this.IPB == null)
    {
      AppMethodBeat.o(133500);
      return false;
    }
    boolean bool = this.IPB.dX(paramObject);
    AppMethodBeat.o(133500);
    return bool;
  }
  
  public final a dY(Object paramObject)
  {
    AppMethodBeat.i(133501);
    if (!this.IPA)
    {
      Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error ".concat(String.valueOf(paramObject)));
      AppMethodBeat.o(133501);
      return null;
    }
    if (this.IPB == null)
    {
      Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
      AppMethodBeat.o(133501);
      return null;
    }
    b localb = this.IPB;
    if (localb.IPm == null)
    {
      AppMethodBeat.o(133501);
      return null;
    }
    paramObject = (a)localb.IPm.get(paramObject);
    AppMethodBeat.o(133501);
    return paramObject;
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(133486);
    super.deactivate();
    this.mDriver.cursorDeactivated();
    AppMethodBeat.o(133486);
  }
  
  public final void finalize()
  {
    AppMethodBeat.i(133489);
    try
    {
      if (this.IPB != null) {
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
  
  public final SparseArray<Object>[] ftH()
  {
    if (!this.IPA) {
      return null;
    }
    return new SparseArray[] { this.IPB.IPk };
  }
  
  public final HashMap ftI()
  {
    return this.IPB.IPm;
  }
  
  public final boolean ftJ()
  {
    return this.IPD;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(133497);
    if (!this.IPA)
    {
      byte[] arrayOfByte = this.IPC.getBlob(paramInt);
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
      Log.e("WCDB.SQLiteNewCursor", "requesting column name with table name -- ".concat(String.valueOf(paramString)), new Object[] { localObject });
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
      this.mCount = abm(0);
      if (this.IPB != null) {
        if ((this.mCount == -1) || (this.mCount != this.IPB.IPk.size())) {
          break label91;
        }
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      this.IPD = bool;
      if ((!this.IPA) || (!this.IPD)) {
        break label115;
      }
      if (this.IPB != null) {
        break;
      }
      AppMethodBeat.o(133482);
      return 0;
    }
    int i = this.IPB.IPk.size();
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
    if (!this.IPA)
    {
      double d = this.IPC.getDouble(paramInt);
      AppMethodBeat.o(133495);
      return d;
    }
    AppMethodBeat.o(133495);
    return 0.0D;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(133494);
    if (!this.IPA)
    {
      float f = this.IPC.getFloat(paramInt);
      AppMethodBeat.o(133494);
      return f;
    }
    AppMethodBeat.o(133494);
    return 0.0F;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(133492);
    if (!this.IPA)
    {
      paramInt = this.IPC.getInt(paramInt);
      AppMethodBeat.o(133492);
      return paramInt;
    }
    AppMethodBeat.o(133492);
    return 0;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(133493);
    if (!this.IPA)
    {
      long l = this.IPC.getLong(paramInt);
      AppMethodBeat.o(133493);
      return l;
    }
    AppMethodBeat.o(133493);
    return 0L;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(133491);
    if (!this.IPA)
    {
      short s = this.IPC.getShort(paramInt);
      AppMethodBeat.o(133491);
      return s;
    }
    AppMethodBeat.o(133491);
    return 0;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(133490);
    if (!this.IPA)
    {
      String str = this.IPC.getString(paramInt);
      AppMethodBeat.o(133490);
      return str;
    }
    AppMethodBeat.o(133490);
    return null;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(133496);
    if (!this.IPA)
    {
      boolean bool = this.IPC.isNull(paramInt);
      AppMethodBeat.o(133496);
      return bool;
    }
    AppMethodBeat.o(133496);
    return false;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133480);
    if (this.IPA)
    {
      if ((this.IPB == null) || (!this.IPB.abl(paramInt2))) {
        abm(paramInt2 / this.pageSize * this.pageSize);
      }
      AppMethodBeat.o(133480);
      return true;
    }
    if (this.IPC == null) {
      ftW();
    }
    c localc = this.IPC;
    paramInt1 = paramInt2 / localc.IPq;
    if (localc.IPp.indexOfKey(paramInt1) >= 0)
    {
      int i = localc.IPq;
      int j = localc.columnCount;
      if (((Object[])localc.IPp.get(paramInt1))[(paramInt2 % i * j)] == null) {}
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        abm(paramInt2 / this.pageSize * this.pageSize);
      }
      this.IPC.moveToPosition(paramInt2);
      break;
    }
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  /* Error */
  public final boolean requery()
  {
    // Byte code:
    //   0: ldc_w 439
    //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 442	com/tencent/mm/storagebase/a/f:isClosed	()Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 439
    //   16: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 83	com/tencent/mm/storagebase/a/f:IPx	Lcom/tencent/mm/storagebase/a/h;
    //   27: invokevirtual 446	com/tencent/mm/storagebase/a/h:getDatabase	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   30: invokevirtual 451	com/tencent/wcdb/database/SQLiteDatabase:isOpen	()Z
    //   33: ifne +13 -> 46
    //   36: aload_0
    //   37: monitorexit
    //   38: ldc_w 439
    //   41: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: getfield 107	com/tencent/mm/storagebase/a/f:IPB	Lcom/tencent/mm/storagebase/a/b;
    //   50: ifnull +10 -> 60
    //   53: aload_0
    //   54: getfield 107	com/tencent/mm/storagebase/a/f:IPB	Lcom/tencent/mm/storagebase/a/b;
    //   57: invokevirtual 454	com/tencent/mm/storagebase/a/b:clearData	()V
    //   60: aload_0
    //   61: iconst_m1
    //   62: putfield 455	com/tencent/mm/storagebase/a/f:mPos	I
    //   65: aload_0
    //   66: iconst_m1
    //   67: putfield 64	com/tencent/mm/storagebase/a/f:mCount	I
    //   70: aload_0
    //   71: getfield 77	com/tencent/mm/storagebase/a/f:mDriver	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   74: aload_0
    //   75: invokeinterface 459 2 0
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_0
    //   83: invokespecial 461	com/tencent/wcdb/AbstractCursor:requery	()Z
    //   86: istore_1
    //   87: ldc_w 439
    //   90: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iload_1
    //   94: ireturn
    //   95: astore_2
    //   96: aload_0
    //   97: monitorexit
    //   98: ldc_w 439
    //   101: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_2
    //   105: athrow
    //   106: astore_2
    //   107: ldc_w 313
    //   110: new 149	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 463
    //   117: invokespecial 152	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 466	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_1
    //   131: anewarray 256	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_2
    //   137: aastore
    //   138: invokestatic 469	com/tencent/wcdb/support/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: ldc_w 439
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
    //   96	98	95	finally
    //   82	87	106	java/lang/IllegalStateException
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final void wS(boolean paramBoolean)
  {
    this.IPA = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<a> aV(ArrayList<Object> paramArrayList);
    
    public abstract a ftV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.f
 * JD-Core Version:    0.7.0.1
 */