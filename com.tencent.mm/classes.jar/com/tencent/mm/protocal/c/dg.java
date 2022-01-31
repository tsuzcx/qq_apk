package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class dg
  extends com.tencent.mm.bv.a
{
  public int kSS;
  public String kSb;
  public int kSc;
  public String swA;
  public aaf swB;
  public String swC;
  public String swD;
  public String sww;
  public long swx;
  public String swy;
  public String swz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sww != null) {
        paramVarArgs.d(1, this.sww);
      }
      if (this.kSb != null) {
        paramVarArgs.d(2, this.kSb);
      }
      paramVarArgs.Y(3, this.swx);
      if (this.swy != null) {
        paramVarArgs.d(4, this.swy);
      }
      if (this.swz != null) {
        paramVarArgs.d(5, this.swz);
      }
      paramVarArgs.gB(6, this.kSS);
      paramVarArgs.gB(7, this.kSc);
      if (this.swA != null) {
        paramVarArgs.d(8, this.swA);
      }
      if (this.swB != null)
      {
        paramVarArgs.gD(9, this.swB.btq());
        this.swB.a(paramVarArgs);
      }
      if (this.swC != null) {
        paramVarArgs.d(10, this.swC);
      }
      if (this.swD != null) {
        paramVarArgs.d(11, this.swD);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sww == null) {
        break label783;
      }
    }
    label783:
    for (paramInt = d.a.a.b.b.a.e(1, this.sww) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kSb != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.kSb);
      }
      i += d.a.a.a.X(3, this.swx);
      paramInt = i;
      if (this.swy != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.swy);
      }
      i = paramInt;
      if (this.swz != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.swz);
      }
      i = i + d.a.a.a.gy(6, this.kSS) + d.a.a.a.gy(7, this.kSc);
      paramInt = i;
      if (this.swA != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.swA);
      }
      i = paramInt;
      if (this.swB != null) {
        i = paramInt + d.a.a.a.gA(9, this.swB.btq());
      }
      paramInt = i;
      if (this.swC != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.swC);
      }
      i = paramInt;
      if (this.swD != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.swD);
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
        dg localdg = (dg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localdg.sww = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localdg.kSb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localdg.swx = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localdg.swy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localdg.swz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localdg.kSS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localdg.kSc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localdg.swA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aaf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localdg.swB = ((aaf)localObject1);
            paramInt += 1;
          }
        case 10: 
          localdg.swC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localdg.swD = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dg
 * JD-Core Version:    0.7.0.1
 */