package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class aap
  extends com.tencent.mm.bv.a
{
  public int bcw;
  public int tak;
  public LinkedList<we> tal = new LinkedList();
  public int tam;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tak);
      paramVarArgs.d(2, 8, this.tal);
      paramVarArgs.gB(3, this.tam);
      paramVarArgs.gB(4, this.bcw);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.tak) + 0 + d.a.a.a.c(2, 8, this.tal) + d.a.a.a.gy(3, this.tam) + d.a.a.a.gy(4, this.bcw);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tal.clear();
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
      aap localaap = (aap)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaap.tak = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new we();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((we)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localaap.tal.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        localaap.tam = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      localaap.bcw = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aap
 * JD-Core Version:    0.7.0.1
 */