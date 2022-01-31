package com.tencent.mm.protocal.a.a;

import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public int nettype;
  public String sqE;
  public String sqF;
  public String sqG;
  public String sqH;
  public String sqI;
  public int sqJ;
  public int squ;
  public LinkedList<d> sqv = new LinkedList();
  public int uin;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.uin);
      paramVarArgs.gB(2, this.squ);
      paramVarArgs.gB(3, this.nettype);
      paramVarArgs.d(4, 8, this.sqv);
      if (this.sqE != null) {
        paramVarArgs.d(5, this.sqE);
      }
      if (this.sqF != null) {
        paramVarArgs.d(6, this.sqF);
      }
      if (this.sqG != null) {
        paramVarArgs.d(7, this.sqG);
      }
      if (this.sqH != null) {
        paramVarArgs.d(8, this.sqH);
      }
      if (this.sqI != null) {
        paramVarArgs.d(9, this.sqI);
      }
      paramVarArgs.gB(10, this.sqJ);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.uin) + 0 + d.a.a.a.gy(2, this.squ) + d.a.a.a.gy(3, this.nettype) + d.a.a.a.c(4, 8, this.sqv);
      paramInt = i;
      if (this.sqE != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sqE);
      }
      i = paramInt;
      if (this.sqF != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sqF);
      }
      paramInt = i;
      if (this.sqG != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sqG);
      }
      i = paramInt;
      if (this.sqH != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.sqH);
      }
      paramInt = i;
      if (this.sqI != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sqI);
      }
      return paramInt + d.a.a.a.gy(10, this.sqJ);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sqv.clear();
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
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        locale.uin = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        locale.squ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        locale.nettype = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          locale.sqv.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        locale.sqE = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        locale.sqF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 7: 
        locale.sqG = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        locale.sqH = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        locale.sqI = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      locale.sqJ = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.e
 * JD-Core Version:    0.7.0.1
 */