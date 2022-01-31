package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ng
  extends blm
{
  public int amount;
  public String sKU;
  public String sKV;
  public String swc;
  public String swd;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.swc == null) {
        throw new b("Not all required fields were included: f2f_id");
      }
      if (this.swd == null) {
        throw new b("Not all required fields were included: trans_id");
      }
      if (this.sKV == null) {
        throw new b("Not all required fields were included: receiver_open_id");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.swc != null) {
        paramVarArgs.d(2, this.swc);
      }
      if (this.swd != null) {
        paramVarArgs.d(3, this.swd);
      }
      if (this.sKU != null) {
        paramVarArgs.d(4, this.sKU);
      }
      if (this.sKV != null) {
        paramVarArgs.d(5, this.sKV);
      }
      paramVarArgs.gB(6, this.amount);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label632;
      }
    }
    label632:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.swc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.swc);
      }
      i = paramInt;
      if (this.swd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.swd);
      }
      paramInt = i;
      if (this.sKU != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sKU);
      }
      i = paramInt;
      if (this.sKV != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sKV);
      }
      return i + d.a.a.a.gy(6, this.amount);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.swc == null) {
          throw new b("Not all required fields were included: f2f_id");
        }
        if (this.swd == null) {
          throw new b("Not all required fields were included: trans_id");
        }
        if (this.sKV != null) {
          break;
        }
        throw new b("Not all required fields were included: receiver_open_id");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ng localng = (ng)paramVarArgs[1];
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
            localng.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localng.swc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localng.swd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localng.sKU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localng.sKV = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localng.amount = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ng
 * JD-Core Version:    0.7.0.1
 */