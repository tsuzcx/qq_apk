package com.tencent.mm.storagebase.a;

import android.database.CursorIndexOutOfBoundsException;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectQuery;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;

public final class h
  extends SQLiteDirectQuery
{
  h(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, null, paramCancellationSignal);
  }
  
  final int a(b paramb, int paramInt1, int paramInt2)
  {
    int k = 1;
    AppMethodBeat.i(133505);
    acquireReference();
    paramb.acquireReference();
    if (paramInt1 > 0) {}
    int i;
    int j;
    for (;;)
    {
      try
      {
        i = step(paramInt1);
        if (i < paramInt1)
        {
          ad.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
          return i;
        }
        int m = getColumnNames().length;
        i = paramInt1;
        if (i >= paramInt2 + paramInt1) {
          break label460;
        }
        j = k;
        if (step(1) != 1) {
          break;
        }
        paramb.FCV = paramb.eOj();
        j = 0;
        if (j >= m) {
          break label394;
        }
        switch (getType(j))
        {
        case 3: 
          label164:
          paramb.jb(i, 1);
          SQLiteException localSQLiteException1 = new SQLiteException("Unknown column type when filling window.");
          AppMethodBeat.o(133505);
          throw localSQLiteException1;
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ad.printErrStackTrace("WCDB.SQLiteNewQuery", localIllegalStateException, "fillWindow failed", new Object[0]);
        return 0;
        String str = getString(j);
        if (paramb.FCV == null) {
          break label451;
        }
        paramb.FCV.cD(j, str);
        break label451;
        long l = getLong(j);
        if (paramb.FCV == null) {
          break label451;
        }
        paramb.FCV.aE(j, l);
      }
      catch (SQLiteException localSQLiteException2)
      {
        ad.e("WCDB.SQLiteNewQuery", "exception: " + localSQLiteException2.getMessage() + "; query: " + getSql());
        checkCorruption(localSQLiteException2);
        AppMethodBeat.o(133505);
        throw localSQLiteException2;
      }
      finally
      {
        paramb.releaseReference();
        releaseReference();
        AppMethodBeat.o(133505);
      }
      getDouble(j);
      break label451;
      byte[] arrayOfByte = getBlob(j);
      if (paramb.FCV == null) {
        break label451;
      }
      paramb.FCV.t(j, arrayOfByte);
      break label451;
      label394:
      paramb.jb(i, 0);
      i += 1;
    }
    for (;;)
    {
      paramInt1 = i;
      if (j == 0) {
        paramInt1 = i + step(2147483647);
      }
      reset(true);
      paramb.releaseReference();
      releaseReference();
      AppMethodBeat.o(133505);
      return paramInt1;
      break label164;
      label451:
      j += 1;
      break;
      label460:
      j = 0;
    }
  }
  
  final int a(c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133506);
    acquireReference();
    if (paramInt1 > 0) {}
    int i;
    Object localObject;
    for (;;)
    {
      c.a locala;
      try
      {
        i = step(paramInt1);
        if (i < paramInt1)
        {
          ad.w("WCDB.SQLiteNewQuery", "startPos %d > actual rows %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i) });
          return i;
        }
        int k = getColumnNames().length;
        i = paramInt1;
        if (i >= paramInt2 + paramInt1) {
          break;
        }
        if (step(1) != 1) {
          break label531;
        }
        j = i / paramc.FCX;
        if (paramc.FCW.indexOfKey(j) < 0)
        {
          localObject = new Object[paramc.FCX * paramc.columnCount];
          paramc.FCW.put(j, localObject);
          j = paramc.FCX;
          m = paramc.columnCount * (i % j);
          int n = paramc.columnCount;
          j = i + 1;
          if (j <= paramc.FCY) {
            break label347;
          }
          paramc.FCY = j;
          locala = new c.a(paramc, m, m + n, (Object[])localObject);
          j = 0;
          if (j >= k) {
            break label522;
          }
          switch (getType(j))
          {
          case 3: 
            label252:
            paramc = new SQLiteException("Unknown column type when filling window.");
            AppMethodBeat.o(133506);
            throw paramc;
          }
        }
      }
      catch (SQLiteException paramc)
      {
        ad.e("WCDB.SQLiteNewQuery", "exception: " + paramc.getMessage() + "; query: " + getSql());
        checkCorruption(paramc);
        AppMethodBeat.o(133506);
        throw paramc;
      }
      finally
      {
        releaseReference();
        AppMethodBeat.o(133506);
      }
      localObject = (Object[])paramc.FCW.get(j);
      continue;
      label347:
      int j = paramc.FCY;
      continue;
      localObject = getString(j);
      label364:
      while (locala.index == locala.endIndex)
      {
        paramc = new CursorIndexOutOfBoundsException("No more columns left.");
        AppMethodBeat.o(133506);
        throw paramc;
        localObject = Long.valueOf(getLong(j));
        continue;
        localObject = Double.valueOf(getDouble(j));
        continue;
        localObject = getBlob(j);
      }
      Object[] arrayOfObject = locala.FCZ;
      int m = locala.index;
      locala.index = (m + 1);
      arrayOfObject[m] = localObject;
      j += 1;
    }
    for (;;)
    {
      if (paramInt1 == 0) {}
      for (paramInt1 = step(2147483647) + i;; paramInt1 = i)
      {
        reset(true);
        releaseReference();
        AppMethodBeat.o(133506);
        return paramInt1;
      }
      paramInt1 = 0;
      continue;
      break label252;
      localObject = null;
      break label364;
      label522:
      i += 1;
      break;
      label531:
      paramInt1 = 1;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(133507);
    String str = "SQLiteNewQuery: " + getSql();
    AppMethodBeat.o(133507);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.h
 * JD-Core Version:    0.7.0.1
 */