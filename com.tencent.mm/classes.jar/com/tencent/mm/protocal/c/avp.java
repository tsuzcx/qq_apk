package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class avp
  extends blm
{
  public String ffk;
  public String hQc;
  public String jxh;
  public String jxi;
  public int kTR;
  public String ljr;
  public String sEc;
  public String sEd;
  public String sRp;
  public String sZM;
  public int sss;
  public ga syE;
  public String syF;
  public int syG;
  public String syH;
  public String syI;
  public bmk tpt;
  public String trf;
  public String trg;
  public String trh;
  public int tri;
  
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
      if (this.syE != null)
      {
        paramVarArgs.gD(2, this.syE.btq());
        this.syE.a(paramVarArgs);
      }
      if (this.ljr != null) {
        paramVarArgs.d(3, this.ljr);
      }
      if (this.syF != null) {
        paramVarArgs.d(4, this.syF);
      }
      paramVarArgs.gB(5, this.syG);
      if (this.syH != null) {
        paramVarArgs.d(6, this.syH);
      }
      if (this.ffk != null) {
        paramVarArgs.d(7, this.ffk);
      }
      if (this.hQc != null) {
        paramVarArgs.d(8, this.hQc);
      }
      if (this.syI != null) {
        paramVarArgs.d(9, this.syI);
      }
      if (this.jxi != null) {
        paramVarArgs.d(10, this.jxi);
      }
      if (this.jxh != null) {
        paramVarArgs.d(11, this.jxh);
      }
      paramVarArgs.gB(13, this.sss);
      paramVarArgs.gB(14, this.kTR);
      if (this.sEd != null) {
        paramVarArgs.d(15, this.sEd);
      }
      if (this.sEc != null) {
        paramVarArgs.d(16, this.sEc);
      }
      if (this.trf != null) {
        paramVarArgs.d(17, this.trf);
      }
      if (this.sRp != null) {
        paramVarArgs.d(18, this.sRp);
      }
      if (this.sZM != null) {
        paramVarArgs.d(19, this.sZM);
      }
      if (this.trg != null) {
        paramVarArgs.d(20, this.trg);
      }
      if (this.trh != null) {
        paramVarArgs.d(21, this.trh);
      }
      paramVarArgs.gB(22, this.tri);
      if (this.tpt != null)
      {
        paramVarArgs.gD(23, this.tpt.btq());
        this.tpt.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1584;
      }
    }
    label1584:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syE != null) {
        paramInt = i + d.a.a.a.gA(2, this.syE.btq());
      }
      i = paramInt;
      if (this.ljr != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ljr);
      }
      paramInt = i;
      if (this.syF != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.syF);
      }
      i = paramInt + d.a.a.a.gy(5, this.syG);
      paramInt = i;
      if (this.syH != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.syH);
      }
      i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.ffk);
      }
      paramInt = i;
      if (this.hQc != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.hQc);
      }
      i = paramInt;
      if (this.syI != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.syI);
      }
      paramInt = i;
      if (this.jxi != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.jxi);
      }
      i = paramInt;
      if (this.jxh != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.jxh);
      }
      i = i + d.a.a.a.gy(13, this.sss) + d.a.a.a.gy(14, this.kTR);
      paramInt = i;
      if (this.sEd != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.sEd);
      }
      i = paramInt;
      if (this.sEc != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.sEc);
      }
      paramInt = i;
      if (this.trf != null) {
        paramInt = i + d.a.a.b.b.a.e(17, this.trf);
      }
      i = paramInt;
      if (this.sRp != null) {
        i = paramInt + d.a.a.b.b.a.e(18, this.sRp);
      }
      paramInt = i;
      if (this.sZM != null) {
        paramInt = i + d.a.a.b.b.a.e(19, this.sZM);
      }
      i = paramInt;
      if (this.trg != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.trg);
      }
      paramInt = i;
      if (this.trh != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.trh);
      }
      i = paramInt + d.a.a.a.gy(22, this.tri);
      paramInt = i;
      if (this.tpt != null) {
        paramInt = i + d.a.a.a.gA(23, this.tpt.btq());
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
        avp localavp = (avp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 12: 
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
            localavp.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ga();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ga)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localavp.syE = ((ga)localObject1);
            paramInt += 1;
          }
        case 3: 
          localavp.ljr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localavp.syF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localavp.syG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localavp.syH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localavp.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localavp.hQc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localavp.syI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localavp.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localavp.jxh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localavp.sss = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localavp.kTR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localavp.sEd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localavp.sEc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localavp.trf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 18: 
          localavp.sRp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 19: 
          localavp.sZM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localavp.trg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localavp.trh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localavp.tri = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localavp.tpt = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.avp
 * JD-Core Version:    0.7.0.1
 */