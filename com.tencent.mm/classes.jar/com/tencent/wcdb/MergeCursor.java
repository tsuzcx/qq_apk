package com.tencent.wcdb;

import android.database.ContentObserver;
import android.database.DataSetObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MergeCursor
  extends AbstractCursor
{
  private Cursor mCursor;
  private Cursor[] mCursors;
  private DataSetObserver mObserver;
  
  public MergeCursor(Cursor[] paramArrayOfCursor)
  {
    AppMethodBeat.i(12191);
    this.mObserver = new MergeCursor.1(this);
    this.mCursors = paramArrayOfCursor;
    this.mCursor = paramArrayOfCursor[0];
    while (i < this.mCursors.length)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(12191);
  }
  
  public void close()
  {
    AppMethodBeat.i(12205);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(12205);
  }
  
  public void deactivate()
  {
    AppMethodBeat.i(12204);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(12204);
  }
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(12202);
    byte[] arrayOfByte = this.mCursor.getBlob(paramInt);
    AppMethodBeat.o(12202);
    return arrayOfByte;
  }
  
  public String[] getColumnNames()
  {
    AppMethodBeat.i(12203);
    if (this.mCursor != null)
    {
      String[] arrayOfString = this.mCursor.getColumnNames();
      AppMethodBeat.o(12203);
      return arrayOfString;
    }
    AppMethodBeat.o(12203);
    return new String[0];
  }
  
  public int getCount()
  {
    AppMethodBeat.i(12192);
    int m = this.mCursors.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (this.mCursors[i] != null) {
        k = j + this.mCursors[i].getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(12192);
    return j;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(12199);
    double d = this.mCursor.getDouble(paramInt);
    AppMethodBeat.o(12199);
    return d;
  }
  
  public float getFloat(int paramInt)
  {
    AppMethodBeat.i(12198);
    float f = this.mCursor.getFloat(paramInt);
    AppMethodBeat.o(12198);
    return f;
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(12196);
    paramInt = this.mCursor.getInt(paramInt);
    AppMethodBeat.o(12196);
    return paramInt;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(12197);
    long l = this.mCursor.getLong(paramInt);
    AppMethodBeat.o(12197);
    return l;
  }
  
  public short getShort(int paramInt)
  {
    AppMethodBeat.i(12195);
    short s = this.mCursor.getShort(paramInt);
    AppMethodBeat.o(12195);
    return s;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(12194);
    String str = this.mCursor.getString(paramInt);
    AppMethodBeat.o(12194);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(12200);
    paramInt = this.mCursor.getType(paramInt);
    AppMethodBeat.o(12200);
    return paramInt;
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(12201);
    boolean bool = this.mCursor.isNull(paramInt);
    AppMethodBeat.o(12201);
    return bool;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12193);
    this.mCursor = null;
    int k = this.mCursors.length;
    paramInt1 = 0;
    int j;
    for (int i = 0;; i = j)
    {
      if (paramInt1 < k)
      {
        j = i;
        if (this.mCursors[paramInt1] == null) {
          break label112;
        }
        if (paramInt2 < this.mCursors[paramInt1].getCount() + i) {
          this.mCursor = this.mCursors[paramInt1];
        }
      }
      else
      {
        if (this.mCursor == null) {
          break;
        }
        boolean bool = this.mCursor.moveToPosition(paramInt2 - i);
        AppMethodBeat.o(12193);
        return bool;
      }
      j = i + this.mCursors[paramInt1].getCount();
      label112:
      paramInt1 += 1;
    }
    AppMethodBeat.o(12193);
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(12206);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(12206);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(12208);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(12208);
  }
  
  public boolean requery()
  {
    AppMethodBeat.i(12210);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if ((this.mCursors[i] != null) && (!this.mCursors[i].requery()))
      {
        AppMethodBeat.o(12210);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(12210);
    return true;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(12207);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(12207);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(12209);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(12209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.wcdb.MergeCursor
 * JD-Core Version:    0.7.0.1
 */