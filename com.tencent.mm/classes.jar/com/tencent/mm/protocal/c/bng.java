package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class bng
  extends blm
{
  public String category;
  public String mac;
  public String userName;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mac == null) {
        throw new b("Not all required fields were included: mac");
      }
      if (this.userName == null) {
        throw new b("Not all required fields were included: userName");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.mac != null) {
        paramVarArgs.d(2, this.mac);
      }
      if (this.userName != null) {
        paramVarArgs.d(3, this.userName);
      }
      if (this.category != null) {
        paramVarArgs.d(4, this.category);
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
      if (this.mac != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.mac);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.userName);
      }
      paramInt = i;
      if (this.category != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.category);
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
        if (this.mac == null) {
          throw new b("Not all required fields were included: mac");
        }
        if (this.userName != null) {
          break;
        }
        throw new b("Not all required fields were included: userName");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bng localbng = (bng)paramVarArgs[1];
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
            localbng.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbng.mac = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbng.userName = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbng.category = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bng
 * JD-Core Version:    0.7.0.1
 */