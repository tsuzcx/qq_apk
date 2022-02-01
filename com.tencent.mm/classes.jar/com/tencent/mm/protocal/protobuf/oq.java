package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class oq
  extends com.tencent.mm.bx.a
{
  public String YRJ;
  public String YRQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124417);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRQ != null) {
        paramVarArgs.g(2, this.YRQ);
      }
      if (this.YRJ != null) {
        paramVarArgs.g(3, this.YRJ);
      }
      AppMethodBeat.o(124417);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRQ == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(2, this.YRQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YRJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YRJ);
      }
      AppMethodBeat.o(124417);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124417);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        oq localoq = (oq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124417);
          return -1;
        case 2: 
          localoq.YRQ = locala.ajGk.readString();
          AppMethodBeat.o(124417);
          return 0;
        }
        localoq.YRJ = locala.ajGk.readString();
        AppMethodBeat.o(124417);
        return 0;
      }
      AppMethodBeat.o(124417);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oq
 * JD-Core Version:    0.7.0.1
 */