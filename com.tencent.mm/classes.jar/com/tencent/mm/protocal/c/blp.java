package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class blp
  extends blm
{
  public String bOL;
  public int lLl;
  public String lLm;
  public int srt;
  public int tFd;
  public int tFe;
  public long txB;
  
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
      paramVarArgs.gB(3, this.lLl);
      paramVarArgs.gB(4, this.srt);
      paramVarArgs.Y(5, this.txB);
      paramVarArgs.gB(6, this.tFd);
      if (this.lLm != null) {
        paramVarArgs.d(7, this.lLm);
      }
      paramVarArgs.gB(8, this.tFe);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bOL);
      }
      i = i + d.a.a.a.gy(3, this.lLl) + d.a.a.a.gy(4, this.srt) + d.a.a.a.X(5, this.txB) + d.a.a.a.gy(6, this.tFd);
      paramInt = i;
      if (this.lLm != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.lLm);
      }
      return paramInt + d.a.a.a.gy(8, this.tFe);
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
        blp localblp = (blp)paramVarArgs[1];
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
            localblp.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localblp.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localblp.lLl = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localblp.srt = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localblp.txB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localblp.tFd = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localblp.lLm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localblp.tFe = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.blp
 * JD-Core Version:    0.7.0.1
 */