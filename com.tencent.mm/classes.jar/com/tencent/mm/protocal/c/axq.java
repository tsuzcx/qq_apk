package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class axq
  extends com.tencent.mm.bv.a
{
  public beo ttF;
  public String ttJ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ttJ == null) {
        throw new b("Not all required fields were included: ContactUsername");
      }
      if (this.ttF == null) {
        throw new b("Not all required fields were included: PhoneNumListInfo");
      }
      if (this.ttJ != null) {
        paramVarArgs.d(1, this.ttJ);
      }
      if (this.ttF != null)
      {
        paramVarArgs.gD(2, this.ttF.btq());
        this.ttF.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.ttJ == null) {
        break label396;
      }
    }
    label396:
    for (paramInt = d.a.a.b.b.a.e(1, this.ttJ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ttF != null) {
        i = paramInt + d.a.a.a.gA(2, this.ttF.btq());
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
        if (this.ttJ == null) {
          throw new b("Not all required fields were included: ContactUsername");
        }
        if (this.ttF != null) {
          break;
        }
        throw new b("Not all required fields were included: PhoneNumListInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        axq localaxq = (axq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localaxq.ttJ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new beo();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((beo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaxq.ttF = ((beo)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axq
 * JD-Core Version:    0.7.0.1
 */