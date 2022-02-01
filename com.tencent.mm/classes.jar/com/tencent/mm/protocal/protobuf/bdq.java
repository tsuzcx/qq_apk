package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdq
  extends com.tencent.mm.bx.a
{
  public bkf ZOs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258911);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOs != null)
      {
        paramVarArgs.qD(1, this.ZOs.computeSize());
        this.ZOs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258911);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOs == null) {
        break label284;
      }
    }
    label284:
    for (paramInt = i.a.a.a.qC(1, this.ZOs.computeSize()) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(258911);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258911);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bdq localbdq = (bdq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258911);
          return -1;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        int i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bkf localbkf = new bkf();
          if ((localObject != null) && (localObject.length > 0)) {
            localbkf.parseFrom((byte[])localObject);
          }
          localbdq.ZOs = localbkf;
          paramInt += 1;
        }
        AppMethodBeat.o(258911);
        return 0;
      }
      AppMethodBeat.o(258911);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdq
 * JD-Core Version:    0.7.0.1
 */