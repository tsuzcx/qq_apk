package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cfj
  extends com.tencent.mm.bv.a
{
  public int lpZ;
  public cfp tSF;
  public cfp tSG;
  public int tTX;
  public cec tTY;
  public cec tTZ;
  public int tUa;
  public int tUb;
  public int tUc;
  public int tUd;
  public bmk tUe;
  public int tUf;
  public cec tUg;
  public int tUh;
  public int tUi;
  public int tUj;
  public int tUk;
  public int tUl;
  public int tUm;
  public bmk tUn;
  public bmk tUo;
  public int tUp;
  public bmk tUq;
  public int tUr;
  public int tUs;
  public int tUt;
  public asc tUu;
  public bmk tUv;
  public int tUw;
  public String tUx;
  public int tUy;
  public LinkedList<cfk> tUz = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tSF == null) {
        throw new b("Not all required fields were included: PeerId");
      }
      if (this.tSG == null) {
        throw new b("Not all required fields were included: CapInfo");
      }
      if (this.tSF != null)
      {
        paramVarArgs.gD(1, this.tSF.btq());
        this.tSF.a(paramVarArgs);
      }
      if (this.tSG != null)
      {
        paramVarArgs.gD(2, this.tSG.btq());
        this.tSG.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tTX);
      if (this.tTY != null)
      {
        paramVarArgs.gD(4, this.tTY.btq());
        this.tTY.a(paramVarArgs);
      }
      if (this.tTZ != null)
      {
        paramVarArgs.gD(5, this.tTZ.btq());
        this.tTZ.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.tUa);
      paramVarArgs.gB(7, this.tUb);
      paramVarArgs.gB(8, this.tUc);
      paramVarArgs.gB(9, this.tUd);
      if (this.tUe != null)
      {
        paramVarArgs.gD(10, this.tUe.btq());
        this.tUe.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.tUf);
      if (this.tUg != null)
      {
        paramVarArgs.gD(12, this.tUg.btq());
        this.tUg.a(paramVarArgs);
      }
      paramVarArgs.gB(13, this.tUh);
      paramVarArgs.gB(14, this.tUi);
      paramVarArgs.gB(15, this.tUj);
      paramVarArgs.gB(16, this.tUk);
      paramVarArgs.gB(17, this.tUl);
      paramVarArgs.gB(18, this.lpZ);
      paramVarArgs.gB(19, this.tUm);
      if (this.tUn != null)
      {
        paramVarArgs.gD(20, this.tUn.btq());
        this.tUn.a(paramVarArgs);
      }
      if (this.tUo != null)
      {
        paramVarArgs.gD(21, this.tUo.btq());
        this.tUo.a(paramVarArgs);
      }
      paramVarArgs.gB(22, this.tUp);
      if (this.tUq != null)
      {
        paramVarArgs.gD(23, this.tUq.btq());
        this.tUq.a(paramVarArgs);
      }
      paramVarArgs.gB(24, this.tUr);
      paramVarArgs.gB(25, this.tUs);
      paramVarArgs.gB(26, this.tUt);
      if (this.tUu != null)
      {
        paramVarArgs.gD(27, this.tUu.btq());
        this.tUu.a(paramVarArgs);
      }
      if (this.tUv != null)
      {
        paramVarArgs.gD(28, this.tUv.btq());
        this.tUv.a(paramVarArgs);
      }
      paramVarArgs.gB(29, this.tUw);
      if (this.tUx != null) {
        paramVarArgs.d(30, this.tUx);
      }
      paramVarArgs.gB(31, this.tUy);
      paramVarArgs.d(32, 8, this.tUz);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tSF == null) {
        break label2768;
      }
    }
    label2768:
    for (paramInt = d.a.a.a.gA(1, this.tSF.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tSG != null) {
        i = paramInt + d.a.a.a.gA(2, this.tSG.btq());
      }
      i += d.a.a.a.gy(3, this.tTX);
      paramInt = i;
      if (this.tTY != null) {
        paramInt = i + d.a.a.a.gA(4, this.tTY.btq());
      }
      i = paramInt;
      if (this.tTZ != null) {
        i = paramInt + d.a.a.a.gA(5, this.tTZ.btq());
      }
      i = i + d.a.a.a.gy(6, this.tUa) + d.a.a.a.gy(7, this.tUb) + d.a.a.a.gy(8, this.tUc) + d.a.a.a.gy(9, this.tUd);
      paramInt = i;
      if (this.tUe != null) {
        paramInt = i + d.a.a.a.gA(10, this.tUe.btq());
      }
      i = paramInt + d.a.a.a.gy(11, this.tUf);
      paramInt = i;
      if (this.tUg != null) {
        paramInt = i + d.a.a.a.gA(12, this.tUg.btq());
      }
      i = paramInt + d.a.a.a.gy(13, this.tUh) + d.a.a.a.gy(14, this.tUi) + d.a.a.a.gy(15, this.tUj) + d.a.a.a.gy(16, this.tUk) + d.a.a.a.gy(17, this.tUl) + d.a.a.a.gy(18, this.lpZ) + d.a.a.a.gy(19, this.tUm);
      paramInt = i;
      if (this.tUn != null) {
        paramInt = i + d.a.a.a.gA(20, this.tUn.btq());
      }
      i = paramInt;
      if (this.tUo != null) {
        i = paramInt + d.a.a.a.gA(21, this.tUo.btq());
      }
      i += d.a.a.a.gy(22, this.tUp);
      paramInt = i;
      if (this.tUq != null) {
        paramInt = i + d.a.a.a.gA(23, this.tUq.btq());
      }
      i = paramInt + d.a.a.a.gy(24, this.tUr) + d.a.a.a.gy(25, this.tUs) + d.a.a.a.gy(26, this.tUt);
      paramInt = i;
      if (this.tUu != null) {
        paramInt = i + d.a.a.a.gA(27, this.tUu.btq());
      }
      i = paramInt;
      if (this.tUv != null) {
        i = paramInt + d.a.a.a.gA(28, this.tUv.btq());
      }
      i += d.a.a.a.gy(29, this.tUw);
      paramInt = i;
      if (this.tUx != null) {
        paramInt = i + d.a.a.b.b.a.e(30, this.tUx);
      }
      return paramInt + d.a.a.a.gy(31, this.tUy) + d.a.a.a.c(32, 8, this.tUz);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tUz.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tSF == null) {
          throw new b("Not all required fields were included: PeerId");
        }
        if (this.tSG != null) {
          break;
        }
        throw new b("Not all required fields were included: CapInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cfj localcfj = (cfj)paramVarArgs[1];
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
            localObject1 = new cfp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tSF = ((cfp)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tSG = ((cfp)localObject1);
            paramInt += 1;
          }
        case 3: 
          localcfj.tTX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cec();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cec)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tTY = ((cec)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cec();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cec)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tTZ = ((cec)localObject1);
            paramInt += 1;
          }
        case 6: 
          localcfj.tUa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcfj.tUb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localcfj.tUc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localcfj.tUd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tUe = ((bmk)localObject1);
            paramInt += 1;
          }
        case 11: 
          localcfj.tUf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cec();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cec)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tUg = ((cec)localObject1);
            paramInt += 1;
          }
        case 13: 
          localcfj.tUh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localcfj.tUi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localcfj.tUj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localcfj.tUk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localcfj.tUl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localcfj.lpZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localcfj.tUm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 20: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tUn = ((bmk)localObject1);
            paramInt += 1;
          }
        case 21: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tUo = ((bmk)localObject1);
            paramInt += 1;
          }
        case 22: 
          localcfj.tUp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 23: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tUq = ((bmk)localObject1);
            paramInt += 1;
          }
        case 24: 
          localcfj.tUr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          localcfj.tUs = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 26: 
          localcfj.tUt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 27: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tUu = ((asc)localObject1);
            paramInt += 1;
          }
        case 28: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcfj.tUv = ((bmk)localObject1);
            paramInt += 1;
          }
        case 29: 
          localcfj.tUw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 30: 
          localcfj.tUx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 31: 
          localcfj.tUy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localcfj.tUz.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cfj
 * JD-Core Version:    0.7.0.1
 */