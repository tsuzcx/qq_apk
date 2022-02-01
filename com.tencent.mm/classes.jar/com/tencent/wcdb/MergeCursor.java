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
    AppMethodBeat.i(2872);
    this.mObserver = new DataSetObserver()
    {
      public void onChanged()
      {
        MergeCursor.this.mPos = -1;
      }
      
      public void onInvalidated()
      {
        MergeCursor.this.mPos = -1;
      }
    };
    this.mCursors = paramArrayOfCursor;
    this.mCursor = paramArrayOfCursor[0];
    while (i < this.mCursors.length)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(2872);
  }
  
  public void close()
  {
    AppMethodBeat.i(2886);
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
    AppMethodBeat.o(2886);
  }
  
  public void deactivate()
  {
    AppMethodBeat.i(2885);
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
    AppMethodBeat.o(2885);
  }
  
  public byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(2883);
    byte[] arrayOfByte = this.mCursor.getBlob(paramInt);
    AppMethodBeat.o(2883);
    return arrayOfByte;
  }
  
  public String[] getColumnNames()
  {
    AppMethodBeat.i(2884);
    if (this.mCursor != null)
    {
      String[] arrayOfString = this.mCursor.getColumnNames();
      AppMethodBeat.o(2884);
      return arrayOfString;
    }
    AppMethodBeat.o(2884);
    return new String[0];
  }
  
  public int getCount()
  {
    AppMethodBeat.i(2873);
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
    AppMethodBeat.o(2873);
    return j;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(2880);
    double d = this.mCursor.getDouble(paramInt);
    AppMethodBeat.o(2880);
    return d;
  }
  
  public float getFloat(int paramInt)
  {
    AppMethodBeat.i(2879);
    float f = this.mCursor.getFloat(paramInt);
    AppMethodBeat.o(2879);
    return f;
  }
  
  public int getInt(int paramInt)
  {
    AppMethodBeat.i(2877);
    paramInt = this.mCursor.getInt(paramInt);
    AppMethodBeat.o(2877);
    return paramInt;
  }
  
  public long getLong(int paramInt)
  {
    AppMethodBeat.i(2878);
    long l = this.mCursor.getLong(paramInt);
    AppMethodBeat.o(2878);
    return l;
  }
  
  public short getShort(int paramInt)
  {
    AppMethodBeat.i(2876);
    short s = this.mCursor.getShort(paramInt);
    AppMethodBeat.o(2876);
    return s;
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(2875);
    String str = this.mCursor.getString(paramInt);
    AppMethodBeat.o(2875);
    return str;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(2881);
    paramInt = this.mCursor.getType(paramInt);
    AppMethodBeat.o(2881);
    return paramInt;
  }
  
  public boolean isNull(int paramInt)
  {
    AppMethodBeat.i(2882);
    boolean bool = this.mCursor.isNull(paramInt);
    AppMethodBeat.o(2882);
    return bool;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2874);
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
        AppMethodBeat.o(2874);
        return bool;
      }
      j = i + this.mCursors[paramInt1].getCount();
      label112:
      paramInt1 += 1;
    }
    AppMethodBeat.o(2874);
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(2887);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(2887);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(2889);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(2889);
  }
  
  public boolean requery()
  {
    AppMethodBeat.i(2891);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if ((this.mCursors[i] != null) && (!this.mCursors[i].requery()))
      {
        AppMethodBeat.o(2891);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(2891);
    return true;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(2888);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(2888);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(2890);
    int j = this.mCursors.length;
    int i = 0;
    while (i < j)
    {
      if (this.mCursors[i] != null) {
        this.mCursors[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(2890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.wcdb.MergeCursor
 * JD-Core Version:    0.7.0.1
 */