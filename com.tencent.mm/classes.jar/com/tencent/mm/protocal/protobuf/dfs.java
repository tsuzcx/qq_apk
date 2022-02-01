package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfs
  extends com.tencent.mm.bx.a
{
  public String OzQ;
  public String aaLp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32334);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.OzQ != null) {
        paramVarArgs.g(1, this.OzQ);
      }
      if (this.aaLp != null) {
        paramVarArgs.g(2, this.aaLp);
      }
      AppMethodBeat.o(32334);
      return 0;
    }
    if (paramInt == 1) {
      if (this.OzQ == null) {
        break label278;
      }
    }
    label278:
    for (paramInt = i.a.a.b.b.a.h(1, this.OzQ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaLp != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaLp);
      }
      AppMethodBeat.o(32334);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32334);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dfs localdfs = (dfs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32334);
          return -1;
        case 1: 
          localdfs.OzQ = locala.ajGk.readString();
          AppMethodBeat.o(32334);
          return 0;
        }
        localdfs.aaLp = locala.ajGk.readString();
        AppMethodBeat.o(32334);
        return 0;
      }
      AppMethodBeat.o(32334);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfs
 * JD-Core Version:    0.7.0.1
 */