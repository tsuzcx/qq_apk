package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class qi
  extends com.tencent.mm.bv.a
  implements bsi
{
  public int sOb;
  public int sOc;
  public int sOd;
  public LinkedList<bvy> sOe = new LinkedList();
  public LinkedList<bvy> sOf = new LinkedList();
  public LinkedList<bvy> sOg = new LinkedList();
  public int sOh;
  public int sOi;
  public int sOj;
  public apb sOk;
  public int sze;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sze);
      paramVarArgs.gB(2, this.sOb);
      paramVarArgs.gB(3, this.sOc);
      paramVarArgs.gB(4, this.sOd);
      paramVarArgs.d(5, 8, this.sOe);
      paramVarArgs.d(6, 8, this.sOf);
      paramVarArgs.d(7, 8, this.sOg);
      paramVarArgs.gB(8, this.sOh);
      paramVarArgs.gB(9, this.sOi);
      paramVarArgs.gB(10, this.sOj);
      if (this.sOk != null)
      {
        paramVarArgs.gD(11, this.sOk.btq());
        this.sOk.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.sze) + 0 + d.a.a.a.gy(2, this.sOb) + d.a.a.a.gy(3, this.sOc) + d.a.a.a.gy(4, this.sOd) + d.a.a.a.c(5, 8, this.sOe) + d.a.a.a.c(6, 8, this.sOf) + d.a.a.a.c(7, 8, this.sOg) + d.a.a.a.gy(8, this.sOh) + d.a.a.a.gy(9, this.sOi) + d.a.a.a.gy(10, this.sOj);
      paramInt = i;
    } while (this.sOk == null);
    return i + d.a.a.a.gA(11, this.sOk.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sOe.clear();
      this.sOf.clear();
      this.sOg.clear();
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
      qi localqi = (qi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localqi.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localqi.sOb = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localqi.sOc = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localqi.sOd = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localqi.sOe.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localqi.sOf.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localqi.sOg.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        localqi.sOh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localqi.sOi = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localqi.sOj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new apb();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((apb)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localqi.sOk = ((apb)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
  
  public final int getRet()
  {
    return this.sze;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qi
 * JD-Core Version:    0.7.0.1
 */