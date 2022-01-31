package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class os
  extends bly
{
  public cls sMk;
  public boolean sMl;
  public String sMm;
  public String sMn;
  public boolean sMo;
  public String sMp;
  public String sMq;
  public String sMr;
  
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
      if (this.sMk != null)
      {
        paramVarArgs.gD(2, this.sMk.btq());
        this.sMk.a(paramVarArgs);
      }
      paramVarArgs.aA(3, this.sMl);
      if (this.sMm != null) {
        paramVarArgs.d(4, this.sMm);
      }
      if (this.sMn != null) {
        paramVarArgs.d(5, this.sMn);
      }
      paramVarArgs.aA(6, this.sMo);
      if (this.sMp != null) {
        paramVarArgs.d(7, this.sMp);
      }
      if (this.sMq != null) {
        paramVarArgs.d(8, this.sMq);
      }
      if (this.sMr != null) {
        paramVarArgs.d(9, this.sMr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label805;
      }
    }
    label805:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sMk != null) {
        i = paramInt + d.a.a.a.gA(2, this.sMk.btq());
      }
      i += d.a.a.b.b.a.dQ(3) + 1;
      paramInt = i;
      if (this.sMm != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sMm);
      }
      i = paramInt;
      if (this.sMn != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sMn);
      }
      i += d.a.a.b.b.a.dQ(6) + 1;
      paramInt = i;
      if (this.sMp != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sMp);
      }
      i = paramInt;
      if (this.sMq != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sMq);
      }
      paramInt = i;
      if (this.sMr != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sMr);
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
        os localos = (os)paramVarArgs[1];
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
            localos.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cls();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cls)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localos.sMk = ((cls)localObject1);
            paramInt += 1;
          }
        case 3: 
          localos.sMl = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 4: 
          localos.sMm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localos.sMn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localos.sMo = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 7: 
          localos.sMp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localos.sMq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localos.sMr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.os
 * JD-Core Version:    0.7.0.1
 */