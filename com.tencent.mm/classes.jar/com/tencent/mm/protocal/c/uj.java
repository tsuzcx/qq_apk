package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class uj
  extends blm
{
  public int ndm;
  public long ndp;
  public int sDT;
  public int sRd;
  public long sRe;
  public String svm;
  public String swQ;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ndm);
      paramVarArgs.gB(2, this.sDT);
      paramVarArgs.gB(3, this.sRd);
      if (this.swQ != null) {
        paramVarArgs.d(4, this.swQ);
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(5, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.Y(6, this.ndp);
      if (this.svm != null) {
        paramVarArgs.d(7, this.svm);
      }
      paramVarArgs.Y(8, this.sRe);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.ndm) + 0 + d.a.a.a.gy(2, this.sDT) + d.a.a.a.gy(3, this.sRd);
      paramInt = i;
      if (this.swQ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.swQ);
      }
      i = paramInt;
      if (this.tEX != null) {
        i = paramInt + d.a.a.a.gA(5, this.tEX.btq());
      }
      i += d.a.a.a.X(6, this.ndp);
      paramInt = i;
      if (this.svm != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.svm);
      }
      return paramInt + d.a.a.a.X(8, this.sRe);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      uj localuj = (uj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localuj.ndm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localuj.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localuj.sRd = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localuj.swQ = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gc();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localuj.tEX = ((gc)localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localuj.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 7: 
        localuj.svm = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localuj.sRe = ((d.a.a.a.a)localObject1).xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.uj
 * JD-Core Version:    0.7.0.1
 */