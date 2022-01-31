package com.tencent.mm.protocal.b.a;

import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public String bHk;
  public int id;
  public LinkedList<a> srm = new LinkedList();
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.id);
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.bHk != null) {
        paramVarArgs.d(3, this.bHk);
      }
      paramVarArgs.d(4, 8, this.srm);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.id) + 0;
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.bHk != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bHk);
      }
      return i + d.a.a.a.c(4, 8, this.srm);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.srm.clear();
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
        localb.id = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localb.title = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localb.bHk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new a();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((a)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localb.srm.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.b
 * JD-Core Version:    0.7.0.1
 */