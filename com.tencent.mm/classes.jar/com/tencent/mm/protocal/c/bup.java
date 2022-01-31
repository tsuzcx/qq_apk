package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bup
  extends blm
{
  public String tJH;
  public long tJI;
  public bmk tJk;
  public int tJm;
  public long tLe;
  public int tLf;
  public long tLg;
  
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
      if (this.tJH != null) {
        paramVarArgs.d(2, this.tJH);
      }
      paramVarArgs.Y(3, this.tJI);
      paramVarArgs.Y(4, this.tLe);
      paramVarArgs.gB(5, this.tLf);
      paramVarArgs.Y(6, this.tLg);
      if (this.tJk != null)
      {
        paramVarArgs.gD(7, this.tJk.btq());
        this.tJk.a(paramVarArgs);
      }
      paramVarArgs.gB(8, this.tJm);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tJH != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tJH);
      }
      i = i + d.a.a.a.X(3, this.tJI) + d.a.a.a.X(4, this.tLe) + d.a.a.a.gy(5, this.tLf) + d.a.a.a.X(6, this.tLg);
      paramInt = i;
      if (this.tJk != null) {
        paramInt = i + d.a.a.a.gA(7, this.tJk.btq());
      }
      return paramInt + d.a.a.a.gy(8, this.tJm);
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
        bup localbup = (bup)paramVarArgs[1];
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
            localbup.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbup.tJH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbup.tJI = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localbup.tLe = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 5: 
          localbup.tLf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbup.tLg = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmk();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbup.tJk = ((bmk)localObject1);
            paramInt += 1;
          }
        }
        localbup.tJm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bup
 * JD-Core Version:    0.7.0.1
 */