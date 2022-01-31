package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aca
  extends com.tencent.mm.bv.a
{
  public aw sHl;
  public String sLl;
  public LinkedList<String> tba = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.d(1, 1, this.tba);
      if (this.sHl != null)
      {
        paramVarArgs.gD(2, this.sHl.btq());
        this.sHl.a(paramVarArgs);
      }
      if (this.sLl != null) {
        paramVarArgs.d(3, this.sLl);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.c(1, 1, this.tba) + 0;
      paramInt = i;
      if (this.sHl != null) {
        paramInt = i + d.a.a.a.gA(2, this.sHl.btq());
      }
      i = paramInt;
    } while (this.sLl == null);
    return paramInt + d.a.a.b.b.a.e(3, this.sLl);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tba.clear();
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
      aca localaca = (aca)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaca.tba.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaca.sHl = ((aw)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localaca.sLl = ((d.a.a.a.a)localObject1).xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aca
 * JD-Core Version:    0.7.0.1
 */