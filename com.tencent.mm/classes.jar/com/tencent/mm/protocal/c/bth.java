package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bth
  extends blm
{
  public int hQR;
  public int ndf;
  public int ndg;
  public String tJQ;
  public int tJR;
  
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
      paramVarArgs.gB(2, this.ndg);
      paramVarArgs.gB(3, this.ndf);
      if (this.tJQ != null) {
        paramVarArgs.d(4, this.tJQ);
      }
      paramVarArgs.gB(5, this.hQR);
      paramVarArgs.gB(6, this.tJR);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label480;
      }
    }
    label480:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.ndg) + d.a.a.a.gy(3, this.ndf);
      paramInt = i;
      if (this.tJQ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tJQ);
      }
      return paramInt + d.a.a.a.gy(5, this.hQR) + d.a.a.a.gy(6, this.tJR);
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
        bth localbth = (bth)paramVarArgs[1];
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
            localbth.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbth.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbth.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbth.tJQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbth.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbth.tJR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bth
 * JD-Core Version:    0.7.0.1
 */