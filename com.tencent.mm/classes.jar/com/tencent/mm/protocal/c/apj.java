package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class apj
  extends bly
{
  public int bIC;
  public String errorMsg;
  public bmk tls;
  public int tlt;
  public String tlu;
  public int tlv;
  
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
      if (this.tls != null)
      {
        paramVarArgs.gD(2, this.tls.btq());
        this.tls.a(paramVarArgs);
      }
      paramVarArgs.gB(3, this.tlt);
      if (this.tlu != null) {
        paramVarArgs.d(4, this.tlu);
      }
      paramVarArgs.gB(5, this.tlv);
      paramVarArgs.gB(6, this.bIC);
      if (this.errorMsg != null) {
        paramVarArgs.d(7, this.errorMsg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label681;
      }
    }
    label681:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tls != null) {
        i = paramInt + d.a.a.a.gA(2, this.tls.btq());
      }
      i += d.a.a.a.gy(3, this.tlt);
      paramInt = i;
      if (this.tlu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tlu);
      }
      i = paramInt + d.a.a.a.gy(5, this.tlv) + d.a.a.a.gy(6, this.bIC);
      paramInt = i;
      if (this.errorMsg != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.errorMsg);
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
        apj localapj = (apj)paramVarArgs[1];
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
            localapj.tFx = ((gd)localObject1);
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
            localapj.tls = ((bmk)localObject1);
            paramInt += 1;
          }
        case 3: 
          localapj.tlt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localapj.tlu = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localapj.tlv = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localapj.bIC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localapj.errorMsg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apj
 * JD-Core Version:    0.7.0.1
 */