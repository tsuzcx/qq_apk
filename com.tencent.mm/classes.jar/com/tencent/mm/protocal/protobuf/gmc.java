package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gmc
  extends com.tencent.mm.bx.a
{
  public String aaJi;
  public String achr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123709);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achr != null) {
        paramVarArgs.g(1, this.achr);
      }
      if (this.aaJi != null) {
        paramVarArgs.g(2, this.aaJi);
      }
      AppMethodBeat.o(123709);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achr == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.achr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaJi != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaJi);
      }
      AppMethodBeat.o(123709);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123709);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gmc localgmc = (gmc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123709);
          return -1;
        case 1: 
          localgmc.achr = locala.ajGk.readString();
          AppMethodBeat.o(123709);
          return 0;
        }
        localgmc.aaJi = locala.ajGk.readString();
        AppMethodBeat.o(123709);
        return 0;
      }
      AppMethodBeat.o(123709);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmc
 * JD-Core Version:    0.7.0.1
 */