package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dld
  extends com.tencent.mm.cd.a
{
  public LinkedList<pa> TSi;
  public LinkedList<String> TSj;
  public LinkedList<String> TSk;
  
  public dld()
  {
    AppMethodBeat.i(205970);
    this.TSi = new LinkedList();
    this.TSj = new LinkedList();
    this.TSk = new LinkedList();
    AppMethodBeat.o(205970);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205971);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.TSi);
      paramVarArgs.e(2, 1, this.TSj);
      paramVarArgs.e(3, 1, this.TSk);
      AppMethodBeat.o(205971);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.TSi);
      i = g.a.a.a.c(2, 1, this.TSj);
      int j = g.a.a.a.c(3, 1, this.TSk);
      AppMethodBeat.o(205971);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.TSi.clear();
      this.TSj.clear();
      this.TSk.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(205971);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      dld localdld = (dld)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(205971);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          pa localpa = new pa();
          if ((localObject != null) && (localObject.length > 0)) {
            localpa.parseFrom((byte[])localObject);
          }
          localdld.TSi.add(localpa);
          paramInt += 1;
        }
        AppMethodBeat.o(205971);
        return 0;
      case 2: 
        localdld.TSj.add(((g.a.a.a.a)localObject).abFh.readString());
        AppMethodBeat.o(205971);
        return 0;
      }
      localdld.TSk.add(((g.a.a.a.a)localObject).abFh.readString());
      AppMethodBeat.o(205971);
      return 0;
    }
    AppMethodBeat.o(205971);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dld
 * JD-Core Version:    0.7.0.1
 */