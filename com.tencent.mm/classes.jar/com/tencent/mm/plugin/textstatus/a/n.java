package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n
  implements Cloneable
{
  public static n FXs;
  public static n FXt;
  public static n FXu;
  public boolean FXv = false;
  public int scene = 3;
  int showFlag = 0;
  
  static
  {
    AppMethodBeat.i(222805);
    FXs = new n().wq(true).wr(true);
    n localn = new n().wr(true);
    localn.showFlag |= 0x10;
    FXt = localn;
    localn = new n();
    localn.showFlag |= 0x1;
    localn.showFlag |= 0x2;
    FXu = localn.wr(false).wq(false);
    AppMethodBeat.o(222805);
  }
  
  private n wr(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.showFlag |= 0x8;
      return this;
    }
    this.showFlag &= 0xFFFFFFF7;
    return this;
  }
  
  public final boolean abM(int paramInt)
  {
    return (this.showFlag & paramInt) != 0;
  }
  
  public final n awv(int paramInt)
  {
    this.scene = paramInt;
    return this;
  }
  
  public final n fvA()
  {
    AppMethodBeat.i(222803);
    try
    {
      n localn = (n)super.clone();
      AppMethodBeat.o(222803);
      return localn;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public final n fvB()
  {
    this.FXv = true;
    return this;
  }
  
  public final n wq(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.showFlag |= 0x4;
      return this;
    }
    this.showFlag &= 0xFFFFFFFB;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.n
 * JD-Core Version:    0.7.0.1
 */