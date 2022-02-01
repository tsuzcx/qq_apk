package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ql
  extends com.tencent.mm.cd.a
{
  public String RYH;
  public LinkedList<dqj> RYI;
  
  public ql()
  {
    AppMethodBeat.i(250171);
    this.RYI = new LinkedList();
    AppMethodBeat.o(250171);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250173);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RYH != null) {
        paramVarArgs.f(1, this.RYH);
      }
      paramVarArgs.e(2, 8, this.RYI);
      AppMethodBeat.o(250173);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RYH == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = g.a.a.b.b.a.g(1, this.RYH) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.RYI);
      AppMethodBeat.o(250173);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RYI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(250173);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ql localql = (ql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(250173);
          return -1;
        case 1: 
          localql.RYH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250173);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dqj localdqj = new dqj();
          if ((localObject != null) && (localObject.length > 0)) {
            localdqj.parseFrom((byte[])localObject);
          }
          localql.RYI.add(localdqj);
          paramInt += 1;
        }
        AppMethodBeat.o(250173);
        return 0;
      }
      AppMethodBeat.o(250173);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ql
 * JD-Core Version:    0.7.0.1
 */