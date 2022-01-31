package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ayy
  extends bly
{
  public int sFD;
  public int ssV;
  public bmk tuH;
  public bmk tuI;
  public int tuJ;
  public int tuK;
  public LinkedList<qv> tuL = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tuH == null) {
        throw new b("Not all required fields were included: CurrentSynckey");
      }
      if (this.tuI == null) {
        throw new b("Not all required fields were included: MaxSynckey");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.tuH != null)
      {
        paramVarArgs.gD(2, this.tuH.btq());
        this.tuH.a(paramVarArgs);
      }
      if (this.tuI != null)
      {
        paramVarArgs.gD(3, this.tuI.btq());
        this.tuI.a(paramVarArgs);
      }
      paramVarArgs.gB(4, this.sFD);
      paramVarArgs.gB(5, this.tuJ);
      paramVarArgs.gB(6, this.tuK);
      paramVarArgs.d(7, 8, this.tuL);
      paramVarArgs.gB(8, this.ssV);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label952;
      }
    }
    label952:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tuH != null) {
        paramInt = i + d.a.a.a.gA(2, this.tuH.btq());
      }
      i = paramInt;
      if (this.tuI != null) {
        i = paramInt + d.a.a.a.gA(3, this.tuI.btq());
      }
      return i + d.a.a.a.gy(4, this.sFD) + d.a.a.a.gy(5, this.tuJ) + d.a.a.a.gy(6, this.tuK) + d.a.a.a.c(7, 8, this.tuL) + d.a.a.a.gy(8, this.ssV);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tuL.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx == null) {
          throw new b("Not all required fields were included: BaseResponse");
        }
        if (this.tuH == null) {
          throw new b("Not all required fields were included: CurrentSynckey");
        }
        if (this.tuI != null) {
          break;
        }
        throw new b("Not all required fields were included: MaxSynckey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ayy localayy = (ayy)paramVarArgs[1];
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
            localayy.tFx = ((gd)localObject1);
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
            localayy.tuH = ((bmk)localObject1);
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
            localayy.tuI = ((bmk)localObject1);
            paramInt += 1;
          }
        case 4: 
          localayy.sFD = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localayy.tuJ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localayy.tuK = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qv();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qv)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localayy.tuL.add(localObject1);
            paramInt += 1;
          }
        }
        localayy.ssV = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayy
 * JD-Core Version:    0.7.0.1
 */