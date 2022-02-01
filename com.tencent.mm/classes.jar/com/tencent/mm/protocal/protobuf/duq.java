package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duq
  extends com.tencent.mm.cd.a
{
  public int GroupCount;
  public LinkedList<dup> UaV;
  
  public duq()
  {
    AppMethodBeat.i(6422);
    this.UaV = new LinkedList();
    AppMethodBeat.o(6422);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6423);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.GroupCount);
      paramVarArgs.e(2, 8, this.UaV);
      AppMethodBeat.o(6423);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.GroupCount);
      i = g.a.a.a.c(2, 8, this.UaV);
      AppMethodBeat.o(6423);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.UaV.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(6423);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      duq localduq = (duq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6423);
        return -1;
      case 1: 
        localduq.GroupCount = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(6423);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        dup localdup = new dup();
        if ((localObject != null) && (localObject.length > 0)) {
          localdup.parseFrom((byte[])localObject);
        }
        localduq.UaV.add(localdup);
        paramInt += 1;
      }
      AppMethodBeat.o(6423);
      return 0;
    }
    AppMethodBeat.o(6423);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duq
 * JD-Core Version:    0.7.0.1
 */