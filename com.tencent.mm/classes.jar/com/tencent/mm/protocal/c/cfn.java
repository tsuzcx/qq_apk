package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cfn
  extends blm
{
  public int sST;
  public long sSU;
  public int tAN;
  public int tUI;
  public int tUJ;
  public LinkedList<cfq> tUK = new LinkedList();
  public int tUL;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.sST);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.gB(4, this.tAN);
      paramVarArgs.gB(5, this.tUI);
      paramVarArgs.gB(6, this.tUJ);
      paramVarArgs.d(7, 8, this.tUK);
      paramVarArgs.gB(8, this.tUL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label632;
      }
    }
    label632:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.sST) + d.a.a.a.X(3, this.sSU) + d.a.a.a.gy(4, this.tAN) + d.a.a.a.gy(5, this.tUI) + d.a.a.a.gy(6, this.tUJ) + d.a.a.a.c(7, 8, this.tUK) + d.a.a.a.gy(8, this.tUL);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tUK.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cfn localcfn = (cfn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        int i;
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfn.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcfn.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcfn.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localcfn.tAN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcfn.tUI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcfn.tUJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfn.tUK.add(localObject1);
            paramInt += 1;
          }
        }
        localcfn.tUL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfn
 * JD-Core Version:    0.7.0.1
 */