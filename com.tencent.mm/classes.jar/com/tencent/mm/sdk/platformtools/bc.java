package com.tencent.mm.sdk.platformtools;

public class bc<T>
{
  public Object[] Eq;
  public int Er;
  
  public bc(int paramInt)
  {
    if (paramInt <= 0)
    {
      y.e("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
      return;
    }
    this.Eq = new Object[paramInt];
  }
  
  public boolean D(T paramT)
  {
    if (this.Eq == null) {}
    label93:
    for (;;)
    {
      return false;
      if (this.Eq != null)
      {
        i = 0;
        if (i < this.Er) {
          if (this.Eq[i] != paramT) {}
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label93;
        }
        if ((this.Er >= this.Eq.length) || (this.Er < 0)) {
          break label95;
        }
        this.Eq[this.Er] = paramT;
        this.Er += 1;
        return true;
        i += 1;
        break;
      }
    }
    label95:
    y.e("MicroMsg.SimpleObjectPool", "error index %d %d", new Object[] { Integer.valueOf(this.Er), Integer.valueOf(this.Eq.length) });
    return false;
  }
  
  public T de()
  {
    if (this.Eq == null) {}
    while (this.Er <= 0) {
      return null;
    }
    int i = this.Er - 1;
    Object localObject = this.Eq[i];
    this.Eq[i] = null;
    this.Er -= 1;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bc
 * JD-Core Version:    0.7.0.1
 */