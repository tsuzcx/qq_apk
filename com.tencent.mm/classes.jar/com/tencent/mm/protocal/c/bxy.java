package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bxy
  extends com.tencent.mm.bv.a
{
  public int hQQ;
  public String jnU;
  public String sND;
  public int sNE;
  public int tFj;
  public LinkedList<bxx> tNT = new LinkedList();
  public boolean tNU;
  public String tNV;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.type);
      paramVarArgs.gB(2, this.hQQ);
      if (this.sND != null) {
        paramVarArgs.d(3, this.sND);
      }
      if (this.jnU != null) {
        paramVarArgs.d(4, this.jnU);
      }
      paramVarArgs.gB(5, this.sNE);
      paramVarArgs.gB(6, this.tFj);
      paramVarArgs.d(7, 8, this.tNT);
      paramVarArgs.aA(8, this.tNU);
      if (this.tNV != null) {
        paramVarArgs.d(9, this.tNV);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.type) + 0 + d.a.a.a.gy(2, this.hQQ);
      paramInt = i;
      if (this.sND != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sND);
      }
      i = paramInt;
      if (this.jnU != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.jnU);
      }
      i = i + d.a.a.a.gy(5, this.sNE) + d.a.a.a.gy(6, this.tFj) + d.a.a.a.c(7, 8, this.tNT) + (d.a.a.b.b.a.dQ(8) + 1);
      paramInt = i;
    } while (this.tNV == null);
    return i + d.a.a.b.b.a.e(9, this.tNV);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tNT.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      bxy localbxy = (bxy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbxy.type = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbxy.hQQ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localbxy.sND = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localbxy.jnU = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localbxy.sNE = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        localbxy.tFj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bxx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bxx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbxy.tNT.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        localbxy.tNU = ((d.a.a.a.a)localObject1).cUr();
        return 0;
      }
      localbxy.tNV = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxy
 * JD-Core Version:    0.7.0.1
 */