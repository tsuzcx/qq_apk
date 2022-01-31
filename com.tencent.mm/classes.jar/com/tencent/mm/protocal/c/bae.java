package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bae
  extends bly
{
  public int balance;
  public int ino;
  public String inp;
  public aup tvY;
  public int tvZ;
  public int twa;
  public LinkedList<uc> twb = new LinkedList();
  public LinkedList<bjx> twc = new LinkedList();
  public LinkedList<fw> twd = new LinkedList();
  
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
      paramVarArgs.gB(4, this.balance);
      paramVarArgs.gB(5, this.tvZ);
      paramVarArgs.gB(6, this.twa);
      paramVarArgs.d(8, 8, this.twb);
      if (this.tvY != null)
      {
        paramVarArgs.gD(9, this.tvY.btq());
        this.tvY.a(paramVarArgs);
      }
      paramVarArgs.d(10, 8, this.twc);
      paramVarArgs.d(11, 8, this.twd);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1064;
      }
    }
    label1064:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ino);
      paramInt = i;
      if (this.inp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.inp);
      }
      i = paramInt + d.a.a.a.gy(4, this.balance) + d.a.a.a.gy(5, this.tvZ) + d.a.a.a.gy(6, this.twa) + d.a.a.a.c(8, 8, this.twb);
      paramInt = i;
      if (this.tvY != null) {
        paramInt = i + d.a.a.a.gA(9, this.tvY.btq());
      }
      return paramInt + d.a.a.a.c(10, 8, this.twc) + d.a.a.a.c(11, 8, this.twd);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.twb.clear();
        this.twc.clear();
        this.twd.clear();
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
        bae localbae = (bae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
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
            localbae.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbae.ino = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbae.inp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbae.balance = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbae.tvZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbae.twa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbae.twb.add(localObject1);
            paramInt += 1;
          }
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aup();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aup)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbae.tvY = ((aup)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bjx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localbae.twc.add(localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localbae.twd.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bae
 * JD-Core Version:    0.7.0.1
 */