package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ad
  extends bly
{
  public bsf ssA;
  public bkb ssB;
  public int ssI;
  public rh ssM;
  public boolean ssN;
  public int ssO;
  public int ssy;
  public String ssz;
  
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
      paramVarArgs.gB(2, this.ssy);
      if (this.ssz != null) {
        paramVarArgs.d(3, this.ssz);
      }
      if (this.ssA != null)
      {
        paramVarArgs.gD(4, this.ssA.btq());
        this.ssA.a(paramVarArgs);
      }
      if (this.ssB != null)
      {
        paramVarArgs.gD(5, this.ssB.btq());
        this.ssB.a(paramVarArgs);
      }
      paramVarArgs.gB(6, this.ssI);
      if (this.ssM != null)
      {
        paramVarArgs.gD(7, this.ssM.btq());
        this.ssM.a(paramVarArgs);
      }
      paramVarArgs.aA(8, this.ssN);
      paramVarArgs.gB(9, this.ssO);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label956;
      }
    }
    label956:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssy);
      paramInt = i;
      if (this.ssz != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.ssz);
      }
      i = paramInt;
      if (this.ssA != null) {
        i = paramInt + d.a.a.a.gA(4, this.ssA.btq());
      }
      paramInt = i;
      if (this.ssB != null) {
        paramInt = i + d.a.a.a.gA(5, this.ssB.btq());
      }
      i = paramInt + d.a.a.a.gy(6, this.ssI);
      paramInt = i;
      if (this.ssM != null) {
        paramInt = i + d.a.a.a.gA(7, this.ssM.btq());
      }
      return paramInt + (d.a.a.b.b.a.dQ(8) + 1) + d.a.a.a.gy(9, this.ssO);
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
        ad localad = (ad)paramVarArgs[1];
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
            localad.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localad.ssy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localad.ssz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localad.ssA = ((bsf)localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localad.ssB = ((bkb)localObject1);
            paramInt += 1;
          }
        case 6: 
          localad.ssI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rh();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rh)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localad.ssM = ((rh)localObject1);
            paramInt += 1;
          }
        case 8: 
          localad.ssN = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localad.ssO = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ad
 * JD-Core Version:    0.7.0.1
 */