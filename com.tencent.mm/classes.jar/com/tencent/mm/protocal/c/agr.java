package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class agr
  extends blm
{
  public String koB;
  public String koC;
  public String koD;
  public ty ssK;
  public String sst;
  
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
      if (this.koB != null) {
        paramVarArgs.d(2, this.koB);
      }
      if (this.koC != null) {
        paramVarArgs.d(3, this.koC);
      }
      if (this.koD != null) {
        paramVarArgs.d(4, this.koD);
      }
      if (this.sst != null) {
        paramVarArgs.d(5, this.sst);
      }
      if (this.ssK != null)
      {
        paramVarArgs.gD(6, this.ssK.btq());
        this.ssK.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label642;
      }
    }
    label642:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.koB != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.koB);
      }
      i = paramInt;
      if (this.koC != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.koC);
      }
      paramInt = i;
      if (this.koD != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.koD);
      }
      i = paramInt;
      if (this.sst != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sst);
      }
      paramInt = i;
      if (this.ssK != null) {
        paramInt = i + d.a.a.a.gA(6, this.ssK.btq());
      }
      return paramInt;
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
        agr localagr = (agr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localagr.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localagr.koB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localagr.koC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localagr.koD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localagr.sst = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ty();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ty)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localagr.ssK = ((ty)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.agr
 * JD-Core Version:    0.7.0.1
 */