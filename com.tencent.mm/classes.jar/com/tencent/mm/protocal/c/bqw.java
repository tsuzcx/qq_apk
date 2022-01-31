package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bqw
  extends blm
{
  public float bRt;
  public float bTc;
  public int scene;
  public String tHH;
  
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
      paramVarArgs.gB(4, this.scene);
      if (this.tHH != null) {
        paramVarArgs.d(5, this.tHH);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label437;
      }
    }
    label437:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 4) + (d.a.a.b.b.a.dQ(3) + 4) + d.a.a.a.gy(4, this.scene);
      paramInt = i;
      if (this.tHH != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tHH);
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
        bqw localbqw = (bqw)paramVarArgs[1];
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
            localbqw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbqw.bTc = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 3: 
          localbqw.bRt = ((d.a.a.a.a)localObject1).xpH.readFloat();
          return 0;
        case 4: 
          localbqw.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbqw.tHH = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bqw
 * JD-Core Version:    0.7.0.1
 */