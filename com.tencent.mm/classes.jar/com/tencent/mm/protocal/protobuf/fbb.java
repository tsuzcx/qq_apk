package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fbb
  extends com.tencent.mm.cd.a
{
  public fbf UAW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205419);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UAW != null)
      {
        paramVarArgs.oE(1, this.UAW.computeSize());
        this.UAW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(205419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UAW == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.UAW.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(205419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fbb localfbb = (fbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205419);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fbf localfbf = new fbf();
          if ((localObject != null) && (localObject.length > 0)) {
            localfbf.parseFrom((byte[])localObject);
          }
          localfbb.UAW = localfbf;
          paramInt += 1;
        }
        AppMethodBeat.o(205419);
        return 0;
      }
      AppMethodBeat.o(205419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbb
 * JD-Core Version:    0.7.0.1
 */