package com.tencent.mm.storagebase.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;

public final class c
  extends AbstractCursor
{
  SparseArray<Object[]> JjX;
  public int JjY;
  int JjZ;
  final int columnCount;
  private final String[] columnNames;
  
  private c(String[] paramArrayOfString)
  {
    AppMethodBeat.i(133434);
    this.JjY = 3000;
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    this.JjX = new SparseArray();
    AppMethodBeat.o(133434);
  }
  
  public c(String[] paramArrayOfString, byte paramByte)
  {
    this(paramArrayOfString);
  }
  
  private Object get(int paramInt)
  {
    AppMethodBeat.i(133435);
    if ((paramInt < 0) || (paramInt >= this.columnCount))
    {
      localObject = new CursorIndexOutOfBoundsException("Requested column: " + paramInt + ", # of columns: " + this.columnCount);
      AppMethodBeat.o(133435);
      throw ((Throwable)localObject);
    }
    if (this.mPos < 0)
    {
      localObject = new CursorIndexOutOfBoundsException("Before first row.");
      AppMethodBeat.o(133435);
      throw ((Throwable)localObject);
    }
    if (this.mPos >= this.JjZ)
    {
      localObject = new CursorIndexOutOfBoundsException("After last row.");
      AppMethodBeat.o(133435);
      throw ((Throwable)localObject);
    }
    int i = this.mPos / this.JjY;
    int j = this.mPos;
    int k = this.JjY;
    int m = this.columnCount;
    Object localObject = ((Object[])this.JjX.get(i))[(j % k * m + paramInt)];
    AppMethodBeat.o(133435);
    return localObject;
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(133443);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133443);
      return null;
    }
    localObject = (byte[])localObject;
    AppMethodBeat.o(133443);
    return localObject;
  }
  
  public final String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public final int getCount()
  {
    return this.JjZ;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(133441);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133441);
      return 0.0D;
    }
    if ((localObject instanceof Number))
    {
      d = ((Number)localObject).doubleValue();
      AppMethodBeat.o(133441);
      return d;
    }
    double d = Double.parseDouble(localObject.toString());
    AppMethodBeat.o(133441);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(133440);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133440);
      return 0.0F;
    }
    if ((localObject instanceof Number))
    {
      f = ((Number)localObject).floatValue();
      AppMethodBeat.o(133440);
      return f;
    }
    float f = Float.parseFloat(localObject.toString());
    AppMethodBeat.o(133440);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(133438);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133438);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(133438);
      return paramInt;
    }
    paramInt = Integer.parseInt(localObject.toString());
    AppMethodBeat.o(133438);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(133439);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133439);
      return 0L;
    }
    if ((localObject instanceof Number))
    {
      l = ((Number)localObject).longValue();
      AppMethodBeat.o(133439);
      return l;
    }
    long l = Long.parseLong(localObject.toString());
    AppMethodBeat.o(133439);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(133437);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133437);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      s = ((Number)localObject).shortValue();
      AppMethodBeat.o(133437);
      return s;
    }
    short s = Short.parseShort(localObject.toString());
    AppMethodBeat.o(133437);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(133436);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133436);
      return null;
    }
    localObject = localObject.toString();
    AppMethodBeat.o(133436);
    return localObject;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(133442);
    if (get(paramInt) == null)
    {
      AppMethodBeat.o(133442);
      return true;
    }
    AppMethodBeat.o(133442);
    return false;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public final class a
  {
    Object[] Jka;
    final int endIndex;
    int index;
    
    a(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
    {
      this.index = paramInt1;
      this.endIndex = paramInt2;
      this.Jka = paramArrayOfObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.c
 * JD-Core Version:    0.7.0.1
 */