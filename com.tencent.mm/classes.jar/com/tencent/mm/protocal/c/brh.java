package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class brh
  extends blm
{
  public int bZe;
  public LinkedList<brj> dTx = new LinkedList();
  public bvk stf;
  public int tId;
  public String tIe;
  public bry tIf;
  public String tbG;
  
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
      paramVarArgs.gB(2, this.tId);
      paramVarArgs.d(3, 8, this.dTx);
      if (this.tIe != null) {
        paramVarArgs.d(4, this.tIe);
      }
      if (this.tbG != null) {
        paramVarArgs.d(5, this.tbG);
      }
      if (this.tIf != null)
      {
        paramVarArgs.gD(6, this.tIf.btq());
        this.tIf.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.bZe);
      if (this.stf != null)
      {
        paramVarArgs.gD(8, this.stf.btq());
        this.stf.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label892;
      }
    }
    label892:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tId) + d.a.a.a.c(3, 8, this.dTx);
      paramInt = i;
      if (this.tIe != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tIe);
      }
      i = paramInt;
      if (this.tbG != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tbG);
      }
      paramInt = i;
      if (this.tIf != null) {
        paramInt = i + d.a.a.a.gA(6, this.tIf.btq());
      }
      i = paramInt + d.a.a.a.gy(7, this.bZe);
      paramInt = i;
      if (this.stf != null) {
        paramInt = i + d.a.a.a.gA(8, this.stf.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.dTx.clear();
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
        brh localbrh = (brh)paramVarArgs[1];
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
            localbrh.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbrh.tId = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new brj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((brj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbrh.dTx.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localbrh.tIe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbrh.tbG = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bry();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bry)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbrh.tIf = ((bry)localObject1);
            paramInt += 1;
          }
        case 7: 
          localbrh.bZe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localbrh.stf = ((bvk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brh
 * JD-Core Version:    0.7.0.1
 */