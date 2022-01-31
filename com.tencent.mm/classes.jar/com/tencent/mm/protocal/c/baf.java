package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class baf
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b sAk;
  public int twe;
  public String twf;
  public bmk twg;
  public int twh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.twg == null) {
        throw new d.a.a.b("Not all required fields were included: ClientKey");
      }
      paramVarArgs.gB(1, this.twe);
      if (this.sAk != null) {
        paramVarArgs.b(2, this.sAk);
      }
      if (this.twf != null) {
        paramVarArgs.d(3, this.twf);
      }
      if (this.twg != null)
      {
        paramVarArgs.gD(4, this.twg.btq());
        this.twg.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.twh);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.twe) + 0;
      paramInt = i;
      if (this.sAk != null) {
        paramInt = i + d.a.a.a.a(2, this.sAk);
      }
      i = paramInt;
      if (this.twf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.twf);
      }
      paramInt = i;
      if (this.twg != null) {
        paramInt = i + d.a.a.a.gA(4, this.twg.btq());
      }
      return paramInt + d.a.a.a.gy(5, this.twh);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.twg == null) {
        throw new d.a.a.b("Not all required fields were included: ClientKey");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      baf localbaf = (baf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localbaf.twe = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localbaf.sAk = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      case 3: 
        localbaf.twf = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localbaf.twg = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localbaf.twh = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.baf
 * JD-Core Version:    0.7.0.1
 */