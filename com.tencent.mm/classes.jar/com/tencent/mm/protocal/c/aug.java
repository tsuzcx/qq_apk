package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class aug
  extends blm
{
  public int sDT;
  public String sFF;
  public String tcJ;
  public int tpI;
  public int tpJ = 2;
  public double tpK;
  public double tpL;
  public String tpM;
  public b tpN;
  public b tpO;
  
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
      if (this.tpM != null) {
        paramVarArgs.d(9, this.tpM);
      }
      if (this.tpN != null) {
        paramVarArgs.b(11, this.tpN);
      }
      if (this.tpO != null) {
        paramVarArgs.b(12, this.tpO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label745;
      }
    }
    label745:
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
      i = paramInt + d.a.a.a.gy(6, this.tpJ) + (d.a.a.b.b.a.dQ(7) + 8) + (d.a.a.b.b.a.dQ(8) + 8);
      paramInt = i;
      if (this.tpM != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tpM);
      }
      i = paramInt;
      if (this.tpN != null) {
        i = paramInt + d.a.a.a.a(11, this.tpN);
      }
      paramInt = i;
      if (this.tpO != null) {
        paramInt = i + d.a.a.a.a(12, this.tpO);
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
        aug localaug = (aug)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 10: 
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
            localaug.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaug.tcJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaug.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localaug.tpI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localaug.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaug.tpJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localaug.tpK = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 8: 
          localaug.tpL = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 9: 
          localaug.tpM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localaug.tpN = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localaug.tpO = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aug
 * JD-Core Version:    0.7.0.1
 */