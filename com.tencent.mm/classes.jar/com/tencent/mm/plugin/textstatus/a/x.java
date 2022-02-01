package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class x
  implements Cloneable
{
  public boolean ThT = false;
  public String ThU = "";
  public int ThV = 0;
  public boolean ThW = true;
  public int scene = 3;
  int showFlag = 12480;
  
  private x Fw(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.showFlag |= 0x4;
      return this;
    }
    this.showFlag &= 0xFFFFFFFB;
    return this;
  }
  
  public static x hFI()
  {
    AppMethodBeat.i(289755);
    x localx = new x().Fw(true).hFQ();
    AppMethodBeat.o(289755);
    return localx;
  }
  
  public static x hFJ()
  {
    AppMethodBeat.i(289761);
    x localx = hFI();
    localx.ThT = true;
    localx.scene = 6;
    localx.showFlag &= 0xFFFFEFFF;
    localx.showFlag |= 0x800;
    AppMethodBeat.o(289761);
    return localx;
  }
  
  public static x hFK()
  {
    AppMethodBeat.i(289765);
    x localx = hFI();
    localx.ThW = false;
    AppMethodBeat.o(289765);
    return localx;
  }
  
  public static x hFL()
  {
    AppMethodBeat.i(289767);
    x localx = new x().hFQ();
    localx.ThW = false;
    AppMethodBeat.o(289767);
    return localx;
  }
  
  public static x hFM()
  {
    AppMethodBeat.i(289770);
    x localx = new x().hFQ();
    localx.ThT = true;
    localx = localx.hFR();
    AppMethodBeat.o(289770);
    return localx;
  }
  
  public static x hFN()
  {
    AppMethodBeat.i(289774);
    x localx = new x().hFQ().hFR();
    AppMethodBeat.o(289774);
    return localx;
  }
  
  public static x hFO()
  {
    AppMethodBeat.i(289782);
    x localx = new x();
    localx.showFlag |= 0x1;
    localx.showFlag |= 0x2;
    localx = localx.hFQ().Fw(false);
    localx.scene = 8;
    localx.showFlag |= 0x20;
    localx = localx.hFR();
    localx.showFlag &= 0xFFFFFFBF;
    localx.showFlag &= 0xFFFFFF7F;
    localx.showFlag |= 0x100;
    localx.showFlag &= 0xFFFFDFFF;
    localx.showFlag |= 0x4000;
    localx.showFlag |= 0x200;
    localx.showFlag |= 0x400;
    AppMethodBeat.o(289782);
    return localx;
  }
  
  private x hFP()
  {
    AppMethodBeat.i(289791);
    try
    {
      x localx = (x)super.clone();
      AppMethodBeat.o(289791);
      return localx;
    }
    finally
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private x hFQ()
  {
    this.showFlag |= 0x8;
    return this;
  }
  
  private x hFR()
  {
    this.showFlag |= 0x10;
    return this;
  }
  
  public final boolean aom(int paramInt)
  {
    return (this.showFlag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.x
 * JD-Core Version:    0.7.0.1
 */