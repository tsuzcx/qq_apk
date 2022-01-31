package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bsr
  extends com.tencent.mm.bv.a
{
  public int swS;
  public bml tJe;
  public bml tJg;
  public int tJh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tJe != null)
      {
        paramVarArgs.gD(1, this.tJe.btq());
        this.tJe.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.swS);
      if (this.tJg != null)
      {
        paramVarArgs.gD(3, this.tJg.btq());
        this.tJg.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.tJh);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tJe == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = d.a.a.a.gA(1, this.tJe.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.swS);
      paramInt = i;
      if (this.tJg != null) {
        paramInt = i + d.a.a.a.gA(3, this.tJg.btq());
      }
      return paramInt + d.a.a.a.gy(4, this.tJh);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        bsr localbsr = (bsr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbsr.tJe = ((bml)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbsr.swS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbsr.tJg = ((bml)localObject1);
            paramInt += 1;
          }
        }
        localbsr.tJh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsr
 * JD-Core Version:    0.7.0.1
 */