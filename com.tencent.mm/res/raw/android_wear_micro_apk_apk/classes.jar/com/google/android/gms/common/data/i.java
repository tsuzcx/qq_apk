package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class i<T>
  extends a<T>
{
  private boolean Kl = false;
  private ArrayList<Integer> Km;
  
  protected i(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private int bz(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Km.size())) {
      throw new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.Km.get(paramInt)).intValue();
  }
  
  private void ha()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.Kl) {
          break label204;
        }
        int j = this.JP.JZ;
        this.Km = new ArrayList();
        if (j <= 0) {
          break label199;
        }
        this.Km.add(Integer.valueOf(0));
        String str3 = gZ();
        i = this.JP.by(0);
        String str1 = this.JP.c(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label199;
        }
        int k = this.JP.by(i);
        str2 = this.JP.c(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException(String.valueOf(str3).length() + 78 + "Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.Km.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label207;
        label199:
        this.Kl = true;
        label204:
        return;
      }
      label207:
      i += 1;
    }
  }
  
  protected abstract T Z(int paramInt1, int paramInt2);
  
  protected abstract String gZ();
  
  public final T get(int paramInt)
  {
    ha();
    int k = bz(paramInt);
    int j;
    if ((paramInt < 0) || (paramInt == this.Km.size()))
    {
      j = 0;
      return Z(k, j);
    }
    if (paramInt == this.Km.size() - 1) {}
    for (int i = this.JP.JZ - ((Integer)this.Km.get(paramInt)).intValue();; i = ((Integer)this.Km.get(paramInt + 1)).intValue() - ((Integer)this.Km.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = bz(paramInt);
      this.JP.by(paramInt);
      j = i;
      break;
    }
  }
  
  public final int getCount()
  {
    ha();
    return this.Km.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.i
 * JD-Core Version:    0.7.0.1
 */