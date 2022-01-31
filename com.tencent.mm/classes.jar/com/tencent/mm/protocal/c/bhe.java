package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bhe
  extends bly
{
  public String bVO;
  public int ilo;
  public String imz;
  public int ino;
  public String inp;
  public long sQd;
  public String srM;
  public bya tcF;
  public bmi tle;
  public long tli;
  
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
      paramVarArgs.gB(2, this.ino);
      if (this.inp != null) {
        paramVarArgs.d(3, this.inp);
      }
      if (this.srM != null) {
        paramVarArgs.d(4, this.srM);
      }
      paramVarArgs.Y(5, this.tli);
      paramVarArgs.Y(6, this.sQd);
      if (this.tle != null)
      {
        paramVarArgs.gD(7, this.tle.btq());
        this.tle.a(paramVarArgs);
      }
      if (this.tcF != null)
      {
        paramVarArgs.gD(8, this.tcF.btq());
        this.tcF.a(paramVarArgs);
      }
      if (this.imz != null) {
        paramVarArgs.d(9, this.imz);
      }
      paramVarArgs.gB(10, this.ilo);
      if (this.bVO != null) {
        paramVarArgs.d(11, this.bVO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label987;
      }
    }
    label987:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt;
      if (this.srM != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.srM);
      }
      i = i + d.a.a.a.X(5, this.tli) + d.a.a.a.X(6, this.sQd);
      paramInt = i;
      if (this.tle != null) {
        paramInt = i + d.a.a.a.gA(7, this.tle.btq());
      }
      i = paramInt;
      if (this.tcF != null) {
        i = paramInt + d.a.a.a.gA(8, this.tcF.btq());
      }
      paramInt = i;
      if (this.imz != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.imz);
      }
      i = paramInt + d.a.a.a.gy(10, this.ilo);
      paramInt = i;
      if (this.bVO != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.bVO);
      }
      return paramInt;
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
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bhe localbhe = (bhe)paramVarArgs[1];
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
            localbhe.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbhe.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbhe.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbhe.srM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbhe.tli = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localbhe.sQd = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhe.tle = ((bmi)localObject1);
            paramInt += 1;
          }
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bya();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bya)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbhe.tcF = ((bya)localObject1);
            paramInt += 1;
          }
        case 9: 
          localbhe.imz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbhe.ilo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbhe.bVO = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bhe
 * JD-Core Version:    0.7.0.1
 */