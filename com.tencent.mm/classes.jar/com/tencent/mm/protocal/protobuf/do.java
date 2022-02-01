package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class do
  extends com.tencent.mm.cd.a
{
  public crd RIW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43082);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIW != null)
      {
        paramVarArgs.oE(1, this.RIW.computeSize());
        this.RIW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIW == null) {
        break label288;
      }
    }
    label288:
    for (paramInt = g.a.a.a.oD(1, this.RIW.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43082);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(43082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        do localdo = (do)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43082);
          return -1;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          crd localcrd = new crd();
          if ((localObject != null) && (localObject.length > 0)) {
            localcrd.parseFrom((byte[])localObject);
          }
          localdo.RIW = localcrd;
          paramInt += 1;
        }
        AppMethodBeat.o(43082);
        return 0;
      }
      AppMethodBeat.o(43082);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.do
 * JD-Core Version:    0.7.0.1
 */