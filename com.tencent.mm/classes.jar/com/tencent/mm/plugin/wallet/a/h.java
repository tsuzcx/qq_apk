package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class h
  extends com.tencent.mm.bv.a
{
  public double qkV;
  public LinkedList<q> qkX = new LinkedList();
  public double qlc;
  public double qld;
  public int qle;
  public String qlf;
  public String qlg;
  public b qlj;
  public String qlk;
  public double qll;
  public LinkedList<e> qlm = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.qlk != null) {
        paramVarArgs.d(1, this.qlk);
      }
      paramVarArgs.b(2, this.qll);
      paramVarArgs.b(3, this.qkV);
      paramVarArgs.d(4, 8, this.qlm);
      paramVarArgs.d(5, 8, this.qkX);
      paramVarArgs.b(6, this.qlc);
      paramVarArgs.b(7, this.qld);
      paramVarArgs.gB(8, this.qle);
      if (this.qlf != null) {
        paramVarArgs.d(9, this.qlf);
      }
      if (this.qlg != null) {
        paramVarArgs.d(10, this.qlg);
      }
      if (this.qlj != null) {
        paramVarArgs.b(11, this.qlj);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.qlk == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = d.a.a.b.b.a.e(1, this.qlk) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 8) + (d.a.a.b.b.a.dQ(3) + 8) + d.a.a.a.c(4, 8, this.qlm) + d.a.a.a.c(5, 8, this.qkX) + (d.a.a.b.b.a.dQ(6) + 8) + (d.a.a.b.b.a.dQ(7) + 8) + d.a.a.a.gy(8, this.qle);
      paramInt = i;
      if (this.qlf != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.qlf);
      }
      i = paramInt;
      if (this.qlg != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.qlg);
      }
      paramInt = i;
      if (this.qlj != null) {
        paramInt = i + d.a.a.a.a(11, this.qlj);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.qlm.clear();
        this.qkX.clear();
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
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localh.qlk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localh.qll = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 3: 
          localh.qkV = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localh.qlm.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new q();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((q)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localh.qkX.add(localObject1);
            paramInt += 1;
          }
        case 6: 
          localh.qlc = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 7: 
          localh.qld = ((d.a.a.a.a)localObject1).xpH.readDouble();
          return 0;
        case 8: 
          localh.qle = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localh.qlf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localh.qlg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localh.qlj = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.h
 * JD-Core Version:    0.7.0.1
 */