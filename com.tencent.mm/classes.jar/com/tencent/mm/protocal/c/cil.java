package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cil
  extends blm
{
  public int hQR;
  public int sDT;
  public String sFF;
  public int tAu;
  public String tWS;
  public String tWT;
  public String tWU;
  public int tWV;
  public String tWW;
  public String tcJ;
  public int tpI;
  public int tpJ = 2;
  public double tpK;
  public double tpL;
  public String tpM;
  
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
      if (this.tcJ != null) {
        paramVarArgs.d(2, this.tcJ);
      }
      paramVarArgs.gB(3, this.sDT);
      paramVarArgs.gB(4, this.tpI);
      if (this.sFF != null) {
        paramVarArgs.d(5, this.sFF);
      }
      paramVarArgs.gB(6, this.tpJ);
      paramVarArgs.b(7, this.tpK);
      paramVarArgs.b(8, this.tpL);
      paramVarArgs.gB(9, this.hQR);
      paramVarArgs.gB(10, this.tAu);
      if (this.tpM != null) {
        paramVarArgs.d(99, this.tpM);
      }
      if (this.tWS != null) {
        paramVarArgs.d(100, this.tWS);
      }
      if (this.tWT != null) {
        paramVarArgs.d(101, this.tWT);
      }
      if (this.tWU != null) {
        paramVarArgs.d(102, this.tWU);
      }
      paramVarArgs.gB(103, this.tWV);
      if (this.tWW != null) {
        paramVarArgs.d(104, this.tWW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1038;
      }
    }
    label1038:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tcJ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tcJ);
      }
      i = i + d.a.a.a.gy(3, this.sDT) + d.a.a.a.gy(4, this.tpI);
      paramInt = i;
      if (this.sFF != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sFF);
      }
      i = paramInt + d.a.a.a.gy(6, this.tpJ) + (d.a.a.b.b.a.dQ(7) + 8) + (d.a.a.b.b.a.dQ(8) + 8) + d.a.a.a.gy(9, this.hQR) + d.a.a.a.gy(10, this.tAu);
      paramInt = i;
      if (this.tpM != null) {
        paramInt = i + d.a.a.b.b.a.e(99, this.tpM);
      }
      i = paramInt;
      if (this.tWS != null) {
        i = paramInt + d.a.a.b.b.a.e(100, this.tWS);
      }
      paramInt = i;
      if (this.tWT != null) {
        paramInt = i + d.a.a.b.b.a.e(101, this.tWT);
      }
      i = paramInt;
      if (this.tWU != null) {
        i = paramInt + d.a.a.b.b.a.e(102, this.tWU);
      }
      i += d.a.a.a.gy(103, this.tWV);
      paramInt = i;
      if (this.tWW != null) {
        paramInt = i + d.a.a.b.b.a.e(104, this.tWW);
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
        cil localcil = (cil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localcil.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcil.tcJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcil.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcil.tpI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcil.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localcil.tpJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcil.tpK = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 8: 
          localcil.tpL = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 9: 
          localcil.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localcil.tAu = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 99: 
          localcil.tpM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 100: 
          localcil.tWS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 101: 
          localcil.tWT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 102: 
          localcil.tWU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 103: 
          localcil.tWV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcil.tWW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cil
 * JD-Core Version:    0.7.0.1
 */