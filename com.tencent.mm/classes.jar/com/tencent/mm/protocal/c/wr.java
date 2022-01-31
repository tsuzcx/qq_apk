package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class wr
  extends bly
{
  public wu sTs;
  public wo sTt;
  public wp sTu;
  public String sTv;
  public int sTw;
  public int sTx;
  
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
      if (this.sTs != null)
      {
        paramVarArgs.gD(2, this.sTs.btq());
        this.sTs.a(paramVarArgs);
      }
      if (this.sTt != null)
      {
        paramVarArgs.gD(3, this.sTt.btq());
        this.sTt.a(paramVarArgs);
      }
      if (this.sTu != null)
      {
        paramVarArgs.gD(4, this.sTu.btq());
        this.sTu.a(paramVarArgs);
      }
      if (this.sTv != null) {
        paramVarArgs.d(5, this.sTv);
      }
      paramVarArgs.gB(6, this.sTw);
      paramVarArgs.gB(7, this.sTx);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label881;
      }
    }
    label881:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sTs != null) {
        paramInt = i + d.a.a.a.gA(2, this.sTs.btq());
      }
      i = paramInt;
      if (this.sTt != null) {
        i = paramInt + d.a.a.a.gA(3, this.sTt.btq());
      }
      paramInt = i;
      if (this.sTu != null) {
        paramInt = i + d.a.a.a.gA(4, this.sTu.btq());
      }
      i = paramInt;
      if (this.sTv != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sTv);
      }
      return i + d.a.a.a.gy(6, this.sTw) + d.a.a.a.gy(7, this.sTx);
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
        wr localwr = (wr)paramVarArgs[1];
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
            localwr.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wu();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wu)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localwr.sTs = ((wu)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localwr.sTt = ((wo)localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wp();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wp)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localwr.sTu = ((wp)localObject1);
            paramInt += 1;
          }
        case 5: 
          localwr.sTv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localwr.sTw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localwr.sTx = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.wr
 * JD-Core Version:    0.7.0.1
 */