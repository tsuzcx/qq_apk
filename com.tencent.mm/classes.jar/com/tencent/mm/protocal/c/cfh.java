package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cfh
  extends blm
{
  public int sNU;
  public int sST;
  public long sSU;
  public int tAC;
  public String tAY;
  public int tLL;
  public cfp tSF;
  public cfp tSG;
  public long tSJ;
  public int tSK;
  public int tTG;
  public int tTR;
  public LinkedList<bml> tTS = new LinkedList();
  public int tTT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tSF == null) {
        throw new b("Not all required fields were included: PeerId");
      }
      if (this.tSG == null) {
        throw new b("Not all required fields were included: CapInfo");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.tAY != null) {
        paramVarArgs.d(2, this.tAY);
      }
      paramVarArgs.gB(3, this.tTR);
      paramVarArgs.d(4, 8, this.tTS);
      if (this.tSF != null)
      {
        paramVarArgs.gD(6, this.tSF.btq());
        this.tSF.a(paramVarArgs);
      }
      if (this.tSG != null)
      {
        paramVarArgs.gD(7, this.tSG.btq());
        this.tSG.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.sNU);
      paramVarArgs.gB(9, this.tLL);
      paramVarArgs.gB(10, this.sST);
      paramVarArgs.Y(11, this.sSU);
      paramVarArgs.gB(12, this.tTG);
      paramVarArgs.Y(13, this.tSJ);
      paramVarArgs.gB(14, this.tTT);
      paramVarArgs.gB(15, this.tAC);
      paramVarArgs.gB(16, this.tSK);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1217;
      }
    }
    label1217:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tAY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tAY);
      }
      i = i + d.a.a.a.gy(3, this.tTR) + d.a.a.a.c(4, 8, this.tTS);
      paramInt = i;
      if (this.tSF != null) {
        paramInt = i + d.a.a.a.gA(6, this.tSF.btq());
      }
      i = paramInt;
      if (this.tSG != null) {
        i = paramInt + d.a.a.a.gA(7, this.tSG.btq());
      }
      return i + d.a.a.a.gy(8, this.sNU) + d.a.a.a.gy(9, this.tLL) + d.a.a.a.gy(10, this.sST) + d.a.a.a.X(11, this.sSU) + d.a.a.a.gy(12, this.tTG) + d.a.a.a.X(13, this.tSJ) + d.a.a.a.gy(14, this.tTT) + d.a.a.a.gy(15, this.tAC) + d.a.a.a.gy(16, this.tSK);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tTS.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tSF == null) {
          throw new b("Not all required fields were included: PeerId");
        }
        if (this.tSG != null) {
          break;
        }
        throw new b("Not all required fields were included: CapInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cfh localcfh = (cfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
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
            localcfh.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcfh.tAY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcfh.tTR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bml();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfh.tTS.add(localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfh.tSF = ((cfp)localObject1);
            paramInt += 1;
          }
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcfh.tSG = ((cfp)localObject1);
            paramInt += 1;
          }
        case 8: 
          localcfh.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcfh.tLL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcfh.sST = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localcfh.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 12: 
          localcfh.tTG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localcfh.tSJ = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 14: 
          localcfh.tTT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localcfh.tAC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcfh.tSK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfh
 * JD-Core Version:    0.7.0.1
 */