package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aai
  extends blm
{
  public String euK;
  public String kWx;
  public int pyo;
  public String sBi;
  public aw sHl;
  public String sMg;
  public String sNf;
  public String sNg;
  public String sNh;
  public String sNi;
  public String sZA;
  public int sZB;
  public String sZC;
  public String sZw;
  public String sZz;
  public int sss;
  
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
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.sNf != null) {
        paramVarArgs.d(3, this.sNf);
      }
      if (this.sBi != null) {
        paramVarArgs.d(4, this.sBi);
      }
      if (this.sNg != null) {
        paramVarArgs.d(5, this.sNg);
      }
      if (this.sNh != null) {
        paramVarArgs.d(6, this.sNh);
      }
      if (this.sNi != null) {
        paramVarArgs.d(7, this.sNi);
      }
      if (this.sMg != null) {
        paramVarArgs.d(8, this.sMg);
      }
      if (this.sZw != null) {
        paramVarArgs.d(9, this.sZw);
      }
      paramVarArgs.gB(10, this.sss);
      if (this.kWx != null) {
        paramVarArgs.d(11, this.kWx);
      }
      if (this.sZz != null) {
        paramVarArgs.d(12, this.sZz);
      }
      if (this.sZA != null) {
        paramVarArgs.d(13, this.sZA);
      }
      if (this.sHl != null)
      {
        paramVarArgs.gD(14, this.sHl.btq());
        this.sHl.a(paramVarArgs);
      }
      paramVarArgs.gB(15, this.pyo);
      paramVarArgs.gB(16, this.sZB);
      if (this.sZC != null) {
        paramVarArgs.d(17, this.sZC);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1219;
      }
    }
    label1219:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.sNf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sNf);
      }
      paramInt = i;
      if (this.sBi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sBi);
      }
      i = paramInt;
      if (this.sNg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sNg);
      }
      paramInt = i;
      if (this.sNh != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sNh);
      }
      i = paramInt;
      if (this.sNi != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sNi);
      }
      paramInt = i;
      if (this.sMg != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sMg);
      }
      i = paramInt;
      if (this.sZw != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sZw);
      }
      i += d.a.a.a.gy(10, this.sss);
      paramInt = i;
      if (this.kWx != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.kWx);
      }
      i = paramInt;
      if (this.sZz != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.sZz);
      }
      paramInt = i;
      if (this.sZA != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.sZA);
      }
      i = paramInt;
      if (this.sHl != null) {
        i = paramInt + d.a.a.a.gA(14, this.sHl.btq());
      }
      i = i + d.a.a.a.gy(15, this.pyo) + d.a.a.a.gy(16, this.sZB);
      paramInt = i;
      if (this.sZC != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.sZC);
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
        aai localaai = (aai)paramVarArgs[1];
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
            localaai.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaai.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaai.sNf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaai.sBi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localaai.sNg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaai.sNh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localaai.sNi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localaai.sMg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localaai.sZw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localaai.sss = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localaai.kWx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localaai.sZz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localaai.sZA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaai.sHl = ((aw)localObject1);
            paramInt += 1;
          }
        case 15: 
          localaai.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localaai.sZB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaai.sZC = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aai
 * JD-Core Version:    0.7.0.1
 */