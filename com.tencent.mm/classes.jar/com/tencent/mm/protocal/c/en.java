package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class en
  extends com.tencent.mm.bv.a
{
  public String ssG;
  public String syc;
  public vl syd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syc == null) {
        throw new b("Not all required fields were included: ProductID");
      }
      if (this.syd == null) {
        throw new b("Not all required fields were included: Price");
      }
      if (this.syc != null) {
        paramVarArgs.d(1, this.syc);
      }
      if (this.syd != null)
      {
        paramVarArgs.gD(2, this.syd.btq());
        this.syd.a(paramVarArgs);
      }
      if (this.ssG != null) {
        paramVarArgs.d(3, this.ssG);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.syc == null) {
        break label451;
      }
    }
    label451:
    for (int i = d.a.a.b.b.a.e(1, this.syc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.syd != null) {
        paramInt = i + d.a.a.a.gA(2, this.syd.btq());
      }
      i = paramInt;
      if (this.ssG != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ssG);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.syc == null) {
          throw new b("Not all required fields were included: ProductID");
        }
        if (this.syd != null) {
          break;
        }
        throw new b("Not all required fields were included: Price");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        en localen = (en)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localen.syc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((vl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localen.syd = ((vl)localObject1);
            paramInt += 1;
          }
        }
        localen.ssG = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.en
 * JD-Core Version:    0.7.0.1
 */