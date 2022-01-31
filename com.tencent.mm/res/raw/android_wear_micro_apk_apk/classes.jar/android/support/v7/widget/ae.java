package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public final class ae
{
  private SparseArray<ArrayList<an>> ur = new SparseArray();
  private SparseIntArray us = new SparseIntArray();
  private int ut = 0;
  
  final void a(t paramt1, t paramt2, boolean paramBoolean)
  {
    if (paramt1 != null) {
      this.ut -= 1;
    }
    if (this.ut == 0) {
      this.ur.clear();
    }
    if (paramt2 != null) {
      this.ut += 1;
    }
  }
  
  public final an ar(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)this.ur.get(0);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramInt = localArrayList.size() - 1;
      an localan = (an)localArrayList.get(paramInt);
      localArrayList.remove(paramInt);
      return localan;
    }
    return null;
  }
  
  public final void o(an paraman)
  {
    int i = paraman.vh;
    ArrayList localArrayList2 = (ArrayList)this.ur.get(i);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList2 = new ArrayList();
      this.ur.put(i, localArrayList2);
      localArrayList1 = localArrayList2;
      if (this.us.indexOfKey(i) < 0)
      {
        this.us.put(i, 5);
        localArrayList1 = localArrayList2;
      }
    }
    if (this.us.get(i) <= localArrayList1.size()) {
      return;
    }
    paraman.es();
    localArrayList1.add(paraman);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ae
 * JD-Core Version:    0.7.0.1
 */