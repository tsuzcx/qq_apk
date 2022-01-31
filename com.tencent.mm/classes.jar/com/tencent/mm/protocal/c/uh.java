package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class uh
  extends blm
{
  public int ndf;
  public int ndg;
  public int ndm;
  public long ndp;
  public int sRb;
  public int sRc;
  
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
      paramVarArgs.gB(2, this.ndm);
      paramVarArgs.gB(3, this.ndf);
      paramVarArgs.gB(4, this.ndg);
      paramVarArgs.gB(5, this.sRb);
      paramVarArgs.gB(6, this.sRc);
      paramVarArgs.Y(7, this.ndp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label499;
      }
    }
    label499:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.ndm) + d.a.a.a.gy(3, this.ndf) + d.a.a.a.gy(4, this.ndg) + d.a.a.a.gy(5, this.sRb) + d.a.a.a.gy(6, this.sRc) + d.a.a.a.X(7, this.ndp);
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
        uh localuh = (uh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          int i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localuh.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localuh.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localuh.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localuh.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localuh.sRb = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localuh.sRc = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localuh.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.uh
 * JD-Core Version:    0.7.0.1
 */