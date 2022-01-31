package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class awo
  extends bly
{
  public int hQR;
  public int mPL;
  public int ndm;
  public long ndp;
  public bml svG;
  public int sze;
  public int ttf;
  public int ttg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      paramVarArgs.gB(1, this.sze);
      if (this.svG != null)
      {
        paramVarArgs.gD(2, this.svG.btq());
        this.svG.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.ndm);
      paramVarArgs.gB(4, this.ttf);
      paramVarArgs.gB(5, this.mPL);
      paramVarArgs.gB(6, this.ttg);
      paramVarArgs.gB(7, this.hQR);
      paramVarArgs.Y(8, this.ndp);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.sze) + 0;
      paramInt = i;
      if (this.svG != null) {
        paramInt = i + d.a.a.a.gA(2, this.svG.btq());
      }
      return paramInt + d.a.a.a.gy(3, this.ndm) + d.a.a.a.gy(4, this.ttf) + d.a.a.a.gy(5, this.mPL) + d.a.a.a.gy(6, this.ttg) + d.a.a.a.gy(7, this.hQR) + d.a.a.a.X(8, this.ndp);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.svG == null) {
        throw new b("Not all required fields were included: ToUserName");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      awo localawo = (awo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localawo.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bml();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localawo.svG = ((bml)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localawo.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localawo.ttf = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        localawo.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localawo.ttg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localawo.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localawo.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awo
 * JD-Core Version:    0.7.0.1
 */