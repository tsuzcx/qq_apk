package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmw
  extends com.tencent.mm.bx.a
{
  public LinkedList<dlh> EBk;
  public int EDt;
  public int EDu;
  
  public dmw()
  {
    AppMethodBeat.i(115901);
    this.EBk = new LinkedList();
    AppMethodBeat.o(115901);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115902);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EDt);
      paramVarArgs.aR(2, this.EDu);
      paramVarArgs.e(3, 8, this.EBk);
      AppMethodBeat.o(115902);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.EDt);
      i = f.a.a.b.b.a.bA(2, this.EDu);
      int j = f.a.a.a.c(3, 8, this.EBk);
      AppMethodBeat.o(115902);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EBk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115902);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dmw localdmw = (dmw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115902);
        return -1;
      case 1: 
        localdmw.EDt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115902);
        return 0;
      case 2: 
        localdmw.EDu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(115902);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dlh();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dlh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdmw.EBk.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmw
 * JD-Core Version:    0.7.0.1
 */