package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class asd
  extends blm
{
  public String bOL;
  public String signature;
  public String srr;
  public int timestamp;
  public String tmB;
  
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
      if (this.srr != null) {
        paramVarArgs.d(3, this.srr);
      }
      if (this.signature != null) {
        paramVarArgs.d(4, this.signature);
      }
      paramVarArgs.gB(5, this.timestamp);
      if (this.tmB != null) {
        paramVarArgs.d(6, this.tmB);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label532;
      }
    }
    label532:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bOL);
      }
      i = paramInt;
      if (this.srr != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.srr);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.signature);
      }
      i = paramInt + d.a.a.a.gy(5, this.timestamp);
      paramInt = i;
      if (this.tmB != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tmB);
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
        asd localasd = (asd)paramVarArgs[1];
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
            localasd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localasd.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localasd.srr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localasd.signature = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localasd.timestamp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localasd.tmB = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.asd
 * JD-Core Version:    0.7.0.1
 */