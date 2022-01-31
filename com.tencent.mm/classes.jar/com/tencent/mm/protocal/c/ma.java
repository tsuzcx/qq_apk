package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ma
  extends com.tencent.mm.bv.a
{
  public String sHX;
  public String sHY;
  public String sHZ;
  public int sIa;
  public String sIb;
  public lx sIc;
  public String sId;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sHX != null) {
        paramVarArgs.d(1, this.sHX);
      }
      if (this.sHY != null) {
        paramVarArgs.d(2, this.sHY);
      }
      if (this.sHZ != null) {
        paramVarArgs.d(3, this.sHZ);
      }
      paramVarArgs.gB(4, this.sIa);
      if (this.sIb != null) {
        paramVarArgs.d(5, this.sIb);
      }
      if (this.sIc != null)
      {
        paramVarArgs.gD(6, this.sIc.btq());
        this.sIc.a(paramVarArgs);
      }
      if (this.sId != null) {
        paramVarArgs.d(7, this.sId);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sHX == null) {
        break label591;
      }
    }
    label591:
    for (int i = d.a.a.b.b.a.e(1, this.sHX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sHY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sHY);
      }
      i = paramInt;
      if (this.sHZ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sHZ);
      }
      i += d.a.a.a.gy(4, this.sIa);
      paramInt = i;
      if (this.sIb != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sIb);
      }
      i = paramInt;
      if (this.sIc != null) {
        i = paramInt + d.a.a.a.gA(6, this.sIc.btq());
      }
      paramInt = i;
      if (this.sId != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sId);
      }
      return paramInt;
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
        ma localma = (ma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localma.sHX = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localma.sHY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localma.sHZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localma.sIa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localma.sIb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lx();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((lx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localma.sIc = ((lx)localObject1);
            paramInt += 1;
          }
        }
        localma.sId = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ma
 * JD-Core Version:    0.7.0.1
 */