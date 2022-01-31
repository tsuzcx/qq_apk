package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bfc
  extends com.tencent.mm.bv.a
{
  public int ten;
  public String teo;
  public String tep;
  public bzd tzP;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.ten);
      if (this.teo != null) {
        paramVarArgs.d(2, this.teo);
      }
      if (this.tep != null) {
        paramVarArgs.d(3, this.tep);
      }
      if (this.tzP != null)
      {
        paramVarArgs.gD(4, this.tzP.btq());
        this.tzP.a(paramVarArgs);
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
      i = d.a.a.a.gy(1, this.ten) + 0;
      paramInt = i;
      if (this.teo != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.teo);
      }
      i = paramInt;
      if (this.tep != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tep);
      }
      paramInt = i;
    } while (this.tzP == null);
    return i + d.a.a.a.gA(4, this.tzP.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
      bfc localbfc = (bfc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbfc.ten = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbfc.teo = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localbfc.tep = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bzd();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bzd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localbfc.tzP = ((bzd)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bfc
 * JD-Core Version:    0.7.0.1
 */