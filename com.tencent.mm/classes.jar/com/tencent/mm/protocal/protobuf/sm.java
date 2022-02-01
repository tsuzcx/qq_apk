package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sm
  extends com.tencent.mm.cd.a
{
  public boolean KVr;
  public LinkedList<sn> SbU;
  
  public sm()
  {
    AppMethodBeat.i(247762);
    this.SbU = new LinkedList();
    AppMethodBeat.o(247762);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247764);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.SbU);
      paramVarArgs.co(2, this.KVr);
      AppMethodBeat.o(247764);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.SbU);
      i = g.a.a.b.b.a.gL(2);
      AppMethodBeat.o(247764);
      return paramInt + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SbU.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(247764);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      sm localsm = (sm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(247764);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          sn localsn = new sn();
          if ((localObject != null) && (localObject.length > 0)) {
            localsn.parseFrom((byte[])localObject);
          }
          localsm.SbU.add(localsn);
          paramInt += 1;
        }
        AppMethodBeat.o(247764);
        return 0;
      }
      localsm.KVr = ((g.a.a.a.a)localObject).abFh.AB();
      AppMethodBeat.o(247764);
      return 0;
    }
    AppMethodBeat.o(247764);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sm
 * JD-Core Version:    0.7.0.1
 */