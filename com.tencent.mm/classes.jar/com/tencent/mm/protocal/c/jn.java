package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class jn
  extends com.tencent.mm.bv.a
{
  public String sEi;
  public int sEj;
  public String sEk;
  public int sEl;
  public LinkedList<ii> sEm = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sEi != null) {
        paramVarArgs.d(1, this.sEi);
      }
      paramVarArgs.gB(2, this.sEj);
      if (this.sEk != null) {
        paramVarArgs.d(3, this.sEk);
      }
      paramVarArgs.gB(4, this.sEl);
      paramVarArgs.d(5, 8, this.sEm);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sEi == null) {
        break label441;
      }
    }
    label441:
    for (paramInt = d.a.a.b.b.a.e(1, this.sEi) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.sEj);
      paramInt = i;
      if (this.sEk != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sEk);
      }
      return paramInt + d.a.a.a.gy(4, this.sEl) + d.a.a.a.c(5, 8, this.sEm);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sEm.clear();
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
        jn localjn = (jn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localjn.sEi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localjn.sEj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localjn.sEk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localjn.sEl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ii();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ii)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localjn.sEm.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jn
 * JD-Core Version:    0.7.0.1
 */