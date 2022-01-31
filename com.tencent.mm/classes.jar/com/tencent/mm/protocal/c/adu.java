package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class adu
  extends com.tencent.mm.bv.a
{
  public String tbK;
  public nd tbQ;
  public String tbR;
  public boolean tbS;
  public int tbT;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tbQ != null)
      {
        paramVarArgs.gD(1, this.tbQ.btq());
        this.tbQ.a(paramVarArgs);
      }
      if (this.tbK != null) {
        paramVarArgs.d(2, this.tbK);
      }
      if (this.tbR != null) {
        paramVarArgs.d(3, this.tbR);
      }
      paramVarArgs.aA(4, this.tbS);
      paramVarArgs.gB(5, this.tbT);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tbQ == null) {
        break label450;
      }
    }
    label450:
    for (int i = d.a.a.a.gA(1, this.tbQ.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tbK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tbK);
      }
      i = paramInt;
      if (this.tbR != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tbR);
      }
      return i + (d.a.a.b.b.a.dQ(4) + 1) + d.a.a.a.gy(5, this.tbT);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        adu localadu = (adu)paramVarArgs[1];
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
            localObject1 = new nd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((nd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localadu.tbQ = ((nd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localadu.tbK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localadu.tbR = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localadu.tbS = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localadu.tbT = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.adu
 * JD-Core Version:    0.7.0.1
 */