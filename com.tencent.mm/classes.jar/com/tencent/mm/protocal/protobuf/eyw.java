package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eyw
  extends com.tencent.mm.bx.a
{
  public String abzW;
  public String hJW;
  public String zIC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122530);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.zIC != null) {
        paramVarArgs.g(1, this.zIC);
      }
      if (this.abzW != null) {
        paramVarArgs.g(2, this.abzW);
      }
      if (this.hJW != null) {
        paramVarArgs.g(3, this.hJW);
      }
      AppMethodBeat.o(122530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zIC == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.zIC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abzW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abzW);
      }
      i = paramInt;
      if (this.hJW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hJW);
      }
      AppMethodBeat.o(122530);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122530);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eyw localeyw = (eyw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122530);
          return -1;
        case 1: 
          localeyw.zIC = locala.ajGk.readString();
          AppMethodBeat.o(122530);
          return 0;
        case 2: 
          localeyw.abzW = locala.ajGk.readString();
          AppMethodBeat.o(122530);
          return 0;
        }
        localeyw.hJW = locala.ajGk.readString();
        AppMethodBeat.o(122530);
        return 0;
      }
      AppMethodBeat.o(122530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyw
 * JD-Core Version:    0.7.0.1
 */