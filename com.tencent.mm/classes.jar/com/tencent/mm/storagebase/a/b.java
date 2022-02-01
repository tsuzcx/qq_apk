package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  SparseArray<Object> adnM = new SparseArray();
  int adnN;
  HashMap<Object, T> adnO = new HashMap();
  ArrayList<Object> adnP;
  T adnQ;
  int mStartPos = 0;
  
  final void I(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.adnM.size())
    {
      int i2 = this.adnM.keyAt(i);
      Object localObject = this.adnM.valueAt(i);
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
    if (this.adnM.size() != localSparseArray.size()) {
      Log.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.adnM.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.adnM = localSparseArray;
  }
  
  public final boolean azo(int paramInt)
  {
    return this.adnM.indexOfKey(paramInt) >= 0;
  }
  
  final void b(Object paramObject, T paramT)
  {
    this.adnO.put(paramObject, paramT);
  }
  
  public abstract ArrayList<T> ce(ArrayList<Object> paramArrayList);
  
  public final void clearData()
  {
    Log.i("MicroMsg.CursorDataWindow", "clearData");
    this.adnM.clear();
    this.adnO.clear();
  }
  
  public final boolean gF(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.adnO != null) && (this.adnO.containsKey(arrayOfObject[0]));
      }
    }
    return (this.adnO != null) && (this.adnO.containsKey(paramObject));
  }
  
  public abstract T jeg();
  
  public final void nV(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      Log.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.adnM.remove(paramInt1);
    }
    while (this.adnQ == null) {
      return;
    }
    Object localObject = this.adnQ.getKey();
    b(localObject, this.adnQ);
    this.adnM.put(paramInt1, localObject);
  }
  
  protected void onAllReferencesReleased()
  {
    clearData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.b
 * JD-Core Version:    0.7.0.1
 */