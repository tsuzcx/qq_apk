package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aos
  extends bly
{
  public bmk syh;
  public bmk tkE;
  public bmk tkF;
  public int tkG;
  public int tkH;
  public int tkI;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.syh == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      if (this.tkE == null) {
        throw new b("Not all required fields were included: SessionBuffer");
      }
      if (this.tkF == null) {
        throw new b("Not all required fields were included: KeyBuffer");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.syh != null)
      {
        paramVarArgs.gD(2, this.syh.btq());
        this.syh.a(paramVarArgs);
      }
      if (this.tkE != null)
      {
        paramVarArgs.gD(3, this.tkE.btq());
        this.tkE.a(paramVarArgs);
      }
      if (this.tkF != null)
      {
        paramVarArgs.gD(4, this.tkF.btq());
        this.tkF.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tkG);
      paramVarArgs.gB(6, this.tkH);
      paramVarArgs.gB(7, this.tkI);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label965;
      }
    }
    label965:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syh != null) {
        paramInt = i + d.a.a.a.gA(2, this.syh.btq());
      }
      i = paramInt;
      if (this.tkE != null) {
        i = paramInt + d.a.a.a.gA(3, this.tkE.btq());
      }
      paramInt = i;
      if (this.tkF != null) {
        paramInt = i + d.a.a.a.gA(4, this.tkF.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.tkG) + d.a.a.a.gy(6, this.tkH) + d.a.a.a.gy(7, this.tkI);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.syh == null) {
          throw new b("Not all required fields were included: SessionKey");
        }
        if (this.tkE == null) {
          throw new b("Not all required fields were included: SessionBuffer");
        }
        if (this.tkF != null) {
          break;
        }
        throw new b("Not all required fields were included: KeyBuffer");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aos localaos = (aos)paramVarArgs[1];
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
            localaos.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaos.syh = ((bmk)localObject1);
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
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaos.tkE = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localaos.tkF = ((bmk)localObject1);
            paramInt += 1;
          }
        case 5: 
          localaos.tkG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localaos.tkH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localaos.tkI = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aos
 * JD-Core Version:    0.7.0.1
 */