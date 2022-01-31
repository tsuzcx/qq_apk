package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ahl
  extends blm
{
  public int kTS;
  public int pyo;
  public String sRE;
  public int teY;
  public LinkedList<awt> teZ = new LinkedList();
  public int tfa;
  public LinkedList<auq> tfb = new LinkedList();
  
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
      paramVarArgs.gB(2, this.kTS);
      if (this.sRE != null) {
        paramVarArgs.d(3, this.sRE);
      }
      paramVarArgs.gB(4, this.teY);
      paramVarArgs.d(5, 8, this.teZ);
      paramVarArgs.gB(6, this.tfa);
      paramVarArgs.d(7, 8, this.tfb);
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
      int i = paramInt + d.a.a.a.gy(2, this.kTS);
      paramInt = i;
      if (this.sRE != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sRE);
      }
      return paramInt + d.a.a.a.gy(4, this.teY) + d.a.a.a.c(5, 8, this.teZ) + d.a.a.a.gy(6, this.tfa) + d.a.a.a.c(7, 8, this.tfb) + d.a.a.a.gy(8, this.pyo);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.teZ.clear();
        this.tfb.clear();
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
        ahl localahl = (ahl)paramVarArgs[1];
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
            localahl.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localahl.kTS = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localahl.sRE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localahl.teY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localahl.teZ.add(localObject1);
            paramInt += 1;
          }
        case 6: 
          localahl.tfa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localahl.tfb.add(localObject1);
            paramInt += 1;
          }
        }
        localahl.pyo = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ahl
 * JD-Core Version:    0.7.0.1
 */