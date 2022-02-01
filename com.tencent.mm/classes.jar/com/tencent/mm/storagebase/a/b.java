package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  SparseArray<Object> VJI = new SparseArray();
  int VJJ;
  HashMap<Object, T> VJK = new HashMap();
  ArrayList<Object> VJL;
  T VJM;
  int mStartPos = 0;
  
  final void E(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.VJI.size())
    {
      int i2 = this.VJI.keyAt(i);
      Object localObject = this.VJI.valueAt(i);
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
    if (this.VJI.size() != localSparseArray.size()) {
      Log.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.VJI.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.VJI = localSparseArray;
  }
  
  public final boolean asY(int paramInt)
  {
    return this.VJI.indexOfKey(paramInt) >= 0;
  }
  
  final void b(Object paramObject, T paramT)
  {
    this.VJK.put(paramObject, paramT);
  }
  
  public abstract ArrayList<T> bD(ArrayList<Object> paramArrayList);
  
  public final void clearData()
  {
    Log.i("MicroMsg.CursorDataWindow", "clearData");
    this.VJI.clear();
    this.VJK.clear();
  }
  
  public final boolean eh(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.VJK != null) && (this.VJK.containsKey(arrayOfObject[0]));
      }
    }
    return (this.VJK != null) && (this.VJK.containsKey(paramObject));
  }
  
  public abstract T hCa();
  
  public final void mf(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      Log.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.VJI.remove(paramInt1);
    }
    while (this.VJM == null) {
      return;
    }
    Object localObject = this.VJM.getKey();
    b(localObject, this.VJM);
    this.VJI.put(paramInt1, localObject);
  }
  
  protected void onAllReferencesReleased()
  {
    clearData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storagebase.a.b
 * JD-Core Version:    0.7.0.1
 */