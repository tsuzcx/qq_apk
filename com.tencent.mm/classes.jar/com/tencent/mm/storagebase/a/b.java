package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  SparseArray<Object> JjS = new SparseArray();
  int JjT;
  HashMap<Object, T> JjU = new HashMap();
  ArrayList<Object> JjV;
  T JjW;
  int mStartPos = 0;
  
  final void D(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.JjS.size())
    {
      int i2 = this.JjS.keyAt(i);
      Object localObject = this.JjS.valueAt(i);
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
        ae.i("MicroMsg.CursorDataWindow", "newcursor delete index : " + i + " obj : " + localObject);
      }
    }
    if (this.JjS.size() != localSparseArray.size()) {
      ae.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.JjS.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.JjS = localSparseArray;
  }
  
  public abstract ArrayList<T> aW(ArrayList<Object> paramArrayList);
  
  public final boolean abT(int paramInt)
  {
    return this.JjS.indexOfKey(paramInt) >= 0;
  }
  
  final void b(Object paramObject, T paramT)
  {
    this.JjU.put(paramObject, paramT);
  }
  
  public final void clearData()
  {
    ae.i("MicroMsg.CursorDataWindow", "clearData");
    this.JjS.clear();
    this.JjU.clear();
  }
  
  public final boolean dY(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.JjU != null) && (this.JjU.containsKey(arrayOfObject[0]));
      }
    }
    return (this.JjU != null) && (this.JjU.containsKey(paramObject));
  }
  
  public abstract T fxW();
  
  public final void jE(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      ae.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.JjS.remove(paramInt1);
    }
    while (this.JjW == null) {
      return;
    }
    Object localObject = this.JjW.getKey();
    b(localObject, this.JjW);
    this.JjS.put(paramInt1, localObject);
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