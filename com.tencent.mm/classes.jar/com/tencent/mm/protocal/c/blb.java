package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class blb
  extends blm
{
  public float bRt;
  public float bTc;
  public String bZc;
  public float tEB;
  public b tEC;
  public boolean tED;
  public boolean tEE;
  
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
      paramVarArgs.m(2, this.bTc);
      paramVarArgs.m(3, this.bRt);
      paramVarArgs.m(4, this.tEB);
      if (this.tEC != null) {
        paramVarArgs.b(5, this.tEC);
      }
      if (this.bZc != null) {
        paramVarArgs.d(6, this.bZc);
      }
      paramVarArgs.aA(7, this.tED);
      paramVarArgs.aA(8, this.tEE);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label557;
      }
    }
    label557:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 4) + (d.a.a.b.b.a.dQ(3) + 4) + (d.a.a.b.b.a.dQ(4) + 4);
      paramInt = i;
      if (this.tEC != null) {
        paramInt = i + d.a.a.a.a(5, this.tEC);
      }
      i = paramInt;
      if (this.bZc != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.bZc);
      }
      return i + (d.a.a.b.b.a.dQ(7) + 1) + (d.a.a.b.b.a.dQ(8) + 1);
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
        blb localblb = (blb)paramVarArgs[1];
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
            localblb.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localblb.bTc = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 3: 
          localblb.bRt = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 4: 
          localblb.tEB = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 5: 
          localblb.tEC = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 6: 
          localblb.bZc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localblb.tED = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localblb.tEE = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blb
 * JD-Core Version:    0.7.0.1
 */