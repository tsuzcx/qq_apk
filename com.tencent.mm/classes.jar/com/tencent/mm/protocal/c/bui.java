package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bui
  extends com.tencent.mm.bv.a
{
  public int hPS;
  public LinkedList<bml> hPT = new LinkedList();
  public String kVl;
  public long tLb;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.tLb);
      if (this.kVl != null) {
        paramVarArgs.d(2, this.kVl);
      }
      paramVarArgs.gB(3, this.hPS);
      paramVarArgs.d(4, 8, this.hPT);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.X(1, this.tLb) + 0;
      paramInt = i;
      if (this.kVl != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kVl);
      }
      return paramInt + d.a.a.a.gy(3, this.hPS) + d.a.a.a.c(4, 8, this.hPT);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hPT.clear();
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
      bui localbui = (bui)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbui.tLb = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localbui.kVl = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbui.hPS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bml();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bml)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localbui.hPT.add(localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bui
 * JD-Core Version:    0.7.0.1
 */