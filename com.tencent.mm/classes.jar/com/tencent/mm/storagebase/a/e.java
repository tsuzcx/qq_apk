package com.tencent.mm.storagebase.a;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.AbstractCursor;
import java.util.HashMap;

public final class e
  extends AbstractCursor
  implements d
{
  private d FDb;
  public d[] FDc;
  private DataSetObserver mObserver;
  
  public e(d[] paramArrayOfd)
  {
    AppMethodBeat.i(133446);
    this.mObserver = new DataSetObserver()
    {
      public final void onChanged()
      {
        AppMethodBeat.i(133444);
        e.a(e.this);
        AppMethodBeat.o(133444);
      }
      
      public final void onInvalidated()
      {
        AppMethodBeat.i(133445);
        e.b(e.this);
        AppMethodBeat.o(133445);
      }
    };
    this.FDc = paramArrayOfd;
    this.FDb = paramArrayOfd[0];
    while (i < this.FDc.length)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133446);
  }
  
  public final boolean WP(int paramInt)
  {
    AppMethodBeat.i(133471);
    int j = this.FDc.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.FDc[i] != null)
      {
        bool2 = bool1;
        if (!this.FDc[i].WP(paramInt)) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    AppMethodBeat.o(133471);
    return bool1;
  }
  
  public final a WQ(int paramInt)
  {
    AppMethodBeat.i(133468);
    int k = this.FDc.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      j = this.FDc[paramInt].getCount();
      if (i < j)
      {
        a locala = this.FDc[paramInt].WQ(i);
        AppMethodBeat.o(133468);
        return locala;
      }
      i -= j;
      paramInt += 1;
    }
    AppMethodBeat.o(133468);
    return null;
  }
  
  public final void WR(int paramInt)
  {
    AppMethodBeat.i(133474);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].WR(paramInt);
      }
      i += 1;
    }
    AppMethodBeat.o(133474);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(133465);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].a(parama);
      }
      i += 1;
    }
    AppMethodBeat.o(133465);
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    AppMethodBeat.i(133469);
    int j = this.FDc.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.FDc[i] != null)
      {
        bool2 = bool1;
        if (this.FDc[i].a(paramObject, parama)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(133469);
    return bool1;
  }
  
  public final void close()
  {
    AppMethodBeat.i(133459);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(133459);
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final boolean dT(Object paramObject)
  {
    AppMethodBeat.i(133472);
    int j = this.FDc.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.FDc[i] != null)
      {
        bool2 = bool1;
        if (this.FDc[i].dT(paramObject)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(133472);
    return bool1;
  }
  
  public final a dU(Object paramObject)
  {
    AppMethodBeat.i(133473);
    paramObject = this.FDb.dU(paramObject);
    AppMethodBeat.o(133473);
    return paramObject;
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(133458);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(133458);
  }
  
  public final SparseArray<Object>[] eNV()
  {
    AppMethodBeat.i(133470);
    int j = this.FDc.length;
    SparseArray[] arrayOfSparseArray = new SparseArray[j];
    int i = 0;
    if (i < j)
    {
      Object localObject = this.FDc[i].eNV();
      if (localObject != null) {}
      for (localObject = localObject[0];; localObject = null)
      {
        arrayOfSparseArray[i] = localObject;
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(133470);
    return arrayOfSparseArray;
  }
  
  public final HashMap eNW()
  {
    return null;
  }
  
  public final boolean eNX()
  {
    AppMethodBeat.i(133467);
    int j = this.FDc.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.FDc[i] != null)
      {
        bool2 = bool1;
        if (!this.FDc[i].eNX()) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    AppMethodBeat.o(133467);
    return bool1;
  }
  
  public final byte[] getBlob(int paramInt)
  {
    AppMethodBeat.i(133456);
    byte[] arrayOfByte = this.FDb.getBlob(paramInt);
    AppMethodBeat.o(133456);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(133457);
    if (this.FDb != null)
    {
      String[] arrayOfString = this.FDb.getColumnNames();
      AppMethodBeat.o(133457);
      return arrayOfString;
    }
    AppMethodBeat.o(133457);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(133447);
    int m = this.FDc.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (this.FDc[i] != null) {
        k = j + this.FDc[i].getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(133447);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(133454);
    double d = this.FDb.getDouble(paramInt);
    AppMethodBeat.o(133454);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(133453);
    float f = this.FDb.getFloat(paramInt);
    AppMethodBeat.o(133453);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(133451);
    paramInt = this.FDb.getInt(paramInt);
    AppMethodBeat.o(133451);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(133452);
    long l = this.FDb.getLong(paramInt);
    AppMethodBeat.o(133452);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(133450);
    short s = this.FDb.getShort(paramInt);
    AppMethodBeat.o(133450);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(133449);
    String str = this.FDb.getString(paramInt);
    AppMethodBeat.o(133449);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(133455);
    boolean bool = this.FDb.isNull(paramInt);
    AppMethodBeat.o(133455);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133448);
    this.FDb = null;
    int k = this.FDc.length;
    paramInt1 = 0;
    int j;
    for (int i = 0;; i = j)
    {
      if (paramInt1 < k)
      {
        j = i;
        if (this.FDc[paramInt1] == null) {
          break label110;
        }
        if (paramInt2 < this.FDc[paramInt1].getCount() + i) {
          this.FDb = this.FDc[paramInt1];
        }
      }
      else
      {
        if (this.FDb == null) {
          break;
        }
        boolean bool = this.FDb.moveToPosition(paramInt2 - i);
        AppMethodBeat.o(133448);
        return bool;
      }
      j = i + this.FDc[paramInt1].getCount();
      label110:
      paramInt1 += 1;
    }
    AppMethodBeat.o(133448);
    return false;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(133460);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133460);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(133462);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133462);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(133464);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if ((this.FDc[i] != null) && (!this.FDc[i].requery()))
      {
        AppMethodBeat.o(133464);
        return false;
      }
      i += 1;
    }
    AppMethodBeat.o(133464);
    return true;
  }
  
  public final void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(133461);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133461);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(133463);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133463);
  }
  
  public final void ve(boolean paramBoolean)
  {
    AppMethodBeat.i(133466);
    int j = this.FDc.length;
    int i = 0;
    while (i < j)
    {
      if (this.FDc[i] != null) {
        this.FDc[i].ve(paramBoolean);
      }
      i += 1;
    }
    AppMethodBeat.o(133466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.e
 * JD-Core Version:    0.7.0.1
 */