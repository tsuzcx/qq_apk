package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class u
  extends blm
{
  public int scene;
  public String sign;
  public String srq;
  public String srr;
  public int ver;
  
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
      if (this.srq != null) {
        paramVarArgs.d(2, this.srq);
      }
      paramVarArgs.gB(3, this.scene);
      if (this.srr != null) {
        paramVarArgs.d(4, this.srr);
      }
      if (this.sign != null) {
        paramVarArgs.d(5, this.sign);
      }
      paramVarArgs.gB(6, this.ver);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label516;
      }
    }
    label516:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.srq != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.srq);
      }
      i += d.a.a.a.gy(3, this.scene);
      paramInt = i;
      if (this.srr != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.srr);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sign);
      }
      return i + d.a.a.a.gy(6, this.ver);
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
        u localu = (u)paramVarArgs[1];
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
            localu.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localu.srq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localu.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localu.srr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localu.sign = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localu.ver = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.u
 * JD-Core Version:    0.7.0.1
 */