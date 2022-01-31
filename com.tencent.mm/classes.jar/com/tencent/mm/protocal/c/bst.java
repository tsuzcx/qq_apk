package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bst
  extends blm
{
  public int pyo;
  public long sGd;
  public int swS;
  public bkk swb;
  public bmk tJk;
  public bmk tJl;
  public int tJm;
  
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
      paramVarArgs.Y(2, this.sGd);
      paramVarArgs.gB(3, this.pyo);
      if (this.tJk != null)
      {
        paramVarArgs.gD(4, this.tJk.btq());
        this.tJk.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.swS);
      if (this.tJl != null)
      {
        paramVarArgs.gD(6, this.tJl.btq());
        this.tJl.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.tJm);
      if (this.swb != null)
      {
        paramVarArgs.gD(8, this.swb.btq());
        this.swb.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label872;
      }
    }
    label872:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.sGd) + d.a.a.a.gy(3, this.pyo);
      paramInt = i;
      if (this.tJk != null) {
        paramInt = i + d.a.a.a.gA(4, this.tJk.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.swS);
      paramInt = i;
      if (this.tJl != null) {
        paramInt = i + d.a.a.a.gA(6, this.tJl.btq());
      }
      i = paramInt + d.a.a.a.gy(7, this.tJm);
      paramInt = i;
      if (this.swb != null) {
        paramInt = i + d.a.a.a.gA(8, this.swb.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        bst localbst = (bst)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbst.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbst.sGd = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localbst.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbst.tJk = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          localbst.swS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbst.tJl = ((bmk)localObject1);
            paramInt += 1;
          }
        case 7: 
          localbst.tJm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bkk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bkk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localbst.swb = ((bkk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bst
 * JD-Core Version:    0.7.0.1
 */