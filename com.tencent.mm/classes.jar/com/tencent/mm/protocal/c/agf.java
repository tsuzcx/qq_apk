package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class agf
  extends blm
{
  public String hPY;
  public int ndf;
  public int ndg;
  public int tdV;
  public int tdW;
  public String tdX;
  public int tdY;
  
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
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      paramVarArgs.gB(3, this.tdV);
      paramVarArgs.gB(4, this.tdW);
      if (this.tdX != null) {
        paramVarArgs.d(5, this.tdX);
      }
      paramVarArgs.gB(6, this.ndf);
      paramVarArgs.gB(7, this.ndg);
      paramVarArgs.gB(8, this.tdY);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = i + d.a.a.a.gy(3, this.tdV) + d.a.a.a.gy(4, this.tdW);
      paramInt = i;
      if (this.tdX != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tdX);
      }
      return paramInt + d.a.a.a.gy(6, this.ndf) + d.a.a.a.gy(7, this.ndg) + d.a.a.a.gy(8, this.tdY);
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
        agf localagf = (agf)paramVarArgs[1];
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
            localagf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localagf.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localagf.tdV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localagf.tdW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localagf.tdX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localagf.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localagf.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localagf.tdY = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.agf
 * JD-Core Version:    0.7.0.1
 */