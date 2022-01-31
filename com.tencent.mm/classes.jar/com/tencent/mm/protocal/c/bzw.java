package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bzw
  extends blm
{
  public String cMT;
  public String devicetype;
  public String mLc;
  public int tPB;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.devicetype == null) {
        throw new b("Not all required fields were included: devicetype");
      }
      if (this.mLc == null) {
        throw new b("Not all required fields were included: deviceid");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.devicetype != null) {
        paramVarArgs.d(2, this.devicetype);
      }
      if (this.mLc != null) {
        paramVarArgs.d(3, this.mLc);
      }
      if (this.cMT != null) {
        paramVarArgs.d(4, this.cMT);
      }
      paramVarArgs.gB(5, this.tPB);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label541;
      }
    }
    label541:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.devicetype != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.devicetype);
      }
      i = paramInt;
      if (this.mLc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mLc);
      }
      paramInt = i;
      if (this.cMT != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.cMT);
      }
      return paramInt + d.a.a.a.gy(5, this.tPB);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.devicetype == null) {
          throw new b("Not all required fields were included: devicetype");
        }
        if (this.mLc != null) {
          break;
        }
        throw new b("Not all required fields were included: deviceid");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bzw localbzw = (bzw)paramVarArgs[1];
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
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbzw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbzw.devicetype = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbzw.mLc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbzw.cMT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbzw.tPB = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bzw
 * JD-Core Version:    0.7.0.1
 */