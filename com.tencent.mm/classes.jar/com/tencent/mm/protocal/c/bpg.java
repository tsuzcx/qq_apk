package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bpg
  extends blm
{
  public String kRZ;
  public String kSz;
  public String mEb;
  public String sxZ;
  public String tHj;
  public String tHk;
  
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
      if (this.kSz != null) {
        paramVarArgs.d(2, this.kSz);
      }
      if (this.tHj != null) {
        paramVarArgs.d(3, this.tHj);
      }
      if (this.mEb != null) {
        paramVarArgs.d(5, this.mEb);
      }
      if (this.kRZ != null) {
        paramVarArgs.d(4, this.kRZ);
      }
      if (this.sxZ != null) {
        paramVarArgs.d(6, this.sxZ);
      }
      if (this.tHk != null) {
        paramVarArgs.d(7, this.tHk);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label607;
      }
    }
    label607:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSz != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSz);
      }
      i = paramInt;
      if (this.tHj != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tHj);
      }
      paramInt = i;
      if (this.mEb != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.mEb);
      }
      i = paramInt;
      if (this.kRZ != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.kRZ);
      }
      paramInt = i;
      if (this.sxZ != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sxZ);
      }
      i = paramInt;
      if (this.tHk != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tHk);
      }
      return i;
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
        bpg localbpg = (bpg)paramVarArgs[1];
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
            localbpg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbpg.kSz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbpg.tHj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbpg.mEb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbpg.kRZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbpg.sxZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbpg.tHk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bpg
 * JD-Core Version:    0.7.0.1
 */