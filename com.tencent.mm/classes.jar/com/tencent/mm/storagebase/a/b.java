package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  SparseArray<Object> IPk = new SparseArray();
  int IPl;
  HashMap<Object, T> IPm = new HashMap();
  ArrayList<Object> IPn;
  T IPo;
  int mStartPos = 0;
  
  final void E(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.IPk.size())
    {
      int i2 = this.IPk.keyAt(i);
      Object localObject = this.IPk.valueAt(i);
      int i1 = 1;
      int i3 = paramArrayOfObject.length;
      int n = 0;
      label54:
      int k = j;
      int m = i1;
      if (n < i3)
      {
        if (paramArrayOfObject[n].equals(localObject))
        {
          k = j + 1;
          m = 0;
        }
      }
      else
      {
        if (m == 0) {
          break label124;
        }
        localSparseArray.put(i2 - k, localObject);
      }
      for (;;)
      {
        i += 1;
        j = k;
        break;
        n += 1;
        break label54;
        label124:
        ad.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i + " obj : " + localObject);
      }
    }
    if (this.IPk.size() != localSparseArray.size()) {
      ad.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.IPk.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.IPk = localSparseArray;
  }
  
  public abstract ArrayList<T> aV(ArrayList<Object> paramArrayList);
  
  public final boolean abl(int paramInt)
  {
    return this.IPk.indexOfKey(paramInt) >= 0;
  }
  
  final void b(Object paramObject, T paramT)
  {
    this.IPm.put(paramObject, paramT);
  }
  
  public final void clearData()
  {
    ad.i("MicroMsg.CursorDataWindow", "clearData");
    this.IPk.clear();
    this.IPm.clear();
  }
  
  public final boolean dX(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.IPm != null) && (this.IPm.containsKey(arrayOfObject[0]));
      }
    }
    return (this.IPm != null) && (this.IPm.containsKey(paramObject));
  }
  
  public abstract T ftV();
  
  public final void jA(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      ad.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.IPk.remove(paramInt1);
    }
    while (this.IPo == null) {
      return;
    }
    Object localObject = this.IPo.getKey();
    b(localObject, this.IPo);
    this.IPk.put(paramInt1, localObject);
  }
  
  protected void onAllReferencesReleased()
  {
    clearData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.b
 * JD-Core Version:    0.7.0.1
 */