package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class zx
  extends blm
{
  public String ffq;
  public String kUa;
  public LinkedList<String> sZa = new LinkedList();
  public LinkedList<String> sZh = new LinkedList();
  public int sZi;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.d(2, 1, this.sZh);
      paramVarArgs.d(3, 1, this.sZa);
      if (this.kUa != null) {
        paramVarArgs.d(4, this.kUa);
      }
      if (this.ffq != null) {
        paramVarArgs.d(5, this.ffq);
      }
      paramVarArgs.gB(6, this.sZi);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label524;
      }
    }
    label524:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 1, this.sZh) + d.a.a.a.c(3, 1, this.sZa);
      paramInt = i;
      if (this.kUa != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kUa);
      }
      i = paramInt;
      if (this.ffq != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ffq);
      }
      return i + d.a.a.a.gy(6, this.sZi);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sZh.clear();
        this.sZa.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        zx localzx = (zx)paramVarArgs[1];
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
            localzx.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localzx.sZh.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 3: 
          localzx.sZa.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 4: 
          localzx.kUa = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localzx.ffq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localzx.sZi = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zx
 * JD-Core Version:    0.7.0.1
 */