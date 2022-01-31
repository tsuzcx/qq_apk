package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class axj
  extends blm
{
  public int pyo;
  public LinkedList<axl> sAA = new LinkedList();
  public int svw;
  public int ttN;
  public LinkedList<axi> ttO = new LinkedList();
  public int ttP;
  public String ttQ;
  
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
      paramVarArgs.gB(2, this.svw);
      paramVarArgs.gB(3, this.ttN);
      paramVarArgs.d(4, 8, this.ttO);
      paramVarArgs.gB(5, this.ttP);
      paramVarArgs.d(6, 8, this.sAA);
      if (this.ttQ != null) {
        paramVarArgs.d(7, this.ttQ);
      }
      paramVarArgs.gB(8, this.pyo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.svw) + d.a.a.a.gy(3, this.ttN) + d.a.a.a.c(4, 8, this.ttO) + d.a.a.a.gy(5, this.ttP) + d.a.a.a.c(6, 8, this.sAA);
      paramInt = i;
      if (this.ttQ != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.ttQ);
      }
      return paramInt + d.a.a.a.gy(8, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ttO.clear();
        this.sAA.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        axj localaxj = (axj)paramVarArgs[1];
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
            localaxj.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localaxj.svw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localaxj.ttN = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaxj.ttO.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localaxj.ttP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axl();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axl)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localaxj.sAA.add(localObject1);
            paramInt += 1;
          }
        case 7: 
          localaxj.ttQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localaxj.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.axj
 * JD-Core Version:    0.7.0.1
 */