package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ke
  extends bly
{
  public String bOT;
  public int ino;
  public String inp;
  public int nyU = 0;
  public String nyV;
  public String nyW;
  public String nyX;
  public String nyY;
  public String sER;
  public String sFa;
  public bsb sFb;
  public String sFc;
  public String sFd;
  public int sFe;
  public int sFf;
  public int sFg;
  public bya sFh;
  public String sFi;
  public int sFj;
  public int sFk;
  public int sFl;
  public com.tencent.mm.bv.b sFm;
  public int sFn;
  public int sFo;
  public String swc;
  public String swd;
  public String swe;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      if (this.bOT != null) {
        paramVarArgs.d(4, this.bOT);
      }
      if (this.sFa != null) {
        paramVarArgs.d(5, this.sFa);
      }
      if (this.sFb != null)
      {
        paramVarArgs.gD(6, this.sFb.btq());
        this.sFb.a(paramVarArgs);
      }
      if (this.swc != null) {
        paramVarArgs.d(7, this.swc);
      }
      if (this.swe != null) {
        paramVarArgs.d(8, this.swe);
      }
      if (this.sFc != null) {
        paramVarArgs.d(9, this.sFc);
      }
      if (this.sFd != null) {
        paramVarArgs.d(10, this.sFd);
      }
      paramVarArgs.gB(11, this.sFe);
      if (this.swd != null) {
        paramVarArgs.d(12, this.swd);
      }
      if (this.sER != null) {
        paramVarArgs.d(13, this.sER);
      }
      paramVarArgs.gB(14, this.sFf);
      paramVarArgs.gB(15, this.sFg);
      if (this.sFh != null)
      {
        paramVarArgs.gD(16, this.sFh.btq());
        this.sFh.a(paramVarArgs);
      }
      if (this.sFi != null) {
        paramVarArgs.d(17, this.sFi);
      }
      paramVarArgs.gB(18, this.sFj);
      paramVarArgs.gB(19, this.sFk);
      paramVarArgs.gB(20, this.sFl);
      if (this.sFm != null) {
        paramVarArgs.b(21, this.sFm);
      }
      paramVarArgs.gB(22, this.sFn);
      paramVarArgs.gB(23, this.nyU);
      if (this.nyV != null) {
        paramVarArgs.d(24, this.nyV);
      }
      if (this.nyW != null) {
        paramVarArgs.d(25, this.nyW);
      }
      paramVarArgs.gB(26, this.sFo);
      if (this.nyX != null) {
        paramVarArgs.d(27, this.nyX);
      }
      if (this.nyY != null) {
        paramVarArgs.d(28, this.nyY);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1851;
      }
    }
    label1851:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt;
      if (this.bOT != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.bOT);
      }
      paramInt = i;
      if (this.sFa != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sFa);
      }
      i = paramInt;
      if (this.sFb != null) {
        i = paramInt + d.a.a.a.gA(6, this.sFb.btq());
      }
      paramInt = i;
      if (this.swc != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.swc);
      }
      i = paramInt;
      if (this.swe != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.swe);
      }
      paramInt = i;
      if (this.sFc != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sFc);
      }
      i = paramInt;
      if (this.sFd != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.sFd);
      }
      i += d.a.a.a.gy(11, this.sFe);
      paramInt = i;
      if (this.swd != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.swd);
      }
      i = paramInt;
      if (this.sER != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.sER);
      }
      i = i + d.a.a.a.gy(14, this.sFf) + d.a.a.a.gy(15, this.sFg);
      paramInt = i;
      if (this.sFh != null) {
        paramInt = i + d.a.a.a.gA(16, this.sFh.btq());
      }
      i = paramInt;
      if (this.sFi != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.sFi);
      }
      i = i + d.a.a.a.gy(18, this.sFj) + d.a.a.a.gy(19, this.sFk) + d.a.a.a.gy(20, this.sFl);
      paramInt = i;
      if (this.sFm != null) {
        paramInt = i + d.a.a.a.a(21, this.sFm);
      }
      i = paramInt + d.a.a.a.gy(22, this.sFn) + d.a.a.a.gy(23, this.nyU);
      paramInt = i;
      if (this.nyV != null) {
        paramInt = i + d.a.a.b.b.a.e(24, this.nyV);
      }
      i = paramInt;
      if (this.nyW != null) {
        i = paramInt + d.a.a.b.b.a.e(25, this.nyW);
      }
      i += d.a.a.a.gy(26, this.sFo);
      paramInt = i;
      if (this.nyX != null) {
        paramInt = i + d.a.a.b.b.a.e(27, this.nyX);
      }
      i = paramInt;
      if (this.nyY != null) {
        i = paramInt + d.a.a.b.b.a.e(28, this.nyY);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ke localke = (ke)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localke.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localke.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localke.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localke.bOT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localke.sFa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localke.sFb = ((bsb)localObject1);
            paramInt += 1;
          }
        case 7: 
          localke.swc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localke.swe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localke.sFc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localke.sFd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localke.sFe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localke.swd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localke.sER = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localke.sFf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localke.sFg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bya();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bya)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localke.sFh = ((bya)localObject1);
            paramInt += 1;
          }
        case 17: 
          localke.sFi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localke.sFj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localke.sFk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          localke.sFl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 21: 
          localke.sFm = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 22: 
          localke.sFn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          localke.nyU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 24: 
          localke.nyV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 25: 
          localke.nyW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 26: 
          localke.sFo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 27: 
          localke.nyX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localke.nyY = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ke
 * JD-Core Version:    0.7.0.1
 */