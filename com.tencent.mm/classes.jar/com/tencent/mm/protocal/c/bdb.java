package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bdb
  extends blm
{
  public String mPI;
  public int mPQ;
  public String mQb;
  public aw sHl;
  public int tys;
  
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
      paramVarArgs.gB(2, this.tys);
      if (this.mPI != null) {
        paramVarArgs.d(3, this.mPI);
      }
      paramVarArgs.gB(4, this.mPQ);
      if (this.mQb != null) {
        paramVarArgs.d(5, this.mQb);
      }
      if (this.sHl != null)
      {
        paramVarArgs.gD(6, this.sHl.btq());
        this.sHl.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label610;
      }
    }
    label610:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tys);
      paramInt = i;
      if (this.mPI != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.mPI);
      }
      i = paramInt + d.a.a.a.gy(4, this.mPQ);
      paramInt = i;
      if (this.mQb != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.mQb);
      }
      i = paramInt;
      if (this.sHl != null) {
        i = paramInt + d.a.a.a.gA(6, this.sHl.btq());
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
        bdb localbdb = (bdb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbdb.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbdb.tys = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localbdb.mPI = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbdb.mPQ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbdb.mQb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localbdb.sHl = ((aw)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdb
 * JD-Core Version:    0.7.0.1
 */