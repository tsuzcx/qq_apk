package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cin
  extends blm
{
  public String bVk;
  public String tWS;
  public String tWX;
  public int tpI;
  public String tpM;
  
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
      if (this.bVk != null) {
        paramVarArgs.d(2, this.bVk);
      }
      paramVarArgs.gB(3, this.tpI);
      if (this.tpM != null) {
        paramVarArgs.d(99, this.tpM);
      }
      if (this.tWS != null) {
        paramVarArgs.d(100, this.tWS);
      }
      if (this.tWX != null) {
        paramVarArgs.d(101, this.tWX);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bVk != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bVk);
      }
      i += d.a.a.a.gy(3, this.tpI);
      paramInt = i;
      if (this.tpM != null) {
        paramInt = i + d.a.a.b.b.a.e(99, this.tpM);
      }
      i = paramInt;
      if (this.tWS != null) {
        i = paramInt + d.a.a.b.b.a.e(100, this.tWS);
      }
      paramInt = i;
      if (this.tWX != null) {
        paramInt = i + d.a.a.b.b.a.e(101, this.tWX);
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
        cin localcin = (cin)paramVarArgs[1];
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
            localcin.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcin.bVk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcin.tpI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 99: 
          localcin.tpM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 100: 
          localcin.tWS = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcin.tWX = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cin
 * JD-Core Version:    0.7.0.1
 */