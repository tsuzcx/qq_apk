package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ic
  extends blm
{
  public bmk sAc;
  public String sBC;
  public int sBN;
  public String sBO;
  public String sBP;
  public String sBQ;
  public int sBR;
  public bml sBS;
  public bmk sBT;
  public int sBU;
  public String sBr;
  public String sBs;
  
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
      paramVarArgs.gB(2, this.sBN);
      if (this.sBC != null) {
        paramVarArgs.d(3, this.sBC);
      }
      if (this.sBO != null) {
        paramVarArgs.d(4, this.sBO);
      }
      if (this.sBP != null) {
        paramVarArgs.d(5, this.sBP);
      }
      if (this.sBQ != null) {
        paramVarArgs.d(6, this.sBQ);
      }
      paramVarArgs.gB(7, this.sBR);
      if (this.sBS != null)
      {
        paramVarArgs.gD(8, this.sBS.btq());
        this.sBS.a(paramVarArgs);
      }
      if (this.sBT != null)
      {
        paramVarArgs.gD(9, this.sBT.btq());
        this.sBT.a(paramVarArgs);
      }
      paramVarArgs.gB(10, this.sBU);
      if (this.sBr != null) {
        paramVarArgs.d(11, this.sBr);
      }
      if (this.sBs != null) {
        paramVarArgs.d(12, this.sBs);
      }
      if (this.sAc != null)
      {
        paramVarArgs.gD(13, this.sAc.btq());
        this.sAc.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1175;
      }
    }
    label1175:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sBN);
      paramInt = i;
      if (this.sBC != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sBC);
      }
      i = paramInt;
      if (this.sBO != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sBO);
      }
      paramInt = i;
      if (this.sBP != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sBP);
      }
      i = paramInt;
      if (this.sBQ != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sBQ);
      }
      i += d.a.a.a.gy(7, this.sBR);
      paramInt = i;
      if (this.sBS != null) {
        paramInt = i + d.a.a.a.gA(8, this.sBS.btq());
      }
      i = paramInt;
      if (this.sBT != null) {
        i = paramInt + d.a.a.a.gA(9, this.sBT.btq());
      }
      i += d.a.a.a.gy(10, this.sBU);
      paramInt = i;
      if (this.sBr != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sBr);
      }
      i = paramInt;
      if (this.sBs != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.sBs);
      }
      paramInt = i;
      if (this.sAc != null) {
        paramInt = i + d.a.a.a.gA(13, this.sAc.btq());
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
        ic localic = (ic)paramVarArgs[1];
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
            localic.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localic.sBN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localic.sBC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localic.sBO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localic.sBP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localic.sBQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localic.sBR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localic.sBS = ((bml)localObject1);
            paramInt += 1;
          }
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localic.sBT = ((bmk)localObject1);
            paramInt += 1;
          }
        case 10: 
          localic.sBU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localic.sBr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localic.sBs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localic.sAc = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ic
 * JD-Core Version:    0.7.0.1
 */