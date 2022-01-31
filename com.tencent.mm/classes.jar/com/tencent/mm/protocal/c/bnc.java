package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bnc
  extends blm
{
  public String bOL;
  public int sQr;
  public String state;
  public String tGh;
  public int tvG;
  public LinkedList<String> tvH = new LinkedList();
  
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
      paramVarArgs.gB(3, this.tvG);
      paramVarArgs.d(4, 1, this.tvH);
      if (this.bOL != null) {
        paramVarArgs.d(5, this.bOL);
      }
      if (this.state != null) {
        paramVarArgs.d(6, this.state);
      }
      if (this.tGh != null) {
        paramVarArgs.d(7, this.tGh);
      }
      paramVarArgs.gB(8, this.sQr);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label575;
      }
    }
    label575:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(3, this.tvG) + d.a.a.a.c(4, 1, this.tvH);
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.bOL);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.state);
      }
      paramInt = i;
      if (this.tGh != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tGh);
      }
      return paramInt + d.a.a.a.gy(8, this.sQr);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tvH.clear();
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
        bnc localbnc = (bnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
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
            localbnc.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 3: 
          localbnc.tvG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbnc.tvH.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 5: 
          localbnc.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbnc.state = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbnc.tGh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbnc.sQr = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bnc
 * JD-Core Version:    0.7.0.1
 */