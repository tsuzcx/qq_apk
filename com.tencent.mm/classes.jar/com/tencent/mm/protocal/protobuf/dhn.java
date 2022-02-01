package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhn
  extends com.tencent.mm.bx.a
{
  public String session_id;
  public String wwH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104816);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wwH != null) {
        paramVarArgs.g(1, this.wwH);
      }
      if (this.session_id != null) {
        paramVarArgs.g(2, this.session_id);
      }
      AppMethodBeat.o(104816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wwH == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.wwH) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.session_id);
      }
      AppMethodBeat.o(104816);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104816);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dhn localdhn = (dhn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104816);
          return -1;
        case 1: 
          localdhn.wwH = locala.ajGk.readString();
          AppMethodBeat.o(104816);
          return 0;
        }
        localdhn.session_id = locala.ajGk.readString();
        AppMethodBeat.o(104816);
        return 0;
      }
      AppMethodBeat.o(104816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhn
 * JD-Core Version:    0.7.0.1
 */