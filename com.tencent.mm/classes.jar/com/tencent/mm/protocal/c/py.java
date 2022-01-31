package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class py
  extends blm
{
  public String euK;
  public String hPY;
  public String kWt;
  public String psl;
  public String psm;
  public String sBi;
  public aw sHl;
  public String sMg;
  public int sNJ;
  public int sNK;
  public String sNf;
  public String sNg;
  public String sNh;
  public String sNi;
  public int sNj;
  public int sNl;
  public String sNm;
  public int svA;
  
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
      paramVarArgs.gB(9, this.sNj);
      if (this.sHl != null)
      {
        paramVarArgs.gD(10, this.sHl.btq());
        this.sHl.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(11, this.hPY);
      }
      if (this.kWt != null) {
        paramVarArgs.d(12, this.kWt);
      }
      paramVarArgs.gB(13, this.svA);
      paramVarArgs.gB(14, this.sNJ);
      if (this.psl != null) {
        paramVarArgs.d(15, this.psl);
      }
      if (this.psm != null) {
        paramVarArgs.d(16, this.psm);
      }
      paramVarArgs.gB(17, this.sNK);
      paramVarArgs.gB(18, this.sNl);
      if (this.sNm != null) {
        paramVarArgs.d(19, this.sNm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1297;
      }
    }
    label1297:
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
      i = paramInt + d.a.a.a.gy(9, this.sNj);
      paramInt = i;
      if (this.sHl != null) {
        paramInt = i + d.a.a.a.gA(10, this.sHl.btq());
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.hPY);
      }
      paramInt = i;
      if (this.kWt != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.kWt);
      }
      i = paramInt + d.a.a.a.gy(13, this.svA) + d.a.a.a.gy(14, this.sNJ);
      paramInt = i;
      if (this.psl != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.psl);
      }
      i = paramInt;
      if (this.psm != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.psm);
      }
      i = i + d.a.a.a.gy(17, this.sNK) + d.a.a.a.gy(18, this.sNl);
      paramInt = i;
      if (this.sNm != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.sNm);
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
        py localpy = (py)paramVarArgs[1];
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
            localpy.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localpy.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localpy.sNf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localpy.sBi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localpy.sNg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localpy.sNh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localpy.sNi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localpy.sMg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localpy.sNj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localpy.sHl = ((aw)localObject1);
            paramInt += 1;
          }
        case 11: 
          localpy.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localpy.kWt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localpy.svA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localpy.sNJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localpy.psl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localpy.psm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localpy.sNK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localpy.sNl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localpy.sNm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.py
 * JD-Core Version:    0.7.0.1
 */