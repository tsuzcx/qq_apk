package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bve
  extends com.tencent.mm.bv.a
{
  public int tLA;
  public ceb tLB;
  public int tLC;
  public int tLD;
  public int tLE;
  public int tLF;
  public LinkedList<Integer> tLG = new LinkedList();
  public int tLH;
  public LinkedList<Integer> tLI = new LinkedList();
  public int tLJ;
  public LinkedList<Integer> tLK = new LinkedList();
  public int tLy;
  public int tLz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tLB == null) {
        throw new d.a.a.b("Not all required fields were included: Addr");
      }
      paramVarArgs.gB(1, this.tLy);
      paramVarArgs.gB(2, this.tLz);
      paramVarArgs.gB(3, this.tLA);
      if (this.tLB != null)
      {
        paramVarArgs.gD(4, this.tLB.btq());
        this.tLB.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tLC);
      paramVarArgs.gB(6, this.tLD);
      paramVarArgs.gB(7, this.tLE);
      paramVarArgs.gB(8, this.tLF);
      paramVarArgs.d(9, this.tLG);
      paramVarArgs.gB(10, this.tLH);
      paramVarArgs.d(11, this.tLI);
      paramVarArgs.gB(12, this.tLJ);
      paramVarArgs.d(13, this.tLK);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.tLy) + 0 + d.a.a.a.gy(2, this.tLz) + d.a.a.a.gy(3, this.tLA);
      paramInt = i;
      if (this.tLB != null) {
        paramInt = i + d.a.a.a.gA(4, this.tLB.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.tLC) + d.a.a.a.gy(6, this.tLD) + d.a.a.a.gy(7, this.tLE) + d.a.a.a.gy(8, this.tLF) + d.a.a.a.c(9, this.tLG) + d.a.a.a.gy(10, this.tLH) + d.a.a.a.c(11, this.tLI) + d.a.a.a.gy(12, this.tLJ) + d.a.a.a.c(13, this.tLK);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tLG.clear();
      this.tLI.clear();
      this.tLK.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tLB == null) {
        throw new d.a.a.b("Not all required fields were included: Addr");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bve localbve = (bve)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbve.tLy = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbve.tLz = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localbve.tLA = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ceb();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ceb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbve.tLB = ((ceb)localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localbve.tLC = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localbve.tLD = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localbve.tLE = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localbve.tLF = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localbve.tLG = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
        return 0;
      case 10: 
        localbve.tLH = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        localbve.tLI = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
        return 0;
      case 12: 
        localbve.tLJ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localbve.tLK = new d.a.a.a.a(((d.a.a.a.a)localObject1).cUs().oY, unknownTagHandler).cUp();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bve
 * JD-Core Version:    0.7.0.1
 */