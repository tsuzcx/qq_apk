package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class car
  extends blm
{
  public String bJp;
  public int bba;
  public String bwK;
  public String dRQ;
  public String tGh;
  public int tPJ;
  public int tPK;
  public String tPL;
  public int tPM;
  public String tPN;
  public LinkedList<bvh> tPO = new LinkedList();
  public int tPP;
  public int tPQ;
  
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
      if (this.bwK != null) {
        paramVarArgs.d(2, this.bwK);
      }
      if (this.bJp != null) {
        paramVarArgs.d(3, this.bJp);
      }
      paramVarArgs.gB(4, this.tPJ);
      paramVarArgs.gB(5, this.tPK);
      paramVarArgs.gB(6, this.bba);
      if (this.tPL != null) {
        paramVarArgs.d(7, this.tPL);
      }
      if (this.tGh != null) {
        paramVarArgs.d(8, this.tGh);
      }
      if (this.dRQ != null) {
        paramVarArgs.d(9, this.dRQ);
      }
      paramVarArgs.gB(10, this.tPM);
      if (this.tPN != null) {
        paramVarArgs.d(11, this.tPN);
      }
      paramVarArgs.d(12, 8, this.tPO);
      paramVarArgs.gB(13, this.tPP);
      paramVarArgs.gB(14, this.tPQ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label978;
      }
    }
    label978:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bwK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bwK);
      }
      i = paramInt;
      if (this.bJp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bJp);
      }
      i = i + d.a.a.a.gy(4, this.tPJ) + d.a.a.a.gy(5, this.tPK) + d.a.a.a.gy(6, this.bba);
      paramInt = i;
      if (this.tPL != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tPL);
      }
      i = paramInt;
      if (this.tGh != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tGh);
      }
      paramInt = i;
      if (this.dRQ != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.dRQ);
      }
      i = paramInt + d.a.a.a.gy(10, this.tPM);
      paramInt = i;
      if (this.tPN != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.tPN);
      }
      return paramInt + d.a.a.a.c(12, 8, this.tPO) + d.a.a.a.gy(13, this.tPP) + d.a.a.a.gy(14, this.tPQ);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tPO.clear();
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
        car localcar = (car)paramVarArgs[1];
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
            localcar.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcar.bwK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcar.bJp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localcar.tPJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcar.tPK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcar.bba = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcar.tPL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localcar.tGh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localcar.dRQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localcar.tPM = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localcar.tPN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcar.tPO.add(localObject1);
            paramInt += 1;
          }
        case 13: 
          localcar.tPP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcar.tPQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.car
 * JD-Core Version:    0.7.0.1
 */