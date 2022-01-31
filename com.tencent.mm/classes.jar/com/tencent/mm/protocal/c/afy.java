package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class afy
  extends bly
{
  public int ssq;
  public String tdM;
  public kt tdN;
  public long tdO;
  public cd tdP;
  public int tdQ;
  
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
      paramVarArgs.gB(2, this.ssq);
      paramVarArgs.Y(3, this.tdO);
      if (this.tdP != null)
      {
        paramVarArgs.gD(4, this.tdP.btq());
        this.tdP.a(paramVarArgs);
      }
      if (this.tdM != null) {
        paramVarArgs.d(5, this.tdM);
      }
      paramVarArgs.gB(6, this.tdQ);
      if (this.tdN != null)
      {
        paramVarArgs.gD(7, this.tdN.btq());
        this.tdN.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label775;
      }
    }
    label775:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ssq) + d.a.a.a.X(3, this.tdO);
      paramInt = i;
      if (this.tdP != null) {
        paramInt = i + d.a.a.a.gA(4, this.tdP.btq());
      }
      i = paramInt;
      if (this.tdM != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tdM);
      }
      i += d.a.a.a.gy(6, this.tdQ);
      paramInt = i;
      if (this.tdN != null) {
        paramInt = i + d.a.a.a.gA(7, this.tdN.btq());
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
        afy localafy = (afy)paramVarArgs[1];
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
            localafy.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafy.ssq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localafy.tdO = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localafy.tdP = ((cd)localObject1);
            paramInt += 1;
          }
        case 5: 
          localafy.tdM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localafy.tdQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kt();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((kt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localafy.tdN = ((kt)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afy
 * JD-Core Version:    0.7.0.1
 */