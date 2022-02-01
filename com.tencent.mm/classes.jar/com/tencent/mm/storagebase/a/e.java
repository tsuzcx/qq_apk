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
  private d Jkc;
  public d[] Jkd;
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
    this.Jkd = paramArrayOfd;
    this.Jkc = paramArrayOfd[0];
    while (i < this.Jkd.length)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].registerDataSetObserver(this.mObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133446);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(133465);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].a(parama);
      }
      i += 1;
    }
    AppMethodBeat.o(133465);
  }
  
  public final boolean a(Object paramObject, a parama)
  {
    AppMethodBeat.i(133469);
    int j = this.Jkd.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.Jkd[i] != null)
      {
        bool2 = bool1;
        if (this.Jkd[i].a(paramObject, parama)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(133469);
    return bool1;
  }
  
  public final boolean abQ(int paramInt)
  {
    AppMethodBeat.i(133471);
    int j = this.Jkd.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.Jkd[i] != null)
      {
        bool2 = bool1;
        if (!this.Jkd[i].abQ(paramInt)) {
          bool2 = false;
        }
      }
      i += 1;
      bool1 = bool2;
    }
    AppMethodBeat.o(133471);
    return bool1;
  }
  
  public final a abR(int paramInt)
  {
    AppMethodBeat.i(133468);
    int k = this.Jkd.length;
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      j = this.Jkd[paramInt].getCount();
      if (i < j)
      {
        a locala = this.Jkd[paramInt].abR(i);
        AppMethodBeat.o(133468);
        return locala;
      }
      i -= j;
      paramInt += 1;
    }
    AppMethodBeat.o(133468);
    return null;
  }
  
  public final void abS(int paramInt)
  {
    AppMethodBeat.i(133474);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].abS(paramInt);
      }
      i += 1;
    }
    AppMethodBeat.o(133474);
  }
  
  public final void close()
  {
    AppMethodBeat.i(133459);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].close();
      }
      i += 1;
    }
    super.close();
    AppMethodBeat.o(133459);
  }
  
  public final void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public final boolean dY(Object paramObject)
  {
    AppMethodBeat.i(133472);
    int j = this.Jkd.length;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; i < j; bool1 = bool2)
    {
      bool2 = bool1;
      if (this.Jkd[i] != null)
      {
        bool2 = bool1;
        if (this.Jkd[i].dY(paramObject)) {
          bool2 = true;
        }
      }
      i += 1;
    }
    AppMethodBeat.o(133472);
    return bool1;
  }
  
  public final a dZ(Object paramObject)
  {
    AppMethodBeat.i(133473);
    paramObject = this.Jkc.dZ(paramObject);
    AppMethodBeat.o(133473);
    return paramObject;
  }
  
  public final void deactivate()
  {
    AppMethodBeat.i(133458);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].deactivate();
      }
      i += 1;
    }
    super.deactivate();
    AppMethodBeat.o(133458);
  }
  
  public final SparseArray<Object>[] fxI()
  {
    AppMethodBeat.i(133470);
    int j = this.Jkd.length;
    SparseArray[] arrayOfSparseArray = new SparseArray[j];
    int i = 0;
    if (i < j)
    {
      Object localObject = this.Jkd[i].fxI();
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
  
  public final HashMap fxJ()
  {
    return null;
  }
  
  public final boolean fxK()
  {
    AppMethodBeat.i(133467);
    int j = this.Jkd.length;
    boolean bool1 = true;
    int i = 0;
    while (i < j)
    {
      boolean bool2 = bool1;
      if (this.Jkd[i] != null)
      {
        bool2 = bool1;
        if (!this.Jkd[i].fxK()) {
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
    byte[] arrayOfByte = this.Jkc.getBlob(paramInt);
    AppMethodBeat.o(133456);
    return arrayOfByte;
  }
  
  public final String[] getColumnNames()
  {
    AppMethodBeat.i(133457);
    if (this.Jkc != null)
    {
      String[] arrayOfString = this.Jkc.getColumnNames();
      AppMethodBeat.o(133457);
      return arrayOfString;
    }
    AppMethodBeat.o(133457);
    return new String[0];
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(133447);
    int m = this.Jkd.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (this.Jkd[i] != null) {
        k = j + this.Jkd[i].getCount();
      }
      i += 1;
    }
    AppMethodBeat.o(133447);
    return j;
  }
  
  public final double getDouble(int paramInt)
  {
    AppMethodBeat.i(133454);
    double d = this.Jkc.getDouble(paramInt);
    AppMethodBeat.o(133454);
    return d;
  }
  
  public final float getFloat(int paramInt)
  {
    AppMethodBeat.i(133453);
    float f = this.Jkc.getFloat(paramInt);
    AppMethodBeat.o(133453);
    return f;
  }
  
  public final int getInt(int paramInt)
  {
    AppMethodBeat.i(133451);
    paramInt = this.Jkc.getInt(paramInt);
    AppMethodBeat.o(133451);
    return paramInt;
  }
  
  public final long getLong(int paramInt)
  {
    AppMethodBeat.i(133452);
    long l = this.Jkc.getLong(paramInt);
    AppMethodBeat.o(133452);
    return l;
  }
  
  public final short getShort(int paramInt)
  {
    AppMethodBeat.i(133450);
    short s = this.Jkc.getShort(paramInt);
    AppMethodBeat.o(133450);
    return s;
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(133449);
    String str = this.Jkc.getString(paramInt);
    AppMethodBeat.o(133449);
    return str;
  }
  
  public final boolean isNull(int paramInt)
  {
    AppMethodBeat.i(133455);
    boolean bool = this.Jkc.isNull(paramInt);
    AppMethodBeat.o(133455);
    return bool;
  }
  
  public final boolean onMove(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133448);
    this.Jkc = null;
    int k = this.Jkd.length;
    paramInt1 = 0;
    int j;
    for (int i = 0;; i = j)
    {
      if (paramInt1 < k)
      {
        j = i;
        if (this.Jkd[paramInt1] == null) {
          break label110;
        }
        if (paramInt2 < this.Jkd[paramInt1].getCount() + i) {
          this.Jkc = this.Jkd[paramInt1];
        }
      }
      else
      {
        if (this.Jkc == null) {
          break;
        }
        boolean bool = this.Jkc.moveToPosition(paramInt2 - i);
        AppMethodBeat.o(133448);
        return bool;
      }
      j = i + this.Jkd[paramInt1].getCount();
      label110:
      paramInt1 += 1;
    }
    AppMethodBeat.o(133448);
    return false;
  }
  
  public final void registerContentObserver(ContentObserver paramContentObserver)
  {
    AppMethodBeat.i(133460);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].registerContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133460);
  }
  
  public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(133462);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].registerDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133462);
  }
  
  public final boolean requery()
  {
    AppMethodBeat.i(133464);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if ((this.Jkd[i] != null) && (!this.Jkd[i].requery()))
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
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].unregisterContentObserver(paramContentObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133461);
  }
  
  public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    AppMethodBeat.i(133463);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].unregisterDataSetObserver(paramDataSetObserver);
      }
      i += 1;
    }
    AppMethodBeat.o(133463);
  }
  
  public final void xa(boolean paramBoolean)
  {
    AppMethodBeat.i(133466);
    int j = this.Jkd.length;
    int i = 0;
    while (i < j)
    {
      if (this.Jkd[i] != null) {
        this.Jkd[i].xa(paramBoolean);
      }
      i += 1;
    }
    AppMethodBeat.o(133466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.e
 * JD-Core Version:    0.7.0.1
 */