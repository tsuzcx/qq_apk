package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clb
  extends com.tencent.mm.bx.a
{
  public int Heq;
  public LinkedList<dky> Her;
  public int gsV;
  
  public clb()
  {
    AppMethodBeat.i(152661);
    this.Her = new LinkedList();
    AppMethodBeat.o(152661);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152662);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.gsV);
      paramVarArgs.aS(2, this.Heq);
      paramVarArgs.e(3, 8, this.Her);
      AppMethodBeat.o(152662);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.gsV);
      i = f.a.a.b.b.a.bz(2, this.Heq);
      int j = f.a.a.a.c(3, 8, this.Her);
      AppMethodBeat.o(152662);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Her.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clb localclb = (clb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152662);
        return -1;
      case 1: 
        localclb.gsV = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152662);
        return 0;
      case 2: 
        localclb.Heq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(152662);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dky();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dky)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localclb.Her.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(152662);
      return 0;
    }
    AppMethodBeat.o(152662);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clb
 * JD-Core Version:    0.7.0.1
 */