package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public final class ae
{
  private SparseArray<ArrayList<an>> wg = new SparseArray();
  private SparseIntArray wh = new SparseIntArray();
  private int wi = 0;
  
  final void a(t paramt1, t paramt2, boolean paramBoolean)
  {
    if (paramt1 != null) {
      this.wi -= 1;
    }
    if (this.wi == 0) {
      this.wg.clear();
    }
    if (paramt2 != null) {
      this.wi += 1;
    }
  }
  
  public final an aD(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)this.wg.get(0);
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
    int i = paraman.wW;
    ArrayList localArrayList2 = (ArrayList)this.wg.get(i);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList2 = new ArrayList();
      this.wg.put(i, localArrayList2);
      localArrayList1 = localArrayList2;
      if (this.wh.indexOfKey(i) < 0)
      {
        this.wh.put(i, 5);
        localArrayList1 = localArrayList2;
      }
    }
    if (this.wh.get(i) <= localArrayList1.size()) {
      return;
    }
    paraman.df();
    localArrayList1.add(paraman);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.ae
 * JD-Core Version:    0.7.0.1
 */