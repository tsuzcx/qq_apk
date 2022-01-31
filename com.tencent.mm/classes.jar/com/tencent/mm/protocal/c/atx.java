package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class atx
  extends blm
{
  public int bXq;
  public String dRj;
  public String jFa;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username == null) {
        throw new b("Not all required fields were included: username");
      }
      if (this.jFa == null) {
        throw new b("Not all required fields were included: appusername");
      }
      if (this.dRj == null) {
        throw new b("Not all required fields were included: rankid");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.jFa != null) {
        paramVarArgs.d(3, this.jFa);
      }
      paramVarArgs.gB(4, this.bXq);
      if (this.dRj != null) {
        paramVarArgs.d(5, this.dRj);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label577;
      }
    }
    label577:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.jFa != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.jFa);
      }
      i += d.a.a.a.gy(4, this.bXq);
      paramInt = i;
      if (this.dRj != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.dRj);
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
        if (this.username == null) {
          throw new b("Not all required fields were included: username");
        }
        if (this.jFa == null) {
          throw new b("Not all required fields were included: appusername");
        }
        if (this.dRj != null) {
          break;
        }
        throw new b("Not all required fields were included: rankid");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        atx localatx = (atx)paramVarArgs[1];
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
            localatx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localatx.username = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localatx.jFa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localatx.bXq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localatx.dRj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atx
 * JD-Core Version:    0.7.0.1
 */