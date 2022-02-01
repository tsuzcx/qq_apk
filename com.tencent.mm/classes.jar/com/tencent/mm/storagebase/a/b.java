package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  SparseArray<Object> OtK = new SparseArray();
  int OtL;
  HashMap<Object, T> OtM = new HashMap();
  ArrayList<Object> OtN;
  T OtO;
  int mStartPos = 0;
  
  final void E(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.OtK.size())
    {
      int i2 = this.OtK.keyAt(i);
      Object localObject = this.OtK.valueAt(i);
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
        Log.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i + " obj : " + localObject);
      }
    }
    if (this.OtK.size() != localSparseArray.size()) {
      Log.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.OtK.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.OtK = localSparseArray;
  }
  
  public final boolean akB(int paramInt)
  {
    return this.OtK.indexOfKey(paramInt) >= 0;
  }
  
  final void b(Object paramObject, T paramT)
  {
    this.OtM.put(paramObject, paramT);
  }
  
  public abstract ArrayList<T> bo(ArrayList<Object> paramArrayList);
  
  public final void clearData()
  {
    Log.i("MicroMsg.CursorDataWindow", "clearData");
    this.OtK.clear();
    this.OtM.clear();
  }
  
  public final boolean ed(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.OtM != null) && (this.OtM.containsKey(arrayOfObject[0]));
      }
    }
    return (this.OtM != null) && (this.OtM.containsKey(paramObject));
  }
  
  public abstract T gFJ();
  
  public final void kN(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      Log.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.OtK.remove(paramInt1);
    }
    while (this.OtO == null) {
      return;
    }
    Object localObject = this.OtO.getKey();
    b(localObject, this.OtO);
    this.OtK.put(paramInt1, localObject);
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