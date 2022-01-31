package android.support.v7.widget;

final class e
{
  long rk = 0L;
  e rl;
  
  private void cF()
  {
    if (this.rl == null) {
      this.rl = new e();
    }
  }
  
  private void clear(int paramInt)
  {
    e locale = this;
    while (paramInt >= 64)
    {
      if (locale.rl == null) {
        return;
      }
      locale = locale.rl;
      paramInt -= 64;
    }
    locale.rk &= (1L << paramInt ^ 0xFFFFFFFF);
  }
  
  final boolean ac(int paramInt)
  {
    e locale = this;
    while (paramInt >= 64)
    {
      locale.cF();
      locale = locale.rl;
      paramInt -= 64;
    }
    long l1 = 1L << paramInt;
    if ((locale.rk & l1) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      locale.rk &= (l1 ^ 0xFFFFFFFF);
      l1 -= 1L;
      long l2 = locale.rk;
      locale.rk = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locale.rk, 1) | l2 & l1);
      if (locale.rl != null)
      {
        if (locale.rl.get(0)) {
          locale.set(63);
        }
        locale.rl.ac(0);
      }
      return bool;
    }
  }
  
  final int ad(int paramInt)
  {
    if (this.rl == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(this.rk);
      }
      return Long.bitCount(this.rk & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(this.rk & (1L << paramInt) - 1L);
    }
    return this.rl.ad(paramInt - 64) + Long.bitCount(this.rk);
  }
  
  final void b(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    e locale = this;
    while (paramInt >= 64)
    {
      locale.cF();
      locale = locale.rl;
      paramInt -= 64;
    }
    if ((locale.rk & 0x0) != 0L)
    {
      paramBoolean = true;
      label47:
      long l1 = (1L << paramInt) - 1L;
      long l2 = locale.rk;
      locale.rk = (((l1 ^ 0xFFFFFFFF) & locale.rk) << 1 | l2 & l1);
      if (!bool) {
        break label132;
      }
      locale.set(paramInt);
    }
    for (;;)
    {
      if ((!paramBoolean) && (locale.rl == null)) {
        return;
      }
      locale.cF();
      locale = locale.rl;
      paramInt = 0;
      bool = paramBoolean;
      break;
      paramBoolean = false;
      break label47;
      label132:
      locale.clear(paramInt);
    }
  }
  
  final boolean get(int paramInt)
  {
    e locale = this;
    while (paramInt >= 64)
    {
      locale.cF();
      locale = locale.rl;
      paramInt -= 64;
    }
    return (locale.rk & 1L << paramInt) != 0L;
  }
  
  final void set(int paramInt)
  {
    e locale = this;
    while (paramInt >= 64)
    {
      locale.cF();
      locale = locale.rl;
      paramInt -= 64;
    }
    locale.rk |= 1L << paramInt;
  }
  
  public final String toString()
  {
    if (this.rl == null) {
      return Long.toBinaryString(this.rk);
    }
    return this.rl.toString() + "xx" + Long.toBinaryString(this.rk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */