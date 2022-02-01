package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  SparseArray<Object> HbU = new SparseArray();
  int HbV;
  HashMap<Object, T> HbW = new HashMap();
  ArrayList<Object> HbX;
  T HbY;
  int mStartPos = 0;
  
  final void D(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.HbU.size())
    {
      int i2 = this.HbU.keyAt(i);
      Object localObject = this.HbU.valueAt(i);
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
        ac.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i + " obj : " + localObject);
      }
    }
    if (this.HbU.size() != localSparseArray.size()) {
      ac.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.HbU.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.HbU = localSparseArray;
  }
  
  public final boolean Zc(int paramInt)
  {
    return this.HbU.indexOfKey(paramInt) >= 0;
  }
  
  public abstract ArrayList<T> aY(ArrayList<Object> paramArrayList);
  
  final void b(Object paramObject, T paramT)
  {
    this.HbW.put(paramObject, paramT);
  }
  
  public final void clearData()
  {
    ac.i("MicroMsg.CursorDataWindow", "clearData");
    this.HbU.clear();
    this.HbW.clear();
  }
  
  public final boolean dU(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.HbW != null) && (this.HbW.containsKey(arrayOfObject[0]));
      }
    }
    return (this.HbW != null) && (this.HbW.containsKey(paramObject));
  }
  
  public abstract T fdN();
  
  public final void jo(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      ac.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.HbU.remove(paramInt1);
    }
    while (this.HbY == null) {
      return;
    }
    Object localObject = this.HbY.getKey();
    b(localObject, this.HbY);
    this.HbU.put(paramInt1, localObject);
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