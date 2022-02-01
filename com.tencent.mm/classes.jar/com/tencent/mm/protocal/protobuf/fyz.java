package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fyz
  extends com.tencent.mm.bx.a
{
  public fyy abWu;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257528);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abWu != null)
      {
        paramVarArgs.qD(1, this.abWu.computeSize());
        this.abWu.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.status);
      AppMethodBeat.o(257528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abWu == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.abWu.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.status);
      AppMethodBeat.o(257528);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257528);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fyz localfyz = (fyz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257528);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fyy localfyy = new fyy();
            if ((localObject != null) && (localObject.length > 0)) {
              localfyy.parseFrom((byte[])localObject);
            }
            localfyz.abWu = localfyy;
            paramInt += 1;
          }
          AppMethodBeat.o(257528);
          return 0;
        }
        localfyz.status = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257528);
        return 0;
      }
      AppMethodBeat.o(257528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fyz
 * JD-Core Version:    0.7.0.1
 */