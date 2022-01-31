package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class apx
  extends com.tencent.mm.bv.a
{
  public String dCX;
  public int major;
  public LinkedList<apz> tlR = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.dCX != null) {
        paramVarArgs.d(1, this.dCX);
      }
      paramVarArgs.gB(2, this.major);
      paramVarArgs.d(3, 8, this.tlR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dCX == null) {
        break label347;
      }
    }
    label347:
    for (paramInt = d.a.a.b.b.a.e(1, this.dCX) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.major) + d.a.a.a.c(3, 8, this.tlR);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tlR.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        apx localapx = (apx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localapx.dCX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localapx.major = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apz();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((apz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localapx.tlR.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.apx
 * JD-Core Version:    0.7.0.1
 */