package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aok
  extends blm
{
  public String euK;
  public String ffq;
  public String kUa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.euK == null) {
        throw new b("Not all required fields were included: AppId");
      }
      if (this.kUa == null) {
        throw new b("Not all required fields were included: Lang");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.kUa != null) {
        paramVarArgs.d(3, this.kUa);
      }
      if (this.ffq != null) {
        paramVarArgs.d(4, this.ffq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label506;
      }
    }
    label506:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.kUa != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.kUa);
      }
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.ffq);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.euK == null) {
          throw new b("Not all required fields were included: AppId");
        }
        if (this.kUa != null) {
          break;
        }
        throw new b("Not all required fields were included: Lang");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        aok localaok = (aok)paramVarArgs[1];
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
            localaok.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaok.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localaok.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaok.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aok
 * JD-Core Version:    0.7.0.1
 */