package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cel
  extends blm
{
  public int sNU;
  public long tAB;
  public int tAC;
  public String tTp;
  public com.tencent.mm.bv.b tTq;
  public com.tencent.mm.bv.b tTr;
  public String tTs;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tTp == null) {
        throw new d.a.a.b("Not all required fields were included: ToBizUserName");
      }
      if (this.tTr == null) {
        throw new d.a.a.b("Not all required fields were included: CapInfo");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      paramVarArgs.gB(2, this.tAC);
      if (this.tTp != null) {
        paramVarArgs.d(3, this.tTp);
      }
      paramVarArgs.gB(4, this.sNU);
      if (this.tTq != null) {
        paramVarArgs.b(5, this.tTq);
      }
      if (this.tTr != null) {
        paramVarArgs.b(6, this.tTr);
      }
      paramVarArgs.Y(7, this.tAB);
      if (this.tTs != null) {
        paramVarArgs.d(8, this.tTs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label676;
      }
    }
    label676:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tAC);
      paramInt = i;
      if (this.tTp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.tTp);
      }
      i = paramInt + d.a.a.a.gy(4, this.sNU);
      paramInt = i;
      if (this.tTq != null) {
        paramInt = i + d.a.a.a.a(5, this.tTq);
      }
      i = paramInt;
      if (this.tTr != null) {
        i = paramInt + d.a.a.a.a(6, this.tTr);
      }
      i += d.a.a.a.X(7, this.tAB);
      paramInt = i;
      if (this.tTs != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tTs);
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
        if (this.tTp == null) {
          throw new d.a.a.b("Not all required fields were included: ToBizUserName");
        }
        if (this.tTr != null) {
          break;
        }
        throw new d.a.a.b("Not all required fields were included: CapInfo");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cel localcel = (cel)paramVarArgs[1];
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
            localcel.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcel.tAC = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcel.tTp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localcel.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcel.tTq = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 6: 
          localcel.tTr = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 7: 
          localcel.tAB = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        }
        localcel.tTs = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cel
 * JD-Core Version:    0.7.0.1
 */