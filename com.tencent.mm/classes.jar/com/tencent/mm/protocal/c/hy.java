package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class hy
  extends blm
{
  public int sBe;
  public String sBf;
  public String sBg;
  public String sBh;
  public String sBi;
  public String sBj;
  public String sBk;
  public String sBl;
  public int syV;
  
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
      paramVarArgs.gB(2, this.syV);
      paramVarArgs.gB(3, this.sBe);
      if (this.sBf != null) {
        paramVarArgs.d(4, this.sBf);
      }
      if (this.sBg != null) {
        paramVarArgs.d(5, this.sBg);
      }
      if (this.sBh != null) {
        paramVarArgs.d(6, this.sBh);
      }
      if (this.sBi != null) {
        paramVarArgs.d(7, this.sBi);
      }
      if (this.sBj != null) {
        paramVarArgs.d(8, this.sBj);
      }
      if (this.sBk != null) {
        paramVarArgs.d(9, this.sBk);
      }
      if (this.sBl != null) {
        paramVarArgs.d(10, this.sBl);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label744;
      }
    }
    label744:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.syV) + d.a.a.a.gy(3, this.sBe);
      paramInt = i;
      if (this.sBf != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sBf);
      }
      i = paramInt;
      if (this.sBg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sBg);
      }
      paramInt = i;
      if (this.sBh != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sBh);
      }
      i = paramInt;
      if (this.sBi != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sBi);
      }
      paramInt = i;
      if (this.sBj != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sBj);
      }
      i = paramInt;
      if (this.sBk != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sBk);
      }
      paramInt = i;
      if (this.sBl != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sBl);
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
        hy localhy = (hy)paramVarArgs[1];
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
            localhy.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localhy.syV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localhy.sBe = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localhy.sBf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localhy.sBg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localhy.sBh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localhy.sBi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localhy.sBj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localhy.sBk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localhy.sBl = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.hy
 * JD-Core Version:    0.7.0.1
 */