package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class cq
  extends com.tencent.mm.bv.a
{
  public String kUa;
  public el swk;
  public LinkedList<anz> swl = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.swk == null) {
        throw new b("Not all required fields were included: ArtisAuthor");
      }
      if (this.swk != null)
      {
        paramVarArgs.gD(1, this.swk.btq());
        this.swk.a(paramVarArgs);
      }
      paramVarArgs.d(2, 8, this.swl);
      if (this.kUa != null) {
        paramVarArgs.d(3, this.kUa);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.swk == null) {
        break label493;
      }
    }
    label493:
    for (paramInt = d.a.a.a.gA(1, this.swk.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.swl);
      paramInt = i;
      if (this.kUa != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.kUa);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.swl.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.swk != null) {
          break;
        }
        throw new b("Not all required fields were included: ArtisAuthor");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cq localcq = (cq)paramVarArgs[1];
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
            localObject1 = new el();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((el)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcq.swk = ((el)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((anz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcq.swl.add(localObject1);
            paramInt += 1;
          }
        }
        localcq.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cq
 * JD-Core Version:    0.7.0.1
 */