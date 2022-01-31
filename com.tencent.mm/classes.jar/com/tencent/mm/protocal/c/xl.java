package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class xl
  extends blm
{
  public String bOL;
  public int jMS;
  public String sTW;
  public long sUf;
  public String sUg;
  public String sUh;
  public int sUi;
  public int source;
  
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
      if (this.bOL != null) {
        paramVarArgs.d(2, this.bOL);
      }
      paramVarArgs.Y(3, this.sUf);
      if (this.sTW != null) {
        paramVarArgs.d(4, this.sTW);
      }
      if (this.sUg != null) {
        paramVarArgs.d(5, this.sUg);
      }
      if (this.sUh != null) {
        paramVarArgs.d(6, this.sUh);
      }
      paramVarArgs.gB(7, this.source);
      paramVarArgs.gB(8, this.sUi);
      paramVarArgs.gB(9, this.jMS);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label649;
      }
    }
    label649:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bOL);
      }
      i += d.a.a.a.X(3, this.sUf);
      paramInt = i;
      if (this.sTW != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sTW);
      }
      i = paramInt;
      if (this.sUg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sUg);
      }
      paramInt = i;
      if (this.sUh != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sUh);
      }
      return paramInt + d.a.a.a.gy(7, this.source) + d.a.a.a.gy(8, this.sUi) + d.a.a.a.gy(9, this.jMS);
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
        xl localxl = (xl)paramVarArgs[1];
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
            localxl.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localxl.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localxl.sUf = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localxl.sTW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localxl.sUg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localxl.sUh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localxl.source = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localxl.sUi = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localxl.jMS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.xl
 * JD-Core Version:    0.7.0.1
 */