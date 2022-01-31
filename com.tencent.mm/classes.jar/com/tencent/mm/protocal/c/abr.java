package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class abr
  extends bly
{
  public fd krS;
  public bsf ssA;
  public int ssI;
  public int ssu;
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
      paramVarArgs.gB(3, this.ssI);
      if (this.ssz != null) {
        paramVarArgs.d(4, this.ssz);
      }
      if (this.ssA != null)
      {
        paramVarArgs.gD(5, this.ssA.btq());
        this.ssA.a(paramVarArgs);
      }
      if (this.krS != null)
      {
        paramVarArgs.gD(6, this.krS.btq());
        this.krS.a(paramVarArgs);
      }
      paramVarArgs.gB(7, this.ssu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label771;
      }
    }
    label771:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssy) + d.a.a.a.gy(3, this.ssI);
      paramInt = i;
      if (this.ssz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ssz);
      }
      i = paramInt;
      if (this.ssA != null) {
        i = paramInt + d.a.a.a.gA(5, this.ssA.btq());
      }
      paramInt = i;
      if (this.krS != null) {
        paramInt = i + d.a.a.a.gA(6, this.krS.btq());
      }
      return paramInt + d.a.a.a.gy(7, this.ssu);
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
        abr localabr = (abr)paramVarArgs[1];
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
            localabr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localabr.ssy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localabr.ssI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localabr.ssz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localabr.ssA = ((bsf)localObject1);
            paramInt += 1;
          }
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localabr.krS = ((fd)localObject1);
            paramInt += 1;
          }
        }
        localabr.ssu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.abr
 * JD-Core Version:    0.7.0.1
 */