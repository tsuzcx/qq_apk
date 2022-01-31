package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aao
  extends bly
{
  public String SSID;
  public String bGw;
  public String hPY;
  public String kVs;
  public String lsL;
  public bmk sZU;
  public String sZV;
  public String sZW;
  public are sZX;
  public aak sZY;
  public String sZZ;
  public String ssn;
  public int ssy;
  public int taa;
  public LinkedList<jn> tab = new LinkedList();
  public String tac;
  public sj tad;
  public bmk tae;
  public int taf;
  public LinkedList<apm> tah = new LinkedList();
  public String tai;
  public String taj;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sZV != null) {
        paramVarArgs.d(2, this.sZV);
      }
      if (this.sZW != null) {
        paramVarArgs.d(3, this.sZW);
      }
      paramVarArgs.gB(4, this.ssy);
      if (this.bGw != null) {
        paramVarArgs.d(5, this.bGw);
      }
      if (this.kVs != null) {
        paramVarArgs.d(6, this.kVs);
      }
      if (this.sZX != null)
      {
        paramVarArgs.gD(7, this.sZX.btq());
        this.sZX.a(paramVarArgs);
      }
      if (this.sZY != null)
      {
        paramVarArgs.gD(8, this.sZY.btq());
        this.sZY.a(paramVarArgs);
      }
      if (this.hPY != null) {
        paramVarArgs.d(9, this.hPY);
      }
      if (this.sZZ != null) {
        paramVarArgs.d(15, this.sZZ);
      }
      paramVarArgs.gB(16, this.taa);
      paramVarArgs.d(17, 8, this.tab);
      if (this.tac != null) {
        paramVarArgs.d(18, this.tac);
      }
      if (this.SSID != null) {
        paramVarArgs.d(20, this.SSID);
      }
      if (this.ssn != null) {
        paramVarArgs.d(21, this.ssn);
      }
      if (this.tad != null)
      {
        paramVarArgs.gD(22, this.tad.btq());
        this.tad.a(paramVarArgs);
      }
      if (this.tae != null)
      {
        paramVarArgs.gD(23, this.tae.btq());
        this.tae.a(paramVarArgs);
      }
      paramVarArgs.gB(24, this.taf);
      paramVarArgs.d(25, 8, this.tah);
      if (this.lsL != null) {
        paramVarArgs.d(26, this.lsL);
      }
      if (this.tai != null) {
        paramVarArgs.d(27, this.tai);
      }
      if (this.sZU != null)
      {
        paramVarArgs.gD(28, this.sZU.btq());
        this.sZU.a(paramVarArgs);
      }
      if (this.taj != null) {
        paramVarArgs.d(29, this.taj);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label2141;
      }
    }
    label2141:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sZV != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sZV);
      }
      i = paramInt;
      if (this.sZW != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sZW);
      }
      i += d.a.a.a.gy(4, this.ssy);
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.bGw);
      }
      i = paramInt;
      if (this.kVs != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.kVs);
      }
      paramInt = i;
      if (this.sZX != null) {
        paramInt = i + d.a.a.a.gA(7, this.sZX.btq());
      }
      i = paramInt;
      if (this.sZY != null) {
        i = paramInt + d.a.a.a.gA(8, this.sZY.btq());
      }
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.hPY);
      }
      i = paramInt;
      if (this.sZZ != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.sZZ);
      }
      i = i + d.a.a.a.gy(16, this.taa) + d.a.a.a.c(17, 8, this.tab);
      paramInt = i;
      if (this.tac != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.tac);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + d.a.a.b.b.a.e(20, this.SSID);
      }
      paramInt = i;
      if (this.ssn != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.ssn);
      }
      i = paramInt;
      if (this.tad != null) {
        i = paramInt + d.a.a.a.gA(22, this.tad.btq());
      }
      paramInt = i;
      if (this.tae != null) {
        paramInt = i + d.a.a.a.gA(23, this.tae.btq());
      }
      i = paramInt + d.a.a.a.gy(24, this.taf) + d.a.a.a.c(25, 8, this.tah);
      paramInt = i;
      if (this.lsL != null) {
        paramInt = i + d.a.a.b.b.a.e(26, this.lsL);
      }
      i = paramInt;
      if (this.tai != null) {
        i = paramInt + d.a.a.b.b.a.e(27, this.tai);
      }
      paramInt = i;
      if (this.sZU != null) {
        paramInt = i + d.a.a.a.gA(28, this.sZU.btq());
      }
      i = paramInt;
      if (this.taj != null) {
        i = paramInt + d.a.a.b.b.a.e(29, this.taj);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tab.clear();
        this.tah.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aao localaao = (aao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 19: 
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
            localaao.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaao.sZV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaao.sZW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localaao.ssy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localaao.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaao.kVs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new are();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((are)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaao.sZX = ((are)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aak();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aak)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaao.sZY = ((aak)localObject1);
            paramInt += 1;
          }
        case 9: 
          localaao.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localaao.sZZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localaao.taa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaao.tab.add(localObject1);
            paramInt += 1;
          }
        case 18: 
          localaao.tac = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 20: 
          localaao.SSID = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localaao.ssn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaao.tad = ((sj)localObject1);
            paramInt += 1;
          }
        case 23: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaao.tae = ((bmk)localObject1);
            paramInt += 1;
          }
        case 24: 
          localaao.taf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 25: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apm();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaao.tah.add(localObject1);
            paramInt += 1;
          }
        case 26: 
          localaao.lsL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 27: 
          localaao.tai = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 28: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaao.sZU = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        localaao.taj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aao
 * JD-Core Version:    0.7.0.1
 */