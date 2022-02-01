package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edf
  extends com.tencent.mm.cd.a
{
  public String GdS;
  public dog UhH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231423);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UhH != null)
      {
        paramVarArgs.oE(1, this.UhH.computeSize());
        this.UhH.writeFields(paramVarArgs);
      }
      if (this.GdS != null) {
        paramVarArgs.f(2, this.GdS);
      }
      AppMethodBeat.o(231423);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UhH == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.UhH.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GdS != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.GdS);
      }
      AppMethodBeat.o(231423);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231423);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        edf localedf = (edf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231423);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dog localdog = new dog();
            if ((localObject != null) && (localObject.length > 0)) {
              localdog.parseFrom((byte[])localObject);
            }
            localedf.UhH = localdog;
            paramInt += 1;
          }
          AppMethodBeat.o(231423);
          return 0;
        }
        localedf.GdS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(231423);
        return 0;
      }
      AppMethodBeat.o(231423);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edf
 * JD-Core Version:    0.7.0.1
 */