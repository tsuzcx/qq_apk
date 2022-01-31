package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bdv
  extends com.tencent.mm.bv.a
{
  public String kVn;
  public String mPI;
  public String mPK;
  public int mPL;
  public String mPM;
  public int mPN;
  public String mPO;
  public int mPP;
  public int mPQ;
  public String mPR;
  public String mPS;
  public String mPT;
  public String mPU;
  public String mPV;
  public int mPW;
  public LinkedList<bsh> mPX = new LinkedList();
  public int tze;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mPI != null) {
        paramVarArgs.d(1, this.mPI);
      }
      paramVarArgs.gB(2, this.tze);
      if (this.mPK != null) {
        paramVarArgs.d(3, this.mPK);
      }
      paramVarArgs.gB(4, this.mPL);
      if (this.mPM != null) {
        paramVarArgs.d(5, this.mPM);
      }
      paramVarArgs.gB(6, this.mPN);
      if (this.mPO != null) {
        paramVarArgs.d(7, this.mPO);
      }
      paramVarArgs.gB(8, this.mPP);
      paramVarArgs.gB(9, this.mPQ);
      if (this.mPR != null) {
        paramVarArgs.d(10, this.mPR);
      }
      if (this.kVn != null) {
        paramVarArgs.d(11, this.kVn);
      }
      if (this.mPS != null) {
        paramVarArgs.d(12, this.mPS);
      }
      if (this.mPT != null) {
        paramVarArgs.d(13, this.mPT);
      }
      if (this.mPU != null) {
        paramVarArgs.d(14, this.mPU);
      }
      if (this.mPV != null) {
        paramVarArgs.d(15, this.mPV);
      }
      paramVarArgs.gB(16, this.mPW);
      paramVarArgs.d(17, 8, this.mPX);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mPI == null) {
        break label1061;
      }
    }
    label1061:
    for (paramInt = d.a.a.b.b.a.e(1, this.mPI) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tze);
      paramInt = i;
      if (this.mPK != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.mPK);
      }
      i = paramInt + d.a.a.a.gy(4, this.mPL);
      paramInt = i;
      if (this.mPM != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.mPM);
      }
      i = paramInt + d.a.a.a.gy(6, this.mPN);
      paramInt = i;
      if (this.mPO != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.mPO);
      }
      i = paramInt + d.a.a.a.gy(8, this.mPP) + d.a.a.a.gy(9, this.mPQ);
      paramInt = i;
      if (this.mPR != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.mPR);
      }
      i = paramInt;
      if (this.kVn != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.kVn);
      }
      paramInt = i;
      if (this.mPS != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.mPS);
      }
      i = paramInt;
      if (this.mPT != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.mPT);
      }
      paramInt = i;
      if (this.mPU != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.mPU);
      }
      i = paramInt;
      if (this.mPV != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.mPV);
      }
      return i + d.a.a.a.gy(16, this.mPW) + d.a.a.a.c(17, 8, this.mPX);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mPX.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        bdv localbdv = (bdv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbdv.mPI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbdv.tze = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbdv.mPK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbdv.mPL = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbdv.mPM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbdv.mPN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localbdv.mPO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbdv.mPP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localbdv.mPQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          localbdv.mPR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localbdv.kVn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localbdv.mPS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbdv.mPT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbdv.mPU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbdv.mPV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localbdv.mPW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsh();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bsh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbdv.mPX.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdv
 * JD-Core Version:    0.7.0.1
 */