package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ed
  extends com.tencent.mm.bx.a
{
  public dhy YGk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43082);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGk != null)
      {
        paramVarArgs.qD(1, this.YGk.computeSize());
        this.YGk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43082);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGk == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.YGk.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(43082);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43082);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ed localed = (ed)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43082);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dhy localdhy = new dhy();
          if ((localObject != null) && (localObject.length > 0)) {
            localdhy.parseFrom((byte[])localObject);
          }
          localed.YGk = localdhy;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ed
 * JD-Core Version:    0.7.0.1
 */