package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bxv
  extends com.tencent.mm.bv.a
{
  public String sNz;
  public int state;
  public LinkedList<bxu> tNN = new LinkedList();
  public int tNO;
  public int tNP;
  public blu tNQ;
  public int tNR;
  public LinkedList<bxt> tNS = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sNz == null) {
        throw new b("Not all required fields were included: patchid");
      }
      if (this.sNz != null) {
        paramVarArgs.d(1, this.sNz);
      }
      paramVarArgs.gB(2, this.state);
      paramVarArgs.d(3, 8, this.tNN);
      paramVarArgs.gB(4, this.tNO);
      paramVarArgs.gB(5, this.tNP);
      if (this.tNQ != null)
      {
        paramVarArgs.gD(6, this.tNQ.btq());
        this.tNQ.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.tNR);
      paramVarArgs.d(8, 8, this.tNS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sNz == null) {
        break label778;
      }
    }
    label778:
    for (paramInt = d.a.a.b.b.a.e(1, this.sNz) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.state) + d.a.a.a.c(3, 8, this.tNN) + d.a.a.a.gy(4, this.tNO) + d.a.a.a.gy(5, this.tNP);
      paramInt = i;
      if (this.tNQ != null) {
        paramInt = i + d.a.a.a.gA(6, this.tNQ.btq());
      }
      return paramInt + d.a.a.a.gy(7, this.tNR) + d.a.a.a.c(8, 8, this.tNS);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tNN.clear();
        this.tNS.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sNz != null) {
          break;
        }
        throw new b("Not all required fields were included: patchid");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bxv localbxv = (bxv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbxv.sNz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbxv.state = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bxu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bxu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbxv.tNN.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localbxv.tNO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbxv.tNP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbxv.tNQ = ((blu)localObject1);
            paramInt += 1;
          }
        case 7: 
          localbxv.tNR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxt();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bxt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbxv.tNS.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxv
 * JD-Core Version:    0.7.0.1
 */