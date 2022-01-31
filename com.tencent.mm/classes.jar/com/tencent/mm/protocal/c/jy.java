package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class jy
  extends com.tencent.mm.bv.a
{
  public LinkedList<za> sEJ = new LinkedList();
  public LinkedList<yz> sEK = new LinkedList();
  public String sEL;
  public String sEM;
  public String sEN;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 8, this.sEJ);
      paramVarArgs.d(2, 8, this.sEK);
      if (this.sEL != null) {
        paramVarArgs.d(3, this.sEL);
      }
      if (this.sEM != null) {
        paramVarArgs.d(4, this.sEM);
      }
      if (this.sEN != null) {
        paramVarArgs.d(5, this.sEN);
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
      i = d.a.a.a.c(1, 8, this.sEJ) + 0 + d.a.a.a.c(2, 8, this.sEK);
      paramInt = i;
      if (this.sEL != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.sEL);
      }
      i = paramInt;
      if (this.sEM != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.sEM);
      }
      paramInt = i;
    } while (this.sEN == null);
    return i + d.a.a.b.b.a.e(5, this.sEN);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sEJ.clear();
      this.sEK.clear();
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
      jy localjy = (jy)paramVarArgs[1];
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
          localObject1 = new za();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((za)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localjy.sEJ.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yz();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localjy.sEK.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localjy.sEL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localjy.sEM = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localjy.sEN = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jy
 * JD-Core Version:    0.7.0.1
 */