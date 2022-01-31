package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bgy
  extends com.tencent.mm.bv.a
{
  public String bZc;
  public int tBA;
  public boolean tBB;
  public String tBC;
  public int tBD;
  public int tBE;
  public LinkedList<bgx> tBF = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bZc != null) {
        paramVarArgs.d(1, this.bZc);
      }
      paramVarArgs.gB(2, this.tBA);
      paramVarArgs.aA(3, this.tBB);
      if (this.tBC != null) {
        paramVarArgs.d(4, this.tBC);
      }
      paramVarArgs.gB(5, this.tBD);
      paramVarArgs.gB(6, this.tBE);
      paramVarArgs.d(7, 8, this.tBF);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bZc == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = d.a.a.b.b.a.e(1, this.bZc) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tBA) + (d.a.a.b.b.a.dQ(3) + 1);
      paramInt = i;
      if (this.tBC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tBC);
      }
      return paramInt + d.a.a.a.gy(5, this.tBD) + d.a.a.a.gy(6, this.tBE) + d.a.a.a.c(7, 8, this.tBF);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tBF.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bgy localbgy = (bgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbgy.bZc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbgy.tBA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbgy.tBB = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 4: 
          localbgy.tBC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbgy.tBD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbgy.tBE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bgx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbgy.tBF.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bgy
 * JD-Core Version:    0.7.0.1
 */