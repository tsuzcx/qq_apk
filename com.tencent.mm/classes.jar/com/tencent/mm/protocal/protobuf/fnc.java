package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class fnc
  extends com.tencent.mm.cd.a
{
  public fmz ULE;
  public b ULF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(186704);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ULE != null)
      {
        paramVarArgs.oE(1, this.ULE.computeSize());
        this.ULE.writeFields(paramVarArgs);
      }
      if (this.ULF != null) {
        paramVarArgs.c(2, this.ULF);
      }
      AppMethodBeat.o(186704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ULE == null) {
        break label348;
      }
    }
    label348:
    for (paramInt = g.a.a.a.oD(1, this.ULE.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ULF != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.ULF);
      }
      AppMethodBeat.o(186704);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(186704);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fnc localfnc = (fnc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(186704);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fmz localfmz = new fmz();
            if ((localObject != null) && (localObject.length > 0)) {
              localfmz.parseFrom((byte[])localObject);
            }
            localfnc.ULE = localfmz;
            paramInt += 1;
          }
          AppMethodBeat.o(186704);
          return 0;
        }
        localfnc.ULF = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(186704);
        return 0;
      }
      AppMethodBeat.o(186704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnc
 * JD-Core Version:    0.7.0.1
 */