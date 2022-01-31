package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cna
  extends com.tencent.mm.bv.a
{
  public cnc tZL;
  public cnb tZM;
  public cnd tZN;
  public cnf tZO;
  public cne tZP;
  public cng tZQ;
  public cmz tZR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tZL != null)
      {
        paramVarArgs.gD(1, this.tZL.btq());
        this.tZL.a(paramVarArgs);
      }
      if (this.tZM != null)
      {
        paramVarArgs.gD(2, this.tZM.btq());
        this.tZM.a(paramVarArgs);
      }
      if (this.tZN != null)
      {
        paramVarArgs.gD(3, this.tZN.btq());
        this.tZN.a(paramVarArgs);
      }
      if (this.tZO != null)
      {
        paramVarArgs.gD(4, this.tZO.btq());
        this.tZO.a(paramVarArgs);
      }
      if (this.tZP != null)
      {
        paramVarArgs.gD(5, this.tZP.btq());
        this.tZP.a(paramVarArgs);
      }
      if (this.tZQ != null)
      {
        paramVarArgs.gD(6, this.tZQ.btq());
        this.tZQ.a(paramVarArgs);
      }
      if (this.tZR != null)
      {
        paramVarArgs.gD(7, this.tZR.btq());
        this.tZR.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tZL == null) {
        break label1159;
      }
    }
    label1159:
    for (int i = d.a.a.a.gA(1, this.tZL.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tZM != null) {
        paramInt = i + d.a.a.a.gA(2, this.tZM.btq());
      }
      i = paramInt;
      if (this.tZN != null) {
        i = paramInt + d.a.a.a.gA(3, this.tZN.btq());
      }
      paramInt = i;
      if (this.tZO != null) {
        paramInt = i + d.a.a.a.gA(4, this.tZO.btq());
      }
      i = paramInt;
      if (this.tZP != null) {
        i = paramInt + d.a.a.a.gA(5, this.tZP.btq());
      }
      paramInt = i;
      if (this.tZQ != null) {
        paramInt = i + d.a.a.a.gA(6, this.tZQ.btq());
      }
      i = paramInt;
      if (this.tZR != null) {
        i = paramInt + d.a.a.a.gA(7, this.tZR.btq());
      }
      return i;
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
        cna localcna = (cna)paramVarArgs[1];
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
            localObject1 = new cnc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcna.tZL = ((cnc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcna.tZM = ((cnb)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcna.tZN = ((cnd)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cnf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cnf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcna.tZO = ((cnf)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cne();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cne)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcna.tZP = ((cne)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cng();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cng)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcna.tZQ = ((cng)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmz();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcna.tZR = ((cmz)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cna
 * JD-Core Version:    0.7.0.1
 */