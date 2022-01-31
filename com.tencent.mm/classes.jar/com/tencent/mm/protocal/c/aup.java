package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aup
  extends com.tencent.mm.bv.a
{
  public LinkedList<mo> taW = new LinkedList();
  public String tqb;
  public boolean tqc;
  public fq tqd;
  public String tqe;
  public boolean tqf;
  public int tqg;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tqb != null) {
        paramVarArgs.d(1, this.tqb);
      }
      paramVarArgs.d(2, 8, this.taW);
      paramVarArgs.aA(3, this.tqc);
      if (this.tqd != null)
      {
        paramVarArgs.gD(4, this.tqd.btq());
        this.tqd.a(paramVarArgs);
      }
      if (this.tqe != null) {
        paramVarArgs.d(5, this.tqe);
      }
      paramVarArgs.aA(6, this.tqf);
      paramVarArgs.gB(7, this.tqg);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tqb == null) {
        break label619;
      }
    }
    label619:
    for (paramInt = d.a.a.b.b.a.e(1, this.tqb) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.c(2, 8, this.taW) + (d.a.a.b.b.a.dQ(3) + 1);
      paramInt = i;
      if (this.tqd != null) {
        paramInt = i + d.a.a.a.gA(4, this.tqd.btq());
      }
      i = paramInt;
      if (this.tqe != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tqe);
      }
      return i + (d.a.a.b.b.a.dQ(6) + 1) + d.a.a.a.gy(7, this.tqg);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.taW.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        aup localaup = (aup)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localaup.tqb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mo();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mo)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaup.taW.add(localObject1);
            paramInt += 1;
          }
        case 3: 
          localaup.tqc = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fq();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localaup.tqd = ((fq)localObject1);
            paramInt += 1;
          }
        case 5: 
          localaup.tqe = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localaup.tqf = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        }
        localaup.tqg = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aup
 * JD-Core Version:    0.7.0.1
 */