package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiz
  extends com.tencent.mm.cd.a
{
  public eaf UkV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125761);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UkV != null)
      {
        paramVarArgs.oE(1, this.UkV.computeSize());
        this.UkV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UkV == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.UkV.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125761);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eiz localeiz = (eiz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125761);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eaf localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localeiz.UkV = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(125761);
        return 0;
      }
      AppMethodBeat.o(125761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiz
 * JD-Core Version:    0.7.0.1
 */