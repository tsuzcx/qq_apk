package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.protocal.c.awd;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public awd bZK;
  public int enw;
  public String owP;
  public int owQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bZK != null)
      {
        paramVarArgs.gD(1, this.bZK.btq());
        this.bZK.a(paramVarArgs);
      }
      if (this.owP != null) {
        paramVarArgs.d(2, this.owP);
      }
      paramVarArgs.gB(3, this.enw);
      paramVarArgs.gB(4, this.owQ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bZK == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = d.a.a.a.gA(1, this.bZK.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.owP != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.owP);
      }
      return i + d.a.a.a.gy(3, this.enw) + d.a.a.a.gy(4, this.owQ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        b localb = (b)paramVarArgs[1];
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
            localObject1 = new awd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((awd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localb.bZK = ((awd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localb.owP = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localb.enw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localb.owQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.b
 * JD-Core Version:    0.7.0.1
 */