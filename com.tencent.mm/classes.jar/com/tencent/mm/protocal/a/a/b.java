package com.tencent.mm.protocal.a.a;

import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public int nettype;
  public int squ;
  public LinkedList<a> sqv = new LinkedList();
  public int uin;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.uin);
      paramVarArgs.gB(2, this.squ);
      paramVarArgs.d(3, 8, this.sqv);
      paramVarArgs.gB(4, this.nettype);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.uin) + 0 + d.a.a.a.gy(2, this.squ) + d.a.a.a.c(3, 8, this.sqv) + d.a.a.a.gy(4, this.nettype);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sqv.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
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
        localb.uin = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localb.squ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localb.sqv.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localb.nettype = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.b
 * JD-Core Version:    0.7.0.1
 */