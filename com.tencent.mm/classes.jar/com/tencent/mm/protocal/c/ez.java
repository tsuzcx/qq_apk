package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ez
  extends blm
{
  public String ffk;
  public String hQc;
  public String jxh;
  public String jxi;
  public String ljr;
  public int sss;
  public ga syE;
  public String syF;
  public int syG;
  public String syH;
  public String syI;
  public bmk syi;
  public bmk tpt;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syi == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
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
      if (this.syi != null)
      {
        paramVarArgs.gD(3, this.syi.btq());
        this.syi.a(paramVarArgs);
      }
      if (this.ljr != null) {
        paramVarArgs.d(4, this.ljr);
      }
      if (this.syF != null) {
        paramVarArgs.d(5, this.syF);
      }
      paramVarArgs.gB(6, this.syG);
      if (this.syH != null) {
        paramVarArgs.d(7, this.syH);
      }
      if (this.ffk != null) {
        paramVarArgs.d(8, this.ffk);
      }
      if (this.hQc != null) {
        paramVarArgs.d(9, this.hQc);
      }
      if (this.syI != null) {
        paramVarArgs.d(10, this.syI);
      }
      if (this.jxi != null) {
        paramVarArgs.d(11, this.jxi);
      }
      if (this.jxh != null) {
        paramVarArgs.d(12, this.jxh);
      }
      paramVarArgs.gB(13, this.sss);
      if (this.tpt != null)
      {
        paramVarArgs.gD(14, this.tpt.btq());
        this.tpt.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1282;
      }
    }
    label1282:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syE != null) {
        paramInt = i + d.a.a.a.gA(2, this.syE.btq());
      }
      i = paramInt;
      if (this.syi != null) {
        i = paramInt + d.a.a.a.gA(3, this.syi.btq());
      }
      paramInt = i;
      if (this.ljr != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ljr);
      }
      i = paramInt;
      if (this.syF != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.syF);
      }
      i += d.a.a.a.gy(6, this.syG);
      paramInt = i;
      if (this.syH != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.syH);
      }
      i = paramInt;
      if (this.ffk != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.ffk);
      }
      paramInt = i;
      if (this.hQc != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.hQc);
      }
      i = paramInt;
      if (this.syI != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.syI);
      }
      paramInt = i;
      if (this.jxi != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.jxi);
      }
      i = paramInt;
      if (this.jxh != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.jxh);
      }
      i += d.a.a.a.gy(13, this.sss);
      paramInt = i;
      if (this.tpt != null) {
        paramInt = i + d.a.a.a.gA(14, this.tpt.btq());
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
        if (this.syi != null) {
          break;
        }
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ez localez = (ez)paramVarArgs[1];
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
            localez.tEX = ((gc)localObject1);
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
            localez.syE = ((ga)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localez.syi = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localez.ljr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localez.syF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localez.syG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localez.syH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localez.ffk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localez.hQc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localez.syI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localez.jxi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localez.jxh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localez.sss = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localez.tpt = ((bmk)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ez
 * JD-Core Version:    0.7.0.1
 */