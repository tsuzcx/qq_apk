package com.tencent.mm.storagebase.a;

import android.database.sqlite.SQLiteClosable;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class b<T extends a>
  extends SQLiteClosable
{
  SparseArray<Object> FCR = new SparseArray();
  int FCS;
  HashMap<Object, T> FCT = new HashMap();
  ArrayList<Object> FCU;
  T FCV;
  int mStartPos = 0;
  
  final void B(Object[] paramArrayOfObject)
  {
    SparseArray localSparseArray = new SparseArray();
    int i = 0;
    int j = 0;
    if (i < this.FCR.size())
    {
      int i2 = this.FCR.keyAt(i);
      Object localObject = this.FCR.valueAt(i);
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
    if (this.FCR.size() != localSparseArray.size()) {
      ad.i("MicroMsg.CursorDataWindow", "newcursor oldposition size :" + this.FCR.size() + " newposistion Size : " + localSparseArray.size());
    }
    this.FCR = localSparseArray;
  }
  
  public final boolean WS(int paramInt)
  {
    return this.FCR.indexOfKey(paramInt) >= 0;
  }
  
  public abstract ArrayList<T> aM(ArrayList<Object> paramArrayList);
  
  final void b(Object paramObject, T paramT)
  {
    this.FCT.put(paramObject, paramT);
  }
  
  public final void clearData()
  {
    ad.i("MicroMsg.CursorDataWindow", "clearData");
    this.FCR.clear();
    this.FCT.clear();
  }
  
  public final boolean dT(Object paramObject)
  {
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 1) {
        return (this.FCT != null) && (this.FCT.containsKey(arrayOfObject[0]));
      }
    }
    return (this.FCT != null) && (this.FCT.containsKey(paramObject));
  }
  
  public abstract T eOj();
  
  public final void jb(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      ad.e("MicroMsg.CursorDataWindow", "newcursor rowEnd with error %d rowNum : %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      this.FCR.remove(paramInt1);
    }
    while (this.FCV == null) {
      return;
    }
    Object localObject = this.FCV.getKey();
    b(localObject, this.FCV);
    this.FCR.put(paramInt1, localObject);
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