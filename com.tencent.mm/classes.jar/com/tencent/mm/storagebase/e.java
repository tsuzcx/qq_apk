package com.tencent.mm.storagebase;

import android.database.AbstractCursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class e
  extends AbstractCursor
{
  private final int columnCount;
  private final String[] columnNames;
  private Object[] data;
  private int rowCount;
  
  private e(String[] paramArrayOfString)
  {
    AppMethodBeat.i(133331);
    this.rowCount = 0;
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    this.data = new Object[this.columnCount * 16];
    AppMethodBeat.o(133331);
  }
  
  public e(String[] paramArrayOfString, byte paramByte)
  {
    this(paramArrayOfString);
  }
  
  private static int dZ(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double))) {
      return 2;
    }
    if (((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte))) {
      return 1;
    }
    return 3;
  }
  
  private void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(133334);
    Object[] arrayOfObject;
    int i;
    if (paramInt > this.data.length)
    {
      arrayOfObject = this.data;
      i = this.data.length * 2;
      if (i >= paramInt) {
        break label58;
      }
    }
    for (;;)
    {
      this.data = new Object[paramInt];
      System.arraycopy(arrayOfObject, 0, this.data, 0, arrayOfObject.length);
      AppMethodBeat.o(133334);
      return;
      label58:
      paramInt = i;
    }
  }
  
  private Object get(int paramInt)
  {
    AppMethodBeat.i(133332);
    if ((paramInt < 0) || (paramInt >= this.columnCount))
    {
      localObject = new CursorIndexOutOfBoundsException("Requested column: " + paramInt + ", # of columns: " + this.columnCount);
      AppMethodBeat.o(133332);
      throw ((Throwable)localObject);
    }
    if (this.mPos < 0)
    {
      localObject = new CursorIndexOutOfBoundsException("Before first row.");
      AppMethodBeat.o(133332);
      throw ((Throwable)localObject);
    }
    if (this.mPos >= this.rowCount)
    {
      localObject = new CursorIndexOutOfBoundsException("After last row.");
      AppMethodBeat.o(133332);
      throw ((Throwable)localObject);
    }
    Object localObject = this.data[(this.mPos * this.columnCount + paramInt)];
    AppMethodBeat.o(133332);
    return localObject;
  }
  
  public final void addRow(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(133333);
    if (paramArrayOfObject.length != this.columnCount)
    {
      paramArrayOfObject = new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + paramArrayOfObject.length);
      AppMethodBeat.o(133333);
      throw paramArrayOfObject;
    }
    int i = this.rowCount;
    this.rowCount = (i + 1);
    i *= this.columnCount;
    ensureCapacity(this.columnCount + i);
    System.arraycopy(paramArrayOfObject, 0, this.data, i, this.columnCount);
    AppMethodBeat.o(133333);
  }
  
  public final void fillWindow(int paramInt, CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(133344);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      AppMethodBeat.o(133344);
      return;
    }
    paramCursorWindow.acquireReference();
    try
    {
      int j = getPosition();
      int k = getColumnCount();
      paramCursorWindow.clear();
      paramCursorWindow.setStartPosition(paramInt);
      paramCursorWindow.setNumColumns(k);
      int i;
      if (moveToPosition(paramInt)) {
        if (paramCursorWindow.allocRow())
        {
          i = 0;
          label72:
          if (i < k) {
            switch (dZ(get(i)))
            {
            }
          }
        }
      }
      for (;;)
      {
        Object localObject1 = getString(i);
        boolean bool;
        if (localObject1 != null) {
          bool = paramCursorWindow.putString((String)localObject1, paramInt, i);
        }
        for (;;)
        {
          if (bool) {
            break label269;
          }
          paramCursorWindow.freeLastRow();
          paramInt += 1;
          if (moveToNext()) {
            break;
          }
          moveToPosition(j);
          return;
          bool = paramCursorWindow.putNull(paramInt, i);
          continue;
          bool = paramCursorWindow.putLong(getLong(i), paramInt, i);
          continue;
          bool = paramCursorWindow.putDouble(getDouble(i), paramInt, i);
          continue;
          localObject1 = getBlob(i);
          if (localObject1 != null)
          {
            bool = paramCursorWindow.putBlob((byte[])localObject1, paramInt, i);
          }
          else
          {
            bool = paramCursorWindow.putNull(paramInt, i);
            continue;
            bool = paramCursorWindow.putNull(paramInt, i);
          }
        }
        label269:
        i += 1;
        break label72;
      }
    }
    catch (IllegalStateException localIllegalStateException) {}finally
    {
      paramCursorWindow.releaseReference();
      AppMethodBeat.o(133344);
    }
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(133341);
    byte[] arrayOfByte = (byte[])get(paramInt);
    AppMethodBeat.o(133341);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public final int getCount()
  {
    return this.rowCount;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(133340);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133340);
      return 0.0D;
    }
    if ((localObject instanceof Number))
    {
      d = ((Number)localObject).doubleValue();
      AppMethodBeat.o(133340);
      return d;
    }
    double d = bt.getDouble(localObject.toString(), 0.0D);
    AppMethodBeat.o(133340);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(133339);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133339);
      return 0.0F;
    }
    if ((localObject instanceof Number))
    {
      f = ((Number)localObject).floatValue();
      AppMethodBeat.o(133339);
      return f;
    }
    float f = bt.getFloat(localObject.toString(), 0.0F);
    AppMethodBeat.o(133339);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(133337);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133337);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      paramInt = ((Number)localObject).intValue();
      AppMethodBeat.o(133337);
      return paramInt;
    }
    paramInt = bt.getInt(localObject.toString(), 0);
    AppMethodBeat.o(133337);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(133338);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133338);
      return 0L;
    }
    if ((localObject instanceof Number))
    {
      l = ((Number)localObject).longValue();
      AppMethodBeat.o(133338);
      return l;
    }
    long l = bt.getLong(localObject.toString(), 0L);
    AppMethodBeat.o(133338);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(133336);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133336);
      return 0;
    }
    if ((localObject instanceof Number))
    {
      s = ((Number)localObject).shortValue();
      AppMethodBeat.o(133336);
      return s;
    }
    short s = Short.parseShort(localObject.toString());
    AppMethodBeat.o(133336);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(133335);
    Object localObject = get(paramInt);
    if (localObject == null)
    {
      AppMethodBeat.o(133335);
      return null;
    }
    localObject = localObject.toString();
    AppMethodBeat.o(133335);
    return localObject;
  }
  
  public final int getType(int paramInt)
  {
    AppMethodBeat.i(133342);
    paramInt = dZ(get(paramInt));
    AppMethodBeat.o(133342);
    return paramInt;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(133343);
    if (get(paramInt) == null)
    {
      AppMethodBeat.o(133343);
      return true;
    }
    AppMethodBeat.o(133343);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storagebase.e
 * JD-Core Version:    0.7.0.1
 */