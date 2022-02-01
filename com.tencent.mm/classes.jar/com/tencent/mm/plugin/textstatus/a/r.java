package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class r
  implements Cloneable
{
  public boolean MzM = false;
  public String MzN = "";
  public int MzO = 0;
  public boolean MzP = true;
  public int scene = 3;
  int showFlag = 0;
  
  private r Ac(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.showFlag |= 0x4;
      return this;
    }
    this.showFlag &= 0xFFFFFFFB;
    return this;
  }
  
  private r Ad(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.showFlag |= 0x8;
      return this;
    }
    this.showFlag &= 0xFFFFFFF7;
    return this;
  }
  
  public static r gkP()
  {
    AppMethodBeat.i(243696);
    r localr = new r().Ac(true).Ad(true);
    AppMethodBeat.o(243696);
    return localr;
  }
  
  public static r gkQ()
  {
    AppMethodBeat.i(243697);
    r localr = gkP();
    localr.MzM = true;
    localr.scene = 6;
    AppMethodBeat.o(243697);
    return localr;
  }
  
  public static r gkR()
  {
    AppMethodBeat.i(243698);
    r localr = gkP();
    localr.MzP = false;
    AppMethodBeat.o(243698);
    return localr;
  }
  
  public static r gkS()
  {
    AppMethodBeat.i(243699);
    r localr = new r().Ad(true);
    localr.MzP = false;
    AppMethodBeat.o(243699);
    return localr;
  }
  
  public static r gkT()
  {
    AppMethodBeat.i(243700);
    r localr = new r().Ad(true);
    localr.MzM = true;
    localr = localr.gkY();
    AppMethodBeat.o(243700);
    return localr;
  }
  
  public static r gkU()
  {
    AppMethodBeat.i(243701);
    r localr = new r().Ad(true).gkY();
    AppMethodBeat.o(243701);
    return localr;
  }
  
  public static r gkV()
  {
    AppMethodBeat.i(243702);
    r localr = new r();
    localr.showFlag |= 0x1;
    localr.showFlag |= 0x2;
    localr = localr.Ad(false).Ac(false);
    AppMethodBeat.o(243702);
    return localr;
  }
  
  private r gkW()
  {
    AppMethodBeat.i(243703);
    try
    {
      r localr = (r)super.clone();
      AppMethodBeat.o(243703);
      return localr;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private r gkY()
  {
    this.showFlag |= 0x10;
    return this;
  }
  
  public final r ajg(int paramInt)
  {
    this.MzO = paramInt;
    return this;
  }
  
  public final boolean ajh(int paramInt)
  {
    return (this.showFlag & paramInt) != 0;
  }
  
  public final r bek(String paramString)
  {
    this.MzN = paramString;
    return this;
  }
  
  public final r gkX()
  {
    this.scene = 2;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.a.r
 * JD-Core Version:    0.7.0.1
 */