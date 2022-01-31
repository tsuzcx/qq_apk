package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aee
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
  public int tck;
  public int tcl;
  public int tcm;
  public LinkedList<bvy> tcn = new LinkedList();
  public LinkedList<bvy> tco = new LinkedList();
  public LinkedList<bvy> tcp = new LinkedList();
  
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
      paramVarArgs.gB(11, this.tck);
      paramVarArgs.gB(12, this.tcl);
      paramVarArgs.gB(13, this.tcm);
      paramVarArgs.d(14, 8, this.tcn);
      paramVarArgs.d(15, 8, this.tco);
      paramVarArgs.d(16, 8, this.tcp);
      if (this.sOk != null)
      {
        paramVarArgs.gD(17, this.sOk.btq());
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
      i = d.a.a.a.gy(1, this.sze) + 0 + d.a.a.a.gy(2, this.sOb) + d.a.a.a.gy(3, this.sOc) + d.a.a.a.gy(4, this.sOd) + d.a.a.a.c(5, 8, this.sOe) + d.a.a.a.c(6, 8, this.sOf) + d.a.a.a.c(7, 8, this.sOg) + d.a.a.a.gy(8, this.sOh) + d.a.a.a.gy(9, this.sOi) + d.a.a.a.gy(10, this.sOj) + d.a.a.a.gy(11, this.tck) + d.a.a.a.gy(12, this.tcl) + d.a.a.a.gy(13, this.tcm) + d.a.a.a.c(14, 8, this.tcn) + d.a.a.a.c(15, 8, this.tco) + d.a.a.a.c(16, 8, this.tcp);
      paramInt = i;
    } while (this.sOk == null);
    return i + d.a.a.a.gA(17, this.sOk.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sOe.clear();
      this.sOf.clear();
      this.sOg.clear();
      this.tcn.clear();
      this.tco.clear();
      this.tcp.clear();
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
      aee localaee = (aee)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaee.sze = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localaee.sOb = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localaee.sOc = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        localaee.sOd = ((d.a.a.a.a)localObject1).xpH.oD();
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
          localaee.sOe.add(localObject1);
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
          localaee.sOf.add(localObject1);
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
          localaee.sOg.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        localaee.sOh = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localaee.sOi = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 10: 
        localaee.sOj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 11: 
        localaee.tck = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 12: 
        localaee.tcl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 13: 
        localaee.tcm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaee.tcn.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 15: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaee.tco.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 16: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvy();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvy)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaee.tcp.add(localObject1);
          paramInt += 1;
        }
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
        localaee.sOk = ((apb)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aee
 * JD-Core Version:    0.7.0.1
 */