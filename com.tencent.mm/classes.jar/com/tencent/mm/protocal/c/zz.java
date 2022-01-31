package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class zz
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public LinkedList<zt> sZk = new LinkedList();
  public LinkedList<aab> sZl = new LinkedList();
  public String sZm;
  public String sZn;
  public LinkedList<aaa> sZo = new LinkedList();
  public int sZp;
  public boolean sZq;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bGw != null) {
        paramVarArgs.d(1, this.bGw);
      }
      paramVarArgs.gB(2, this.type);
      paramVarArgs.d(3, 8, this.sZk);
      paramVarArgs.d(4, 8, this.sZl);
      if (this.sZm != null) {
        paramVarArgs.d(5, this.sZm);
      }
      if (this.sZn != null) {
        paramVarArgs.d(6, this.sZn);
      }
      paramVarArgs.d(7, 8, this.sZo);
      paramVarArgs.gB(8, this.sZp);
      paramVarArgs.aA(9, this.sZq);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bGw == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = d.a.a.b.b.a.e(1, this.bGw) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.type) + d.a.a.a.c(3, 8, this.sZk) + d.a.a.a.c(4, 8, this.sZl);
      paramInt = i;
      if (this.sZm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sZm);
      }
      i = paramInt;
      if (this.sZn != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sZn);
      }
      return i + d.a.a.a.c(7, 8, this.sZo) + d.a.a.a.gy(8, this.sZp) + (d.a.a.b.b.a.dQ(9) + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sZk.clear();
        this.sZl.clear();
        this.sZo.clear();
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
        zz localzz = (zz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localzz.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localzz.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new zt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((zt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localzz.sZk.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aab();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aab)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localzz.sZl.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localzz.sZm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localzz.sZn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aaa();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aaa)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localzz.sZo.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localzz.sZp = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localzz.sZq = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.zz
 * JD-Core Version:    0.7.0.1
 */