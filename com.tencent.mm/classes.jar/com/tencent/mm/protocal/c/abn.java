package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class abn
  extends bly
{
  public com.tencent.mm.bv.b inP;
  public String inn;
  public int taP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.inn != null) {
        paramVarArgs.d(2, this.inn);
      }
      paramVarArgs.gB(3, this.taP);
      if (this.inP != null) {
        paramVarArgs.b(4, this.inP);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label451;
      }
    }
    label451:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.inn != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.inn);
      }
      i += d.a.a.a.gy(3, this.taP);
      paramInt = i;
      if (this.inP != null) {
        paramInt = i + d.a.a.a.a(4, this.inP);
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
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        abn localabn = (abn)paramVarArgs[1];
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
            localabn.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localabn.inn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localabn.taP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localabn.inP = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.abn
 * JD-Core Version:    0.7.0.1
 */