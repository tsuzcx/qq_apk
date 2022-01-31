package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class nu
  extends blm
{
  public String bOT;
  public long nAM;
  public String nzl;
  public String nzq;
  public String sKU;
  public String sLn;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOT == null) {
        throw new b("Not all required fields were included: req_key");
      }
      if (this.sLn == null) {
        throw new b("Not all required fields were included: transfer_id");
      }
      if (this.nzq == null) {
        throw new b("Not all required fields were included: transaction_id");
      }
      if (this.nzl == null) {
        throw new b("Not all required fields were included: receiver_openid");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.bOT != null) {
        paramVarArgs.d(2, this.bOT);
      }
      if (this.sLn != null) {
        paramVarArgs.d(3, this.sLn);
      }
      if (this.nzq != null) {
        paramVarArgs.d(4, this.nzq);
      }
      if (this.nzl != null) {
        paramVarArgs.d(5, this.nzl);
      }
      paramVarArgs.Y(6, this.nAM);
      if (this.sKU != null) {
        paramVarArgs.d(7, this.sKU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label727;
      }
    }
    label727:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bOT != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bOT);
      }
      i = paramInt;
      if (this.sLn != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sLn);
      }
      paramInt = i;
      if (this.nzq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.nzq);
      }
      i = paramInt;
      if (this.nzl != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.nzl);
      }
      i += d.a.a.a.X(6, this.nAM);
      paramInt = i;
      if (this.sKU != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sKU);
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
        if (this.bOT == null) {
          throw new b("Not all required fields were included: req_key");
        }
        if (this.sLn == null) {
          throw new b("Not all required fields were included: transfer_id");
        }
        if (this.nzq == null) {
          throw new b("Not all required fields were included: transaction_id");
        }
        if (this.nzl != null) {
          break;
        }
        throw new b("Not all required fields were included: receiver_openid");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        nu localnu = (nu)paramVarArgs[1];
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
            localnu.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localnu.bOT = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localnu.sLn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localnu.nzq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localnu.nzl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localnu.nAM = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localnu.sKU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.nu
 * JD-Core Version:    0.7.0.1
 */