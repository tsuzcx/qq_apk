package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bsn
  extends com.tencent.mm.bv.a
{
  public int mPW;
  public String sHh;
  public LinkedList<bfq> tJa = new LinkedList();
  public wi tJb;
  public LinkedList<bjm> tJc = new LinkedList();
  public int tJd;
  public cm tes;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.mPW);
      paramVarArgs.d(2, 8, this.tJa);
      if (this.tJb != null)
      {
        paramVarArgs.gD(3, this.tJb.btq());
        this.tJb.a(paramVarArgs);
      }
      if (this.tes != null)
      {
        paramVarArgs.gD(4, this.tes.btq());
        this.tes.a(paramVarArgs);
      }
      paramVarArgs.d(5, 8, this.tJc);
      paramVarArgs.gB(6, this.tJd);
      if (this.sHh != null) {
        paramVarArgs.d(7, this.sHh);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.mPW) + 0 + d.a.a.a.c(2, 8, this.tJa);
      paramInt = i;
      if (this.tJb != null) {
        paramInt = i + d.a.a.a.gA(3, this.tJb.btq());
      }
      i = paramInt;
      if (this.tes != null) {
        i = paramInt + d.a.a.a.gA(4, this.tes.btq());
      }
      i = i + d.a.a.a.c(5, 8, this.tJc) + d.a.a.a.gy(6, this.tJd);
      paramInt = i;
    } while (this.sHh == null);
    return i + d.a.a.b.b.a.e(7, this.sHh);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tJa.clear();
      this.tJc.clear();
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
      bsn localbsn = (bsn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbsn.mPW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbsn.tJa.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new wi();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((wi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbsn.tJb = ((wi)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cm();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbsn.tes = ((cm)localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bjm();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bjm)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbsn.tJc.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localbsn.tJd = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localbsn.sHh = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bsn
 * JD-Core Version:    0.7.0.1
 */