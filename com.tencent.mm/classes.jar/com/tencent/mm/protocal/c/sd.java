package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class sd
  extends bly
{
  public String ePR;
  public String sQf;
  public String sQg;
  public LinkedList<bbb> svR = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.ePR != null) {
        paramVarArgs.d(2, this.ePR);
      }
      paramVarArgs.d(3, 8, this.svR);
      if (this.sQf != null) {
        paramVarArgs.d(4, this.sQf);
      }
      if (this.sQg != null) {
        paramVarArgs.d(5, this.sQg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label571;
      }
    }
    label571:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ePR != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ePR);
      }
      i += d.a.a.a.c(3, 8, this.svR);
      paramInt = i;
      if (this.sQf != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sQf);
      }
      i = paramInt;
      if (this.sQg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sQg);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.svR.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        sd localsd = (sd)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localsd.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localsd.ePR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbb();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bbb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localsd.svR.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          localsd.sQf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localsd.sQg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.sd
 * JD-Core Version:    0.7.0.1
 */