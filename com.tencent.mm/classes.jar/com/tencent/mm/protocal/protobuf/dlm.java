package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dlm
  extends com.tencent.mm.bx.a
{
  public String DKe;
  public int DYT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DKe == null)
      {
        paramVarArgs = new b("Not all required fields were included: Ip");
        AppMethodBeat.o(125493);
        throw paramVarArgs;
      }
      if (this.DKe != null) {
        paramVarArgs.d(1, this.DKe);
      }
      paramVarArgs.aR(2, this.DYT);
      AppMethodBeat.o(125493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DKe == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.DKe) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.DYT);
      AppMethodBeat.o(125493);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DKe == null)
        {
          paramVarArgs = new b("Not all required fields were included: Ip");
          AppMethodBeat.o(125493);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125493);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dlm localdlm = (dlm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125493);
          return -1;
        case 1: 
          localdlm.DKe = locala.KhF.readString();
          AppMethodBeat.o(125493);
          return 0;
        }
        localdlm.DYT = locala.KhF.xS();
        AppMethodBeat.o(125493);
        return 0;
      }
      AppMethodBeat.o(125493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlm
 * JD-Core Version:    0.7.0.1
 */