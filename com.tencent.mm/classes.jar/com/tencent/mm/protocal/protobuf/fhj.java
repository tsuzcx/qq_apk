package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fhj
  extends com.tencent.mm.bx.a
{
  public String abHW;
  public String wtP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114081);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abHW != null) {
        paramVarArgs.g(1, this.abHW);
      }
      if (this.wtP != null) {
        paramVarArgs.g(2, this.wtP);
      }
      AppMethodBeat.o(114081);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abHW == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.abHW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wtP != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wtP);
      }
      AppMethodBeat.o(114081);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(114081);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fhj localfhj = (fhj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114081);
          return -1;
        case 1: 
          localfhj.abHW = locala.ajGk.readString();
          AppMethodBeat.o(114081);
          return 0;
        }
        localfhj.wtP = locala.ajGk.readString();
        AppMethodBeat.o(114081);
        return 0;
      }
      AppMethodBeat.o(114081);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhj
 * JD-Core Version:    0.7.0.1
 */