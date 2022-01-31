package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class dn
  extends com.tencent.mm.bv.a
{
  public String euK;
  public int hQR;
  public String kVs;
  public String kWm;
  public String kWn;
  public int mPL;
  public String svK;
  public int swP;
  public String swQ;
  public bmk swR;
  public int swS;
  public int swT;
  public String swU;
  public String swV;
  public String swW;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.kWn != null) {
        paramVarArgs.d(1, this.kWn);
      }
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      paramVarArgs.gB(3, this.swP);
      if (this.kWm != null) {
        paramVarArgs.d(4, this.kWm);
      }
      paramVarArgs.gB(5, this.hQR);
      if (this.kVs != null) {
        paramVarArgs.d(6, this.kVs);
      }
      paramVarArgs.gB(7, this.mPL);
      if (this.swQ != null) {
        paramVarArgs.d(8, this.swQ);
      }
      if (this.swR != null)
      {
        paramVarArgs.gD(9, this.swR.btq());
        this.swR.a(paramVarArgs);
      }
      paramVarArgs.gB(10, this.swS);
      paramVarArgs.gB(11, this.swT);
      if (this.svK != null) {
        paramVarArgs.d(12, this.svK);
      }
      if (this.swU != null) {
        paramVarArgs.d(13, this.swU);
      }
      if (this.swV != null) {
        paramVarArgs.d(14, this.swV);
      }
      if (this.swW != null) {
        paramVarArgs.d(15, this.swW);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.kWn == null) {
        break label979;
      }
    }
    label979:
    for (paramInt = d.a.a.b.b.a.e(1, this.kWn) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.euK);
      }
      i += d.a.a.a.gy(3, this.swP);
      paramInt = i;
      if (this.kWm != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kWm);
      }
      i = paramInt + d.a.a.a.gy(5, this.hQR);
      paramInt = i;
      if (this.kVs != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.kVs);
      }
      i = paramInt + d.a.a.a.gy(7, this.mPL);
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.swQ);
      }
      i = paramInt;
      if (this.swR != null) {
        i = paramInt + d.a.a.a.gA(9, this.swR.btq());
      }
      i = i + d.a.a.a.gy(10, this.swS) + d.a.a.a.gy(11, this.swT);
      paramInt = i;
      if (this.svK != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.svK);
      }
      i = paramInt;
      if (this.swU != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.swU);
      }
      paramInt = i;
      if (this.swV != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.swV);
      }
      i = paramInt;
      if (this.swW != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.swW);
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
        dn localdn = (dn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localdn.kWn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localdn.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localdn.swP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localdn.kWm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localdn.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localdn.kVs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localdn.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localdn.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localdn.swR = ((bmk)localObject1);
            paramInt += 1;
          }
        case 10: 
          localdn.swS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localdn.swT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localdn.svK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localdn.swU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localdn.swV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localdn.swW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dn
 * JD-Core Version:    0.7.0.1
 */