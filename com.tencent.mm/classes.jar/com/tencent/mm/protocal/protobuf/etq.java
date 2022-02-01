package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class etq
  extends com.tencent.mm.bx.a
{
  public String YIZ;
  public String abwW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257906);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIZ != null) {
        paramVarArgs.g(1, this.YIZ);
      }
      if (this.abwW != null) {
        paramVarArgs.g(2, this.abwW);
      }
      AppMethodBeat.o(257906);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YIZ == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.YIZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abwW != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abwW);
      }
      AppMethodBeat.o(257906);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257906);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        etq localetq = (etq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257906);
          return -1;
        case 1: 
          localetq.YIZ = locala.ajGk.readString();
          AppMethodBeat.o(257906);
          return 0;
        }
        localetq.abwW = locala.ajGk.readString();
        AppMethodBeat.o(257906);
        return 0;
      }
      AppMethodBeat.o(257906);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etq
 * JD-Core Version:    0.7.0.1
 */