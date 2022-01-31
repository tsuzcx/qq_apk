package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class i<T>
  extends a<T>
{
  private boolean Iw = false;
  private ArrayList<Integer> Ix;
  
  protected i(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private int bf(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Ix.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.Ix.get(paramInt)).intValue();
  }
  
  private void gQ()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.Iw) {
          break label204;
        }
        int j = this.Ia.Ik;
        this.Ix = new ArrayList();
        if (j <= 0) {
          break label199;
        }
        this.Ix.add(Integer.valueOf(0));
        String str3 = gP();
        i = this.Ia.be(0);
        String str1 = this.Ia.c(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label199;
        }
        int k = this.Ia.be(i);
        str2 = this.Ia.c(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.Ix.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199:
        this.Iw = true;
        label204:
        return;
      }
      label207:
      i += 1;
    }
  }
  
  protected abstract T X(int paramInt1, int paramInt2);
  
  protected abstract String gP();
  
  public final T get(int paramInt)
  {
    gQ();
    int k = bf(paramInt);
    int j;
    if ((paramInt < 0) || (paramInt == this.Ix.size()))
    {
      j = 0;
      return X(k, j);
    }
    if (paramInt == this.Ix.size() - 1) {}
    for (int i = this.Ia.Ik - ((Integer)this.Ix.get(paramInt)).intValue();; i = ((Integer)this.Ix.get(paramInt + 1)).intValue() - ((Integer)this.Ix.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = bf(paramInt);
      this.Ia.be(paramInt);
      j = i;
      break;
    }
  }
  
  public final int getCount()
  {
    gQ();
    return this.Ix.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.i
 * JD-Core Version:    0.7.0.1
 */