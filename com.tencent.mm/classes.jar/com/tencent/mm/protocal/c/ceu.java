package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ceu
  extends bly
{
  public long sSU;
  public int tTA;
  public int tTB;
  public com.tencent.mm.bv.b tTC;
  public long tTo;
  public int tTy;
  public int tTz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      paramVarArgs.Y(2, this.tTo);
      paramVarArgs.Y(3, this.sSU);
      paramVarArgs.gB(4, this.tTy);
      paramVarArgs.gB(5, this.tTz);
      paramVarArgs.gB(6, this.tTA);
      paramVarArgs.gB(7, this.tTB);
      if (this.tTC != null) {
        paramVarArgs.b(8, this.tTC);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label587;
      }
    }
    label587:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.X(2, this.tTo) + d.a.a.a.X(3, this.sSU) + d.a.a.a.gy(4, this.tTy) + d.a.a.a.gy(5, this.tTz) + d.a.a.a.gy(6, this.tTA) + d.a.a.a.gy(7, this.tTB);
      paramInt = i;
      if (this.tTC != null) {
        paramInt = i + d.a.a.a.a(8, this.tTC);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ceu localceu = (ceu)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localceu.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          localceu.tTo = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 3: 
          localceu.sSU = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 4: 
          localceu.tTy = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localceu.tTz = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localceu.tTA = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localceu.tTB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localceu.tTC = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ceu
 * JD-Core Version:    0.7.0.1
 */