package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class auz
  extends bly
{
  public String iQS;
  public String iQT;
  public String rfx;
  public int rfy;
  public String sign;
  
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
      if (this.rfx != null) {
        paramVarArgs.d(2, this.rfx);
      }
      if (this.iQS != null) {
        paramVarArgs.d(3, this.iQS);
      }
      if (this.iQT != null) {
        paramVarArgs.d(4, this.iQT);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      paramVarArgs.gB(6, this.rfy);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label564;
      }
    }
    label564:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rfx != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.rfx);
      }
      i = paramInt;
      if (this.iQS != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.iQS);
      }
      paramInt = i;
      if (this.iQT != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.iQT);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sign);
      }
      return i + d.a.a.a.gy(6, this.rfy);
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
        auz localauz = (auz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localauz.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localauz.rfx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localauz.iQS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localauz.iQT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localauz.sign = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localauz.rfy = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.auz
 * JD-Core Version:    0.7.0.1
 */