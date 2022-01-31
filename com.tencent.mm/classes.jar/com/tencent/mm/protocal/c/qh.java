package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class qh
  extends com.tencent.mm.bv.a
{
  public int sNV;
  public int sNW;
  public int sNX;
  public LinkedList<qg> sNY = new LinkedList();
  public b sNZ;
  public apa sOa;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sNV);
      paramVarArgs.gB(2, this.sNW);
      paramVarArgs.gB(3, this.sNX);
      paramVarArgs.d(4, 8, this.sNY);
      if (this.sNZ != null) {
        paramVarArgs.b(5, this.sNZ);
      }
      if (this.sOa != null)
      {
        paramVarArgs.gD(6, this.sOa.btq());
        this.sOa.a(paramVarArgs);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.sNV) + 0 + d.a.a.a.gy(2, this.sNW) + d.a.a.a.gy(3, this.sNX) + d.a.a.a.c(4, 8, this.sNY);
      paramInt = i;
      if (this.sNZ != null) {
        paramInt = i + d.a.a.a.a(5, this.sNZ);
      }
      i = paramInt;
    } while (this.sOa == null);
    return paramInt + d.a.a.a.gA(6, this.sOa.btq());
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sNY.clear();
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
      qh localqh = (qh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localqh.sNV = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localqh.sNW = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localqh.sNX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qg();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qg)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localqh.sNY.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localqh.sNZ = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new apa();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((apa)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localqh.sOa = ((apa)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qh
 * JD-Core Version:    0.7.0.1
 */