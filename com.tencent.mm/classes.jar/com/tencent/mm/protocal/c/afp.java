package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class afp
  extends blm
{
  public String iQe;
  public int scene;
  public String tdz;
  
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
      paramVarArgs.gB(2, this.scene);
      if (this.iQe != null) {
        paramVarArgs.d(3, this.iQe);
      }
      if (this.tdz != null) {
        paramVarArgs.d(4, this.tdz);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.scene);
      paramInt = i;
      if (this.iQe != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.iQe);
      }
      i = paramInt;
      if (this.tdz != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tdz);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        afp localafp = (afp)paramVarArgs[1];
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
            localafp.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localafp.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localafp.iQe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localafp.tdz = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.afp
 * JD-Core Version:    0.7.0.1
 */