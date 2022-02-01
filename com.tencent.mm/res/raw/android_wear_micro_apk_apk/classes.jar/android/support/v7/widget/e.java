package android.support.v7.widget;

final class e
{
  long ta = 0L;
  e tb;
  
  private void cN()
  {
    if (this.tb == null) {
      this.tb = new e();
    }
  }
  
  private void clear(int paramInt)
  {
    e locale = this;
    while (paramInt >= 64)
    {
      if (locale.tb == null) {
        return;
      }
      locale = locale.tb;
      paramInt -= 64;
    }
    locale.ta &= (1L << paramInt ^ 0xFFFFFFFF);
  }
  
  final boolean an(int paramInt)
  {
    e locale = this;
    while (paramInt >= 64)
    {
      locale.cN();
      locale = locale.tb;
      paramInt -= 64;
    }
    long l1 = 1L << paramInt;
    if ((locale.ta & l1) != 0L) {}
    for (boolean bool = true;; bool = false)
    {
      locale.ta &= (l1 ^ 0xFFFFFFFF);
      l1 -= 1L;
      long l2 = locale.ta;
      locale.ta = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locale.ta, 1) | l2 & l1);
      if (locale.tb != null)
      {
        if (locale.tb.get(0)) {
          locale.set(63);
        }
        locale.tb.an(0);
      }
      return bool;
    }
  }
  
  final int ao(int paramInt)
  {
    if (this.tb == null)
    {
      if (paramInt >= 64) {
        return Long.bitCount(this.ta);
      }
      return Long.bitCount(this.ta & (1L << paramInt) - 1L);
    }
    if (paramInt < 64) {
      return Long.bitCount(this.ta & (1L << paramInt) - 1L);
    }
    return this.tb.ao(paramInt - 64) + Long.bitCount(this.ta);
  }
  
  final void c(int paramInt, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    e locale = this;
    while (paramInt >= 64)
    {
      locale.cN();
      locale = locale.tb;
      paramInt -= 64;
    }
    if ((locale.ta & 0x0) != 0L)
    {
      paramBoolean = true;
      label47:
      long l1 = (1L << paramInt) - 1L;
      long l2 = locale.ta;
      locale.ta = (((l1 ^ 0xFFFFFFFF) & locale.ta) << 1 | l2 & l1);
      if (!bool) {
        break label132;
      }
      locale.set(paramInt);
    }
    for (;;)
    {
      if ((!paramBoolean) && (locale.tb == null)) {
        return;
      }
      locale.cN();
      locale = locale.tb;
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
      locale.cN();
      locale = locale.tb;
      paramInt -= 64;
    }
    return (locale.ta & 1L << paramInt) != 0L;
  }
  
  final void set(int paramInt)
  {
    e locale = this;
    while (paramInt >= 64)
    {
      locale.cN();
      locale = locale.tb;
      paramInt -= 64;
    }
    locale.ta |= 1L << paramInt;
  }
  
  public final String toString()
  {
    if (this.tb == null) {
      return Long.toBinaryString(this.ta);
    }
    return this.tb.toString() + "xx" + Long.toBinaryString(this.ta);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v7.widget.e
 * JD-Core Version:    0.7.0.1
 */