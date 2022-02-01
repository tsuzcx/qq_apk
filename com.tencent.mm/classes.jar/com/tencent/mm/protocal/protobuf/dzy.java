package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzy
  extends com.tencent.mm.bw.a
{
  public LinkedList<dyj> IdB;
  public int IfK;
  public int IfL;
  
  public dzy()
  {
    AppMethodBeat.i(115901);
    this.IdB = new LinkedList();
    AppMethodBeat.o(115901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IfK);
      paramVarArgs.aS(2, this.IfL);
      paramVarArgs.e(3, 8, this.IdB);
      AppMethodBeat.o(115902);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.IfK);
      i = f.a.a.b.b.a.bz(2, this.IfL);
      int j = f.a.a.a.c(3, 8, this.IdB);
      AppMethodBeat.o(115902);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.IdB.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dzy localdzy = (dzy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115902);
        return -1;
      case 1: 
        localdzy.IfK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115902);
        return 0;
      case 2: 
        localdzy.IfL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115902);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dyj();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdzy.IdB.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    AppMethodBeat.o(115902);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzy
 * JD-Core Version:    0.7.0.1
 */