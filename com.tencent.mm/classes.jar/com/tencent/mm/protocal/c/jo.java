package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class jo
  extends blm
{
  public String sCE;
  public auj sEn;
  public bmv sEo;
  public int sss;
  public String sst;
  
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
      if (this.sCE != null) {
        paramVarArgs.d(2, this.sCE);
      }
      if (this.sEn != null)
      {
        paramVarArgs.gD(3, this.sEn.btq());
        this.sEn.a(paramVarArgs);
      }
      if (this.sEo != null)
      {
        paramVarArgs.gD(4, this.sEo.btq());
        this.sEo.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.sss);
      if (this.sst != null) {
        paramVarArgs.d(6, this.sst);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label716;
      }
    }
    label716:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sCE != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sCE);
      }
      i = paramInt;
      if (this.sEn != null) {
        i = paramInt + d.a.a.a.gA(3, this.sEn.btq());
      }
      paramInt = i;
      if (this.sEo != null) {
        paramInt = i + d.a.a.a.gA(4, this.sEo.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.sss);
      paramInt = i;
      if (this.sst != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sst);
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
        jo localjo = (jo)paramVarArgs[1];
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
            localjo.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localjo.sCE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auj();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localjo.sEn = ((auj)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localjo.sEo = ((bmv)localObject1);
            paramInt += 1;
          }
        case 5: 
          localjo.sss = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localjo.sst = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jo
 * JD-Core Version:    0.7.0.1
 */