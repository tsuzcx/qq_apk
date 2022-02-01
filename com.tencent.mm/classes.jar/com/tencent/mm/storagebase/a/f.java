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
  private final h FDe;
  private final Throwable FDf;
  public a FDg;
  private boolean FDh;
  private b<a> FDi;
  c FDj;
  private boolean FDk;
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
    this.FDf = null;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.FDe = paramh;
    this.mColumns = paramh.getColumnNames();
    this.mRowIdColumnIndex = DatabaseUtils.findRowIdColumnIndex(this.mColumns);
    AppMethodBeat.o(133479);
  }
  
  private int WT(int paramInt)
  {
    AppMethodBeat.i(133484);
    if (this.FDh)
    {
      if (this.FDi == null) {
        this.FDi = new b()
        {
          public final ArrayList<a> aM(ArrayList<Object> paramAnonymousArrayList)
          {
            AppMethodBeat.i(133476);
            f localf = f.this;
            if (localf.FDg != null)
            {
              paramAnonymousArrayList = localf.FDg.aM(paramAnonymousArrayList);
              AppMethodBeat.o(133476);
              return paramAnonymousArrayList;
            }
            AppMethodBeat.o(133476);
            return null;
          }
          
          public final a eOj()
          {
            AppMethodBeat.i(133475);
            Object localObject = f.this;
            if (((f)localObject).FDg != null)
            {
              localObject = ((f)localObject).FDg.eOj();
              AppMethodBeat.o(133475);
              return localObject;
            }
            AppMethodBeat.o(133475);
            return null;
          }
        };
      }
      this.FDi.mStartPos = paramInt;
      paramInt = this.FDe.a(this.FDi, paramInt, this.pageSize);
      AppMethodBeat.o(133484);
      return paramInt;
    }
    eOk();
    paramInt = this.FDe.a(this.FDj, paramInt, this.pageSize);
    AppMethodBeat.o(133484);
    return paramInt;
  }
  
  private void eOk()
  {
    AppMethodBeat.i(133481);
    if (this.FDj == null) {
      this.FDj = new c(this.mColumns, (byte)0);
    }
    AppMethodBeat.o(133481);
  }
  
  public final boolean WP(int paramInt)
  {
    if (!this.FDh) {}
    b localb;
    do
    {
      do
      {
        return false;
        localb = this.FDi;
      } while (paramInt > 50);
      if (localb.FCS < 10) {
        return true;
      }
    } while (paramInt / localb.FCS >= 0.1D);
    return true;
  }
  
  public final a WQ(int paramInt)
  {
    Object localObject1 = null;
    int i = 0;
    AppMethodBeat.i(133498);
    if (this.FDi != null)
    {
      b localb = this.FDi;
      if (localb.WS(paramInt))
      {
        Object localObject2 = localb.FCR.get(paramInt);
        a locala = (a)localb.FCT.get(localObject2);
        localObject1 = locala;
        if (locala == null)
        {
          ad.i("MicroMsg.CursorDataWindow", "get data null %s", new Object[] { localObject2 });
          if (localb.FCU.size() != 0)
          {
            localObject1 = localb.aM(localb.FCU);
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
            localb.FCU.clear();
          }
          locala = (a)localb.FCT.get(localObject2);
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
        ad.e("MicroMsg.CursorDataWindow", "newcursor cursor getItem error: pos " + paramInt + " loaded num :" + localb.FCR.size());
      }
    }
    AppMethodBeat.o(133498);
    return null;
  }
  
  public final void WR(int paramInt)
  {
    if ((paramInt <= 15000) && (paramInt >= 2000)) {
      this.pageSize = paramInt;
    }
  }
  
  public final void a(a parama)
  {
    this.FDg = parama;
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    AppMethodBeat.i(133499);
    if ((this.FDh) && (this.FDi != null))
    {
      if ((!this.FDk) && ((paramObject instanceof Object[])) && (this.FDi.dT(paramObject)))
      {
        this.mCount -= ((Object[])paramObject).length;
        this.pageSize -= ((Object[])paramObject).length;
      }
      b localb = this.FDi;
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
            localb.FCT.remove(parama);
            i += 1;
          }
          localb.B(paramObject);
        }
        else
        {
          if (localb.FCU == null) {
            localb.FCU = new ArrayList();
          }
          if (!localb.FCU.contains(paramObject))
          {
            localb.FCU.add(paramObject);
            ad.i("MicroMsg.CursorDataWindow", "newcursor cursor clearData : ".concat(String.valueOf(paramObject)));
          }
          localb.FCT.remove(paramObject);
        }
      }
    }
    if (!this.FDh)
    {
      paramObject = this.FDj;
      paramObject.mPos = 0;
      paramObject.FCW.clear();
    }
    AppMethodBeat.o(133499);
    return false;
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
      this.FDe.close();
      this.mDriver.cursorClosed();
      return;
    }
    finally
    {
      AppMethodBeat.o(133487);
    }
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final boolean dT(Object paramObject)
  {
    AppMethodBeat.i(133500);
    if (!this.FDh)
    {
      AppMethodBeat.o(133500);
      return false;
    }
    if (this.FDi == null)
    {
      AppMethodBeat.o(133500);
      return false;
    }
    boolean bool = this.FDi.dT(paramObject);
    AppMethodBeat.o(133500);
    return bool;
  }
  
  public final a dU(Object paramObject)
  {
    AppMethodBeat.i(133501);
    if (!this.FDh)
    {
      Log.e("WCDB.SQLiteNewCursor", "newcursor getItemByKey error ".concat(String.valueOf(paramObject)));
      AppMethodBeat.o(133501);
      return null;
    }
    if (this.FDi == null)
    {
      Log.e("WCDB.SQLiteNewCursor", "newcursor error getItemByKey window is null");
      AppMethodBeat.o(133501);
      return null;
    }
    b localb = this.FDi;
    if (localb.FCT == null)
    {
      AppMethodBeat.o(133501);
      return null;
    }
    paramObject = (a)localb.FCT.get(paramObject);
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
  
  public final SparseArray<Object>[] eNV()
  {
    if (!this.FDh) {
      return null;
    }
    return new SparseArray[] { this.FDi.FCR };
  }
  
  public final HashMap eNW()
  {
    return this.FDi.FCT;
  }
  
  public final boolean eNX()
  {
    return this.FDk;
  }
  
  public final void finalize()
  {
    AppMethodBeat.i(133489);
    try
    {
      if (this.FDi != null) {
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
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(133497);
    if (!this.FDh)
    {
      byte[] arrayOfByte = this.FDj.getBlob(paramInt);
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
      this.mCount = WT(0);
      if (this.FDi != null) {
        if ((this.mCount == -1) || (this.mCount != this.FDi.FCR.size())) {
          break label91;
        }
      }
    }
    label91:
    for (boolean bool = true;; bool = false)
    {
      this.FDk = bool;
      if ((!this.FDh) || (!this.FDk)) {
        break label115;
      }
      if (this.FDi != null) {
        break;
      }
      AppMethodBeat.o(133482);
      return 0;
    }
    int i = this.FDi.FCR.size();
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
    if (!this.FDh)
    {
      double d = this.FDj.getDouble(paramInt);
      AppMethodBeat.o(133495);
      return d;
    }
    AppMethodBeat.o(133495);
    return 0.0D;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(133494);
    if (!this.FDh)
    {
      float f = this.FDj.getFloat(paramInt);
      AppMethodBeat.o(133494);
      return f;
    }
    AppMethodBeat.o(133494);
    return 0.0F;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(133492);
    if (!this.FDh)
    {
      paramInt = this.FDj.getInt(paramInt);
      AppMethodBeat.o(133492);
      return paramInt;
    }
    AppMethodBeat.o(133492);
    return 0;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(133493);
    if (!this.FDh)
    {
      long l = this.FDj.getLong(paramInt);
      AppMethodBeat.o(133493);
      return l;
    }
    AppMethodBeat.o(133493);
    return 0L;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(133491);
    if (!this.FDh)
    {
      short s = this.FDj.getShort(paramInt);
      AppMethodBeat.o(133491);
      return s;
    }
    AppMethodBeat.o(133491);
    return 0;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(133490);
    if (!this.FDh)
    {
      String str = this.FDj.getString(paramInt);
      AppMethodBeat.o(133490);
      return str;
    }
    AppMethodBeat.o(133490);
    return null;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(133496);
    if (!this.FDh)
    {
      boolean bool = this.FDj.isNull(paramInt);
      AppMethodBeat.o(133496);
      return bool;
    }
    AppMethodBeat.o(133496);
    return false;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133480);
    if (this.FDh)
    {
      if ((this.FDi == null) || (!this.FDi.WS(paramInt2))) {
        WT(paramInt2 / this.pageSize * this.pageSize);
      }
      AppMethodBeat.o(133480);
      return true;
    }
    if (this.FDj == null) {
      eOk();
    }
    c localc = this.FDj;
    paramInt1 = paramInt2 / localc.FCX;
    if (localc.FCW.indexOfKey(paramInt1) >= 0)
    {
      int i = localc.FCX;
      int j = localc.columnCount;
      if (((Object[])localc.FCW.get(paramInt1))[(paramInt2 % i * j)] == null) {}
    }
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        WT(paramInt2 / this.pageSize * this.pageSize);
      }
      this.FDj.moveToPosition(paramInt2);
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
    //   24: getfield 83	com/tencent/mm/storagebase/a/f:FDe	Lcom/tencent/mm/storagebase/a/h;
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
    //   47: getfield 107	com/tencent/mm/storagebase/a/f:FDi	Lcom/tencent/mm/storagebase/a/b;
    //   50: ifnull +10 -> 60
    //   53: aload_0
    //   54: getfield 107	com/tencent/mm/storagebase/a/f:FDi	Lcom/tencent/mm/storagebase/a/b;
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
    //   110: new 211	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 463
    //   117: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_2
    //   121: invokevirtual 466	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   124: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_1
    //   131: anewarray 172	java/lang/Object
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
  
  public final void ve(boolean paramBoolean)
  {
    this.FDh = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract ArrayList<a> aM(ArrayList<Object> paramArrayList);
    
    public abstract a eOj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.f
 * JD-Core Version:    0.7.0.1
 */