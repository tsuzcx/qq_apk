package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class pk
  extends blm
{
  public String euK;
  public String hPY;
  public String kWt;
  public String sBi;
  public aw sHl;
  public String sMg;
  public String sNf;
  public String sNg;
  public String sNh;
  public String sNi;
  public int sNj;
  public String sNk;
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
      if (this.sNk != null) {
        paramVarArgs.d(11, this.sNk);
      }
      if (this.hPY != null) {
        paramVarArgs.d(12, this.hPY);
      }
      if (this.kWt != null) {
        paramVarArgs.d(13, this.kWt);
      }
      paramVarArgs.gB(14, this.svA);
      paramVarArgs.gB(15, this.sNl);
      if (this.sNm != null) {
        paramVarArgs.d(16, this.sNm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1160;
      }
    }
    label1160:
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
      if (this.sNk != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sNk);
      }
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.hPY);
      }
      i = paramInt;
      if (this.kWt != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.kWt);
      }
      i = i + d.a.a.a.gy(14, this.svA) + d.a.a.a.gy(15, this.sNl);
      paramInt = i;
      if (this.sNm != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.sNm);
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
        pk localpk = (pk)paramVarArgs[1];
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
            localpk.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localpk.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localpk.sNf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localpk.sBi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localpk.sNg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localpk.sNh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localpk.sNi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localpk.sMg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localpk.sNj = ((d.a.a.a.a)localObject1).xpH.oD();
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
            localpk.sHl = ((aw)localObject1);
            paramInt += 1;
          }
        case 11: 
          localpk.sNk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localpk.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localpk.kWt = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localpk.svA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localpk.sNl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localpk.sNm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.pk
 * JD-Core Version:    0.7.0.1
 */